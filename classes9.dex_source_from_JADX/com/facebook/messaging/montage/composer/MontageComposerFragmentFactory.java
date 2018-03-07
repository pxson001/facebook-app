package com.facebook.messaging.montage.composer;

import com.facebook.base.fragment.FbFragment;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_promote_website */
public class MontageComposerFragmentFactory<T extends FbFragment & MontageComposerCanvas> {
    private static volatile MontageComposerFragmentFactory f12484c;
    public final Map<CanvasType, WeakReference<T>> f12485a = new HashMap();
    public final Map<CanvasType, T> f12486b = new HashMap();

    /* compiled from: is_promote_website */
    public /* synthetic */ class C13861 {
        public static final /* synthetic */ int[] f12483a = new int[CanvasType.values().length];

        static {
            try {
                f12483a[CanvasType.CAMERA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12483a[CanvasType.MEDIA_PICKER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12483a[CanvasType.LOCATION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static com.facebook.messaging.montage.composer.MontageComposerFragmentFactory m12947a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f12484c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.montage.composer.MontageComposerFragmentFactory.class;
        monitor-enter(r1);
        r0 = f12484c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m12949c();	 Catch:{ all -> 0x0034 }
        f12484c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12484c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.montage.composer.MontageComposerFragmentFactory.a(com.facebook.inject.InjectorLike):com.facebook.messaging.montage.composer.MontageComposerFragmentFactory");
    }

    private static MontageComposerFragmentFactory m12949c() {
        return new MontageComposerFragmentFactory();
    }

    public static T m12948b(CanvasType canvasType) {
        switch (C13861.f12483a[canvasType.ordinal()]) {
            case 1:
                return new MontageCameraCanvasFragment();
            case 2:
                return new MontageMediaPickerCanvasFragment();
            case 3:
                return new MontageLocationCanvasFragment();
            default:
                throw new IllegalStateException("Invalid canvas type:" + canvasType);
        }
    }
}
