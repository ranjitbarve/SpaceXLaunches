package com.ranjit.spacex.launches.data.network;

public interface ApiConstants {
    String BASE_URL = "https://api.spacexdata.com/v3/";
//    String GET_ALL_LAUNCHES = "launches?limit=1&mode=detailed&offset=1";
    String GET_ALL_LAUNCHES = "launches";
    String GET_ONE_LAUNCH_DETAILS = "launches/{flight_number}";
}
