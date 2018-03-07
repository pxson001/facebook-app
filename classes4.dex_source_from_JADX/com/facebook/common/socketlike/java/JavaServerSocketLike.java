package com.facebook.common.socketlike.java;

import java.net.ServerSocket;
import java.net.SocketAddress;

/* compiled from: first_cold_start */
public class JavaServerSocketLike {
    public final ServerSocket f11586a = new ServerSocket();

    public final void m12074a(SocketAddress socketAddress) {
        this.f11586a.bind(socketAddress);
    }

    public final boolean m12075a() {
        return this.f11586a.isBound();
    }

    public final SocketAddress m12076b() {
        return this.f11586a.getLocalSocketAddress();
    }

    public final JavaSocketLike m12077c() {
        return new JavaSocketLike(this.f11586a.accept());
    }
}
