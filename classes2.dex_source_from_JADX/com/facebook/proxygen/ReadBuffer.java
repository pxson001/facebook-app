package com.facebook.proxygen;

/* compiled from: ptr_jump_to_top */
public interface ReadBuffer {
    void close();

    int read(byte[] bArr, int i, int i2);

    int size();
}
