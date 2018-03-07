package com.facebook.video.creativeediting;

import android.content.Context;
import android.net.Uri;
import android.view.ViewStub;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;
import com.facebook.photos.creativeediting.model.VideoTrimParams;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger;
import com.facebook.video.creativeediting.analytics.VideoEditingGalleryEntryPoint;
import com.facebook.video.creativeediting.trimmer.StripSlidingControllerProvider;
import com.facebook.video.creativeediting.trimmer.StripZoomingControllerProvider;
import com.facebook.video.creativeediting.trimmer.VideoStripControllerProvider;
import com.facebook.video.creativeediting.utilities.StripViewVideoTimeConverterProvider;
import com.facebook.video.creativeediting.utilities.ZoomPositionConverter;
import com.facebook.videocodec.policy.VideoMirroringMode;

/* compiled from: dvr_file_available */
public class VideoTrimmingControllerProvider extends AbstractAssistedProvider<VideoTrimmingController> {
    public final VideoTrimmingController m19543a(Uri uri, Uri uri2, VideoMirroringMode videoMirroringMode, String str, ViewStub viewStub, VideoTrimParams videoTrimParams, VideoEditGalleryLaunchConfiguration videoEditGalleryLaunchConfiguration, VideoEditGalleryTrimmerFilmstripView videoEditGalleryTrimmerFilmstripView, VideoEditingGalleryEntryPoint videoEditingGalleryEntryPoint, VideoEditGalleryFragmentController videoEditGalleryFragmentController, VideoEditGalleryFragmentController videoEditGalleryFragmentController2) {
        return new VideoTrimmingController((Context) getInstance(Context.class), (VideoStripControllerProvider) getOnDemandAssistedProviderForStaticDi(VideoStripControllerProvider.class), ZoomPositionConverter.m19614a((InjectorLike) this), (StripViewVideoTimeConverterProvider) getOnDemandAssistedProviderForStaticDi(StripViewVideoTimeConverterProvider.class), (StripSlidingControllerProvider) getOnDemandAssistedProviderForStaticDi(StripSlidingControllerProvider.class), (StripZoomingControllerProvider) getOnDemandAssistedProviderForStaticDi(StripZoomingControllerProvider.class), VideoCreativeEditingLogger.m19546a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), uri, uri2, videoMirroringMode, str, viewStub, videoTrimParams, videoEditGalleryLaunchConfiguration, videoEditGalleryTrimmerFilmstripView, videoEditingGalleryEntryPoint, videoEditGalleryFragmentController, videoEditGalleryFragmentController2);
    }
}
