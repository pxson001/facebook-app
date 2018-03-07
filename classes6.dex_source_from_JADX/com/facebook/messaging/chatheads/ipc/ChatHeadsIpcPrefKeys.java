package com.facebook.messaging.chatheads.ipc;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: video_filesize */
public class ChatHeadsIpcPrefKeys {
    public static final PrefKey f744a;
    public static final PrefKey f745b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.c.a("messages/chat_heads/ipc");
        f744a = prefKey;
        f745b = (PrefKey) prefKey.a("/debug_show_inside_app");
    }
}
