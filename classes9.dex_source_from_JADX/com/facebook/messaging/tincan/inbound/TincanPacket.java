package com.facebook.messaging.tincan.inbound;

import com.facebook.messaging.tincan.thrift.Packet;

/* compiled from: client_create_success */
public class TincanPacket {
    public final String f17968a;
    public final Packet f17969b;
    public final byte[] f17970c;

    protected TincanPacket(String str, Packet packet, byte[] bArr) {
        this.f17968a = str;
        this.f17969b = packet;
        this.f17970c = bArr;
    }
}
