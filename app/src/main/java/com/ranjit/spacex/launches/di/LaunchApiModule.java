package com.ranjit.spacex.launches.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ranjit.spacex.launches.data.local.LaunchDao;
import com.ranjit.spacex.launches.data.network.ApiConstants;
import com.ranjit.spacex.launches.data.network.LaunchesApiService;
import com.ranjit.spacex.launches.data.repository.SpaceLaunchesRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class LaunchApiModule {

    // Provides a singleton instance of SpaceLaunchesApi
    @Provides
    public LaunchesApiService provideSpaceLaunchesApi(Retrofit.Builder retrofitBuilder, OkHttpClient okHttpClient) {
        return retrofitBuilder.client(okHttpClient).build().create(LaunchesApiService.class);
    }

    // Provides a singleton instance of OkHttpClient with logging interceptor
    @Provides
    public OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient().newBuilder().addInterceptor(interceptor).build();
    }

    // Provides a singleton instance of Retrofit.Builder
    @Provides
    public Retrofit.Builder provideRetrofitBuilder() {
        // Create Gson instance with custom configuration
        Gson gson = new GsonBuilder()
                .serializeNulls() // Allow Gson to serialize null values
                .create();

        // Configure Retrofit.Builder with base URL and GsonConverterFactory
        return new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson));
    }

    // Provides a singleton instance of SpaceLaunchesRepository
    @Provides
    public SpaceLaunchesRepository provideRepository(LaunchesApiService launchesApi, LaunchDao dao) {
        // Create and return an instance of SpaceLaunchesRepository
        return new SpaceLaunchesRepository(launchesApi, dao);
    }
}
