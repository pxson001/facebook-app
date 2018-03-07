package com.facebook.notifications.settings.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: minutiae_object_picker_time_to_search_shown */
public class NotificationSettingsRemovableRowKey implements ContextStateKey<String, NotificationSettingsRemovableRowPersistentState> {
    private final String f8847a;

    public NotificationSettingsRemovableRowKey(String str) {
        this.f8847a = str;
    }

    public final Object m10773a() {
        return new NotificationSettingsRemovableRowPersistentState();
    }

    public final Object m10774b() {
        return this.f8847a;
    }
}
