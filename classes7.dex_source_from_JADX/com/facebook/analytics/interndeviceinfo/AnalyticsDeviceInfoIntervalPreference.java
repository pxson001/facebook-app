package com.facebook.analytics.interndeviceinfo;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.analytics.ClientPeriodicEventReporterManager;
import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.widget.prefs.OrcaListPreference;
import javax.inject.Inject;

/* compiled from: video_timestamp_ms */
public class AnalyticsDeviceInfoIntervalPreference extends OrcaListPreference implements InjectableComponentWithoutContext {
    @Inject
    public FbSharedPreferences f560a;
    @Inject
    public Lazy<ClientPeriodicEventReporterManager> f561b;

    /* compiled from: video_timestamp_ms */
    class C00541 implements OnPreferenceChangeListener {
        final /* synthetic */ AnalyticsDeviceInfoIntervalPreference f559a;

        C00541(AnalyticsDeviceInfoIntervalPreference analyticsDeviceInfoIntervalPreference) {
            this.f559a = analyticsDeviceInfoIntervalPreference;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            Long valueOf = Long.valueOf(Long.parseLong((String) obj));
            if (valueOf.longValue() == -1) {
                this.f559a.f560a.edit().a(AnalyticsPrefKeys.e).commit();
            } else {
                this.f559a.f560a.edit().a(AnalyticsPrefKeys.e, valueOf.longValue() * 1000).commit();
                ((ClientPeriodicEventReporterManager) this.f559a.f561b.get()).a();
            }
            return true;
        }
    }

    public static void m575a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AnalyticsDeviceInfoIntervalPreference analyticsDeviceInfoIntervalPreference = (AnalyticsDeviceInfoIntervalPreference) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 125);
        analyticsDeviceInfoIntervalPreference.f560a = fbSharedPreferences;
        analyticsDeviceInfoIntervalPreference.f561b = b;
    }

    public AnalyticsDeviceInfoIntervalPreference(Context context) {
        super(context);
        Class cls = AnalyticsDeviceInfoIntervalPreference.class;
        m575a(this, context);
        String str = this.f560a.a(AnalyticsPrefKeys.e, -1);
        CharSequence[] charSequenceArr = new CharSequence[]{"1", "10", "60", "3600", "86400", "-1"};
        setEntries(new CharSequence[]{"1 second", "10 seconds", "1 minute", "1 hour", "1 day", "Unset"});
        setEntryValues(charSequenceArr);
        setDefaultValue(str);
        setKey(AnalyticsDeviceInfoIntervalPreference.class.getName());
        setTitle("Device Info Event Interval");
        setSummary("Time between Device Info analytics events");
        setOnPreferenceChangeListener(new C00541(this));
    }
}
