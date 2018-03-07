package com.facebook.timeline.profilenux;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;

/* compiled from: feed_filter_videos */
public class ProfileNuxModalActivity extends FbFragmentActivity {
    public final void m12088b(Bundle bundle) {
        super.b(bundle);
        overridePendingTransition(2130968739, 2130968740);
        setContentView(2130906448);
        if (bundle == null) {
            Intent intent = getIntent();
            ProfileNuxModalFragment profileNuxModalFragment = new ProfileNuxModalFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("nux_modal_title", intent.getStringExtra("nux_modal_title"));
            bundle2.putString("nux_modal_text", intent.getStringExtra("nux_modal_text"));
            bundle2.putString("profile_id", intent.getStringExtra("profile_id"));
            bundle2.putParcelable("refresher_configuration", intent.getParcelableExtra("refresher_configuration"));
            profileNuxModalFragment.g(bundle2);
            kO_().a().a(2131566369, profileNuxModalFragment).b();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            super.finish();
        }
    }
}
