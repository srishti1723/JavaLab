package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View wallView = findViewById(R.id.wallpaper);
        Button wallButton = findViewById(R.id.buttonWall);
        int [] images;
        Timer timer = new Timer();
        images = new int[]{R.drawable.photo,R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,
                            R.drawable.photo4,R.drawable.photo5, R.drawable.photo6, R.drawable.photo7};
        wallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        Random random = new Random();
                        int imageLen = images.length;
                        int randNum = random.nextInt(imageLen);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                wallView.setBackground(ContextCompat.getDrawable(getApplicationContext(),images[randNum]));
                            }
                        });
                    }
                },0,3000);
            }
        });
    }
}