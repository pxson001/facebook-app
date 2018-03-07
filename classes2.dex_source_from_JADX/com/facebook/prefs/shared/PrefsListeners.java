package com.facebook.prefs.shared;

import com.facebook.common.listeners.AbstractWeakListenersManager;
import com.facebook.common.typedkey.TypedKey;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import java.util.Set;

/* compiled from: viewer_has_chosen */
public class PrefsListeners {
    public final FbSharedPreferencesListenersManager f1038a = new FbSharedPreferencesListenersManager();
    public final FbSharedPreferencesPrefixListenersManager f1039b = new FbSharedPreferencesPrefixListenersManager();

    /* compiled from: viewer_has_chosen */
    class FbSharedPreferencesListenersManager extends AbstractWeakListenersManager<PrefKey, FbSharedPreferences, OnSharedPreferenceChangeListener> {
        FbSharedPreferencesListenersManager() {
        }

        protected final void mo325a(Object obj, Object obj2, Object obj3) {
            ((OnSharedPreferenceChangeListener) obj).mo668a((FbSharedPreferences) obj2, (PrefKey) obj3);
        }
    }

    /* compiled from: viewer_has_chosen */
    class FbSharedPreferencesPrefixListenersManager extends FbSharedPreferencesListenersManager {
        FbSharedPreferencesPrefixListenersManager() {
        }

        protected final boolean mo326a(Set set, Object obj) {
            PrefKey prefKey = (PrefKey) obj;
            for (TypedKey a : set) {
                if (prefKey.m2013a(a)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void m2109a(PrefKey prefKey, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f1038a.m2115a((Object) prefKey, (Object) onSharedPreferenceChangeListener);
    }

    public final void m2111b(PrefKey prefKey, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f1038a.m2120b(prefKey, onSharedPreferenceChangeListener);
    }

    public final synchronized void m2110a(Set<PrefKey> set, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        for (PrefKey a : set) {
            m2109a(a, onSharedPreferenceChangeListener);
        }
    }
}
