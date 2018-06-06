package com.kumar.vikas.keyboardinapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    private Button hindi;
    private Button english;
    private LinearLayout hindiKeyBoard,englishKeyBoard;

    private EditText text;
    private EditText text1;
    private int i=0,state=0;
    private View child;
    RelativeLayout item;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(text.getWindowToken(), 0);
                inflate();

            }
        });
    }

    void inflate(){
        item = (RelativeLayout) findViewById(R.id.rel);
        child = getLayoutInflater().inflate(R.layout.keyboard, null);
        item.addView(child);
        hindi = child.findViewById(R.id.hindi);
        english = child.findViewById(R.id.english);
        hindiKeyBoard = child.findViewById(R.id.hindiKeyBoard);
        englishKeyBoard = child.findViewById(R.id.englishKeyBoard);
        text1 = child.findViewById(R.id.editText);
        text1.setActivated(true);
        text1.setPressed(true);
    }

    void text1(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(text.getWindowToken(), 0);

    }

    void hindi(View view){
        englishKeyBoard.setVisibility(View.INVISIBLE);
        hindiKeyBoard.setVisibility(View.VISIBLE);
    }

    void english(View view){
        englishKeyBoard.setVisibility(View.VISIBLE);
        hindiKeyBoard.setVisibility(View.INVISIBLE);
    }

    void onTapped(View view){
        Button button=(Button)view;
        if(!(button.getText().equals("Space")||button.getText().equals("del")||button.getText().equals("cap"))){
            if(i==0){
        text1.setText(text1.getText()+""+button.getText());
        text1.setSelection(text1.getText().length());}
        else {
                text1.setText(text1.getText()+""+button.getText().toString().toUpperCase());
                text1.setSelection(text1.getText().length());
            }
        }
        else if(button.getText().equals("Space")){
            text1.setText(text1.getText()+" ");
            text1.setSelection(text1.getText().length());
        }
        else if(button.getText().equals("del")){
            text1.setText(text1.getText().toString().substring(0,text1.getText().length()-1));
            text1.setSelection(text1.getText().length());
        }
        else if(button.getText().equals("cap")){
            if(i==0)
                i=1;
            else
                i=0;
        }

    }
}
