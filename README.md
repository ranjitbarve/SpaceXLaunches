# SpaceX Launches

## Overview

SpaceX Launches is an Android application that allows users to explore information about SpaceX rocket launches. The app provides details about upcoming and past launches, rocket information, and mission details.

## Project Structure

The project follows a modular architecture and leverages Dagger Hilt for dependency injection. Here's an overview of the key components:

### Modules

- **app**: The main application module containing the entry point (`MainActivity`), navigation, and main view models.
- **data**: Deals with data-related operations, including repository, local database, and remote API.
- **di**: Contains Dagger Hilt modules for dependency injection, such as `LaunchApiModule` and `LaunchDatabaseModule`.
- **model**: Defines the data models used in the application.
- **ui**: Includes fragments, adapters, and other UI-related components. Notable fragments are `LaunchesListFragment` and `OneLaunchDetailFragment`.
- **utils**: Contains utility classes, such as `DateUtils` and `ClickableUrlSpan` and `DispatchGroup` and `ImageUtils` and `LinksUtil` and  `RocketDetailsUtil`.
  
  
  

### Key Files

- **MainActivity.java**: The main activity responsible for hosting the navigation graph and configuring the ActionBar based on the current destination.
- **LaunchesListFragment.java**: Fragment displaying a list of SpaceX launches with a RecyclerView. Utilizes the `LaunchesAdapter` for item handling.
- **OneLaunchDetailFragment.java**: Fragment displaying detailed information about a specific SpaceX launch.
- **LaunchesAdapter.java**: RecyclerView adapter for displaying SpaceX launches. Utilizes data binding for efficient item binding.
- **LaunchesViewModel.java**: ViewModel responsible for handling UI-related data and interactions, communicating with the repository.
- **LaunchesRepository.java**: Repository handling data operations, including fetching launches from the API and updating local storage.

### Dependencies

- **Dagger Hilt**: Used for dependency injection, providing a modular and testable architecture.
- **Retrofit**: A type-safe HTTP client for making API calls.
- **Room Database**: Android's SQLite object-mapping library for local storage.
- **Gson**: A JSON serialization/deserialization library.
- **ViewModel and LiveData**: Part of Android Architecture Components for managing UI-related data and lifecycle-aware observations.

## Build and Run

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the application on an Android emulator or device.

## Download APK

You can download the latest APK for the app from the following link:

[Download SpaceXLaunches APK](https://drive.google.com/file/d/1Cxc4CUcVhT-mlQm2eZlhmZNjtLIxwkjs/view?usp=sharing)









## Screenshots
![SpaceXLaunchesList 1](https://drive.google.com/file/d/1NQa0NLZEdoe2BDU2FQRdqERvBrw_tUbA/view?usp=sharing)
![SpaceXLaunche_Detail_1](https://drive.google.com/file/d/1vF_I3YYVQ-NnzDw2y6qYXcnp-UDd3Spc/view?usp=sharing)
![SpaceXLaunche_Detail_1](https://drive.google.com/file/d/1KH4CLf4D_hfXVfQ3wPVSzC36aZ9irv-x/view?usp=sharing)


## Contribution

Contributions to improve the project are welcome! Feel free to create issues, submit pull requests, or suggest enhancements.


