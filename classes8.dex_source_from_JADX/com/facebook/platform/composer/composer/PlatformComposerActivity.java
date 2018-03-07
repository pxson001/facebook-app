package com.facebook.platform.composer.composer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: route-id */
public class PlatformComposerActivity extends FbFragmentActivity {
    @Inject
    public PlatformComposerLauncher f3943p;

    private static <T extends Context> void m3933a(Class<T> cls, T t) {
        m3934a((Object) t, (Context) t);
    }

    public static void m3934a(Object obj, Context context) {
        ((PlatformComposerActivity) obj).f3943p = PlatformComposerLauncher.m4085b(FbInjector.get(context));
    }

    public final void m3935b(Bundle bundle) {
        super.b(bundle);
        Class cls = PlatformComposerActivity.class;
        m3934a((Object) this, (Context) this);
        setContentView(2130906295);
        this.f3943p.m4086a(bundle, this, 2131560487, getIntent());
    }

    public static Intent m3930a(Activity activity) {
        Intent intent = activity.getIntent();
        return new Intent(activity, PlatformComposerActivity.class).setType(intent.getType()).setAction(intent.getAction()).putExtras(intent);
    }

    public static Intent m3931a(Context context, @Nullable String str, ComposerConfiguration composerConfiguration, boolean z) {
        if (str == null) {
            str = SafeUUIDGenerator.a().toString();
        }
        Intent intent = new Intent(context, PlatformComposerActivity.class);
        intent.addFlags(131072);
        intent.putExtra("extra_composer_internal_session_id", str);
        intent.putExtra("extra_composer_configuration", composerConfiguration);
        if (z) {
            intent.putExtra("skip_publish", true);
        }
        return intent;
    }

    private void m3932a(PlatformComposerLauncher platformComposerLauncher) {
        this.f3943p = platformComposerLauncher;
    }

    public void onBackPressed() {
        if (this.f3943p != null) {
            this.f3943p.m4087b();
        } else {
            super.onBackPressed();
        }
    }

    public void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1963478668);
        PlatformComposerLauncher.m4084a(this);
        super.onStop();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1192829576, a);
    }
}
