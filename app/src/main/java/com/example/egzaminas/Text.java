package com.example.egzaminas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;


import android.content.Intent;
import android.net.Uri;



public class Text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        View backButton = findViewById(R.id.back_button);
        View linkText = findViewById(R.id.link);
        // Nustatome mygtuko paspaudimo veiksmą
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Įvykdoma veiksmas paspaudus mygtuką
                onBackPressed();
            }
        });

        linkText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sukuriame intentą, skirtą atidaryti naršyklę su nuoroda
                Uri webpage = Uri.parse("https://www.kolegija.lt");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                // Atidarome naršyklę su nurodyta nuoroda
                startActivity(intent);
            }
        });
    }
}