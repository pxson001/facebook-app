package com.facebook.photos.albumcreator;

import android.content.Context;
import android.content.Intent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mark_self_safe */
public class AlbumCreatorIntentBuilder {
    private Context f9304a;

    public static AlbumCreatorIntentBuilder m11324b(InjectorLike injectorLike) {
        return new AlbumCreatorIntentBuilder((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public AlbumCreatorIntentBuilder(Context context) {
        this.f9304a = context;
    }

    public final Intent m11325a(AlbumCreatorSourceType albumCreatorSourceType, ViewerContext viewerContext) {
        return m11326a(albumCreatorSourceType, viewerContext, null);
    }

    public final Intent m11326a(AlbumCreatorSourceType albumCreatorSourceType, ViewerContext viewerContext, @Nullable ComposerTargetData composerTargetData) {
        Intent intent = new Intent(this.f9304a, AlbumCreatorActivity.class);
        intent.putExtra("source", albumCreatorSourceType.toString());
        if (viewerContext != null) {
            intent.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", viewerContext);
        }
        if (composerTargetData != null) {
            intent.putExtra("extra_composer_target_data", composerTargetData);
        }
        return intent;
    }
}
