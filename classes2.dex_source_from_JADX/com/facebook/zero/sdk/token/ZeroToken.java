package com.facebook.zero.sdk.token;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRule;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRuleSerialization;
import com.facebook.zero.sdk.util.UiFeatureDataSerializer;
import com.facebook.zero.sdk.util.ZeroSharedPreferences;
import com.facebook.zero.sdk.util.ZeroSharedPreferences.Editor;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import java.io.IOException;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fragment_background_color_id */
public class ZeroToken implements Parcelable {
    public static final Creator<ZeroToken> CREATOR = new C09461();
    public static final ZeroToken f23324a = new ZeroToken(null, null, null, null, null, 0, RegularImmutableSet.f688a, RegularImmutableList.f535a, null, RegularImmutableList.f535a, null, 0, null);
    private static final Class<?> f23325b = ZeroToken.class;
    public final String f23326c;
    public final String f23327d;
    public final String f23328e;
    public final String f23329f;
    public final String f23330g;
    public final int f23331h;
    public final ImmutableSet<ZeroFeatureKey> f23332i;
    public final ImmutableList<ZeroUrlRewriteRule> f23333j;
    public final String f23334k;
    public final ImmutableList<ZeroUrlRewriteRule> f23335l;
    public final String f23336m;
    private final int f23337n;
    public final String f23338o;

    /* compiled from: fragment_background_color_id */
    final class C09461 implements Creator<ZeroToken> {
        C09461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ZeroToken(parcel);
        }

