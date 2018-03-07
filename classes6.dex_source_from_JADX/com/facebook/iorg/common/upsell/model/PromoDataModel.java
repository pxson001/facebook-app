package com.facebook.iorg.common.upsell.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.iorg.common.upsell.server.ZeroPromoResult;
import com.facebook.iorg.common.upsell.server.ZeroPromoResult.Page;

/* compiled from: mCaption */
public class PromoDataModel implements Parcelable {
    public static final Creator<PromoDataModel> CREATOR = new C07051();
    public String f11244a;
    public String f11245b;
    private String f11246c;
    public String f11247d;
    public String f11248e;
    public String f11249f;
    public String f11250g;
    public String f11251h;
    public PromoLocation f11252i;

    /* compiled from: mCaption */
    final class C07051 implements Creator<PromoDataModel> {
        C07051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PromoDataModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new PromoDataModel[i];
        }
    }

    public PromoDataModel() {
        this.f11244a = null;
        this.f11245b = null;
        this.f11246c = null;
        this.f11247d = null;
        this.f11248e = null;
        this.f11249f = null;
        this.f11250g = null;
        this.f11251h = null;
        this.f11252i = PromoLocation.UNKNOWN;
    }

    public PromoDataModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, PromoLocation promoLocation) {
        this.f11244a = str;
        this.f11245b = str2;
        this.f11246c = str3;
        this.f11247d = str4;
        this.f11248e = str5;
        this.f11249f = str6;
        this.f11250g = str7;
        this.f11251h = str8;
        this.f11252i = promoLocation;
    }

    public PromoDataModel(ZeroPromoResult zeroPromoResult) {
        Page page = zeroPromoResult.f11312e;
        this.f11245b = page.f11303a;
        this.f11246c = page.f11305c;
        this.f11247d = page.f11304b;
        this.f11249f = page.f11306d;
        this.f11250g = page.f11307e;
        this.f11252i = PromoLocation.UNKNOWN;
    }

    public PromoDataModel(Parcel parcel) {
        this.f11244a = parcel.readString();
        this.f11245b = parcel.readString();
        this.f11246c = parcel.readString();
        this.f11247d = parcel.readString();
        this.f11248e = parcel.readString();
        this.f11249f = parcel.readString();
        this.f11250g = parcel.readString();
        this.f11251h = parcel.readString();
        this.f11252i = PromoLocation.fromString(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11244a);
        parcel.writeString(this.f11245b);
        parcel.writeString(this.f11246c);
        parcel.writeString(this.f11247d);
        parcel.writeString(this.f11248e);
        parcel.writeString(this.f11249f);
        parcel.writeString(this.f11250g);
        parcel.writeString(this.f11251h);
        parcel.writeString(this.f11252i.getParamName());
    }
}
