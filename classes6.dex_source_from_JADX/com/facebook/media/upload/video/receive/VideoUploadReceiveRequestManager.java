package com.facebook.media.upload.video.receive;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbuploader.Config;
import com.facebook.fbuploader.Config.Namespace;
import com.facebook.fbuploader.Config.RetryPolicy;
import com.facebook.fbuploader.Content;
import com.facebook.fbuploader.FbUploaderImpl;
import com.facebook.fbuploader.FbUploaderImpl.FbUploadJobHandleImpl;
import com.facebook.fbuploader.Listener;
import com.facebook.fbuploader.UploadFailureException;
import com.facebook.fbuploader.UploadResult;
import com.facebook.fbuploader.fbcommon.FbUploaderSingletonWrapper;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.inject.Assisted;
import com.facebook.media.common.MediaLogger;
import com.facebook.media.upload.MediaUploadParameters;
import com.facebook.media.upload.common.CancelHandler;
import com.facebook.media.upload.video.InvalidOffsetException;
import com.facebook.media.upload.video.VideoUploadErrorHandler;
import com.facebook.media.upload.video.VideoUploadErrorHandlerProvider;
import com.facebook.media.upload.video.start.VideoUploadStartResponse;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.upload.event.BaseMediaUploadEvent$Status;
import com.facebook.photos.upload.event.VideoUploadProgressEvent;
import com.facebook.photos.upload.uploaders.VideoUploaderProgressListener;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;

/* compiled from: iu */
public class VideoUploadReceiveRequestManager {
    private static final CallerContext f11958a = CallerContext.a(VideoUploadReceiveRequestManager.class);
    private final AbstractSingleMethodRunner f11959b;
    private final MonotonicClock f11960c;
    private final VideoUploadReceiveMethod f11961d = new VideoUploadReceiveMethod();
    private final FbUploaderImpl f11962e;
    private final MediaLogger f11963f;
    private float f11964g;
    private ApiMethodRunnerParams f11965h;
    private UploadProgressListener f11966i;
    private VideoUploadErrorHandlerProvider f11967j;
    private VideoUploadErrorHandler f11968k;
    private CancelHandler f11969l;
    public VideoItem f11970m;
    private MediaUploadParameters f11971n;
    private String f11972o;
    private long f11973p;
    private int f11974q = 0;
    private long f11975r;
    private long f11976s;

    /* compiled from: iu */
    class UploadProgressListener implements Listener {
        final /* synthetic */ VideoUploadReceiveRequestManager f11949a;
        private float f11950b;
        private long f11951c;
        private long f11952d;
        private long f11953e;
        private long f11954f;
        private long f11955g;
        private VideoUploaderProgressListener f11956h;
        private final MonotonicClock f11957i;

        public UploadProgressListener(VideoUploadReceiveRequestManager videoUploadReceiveRequestManager, VideoUploaderProgressListener videoUploaderProgressListener, long j, long j2, MonotonicClock monotonicClock) {
            this.f11949a = videoUploadReceiveRequestManager;
            Preconditions.checkArgument(j2 > 0, "Length of transfer must be greater than 0");
            this.f11956h = videoUploaderProgressListener;
            this.f11951c = j;
            this.f11952d = j2;
            this.f11957i = monotonicClock;
            this.f11954f = 0;
            this.f11950b = 0.0f;
            this.f11953e = 0;
        }

        public final void mo1026a() {
        }

        public final void mo1027a(float f) {
            this.f11955g = (long) (((float) this.f11954f) * f);
            m18880a(this.f11951c + this.f11955g);
        }

        public final void mo1028a(UploadFailureException uploadFailureException) {
        }

        public final void mo1030b() {
        }

        public final void mo1029a(UploadResult uploadResult) {
        }

        public final void m18883a(long j, long j2) {
            this.f11951c = j;
            this.f11955g = 0;
            this.f11954f = j2 - j;
        }

        public final long m18887c() {
            return this.f11955g;
        }

        private void m18880a(long j) {
            if (this.f11956h != null) {
                if (this.f11957i.now() - this.f11953e >= 1000 || j == this.f11952d) {
                    float min = Math.min(Math.max((((float) j) / ((float) this.f11952d)) * 100.0f, 0.0f), 100.0f);
                    if (min > this.f11950b) {
                        this.f11953e = this.f11957i.now();
                        this.f11950b = min;
                        VideoUploaderProgressListener videoUploaderProgressListener = this.f11956h;
                        if (!videoUploaderProgressListener.f14569d.f14351d) {
                            videoUploaderProgressListener.f14570e.a(new VideoUploadProgressEvent(videoUploaderProgressListener.f14566a, BaseMediaUploadEvent$Status.UPLOADING, (int) min));
                        }
                    }
                }
            }
        }
    }

