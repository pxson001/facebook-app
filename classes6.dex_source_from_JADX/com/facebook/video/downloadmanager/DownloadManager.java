package com.facebook.video.downloadmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.common.executors.DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.SavedVideoDownloadStateInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.common.HttpFutureWrapper;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.video.downloadmanager.DownloadCompleteNotifier.C13831;
import com.facebook.video.downloadmanager.VideoDownloadAnalytics.Event;
import com.facebook.video.downloadmanager.graphql.SavedVideoMutation.SavedVideoDownloadStateMutationString;
import com.facebook.video.events.VideoDownloadEventBus;
import com.facebook.video.events.VideoDownloadEvents.DownloadStatusChangeEvent;
import com.facebook.video.events.VideoDownloadStatus;
import com.facebook.video.events.VideoDownloadStatus.DownloadStatus;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"BadMethodUse-com.google.common.util.concurrent.Futures.addCallback", "ConstructorMayLeakThis"})
/* compiled from: contactId */
public class DownloadManager {
    public static final String f18653b = DownloadManager.class.getName();
    private static volatile DownloadManager f18654l;
    public final C13851 f18655a = new C13851(this);
    public final SavedVideoDbHelper f18656c;
    private final VideoDownloadHandler f18657d;
    public HashMap<String, HttpFutureWrapper> f18658e;
    private final VideoDownloadEventBus f18659f;
    public final DefaultSerialListeningExecutorService f18660g;
    private final DownloadCompleteNotifier f18661h;
    public final VideoDownloadAnalytics f18662i;
    public final NetworkMonitor f18663j;
    public final DownloadManagerConfig f18664k;

    /* compiled from: contactId */
    public class C13851 {
        final /* synthetic */ DownloadManager f18639a;

        C13851(DownloadManager downloadManager) {
            this.f18639a = downloadManager;
        }

        public final void m27401a(String str, long j, long j2) {
            synchronized (this.f18639a) {
                if (j >= j2) {
                    this.f18639a.f18656c.m27439a(str, j2);
                }
                if (j <= j2) {
                    this.f18639a.f18662i.m27461a(str, Event.DOWNLOAD_COMPLETED);
                    this.f18639a.f18656c.m27437a(str, DownloadStatus.DOWNLOAD_COMPLETED);
                    this.f18639a.f18658e.remove(str);
                }
                DownloadManager.m27409h(this.f18639a, str);
            }
        }

        public final void m27402a(final String str, Exception exception) {
            synchronized (this.f18639a) {
                BLog.b(DownloadManager.f18653b, exception, "Error downloading video", new Object[0]);
                try {
                    this.f18639a.f18662i.m27461a(str, Event.DOWNLOAD_FAILED);
                    this.f18639a.f18658e.remove(str);
                    VideoDownloadAnalyticsRecord c = this.f18639a.f18656c.m27441c(str);
                    if (c == null || c.f18711b >= 5) {
                        BLog.b(DownloadManager.f18653b, exception, "ABORTING DOWNLOAD", new Object[0]);
                        this.f18639a.f18656c.m27437a(str, DownloadStatus.DOWNLOAD_ABORTED);
                    } else {
                        this.f18639a.f18656c.m27437a(str, DownloadStatus.DOWNLOAD_FAILED);
                        if (this.f18639a.f18663j.a()) {
                            new Timer().schedule(new TimerTask(this) {
                                final /* synthetic */ C13851 f18638b;

                                public void run() {
                                    DownloadManager downloadManager = this.f18638b.f18639a;
                                    ListenableFuture a = downloadManager.f18660g.a(new C13895(downloadManager, str));
                                }
                            }, this.f18639a.f18664k.m27419b());
                        }
                    }
                    DownloadManager.m27409h(this.f18639a, str);
                } catch (Throwable e) {
                    BLog.b(DownloadManager.f18653b, e, "failing retry download", new Object[0]);
                    this.f18639a.f18656c.m27437a(str, DownloadStatus.DOWNLOAD_ABORTED);
                    DownloadManager.m27409h(this.f18639a, str);
                }
            }
        }
    }

    /* compiled from: contactId */
    public class C13862 implements Callable {
        final /* synthetic */ DownloadManager f18640a;

        public C13862(DownloadManager downloadManager) {
            this.f18640a = downloadManager;
        }

