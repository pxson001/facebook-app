package com.facebook.video.creativeediting.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: dump_cause */
public class AudioLoggingParams implements Parcelable {
    public static final Creator<AudioLoggingParams> CREATOR = new C11861();
    public int f15530a;

    /* compiled from: dump_cause */
    final class C11861 implements Creator<AudioLoggingParams> {
        C11861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AudioLoggingParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AudioLoggingParams[i];
        }
    }

    public AudioLoggingParams(Parcel parcel) {
        this.f15530a = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f15530a);
    }
}
