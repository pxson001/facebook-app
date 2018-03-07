package com.facebook.iorg.common.upsell.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: mBirthdayDay */
public class UpsellPromo implements Parcelable {
    public static final Creator<UpsellPromo> CREATOR = new C07081();
    @Deprecated
    public ImmutableList<String> f11288a;
    public final String f11289b;
    public final String f11290c;
    public final String f11291d;
    public final String f11292e;
    public final String f11293f;
    public final boolean f11294g;
    public final String f11295h;
    public final boolean f11296i;
    public final boolean f11297j;
    public final String f11298k;
    @Deprecated
    private final boolean f11299l;
    @Deprecated
    private final String f11300m;
    @Deprecated
    public final String f11301n;
    @Deprecated
    public final String f11302o;

    /* compiled from: mBirthdayDay */
    final class C07081 implements Creator<UpsellPromo> {
        C07081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpsellPromo(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpsellPromo[i];
        }
    }

    /* compiled from: mBirthdayDay */
    public enum PromoType {
        DATA("data"),
        DATA_MB("data_mb"),
        DATA_TIME("data_time"),
        DATA_UNLIMITED("data_unlimited"),
        UNKNOWN("unknown"),
        SMS("sms"),
        VOICE("voice"),
        CARRIER_ONLY("carrier_only"),
        LOAN("loan"),
        URL_PROMO("url_promo"),
        BUY_LATER("buy_later");
        
        private final String mType;

        private PromoType(String str) {
            this.mType = str;
        }

        public static PromoType fromString(String str) {
            if (str != null) {
                for (PromoType promoType : values()) {
                    if (str.equalsIgnoreCase(promoType.mType)) {
                        return promoType;
                    }
                }
            }
            return UNKNOWN;
        }

        public final String toString() {
            return this.mType;
        }
    }

    public UpsellPromo() {
        this(null, null, null, null, null, false, null, null, false, null, false, true, null, null, ImmutableList.of());
    }

    public UpsellPromo(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, boolean z2, String str8, boolean z3, boolean z4, String str9, String str10, ImmutableList<String> immutableList) {
        this.f11289b = str;
        this.f11290c = str2;
        this.f11291d = str3;
        this.f11292e = str4;
        this.f11293f = str5;
        this.f11294g = z;
        this.f11300m = str6;
        this.f11298k = str7;
        this.f11296i = z2;
        this.f11301n = str8;
        this.f11299l = z3;
        this.f11297j = z4;
        this.f11295h = str9;
        this.f11302o = str10;
        this.f11288a = immutableList;
    }

    public UpsellPromo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f11289b = parcel.readString();
        this.f11290c = parcel.readString();
        this.f11291d = parcel.readString();
        this.f11292e = parcel.readString();
        this.f11293f = parcel.readString();
        this.f11294g = parcel.readByte() != (byte) 0;
        this.f11300m = parcel.readString();
        this.f11298k = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.f11296i = z;
        this.f11301n = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.f11299l = z;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.f11297j = z2;
        this.f11295h = parcel.readString();
        this.f11302o = parcel.readString();
        Collection a = Lists.a();
        parcel.readStringList(a);
        this.f11288a = ImmutableList.copyOf(a);
    }

    @Nullable
    public static UpsellPromo m18134a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = ImmutableList.builder();
        JSONArray optJSONArray = jSONObject.optJSONArray("types");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                builder.c(optJSONArray.optString(i));
            }
        }
        return new UpsellPromo(jSONObject.optString("name"), jSONObject.optString("short_name"), jSONObject.optString("desc"), jSONObject.optString("code"), jSONObject.optString("price"), jSONObject.optBoolean("is_loan"), jSONObject.optString("message"), jSONObject.optString("sms_number"), jSONObject.optBoolean("current_promo"), jSONObject.optString("buy_url"), jSONObject.optBoolean("is_selected"), jSONObject.optBoolean("is_enabled"), jSONObject.optString("purchase_button_text"), jSONObject.optString("extra_confirm_text"), builder.b());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f11289b);
        parcel.writeString(this.f11290c);
        parcel.writeString(this.f11291d);
        parcel.writeString(this.f11292e);
        parcel.writeString(this.f11293f);
        parcel.writeByte((byte) (this.f11294g ? 1 : 0));
        parcel.writeString(this.f11300m);
        parcel.writeString(this.f11298k);
        if (this.f11296i) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.f11301n);
        if (this.f11299l) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.f11297j) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.f11295h);
        parcel.writeString(this.f11302o);
        parcel.writeStringList(this.f11288a);
    }
}
