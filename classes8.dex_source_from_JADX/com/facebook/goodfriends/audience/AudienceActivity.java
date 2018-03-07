package com.facebook.goodfriends.audience;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: fetch_size */
public class AudienceActivity extends FbFragmentActivity {
    public final void m15029b(Bundle bundle) {
        super.b(bundle);
        setContentView(new FrameLayout(this));
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 843526363);
        super.onStart();
        kO_().a().a(16908290, m15028i(), AudienceFragment.f13405a).b();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -166129199, a);
    }

    private AudienceFragment m15028i() {
        AudienceFragment audienceFragment = new AudienceFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("triggered_by_nux", getIntent().getBooleanExtra("triggered_by_nux", false));
        audienceFragment.g(bundle);
        return audienceFragment;
    }
}
