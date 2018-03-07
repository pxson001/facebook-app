package com.facebook.photos.upload.uploaders;

import android.util.Pair;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbuploader.Config;
import com.facebook.fbuploader.Config.Namespace;
import com.facebook.fbuploader.Config.RetryPolicy;
import com.facebook.fbuploader.Content;
import com.facebook.fbuploader.FbUploader.FbUploadJobHandle;
import com.facebook.fbuploader.FbUploaderImpl;
import com.facebook.fbuploader.FbUploaderImpl.FbUploadJobHandleImpl;
import com.facebook.fbuploader.Listener;
import com.facebook.fbuploader.UploadFailureException;
import com.facebook.fbuploader.UploadResult;
import com.facebook.fbuploader.fbcommon.FbUploaderSingletonWrapper;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodProgressListener;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.HttpWireCallback;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.InterpretedException;
import com.facebook.photos.base.analytics.ResumableUploadLogger;
import com.facebook.photos.base.analytics.upload.UploadBaseParams;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.manager.UploadCrashMonitor;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadPartitionInfo;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.protocol.UploadVideoChunkReceiveMethod;
import com.facebook.photos.upload.protocol.UploadVideoChunkReceiveParams;
import com.facebook.photos.upload.protocol.UploadVideoChunkReceiveResponse;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: from_privacy */
public class ChunkUploadDelegator {
    private static final CallerContext f14288a = CallerContext.a(ChunkUploadDelegator.class);
    private final ExecutorService f14289b;
    private final AbstractSingleMethodRunner f14290c;
    private final UploadVideoChunkReceiveMethod f14291d;
    private final MonotonicClock f14292e;
    private final MediaUploadEventBus f14293f;
    private final FbUploaderSingletonWrapper f14294g;
    private final ResumableUploadLogger f14295h;
    private final Provider<ImmediateRetryPolicy> f14296i;
    private volatile boolean f14297j;
    private ArrayList<FbUploadJobHandle> f14298k;
    private final Object f14299l = new Object();

    /* compiled from: from_privacy */
    class ChunkUploadProgressListener implements ApiMethodProgressListener, HttpWireCallback {
        final /* synthetic */ ChunkUploadDelegator f14276a;
        private String f14277b;
        private VideoUploaderProgressListener f14278c;

        public ChunkUploadProgressListener(ChunkUploadDelegator chunkUploadDelegator, String str, VideoUploaderProgressListener videoUploaderProgressListener) {
            this.f14276a = chunkUploadDelegator;
            this.f14277b = str;
            this.f14278c = videoUploaderProgressListener;
        }

        public final void m21943a(long j, long j2) {
            this.f14278c.m22162a(this.f14277b, j, j2);
        }

        public final void m21941a() {
            this.f14278c.m22155a();
        }

        public final void m21942a(long j) {
            this.f14278c.m22161a(this.f14277b, j);
        }
    }

    /* compiled from: from_privacy */
    class ChunkUploadResumableListener implements Listener {
        private final ChunkUploadProgressListener f14279a;
        private final long f14280b;

        public ChunkUploadResumableListener(ChunkUploadProgressListener chunkUploadProgressListener, long j) {
            this.f14279a = chunkUploadProgressListener;
            this.f14280b = j;
        }

        public final void mo1026a() {
        }

        public final void mo1027a(float f) {
            this.f14279a.m21943a((long) (((float) this.f14280b) * f), this.f14280b);
        }

        public final void mo1028a(UploadFailureException uploadFailureException) {
        }

        public final void mo1030b() {
        }

        public final void mo1029a(UploadResult uploadResult) {
        }
    }

    /* compiled from: from_privacy */
    class UploadWorkItem {
        UploadOperation f14281a;
        UploadSessionContext f14282b;
        int f14283c;
        UploadPartitionInfo f14284d;
        UploadCrashMonitor f14285e;
        MediaUploadCancelHandler f14286f;
        VideoUploaderExceptionHandler f14287g;

