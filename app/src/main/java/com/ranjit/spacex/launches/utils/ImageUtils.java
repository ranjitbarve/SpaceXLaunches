package com.ranjit.spacex.launches.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.ranjit.spacex.launches.R;

public class ImageUtils {
    public static void loadImage(String url, ImageView imageView) {
        // Using Glide for efficient image loading
        Context context = imageView.getContext();
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }
}
