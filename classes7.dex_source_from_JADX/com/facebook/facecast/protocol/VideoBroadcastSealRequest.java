package com.facebook.facecast.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: b-api.facebook.com */
public class VideoBroadcastSealRequest implements Parcelable {
    public static final Creator<VideoBroadcastSealRequest> CREATOR = new C16281();
    public final String f18802a;

    /* compiled from: b-api.facebook.com */
    final class C16281 implements Creator<VideoBroadcastSealRequest> {
        C16281() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoBroadcastSealRequest(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoBroadcastSealRequest[i];
        }
    }

    public VideoBroadcastSealRequest(String str) {
        this.f18802a = str;
    }

    public VideoBroadcastSealRequest(Parcel parcel) {
        this.f18802a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18802a);
    }
}
