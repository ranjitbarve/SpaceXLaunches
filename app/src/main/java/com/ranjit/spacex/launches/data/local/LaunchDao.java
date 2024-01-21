package com.ranjit.spacex.launches.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ranjit.spacex.launches.model.Launches;

import java.util.List;

// SpaceDao.java

@Dao
public interface LaunchDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Launches item);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<Launches> items);

    @Query("SELECT * FROM launch")
    List<Launches> listLaunches();

    @Query("UPDATE launch SET is_favorite = :status WHERE flight_number =:flightNumber")
    void updateFavStatus(int flightNumber, boolean status);
}

