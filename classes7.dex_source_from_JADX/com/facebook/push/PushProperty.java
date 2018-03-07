package com.facebook.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: icon_image_after */
public class PushProperty implements Parcelable {
    public static final Creator<PushProperty> CREATOR = new C09911();
    public final PushSource f11217a;
    @Nullable
    public final String f11218b;
    public final long f11219c;

    /* compiled from: icon_image_after */
    final class C09911 implements Creator<PushProperty> {
        C09911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PushProperty(parcel);
        }

        public final Object[] newArray(int i) {
            return new PushProperty[i];
        }
    }

    public PushProperty(PushSource pushSource) {
        this(pushSource, null, 0);
    }

    public PushProperty(PushSource pushSource, @Nullable String str, long j) {
        this.f11217a = pushSource;
        this.f11218b = str;
        this.f11219c = j;
    }

    public PushProperty(Parcel parcel) {
        this.f11217a = (PushSource) parcel.readSerializable();
        this.f11218b = parcel.readString();
        this.f11219c = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f11217a);
        parcel.writeString(this.f11218b);
        parcel.writeLong(this.f11219c);
    }
}
