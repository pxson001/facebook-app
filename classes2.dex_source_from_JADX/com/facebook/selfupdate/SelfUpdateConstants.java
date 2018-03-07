package com.facebook.selfupdate;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: reaction_android_external_share */
public class SelfUpdateConstants {
    public static final PrefKey f8160A = ((PrefKey) f8166a.m2011a("foreground_size"));
    public static final PrefKey f8161B = ((PrefKey) f8166a.m2011a("foreground_release_notes"));
    public static final PrefKey f8162C = ((PrefKey) f8166a.m2011a("foreground_source"));
    public static final PrefKey f8163D = ((PrefKey) f8166a.m2011a("allow_on_local_builds"));
    public static final PrefKey f8164E = ((PrefKey) f8166a.m2011a("source_override"));
    public static final PrefKey f8165F = ((PrefKey) f8166a.m2011a("launch_interval"));
    public static final PrefKey f8166a;
    public static final PrefKey f8167b;
    public static final PrefKey f8168c = ((PrefKey) f8166a.m2011a("schedule_interval"));
    public static final PrefKey f8169d = ((PrefKey) f8166a.m2011a("new_build"));
    public static final PrefKey f8170e = ((PrefKey) f8166a.m2011a("new_build_url"));
    public static final PrefKey f8171f = ((PrefKey) f8166a.m2011a("new_version_notes"));
    public static final PrefKey f8172g = ((PrefKey) f8166a.m2011a("download_id"));
    public static final PrefKey f8173h = ((PrefKey) f8166a.m2011a("local_file"));
    public static final PrefKey f8174i = ((PrefKey) f8166a.m2011a("hard_nag"));
    public static final PrefKey f8175j = ((PrefKey) f8166a.m2011a("app_name"));
    public static final PrefKey f8176k = ((PrefKey) f8166a.m2011a("app_version"));
    public static final PrefKey f8177l = ((PrefKey) f8166a.m2011a("postponed_build"));
    public static final PrefKey f8178m = ((PrefKey) f8166a.m2011a("postponed_until"));
    public static final PrefKey f8179n = ((PrefKey) f8166a.m2011a("download_status"));
    public static final PrefKey f8180o = ((PrefKey) f8166a.m2011a("megaphone"));
    public static final PrefKey f8181p = ((PrefKey) f8166a.m2011a("mimetype"));
    public static final PrefKey f8182q = ((PrefKey) f8166a.m2011a("file_size"));
    public static final PrefKey f8183r = ((PrefKey) f8166a.m2011a("apk_source"));
    public static final PrefKey f8184s = ((PrefKey) f8166a.m2011a("use_oxygen_for_internal"));
    public static final PrefKey f8185t = ((PrefKey) f8166a.m2011a("show_debug_info"));
    public static final PrefKey f8186u = ((PrefKey) f8166a.m2011a("foreground_last_fetched"));
    public static final PrefKey f8187v = ((PrefKey) f8166a.m2011a("foreground_fetch_interval"));
    public static final PrefKey f8188w = ((PrefKey) f8166a.m2011a("foreground_package_name"));
    public static final PrefKey f8189x = ((PrefKey) f8166a.m2011a("foreground_url"));
    public static final PrefKey f8190y = ((PrefKey) f8166a.m2011a("foreground_version_code"));
    public static final PrefKey f8191z = ((PrefKey) f8166a.m2011a("foreground_version_name"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("selfupdate/");
        f8166a = prefKey;
        f8167b = (PrefKey) prefKey.m2011a("scheduled_time");
    }

    public static String m12702a(int i) {
        switch (i) {
            case 0:
                return "DOWNLOAD_STATUS_NOT_STARTED";
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "DOWNLOAD_STATUS_STARTED";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "DOWNLOAD_STATUS_COMPLETED";
            default:
                return "UNKNOWN(" + i + ")";
        }
    }
}
