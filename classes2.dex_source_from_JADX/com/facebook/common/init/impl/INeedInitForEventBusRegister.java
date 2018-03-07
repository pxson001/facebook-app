package com.facebook.common.init.impl;

import com.facebook.common.init.INeedInit;
import com.facebook.common.init.INeedInitForEventBusSubscription;
import com.facebook.common.init.STATICDI_MULTIBIND_PROVIDER$INeedInitForEventBusSubscription;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_bytes_received */
public class INeedInitForEventBusRegister implements INeedInit {
    private static final Class<?> f2382a = INeedInitForEventBusRegister.class;
    private static volatile INeedInitForEventBusRegister f2383c;
    private final Lazy<Set<INeedInitForEventBusSubscription>> f2384b;

    public static com.facebook.common.init.impl.INeedInitForEventBusRegister m4550a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2383c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.init.impl.INeedInitForEventBusRegister.class;
        monitor-enter(r1);
        r0 = f2383c;	 Catch:{ all -> 0x003a }
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
        r0 = m4552b(r0);	 Catch:{ all -> 0x0035 }
        f2383c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2383c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.init.impl.INeedInitForEventBusRegister.a(com.facebook.inject.InjectorLike):com.facebook.common.init.impl.INeedInitForEventBusRegister");
    }

    private static INeedInitForEventBusRegister m4552b(InjectorLike injectorLike) {
        return new INeedInitForEventBusRegister(ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$INeedInitForEventBusSubscription(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public INeedInitForEventBusRegister(Lazy<Set<INeedInitForEventBusSubscription>> lazy) {
        this.f2384b = lazy;
    }

    public void init() {
        m4551a();
    }

    private void m4551a() {
        TracerDetour.a("INeedInitForEventBusRegister-RegisterEventBusSubscribers", -1268039904);
        try {
            for (FbEventSubscriber fbEventSubscriber : m4553b()) {
                fbEventSubscriber.m4557b().m4568a(fbEventSubscriber);
            }
        } finally {
            TracerDetour.a(2032162314);
        }
    }

    private Set<INeedInitForEventBusSubscription> m4553b() {
        TracerDetour.a("INeedInitForEventBusRegister-RegisterEventBusSubscribers#construct", 449869580);
        try {
            Set<INeedInitForEventBusSubscription> set = (Set) this.f2384b.get();
            return set;
        } finally {
            TracerDetour.a(1032633993);
        }
    }
}
