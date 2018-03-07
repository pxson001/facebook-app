package com.facebook.messaging.notify;

import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: set_hscroll_unit_visible_item_index is not supported on  */
public class MessagingNotificationPreferencesUtil {
    public final FbSharedPreferences f2377a;
    private final Provider<Boolean> f2378b;

    @Inject
    public MessagingNotificationPreferencesUtil(FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider) {
        this.f2377a = fbSharedPreferences;
        this.f2378b = provider;
    }
}
