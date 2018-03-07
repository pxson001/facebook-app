package com.facebook.messaging.media.upload.segmented;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.media.common.MediaLoggerProvider;
import com.facebook.media.transcode.SegmentedMediaTranscoder;
import com.facebook.ui.media.attachments.MediaResource;
import java.util.concurrent.ExecutorService;

/* compiled from: last_selected_index */
public class VideoSegmentTranscodeUploadOperationProvider extends AbstractAssistedProvider<VideoSegmentTranscodeUploadOperation> {
    public final VideoSegmentTranscodeUploadOperation m12638a(MediaResource mediaResource) {
        VideoSegmentTranscodeUploadOperation videoSegmentTranscodeUploadOperation = new VideoSegmentTranscodeUploadOperation(mediaResource);
        videoSegmentTranscodeUploadOperation.m12634a(ApiMethodRunnerImpl.a(this), BackingFileResolver.a(this), new SegmentedMediaTranscoder(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), IdBasedProvider.a(this, 7491), (MediaLoggerProvider) getOnDemandAssistedProviderForStaticDi(MediaLoggerProvider.class)), (ExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(this), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(this), StartStreamUploadMethod.m12610a((InjectorLike) this), PerformStreamUploadMethod.m12605a((InjectorLike) this), EndStreamUploadMethod.m12602a((InjectorLike) this), CancelStreamUploadMethod.m12598a((InjectorLike) this));
        return videoSegmentTranscodeUploadOperation;
    }
}
