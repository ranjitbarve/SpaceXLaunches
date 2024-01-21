package com.ranjit.spacex.launches.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.ranjit.spacex.launches.model.Links;

import java.util.ArrayList;

public class LinksUtil {

    public static void setLinksToTextView(Links links, TextView textView, Context context) {
        if (links == null || textView == null) {
            return;
        }

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();

        // Add each link to the spannableStringBuilder
        appendClickableLink(spannableStringBuilder, links.getMissionPatch(), "Mission Patch", context);
        appendClickableLink(spannableStringBuilder, links.getMissionPatchSmall(), "Mission Patch Small", context);
        appendClickableLink(spannableStringBuilder, links.getRedditCampaign(), "Reddit Campaign", context);
        appendClickableLink(spannableStringBuilder, links.getRedditLaunch(), "Reddit Launch", context);
        appendClickableLink(spannableStringBuilder, links.getRedditMedia(), "Reddit Media", context);
        appendClickableLink(spannableStringBuilder, links.getPresskit(), "Presskit", context);
        appendClickableLink(spannableStringBuilder, links.getArticleLink(), "Article Link", context);
        appendClickableLink(spannableStringBuilder, links.getWikipedia(), "Wikipedia", context);
        appendClickableLink(spannableStringBuilder, links.getVideoLink(), "Video Link", context);
        appendClickableLink(spannableStringBuilder, links.getYoutubeId(), "YouTube ID", context);

        // Add Flickr images as separate clickable links
        ArrayList<String> flickrImages = links.getFlickrImages();
        if (flickrImages != null && !flickrImages.isEmpty()) {
            for (String flickrImage : flickrImages) {
                appendClickableLink(spannableStringBuilder, flickrImage, "Flickr Image", context);
            }
        }

        // Set the spannableStringBuilder to the TextView
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private static void appendClickableLink(SpannableStringBuilder spannableStringBuilder, String url, String label, Context context) {
        if (url != null && !url.isEmpty()) {
            SpannableString spannableString = new SpannableString(label + ": " + url + "\n");
            spannableString.setSpan(new ClickableUrlSpan(context,url), 0, spannableString.length(), 0);
            spannableStringBuilder.append(spannableString);
        }
    }

}