        public Object call() {
            DownloadManager.f18653b;
            VideoDownloadRecord a = this.f18640a.f18656c.m27435a(DownloadStatus.DOWNLOAD_NOT_STARTED);
            while (a != null) {
                DownloadManager.f18653b;
                try {
                    DownloadManager.m27405a(this.f18640a, a);
                } catch (Exception e) {
                    BLog.b(DownloadManager.f18653b, "Rescheduling download exception for %s", new Object[]{a.f18725a, e});
                    DownloadManager.m27409h(this.f18640a, a.f18725a);
                }
                a = this.f18640a.f18656c.m27435a(DownloadStatus.DOWNLOAD_NOT_STARTED);
            }
            return null;
        }
    }

    /* compiled from: contactId */
    public class C13873 implements Runnable {
        final /* synthetic */ DownloadManager f18641a;

        public C13873(DownloadManager downloadManager) {
            this.f18641a = downloadManager;
        }

        public void run() {
            this.f18641a.m27411a();
        }
    }

    /* compiled from: contactId */
    class C13884 implements Callable {
        final /* synthetic */ DownloadManager f18642a;

        C13884(DownloadManager downloadManager) {
            this.f18642a = downloadManager;
        }

        public Object call() {
            VideoDownloadRecord a = this.f18642a.f18656c.m27435a(DownloadStatus.DOWNLOAD_FAILED);
            while (a != null) {
                try {
                    this.f18642a.f18656c.m27437a(a.f18725a, DownloadStatus.DOWNLOAD_NOT_STARTED);
                    DownloadManager.f18653b;
                    DownloadManager.m27405a(this.f18642a, a);
                } catch (Exception e) {
                    DownloadManager.m27409h(this.f18642a, a.f18725a);
                }
                a = this.f18642a.f18656c.m27435a(DownloadStatus.DOWNLOAD_FAILED);
            }
            return null;
        }
    }

    /* compiled from: contactId */
    public class C13895 implements Callable<Void> {
        final /* synthetic */ String f18643a;
        final /* synthetic */ DownloadManager f18644b;

        public C13895(DownloadManager downloadManager, String str) {
            this.f18644b = downloadManager;
            this.f18643a = str;
        }

        public Object call() {
            synchronized (this.f18644b) {
                VideoDownloadRecord a = this.f18644b.f18656c.m27436a(this.f18643a);
                if (a != null && a.f18730f == DownloadStatus.DOWNLOAD_FAILED) {
                    this.f18644b.f18656c.m27437a(a.f18725a, DownloadStatus.DOWNLOAD_NOT_STARTED);
                    BLog.b(DownloadManager.f18653b, "Retrying download for video %s", new Object[]{a.f18725a});
                    DownloadManager.m27405a(this.f18644b, a);
                }
            }
            return null;
        }
    }

