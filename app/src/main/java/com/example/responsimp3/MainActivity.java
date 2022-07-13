package com.example.responsimp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Switch;

import com.example.responsimp3.View.HistoryFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomnav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomnav = findViewById(R.id.bottomnav);
      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        bottomnav.setOnItemSelectedListener(item -> {
            //untuk pilih kondisi fragment
            Fragment fragment = null;
            switch (item.getItemId()){
                case R.id.Home:
                    fragment = new HomeFragment();
                    break;
                case R.id.History:
                    fragment = new HistoryFragment();
                    break;
                case R.id.Payment:
                    fragment = new PaymentFragment();
                    break;
                case R.id.Setting:
                    fragment = new SettingFragment();
            }
            assert fragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                    return true;
        });
    }


}