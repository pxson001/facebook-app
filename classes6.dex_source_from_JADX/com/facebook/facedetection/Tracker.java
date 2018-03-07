package com.facebook.facedetection;

import android.graphics.Bitmap;
import com.facebook.device.ScreenUtil;
import com.facebook.facedetection.detector.InternalFaceDetector;
import com.facebook.facedetection.gating.FaceDetectionGating;
import com.facebook.facedetection.model.TagDescriptor;
import com.facebook.facedetection.module.FaceDetectionModule;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: num_checked */
public class Tracker {
    private static volatile Tracker f9798c;
    public final int f9799a;
    public InternalFaceDetector f9800b = null;

    public static com.facebook.facedetection.Tracker m15542a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9798c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.facedetection.Tracker.class;
        monitor-enter(r1);
        r0 = f9798c;	 Catch:{ all -> 0x003a }
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
        r0 = m15543b(r0);	 Catch:{ all -> 0x0035 }
        f9798c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9798c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facedetection.Tracker.a(com.facebook.inject.InjectorLike):com.facebook.facedetection.Tracker");
    }

    private static Tracker m15543b(InjectorLike injectorLike) {
        return new Tracker(FaceDetectionGating.m15568a(injectorLike), FaceDetectionModule.m15586a((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 5762), IdBasedProvider.a(injectorLike, 5760)), ScreenUtil.a(injectorLike));
    }

    @Inject
    public Tracker(FaceDetectionGating faceDetectionGating, InternalFaceDetector internalFaceDetector, ScreenUtil screenUtil) {
        Object obj;
        if (faceDetectionGating.f9822a && (faceDetectionGating.f9823b.a() || faceDetectionGating.f9823b.b())) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.f9800b = internalFaceDetector;
        }
        this.f9799a = Math.max(screenUtil.c(), screenUtil.d());
    }

    public final boolean m15545a() {
        return this.f9800b != null;
    }

    public final List<TagDescriptor> m15544a(Bitmap bitmap, int i, boolean z) {
        if (this.f9800b == null || !this.f9800b.mo1020a()) {
            return Lists.a();
        }
        return this.f9800b.mo1018a(bitmap, i, z);
    }
}
