package com.facebook.video.downloadmanager;

import android.net.NetworkInfo;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: connection_manager_latency_quality */
public class VideoDownloadAnalytics {
    private static volatile VideoDownloadAnalytics f18706d;
    private final AnalyticsLogger f18707a;
    private final FbNetworkManager f18708b;
    private final SavedVideoDbHelper f18709c;

    /* compiled from: connection_manager_latency_quality */
    public enum Event {
        DOWNLOAD_QUEUED("video_download_queued"),
        DOWNLOAD_STARTED("video_download_started"),
        DOWNLOAD_PAUSED("video_download_paused"),
        DOWNLOAD_COMPLETED("video_download_completed"),
        DOWNLOAD_ABORTED("video_download_aborted"),
        DOWNLOAD_CANCELLED("video_download_cancelled"),
        DOWNLOAD_DELETED("video_download_deleted"),
        DOWNLOAD_FAILED("video_download_failed");
        
        public final String value;

        private Event(String str) {
            this.value = str;
        }
    }

    /* compiled from: connection_manager_latency_quality */
    public enum EventParams {
        VIDEO_ID("video_id"),
        VIDEO_SIZE("video_size"),
        DOWNLOADED_SIZE("downloaded_size"),
        DOWNLOAD_SESSION_ID("download_session_id"),
        DOWNLOAD_ORIGIN("download_origin"),
        DOWNLOAD_DURATION("download_duration"),
        DOWNLOAD_ATTEMPTS("download_attempts"),
        CONNECTION_TYPE_PARAM("connection_type"),
        CONNECTION_SUB_TYPE_PARAM("connection_sub_type");
        
        public final String value;

        private EventParams(String str) {
            this.value = str;
        }
    }

    public static com.facebook.video.downloadmanager.VideoDownloadAnalytics m27458a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18706d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.downloadmanager.VideoDownloadAnalytics.class;
        monitor-enter(r1);
        r0 = f18706d;	 Catch:{ all -> 0x003a }
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
        r0 = m27460b(r0);	 Catch:{ all -> 0x0035 }
        f18706d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18706d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.downloadmanager.VideoDownloadAnalytics.a(com.facebook.inject.InjectorLike):com.facebook.video.downloadmanager.VideoDownloadAnalytics");
    }

    private static VideoDownloadAnalytics m27460b(InjectorLike injectorLike) {
        return new VideoDownloadAnalytics(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), SavedVideoDbHelper.m27429a(injectorLike));
    }

    @Inject
    public VideoDownloadAnalytics(AnalyticsLogger analyticsLogger, FbNetworkManager fbNetworkManager, SavedVideoDbHelper savedVideoDbHelper) {
        this.f18707a = analyticsLogger;
        this.f18708b = fbNetworkManager;
        this.f18709c = savedVideoDbHelper;
    }

    private HoneyClientEvent m27457a(String str, int i, long j, long j2, String str2, Event event) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event.value);
        NetworkInfo b = this.f18708b.b();
        if (b != null) {
            honeyClientEvent.b(EventParams.VIDEO_ID.value, str);
            honeyClientEvent.a(EventParams.VIDEO_SIZE.value, j);
            honeyClientEvent.a(EventParams.DOWNLOADED_SIZE.value, j2);
            honeyClientEvent.b(EventParams.DOWNLOAD_ORIGIN.value, str2);
            honeyClientEvent.a(EventParams.DOWNLOAD_SESSION_ID.value, i);
            honeyClientEvent.b(EventParams.CONNECTION_TYPE_PARAM.value, b.getTypeName());
            honeyClientEvent.b(EventParams.CONNECTION_SUB_TYPE_PARAM.value, b.getSubtypeName());
        }
        return honeyClientEvent;
    }

    private void m27459a(VideoDownloadRecord videoDownloadRecord, Event event) {
        VideoDownloadAnalyticsRecord c = this.f18709c.m27441c(videoDownloadRecord.f18725a);
        try {
            HoneyClientEvent a = m27457a(videoDownloadRecord.f18725a, videoDownloadRecord.f18729e.hashCode(), videoDownloadRecord.f18727c, videoDownloadRecord.f18728d, c != null ? c.f18715f : null, event);
            if (event == Event.DOWNLOAD_COMPLETED || event == Event.DOWNLOAD_ABORTED) {
                a.a(EventParams.DOWNLOAD_ATTEMPTS.value, c.f18711b);
                a.a(EventParams.DOWNLOAD_DURATION.value, c.f18713d - c.f18712c);
            }
            this.f18707a.a(a);
        } catch (Exception e) {
        }
    }

    public final void m27461a(String str, Event event) {
        VideoDownloadRecord a = this.f18709c.m27436a(str);
        if (a != null) {
            m27459a(a, event);
        }
    }
}
