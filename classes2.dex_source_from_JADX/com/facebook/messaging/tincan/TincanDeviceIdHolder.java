package com.facebook.messaging.tincan;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.io.BaseEncoding;
import java.security.MessageDigest;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.whispersystems.libsignal.IdentityKeyPair;
import org.whispersystems.libsignal.state.IdentityKeyStore;

@Singleton
/* compiled from: mNextAnim= */
public class TincanDeviceIdHolder implements IHaveUserData {
    private static final Class<?> f15506a = TincanDeviceIdHolder.class;
    private static volatile TincanDeviceIdHolder f15507e;
    private final Provider<IdentityKeyStore> f15508b;
    private final Product f15509c;
    private String f15510d = null;

    public static com.facebook.messaging.tincan.TincanDeviceIdHolder m22122a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15507e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.TincanDeviceIdHolder.class;
        monitor-enter(r1);
        r0 = f15507e;	 Catch:{ all -> 0x003a }
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
        r0 = m22123b(r0);	 Catch:{ all -> 0x0035 }
        f15507e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15507e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.TincanDeviceIdHolder.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.TincanDeviceIdHolder");
    }

    private static TincanDeviceIdHolder m22123b(InjectorLike injectorLike) {
        return new TincanDeviceIdHolder(IdBasedProvider.m1811a(injectorLike, 8580), ProductMethodAutoProvider.m4524b(injectorLike));
    }

    @Inject
    public TincanDeviceIdHolder(Provider<IdentityKeyStore> provider, Product product) {
        this.f15508b = provider;
        this.f15509c = product;
    }

    public final String m22126a() {
        if (this.f15509c == Product.MESSENGER) {
            return m22124b().replaceAll("-", "");
        }
        return "deviceidinvalid";
    }

    public void clearUserData() {
        this.f15510d = null;
    }

    private String m22124b() {
        if (this.f15510d != null) {
            return this.f15510d;
        }
        this.f15510d = m22125c();
        return this.f15510d;
    }

    private String m22125c() {
        IdentityKeyStore identityKeyStore = (IdentityKeyStore) this.f15508b.get();
        if (identityKeyStore == null) {
            BLog.b(f15506a, "Could not retrieve a valid identity key store when generating Tincan device ID");
            return "deviceidinvalid";
        }
        IdentityKeyPair a = identityKeyStore.a();
        if (a == null) {
            BLog.b(f15506a, "Could not retrieve a valid identity key to go into Tincan device ID");
            return "deviceidinvalid";
        }
        byte[] b = a.a().b();
        try {
            b = MessageDigest.getInstance("SHA-256").digest(b);
        } catch (Throwable e) {
            BLog.b(f15506a, e.getMessage(), e);
        }
        return BaseEncoding.m16267e().mo2093b().m16271a(b);
    }
}
