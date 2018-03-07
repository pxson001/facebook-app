package com.facebook.messaging.composer.triggers;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.preview.MediaPreviewDialogManager;

/* compiled from: messenger_inbox_unit */
public class C1147x627999c2 extends AbstractProvider<MediaPreviewDialogManager> {
    public static MediaPreviewDialogManager m10431b(InjectorLike injectorLike) {
        return MessagingComposerTriggersModule.m10473a(ResourcesMethodAutoProvider.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike));
    }

    public Object get() {
        return MessagingComposerTriggersModule.m10473a(ResourcesMethodAutoProvider.a(this), FbDraweeControllerBuilder.b(this));
    }
}
