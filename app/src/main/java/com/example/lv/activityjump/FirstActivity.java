package com.example.lv.activityjump;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    //题目要求：编写一个程序实现带参数以及返回值的Activity跳转
    //两个Activity，分别为FirstActivity和SecondActivity，程序默认打开FirstActivity
    //带参数以及返回值的体现方式：log中打印
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //按钮点击事件，向SecondActivity中传递参数
        Button firstButton = (Button) findViewById(R.id.button_first);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Text", "B16070612：SecondActivity opened!");//传递参数的内容
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
    }
        //重写该方法实现SecondActivity销毁后返回值的提取及log打印
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            switch (requestCode) {
                case 1:
                    if (resultCode == RESULT_OK) {
                        Bundle b = data.getExtras();
                        String returnedData = b.getString("returnText");
                        Log.d("FirstActivity", returnedData);
                    }
                    break;
                default:
                    break;
            }
        }

}
