package com.zhouwenguang.hz.myexcelapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button btnOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        btnOpen= (Button) findViewById(R.id.btnOpen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        WriteExcelUtils.writeExecleToFile(MainActivity.this);
                    }
                }).start();
            }
        });


        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MyUtils.FILE_PATH!=null){
                    try {
                        MyUtils.openAssignFolder(MainActivity.this,MyUtils.FILE_PATH);
                    } catch (Exception e) {
                        Toast toast = Toast.makeText(MainActivity.this, "没有找到打开该文件的应用程序", Toast.LENGTH_SHORT);
                        toast.show();
                        e.printStackTrace();
                    }
                }

            }
        });
    }
}
