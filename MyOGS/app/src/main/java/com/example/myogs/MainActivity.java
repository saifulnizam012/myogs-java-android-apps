package com.example.myogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    TextView mFullName, mEmail;
    FirebaseAuth mAuth;
    FirebaseFirestore mStore;
    String muserID;

    TextView nameNavBar, descNavBar;
    ImageView picNavBar;
    FirebaseUser mUser;
    StorageReference mStorageReference;

    private DatabaseReference mUserRef;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStorageReference = FirebaseStorage.getInstance().getReference();

        //  navigation drawer
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_closed);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }   // onCreate

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
            case R.id.nav_profile:
                Toast.makeText(MainActivity.this, "Open Profile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Profile_Page_Activity.class));
                break;
            case R.id.nav_phone:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LaptopFragment()).commit();
                Toast.makeText(MainActivity.this, "Open All Product", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_news:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NewsFragment_1()).commit();
                startActivity(new Intent(this, News_activity.class));
                Toast.makeText(MainActivity.this, "Open News", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_cart:
                startActivity(new Intent(this, Cart_Activity.class));
                Toast.makeText(MainActivity.this, "Open Cart", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_notification:
                startActivity(new Intent(this, Setting_Activity.class));
                Toast.makeText(MainActivity.this, "Open Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_contactus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ContactusFragment()).commit();
                Toast.makeText(MainActivity.this, "Open Contact Us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_about_us:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutusFragment()).commit();
                Toast.makeText(MainActivity.this, "Open About Us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout:
                logout();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (doubleBackToExitPressedOnce){
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click back again to exit.", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

    }

    public void logout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure want to logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                FirebaseAuth.getInstance().signOut();
                finish();

                SharedPreferences sp = getApplicationContext().getSharedPreferences("myUserPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.remove("myUserPrefs");
                editor.clear();
                editor.apply();

                SharedPreferences sp2 = getApplicationContext().getSharedPreferences("sp2Pref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = sp2.edit();
                editor2.remove("sp2Pref");
                editor2.clear();
                editor2.apply();

                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }
}