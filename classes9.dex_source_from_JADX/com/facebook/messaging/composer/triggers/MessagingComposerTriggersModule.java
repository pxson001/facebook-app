package com.facebook.messaging.composer.triggers;

import android.content.res.Resources;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.media.preview.MediaPreviewDialogManager;

@InjectorModule
/* compiled from: messenger_dynamic_media_picker_preference */
public class MessagingComposerTriggersModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ForMediaResourcePreview
    static MediaPreviewDialogManager m10473a(Resources resources, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        MediaPreviewDialogManager mediaPreviewDialogManager = new MediaPreviewDialogManager(fbDraweeControllerBuilder);
        mediaPreviewDialogManager.f = resources.getDimensionPixelSize(2131433763);
        mediaPreviewDialogManager.g = CallerContext.b(ForMediaResourcePreview.class, "media_preview_dialog");
        return mediaPreviewDialogManager;
    }
}
