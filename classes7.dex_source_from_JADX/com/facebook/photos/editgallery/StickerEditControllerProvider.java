package com.facebook.photos.editgallery;

import android.content.Context;
import android.widget.FrameLayout;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.utilities.SpringAlphaAnimator;
import com.google.common.base.Optional;

/* compiled from: launch_composer */
public class StickerEditControllerProvider extends AbstractAssistedProvider<StickerEditController> {
    public final StickerEditController m12298a(FrameLayout frameLayout, EditableOverlayContainerView editableOverlayContainerView, String str, MovableItemListener movableItemListener, Optional<CreativeEditingLogger> optional) {
        return new StickerEditController(frameLayout, editableOverlayContainerView, str, movableItemListener, optional, (Context) getInstance(Context.class), SpringAlphaAnimator.b(this), IdBasedSingletonScopeProvider.b(this, 9280));
    }
}
