package com.ranjit.spacex.launches.data.repository;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.ranjit.spacex.launches.data.local.LaunchDao;
import com.ranjit.spacex.launches.data.network.Result;
import com.ranjit.spacex.launches.utils.DispatchGroup;
import com.ranjit.spacex.launches.data.network.LaunchesApiService;
import com.ranjit.spacex.launches.model.Launches;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpaceLaunchesRepository {

    private LaunchesApiService launchesApi;
    private LaunchDao launchDao;

    @Inject
    public SpaceLaunchesRepository(LaunchesApiService launchesApi, LaunchDao dao) {
        this.launchesApi = launchesApi;
        this.launchDao = dao;
    }

    // Method to update favorite status in the background
    public void updateFavStatus(int flightNumber, boolean status) {
        AsyncTask.execute(() -> launchDao.updateFavStatus(flightNumber, status));
    }

    // Method to list space launches
    public void listSpaceLaunches(MutableLiveData<Result<List<Launches>>> liveData, boolean hardRefresh) {
        if (hardRefresh) {
            // If hard refresh is needed, fetch data from the network
            fetchItems(liveData);
        } else {
            // Otherwise, check the local database
            DispatchGroup dbDispatcher = new DispatchGroup(() -> {});
            dbDispatcher.enter();
            AsyncTask.execute(() -> {
                List<Launches> items = launchDao.listLaunches();
                if (items != null && !items.isEmpty()) {
                    // If data is available in the local database, post the result
                    liveData.postValue(Result.success(items));
                } else {
                    // Otherwise, fetch data from the network
                    fetchItems(liveData);
                }
                dbDispatcher.leave();
            });
        }
    }

    // Method to fetch items from the network
    private void fetchItems(MutableLiveData<Result<List<Launches>>> liveData) {
        launchesApi.getAllLaunches().enqueue(new Callback<List<Launches>>() {
            @Override
            public void onResponse(Call<List<Launches>> call, Response<List<Launches>> response) {
                if (response.isSuccessful()) {
                    try {
                        List<Launches> items = response.body();

                        if (items != null) {
                            // Process the response and update the local database
                            for (Launches item : items) {
                                if (item.getRocket()!= null) {
                                    item.setRocketName(item.getRocket().getRocketName());
                                }
                                if (item.getLinks() != null) {
                                    item.setMissionPatchSmall(item.getLinks().getMissionPatchSmall());
                                }
                            }
                            AsyncTask.execute(() -> {
                                // Insert into the Room database
                                launchDao.insertAll(items);

                                // Update LiveData after insertion
                                liveData.postValue(Result.success(launchDao.listLaunches()));
                            });
                        } else {
                            // Handle null response body
                            liveData.postValue(Result.error("Null response body"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        liveData.postValue(Result.error(e.getLocalizedMessage()));
                    }
                } else {
                    // Handle unsuccessful response
                    liveData.postValue(Result.error("Unsuccessful response"));
                }
            }

            @Override
            public void onFailure(Call<List<Launches>> call, Throwable t) {
                // Handle failure
                liveData.postValue(Result.error(t.getLocalizedMessage()));
            }
        });
    }

    // Method to get details of a single launch
    public void getOneLaunchDetail(MutableLiveData<Result<Launches>> liveData, int flightNumber) {
        launchesApi.getOneLaunchDetails(flightNumber).enqueue(new Callback<Launches>() {
            @Override
            public void onResponse(Call<Launches> call, Response<Launches> response) {
                if (response.isSuccessful()) {
                    Launches item = response.body();
                    liveData.postValue(Result.success(response.body()));
                }
            }

            @Override
            public void onFailure(Call<Launches> call, Throwable t) {
                liveData.postValue(Result.error(t.getLocalizedMessage()));
            }
        });
    }
}
