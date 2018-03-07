package com.facebook.places.create.citypicker;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: see_more_query */
public class FetchCityParam implements Parcelable {
    public static final Creator<FetchCityParam> CREATOR = new C04531();
    public final String f3567a;
    public final Location f3568b;

    /* compiled from: see_more_query */
    final class C04531 implements Creator<FetchCityParam> {
        C04531() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchCityParam(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchCityParam[i];
        }
    }

    public FetchCityParam(String str, Location location) {
        this.f3567a = str;
        this.f3568b = location;
    }

    public FetchCityParam(Parcel parcel) {
        this.f3567a = parcel.readString();
        this.f3568b = (Location) parcel.readParcelable(Location.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3567a);
        parcel.writeParcelable(this.f3568b, i);
    }

    public int describeContents() {
        return 0;
    }
}
