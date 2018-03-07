package com.facebook.photos.upload.uploaders;

import android.os.Bundle;
import android.util.Pair;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.media.MediaItem;
import com.facebook.media.transcode.MediaTranscodeParameters;
import com.facebook.media.transcode.MediaTranscodeResult;
import com.facebook.media.transcode.MediaTranscoder;
import com.facebook.media.transcode.video.VideoEditConfig;
import com.facebook.media.transcode.video.VideoEditConfig.Builder;
import com.facebook.media.transcode.video.VideoTranscodeParameters;
import com.facebook.media.upload.MediaAttachementBody;
import com.facebook.media.upload.MediaUploadParameters;
import com.facebook.media.upload.MediaUploadResult;
import com.facebook.media.upload.MediaUploader;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.base.analytics.InterpretedException;
import com.facebook.photos.base.analytics.LoggingTypes.SourceType;
import com.facebook.photos.base.analytics.LoggingTypes.UploadMethodType;
import com.facebook.photos.base.analytics.PhotoFlowLogger$ExceptionReporter;
import com.facebook.photos.base.analytics.ResumableUploadLogger;
import com.facebook.photos.base.analytics.TranscodingFailedException;
import com.facebook.photos.base.analytics.upload.UploadBaseParams;
import com.facebook.photos.base.media.MediaItemFactory$VideoItemBuilder;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.upload.abtest.OptimisticVideoUploadQuickExperiment;
import com.facebook.photos.upload.event.BaseMediaUploadEvent$Status;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.VideoUploadProgressEvent;
import com.facebook.photos.upload.manager.UploadCrashMonitor;
import com.facebook.photos.upload.operation.TranscodeInfo;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.PublishMethod;
import com.facebook.photos.upload.operation.UploadOperationHelper;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.operation.UploadRecords;
import com.facebook.photos.upload.protocol.UploadVideoChunkCancelMethod;
import com.facebook.photos.upload.protocol.UploadVideoChunkCancelParams;
import com.facebook.photos.upload.protocol.UploadVideoChunkPostMethod;
import com.facebook.photos.upload.protocol.UploadVideoChunkPostParams;
import com.facebook.photos.upload.protocol.UploadVideoChunkSettingsMethod;
import com.facebook.photos.upload.protocol.UploadVideoChunkSettingsParams;
import com.facebook.photos.upload.protocol.UploadVideoChunkSettingsResponse;
import com.facebook.photos.upload.protocol.UploadVideoChunkStartMethod;
import com.facebook.photos.upload.protocol.UploadVideoChunkStartParams;
import com.facebook.photos.upload.protocol.UploadVideoChunkStartResponse;
import com.facebook.photos.upload.protocol.UploadVideoPostHelper;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.videocodec.base.VideoOperationProgressListener;
import com.facebook.videocodec.resizer.VideoResizeException;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: friends_locations_feedstory_scroll_left */
public class VideoUploader implements MediaUploader {
    private static final Class<?> f14524a = VideoUploader.class;
    private static final WeakHashMap<String, UploadSessionContext> f14525b = new WeakHashMap();
    private final QeAccessor f14526A;
    private final MediaTranscoder f14527B;
    private final MediaUploader f14528C;
    private Future<MediaTranscodeResult> f14529D;
    private Future<MediaUploadResult> f14530E;
    private final FbObjectMapper f14531F;
    private final GatekeeperStoreImpl f14532G;
    private final Clock f14533c;
    public final MediaUploadEventBus f14534d;
    public final AbstractSingleMethodRunner f14535e;
    private final UploadOperationHelper f14536f;
    private final UploadCrashMonitor f14537g;
    private final Provider<ImmediateRetryPolicy> f14538h;
    private final MediaUploadCancelHandler f14539i;
    private final AbstractFbErrorReporter f14540j;
    private final UploadVideoChunkSettingsMethod f14541k;
    private final UploadVideoChunkStartMethod f14542l;
    private final UploadVideoChunkPostMethod f14543m;
    public final UploadVideoChunkCancelMethod f14544n;
    private final ResizeProgressListener f14545o;
    private final VideoUploadResizeHandler f14546p;
    private final MonotonicClock f14547q;
    private final ResumableUploadLogger f14548r;
    private final ChunkUploadDelegator f14549s;
    private VideoUploaderExceptionHandler f14550t;
    private VideoSegmentUploadDelegator f14551u;
    private final DefaultAndroidThreadUtil f14552v;
    private Semaphore f14553w;
    private final VideoUploadStateParams f14554x = new VideoUploadStateParams();
    private final Provider<Boolean> f14555y;
    private final Provider<Boolean> f14556z;

    /* compiled from: friends_locations_feedstory_scroll_left */
    public class ResizeProgressListener implements VideoOperationProgressListener {
        private final long f14514a = 100;
        private final WeakReference<VideoUploader> f14515b;
        private final Clock f14516c;
        private final MediaUploadCancelHandler f14517d;
        private WeakReference<UploadOperation> f14518e;
        private long f14519f = 0;
        private int f14520g = 0;
        private boolean f14521h = false;
        private int f14522i = 1;
        private boolean f14523j = false;

        public ResizeProgressListener(VideoUploader videoUploader, Clock clock, MediaUploadCancelHandler mediaUploadCancelHandler) {
            this.f14515b = new WeakReference(videoUploader);
            this.f14516c = clock;
            this.f14517d = mediaUploadCancelHandler;
        }

        public final void m22111a(UploadOperation uploadOperation, int i) {
            Preconditions.checkArgument(i > 0);
            this.f14518e = new WeakReference(uploadOperation);
            this.f14519f = 0;
            this.f14522i = i;
            this.f14520g = 0;
            this.f14523j = false;
            if (this.f14522i > 1) {
                this.f14521h = true;
            } else {
                this.f14521h = false;
            }
        }

        public final void m22110a(int i) {
            boolean z = i <= this.f14522i && i >= 0;
            Preconditions.checkState(z);
            this.f14520g = i;
        }

        public final void m22112b() {
            this.f14523j = true;
            mo1160a();
        }

