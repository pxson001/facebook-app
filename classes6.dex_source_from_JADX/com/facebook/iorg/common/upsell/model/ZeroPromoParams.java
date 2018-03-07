package com.facebook.iorg.common.upsell.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: mCallToActionText */
public class ZeroPromoParams implements Parcelable {
    public static final Creator<ZeroPromoParams> CREATOR = new C07061();
    public String f11280a;
    public String f11281b;
    public PromoLocation f11282c;

    /* compiled from: mCallToActionText */
    final class C07061 implements Creator<ZeroPromoParams> {
        C07061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ZeroPromoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ZeroPromoParams[i];
        }
    }

    public ZeroPromoParams() {
        this.f11280a = "";
        this.f11281b = "";
        this.f11282c = PromoLocation.UNKNOWN;
    }

    public ZeroPromoParams(Parcel parcel) {
        this.f11280a = parcel.readString();
        this.f11281b = parcel.readString();
        this.f11282c = PromoLocation.fromString(parcel.readString());
    }

    public ZeroPromoParams(String str, String str2, PromoLocation promoLocation) {
        this.f11280a = str;
        this.f11281b = str2;
        this.f11282c = promoLocation;
    }

    public String toString() {
        return "ZeroPromoParams{mEncodedPhone='" + this.f11280a + '\'' + ", mPromoId='" + this.f11281b + '\'' + ", mLocation=" + this.f11282c + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11280a);
        parcel.writeString(this.f11281b);
        parcel.writeString(this.f11282c.getParamName());
    }
}
