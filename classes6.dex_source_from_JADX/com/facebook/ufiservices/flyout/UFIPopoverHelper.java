package com.facebook.ufiservices.flyout;

import android.app.Dialog;
import android.content.res.Resources;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.common.ui.util.ViewDimensionUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: cut_type */
public class UFIPopoverHelper {
    private final TabletExperimentConfiguration f18108a;

    public static UFIPopoverHelper m26636b(InjectorLike injectorLike) {
        return new UFIPopoverHelper(TabletExperimentConfiguration.a(injectorLike));
    }

    @Inject
    public UFIPopoverHelper(TabletExperimentConfiguration tabletExperimentConfiguration) {
        this.f18108a = tabletExperimentConfiguration;
    }

    public final boolean m26638a() {
        return this.f18108a == null || !this.f18108a.a();
    }

    public static Map<String, Object> m26635a(UFIContentFragment uFIContentFragment, UFIContentFragment uFIContentFragment2) {
        Map<String, Object> hashMap = new HashMap();
        if (uFIContentFragment instanceof AnalyticsFragmentWithExtraData) {
            hashMap.putAll(((AnalyticsFragmentWithExtraData) uFIContentFragment).c());
        }
        if (uFIContentFragment2 instanceof AnalyticsFragmentWithExtraData) {
            hashMap.putAll(((AnalyticsFragmentWithExtraData) uFIContentFragment2).c());
        }
        return hashMap;
    }

    public final void m26637a(Dialog dialog) {
        Resources resources = dialog.getContext().getResources();
        dialog.getWindow().setLayout(ViewDimensionUtil.a(resources, 520.0f, resources.getDisplayMetrics().widthPixels), ViewDimensionUtil.a(resources, 0.8f, resources.getDisplayMetrics().heightPixels));
    }
}
