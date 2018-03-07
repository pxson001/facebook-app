package com.facebook.messaging.model.attachment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: using_new_chunk_flow */
public class AudioData implements Parcelable {
    public static final Creator<AudioData> CREATOR = new C00771();
    public final boolean f1884a;

    /* compiled from: using_new_chunk_flow */
    final class C00771 implements Creator<AudioData> {
        C00771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AudioData(parcel);
        }

        public final Object[] newArray(int i) {
            return new AudioData[i];
        }
    }

    public AudioData(boolean z) {
        this.f1884a = z;
    }

    public AudioData(Parcel parcel) {
        this.f1884a = parcel.readInt() > 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1884a ? 1 : 0);
    }
}
