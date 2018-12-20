package com.example.lv.activityjump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Bundle接收FirstActivity传递的参数
        Bundle bundle = this.getIntent().getExtras();
        String text = bundle.getString("Text");
        Log.d("SecondActivity", text);
        //SecondActivity中的按钮：销毁该活动并设置返回值
        Button secondButton = findViewById(R.id.button_second);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundleReturn = new Bundle();
                bundleReturn.putString("returnText", "B16070612：FirstActivity returned");
                intent.putExtras(bundleReturn);
                intent.setClass(SecondActivity.this, FirstActivity.class);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
