package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.facebook.appevents.AppEventsLogger;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: video_list_entries_per_fetch */
public class LoginLogger {
    public final AppEventsLogger f234a;
    public String f235b;
    private String f236c;

    LoginLogger(Context context, String str) {
        this.f235b = str;
        this.f234a = AppEventsLogger.a(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                PackageInfo packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0);
                if (packageInfo != null) {
                    this.f236c = packageInfo.versionName;
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    public static Bundle m263a(String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", str);
        bundle.putString("3_method", "");
        bundle.putString("2_result", "");
        bundle.putString("5_error_message", "");
        bundle.putString("4_error_code", "");
        bundle.putString("6_extras", "");
        return bundle;
    }

    public final void m264a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Bundle a = m263a(str);
        if (str3 != null) {
            a.putString("2_result", str3);
        }
        if (str4 != null) {
            a.putString("5_error_message", str4);
        }
        if (str5 != null) {
            a.putString("4_error_code", str5);
        }
        if (!(map == null || map.isEmpty())) {
            a.putString("6_extras", new JSONObject(map).toString());
        }
        a.putString("3_method", str2);
        this.f234a.a("fb_mobile_login_method_complete", null, a);
    }
}
