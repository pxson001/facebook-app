package com.facebook.notifications.settings.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: minutiae_reshare_nux_shown */
public class NotificationSettingsMultiSelectorKey implements ContextStateKey<String, NotificationSettingsMultiSelectorPersistentState> {
    private static final String f8843a = NotificationSettingsMultiSelectorKey.class.getSimpleName();
    private String f8844b;

    public NotificationSettingsMultiSelectorKey(String str) {
        this.f8844b = f8843a + str;
    }

    public final Object m10768a() {
        return new NotificationSettingsMultiSelectorPersistentState();
    }

    public final Object m10769b() {
        return this.f8844b;
    }
}
