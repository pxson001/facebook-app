package com.facebook.apptab.state.abtest;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache.QuickExperimentMemoryCacheObserver;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.apptab.state.NavigationImmersiveConfig;
import com.facebook.apptab.state.NavigationMemoryConfig;
import com.facebook.apptab.state.TabBarStateManager;
import com.facebook.base.broadcast.BackgroundBroadcastThread;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.init.INeedInit;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messages.ACTION_CLEAR_MESSAGE */
public class NavigationExperimentSyncer implements INeedInit {
    private static volatile NavigationExperimentSyncer f8089i;
    public final TabBarStateManager f8090a;
    public final NavImmersiveExperiment f8091b;
    public final NavMemoryExperiment f8092c;
    public final QuickExperimentController f8093d;
    private final QuickExperimentMemoryCache f8094e;
    private final QuickExperimentMemoryCacheObserver f8095f = new C03941(this);
    @BackgroundBroadcastThread
    private final Handler f8096g;
    private final SelfRegistrableReceiverImpl f8097h;

    /* compiled from: messages.ACTION_CLEAR_MESSAGE */
    class C03941 implements QuickExperimentMemoryCacheObserver {
        final /* synthetic */ NavigationExperimentSyncer f8102a;

        C03941(NavigationExperimentSyncer navigationExperimentSyncer) {
            this.f8102a = navigationExperimentSyncer;
        }

        public final void m8385b() {
            this.f8102a.f8090a.a((NavigationImmersiveConfig) this.f8102a.f8093d.a(this.f8102a.f8091b));
            this.f8102a.f8090a.a((NavigationMemoryConfig) this.f8102a.f8093d.a(this.f8102a.f8092c));
        }

        public final void m8386c() {
        }
    }

    /* compiled from: messages.ACTION_CLEAR_MESSAGE */
    class C03952 implements ActionReceiver {
        final /* synthetic */ NavigationExperimentSyncer f8103a;

        C03952(NavigationExperimentSyncer navigationExperimentSyncer) {
            this.f8103a = navigationExperimentSyncer;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1839171313);
            if (this.f8103a.f8090a.b().equals(this.f8103a.f8093d.a(this.f8103a.f8091b))) {
                this.f8103a.f8093d.b(this.f8103a.f8091b);
            }
            if (this.f8103a.f8090a.c().equals(this.f8103a.f8093d.a(this.f8103a.f8092c))) {
                this.f8103a.f8093d.b(this.f8103a.f8092c);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -844080497, a);
        }
    }

    public static com.facebook.apptab.state.abtest.NavigationExperimentSyncer m8375a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8089i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.apptab.state.abtest.NavigationExperimentSyncer.class;
        monitor-enter(r1);
        r0 = f8089i;	 Catch:{ all -> 0x003a }
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
        r0 = m8376b(r0);	 Catch:{ all -> 0x0035 }
        f8089i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8089i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.apptab.state.abtest.NavigationExperimentSyncer.a(com.facebook.inject.InjectorLike):com.facebook.apptab.state.abtest.NavigationExperimentSyncer");
    }

    private static NavigationExperimentSyncer m8376b(InjectorLike injectorLike) {
        return new NavigationExperimentSyncer(TabBarStateManager.a(injectorLike), NavImmersiveExperiment.m8377a(injectorLike), NavMemoryExperiment.m8381a(injectorLike), (QuickExperimentController) QuickExperimentControllerImpl.a(injectorLike), (QuickExperimentMemoryCache) QuickExperimentMemoryCacheImpl.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), Handler_BackgroundBroadcastThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NavigationExperimentSyncer(TabBarStateManager tabBarStateManager, NavImmersiveExperiment navImmersiveExperiment, NavMemoryExperiment navMemoryExperiment, QuickExperimentController quickExperimentController, QuickExperimentMemoryCache quickExperimentMemoryCache, BaseFbBroadcastManager baseFbBroadcastManager, Handler handler) {
        this.f8090a = tabBarStateManager;
        this.f8091b = navImmersiveExperiment;
        this.f8092c = navMemoryExperiment;
        this.f8093d = quickExperimentController;
        this.f8094e = quickExperimentMemoryCache;
        this.f8096g = handler;
        this.f8097h = baseFbBroadcastManager.a().a(AppStateManager.b, new C03952(this)).a(this.f8096g).a();
    }

    public void init() {
        this.f8097h.b();
        this.f8094e.a(this.f8095f);
    }
}
