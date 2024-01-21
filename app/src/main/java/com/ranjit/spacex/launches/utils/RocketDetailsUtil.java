package com.ranjit.spacex.launches.utils;

import android.text.TextUtils;

import com.ranjit.spacex.launches.model.rocket.Core;
import com.ranjit.spacex.launches.model.rocket.Payload;
import com.ranjit.spacex.launches.model.rocket.Rocket;

public class RocketDetailsUtil {

    public static String combineDetails(Rocket rocket) {
        if (rocket == null) {
            return "N/A";
        }

        StringBuilder detailsBuilder = new StringBuilder();
        
        // Rocket Details
            detailsBuilder.append("Rocket ID: ").append(rocket.getRocketId()).append("\n");
            detailsBuilder.append("Rocket Name: ").append(rocket.getRocketName()).append("\n");
            detailsBuilder.append("Rocket Type: ").append(rocket.getRocketType()).append("\n");

            // Add more rocket details as needed..

            // First Stage
            if (rocket.getFirstStage() != null
                    && rocket.getFirstStage().getCores() != null
                    && !rocket.getFirstStage().getCores().isEmpty()) {

                detailsBuilder.append("First Stage Core Details:\n");

                for (Core core : rocket.getFirstStage().getCores()) {
                    detailsBuilder.append("Core Serial: ").append(core.getCoreSerial()).append("\n");
                    detailsBuilder.append("Flight: ").append(core.getFlight()).append("\n");
                    detailsBuilder.append("Block: ").append(core.getBlock()).append("\n");
                    detailsBuilder.append("Gridfins: ").append(core.isGridfins()).append("\n");
                    detailsBuilder.append("Legs: ").append(core.isLegs()).append("\n");
                    detailsBuilder.append("Reused: ").append(core.isReused()).append("\n");
                    detailsBuilder.append("Landing Intent: ").append(core.isLandingIntent()).append("\n");
                    detailsBuilder.append("\n");
                }
            }

            // Second Stage
            if (rocket.getSecondStage() != null) {
                detailsBuilder.append("Second Stage Block: ").append(rocket.getSecondStage().getBlock()).append("\n");

                // Add more second stage details as needed..

                // Payloads in Second Stage
                if (rocket.getSecondStage().getPayloads() != null
                        && !rocket.getSecondStage().getPayloads().isEmpty()) {

                    detailsBuilder.append("Payload Details in Second Stage:\n");

                    for (Payload payload : rocket.getSecondStage().getPayloads()) {
                        detailsBuilder.append("Payload ID: ").append(payload.getPayloadId()).append("\n");
                        detailsBuilder.append("Payload Customers: ").append(TextUtils.join(", ", payload.getCustomers())).append("\n");
                        // Add more payload details as needed..
                        detailsBuilder.append("\n");
                    }
                }
            }


        // Add more non-nullable key-value pairs..

        return detailsBuilder.toString();
    }
}

