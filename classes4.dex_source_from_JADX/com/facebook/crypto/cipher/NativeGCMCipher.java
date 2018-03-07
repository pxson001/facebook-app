package com.facebook.crypto.cipher;

import com.facebook.crypto.module.ConcealNativeLibrary;
import com.facebook.crypto.proguard.annotations.DoNotStrip;
import com.facebook.crypto.util.Assertions;

@DoNotStrip
/* compiled from: syncContactsFull */
public class NativeGCMCipher {
    private STATE f1516a = STATE.UNINITIALIZED;
    private final ConcealNativeLibrary f1517b;
    @DoNotStrip
    private long mCtxPtr;

    /* compiled from: syncContactsFull */
    enum STATE {
        UNINITIALIZED,
        ENCRYPT_INITIALIZED,
        DECRYPT_INITIALIZED,
        ENCRYPT_FINALIZED,
        DECRYPT_FINALIZED
    }

    private native int nativeDecryptFinal(byte[] bArr, int i);

    private native int nativeDecryptInit(byte[] bArr, byte[] bArr2);

    private native int nativeDestroy();

    private native int nativeEncryptFinal(byte[] bArr, int i);

    private native int nativeEncryptInit(byte[] bArr, byte[] bArr2);

    private static native int nativeFailure();

    private native int nativeGetCipherBlockSize();

    private native int nativeUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    private native int nativeUpdateAad(byte[] bArr, int i);

    public NativeGCMCipher(ConcealNativeLibrary concealNativeLibrary) {
        this.f1517b = concealNativeLibrary;
    }

    public final void m1737a(byte[] bArr, byte[] bArr2) {
        Assertions.m1742a(this.f1516a == STATE.UNINITIALIZED, "Cipher has already been initialized");
        this.f1517b.a();
        if (nativeEncryptInit(bArr, bArr2) == nativeFailure()) {
            throw new NativeGCMCipherException("encryptInit");
        }
        this.f1516a = STATE.ENCRYPT_INITIALIZED;
    }

    public final void m1740b(byte[] bArr, byte[] bArr2) {
        Assertions.m1742a(this.f1516a == STATE.UNINITIALIZED, "Cipher has already been initialized");
        this.f1517b.a();
        if (nativeDecryptInit(bArr, bArr2) == nativeFailure()) {
            throw new NativeGCMCipherException("decryptInit");
        }
        this.f1516a = STATE.DECRYPT_INITIALIZED;
    }

    public final int m1734a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        m1732c();
        int nativeUpdate = nativeUpdate(bArr, i, i2, bArr2, i3);
        if (nativeUpdate >= 0) {
            return nativeUpdate;
        }
        throw new NativeGCMCipherException(m1731a("update: Offset = %d; DataLen = %d; Result = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(nativeUpdate)));
    }

    public final void m1736a(byte[] bArr, int i) {
        m1732c();
        if (nativeUpdateAad(bArr, i) < 0) {
            throw new NativeGCMCipherException(m1731a("updateAAd: DataLen = %d", Integer.valueOf(i)));
        }
    }

    public final void m1739b(byte[] bArr, int i) {
        boolean z;
        if (this.f1516a == STATE.ENCRYPT_INITIALIZED) {
            z = true;
        } else {
            z = false;
        }
        Assertions.m1742a(z, "Cipher has not been initialized");
        this.f1516a = STATE.ENCRYPT_FINALIZED;
        if (nativeEncryptFinal(bArr, i) == nativeFailure()) {
            throw new NativeGCMCipherException(m1731a("encryptFinal: %d", Integer.valueOf(i)));
        }
    }

    public final void m1741c(byte[] bArr, int i) {
        Assertions.m1742a(this.f1516a == STATE.DECRYPT_INITIALIZED, "Cipher has not been initialized");
        this.f1516a = STATE.DECRYPT_FINALIZED;
        if (nativeDecryptFinal(bArr, i) == nativeFailure()) {
            throw new NativeGCMCipherException("The message could not be decrypted successfully.It has either been tampered with or the wrong resource is being decrypted.");
        }
    }

    public final void m1735a() {
        m1733d();
        if (nativeDestroy() == nativeFailure()) {
            throw new NativeGCMCipherException("destroy");
        }
        this.f1516a = STATE.UNINITIALIZED;
    }

    public final int m1738b() {
        m1732c();
        return nativeGetCipherBlockSize();
    }

    private void m1732c() {
        boolean z = this.f1516a == STATE.DECRYPT_INITIALIZED || this.f1516a == STATE.ENCRYPT_INITIALIZED;
        Assertions.m1742a(z, "Cipher has not been initialized");
    }

    private void m1733d() {
        boolean z = this.f1516a == STATE.DECRYPT_FINALIZED || this.f1516a == STATE.ENCRYPT_FINALIZED;
        Assertions.m1742a(z, "Cipher has not been finalized");
    }

    private static String m1731a(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }
}
