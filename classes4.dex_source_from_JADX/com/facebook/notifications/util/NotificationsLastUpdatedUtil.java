package com.facebook.notifications.util;

import com.facebook.inject.InjectorLike;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;

/* compiled from: mobile_zero_free_facebook_launch */
public class NotificationsLastUpdatedUtil {
    public final FbSharedPreferences f7614a;

    public static NotificationsLastUpdatedUtil m7923b(InjectorLike injectorLike) {
        return new NotificationsLastUpdatedUtil((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public NotificationsLastUpdatedUtil(FbSharedPreferences fbSharedPreferences) {
        this.f7614a = fbSharedPreferences;
    }

    public final long m7924a() {
        return this.f7614a.a(NotificationsPreferenceConstants.f7725b, -1);
    }

    public final void m7925a(long j) {
        Editor edit = this.f7614a.edit();
        edit.a(NotificationsPreferenceConstants.f7725b, j);
        edit.commit();
    }

    public static NotificationsLastUpdatedUtil m7922a(InjectorLike injectorLike) {
        return m7923b(injectorLike);
    }

    public final int m7926b() {
        return this.f7614a.a(NotificationsPreferenceConstants.f7729f, 0);
    }

    public final void m7927c(int i) {
        Editor edit = this.f7614a.edit();
        edit.a(NotificationsPreferenceConstants.f7729f, i);
        edit.commit();
    }
}
