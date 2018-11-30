package jp.techacademy.saito.maiko.kadai04_calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.support.design.widget.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // メンバ変数を定義
    EditText mEditText1;
    EditText mEditText2;
    double num1;
    double num2;
    double num_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        // fingViewByIdを使ってインスタンスを代入
        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {

        // 入力値チェック
        if (mEditText1.getText().toString().isEmpty()) {
            Log.d("UI_PARTS", "入力値１なし");
            Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_SHORT).show();
            return;
        } else if (mEditText2.getText().toString().isEmpty()) {
            Log.d("UI_PARTS", "入力値２なし");
            Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_SHORT).show();
            return;
        }

        // EditTextの文字列をTextViewに設定
        num1 = Double.parseDouble(mEditText1.getText().toString());
        num2 = Double.parseDouble(mEditText2.getText().toString());
        Log.d("UI_PARTS", "num1: " + num1);
        Log.d("UI_PARTS", "num2: " + num2);


        if (v.getId() == R.id.button1) {
            Log.d("UI_PARTS", "CALC: +");
            num_result = num1 + num2;
        } else if (v.getId() == R.id.button2) {
            Log.d("UI_PARTS", "CALC: -");
            num_result = num1 - num2;
        } else if (v.getId() == R.id.button3) {
            Log.d("UI_PARTS", "CALC: *");
            num_result = num1 * num2;
        } else if (v.getId() == R.id.button4) {
            Log.d("UI_PARTS", "CALC: /");
            num_result = num1 / num2;
        }
        Log.d("UI_PARTS", "num_result: " + num_result);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("RESULT", num_result);
        startActivity(intent);

    }
}
