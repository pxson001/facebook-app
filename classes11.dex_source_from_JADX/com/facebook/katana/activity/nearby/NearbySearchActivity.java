package com.facebook.katana.activity.nearby;

import android.os.Bundle;
import android.widget.TextView;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;

/* compiled from: {checkup_type PROFILE_PHOTO_CHECKUP} */
public class NearbySearchActivity extends FbFragmentActivity implements AnalyticsActivity {
    protected final void m38b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130905411);
        ((TextView) findViewById(2131558927)).setText(2131236611);
    }

    public final String am_() {
        return "places_search";
    }
}
