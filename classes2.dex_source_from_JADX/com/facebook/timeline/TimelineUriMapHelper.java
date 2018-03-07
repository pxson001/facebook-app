package com.facebook.timeline;

import android.content.Intent;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.crudolib.urimap.runtime.ComponentHelper;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: show_perf_toast */
public class TimelineUriMapHelper extends ComponentHelper {
    private final Provider<Boolean> f4856a;
    private final Provider<String> f4857b;

    @Inject
    public TimelineUriMapHelper(Provider<Boolean> provider, Provider<String> provider2) {
        this.f4856a = provider;
        this.f4857b = provider2;
    }

    public final boolean mo1270a() {
        return ((Boolean) this.f4856a.get()).booleanValue();
    }

    public final Intent mo1269a(Intent intent) {
        int intExtra = intent.getIntExtra("target_fragment", -1);
        if (intExtra == FragmentConstants$ContentFragmentType.NATIVE_TIMELINE_FRAGMENT.ordinal() || intExtra == FragmentConstants$ContentFragmentType.TIMELINE_COVERPHOTO_FRAGMENT.ordinal()) {
            intent.putExtra("extra_parent_activity", true);
        } else if (intExtra == FragmentConstants$ContentFragmentType.COLLECTIONS_SUMMARY_FRAGMENT.ordinal()) {
            intent.putExtra("com.facebook.katana.profile.id", (String) this.f4857b.get());
        }
        return intent;
    }
}
