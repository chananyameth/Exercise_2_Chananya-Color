package com.example.gidi7.colorchananya;

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

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView textView;
    Button next;
    LinearLayout view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		input = (EditText)findViewById(R.id.Input);
		next = (Button)findViewById(R.id.Next);
        textView = (TextView)findViewById(R.id.mainTextView);
        view = (LinearLayout)findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
		next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("input", input.getText().toString());
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            try {
                textView.setTextColor(Color.parseColor(data.getStringExtra("returned_color").toUpperCase()));
                textView.setText(data.getStringExtra("returned_color").toUpperCase());
            }catch(Exception e){
                textView.setTextColor(Color.RED);
                textView.setText("Your input isn't an exist color!");
            }
        }
        /*else if(resultCode == RESULT_CANCELED) {
            textView.setTextColor(Color.RED);
            textView.setText("No results!");
        }*/
        /*switch (data.getStringExtra("returned_color").toUpperCase()){

            case "BLACK":
                textView.setTextColor(Color.BLACK);
                break;
            case "BLUE":
                textView.setTextColor(Color.BLUE);
                break;
            case "CYAN":
                textView.setTextColor(Color.CYAN);
                break;
            case "DKGRAY":
                textView.setTextColor(Color.DKGRAY);
                break;
            case "GRAY":
                textView.setTextColor(Color.GRAY);
                break;
            case "green":
                textView.setTextColor(Color.GREEN);
                break;
            case "LTGRAY":
                textView.setTextColor(Color.LTGRAY);
                break;
            case "MAGENTA":
                textView.setTextColor(Color.MAGENTA);
                break;
            case "RED":
                textView.setTextColor(Color.RED);
                break;
            case "WHITE":
                textView.setTextColor(Color.WHITE);
                break;
            case "YELLOW":
                textView.setTextColor(Color.YELLOW);
                break;
            default:
                textView.setTextColor(Color.GREEN);
                break;
        }*/
    }
}
