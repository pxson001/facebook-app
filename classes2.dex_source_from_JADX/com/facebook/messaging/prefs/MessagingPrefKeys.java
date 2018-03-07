package com.facebook.messaging.prefs;

import android.net.Uri;
import com.facebook.messaging.chatheads.prefs.ChatHeadsPrefKeys;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: title_bar_secondary_button_spec */
public class MessagingPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f2537A = ((PrefKey) f2564b.m2011a("platform_user_accepted_reply_dialog_key"));
    public static final PrefKey f2538B = ((PrefKey) f2564b.m2011a("platform_last_time_reply_dialog_seen"));
    public static final PrefKey f2539C = ((PrefKey) f2564b.m2011a("platform_show_reply_dialog_wait_interval_days"));
    public static final PrefKey f2540D;
    public static final PrefKey f2541E;
    public static final PrefKey f2542F = ((PrefKey) f2540D.m2011a("muted_until2"));
    public static final PrefKey f2543G = ((PrefKey) f2540D.m2011a("sound_enabled"));
    public static final PrefKey f2544H = ((PrefKey) f2540D.m2011a("in_app_sounds_enabled"));
    public static final PrefKey f2545I = ((PrefKey) f2540D.m2011a("vibrate_enabled"));
    public static final PrefKey f2546J = ((PrefKey) f2540D.m2011a("led_enabled"));
    @Deprecated
    public static final PrefKey f2547K = ((PrefKey) f2540D.m2011a("ringtone_uri"));
    public static final PrefKey f2548L = ((PrefKey) f2540D.m2011a("ringtone_uri2"));
    public static final PrefKey f2549M = ((PrefKey) f2540D.m2011a("preview"));
    @Deprecated
    public static final PrefKey f2550N = ((PrefKey) f2540D.m2011a("use_system_sound"));
    public static final PrefKey f2551O = ((PrefKey) f2566d.m2011a("converted_prefs_to_threadkey"));
    public static final PrefKey f2552P = ((PrefKey) f2566d.m2011a("threads/"));
    public static final PrefKey f2553Q = ((PrefKey) f2566d.m2011a("group_threads/"));
    public static final PrefKey f2554R = ((PrefKey) f2552P.m2011a("/num_shortcut_banner_shown"));
    public static final PrefKey f2555S = ((PrefKey) f2566d.m2011a("canonical_recipients/"));
    public static final PrefKey f2556T;
    public static final PrefKey f2557U;
    public static final PrefKey f2558V;
    public static final PrefKey f2559W = ((PrefKey) f2565c.m2011a("notifications/recent_threads/"));
    public static final PrefKey f2560X = ((PrefKey) ChatHeadsPrefKeys.f2594f.m2011a("/chat_heads_hide_on_fullscreen"));
    public static final PrefKey f2561Y;
    public static final PrefKey f2562Z;
    public static final PrefKey f2563a = ((PrefKey) SharedPrefKeys.f987a.m2011a("messenger/"));
    public static final PrefKey aA = ((PrefKey) ay.m2011a("previously_enabled"));
    public static final PrefKey aB = ((PrefKey) ay.m2011a("last_notif_time"));
    public static final PrefKey aC = ((PrefKey) ay.m2011a("thread_suggestion/"));
    public static final PrefKey aD = ((PrefKey) ay.m2011a("optimistic_scan_count"));
    public static final PrefKey aE = ((PrefKey) ay.m2011a("optimistic_scan_successful_count"));
    public static final PrefKey aF = ((PrefKey) ay.m2011a("optimistic_scan_initial_start_time_ms"));
    public static final PrefKey aG = ((PrefKey) ay.m2011a("optimistic_scan_cumulative_processing_time_ms"));
    public static final PrefKey aH = ((PrefKey) ay.m2011a("optimistic_scan_finish_time_ms"));
    public static final PrefKey aI = ((PrefKey) ay.m2011a("optimistic_scan_debug_mode"));
    public static final PrefKey aJ = ((PrefKey) ay.m2011a("nux_shown_count"));
    public static final PrefKey aK = ((PrefKey) ay.m2011a("nux_last_shown_time_ms"));
    public static final PrefKey aL = ((PrefKey) ay.m2011a("nux_admit_time_ms"));
    public static final PrefKey aM = ((PrefKey) ay.m2011a("media_tray_nux_action_count"));
    public static final PrefKey aN = ((PrefKey) ay.m2011a("media_tray_nux_exposure_count"));
    public static final PrefKey aO = ((PrefKey) ay.m2011a("media_tray_nux_last_shown_time_ms"));
    public static final PrefKey aP = ((PrefKey) ay.m2011a("use_color_crops"));
    public static final PrefKey aQ = ((PrefKey) f2565c.m2011a("last_send_failure_captive_portal_notified_ms"));
    public static final PrefKey aR = ((PrefKey) f2565c.m2011a("last_send_failure_long_queued_message_last_notified_ms"));
    public static final PrefKey aS = ((PrefKey) f2565c.m2011a("last_send_failure_backround_data_restriction_last_notified_ms"));
    public static final PrefKey aT = ((PrefKey) f2565c.m2011a("last_ssl_dialg_ms"));
    public static final PrefKey aU = ((PrefKey) f2563a.m2011a("inbox_has_top_unit"));
    public static final PrefKey aa = ((PrefKey) SharedPrefKeys.f989c.m2011a("online_availablity_for_ui"));
    public static final PrefKey ab;
    public static final PrefKey ac;
    public static final PrefKey ad = ((PrefKey) f2565c.m2011a("neue_nux/"));
    public static final PrefKey ae = ((PrefKey) f2565c.m2011a("show_voip_nux_banner2"));
    public static final PrefKey af = ((PrefKey) f2565c.m2011a("should_show_shortcut_banner"));
    public static final PrefKey ag = ((PrefKey) ad.m2011a("show_blue_messenger_badge_nux"));
    public static final PrefKey ah = ((PrefKey) ad.m2011a("show_grey_facebook_badge_nux"));
    public static final PrefKey ai;
    public static final PrefKey aj;
    public static final PrefKey ak = ((PrefKey) ai.m2011a("show_nux"));
    public static final PrefKey al;
    public static final PrefKey am;
    public static final PrefKey an = ((PrefKey) f2565c.m2011a("confirm_delete_sms_thread"));
    public static final PrefKey ao = ((PrefKey) f2565c.m2011a("quickcam_videos_taken"));
    public static final PrefKey ap = ((PrefKey) f2565c.m2011a("quickcam_photos_taken"));
    public static final PrefKey aq = ((PrefKey) f2565c.m2011a("audio_recording_first_time_press"));
    public static final PrefKey ar = ((PrefKey) f2565c.m2011a("hot_like_has_seen_nux_bubble"));
    public static final PrefKey as = ((PrefKey) f2565c.m2011a("hot_like_has_sent_larger_like"));
    public static final PrefKey at = ((PrefKey) f2565c.m2011a("wear_connected_nodes"));
    public static final PrefKey au = ((PrefKey) f2565c.m2011a("messages_collection_size_logged_timestamp_ms"));
    public static final PrefKey av = ((PrefKey) f2565c.m2011a("server_muted_until"));
    public static final PrefKey aw = ((PrefKey) f2565c.m2011a("num_threads_in_threadlist"));
    public static final PrefKey ax = ((PrefKey) f2566d.m2011a("auto_add_notice_shown"));
    public static final PrefKey ay;
    public static final PrefKey az;
    public static final PrefKey f2564b = ((PrefKey) SharedPrefKeys.f990d.m2011a("neue/"));
    public static final PrefKey f2565c = ((PrefKey) SharedPrefKeys.f987a.m2011a("messages/"));
    public static final PrefKey f2566d = ((PrefKey) SharedPrefKeys.f989c.m2011a("messages/"));
    public static final PrefKey f2567e = ((PrefKey) f2563a.m2011a("first_install_time"));
    public static final PrefKey f2568f = ((PrefKey) f2563a.m2011a("nux_completed"));
    public static final PrefKey f2569g;
    public static final PrefKey f2570h;
    public static final PrefKey f2571i = ((PrefKey) f2569g.m2011a("chat_head_close_nux_completed"));
    public static final PrefKey f2572j = ((PrefKey) f2569g.m2011a("message_requests_settings_entry_nux_shown"));
    public static final PrefKey f2573k = ((PrefKey) f2563a.m2011a("phone_confirm/"));
    public static final PrefKey f2574l = ((PrefKey) f2563a.m2011a("app_icon_badge"));
    public static final PrefKey f2575m;
    public static final PrefKey f2576n;
    public static final PrefKey f2577o = ((PrefKey) f2564b.m2011a("confirmation_code_request_time"));
    public static final PrefKey f2578p = ((PrefKey) f2564b.m2011a("phone_need_reconfirmation"));
    public static final PrefKey f2579q = ((PrefKey) f2564b.m2011a("phone_confirmed"));
    public static final PrefKey f2580r = ((PrefKey) f2564b.m2011a("validated_phonenumber"));
    public static final PrefKey f2581s = ((PrefKey) f2564b.m2011a("validated_country"));
    public static final PrefKey f2582t = ((PrefKey) f2564b.m2011a("prefill_phone_infos"));
    public static final PrefKey f2583u = ((PrefKey) f2564b.m2011a("global_searchability_id"));
    public static final PrefKey f2584v = ((PrefKey) f2564b.m2011a("nux_ver_completed"));
    public static final PrefKey f2585w = ((PrefKey) f2564b.m2011a("has_logged_app_install"));
    public static final PrefKey f2586x = ((PrefKey) f2564b.m2011a("has_seen_deactivations_nux"));
    public static final PrefKey f2587y = ((PrefKey) f2564b.m2011a("platform_reply_crypto_key"));
    public static final PrefKey f2588z = ((PrefKey) f2564b.m2011a("platform_reply_iv_crypto_key"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("nux/");
        f2569g = prefKey;
        f2570h = (PrefKey) prefKey.m2011a("chat_head_first_head_nux_completed");
        prefKey = (PrefKey) f2563a.m2011a("contact_logs/");
        f2575m = prefKey;
        f2576n = (PrefKey) prefKey.m2011a("nux_contact_logs_upload_screen_shown");
        prefKey = (PrefKey) f2566d.m2011a("notifications/");
        f2540D = prefKey;
        f2541E = (PrefKey) prefKey.m2011a("enabled");
        prefKey = (PrefKey) f2540D.m2011a("threads/");
        f2556T = prefKey;
        prefKey = (PrefKey) prefKey.m2011a("custom/");
        f2557U = prefKey;
        f2558V = (PrefKey) prefKey.m2011a("count/");
        prefKey = (PrefKey) ChatHeadsPrefKeys.f2594f.m2011a("dive_head/");
        f2561Y = prefKey;
        f2562Z = (PrefKey) prefKey.m2011a("shortcut_notif_enabled");
        prefKey = (PrefKey) f2565c.m2011a("contacts/");
        ab = prefKey;
        ac = (PrefKey) prefKey.m2011a("new_user_notifications");
        prefKey = (PrefKey) f2565c.m2011a("telephone_call_log/");
        ai = prefKey;
        aj = (PrefKey) prefKey.m2011a("disable_everyone");
        prefKey = (PrefKey) f2565c.m2011a("sms_upsell/");
        al = prefKey;
        am = (PrefKey) prefKey.m2011a("disable_everyone");
        prefKey = (PrefKey) f2565c.m2011a("photo_reminders/");
        ay = prefKey;
        az = (PrefKey) prefKey.m2011a("enabled");
    }

    public static PrefKey m4706a(ThreadKey threadKey) {
        return (PrefKey) ((PrefKey) f2556T.m2011a(Uri.encode(threadKey.toString()))).m2011a("/muted_until2");
    }

    @Nullable
    public static ThreadKey m4705a(PrefKey prefKey) {
        if (prefKey == null || !prefKey.m2013a(f2556T) || !prefKey.m2012a().endsWith("muted_until2")) {
            return null;
        }
        Iterator it = Splitter.on("/").split(prefKey.m2014b(f2556T)).iterator();
        if (it.hasNext()) {
            return ThreadKey.a(Uri.decode((String) it.next()));
        }
        return null;
    }

    public static PrefKey m4708b(String str) {
        return (PrefKey) ((PrefKey) f2552P.m2011a(Uri.encode(str))).m2011a("/show_invite_banner");
    }

    public static PrefKey m4707b(ThreadKey threadKey) {
        return (PrefKey) f2559W.m2011a(Uri.encode(threadKey.toString()));
    }

    public final ImmutableSet<PrefKey> mo671b() {
        return ImmutableSet.of(f2575m);
    }
}
