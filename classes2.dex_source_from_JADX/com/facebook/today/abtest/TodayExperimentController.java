package com.facebook.today.abtest;

import android.content.Context;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.notificationsfriending.abtest.NotificationsFriendingExperimentController;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: show_keyboard_on_first_load */
public class TodayExperimentController {
    private static final String f4871a = BackType.ENABLED.name();
    private static volatile TodayExperimentController f4872f;
    public final QeAccessor f4873b;
    private final Context f4874c;
    private final GatekeeperStoreImpl f4875d;
    private final NotificationsFriendingExperimentController f4876e;

    /* compiled from: show_keyboard_on_first_load */
    public enum BackType {
        ENABLED,
        DISABLED,
        FORWARD
    }

    public static com.facebook.today.abtest.TodayExperimentController m8720a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4872f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.today.abtest.TodayExperimentController.class;
        monitor-enter(r1);
        r0 = f4872f;	 Catch:{ all -> 0x003a }
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
        r0 = m8721b(r0);	 Catch:{ all -> 0x0035 }
        f4872f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4872f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.today.abtest.TodayExperimentController.a(com.facebook.inject.InjectorLike):com.facebook.today.abtest.TodayExperimentController");
    }

    private static TodayExperimentController m8721b(InjectorLike injectorLike) {
        return new TodayExperimentController(QeInternalImplMethodAutoProvider.m3744a(injectorLike), (Context) injectorLike.getInstance(Context.class), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), NotificationsFriendingExperimentController.m6599a(injectorLike));
    }

    @Inject
    public TodayExperimentController(QeAccessor qeAccessor, Context context, GatekeeperStoreImpl gatekeeperStoreImpl, NotificationsFriendingExperimentController notificationsFriendingExperimentController) {
        this.f4873b = qeAccessor;
        this.f4874c = context;
        this.f4875d = gatekeeperStoreImpl;
        this.f4876e = notificationsFriendingExperimentController;
    }

    public final boolean m8726a() {
        return this.f4873b.mo596a(ExperimentsForTodayAbTestModule.f8107X, false);
    }

    public final boolean m8727b() {
        return this.f4873b.mo596a(ExperimentsForTodayAbTestModule.f8109Z, false);
    }

    public final boolean m8728c() {
        return this.f4873b.mo596a(ExperimentsForTodayAbTestModule.f8097N, false);
    }

    public final long m8729f() {
        return this.f4873b.mo575a(ExperimentsForTodayAbTestModule.f8124o, 86400);
    }

    public final int m8730i() {
        return this.f4873b.mo572a(ExperimentsForTodayAbTestModule.f8123n, 2);
    }

    public final long m8731l() {
        return ((long) this.f4873b.mo572a(ExperimentsForTodayAbTestModule.f8094K, 12)) * 3600000;
    }

    public final long m8732m() {
        return ((long) this.f4873b.mo572a(ExperimentsForTodayAbTestModule.f8095L, 2)) * 60000;
    }

    public final String m8733o() {
        return this.f4873b.mo581a(ExperimentsForTodayAbTestModule.f8098O, this.f4874c.getResources().getString(2131233694));
    }

    public final String m8734p() {
        return this.f4873b.mo581a(ExperimentsForTodayAbTestModule.f8099P, this.f4874c.getResources().getString(2131233695));
    }

    public final long m8735q() {
        return this.f4873b.mo575a(ExperimentsForTodayAbTestModule.f8105V, 14400);
    }

    public final int m8736r() {
        return this.f4873b.mo572a(ExperimentsForTodayAbTestModule.f8106W, 3);
    }

    public final long m8737s() {
        return this.f4873b.mo575a(ExperimentsForTodayAbTestModule.f8108Y, 120);
    }

    public final String m8738t() {
        return this.f4873b.mo581a(ExperimentsForTodayAbTestModule.ad, this.f4874c.getResources().getString(2131233693));
    }

    public final boolean m8739u() {
        return this.f4873b.mo596a(ExperimentsForTodayAbTestModule.f8113d, false);
    }

    public final boolean m8740v() {
        return !this.f4876e.m6601b() && this.f4873b.mo596a(ExperimentsForTodayAbTestModule.f8114e, false);
    }

    public final boolean m8741x() {
        return this.f4873b.mo596a(ExperimentsForTodayAbTestModule.f8132w, false);
    }

    public final boolean m8742z() {
        return this.f4873b.mo596a(ExperimentsForTodayAbTestModule.f8120k, this.f4875d.m2189a(1150, false));
    }

    public final boolean m8722C() {
        return this.f4873b.mo596a(ExperimentsForTodayAbTestModule.aa, false);
    }

    public final boolean m8723G() {
        return this.f4873b.mo596a(ExperimentsForTodayAbTestModule.f8091H, false);
    }

    public final boolean m8724I() {
        return this.f4873b.mo596a(ExperimentsForTodayAbTestModule.f8100Q, false);
    }

    public final boolean m8725L() {
        return this.f4873b.mo596a(ExperimentsForTodayAbTestModule.f8116g, false);
    }
}
