package com.facebook.sync;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager.ReceiverBuilder;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.init.INeedInit;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.gk.listeners.GatekeeperListenersImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperListeners;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.OnGatekeeperChangeListener;
import com.facebook.gk.store.internal.GatekeeperListenersImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.facebook.push.mqtt.service.ForceAutoSubscriberUpdate;
import com.facebook.sync.SyncInitializationHandler.EnsureSyncTrigger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@NotThreadSafe
/* compiled from: likers */
public class SyncInitializer implements INeedInit {
    private static final Class<?> f9344a = SyncInitializer.class;
    private static volatile SyncInitializer f9345m;
    public final Context f9346b;
    public final FbSharedPreferences f9347c;
    public final GatekeeperListenersImpl f9348d;
    public final ForceAutoSubscriberUpdate f9349e;
    private final BaseFbBroadcastManager f9350f;
    public final Set<SyncInitializationHandler> f9351g;
    public final Multimap<PrefKey, SyncInitializationHandler> f9352h = ArrayListMultimap.t();
    public final Multimap<Integer, SyncInitializationHandler> f9353i = ArrayListMultimap.t();
    public final Map<String, SyncInitializationHandler> f9354j = Maps.c();
    public ChangeListener f9355k;
    public final DefaultSyncContextChecker f9356l;

    /* compiled from: likers */
    public class ChangeListener extends OnGatekeeperChangeListener implements OnSharedPreferenceChangeListener {
        final /* synthetic */ SyncInitializer f11453a;

        public ChangeListener(SyncInitializer syncInitializer) {
            this.f11453a = syncInitializer;
        }

        public final void m11913a(GatekeeperStoreImpl gatekeeperStoreImpl, int i) {
            m11912a(this, this.f11453a.f9353i.c(Integer.valueOf(i)), EnsureSyncTrigger.GATEKEEPER_CHANGED);
        }

        public final void m11914a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            m11912a(this, this.f11453a.f9352h.c(prefKey), EnsureSyncTrigger.PREFKEY_CHANGED);
        }

