package com.facebook.video.scrubber;

import android.net.Uri;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.video.scrubber.GLFrameRetriever.FrameRetrieverDelegate;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.effects.GLRenderer;
import com.facebook.videocodec.extract.DefaultVideoMetadataExtractor;
import com.facebook.videocodec.policy.VideoMirroringMode;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* compiled from: display_decision */
public class GLFrameRetrieverProvider extends AbstractAssistedProvider<GLFrameRetriever> {
    public final GLFrameRetriever m19672a(Uri uri, FrameRetrieverDelegate frameRetrieverDelegate, List<GLRenderer> list, VideoMirroringMode videoMirroringMode) {
        return new GLFrameRetriever(uri, frameRetrieverDelegate, list, videoMirroringMode, (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (Clock) SystemClockMethodAutoProvider.a(this), (CodecOutputSurfaceProvider) getOnDemandAssistedProviderForStaticDi(CodecOutputSurfaceProvider.class), (VideoMetadataExtractor) DefaultVideoMetadataExtractor.b(this), IdBasedSingletonScopeProvider.a(this, 494));
    }
}
