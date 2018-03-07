package com.facebook.facedetection.module;

import com.facebook.bitmaps.ImageResizerMethodAutoProvider;
import com.facebook.bitmaps.NativeImageLibraries;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.device.CpuCapabilities;
import com.facebook.facedetection.FaceDetectionAnalyticsLogger;
import com.facebook.facedetection.FaceDetectionAssetDownloader;
import com.facebook.facedetection.detector.NativeFaceDetector;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.ExecutorService;

/* compiled from: null diagnostic  */
public class NativeFaceDetectorMethodAutoProvider extends AbstractProvider<NativeFaceDetector> {
    private static volatile NativeFaceDetector f9833a;

    public static com.facebook.facedetection.detector.NativeFaceDetector m15588a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9833a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.facedetection.module.NativeFaceDetectorMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f9833a;	 Catch:{ all -> 0x003a }
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
        r0 = m15589b(r0);	 Catch:{ all -> 0x0035 }
        f9833a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9833a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facedetection.module.NativeFaceDetectorMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.facedetection.detector.NativeFaceDetector");
    }

    private static NativeFaceDetector m15589b(InjectorLike injectorLike) {
        return FaceDetectionModule.m15587a(FaceDetectionAssetDownloader.m15537b(injectorLike), CpuCapabilities.a(injectorLike), FaceDetectionAnalyticsLogger.m15525a(injectorLike), ImageResizerMethodAutoProvider.b(injectorLike), NativeImageLibraries.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), Boolean_IsFaceDetectionEnabledGatekeeperAutoProvider.m15585b(injectorLike));
    }

    public Object get() {
        return FaceDetectionModule.m15587a(FaceDetectionAssetDownloader.m15537b(this), CpuCapabilities.a(this), FaceDetectionAnalyticsLogger.m15525a((InjectorLike) this), ImageResizerMethodAutoProvider.b(this), NativeImageLibraries.a(this), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), Boolean_IsFaceDetectionEnabledGatekeeperAutoProvider.m15585b(this));
    }
}
