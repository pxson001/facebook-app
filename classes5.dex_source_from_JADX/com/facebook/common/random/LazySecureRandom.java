package com.facebook.common.random;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import java.security.SecureRandom;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: show_all_contextual_places */
public class LazySecureRandom extends SecureRandom {
    private static volatile LazySecureRandom f2725a;
    private final Lazy<SecureRandom> mDelegate;

    public static com.facebook.common.random.LazySecureRandom m3839a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2725a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.random.LazySecureRandom.class;
        monitor-enter(r1);
        r0 = f2725a;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3840b(r0);	 Catch:{ all -> 0x0035 }
        f2725a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2725a;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.random.LazySecureRandom.a(com.facebook.inject.InjectorLike):com.facebook.common.random.LazySecureRandom");
    }

    private static LazySecureRandom m3840b(InjectorLike injectorLike) {
        return new LazySecureRandom(IdBasedLazy.a(injectorLike, 4477));
    }

    @Inject
    public LazySecureRandom(Lazy<SecureRandom> lazy) {
        this.mDelegate = lazy;
    }

    public String getAlgorithm() {
        return ((SecureRandom) this.mDelegate.get()).getAlgorithm();
    }

    public void setSeed(long j) {
        if (j != 0) {
            ((SecureRandom) this.mDelegate.get()).setSeed(j);
        }
    }

    public synchronized void setSeed(byte[] bArr) {
        ((SecureRandom) this.mDelegate.get()).setSeed(bArr);
    }

    public synchronized void nextBytes(byte[] bArr) {
        ((SecureRandom) this.mDelegate.get()).nextBytes(bArr);
    }

    public byte[] generateSeed(int i) {
        return ((SecureRandom) this.mDelegate.get()).generateSeed(i);
    }

    public boolean nextBoolean() {
        return ((SecureRandom) this.mDelegate.get()).nextBoolean();
    }

    public double nextDouble() {
        return ((SecureRandom) this.mDelegate.get()).nextDouble();
    }

    public float nextFloat() {
        return ((SecureRandom) this.mDelegate.get()).nextFloat();
    }

    public synchronized double nextGaussian() {
        return ((SecureRandom) this.mDelegate.get()).nextGaussian();
    }

    public int nextInt() {
        return ((SecureRandom) this.mDelegate.get()).nextInt();
    }

    public int nextInt(int i) {
        return ((SecureRandom) this.mDelegate.get()).nextInt(i);
    }

    public long nextLong() {
        return ((SecureRandom) this.mDelegate.get()).nextLong();
    }

    public int hashCode() {
        return ((SecureRandom) this.mDelegate.get()).hashCode();
    }

    public String toString() {
        return ((SecureRandom) this.mDelegate.get()).toString();
    }
}
