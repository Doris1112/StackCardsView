package com.doris.stackcardsview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Doris
 * @date 2019/1/7
 **/
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void testViewOnClick1(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void testViewOnClick2(View view){
        startActivity(new Intent(this, Main2Activity.class));
    }
}
