package com.facebook.debug.pref;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: picker_used_ratio */
public class NonEmployeeModePreference extends CheckBoxOrSwitchPreference implements INeedInit {
    public final FbErrorReporterImpl f6591a;
    private final FbSharedPreferences f6592b;

    /* compiled from: picker_used_ratio */
    class C06821 implements OnPreferenceChangeListener {
        final /* synthetic */ NonEmployeeModePreference f6590a;

        C06821(NonEmployeeModePreference nonEmployeeModePreference) {
            this.f6590a = nonEmployeeModePreference;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            return this.f6590a.f6591a.a(((Boolean) obj).booleanValue());
        }
    }

    public static NonEmployeeModePreference m6907b(InjectorLike injectorLike) {
        return new NonEmployeeModePreference(injectorLike.getProvider(Context.class), FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public NonEmployeeModePreference(Provider<Context> provider, FbErrorReporterImpl fbErrorReporterImpl, FbSharedPreferences fbSharedPreferences) {
        super((Context) provider.get());
        this.f6591a = fbErrorReporterImpl;
        this.f6592b = fbSharedPreferences;
        setKey(DebugLoggingPrefKeys.g.a());
        setSummary("Disable certain employee only features that cause performance problems");
        setTitle("Non-employee mode");
        setOnPreferenceChangeListener(new C06821(this));
    }

    public static NonEmployeeModePreference m6906a(InjectorLike injectorLike) {
        return m6907b(injectorLike);
    }

    public void init() {
        Editor edit = this.f6592b.edit();
        edit.a(DebugLoggingPrefKeys.g);
        edit.commit();
    }
}
