package com.facebook.http.common.executorimpl.apache;

import com.facebook.http.enginehooks.DefaultOpenConnectionEventListenerProvider;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;

/* compiled from: display_total */
public class FbHttpClientConnectionOperator extends DefaultClientConnectionOperator {
    private static final PlainSocketFactory f4981a = new PlainSocketFactory();
    public DefaultOpenConnectionEventListenerProvider f4982b = new DefaultOpenConnectionEventListenerProvider();

    public FbHttpClientConnectionOperator(SchemeRegistry schemeRegistry) {
        super(schemeRegistry);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openConnection(org.apache.http.conn.OperatedClientConnection r15, org.apache.http.HttpHost r16, @javax.annotation.Nullable java.net.InetAddress r17, org.apache.http.protocol.HttpContext r18, org.apache.http.params.HttpParams r19) {
        /*
        r14 = this;
        if (r15 != 0) goto L_0x000a;
    L_0x0002:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Connection must not be null.";
        r2.<init>(r3);
        throw r2;
    L_0x000a:
        if (r16 != 0) goto L_0x0014;
    L_0x000c:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Target host must not be null.";
        r2.<init>(r3);
        throw r2;
    L_0x0014:
        if (r19 != 0) goto L_0x001e;
    L_0x0016:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Parameters must not be null.";
        r2.<init>(r3);
        throw r2;
    L_0x001e:
        r2 = r15.isOpen();
        if (r2 == 0) goto L_0x002c;
    L_0x0024:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Connection must not be open.";
        r2.<init>(r3);
        throw r2;
    L_0x002c:
        r2 = r14.schemeRegistry;
        r3 = r16.getSchemeName();
        r12 = r2.getScheme(r3);
        r9 = r12.getSocketFactory();
        r2 = r9 instanceof org.apache.http.conn.scheme.LayeredSocketFactory;
        if (r2 == 0) goto L_0x00b5;
    L_0x003e:
        r3 = f4981a;
        r2 = r9;
        r2 = (org.apache.http.conn.scheme.LayeredSocketFactory) r2;
        r10 = r2;
        r2 = r3;
    L_0x0045:
        r3 = com.facebook.http.common.executorimpl.apache.FbHttpClientRequestExecutor.m9919a(r18);
        r4 = 1;
        r3.b(r4);
        r3 = r14.f4982b;
        r16.getHostName();
        r3.m9938a();
        r3 = r16.getHostName();	 Catch:{ UnknownHostException -> 0x00b9 }
        r13 = java.net.InetAddress.getAllByName(r3);	 Catch:{ UnknownHostException -> 0x00b9 }
        r3 = 0;
        r11 = r3;
    L_0x005f:
        r3 = r13.length;
        if (r11 >= r3) goto L_0x00b4;
    L_0x0062:
        r3 = r2.createSocket();
        r0 = r16;
        r15.opening(r3, r0);
        r4 = r13[r11];	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
        r4 = r4.getHostAddress();	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
        r5 = r16.getPort();	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
        r5 = r12.resolvePort(r5);	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
        r7 = 0;
        r6 = r17;
        r8 = r19;
        r4 = r2.connectSocket(r3, r4, r5, r6, r7, r8);	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
        if (r3 == r4) goto L_0x008a;
    L_0x0084:
        r0 = r16;
        r15.opening(r4, r0);	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
        r3 = r4;
    L_0x008a:
        r0 = r18;
        r1 = r19;
        r14.prepareSocket(r3, r0, r1);	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
        if (r10 == 0) goto L_0x00bb;
    L_0x0093:
        r4 = r16.getHostName();	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
        r5 = r16.getPort();	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
        r5 = r12.resolvePort(r5);	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
        r6 = 1;
        r4 = r10.createSocket(r3, r4, r5, r6);	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
        if (r4 == r3) goto L_0x00ab;
    L_0x00a6:
        r0 = r16;
        r15.opening(r4, r0);	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
    L_0x00ab:
        r3 = r9.isSecure(r4);	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
        r0 = r19;
        r15.openCompleted(r3, r0);	 Catch:{ SocketException -> 0x00c5, ConnectTimeoutException -> 0x00e4 }
    L_0x00b4:
        return;
    L_0x00b5:
        r2 = 0;
        r10 = r2;
        r2 = r9;
        goto L_0x0045;
    L_0x00b9:
        r2 = move-exception;
        throw r2;
    L_0x00bb:
        r3 = r9.isSecure(r3);	 Catch:{  }
        r0 = r19;
        r15.openCompleted(r3, r0);	 Catch:{  }
        goto L_0x00b4;
    L_0x00c5:
        r3 = move-exception;
        r4 = r13.length;
        r4 = r4 + -1;
        if (r11 != r4) goto L_0x00eb;
    L_0x00cb:
        r2 = r3 instanceof java.net.ConnectException;
        if (r2 == 0) goto L_0x00da;
    L_0x00cf:
        r2 = r3;
        r2 = (java.net.ConnectException) r2;
    L_0x00d2:
        r3 = new org.apache.http.conn.HttpHostConnectException;
        r0 = r16;
        r3.<init>(r0, r2);
        throw r3;
    L_0x00da:
        r2 = new java.net.ConnectException;
        r3 = r3.getMessage();
        r2.<init>(r3);
        goto L_0x00d2;
    L_0x00e4:
        r3 = move-exception;
        r4 = r13.length;
        r4 = r4 + -1;
        if (r11 != r4) goto L_0x00eb;
    L_0x00ea:
        throw r3;
    L_0x00eb:
        r3 = r11 + 1;
        r11 = r3;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.executorimpl.apache.FbHttpClientConnectionOperator.openConnection(org.apache.http.conn.OperatedClientConnection, org.apache.http.HttpHost, java.net.InetAddress, org.apache.http.protocol.HttpContext, org.apache.http.params.HttpParams):void");
    }
}
