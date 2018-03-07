package com.facebook.messaging.model.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: upload has failed in another partition */
public class ShareProperty implements Parcelable {
    public static final Creator<ShareProperty> CREATOR = new C01111();
    public final String f2216a;
    public final String f2217b;
    public final String f2218c;

    /* compiled from: upload has failed in another partition */
    final class C01111 implements Creator<ShareProperty> {
        C01111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShareProperty(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShareProperty[i];
        }
    }

    ShareProperty(SharePropertyBuilder sharePropertyBuilder) {
        this.f2216a = sharePropertyBuilder.f2219a;
        this.f2217b = sharePropertyBuilder.f2220b;
        this.f2218c = sharePropertyBuilder.f2221c;
    }

    public ShareProperty(Parcel parcel) {
        this.f2216a = parcel.readString();
        this.f2217b = parcel.readString();
        this.f2218c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2216a);
        parcel.writeString(this.f2217b);
        parcel.writeString(this.f2218c);
    }
}
