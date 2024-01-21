package com.ranjit.spacex.launches.ui;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ranjit.spacex.launches.R;
import com.ranjit.spacex.launches.data.network.Status;
import com.ranjit.spacex.launches.databinding.FragmentListLaunchesBinding;
import com.ranjit.spacex.launches.model.Launches;
import com.ranjit.spacex.launches.viewmodels.LaunchesViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LaunchesListFragment extends Fragment {

    private FragmentListLaunchesBinding binding;
    private LaunchesViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize ViewModel using Hilt for dependency injection
        viewModel = new ViewModelProvider(requireActivity()).get(LaunchesViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment using view binding
        binding = FragmentListLaunchesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Set up refresh listener for swipeRefreshLayout
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            viewModel.listLaunches(true);
        });
        // Set up RecyclerView adapter and observe SpaceX launches
        setupAdapter();
        observeSpaceXLaunches();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Release binding reference when view is destroyed
        binding = null;
    }

    // Method to set up RecyclerView adapter
    private void setupAdapter() {
        binding.spaceLaunchesRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.spaceLaunchesRecyclerView.setHasFixedSize(true);
        // Set up SpaceLaunchesAdapter with item click listeners
        LaunchesAdapter adapter = new LaunchesAdapter(new LaunchesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Launches launch) {
                // Navigate to detail screen and handle launch item click
                findNavController(requireView()).navigate(R.id.action_spaceLaunches_to_spaceLauncheDetail);
                viewModel.onClickLaunchItem(launch);
            }

            @Override
            public void onFabItemClick(Launches launch) {
                // Handle FAB item click to set favorite status
                viewModel.setFabStatus(launch);
            }
        });
        binding.spaceLaunchesRecyclerView.setAdapter(adapter);
    }

    // Method to observe SpaceX launches from the ViewModel
    private void observeSpaceXLaunches() {
        viewModel.listLaunches(false).observe(getViewLifecycleOwner(), result -> {
            if (result.status == Status.LOADING) {
                // Show loading indicator when data is being loaded
                binding.pbLoading.setVisibility(View.VISIBLE);
                binding.swipeRefreshLayout.setRefreshing(true);
            } else if (result.status == Status.SUCCESS) {
                // Hide loading indicator and display RecyclerView when data is loaded successfully
                binding.pbLoading.setVisibility(View.GONE);
                binding.swipeRefreshLayout.setRefreshing(false);
                binding.spaceLaunchesRecyclerView.setVisibility(View.VISIBLE);
                LaunchesAdapter adapter = (LaunchesAdapter) binding.spaceLaunchesRecyclerView.getAdapter();
                if (adapter != null) {
                    // Update RecyclerView data with the loaded launches
                    adapter.setData(result.data);
                }
            } else if (result.status == Status.ERROR) {
                // Hide loading indicator and show error state when data loading fails
                binding.pbLoading.setVisibility(View.GONE);
                binding.swipeRefreshLayout.setRefreshing(false);
                binding.spaceLaunchesRecyclerView.setVisibility(View.GONE);
            }
        });
    }
}
