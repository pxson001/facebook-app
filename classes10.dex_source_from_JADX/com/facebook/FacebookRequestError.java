package com.facebook;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: eventWallPhoto */
public final class FacebookRequestError {
    static final Range f13747a = new Range(200, 299);
    private final Category f13748b;
    public final int f13749c;
    public final int f13750d;
    private final int f13751e;
    public final String f13752f;
    private final String f13753g;
    private final String f13754h;
    private final String f13755i;
    private final String f13756j;
    private final JSONObject f13757k;
    private final JSONObject f13758l;
    private final Object f13759m;
    private final HttpURLConnection f13760n;
    public final FacebookException f13761o;

    /* compiled from: eventWallPhoto */
    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    /* compiled from: eventWallPhoto */
    class Range {
        private final int f13745a;
        private final int f13746b;

        public Range(int i, int i2) {
            this.f13745a = i;
            this.f13746b = i2;
        }

        final boolean m14037a(int i) {
            return this.f13745a <= i && i <= this.f13746b;
        }
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        this.f13749c = i;
        this.f13750d = i2;
        this.f13751e = i3;
        this.f13752f = str;
        this.f13753g = str2;
        this.f13758l = jSONObject;
        this.f13757k = jSONObject2;
        this.f13759m = obj;
        this.f13760n = httpURLConnection;
        this.f13754h = str3;
        this.f13755i = str4;
        Object obj2 = null;
        if (facebookException != null) {
            this.f13761o = facebookException;
            obj2 = 1;
        } else {
            this.f13761o = new FacebookServiceException(this, str2);
        }
        FacebookRequestErrorClassification f = m14039f();
        this.f13748b = obj2 != null ? Category.OTHER : f.m25264a(i2, i3, z);
        this.f13756j = f.m25265a(this.f13748b);
    }

    FacebookRequestError(HttpURLConnection httpURLConnection, Exception exception) {
        FacebookException facebookException;
        if (exception instanceof FacebookException) {
            facebookException = (FacebookException) exception;
        } else {
            facebookException = new FacebookException((Throwable) exception);
        }
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, facebookException);
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    public final int m14040b() {
        return this.f13750d;
    }

    public final String m14041d() {
        if (this.f13753g != null) {
            return this.f13753g;
        }
        return this.f13761o.getLocalizedMessage();
    }

    public final FacebookException m14042e() {
        return this.f13761o;
    }

    public final String toString() {
        return "{HttpStatus: " + this.f13749c + ", errorCode: " + this.f13750d + ", errorType: " + this.f13752f + ", errorMessage: " + m14041d() + "}";
    }

    static FacebookRequestError m14038a(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        try {
            if (jSONObject.has("code")) {
                JSONObject jSONObject2;
                int i = jSONObject.getInt("code");
                Object a = Utility.m25322a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                if (a != null && (a instanceof JSONObject)) {
                    jSONObject2 = (JSONObject) a;
                    String str = null;
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    boolean z = false;
                    int i2 = 0;
                    int i3 = 0;
                    Object obj2 = null;
                    if (jSONObject2.has("error")) {
                        JSONObject jSONObject3 = (JSONObject) Utility.m25322a(jSONObject2, "error", null);
                        str = jSONObject3.optString("type", null);
                        str2 = jSONObject3.optString("message", null);
                        i2 = jSONObject3.optInt("code", -1);
                        i3 = jSONObject3.optInt("error_subcode", -1);
                        str3 = jSONObject3.optString("error_user_msg", null);
                        str4 = jSONObject3.optString("error_user_title", null);
                        z = jSONObject3.optBoolean("is_transient", false);
                        obj2 = 1;
                    } else if (jSONObject2.has("error_code") || jSONObject2.has("error_msg") || jSONObject2.has("error_reason")) {
                        str = jSONObject2.optString("error_reason", null);
                        str2 = jSONObject2.optString("error_msg", null);
                        i2 = jSONObject2.optInt("error_code", -1);
                        i3 = jSONObject2.optInt("error_subcode", -1);
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        return new FacebookRequestError(i, i2, i3, str, str2, str4, str3, z, jSONObject2, jSONObject, obj, httpURLConnection, null);
                    }
                }
                if (!f13747a.m14037a(i)) {
                    if (jSONObject.has("body")) {
                        jSONObject2 = (JSONObject) Utility.m25322a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                    } else {
                        jSONObject2 = null;
                    }
                    return new FacebookRequestError(i, -1, -1, null, null, null, null, false, jSONObject2, jSONObject, obj, httpURLConnection, null);
                }
            }
        } catch (JSONException e) {
        }
        return null;
    }

    private static synchronized FacebookRequestErrorClassification m14039f() {
        FacebookRequestErrorClassification a;
        synchronized (FacebookRequestError.class) {
            FetchedAppSettings c = Utility.m25353c(FacebookSdk.m14053i());
            if (c == null) {
                a = FacebookRequestErrorClassification.m25260a();
            } else {
                a = c.m25312b();
            }
        }
        return a;
    }
}
