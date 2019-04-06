package com.example.selfchat;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText inputText;
    private TextView msg;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = (TextInputEditText) findViewById(R.id.inputText);
        msg = (TextView) findViewById(R.id.msgView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg.setText(inputText.getText());
                inputText.getText().clear();
            }
        });
    }
    protected void onSaveInstanceState(Bundle outState){

        super.onSaveInstanceState(outState);
        outState.putString("inp_txt", inputText.getText().toString());
        outState.putString("out_txt", msg.getText().toString());

    }
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        inputText.setText(savedInstanceState.getString("my_txt"));
        msg.setText(savedInstanceState.getString("out_txt"));
    }
}
