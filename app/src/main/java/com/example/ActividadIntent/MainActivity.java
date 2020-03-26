package com.example.ActividadIntent;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Dictionary;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    public static final String EXTRA_MESSAGE = "com.example.android.ActividadIntent.extra.MESSAGE";
    public static Bundle peticion = new Bundle();
    EditText editText;
    TextView messageRec,headerMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, secondActivity.class);
        editText = findViewById(R.id.editText_main);
        headerMain = findViewById(R.id.headerMain);
        messageRec = findViewById(R.id.messageReceived);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(peticion != null) {
            messageRec.setVisibility(View.VISIBLE);
            headerMain.setVisibility(View.VISIBLE);
            messageRec.setText(peticion.getString("reply"));
        }
    }

    public void launchSecondActivity(View view) {
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


}
