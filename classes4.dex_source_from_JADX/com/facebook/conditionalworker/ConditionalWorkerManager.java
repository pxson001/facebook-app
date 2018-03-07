package com.facebook.conditionalworker;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.base.broadcast.BackgroundBroadcastThread;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.C0398xee77ff78;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.common.hardware.BatteryStateManager$BatteryChangeListener;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: syncSuccess */
public class ConditionalWorkerManager extends AbstractAuthComponent implements BatteryStateManager$BatteryChangeListener, INeedInit {
    private static final Class<?> f8195a = ConditionalWorkerManager.class;
    private static volatile ConditionalWorkerManager f8196l;
    private final Context f8197b;
    public final NetworkStateManager f8198c;
    public final SystemBatteryStateManager f8199d;
    public final BaseFbBroadcastManager f8200e;
    public final ScheduledExecutorService f8201f;
    @BackgroundBroadcastThread
    public final Handler f8202g;
    private final DefaultProcessIdleExecutor f8203h;
    private final Intent f8204i;
    public final Runnable f8205j = new NamedRunnable(this, f8195a, "StartingServiceRunnable") {
        final /* synthetic */ ConditionalWorkerManager f8224c;

        public void run() {
            ConditionalWorkerManager.m8494n(this.f8224c);
        }
    };
    public volatile ScheduledFuture<?> f8206k;

    /* compiled from: syncSuccess */
    class C00812 implements Runnable {
        final /* synthetic */ ConditionalWorkerManager f1510a;

        C00812(ConditionalWorkerManager conditionalWorkerManager) {
            this.f1510a = conditionalWorkerManager;
        }

        public void run() {
            ConditionalWorkerManager.m8494n(this.f1510a);
        }
    }

    /* compiled from: syncSuccess */
    public class C04574 implements ActionReceiver {
        final /* synthetic */ ConditionalWorkerManager f10089a;

        public C04574(ConditionalWorkerManager conditionalWorkerManager) {
            this.f10089a = conditionalWorkerManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1435530455);
            ConditionalWorkerManager.m8494n(this.f10089a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -2090889373, a);
        }
    }

    /* compiled from: syncSuccess */
    public class C04583 implements ActionReceiver {
        final /* synthetic */ ConditionalWorkerManager f10090a;

        public C04583(ConditionalWorkerManager conditionalWorkerManager) {
            this.f10090a = conditionalWorkerManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 945374105);
            ConditionalWorkerManager.m8494n(this.f10090a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -915561039, a);
        }
    }

    public static com.facebook.conditionalworker.ConditionalWorkerManager m8492a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8196l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.conditionalworker.ConditionalWorkerManager.class;
        monitor-enter(r1);
        r0 = f8196l;	 Catch:{ all -> 0x003a }
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
        r0 = m8493b(r0);	 Catch:{ all -> 0x0035 }
        f8196l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8196l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.conditionalworker.ConditionalWorkerManager.a(com.facebook.inject.InjectorLike):com.facebook.conditionalworker.ConditionalWorkerManager");
    }

    private static ConditionalWorkerManager m8493b(InjectorLike injectorLike) {
        return new ConditionalWorkerManager((Context) injectorLike.getInstance(Context.class), NetworkStateManager.m8499a(injectorLike), SystemBatteryStateManager.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (ScheduledExecutorService) C0398xee77ff78.m8506a(injectorLike), Handler_BackgroundBroadcastThreadMethodAutoProvider.a(injectorLike), IdleExecutor_DefaultIdleExecutorMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ConditionalWorkerManager(Context context, NetworkStateManager networkStateManager, SystemBatteryStateManager systemBatteryStateManager, BaseFbBroadcastManager baseFbBroadcastManager, ScheduledExecutorService scheduledExecutorService, Handler handler, DefaultProcessIdleExecutor defaultProcessIdleExecutor) {
        this.f8197b = context;
        this.f8198c = networkStateManager;
        this.f8199d = systemBatteryStateManager;
        this.f8200e = baseFbBroadcastManager;
        this.f8201f = scheduledExecutorService;
        this.f8202g = handler;
        this.f8204i = new Intent(this.f8197b, ConditionalWorkerService.class);
        this.f8203h = defaultProcessIdleExecutor;
    }

    public final void m8496a(@Nullable AuthenticationResult authenticationResult) {
        ExecutorDetour.a(this.f8203h, new C00812(this), 1996156504);
    }

    public final void m8497g() {
        m8494n(this);
    }

    public final void mo671a(Intent intent) {
        m8494n(this);
    }

    public void init() {
        this.f8200e.a().a(AppStateManager.b, new C04574(this)).a(AppStateManager.c, new C04583(this)).a(this.f8202g).a().b();
        this.f8198c.m8505a(this);
        this.f8199d.a(this);
        m8494n(this);
    }

    public static void m8494n(ConditionalWorkerManager conditionalWorkerManager) {
        try {
            conditionalWorkerManager.f8197b.startService(conditionalWorkerManager.f8204i);
        } catch (SecurityException e) {
        }
    }
}
