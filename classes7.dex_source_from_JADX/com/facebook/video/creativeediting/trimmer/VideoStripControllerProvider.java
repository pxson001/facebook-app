package com.facebook.video.creativeediting.trimmer;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.video.scrubber.GLFrameRetrieverProvider;
import com.facebook.videocodec.effects.renderers.EffectsFactory;
import com.facebook.videocodec.policy.VideoMirroringMode;
import java.util.concurrent.Executor;

/* compiled from: doodle_used_color_picker */
public class VideoStripControllerProvider extends AbstractAssistedProvider<VideoStripController> {
    public final VideoStripController m19589a(Uri uri, Uri uri2, boolean z, VideoMirroringMode videoMirroringMode) {
        return new VideoStripController((Context) getInstance(Context.class), uri, uri2, z, videoMirroringMode, ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), PlatformBitmapFactoryMethodAutoProvider.a(this), FbDraweeControllerBuilder.b(this), (GLFrameRetrieverProvider) getOnDemandAssistedProviderForStaticDi(GLFrameRetrieverProvider.class), EffectsFactory.m19782b(this));
    }
}
