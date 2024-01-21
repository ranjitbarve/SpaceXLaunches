package com.ranjit.spacex.launches.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ranjit.spacex.launches.model.Launches;

// Room Database declaration with entities and version
@Database(version = 1, entities = {Launches.class}, exportSchema = false)
public abstract class LaunchRoomDatabase extends RoomDatabase {
    // Abstract method to get SpaceDao
    public abstract LaunchDao spaceDao();
}
