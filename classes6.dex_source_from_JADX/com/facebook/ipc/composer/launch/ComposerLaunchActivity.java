package com.facebook.ipc.composer.launch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: life event type should not be null */
public class ComposerLaunchActivity extends FbFragmentActivity {
    @Inject
    public ComposerLauncher f11607p;

    private static <T extends Context> void m18322a(Class<T> cls, T t) {
        m18323a((Object) t, (Context) t);
    }

    public static void m18323a(Object obj, Context context) {
        ((ComposerLaunchActivity) obj).f11607p = (ComposerLauncher) ComposerLauncherImpl.a(FbInjector.get(context));
    }

    private void m18321a(ComposerLauncher composerLauncher) {
        this.f11607p = composerLauncher;
    }

    protected final void m18324b(Bundle bundle) {
        super.b(bundle);
        Class cls = ComposerLaunchActivity.class;
        m18323a((Object) this, (Context) this);
        if (bundle == null) {
            this.f11607p.a(getIntent().getStringExtra("extra_ComposerLaunchActivity_session_id"), (ComposerConfiguration) getIntent().getParcelableExtra("extra_ComposerLaunchActivity_configuration"), 0, this);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Preconditions.checkArgument(i == 0);
        setResult(i2, intent);
        finish();
    }

    public static Intent m18320a(Context context, @Nullable String str, ComposerConfiguration composerConfiguration) {
        return new Intent(context, ComposerLaunchActivity.class).putExtra("extra_ComposerLaunchActivity_session_id", str).putExtra("extra_ComposerLaunchActivity_configuration", composerConfiguration);
    }
}
