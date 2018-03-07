package com.facebook.messaging.media.upload;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.common.tempfile.BackingFileResolver.BackingFileResult;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.util.ExifOrientation;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Cancelable;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.config.MessagesVideoResizingPolicy;
import com.facebook.messaging.media.upload.config.MmsVideoResizingPolicy;
import com.facebook.messaging.media.upload.util.MediaHashCache;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.facebook.videocodec.base.VideoOperationProgressListener;
import com.facebook.videocodec.policy.AbstractVideoResizingPolicy;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.facebook.videocodec.prober.VideoProbeResult;
import com.facebook.videocodec.prober.VideoProber;
import com.facebook.videocodec.resizer.VideoResizeException;
import com.facebook.videocodec.resizer.VideoResizeResult;
import com.facebook.videocodec.resizer.VideoResizer;
import com.facebook.videocodec.resizer.VideoResizerParams;
import com.facebook.videocodec.resizer.VideoResizerParamsBuilder;
import com.facebook.videocodec.trimmer.VideoTrimmer;
import com.facebook.videocodec.trimmer.VideoTrimmerParams;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.inject.Inject;

@UserScoped
/* compiled from: lip_sync */
public class MediaUploadVideoResizeHandler implements BlueServiceHandler, Cancelable {
    private static final Object f11980q = new Object();
    public final VideoProber f11981a;
    public final VideoResizer f11982b;
    public final VideoTrimmer f11983c;
    public final TempFileManager f11984d;
    public final BackingFileResolver f11985e;
    public final MessagesVideoResizingPolicy f11986f;
    public final MmsVideoResizingPolicy f11987g = new MmsVideoResizingPolicy();
    public final BaseFbBroadcastManager f11988h;
    private final VideoResizeAnalyticsLogger f11989i;
    private final MediaResourceHelper f11990j;
    private final AbstractFbErrorReporter f11991k;
    private final MaxVideoSizeHelper f11992l;
    private final MediaHashCache f11993m;
    private final QuickExperimentController f11994n;
    public final VideoResizeOperationsMap f11995o = new VideoResizeOperationsMap();
    private final SkipVideoResizeHelper f11996p;

    /* compiled from: lip_sync */
    enum RESIZE_STATUS {
        skipped,
        completed,
        results_discarded,
        failure_ignored,
        unknown
    }

    /* compiled from: lip_sync */
    enum RESIZE_STRATEGY {
        trim,
        transcode,
        unknown
    }

    /* compiled from: lip_sync */
    public abstract class ResizeVideoStrategy {
        Future f11973a;

        abstract File mo459a(String str, MediaResource mediaResource);
    }

    /* compiled from: lip_sync */
    class TranscodeResizeVideoStrategy extends ResizeVideoStrategy {
        final /* synthetic */ MediaUploadVideoResizeHandler f11976b;

        public TranscodeResizeVideoStrategy(MediaUploadVideoResizeHandler mediaUploadVideoResizeHandler) {
            this.f11976b = mediaUploadVideoResizeHandler;
        }

        final File mo459a(String str, MediaResource mediaResource) {
            Preconditions.checkNotNull(mediaResource.c);
            BackingFileResult a = this.f11976b.f11985e.a(mediaResource.c, Privacy.PREFER_SDCARD);
            try {
                File a2 = m12529a(str, a.a, mediaResource);
                a.a();
                return a2;
            } catch (Throwable th) {
                a.a();
            }
        }

        private File m12529a(String str, File file, MediaResource mediaResource) {
            String str2;
            VideoProbeResult a = this.f11976b.f11981a.m19998a(file);
            TempFileManager tempFileManager = this.f11976b.f11984d;
            String str3 = "media_upload";
            if (Source.VIDEO_MMS == mediaResource.e) {
                str2 = ".3gp";
            } else {
                str2 = MediaUploadVideoResizeHandler.m12537a(this.f11976b, a);
            }
            File a2 = tempFileManager.a(str3, str2, Privacy.PREFER_SDCARD);
            this.a = m12528a(file, a2, mediaResource);
            this.f11976b.f11995o.m12593a(str, this.f11973a);
            while (true) {
                try {
                    FutureDetour.a(this.f11973a, 50, TimeUnit.MILLISECONDS, 172981008);
                    return a2;
                } catch (TimeoutException e) {
                    this.f11976b.f11995o.m12596c(str);
                } catch (ExecutionException e2) {
                    throw new VideoResizeException(e2.getCause());
                } catch (Throwable e3) {
                    Thread.currentThread().interrupt();
                    throw new VideoResizeException(e3);
                }
            }
        }

