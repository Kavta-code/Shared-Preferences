package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editMessage;
    Button buttonsave,buttondisplay;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMessage = findViewById(R.id.editText_message);
        buttonsave =findViewById(R.id.button_save);
        buttondisplay = findViewById(R.id.button_display);
        textView = findViewById(R.id.textView2);


        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userMessage", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("message", editMessage.getText().toString().trim());
            editor.apply();
                Toast.makeText(MainActivity.this, "saved successfully", Toast.LENGTH_SHORT).show();

            }
        });

        buttondisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userMessage", Context.MODE_PRIVATE);
                String message = sharedPreferences.getString("message","");//key from editor
                textView.setText("Message:" +message);

            }
        });


    }
}
