package com.facebook.backgroundlocation.nux;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Pair;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.backgroundlocation.nux.BackgroundLocationNuxInterstitialAnalyticsLogger.IneligibleReason;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.api.InterstitialNUXFetchResult;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialControllerWithContextClass;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialNUXController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.model.NuxStep;
import com.facebook.location.FbLocationStatus;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: download_attachment_dialog */
public class BackgroundLocationNuxInterstitialController implements InterstitialControllerWithContextClass, InterstitialIntentController, InterstitialNUXController {
    private static final ImmutableList<InterstitialTrigger> f14757a = ImmutableList.of(new InterstitialTrigger(Action.SESSION_COLD_START));
    private static final ImmutableList<InterstitialTrigger> f14758b = ImmutableList.of(new InterstitialTrigger(Action.SESSION_COLD_START), new InterstitialTrigger(Action.APP_FOREGROUND));
    private static volatile BackgroundLocationNuxInterstitialController f14759i;
    public final Provider<Boolean> f14760c;
    public final GatekeeperStoreImpl f14761d;
    public final Lazy<FbLocationStatusUtil> f14762e;
    private final BackgroundLocationNuxInterstitialAnalyticsLogger f14763f;
    private final QeAccessor f14764g;
    public List<NuxStep> f14765h;

    public static com.facebook.backgroundlocation.nux.BackgroundLocationNuxInterstitialController m15121a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f14759i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundlocation.nux.BackgroundLocationNuxInterstitialController.class;
        monitor-enter(r1);
        r0 = f14759i;	 Catch:{ all -> 0x003a }
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
        r0 = m15122b(r0);	 Catch:{ all -> 0x0035 }
        f14759i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14759i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.nux.BackgroundLocationNuxInterstitialController.a(com.facebook.inject.InjectorLike):com.facebook.backgroundlocation.nux.BackgroundLocationNuxInterstitialController");
    }

    private static BackgroundLocationNuxInterstitialController m15122b(InjectorLike injectorLike) {
        return new BackgroundLocationNuxInterstitialController(IdBasedProvider.a(injectorLike, 3906), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2483), new BackgroundLocationNuxInterstitialAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BackgroundLocationNuxInterstitialController(Provider<Boolean> provider, GatekeeperStore gatekeeperStore, Lazy<FbLocationStatusUtil> lazy, BackgroundLocationNuxInterstitialAnalyticsLogger backgroundLocationNuxInterstitialAnalyticsLogger, QeAccessor qeAccessor) {
        this.f14760c = provider;
        this.f14761d = gatekeeperStore;
        this.f14762e = lazy;
        this.f14763f = backgroundLocationNuxInterstitialAnalyticsLogger;
        this.f14764g = qeAccessor;
    }

    public final String m15128b() {
        return "1631";
    }

    public final Class<? extends Parcelable> m15130d() {
        return InterstitialNUXFetchResult.class;
    }

    public final void m15127a(Parcelable parcelable) {
        this.f14765h = ((InterstitialNUXFetchResult) parcelable).steps;
    }

    public final void m15126a(long j) {
    }

    public final InterstitialControllerState m15124a(InterstitialTrigger interstitialTrigger) {
        Pair create;
        if (((Boolean) this.f14760c.get()).booleanValue()) {
            State a = ((FbLocationStatusUtil) this.f14762e.get()).a();
            if (this.f14761d.a(997, false)) {
                if (!FbLocationStatus.a(a)) {
                    create = Pair.create(InterstitialControllerState.INELIGIBLE, IneligibleReason.LOCATION_UNAVAILABLE);
                }
            } else if (a != State.OKAY) {
                create = Pair.create(InterstitialControllerState.INELIGIBLE, IneligibleReason.LOCATION_UNAVAILABLE);
            }
            if (this.f14765h == null || this.f14765h.isEmpty()) {
                create = Pair.create(InterstitialControllerState.INELIGIBLE, IneligibleReason.EMPTY_SERVER_DATA);
            } else {
                BackgroundLocationNuxStep fromStepName;
                for (NuxStep nuxStep : this.f14765h) {
                    if (nuxStep.b()) {
                        fromStepName = BackgroundLocationNuxStep.fromStepName(nuxStep.name);
                        break;
                    }
                }
                fromStepName = null;
                create = fromStepName != BackgroundLocationNuxStep.SHARING ? Pair.create(InterstitialControllerState.INELIGIBLE, IneligibleReason.WRONG_NUX_STEP) : Pair.create(InterstitialControllerState.ELIGIBLE, null);
            }
        } else {
            create = Pair.create(InterstitialControllerState.INELIGIBLE, IneligibleReason.NOT_ALLOWED_IN_APP);
        }
        Pair pair = create;
        this.f14763f.m15120a((InterstitialControllerState) pair.first, (IneligibleReason) pair.second, ((FbLocationStatusUtil) this.f14762e.get()).b(), this.f14765h);
        return (InterstitialControllerState) pair.first;
    }

    public final ImmutableList<InterstitialTrigger> m15129c() {
        if (this.f14761d.a(517, false)) {
            return f14758b;
        }
        return f14757a;
    }

    public final Intent m15123a(Context context) {
        Intent intent = new Intent(context, BackgroundLocationOnePageNuxActivity.class);
        intent.putExtra("source", "cold_start");
        return intent;
    }

    public final List<NuxStep> m15131e() {
        return this.f14765h;
    }

    public final long hI_() {
        return 604800000;
    }

    public final Optional<Intent> m15125a(int i, Intent intent) {
        if (i != 1 || intent == null) {
            return Absent.INSTANCE;
        }
        return Optional.of(intent);
    }
}
