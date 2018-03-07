package com.facebook.platform.composer.composer;

import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05232;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05243;

/* compiled from: right_edge */
public class PlatformComposerAttachmentControllerProvider extends AbstractAssistedProvider<PlatformComposerAttachmentController> {
    public final PlatformComposerAttachmentController m3958a(C05232 c05232, C05243 c05243) {
        return new PlatformComposerAttachmentController(DefaultBlueServiceOperationFactory.b(this), ViewerContextManagerProvider.b(this), ResourcesMethodAutoProvider.a(this), new PlatformComposerAttachmentViewBinder(FbDraweeControllerBuilder.b(this)), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), c05232, c05243);
    }
}
