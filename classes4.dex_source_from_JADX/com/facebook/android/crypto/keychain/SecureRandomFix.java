package com.facebook.android.crypto.keychain;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;

/* compiled from: syncPayload */
public class SecureRandomFix {
    private static boolean f1513a;

    public static synchronized void m1722a() {
        synchronized (SecureRandomFix.class) {
            if (!f1513a) {
                try {
                    m1723c();
                    m1727g();
                    f1513a = true;
                } catch (Throwable th) {
                    FixException fixException = new FixException(th);
                }
            }
        }
    }

    private static void m1723c() {
        if (VERSION.SDK_INT >= 17 && VERSION.SDK_INT <= 18) {
            try {
                Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[]{byte[].class}).invoke(null, new Object[]{m1724d()});
                int intValue = ((Integer) Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", new Class[]{String.class, Long.TYPE}).invoke(null, new Object[]{"/dev/urandom", Integer.valueOf(1024)})).intValue();
                if (intValue != 1024) {
                    throw new IOException("Unexpected number of bytes read from Linux PRNG: " + intValue);
                }
            } catch (Throwable e) {
                throw new SecurityException("Failed to seed OpenSSL PRNG", e);
            }
        }
    }

    public static byte[] m1724d() {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeLong(System.currentTimeMillis());
            dataOutputStream.writeLong(System.nanoTime());
            dataOutputStream.writeInt(Process.myPid());
            dataOutputStream.writeInt(Process.myUid());
            dataOutputStream.write(m1725e());
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            throw new SecurityException("Failed to generate seed", e);
        }
    }

    private static byte[] m1725e() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = Build.FINGERPRINT;
        if (str != null) {
            stringBuilder.append(str);
        }
        str = m1726f();
        if (str != null) {
            stringBuilder.append(str);
        }
        try {
            return stringBuilder.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported");
        }
    }

    private static String m1726f() {
        try {
            return (String) Build.class.getField("SERIAL").get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static void m1727g() {
        if (VERSION.SDK_INT <= 18) {
            Provider[] providers = Security.getProviders("SecureRandom.SHA1PRNG");
            if (providers == null || providers.length <= 0 || !LinuxPRNGSecureRandomProvider.class.equals(providers[0].getClass())) {
                Security.insertProviderAt(new LinuxPRNGSecureRandomProvider(), 1);
            }
            SecureRandom secureRandom = new SecureRandom();
            if (LinuxPRNGSecureRandomProvider.class.getName().equals(secureRandom.getProvider().getClass().getName())) {
                try {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                    if (!LinuxPRNGSecureRandomProvider.class.getName().equals(secureRandom.getProvider().getClass().getName())) {
                        throw new SecurityException("SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: " + secureRandom.getProvider().getClass());
                    }
                    return;
                } catch (Throwable e) {
                    throw new SecurityException("SHA1PRNG not available", e);
                }
            }
            throw new SecurityException("new SecureRandom() backed by wrong Provider: " + secureRandom.getProvider().getClass());
        }
    }
}