        public static void m11912a(ChangeListener changeListener, Collection collection, EnsureSyncTrigger ensureSyncTrigger) {
            changeListener.f11453a.f9349e.m7772a();
            SyncInitializer.m9745a(changeListener.f11453a, collection, ensureSyncTrigger);
        }
    }

    /* compiled from: likers */
    public class C05541 implements ActionReceiver {
        final /* synthetic */ SyncInitializer f11454a;

        public C05541(SyncInitializer syncInitializer) {
            this.f11454a = syncInitializer;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1839495336);
            ChangeListener.m11912a(this.f11454a.f9355k, this.f11454a.f9351g, EnsureSyncTrigger.NORMAL);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 933203246, a);
        }
    }

    /* compiled from: likers */
    class C05562 implements ActionReceiver {
        final /* synthetic */ SyncInitializer f11463a;

        C05562(SyncInitializer syncInitializer) {
            this.f11463a = syncInitializer;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1434891524);
            if (PushStateEvent.CHANNEL_CONNECTED == PushStateEvent.fromValue(intent.getIntExtra("event", PushStateEvent.UNKNOWN.toValue()))) {
                SyncInitializer.m9745a(this.f11463a, this.f11463a.f9351g, EnsureSyncTrigger.NORMAL);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -2003846484, a);
        }
    }

    /* compiled from: likers */
    class C05573 implements ActionReceiver {
        final /* synthetic */ SyncInitializer f11464a;

        C05573(SyncInitializer syncInitializer) {
            this.f11464a = syncInitializer;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1432628875);
            if (this.f11464a.f9356l.m9750a()) {
                for (SyncInitializationHandler syncInitializationHandler : this.f11464a.f9351g) {
                    if (syncInitializationHandler.mo840a()) {
                        syncInitializationHandler.mo842b(EnsureSyncTrigger.NORMAL);
                    }
                }
                LogUtils.e(-1849508277, a);
                return;
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 157044089, a);
        }
    }

    /* compiled from: likers */
    class C05584 implements ActionReceiver {
        final /* synthetic */ SyncInitializer f11465a;

        C05584(SyncInitializer syncInitializer) {
            this.f11465a = syncInitializer;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1355551832);
            if (this.f11465a.f9356l.m9750a()) {
                SyncInitializationHandler syncInitializationHandler = (SyncInitializationHandler) this.f11465a.f9354j.get(intent.getAction());
                if (syncInitializationHandler != null && syncInitializationHandler.mo840a()) {
                    syncInitializationHandler.mo845e();
                }
                LogUtils.e(-1518442987, a);
                return;
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 838665999, a);
        }
    }

    public static com.facebook.sync.SyncInitializer m9744a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9345m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sync.SyncInitializer.class;
        monitor-enter(r1);
        r0 = f9345m;	 Catch:{ all -> 0x003a }
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
        r0 = m9746b(r0);	 Catch:{ all -> 0x0035 }
        f9345m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9345m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.SyncInitializer.a(com.facebook.inject.InjectorLike):com.facebook.sync.SyncInitializer");
    }

    private static SyncInitializer m9746b(InjectorLike injectorLike) {
        return new SyncInitializer((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GatekeeperListenersImplMethodAutoProvider.a(injectorLike), ForceAutoSubscriberUpdate.m7770a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$SyncInitializationHandler(injectorLike)), DefaultSyncContextChecker.m9749b(injectorLike));
    }

    @Inject
    public SyncInitializer(Context context, FbSharedPreferences fbSharedPreferences, GatekeeperListeners gatekeeperListeners, ForceAutoSubscriberUpdate forceAutoSubscriberUpdate, FbBroadcastManager fbBroadcastManager, Set<SyncInitializationHandler> set, SyncContextChecker syncContextChecker) {
        this.f9346b = context;
        this.f9347c = fbSharedPreferences;
        this.f9348d = gatekeeperListeners;
        this.f9349e = forceAutoSubscriberUpdate;
        this.f9350f = fbBroadcastManager;
        this.f9351g = set;
        this.f9356l = syncContextChecker;
        this.f9355k = null;
    }

    public void init() {
        for (SyncInitializationHandler syncInitializationHandler : this.f9351g) {
            int i;
            ImmutableList b = syncInitializationHandler.mo841b();
            int size = b.size();
            for (i = 0; i < size; i++) {
                this.f9352h.a((PrefKey) b.get(i), syncInitializationHandler);
            }
            b = syncInitializationHandler.mo843c();
            size = b.size();
            for (i = 0; i < size; i++) {
                this.f9353i.a(Integer.valueOf(((Integer) b.get(i)).intValue()), syncInitializationHandler);
            }
        }
        this.f9355k = new ChangeListener(this);
        this.f9347c.a(this.f9352h.p(), this.f9355k);
        this.f9348d.a(this.f9355k, Ints.a(this.f9353i.p()));
        this.f9346b.registerReceiver(new DynamicSecureBroadcastReceiver("android.intent.action.LOCALE_CHANGED", new C05541(this)), new IntentFilter("android.intent.action.LOCALE_CHANGED"));
        m9747c();
        m9748d();
        m9745a(this, this.f9351g, EnsureSyncTrigger.NORMAL);
    }

    private void m9747c() {
        this.f9350f.a().a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", new C05562(this)).a().b();
        this.f9350f.a().a(AppStateManager.b, new C05573(this)).a().b();
    }

    private void m9748d() {
        for (SyncInitializationHandler syncInitializationHandler : this.f9351g) {
            String d = syncInitializationHandler.mo844d();
            if (d != null) {
                if (this.f9354j.containsKey(d)) {
                    throw new RuntimeException("Multiple handlers for the same refresh action: " + d);
                }
                this.f9354j.put(d, syncInitializationHandler);
            }
        }
        ReceiverBuilder a = this.f9350f.a();
        C05584 c05584 = new C05584(this);
        if (!this.f9354j.isEmpty()) {
            for (String a2 : this.f9354j.keySet()) {
                a.a(a2, c05584);
            }
            a.a().b();
        }
    }

    public static void m9745a(SyncInitializer syncInitializer, Collection collection, EnsureSyncTrigger ensureSyncTrigger) {
        if (syncInitializer.f9356l.m9750a()) {
            for (SyncInitializationHandler syncInitializationHandler : collection) {
                if (syncInitializationHandler.mo840a()) {
                    syncInitializationHandler.mo839a(ensureSyncTrigger);
                }
            }
        }
    }
}
