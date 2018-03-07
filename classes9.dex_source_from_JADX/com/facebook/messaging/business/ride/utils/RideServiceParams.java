package com.facebook.messaging.business.ride.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.location.Coordinates;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: mobile_eligibility */
public class RideServiceParams implements Parcelable {
    public static final Creator<RideServiceParams> CREATOR = new C10741();
    public final String f9308a;
    @Nullable
    public final ThreadKey f9309b;
    @Nullable
    public final String f9310c;
    @Nullable
    public final String f9311d;
    @Nullable
    public final String f9312e;
    @Nullable
    public final String f9313f;
    @Nullable
    public final Coordinates f9314g;
    @Nullable
    public final String f9315h;
    public final boolean f9316i;

    /* compiled from: mobile_eligibility */
    final class C10741 implements Creator<RideServiceParams> {
        C10741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RideServiceParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new RideServiceParams[i];
        }
    }

    /* compiled from: mobile_eligibility */
    public class RideServiceParamsBuilder {
        @Nullable
        public String f9299a;
        @Nullable
        public ThreadKey f9300b;
        @Nullable
        public String f9301c;
        @Nullable
        public String f9302d;
        @Nullable
        public String f9303e;
        @Nullable
        public String f9304f;
        @Nullable
        public Coordinates f9305g;
        @Nullable
        public String f9306h;
        public boolean f9307i;

        public final RideServiceParamsBuilder m9762a(String str) {
            this.f9299a = str;
            return this;
        }

        public final RideServiceParamsBuilder m9763b(String str) {
            this.f9301c = str;
            return this;
        }

        public final RideServiceParamsBuilder m9764c(String str) {
            this.f9302d = str;
            return this;
        }

        public final RideServiceParamsBuilder m9765e(String str) {
            this.f9304f = str;
            return this;
        }

        public final RideServiceParamsBuilder m9761a(Coordinates coordinates) {
            this.f9305g = coordinates;
            return this;
        }

        public final RideServiceParamsBuilder m9766f(String str) {
            this.f9306h = str;
            return this;
        }

        public final RideServiceParams m9767j() {
            return new RideServiceParams(this);
        }
    }

    public RideServiceParams(RideServiceParamsBuilder rideServiceParamsBuilder) {
        this.f9308a = (String) Preconditions.checkNotNull(rideServiceParamsBuilder.f9299a);
        this.f9309b = rideServiceParamsBuilder.f9300b;
        this.f9310c = rideServiceParamsBuilder.f9301c;
        this.f9311d = rideServiceParamsBuilder.f9302d;
        this.f9312e = rideServiceParamsBuilder.f9303e;
        this.f9313f = rideServiceParamsBuilder.f9304f;
        this.f9314g = rideServiceParamsBuilder.f9305g;
        this.f9315h = rideServiceParamsBuilder.f9306h;
        this.f9316i = rideServiceParamsBuilder.f9307i;
    }

    public static RideServiceParamsBuilder newBuilder() {
        return new RideServiceParamsBuilder();
    }

    public RideServiceParams(Parcel parcel) {
        ClassLoader classLoader = RideServiceParams.class.getClassLoader();
        this.f9308a = parcel.readString();
        this.f9309b = (ThreadKey) parcel.readParcelable(classLoader);
        this.f9310c = parcel.readString();
        this.f9311d = parcel.readString();
        this.f9312e = parcel.readString();
        this.f9313f = parcel.readString();
        this.f9314g = (Coordinates) parcel.readParcelable(classLoader);
        this.f9315h = parcel.readString();
        this.f9316i = parcel.readByte() == (byte) 1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.f9308a);
        parcel.writeParcelable(this.f9309b, 0);
        parcel.writeString(this.f9310c);
        parcel.writeString(this.f9311d);
        parcel.writeString(this.f9312e);
        parcel.writeString(this.f9313f);
        parcel.writeParcelable(this.f9314g, 0);
        parcel.writeString(this.f9315h);
        if (this.f9316i) {
            i2 = 1;
        }
        parcel.writeByte((byte) i2);
    }
}
