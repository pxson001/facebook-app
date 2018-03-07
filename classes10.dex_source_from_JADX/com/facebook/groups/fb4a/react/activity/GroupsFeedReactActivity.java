package com.facebook.groups.fb4a.react.activity;

import android.os.Bundle;
import com.facebook.common.util.SizeUtil;
import com.facebook.fbreact.fragment.ReactActivity;

/* compiled from: Total bytes mismatch */
public class GroupsFeedReactActivity extends ReactActivity {
    private int f21969q;

    public final void m23098b(Bundle bundle) {
        m23097i();
        super.b(bundle);
    }

    protected final Bundle m23099c(Bundle bundle) {
        bundle.putString("group", getIntent().getExtras().getString("group_feed_id"));
        bundle.putDouble("statusBarHeight", (double) this.f21969q);
        return bundle;
    }

    private void m23097i() {
        if (this.f21969q <= 0) {
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            this.f21969q = identifier > 0 ? SizeUtil.c(this, (float) getResources().getDimensionPixelSize(identifier)) : 25;
        }
    }
}
