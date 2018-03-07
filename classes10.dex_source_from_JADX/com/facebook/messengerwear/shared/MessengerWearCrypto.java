package com.facebook.messengerwear.shared;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: photo_suggestion */
public class MessengerWearCrypto {
    public static final SecureRandom f4964a = new SecureRandom();
    public static byte[] f4965b = new byte[16];
    public static byte[] f4966c = new byte[32];

    static {
        m4504a("FaceBooK12345678".getBytes(Charset.forName("UTF-8")), "FaceBooK12345678fACEbOOk12345678".getBytes(Charset.forName("UTF-8")));
    }

    private static void m4504a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 16 && bArr2.length == 32) {
            f4965b = Arrays.copyOf(bArr, 16);
            f4966c = Arrays.copyOf(bArr2, 32);
            return;
        }
        throw new IllegalArgumentException("Invalid keys (" + bArr.length + ", " + bArr2.length + ")");
    }

    public static byte[] m4505a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Mac instance = Mac.getInstance("HMACSHA1");
        instance.init(new SecretKeySpec(f4966c, "HMACSHA1"));
        byte[] bArr2 = new byte[f4965b.length];
        f4964a.nextBytes(bArr2);
        Key secretKeySpec = new SecretKeySpec(f4965b, "AES");
        Cipher instance2 = Cipher.getInstance("AES/CTR/NoPadding");
        instance2.init(1, secretKeySpec, new IvParameterSpec(bArr2));
        ByteBuffer allocate = ByteBuffer.allocate((wrap.limit() + 16) + 20);
        allocate.put(bArr2);
        instance2.doFinal(wrap, allocate);
        ByteBuffer asReadOnlyBuffer = allocate.asReadOnlyBuffer();
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.limit(allocate.position());
        instance.update(asReadOnlyBuffer.slice());
        allocate.put(instance.doFinal());
        allocate.clear();
        return allocate.array();
    }

    public static byte[] m4508b(byte[] bArr) {
        return m4507b(ByteBuffer.wrap(bArr));
    }

    private static byte[] m4507b(ByteBuffer byteBuffer) {
        Mac instance = Mac.getInstance("HMACSHA1");
        instance.init(new SecretKeySpec(f4966c, "HMACSHA1"));
        Cipher instance2 = Cipher.getInstance("AES/CTR/NoPadding");
        Key secretKeySpec = new SecretKeySpec(f4965b, "AES");
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        int limit = asReadOnlyBuffer.limit();
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.limit(16);
        ByteBuffer slice = asReadOnlyBuffer.slice();
        asReadOnlyBuffer.limit(limit - 20);
        asReadOnlyBuffer.position(16);
        ByteBuffer slice2 = asReadOnlyBuffer.slice();
        asReadOnlyBuffer.limit(limit);
        asReadOnlyBuffer.position(limit - 20);
        asReadOnlyBuffer = asReadOnlyBuffer.slice();
        instance.update(slice);
        instance.update(slice2);
        byte[] doFinal = instance.doFinal();
        byte[] bArr = new byte[20];
        asReadOnlyBuffer.get(bArr);
        Object obj = null;
        if (bArr == null || doFinal == null) {
            if (bArr == doFinal) {
                obj = 1;
            }
        } else if (bArr.length == doFinal.length) {
            int i = 0;
            for (int i2 = 0; i2 < bArr.length; i2++) {
                i = (byte) (i | (bArr[i2] ^ doFinal[i2]));
            }
            if (i == 0) {
                int i3 = 1;
            }
        }
        if (obj == null) {
            throw new GeneralSecurityException();
        }
        doFinal = new byte[16];
        slice.clear();
        slice.get(doFinal);
        instance2.init(2, secretKeySpec, new IvParameterSpec(doFinal));
        ByteBuffer allocate = ByteBuffer.allocate(slice2.capacity());
        slice2.clear();
        instance2.doFinal(slice2, allocate);
        byte[] bArr2 = new byte[allocate.limit()];
        allocate.clear();
        allocate.get(bArr2);
        return bArr2;
    }

    public static String m4503a(String str) {
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, new SecretKeySpec(f4965b, "AES"));
        return Base64.encodeToString(instance.doFinal(str.getBytes()), 3);
    }

    public static String m4506b(String str) {
        byte[] decode = Base64.decode(str, 3);
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, new SecretKeySpec(f4965b, "AES"));
        return new String(instance.doFinal(decode));
    }
}
