package com.facebook.orca.threadlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: native_click_report_url */
public class ThreadListFragmentWarmUpHelper {
    private static volatile ThreadListFragmentWarmUpHelper f6674c;
    private final MessagingPerformanceLogger f6675a;
    @Nullable
    public View f6676b;

    public static com.facebook.orca.threadlist.ThreadListFragmentWarmUpHelper m6379a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6674c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.threadlist.ThreadListFragmentWarmUpHelper.class;
        monitor-enter(r1);
        r0 = f6674c;	 Catch:{ all -> 0x003a }
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
        r0 = m6380b(r0);	 Catch:{ all -> 0x0035 }
        f6674c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6674c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadlist.ThreadListFragmentWarmUpHelper.a(com.facebook.inject.InjectorLike):com.facebook.orca.threadlist.ThreadListFragmentWarmUpHelper");
    }

    private static ThreadListFragmentWarmUpHelper m6380b(InjectorLike injectorLike) {
        return new ThreadListFragmentWarmUpHelper(MessagingPerformanceLogger.a(injectorLike));
    }

    @Inject
    public ThreadListFragmentWarmUpHelper(MessagingPerformanceLogger messagingPerformanceLogger) {
        this.f6675a = messagingPerformanceLogger;
    }

    final View m6381a(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, boolean z) {
        if (this.f6676b == null || !z) {
            LayoutInflater from;
            this.f6675a.a(5505045, i, "onCreateView");
            if (layoutInflater == null) {
                from = LayoutInflater.from(context);
            } else {
                from = layoutInflater.cloneInContext(context);
            }
            View inflate = from.inflate(2130905877, viewGroup, false);
            if (viewGroup == null) {
                inflate.setLayoutParams(new LayoutParams(-1, -1));
            }
            View view = inflate;
            this.f6675a.a(5505045, i, (short) 45);
            return view;
        }
        view = this.f6676b;
        this.f6676b = null;
        return view;
    }
}
