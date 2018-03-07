package com.facebook.ipc.composer.launch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.InteractionTTILogger;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: mobile_video_encode */
public class ComposerIntentLauncher {
    public final Context f13379a;
    public final SecureContextHelper f13380b;
    public final InteractionTTILogger f13381c;

    public static ComposerIntentLauncher m19715b(InjectorLike injectorLike) {
        return new ComposerIntentLauncher((Context) injectorLike.getInstance(Context.class), DefaultSecureContextHelper.m4636a(injectorLike), InteractionTTILogger.m4228a(injectorLike));
    }

    @Inject
    public ComposerIntentLauncher(Context context, SecureContextHelper secureContextHelper, InteractionTTILogger interactionTTILogger) {
        this.f13379a = context;
        this.f13380b = secureContextHelper;
        this.f13381c = interactionTTILogger;
    }

    public final void m19716a(Intent intent, int i, Activity activity) {
        this.f13381c.m4248a((Context) activity, "ComposerIntentLauncher");
        this.f13380b.mo660a(m19714b(intent), i, (Activity) Preconditions.checkNotNull(activity));
    }

    public final void m19717a(Intent intent, int i, Fragment fragment) {
        this.f13381c.m4252a(fragment.getClass().getSimpleName(), "ComposerIntentLauncher");
        this.f13380b.mo661a(m19714b(intent), i, fragment);
    }

    public static Intent m19714b(Intent intent) {
        if (intent.hasExtra("extra_composer_internal_session_id")) {
            return intent;
        }
        return new Intent(intent).putExtra("extra_composer_internal_session_id", SafeUUIDGenerator.m2795a().toString());
    }
}
