package ru.denfad.akva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView title = findViewById(R.id.up_text);
        bottomNavigationView = findViewById(R.id.navigation);
        loadFragment(FishFragment.newInstance());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.fish_menu:
                        loadFragment(FishFragment.newInstance());
                        title.setText("Рыбы");
                        return true;

                    case R.id.temperature_menu:
                        loadFragment(TemperatureFragment.newInstance());
                        title.setText("Вода");
                        return true;
                    case R.id.leaf_menu:
                        loadFragment(PlantFragment.newInstance());
                        title.setText("Растения");
                        return true;
                }
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.replace(R.id.fl_content, fragment);
        ft.commit();
    }
}
