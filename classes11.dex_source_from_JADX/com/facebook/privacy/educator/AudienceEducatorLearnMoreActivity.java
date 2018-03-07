package com.facebook.privacy.educator;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;

/* compiled from: STORY_TYPE */
public final class AudienceEducatorLearnMoreActivity extends FbFragmentActivity {
    public final void m11654b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903310);
        if (((AudienceEducatorLearnMoreFragment) kO_().a(2131558429)) == null) {
            Intent intent = getIntent();
            Bundle bundle2 = new Bundle();
            bundle2.putAll(intent.getExtras());
            AudienceEducatorLearnMoreFragment audienceEducatorLearnMoreFragment = new AudienceEducatorLearnMoreFragment();
            audienceEducatorLearnMoreFragment.g(bundle2);
            kO_().a().b(2131558429, audienceEducatorLearnMoreFragment).b();
        }
    }
}
