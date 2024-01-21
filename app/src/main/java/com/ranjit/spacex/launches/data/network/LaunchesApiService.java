package com.ranjit.spacex.launches.data.network;

import com.ranjit.spacex.launches.model.Launches;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// SpaceLaunchesApi.java

public interface LaunchesApiService {

    @GET(ApiConstants.GET_ALL_LAUNCHES)
    Call<List<Launches>> getAllLaunches();

    @GET(ApiConstants.GET_ONE_LAUNCH_DETAILS)
    Call<Launches> getOneLaunchDetails(@Path("flight_number") int flight_number);
}

