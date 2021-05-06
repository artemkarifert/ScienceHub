package com.tsg.test;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.jetbrains.annotations.NotNull;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      AnimatedBottomBar navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        final NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        navView.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NotNull AnimatedBottomBar.Tab tab1) {
                if (i1 == 0)
                    navController.navigate(R.id.navigation_dashboard);
                if (i1 == 1)
                    navController.navigate(R.id.navigation_home);
                if (i1 == 2)
                    navController.navigate(R.id.navigation_notifications);
            }

            @Override
            public void onTabReselected(int i, @NotNull AnimatedBottomBar.Tab tab) {

            }
        });

        /*ScrollView sView = (ScrollView)findViewById(R.id.ScrollView);
        sView.setVerticalScrollBarEnabled(false);*/


        /*Typeface CF = Typeface.createFromAsset(getAssets(), "fonts/poppins_bold.ttf");
        TextView textView = findViewById(R.id.textView);
        textView.setTypeface(CF);*/ //Не понимаю как сделать шрифт, при этом способе крашит

    }

}