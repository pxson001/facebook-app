package com.facebook.oxygen.preloads.integration.tosacceptance;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkPresence;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkPresenceMethodAutoProvider;
import com.facebook.oxygen.preloads.sdk.firstparty.settings.AppmanagerRemoteException;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: logEligibilityWaterfall */
public class TosAcceptedListener implements INeedInit, ActionReceiver, Runnable {
    private static volatile TosAcceptedListener f9024g;
    private final LoggedInUserSessionManager f9025a;
    private final Context f9026b;
    private final ExecutorService f9027c;
    private final BaseFbBroadcastManager f9028d;
    private final AbstractFbErrorReporter f9029e;
    private final PreloadSdkPresence f9030f;

    public static com.facebook.oxygen.preloads.integration.tosacceptance.TosAcceptedListener m9370a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9024g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.oxygen.preloads.integration.tosacceptance.TosAcceptedListener.class;
        monitor-enter(r1);
        r0 = f9024g;	 Catch:{ all -> 0x003a }
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
        r0 = m9371b(r0);	 Catch:{ all -> 0x0035 }
        f9024g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9024g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.oxygen.preloads.integration.tosacceptance.TosAcceptedListener.a(com.facebook.inject.InjectorLike):com.facebook.oxygen.preloads.integration.tosacceptance.TosAcceptedListener");
    }

    private static TosAcceptedListener m9371b(InjectorLike injectorLike) {
        return new TosAcceptedListener(LoggedInUserSessionManager.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PreloadSdkPresenceMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public TosAcceptedListener(LoggedInUserSessionManager loggedInUserSessionManager, Context context, ExecutorService executorService, BaseFbBroadcastManager baseFbBroadcastManager, AbstractFbErrorReporter abstractFbErrorReporter, PreloadSdkPresence preloadSdkPresence) {
        this.f9025a = loggedInUserSessionManager;
        this.f9026b = context;
        this.f9027c = executorService;
        this.f9028d = baseFbBroadcastManager;
        this.f9029e = abstractFbErrorReporter;
        this.f9030f = preloadSdkPresence;
    }

    public void init() {
        if (this.f9025a.a() != null) {
            ExecutorDetour.a(this.f9027c, this, 932558434);
        } else {
            this.f9028d.a().a("com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE", this).a().b();
        }
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1811748577);
        ExecutorDetour.a(this.f9027c, this, 138924816);
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1505487967, a);
    }

    public void run() {
        Log.i("TOSACCEPTANCE", "Running setter");
        if (this.f9030f.a(2)) {
            try {
                TosAcceptedSetter.a(this.f9026b);
            } catch (AppmanagerRemoteException e) {
                this.f9029e.b(TosAcceptedSetter.class.getName(), "Unable to push ToS accepted setting to appmanager", e);
            }
        }
    }
}
