package com.facebook.ssl.openssl;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.ssl.openssl.reflect.SSLParametersGetter;
import com.facebook.ssl.openssl.reflect.SSLSessionTimeoutSetter;
import com.facebook.ssl.openssl.reflect.SocketImplSetter;
import com.facebook.ssl.socket.SSLVerifier;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.harmony.xnet.provider.jsse.SSLParametersImpl;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.params.HttpParams;

@SuppressLint({"DeprecatedInterface"})
@TargetApi(9)
/* compiled from: confirmation */
public class TicketEnabledOpenSSLSocketFactory implements LayeredSocketFactory {
    private final SSLParametersImpl f5303a;
    private final SSLVerifier f5304b;
    private final SocketImplSetter f5305c;
    private final TicketEnabledOpenSSLSocketFactoryHelper f5306d;
    private final AbstractFbErrorReporter f5307e;

    public TicketEnabledOpenSSLSocketFactory(SSLSocketFactory sSLSocketFactory, SSLVerifier sSLVerifier, SSLParametersGetter sSLParametersGetter, SSLSessionTimeoutSetter sSLSessionTimeoutSetter, SocketImplSetter socketImplSetter, TicketEnabledOpenSSLSocketFactoryHelper ticketEnabledOpenSSLSocketFactoryHelper, int i, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f5304b = sSLVerifier;
        this.f5303a = SSLParametersGetter.m10234a(sSLSocketFactory);
        SSLSessionTimeoutSetter.m10237a(this.f5303a, i);
        this.f5305c = socketImplSetter;
        this.f5306d = ticketEnabledOpenSSLSocketFactoryHelper;
        this.f5307e = abstractFbErrorReporter;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        TicketEnabledOpenSSLSocketImplWrapper a = TicketEnabledOpenSSLSocketFactoryHelper.m10209a(socket, str, i, z, this.f5303a, this.f5307e);
        try {
            a.setHostname(str);
            a.setUseSessionTickets(true);
            a.setHandshakeTimeout(socket.getSoTimeout());
            SocketImplSetter.m10240a(a, socket.getInetAddress().getAddress(), str, i);
            this.f5304b.m10248a(a, str);
            return a;
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }

    public boolean isSecure(Socket socket) {
        Preconditions.checkNotNull(socket, "The socket may not be null");
        Preconditions.checkArgument(socket instanceof TicketEnabledOpenSSLSocketImplWrapper, "Socket not created by this factory.");
        return true;
    }

    public Socket createSocket() {
        throw new UnsupportedOperationException("createSocket() is not supported by the socket factory");
    }

    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) {
        throw new UnsupportedOperationException("connectSocket() is not supported by the socket factory");
    }
}