        private ListenableFuture<VideoResizeResult> m12528a(File file, File file2, final MediaResource mediaResource) {
            AbstractVideoResizingPolicy abstractVideoResizingPolicy;
            VideoMirroringMode videoMirroringMode;
            C13431 c13431 = new VideoOperationProgressListener(this) {
                final /* synthetic */ TranscodeResizeVideoStrategy f11975b;

                public final void m12527a(double d) {
                    this.f11975b.f11976b.f11988h.a(MediaUploadEvents.m12486a(mediaResource, d));
                }

                public final void m12526a() {
                }
            };
            VideoResizerParamsBuilder newBuilder = VideoResizerParams.newBuilder();
            newBuilder.a = file;
            newBuilder = newBuilder;
            newBuilder.b = file2;
            VideoResizerParamsBuilder videoResizerParamsBuilder = newBuilder;
            if (mediaResource.e == Source.VIDEO_MMS) {
                abstractVideoResizingPolicy = this.f11976b.f11987g;
            } else {
                abstractVideoResizingPolicy = this.f11976b.f11986f;
            }
            videoResizerParamsBuilder.c = abstractVideoResizingPolicy;
            newBuilder = videoResizerParamsBuilder;
            newBuilder.d = mediaResource.q;
            newBuilder = newBuilder;
            newBuilder.f = mediaResource.s;
            newBuilder = newBuilder;
            newBuilder.g = mediaResource.t;
            newBuilder = newBuilder;
            newBuilder.h = c13431;
            VideoResizerParamsBuilder videoResizerParamsBuilder2 = newBuilder;
            if (mediaResource.e == Source.QUICKCAM_FRONT) {
                videoMirroringMode = VideoMirroringMode.MIRROR_HORIZONTALLY;
            } else {
                videoMirroringMode = VideoMirroringMode.NONE;
            }
            videoResizerParamsBuilder2.e = videoMirroringMode;
            return this.f11976b.f11982b.a(videoResizerParamsBuilder2.o());
        }
    }

    /* compiled from: lip_sync */
    class TrimResizeVideoStrategy extends ResizeVideoStrategy {
        final /* synthetic */ MediaUploadVideoResizeHandler f11979b;

        public TrimResizeVideoStrategy(MediaUploadVideoResizeHandler mediaUploadVideoResizeHandler) {
            this.f11979b = mediaUploadVideoResizeHandler;
        }

        final File mo459a(String str, MediaResource mediaResource) {
            Preconditions.checkNotNull(mediaResource.c);
            BackingFileResult a = this.f11979b.f11985e.a(mediaResource.c, Privacy.PREFER_SDCARD);
            try {
                File a2 = m12534a(str, a.a, mediaResource);
                a.a();
                return a2;
            } catch (Throwable th) {
                a.a();
            }
        }

        private File m12534a(String str, File file, MediaResource mediaResource) {
            File a = this.f11979b.f11984d.a("media_upload", MediaUploadVideoResizeHandler.m12537a(this.f11979b, this.f11979b.f11981a.m19998a(file)), Privacy.PREFER_SDCARD);
            this.a = m12533a(file, a, mediaResource);
            this.f11979b.f11995o.m12593a(str, this.f11973a);
            while (true) {
                try {
                    FutureDetour.a(this.f11973a, 50, TimeUnit.MILLISECONDS, -2123778427);
                    return a;
                } catch (TimeoutException e) {
                    this.f11979b.f11995o.m12596c(str);
                } catch (ExecutionException e2) {
                    throw new VideoResizeException(e2.getCause());
                } catch (Throwable e3) {
                    Thread.currentThread().interrupt();
                    throw new VideoResizeException(e3);
                }
            }
        }

        private ListenableFuture<Void> m12533a(File file, File file2, final MediaResource mediaResource) {
            File file3 = file;
            File file4 = file2;
            return this.f11979b.f11983c.m20003a(new VideoTrimmerParams(file3, file4, mediaResource.s, mediaResource.t, new VideoOperationProgressListener(this) {
                final /* synthetic */ TrimResizeVideoStrategy f11978b;

                public final void m12532a(double d) {
                    this.f11978b.f11979b.f11988h.a(MediaUploadEvents.m12486a(mediaResource, d));
                }

                public final void m12531a() {
                }
            }));
        }
    }

