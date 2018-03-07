package com.facebook.http.tigon;

import com.facebook.debug.log.BLog;
import com.facebook.http.common.HttpFutureWrapper;
import com.facebook.http.common.NetworkException;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.proxygen.HTTPRequestError;
import com.facebook.proxygen.HTTPRequestError.ProxygenError;
import com.facebook.proxygen.HttpNetworkException;
import com.facebook.soloader.SoLoader;
import com.facebook.tigon.javaservice.AbstractRequestToken;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;

/* compiled from: last_wifi_connection */
public class Tigon4aRequestToken extends AbstractRequestToken {
    private static final String f9514a = Tigon4aRequestToken.class.getSimpleName();
    private HttpFutureWrapper<TigonResult> f9515b;

    private native void onError(int i, String str, int i2, String str2);

    private native void onWillRetry(int i, String str, int i2, String str2);

    public native void onBody(byte[] bArr, int i);

    public native void onEOM();

    public native void onResponse(int i, String[] strArr);

    static {
        SoLoader.a("tigon4a");
    }

    public final void m9885a(Throwable th) {
        BLog.a(f9514a, th, "Tigon4aRequestToken.onError", new Object[0]);
        if (th instanceof HttpNetworkException) {
            HTTPRequestError hTTPRequestError = ((HttpNetworkException) th).mError;
            onError(m9882a(hTTPRequestError.mErrCode), "LigerErrorDomain", hTTPRequestError.mErrCode.ordinal(), hTTPRequestError.mErrMsg);
            return;
        }
        onError(m9883c(th), "Tigon4aErrorDomain", 0, th.toString());
    }

    public final void m9886b(Throwable th) {
        BLog.a(f9514a, th, "Tigon4aRequestToken.onWillRetry", new Object[0]);
        if (th instanceof HttpNetworkException) {
            HTTPRequestError hTTPRequestError = ((HttpNetworkException) th).mError;
            onWillRetry(m9882a(hTTPRequestError.mErrCode), "LigerErrorDomain", hTTPRequestError.mErrCode.ordinal(), hTTPRequestError.mErrMsg);
            return;
        }
        onWillRetry(m9883c(th), "Tigon4aErrorDomain", 0, th.toString());
    }

    private static int m9883c(Throwable th) {
        if ((th instanceof SocketTimeoutException) || (th instanceof ConnectTimeoutException) || (th instanceof UnknownHostException) || (th instanceof HttpHostConnectException) || (th instanceof ConnectException) || (th instanceof NoHttpResponseException) || (th instanceof NetworkException) || th.getClass() == SSLException.class || (th instanceof NetworkException)) {
            return 2;
        }
        return 3;
    }

    private static int m9882a(ProxygenError proxygenError) {
        switch (1.a[proxygenError.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                return 2;
            case 40:
                return 1;
            default:
                return 3;
        }
    }

    private Tigon4aRequestToken(HybridData hybridData) {
        super(hybridData);
    }

    public final void m9884a(HttpFutureWrapper<TigonResult> httpFutureWrapper) {
        this.f9515b = httpFutureWrapper;
    }

    @DoNotStrip
    public void cancel() {
        this.f9515b.b();
    }

    @DoNotStrip
    public void changePriority(int i) {
        this.f9515b.a(RequestPriority.fromNumericValue(i, RequestPriority.DEFAULT_PRIORITY));
    }
}
