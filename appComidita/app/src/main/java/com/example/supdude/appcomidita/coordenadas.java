package com.example.supdude.appcomidita;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class coordenadas implements Parcelable {


    public String lat;

    public coordenadas(String lat, String longitud) {
        this.lat = lat;
        this.longitud = longitud;
    }

    protected coordenadas(Parcel in) {
        if (in.readByte() == 0) {
            lat = null;
        } else {
            lat = in.readString();
        }
        if (in.readByte() == 0) {
            longitud = null;
        } else {
            longitud = in.readString();
        }
    }

    public static final Creator<coordenadas> CREATOR = new Creator<coordenadas>() {
        @Override
        public coordenadas createFromParcel(Parcel in) {
            return new coordenadas(in);
        }

        @Override
        public coordenadas[] newArray(int size) {
            return new coordenadas[size];
        }
    };

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String longitud;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (lat == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeString(lat);
        }
        if (longitud == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeString(longitud);
        }
    }
}
