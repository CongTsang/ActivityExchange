package com.congtsang.FirstApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdAct extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        Log.d("ThirdActivity", "Task id is " + getTaskId());
        Button button = (Button) findViewById(R.id.button_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdAct.this, "U clicked Button 3",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ThirdAct.this, FirstAct.class);
                startActivity(intent);
                finish();
            }
        });

        Button button1 = findViewById(R.id.button_6);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello, CongTsang! Nice to SecondAct.");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello, CongTsang! Nice to SecondAct.");
        setResult(RESULT_OK, intent);
        finish();
    }
}
