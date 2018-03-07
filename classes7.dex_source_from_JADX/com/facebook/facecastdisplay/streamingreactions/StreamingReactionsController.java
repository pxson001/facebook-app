package com.facebook.facecastdisplay.streamingreactions;

import com.facebook.facecastdisplay.analytics.FacecastDisplayLogger;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: starting_media_id */
public class StreamingReactionsController {
    private static volatile StreamingReactionsController f3327e;
    public final GatekeeperStoreImpl f3328a;
    private final Lazy<FacecastDisplayLogger> f3329b;
    private final Set<String> f3330c = new HashSet();
    private final Set<OnStreamingReactionsToggledListener> f3331d = new LinkedHashSet();

    /* compiled from: starting_media_id */
    public interface OnStreamingReactionsToggledListener {
        void mo162a(String str, boolean z);
    }

    public static com.facebook.facecastdisplay.streamingreactions.StreamingReactionsController m4075a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3327e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.facecastdisplay.streamingreactions.StreamingReactionsController.class;
        monitor-enter(r1);
        r0 = f3327e;	 Catch:{ all -> 0x003a }
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
        r0 = m4077b(r0);	 Catch:{ all -> 0x0035 }
        f3327e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3327e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.streamingreactions.StreamingReactionsController.a(com.facebook.inject.InjectorLike):com.facebook.facecastdisplay.streamingreactions.StreamingReactionsController");
    }

    private static StreamingReactionsController m4077b(InjectorLike injectorLike) {
        return new StreamingReactionsController(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 5743));
    }

    @Inject
    public StreamingReactionsController(GatekeeperStore gatekeeperStore, Lazy<FacecastDisplayLogger> lazy) {
        this.f3328a = gatekeeperStore;
        this.f3329b = lazy;
    }

    public final boolean m4079a(String str) {
        return this.f3330c.contains(str);
    }

    public final void m4081b(String str) {
        this.f3330c.add(str);
        m4076a(str, false);
        ((FacecastDisplayLogger) this.f3329b.get()).m3312f();
    }

    public final void m4082c(String str) {
        this.f3330c.remove(str);
        m4076a(str, true);
        ((FacecastDisplayLogger) this.f3329b.get()).m3313g();
    }

    private synchronized void m4076a(String str, boolean z) {
        for (OnStreamingReactionsToggledListener a : (OnStreamingReactionsToggledListener[]) this.f3331d.toArray(new OnStreamingReactionsToggledListener[this.f3331d.size()])) {
            a.mo162a(str, z);
        }
    }

    public final synchronized void m4078a(OnStreamingReactionsToggledListener onStreamingReactionsToggledListener) {
        if (onStreamingReactionsToggledListener != null) {
            if (!this.f3331d.contains(onStreamingReactionsToggledListener)) {
                this.f3331d.add(onStreamingReactionsToggledListener);
            }
        }
    }

    public final synchronized void m4080b(OnStreamingReactionsToggledListener onStreamingReactionsToggledListener) {
        this.f3331d.remove(onStreamingReactionsToggledListener);
    }
}
