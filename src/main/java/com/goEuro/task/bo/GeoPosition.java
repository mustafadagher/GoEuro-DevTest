package com.goEuro.task.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The entity class for GeoPosition
 *
 * @author mustafa.kamel
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoPosition {

    @JsonProperty("latitude")
    private String latitude;

    @JsonProperty("longitude")
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(final String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(final String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "GeoPosition [latitude=" + latitude + ", longitude=" + longitude + "]";
    }
}
