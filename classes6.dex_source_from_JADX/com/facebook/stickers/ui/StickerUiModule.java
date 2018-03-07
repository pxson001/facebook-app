package com.facebook.stickers.ui;

import android.content.res.Resources;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.media.preview.MediaPreviewDialogManager;

@InjectorModule
/* compiled from: drawableFromFetchImageParams */
public class StickerUiModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ForStickerPreview
    public static MediaPreviewDialogManager m24766a(Resources resources, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        MediaPreviewDialogManager mediaPreviewDialogManager = new MediaPreviewDialogManager(fbDraweeControllerBuilder);
        mediaPreviewDialogManager.f12091f = resources.getDimensionPixelSize(2131428605);
        mediaPreviewDialogManager.f12092g = CallerContext.b(ForStickerPreview.class, "sticker_preview_dialog");
        return mediaPreviewDialogManager;
    }
}
