package com.facebook.ui.toaster;

import android.os.Handler;
import android.os.Looper;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.Lists;
import java.util.Queue;
import javax.inject.Singleton;

@Singleton
/* compiled from: experiments */
public class ClickableToastCoordinator {
    private static volatile ClickableToastCoordinator f12589d;
    private Queue<ClickableToast> f12590a = Lists.b();
    public boolean f12591b;
    private final Handler f12592c = new Handler(Looper.getMainLooper());

    public static com.facebook.ui.toaster.ClickableToastCoordinator m13375a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12589d;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.ui.toaster.ClickableToastCoordinator.class;
        monitor-enter(r1);
        r0 = f12589d;	 Catch:{ all -> 0x0039 }
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
        r0 = m13377b();	 Catch:{ all -> 0x0034 }
        f12589d = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12589d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.toaster.ClickableToastCoordinator.a(com.facebook.inject.InjectorLike):com.facebook.ui.toaster.ClickableToastCoordinator");
    }

    private static ClickableToastCoordinator m13377b() {
        return new ClickableToastCoordinator();
    }

    public final void m13378a(ClickableToast clickableToast) {
        this.f12590a.offer(clickableToast);
        if (!this.f12591b) {
            m13376a();
        }
    }

    public final void m13379b(ClickableToast clickableToast) {
        HandlerDetour.a(this.f12592c, new 1(this, clickableToast), 1312639648);
        this.f12590a.remove(clickableToast);
        this.f12591b = false;
        m13376a();
    }

    private void m13376a() {
        ClickableToast clickableToast = (ClickableToast) this.f12590a.poll();
        if (clickableToast != null) {
            HandlerDetour.a(this.f12592c, new 2(this, clickableToast), -2009735285);
        }
    }
}