    public static com.facebook.video.downloadmanager.DownloadManager m27403a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f18654l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.downloadmanager.DownloadManager.class;
        monitor-enter(r1);
        r0 = f18654l;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m27406b(r0);	 Catch:{ all -> 0x0035 }
        f18654l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18654l;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.downloadmanager.DownloadManager.a(com.facebook.inject.InjectorLike):com.facebook.video.downloadmanager.DownloadManager");
    }

    private static DownloadManager m27406b(InjectorLike injectorLike) {
        return new DownloadManager((Context) injectorLike.getInstance(Context.class), NetworkMonitor.a(injectorLike), SavedVideoDbHelper.m27429a(injectorLike), VideoDownloadHandler.m27464a(injectorLike), VideoDownloadEventBus.m27618a(injectorLike), DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.b(injectorLike), DownloadCompleteNotifier.m27399a(injectorLike), VideoDownloadAnalytics.m27458a(injectorLike), DownloadManagerConfig.m27417a(injectorLike));
    }

    @Inject
    public DownloadManager(Context context, NetworkMonitor networkMonitor, SavedVideoDbHelper savedVideoDbHelper, VideoDownloadHandler videoDownloadHandler, VideoDownloadEventBus videoDownloadEventBus, DefaultSerialListeningExecutorService defaultSerialListeningExecutorService, DownloadCompleteNotifier downloadCompleteNotifier, VideoDownloadAnalytics videoDownloadAnalytics, DownloadManagerConfig downloadManagerConfig) {
        this.f18660g = defaultSerialListeningExecutorService;
        this.f18663j = networkMonitor;
        this.f18659f = videoDownloadEventBus;
        this.f18656c = savedVideoDbHelper;
        this.f18657d = videoDownloadHandler;
        this.f18658e = new HashMap();
        this.f18661h = downloadCompleteNotifier;
        this.f18662i = videoDownloadAnalytics;
        this.f18664k = downloadManagerConfig;
        this.f18663j.a(State.CONNECTED, new C13873(this));
        this.f18660g.a(new C13862(this));
        m27411a();
    }

    public final void m27411a() {
        this.f18660g.a(new C13884(this));
    }

    static String m27404a(String str, String str2) {
        return str + str2 + SafeUUIDGenerator.a().toString();
    }

    public static synchronized void m27405a(DownloadManager downloadManager, final VideoDownloadRecord videoDownloadRecord) {
        synchronized (downloadManager) {
            try {
                File file = new File(videoDownloadRecord.f18729e);
                downloadManager.f18656c.m27437a(videoDownloadRecord.f18725a, DownloadStatus.DOWNLOAD_IN_PROGRESS);
                downloadManager.f18662i.m27461a(videoDownloadRecord.f18725a, Event.DOWNLOAD_STARTED);
                HttpFutureWrapper a = downloadManager.f18657d.m27472a(videoDownloadRecord.f18726b, videoDownloadRecord.f18725a, file, downloadManager.f18655a);
                downloadManager.f18658e.put(videoDownloadRecord.f18725a, a);
                Futures.a(a.a(), new FutureCallback(downloadManager) {
                    final /* synthetic */ DownloadManager f18646b;

                    public void onSuccess(@Nullable Object obj) {
                    }

                    public void onFailure(Throwable th) {
                        if (!(th instanceof CancellationException)) {
                            this.f18646b.f18655a.m27402a(videoDownloadRecord.f18725a, new IOException(th));
                        }
                    }
                });
            } catch (Throwable e) {
                BLog.b(f18653b, "Failed to schedule download", e);
                downloadManager.f18656c.m27437a(videoDownloadRecord.f18725a, DownloadStatus.DOWNLOAD_ABORTED);
                throw e;
            }
        }
    }

    public final ListenableFuture m27410a(final VideoDownloadRequest videoDownloadRequest) {
        if (videoDownloadRequest.f18735e <= 0) {
            throw new IllegalArgumentException("Video size must be specified");
        }
        return this.f18660g.a(new Callable<Void>(this) {
            final /* synthetic */ DownloadManager f18648b;

            public Object call() {
                DownloadManager.f18653b;
                synchronized (this.f18648b) {
                    VideoDownloadRecord a = this.f18648b.f18656c.m27436a(videoDownloadRequest.f18732b);
                    if (a == null || !new File(a.f18729e).exists()) {
                        if (a != null) {
                            DownloadManager.f18653b;
                            this.f18648b.f18656c.m27440b(videoDownloadRequest.f18732b);
                        }
                        DownloadManager.f18653b;
                        a = new VideoDownloadRecord(videoDownloadRequest);
                        a.f18729e = DownloadManager.m27404a(this.f18648b.f18656c.f18683b, videoDownloadRequest.f18732b);
                        try {
                            new File(a.f18729e).createNewFile();
                        } catch (IOException e) {
                            DownloadManager.f18653b;
                        }
                        this.f18648b.f18656c.m27438a(a, videoDownloadRequest.f18734d);
                        this.f18648b.f18662i.m27461a(a.f18725a, Event.DOWNLOAD_QUEUED);
                    } else if (a.f18730f == DownloadStatus.DOWNLOAD_IN_PROGRESS || a.f18730f == DownloadStatus.DOWNLOAD_COMPLETED) {
                        DownloadManager.f18653b;
                        toString();
                        DownloadManager.f18653b;
                    } else {
                        DownloadManager.f18653b;
                        this.f18648b.f18656c.m27437a(a.f18725a, DownloadStatus.DOWNLOAD_NOT_STARTED);
                    }
                    DownloadManager.m27409h(this.f18648b, videoDownloadRequest.f18732b);
                    DownloadManager.m27405a(this.f18648b, a);
                    DownloadManager.f18653b;
                }
                return null;
            }
        });
    }

    public static synchronized void m27408g(DownloadManager downloadManager, String str) {
        synchronized (downloadManager) {
            HttpFutureWrapper httpFutureWrapper = (HttpFutureWrapper) downloadManager.f18658e.get(str);
            if (httpFutureWrapper != null) {
                downloadManager.f18662i.m27461a(str, Event.DOWNLOAD_CANCELLED);
                httpFutureWrapper.b();
                httpFutureWrapper.a().cancel(true);
                try {
                    FutureDetour.a(httpFutureWrapper.a(), 1000, TimeUnit.MILLISECONDS, 386404356);
                } catch (TimeoutException e) {
                    throw e;
                } catch (CancellationException e2) {
                } catch (Throwable e3) {
                    BLog.a(f18653b, "Download already completed with an exception", e3);
                }
            }
        }
    }

    public final synchronized ListenableFuture m27412b(final String str) {
        return this.f18660g.a(new Callable<Void>(this) {
            final /* synthetic */ DownloadManager f18650b;

            public Object call() {
                VideoDownloadRecord a = this.f18650b.f18656c.m27436a(str);
                if (a != null) {
                    this.f18650b.f18662i.m27461a(a.f18725a, Event.DOWNLOAD_DELETED);
                    DownloadManager.m27408g(this.f18650b, str);
                    File file = new File(a.f18729e);
                    String str = DownloadManager.f18653b;
                    if (!file.exists() || file.delete()) {
                        if (!this.f18650b.f18656c.m27440b(str)) {
                            BLog.a(DownloadManager.f18653b, "Failed to delete the video record %s", new Object[]{str});
                        }
                        DownloadManager.m27409h(this.f18650b, str);
                    } else {
                        BLog.b(DownloadManager.f18653b, "Failed to delete the video file %s", new Object[]{a.f18729e});
                        throw new IOException("Cannot delete video file " + a.f18729e);
                    }
                }
                return null;
            }
        });
    }

    public final synchronized ListenableFuture m27413c(final String str) {
        return this.f18660g.a(new Callable<Void>(this) {
            final /* synthetic */ DownloadManager f18652b;

            public Object call() {
                DownloadManager.m27408g(this.f18652b, str);
                this.f18652b.f18662i.m27461a(str, Event.DOWNLOAD_PAUSED);
                this.f18652b.f18656c.m27437a(str, DownloadStatus.DOWNLOAD_PAUSED);
                DownloadManager.m27409h(this.f18652b, str);
                return null;
            }
        });
    }

    public static void m27409h(DownloadManager downloadManager, String str) {
        VideoDownloadRecord a = downloadManager.f18656c.m27436a(str);
        downloadManager.f18659f.a(new DownloadStatusChangeEvent(str, downloadManager.m27414d(str)));
        if (a != null && a.f18730f == DownloadStatus.DOWNLOAD_COMPLETED) {
            DownloadCompleteNotifier downloadCompleteNotifier = downloadManager.f18661h;
            SavedVideoDownloadStateInputData savedVideoDownloadStateInputData = new SavedVideoDownloadStateInputData();
            savedVideoDownloadStateInputData.a("video_id", str);
            GraphQlCallInput graphQlCallInput = savedVideoDownloadStateInputData;
            GraphQlQueryString savedVideoDownloadStateMutationString = new SavedVideoDownloadStateMutationString();
            savedVideoDownloadStateMutationString.a("input", graphQlCallInput);
            Futures.a(downloadCompleteNotifier.f18636b.a(GraphQLRequest.a(savedVideoDownloadStateMutationString)), new C13831(downloadCompleteNotifier, str));
        }
    }

    public final VideoDownloadStatus m27414d(String str) {
        try {
            VideoDownloadRecord a = this.f18656c.m27436a(str);
            if (a == null) {
                return new VideoDownloadStatus(0, 0, DownloadStatus.DOWNLOAD_NOT_REQUESTED);
            }
            if (new File(a.f18729e).exists()) {
                return new VideoDownloadStatus(a.f18727c, a.f18728d, a.f18730f);
            }
            return new VideoDownloadStatus(a.f18727c, 0, DownloadStatus.DOWNLOAD_NOT_REQUESTED);
        } catch (Throwable e) {
            BLog.b(f18653b, "Exception getting download status", e);
            return new VideoDownloadStatus(0, 0, DownloadStatus.DOWNLOAD_NOT_REQUESTED);
        }
    }

    public final boolean m27415e(String str) {
        try {
            VideoDownloadStatus d = m27414d(str);
            if (d.f18951c == DownloadStatus.DOWNLOAD_NOT_REQUESTED || d.f18951c == DownloadStatus.DOWNLOAD_ABORTED) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            BLog.b(f18653b, "getDownloadStatus failed ", e);
            return false;
        }
    }

    public final boolean m27416f(String str) {
        try {
            VideoDownloadStatus d = m27414d(str);
            if (d.f18951c == DownloadStatus.DOWNLOAD_COMPLETED || d.f18951c == DownloadStatus.DOWNLOAD_IN_PROGRESS) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            BLog.b(f18653b, "getDownloadStatus failed ", e);
            return false;
        }
    }
}
