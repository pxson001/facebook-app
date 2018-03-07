package com.facebook.messaging.location.sending;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.android.maps.model.LatLng;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mMessengerPayState */
public class NearbyPlace implements Parcelable {
    public static final Creator<NearbyPlace> CREATOR = new C12771();
    public final String f11444a;
    public final String f11445b;
    public final Uri f11446c;
    public final LatLng f11447d;
    @Nullable
    public final String f11448e;
    @Nullable
    public final String f11449f;

    /* compiled from: mMessengerPayState */
    final class C12771 implements Creator<NearbyPlace> {
        C12771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlace(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlace[i];
        }
    }

    /* compiled from: mMessengerPayState */
    public class Builder {
        @Nullable
        public String f11438a;
        @Nullable
        public String f11439b;
        @Nullable
        public Uri f11440c;
        @Nullable
        public LatLng f11441d;
        @Nullable
        public String f11442e;
        @Nullable
        public String f11443f;
    }

    public NearbyPlace(Builder builder) {
        this.f11444a = (String) Preconditions.checkNotNull(builder.f11438a);
        this.f11445b = (String) Preconditions.checkNotNull(builder.f11439b);
        this.f11446c = (Uri) Preconditions.checkNotNull(builder.f11440c);
        this.f11447d = (LatLng) Preconditions.checkNotNull(builder.f11441d);
        this.f11448e = builder.f11442e;
        this.f11449f = builder.f11443f;
    }

    public NearbyPlace(Parcel parcel) {
        this.f11444a = parcel.readString();
        this.f11445b = parcel.readString();
        this.f11446c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f11447d = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f11448e = parcel.readString();
        this.f11449f = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11444a);
        parcel.writeString(this.f11445b);
        parcel.writeParcelable(this.f11446c, i);
        parcel.writeParcelable(this.f11447d, i);
        parcel.writeString(this.f11448e);
        parcel.writeString(this.f11449f);
    }
}
