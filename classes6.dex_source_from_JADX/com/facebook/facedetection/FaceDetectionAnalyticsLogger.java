package com.facebook.facedetection;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: num_differences */
public class FaceDetectionAnalyticsLogger {
    private static volatile FaceDetectionAnalyticsLogger f9792d;
    private AnalyticsLogger f9793a;
    private PerformanceLogger f9794b;
    private String f9795c = null;

    /* compiled from: num_differences */
    public enum DetectionSource {
        FILE,
        BITMAP,
        FRAME
    }

    public static com.facebook.facedetection.FaceDetectionAnalyticsLogger m15525a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9792d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.facedetection.FaceDetectionAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f9792d;	 Catch:{ all -> 0x003a }
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
        r0 = m15529b(r0);	 Catch:{ all -> 0x0035 }
        f9792d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9792d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facedetection.FaceDetectionAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.facedetection.FaceDetectionAnalyticsLogger");
    }

    private static FaceDetectionAnalyticsLogger m15529b(InjectorLike injectorLike) {
        return new FaceDetectionAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    @Inject
    public FaceDetectionAnalyticsLogger(AnalyticsLogger analyticsLogger, PerformanceLogger performanceLogger) {
        this.f9793a = analyticsLogger;
        this.f9794b = performanceLogger;
    }

    public final void m15532a() {
        m15530b("FD_SUCCEEDED");
    }

    public final void m15535b() {
        m15530b("FD_FAILED");
    }

    public final void m15534a(String str) {
        HoneyClientEvent c = m15531c("TRACKER_FAILURE");
        c.b("REASON", str);
        m15527a(c);
    }

    public final void m15533a(int i, String str) {
        this.f9794b.d(i, str);
    }

    public final void m15536b(int i, String str) {
        this.f9794b.c(i, str);
    }

    private void m15530b(String str) {
        m15527a(m15531c(str));
    }

    private HoneyClientEvent m15531c(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "composer";
        if (this.f9795c != null) {
            honeyClientEvent.f = this.f9795c;
        }
        return honeyClientEvent;
    }

    private void m15527a(HoneyClientEvent honeyClientEvent) {
        this.f9793a.a(honeyClientEvent);
    }

    public static String m15526a(DetectionSource detectionSource) {
        Preconditions.checkNotNull(detectionSource);
        switch (detectionSource) {
            case FILE:
                return "file_face_detection_tracker";
            case BITMAP:
                return "face_detection_tracker";
            case FRAME:
                return "frame_detection_tracker";
            default:
                throw new IllegalArgumentException("Unknown DetectionSource");
        }
    }

    public static int m15528b(DetectionSource detectionSource) {
        Preconditions.checkNotNull(detectionSource);
        switch (detectionSource) {
            case FILE:
                return 3866626;
            case BITMAP:
                return 3866627;
            case FRAME:
                return 3866628;
            default:
                throw new IllegalArgumentException("Unknown DetectionSource");
        }
    }
}
