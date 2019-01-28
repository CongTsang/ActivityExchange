package com.congtsang.FirstApp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Intent intent1 = getIntent();
        String data = intent1.getStringExtra("extra_data");
        Log.d("SecondAct", data);

//        Log.d("SecondActivity", this.toString());
        Log.d("SecondActivity", "Task id is " + getTaskId());
        Button button1 = (Button) findViewById(R.id.button_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondAct.this, "U clicked Button 2",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SecondAct.this, ThirdAct.class);
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button_5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondAct.this, "U clicked Button 5",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SecondAct.this, ThirdAct.class);
                startActivityForResult(intent,1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("SecondAct", returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy");
    }
}
