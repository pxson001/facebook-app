package com.facebook.rtc.fbwebrtc;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: audio-message- */
public class WebrtcPrefKeys {
    public static final PrefKey f19400a;
    public static final PrefKey f19401b;
    public static final PrefKey f19402c = ((PrefKey) f19400a.a("free_call_acceptance"));
    public static final PrefKey f19403d = ((PrefKey) f19400a.a("ringtone_toast_qe"));
    public static final PrefKey f19404e = ((PrefKey) f19400a.a("chat_head_nux_message_top_button"));
    public static final PrefKey f19405f = ((PrefKey) f19400a.a("chat_head_nux_message_button"));
    public static final PrefKey f19406g = ((PrefKey) f19400a.a("chat_head_nux_message_go_home"));
    public static final PrefKey f19407h = ((PrefKey) f19400a.a("chat_head_nux"));
    public static final PrefKey f19408i = ((PrefKey) f19400a.a("chat_head_nux_recangular_vch"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.d.a("webrtc/");
        f19400a = prefKey;
        f19401b = (PrefKey) prefKey.a("last_call_volume");
    }
}
