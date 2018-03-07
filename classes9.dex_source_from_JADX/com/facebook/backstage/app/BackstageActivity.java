package com.facebook.backstage.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.facebook.backstage.consumption.BackstageFragment;
import com.facebook.backstage.nub.BackstageService;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: secure.facebook.com */
public class BackstageActivity extends FbFragmentActivity {
    public final void m4281b(Bundle bundle) {
        super.b(bundle);
        startService(new Intent(this, BackstageService.class));
        setContentView(new FrameLayout(this));
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1993288801);
        super.onStart();
        kO_().a().a(16908290, new BackstageFragment(), BackstageFragment.f4496a).b();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1419060624, a);
    }

    public void onBackPressed() {
        BackstageFragment backstageFragment = (BackstageFragment) kO_().a(BackstageFragment.f4496a);
        if (backstageFragment == null || !backstageFragment.aq()) {
            super.onBackPressed();
        }
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1053523479);
        super.onResume();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 185335630, a);
    }
}
