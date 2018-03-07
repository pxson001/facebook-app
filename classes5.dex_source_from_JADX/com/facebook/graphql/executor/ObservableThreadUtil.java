package com.facebook.graphql.executor;

import android.os.Handler;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: libcore.io.ErrnoException */
public class ObservableThreadUtil {
    private static volatile ObservableThreadUtil f3227b;
    @ForUiThread
    public final Handler f3228a;

    public static com.facebook.graphql.executor.ObservableThreadUtil m6282a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3227b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.executor.ObservableThreadUtil.class;
        monitor-enter(r1);
        r0 = f3227b;	 Catch:{ all -> 0x003a }
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
        r0 = m6283b(r0);	 Catch:{ all -> 0x0035 }
        f3227b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3227b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.ObservableThreadUtil.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.ObservableThreadUtil");
    }

    private static ObservableThreadUtil m6283b(InjectorLike injectorLike) {
        return new ObservableThreadUtil(Handler_ForUiThreadMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ObservableThreadUtil(Handler handler) {
        this.f3228a = handler;
    }

    public final <T> RequestSubscription m6284a(RequestObservable<T> requestObservable, final RequestObserver<T> requestObserver) {
        return requestObservable.a(new RequestObserver<T>(this) {
            final /* synthetic */ ObservableThreadUtil f3226b;

            /* compiled from: libcore.io.ErrnoException */
            class C02491 implements Runnable {
                final /* synthetic */ C02521 f3220a;

                C02491(C02521 c02521) {
                    this.f3220a = c02521;
                }

                public void run() {
                    requestObserver.a();
                }
            }

            public final void m6279a() {
                HandlerDetour.a(this.f3226b.f3228a, new C02491(this), 1130950009);
            }

            public final void m6281a(final Throwable th) {
                HandlerDetour.a(this.f3226b.f3228a, new Runnable(this) {
                    final /* synthetic */ C02521 f3222b;

                    public void run() {
                        requestObserver.a(th);
                    }
                }, 1784979215);
            }

            public final void m6280a(final T t) {
                HandlerDetour.a(this.f3226b.f3228a, new Runnable(this) {
                    final /* synthetic */ C02521 f3224b;

                    public void run() {
                        requestObserver.a(t);
                    }
                }, -1095424518);
            }
        });
    }
}
