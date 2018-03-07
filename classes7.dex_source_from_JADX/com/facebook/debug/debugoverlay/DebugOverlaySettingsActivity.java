package com.facebook.debug.debugoverlay;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceScreen;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.inject.FbInjector;
import com.facebook.inject.MultiBinderSet;
import com.facebook.widget.prefs.OrcaCheckBoxPreference;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: sync_delta_handling_cache */
public class DebugOverlaySettingsActivity extends FbPreferenceActivity {
    public Set<DebugOverlayTagSetProvider> f2581a;

    private static <T extends Context> void m2971a(Class<T> cls, T t) {
        m2972a((Object) t, (Context) t);
    }

    public static void m2972a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DebugOverlaySettingsActivity) obj).f2581a = new MultiBinderSet(fbInjector.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$DebugOverlayTagSetProvider(fbInjector));
    }

    @Inject
    private void m2973a(Set<DebugOverlayTagSetProvider> set) {
        this.f2581a = set;
    }

    public final void m2974c(Bundle bundle) {
        super.c(bundle);
        Class cls = DebugOverlaySettingsActivity.class;
        m2972a((Object) this, (Context) this);
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        for (DebugOverlayTagSetProvider a : this.f2581a) {
            Iterator it = a.mo1148a().iterator();
            while (it.hasNext()) {
                m2970a(createPreferenceScreen, (DebugOverlayTag) it.next());
            }
        }
        setPreferenceScreen(createPreferenceScreen);
    }

    private void m2970a(PreferenceScreen preferenceScreen, DebugOverlayTag debugOverlayTag) {
        OrcaCheckBoxPreference orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.setTitle(debugOverlayTag.f2582a);
        orcaCheckBoxPreference.setSummary(debugOverlayTag.f2583b);
        orcaCheckBoxPreference.a(DebugOverlayTagPrefKeys.m2975a(debugOverlayTag));
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        preferenceScreen.addPreference(orcaCheckBoxPreference);
    }
}
