package com.facebook.katana.app.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.peer.MessagesNotificationProcessType;

/* compiled from: time_since_boot_ms */
public class MessagesNotificationProcessTypeMethodAutoProvider extends AbstractProvider<MessagesNotificationProcessType> {
    public static MessagesNotificationProcessType m4833a(InjectorLike injectorLike) {
        return MessagesNotificationProcessType.Fb4a;
    }

    public Object get() {
        return MessagesNotificationProcessType.Fb4a;
    }
}