        public final void mo1161a(double d) {
            VideoUploader videoUploader = (VideoUploader) this.f14515b.get();
            long a = this.f14516c.a();
            if (videoUploader != null && a - this.f14519f >= 100) {
                this.f14519f = a;
                if (this.f14521h) {
                    d = m22107b(d);
                }
                videoUploader.m22144a(d, this.f14518e == null ? null : (UploadOperation) this.f14518e.get());
            }
        }

        private double m22107b(double d) {
            return (Math.min(1.0d, Math.max(0.0d, d)) + ((double) this.f14520g)) / ((double) this.f14522i);
        }

        public final void mo1160a() {
            if (!this.f14521h || this.f14523j) {
                VideoUploader videoUploader = (VideoUploader) this.f14515b.get();
                if (videoUploader != null && !this.f14517d.f14351d) {
                    UploadOperation uploadOperation;
                    if (this.f14518e == null) {
                        uploadOperation = null;
                    } else {
                        uploadOperation = (UploadOperation) this.f14518e.get();
                    }
                    if (uploadOperation != null) {
                        videoUploader.f14534d.a(new VideoUploadProgressEvent(uploadOperation, BaseMediaUploadEvent$Status.PROCESSING, 100));
                    }
                }
            }
        }
    }

    /* compiled from: friends_locations_feedstory_scroll_left */
    public class VideoProcessException extends InterpretedException {
        public VideoProcessException(String str, boolean z) {
            super(str, z);
        }
    }

