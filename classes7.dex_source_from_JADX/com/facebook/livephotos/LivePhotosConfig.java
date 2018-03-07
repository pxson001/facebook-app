package com.facebook.livephotos;

import com.facebook.debug.log.BLog;
import com.facebook.livephotos.egl.GLContext;
import javax.inject.Singleton;

@Singleton
/* compiled from: phasedRegistrationNames */
public class LivePhotosConfig {
    private static final String f6628b = LivePhotosConfig.class.getSimpleName();
    private static volatile LivePhotosConfig f6629c;
    public final boolean f6630a = m8543a();

    public static com.facebook.livephotos.LivePhotosConfig m8542a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6629c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.livephotos.LivePhotosConfig.class;
        monitor-enter(r1);
        r0 = f6629c;	 Catch:{ all -> 0x0039 }
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
        r0 = m8544b();	 Catch:{ all -> 0x0034 }
        f6629c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f6629c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.livephotos.LivePhotosConfig.a(com.facebook.inject.InjectorLike):com.facebook.livephotos.LivePhotosConfig");
    }

    private static LivePhotosConfig m8544b() {
        return new LivePhotosConfig();
    }

    private static boolean m8543a() {
        GLContext gLContext;
        Throwable e;
        Throwable th;
        try {
            gLContext = new GLContext();
            try {
                if (gLContext.m8564a()) {
                    gLContext.m8565d();
                    return true;
                }
                BLog.b(f6628b, "Could not create GLContext");
                gLContext.m8565d();
                return false;
            } catch (Exception e2) {
                e = e2;
                try {
                    BLog.b(f6628b, "LivePhotosConfig.isSupported", e);
                    if (gLContext != null) {
                        return false;
                    }
                    gLContext.m8565d();
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (gLContext != null) {
                        gLContext.m8565d();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            gLContext = null;
            BLog.b(f6628b, "LivePhotosConfig.isSupported", e);
            if (gLContext != null) {
                return false;
            }
            gLContext.m8565d();
            return false;
        } catch (Throwable th3) {
            th = th3;
            gLContext = null;
            if (gLContext != null) {
                gLContext.m8565d();
            }
            throw th;
        }
    }
}
