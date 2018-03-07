package com.facebook.http.common;

import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* compiled from: doFrame */
public class TrustNonFacebookSocketFactory extends SSLSocketFactory {
    private static final String[] f4955a = new String[]{"facebook.com", "beta.facebook.com", "latest.facebook.com"};
    private static final X509HostnameVerifier f4956b = new SelectedHostsVerifier(f4955a, SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    private static TrustManager f4957d = new C04781();
    private SSLContext f4958c = SSLContext.getInstance("TLS");

    /* compiled from: doFrame */
    final class C04781 implements X509TrustManager {
        X509Certificate[] f4952a = new X509Certificate[0];

        C04781() {
        }

        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public final X509Certificate[] getAcceptedIssuers() {
            return this.f4952a;
        }
    }

    /* compiled from: doFrame */
    class SelectedHostsVerifier implements X509HostnameVerifier {
        private final Set<String> f4953a = new HashSet();
        private final X509HostnameVerifier f4954b;

        public SelectedHostsVerifier(String[] strArr, X509HostnameVerifier x509HostnameVerifier) {
            if (strArr != null) {
                for (Object add : strArr) {
                    this.f4953a.add(add);
                }
            }
            this.f4954b = x509HostnameVerifier;
        }

        private boolean m9900a(String str) {
            int indexOf = str.indexOf(46);
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            return this.f4953a.contains(str);
        }

        public boolean verify(String str, SSLSession sSLSession) {
            if (m9900a(str)) {
                return this.f4954b.verify(str, sSLSession);
            }
            return true;
        }

        public void verify(String str, SSLSocket sSLSocket) {
            if (m9900a(str)) {
                this.f4954b.verify(str, sSLSocket);
            }
        }

        public void verify(String str, X509Certificate x509Certificate) {
            if (m9900a(str)) {
                this.f4954b.verify(str, x509Certificate);
            }
        }

        public void verify(String str, String[] strArr, String[] strArr2) {
            if (m9900a(str)) {
                this.f4954b.verify(str, strArr, strArr2);
            }
        }

        public final String toString() {
            return "SELECTED_HOSTS_VERIFIER";
        }
    }

    private TrustNonFacebookSocketFactory(KeyStore keyStore) {
        super(keyStore);
        this.f4958c.init(null, new TrustManager[]{f4957d}, new SecureRandom());
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        SSLSocket sSLSocket = (SSLSocket) this.f4958c.getSocketFactory().createSocket(socket, str, i, z);
        getHostnameVerifier().verify(str, sSLSocket);
        return sSLSocket;
    }

    public Socket createSocket() {
        return this.f4958c.getSocketFactory().createSocket();
    }

    public static SSLSocketFactory m9901a() {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(null, null);
            SSLSocketFactory trustNonFacebookSocketFactory = new TrustNonFacebookSocketFactory(instance);
            trustNonFacebookSocketFactory.setHostnameVerifier(f4956b);
            return trustNonFacebookSocketFactory;
        } catch (Exception e) {
            return null;
        }
    }
}
