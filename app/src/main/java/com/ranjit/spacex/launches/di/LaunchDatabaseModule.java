// SpaceDatabaseModule.java

package com.ranjit.spacex.launches.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.ranjit.spacex.launches.data.local.LaunchDao;
import com.ranjit.spacex.launches.data.local.LaunchRoomDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class LaunchDatabaseModule {

    // Provides a singleton instance of the application context
    @Provides
    @Singleton
    public Context provideContext(Application application) {
        return application.getApplicationContext();
    }

    // Provides a singleton instance of SpaceRoomDatabase
    @Provides
    @Singleton
    public LaunchRoomDatabase provideSpaceDatabase(@ApplicationContext Context context) {
        // Use Room's databaseBuilder to create the database instance
        return Room.databaseBuilder(context, LaunchRoomDatabase.class, "spacex_launch.db").build();
    }

    // Provides a singleton instance of SpaceDao
    @Provides
    @Singleton
    public LaunchDao provideSpaceDao(LaunchRoomDatabase database) {
        // Access SpaceDao from the SpaceRoomDatabase instance
        return database.spaceDao();
    }
}