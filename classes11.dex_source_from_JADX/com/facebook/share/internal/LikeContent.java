package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareModel;

/* compiled from: out of range ( */
public class LikeContent implements ShareModel {
    public static final Creator<LikeContent> CREATOR = new C06151();
    private final String f4565a;
    private final String f4566b;

    /* compiled from: out of range ( */
    final class C06151 implements Creator<LikeContent> {
        C06151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LikeContent(parcel);
        }

        public final Object[] newArray(int i) {
            return new LikeContent[i];
        }
    }

    LikeContent(Parcel parcel) {
        this.f4565a = parcel.readString();
        this.f4566b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4565a);
        parcel.writeString(this.f4566b);
    }
}
