package com.facebook.timeline.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/* compiled from: deletePhotoParams */
public class FetchTimelineHeaderParams implements Parcelable {
    public static final Creator<FetchTimelineHeaderParams> CREATOR = new C12881();
    public final long f17819a;
    private final int f17820b;
    public final int f17821c;
    private final Optional<String> f17822d;

    /* compiled from: deletePhotoParams */
    final class C12881 implements Creator<FetchTimelineHeaderParams> {
        C12881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchTimelineHeaderParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchTimelineHeaderParams[i];
        }
    }

    public FetchTimelineHeaderParams(long j, int i, int i2, Optional<String> optional) {
        this.f17819a = j;
        this.f17820b = i;
        this.f17821c = i2;
        this.f17822d = (Optional) Preconditions.checkNotNull(optional);
    }

    public FetchTimelineHeaderParams(Parcel parcel) {
        this.f17819a = parcel.readLong();
        this.f17820b = parcel.readInt();
        this.f17821c = parcel.readInt();
        this.f17822d = Optional.fromNullable(parcel.readString());
    }

    public static long m26127c() {
        return 2419200000L;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f17819a);
        parcel.writeInt(this.f17820b);
        parcel.writeInt(this.f17821c);
        parcel.writeString((String) this.f17822d.orNull());
    }

    public String toString() {
        return Objects.toStringHelper(this).add("profile", String.valueOf(this.f17819a)).add("lowResWidth", String.valueOf(this.f17820b)).add("highResWidth", String.valueOf(this.f17821c)).add("topContextItemType", this.f17822d).toString();
    }
}
