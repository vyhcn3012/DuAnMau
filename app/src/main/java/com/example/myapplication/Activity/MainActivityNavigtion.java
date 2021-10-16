package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivityNavigtion extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    ViewPager2 vp2;
    TextView tvb3;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigtion);
        setUpToolbar();
        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case  R.id.nav_home:
                        Intent intent = new Intent(MainActivityNavigtion.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case  R.id.nav_theloai:
                        intent = new Intent(MainActivityNavigtion.this, ListTheLoaiActivity.class);
                        startActivity(intent);
                        break;
                    case  R.id.nav_sach:
                        intent = new Intent(MainActivityNavigtion.this, ListSachActivity.class);
                        startActivity(intent);
                        break;
                    case  R.id.nav_hoadon:
                        intent = new Intent(MainActivityNavigtion.this, ListHoaDonActivity.class);
                        startActivity(intent);
                        break;
                    case  R.id.nav_top:
                        intent = new Intent(MainActivityNavigtion.this, ListBanChayActivity.class);
                        startActivity(intent);
                        break;
                    case  R.id.nav_thongke:
                        intent = new Intent(MainActivityNavigtion.this, ListThongKeActivity.class);
                        startActivity(intent);
                        break;

                }
                return false;
            }
        });

        vp2 = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);

        FragmentManager fManager = getSupportFragmentManager();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        vp2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }
}