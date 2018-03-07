package com.facebook.messages.ipc.peer;

import android.net.Uri;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: time_range.end */
public class MessageNotificationPeerContract {
    public static final Uri f2835a;
    public static final Uri f2836b;
    public static final Uri f2837c = Uri.withAppendedPath(f2835a, "clear_active_threads");
    public static final Uri f2838d = Uri.withAppendedPath(f2835a, "is_user_active");
    public static final Uri f2839e;
    public static final Uri f2840f;
    public static final Uri f2841g = Uri.withAppendedPath(f2839e, "clear_active_threads");
    public static final Uri f2842h = Uri.withAppendedPath(f2839e, "open");
    public static final Uri f2843i = Uri.withAppendedPath(f2839e, "close_bauble_up");
    public static final Uri f2844j = Uri.withAppendedPath(f2839e, "hidden");
    public static final Uri f2845k = Uri.withAppendedPath(f2839e, "enabled");
    public static final Uri f2846l = Uri.withAppendedPath(f2839e, "disconnected");
    public static final Uri f2847m;
    public static final Uri f2848n;
    public static final Uri f2849o;
    public static final Uri f2850p;

    static {
        Uri parse = Uri.parse("peer://msg_notification_dash");
        f2835a = parse;
        f2836b = Uri.withAppendedPath(parse, "clear");
        parse = Uri.parse("peer://msg_notification_chathead");
        f2839e = parse;
        f2840f = Uri.withAppendedPath(parse, "clear");
        parse = Uri.parse("peer://msg_notification_user_interaction");
        f2847m = parse;
        f2848n = Uri.withAppendedPath(parse, "is_user_in_app");
        parse = Uri.parse("peer://msg_notification_unread_count");
        f2849o = parse;
        f2850p = Uri.withAppendedPath(parse, "clear_all");
    }

    public static final Uri m4838b(ThreadKey threadKey) {
        return Uri.parse("peer://msg_notification_unread_count/thread/" + Uri.encode(threadKey.toString()));
    }
}
