package com.facebook.debug.mainlooper;

import android.os.Handler;
import android.os.Looper;
import android.util.Printer;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: time_since_startup */
public class MainLooperLogMessagesDispatcher {
    private static volatile MainLooperLogMessagesDispatcher f2813e;
    public final Printer f2814a;
    private final Runnable f2815b;
    public final Handler f2816c;
    public final List<MainLooperLogMessageListener> f2817d;

    /* compiled from: time_since_startup */
    class C01771 implements Printer {
        final /* synthetic */ MainLooperLogMessagesDispatcher f2818a;

        C01771(MainLooperLogMessagesDispatcher mainLooperLogMessagesDispatcher) {
            this.f2818a = mainLooperLogMessagesDispatcher;
        }

        public void println(String str) {
            synchronized (this.f2818a.f2817d) {
                for (int i = 0; i < this.f2818a.f2817d.size(); i++) {
                    ((MainLooperLogMessageListener) this.f2818a.f2817d.get(i)).mo676a(str);
                }
            }
        }
    }

    /* compiled from: time_since_startup */
    class C01782 implements Runnable {
        final /* synthetic */ MainLooperLogMessagesDispatcher f2819a;

        C01782(MainLooperLogMessagesDispatcher mainLooperLogMessagesDispatcher) {
            this.f2819a = mainLooperLogMessagesDispatcher;
        }

        public void run() {
            synchronized (this.f2819a.f2817d) {
                boolean isEmpty = this.f2819a.f2817d.isEmpty();
            }
            if (isEmpty) {
                this.f2819a.f2816c.getLooper().setMessageLogging(null);
            } else {
                this.f2819a.f2816c.getLooper().setMessageLogging(this.f2819a.f2814a);
            }
        }
    }

    public static com.facebook.debug.mainlooper.MainLooperLogMessagesDispatcher m4820a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2813e;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.debug.mainlooper.MainLooperLogMessagesDispatcher.class;
        monitor-enter(r1);
        r0 = f2813e;	 Catch:{ all -> 0x0039 }
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
        r0 = m4819a();	 Catch:{ all -> 0x0034 }
        f2813e = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f2813e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.debug.mainlooper.MainLooperLogMessagesDispatcher.a(com.facebook.inject.InjectorLike):com.facebook.debug.mainlooper.MainLooperLogMessagesDispatcher");
    }

    private static MainLooperLogMessagesDispatcher m4819a() {
        return new MainLooperLogMessagesDispatcher();
    }

    private MainLooperLogMessagesDispatcher(Handler handler) {
        this.f2814a = new C01771(this);
        this.f2815b = new C01782(this);
        this.f2817d = Lists.m1296a();
        this.f2816c = handler;
    }

    @Inject
    public MainLooperLogMessagesDispatcher() {
        this(new Handler(Looper.getMainLooper()));
    }

    public final void m4821a(MainLooperLogMessageListener mainLooperLogMessageListener) {
        if (mainLooperLogMessageListener != null) {
            boolean isEmpty;
            synchronized (this.f2817d) {
                isEmpty = this.f2817d.isEmpty();
                this.f2817d.add(mainLooperLogMessageListener);
            }
            if (isEmpty) {
                HandlerDetour.a(this.f2816c, this.f2815b, -462348745);
            }
        }
    }

    public final void m4822b(MainLooperLogMessageListener mainLooperLogMessageListener) {
        if (mainLooperLogMessageListener != null) {
            boolean isEmpty;
            synchronized (this.f2817d) {
                this.f2817d.remove(mainLooperLogMessageListener);
                isEmpty = this.f2817d.isEmpty();
            }
            if (isEmpty) {
                HandlerDetour.a(this.f2816c, this.f2815b, -1001908608);
            }
        }
    }
}
