package com.example.egzaminas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;

import android.widget.ImageView;
import java.util.Random;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText fahrenheitEditText;
    EditText celsiusEditText;
    int[] imageArray = {R.drawable._1, R.drawable._2, R.drawable._3};

    Random random = new Random();
    int randomIndex = random.nextInt(imageArray.length);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View textButton = findViewById(R.id.text_button);
        View backButton = findViewById(R.id.back_button);
        ImageView imageView = findViewById(R.id.imageView);

        fahrenheitEditText = findViewById(R.id.Fahrenheit);
        celsiusEditText = findViewById(R.id.Celsius);

        imageView.setImageResource(imageArray[randomIndex]);
        // Nustatome mygtuko paspaudimo veiksmą
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sukuriame intentą, skirtą perkelti į Text klasę
                Intent intent = new Intent(MainActivity.this, Text.class);

                // Paleidžiame naują veiklą
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Įvykdoma veiksmas paspaudus mygtuką
                onBackPressed();
            }
        });


        findViewById(R.id.countbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });

        findViewById(R.id.deletebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearEditText();
            }
        });
    }

    private void convertTemperature() {
        if (!fahrenheitEditText.getText().toString().isEmpty()) {
            double fahrenheit = Double.parseDouble(fahrenheitEditText.getText().toString());
            double celsius = (fahrenheit - 32) * 5 / 9;
            celsiusEditText.setText(String.valueOf(celsius));
        } else if (!celsiusEditText.getText().toString().isEmpty()) {
            double celsius = Double.parseDouble(celsiusEditText.getText().toString());
            double fahrenheit = celsius * 9 / 5 + 32;
            fahrenheitEditText.setText(String.valueOf(fahrenheit));
        }
    }

    private void clearEditText() {
        fahrenheitEditText.getText().clear();
        celsiusEditText.getText().clear();
    }


}