package com.facebook.messaging.model.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: updateNuxStatus */
public class ThreadGameData implements Parcelable {
    public static final Creator<ThreadGameData> CREATOR = new C01221();
    public final String f2273a;
    public final int f2274b;

    /* compiled from: updateNuxStatus */
    final class C01221 implements Creator<ThreadGameData> {
        C01221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThreadGameData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThreadGameData[i];
        }
    }

    public ThreadGameData(String str, int i) {
        this.f2273a = str;
        this.f2274b = i;
    }

    public ThreadGameData(Parcel parcel) {
        this.f2273a = parcel.readString();
        this.f2274b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2273a);
        parcel.writeInt(this.f2274b);
    }
}
