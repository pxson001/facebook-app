package com.facebook.video.videohome.prefetching;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.widget.prefs.OrcaListPreference;
import javax.inject.Inject;

/* compiled from: showsHorizontalScrollIndicator */
public class VideoHomePrefetchingIntervalPreference extends OrcaListPreference implements InjectableComponentWithoutContext {
    @Inject
    public FbSharedPreferences f3284a;

    /* compiled from: showsHorizontalScrollIndicator */
    class C03031 implements OnPreferenceChangeListener {
        final /* synthetic */ VideoHomePrefetchingIntervalPreference f3283a;

        C03031(VideoHomePrefetchingIntervalPreference videoHomePrefetchingIntervalPreference) {
            this.f3283a = videoHomePrefetchingIntervalPreference;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            this.f3283a.f3284a.edit().a(VideoHomePrefetchPrefKeys.f3282b, (String) obj).commit();
            return true;
        }
    }

    public static void m3125a(Object obj, Context context) {
        ((VideoHomePrefetchingIntervalPreference) obj).f3284a = (FbSharedPreferences) FbSharedPreferencesImpl.a(FbInjector.get(context));
    }

    public VideoHomePrefetchingIntervalPreference(Context context) {
        super(context);
        Class cls = VideoHomePrefetchingIntervalPreference.class;
        m3125a(this, context);
        CharSequence[] charSequenceArr = new CharSequence[]{"0", "20", "30", "120", "600"};
        setEntries(new CharSequence[]{"server value", "20 seconds", "30 seconds", "60 seconds", "2 minutes", "10 minutes"});
        setEntryValues(charSequenceArr);
        setDefaultValue("0");
        a(VideoHomePrefetchPrefKeys.f3281a);
        setPersistent(false);
        setTitle("Videohome prefetching interval");
        setSummary("shows a toast when prefetching starts/finishes");
        setOnPreferenceChangeListener(new C03031(this));
    }
}
