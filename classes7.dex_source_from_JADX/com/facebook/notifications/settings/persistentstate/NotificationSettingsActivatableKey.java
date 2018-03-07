package com.facebook.notifications.settings.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: minutiae_session_finished */
public class NotificationSettingsActivatableKey implements ContextStateKey<String, NotificationSettingsActivatablePersistentState> {
    private final String f8840a;

    public NotificationSettingsActivatableKey(String str) {
        this.f8840a = str;
    }

    public final Object m10765a() {
        return new NotificationSettingsActivatablePersistentState();
    }

    public final Object m10766b() {
        return this.f8840a;
    }
}
