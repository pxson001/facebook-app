package com.facebook.common.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import java.util.LinkedList;
import javax.inject.Singleton;

@Singleton
/* compiled from: story_save_nux_type */
public class DeferredHandler {
    private static volatile DeferredHandler f2489d;
    public LinkedList<Runnable> f2490a = new LinkedList();
    private MessageQueue f2491b = Looper.myQueue();
    private Impl f2492c = new Impl(this);

    /* compiled from: story_save_nux_type */
    class IdleRunnable implements Runnable {
        Runnable f2487a;

        public void run() {
            this.f2487a.run();
        }
    }

    /* compiled from: story_save_nux_type */
    class Impl extends Handler implements IdleHandler {
        final /* synthetic */ DeferredHandler f2488a;

        public Impl(DeferredHandler deferredHandler) {
            this.f2488a = deferredHandler;
        }

        public void handleMessage(Message message) {
            synchronized (this.f2488a.f2490a) {
                if (this.f2488a.f2490a.size() == 0) {
                    return;
                }
                Runnable runnable = (Runnable) this.f2488a.f2490a.removeFirst();
                runnable.run();
                synchronized (this.f2488a.f2490a) {
                    this.f2488a.m3622a();
                }
            }
        }

        public boolean queueIdle() {
            handleMessage(null);
            return false;
        }
    }

    public static com.facebook.common.async.DeferredHandler m3620a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2489d;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.common.async.DeferredHandler.class;
        monitor-enter(r1);
        r0 = f2489d;	 Catch:{ all -> 0x0039 }
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
        r0 = m3621b();	 Catch:{ all -> 0x0034 }
        f2489d = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f2489d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.async.DeferredHandler.a(com.facebook.inject.InjectorLike):com.facebook.common.async.DeferredHandler");
    }

    private static DeferredHandler m3621b() {
        return new DeferredHandler();
    }

    final void m3622a() {
        if (this.f2490a.size() <= 0) {
            return;
        }
        if (((Runnable) this.f2490a.getFirst()) instanceof IdleRunnable) {
            this.f2491b.addIdleHandler(this.f2492c);
        } else {
            this.f2492c.sendEmptyMessage(1);
        }
    }
}
