package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.friendsharing.videotagging.VideoTaggingManagerProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsComposerDrawn;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger;
import java.util.concurrent.ExecutorService;

/* compiled from: comment_attachment_fallback */
public class VideoPreviewAttachmentViewControllerProvider extends AbstractAssistedProvider<VideoPreviewAttachmentViewController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesIsComposerDrawn & ProvidesConfiguration> VideoPreviewAttachmentViewController<DataProvider> m21261a(DataProvider dataProvider, AttachmentsEventListener attachmentsEventListener, FragmentManager fragmentManager, String str) {
        return new VideoPreviewAttachmentViewController(ComposerAttachmentViewUtility.m21071b(this), InputMethodManagerMethodAutoProvider.b(this), VideoCreativeEditingLogger.m19548b(this), UnderwoodVideoTranscodingUtil.m21170b(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), (Context) getInstance(Context.class), (VideoTaggingManagerProvider) getOnDemandAssistedProviderForStaticDi(VideoTaggingManagerProvider.class), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(this), Handler_ForUiThreadMethodAutoProvider.b(this), (ProvidesAttachments) dataProvider, attachmentsEventListener, fragmentManager, str);
    }
}
