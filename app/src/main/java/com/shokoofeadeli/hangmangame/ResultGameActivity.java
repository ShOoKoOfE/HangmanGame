package com.shokoofeadeli.hangmangame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultGameActivity extends AppCompatActivity {

  private TextView txt_result;
  private Button btn_exit;
  private Button btn_play;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result_game);
    txt_result = (TextView) findViewById(R.id.txt_result);
    btn_exit = (Button) findViewById(R.id.btn_exit);
    btn_play = (Button) findViewById(R.id.btn_play);

    Intent intent = getIntent();
    String result = intent.getStringExtra("RESULT");
    switch (result){
      case "WIN":
        txt_result.setText("You Winner!!!");
        break;
      case "LOSE":
        txt_result.setText("Game Over!!!");
        break;
    }
    btn_exit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        finish();
      }
    });

    btn_play.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(ResultGameActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
      }
    });
  }
}
