package com.facebook.platform.composer.composer;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import javax.inject.Inject;

/* compiled from: rich_document_view_initialization */
public class PlatformComposerAttachmentViewBinder {
    public static final CallerContext f4001a = CallerContext.a(PlatformComposerAttachmentViewBinder.class);
    public final FbDraweeControllerBuilder f4002b;

    @Inject
    public PlatformComposerAttachmentViewBinder(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f4002b = fbDraweeControllerBuilder;
    }
}
