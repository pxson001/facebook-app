package com.facebook.device_id;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.phoneid.PhoneId;
import com.facebook.xconfig.core.XConfigReader;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_sc */
public class DefaultPhoneIdStore {
    private static volatile DefaultPhoneIdStore f867g;
    private final Provider<Boolean> f868a;
    private final Lazy<XConfigReader> f869b;
    public final UniqueIdForDeviceHolderImpl f870c;
    private final Object f871d = new Object();
    @GuardedBy("this")
    private PhoneId f872e;
    @GuardedBy("mShouldShareLock")
    private Boolean f873f = null;

    public static com.facebook.device_id.DefaultPhoneIdStore m1203a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f867g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device_id.DefaultPhoneIdStore.class;
        monitor-enter(r1);
        r0 = f867g;	 Catch:{ all -> 0x003a }
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
        r0 = m1204b(r0);	 Catch:{ all -> 0x0035 }
        f867g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f867g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device_id.DefaultPhoneIdStore.a(com.facebook.inject.InjectorLike):com.facebook.device_id.DefaultPhoneIdStore");
    }

    private static DefaultPhoneIdStore m1204b(InjectorLike injectorLike) {
        return new DefaultPhoneIdStore(UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 3953), IdBasedSingletonScopeProvider.b(injectorLike, 3749));
    }

    @Inject
    public DefaultPhoneIdStore(UniqueIdForDeviceHolder uniqueIdForDeviceHolder, Provider<Boolean> provider, Lazy<XConfigReader> lazy) {
        this.f870c = uniqueIdForDeviceHolder;
        this.f868a = provider;
        this.f869b = lazy;
    }

    public final boolean m1206a() {
        boolean booleanValue;
        synchronized (this.f871d) {
            if (this.f873f == null) {
                boolean a = ((XConfigReader) this.f869b.get()).a(DeviceIdXConfig.f864f, true);
                if (this.f868a.get() != null) {
                    booleanValue = ((Boolean) this.f868a.get()).booleanValue();
                } else {
                    booleanValue = true;
                }
                booleanValue = a && booleanValue;
                this.f873f = Boolean.valueOf(booleanValue);
            }
            booleanValue = this.f873f.booleanValue();
        }
        return booleanValue;
    }

    public final synchronized PhoneId m1207b() {
        PhoneId phoneId;
        UniqueDeviceId b = this.f870c.b();
        if (this.f872e != null && this.f872e.f888b == b.b() && this.f872e.f887a.equals(b.a())) {
            phoneId = this.f872e;
        } else {
            this.f872e = new PhoneId(b.a(), b.b());
            phoneId = this.f872e;
        }
        return phoneId;
    }

    public final synchronized void m1205a(PhoneId phoneId) {
        this.f872e = phoneId;
        this.f870c.a(new UniqueDeviceId(this.f872e.f887a, this.f872e.f888b));
    }
}
