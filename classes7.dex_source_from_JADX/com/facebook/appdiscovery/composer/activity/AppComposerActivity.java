package com.facebook.appdiscovery.composer.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.appdiscovery.composer.fragment.AppPickerFragment;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.ipc.composer.intent.ComposerConfiguration;

/* compiled from: cta_lead_gen_user_info_validation_error */
public class AppComposerActivity extends FbFragmentActivity {
    protected final void m20518b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903260);
        m20517i();
    }

    private void m20517i() {
        if (((AppPickerFragment) kO_().a(2131558429)) == null) {
            kO_().a().a(2131558429, new AppPickerFragment(), AppPickerFragment.f16437d).b();
            kO_().b();
        }
    }

    public static Intent m20516a(Context context, String str, ComposerConfiguration composerConfiguration) {
        return new Intent().setComponent(new ComponentName(context, AppComposerActivity.class.getName())).putExtra("composerSessionId", str).putExtra("composerConfig", composerConfiguration);
    }
}
