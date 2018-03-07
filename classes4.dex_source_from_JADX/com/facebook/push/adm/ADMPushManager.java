package com.facebook.push.adm;

import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.push.PushManager;
import com.facebook.push.adm.ADMBroadcastReceiver.MessageAlertReceiver;
import com.facebook.push.externalcloud.PushServiceSelector;
import com.facebook.push.registration.FacebookPushServerRegistrar;
import com.facebook.push.registration.ServiceType;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: intercepted */
public class ADMPushManager implements PushManager {
    private static final Class<?> f10216a = ADMPushManager.class;
    private static volatile ADMPushManager f10217f;
    private final Lazy<ADMRegistrar> f10218b;
    private final Lazy<FacebookPushServerRegistrar> f10219c;
    private final Provider<String> f10220d;
    private final PushServiceSelector f10221e;

    public static com.facebook.push.adm.ADMPushManager m10704a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10217f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.adm.ADMPushManager.class;
        monitor-enter(r1);
        r0 = f10217f;	 Catch:{ all -> 0x003a }
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
        r0 = m10705b(r0);	 Catch:{ all -> 0x0035 }
        f10217f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10217f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.adm.ADMPushManager.a(com.facebook.inject.InjectorLike):com.facebook.push.adm.ADMPushManager");
    }

    private static ADMPushManager m10705b(InjectorLike injectorLike) {
        return new ADMPushManager(IdBasedSingletonScopeProvider.b(injectorLike, 3158), IdBasedSingletonScopeProvider.b(injectorLike, 3215), IdBasedProvider.a(injectorLike, 4442), PushServiceSelector.m10724a(injectorLike));
    }

    @Inject
    public ADMPushManager(Lazy<ADMRegistrar> lazy, Lazy<FacebookPushServerRegistrar> lazy2, Provider<String> provider, PushServiceSelector pushServiceSelector) {
        this.f10218b = lazy;
        this.f10219c = lazy2;
        this.f10220d = provider;
        this.f10221e = pushServiceSelector;
    }

    public final ServiceType mo794a() {
        return ServiceType.ADM;
    }

    private boolean m10706f() {
        return this.f10221e.m10731a(ServiceType.ADM);
    }

    public final void mo795b() {
        try {
            if (m10706f()) {
                this.f10221e.m10730a("com.amazon.device.messaging", ADMBroadcastReceiver.class, MessageAlertReceiver.class, ADMRegistrarService.class, ADMService.class);
            }
        } catch (NoClassDefFoundError e) {
        }
    }

    public final void mo796c() {
        if (m10706f()) {
            ((ADMRegistrar) this.f10218b.get()).m10771a(true);
        }
    }

    public final void mo797d() {
        if (m10706f() && !StringUtil.a((CharSequence) this.f10220d.get())) {
            ((ADMRegistrar) this.f10218b.get()).m10771a(false);
        }
    }

    public final void mo798e() {
        if (m10706f()) {
            ((FacebookPushServerRegistrar) this.f10219c.get()).m10798a(ServiceType.ADM);
        }
    }
}
