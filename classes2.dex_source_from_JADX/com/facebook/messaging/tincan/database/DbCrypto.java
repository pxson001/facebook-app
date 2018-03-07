package com.facebook.messaging.tincan.database;

import com.facebook.android.crypto.keychain.FixedSecureRandom;
import com.facebook.crypto.CryptoConfig;
import com.facebook.crypto.Entity;
import com.facebook.crypto.keychain.KeyChain;
import com.facebook.crypto.module.FacebookConceal;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: makeUserAvailableInForeground */
public class DbCrypto {
    public static final CryptoConfig f15271a = CryptoConfig.KEY_256;
    private static volatile DbCrypto f15272f;
    private final FacebookConceal f15273b;
    private final Provider<MasterKeyChain> f15274c;
    public final FixedSecureRandom f15275d = new FixedSecureRandom();
    private final Entity f15276e = Entity.m16303a("");

    public static com.facebook.messaging.tincan.database.DbCrypto m21813a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15272f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.database.DbCrypto.class;
        monitor-enter(r1);
        r0 = f15272f;	 Catch:{ all -> 0x003a }
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
        r0 = m21814b(r0);	 Catch:{ all -> 0x0035 }
        f15272f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15272f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.DbCrypto.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.database.DbCrypto");
    }

    private static DbCrypto m21814b(InjectorLike injectorLike) {
        return new DbCrypto(FacebookConceal.m16211a(injectorLike), IdBasedProvider.m1811a(injectorLike, 8565));
    }

    @Inject
    public DbCrypto(FacebookConceal facebookConceal, Provider<MasterKeyChain> provider) {
        this.f15273b = facebookConceal;
        this.f15274c = provider;
    }

    public final byte[] m21815a() {
        byte[] bArr = new byte[f15271a.keyLength];
        this.f15275d.nextBytes(bArr);
        return bArr;
    }

    public final byte[] m21817a(byte[] bArr, byte[] bArr2) {
        return this.f15273b.m16213a(new DbCryptoKeyChain(this, bArr)).m16233a(bArr2, this.f15276e);
    }

    public final byte[] m21819b(byte[] bArr, byte[] bArr2) {
        return this.f15273b.m16213a(new DbCryptoKeyChain(this, bArr)).m16234b(bArr2, this.f15276e);
    }

    public final byte[] m21816a(byte[] bArr) {
        return this.f15273b.m16213a((KeyChain) this.f15274c.get()).m16233a(bArr, this.f15276e);
    }

    public final byte[] m21818b(byte[] bArr) {
        return this.f15273b.m16213a((KeyChain) this.f15274c.get()).m16234b(bArr, this.f15276e);
    }
}
