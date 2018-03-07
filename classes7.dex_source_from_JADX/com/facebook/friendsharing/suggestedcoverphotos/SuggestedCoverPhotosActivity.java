package com.facebook.friendsharing.suggestedcoverphotos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger$Action;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: ProtilesWaitTime */
public class SuggestedCoverPhotosActivity extends FbFragmentActivity {
    private SuggestedCoverPhotosFragment f24296p;

    public final void m26505b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130907313);
        this.f24296p = (SuggestedCoverPhotosFragment) kO_().a(SuggestedCoverPhotosFragment.f24299a);
        if (this.f24296p == null) {
            this.f24296p = new SuggestedCoverPhotosFragment();
            Intent intent = getIntent();
            Bundle bundle2 = new Bundle();
            if (!(intent == null || intent.getExtras() == null)) {
                bundle2.putAll(intent.getExtras());
            }
            this.f24296p.g(bundle2);
            kO_().a().a(2131558429, this.f24296p).b();
        }
    }

    public static Intent m26504a(@Nullable String str, Context context, ImmutableList<String> immutableList, PromptAnalytics promptAnalytics) {
        return new Intent(context, SuggestedCoverPhotosActivity.class).putExtra("prompt_session_id", str).putExtra("photo_urls", immutableList).putExtra("prompt_analytics", promptAnalytics);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        finish();
    }

    public void onBackPressed() {
        SuggestedCoverPhotosFragment suggestedCoverPhotosFragment = this.f24296p;
        suggestedCoverPhotosFragment.f24301c.a.a(SuggestedCoverPhotosLogger.a(suggestedCoverPhotosFragment.f24303e, SuggestedCoverPhotosLogger$Action.CANCEL_PICKER.name()));
        super.onBackPressed();
    }
}
