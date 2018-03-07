package com.facebook.crypto;

import com.facebook.crypto.cipher.NativeGCMCipher;
import com.facebook.crypto.keychain.KeyChain;
import com.facebook.crypto.module.ConcealNativeLibrary;
import com.facebook.crypto.streams.FixedSizeByteArrayOutputStream;
import com.facebook.crypto.streams.NativeGCMCipherInputStream;
import com.facebook.crypto.streams.NativeGCMCipherOutputStream;
import com.facebook.crypto.util.Assertions;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: operation_stated */
public class Crypto {
    private final KeyChain f10937a;
    private final ConcealNativeLibrary f10938b;
    private final CryptoAlgoGcm f10939c;

    public Crypto(KeyChain keyChain, ConcealNativeLibrary concealNativeLibrary, CryptoConfig cryptoConfig) {
        this.f10937a = new CheckedKeyChain(keyChain, cryptoConfig);
        this.f10938b = concealNativeLibrary;
        this.f10939c = new CryptoAlgoGcm(this.f10938b, this.f10937a, cryptoConfig);
    }

    public final boolean m16232a() {
        try {
            this.f10938b.m16218a();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public final OutputStream m16230a(OutputStream outputStream, Entity entity) {
        return m16231a(outputStream, entity, null);
    }

    public final OutputStream m16231a(OutputStream outputStream, Entity entity, byte[] bArr) {
        CryptoAlgoGcm cryptoAlgoGcm = this.f10939c;
        outputStream.write(1);
        outputStream.write(cryptoAlgoGcm.f10944c.cipherId);
        byte[] b = cryptoAlgoGcm.f10943b.mo2086b();
        NativeGCMCipher nativeGCMCipher = new NativeGCMCipher(cryptoAlgoGcm.f10942a);
        nativeGCMCipher.a(cryptoAlgoGcm.f10943b.mo2085a(), b);
        outputStream.write(b);
        CryptoAlgoGcm.m16238a(nativeGCMCipher, (byte) 1, cryptoAlgoGcm.f10944c.cipherId, entity.f10986c);
        return new NativeGCMCipherOutputStream(outputStream, nativeGCMCipher, bArr, cryptoAlgoGcm.f10944c.tagLength);
    }

    public final InputStream m16229a(InputStream inputStream, Entity entity) {
        CryptoAlgoGcm cryptoAlgoGcm = this.f10939c;
        boolean z = true;
        byte read = (byte) inputStream.read();
        byte read2 = (byte) inputStream.read();
        Assertions.b(read == (byte) 1, "Unexpected crypto version " + read);
        if (read2 != cryptoAlgoGcm.f10944c.cipherId) {
            z = false;
        }
        Assertions.b(z, "Unexpected cipher ID " + read2);
        byte[] bArr = new byte[cryptoAlgoGcm.f10944c.ivLength];
        new DataInputStream(inputStream).readFully(bArr);
        NativeGCMCipher nativeGCMCipher = new NativeGCMCipher(cryptoAlgoGcm.f10942a);
        nativeGCMCipher.b(cryptoAlgoGcm.f10943b.mo2085a(), bArr);
        CryptoAlgoGcm.m16238a(nativeGCMCipher, read, read2, entity.f10986c);
        return new NativeGCMCipherInputStream(inputStream, nativeGCMCipher, cryptoAlgoGcm.f10944c.tagLength);
    }

    public final byte[] m16233a(byte[] bArr, Entity entity) {
        FixedSizeByteArrayOutputStream fixedSizeByteArrayOutputStream = new FixedSizeByteArrayOutputStream(bArr.length + m16228b());
        OutputStream a = m16231a(fixedSizeByteArrayOutputStream, entity, null);
        a.write(bArr);
        a.close();
        return fixedSizeByteArrayOutputStream.a();
    }

    public final byte[] m16234b(byte[] bArr, Entity entity) {
        int length = bArr.length;
        InputStream a = m16229a(new ByteArrayInputStream(bArr), entity);
        FixedSizeByteArrayOutputStream fixedSizeByteArrayOutputStream = new FixedSizeByteArrayOutputStream(length - m16228b());
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = a.read(bArr2);
            if (read != -1) {
                fixedSizeByteArrayOutputStream.write(bArr2, 0, read);
            } else {
                a.close();
                return fixedSizeByteArrayOutputStream.a();
            }
        }
    }

    private int m16228b() {
        CryptoAlgoGcm cryptoAlgoGcm = this.f10939c;
        return (cryptoAlgoGcm.f10944c.ivLength + 2) + cryptoAlgoGcm.f10944c.tagLength;
    }
}
