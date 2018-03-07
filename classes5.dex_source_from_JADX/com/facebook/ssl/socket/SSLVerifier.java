package com.facebook.ssl.socket;

import android.util.Log;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ssl.HostnameVerifierMethodAutoProvider;
import java.security.cert.Certificate;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Singleton
/* compiled from: computeBatteryRealtime */
public class SSLVerifier {
    private static volatile SSLVerifier f5349b;
    private final HostnameVerifier f5350a;

    public static com.facebook.ssl.socket.SSLVerifier m10243a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5349b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ssl.socket.SSLVerifier.class;
        monitor-enter(r1);
        r0 = f5349b;	 Catch:{ all -> 0x003a }
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
        r0 = m10247b(r0);	 Catch:{ all -> 0x0035 }
        f5349b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5349b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ssl.socket.SSLVerifier.a(com.facebook.inject.InjectorLike):com.facebook.ssl.socket.SSLVerifier");
    }

    private static SSLVerifier m10247b(InjectorLike injectorLike) {
        return new SSLVerifier(HostnameVerifierMethodAutoProvider.m10195a(injectorLike));
    }

    @Inject
    public SSLVerifier(HostnameVerifier hostnameVerifier) {
        this.f5350a = hostnameVerifier;
    }

    private void m10246a(SSLSession sSLSession, SSLSocket sSLSocket, String str, SSLParameters sSLParameters, boolean z) {
        if (sSLSession == null) {
            throw new SSLException("SSL Session is null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(sSLSession.getCipherSuite())) {
            String str2;
            String str3 = "SSL handshake returned an invalid session. Socket state (%s, %s, %s, %s, %s, %s, %s) Session state (%s, %s) SSL parameters (%s, %s) Stack Trace (%s)";
            Object[] objArr = new Object[12];
            if (sSLSocket.isClosed()) {
                str2 = "closed";
            } else {
                str2 = "open";
            }
            objArr[0] = str2;
            if (sSLSocket.isConnected()) {
                str2 = "connected";
            } else {
                str2 = "disconnected";
            }
            objArr[1] = str2;
            if (sSLSocket.isBound()) {
                str2 = "bound";
            } else {
                str2 = "unbound";
            }
            objArr[2] = str2;
            if (sSLSocket.isInputShutdown()) {
                str2 = "input_shutdown";
            } else {
                str2 = "input_open";
            }
            objArr[3] = str2;
            if (sSLSocket.isOutputShutdown()) {
                str2 = "output_shutdown";
            } else {
                str2 = "output_open";
            }
            objArr[4] = str2;
            objArr[5] = str;
            objArr[6] = String.valueOf(sSLSocket.getInetAddress());
            if (z) {
                str2 = "completed";
            } else {
                str2 = "incompleted";
            }
            objArr[7] = str2;
            if (sSLSession.isValid()) {
                str2 = "valid";
            } else {
                str2 = "invalid";
            }
            objArr[8] = str2;
            objArr[9] = m10244a(sSLParameters);
            objArr[10] = m10244a(sSLSocket.getSSLParameters());
            if (sSLSocket.getInetAddress() == null) {
                str2 = Log.getStackTraceString(new Throwable());
            } else {
                str2 = "";
            }
            objArr[11] = str2;
            throw new SSLException(StringFormatUtil.a(str3, objArr));
        }
    }

    private static String m10244a(SSLParameters sSLParameters) {
        if (sSLParameters == null) {
            return "null";
        }
        return StringFormatUtil.formatStrLocaleSafe("# cipher suites: %d, # protocols: %d, %b, %b", Integer.valueOf(sSLParameters.getCipherSuites().length), Integer.valueOf(sSLParameters.getProtocols().length), Boolean.valueOf(sSLParameters.getNeedClientAuth()), Boolean.valueOf(sSLParameters.getWantClientAuth()));
    }

    public final void m10248a(SSLSocket sSLSocket, String str) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        sSLSocket.addHandshakeCompletedListener(new HandshakeCompletedListener(this) {
            final /* synthetic */ SSLVerifier f5348b;

            public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                atomicBoolean.set(true);
            }
        });
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        SSLSession session = sSLSocket.getSession();
        m10246a(session, sSLSocket, str, sSLParameters, atomicBoolean.get());
        if (!this.f5350a.verify(str, session)) {
            throw new SSLException(StringFormatUtil.formatStrLocaleSafe("could not verify hostname for (%s, %s). (%s)", str, String.valueOf(sSLSocket.getInetAddress()), m10245a(session)));
        }
    }

    private static String m10245a(SSLSession sSLSession) {
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            if (peerCertificates == null || peerCertificates.length <= 0) {
                return "No certificates";
            }
            return StringFormatUtil.formatStrLocaleSafe("num: %d, %s", Integer.valueOf(peerCertificates.length), peerCertificates[0].toString());
        } catch (SSLException e) {
            return "Exception getting certificates " + e.toString();
        }
    }
}
