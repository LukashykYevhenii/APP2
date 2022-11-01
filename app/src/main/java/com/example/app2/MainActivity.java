package com.example.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

  TextView tvInfo;
  EditText etInput;
  Button bControl;

  int guess;
  boolean gameFinish;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tvInfo = findViewById(R.id.textView);
    etInput = findViewById(R.id.editTextNumberDecimal);
    bControl = findViewById(R.id.button);
    guess = new Random().nextInt(10);
    gameFinish = false;
  }

  public void onClick(View view) {
    int inputData = 0;
    try {
      inputData = Integer.parseInt(etInput.getText().toString());
    } catch (NumberFormatException e) {
      tvInfo.setText(getResources().getString(R.string.error));
    }

    if (inputData > 0 && inputData <= 10) {

      if (!gameFinish) {
        bControl.setText(getResources().getString(R.string.input_value));
        if (inputData < guess) {
          tvInfo.setText(getResources().getString(R.string.behind));
        }
        if (inputData > guess) {
          tvInfo.setText(getResources().getString(R.string.ahead));
        }
        if (inputData == guess) {
          tvInfo.setText(getResources().getString(R.string.hit));
          bControl.setText(getResources().getString(R.string.play_more));
          gameFinish = true;
        }
      } else {
        guess = new Random().nextInt(10);
        bControl.setText(getResources().getString(R.string.input_value));
        tvInfo.setText(getResources().getString(R.string.try_to_guess));
        gameFinish = false;
      }
    } else {
      if (inputData > 10) {
        tvInfo.setText(getResources().getString(R.string.ahead_ten));
      } else {
        tvInfo.setText(getResources().getString(R.string.error));
      }
    }
    etInput.setText("");
  }
  public void onOutClick(View view) {
    this.finish();
  }
}
