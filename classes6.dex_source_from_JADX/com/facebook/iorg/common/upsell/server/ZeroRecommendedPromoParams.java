package com.facebook.iorg.common.upsell.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.iorg.common.upsell.model.PromoLocation;
import com.facebook.zero.sdk.common.ZeroFeatureKey;

/* compiled from: mBigPictureSize */
public class ZeroRecommendedPromoParams implements Parcelable {
    public static final Creator<ZeroRecommendedPromoParams> CREATOR = new C07111();
    public int f11313a;
    public String f11314b;
    public boolean f11315c;
    private PromoLocation f11316d;
    private ZeroFeatureKey f11317e;

    /* compiled from: mBigPictureSize */
    final class C07111 implements Creator<ZeroRecommendedPromoParams> {
        C07111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ZeroRecommendedPromoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ZeroRecommendedPromoParams[i];
        }
    }

    public ZeroRecommendedPromoParams() {
        this.f11313a = 2;
        this.f11314b = "";
        this.f11315c = false;
        this.f11316d = PromoLocation.UNKNOWN;
        this.f11317e = ZeroFeatureKey.UNKNOWN;
    }

    public ZeroRecommendedPromoParams(int i, String str, boolean z, PromoLocation promoLocation, ZeroFeatureKey zeroFeatureKey) {
        this.f11313a = i;
        this.f11314b = str;
        this.f11315c = z;
        this.f11316d = promoLocation;
        this.f11317e = zeroFeatureKey;
    }

    public ZeroRecommendedPromoParams(Parcel parcel) {
        this.f11313a = parcel.readInt();
        this.f11314b = parcel.readString();
        this.f11315c = parcel.readByte() != (byte) 0;
        this.f11316d = PromoLocation.fromString(parcel.readString());
        this.f11317e = ZeroFeatureKey.fromString(parcel.readString());
    }

    public final String m18138a() {
        return this.f11316d.getParamName();
    }

    public final String m18139b() {
        return this.f11317e.prefString;
    }

    public String toString() {
        return "ZeroRecommendedPromoParams{limit=" + this.f11313a + ", scale='" + this.f11314b + '\'' + ", refresh=" + this.f11315c + ", location=" + this.f11316d + ", zeroFeatureKey=" + this.f11317e + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11313a);
        parcel.writeString(this.f11314b);
        parcel.writeByte((byte) (this.f11315c ? 1 : 0));
        parcel.writeString(this.f11316d.getParamName());
        parcel.writeString(this.f11317e.prefString);
    }
}
