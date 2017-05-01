package com.example.iksan.sharedpreferenceexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {

    private TextView tvDetail;
    private LinearLayout linRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_activty);

        tvDetail = (TextView) findViewById(R.id.tvDetail);
        linRoot = (LinearLayout) findViewById(R.id.linRoot);

        String asWho = SPSharedPreferences.getAsWho(this); //untuk ngambil tipe si user
        String username = SPSharedPreferences.getUsername(this); //untuk ngambil username si user


        //ini fungsi buat nge filter apa si tipenya
        if ((asWho != null && username != null)) {
            if (!asWho.equals("") && !username.equals("")) {
                switch (asWho) {
                    case "Admin":
                        //disini masukin fungsi admin
                        linRoot.setBackgroundColor(Color.parseColor("#ffffff"));
                        tvDetail.setTextColor(Color.parseColor("#000000"));
                        break;
                    case "User":
                        //disini masukin fungsi user
                        linRoot.setBackgroundColor(Color.parseColor("#000000"));
                        tvDetail.setTextColor(Color.parseColor("#ffffff"));
                        break;
                    case "Reseller":
                        //disini masukin fungsi reseller
                        linRoot.setBackgroundColor(Color.parseColor("#ffffff"));
                        tvDetail.setTextColor(Color.parseColor("#333333"));
                        break;

                    default:
                        accessDenied();
                        break;
                }
                tvDetail.setText(username + " login as " + asWho);
            } else {
                accessDenied();
            }
        } else {
            accessDenied();
        }
    }

    private void accessDenied() {
        finish();
        Toast.makeText(this, "Access Denied", Toast.LENGTH_SHORT).show();
    }
}

