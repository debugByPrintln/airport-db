package org.emobile.model;

import jakarta.persistence.*;

@Entity
@Table(name = "airports", schema = "bookings")
public class Airport {

    @Id
    @Column(name = "airport_code", length = 3)
    private String airportCode;

    @Column(name = "airport_name", nullable = false)
    private String airportName;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "timezone", nullable = false)
    private String timezone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (!airportCode.equals(airport.airportCode)) return false;
        if (!airportName.equals(airport.airportName)) return false;
        if (!city.equals(airport.city)) return false;
        if (!longitude.equals(airport.longitude)) return false;
        if (!latitude.equals(airport.latitude)) return false;
        return timezone.equals(airport.timezone);
    }

    @Override
    public int hashCode() {
        int result = airportCode.hashCode();
        result = 31 * result + airportName.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + latitude.hashCode();
        result = 31 * result + timezone.hashCode();
        return result;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
