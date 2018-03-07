package com.facebook.nearby.fallback;

import android.os.Bundle;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.widget.titlebar.FbTitleBarUtil;

/* compiled from: usePersistedQueries */
public class NearbyPlacesFallbackActivity extends FbFragmentActivity implements AnalyticsActivity {
    public final void m439b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130905383);
        FbTitleBarUtil.b(this);
    }

    public final String am_() {
        return "nearby_places_fallback";
    }
}
