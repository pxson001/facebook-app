package com.facebook.messaging.media.upload.udp;

/* compiled from: last_seen */
public class UDPMessageBuilder {
    protected byte[] f12131a;
    protected int f12132b;
    public int f12133c;
    public int f12134d;
    protected int f12135e;

    public final UDPMessageBuilder m12642a(byte[] bArr) {
        this.f12131a = bArr;
        return this;
    }

    public final UDPMessageBuilder m12641a(int i) {
        this.f12132b = i;
        return this;
    }

    public final UDPMessageBuilder m12644b(int i) {
        this.f12133c = i;
        return this;
    }

    public final UDPMessageBuilder m12646c(int i) {
        this.f12134d = i;
        return this;
    }

    public final UDPMessageBuilder m12647d(int i) {
        this.f12135e = i;
        return this;
    }

    public final UDPMessage m12643b() {
        return new UDPMessage(this.f12131a, this.f12132b);
    }

    public final UDPChunk m12645c() {
        return new UDPChunk(this.f12131a, this.f12133c, this.f12134d, this.f12135e);
    }
}
