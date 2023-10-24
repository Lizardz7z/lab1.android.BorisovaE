package com.example.lab1_borisovaelizaveta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ColorActivity extends AppCompatActivity {

    private Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        back_button = findViewById(R.id.button_2);
        Bundle args = getIntent().getExtras();
        if (args != null){
            String color = args.get("color").toString();
            LinearLayout back_color = findViewById(R.id.color_view);
            if (color.equals("red")){
                back_color.setBackgroundColor(Color.rgb(255, 0, 0));
            }
            else if (color.equals("green")){
                back_color.setBackgroundColor(Color.rgb(0, 255, 0));
            }
            else if (color.equals("blue")){
                back_color.setBackgroundColor(Color.rgb(0, 0, 255));
            }
        }
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toMainActivity(view);
            }
        });
    }

    public void toMainActivity(View view) {
        Intent intent = new Intent(ColorActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

