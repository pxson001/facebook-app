package com.facebook.notifications.settings.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: minutiae_object_picker_time_to_results_shown_cached */
public class NotificationSettingsSingleSelectorKey implements ContextStateKey<String, NotificationSettingsSingleSelectorPersistentState> {
    private static final String f8849a = NotificationSettingsSingleSelectorKey.class.getSimpleName();
    private String f8850b;

    public NotificationSettingsSingleSelectorKey(String str) {
        this.f8850b = f8849a + str;
    }

    public final Object m10775a() {
        return new NotificationSettingsSingleSelectorPersistentState();
    }

    public final Object m10776b() {
        return this.f8850b;
    }
}
