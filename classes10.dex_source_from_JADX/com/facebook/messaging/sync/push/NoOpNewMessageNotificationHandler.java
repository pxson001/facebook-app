package com.facebook.messaging.sync.push;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.notify.NewMessageNotification;
import com.facebook.messaging.notify.NewMessageNotificationHandler;

/* compiled from: prefillContactPoints */
public class NoOpNewMessageNotificationHandler implements NewMessageNotificationHandler {
    public static NoOpNewMessageNotificationHandler m4216a(InjectorLike injectorLike) {
        return new NoOpNewMessageNotificationHandler();
    }

    public final void m4217a(NewMessageNotification newMessageNotification) {
    }
}
