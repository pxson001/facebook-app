package com.facebook.ssl.openssl.reflect;

import com.facebook.ssl.openssl.UnsupportedOpenSSLVersionException;
import java.lang.reflect.Field;
import javax.inject.Singleton;
import org.apache.harmony.xnet.provider.jsse.ClientSessionContext;
import org.apache.harmony.xnet.provider.jsse.SSLParametersImpl;

@Singleton
/* compiled from: computeFitSystemWindows */
public class SSLSessionTimeoutSetter {
    private static Field f5341a;
    public static boolean f5342b;
    private static volatile SSLSessionTimeoutSetter f5343c;

    public static com.facebook.ssl.openssl.reflect.SSLSessionTimeoutSetter m10236a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5343c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.ssl.openssl.reflect.SSLSessionTimeoutSetter.class;
        monitor-enter(r1);
        r0 = f5343c;	 Catch:{ all -> 0x0039 }
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
        r0 = m10238b();	 Catch:{ all -> 0x0034 }
        f5343c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f5343c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ssl.openssl.reflect.SSLSessionTimeoutSetter.a(com.facebook.inject.InjectorLike):com.facebook.ssl.openssl.reflect.SSLSessionTimeoutSetter");
    }

    private static SSLSessionTimeoutSetter m10238b() {
        return new SSLSessionTimeoutSetter();
    }

    static {
        f5342b = false;
        try {
            Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            Class.forName("org.apache.harmony.xnet.provider.jsse.ClientSessionContext");
            Field declaredField = SSLParametersImpl.class.getDeclaredField("clientSessionContext");
            f5341a = declaredField;
            declaredField.setAccessible(true);
            f5342b = true;
        } catch (Throwable th) {
        }
    }

    public static void m10237a(SSLParametersImpl sSLParametersImpl, int i) {
        try {
            ((ClientSessionContext) f5341a.get(sSLParametersImpl)).setSessionTimeout(i);
        } catch (Exception e) {
            throw new UnsupportedOpenSSLVersionException(e);
        }
    }
}
