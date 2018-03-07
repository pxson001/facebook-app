package com.facebook.aldrin.prefs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.facebook.aldrin.transition.AldrinTransitionLauncher;
import com.facebook.aldrin.transition.activity.AldrinTransitionActivity;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: line_height */
public class AldrinInternSettingsActivity extends FbPreferenceActivity {
    @Inject
    public AldrinTransitionLauncher f10342a;

    private static <T extends Context> void m12157a(Class<T> cls, T t) {
        m12158a((Object) t, (Context) t);
    }

    public static void m12158a(Object obj, Context context) {
        ((AldrinInternSettingsActivity) obj).f10342a = AldrinTransitionLauncher.m12188a(FbInjector.get(context));
    }

    protected final void m12159b(Bundle bundle) {
        super.b(bundle);
        Class cls = AldrinInternSettingsActivity.class;
        m12158a((Object) this, (Context) this);
        setTitle("Aldrin Internal Settings");
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(createPreferenceScreen);
        createPreferenceScreen.addPreference(new RefreshAldrinUserStatusPreference(this));
        Preference preference = new Preference(this);
        preference.setTitle("Launch Transition Activity");
        preference.setIntent(new Intent(this, AldrinTransitionActivity.class));
        preference.setEnabled(this.f10342a.m12191a());
    }

    private void m12156a(AldrinTransitionLauncher aldrinTransitionLauncher) {
        this.f10342a = aldrinTransitionLauncher;
    }
}
