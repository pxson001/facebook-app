package com.facebook.upnp;

import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.charset.Charset;

/* compiled from: navigation_info */
public class UpnpDiscoverySocket {
    private static final Class<?> f5269a = UpnpDiscoverySocket.class;
    private static final ImmutableSet<String> f5270b = ImmutableSet.of("NOTIFY * HTTP/1.1", "M-SEARCH * HTTP/1.1", "HTTP/1.1 200 OK");
    private static final String f5271c = ("M-SEARCH * HTTP/1.1\r\nHOST: 239.255.255.250:" + Integer.toString(1900) + "\r\nMAN: \"ssdp:discover\"\r\n" + "MX: %d \r\nST: upnp:rootdevice\r\n" + "\r\n");
    private final int f5272d;
    private final InetAddress f5273e;
    private MulticastSocket f5274f;
    private DatagramPacket f5275g;

    public UpnpDiscoverySocket(int i, InetAddress inetAddress) {
        this.f5272d = i;
        this.f5273e = inetAddress;
    }

    public final boolean m6523a() {
        try {
            SocketAddress inetSocketAddress = new InetSocketAddress("239.255.255.250", 1900);
            this.f5274f = new MulticastSocket(new InetSocketAddress(this.f5273e, 0));
            this.f5274f.setTimeToLive(2);
            byte[] bytes = StringFormatUtil.formatStrLocaleSafe(f5271c, Integer.valueOf(this.f5272d)).getBytes(Charset.forName("US-ASCII"));
            this.f5275g = new DatagramPacket(bytes, bytes.length, inetSocketAddress);
            this.f5274f.send(this.f5275g);
            this.f5274f.setSoTimeout(this.f5272d * 1000);
            this.f5275g = new DatagramPacket(new byte[2048], 2048);
            return true;
        } catch (SocketException e) {
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    public final java.util.List<java.util.List<java.lang.String>> m6524b() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r1 = 0;
        r4 = new java.util.LinkedList;
        r4.<init>();
        r2 = new java.util.LinkedList;
        r2.<init>();
        r0 = r1;
    L_0x000c:
        r3 = r8.f5274f;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r5 = r8.f5275g;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r3.receive(r5);	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r3 = new java.lang.String;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r5 = r8.f5275g;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r5 = r5.getData();	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r6 = 0;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r7 = r8.f5275g;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r7 = r7.getLength();	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r3.<init>(r5, r6, r7);	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r5 = "\r\n";	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r5 = r3.split(r5);	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r3 = r1;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
    L_0x002c:
        r6 = r5.length;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        if (r3 >= r6) goto L_0x000c;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
    L_0x002f:
        r6 = r5[r3];	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r6 = r6.trim();	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r7 = f5270b;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r7 = r7.contains(r6);	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        if (r7 != 0) goto L_0x0043;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
    L_0x003d:
        r6 = r6.isEmpty();	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        if (r6 == 0) goto L_0x0066;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
    L_0x0043:
        r0 = r2.isEmpty();	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        if (r0 != 0) goto L_0x0052;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
    L_0x0049:
        r4.add(r2);	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r0 = new java.util.LinkedList;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r2 = r0;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
    L_0x0052:
        r0 = "HTTP/1.1 200 OK";	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r6 = r5[r3];	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r6 = r6.trim();	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r0 = r0.equals(r6);	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        if (r0 == 0) goto L_0x0064;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
    L_0x0060:
        r0 = 1;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
    L_0x0061:
        r3 = r3 + 1;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        goto L_0x002c;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
    L_0x0064:
        r0 = r1;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        goto L_0x0061;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
    L_0x0066:
        if (r0 == 0) goto L_0x0061;	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
    L_0x0068:
        r6 = r5[r3];	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r6 = r6.trim();	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        r2.add(r6);	 Catch:{ SocketTimeoutException -> 0x0072, IOException -> 0x007d }
        goto L_0x0061;
    L_0x0072:
        r0 = move-exception;
        r0 = r2.isEmpty();
        if (r0 != 0) goto L_0x007c;
    L_0x0079:
        r4.add(r2);
    L_0x007c:
        return r4;
    L_0x007d:
        r0 = move-exception;
        goto L_0x007c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.upnp.UpnpDiscoverySocket.b():java.util.List<java.util.List<java.lang.String>>");
    }
}
