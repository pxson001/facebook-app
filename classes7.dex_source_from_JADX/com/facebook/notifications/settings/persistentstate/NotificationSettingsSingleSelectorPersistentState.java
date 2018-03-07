package com.facebook.notifications.settings.persistentstate;

/* compiled from: minutiae_object_picker_time_to_results_shown */
public class NotificationSettingsSingleSelectorPersistentState implements SelectablePersistentState {
    public String f8851a = null;
    public boolean f8852b = false;

    public final boolean mo471a(String str) {
        if (this.f8851a == null) {
            return false;
        }
        return this.f8851a.equals(str);
    }
}
