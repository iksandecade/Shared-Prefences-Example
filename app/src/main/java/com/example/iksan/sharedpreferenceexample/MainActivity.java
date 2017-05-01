package com.example.iksan.sharedpreferenceexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText etUsername;
    private Spinner spType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        etUsername = (EditText) findViewById(R.id.etUsername);
        spType = (Spinner) findViewById(R.id.spType);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.typeItem, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spType.setAdapter(adapter);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String asWho = spType.getSelectedItem().toString();
                SPSharedPreferences.setUsername(MainActivity.this, username); //untuk menyimpan username ke sharedpreferences
                SPSharedPreferences.setAsWho(MainActivity.this, asWho); // untuk menyimpan tipe ke sharedpreferences
                startActivity(new Intent(MainActivity.this, ShowActivity.class));
            }
        });
    }
}
