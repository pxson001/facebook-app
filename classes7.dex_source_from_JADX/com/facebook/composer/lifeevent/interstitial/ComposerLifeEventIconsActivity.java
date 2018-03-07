package com.facebook.composer.lifeevent.interstitial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.base.activity.FbFragmentActivity;

/* compiled from: core_attribute_color */
public class ComposerLifeEventIconsActivity extends FbFragmentActivity {
    public final void m20762b(Bundle bundle) {
        setContentView(2130903682);
        Fragment fragment = (ComposerLifeEventIconsFragment) kO_().a(2131560535);
        if (fragment == null) {
            fragment = new ComposerLifeEventIconsFragment();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("extra_composer_life_event_model", getIntent().getParcelableExtra("extra_composer_life_event_model"));
        bundle2.putBoolean("extra_composer_life_event_custom", getIntent().hasExtra("extra_composer_life_event_custom"));
        fragment.g(bundle2);
        kO_().a().a(2131560534, fragment).b();
    }

    public static Intent m20761a(Context context) {
        return new Intent(context, ComposerLifeEventIconsActivity.class);
    }
}
