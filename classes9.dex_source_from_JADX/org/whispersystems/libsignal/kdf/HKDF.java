package org.whispersystems.libsignal.kdf;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: adInterfacesModifyStoryPromotionParams */
public abstract class HKDF {
    protected abstract int mo936a();

    public static HKDF m21744a(int i) {
        switch (i) {
            case 2:
                return new HKDFv2();
            case 3:
                return new HKDFv3();
            default:
                throw new AssertionError("Unknown version: " + i);
        }
    }

    public final byte[] m21748a(byte[] bArr, byte[] bArr2, int i) {
        return m21749a(bArr, new byte[32], bArr2, i);
    }

    public final byte[] m21749a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        return m21746b(m21745a(bArr2, bArr), bArr3, i);
    }

    private static byte[] m21745a(byte[] bArr, byte[] bArr2) {
        Object e;
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(bArr, "HmacSHA256"));
            return instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (InvalidKeyException e3) {
            e = e3;
            throw new AssertionError(e);
        }
    }

    private byte[] m21746b(byte[] bArr, byte[] bArr2, int i) {
        Object e;
        try {
            int ceil = (int) Math.ceil(((double) i) / 32.0d);
            byte[] bArr3 = new byte[0];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int a = mo936a(); a < mo936a() + ceil; a++) {
                Mac instance = Mac.getInstance("HmacSHA256");
                instance.init(new SecretKeySpec(bArr, "HmacSHA256"));
                instance.update(bArr3);
                if (bArr2 != null) {
                    instance.update(bArr2);
                }
                instance.update((byte) a);
                bArr3 = instance.doFinal();
                int min = Math.min(i, bArr3.length);
                byteArrayOutputStream.write(bArr3, 0, min);
                i -= min;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (InvalidKeyException e3) {
            e = e3;
            throw new AssertionError(e);
        }
    }
}
