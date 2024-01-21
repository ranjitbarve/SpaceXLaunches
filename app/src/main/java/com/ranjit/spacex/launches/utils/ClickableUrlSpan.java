package com.ranjit.spacex.launches.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

public class ClickableUrlSpan extends ClickableSpan {

    private String url;
    private Context context;

    public ClickableUrlSpan(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    @Override
    public void onClick(View widget) {
        // Handle the click event by opening the URL in the default web browser
        openUrlInBrowser(url);
    }

    private void openUrlInBrowser(String url) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(browserIntent);
        } catch (Exception e) {
            // Handle exceptions, e.g., if there is no web browser installed
            Toast.makeText(context, "Unable to open the link", Toast.LENGTH_SHORT).show();
        }
    }
}

