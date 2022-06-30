package com.example.OnlineStore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.OnlineStore.ui.category.CategoryFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_category);

    }

//
//    public void start(View view) {
//        Intent intent = new Intent(MainActivity.this, CategoryFragment.class);
//        startActivity(intent);
//        finish();
//    }
}