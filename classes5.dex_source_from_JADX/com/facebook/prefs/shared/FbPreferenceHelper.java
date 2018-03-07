package com.facebook.prefs.shared;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.Preference;
import com.facebook.inject.Assisted;
import com.google.common.base.Objects;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: date */
public class FbPreferenceHelper {
    public final Preference f5215a;
    public final SharedPreferences f5216b;
    public final FbSharedPreferences f5217c;

    /* compiled from: date */
    class SimpleForwardingSharedPreferences implements SharedPreferences {
        private final FbSharedPreferences f5214a;

        public SimpleForwardingSharedPreferences(FbSharedPreferences fbSharedPreferences) {
            this.f5214a = fbSharedPreferences;
        }

        public boolean contains(String str) {
            return this.f5214a.a(new PrefKey(str));
        }

        public Map<String, ?> getAll() {
            throw new UnsupportedOperationException();
        }

        public String getString(String str, String str2) {
            throw new UnsupportedOperationException();
        }

        public Set<String> getStringSet(String str, Set<String> set) {
            throw new UnsupportedOperationException();
        }

        public int getInt(String str, int i) {
            throw new UnsupportedOperationException();
        }

        public long getLong(String str, long j) {
            throw new UnsupportedOperationException();
        }

        public float getFloat(String str, float f) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(String str, boolean z) {
            throw new UnsupportedOperationException();
        }

        public Editor edit() {
            throw new UnsupportedOperationException();
        }

        public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
            throw new UnsupportedOperationException();
        }

        public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
            throw new UnsupportedOperationException();
        }
    }

    @Inject
    public FbPreferenceHelper(@Assisted Preference preference, FbSharedPreferences fbSharedPreferences) {
        this.f5215a = preference;
        this.f5216b = new SimpleForwardingSharedPreferences(fbSharedPreferences);
        this.f5217c = fbSharedPreferences;
    }

    public final void m10076a(PrefKey prefKey) {
        this.f5215a.setKey(prefKey.a());
    }

    public final boolean m10077a(boolean z) {
        return this.f5217c.a(new PrefKey(this.f5215a.getKey()), z);
    }

    public final String m10075a(String str) {
        return this.f5217c.a(new PrefKey(this.f5215a.getKey()), str);
    }

    public final boolean m10078b(String str) {
        if (this.f5215a.hasKey() && !Objects.equal(str, m10075a(null))) {
            FbSharedPreferences.Editor edit = this.f5217c.edit();
            edit.a(new PrefKey(this.f5215a.getKey()), str);
            edit.commit();
        }
        return true;
    }
}
