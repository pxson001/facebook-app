package com.facebook.ssl.openssl.check;

import com.facebook.inject.InjectorLike;
import com.facebook.ssl.openssl.UnsupportedOpenSSLVersionException;
import com.facebook.ssl.openssl.reflect.SocketImplSetter;
import java.net.Socket;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: config */
public class CheckSocketImplSetter implements OpenSSLEnvironmentCheck {
    private static volatile CheckSocketImplSetter f5322h;
    private final SocketImplSetter f5323a;
    private final Socket f5324b = new Socket();
    private final byte[] f5325c = new byte[4];
    private final String f5326d = "dummy_host";
    private final int f5327e = 443;
    private boolean f5328f = false;
    private boolean f5329g = false;

    public static com.facebook.ssl.openssl.check.CheckSocketImplSetter m10223a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5322h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ssl.openssl.check.CheckSocketImplSetter.class;
        monitor-enter(r1);
        r0 = f5322h;	 Catch:{ all -> 0x003a }
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
        r0 = m10224b(r0);	 Catch:{ all -> 0x0035 }
        f5322h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5322h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ssl.openssl.check.CheckSocketImplSetter.a(com.facebook.inject.InjectorLike):com.facebook.ssl.openssl.check.CheckSocketImplSetter");
    }

    private static CheckSocketImplSetter m10224b(InjectorLike injectorLike) {
        return new CheckSocketImplSetter(SocketImplSetter.m10239a(injectorLike));
    }

    @Inject
    public CheckSocketImplSetter(SocketImplSetter socketImplSetter) {
        this.f5323a = socketImplSetter;
    }

    public final synchronized boolean mo624a() {
        boolean a;
        a = SocketImplSetter.m10241a();
        if (a && !this.f5328f) {
            try {
                SocketImplSetter.m10240a(this.f5324b, this.f5325c, "dummy_host", 443);
                this.f5329g = true;
                this.f5328f = true;
            } catch (UnsupportedOpenSSLVersionException e) {
                this.f5328f = true;
                a = false;
            } catch (Throwable th) {
                this.f5328f = true;
            }
        } else if (a && this.f5329g) {
            a = true;
        } else {
            a = false;
        }
        return a;
    }
}
