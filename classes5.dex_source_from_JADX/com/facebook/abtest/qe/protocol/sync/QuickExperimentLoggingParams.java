package com.facebook.abtest.qe.protocol.sync;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: total power is  */
public class QuickExperimentLoggingParams implements Parcelable {
    public static Creator<QuickExperimentLoggingParams> f1739a = new C01051();
    public final String f1740b;
    public final String f1741c;
    public final String f1742d;
    public final String f1743e;
    public final String f1744f;

    /* compiled from: total power is  */
    final class C01051 implements Creator<QuickExperimentLoggingParams> {
        C01051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new QuickExperimentLoggingParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new QuickExperimentLoggingParams[i];
        }
    }

    /* compiled from: total power is  */
    public class Builder {
        public String f1734a;
        public String f1735b;
        public String f1736c;
        public String f1737d;
        public String f1738e;

        public final QuickExperimentLoggingParams m2383a() {
            return new QuickExperimentLoggingParams(this);
        }
    }

    public QuickExperimentLoggingParams(Builder builder) {
        this.f1742d = (String) Preconditions.checkNotNull(builder.f1736c);
        this.f1740b = builder.f1734a;
        this.f1743e = builder.f1737d;
        this.f1741c = builder.f1735b;
        this.f1744f = builder.f1738e;
    }

    public QuickExperimentLoggingParams(Parcel parcel) {
        this.f1740b = parcel.readString();
        this.f1741c = parcel.readString();
        this.f1742d = parcel.readString();
        this.f1743e = parcel.readString();
        this.f1744f = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1740b);
        parcel.writeString(this.f1741c);
        parcel.writeString(this.f1742d);
        parcel.writeString(this.f1743e);
        parcel.writeString(this.f1744f);
    }
}
