package com.facebook.iorg.common.upsell.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: mBannersExpanded */
public class ZeroRecommendedPromoResult implements Parcelable {
    public static final Creator<ZeroRecommendedPromoResult> CREATOR = new C07121();
    @Deprecated
    public final String f11318A;
    @Deprecated
    public final String f11319B;
    @Deprecated
    public final String f11320C;
    @Deprecated
    public final String f11321D;
    public final String f11322a;
    public final String f11323b;
    public final ImmutableList<UpsellPromo> f11324c;
    public final String f11325d;
    public final String f11326e;
    public final String f11327f;
    @Deprecated
    private final String f11328g;
    @Deprecated
    private final String f11329h;
    @Deprecated
    public final String f11330i;
    @Deprecated
    public final String f11331j;
    @Deprecated
    public final String f11332k;
    @Deprecated
    public final String f11333l;
    @Deprecated
    public final String f11334m;
    @Deprecated
    public final String f11335n;
    @Deprecated
    private final long f11336o;
    @Deprecated
    public final String f11337p;
    @Deprecated
    private final long f11338q;
    @Deprecated
    public final String f11339r;
    @Deprecated
    public final String f11340s;
    @Deprecated
    public final int f11341t;
    @Deprecated
    public final int f11342u;
    @Deprecated
    public final ImmutableList<UpsellPromo> f11343v;
    @Deprecated
    public final String f11344w;
    @Deprecated
    public final String f11345x;
    @Deprecated
    public final boolean f11346y;
    @Deprecated
    public final String f11347z;

