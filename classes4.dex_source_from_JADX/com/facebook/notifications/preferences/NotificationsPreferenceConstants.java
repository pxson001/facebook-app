package com.facebook.notifications.preferences;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: microphone_mute */
public class NotificationsPreferenceConstants {
    public static final PrefKey f7712A = ((PrefKey) f7724a.a("last_notifications_sync_full_time"));
    public static final PrefKey f7713B = ((PrefKey) f7724a.a("lockscreen_nux"));
    public static final PrefKey f7714C = ((PrefKey) f7724a.a("lockscreen_show_facebook"));
    public static final PrefKey f7715D = ((PrefKey) f7724a.a("lockscreen_show_messenger"));
    public static final PrefKey f7716E = ((PrefKey) f7724a.a("lockscreen_light_up_screen"));
    public static final PrefKey f7717F = ((PrefKey) f7724a.a("pending_jewel_ids"));
    public static final PrefKey f7718G = ((PrefKey) f7724a.a("pending_friend_ids"));
    public static final PrefKey f7719H = ((PrefKey) f7724a.a("notifs_inline_actions_seen"));
    public static final PrefKey f7720I = ((PrefKey) f7724a.a("notifs_highlight_star_nux_enabled"));
    public static final PrefKey f7721J = ((PrefKey) f7724a.a("inline_notification_nux_hidden"));
    public static final PrefKey f7722K = ((PrefKey) f7724a.a("inline_notification_nux_first_seen_time"));
    public static final PrefKey f7723L = ((PrefKey) f7724a.a("sync_local_preference_settings"));
    public static final PrefKey f7724a;
    public static final PrefKey f7725b;
    public static final PrefKey f7726c = ((PrefKey) f7724a.a("last_clicked_notif_cache_id"));
    public static final PrefKey f7727d = ((PrefKey) f7724a.a("count_before_last_update"));
    public static final PrefKey f7728e = ((PrefKey) f7724a.a("count_after_last_update"));
    public static final PrefKey f7729f = ((PrefKey) f7724a.a("added_to_db_count"));
    public static final PrefKey f7730g = ((PrefKey) f7724a.a("full_screen_count"));
    public static final PrefKey f7731h = ((PrefKey) f7724a.a("half_screen_count"));
    public static final PrefKey f7732i = ((PrefKey) f7724a.a("notifs"));
    public static final PrefKey f7733j = ((PrefKey) f7724a.a("lockscreen_on"));
    public static final PrefKey f7734k = ((PrefKey) f7724a.a("vibrate"));
    public static final PrefKey f7735l = ((PrefKey) f7724a.a("use_led"));
    public static final PrefKey f7736m = ((PrefKey) f7724a.a("ringtone"));
    public static final PrefKey f7737n = ((PrefKey) f7724a.a("wall_posts"));
    public static final PrefKey f7738o = ((PrefKey) f7724a.a("comments"));
    public static final PrefKey f7739p = ((PrefKey) f7724a.a("friend_requests"));
    public static final PrefKey f7740q = ((PrefKey) f7724a.a("friend_confirmations"));
    public static final PrefKey f7741r = ((PrefKey) f7724a.a("photo_tags"));
    public static final PrefKey f7742s = ((PrefKey) f7724a.a("event_invites"));
    public static final PrefKey f7743t = ((PrefKey) f7724a.a("app_requests"));
    public static final PrefKey f7744u = ((PrefKey) f7724a.a("groups"));
    public static final PrefKey f7745v = ((PrefKey) f7724a.a("place_tips"));
    public static final PrefKey f7746w = ((PrefKey) f7724a.a("preview"));
    public static final PrefKey f7747x = ((PrefKey) f7724a.a("polling_enabled"));
    public static final PrefKey f7748y = ((PrefKey) f7724a.a("badge"));
    public static final PrefKey f7749z = ((PrefKey) f7724a.a("last_notifications_sync_new_time"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("notifications/");
        f7724a = prefKey;
        f7725b = (PrefKey) prefKey.a("last_updated_time");
    }
}
