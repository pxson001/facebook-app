package com.facebook.ipc.composer.model;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerLocationDeserializer.class)
@JsonSerialize(using = ComposerLocationSerializer.class)
/* compiled from: TNT */
public class ComposerLocation implements Parcelable {
    public static final Creator<ComposerLocation> CREATOR = new C13311();
    @JsonProperty("accuracy")
    public final float accuracy;
    @JsonProperty("latitude")
    public final double latitude;
    @JsonProperty("longitude")
    public final double longitude;
    @JsonProperty("time")
    public final long time;

    /* compiled from: TNT */
    final class C13311 implements Creator<ComposerLocation> {
        C13311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerLocation(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerLocation[i];
        }
    }

    @JsonIgnore
    public static ComposerLocation m23317a(Location location) {
        if (location == null) {
            return null;
        }
        return new ComposerLocation(location.getLatitude(), location.getLongitude(), location.getAccuracy(), location.getTime());
    }

    @JsonIgnore
    public final Location m23318a(String str) {
        Location location = new Location(str);
        location.setLatitude(this.latitude);
        location.setLongitude(this.longitude);
        location.setAccuracy(this.accuracy);
        location.setTime(this.time);
        return location;
    }

    @JsonIgnore
    private ComposerLocation() {
        this(0.0d, 0.0d, 0.0f, 0);
    }

    private ComposerLocation(double d, double d2, float f, long j) {
        this.latitude = d;
        this.longitude = d2;
        this.accuracy = f;
        this.time = j;
    }

    @JsonIgnore
    public ComposerLocation(Parcel parcel) {
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.accuracy = parcel.readFloat();
        this.time = parcel.readLong();
    }

    @JsonIgnore
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeFloat(this.accuracy);
        parcel.writeLong(this.time);
    }

    @JsonIgnore
    public int describeContents() {
        return 0;
    }
}
