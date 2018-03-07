package com.facebook.facecast.plugin.commercialbreak;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: byte[] */
public class CommercialBreakBroadcastStateManager {
    private static volatile CommercialBreakBroadcastStateManager f18568d;
    public final List<CommercialBreakBroadcastStateChangeListener> f18569a = new ArrayList();
    public CommercialBreakBroadcastState f18570b = CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_UNINITIALIZED;
    public CommercialBreakBroadcastState f18571c = CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_UNINITIALIZED;

    /* compiled from: byte[] */
    public interface CommercialBreakBroadcastStateChangeListener {
        void mo1386a(CommercialBreakBroadcastState commercialBreakBroadcastState, CommercialBreakBroadcastState commercialBreakBroadcastState2);
    }

    /* compiled from: byte[] */
    public enum CommercialBreakBroadcastState {
        COMMERCIAL_BREAK_BROADCAST_UNINITIALIZED,
        COMMERCIAL_BREAK_BROADCAST_ELIGIBLE,
        COMMERCIAL_BREAK_BROADCAST_PROMPT,
        COMMERCIAL_BREAK_BROADCAST_PRE_COUNTDOWN,
        COMMERCIAL_BREAK_BROADCAST_PLAYING,
        COMMERCIAL_BREAK_BROADCAST_INTERRUPTED,
        COMMERCIAL_BREAK_BROADCAST_RESUME,
        COMMERCIAL_BREAK_BROADCAST_FINISH
    }

    public static com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager m22183a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f18568d;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.class;
        monitor-enter(r1);
        r0 = f18568d;	 Catch:{ all -> 0x0039 }
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
        r0 = m22184d();	 Catch:{ all -> 0x0034 }
        f18568d = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f18568d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.a(com.facebook.inject.InjectorLike):com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager");
    }

    private static CommercialBreakBroadcastStateManager m22184d() {
        return new CommercialBreakBroadcastStateManager();
    }

    public final void m22186a(@Nullable CommercialBreakBroadcastStateChangeListener commercialBreakBroadcastStateChangeListener) {
        if (commercialBreakBroadcastStateChangeListener != null) {
            this.f18569a.add(commercialBreakBroadcastStateChangeListener);
        }
    }

    public final void m22188b(CommercialBreakBroadcastStateChangeListener commercialBreakBroadcastStateChangeListener) {
        this.f18569a.remove(commercialBreakBroadcastStateChangeListener);
    }

    public final CommercialBreakBroadcastState m22187b() {
        return this.f18570b;
    }

    public final void m22185a(CommercialBreakBroadcastState commercialBreakBroadcastState) {
        this.f18571c = this.f18570b;
        this.f18570b = commercialBreakBroadcastState;
        for (CommercialBreakBroadcastStateChangeListener a : this.f18569a) {
            a.mo1386a(this.f18570b, this.f18571c);
        }
    }
}
