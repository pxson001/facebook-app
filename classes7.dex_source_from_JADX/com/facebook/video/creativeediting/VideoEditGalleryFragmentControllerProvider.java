package com.facebook.video.creativeediting;

import android.content.Context;
import android.net.Uri;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;
import com.facebook.photos.editgallery.animations.AnimationParam;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentController.State;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentManager.VideoEditGalleryCallback;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.extract.DefaultVideoMetadataExtractor;

/* compiled from: easeInEaseOut */
public class VideoEditGalleryFragmentControllerProvider extends AbstractAssistedProvider<VideoEditGalleryFragmentController> {
    public final VideoEditGalleryFragmentController m19477a(VideoEditGalleryFragment videoEditGalleryFragment, Uri uri, State state, VideoEditGalleryCallback videoEditGalleryCallback, AnimationParam animationParam, VideoEditGalleryLaunchConfiguration videoEditGalleryLaunchConfiguration) {
        return new VideoEditGalleryFragmentController((VideoMetadataExtractor) DefaultVideoMetadataExtractor.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), VideoEditGalleryPerformanceLogger.m19480a(this), DefaultAndroidThreadUtil.a(this), (VideoTrimmingControllerProvider) getOnDemandAssistedProviderForStaticDi(VideoTrimmingControllerProvider.class), (Context) getInstance(Context.class), BitmapUtils.a(this), IdBasedSingletonScopeProvider.b(this, 600), VideoCreativeEditingLogger.m19546a(this), VideoCropController.m19434a(this), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), videoEditGalleryFragment, uri, state, videoEditGalleryCallback, animationParam, videoEditGalleryLaunchConfiguration, ScreenUtil.a(this), AllCapsTransformationMethod.a(this));
    }
}
