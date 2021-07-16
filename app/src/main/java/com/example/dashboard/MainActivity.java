package com.example.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView EducationTextView,SkillsTextView,PersonalTextView,text_view_progress,VerificationTextView;
    int progress = 0;
    int EducationClickCount=0,SkillClickCount=0,PersonalClickCount=0,VerificationClickCount=0;
    TextView ProgressEducationNotComplete,ProgressSkillNotComplete,ProgressPersonalNotComplete,ProgressVerificationNotComplete;
    TextView ProgressEducationComplete,ProgressSkillComplete,ProgressPersonalComplete,ProgressVerificationComplete;
    ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Toolbar toolbar = findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        //hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        EducationTextView = findViewById(R.id.textView3);
        SkillsTextView = findViewById(R.id.textView4);
        PersonalTextView=findViewById(R.id.textView5);
        progress_bar = findViewById(R.id.progress_bar);
        VerificationTextView = findViewById(R.id.textView6);
        text_view_progress=findViewById(R.id.text_view_progress);
        ProgressEducationNotComplete = findViewById(R.id.textView7);
        ProgressSkillNotComplete = findViewById(R.id.textView8);
        ProgressPersonalNotComplete = findViewById(R.id.textView9);
        ProgressVerificationNotComplete = findViewById(R.id.textView10);
        ProgressEducationComplete = findViewById(R.id.textView11);
        ProgressSkillComplete = findViewById(R.id.textView12);
        ProgressPersonalComplete = findViewById(R.id.textView13);
        ProgressVerificationComplete = findViewById(R.id.textView14);
        //toolbar
        setSupportActionBar(toolbar);

        //hide or show

        Menu menu = navigationView.getMenu();


        //navigation drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);
        updateProgressBar();

        EducationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progress<=75 && EducationClickCount==0){
                    progress = progress+25;
                    EducationClickCount++;
                    Toast.makeText(MainActivity.this, "Educational Details Updated", Toast.LENGTH_SHORT).show();
                    ProgressEducationNotComplete.setVisibility(v.INVISIBLE);
                    ProgressEducationComplete.setVisibility(v.VISIBLE);
                    updateProgressBar();
                }else {
                    Toast.makeText(MainActivity.this, "Education Details Already Updated", Toast.LENGTH_SHORT).show();
                }

            }
        });
        SkillsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progress<=75 && SkillClickCount==0){
                    progress = progress+25;
                    SkillClickCount++;
                    Toast.makeText(MainActivity.this, "Skill Details Updated", Toast.LENGTH_SHORT).show();
                    ProgressSkillNotComplete.setVisibility(v.INVISIBLE);
                    ProgressSkillComplete.setVisibility(v.VISIBLE);
                    updateProgressBar();
                }
                else {
                    Toast.makeText(MainActivity.this, "Skill Details Already Updated", Toast.LENGTH_SHORT).show();
                }

            }
        });
        PersonalTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progress<=75 && PersonalClickCount==0){
                    progress = progress+25;
                    PersonalClickCount++;
                    Toast.makeText(MainActivity.this, "Personal Details Updated", Toast.LENGTH_SHORT).show();
                    ProgressPersonalNotComplete.setVisibility(v.INVISIBLE);
                    ProgressPersonalComplete.setVisibility(v.VISIBLE);
                    updateProgressBar();
                }
                else {
                    Toast.makeText(MainActivity.this, "Personal Details Already Updated", Toast.LENGTH_SHORT).show();
                }

            }
        });

        VerificationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progress<=75 && VerificationClickCount==0){
                    progress = progress+25;
                    VerificationClickCount++;
                    Toast.makeText(MainActivity.this, "Verification Completed", Toast.LENGTH_SHORT).show();
                    ProgressVerificationNotComplete.setVisibility(v.INVISIBLE);
                    ProgressVerificationComplete.setVisibility(v.VISIBLE);
                    updateProgressBar();
                }
                else {
                    Toast.makeText(MainActivity.this, "Verification Already Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void updateProgressBar(){
        progress_bar.setProgress(progress);
        text_view_progress.setText(String.valueOf(progress)+"%");

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_wallet:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}