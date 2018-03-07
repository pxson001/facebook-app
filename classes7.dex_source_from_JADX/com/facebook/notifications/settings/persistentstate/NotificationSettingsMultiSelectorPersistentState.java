package com.facebook.notifications.settings.persistentstate;

import java.util.HashSet;
import java.util.Set;

/* compiled from: minutiae_reshare_composer_nux */
public class NotificationSettingsMultiSelectorPersistentState implements SelectablePersistentState {
    private final Set<String> f8845a = new HashSet();
    public boolean f8846b = false;

    public final boolean mo471a(String str) {
        return this.f8845a.contains(str);
    }

    public final void m10771a(String str, boolean z) {
        if (z) {
            this.f8845a.add(str);
        } else {
            this.f8845a.remove(str);
        }
    }
}
