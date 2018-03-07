package com.facebook.media.upload.video;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbuploader.fbcommon.FbUploaderSingletonWrapper;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.media.common.MediaLogger;
import com.facebook.media.upload.MediaUploadParameters;
import com.facebook.media.upload.MediaUploadResult;
import com.facebook.media.upload.common.CancelHandler;
import com.facebook.media.upload.video.post.VideoUploadPostRequestManager;
import com.facebook.media.upload.video.post.VideoUploadPostRequestManagerProvider;
import com.facebook.media.upload.video.receive.VideoUploadReceiveRequestManager;
import com.facebook.media.upload.video.receive.VideoUploadReceiveRequestManagerProvider;
import com.facebook.media.upload.video.start.VideoUploadStartRequestManager;
import com.facebook.media.upload.video.start.VideoUploadStartRequestManagerProvider;
import com.facebook.media.upload.video.start.VideoUploadStartResponse;
import com.facebook.photos.base.media.VideoItem;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: json_parse_error */
public class VideoUploadSession {
    private final VideoUploadStartRequestManagerProvider f11922a;
    private final VideoUploadReceiveRequestManagerProvider f11923b;
    private final VideoUploadPostRequestManagerProvider f11924c;
    private VideoUploadStartRequestManager f11925d;
    private VideoUploadReceiveRequestManager f11926e;
    private VideoUploadPostRequestManager f11927f;
    public VideoItem f11928g;
    private MediaUploadParameters f11929h;
    public CancelHandler f11930i;
    private MediaLogger f11931j;
    public boolean f11932k = true;
    private VideoUploadStartResponse f11933l;
    private boolean f11934m;
    private boolean f11935n;

    @Inject
    public VideoUploadSession(VideoUploadStartRequestManagerProvider videoUploadStartRequestManagerProvider, VideoUploadReceiveRequestManagerProvider videoUploadReceiveRequestManagerProvider, VideoUploadPostRequestManagerProvider videoUploadPostRequestManagerProvider, CancelHandler cancelHandler, @Assisted MediaLogger mediaLogger) {
        this.f11930i = cancelHandler;
        this.f11922a = videoUploadStartRequestManagerProvider;
        this.f11923b = videoUploadReceiveRequestManagerProvider;
        this.f11924c = videoUploadPostRequestManagerProvider;
        this.f11931j = mediaLogger;
    }

    public final MediaUploadResult m18873a(MediaItem mediaItem, MediaUploadParameters mediaUploadParameters, boolean z) {
        Preconditions.checkArgument(mediaItem.m() == MediaType.VIDEO, "VideoUploadSession should be given a video file");
        this.f11928g = (VideoItem) mediaItem;
        this.f11929h = mediaUploadParameters;
        VideoUploadStartRequestManagerProvider videoUploadStartRequestManagerProvider = this.f11922a;
        this.f11925d = new VideoUploadStartRequestManager((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(videoUploadStartRequestManagerProvider), (VideoUploadErrorHandlerProvider) videoUploadStartRequestManagerProvider.getOnDemandAssistedProviderForStaticDi(VideoUploadErrorHandlerProvider.class), this.f11931j);
        VideoUploadReceiveRequestManagerProvider videoUploadReceiveRequestManagerProvider = this.f11923b;
        this.f11926e = new VideoUploadReceiveRequestManager((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(videoUploadReceiveRequestManagerProvider), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(videoUploadReceiveRequestManagerProvider), FbUploaderSingletonWrapper.m15786a(videoUploadReceiveRequestManagerProvider), (VideoUploadErrorHandlerProvider) videoUploadReceiveRequestManagerProvider.getOnDemandAssistedProviderForStaticDi(VideoUploadErrorHandlerProvider.class), this.f11931j);
        VideoUploadPostRequestManagerProvider videoUploadPostRequestManagerProvider = this.f11924c;
        this.f11927f = new VideoUploadPostRequestManager((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(videoUploadPostRequestManagerProvider), (VideoUploadErrorHandlerProvider) videoUploadPostRequestManagerProvider.getOnDemandAssistedProviderForStaticDi(VideoUploadErrorHandlerProvider.class), this.f11931j);
        this.f11932k = z;
        this.f11933l = null;
        this.f11935n = false;
        this.f11934m = false;
        m18870d();
        this.f11930i.m18858a("Before transferring file");
        m18871e();
        this.f11930i.m18858a("After transferring file");
        if (!this.f11929h.f11893c) {
            m18872f();
        }
        return new MediaUploadResult(this.f11933l.f11987a, this.f11933l.f11988b);
    }

    private void m18870d() {
        if (this.f11933l == null) {
            this.f11933l = this.f11925d.m18899a(this.f11928g, this.f11929h, this.f11930i);
        }
    }

    private void m18871e() {
        if (!this.f11934m) {
            this.f11926e.m18893a(this.f11928g, this.f11929h, this.f11933l, this.f11930i);
            this.f11934m = true;
        }
    }

    private void m18872f() {
        if (!this.f11935n) {
            this.f11927f.m18877a(this.f11933l, this.f11929h, this.f11930i);
            this.f11935n = true;
        }
    }
}
