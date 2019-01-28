package com.example.royta.edittextvalidationtextwatcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    EditText editText;
    TextWatcher textWatcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.text_field);

        editText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(this, "beforeTextChanged", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(this, "onTextChanged", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterTextChanged(Editable s) {
        Toast.makeText(this, "afterTextChanged", Toast.LENGTH_SHORT).show();

        int num = 0;
        try {
            num = Integer.parseInt(s.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (num > 100) {
            s.replace(0, s.length(), "100");
        }

    }
}
