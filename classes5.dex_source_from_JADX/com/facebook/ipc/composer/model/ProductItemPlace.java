package com.facebook.ipc.composer.model;

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
@JsonDeserialize(using = ProductItemPlaceDeserializer.class)
@JsonSerialize(using = ProductItemPlaceSerializer.class)
/* compiled from: TIMELINE_COLLECTION */
public class ProductItemPlace implements Parcelable {
    public static final Creator<ProductItemPlace> CREATOR = new C13401();
    @JsonProperty("latitude")
    public final double latitude;
    @JsonProperty("location_page_id")
    public final String locationPageID;
    @JsonProperty("longitude")
    public final double longitude;
    @JsonProperty("name")
    public final String name;

    /* compiled from: TIMELINE_COLLECTION */
    final class C13401 implements Creator<ProductItemPlace> {
        C13401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProductItemPlace(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProductItemPlace[i];
        }
    }

    /* compiled from: TIMELINE_COLLECTION */
    public class Builder {
        public String f14029a;
        public String f14030b;
        public double f14031c;
        public double f14032d;

        public final ProductItemPlace m23409a() {
            return new ProductItemPlace(this);
        }
    }

    @JsonIgnore
    private ProductItemPlace() {
        this(new Builder());
    }

    public ProductItemPlace(Builder builder) {
        this.name = builder.f14029a;
        this.locationPageID = builder.f14030b;
        this.latitude = builder.f14031c;
        this.longitude = builder.f14032d;
    }

    public ProductItemPlace(Parcel parcel) {
        this.name = parcel.readString();
        this.locationPageID = parcel.readString();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.locationPageID);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
    }
}
