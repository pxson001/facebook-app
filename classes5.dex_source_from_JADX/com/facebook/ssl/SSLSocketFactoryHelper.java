package com.facebook.ssl;

import com.facebook.common.android.AndroidModule;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.ssl.openssl.TicketEnabledOpenSSLSocketFactory;
import com.facebook.ssl.openssl.TicketEnabledOpenSSLSocketFactoryHelper;
import com.facebook.ssl.openssl.UnsupportedOpenSSLVersionException;
import com.facebook.ssl.openssl.check.OpenSSLEnvironmentCheck;
import com.facebook.ssl.openssl.check.STATICDI_MULTIBIND_PROVIDER$OpenSSLEnvironmentCheck;
import com.facebook.ssl.openssl.heartbleed.HeartbleedMitigation;
import com.facebook.ssl.openssl.reflect.SSLParametersGetter;
import com.facebook.ssl.openssl.reflect.SSLSessionTimeoutSetter;
import com.facebook.ssl.openssl.reflect.SocketImplSetter;
import com.facebook.ssl.socket.SSLVerifier;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Singleton
/* compiled from: confirmation_message */
public class SSLSocketFactoryHelper {
    private static final Class<?> f5289a = SSLSocketFactoryHelper.class;
    private static volatile SSLSocketFactoryHelper f5290m;
    private final int f5291b;
    private final int f5292c;
    private final Set<OpenSSLEnvironmentCheck> f5293d;
    private final SSLParametersGetter f5294e;
    private final SSLSessionTimeoutSetter f5295f;
    private final SocketImplSetter f5296g;
    private final TicketEnabledOpenSSLSocketFactoryHelper f5297h;
    private final SSLVerifier f5298i;
    private final AbstractFbErrorReporter f5299j;
    private final HeartbleedMitigation f5300k;
    private final X509HostnameVerifier f5301l;

    public static com.facebook.ssl.SSLSocketFactoryHelper m10199a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5290m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ssl.SSLSocketFactoryHelper.class;
        monitor-enter(r1);
        r0 = f5290m;	 Catch:{ all -> 0x003a }
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
        r0 = m10202b(r0);	 Catch:{ all -> 0x0035 }
        f5290m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5290m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ssl.SSLSocketFactoryHelper.a(com.facebook.inject.InjectorLike):com.facebook.ssl.SSLSocketFactoryHelper");
    }

    private static SSLSocketFactoryHelper m10202b(InjectorLike injectorLike) {
        return new SSLSocketFactoryHelper(AndroidModule.e(), SSLModule.m10196a(), STATICDI_MULTIBIND_PROVIDER$OpenSSLEnvironmentCheck.m10226a(injectorLike), SSLParametersGetter.m10233a(injectorLike), SSLSessionTimeoutSetter.m10236a(injectorLike), SocketImplSetter.m10239a(injectorLike), TicketEnabledOpenSSLSocketFactoryHelper.m10208a(injectorLike), SSLVerifier.m10243a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), HeartbleedMitigation.m10228b(injectorLike), X509HostnameVerifierMethodAutoProvider.m10205a(injectorLike));
    }

    @Inject
    public SSLSocketFactoryHelper(Integer num, Integer num2, Set<OpenSSLEnvironmentCheck> set, SSLParametersGetter sSLParametersGetter, SSLSessionTimeoutSetter sSLSessionTimeoutSetter, SocketImplSetter socketImplSetter, TicketEnabledOpenSSLSocketFactoryHelper ticketEnabledOpenSSLSocketFactoryHelper, SSLVerifier sSLVerifier, FbErrorReporter fbErrorReporter, HeartbleedMitigation heartbleedMitigation, X509HostnameVerifier x509HostnameVerifier) {
        this.f5292c = num.intValue();
        this.f5291b = num2.intValue();
        this.f5293d = set;
        this.f5294e = sSLParametersGetter;
        this.f5295f = sSLSessionTimeoutSetter;
        this.f5296g = socketImplSetter;
        this.f5297h = ticketEnabledOpenSSLSocketFactoryHelper;
        this.f5298i = sSLVerifier;
        this.f5299j = fbErrorReporter;
        this.f5300k = heartbleedMitigation;
        this.f5301l = x509HostnameVerifier;
    }

    public final SocketFactory m10204a(@Nullable SocketFactory socketFactory) {
        if (this.f5292c <= 8) {
            return m10203b(socketFactory);
        }
        try {
            if (this.f5292c <= 16 && m10201a(this.f5293d)) {
                return new TicketEnabledOpenSSLSocketFactory(m10200a(), this.f5298i, this.f5294e, this.f5295f, this.f5296g, this.f5297h, this.f5291b, this.f5299j);
            }
        } catch (UnsupportedOpenSSLVersionException e) {
            BLog.a(f5289a, "exception occured while trying to create the socket factory");
        }
        if (this.f5300k.m10232a()) {
            this.f5299j.a("heartbeat_not_applied", "Did not apply heartbleed fix");
        }
        return m10203b(socketFactory);
    }

    private SSLSocketFactory m10200a() {
        if (this.f5300k.m10232a()) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.f5300k.m10231a(instance);
                return instance.getSocketFactory();
            } catch (Throwable th) {
            }
        }
        return HttpsURLConnection.getDefaultSSLSocketFactory();
    }

    private SocketFactory m10203b(@Nullable SocketFactory socketFactory) {
        if (socketFactory instanceof org.apache.http.conn.ssl.SSLSocketFactory) {
            ((org.apache.http.conn.ssl.SSLSocketFactory) socketFactory).setHostnameVerifier(this.f5301l);
        }
        return socketFactory;
    }

    private static boolean m10201a(Set<OpenSSLEnvironmentCheck> set) {
        for (OpenSSLEnvironmentCheck openSSLEnvironmentCheck : set) {
            new StringBuilder("trying check ").append(openSSLEnvironmentCheck.getClass().getName());
            if (!openSSLEnvironmentCheck.mo624a()) {
                BLog.a(f5289a, "check fail " + openSSLEnvironmentCheck.getClass().getName());
                return false;
            }
        }
        return true;
    }
}
