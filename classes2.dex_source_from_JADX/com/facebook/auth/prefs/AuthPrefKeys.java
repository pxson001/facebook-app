package com.facebook.auth.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: time_changed_event */
public class AuthPrefKeys {
    public static final PrefKey f2946a;
    public static final PrefKey f2947b;
    public static final PrefKey f2948c;
    public static final PrefKey f2949d = ((PrefKey) f2947b.m2011a("fb_token"));
    public static final PrefKey f2950e = ((PrefKey) f2947b.m2011a("fb_session_cookies_string"));
    public static final PrefKey f2951f = ((PrefKey) f2946a.m2011a("auth_machine_id"));
    public static final PrefKey f2952g = ((PrefKey) f2947b.m2011a("fb_session_secret"));
    public static final PrefKey f2953h = ((PrefKey) f2947b.m2011a("fb_session_key"));
    public static final PrefKey f2954i = ((PrefKey) f2947b.m2011a("fb_username"));
    public static final PrefKey f2955j = ((PrefKey) f2947b.m2011a("in_login_flow"));
    public static final PrefKey f2956k = ((PrefKey) f2946a.m2011a("auth_device_based_login_credentials"));
    public static final PrefKey f2957l = ((PrefKey) f2946a.m2011a("dbl_nux_counter"));
    public static final PrefKey f2958m = ((PrefKey) f2946a.m2011a("dbl_nux_last_shown_ts"));
    public static final PrefKey f2959n = ((PrefKey) f2946a.m2011a("dbl_last_shown_nux"));
    public static final PrefKey f2960o = ((PrefKey) f2946a.m2011a("dbl_nux_cooldown_factor"));
    public static final PrefKey f2961p = ((PrefKey) f2946a.m2011a("fb_show_dbl_change_passcode"));
    @Deprecated
    public static final PrefKey f2962q = ((PrefKey) f2947b.m2011a("fb_me_user"));
    @Deprecated
    public static final PrefKey f2963r = ((PrefKey) f2946a.m2011a("me_user_version"));
    public static final PrefKey f2964s = ((PrefKey) SharedPrefKeys.f991e.m2011a("logged_in_after_last_auth"));
    public static final PrefKey f2965t = ((PrefKey) SharedPrefKeys.f991e.m2011a("fb_sign_verification"));
    public static final PrefKey f2966u = ((PrefKey) f2946a.m2011a("password_account_eligibility_counter"));
    public static final PrefKey f2967v = ((PrefKey) f2946a.m2011a("dbl_password_account_credentials"));
    public static final PrefKey f2968w = ((PrefKey) f2946a.m2011a("account_switch_in_progress"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("auth/");
        f2946a = prefKey;
        prefKey = (PrefKey) prefKey.m2011a("user_data/");
        f2947b = prefKey;
        f2948c = (PrefKey) prefKey.m2011a("fb_uid");
    }
}