        UploadWorkItem(UploadOperation uploadOperation, UploadSessionContext uploadSessionContext, int i, UploadCrashMonitor uploadCrashMonitor, MediaUploadCancelHandler mediaUploadCancelHandler, VideoUploaderExceptionHandler videoUploaderExceptionHandler) {
            this.f14281a = uploadOperation;
            this.f14282b = uploadSessionContext;
            this.f14283c = i;
            this.f14285e = uploadCrashMonitor;
            this.f14286f = mediaUploadCancelHandler;
            boolean z = i >= 0 && i < uploadSessionContext.f14447A.size();
            Preconditions.checkArgument(z);
            this.f14284d = (UploadPartitionInfo) uploadSessionContext.f14447A.get(this.f14283c);
            this.f14287g = videoUploaderExceptionHandler;
        }
    }

    public static ChunkUploadDelegator m21951a(InjectorLike injectorLike) {
        return new ChunkUploadDelegator((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), UploadVideoChunkReceiveMethod.m21844a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), MediaUploadEventBus.a(injectorLike), FbUploaderSingletonWrapper.m15786a(injectorLike), ResumableUploadLogger.m20004b(injectorLike), IdBasedProvider.a(injectorLike, 9491));
    }

    @Inject
    public ChunkUploadDelegator(ExecutorService executorService, SingleMethodRunner singleMethodRunner, UploadVideoChunkReceiveMethod uploadVideoChunkReceiveMethod, MonotonicClock monotonicClock, MediaUploadEventBus mediaUploadEventBus, FbUploaderSingletonWrapper fbUploaderSingletonWrapper, ResumableUploadLogger resumableUploadLogger, Provider<ImmediateRetryPolicy> provider) {
        this.f14289b = executorService;
        this.f14290c = singleMethodRunner;
        this.f14291d = uploadVideoChunkReceiveMethod;
        this.f14292e = monotonicClock;
        this.f14293f = mediaUploadEventBus;
        this.f14294g = fbUploaderSingletonWrapper;
        this.f14295h = resumableUploadLogger;
        this.f14298k = null;
        this.f14296i = provider;
    }

    public final void m21957a(UploadOperation uploadOperation, UploadSessionContext uploadSessionContext, UploadCrashMonitor uploadCrashMonitor, MediaUploadCancelHandler mediaUploadCancelHandler, Semaphore semaphore, VideoUploaderExceptionHandler videoUploaderExceptionHandler) {
        m21954a(uploadSessionContext);
        uploadSessionContext.f14488v = null;
        this.f14297j = false;
        this.f14298k = uploadSessionContext.f14465S;
        CompletionService executorCompletionService = new ExecutorCompletionService(this.f14289b);
        boolean c = videoUploaderExceptionHandler.m22147a().mo1152c();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < uploadSessionContext.f14447A.size()) {
            int i4;
            UploadPartitionInfo uploadPartitionInfo = (UploadPartitionInfo) uploadSessionContext.f14447A.get(i);
            long j = uploadPartitionInfo.chunkedUploadOffset - uploadPartitionInfo.partitionStartOffset;
            Preconditions.checkState(j >= 0, "partitionInfo improperly configured");
            int i5 = (int) (j + ((long) i3));
            if (uploadPartitionInfo.chunkedUploadOffset < uploadPartitionInfo.partitionEndOffset) {
                ImmediateRetryPolicy immediateRetryPolicy = (ImmediateRetryPolicy) this.f14296i.get();
                immediateRetryPolicy.mo1149a(semaphore);
                immediateRetryPolicy.mo1150a(c);
                executorCompletionService.submit(m21953a(new UploadWorkItem(uploadOperation, uploadSessionContext, i, uploadCrashMonitor, mediaUploadCancelHandler, videoUploaderExceptionHandler.m22148a(immediateRetryPolicy))));
                i4 = i2 + 1;
            } else {
                i4 = i2;
            }
            i++;
            i3 = i5;
            i2 = i4;
        }
        uploadSessionContext.f14474h.m22165b((long) i3);
        for (i4 = 0; i4 < i2; i4++) {
            try {
                FutureDetour.a(executorCompletionService.take(), -26546015);
            } catch (Exception e) {
                if (uploadSessionContext.f14488v == null) {
                    uploadSessionContext.f14488v = e;
                }
                this.f14297j = true;
            }
        }
        if (uploadSessionContext.f14488v != null) {
            throw uploadSessionContext.f14488v;
        }
    }

    private static void m21954a(UploadSessionContext uploadSessionContext) {
        if (uploadSessionContext.f14447A == null || uploadSessionContext.f14447A.isEmpty()) {
            long ceil = (long) Math.ceil(((double) uploadSessionContext.f14478l) / ((double) Math.max(Math.min(2, (int) (uploadSessionContext.f14478l / 10485760)), 1)));
            long j = uploadSessionContext.f14486t;
            while (j < uploadSessionContext.f14478l) {
                long min = Math.min(j + ceil, uploadSessionContext.f14478l);
                uploadSessionContext.f14447A.add(new UploadPartitionInfo(j, min, j, uploadSessionContext.f14487u));
                j = min;
            }
            UploadRecord uploadRecord = (UploadRecord) uploadSessionContext.f14473g.get(uploadSessionContext.f14470d);
            Preconditions.checkState(uploadRecord != null, "no upload record for this upload");
            if (uploadRecord != null) {
                uploadRecord.partitionInfo = uploadSessionContext.f14447A;
            }
        }
    }

    private Callable<Void> m21953a(final UploadWorkItem uploadWorkItem) {
        return new Callable<Void>(this) {
            final /* synthetic */ ChunkUploadDelegator f14275b;

            public Object call() {
                ChunkUploadDelegator.m21956b(this.f14275b, uploadWorkItem);
                return null;
            }
        };
    }

    public static void m21956b(ChunkUploadDelegator chunkUploadDelegator, UploadWorkItem uploadWorkItem) {
        long j = uploadWorkItem.f14284d.chunkedUploadOffset;
        VideoUploadStateParams videoUploadStateParams = new VideoUploadStateParams();
        long j2 = 0;
        long j3 = j;
        while (uploadWorkItem.f14284d.chunkedUploadOffset < uploadWorkItem.f14284d.partitionEndOffset) {
            long j4;
            UploadVideoChunkReceiveResponse a = chunkUploadDelegator.m21950a(uploadWorkItem, videoUploadStateParams);
            ChunkUploadProgressStatus a2 = videoUploadStateParams.m22102a(uploadWorkItem.f14284d, "");
            uploadWorkItem.f14284d.chunkedUploadOffset = a.m21861a();
            uploadWorkItem.f14284d.chunkedUploadChunkLength = a.m21862b() - a.m21861a();
            a2.f14305f = uploadWorkItem.f14284d.chunkedUploadOffset;
            a2.f14306g = uploadWorkItem.f14284d.chunkedUploadChunkLength;
            uploadWorkItem.f14282b.f14490x.m19885a(uploadWorkItem.f14282b.f14492z, uploadWorkItem.f14282b.f14470d, uploadWorkItem.f14284d.chunkedUploadOffset, uploadWorkItem.f14284d.chunkedUploadChunkLength, uploadWorkItem.f14284d.chunkedUploadChunkLength, uploadWorkItem.f14281a.m21535d(), a2);
            if (uploadWorkItem.f14284d.chunkedUploadOffset == j3) {
                j4 = 1 + j2;
                if (j4 > 2) {
                    throw new InterpretedException("Transfer chunk failure", true);
                }
                j = j3;
            } else {
                j = uploadWorkItem.f14284d.chunkedUploadOffset;
                j4 = 0;
                chunkUploadDelegator.m21955a(uploadWorkItem.f14282b, uploadWorkItem.f14283c, uploadWorkItem.f14284d, uploadWorkItem.f14285e);
            }
            j2 = j4;
            j3 = j;
        }
    }

    private UploadVideoChunkReceiveResponse m21950a(UploadWorkItem uploadWorkItem, VideoUploadStateParams videoUploadStateParams) {
        Object obj;
        Exception exception;
        Exception e;
        UploadVideoChunkReceiveResponse uploadVideoChunkReceiveResponse;
        Pair a;
        long j;
        UploadVideoChunkReceiveResponse uploadVideoChunkReceiveResponse2 = null;
        Object obj2 = null;
        ApiMethodRunnerParams a2 = ApiMethodRunnerParams.a(uploadWorkItem.f14282b.f14469c);
        String str = "";
        Exception exception2 = null;
        long j2 = 0;
        while (true) {
            try {
                boolean z;
                str = uploadWorkItem.f14282b.m22074a(uploadWorkItem.f14284d.chunkedUploadOffset);
                ChunkUploadProgressListener chunkUploadProgressListener = new ChunkUploadProgressListener(this, str, uploadWorkItem.f14282b.f14474h);
                a2.a(chunkUploadProgressListener);
                uploadWorkItem.f14282b.f14474h.m22163a(uploadWorkItem.f14282b.f14470d, uploadWorkItem.f14284d.chunkedUploadOffset, uploadWorkItem.f14284d.chunkedUploadChunkLength, uploadWorkItem.f14282b.f14478l, uploadWorkItem.f14281a.m21535d(), str);
                long now = this.f14292e.now();
                String a3 = m21952a(uploadWorkItem, chunkUploadProgressListener, a2, now);
                a2.a(null);
                AbstractSingleMethodRunner abstractSingleMethodRunner = this.f14290c;
                UploadVideoChunkReceiveMethod uploadVideoChunkReceiveMethod = this.f14291d;
                long longValue = uploadWorkItem.f14282b.f14468b.longValue();
                long j3 = uploadWorkItem.f14284d.chunkedUploadOffset;
                long j4 = uploadWorkItem.f14284d.chunkedUploadChunkLength;
                long B = uploadWorkItem.f14281a.m21497B();
                String N = uploadWorkItem.f14281a.m21509N();
                String str2 = uploadWorkItem.f14282b.f14476j;
                String str3 = uploadWorkItem.f14282b.f14477k;
                float f = videoUploadStateParams.f14509a;
                if (uploadWorkItem.f14282b.f14447A.size() > 1) {
                    z = true;
                } else {
                    z = false;
                }
                UploadVideoChunkReceiveResponse uploadVideoChunkReceiveResponse3 = (UploadVideoChunkReceiveResponse) abstractSingleMethodRunner.a(uploadVideoChunkReceiveMethod, new UploadVideoChunkReceiveParams(longValue, j3, j4, B, N, str2, str3, f, z, uploadWorkItem.f14284d.partitionStartOffset, uploadWorkItem.f14284d.partitionEndOffset, null, a3), a2, f14288a);
                try {
                    VideoUploadStateParams videoUploadStateParams2 = videoUploadStateParams;
                    longValue = j2;
                    videoUploadStateParams2.m22105a(longValue, uploadWorkItem.f14284d.chunkedUploadChunkLength, now, this.f14292e.now());
                    VideoUploaderSlowNetworkHandler.m22167a(uploadWorkItem.f14281a, this.f14293f, uploadWorkItem.f14284d.partitionEndOffset - uploadWorkItem.f14284d.partitionStartOffset, videoUploadStateParams.f14509a);
                    uploadWorkItem.f14286f.m22001a("after chunk video");
                    obj = 1;
                    try {
                        uploadWorkItem.f14282b.f14474h.m22160a(str);
                        obj2 = 1;
                        uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse3;
                        exception = exception2;
                    } catch (Exception e2) {
                        e = e2;
                        uploadVideoChunkReceiveResponse = uploadVideoChunkReceiveResponse3;
                        videoUploadStateParams.m22104a(j2);
                        a = m21949a(uploadWorkItem, e, j2, videoUploadStateParams.m22102a(uploadWorkItem.f14284d, str));
                        if (a == null) {
                        }
                        exception = e;
                        obj2 = obj;
                        uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                        j = 1 + j2;
                        if (j > ((long) uploadWorkItem.f14287g.m22151c())) {
                            exception2 = exception;
                            j2 = j;
                        } else if (this.f14297j) {
                            throw new InterruptedException("upload has failed in another partition");
                        } else {
                            uploadWorkItem.f14286f.m22001a("after chunk video retries");
                            if (obj2 != null) {
                            }
                            if (uploadVideoChunkReceiveResponse2 != null) {
                                uploadWorkItem.f14287g.m22150b();
                                return uploadVideoChunkReceiveResponse2;
                            }
                            throw new NullPointerException();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    obj = obj2;
                    uploadVideoChunkReceiveResponse = uploadVideoChunkReceiveResponse3;
                    videoUploadStateParams.m22104a(j2);
                    a = m21949a(uploadWorkItem, e, j2, videoUploadStateParams.m22102a(uploadWorkItem.f14284d, str));
                    if (a == null && ((long) ((Integer) a.first).intValue()) == uploadWorkItem.f14284d.partitionEndOffset) {
                        uploadVideoChunkReceiveResponse = new UploadVideoChunkReceiveResponse((long) ((Integer) a.first).intValue(), (long) ((Integer) a.second).intValue());
                        uploadWorkItem.f14282b.f14474h.m22160a(str);
                        exception = e;
                        int i = 1;
                        uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                    } else {
                        exception = e;
                        obj2 = obj;
                        uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                    }
                    j = 1 + j2;
                    if (j > ((long) uploadWorkItem.f14287g.m22151c())) {
                        exception2 = exception;
                        j2 = j;
                    } else if (this.f14297j) {
                        uploadWorkItem.f14286f.m22001a("after chunk video retries");
                        if (obj2 != null) {
                        }
                        if (uploadVideoChunkReceiveResponse2 != null) {
                            uploadWorkItem.f14287g.m22150b();
                            return uploadVideoChunkReceiveResponse2;
                        }
                        throw new NullPointerException();
                    } else {
                        throw new InterruptedException("upload has failed in another partition");
                    }
                }
            } catch (Exception exception3) {
                e = exception3;
                obj = obj2;
                uploadVideoChunkReceiveResponse = uploadVideoChunkReceiveResponse2;
                videoUploadStateParams.m22104a(j2);
                a = m21949a(uploadWorkItem, e, j2, videoUploadStateParams.m22102a(uploadWorkItem.f14284d, str));
                if (a == null) {
                }
                exception3 = e;
                obj2 = obj;
                uploadVideoChunkReceiveResponse2 = uploadVideoChunkReceiveResponse;
                j = 1 + j2;
                if (j > ((long) uploadWorkItem.f14287g.m22151c())) {
                    exception2 = exception3;
                    j2 = j;
                } else if (this.f14297j) {
                    throw new InterruptedException("upload has failed in another partition");
                } else {
                    uploadWorkItem.f14286f.m22001a("after chunk video retries");
                    if (obj2 != null) {
                    }
                    if (uploadVideoChunkReceiveResponse2 != null) {
                        throw new NullPointerException();
                    }
                    uploadWorkItem.f14287g.m22150b();
                    return uploadVideoChunkReceiveResponse2;
                }
            }
            if (obj2 != null || this.f14297j) {
                break;
            }
            j = 1 + j2;
            if (j > ((long) uploadWorkItem.f14287g.m22151c())) {
                break;
            }
            exception2 = exception3;
            j2 = j;
        }
        if (this.f14297j) {
            throw new InterruptedException("upload has failed in another partition");
        }
        uploadWorkItem.f14286f.m22001a("after chunk video retries");
        if (obj2 != null && exception3 != null) {
            throw exception3;
        } else if (uploadVideoChunkReceiveResponse2 != null) {
            throw new NullPointerException();
        } else {
            uploadWorkItem.f14287g.m22150b();
            return uploadVideoChunkReceiveResponse2;
        }
    }

    private String m21952a(UploadWorkItem uploadWorkItem, ChunkUploadProgressListener chunkUploadProgressListener, ApiMethodRunnerParams apiMethodRunnerParams, long j) {
        FbUploaderImpl a = this.f14294g.m15788a();
        Content content = new Content(new File(uploadWorkItem.f14282b.f14476j), uploadWorkItem.f14284d.chunkedUploadOffset, uploadWorkItem.f14284d.chunkedUploadChunkLength, uploadWorkItem.f14282b.f14477k);
        RetryPolicy retryPolicy = new RetryPolicy(2, 100, 30000);
        Map hashMap = new HashMap();
        hashMap.put("X_FB_VIDEO_WATERFALL_ID", uploadWorkItem.f14281a.m21509N());
        Config config = new Config(Namespace.FACEBOOK, hashMap, retryPolicy);
        try {
            FbUploadJobHandleImpl a2 = a.m15754a(content, config, new ChunkUploadResumableListener(chunkUploadProgressListener, uploadWorkItem.f14284d.chunkedUploadChunkLength));
            synchronized (this.f14298k) {
                this.f14298k.add(a2);
            }
            uploadWorkItem.f14286f.m22002a(this.f14298k);
            String str = a.m15756b(a2).f10081a;
            synchronized (this.f14298k) {
                this.f14298k.remove(a2);
            }
            this.f14295h.m20006a(config.m15736c(), content.m15743e(), str, this.f14292e.now() - j, content.m15742c(), uploadWorkItem.f14282b.f14478l, uploadWorkItem.f14281a.m21509N());
            apiMethodRunnerParams.a(null);
            return str;
        } catch (UploadFailureException e) {
            UploadFailureException uploadFailureException = e;
            this.f14295h.m20007a(config.m15736c(), content.m15743e(), uploadFailureException.getMessage(), uploadFailureException.mIsCancellation, uploadFailureException.mBytesTransferred, this.f14292e.now() - j, content.m15742c(), uploadWorkItem.f14282b.f14478l, uploadWorkItem.f14281a.m21509N());
            throw uploadFailureException;
        }
    }

    private static Pair<Integer, Integer> m21949a(UploadWorkItem uploadWorkItem, Exception exception, long j, ChunkUploadProgressStatus chunkUploadProgressStatus) {
        Pair<Integer, Integer> a = uploadWorkItem.f14287g.m22146a(exception, uploadWorkItem.f14282b.f14489w, j, chunkUploadProgressStatus);
        if (a != null) {
            uploadWorkItem.f14284d.chunkedUploadOffset = (long) ((Integer) a.first).intValue();
            uploadWorkItem.f14284d.chunkedUploadChunkLength = (long) ((Integer) a.second).intValue();
        }
        return a;
    }

    private void m21955a(UploadSessionContext uploadSessionContext, int i, UploadPartitionInfo uploadPartitionInfo, UploadCrashMonitor uploadCrashMonitor) {
        synchronized (this.f14299l) {
            UploadRecord uploadRecord = (UploadRecord) uploadSessionContext.f14473g.get(uploadSessionContext.f14470d);
            if (!(uploadRecord == null || uploadRecord.partitionInfo == null || uploadRecord.partitionInfo.size() <= i)) {
                uploadRecord.partitionInfo.remove(i);
                uploadRecord.partitionInfo.add(i, uploadPartitionInfo);
                uploadSessionContext.f14473g.put(uploadSessionContext.f14470d, uploadRecord);
                if (!uploadCrashMonitor.a(uploadSessionContext.f14470d, uploadRecord)) {
                    DefaultPhotoFlowLogger defaultPhotoFlowLogger = uploadSessionContext.f14490x;
                    UploadBaseParams uploadBaseParams = uploadSessionContext.f14492z;
                    UploadOperation uploadOperation = uploadSessionContext.f14467a;
                    defaultPhotoFlowLogger.m19931d(uploadBaseParams);
                }
            }
        }
    }
}