    private static MediaUploadVideoResizeHandler m12540b(InjectorLike injectorLike) {
        return new MediaUploadVideoResizeHandler(VideoProber.m19997b(injectorLike), VideoResizer.a(injectorLike), VideoTrimmer.m20001a(injectorLike), TempFileManager.a(injectorLike), BackingFileResolver.a(injectorLike), MessagesVideoResizingPolicy.b(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), VideoResizeAnalyticsLogger.m12585a(injectorLike), MediaResourceHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), SkipVideoResizeHelper.a(injectorLike), MaxVideoSizeHelper.m12454b(injectorLike), MediaHashCache.a(injectorLike), (QuickExperimentController) QuickExperimentControllerImpl.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.MediaUploadVideoResizeHandler m12536a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f11980q;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m12540b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f11980q;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaUploadVideoResizeHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.upload.MediaUploadVideoResizeHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f11980q;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaUploadVideoResizeHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaUploadVideoResizeHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaUploadVideoResizeHandler");
    }

    public final OperationResult m12541a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("video_resize".equals(str)) {
            return m12539b(operationParams);
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    @Inject
    public MediaUploadVideoResizeHandler(VideoProber videoProber, VideoResizer videoResizer, VideoTrimmer videoTrimmer, TempFileManager tempFileManager, BackingFileResolver backingFileResolver, MessagesVideoResizingPolicy messagesVideoResizingPolicy, BaseFbBroadcastManager baseFbBroadcastManager, VideoResizeAnalyticsLogger videoResizeAnalyticsLogger, MediaResourceHelper mediaResourceHelper, AbstractFbErrorReporter abstractFbErrorReporter, SkipVideoResizeHelper skipVideoResizeHelper, MaxVideoSizeHelper maxVideoSizeHelper, MediaHashCache mediaHashCache, QuickExperimentController quickExperimentController) {
        this.f11981a = videoProber;
        this.f11982b = videoResizer;
        this.f11983c = videoTrimmer;
        this.f11984d = tempFileManager;
        this.f11985e = backingFileResolver;
        this.f11986f = messagesVideoResizingPolicy;
        this.f11988h = baseFbBroadcastManager;
        this.f11989i = videoResizeAnalyticsLogger;
        this.f11990j = mediaResourceHelper;
        this.f11991k = abstractFbErrorReporter;
        this.f11996p = skipVideoResizeHelper;
        this.f11992l = maxVideoSizeHelper;
        this.f11993m = mediaHashCache;
        this.f11994n = quickExperimentController;
    }

    public final boolean m12542a(String str) {
        return this.f11995o.m12594a(str);
    }

    private OperationResult m12539b(OperationParams operationParams) {
        MediaResource mediaResource;
        CancellationException cancellationException;
        int i;
        Throwable e;
        int i2;
        Stopwatch createStarted = Stopwatch.createStarted();
        String e2 = operationParams.e();
        Bundle b = operationParams.b();
        MediaResource mediaResource2 = (MediaResource) b.getParcelable("mediaResource");
        if (MediaResourceHelper.a(mediaResource2)) {
            mediaResource = mediaResource2;
        } else {
            mediaResource = this.f11990j.b(mediaResource2);
        }
        if (mediaResource.d != Type.VIDEO) {
            return OperationResult.a(ErrorCode.OTHER, "MediaResource is not a video.");
        }
        RESIZE_STRATEGY resize_strategy = RESIZE_STRATEGY.unknown;
        RESIZE_STRATEGY resize_strategy2;
        try {
            this.f11989i.m12589a(mediaResource);
            long j = mediaResource.p;
            RESIZE_STATUS resize_status = RESIZE_STATUS.unknown;
            int i3 = b.getInt("estimatedBytes");
            boolean z = b.getBoolean("isOutOfSpace", false);
            boolean a = m12538a(mediaResource);
            boolean c = MediaResourceHelper.c(mediaResource);
            if ((c || a) && z) {
                return OperationResult.a(ErrorCode.OTHER, "Not enough disk space to create new trimmed video.");
            }
            ResizeVideoStrategy resizeVideoStrategy;
            ResizeVideoStrategy transcodeResizeVideoStrategy;
            if (b.getBoolean("transcode", false)) {
                transcodeResizeVideoStrategy = new TranscodeResizeVideoStrategy(this);
                resize_strategy2 = RESIZE_STRATEGY.transcode;
                resizeVideoStrategy = transcodeResizeVideoStrategy;
            } else {
                transcodeResizeVideoStrategy = new TrimResizeVideoStrategy(this);
                resize_strategy2 = RESIZE_STRATEGY.trim;
                resizeVideoStrategy = transcodeResizeVideoStrategy;
            }
            try {
                File file;
                long length;
                RESIZE_STATUS resize_status2;
                Object obj;
                String str = "transcoded_video_larger";
                File file2 = null;
                int a2 = SkipVideoResizeHelper.a();
                int i4 = 1;
                Object obj2 = null;
                String str2 = str;
                RESIZE_STATUS resize_status3 = resize_status;
                while (i4 <= a2) {
                    try {
                        file2 = resizeVideoStrategy.mo459a(e2, mediaResource);
                        resize_status3 = RESIZE_STATUS.completed;
                        file = file2;
                        break;
                    } catch (CancellationException e3) {
                        throw e3;
                    } catch (Exception e4) {
                        Object obj3;
                        if (i4 < a2) {
                            str = str2;
                            obj3 = obj2;
                        } else if (this.f11996p.a(mediaResource)) {
                            obj3 = 1;
                            str = "transcoding_failed";
                        } else {
                            throw e4;
                        }
                        i4++;
                        obj2 = obj3;
                        str2 = str;
                        resize_status3 = RESIZE_STATUS.failure_ignored;
                    }
                }
                file = file2;
                if (obj2 != null || (resize_strategy2 == RESIZE_STRATEGY.transcode && mediaResource.e.isMediaPickerSource())) {
                    file2 = this.f11985e.a(mediaResource.c);
                } else {
                    file2 = null;
                }
                if (file2 == null || (file != null && file2.length() >= file.length())) {
                    MediaResource b2 = this.f11990j.b(MediaResource.a().a(mediaResource).b(mediaResource).a(Uri.fromFile(file)).b("video/mp4").a(0).b(0).a(ExifOrientation.UNDEFINED).c(0).c(-1).d(-2).a(MediaResource.b).b(c).C());
                    length = file.length();
                    resize_status2 = resize_status3;
                    obj = b2;
                } else {
                    MediaResource C = MediaResource.a().a(mediaResource).a(str2, Boolean.TRUE.toString()).C();
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    MediaResource mediaResource3;
                    if (resize_status3 != RESIZE_STATUS.failure_ignored) {
                        mediaResource3 = C;
                        length = j;
                        resize_status2 = RESIZE_STATUS.results_discarded;
                    } else {
                        mediaResource3 = C;
                        length = j;
                        resize_status2 = resize_status3;
                    }
                }
                this.f11988h.a(MediaUploadEvents.m12485a(mediaResource));
                this.f11995o.m12595b(e2);
                this.f11989i.m12590a(mediaResource, length, i3, resize_strategy2.name(), resize_status2.name(), createStarted.elapsed(TimeUnit.MILLISECONDS), i4, this.f11993m.b(mediaResource));
                return OperationResult.a(obj);
            } catch (CancellationException e32) {
                cancellationException = e32;
                i = 0;
                resize_strategy = resize_strategy2;
                this.f11989i.m12591a(mediaResource, resize_strategy.name(), createStarted.elapsed(TimeUnit.MILLISECONDS), i, this.f11993m.b(mediaResource));
                throw cancellationException;
            } catch (Exception e5) {
                e = e5;
                i2 = 0;
                this.f11989i.m12592a(mediaResource, resize_strategy2.name(), createStarted.elapsed(TimeUnit.MILLISECONDS), e, i2, this.f11993m.b(mediaResource));
                this.f11991k.a("MediaUploadVideoResizeHandler_Exception", e);
                throw e;
            }
        } catch (CancellationException e322) {
            cancellationException = e322;
            i = 0;
            this.f11989i.m12591a(mediaResource, resize_strategy.name(), createStarted.elapsed(TimeUnit.MILLISECONDS), i, this.f11993m.b(mediaResource));
            throw cancellationException;
        } catch (Exception e6) {
            e = e6;
            i2 = 0;
            resize_strategy2 = resize_strategy;
            this.f11989i.m12592a(mediaResource, resize_strategy2.name(), createStarted.elapsed(TimeUnit.MILLISECONDS), e, i2, this.f11993m.b(mediaResource));
            this.f11991k.a("MediaUploadVideoResizeHandler_Exception", e);
            throw e;
        }
    }

    private boolean m12538a(MediaResource mediaResource) {
        return mediaResource.p > ((long) this.f11992l.m12455a());
    }

    static /* synthetic */ String m12537a(MediaUploadVideoResizeHandler mediaUploadVideoResizeHandler, VideoProbeResult videoProbeResult) {
        String str;
        if (videoProbeResult.f20421a.isPresent()) {
            str = (String) videoProbeResult.f20421a.get();
            if (str.equals("audio/3gpp") || str.equals("audio/amr-wb")) {
                str = ".3gp";
            } else {
                str = ".mp4";
            }
        } else {
            str = ".mp4";
        }
        return str;
    }
}
