package com.example.mycafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.mycafe.ui.home.AddMoneyDialogFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mycafe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AddMoneyDialogFragment.AddMoneyListener{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private int num1, num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        //FAB
        binding.appBarMain.fabWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogAddMoney();
            }
        });


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_profile, R.id.nav_mall, R.id.nav_Gmail, R.id.nav_googleMap)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void openDialogAddMoney() {
        DialogFragment newFragment = new AddMoneyDialogFragment();
        newFragment.show(getSupportFragmentManager(), "Signin");
    }

    //只會調用一次，只會在menu顯示之前去調用一次，之後就不會再去使用了
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    //menu的點擊處理
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        if (item.getItemId() == R.id.search){
            Uri webpage = Uri.parse("https://www.google.com");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);

            Toast.makeText(this, "search!!", Toast.LENGTH_LONG).show();
        }

        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);

    }

    @Override
    public void appleTexts(String money) {
        num1 = Integer.parseInt(money);
        num2 += num1;
        binding.appBarMain.tvMoney.setText(String.valueOf(num2));
    }
}