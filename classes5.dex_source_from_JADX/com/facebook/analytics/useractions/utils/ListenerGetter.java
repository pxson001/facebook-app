package com.facebook.analytics.useractions.utils;

import com.facebook.analytics.useractions.UserActionsRecorder;
import com.facebook.debug.log.BLog;
import java.lang.reflect.Field;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ticker */
public class ListenerGetter {
    private static Field f1928a;
    private static volatile ListenerGetter f1929b;

    public static com.facebook.analytics.useractions.utils.ListenerGetter m2607a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1929b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.analytics.useractions.utils.ListenerGetter.class;
        monitor-enter(r1);
        r0 = f1929b;	 Catch:{ all -> 0x0039 }
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
        r0 = m2606a();	 Catch:{ all -> 0x0034 }
        f1929b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1929b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.useractions.utils.ListenerGetter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.useractions.utils.ListenerGetter");
    }

    private static ListenerGetter m2606a() {
        return new ListenerGetter();
    }

    @Inject
    public ListenerGetter() {
        try {
            f1928a = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
        } catch (Exception e) {
            m2608a(e);
        } catch (Exception e2) {
            m2608a(e2);
        }
        if (f1928a != null) {
            f1928a.setAccessible(true);
        }
    }

    private static void m2608a(Exception exception) {
        UserActionsRecorder.f1915f = false;
        BLog.b("ListenerGetter", exception.getMessage());
    }
}
