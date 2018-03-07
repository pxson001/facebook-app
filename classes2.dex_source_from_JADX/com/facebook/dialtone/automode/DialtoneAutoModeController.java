package com.facebook.dialtone.automode;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneUiFeaturesAccessor;
import com.facebook.dialtone.activity.DialtoneModeSelectionActivity;
import com.facebook.dialtone.gk.IsDialtoneEligibleGK;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.zero.datacheck.DataState;
import com.facebook.zero.datacheck.ZeroDataCheckerState;
import com.facebook.zero.datacheck.ZeroDataCheckerState.Listener;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_stories_below */
public class DialtoneAutoModeController {
    private static final Class<?> f16228a = DialtoneAutoModeController.class;
    private static volatile DialtoneAutoModeController f16229h;
    private final ZeroDataCheckerState f16230b;
    private final DialtoneUiFeaturesAccessor f16231c;
    @IsDialtoneEligibleGK
    private final Provider<TriState> f16232d;
    public final Lazy<DialtoneController> f16233e;
    public final Lazy<SecureContextHelper> f16234f;
    private final Lazy<AndroidThreadUtil> f16235g;

    @Singleton
    /* compiled from: total_stories_below */
    public class LocalDialtoneAutoModeControllerReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<DialtoneAutoModeController> {
        private static volatile LocalDialtoneAutoModeControllerReceiverRegistration f2320a;

        public static com.facebook.dialtone.automode.DialtoneAutoModeController.LocalDialtoneAutoModeControllerReceiverRegistration m4503a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f2320a;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.dialtone.automode.DialtoneAutoModeController.LocalDialtoneAutoModeControllerReceiverRegistration.class;
            monitor-enter(r1);
            r0 = f2320a;	 Catch:{ all -> 0x003a }
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
            r0 = m4504b(r0);	 Catch:{ all -> 0x0035 }
            f2320a = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2320a;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.automode.DialtoneAutoModeController.LocalDialtoneAutoModeControllerReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.automode.DialtoneAutoModeController$LocalDialtoneAutoModeControllerReceiverRegistration");
        }

        private static LocalDialtoneAutoModeControllerReceiverRegistration m4504b(InjectorLike injectorLike) {
            return new LocalDialtoneAutoModeControllerReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 1099));
        }

        protected /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent, Object obj) {
        }

        @Inject
        public LocalDialtoneAutoModeControllerReceiverRegistration(Lazy<DialtoneAutoModeController> lazy) {
            super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, "com.facebook.zero.ZERO_RATING_STATE_CHANGED");
        }
    }

    /* compiled from: total_stories_below */
    class C07051 implements Listener {
        final /* synthetic */ DialtoneAutoModeController f16236a;

        C07051(DialtoneAutoModeController dialtoneAutoModeController) {
            this.f16236a = dialtoneAutoModeController;
        }

        public final void mo1249a(DataState dataState, DataState dataState2) {
            this.f16236a.m23068a(dataState2);
        }
    }

    public static com.facebook.dialtone.automode.DialtoneAutoModeController m23065a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16229h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.dialtone.automode.DialtoneAutoModeController.class;
        monitor-enter(r1);
        r0 = f16229h;	 Catch:{ all -> 0x003a }
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
        r0 = m23069b(r0);	 Catch:{ all -> 0x0035 }
        f16229h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16229h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.automode.DialtoneAutoModeController.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.automode.DialtoneAutoModeController");
    }

    private static DialtoneAutoModeController m23069b(InjectorLike injectorLike) {
        return new DialtoneAutoModeController(ZeroDataCheckerState.m8439a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1086), DialtoneUiFeaturesAccessor.m4677a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 968), IdBasedLazy.m1808a(injectorLike, 517), IdBasedProvider.m1811a(injectorLike, 664));
    }

    @Inject
    public DialtoneAutoModeController(ZeroDataCheckerState zeroDataCheckerState, Lazy<DialtoneController> lazy, DialtoneUiFeaturesAccessor dialtoneUiFeaturesAccessor, Lazy<SecureContextHelper> lazy2, Lazy<AndroidThreadUtil> lazy3, Provider<TriState> provider) {
        this.f16230b = zeroDataCheckerState;
        this.f16233e = lazy;
        this.f16231c = dialtoneUiFeaturesAccessor;
        this.f16234f = lazy2;
        this.f16235g = lazy3;
        this.f16232d = provider;
        this.f16230b.m8461a(new C07051(this));
    }

    private void m23068a(DataState dataState) {
        if (((DialtoneController) this.f16233e.get()).mo1221b() || !((TriState) this.f16232d.get()).asBoolean(false) || dataState != DataState.FREE_TIER_ONLY) {
            return;
        }
        if (this.f16231c.m4682a(ZeroFeatureKey.DIALTONE_AUTOMATIC_MODE)) {
            Bundle bundle = new Bundle();
            bundle.putString("ref", "dialtone_automode");
            Intent intent = new Intent();
            intent.setData(Uri.parse("dialtone://switch_to_dialtone"));
            intent.putExtras(bundle);
            m23066a(intent);
        } else if (this.f16231c.m4682a(ZeroFeatureKey.DIALTONE_AUTOMATIC_MODE_WITH_CONFIRMATION)) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("dialtone_automode_with_confirmation", true);
            Context f = ((DialtoneController) this.f16233e.get()).mo1227f();
            if (f != null) {
                Intent intent2 = new Intent(f, DialtoneModeSelectionActivity.class);
                intent2.putExtras(bundle2);
                intent2.addFlags(67108864);
                m23066a(intent2);
            }
        }
    }

    private void m23066a(Intent intent) {
        ((DefaultAndroidThreadUtil) this.f16235g.get()).m1656b(new 2(this, intent));
    }
}
