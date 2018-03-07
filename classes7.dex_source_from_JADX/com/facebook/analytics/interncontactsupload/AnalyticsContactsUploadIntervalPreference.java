package com.facebook.analytics.interncontactsupload;

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

/* compiled from: videos_count */
public class AnalyticsContactsUploadIntervalPreference extends OrcaListPreference implements InjectableComponentWithoutContext {
    @Inject
    public FbSharedPreferences f558a;

    /* compiled from: videos_count */
    class C00531 implements OnPreferenceChangeListener {
        final /* synthetic */ AnalyticsContactsUploadIntervalPreference f557a;

        C00531(AnalyticsContactsUploadIntervalPreference analyticsContactsUploadIntervalPreference) {
            this.f557a = analyticsContactsUploadIntervalPreference;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (Long.parseLong((String) obj) * 1000 != 0) {
                this.f557a.f558a.edit().a(AnalyticsPrefKeys.d, Long.parseLong((String) obj) * 1000).commit();
            } else {
                this.f557a.f558a.edit().a(AnalyticsPrefKeys.d).commit();
            }
            return true;
        }
    }

    public static void m574a(Object obj, Context context) {
        ((AnalyticsContactsUploadIntervalPreference) obj).f558a = (FbSharedPreferences) FbSharedPreferencesImpl.a(FbInjector.get(context));
    }

    public AnalyticsContactsUploadIntervalPreference(Context context) {
        super(context);
        Class cls = AnalyticsContactsUploadIntervalPreference.class;
        m574a(this, context);
        String l = Long.toString(this.f558a.a(AnalyticsPrefKeys.d, 86400));
        CharSequence[] charSequenceArr = new CharSequence[]{"300", "600", "3600", "86400", "0"};
        setEntries(new CharSequence[]{"5 minute", "10 minute", "1 hour", "1 day", "Clear Setting"});
        setEntryValues(charSequenceArr);
        setDefaultValue(l);
        setKey(AnalyticsContactsUploadIntervalPreference.class.getName());
        setPersistent(false);
        setTitle("Contacts Upload Interval");
        setSummary("How long to wait before uploading contacts again");
        setOnPreferenceChangeListener(new C00531(this));
    }
}
