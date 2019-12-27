package com.example.myapplication.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Model.User;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText mNameInput;
    private Button playButton;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        mNameInput = (EditText) findViewById(R.id.name);
        playButton = (Button) findViewById(R.id.play);
        user = new User();

        playButton.setEnabled(false);

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                playButton.setEnabled(charSequence.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = mNameInput.getText().toString();
                user.setFirstName(firstName);
                Intent gameActivityIntent = new Intent(MainActivity.this, gameActivity.class);
                startActivity(gameActivityIntent);
            }
        });
    }
}
