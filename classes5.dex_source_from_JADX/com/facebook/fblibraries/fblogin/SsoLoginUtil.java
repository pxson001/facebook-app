package com.facebook.fblibraries.fblogin;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.DeadObjectException;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;
import libraries.debug.log.BLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: review_context */
public class SsoLoginUtil {
    private final ContentResolver f2975a;
    private final List<String> f2976b;

    public SsoLoginUtil(ContentResolver contentResolver, List<String> list) {
        this.f2975a = contentResolver;
        this.f2976b = list;
    }

    public final FirstPartySsoSessionInfo m4153a(Context context) {
        for (String a : this.f2976b) {
            FirstPartySsoSessionInfo a2 = m4149a(context, a);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    private FirstPartySsoSessionInfo m4149a(Context context, String str) {
        if (m4151b(context, str)) {
            try {
                Object a = m4150a(str);
                if (TextUtils.isEmpty(a)) {
                    BLog.m13854b("SSO", "sso session information from %s is empty!", str);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(a);
                JSONObject jSONObject2 = jSONObject.getJSONObject("profile");
                if (jSONObject2.has("uid") && jSONObject2.has("name") && jSONObject.has("access_token")) {
                    String string;
                    String string2 = jSONObject2.getString("uid");
                    String string3 = jSONObject2.getString("name");
                    String string4 = jSONObject.getString("access_token");
                    try {
                        string = jSONObject.getString("username");
                    } catch (JSONException e) {
                        string = string2;
                    }
                    return new FirstPartySsoSessionInfo(string2, string3, string4, string);
                }
                BLog.m13854b("SSO", "%s session information is malformed", str);
                return null;
            } catch (Throwable th) {
                BLog.m13852a("SSO", "Exception occurred while resolving sso session from " + str, th);
                return null;
            }
        }
        BLog.m13854b("SSO", "%s has no matching signatures", str);
        return null;
    }

    private boolean m4151b(Context context, String str) {
        ApplicationInfo c = m4152c(context, context.getPackageName());
        ApplicationInfo c2 = m4152c(context, str);
        if (c == null) {
            String str2 = "SSO";
            String str3 = "No appinfo found for the current application.";
            if (BLog.f7687b > 6 || BLog.f7686a != null) {
                return false;
            }
            Log.e(str2, str3);
            return false;
        } else if (c2 == null) {
            BLog.m13853a("SSO", "No appinfo found for %s", str);
            return false;
        } else {
            int i = c.uid;
            int i2 = c2.uid;
            if (i == i2 || context.getPackageManager().checkSignatures(i, i2) == 0) {
                return true;
            }
            return false;
        }
    }

    private static ApplicationInfo m4152c(Context context, String str) {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 64);
        } catch (NameNotFoundException e) {
        } catch (RuntimeException e2) {
            if (!(e2.getCause() instanceof DeadObjectException)) {
                throw e2;
            }
        }
        return applicationInfo;
    }

    private String m4150a(String str) {
        String str2 = null;
        BLog.m13851a("SSO", "Using content provider URI for %s", (Object) str);
        Uri parse = Uri.parse("content://" + str + ".provider.UserValuesProvider/user_values");
        Cursor query = this.f2975a.query(parse, new String[]{"name", "value"}, "name='active_session_info'", null, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    str2 = query.getString(1);
                    BLog.m13851a("SSO", "%s session data obtained", (Object) str);
                    if (query != null) {
                        query.close();
                    }
                    return str2;
                }
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
            }
        }
        BLog.m13853a("SSO", "%s content provider has no session entry.", str);
        if (query != null) {
            query.close();
        }
        return str2;
    }
}
