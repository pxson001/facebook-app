package com.facebook.feed.firstlaunch;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Inject;

/* compiled from: messenger_photo_reminders */
public class FirstLaunchTracker {
    public final Clock f13831a;
    public final FbSharedPreferences f13832b;
    public final AbstractFbErrorReporter f13833c;

    @Inject
    public FirstLaunchTracker(Clock clock, FbSharedPreferences fbSharedPreferences, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13831a = clock;
        this.f13832b = fbSharedPreferences;
        this.f13833c = abstractFbErrorReporter;
    }

    public final boolean m20235b() {
        if (!this.f13832b.mo284a()) {
            return false;
        }
        long a = this.f13832b.mo277a(FirstLaunchSharedPrefs.f13834a, 0);
        if (a <= 0) {
            return false;
        }
        this.f13832b.edit().mo1271a(FirstLaunchSharedPrefs.f13834a).commit();
        if (this.f13831a.mo211a() - a <= 120000) {
            return true;
        }
        return false;
    }
}
