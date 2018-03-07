package com.facebook.privacy.educator;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.privacy.educator.AudienceEducatorFragment.ReportedActionType;

/* compiled from: SUB_ADAPTER_ITEM_MIDDLE */
public final class AudienceEducatorActivity extends FbFragmentActivity {
    private AudienceEducatorFragment f11261p;

    public final void m11645b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903308);
        this.f11261p = (AudienceEducatorFragment) kO_().a(2131558429);
        if (this.f11261p == null) {
            Intent intent = getIntent();
            Bundle bundle2 = new Bundle();
            bundle2.putAll(intent.getExtras());
            AudienceEducatorFragment audienceEducatorFragment = new AudienceEducatorFragment();
            audienceEducatorFragment.g(bundle2);
            this.f11261p = audienceEducatorFragment;
            kO_().a().b(2131558429, this.f11261p).b();
        }
    }

    public final void onBackPressed() {
        AudienceEducatorFragment audienceEducatorFragment = this.f11261p;
        AudienceEducatorFragment.m11647a(audienceEducatorFragment, ReportedActionType.NAVIGATED_BACK, audienceEducatorFragment.f11272b);
        super.onBackPressed();
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AudienceEducatorFragment audienceEducatorFragment = this.f11261p;
        if (z) {
            AudienceEducatorFragment.m11647a(audienceEducatorFragment, ReportedActionType.EXPOSED, audienceEducatorFragment.f11272b);
        }
    }
}
