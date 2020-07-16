package com.shokoofeadeli.hangmangame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  public String            currentWord;
  public int               nWrong;

  private TextView txt_Dashes;
  public ArrayList<Button> buttons = new ArrayList<Button>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    txt_Dashes = (TextView)findViewById(R.id.txt_Dashes);
    resetGame();
  }

  public void resetGame() {
    String[]          words   = new String[]{
      "Honesty",
      "Goodness",
      "Faithful",
      "Love",
      "Loyal",
      "Dutiful",
      "kind",
      "Noble",
      "Humanity",
      "Peace"
    };
    int randomNumber = (int) (Math.random()* words.length);
    currentWord = words[randomNumber].toUpperCase();
    String dashes = "";
    for (int i = 0; i < currentWord.length(); i++) {
      if (currentWord.charAt(i) != ' ') {
        dashes += "-";
      } else {
        dashes += " ";
      }
    }
    for (Button button: buttons) {
      button.setVisibility(View.VISIBLE);
    }
    buttons.clear();
    txt_Dashes.setText(dashes);
    nWrong = 0;
  }
  public void letterOnClickListener(View view) {
    Button button = (Button) view;
    buttons.add(button);
    char letter = button.getText().toString().toCharArray()[0];
    button.setVisibility(View.INVISIBLE);
    if (currentWord.contains("" + letter)) {
      char[] charDashes = txt_Dashes.getText().toString().toCharArray();
      char[] charArray = currentWord.toCharArray();
      for (int i = 0; i < charArray.length; i++) {
        if (charArray[i] == letter) {
          charDashes[i] = letter;
        }
      }
      String word = new String(charDashes);
      txt_Dashes.setText(word);
      if (!word.contains("-")) {
        showResultActivity("WIN");
      }
    }
    else {
      if (nWrong == currentWord.length()) {
        showResultActivity("LOSE");
      }
      nWrong++;
    }
  }
  private void  showResultActivity(String result){
    Intent intent = new Intent(this,ResultGameActivity.class);
    intent.putExtra("RESULT",result);
    startActivity(intent);
    finish();
  }
}
