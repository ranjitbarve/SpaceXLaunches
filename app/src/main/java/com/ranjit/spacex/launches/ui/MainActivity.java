package com.ranjit.spacex.launches.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import com.ranjit.spacex.launches.R;
import com.ranjit.spacex.launches.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NavHostFragment navHostFragment = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupNavHostFragment();
    }

    // Handle option item selection (e.g., back button)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Pop back stack when the home (back) button is pressed
            navHostFragment.getNavController().popBackStack();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Setup NavHostFragment and configure ActionBar
    private void setupNavHostFragment() {
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        navHostFragment.getNavController().addOnDestinationChangedListener((controller, destination, arguments) -> {
            // Update ActionBar title based on the current destination
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(destination.getLabel());
                // Show/hide the back button based on the current destination
                actionBar.setDisplayHomeAsUpEnabled(destination.getId() == R.id.spaceLauncheDetail);
            }
        });
    }
}
