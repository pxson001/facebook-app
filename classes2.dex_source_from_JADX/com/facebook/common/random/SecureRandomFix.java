package com.facebook.common.random;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: logged_in */
public class SecureRandomFix {
    private static volatile SecureRandomFix f16200d;
    private boolean f16201a;
    private final AbstractFbErrorReporter f16202b;
    private final String f16203c = "SecureRandomFix";

    public static com.facebook.common.random.SecureRandomFix m23035a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16200d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.random.SecureRandomFix.class;
        monitor-enter(r1);
        r0 = f16200d;	 Catch:{ all -> 0x003a }
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
        r0 = m23036b(r0);	 Catch:{ all -> 0x0035 }
        f16200d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16200d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.random.SecureRandomFix.a(com.facebook.inject.InjectorLike):com.facebook.common.random.SecureRandomFix");
    }

    private static SecureRandomFix m23036b(InjectorLike injectorLike) {
        return new SecureRandomFix(FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public SecureRandomFix(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f16202b = abstractFbErrorReporter;
    }

    public final synchronized void m23042a() {
        if (!this.f16201a) {
            try {
                m23037c();
                m23041g();
            } catch (Throwable th) {
                this.f16202b.m2346a("SecureRandomFix", th);
            }
            this.f16201a = true;
        }
    }

    private static void m23037c() {
        if (VERSION.SDK_INT >= 17 && VERSION.SDK_INT <= 18) {
            try {
                Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[]{byte[].class}).invoke(null, new Object[]{m23038d()});
                int intValue = ((Integer) Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", new Class[]{String.class, Long.TYPE}).invoke(null, new Object[]{"/dev/urandom", Integer.valueOf(1024)})).intValue();
                if (intValue != 1024) {
                    throw new IOException("Unexpected number of bytes read from Linux PRNG: " + intValue);
                }
            } catch (Throwable e) {
                throw new SecurityException("Failed to seed OpenSSL PRNG", e);
            }
        }
    }

    public static byte[] m23038d() {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeLong(System.currentTimeMillis());
            dataOutputStream.writeLong(System.nanoTime());
            dataOutputStream.writeInt(Process.myPid());
            dataOutputStream.writeInt(Process.myUid());
            dataOutputStream.write(m23039e());
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            throw new SecurityException("Failed to generate seed", e);
        }
    }

    private static byte[] m23039e() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = Build.FINGERPRINT;
        if (str != null) {
            stringBuilder.append(str);
        }
        str = m23040f();
        if (str != null) {
            stringBuilder.append(str);
        }
        try {
            return stringBuilder.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported");
        }
    }

    private static String m23040f() {
        try {
            return (String) Build.class.getField("SERIAL").get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static void m23041g() {
        if (VERSION.SDK_INT <= 18) {
            Provider[] providers = Security.getProviders("SecureRandom.SHA1PRNG");
            if (providers == null || providers.length <= 0 || !LinuxPRNGSecureRandomProvider.class.equals(providers[0].getClass())) {
                Security.insertProviderAt(new LinuxPRNGSecureRandomProvider(), 1);
            }
            SecureRandom secureRandom = new SecureRandom();
            if (LinuxPRNGSecureRandomProvider.class.equals(secureRandom.getProvider().getClass())) {
                try {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                    if (!LinuxPRNGSecureRandomProvider.class.equals(secureRandom.getProvider().getClass())) {
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
