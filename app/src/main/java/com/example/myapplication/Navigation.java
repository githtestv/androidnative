package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;

import com.example.myapplication.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityNavigationBinding;

public class Navigation extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

//        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        //setSupportActionBar(binding.appBarNavigation.toolbar);
//        binding.appBarNavigation.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//
//        Button button = (Button) findViewById(R.id.start);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                setContentView(R.layout.fragment_home);
//            }
//        });
////        DrawerLayout drawer = binding.drawerLayout;
////        NavigationView navigationView = binding.navView;
////        // Passing each menu ID as a set of Ids because each
////        // menu should be considered as top level destinations.
////        mAppBarConfiguration = new AppBarConfiguration.Builder(
////               )
////                .setOpenableLayout(drawer)
////                .build();
//////        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
//////        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//////        NavigationUI.setupWithNavController(navigationView, navController);
////    }
////
////    private static NavController findNavController(Navigation navigation, int nav_host_fragment_content_navigation) {
////        return null;
////    }
////
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        // Inflate the menu; this adds items to the action bar if it is present.
//////        getMenuInflater().inflate(R.menu.navigation, menu);
//////        return true;
////    }
////
////    @Override
////    public boolean onSupportNavigateUp() {
////        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
////        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
////                || super.onSupportNavigateUp();
//    }
//
////    public void Start(){
////        Intent intent = new Intent(Navigation.this, HomeFragment.class);
////        startActivity(intent);
////        finish();
////    }

    }
}