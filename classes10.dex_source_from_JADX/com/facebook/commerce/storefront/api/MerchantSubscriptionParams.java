package com.facebook.commerce.storefront.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: createOutputFileDescriptor called when response already set */
public class MerchantSubscriptionParams implements Parcelable {
    public static final Creator<MerchantSubscriptionParams> CREATOR = new C21841();
    public final String f15694a;
    public final String f15695b;

    /* compiled from: createOutputFileDescriptor called when response already set */
    final class C21841 implements Creator<MerchantSubscriptionParams> {
        C21841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MerchantSubscriptionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MerchantSubscriptionParams[i];
        }
    }

    public MerchantSubscriptionParams(String str, boolean z) {
        this.f15694a = str;
        this.f15695b = z ? "SUBSCRIBED" : "NONE";
    }

    public MerchantSubscriptionParams(Parcel parcel) {
        this.f15694a = parcel.readString();
        this.f15695b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15694a);
        parcel.writeString(this.f15695b);
    }
}
