package com.example.gidi7.colorchananya;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    TextView colorsView;
    EditText editText;
    Button back;
    Button cancel;
    Intent intent;
    LinearLayout view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView)findViewById(R.id.textView);
        colorsView = (TextView)findViewById(R.id.colorsList);
        editText = (EditText)findViewById(R.id.editText);
        back = (Button)findViewById(R.id.back);
        cancel = (Button)findViewById(R.id.cancel);
        textView.setText(getIntent().getStringExtra("input"));
        intent = getIntent();
        view = (LinearLayout)findViewById(R.id.secondView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("returned_color", editText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
        colorsView.setText(" Yellow \n White \n Red \n Magenta \n LightGray \n Gray \n DarkGray \n Green \n Black \n Blue \n Cyan");
    }
}
