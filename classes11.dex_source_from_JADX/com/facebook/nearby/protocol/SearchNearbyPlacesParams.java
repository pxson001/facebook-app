package com.facebook.nearby.protocol;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: top_up */
public class SearchNearbyPlacesParams implements Parcelable {
    public static final Creator<SearchNearbyPlacesParams> CREATOR = new C00891();
    public final SearchArea f709a;
    public final String f710b;
    public final Location f711c;
    public final float f712d;
    public final float f713e;
    public final float f714f;
    public final float f715g;
    public final float f716h;
    public final int f717i;

    /* compiled from: top_up */
    final class C00891 implements Creator<SearchNearbyPlacesParams> {
        C00891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SearchNearbyPlacesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SearchNearbyPlacesParams[i];
        }
    }

    /* compiled from: top_up */
    public class Builder {
        public SearchArea f700a;
        public String f701b;
        public Location f702c;
        public float f703d;
        public float f704e = 0.0f;
        public float f705f;
        public float f706g = 0.0f;
        public float f707h;
        public int f708i = 0;

        public Builder(SearchArea searchArea, String str) {
            this.f700a = searchArea;
            this.f701b = str;
        }
    }

    public SearchNearbyPlacesParams(Builder builder) {
        this.f709a = builder.f700a;
        this.f710b = builder.f701b;
        this.f711c = builder.f702c;
        this.f712d = builder.f703d;
        this.f713e = builder.f704e;
        this.f714f = builder.f705f;
        this.f715g = builder.f706g;
        this.f716h = builder.f707h;
        this.f717i = builder.f708i;
    }

    public SearchNearbyPlacesParams(Parcel parcel) {
        this.f709a = (SearchArea) parcel.readParcelable(SearchArea.class.getClassLoader());
        this.f710b = parcel.readString();
        this.f711c = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.f712d = parcel.readFloat();
        this.f713e = parcel.readFloat();
        this.f714f = parcel.readFloat();
        this.f715g = parcel.readFloat();
        this.f716h = parcel.readFloat();
        this.f717i = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f709a, i);
        parcel.writeString(this.f710b);
        parcel.writeParcelable(this.f711c, i);
        parcel.writeFloat(this.f712d);
        parcel.writeFloat(this.f713e);
        parcel.writeFloat(this.f714f);
        parcel.writeFloat(this.f715g);
        parcel.writeFloat(this.f716h);
        parcel.writeInt(this.f717i);
    }
}
