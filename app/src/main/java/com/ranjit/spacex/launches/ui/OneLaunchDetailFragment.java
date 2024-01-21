package com.ranjit.spacex.launches.ui;

import static com.ranjit.spacex.launches.utils.LinksUtil.setLinksToTextView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ranjit.spacex.launches.data.network.Status;
import com.ranjit.spacex.launches.databinding.FragmentOneLaunchDetailBinding;
import com.ranjit.spacex.launches.model.Launches;
import com.ranjit.spacex.launches.utils.DateUtils;
import com.ranjit.spacex.launches.R;
import com.ranjit.spacex.launches.utils.ImageUtils;
import com.ranjit.spacex.launches.utils.RocketDetailsUtil;
import com.ranjit.spacex.launches.viewmodels.LaunchesViewModel;

public class OneLaunchDetailFragment extends Fragment {

    private FragmentOneLaunchDetailBinding binding;
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
        binding = FragmentOneLaunchDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Set up observers for LiveData
        setObservers();
    }

    // Method to set up observers for LiveData
    private void setObservers() {
        viewModel.lectureRatingLiveData.observe(getViewLifecycleOwner(), it -> {
            if (it.status.equals(Status.LOADING)) {
                binding.pbLoading.setVisibility(View.VISIBLE);
                // Handle loading state
            } else if (it.status.equals(Status.SUCCESS)) {
                // Process and set data when loading is successful
                binding.pbLoading.setVisibility(View.GONE);
                setData(it.data);
            } else if (it.status.equals(Status.ERROR)) {
                // Handle error state
                binding.pbLoading.setVisibility(View.GONE);
            }
        });
    }

    // Method to set data into UI components
    private void setData(Launches spaceLaunch) {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            // Set action bar title with the mission name
            actionBar.setTitle(spaceLaunch.getMissionName());
        }
        // Set various data fields in the UI
        binding.tvMissionName.setText(getString(R.string.mission_name, spaceLaunch.getMissionName()));
        binding.tvLaunchDate.setText(getString(R.string.launch_date, DateUtils.convertDateFormat(spaceLaunch.getLaunchDateLocal())));
        ImageUtils.loadImage(spaceLaunch.getLinks().getMissionPatch(), binding.ivLaunchSmall);
        binding.tvLaunchStatus.setText(spaceLaunch.isLaunchSuccess() ? R.string.launch_details_status_success : R.string.launch_details_status_failed);
        binding.tvRocketName.setText(getString(R.string.rocket_details_name, spaceLaunch.getRocket().getRocketName()));
        binding.tvRocketType.setText(getString(R.string.rocket_details_type, spaceLaunch.getRocket().getRocketType()));
        binding.tvMissionDescription.setText(getString(R.string.mission_description, spaceLaunch.getDetails()));
        binding.tvRocketDescription.setText(getString(R.string.rocket_details_description, RocketDetailsUtil.combineDetails(spaceLaunch.getRocket())));
        setLinksToTextView(spaceLaunch.getLinks(), binding.tvLinks, getActivity());

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Release binding reference when view is destroyed
        binding = null;
    }
}
