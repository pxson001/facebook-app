package com.facebook.analytics.internal;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.widget.prefs.OrcaListPreference;
import javax.inject.Inject;

/* compiled from: view_consume_action */
public class AnalyticsBatchIntervalPreference extends OrcaListPreference implements InjectableComponentWithoutContext {
    @Inject
    public FbSharedPreferences f556a;

    /* compiled from: view_consume_action */
    class C00521 implements OnPreferenceChangeListener {
        final /* synthetic */ AnalyticsBatchIntervalPreference f555a;

        C00521(AnalyticsBatchIntervalPreference analyticsBatchIntervalPreference) {
            this.f555a = analyticsBatchIntervalPreference;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            this.f555a.f556a.edit().a(AnalyticsPrefKeys.c, Long.parseLong((String) obj) * 1000).commit();
            return true;
        }
    }

    public static void m573a(Object obj, Context context) {
        ((AnalyticsBatchIntervalPreference) obj).f556a = (FbSharedPreferences) FbSharedPreferencesImpl.a(FbInjector.get(context));
    }

    public AnalyticsBatchIntervalPreference(Context context) {
        super(context);
        Class cls = AnalyticsBatchIntervalPreference.class;
        m573a(this, context);
        String str = (this.f556a.a(AnalyticsPrefKeys.c, 300000) / 1000);
        CharSequence[] charSequenceArr = new CharSequence[]{"1", "2", "5", "10", "300"};
        setEntries(new CharSequence[]{"1 second", "2 seconds", "5 seconds", "10 seconds", "300 seconds"});
        setEntryValues(charSequenceArr);
        setDefaultValue(str);
        setKey(AnalyticsBatchIntervalPreference.class.getName());
        setTitle("Batch Log Interval");
        setSummary("how long to batch logs before send them back");
        setOnPreferenceChangeListener(new C00521(this));
    }
}