    public static VideoUploader m22129b(InjectorLike injectorLike) {
        return new VideoUploader((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), MediaUploadEventBus.a(injectorLike), UploadOperationHelper.m21580a(injectorLike), UploadCrashMonitor.a(injectorLike), IdBasedProvider.a(injectorLike, 9491), MediaUploadCancelHandler.m21996a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), UploadVideoChunkSettingsMethod.m21863a(injectorLike), UploadVideoChunkStartMethod.m21869a(injectorLike), UploadVideoChunkPostMethod.m21839a(injectorLike), UploadVideoChunkCancelMethod.m21836a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), VideoUploadResizeHandler.m22087a(injectorLike), VideoSegmentUploadDelegator.m22080a(injectorLike), ChunkUploadDelegator.m21951a(injectorLike), IdBasedProvider.a(injectorLike, 4257), DefaultAndroidThreadUtil.a(injectorLike), ResumableUploadLogger.m20000a(injectorLike), IdBasedProvider.a(injectorLike, 4258), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), MediaTranscoder.m18812a(injectorLike), MediaUploader.m18852a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public VideoUploader(SingleMethodRunner singleMethodRunner, Clock clock, MediaUploadEventBus mediaUploadEventBus, UploadOperationHelper uploadOperationHelper, UploadCrashMonitor uploadCrashMonitor, Provider<ImmediateRetryPolicy> provider, MediaUploadCancelHandler mediaUploadCancelHandler, FbErrorReporter fbErrorReporter, UploadVideoChunkSettingsMethod uploadVideoChunkSettingsMethod, UploadVideoChunkStartMethod uploadVideoChunkStartMethod, UploadVideoChunkPostMethod uploadVideoChunkPostMethod, UploadVideoChunkCancelMethod uploadVideoChunkCancelMethod, MonotonicClock monotonicClock, VideoUploadResizeHandler videoUploadResizeHandler, VideoSegmentUploadDelegator videoSegmentUploadDelegator, ChunkUploadDelegator chunkUploadDelegator, Provider<Boolean> provider2, AndroidThreadUtil androidThreadUtil, ResumableUploadLogger resumableUploadLogger, Provider<Boolean> provider3, QeAccessor qeAccessor, MediaTranscoder mediaTranscoder, MediaUploader mediaUploader, FbObjectMapper fbObjectMapper, GatekeeperStore gatekeeperStore) {
        this.f14535e = singleMethodRunner;
        this.f14533c = clock;
        this.f14534d = mediaUploadEventBus;
        this.f14536f = uploadOperationHelper;
        this.f14537g = uploadCrashMonitor;
        this.f14538h = provider;
        this.f14539i = mediaUploadCancelHandler;
        this.f14540j = fbErrorReporter;
        this.f14541k = uploadVideoChunkSettingsMethod;
        this.f14542l = uploadVideoChunkStartMethod;
        this.f14543m = uploadVideoChunkPostMethod;
        this.f14544n = uploadVideoChunkCancelMethod;
        this.f14545o = new ResizeProgressListener(this, this.f14533c, this.f14539i);
        this.f14547q = monotonicClock;
        this.f14549s = chunkUploadDelegator;
        this.f14546p = videoUploadResizeHandler;
        this.f14551u = videoSegmentUploadDelegator;
        this.f14555y = provider2;
        this.f14552v = androidThreadUtil;
        this.f14548r = resumableUploadLogger;
        this.f14556z = provider3;
        this.f14526A = qeAccessor;
        this.f14527B = mediaTranscoder;
        this.f14528C = mediaUploader;
        this.f14531F = fbObjectMapper;
        this.f14532G = gatekeeperStore;
    }

    public final void mo1158a() {
        this.f14539i.m21999a();
        this.f14553w = new Semaphore(0);
    }

    public final boolean mo1159b() {
        if (!(this.f14529D == null || this.f14529D.isDone())) {
            this.f14529D.cancel(true);
        }
        if (!(this.f14530E == null || this.f14530E.isDone())) {
            this.f14530E.cancel(true);
        }
        if (this.f14553w != null) {
            this.f14553w.release();
        }
        return this.f14539i.m22005c();
    }

    public final OperationResult mo1157a(UploadOperation uploadOperation) {
        try {
            if (!uploadOperation.m21521Z()) {
                this.f14537g.e(uploadOperation);
            }
            UploadSessionContext d = m22135d(uploadOperation);
            m22130b(d);
            OperationResult f = m22139f(d);
            return f;
        } finally {
            if (!uploadOperation.m21521Z()) {
                this.f14537g.a(uploadOperation.m21509N());
            }
        }
    }

    private void m22119a(UploadSessionContext uploadSessionContext) {
        DefaultPhotoFlowLogger defaultPhotoFlowLogger = uploadSessionContext.f14490x;
        UploadOperation uploadOperation = uploadSessionContext.f14467a;
        Preconditions.checkNotNull(defaultPhotoFlowLogger, "Logger cannot be null");
        Preconditions.checkNotNull(uploadOperation, "Upload Operation cannot be null");
        uploadSessionContext.f14491y = null;
        if (this.f14546p.m22100a(uploadSessionContext, defaultPhotoFlowLogger, uploadOperation)) {
            m22120a(uploadSessionContext, defaultPhotoFlowLogger, uploadOperation);
        } else {
            defaultPhotoFlowLogger.m19852a(uploadSessionContext.f14492z, uploadSessionContext.f14479m, uploadSessionContext.f14466T.f14437a / 1000);
        }
        uploadSessionContext.f14480n = uploadOperation.f13767P;
    }

    private void m22120a(UploadSessionContext uploadSessionContext, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadOperation uploadOperation) {
        boolean z = false;
        try {
            boolean z2;
            if (uploadSessionContext.f14454H || uploadSessionContext.f14483q < 20000) {
                z2 = false;
            } else {
                z2 = this.f14526A.a((short) -28536, false);
            }
            boolean z3 = true;
            uploadSessionContext.f14464R = 0;
            while (z3) {
                m22122a(uploadSessionContext, z2);
                z = m22124a(uploadSessionContext, defaultPhotoFlowLogger, uploadOperation, z2);
                m22131b(uploadSessionContext, z);
                z3 = VideoUploadResizeHandler.m22095a(z, uploadSessionContext);
                uploadSessionContext.f14464R++;
            }
            if (uploadSessionContext.f14454H && !r0) {
                throw new TranscodingFailedException(new VideoProcessException("Transcoding failed when editing is specified", false));
            }
        } catch (Exception e) {
            throw new PartialUploadException(new ExceptionInterpreter(e));
        }
    }

    private boolean m22124a(UploadSessionContext uploadSessionContext, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadOperation uploadOperation, boolean z) {
        if (z) {
            uploadSessionContext.f14491y = this.f14546p.m22098a(uploadSessionContext, uploadOperation, defaultPhotoFlowLogger, this.f14545o, this.f14539i);
            if (uploadSessionContext.f14491y != null) {
                return true;
            }
        }
        TranscodeItem b = this.f14546p.m22101b(uploadSessionContext, uploadOperation, defaultPhotoFlowLogger, this.f14545o, this.f14539i);
        if (b != null) {
            uploadSessionContext.f14476j = b.f14435a;
            return true;
        }
        return false;
    }

    private void m22130b(UploadSessionContext uploadSessionContext) {
        if (uploadSessionContext.f14451E) {
            uploadSessionContext.f14490x.m19888a(uploadSessionContext.f14492z, uploadSessionContext.f14450D.f5487h.f5478b, uploadSessionContext.f14450D.f5487h.f5479c);
        } else {
            m22140g(uploadSessionContext);
            uploadSessionContext.f14466T = TranscodeSettings.m22067a(uploadSessionContext.f14467a.am, uploadSessionContext.f14467a.f13768Q, uploadSessionContext.f14448B.transcodeInfo);
            if (this.f14526A.a((short) -32026, false)) {
                m22133c(uploadSessionContext);
            } else {
                m22119a(uploadSessionContext);
            }
        }
        if (uploadSessionContext.f14491y != null) {
            SegmentedUploadItem segmentedUploadItem = uploadSessionContext.f14491y;
            uploadSessionContext.f14478l = ((UploadAssetSegment) segmentedUploadItem.f14434b.get(segmentedUploadItem.f14434b.size() - 1)).f14445f;
            uploadSessionContext.f14476j = uploadSessionContext.f14491y.m22063a().f14440a;
            return;
        }
        uploadSessionContext.f14478l = new File(uploadSessionContext.f14476j).length();
    }

    private void m22133c(UploadSessionContext uploadSessionContext) {
        uploadSessionContext.f14491y = null;
        UploadOperation uploadOperation = uploadSessionContext.f14467a;
        Preconditions.checkNotNull(uploadOperation, "Upload Operation cannot be null");
        MediaTranscodeParameters b = m22128b(uploadSessionContext, uploadOperation);
        if (b != null) {
            try {
                this.f14529D = this.f14527B.m18814a(uploadOperation.m21509N(), VideoUploadResizeHandler.m22082a(uploadOperation), b, "videouploader");
                MediaTranscodeResult mediaTranscodeResult = (MediaTranscodeResult) FutureDetour.a(this.f14529D, 1082509366);
                uploadSessionContext.f14480n = mediaTranscodeResult.m18810a();
                if (mediaTranscodeResult.m18810a()) {
                    uploadSessionContext.f14476j = mediaTranscodeResult.m18811b().e();
                }
                this.f14529D = null;
            } catch (ExecutionException e) {
                this.f14539i.m22001a("Transcoding in the media library");
                Throwable cause = e.getCause();
                if (cause == null || !(cause instanceof VideoResizeException)) {
                    throw e;
                }
                throw new PartialUploadException(new ExceptionInterpreter(new TranscodingFailedException(cause)));
            }
        }
    }

    private void m22122a(UploadSessionContext uploadSessionContext, boolean z) {
        TranscodeInfo transcodeInfo = uploadSessionContext.f14448B.transcodeInfo;
        transcodeInfo.transcodeStartCount++;
        transcodeInfo.isSegmentedTranscode = z;
        m22138e(uploadSessionContext);
    }

    private void m22131b(UploadSessionContext uploadSessionContext, boolean z) {
        TranscodeInfo transcodeInfo = uploadSessionContext.f14448B.transcodeInfo;
        if (z) {
            transcodeInfo.transcodeSuccessCount++;
        } else {
            transcodeInfo.transcodeFailCount++;
        }
        m22138e(uploadSessionContext);
    }

    private UploadSessionContext m22135d(UploadOperation uploadOperation) {
        UploadSessionContext e = m22137e(uploadOperation);
        Preconditions.checkNotNull(e, "Upload Session Context cannot be null");
        e.f14490x = this.f14536f.m21584a(uploadOperation, this.f14533c.a());
        e.f14492z = e.f14490x.m19837a("2.1", UploadMethodType.CHUNKED);
        e.f14490x.m19939f(e.f14492z, uploadOperation);
        ImmediateRetryPolicy immediateRetryPolicy = (ImmediateRetryPolicy) this.f14538h.get();
        if (((Boolean) this.f14556z.get()).booleanValue()) {
            immediateRetryPolicy.mo1150a(uploadOperation.m21541i());
            immediateRetryPolicy.mo1149a(this.f14553w);
        }
        this.f14550t = new VideoUploaderExceptionHandler(this.f14539i, immediateRetryPolicy, e.f14490x, e.f14492z, uploadOperation, null, this.f14531F);
        VideoItem a = VideoUploadResizeHandler.m22082a(uploadOperation);
        String e2 = a.e();
        e.f14476j = e2;
        e.f14482p = e2;
        e.f14479m = new File(e.f14482p).length();
        e.f14477k = a.i();
        VideoUploadResizeHandler.m22092a(uploadOperation, e);
        m22136d(e);
        TranscodeInfo transcodeInfo = e.f14448B.transcodeInfo;
        transcodeInfo.flowStartCount++;
        m22138e(e);
        try {
            e.f14450D = this.f14546p.m22099a(a);
            e.f14483q = e.f14450D.f5480a;
            e.f14484r = e.f14450D.f5481b >= e.f14450D.f5482c ? e.f14450D.f5481b : e.f14450D.f5482c;
            e.f14485s = e.f14450D.f5486g;
            e.f14451E = e.f14450D.m8159a();
        } catch (Exception e3) {
            e.f14483q = 0;
            e.f14484r = -1;
            e.f14485s = -1;
            e.f14450D = null;
            e.f14490x.m19914b(e.f14492z, new ExceptionInterpreter(e3, true));
        }
        return e;
    }

    private static void m22118a(UploadOperation uploadOperation, UploadSessionContext uploadSessionContext) {
        ImmutableList immutableList = uploadOperation.f13778a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MediaItem mediaItem = (MediaItem) immutableList.get(i);
            if (!mediaItem.p()) {
                String e = mediaItem.e();
                if (e == null || !new File(e).isFile()) {
                    uploadSessionContext.f14490x.m19889a(uploadSessionContext.f14492z, uploadSessionContext.f14482p, uploadSessionContext.f14476j, uploadSessionContext.f14480n);
                    throw new MissingMediaFileException(e);
                }
            }
        }
    }

    private static void m22136d(UploadSessionContext uploadSessionContext) {
        UploadRecord uploadRecord = null;
        UploadOperation uploadOperation = uploadSessionContext.f14467a;
        String a = uploadSessionContext.m22073a();
        UploadRecords u = uploadOperation.m21546u();
        if (u != null) {
            uploadRecord = u.m21599a(a);
        }
        if (uploadRecord != null) {
            uploadSessionContext.f14448B = uploadRecord;
            TranscodeInfo transcodeInfo = uploadSessionContext.f14448B.transcodeInfo;
            uploadSessionContext.f14490x.m19857a(uploadSessionContext.f14492z, transcodeInfo.flowStartCount, transcodeInfo.transcodeStartCount, transcodeInfo.transcodeSuccessCount, transcodeInfo.transcodeFailCount, transcodeInfo.isSegmentedTranscode, transcodeInfo.isRequestedServerSettings, transcodeInfo.isServerSettingsAvailable, transcodeInfo.serverSpecifiedTranscodeBitrate, transcodeInfo.serverSpecifiedTranscodeDimension);
            return;
        }
        uploadSessionContext.f14448B = new UploadRecord(-1, -1, false);
    }

    private void m22138e(UploadSessionContext uploadSessionContext) {
        Preconditions.checkState(uploadSessionContext.f14448B != null);
        String a = uploadSessionContext.m22073a();
        uploadSessionContext.f14473g.put(a, uploadSessionContext.f14448B);
        boolean a2 = this.f14537g.a(a, uploadSessionContext.f14448B);
        TranscodeInfo transcodeInfo = uploadSessionContext.f14448B.transcodeInfo;
        uploadSessionContext.f14490x.m19913b(uploadSessionContext.f14492z, transcodeInfo.flowStartCount, transcodeInfo.transcodeStartCount, transcodeInfo.transcodeSuccessCount, transcodeInfo.transcodeFailCount, transcodeInfo.isSegmentedTranscode, transcodeInfo.isRequestedServerSettings, transcodeInfo.isServerSettingsAvailable, transcodeInfo.serverSpecifiedTranscodeBitrate, transcodeInfo.serverSpecifiedTranscodeDimension);
        if (!a2) {
            DefaultPhotoFlowLogger defaultPhotoFlowLogger = uploadSessionContext.f14490x;
            UploadBaseParams uploadBaseParams = uploadSessionContext.f14492z;
            UploadOperation uploadOperation = uploadSessionContext.f14467a;
            defaultPhotoFlowLogger.m19931d(uploadBaseParams);
        }
    }

    private OperationResult m22139f(UploadSessionContext uploadSessionContext) {
        UploadOperation uploadOperation = uploadSessionContext.f14467a;
        SegmentedUploadItem segmentedUploadItem = uploadSessionContext.f14491y;
        DefaultPhotoFlowLogger defaultPhotoFlowLogger = uploadSessionContext.f14490x;
        Preconditions.checkNotNull(defaultPhotoFlowLogger, "Logger cannot be null");
        Preconditions.checkNotNull(uploadOperation, "Upload Operation cannot be null");
        try {
            uploadSessionContext.f14474h = new VideoUploaderProgressListener(uploadOperation, defaultPhotoFlowLogger, uploadSessionContext.f14492z, this.f14539i, this.f14534d, this.f14533c);
            this.f14550t.m22149a(uploadSessionContext.f14474h);
            uploadSessionContext.f14469c = new ApiMethodRunnerParams();
            uploadSessionContext.f14469c.a(uploadSessionContext.f14474h);
            uploadSessionContext.f14469c.a(this.f14539i.m22006d());
            try {
                ImmediateRetryPolicy a;
                Boolean valueOf;
                m22118a(uploadOperation, uploadSessionContext);
                if (((Boolean) this.f14556z.get()).booleanValue()) {
                    a = this.f14550t.m22147a();
                } else {
                    ImmediateRetryPolicy immediateRetryPolicy = (ImmediateRetryPolicy) this.f14538h.get();
                    immediateRetryPolicy.mo1150a(uploadOperation.m21541i());
                    immediateRetryPolicy.mo1149a(this.f14553w);
                    a = immediateRetryPolicy;
                }
                uploadSessionContext.f14488v = null;
                if (this.f14526A.a((short) -32024, false) && uploadSessionContext.f14491y == null) {
                    valueOf = Boolean.valueOf(m22125a(uploadSessionContext, uploadOperation));
                } else {
                    valueOf = Boolean.valueOf(m22126a(uploadSessionContext, uploadOperation, segmentedUploadItem, a, defaultPhotoFlowLogger));
                }
                if (valueOf.booleanValue()) {
                    uploadSessionContext.f14470d = uploadSessionContext.f14471e;
                    defaultPhotoFlowLogger.m19865a(uploadSessionContext.f14492z, SourceType.LOCAL, Long.parseLong(uploadSessionContext.f14471e), uploadOperation.m21535d());
                    defaultPhotoFlowLogger.m19928c(uploadSessionContext.f14492z, uploadOperation);
                    new Bundle().putString(uploadSessionContext.f14482p, uploadSessionContext.f14471e);
                    OperationResult a2 = OperationResult.a(uploadSessionContext.f14470d, new Pair[]{Pair.create("fbids", r1)});
                    return a2;
                }
                this.f14539i.m22001a("after uploading video");
                if (uploadSessionContext.f14488v == null) {
                    this.f14540j.a(f14524a.getSimpleName(), "No fbid");
                    uploadSessionContext.f14488v = new InterpretedException("No fbid", true);
                }
                throw uploadSessionContext.f14488v;
            } catch (Exception e) {
                Exception e2 = e;
                if (e2 instanceof ExecutionException) {
                    e2 = (Exception) e2.getCause();
                }
                if (this.f14539i.m22007e()) {
                    defaultPhotoFlowLogger.m19864a(uploadSessionContext.f14492z, SourceType.LOCAL);
                    m22141h(uploadSessionContext);
                    this.f14539i.m22001a("video");
                }
                PhotoFlowLogger$ExceptionReporter exceptionInterpreter = new ExceptionInterpreter(e2, true);
                defaultPhotoFlowLogger.m19866a(uploadSessionContext.f14492z, SourceType.LOCAL, exceptionInterpreter);
                if (uploadSessionContext.f14473g.isEmpty()) {
                    throw new PartialUploadException(exceptionInterpreter);
                }
                throw new PartialUploadException(exceptionInterpreter, uploadSessionContext.f14473g);
            }
        } finally {
            this.f14553w = null;
            if (uploadSessionContext.f14474h != null) {
                uploadSessionContext.f14474h.m22164b();
            }
        }
    }

    private boolean m22126a(UploadSessionContext uploadSessionContext, UploadOperation uploadOperation, SegmentedUploadItem segmentedUploadItem, ImmediateRetryPolicy immediateRetryPolicy, DefaultPhotoFlowLogger defaultPhotoFlowLogger) {
        UploadRecord a;
        UploadAssetSegment uploadAssetSegment = null;
        UploadRecords uploadRecords = uploadOperation.f13757F;
        uploadSessionContext.f14486t = 0;
        uploadSessionContext.f14487u = 0;
        this.f14539i.m22001a("before uploading video");
        String str = uploadSessionContext.f14476j;
        if (uploadRecords != null) {
            a = uploadRecords.m21599a(str);
        } else {
            a = null;
        }
        if (m22127a(uploadSessionContext, a)) {
            m22121a(uploadSessionContext, uploadRecords, a);
        } else if (uploadSessionContext.f14468b.longValue() < 0) {
            uploadSessionContext.f14489w = VideoUploadStage.START;
            if (segmentedUploadItem != null) {
                uploadAssetSegment = segmentedUploadItem.m22063a();
            }
            m22117a(defaultPhotoFlowLogger, uploadSessionContext, uploadAssetSegment, immediateRetryPolicy);
        } else {
            this.f14539i.m22001a("after retry init");
        }
        uploadSessionContext.f14489w = VideoUploadStage.RECEIVE;
        m22116a(defaultPhotoFlowLogger, uploadSessionContext, segmentedUploadItem, immediateRetryPolicy, str);
        if (!m22134c()) {
            uploadSessionContext.m22075a(true);
        } else if (!((Boolean) FutureDetour.a(uploadSessionContext.f14481o, -838766978)).booleanValue()) {
            throw new CancellationException("cannot be posted");
        }
        uploadSessionContext.f14489w = VideoUploadStage.POST;
        this.f14539i.m22001a("before post video");
        boolean booleanValue = m22115a(defaultPhotoFlowLogger, uploadSessionContext, immediateRetryPolicy).booleanValue();
        uploadSessionContext.f14489w = VideoUploadStage.FINISHED;
        immediateRetryPolicy.mo1146a();
        return booleanValue;
    }

    private boolean m22125a(UploadSessionContext uploadSessionContext, UploadOperation uploadOperation) {
        MediaUploadParameters c = m22132c(uploadSessionContext, uploadOperation);
        try {
            this.f14530E = this.f14528C.m18856a(new MediaItemFactory$VideoItemBuilder().m20107b(uploadSessionContext.f14476j).m20108c(uploadSessionContext.f14477k).m20105a(), c, "videouploader");
            MediaUploadResult mediaUploadResult = (MediaUploadResult) FutureDetour.a(this.f14530E, 1122675131);
            this.f14530E = null;
            uploadSessionContext.f14470d = mediaUploadResult.m18850a();
            uploadSessionContext.f14468b = Long.valueOf(Long.parseLong(uploadSessionContext.f14470d));
            uploadSessionContext.f14471e = mediaUploadResult.m18851b();
            return true;
        } catch (ExecutionException e) {
            ExecutionException executionException = e;
            this.f14539i.m22001a("Exiting media library upload call");
            Throwable cause = executionException.getCause();
            if (cause == null || !(cause instanceof Exception)) {
                throw executionException;
            }
            throw ((Exception) cause);
        }
    }

    private VideoTranscodeParameters m22128b(UploadSessionContext uploadSessionContext, UploadOperation uploadOperation) {
        if (uploadSessionContext.f14466T.f14439c) {
            return null;
        }
        VideoTranscodeParameters videoTranscodeParameters = new VideoTranscodeParameters();
        if (uploadSessionContext.f14454H) {
            Builder builder = new Builder();
            builder.f11864a = uploadSessionContext.f14457K;
            builder = builder;
            builder.f11865b = uploadSessionContext.f14458L;
            builder = builder;
            builder.f11866c = uploadSessionContext.f14459M;
            builder = builder;
            builder.f11868e = uploadSessionContext.f14456J;
            builder = builder;
            builder.f11867d = uploadSessionContext.f14455I;
            builder = builder;
            builder.f11869f = uploadSessionContext.f14460N;
            videoTranscodeParameters.f11878c = new VideoEditConfig(builder);
        }
        if (!uploadSessionContext.f14466T.m22069c()) {
            videoTranscodeParameters.f11876a = true;
            videoTranscodeParameters.f11877b = uploadSessionContext.f14466T.f14437a / 1000;
        }
        this.f14545o.m22111a(uploadOperation, 1);
        videoTranscodeParameters.f11879d = this.f14545o;
        return videoTranscodeParameters;
    }

    private MediaUploadParameters m22132c(UploadSessionContext uploadSessionContext, UploadOperation uploadOperation) {
        boolean z;
        long B = uploadOperation.m21497B();
        long j = uploadSessionContext.f14478l;
        String N = uploadOperation.m21509N();
        String str = uploadSessionContext.f14472f;
        ComposerAppAttribution V = uploadOperation.m21517V();
        boolean W = uploadOperation.m21518W();
        boolean X = uploadOperation.m21519X();
        if (uploadOperation.ah() == PublishMode.NORMAL) {
            z = true;
        } else {
            z = false;
        }
        ApiRequest a = UploadVideoChunkStartMethod.m21868a(new UploadVideoChunkStartParams(B, j, N, str, V, W, X, Optional.of(Boolean.valueOf(z)), Optional.of(Long.valueOf(uploadOperation.ai())), null));
        UploadVideoChunkPostParams a2 = UploadVideoChunkPostParams.m21843a(null, uploadOperation);
        List list = null;
        MediaAttachementBody a3 = UploadVideoPostHelper.m21879a(a2);
        if (a3 != null) {
            list = ImmutableList.of(a3);
        }
        return new MediaUploadParameters(uploadOperation.m21509N(), Long.toString(uploadOperation.m21497B()), false, null, a.h(), this.f14543m.m21840a(a2).h(), list, uploadSessionContext.f14474h);
    }

    private boolean m22134c() {
        return this.f14526A.a((short) -28636, OptimisticVideoUploadQuickExperiment.f13532a.booleanValue());
    }

    private Boolean m22115a(DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadSessionContext uploadSessionContext, ImmediateRetryPolicy immediateRetryPolicy) {
        boolean z = false;
        UploadOperation uploadOperation = uploadSessionContext.f14467a;
        int i = 0;
        while (true) {
            try {
                if (!(uploadOperation.m21505J() == PublishMethod.MULTIMEDIA || uploadOperation.m21505J() == PublishMethod.BACKSTAGE_VIDEO_POST)) {
                    defaultPhotoFlowLogger.m19887a(uploadSessionContext.f14492z, uploadSessionContext.f14470d, uploadOperation);
                    this.f14535e.a(this.f14543m, UploadVideoChunkPostParams.m21843a(Long.toString(uploadSessionContext.f14468b.longValue()), uploadOperation), uploadSessionContext.f14469c);
                }
                immediateRetryPolicy.mo1146a();
                z = true;
            } catch (Exception e) {
                m22113a(uploadSessionContext, e, (long) i, null);
            }
            if (z) {
                break;
            }
            int i2 = i + 1;
            if (i2 > immediateRetryPolicy.mo1151b()) {
                break;
            }
            i = i2;
        }
        if (z) {
            defaultPhotoFlowLogger.m19917b(uploadSessionContext.f14492z, uploadSessionContext.f14470d, uploadOperation);
            return Boolean.valueOf(z);
        }
        throw uploadSessionContext.f14488v;
    }

    private void m22116a(DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadSessionContext uploadSessionContext, SegmentedUploadItem segmentedUploadItem, ImmediateRetryPolicy immediateRetryPolicy, String str) {
        UploadOperation uploadOperation = uploadSessionContext.f14467a;
        Object obj = segmentedUploadItem != null ? 1 : null;
        uploadSessionContext.f14473g.put(uploadSessionContext.f14476j, new UploadRecord(uploadSessionContext.f14468b.longValue(), this.f14533c.a(), false, uploadSessionContext.f14475i, uploadSessionContext.f14471e));
        uploadSessionContext.f14473g.put(uploadSessionContext.f14470d, new UploadRecord(uploadSessionContext.f14486t, uploadSessionContext.f14486t + uploadSessionContext.f14487u, false, false, ""));
        uploadSessionContext.f14469c.a(uploadSessionContext.f14474h);
        defaultPhotoFlowLogger.m19912b(uploadSessionContext.f14492z, uploadSessionContext.f14478l, uploadOperation.m21539g());
        uploadSessionContext.f14474h.m22166c(uploadSessionContext.f14478l);
        if (!this.f14537g.a(str, new UploadRecord(uploadSessionContext.f14468b.longValue(), this.f14533c.a(), false, uploadSessionContext.f14475i, uploadSessionContext.f14471e))) {
            UploadBaseParams uploadBaseParams = uploadSessionContext.f14492z;
            UploadOperation uploadOperation2 = uploadSessionContext.f14467a;
            defaultPhotoFlowLogger.m19931d(uploadBaseParams);
        }
        if (uploadSessionContext.f14475i) {
            defaultPhotoFlowLogger.m19878a(uploadSessionContext.f14492z, uploadSessionContext.f14472f);
        } else if (obj != null) {
            this.f14551u.m22081a(uploadOperation, uploadSessionContext, uploadSessionContext.f14477k, defaultPhotoFlowLogger, immediateRetryPolicy, segmentedUploadItem, uploadSessionContext.f14492z, this.f14554x, this.f14539i, this.f14537g, this.f14550t);
        } else {
            defaultPhotoFlowLogger.m19903a(true);
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f14548r.m20010a(true, true, false, uploadSessionContext.f14478l, uploadOperation.m21509N());
            long now = this.f14547q.now();
            try {
                this.f14549s.m21957a(uploadOperation, uploadSessionContext, this.f14537g, this.f14539i, this.f14553w, this.f14550t);
                this.f14554x.m22105a(0, uploadSessionContext.f14478l, now, this.f14547q.now());
                this.f14548r.m20008a(true, true, false, atomicInteger.get(), this.f14547q.now() - now, uploadSessionContext.f14478l, uploadOperation.m21509N());
            } catch (Exception e) {
                this.f14548r.m20009a(true, true, false, atomicInteger.get(), this.f14547q.now() - now, uploadSessionContext.f14478l, uploadOperation.m21509N(), e.getMessage());
                throw e;
            }
        }
        defaultPhotoFlowLogger.m19925c(uploadSessionContext.f14492z, uploadSessionContext.f14478l, uploadOperation.m21535d());
        uploadSessionContext.f14469c.a(null);
    }

    private void m22117a(DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadSessionContext uploadSessionContext, UploadAssetSegment uploadAssetSegment, ImmediateRetryPolicy immediateRetryPolicy) {
        defaultPhotoFlowLogger.m19850a(uploadSessionContext.f14492z, 0, SourceType.LOCAL, VideoUploadResizeHandler.m22091a(uploadSessionContext.f14476j), uploadSessionContext.f14479m, uploadSessionContext.f14478l, uploadSessionContext.f14483q);
        uploadSessionContext.f14469c.a(null);
        if (uploadSessionContext.f14479m >= 25000000 || uploadSessionContext.f14480n) {
            defaultPhotoFlowLogger.m19858a(uploadSessionContext.f14492z, uploadSessionContext.f14479m, uploadSessionContext.f14478l, uploadSessionContext.f14480n);
        } else {
            defaultPhotoFlowLogger.m19846a(uploadSessionContext.f14492z);
            uploadSessionContext.f14472f = Files.a(new File(uploadSessionContext.f14482p), Hashing.a()).toString();
            defaultPhotoFlowLogger.m19861a(uploadSessionContext.f14492z, uploadSessionContext.f14479m, uploadSessionContext.f14472f);
        }
        UploadVideoChunkStartResponse a = m22114a(uploadSessionContext, uploadAssetSegment, immediateRetryPolicy, defaultPhotoFlowLogger);
        uploadSessionContext.f14470d = a.m21874a();
        uploadSessionContext.f14468b = Long.valueOf(Long.parseLong(uploadSessionContext.f14470d));
        uploadSessionContext.f14471e = a.m21875b();
        uploadSessionContext.f14475i = a.m21878e();
        defaultPhotoFlowLogger.m19859a(uploadSessionContext.f14492z, uploadSessionContext.f14468b.longValue(), uploadSessionContext.f14467a);
        uploadSessionContext.f14486t = a.m21876c();
        uploadSessionContext.f14487u = a.m21877d() - a.m21876c();
        this.f14539i.m22001a("after init video");
    }

    private void m22121a(UploadSessionContext uploadSessionContext, UploadRecords uploadRecords, UploadRecord uploadRecord) {
        uploadSessionContext.f14468b = Long.valueOf(uploadRecord.fbid);
        uploadSessionContext.f14475i = uploadRecord.sameHashExist;
        uploadSessionContext.f14471e = uploadRecord.videoId;
        uploadSessionContext.f14470d = Long.toString(uploadSessionContext.f14468b.longValue());
        UploadRecord a = uploadRecords.m21599a(uploadSessionContext.f14470d);
        if (a != null) {
            uploadSessionContext.f14486t = a.fbid;
            uploadSessionContext.f14487u = a.uploadTime - a.fbid;
            uploadSessionContext.f14447A = a.partitionInfo;
        } else {
            uploadSessionContext.f14486t = 0;
            uploadSessionContext.f14487u = 4096;
        }
        Long.valueOf(uploadSessionContext.f14486t);
        Long.valueOf(uploadSessionContext.f14487u);
        uploadSessionContext.f14489w = VideoUploadStage.RECEIVE;
        this.f14539i.m22001a("after read partial data");
    }

    private void m22140g(UploadSessionContext uploadSessionContext) {
        UploadOperation uploadOperation = uploadSessionContext.f14467a;
        TranscodeInfo transcodeInfo = uploadSessionContext.f14448B.transcodeInfo;
        if (uploadSessionContext.f14450D != null && !uploadOperation.ak() && this.f14532G.a(498, false) && this.f14526A.a(ExperimentsForComposerAbTestModule.aa, false) && !transcodeInfo.isRequestedServerSettings) {
            try {
                transcodeInfo.isRequestedServerSettings = true;
                UploadVideoChunkSettingsResponse uploadVideoChunkSettingsResponse = (UploadVideoChunkSettingsResponse) this.f14535e.a(this.f14541k, new UploadVideoChunkSettingsParams(uploadOperation.m21497B(), uploadOperation.m21509N(), uploadSessionContext.f14450D, uploadSessionContext.f14479m), uploadSessionContext.f14469c);
                transcodeInfo.isServerSettingsAvailable = true;
                transcodeInfo.serverSpecifiedTranscodeDimension = uploadVideoChunkSettingsResponse.m21866a();
                transcodeInfo.serverSpecifiedTranscodeBitrate = uploadVideoChunkSettingsResponse.m21867b();
            } catch (Exception e) {
                transcodeInfo.isServerSettingsAvailable = false;
            }
            m22138e(uploadSessionContext);
        }
    }

    private UploadVideoChunkStartResponse m22114a(UploadSessionContext uploadSessionContext, UploadAssetSegment uploadAssetSegment, ImmediateRetryPolicy immediateRetryPolicy, DefaultPhotoFlowLogger defaultPhotoFlowLogger) {
        UploadOperation uploadOperation = uploadSessionContext.f14467a;
        long j = 0;
        UploadVideoChunkStartResponse uploadVideoChunkStartResponse = null;
        Object obj = null;
        while (true) {
            Object obj2;
            UploadVideoChunkStartResponse uploadVideoChunkStartResponse2;
            try {
                boolean z;
                defaultPhotoFlowLogger.m19877a(uploadSessionContext.f14492z, uploadOperation, uploadSessionContext.m22076b(), uploadSessionContext.f14482p, uploadSessionContext.f14477k);
                AbstractSingleMethodRunner abstractSingleMethodRunner = this.f14535e;
                UploadVideoChunkStartMethod uploadVideoChunkStartMethod = this.f14542l;
                long B = uploadOperation.m21497B();
                long j2 = uploadSessionContext.f14478l;
                String N = uploadOperation.m21509N();
                String str = uploadSessionContext.f14472f;
                ComposerAppAttribution V = uploadOperation.m21517V();
                boolean W = uploadOperation.m21518W();
                boolean X = uploadOperation.m21519X();
                if (uploadOperation.ah() == PublishMode.NORMAL) {
                    z = true;
                } else {
                    z = false;
                }
                UploadVideoChunkStartParams uploadVideoChunkStartParams = new UploadVideoChunkStartParams(B, j2, N, str, V, W, X, Optional.of(Boolean.valueOf(z)), Optional.of(Long.valueOf(uploadOperation.ai())), uploadAssetSegment);
                obj2 = 1;
                uploadVideoChunkStartResponse2 = (UploadVideoChunkStartResponse) abstractSingleMethodRunner.a(uploadVideoChunkStartMethod, uploadVideoChunkStartParams, uploadSessionContext.f14469c);
            } catch (Exception e) {
                m22113a(uploadSessionContext, e, j, null);
                uploadVideoChunkStartResponse2 = uploadVideoChunkStartResponse;
                obj2 = obj;
            }
            if (obj2 != null) {
                break;
            }
            long j3 = 1 + j;
            if (j3 > ((long) immediateRetryPolicy.mo1151b())) {
                break;
            }
            j = j3;
            uploadVideoChunkStartResponse = uploadVideoChunkStartResponse2;
            obj = obj2;
        }
        if (obj2 == null && uploadSessionContext.f14488v != null) {
            throw uploadSessionContext.f14488v;
        } else if (uploadVideoChunkStartResponse2 == null) {
            throw new NullPointerException();
        } else {
            immediateRetryPolicy.mo1146a();
            return uploadVideoChunkStartResponse2;
        }
    }

    @VisibleForTesting
    private boolean m22123a(UploadRecord uploadRecord) {
        return this.f14533c.a() - uploadRecord.uploadTime > 72000000;
    }

    public final void m22144a(double d, UploadOperation uploadOperation) {
        if (uploadOperation != null) {
            this.f14534d.a(new VideoUploadProgressEvent(uploadOperation, BaseMediaUploadEvent$Status.PROCESSING, (int) (100.0d * d)));
        }
    }

    private Pair<Integer, Integer> m22113a(UploadSessionContext uploadSessionContext, Exception exception, long j, ChunkUploadProgressStatus chunkUploadProgressStatus) {
        uploadSessionContext.f14488v = exception;
        Pair<Integer, Integer> a = this.f14550t.m22146a(exception, uploadSessionContext.f14489w, j, chunkUploadProgressStatus);
        if (a != null) {
            uploadSessionContext.f14486t = (long) ((Integer) a.first).intValue();
            uploadSessionContext.f14487u = (long) ((Integer) a.second).intValue();
        }
        return a;
    }

    public static UploadSessionContext m22137e(UploadOperation uploadOperation) {
        UploadSessionContext uploadSessionContext = (UploadSessionContext) f14525b.get(uploadOperation.f13793p);
        if (uploadSessionContext == null) {
            return new UploadSessionContext(uploadOperation);
        }
        if (uploadSessionContext.f14482p.equals(((MediaItem) uploadOperation.f13778a.get(0)).e())) {
            return uploadSessionContext;
        }
        uploadSessionContext.m22075a(false);
        return new UploadSessionContext(uploadOperation);
    }

    private boolean m22127a(UploadSessionContext uploadSessionContext, UploadRecord uploadRecord) {
        if (uploadRecord == null || uploadRecord.fbid <= 0 || m22123a(uploadRecord) || (uploadSessionContext.f14468b.longValue() != uploadRecord.fbid && uploadSessionContext.f14468b.longValue() != -1)) {
            return false;
        }
        return true;
    }

    private void m22141h(final UploadSessionContext uploadSessionContext) {
        if (((Boolean) this.f14555y.get()).booleanValue() && uploadSessionContext.f14468b.longValue() != -1) {
            this.f14552v.a(new FbAsyncTask<Object, Object, Object>(this) {
                final /* synthetic */ VideoUploader f14513b;

                protected final Object m22106a(Object... objArr) {
                    try {
                        uploadSessionContext.f14490x.m19924c(uploadSessionContext.f14492z, uploadSessionContext.f14468b.longValue());
                        this.f14513b.f14535e.a(this.f14513b.f14544n, new UploadVideoChunkCancelParams(Long.toString(uploadSessionContext.f14468b.longValue()), uploadSessionContext.f14467a.m21509N(), Long.toString(uploadSessionContext.f14467a.m21497B())), CallerContext.a(getClass()));
                        uploadSessionContext.f14490x.m19932d(uploadSessionContext.f14492z, uploadSessionContext.f14468b.longValue());
                    } catch (Exception e) {
                        uploadSessionContext.f14490x.m19860a(uploadSessionContext.f14492z, uploadSessionContext.f14468b.longValue(), e);
                    }
                    return null;
                }
            }, new Object[0]);
        }
    }
}
