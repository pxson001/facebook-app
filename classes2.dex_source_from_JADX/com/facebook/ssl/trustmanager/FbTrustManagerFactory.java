package com.facebook.ssl.trustmanager;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

@Singleton
/* compiled from: prompted_models */
public class FbTrustManagerFactory {
    private static final Class<FbTrustManagerFactory> f8740a = FbTrustManagerFactory.class;
    private static volatile FbTrustManagerFactory f8741d;
    private SoftReference<X509Certificate[]> f8742b = new SoftReference(null);
    private AbstractFbErrorReporter f8743c;

    public static com.facebook.ssl.trustmanager.FbTrustManagerFactory m13569a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8741d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ssl.trustmanager.FbTrustManagerFactory.class;
        monitor-enter(r1);
        r0 = f8741d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13570b(r0);	 Catch:{ all -> 0x0035 }
        f8741d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8741d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ssl.trustmanager.FbTrustManagerFactory.a(com.facebook.inject.InjectorLike):com.facebook.ssl.trustmanager.FbTrustManagerFactory");
    }

    private static FbTrustManagerFactory m13570b(InjectorLike injectorLike) {
        return new FbTrustManagerFactory(FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public FbTrustManagerFactory(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f8743c = abstractFbErrorReporter;
    }

    @Nullable
    private synchronized X509TrustManager m13571d() {
        TrustManagerFactory instance;
        Throwable e;
        int i;
        X509TrustManager x509TrustManager;
        try {
            instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            try {
                instance.init(null);
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                BLog.b(f8740a, "Failed to create TrustManagerFactory", e);
                if (instance == null) {
                    for (TrustManager trustManager : instance.getTrustManagers()) {
                        if (trustManager instanceof X509TrustManager) {
                            x509TrustManager = (X509TrustManager) trustManager;
                            break;
                        }
                    }
                    x509TrustManager = null;
                } else {
                    x509TrustManager = null;
                }
                return x509TrustManager;
            } catch (KeyStoreException e3) {
                e = e3;
                BLog.b(f8740a, "Failed to create TrustManagerFactory", e);
                if (instance == null) {
                    x509TrustManager = null;
                } else {
                    for (i = 0; i < r4; i++) {
                        if (trustManager instanceof X509TrustManager) {
                            x509TrustManager = (X509TrustManager) trustManager;
                            break;
                        }
                    }
                    x509TrustManager = null;
                }
                return x509TrustManager;
            }
        } catch (NoSuchAlgorithmException e4) {
            e = e4;
            instance = null;
            BLog.b(f8740a, "Failed to create TrustManagerFactory", e);
            if (instance == null) {
                for (i = 0; i < r4; i++) {
                    if (trustManager instanceof X509TrustManager) {
                        x509TrustManager = (X509TrustManager) trustManager;
                        break;
                    }
                }
                x509TrustManager = null;
            } else {
                x509TrustManager = null;
            }
            return x509TrustManager;
        } catch (KeyStoreException e5) {
            e = e5;
            instance = null;
            BLog.b(f8740a, "Failed to create TrustManagerFactory", e);
            if (instance == null) {
                x509TrustManager = null;
            } else {
                for (i = 0; i < r4; i++) {
                    if (trustManager instanceof X509TrustManager) {
                        x509TrustManager = (X509TrustManager) trustManager;
                        break;
                    }
                }
                x509TrustManager = null;
            }
            return x509TrustManager;
        }
        if (instance == null) {
            x509TrustManager = null;
        } else {
            for (i = 0; i < r4; i++) {
                if (trustManager instanceof X509TrustManager) {
                    x509TrustManager = (X509TrustManager) trustManager;
                    break;
                }
            }
            x509TrustManager = null;
        }
        return x509TrustManager;
    }

    @Nullable
    public final synchronized X509Certificate[] m13574a() {
        X509Certificate[] x509CertificateArr;
        x509CertificateArr = (X509Certificate[]) this.f8742b.get();
        if (x509CertificateArr == null) {
            X509TrustManager d = m13571d();
            if (d == null) {
                x509CertificateArr = null;
            } else {
                x509CertificateArr = d.getAcceptedIssuers();
                this.f8742b = new SoftReference(x509CertificateArr);
            }
        }
        return x509CertificateArr;
    }

    @Nullable
    public final byte[][] m13575b() {
        ArrayList e = m13572e();
        if (e == null || e.isEmpty()) {
            return null;
        }
        byte[][] bArr = new byte[e.size()][];
        for (int i = 0; i < e.size(); i++) {
            try {
                bArr[i] = ((X509Certificate) e.get(i)).getEncoded();
            } catch (Throwable e2) {
                BLog.a(f8740a, "Failed to encode user Root CA", e2);
            }
        }
        return bArr;
    }

    @Nullable
    private synchronized ArrayList<X509Certificate> m13572e() {
        ArrayList<X509Certificate> arrayList;
        Object f = m13573f();
        if (f == null) {
            arrayList = null;
        } else {
            try {
                Class cls = f.getClass();
                Method method = cls.getMethod("userAliases", new Class[0]);
                Method method2 = cls.getMethod("getCertificate", new Class[]{String.class});
                Set set = (Set) method.invoke(f, new Object[0]);
                if (set == null || set.size() == 0) {
                    arrayList = null;
                } else {
                    ArrayList<X509Certificate> arrayList2 = new ArrayList(set.size());
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        X509Certificate x509Certificate = (X509Certificate) method2.invoke(f, new Object[]{(String) it.next()});
                        if (x509Certificate != null) {
                            arrayList2.add(x509Certificate);
                        }
                    }
                    arrayList = arrayList2;
                }
            } catch (Throwable th) {
                arrayList = null;
            }
        }
        return arrayList;
    }

    private static Object m13573f() {
        try {
            return Class.forName("com.android.org.conscrypt.TrustedCertificateStore").newInstance();
        } catch (Throwable th) {
            return null;
        }
    }

    public final boolean m13576c() {
        List<X509Certificate> e = m13572e();
        if (e == null) {
            return false;
        }
        for (X509Certificate subjectDN : e) {
            if ("CN=TheFacebookRootCA".equals(subjectDN.getSubjectDN().getName())) {
                return true;
            }
        }
        return false;
    }
}
