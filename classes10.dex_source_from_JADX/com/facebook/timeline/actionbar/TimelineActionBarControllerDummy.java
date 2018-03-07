package com.facebook.timeline.actionbar;

import android.view.View;
import javax.inject.Singleton;

@Singleton
/* compiled from: groups_launch_file_selector */
public class TimelineActionBarControllerDummy implements TimelineActionBarController {
    private static volatile TimelineActionBarControllerDummy f10255a;

    public static com.facebook.timeline.actionbar.TimelineActionBarControllerDummy m10367a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10255a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.timeline.actionbar.TimelineActionBarControllerDummy.class;
        monitor-enter(r1);
        r0 = f10255a;	 Catch:{ all -> 0x0039 }
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
        r0 = m10368b();	 Catch:{ all -> 0x0034 }
        f10255a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10255a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.actionbar.TimelineActionBarControllerDummy.a(com.facebook.inject.InjectorLike):com.facebook.timeline.actionbar.TimelineActionBarControllerDummy");
    }

    private static TimelineActionBarControllerDummy m10368b() {
        return new TimelineActionBarControllerDummy();
    }

    public final void mo487a(String str) {
    }

    public final void mo488a(String str, View view) {
    }

    public final void mo489a(String str, String str2) {
    }

    public final void mo491b(String str, String str2) {
    }

    public final void mo493c(String str, String str2) {
    }

    public final void mo486a() {
    }

    public final void mo490b(String str) {
    }

    public final void mo492c(String str) {
    }

    public final void mo494d(String str) {
    }

    public final void mo495e(String str) {
    }

    public final void mo496f(String str) {
    }

    public final void mo497g(String str) {
    }

    public final void mo498h(String str) {
    }

    public final void mo499i(String str) {
    }

    public final void mo500j(String str) {
    }

    public final void mo501k(String str) {
    }
}
