package com.facebook.photos.creativeediting.swipeable.composer.nux;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.inject.FbInjector;
import com.facebook.photos.creativeediting.swipeable.common.FramePrefsManager;
import com.facebook.widget.prefs.OrcaListPreference;

/* compiled from: lm.facebook.com */
public class SwipeableFrameNuxPreference extends OrcaListPreference {
    public FramePrefsManager f9958a;

    /* compiled from: lm.facebook.com */
    public class C08311 implements OnPreferenceChangeListener {
        final /* synthetic */ SwipeableFrameNuxPreference f9957a;

        public C08311(SwipeableFrameNuxPreference swipeableFrameNuxPreference) {
            this.f9957a = swipeableFrameNuxPreference;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            this.f9957a.f9958a.m11678a(0);
            this.f9957a.f9958a.m11679b(0);
            return true;
        }
    }

    public static void m11911a(Object obj, Context context) {
        ((SwipeableFrameNuxPreference) obj).f9958a = FramePrefsManager.m11676b(FbInjector.get(context));
    }

    public SwipeableFrameNuxPreference(Context context) {
        super(context);
        Class cls = SwipeableFrameNuxPreference.class;
        m11911a(this, getContext());
        CharSequence[] charSequenceArr = new String[]{"Reset Composer Swipeable Frame NUX"};
        setTitle("Composer Swipeable Frame Nux Settings");
        setSummary("Configure swipeable frame nux in composer (on device only).");
        setEntries(charSequenceArr);
        setEntryValues(new String[]{"composer_swipeable_frame_nux"});
        setPositiveButtonText("Ok");
        setNegativeButtonText("Cancel");
        setKey("SwipeableFrameNuxPreference");
        setOnPreferenceChangeListener(new C08311(this));
    }
}
