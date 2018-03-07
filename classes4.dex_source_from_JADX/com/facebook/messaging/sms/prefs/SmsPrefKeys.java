package com.facebook.messaging.sms.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: drafts */
public class SmsPrefKeys {
    public static final PrefKey f13563A = ((PrefKey) f13578a.a("sms_is_default_app_for_tracking"));
    public static final PrefKey f13564B = ((PrefKey) f13578a.a("messenger_been_sms_default_app"));
    public static final PrefKey f13565C = ((PrefKey) f13578a.a("sms_internal_force_nux"));
    public static final PrefKey f13566D = ((PrefKey) f13578a.a("sms_internal_no_readonly_notification"));
    public static final PrefKey f13567E = ((PrefKey) f13578a.a("sms_readonly_mode_in_thread_banner_disabled"));
    public static final PrefKey f13568F = ((PrefKey) f13578a.a("sms_recent_ro2f_qp_disabled"));
    public static final PrefKey f13569G = ((PrefKey) f13578a.a("sms_full_qp_disabled"));
    public static final PrefKey f13570H = ((PrefKey) f13578a.a("sms_is_default_app_for_settings_ui"));
    public static final PrefKey f13571I = ((PrefKey) f13578a.a("sms_hide_inbox_filter"));
    public static final PrefKey f13572J = ((PrefKey) f13577O.a("sms_auto_retrieve"));
    public static final PrefKey f13573K = ((PrefKey) f13577O.a("sms_auto_retrieve_roaming"));
    public static final PrefKey f13574L = ((PrefKey) f13577O.a("sms_fallback_number"));
    public static final PrefKey f13575M = ((PrefKey) f13577O.a("sms_internal_force_legacy_api"));
    public static final PrefKey f13576N = ((PrefKey) f13577O.a("sms_debug_msg_errors/"));
    private static final PrefKey f13577O;
    public static final PrefKey f13578a;
    public static final PrefKey f13579b;
    public static final PrefKey f13580c = ((PrefKey) f13578a.a("sms_readonly_set_time"));
    public static final PrefKey f13581d = ((PrefKey) f13578a.a("sms_in_anonymous_row_mode"));
    public static final PrefKey f13582e = ((PrefKey) f13578a.a("sms_anonymous_promo_set_time"));
    public static final PrefKey f13583f = ((PrefKey) f13578a.a("sms_last_anonymous_chathead_time"));
    public static final PrefKey f13584g = ((PrefKey) f13578a.a("sms_anonymous_chathead_impression_count"));
    public static final PrefKey f13585h = ((PrefKey) f13578a.a("sms_anonymous_chathead_impression_count_today"));
    public static final PrefKey f13586i = ((PrefKey) f13578a.a("sms_anonymous_chathead_rate_limit"));
    public static final PrefKey f13587j = ((PrefKey) f13578a.a("sms_newest_received_thread_id"));
    public static final PrefKey f13588k = ((PrefKey) f13578a.a("sms_anonymous_promo_ignore_delay"));
    public static final PrefKey f13589l = ((PrefKey) f13578a.a("sms_anonymous_promo_row_seen_today"));
    public static final PrefKey f13590m = ((PrefKey) f13578a.a("call_log_upsell_seen_today"));
    public static final PrefKey f13591n = ((PrefKey) f13578a.a("sms_log_upsell_seen_today"));
    public static final PrefKey f13592o = ((PrefKey) f13578a.a("sms_permanent_contact_search_loaded_today"));
    public static final PrefKey f13593p = ((PrefKey) f13578a.a("sms_permanent_contact_null_state_loaded_today"));
    public static final PrefKey f13594q = ((PrefKey) f13578a.a("sms_permanent_contact_people_tab_loaded_today"));
    public static final PrefKey f13595r = ((PrefKey) f13578a.a("sms_promo_seen"));
    public static final PrefKey f13596s = ((PrefKey) f13578a.a("sms_nux_complete"));
    public static final PrefKey f13597t = ((PrefKey) f13578a.a("sms_nux_v2_seen"));
    public static final PrefKey f13598u = ((PrefKey) f13578a.a("sms_initial_enroll_time"));
    public static final PrefKey f13599v = ((PrefKey) f13578a.a("sms_nux_v2_seen_time"));
    public static final PrefKey f13600w = ((PrefKey) f13578a.a("sms_nux_blocks"));
    public static final PrefKey f13601x = ((PrefKey) f13578a.a("sms_interstitial_seen"));
    public static final PrefKey f13602y = ((PrefKey) f13578a.a("sms_device_status_reported"));
    public static final PrefKey f13603z = ((PrefKey) f13578a.a("sms_is_enabled_for_tracking"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.c.a("sms_integration/");
        f13577O = prefKey;
        prefKey = (PrefKey) prefKey.a("defaultapp/");
        f13578a = prefKey;
        f13579b = (PrefKey) prefKey.a("sms_in_readonly_mode");
    }
}
