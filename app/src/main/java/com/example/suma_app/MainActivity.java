package com.example.suma_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.tvResult);

        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();

                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            fun(50,30);
                        }
                    });
                }

            }
        };

        t.start();

    }

    void fun(int x , int y ){
        String p = String.valueOf(x+y);
        Log.d("Sum" , p);
        result.setText(p);
    }

}
