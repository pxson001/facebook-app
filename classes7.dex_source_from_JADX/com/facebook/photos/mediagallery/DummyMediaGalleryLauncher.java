package com.facebook.photos.mediagallery;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import javax.annotation.Nullable;

/* compiled from: item_badge_count */
public class DummyMediaGalleryLauncher implements MediaGalleryLauncher {
    public static DummyMediaGalleryLauncher m12714a(InjectorLike injectorLike) {
        return new DummyMediaGalleryLauncher();
    }

    public final void mo602a(Context context, MediaGalleryLauncherParams mediaGalleryLauncherParams, @Nullable AnimationParamProvider animationParamProvider) {
        throw new RuntimeException("Method not implemented!");
    }

    public final void mo603a(Context context, MediaGalleryLauncherParams mediaGalleryLauncherParams, @Nullable AnimationParamProvider animationParamProvider, @Nullable OnDismissListener onDismissListener) {
        throw new RuntimeException("Method not implemented!");
    }
}