    /* compiled from: mBannersExpanded */
    final class C07121 implements Creator<ZeroRecommendedPromoResult> {
        C07121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ZeroRecommendedPromoResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new ZeroRecommendedPromoResult[i];
        }
    }

    public ZeroRecommendedPromoResult() {
        this(null, null, "", null, null, null, null, null, 0, null, null, 0, ImmutableList.of(), null, null, 0, 0, ImmutableList.of(), null, null, false, null, null, null, null, null, null, null, null, null);
    }

    public ZeroRecommendedPromoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, long j, String str9, String str10, long j2, ImmutableList<UpsellPromo> immutableList, String str11, String str12, int i, int i2, ImmutableList<UpsellPromo> immutableList2, String str13, String str14, boolean z, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23) {
        this.f11322a = str;
        this.f11323b = str2;
        this.f11325d = str3;
        this.f11328g = str4;
        this.f11329h = str5;
        this.f11330i = str6;
        this.f11334m = str7;
        this.f11335n = str8;
        this.f11336o = j;
        this.f11331j = str9;
        this.f11337p = str10;
        this.f11338q = j2;
        this.f11324c = immutableList;
        this.f11339r = str11;
        this.f11340s = str12;
        this.f11341t = i;
        this.f11342u = i2;
        this.f11343v = immutableList2;
        this.f11344w = str13;
        this.f11345x = str14;
        this.f11346y = z;
        this.f11347z = str15;
        this.f11318A = str16;
        this.f11319B = str17;
        this.f11320C = str18;
        this.f11332k = str19;
        this.f11333l = str20;
        this.f11321D = str21;
        this.f11326e = str22;
        this.f11327f = str23;
    }

    public ZeroRecommendedPromoResult(Parcel parcel) {
        this.f11322a = parcel.readString();
        this.f11323b = parcel.readString();
        this.f11325d = parcel.readString();
        this.f11328g = parcel.readString();
        this.f11329h = parcel.readString();
        this.f11330i = parcel.readString();
        this.f11334m = parcel.readString();
        this.f11335n = parcel.readString();
        this.f11336o = parcel.readLong();
        this.f11331j = parcel.readString();
        this.f11337p = parcel.readString();
        this.f11338q = parcel.readLong();
        Collection a = Lists.a();
        parcel.readTypedList(a, UpsellPromo.CREATOR);
        this.f11324c = ImmutableList.copyOf(a);
        this.f11339r = parcel.readString();
        this.f11340s = parcel.readString();
        this.f11341t = parcel.readInt();
        this.f11342u = parcel.readInt();
        a.clear();
        parcel.readTypedList(a, UpsellPromo.CREATOR);
        this.f11343v = ImmutableList.copyOf(a);
        this.f11344w = parcel.readString();
        this.f11345x = parcel.readString();
        this.f11346y = parcel.readByte() != (byte) 0;
        this.f11347z = parcel.readString();
        this.f11318A = parcel.readString();
        this.f11319B = parcel.readString();
        this.f11320C = parcel.readString();
        this.f11332k = parcel.readString();
        this.f11333l = parcel.readString();
        this.f11321D = parcel.readString();
        this.f11326e = parcel.readString();
        this.f11327f = parcel.readString();
    }

    public final long m18142g() {
        return this.f11336o;
    }

    public final long m18143j() {
        return this.f11338q;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11322a);
        parcel.writeString(this.f11323b);
        parcel.writeString(this.f11325d);
        parcel.writeString(this.f11328g);
        parcel.writeString(this.f11329h);
        parcel.writeString(this.f11330i);
        parcel.writeString(this.f11334m);
        parcel.writeString(this.f11335n);
        parcel.writeLong(this.f11336o);
        parcel.writeString(this.f11331j);
        parcel.writeString(this.f11337p);
        parcel.writeLong(this.f11338q);
        parcel.writeTypedList(this.f11324c);
        parcel.writeString(this.f11339r);
        parcel.writeString(this.f11340s);
        parcel.writeInt(this.f11341t);
        parcel.writeInt(this.f11342u);
        parcel.writeTypedList(this.f11343v);
        parcel.writeString(this.f11344w);
        parcel.writeString(this.f11345x);
        parcel.writeByte((byte) (this.f11346y ? 1 : 0));
        parcel.writeString(this.f11347z);
        parcel.writeString(this.f11318A);
        parcel.writeString(this.f11319B);
        parcel.writeString(this.f11320C);
        parcel.writeString(this.f11332k);
        parcel.writeString(this.f11333l);
        parcel.writeString(this.f11321D);
        parcel.writeString(this.f11326e);
        parcel.writeString(this.f11327f);
    }

    private static ImmutableList<UpsellPromo> m18141a(@Nullable JSONArray jSONArray) {
        if (jSONArray == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < jSONArray.length(); i++) {
            UpsellPromo a = UpsellPromo.m18134a(jSONArray.optJSONObject(i));
            if (a != null) {
                builder.c(a);
            }
        }
        return builder.b();
    }

    public static ZeroRecommendedPromoResult m18140a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return new ZeroRecommendedPromoResult();
        }
        return new ZeroRecommendedPromoResult(jSONObject.optString("title"), jSONObject.optString("top_message"), jSONObject.optString("carrierLogoUrl"), jSONObject.optString("button_text"), jSONObject.optString("accountType"), jSONObject.optString("message"), jSONObject.optString("errorMessage"), jSONObject.optString("loadBalance"), jSONObject.optLong("balanceUpdatedAt"), jSONObject.optString("promoName"), jSONObject.optString("promoRemaining"), jSONObject.optLong("promoExpiry"), m18141a(jSONObject.optJSONArray("promos")), jSONObject.optString("phone"), jSONObject.optString("bannerImage"), jSONObject.optInt("startBannerColor"), jSONObject.optInt("endBannerColor"), m18141a(jSONObject.optJSONArray("outstandingLoans")), jSONObject.optString("carrierManagerTitle"), jSONObject.optString("campaignExpiryText"), jSONObject.optBoolean("createShortcut"), jSONObject.optString("shortcutIcon"), jSONObject.optString("shortcutName"), jSONObject.optString("shortcutAlertIcon"), jSONObject.optString("shortcutAlertText"), jSONObject.optString("currentPromoTitle"), jSONObject.optString("additionalPromoTitle"), jSONObject.optString("buy_url"), jSONObject.optString("buy_text"), jSONObject.optString("promoScreenTitle"));
    }
}
