package com.facebook.photos.editgallery;

import android.content.Context;
import android.net.Uri;
import android.widget.FrameLayout;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager;
import com.facebook.photos.creativeediting.utilities.SpringAlphaAnimator;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.google.common.base.Optional;

/* compiled from: last_viewed_time */
public class TextEditControllerProvider extends AbstractAssistedProvider<TextEditController> {
    public final TextEditController m12333a(Uri uri, Fb4aTitleBar fb4aTitleBar, String str, FrameLayout frameLayout, EditableOverlayContainerView editableOverlayContainerView, String str2, PostprocessorFactory postprocessorFactory, RotatingPhotoViewController rotatingPhotoViewController, MovableItemListener movableItemListener, Optional<CreativeEditingLogger> optional) {
        return new TextEditController(uri, fb4aTitleBar, str, frameLayout, editableOverlayContainerView, str2, postprocessorFactory, rotatingPhotoViewController, movableItemListener, optional, FbDraweeControllerBuilder.b(this), (Context) getInstance(Context.class), CreativeEditingFileManager.a(this), SpringAlphaAnimator.b(this));
    }
}
