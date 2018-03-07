package com.facebook.orca.notify;

import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sync_id */
public class NotificationsUserDataCleaner extends AbstractAuthComponent {
    private final MessagesNotificationManager f1487a;
    private final FbSharedPreferences f1488b;

    @Inject
    public NotificationsUserDataCleaner(MessagesNotificationManager messagesNotificationManager, FbSharedPreferences fbSharedPreferences) {
        this.f1487a = messagesNotificationManager;
        this.f1488b = fbSharedPreferences;
    }

    public final void m1697e() {
        this.f1487a.m10550b("logout");
        this.f1488b.a(ImmutableSet.of(MessagingPrefKeys.W));
    }
}
