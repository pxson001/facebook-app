package com.facebook.photos.mediagallery.launcher;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import javax.annotation.Nullable;

/* compiled from: job_role */
public interface MediaGalleryLauncher {
    void mo602a(Context context, MediaGalleryLauncherParams mediaGalleryLauncherParams, @Nullable AnimationParamProvider animationParamProvider);

    void mo603a(Context context, MediaGalleryLauncherParams mediaGalleryLauncherParams, @Nullable AnimationParamProvider animationParamProvider, @Nullable OnDismissListener onDismissListener);
}
