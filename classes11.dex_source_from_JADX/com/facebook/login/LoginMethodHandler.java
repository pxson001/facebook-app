package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient.Request;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: viewer_non_rated_count */
public abstract class LoginMethodHandler implements Parcelable {
    Map<String, String> f198a;
    public LoginClient f199b;

    abstract boolean mo1a(Request request);

    abstract String mo2c();

    LoginMethodHandler(LoginClient loginClient) {
        this.f199b = loginClient;
    }

    LoginMethodHandler(Parcel parcel) {
        this.f198a = Utility.a(parcel);
    }

    final void m206a(LoginClient loginClient) {
        if (this.f199b != null) {
            throw new FacebookException("Can't set LoginClient if it is already set.");
        }
        this.f199b = loginClient;
    }

    public boolean mo4a(int i, Intent intent) {
        return false;
    }

    boolean mo5d() {
        return false;
    }

    public void mo3a() {
    }

    public final void m208a(String str, Object obj) {
        if (this.f198a == null) {
            this.f198a = new HashMap();
        }
        this.f198a.put(str, obj == null ? null : obj.toString());
    }

    protected final void m207a(String str) {
        String str2 = this.f199b.f225g.f210d;
        AppEventsLogger a = AppEventsLogger.a(this.f199b.m250b(), str2);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", str);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString("app_id", str2);
        a.a("fb_dialogs_web_login_dialog_complete", null, bundle);
    }

    public static AccessToken m203a(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        Collection collection2;
        Date a = Utility.a(bundle, "expires_in", new Date());
        String string = bundle.getString("access_token");
        String string2 = bundle.getString("granted_scopes");
        if (Utility.a(string2)) {
            Collection<String> collection3 = collection;
        } else {
            Collection arrayList = new ArrayList(Arrays.asList(string2.split(",")));
        }
        string2 = bundle.getString("denied_scopes");
        if (Utility.a(string2)) {
            collection2 = null;
        } else {
            collection2 = new ArrayList(Arrays.asList(string2.split(",")));
        }
        if (Utility.a(string)) {
            return null;
        }
        return new AccessToken(string, str, m204b(bundle.getString("signed_request")), arrayList, collection2, accessTokenSource, a, new Date());
    }

    private static String m204b(String str) {
        if (str == null || str.isEmpty()) {
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
        try {
            String[] split = str.split("\\.");
            if (split.length == 2) {
                return new JSONObject(new String(Base64.decode(split[1], 0), "UTF-8")).getString("user_id");
            }
        } catch (UnsupportedEncodingException e) {
        } catch (JSONException e2) {
        }
        throw new FacebookException("Failed to retrieve user_id from signed_request");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Utility.a(parcel, this.f198a);
    }
}
