package com.congtsang.FirstApp;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class FirstAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstAct.this, "U clicked Button 1",
                        Toast.LENGTH_SHORT).show();
//                显式intent
//                Intent intent = new Intent(FirstAct.this, SecondAct.class);
//                startActivity(intent);
//                隐式intent
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://congtsang.com"));
                startActivity(intent1);
            }
        });

//        Log.d("FirstActivity", this.toString());
        Log.d("FirstActivity", "Task id is " + getTaskId());
        Button button2 = (Button) findViewById(R.id.button_4);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstAct.this, FirstAct.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add_item:
                Toast.makeText(this, "U clicked Add",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.rm_item:
                Toast.makeText(this, "U clicked Remove",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.ToSecondAct:
                Toast.makeText(this, "U clicked ToSecondAct",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent("com.congtsang.FirstApp.SecondAct_START");

                String data = "Hallo, CongTsang!";
                intent.putExtra("extra_data", data);

                startActivity(intent);
//                finish();
                break;
                default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity", "onRestart");
    }
}
