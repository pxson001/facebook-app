package com.facebook.messaging.sms;

import com.facebook.gk.init.INeedInitForGatekeepersListenerRegistration;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.sms.analytics.SmsCallerContext;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: toggle_place_save_from_page */
public class SmsTakeoverKillSwitch$GatekeeperListenerRegistration extends INeedInitForGatekeepersListenerRegistration<SmsTakeoverKillSwitch> {
    private static volatile SmsTakeoverKillSwitch$GatekeeperListenerRegistration f2450b;

    public static com.facebook.messaging.sms.SmsTakeoverKillSwitch$GatekeeperListenerRegistration m4657a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2450b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sms.SmsTakeoverKillSwitch$GatekeeperListenerRegistration.class;
        monitor-enter(r1);
        r0 = f2450b;	 Catch:{ all -> 0x003a }
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
        r0 = m4658b(r0);	 Catch:{ all -> 0x0035 }
        f2450b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2450b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.SmsTakeoverKillSwitch$GatekeeperListenerRegistration.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.SmsTakeoverKillSwitch$GatekeeperListenerRegistration");
    }

    private static SmsTakeoverKillSwitch$GatekeeperListenerRegistration m4658b(InjectorLike injectorLike) {
        return new SmsTakeoverKillSwitch$GatekeeperListenerRegistration(IdBasedLazy.m1808a(injectorLike, 2702));
    }

    protected final void mo659a(GatekeeperStoreImpl gatekeeperStoreImpl, int i, Object obj) {
        SmsTakeoverKillSwitch smsTakeoverKillSwitch = (SmsTakeoverKillSwitch) obj;
        if (smsTakeoverKillSwitch.f.e()) {
            smsTakeoverKillSwitch.b.edit().mo1271a(SmsPrefKeys.b).commit();
        }
        if (smsTakeoverKillSwitch.f.d()) {
            smsTakeoverKillSwitch.c.m1655b();
            if (SmsDefaultAppManager.a(smsTakeoverKillSwitch.a)) {
                smsTakeoverKillSwitch.d.a(SmsCallerContext.KILL_SWITCH, smsTakeoverKillSwitch.a, false);
            }
            smsTakeoverKillSwitch.b.edit().mo1278b(SmsPrefKeys.a).commit();
        }
    }

    @Inject
    public SmsTakeoverKillSwitch$GatekeeperListenerRegistration(Lazy<SmsTakeoverKillSwitch> lazy) {
        super((Lazy) lazy, 325, 1127);
    }
}
