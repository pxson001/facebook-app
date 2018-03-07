package com.facebook.messaging.business.ride.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ui.media.attachments.MediaResource;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mobile_location */
public class RidePromoShareExtras implements Parcelable {
    public static final Creator<RidePromoShareExtras> CREATOR = new C10731();
    private final String f9295a;
    private final String f9296b;
    private final MediaResource f9297c;
    private final String f9298d;

    /* compiled from: mobile_location */
    final class C10731 implements Creator<RidePromoShareExtras> {
        C10731() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RidePromoShareExtras(parcel);
        }

        public final Object[] newArray(int i) {
            return new RidePromoShareExtras[i];
        }
    }

    public RidePromoShareExtras(String str, String str2, MediaResource mediaResource, String str3) {
        this.f9295a = str;
        this.f9296b = str2;
        this.f9297c = mediaResource;
        this.f9298d = str3;
    }

    protected RidePromoShareExtras(Parcel parcel) {
        this.f9295a = parcel.readString();
        this.f9296b = parcel.readString();
        this.f9297c = (MediaResource) parcel.readParcelable(RidePromoShareExtras.class.getClassLoader());
        this.f9298d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9295a);
        parcel.writeString(this.f9296b);
        parcel.writeParcelable(this.f9297c, i);
        parcel.writeString(this.f9298d);
    }
}
