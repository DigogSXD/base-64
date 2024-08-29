package com.example.myapplication;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        resultText = findViewById(R.id.resultText);
        Button encodeButton = findViewById(R.id.encodeButton);
        Button decodeButton = findViewById(R.id.decodeButton);

        encodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToEncode = inputText.getText().toString();
                String encodedText = Base64.encodeToString(textToEncode.getBytes(), Base64.DEFAULT);
                resultText.setText(encodedText);
            }
        });

        decodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToDecode = inputText.getText().toString();
                byte[] decodedBytes = Base64.decode(textToDecode, Base64.DEFAULT);
                String decodedText = new String(decodedBytes);
                resultText.setText(decodedText);
            }
        });
    }
}
