package com.facebook.widget.prefs;

import android.content.Context;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Provider;

/* compiled from: com.facebook.orca */
public class OrcaListPreferenceWithSummaryValue extends OrcaListPreference {
    @Inject
    public volatile Provider<FbSharedPreferences> f5842a = UltralightRuntime.a;
    private final OnSharedPreferenceChangeListener f5843b = new C05311(this);

    /* compiled from: com.facebook.orca */
    class C05311 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ OrcaListPreferenceWithSummaryValue f5841a;

        C05311(OrcaListPreferenceWithSummaryValue orcaListPreferenceWithSummaryValue) {
            this.f5841a = orcaListPreferenceWithSummaryValue;
        }

        public final void m10586a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            this.f5841a.m10589b();
        }
    }

    public static void m10588a(Object obj, Context context) {
        ((OrcaListPreferenceWithSummaryValue) obj).f5842a = IdBasedSingletonScopeProvider.a(FbInjector.get(context), 3078);
    }

    public OrcaListPreferenceWithSummaryValue(Context context) {
        super(context);
        Class cls = OrcaListPreferenceWithSummaryValue.class;
        m10588a(this, getContext());
    }

    public final void m10590a() {
        String key = getKey();
        if (key != null) {
            ((FbSharedPreferences) this.f5842a.get()).a(key, this.f5843b);
        }
    }

    protected void onBindView(View view) {
        m10589b();
        super.onBindView(view);
    }

    private void m10589b() {
        int findIndexOfValue = findIndexOfValue(getValue());
        if (findIndexOfValue == -1) {
            findIndexOfValue = 0;
        }
        setSummary(getEntries()[findIndexOfValue]);
    }
}
