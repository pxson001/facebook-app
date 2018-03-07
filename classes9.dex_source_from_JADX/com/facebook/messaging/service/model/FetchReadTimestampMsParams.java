package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: counter */
public class FetchReadTimestampMsParams implements Parcelable {
    public static final Creator<FetchReadTimestampMsParams> CREATOR = new C20231();
    public final ThreadKey f17108a;
    public final long f17109b;

    /* compiled from: counter */
    final class C20231 implements Creator<FetchReadTimestampMsParams> {
        C20231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchReadTimestampMsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchReadTimestampMsParams[i];
        }
    }

    public FetchReadTimestampMsParams(Parcel parcel) {
        this.f17108a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f17109b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17108a, i);
        parcel.writeLong(this.f17109b);
    }
}
