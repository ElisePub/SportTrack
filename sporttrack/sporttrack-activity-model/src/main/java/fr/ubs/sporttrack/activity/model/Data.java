package fr.ubs.sporttrack.activity.model;

import org.json.JSONObject;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class Data {
    private static final String TIME_FIELD = "time";
    private static final String CARDIO_FREQ_FIELD = "cardio_frequency";
    private static final String LATITUDE_FIELD = "latitude";
    private static final String LONGITUDE_FIELD = "longitude";
    private static final String ALTITUDE_FIELD = "altitude";

    @NotNull
    private String time;

    @NotNull
    @Min(value = 0, message = "La fréquence cardiaque doit être supérieure ou égale à zéro")
    private int cardioFrequency;

    @NotNull
    private float latitude;

    @NotNull
    private float longitude;

    @NotNull
    @Min(value = -500, message = "L'altitude minimale autorisée est -500")
    private float altitude;
    
    public Data(){}
    
    public Data(String time, int cf, float lat, float lon, float alt){
        this.time = time;
        this.cardioFrequency = cf;
        this.latitude = lat;
        this.longitude = lon;
        this.altitude = alt;
    }

    public String getTime(){
        return this.time;
    }

    public int getCardioFrequency(){
        return this.cardioFrequency;
    }

    public float getLatitude(){
        return this.latitude;
    }

    public float getLongitude(){
        return this.longitude;
    }

    public float getAltitude(){
        return this.altitude;
    }

    public static Data fromJSON(JSONObject obj){
        return new Data(obj.getString(TIME_FIELD), obj.getInt(CARDIO_FREQ_FIELD), obj.getFloat(LATITUDE_FIELD), obj.getFloat(LONGITUDE_FIELD), obj.getFloat(ALTITUDE_FIELD));
    }

    public JSONObject toJSON(){
        JSONObject obj = new JSONObject();
        obj.put(TIME_FIELD, this.time);
        obj.put(CARDIO_FREQ_FIELD, this.cardioFrequency);
        obj.put(LATITUDE_FIELD, this.latitude);
        obj.put(LONGITUDE_FIELD, this.longitude);
        obj.put(ALTITUDE_FIELD, this.altitude);
        return obj;
    }

    @Override
    public String toString(){
        return this.toJSON().toString();
    }
}
