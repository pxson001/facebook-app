package com.facebook.http.interfaces;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: rerun_param */
public enum RequestStage implements Parcelable {
    CREATED,
    QUEUED,
    WAITING_RESPONSE,
    DOWNLOADING_RESPONSE,
    FINISHED,
    FAILED;
    
    public static final Creator<RequestStage> CREATOR = null;

    /* compiled from: rerun_param */
    final class C03041 implements Creator<RequestStage> {
        C03041() {
        }

        public final Object createFromParcel(Parcel parcel) {
            try {
                return RequestStage.valueOf(parcel.readString());
            } catch (IllegalArgumentException e) {
                return RequestStage.CREATED;
            }
        }

        public final Object[] newArray(int i) {
            return new RequestStage[i];
        }
    }

    static {
        CREATOR = new C03041();
    }

    public final char toChar() {
        switch (2.a[ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return 'S';
            default:
                return name().charAt(0);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }
}
