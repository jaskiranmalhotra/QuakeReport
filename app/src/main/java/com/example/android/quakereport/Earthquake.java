package com.example.android.quakereport;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * An {@link Earthquake} object contains information related to a single earthquake.
 */
public class Earthquake {

    private static final String LOCATION_SEPARATOR = " of ";
    private final String magnitude;
    private final String primaryLocation;
    private final String locationOffset;
    private final String time;
    private final String url;
    private final String date;

    public Earthquake(double magnitude, String location, long time, String url) {

        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        this.magnitude = magnitudeFormat.format(magnitude);

        if (location.contains(LOCATION_SEPARATOR)) {
            String[] parts = location.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = "Near the";
            primaryLocation = location;
        }

        Date dateObject = new Date(time);

        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        date = dateFormat.format(dateObject);

        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        this.time = timeFormat.format(dateObject);

        this.url = url;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getPrimaryLocation() {
        return primaryLocation;
    }

    public String getLocationOffset() {
        return locationOffset;
    }

    public String getTime() {
        return time;
    }

    public String getUrl() {
        return url;
    }

    public String getDate() {
        return date;
    }
}
