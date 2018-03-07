package com.facebook.orca.notify;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.init.INeedInit;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.launcherbadges.LauncherBadgesController;
import com.facebook.launcherbadges.LauncherBadgesManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: loggingEnabled */
public class MessengerLauncherBadgesController implements INeedInit {
    private static volatile MessengerLauncherBadgesController f8925g;
    private final GatekeeperStoreImpl f8926a;
    private final FbSharedPreferences f8927b;
    private final BaseFbBroadcastManager f8928c;
    private final LauncherBadgesManager f8929d;
    private final Provider<Boolean> f8930e;
    private final Product f8931f;

    /* compiled from: loggingEnabled */
    class C05351 implements ActionReceiver {
        final /* synthetic */ MessengerLauncherBadgesController f11156a;

        C05351(MessengerLauncherBadgesController messengerLauncherBadgesController) {
            this.f11156a = messengerLauncherBadgesController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 65631615);
            MessengerLauncherBadgesController.m9282a(this.f11156a, intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1293484365, a);
        }
    }

    public static com.facebook.orca.notify.MessengerLauncherBadgesController m9281a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8925g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.notify.MessengerLauncherBadgesController.class;
        monitor-enter(r1);
        r0 = f8925g;	 Catch:{ all -> 0x003a }
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
        r0 = m9283b(r0);	 Catch:{ all -> 0x0035 }
        f8925g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8925g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.MessengerLauncherBadgesController.a(com.facebook.inject.InjectorLike):com.facebook.orca.notify.MessengerLauncherBadgesController");
    }

    private static MessengerLauncherBadgesController m9283b(InjectorLike injectorLike) {
        return new MessengerLauncherBadgesController(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), LauncherBadgesManager.m8676a(injectorLike), IdBasedProvider.a(injectorLike, 4069), ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public MessengerLauncherBadgesController(GatekeeperStore gatekeeperStore, FbSharedPreferences fbSharedPreferences, FbBroadcastManager fbBroadcastManager, LauncherBadgesController launcherBadgesController, Provider<Boolean> provider, Product product) {
        this.f8926a = gatekeeperStore;
        this.f8927b = fbSharedPreferences;
        this.f8928c = fbBroadcastManager;
        this.f8929d = launcherBadgesController;
        this.f8930e = provider;
        this.f8931f = product;
    }

    public void init() {
        this.f8928c.a().a(MessagesBroadcastIntents.n, new C05351(this)).a().b();
    }

    private Source m9280a() {
        if (!((Boolean) this.f8930e.get()).booleanValue()) {
            return Source.None;
        }
        if (this.f8926a.a(165, false)) {
            return Source.UnreadThreadsOnClient;
        }
        return Source.UnseenThreads;
    }

    public final void m9285a(int i) {
        if (m9280a() == Source.UnseenThreads) {
            m9284b(i);
        }
    }

    public static synchronized void m9282a(MessengerLauncherBadgesController messengerLauncherBadgesController, Intent intent) {
        synchronized (messengerLauncherBadgesController) {
            if (messengerLauncherBadgesController.m9280a() == Source.UnreadThreadsOnClient) {
                messengerLauncherBadgesController.m9284b(intent.getIntExtra("EXTRA_BADGE_COUNT", 0));
            }
        }
    }

    private synchronized void m9284b(int i) {
        if (((Boolean) this.f8930e.get()).booleanValue()) {
            this.f8929d.m8678a(i);
            this.f8927b.edit().a(MessagingPrefKeys.l, i).commit();
        } else if (this.f8931f == Product.MESSENGER && this.f8927b.a(MessagingPrefKeys.l)) {
            this.f8929d.m8678a(0);
            this.f8927b.edit().a(MessagingPrefKeys.l).commit();
        }
    }
}
