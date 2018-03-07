package com.facebook.crypto.mac;

import com.facebook.crypto.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: syncContactsDelta */
public class NativeMac {
    @DoNotStrip
    private long mCtxPtr;

    private native int nativeDestroy();

    private native byte[] nativeDoFinal();

    private static native int nativeFailure();

    private native int nativeGetMacLength();

    private native int nativeInit(byte[] bArr, int i);

    private native int nativeUpdate(byte b);

    private native int nativeUpdate(byte[] bArr, int i, int i2);
}
