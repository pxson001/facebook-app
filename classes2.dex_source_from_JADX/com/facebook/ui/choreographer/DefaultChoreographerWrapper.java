package com.facebook.ui.choreographer;

import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Choreographer;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: response_header_compressed_size */
public class DefaultChoreographerWrapper implements ChoreographerWrapper {
    private static boolean f6965a = (VERSION.SDK_INT >= 16);
    private static volatile DefaultChoreographerWrapper f6966d;
    private Handler f6967b;
    public Choreographer f6968c;

    public static com.facebook.ui.choreographer.DefaultChoreographerWrapper m11555a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6966d;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.ui.choreographer.DefaultChoreographerWrapper.class;
        monitor-enter(r1);
        r0 = f6966d;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m11556b();	 Catch:{ all -> 0x0034 }
        f6966d = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f6966d;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.choreographer.DefaultChoreographerWrapper.a(com.facebook.inject.InjectorLike):com.facebook.ui.choreographer.DefaultChoreographerWrapper");
    }

    private static DefaultChoreographerWrapper m11556b() {
        return new DefaultChoreographerWrapper();
    }

    @Inject
    public DefaultChoreographerWrapper() {
        if (f6965a) {
            this.f6968c = Choreographer.getInstance();
        } else {
            this.f6967b = new Handler();
        }
    }

    public final void mo1636a(FrameCallbackWrapper frameCallbackWrapper) {
        if (f6965a) {
            this.f6968c.postFrameCallback(frameCallbackWrapper.m11565a());
            return;
        }
        HandlerDetour.b(this.f6967b, frameCallbackWrapper.m11567b(), 0, -1811860140);
    }

    public final void mo1637a(FrameCallbackWrapper frameCallbackWrapper, long j) {
        if (f6965a) {
            this.f6968c.postFrameCallbackDelayed(frameCallbackWrapper.m11565a(), j);
            return;
        }
        HandlerDetour.b(this.f6967b, frameCallbackWrapper.m11567b(), 17 + j, -2003034014);
    }

    public final void mo1638b(FrameCallbackWrapper frameCallbackWrapper) {
        if (f6965a) {
            this.f6968c.removeFrameCallback(frameCallbackWrapper.m11565a());
            return;
        }
        HandlerDetour.a(this.f6967b, frameCallbackWrapper.m11567b());
    }
}
