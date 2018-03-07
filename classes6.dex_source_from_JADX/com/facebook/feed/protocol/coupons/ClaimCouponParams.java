package com.facebook.feed.protocol.coupons;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: messenger_app_attribution_visibility */
public class ClaimCouponParams implements Parcelable {
    public static final Creator<ClaimCouponParams> CREATOR = new C06231();
    public final String f10369a;
    public final String f10370b;

    /* compiled from: messenger_app_attribution_visibility */
    final class C06231 implements Creator<ClaimCouponParams> {
        C06231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ClaimCouponParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ClaimCouponParams[i];
        }
    }

    public ClaimCouponParams(String str, String str2) {
        this.f10369a = str;
        this.f10370b = str2;
    }

    public ClaimCouponParams(Parcel parcel) {
        this.f10369a = parcel.readString();
        this.f10370b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10369a);
        parcel.writeString(this.f10370b);
    }
}
