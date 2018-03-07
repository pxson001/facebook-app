package com.facebook.rtc.prefs;

import android.net.Uri;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: application/vnd.android.package-archive */
public class VoipPrefKeys {
    public static final PrefKey f19914a;
    public static final PrefKey f19915b;
    public static final PrefKey f19916c;
    public static final PrefKey f19917d = ((PrefKey) f19915b.a("voip_ringtone_uri"));
    public static final PrefKey f19918e = ((PrefKey) f19914a.a("voip_shortcut_nux"));
    public static final PrefKey f19919f = ((PrefKey) f19914a.a("rtc_ringtone_level"));
    public static final PrefKey f19920g = ((PrefKey) f19914a.a("rtc_one_on_one_over_multiway"));
    public static final PrefKey f19921h = ((PrefKey) f19914a.a("rtc_instant_button_nux"));
    public static final PrefKey f19922i = ((PrefKey) f19914a.a("rtc_instant_button_nux_chat_head"));
    public static final PrefKey f19923j = ((PrefKey) f19914a.a("rtc_video_copresence_nux"));
    public static final PrefKey f19924k = ((PrefKey) f19914a.a("rtc_video_copresence_nux_chat_head"));
    public static final PrefKey f19925l = ((PrefKey) f19914a.a("rtc_group_call_nux"));
    public static final PrefKey f19926m = ((PrefKey) f19915b.a("threads/"));
    public static final PrefKey f19927n = ((PrefKey) f19914a.a("rtc_free_international_call_promoted"));
    public static final PrefKey f19928o = ((PrefKey) f19914a.a("rtc_is_traveling_internationall"));
    public static final PrefKey f19929p = ((PrefKey) f19926m.a("custom/"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.c.a("messages/");
        f19914a = prefKey;
        prefKey = (PrefKey) prefKey.a("notifications/");
        f19915b = prefKey;
        f19916c = (PrefKey) prefKey.a("voip_vibrate_enabled");
    }

    public static PrefKey m19618a(Long l) {
        return (PrefKey) ((PrefKey) f19926m.a(Uri.encode(Long.toString(l.longValue())))).a("/thread_voip_vibrate_enabled");
    }
}