        public final Object[] newArray(int i) {
            return new ZeroToken[0];
        }
    }

    public ZeroToken(String str, String str2, String str3, String str4, String str5, int i, ImmutableSet<ZeroFeatureKey> immutableSet, ImmutableList<ZeroUrlRewriteRule> immutableList, String str6, ImmutableList<ZeroUrlRewriteRule> immutableList2, String str7, int i2, String str8) {
        this.f23326c = str;
        this.f23327d = str2;
        this.f23329f = str3;
        this.f23328e = str4;
        this.f23330g = str5;
        this.f23331h = i;
        this.f23332i = immutableSet;
        this.f23333j = immutableList;
        this.f23334k = str6;
        this.f23335l = immutableList2;
        this.f23336m = str7;
        this.f23337n = i2;
        this.f23338o = str8;
    }

    public ZeroToken(Parcel parcel) {
        this.f23326c = parcel.readString();
        this.f23327d = parcel.readString();
        this.f23329f = parcel.readString();
        this.f23328e = parcel.readString();
        this.f23330g = parcel.readString();
        this.f23331h = parcel.readInt();
        this.f23332i = ImmutableSet.copyOf(ZeroFeatureKey.fromStrings(parcel.createStringArrayList()));
        this.f23333j = ImmutableList.copyOf(parcel.createTypedArrayList(ZeroUrlRewriteRule.CREATOR));
        this.f23334k = parcel.readString();
        this.f23335l = ImmutableList.copyOf(parcel.createTypedArrayList(ZeroUrlRewriteRule.CREATOR));
        this.f23336m = parcel.readString();
        this.f23337n = parcel.readInt();
        this.f23338o = parcel.readString();
    }

    private String m31487d() {
        return this.f23326c;
    }

    private String m31488e() {
        return this.f23327d;
    }

    private String m31489f() {
        return this.f23329f;
    }

    private String m31490g() {
        return this.f23328e;
    }

    private String m31491h() {
        return this.f23330g;
    }

    private int m31492i() {
        return this.f23331h;
    }

    public final ImmutableList<ZeroUrlRewriteRule> m31497a() {
        return this.f23333j;
    }

    public final ImmutableSet<ZeroFeatureKey> m31498b() {
        return this.f23332i;
    }

    private String m31493j() {
        return this.f23334k;
    }

    private String m31494k() {
        return this.f23336m;
    }

    private int m31495l() {
        return this.f23337n;
    }

    private String m31496m() {
        return this.f23338o;
    }

    public final ImmutableList<ZeroUrlRewriteRule> m31499c() {
        return this.f23335l;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f23326c);
        parcel.writeString(this.f23327d);
        parcel.writeString(this.f23329f);
        parcel.writeString(this.f23328e);
        parcel.writeString(this.f23330g);
        parcel.writeInt(this.f23331h);
        parcel.writeStringList(ZeroFeatureKey.toStrings(this.f23332i));
        parcel.writeTypedList(this.f23333j);
        parcel.writeString(this.f23334k);
        parcel.writeTypedList(this.f23335l);
        parcel.writeString(this.f23336m);
        parcel.writeInt(this.f23337n);
        parcel.writeString(this.f23338o);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ZeroToken)) {
            return false;
        }
        ZeroToken zeroToken = (ZeroToken) obj;
        if (Objects.equal(this.f23326c, zeroToken.f23326c) && Objects.equal(this.f23327d, zeroToken.f23327d) && Objects.equal(this.f23329f, zeroToken.f23329f) && Objects.equal(this.f23328e, zeroToken.f23328e) && Objects.equal(this.f23330g, zeroToken.f23330g) && Objects.equal(Integer.valueOf(this.f23331h), Integer.valueOf(zeroToken.f23331h)) && Objects.equal(this.f23332i, zeroToken.f23332i) && Objects.equal(this.f23333j, zeroToken.f23333j) && Objects.equal(this.f23334k, zeroToken.f23334k) && Objects.equal(this.f23335l, zeroToken.f23335l) && Objects.equal(this.f23336m, zeroToken.f23336m) && Objects.equal(this.f23338o, zeroToken.f23338o)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f23326c, this.f23327d, this.f23329f, this.f23328e, this.f23330g, Integer.valueOf(this.f23331h), this.f23332i, this.f23333j, this.f23334k, this.f23335l, this.f23336m, this.f23338o);
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("campaignId", this.f23326c).add("regStatus", this.f23327d).add("carrierName", this.f23329f).add("carrierId", this.f23328e).add("carrierLogoUrl", this.f23330g).add("ttl", this.f23331h).add("enabledUiFeatures", this.f23332i).add("rewriteRules", this.f23333j).add("unregistered_reason", this.f23334k).add("backupRewriteRules", this.f23335l).add("tokenHash", this.f23336m).add("requestTime", this.f23337n).add("fastTokenHash", this.f23338o).toString();
    }

    public static boolean m31486a(String str) {
        return (StringUtil.m3589a((CharSequence) str) || str.equals("0") || str.equals("-1")) ? false : true;
    }

    public static void m31485a(ZeroTokenType zeroTokenType, ZeroToken zeroToken, ZeroSharedPreferences zeroSharedPreferences, UiFeatureDataSerializer uiFeatureDataSerializer, ZeroUrlRewriteRuleSerialization zeroUrlRewriteRuleSerialization) {
        String a;
        Throwable e;
        Editor a2;
        String str = "";
        String str2 = "";
        try {
            a = uiFeatureDataSerializer.m8056a(zeroToken.m31498b());
            try {
                str2 = zeroUrlRewriteRuleSerialization.m31827a(zeroToken.m31497a());
            } catch (IOException e2) {
                e = e2;
                BLog.b(f23325b, "Error serializing enabled ui features and rewrite rules.", e);
                a2 = zeroSharedPreferences.mo1195a();
                a2.mo2850a(zeroTokenType.getCampaignIdKey(), zeroToken.m31487d()).mo2850a(zeroTokenType.getStatusKey(), "enabled").mo2850a(zeroTokenType.getRegistrationStatusKey(), zeroToken.m31488e()).mo2850a(zeroTokenType.getCarrierNameKey(), zeroToken.m31489f()).mo2850a(zeroTokenType.getCarrierIdKey(), zeroToken.m31490g()).mo2850a(zeroTokenType.getCarrierLogoUrlKey(), zeroToken.m31491h()).mo2848a(zeroTokenType.getTokenTTLKey(), zeroToken.m31492i()).mo2850a(zeroTokenType.getUIFeaturesKey(), a).mo2850a(zeroTokenType.getRewriteRulesKey(), str2).mo2850a(zeroTokenType.getUnregisteredReasonKey(), zeroToken.m31493j()).mo2850a(zeroTokenType.getTokenHashKey(), zeroToken.m31494k()).mo2848a(zeroTokenType.getTokenRequestTimeKey(), zeroToken.m31495l()).mo2850a(zeroTokenType.getTokenFastHashKey(), zeroToken.m31496m());
                if (!zeroToken.m31499c().isEmpty()) {
                    str2 = "";
                    try {
                        str2 = zeroUrlRewriteRuleSerialization.m31827a(zeroToken.m31499c());
                    } catch (Throwable e3) {
                        BLog.b(f23325b, "Error serializing backup rewrite rules.", e3);
                    }
                    a2.mo2850a(zeroTokenType.getBackupRewriteRulesKey(), str2);
                }
                a2.mo2852a();
            }
        } catch (Throwable e32) {
            Throwable th = e32;
            a = str;
            e = th;
            BLog.b(f23325b, "Error serializing enabled ui features and rewrite rules.", e);
            a2 = zeroSharedPreferences.mo1195a();
            a2.mo2850a(zeroTokenType.getCampaignIdKey(), zeroToken.m31487d()).mo2850a(zeroTokenType.getStatusKey(), "enabled").mo2850a(zeroTokenType.getRegistrationStatusKey(), zeroToken.m31488e()).mo2850a(zeroTokenType.getCarrierNameKey(), zeroToken.m31489f()).mo2850a(zeroTokenType.getCarrierIdKey(), zeroToken.m31490g()).mo2850a(zeroTokenType.getCarrierLogoUrlKey(), zeroToken.m31491h()).mo2848a(zeroTokenType.getTokenTTLKey(), zeroToken.m31492i()).mo2850a(zeroTokenType.getUIFeaturesKey(), a).mo2850a(zeroTokenType.getRewriteRulesKey(), str2).mo2850a(zeroTokenType.getUnregisteredReasonKey(), zeroToken.m31493j()).mo2850a(zeroTokenType.getTokenHashKey(), zeroToken.m31494k()).mo2848a(zeroTokenType.getTokenRequestTimeKey(), zeroToken.m31495l()).mo2850a(zeroTokenType.getTokenFastHashKey(), zeroToken.m31496m());
            if (zeroToken.m31499c().isEmpty()) {
                str2 = "";
                str2 = zeroUrlRewriteRuleSerialization.m31827a(zeroToken.m31499c());
                a2.mo2850a(zeroTokenType.getBackupRewriteRulesKey(), str2);
            }
            a2.mo2852a();
        }
        a2 = zeroSharedPreferences.mo1195a();
        a2.mo2850a(zeroTokenType.getCampaignIdKey(), zeroToken.m31487d()).mo2850a(zeroTokenType.getStatusKey(), "enabled").mo2850a(zeroTokenType.getRegistrationStatusKey(), zeroToken.m31488e()).mo2850a(zeroTokenType.getCarrierNameKey(), zeroToken.m31489f()).mo2850a(zeroTokenType.getCarrierIdKey(), zeroToken.m31490g()).mo2850a(zeroTokenType.getCarrierLogoUrlKey(), zeroToken.m31491h()).mo2848a(zeroTokenType.getTokenTTLKey(), zeroToken.m31492i()).mo2850a(zeroTokenType.getUIFeaturesKey(), a).mo2850a(zeroTokenType.getRewriteRulesKey(), str2).mo2850a(zeroTokenType.getUnregisteredReasonKey(), zeroToken.m31493j()).mo2850a(zeroTokenType.getTokenHashKey(), zeroToken.m31494k()).mo2848a(zeroTokenType.getTokenRequestTimeKey(), zeroToken.m31495l()).mo2850a(zeroTokenType.getTokenFastHashKey(), zeroToken.m31496m());
        if (zeroToken.m31499c().isEmpty()) {
            str2 = "";
            str2 = zeroUrlRewriteRuleSerialization.m31827a(zeroToken.m31499c());
            a2.mo2850a(zeroTokenType.getBackupRewriteRulesKey(), str2);
        }
        a2.mo2852a();
    }
}
