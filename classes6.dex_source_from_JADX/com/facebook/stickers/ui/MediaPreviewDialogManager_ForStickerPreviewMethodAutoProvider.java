package com.facebook.stickers.ui;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.AbstractProvider;
import com.facebook.messaging.media.preview.MediaPreviewDialogManager;

/* compiled from: during upload */
public class MediaPreviewDialogManager_ForStickerPreviewMethodAutoProvider extends AbstractProvider<MediaPreviewDialogManager> {
    public Object get() {
        return StickerUiModule.m24766a(ResourcesMethodAutoProvider.a(this), FbDraweeControllerBuilder.b(this));
    }
}
