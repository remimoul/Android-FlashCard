package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        Intent srcintent = getIntent();
        String nameGroup = srcintent.getStringExtra("nameGroup");
        String appName = srcintent.getStringExtra("appName");
        String version = srcintent.getStringExtra("version");


        TextView nameAppTextView = findViewById(R.id.appName);
        nameAppTextView.setText(appName);

        TextView versionTextView = findViewById(R.id.appVersion);
        versionTextView.setText(version);

        TextView nameGroupTextView = findViewById(R.id.nameGroup);
        nameGroupTextView.setText(nameGroup);
    }
}