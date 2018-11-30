package jp.techacademy.saito.maiko.kadai04_calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double result = intent.getDoubleExtra("RESULT",0);
        Log.d("UI_PARTS2", "result: " + result);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf("計算結果：  " + result));
    }
}
