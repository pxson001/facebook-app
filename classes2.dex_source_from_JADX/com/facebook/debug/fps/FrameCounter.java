package com.facebook.debug.fps;

import com.facebook.inject.InjectorLike;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pool_alloc_ */
public class FrameCounter {
    private static volatile FrameCounter f9490e;
    public final ChoreographerWrapper f9491a;
    public final FrameCallbackWrapper f9492b;
    public long f9493c = 0;
    public boolean f9494d = false;

    /* compiled from: pool_alloc_ */
    public class C04101 extends FrameCallbackWrapper {
        final /* synthetic */ FrameCounter f9495a;

        public C04101(FrameCounter frameCounter) {
            this.f9495a = frameCounter;
        }

        public final void mo1639a(long j) {
            FrameCounter frameCounter = this.f9495a;
            frameCounter.f9493c = 1 + frameCounter.f9493c;
            if (this.f9495a.f9494d) {
                this.f9495a.f9491a.mo1636a(this.f9495a.f9492b);
            }
        }
    }

    public static com.facebook.debug.fps.FrameCounter m14482a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9490e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.debug.fps.FrameCounter.class;
        monitor-enter(r1);
        r0 = f9490e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m14483b(r0);	 Catch:{ all -> 0x0035 }
        f9490e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9490e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.debug.fps.FrameCounter.a(com.facebook.inject.InjectorLike):com.facebook.debug.fps.FrameCounter");
    }

    private static FrameCounter m14483b(InjectorLike injectorLike) {
        return new FrameCounter(DefaultChoreographerWrapper.m11555a(injectorLike));
    }

    @Inject
    public FrameCounter(ChoreographerWrapper choreographerWrapper) {
        this.f9491a = choreographerWrapper;
        this.f9492b = new C04101(this);
    }
}
