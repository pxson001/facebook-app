package com.facebook.notifications.lockscreenservice;

import com.facebook.messages.ipc.FrozenNewMessageNotification;
import com.facebook.notifications.lockscreen.util.LockScreenNotification;

/* compiled from: network_rtt */
public class MessageNotification extends LockScreenNotification {
    public final int f8347b;
    public final FrozenNewMessageNotification f8348c;

    public MessageNotification(int i, FrozenNewMessageNotification frozenNewMessageNotification) {
        super(frozenNewMessageNotification.j);
        this.f8347b = i;
        this.f8348c = frozenNewMessageNotification;
    }
}
