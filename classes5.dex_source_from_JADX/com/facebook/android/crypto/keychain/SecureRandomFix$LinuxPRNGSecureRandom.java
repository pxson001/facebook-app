package com.facebook.android.crypto.keychain;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.SecureRandomSpi;

/* compiled from: show_ad_preferences */
public class SecureRandomFix$LinuxPRNGSecureRandom extends SecureRandomSpi {
    private static final File f8034a = new File("/dev/urandom");
    private static final Object f8035b = new Object();
    private static DataInputStream f8036c;
    private static OutputStream f8037d;
    private boolean mSeedAttempted;

    protected void engineSetSeed(byte[] bArr) {
        try {
            OutputStream b;
            synchronized (f8035b) {
                b = m14199b();
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
            synchronized (f8035b) {
                a = m14198a();
            }
            synchronized (a) {
                a.readFully(bArr);
            }
        } catch (Throwable e) {
            throw new SecurityException("Failed to read from " + f8034a, e);
        }
    }

    protected byte[] engineGenerateSeed(int i) {
        byte[] bArr = new byte[i];
        engineNextBytes(bArr);
        return bArr;
    }

    private static DataInputStream m14198a() {
        DataInputStream dataInputStream;
        synchronized (f8035b) {
            if (f8036c == null) {
                try {
                    f8036c = new DataInputStream(new FileInputStream(f8034a));
                } catch (Throwable e) {
                    throw new SecurityException("Failed to open " + f8034a + " for reading", e);
                }
            }
            dataInputStream = f8036c;
        }
        return dataInputStream;
    }

    private static OutputStream m14199b() {
        OutputStream outputStream;
        synchronized (f8035b) {
            if (f8037d == null) {
                try {
                    f8037d = new FileOutputStream(f8034a);
                } catch (Throwable e) {
                    throw new SecurityException("Failed to open " + f8034a + " for writing", e);
                }
            }
            outputStream = f8037d;
        }
        return outputStream;
    }
}
