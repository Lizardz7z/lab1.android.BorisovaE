package com.example.lab1_borisovaelizaveta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ColorEnter;
    private Button Button_Enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorEnter = findViewById(R.id.text_color_enter);
        Button_Enter = findViewById(R.id.button_1);
        Button_Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color = ColorEnter.getText().toString();
                if (color.equalsIgnoreCase("red")){
                    toColorActivity(view, "red");
                }
                else if (color.equalsIgnoreCase("green")){
                    toColorActivity(view, "green");
                }
                else if (color.equalsIgnoreCase("blue")){
                    toColorActivity(view, "blue");
                }
                else{
                    ErrorMSG("Please enter one of valid case: red, green, blue");
                }
            }
        });
    }
    private void ErrorMSG(String text){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Error value was entered");
        builder.setMessage(text);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertdialog = builder.create();
        alertdialog.show();
    }

    public void toColorActivity(View view, String color){
        Intent intent = new Intent(MainActivity.this, ColorActivity.class);
        intent.putExtra("color", color);
        startActivity(intent);
    }
}