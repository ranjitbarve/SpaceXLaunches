package com.ranjit.spacex.launches.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.ranjit.spacex.launches.data.network.Result;
import com.ranjit.spacex.launches.data.repository.SpaceLaunchesRepository;
import com.ranjit.spacex.launches.data.network.Status;
import com.ranjit.spacex.launches.model.Launches;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LaunchesViewModel extends ViewModel {


    private MutableLiveData<Result<List<Launches>>> spaceLaunchesLiveData;
    private SpaceLaunchesRepository repository;

    @Inject
    public LaunchesViewModel(SpaceLaunchesRepository repository) {
        this.repository = repository;
        spaceLaunchesLiveData = new MutableLiveData<>();
    }

    // Method to get the list of space launches
    public LiveData<Result<List<Launches>>> listLaunches(boolean hardRefresh) {
        spaceLaunchesLiveData.postValue(Result.loading());
        repository.listSpaceLaunches(spaceLaunchesLiveData, hardRefresh);
        return spaceLaunchesLiveData;
    }


    // Method to handle click on a launch item
    public void onClickLaunchItem(Launches launch)  {
        getOneLaunchDetailRequest(launch.getFlightNumber());
    }

    // Method to set the favorite status of a launch
    public void setFabStatus(Launches launches)  {
        repository.updateFavStatus(launches.getFlightNumber(), launches.isFavorite());
    }

    // Method to get details of a single launch
    private MutableLiveData<Result<Launches>> lectureRatingMLiveData = new MutableLiveData<>();
    public LiveData<Result<Launches>> lectureRatingLiveData = Transformations.map(lectureRatingMLiveData, this::parseLectureRating);

    public void getOneLaunchDetailRequest(int flightNumber) {
        repository.getOneLaunchDetail(lectureRatingMLiveData, flightNumber);
    }

    // Method to parse the result state of the single launch detail
    private Result<Launches> parseLectureRating(Result<Launches> resultState) {
        if (resultState.status.equals(Status.LOADING)) {
            // Handle loading state
        } else if (resultState.status.equals(Status.SUCCESS)) {
            // Handle success state
        } else if (resultState.status.equals(Status.ERROR)) {
            // Handle error state
        }
        return resultState;
    }
}
