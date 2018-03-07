package com.facebook.messengerwear.support;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.init.INeedInit;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.gk.store.GatekeeperListeners;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.OnGatekeeperChangeListener;
import com.facebook.gk.store.internal.GatekeeperListenersImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Wearable;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: login_finish */
public class MessengerWearDetectionInit implements INeedInit, ConnectionCallbacks, OnConnectionFailedListener, ResultCallback<GetCapabilityResult> {
    private static final Class f8857g = MessengerWearDetectionInit.class;
    private static volatile MessengerWearDetectionInit f8858k;
    @Inject
    volatile Provider<MessengerWearSoftAlarm> f8859a = UltralightRuntime.a;
    @Inject
    volatile Provider<MessengerWearHelper> f8860b = UltralightRuntime.a;
    @Inject
    volatile Provider<Context> f8861c = UltralightRuntime.a;
    @Inject
    volatile Provider<FbSharedPreferences> f8862d = UltralightRuntime.a;
    @Inject
    volatile Provider<GatekeeperListeners> f8863e = UltralightRuntime.a;
    @Inject
    volatile Provider<GatekeeperStore> f8864f = UltralightRuntime.a;
    private GoogleApiClient f8865h;
    public GatekeeperListenersImpl f8866i;
    private final OnGatekeeperChangeListener f8867j = new C04211(this);

    /* compiled from: login_finish */
    class C04211 extends OnGatekeeperChangeListener {
        final /* synthetic */ MessengerWearDetectionInit f8868a;

        C04211(MessengerWearDetectionInit messengerWearDetectionInit) {
            this.f8868a = messengerWearDetectionInit;
        }

        public final void m9233a(GatekeeperStoreImpl gatekeeperStoreImpl, int i) {
            if (gatekeeperStoreImpl.a(985, false)) {
                MessengerWearDetectionInit.m9225a(this.f8868a);
                if (this.f8868a.f8866i != null) {
                    this.f8868a.f8866i.b(this, 985);
                }
            }
        }
    }

    public static com.facebook.messengerwear.support.MessengerWearDetectionInit m9224a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8858k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messengerwear.support.MessengerWearDetectionInit.class;
        monitor-enter(r1);
        r0 = f8858k;	 Catch:{ all -> 0x003a }
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
        r0 = m9227b(r0);	 Catch:{ all -> 0x0035 }
        f8858k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8858k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messengerwear.support.MessengerWearDetectionInit.a(com.facebook.inject.InjectorLike):com.facebook.messengerwear.support.MessengerWearDetectionInit");
    }

    private static MessengerWearDetectionInit m9227b(InjectorLike injectorLike) {
        MessengerWearDetectionInit messengerWearDetectionInit = new MessengerWearDetectionInit();
        messengerWearDetectionInit.m9226a(IdBasedSingletonScopeProvider.a(injectorLike, 8614), IdBasedProvider.a(injectorLike, 2752), injectorLike.getProvider(Context.class), IdBasedSingletonScopeProvider.a(injectorLike, 3078), IdBasedSingletonScopeProvider.a(injectorLike, 2138), IdBasedSingletonScopeProvider.a(injectorLike, 2128));
        return messengerWearDetectionInit;
    }

    public final void mo694a(Result result) {
        GetCapabilityResult getCapabilityResult = (GetCapabilityResult) result;
        if (getCapabilityResult.cp_().e()) {
            MessengerWearHelper messengerWearHelper = (MessengerWearHelper) this.f8860b.get();
            CapabilityInfo b = getCapabilityResult.b();
            if ("messenger_wear".equals(b.a())) {
                Integer.valueOf(b.b().size());
                messengerWearHelper.f2466c.edit().putBoolean(MessengerWearPrefKeys.f11148c, !b.b().isEmpty()).commit();
            }
            messengerWearHelper.m2743a(b);
            if (messengerWearHelper.m2744a()) {
                ((MessengerWearSoftAlarm) this.f8859a.get()).a();
            }
            this.f8865h.e();
            return;
        }
        BLog.b(f8857g, "Capability API call failed: %d - %s", new Object[]{Integer.valueOf(getCapabilityResult.cp_().g), getCapabilityResult.cp_().h});
    }

    public void init() {
        TriState a = ((GatekeeperStoreImpl) this.f8864f.get()).a(985);
        if (a == TriState.UNSET) {
            GatekeeperListenersImpl gatekeeperListenersImpl = (GatekeeperListenersImpl) this.f8863e.get();
            this.f8866i = gatekeeperListenersImpl;
            gatekeeperListenersImpl.a(this.f8867j, 985);
        } else if (a == TriState.NO) {
            ((FbSharedPreferences) this.f8862d.get()).edit().a(MessengerWearPrefKeys.f11148c).a(MessengerWearPrefKeys.f11147b).commit();
        } else {
            m9225a(this);
        }
    }

    public static void m9225a(MessengerWearDetectionInit messengerWearDetectionInit) {
        messengerWearDetectionInit.f8865h = new Builder((Context) messengerWearDetectionInit.f8861c.get()).a(Wearable.m).a(messengerWearDetectionInit).a(messengerWearDetectionInit).b();
        messengerWearDetectionInit.f8865h.c();
    }

    public final void m9229a(Bundle bundle) {
        Wearable.b.a(this.f8865h, "messenger_wear", 0).a(this);
    }

    public final void m9228a(int i) {
    }

    public final void m9230a(ConnectionResult connectionResult) {
        Integer.valueOf(connectionResult.c);
        String str = connectionResult.e;
    }

    private void m9226a(Provider<MessengerWearSoftAlarm> provider, Provider<MessengerWearHelper> provider2, Provider<Context> provider3, Provider<FbSharedPreferences> provider4, Provider<GatekeeperListeners> provider5, Provider<GatekeeperStore> provider6) {
        this.f8859a = provider;
        this.f8860b = provider2;
        this.f8861c = provider3;
        this.f8862d = provider4;
        this.f8863e = provider5;
        this.f8864f = provider6;
    }
}
