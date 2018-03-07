package com.facebook.messaging.media.upload.udp;

/* compiled from: last_name_extra */
public class UDPHeaderMessage extends UDPMessage {
    private final int f12152a;
    private final int f12153b;

    public UDPHeaderMessage(byte[] bArr, int i, int i2) {
        super(bArr, i + i2);
        this.f12153b = i;
        this.f12152a = i2;
    }
}
