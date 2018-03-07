package com.facebook.selfupdate;

import android.content.pm.Signature;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: has_fetched_since_login/ */
public class SignatureUtils {
    public static String m10108a(Signature signature) {
        if (signature == null) {
            return "Unknown";
        }
        try {
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()))).getIssuerDN().getName();
        } catch (CertificateException e) {
            return "Unknown";
        }
    }

    public static Certificate[] m10110a(JarFile jarFile, JarEntry jarEntry) {
        InputStream bufferedInputStream;
        InputStream inputStream;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            do {
                try {
                } catch (IOException e) {
                    inputStream = bufferedInputStream;
                } catch (RuntimeException e2) {
                } catch (OutOfMemoryError e3) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (bufferedInputStream.read() != -1);
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                bufferedInputStream.close();
                return certificates;
            } catch (IOException e4) {
                return null;
            }
        } catch (IOException e5) {
            inputStream = null;
            if (inputStream == null) {
                return null;
            }
            try {
                inputStream.close();
                return null;
            } catch (IOException e6) {
                return null;
            }
        } catch (RuntimeException e7) {
            bufferedInputStream = null;
            if (bufferedInputStream == null) {
                return null;
            }
            try {
                bufferedInputStream.close();
                return null;
            } catch (IOException e8) {
                return null;
            }
        } catch (OutOfMemoryError e9) {
            bufferedInputStream = null;
            if (bufferedInputStream == null) {
                return null;
            }
            try {
                bufferedInputStream.close();
                return null;
            } catch (IOException e10) {
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e11) {
                    return null;
                }
            }
            throw th;
        }
    }

    public static Signature[] m10109a(Certificate[] certificateArr) {
        int i = 0;
        if (certificateArr == null || certificateArr.length <= 0) {
            return null;
        }
        try {
            Signature[] signatureArr = new Signature[certificateArr.length];
            int length = certificateArr.length;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                signatureArr[i2] = new Signature(certificateArr[i].getEncoded());
                i++;
                i2 = i3;
            }
            return signatureArr;
        } catch (CertificateEncodingException e) {
            return null;
        }
    }
}
