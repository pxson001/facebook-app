package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: confirmation_params */
public class UnpinThreadParams implements Parcelable {
    public static final Creator<UnpinThreadParams> CREATOR = new C20621();
    public final ThreadKey f17335a;

    /* compiled from: confirmation_params */
    final class C20621 implements Creator<UnpinThreadParams> {
        C20621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UnpinThreadParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UnpinThreadParams[i];
        }
    }

    public UnpinThreadParams(Parcel parcel) {
        this.f17335a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17335a, i);
    }
}
