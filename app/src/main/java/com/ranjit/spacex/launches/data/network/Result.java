package com.ranjit.spacex.launches.data.network;

import static com.ranjit.spacex.launches.data.network.Status.ERROR;
import static com.ranjit.spacex.launches.data.network.Status.LOADING;
import static com.ranjit.spacex.launches.data.network.Status.SUCCESS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Result<T> {

    @NonNull
    public final Status status;

    @Nullable
    public final String message;

    @Nullable
    public final T data;

    public Result(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Result<T> loading() {
        return new Result<>(LOADING, null, null);
    }

    public static <T> Result<T> success(@Nullable T data) {
        return new Result<>(SUCCESS, data, null);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(ERROR, null, msg);
    }


}