    public final void m18893a(VideoItem videoItem, MediaUploadParameters mediaUploadParameters, VideoUploadStartResponse videoUploadStartResponse, CancelHandler cancelHandler) {
        if (!videoUploadStartResponse.f11991e) {
            if (this.f11970m == null) {
                this.f11970m = videoItem;
                this.f11971n = mediaUploadParameters;
                this.f11972o = videoUploadStartResponse.f11987a;
                this.f11973p = m18888a();
                this.f11964g = 0.0f;
                this.f11969l = cancelHandler;
                this.f11968k = this.f11967j.m18867a(this.f11969l);
                this.f11965h = new ApiMethodRunnerParams();
                this.f11965h.c = this.f11969l.f11914a;
                this.f11966i = new UploadProgressListener(this, mediaUploadParameters.f11898h, videoUploadStartResponse.m18901c(), this.f11973p, this.f11960c);
                this.f11975r = videoUploadStartResponse.m18901c();
                this.f11976s = videoUploadStartResponse.m18902d();
            } else {
                Preconditions.checkState(this.f11970m.e() == videoItem.e(), "Request manager should not be reused for different files.");
                this.f11968k.m18865b();
            }
            m18891b();
        }
    }

    @Inject
    public VideoUploadReceiveRequestManager(AbstractSingleMethodRunner abstractSingleMethodRunner, MonotonicClock monotonicClock, FbUploaderSingletonWrapper fbUploaderSingletonWrapper, VideoUploadErrorHandlerProvider videoUploadErrorHandlerProvider, @Assisted MediaLogger mediaLogger) {
        this.f11959b = abstractSingleMethodRunner;
        this.f11960c = monotonicClock;
        this.f11962e = fbUploaderSingletonWrapper.f10102a;
        this.f11967j = videoUploadErrorHandlerProvider;
        this.f11963f = mediaLogger;
    }

    private long m18888a() {
        return new File(this.f11970m.e()).length();
    }

    private void m18891b() {
        String str = "";
        while (this.f11975r < this.f11973p) {
            try {
                this.f11966i.m18883a(this.f11975r, this.f11976s);
                str = m18890a(this.f11971n.m18849a(), this.f11975r);
                VideoUploadReceiveResponse a = m18889a(str);
                this.f11975r = a.m18894a();
                this.f11976s = a.m18895b();
            } catch (InvalidOffsetException e) {
                this.f11975r = e.m18860a();
                this.f11976s = e.m18861b();
            } catch (CancellationException e2) {
                CancellationException cancellationException = e2;
                this.f11963f.m18802b(this.f11972o, this.f11966i.m18887c(), this.f11976s - this.f11975r, this.f11968k.m18863a(), str);
                throw cancellationException;
            } catch (Exception e3) {
                this.f11963f.m18795a(this.f11972o, this.f11966i.m18887c(), this.f11976s - this.f11975r, this.f11968k.m18863a(), str, e3);
                throw e3;
            }
            this.f11968k.m18866c();
        }
    }

    private VideoUploadReceiveResponse m18889a(String str) {
        VideoUploadReceiveResponse videoUploadReceiveResponse;
        long j = this.f11976s - this.f11975r;
        this.f11963f.m18796a(this.f11972o, this.f11975r, j, str);
        while (true) {
            try {
                long now = this.f11960c.now();
                this.f11969l.m18858a("Before sending chunk with resumable");
                String c = m18892c();
                this.f11969l.m18858a("After sending chunk with resumable");
                videoUploadReceiveResponse = (VideoUploadReceiveResponse) this.f11959b.a(this.f11961d, new VideoUploadReceiveParams(this.f11972o, this.f11975r, this.f11964g, this.f11971n, c), this.f11965h, f11958a);
                this.f11969l.m18858a("After sending result handle");
                this.f11964g = ((float) j) / ((float) ((this.f11960c.now() - now) + 1));
                this.f11963f.m18794a(this.f11972o, this.f11975r, j, this.f11968k.m18863a(), str);
                break;
            } catch (Exception e) {
                this.f11968k.m18864a(e);
            }
        }
        return videoUploadReceiveResponse;
    }

    private String m18892c() {
        long j = this.f11975r;
        long j2 = this.f11976s;
        Content content = new Content(new File(this.f11970m.e()), j, j2 - j, this.f11970m.i());
        RetryPolicy retryPolicy = new RetryPolicy(0, 0, 0);
        Map hashMap = new HashMap();
        hashMap.put("X_FB_VIDEO_WATERFALL_ID", this.f11971n.f11891a);
        FbUploadJobHandleImpl a = this.f11962e.m15754a(content, new Config(Namespace.FACEBOOK, hashMap, retryPolicy), this.f11966i);
        this.f11969l.f11917d = a;
        String str = this.f11962e.m15756b(a).f10081a;
        this.f11969l.f11917d = null;
        return str;
    }

    private String m18890a(String str, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("_");
        stringBuilder.append(this.f11960c.now());
        stringBuilder.append("_");
        stringBuilder.append(j);
        stringBuilder.append("_");
        int i = this.f11974q;
        this.f11974q = i + 1;
        stringBuilder.append(i);
        return stringBuilder.toString();
    }
}
