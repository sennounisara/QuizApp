package com.example.myapplication.Controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

    public static final String PREF_KEY_USERNAME = "PREF_KEY_USERNAME";
    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";

    private SharedPreferences sharedPreferences;

    // ----- Identify for the gameActivity ----- //
    public static final int Id_Game_Activity = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        mNameInput = (EditText) findViewById(R.id.name);
        playButton = (Button) findViewById(R.id.play);

        user = new User();

        sharedPreferences =  getPreferences(MODE_PRIVATE);

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

                sharedPreferences.edit().putString(PREF_KEY_USERNAME,user.getFirstName()).apply();

                Intent gameActivityIntent = new Intent(MainActivity.this, gameActivity.class);
                //startActivity(gameActivityIntent);
                startActivityForResult(gameActivityIntent,Id_Game_Activity);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == Id_Game_Activity && RESULT_OK == resultCode) {
            int score = data.getIntExtra(gameActivity.valeur_score,0);
            sharedPreferences.edit().putInt(PREF_KEY_SCORE,score).apply();

            String userNameP =sharedPreferences.getString(PREF_KEY_USERNAME, null);

            if(PREF_KEY_USERNAME != null){
                int scoreF =sharedPreferences.getInt(PREF_KEY_SCORE, 0);
                textView.setText("Soiyer le bienvenu " +userNameP+" votre score  est :"+scoreF);
            }
        }
    }
}
