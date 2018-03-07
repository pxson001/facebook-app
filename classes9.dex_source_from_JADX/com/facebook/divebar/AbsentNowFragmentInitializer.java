package com.facebook.divebar;

import com.facebook.common.activitylistener.ListenableActivity;
import com.facebook.ui.drawers.DrawerContentFragment;
import javax.inject.Singleton;

@Singleton
/* compiled from: permalink.php */
public class AbsentNowFragmentInitializer implements DivebarFragmentInitializer {
    private static volatile AbsentNowFragmentInitializer f6710a;

    public static com.facebook.divebar.AbsentNowFragmentInitializer m6994a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6710a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.divebar.AbsentNowFragmentInitializer.class;
        monitor-enter(r1);
        r0 = f6710a;	 Catch:{ all -> 0x0039 }
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
        r0 = m6995e();	 Catch:{ all -> 0x0034 }
        f6710a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f6710a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.divebar.AbsentNowFragmentInitializer.a(com.facebook.inject.InjectorLike):com.facebook.divebar.AbsentNowFragmentInitializer");
    }

    private static AbsentNowFragmentInitializer m6995e() {
        return new AbsentNowFragmentInitializer();
    }

    public final DrawerContentFragment mo189a() {
        throw new UnsupportedOperationException("Now Fragment is inaccessible");
    }

    public final boolean mo192b() {
        return false;
    }

    public final void mo190a(ListenableActivity listenableActivity, DrawerBasedDivebarControllerImpl drawerBasedDivebarControllerImpl) {
    }

    public final void mo191a(boolean z) {
    }

    public final boolean mo193c() {
        return true;
    }

    public final boolean mo194d() {
        return false;
    }
}
