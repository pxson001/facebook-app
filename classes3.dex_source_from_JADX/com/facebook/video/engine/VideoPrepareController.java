package com.facebook.video.engine;

import com.facebook.device.DeviceConditionHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.video.abtest.VideoExoplayerConfig;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ufi/reactions/v2/face_models/haha */
public class VideoPrepareController {
    private static volatile VideoPrepareController f91d;
    private final DeviceConditionHelper f92a;
    private final NativePlayerPool f93b;
    private VideoExoplayerConfig f94c;

    public static com.facebook.video.engine.VideoPrepareController m87a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f91d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.engine.VideoPrepareController.class;
        monitor-enter(r1);
        r0 = f91d;	 Catch:{ all -> 0x003a }
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
        r0 = m88b(r0);	 Catch:{ all -> 0x0035 }
        f91d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f91d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.VideoPrepareController.a(com.facebook.inject.InjectorLike):com.facebook.video.engine.VideoPrepareController");
    }

    private static VideoPrepareController m88b(InjectorLike injectorLike) {
        return new VideoPrepareController(DeviceConditionHelper.a(injectorLike), NativePlayerPool.a(injectorLike), VideoExoplayerConfig.b(injectorLike));
    }

    @Inject
    public VideoPrepareController(DeviceConditionHelper deviceConditionHelper, NativePlayerPool nativePlayerPool, VideoExoplayerConfig videoExoplayerConfig) {
        this.f92a = deviceConditionHelper;
        this.f93b = nativePlayerPool;
        this.f94c = videoExoplayerConfig;
    }

    public final boolean m89a(boolean z) {
        boolean b = this.f92a.b();
        if (!z) {
            if (!(b ? this.f94c.E : this.f94c.F)) {
                Boolean.valueOf(b);
                return false;
            }
        }
        boolean a = this.f93b.a();
        if (!(a ? this.f94c.u : this.f94c.t)) {
            Boolean.valueOf(a);
            return false;
        } else if (b) {
            return this.f94c.w;
        } else {
            return this.f94c.v;
        }
    }
}
