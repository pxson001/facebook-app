package com.facebook.search.bootstrap;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.bootstrap.db.data.BootstrapDbInsertHelper;
import com.facebook.search.bootstrap.model.BootstrapEntity;
import com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader;
import com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader.BootstrapEntitySource;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: extra_hasfailed_retrymightwork */
public class PendingBootstrapEntitiesManager {
    private static volatile PendingBootstrapEntitiesManager f15571g;
    private final ExecutorService f15572a;
    private final Lazy<BootstrapEntitiesLoader> f15573b;
    public final Lazy<BootstrapDbInsertHelper> f15574c;
    public final GraphSearchErrorReporter f15575d;
    public final Set<Long> f15576e = Sets.a();
    private final Set<BootstrapEntity> f15577f = Sets.a();

    /* compiled from: extra_hasfailed_retrymightwork */
    public class C11081 implements ActionReceiver {
        final /* synthetic */ PendingBootstrapEntitiesManager f15568a;

        public C11081(PendingBootstrapEntitiesManager pendingBootstrapEntitiesManager) {
            this.f15568a = pendingBootstrapEntitiesManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1375795267);
            PendingBootstrapEntitiesManager.m23183a(this.f15568a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1045603920, a);
        }
    }

    public static com.facebook.search.bootstrap.PendingBootstrapEntitiesManager m23182a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15571g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.bootstrap.PendingBootstrapEntitiesManager.class;
        monitor-enter(r1);
        r0 = f15571g;	 Catch:{ all -> 0x003a }
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
        r0 = m23184b(r0);	 Catch:{ all -> 0x0035 }
        f15571g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15571g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.bootstrap.PendingBootstrapEntitiesManager.a(com.facebook.inject.InjectorLike):com.facebook.search.bootstrap.PendingBootstrapEntitiesManager");
    }

    private static PendingBootstrapEntitiesManager m23184b(InjectorLike injectorLike) {
        return new PendingBootstrapEntitiesManager((ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10475), IdBasedSingletonScopeProvider.b(injectorLike, 10466), GraphSearchErrorReporter.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike));
    }

    @Inject
    public PendingBootstrapEntitiesManager(ExecutorService executorService, Lazy<BootstrapEntitiesLoader> lazy, Lazy<BootstrapDbInsertHelper> lazy2, GraphSearchErrorReporter graphSearchErrorReporter, FbBroadcastManager fbBroadcastManager) {
        this.f15572a = executorService;
        this.f15573b = lazy;
        this.f15574c = lazy2;
        this.f15575d = graphSearchErrorReporter;
        fbBroadcastManager.a().a(AppStateManager.c, new C11081(this)).a().b();
    }

    public final void m23185a(BootstrapEntity bootstrapEntity) {
        this.f15577f.add(bootstrapEntity);
    }

    public static synchronized void m23183a(PendingBootstrapEntitiesManager pendingBootstrapEntitiesManager) {
        synchronized (pendingBootstrapEntitiesManager) {
            if (!pendingBootstrapEntitiesManager.f15576e.isEmpty()) {
                ((BootstrapEntitiesLoader) pendingBootstrapEntitiesManager.f15573b.get()).m23466a(ImmutableList.copyOf(pendingBootstrapEntitiesManager.f15576e), BootstrapEntitySource.PROFILE_VIEW);
                pendingBootstrapEntitiesManager.f15576e.clear();
            }
            if (!pendingBootstrapEntitiesManager.f15577f.isEmpty()) {
                final ImmutableList copyOf = ImmutableList.copyOf(pendingBootstrapEntitiesManager.f15577f);
                ExecutorDetour.a(pendingBootstrapEntitiesManager.f15572a, new Runnable(pendingBootstrapEntitiesManager) {
                    final /* synthetic */ PendingBootstrapEntitiesManager f15570b;

                    public void run() {
                        try {
                            ((BootstrapDbInsertHelper) this.f15570b.f15574c.get()).m23406a(copyOf);
                        } catch (Throwable e) {
                            this.f15570b.f15575d.a(GraphSearchError.INSERT_DB_BOOTSTRAP_ENTITY_FAIL, "Failed to insert locally", e);
                        }
                    }
                }, -328578479);
                pendingBootstrapEntitiesManager.f15577f.clear();
            }
        }
    }
}
