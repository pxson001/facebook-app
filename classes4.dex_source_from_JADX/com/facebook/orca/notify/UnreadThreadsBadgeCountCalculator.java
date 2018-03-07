package com.facebook.orca.notify;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: logger_instance_key */
public class UnreadThreadsBadgeCountCalculator implements INeedInit {
    public static final String f8932a = UnreadThreadsBadgeCountCalculator.class.getSimpleName();
    private static volatile UnreadThreadsBadgeCountCalculator f8933i;
    private final GatekeeperStoreImpl f8934b;
    public final ListeningScheduledExecutorService f8935c;
    private final BaseFbBroadcastManager f8936d;
    public final DefaultBlueServiceOperationFactory f8937e;
    public final MessagesBroadcaster f8938f;
    public final NotificationSettingsUtil f8939g;
    private ListenableFuture f8940h = null;

    /* compiled from: logger_instance_key */
    class C05361 implements ActionReceiver {
        final /* synthetic */ UnreadThreadsBadgeCountCalculator f11157a;

        C05361(UnreadThreadsBadgeCountCalculator unreadThreadsBadgeCountCalculator) {
            this.f11157a = unreadThreadsBadgeCountCalculator;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 201044291);
            UnreadThreadsBadgeCountCalculator.m9288b(this.f11157a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 31625484, a);
        }
    }

    public static com.facebook.orca.notify.UnreadThreadsBadgeCountCalculator m9286a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8933i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.notify.UnreadThreadsBadgeCountCalculator.class;
        monitor-enter(r1);
        r0 = f8933i;	 Catch:{ all -> 0x003a }
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
        r0 = m9287b(r0);	 Catch:{ all -> 0x0035 }
        f8933i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8933i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.UnreadThreadsBadgeCountCalculator.a(com.facebook.inject.InjectorLike):com.facebook.orca.notify.UnreadThreadsBadgeCountCalculator");
    }

    private static UnreadThreadsBadgeCountCalculator m9287b(InjectorLike injectorLike) {
        return new UnreadThreadsBadgeCountCalculator(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), MessagesBroadcaster.a(injectorLike), NotificationSettingsUtil.m9290b(injectorLike));
    }

    @Inject
    public UnreadThreadsBadgeCountCalculator(GatekeeperStoreImpl gatekeeperStoreImpl, ListeningScheduledExecutorService listeningScheduledExecutorService, BaseFbBroadcastManager baseFbBroadcastManager, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, MessagesBroadcaster messagesBroadcaster, NotificationSettingsUtil notificationSettingsUtil) {
        this.f8934b = gatekeeperStoreImpl;
        this.f8935c = listeningScheduledExecutorService;
        this.f8936d = baseFbBroadcastManager;
        this.f8937e = defaultBlueServiceOperationFactory;
        this.f8938f = messagesBroadcaster;
        this.f8939g = notificationSettingsUtil;
    }

    public void init() {
        C05361 c05361 = new C05361(this);
        this.f8936d.a().a(AppStateManager.c, c05361).a(MessagesBroadcastIntents.o, c05361).a().b();
        m9288b(this);
    }

    public static synchronized void m9288b(UnreadThreadsBadgeCountCalculator unreadThreadsBadgeCountCalculator) {
        synchronized (unreadThreadsBadgeCountCalculator) {
            if (unreadThreadsBadgeCountCalculator.f8934b.a(165, false)) {
                if (unreadThreadsBadgeCountCalculator.f8940h != null) {
                    unreadThreadsBadgeCountCalculator.f8940h.cancel(false);
                }
                unreadThreadsBadgeCountCalculator.f8940h = unreadThreadsBadgeCountCalculator.f8935c.a(new 2(unreadThreadsBadgeCountCalculator), 1, TimeUnit.SECONDS);
            }
        }
    }
}
