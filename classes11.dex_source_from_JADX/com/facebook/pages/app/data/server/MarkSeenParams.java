package com.facebook.pages.app.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: suggestions_after */
public class MarkSeenParams implements Parcelable {
    public static final Creator<MarkSeenParams> CREATOR = new C01661();
    private final long f1214a;
    private final String f1215b;

    /* compiled from: suggestions_after */
    final class C01661 implements Creator<MarkSeenParams> {
        C01661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MarkSeenParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MarkSeenParams[i];
        }
    }

    public MarkSeenParams(Parcel parcel) {
        this.f1214a = parcel.readLong();
        this.f1215b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f1214a);
        parcel.writeString(this.f1215b);
    }
}
