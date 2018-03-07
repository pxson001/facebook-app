package com.facebook.oxygen.preloads.sdk.firstparty.settings;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.oxygen.preloads.sdk.build.SdkBuildConstants;

/* compiled from: terms_of_service_accepted */
public class FirstPartySettingsContract {
    public static final String f1107a;
    public static final String f1108b = (f1107a + ".firstparty.settings");
    public static final Uri f1109c = new Builder().scheme("content").authority(f1108b).build();

    /* compiled from: terms_of_service_accepted */
    public class SettingsTable {
        public static String f1101a = "package_name";
        public static String f1102b = "auto_updates";
        public static String f1103c = "notif_update_available";
        public static String f1104d = "notif_update_installed";
        public static String f1105e = "rollout_token";
        public static String f1106f = "terms_of_service_accepted";
    }

    static {
        String str;
        if (SdkBuildConstants.a) {
            str = "com.facebook.appmanager.dev";
        } else {
            str = "com.facebook.appmanager";
        }
        f1107a = str;
    }

    public static Uri m1428a(String str) {
        return f1109c.buildUpon().appendPath("package").appendPath(str).build();
    }
}
