package com.facebook.common.random;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.SecureRandomSpi;

/* compiled from: show_ad_preferences */
public class SecureRandomFix$LinuxPRNGSecureRandom extends SecureRandomSpi {
    private static final File f2726a = new File("/dev/urandom");
    private static final Object f2727b = new Object();
    private static DataInputStream f2728c;
    private static OutputStream f2729d;
    private boolean mSeedAttempted;

    protected void engineSetSeed(byte[] bArr) {
        try {
            OutputStream b;
            synchronized (f2727b) {
                b = m3842b();
            }
            b.write(bArr);
            b.flush();
        } catch (Throwable th) {
        } finally {
            this.mSeedAttempted = true;
        }
    }

    protected void engineNextBytes(byte[] bArr) {
        if (!this.mSeedAttempted) {
            engineSetSeed(SecureRandomFix.d());
        }
        try {
            DataInputStream a;
            synchronized (f2727b) {
                a = m3841a();
            }
            synchronized (a) {
                a.readFully(bArr);
            }
        } catch (Throwable e) {
            throw new SecurityException("Failed to read from " + f2726a, e);
        }
    }

    protected byte[] engineGenerateSeed(int i) {
        byte[] bArr = new byte[i];
        engineNextBytes(bArr);
        return bArr;
    }

    private static DataInputStream m3841a() {
        DataInputStream dataInputStream;
        synchronized (f2727b) {
            if (f2728c == null) {
                try {
                    f2728c = new DataInputStream(new FileInputStream(f2726a));
                } catch (Throwable e) {
                    throw new SecurityException("Failed to open " + f2726a + " for reading", e);
                }
            }
            dataInputStream = f2728c;
        }
        return dataInputStream;
    }

    private static OutputStream m3842b() {
        OutputStream outputStream;
        synchronized (f2727b) {
            if (f2729d == null) {
                try {
                    f2729d = new FileOutputStream(f2726a);
                } catch (Throwable e) {
                    throw new SecurityException("Failed to open " + f2726a + " for writing", e);
                }
            }
            outputStream = f2729d;
        }
        return outputStream;
    }
}
