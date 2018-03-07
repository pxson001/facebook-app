package com.facebook;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: event_buy_tickets_view_order */
public final class AccessToken implements Parcelable {
    public static final Creator<AccessToken> CREATOR = new C18632();
    private static final Date f13704a;
    private static final Date f13705b;
    private static final Date f13706c = new Date();
    private static final AccessTokenSource f13707d = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    private final Date f13708e;
    public final Set<String> f13709f;
    private final Set<String> f13710g;
    public final String f13711h;
    public final AccessTokenSource f13712i;
    public final Date f13713j;
    public final String f13714k;
    private final String f13715l;

    /* compiled from: event_buy_tickets_view_order */
    final class C18632 implements Creator {
        C18632() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AccessToken(parcel);
        }

        public final Object[] newArray(int i) {
            return new AccessToken[i];
        }
    }

    /* compiled from: event_buy_tickets_view_order */
    public interface AccessTokenRefreshCallback {
    }

    static {
        Date date = new Date(Long.MAX_VALUE);
        f13704a = date;
        f13705b = date;
    }

    public AccessToken(String str, String str2, String str3, @Nullable Collection<String> collection, @Nullable Collection<String> collection2, @Nullable AccessTokenSource accessTokenSource, @Nullable Date date, @Nullable Date date2) {
        Validate.m25367a(str, "accessToken");
        Validate.m25367a(str2, "applicationId");
        Validate.m25367a(str3, "userId");
        if (date == null) {
            date = f13705b;
        }
        this.f13708e = date;
        this.f13709f = Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet());
        this.f13710g = Collections.unmodifiableSet(collection2 != null ? new HashSet(collection2) : new HashSet());
        this.f13711h = str;
        if (accessTokenSource == null) {
            accessTokenSource = f13707d;
        }
        this.f13712i = accessTokenSource;
        if (date2 == null) {
            date2 = f13706c;
        }
        this.f13713j = date2;
        this.f13714k = str2;
        this.f13715l = str3;
    }

    public static AccessToken m14004a() {
        return AccessTokenManager.m14028a().f13739d;
    }

    public final String m14008b() {
        return this.f13711h;
    }

    public final Date m14009c() {
        return this.f13708e;
    }

    public final Set<String> m14010d() {
        return this.f13709f;
    }

    public final Set<String> m14011e() {
        return this.f13710g;
    }

    public final AccessTokenSource m14012f() {
        return this.f13712i;
    }

    public final String m14013h() {
        return this.f13714k;
    }

    public final String m14014i() {
        return this.f13715l;
    }

    public final String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{AccessToken");
        StringBuilder append = stringBuilder.append(" token:");
        if (this.f13711h == null) {
            str = "null";
        } else if (FacebookSdk.m14047a(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
            str = this.f13711h;
        } else {
            str = "ACCESS_TOKEN_REMOVED";
        }
        append.append(str);
        stringBuilder.append(" permissions:");
        if (this.f13709f == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append("[");
            stringBuilder.append(TextUtils.join(", ", this.f13709f));
            stringBuilder.append("]");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r4 != r5) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r5 instanceof com.facebook.AccessToken;
        if (r2 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r1;
        goto L_0x0004;
    L_0x000b:
        r5 = (com.facebook.AccessToken) r5;
        r2 = r4.f13708e;
        r3 = r5.f13708e;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0057;
    L_0x0017:
        r2 = r4.f13709f;
        r3 = r5.f13709f;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0057;
    L_0x0021:
        r2 = r4.f13710g;
        r3 = r5.f13710g;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0057;
    L_0x002b:
        r2 = r4.f13711h;
        r3 = r5.f13711h;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0057;
    L_0x0035:
        r2 = r4.f13712i;
        r3 = r5.f13712i;
        if (r2 != r3) goto L_0x0057;
    L_0x003b:
        r2 = r4.f13713j;
        r3 = r5.f13713j;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0057;
    L_0x0045:
        r2 = r4.f13714k;
        if (r2 != 0) goto L_0x0059;
    L_0x0049:
        r2 = r5.f13714k;
        if (r2 != 0) goto L_0x0057;
    L_0x004d:
        r2 = r4.f13715l;
        r3 = r5.f13715l;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0004;
    L_0x0057:
        r0 = r1;
        goto L_0x0004;
    L_0x0059:
        r2 = r4.f13714k;
        r3 = r5.f13714k;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0057;
    L_0x0063:
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessToken.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return (((this.f13714k == null ? 0 : this.f13714k.hashCode()) + ((((((((((((this.f13708e.hashCode() + 527) * 31) + this.f13709f.hashCode()) * 31) + this.f13710g.hashCode()) * 31) + this.f13711h.hashCode()) * 31) + this.f13712i.hashCode()) * 31) + this.f13713j.hashCode()) * 31)) * 31) + this.f13715l.hashCode();
    }

    static AccessToken m14005a(Bundle bundle) {
        Collection a = m14007a(bundle, "com.facebook.TokenCachingStrategy.Permissions");
        Collection a2 = m14007a(bundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
        String d = LegacyTokenHelper.m14128d(bundle);
        if (Utility.m25345a(d)) {
            d = FacebookSdk.m14053i();
        }
        String b = LegacyTokenHelper.m14126b(bundle);
        try {
            return new AccessToken(b, d, Utility.m25356d(b).getString("id"), a, a2, LegacyTokenHelper.m14127c(bundle), LegacyTokenHelper.m14124a(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), LegacyTokenHelper.m14124a(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"));
        } catch (JSONException e) {
            return null;
        }
    }

    private static List<String> m14007a(Bundle bundle, String str) {
        Collection stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(stringArrayList));
    }

    final JSONObject m14015j() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.f13711h);
        jSONObject.put("expires_at", this.f13708e.getTime());
        jSONObject.put("permissions", new JSONArray(this.f13709f));
        jSONObject.put("declined_permissions", new JSONArray(this.f13710g));
        jSONObject.put("last_refresh", this.f13713j.getTime());
        jSONObject.put("source", this.f13712i.name());
        jSONObject.put("application_id", this.f13714k);
        jSONObject.put("user_id", this.f13715l);
        return jSONObject;
    }

    static AccessToken m14006a(JSONObject jSONObject) {
        if (jSONObject.getInt("version") > 1) {
            throw new FacebookException("Unknown AccessToken serialization format.");
        }
        String string = jSONObject.getString("token");
        Date date = new Date(jSONObject.getLong("expires_at"));
        JSONArray jSONArray = jSONObject.getJSONArray("permissions");
        JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
        Date date2 = new Date(jSONObject.getLong("last_refresh"));
        return new AccessToken(string, jSONObject.getString("application_id"), jSONObject.getString("user_id"), Utility.m25332a(jSONArray), Utility.m25332a(jSONArray2), AccessTokenSource.valueOf(jSONObject.getString("source")), date, date2);
    }

    AccessToken(Parcel parcel) {
        this.f13708e = new Date(parcel.readLong());
        Collection arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.f13709f = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.f13710g = Collections.unmodifiableSet(new HashSet(arrayList));
        this.f13711h = parcel.readString();
        this.f13712i = AccessTokenSource.valueOf(parcel.readString());
        this.f13713j = new Date(parcel.readLong());
        this.f13714k = parcel.readString();
        this.f13715l = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f13708e.getTime());
        parcel.writeStringList(new ArrayList(this.f13709f));
        parcel.writeStringList(new ArrayList(this.f13710g));
        parcel.writeString(this.f13711h);
        parcel.writeString(this.f13712i.name());
        parcel.writeLong(this.f13713j.getTime());
        parcel.writeString(this.f13714k);
        parcel.writeString(this.f13715l);
    }
}
