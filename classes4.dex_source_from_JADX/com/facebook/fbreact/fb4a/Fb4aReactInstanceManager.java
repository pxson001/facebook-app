package com.facebook.fbreact.fb4a;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.init.INeedInit;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbreact.exceptionmanager.FbReactExceptionManager;
import com.facebook.fbreact.instance.FbReactInstanceHolder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: markImpressionLoggedParams */
public class Fb4aReactInstanceManager implements INeedInit {
    private static final String f8328a = Fb4aReactInstanceManager.class.getSimpleName();
    private static volatile Fb4aReactInstanceManager f8329n;
    private final Provider<Boolean> f8330b;
    private final Lazy<Boolean> f8331c;
    public final Lazy<Boolean> f8332d;
    public final Lazy<FbReactInstanceHolder> f8333e;
    private final Provider<String> f8334f;
    private final DefaultAppChoreographer f8335g;
    private final Lazy<AppStateManager> f8336h;
    private final BaseFbBroadcastManager f8337i;
    public final FbReactExceptionManager f8338j;
    private SelfRegistrableReceiverImpl f8339k;
    @Nullable
    public PreloadErrorReportingExceptionHandler f8340l;
    public boolean f8341m;

    /* compiled from: markImpressionLoggedParams */
    class C04842 implements ActionReceiver {
        final /* synthetic */ Fb4aReactInstanceManager f10601a;

        C04842(Fb4aReactInstanceManager fb4aReactInstanceManager) {
            this.f10601a = fb4aReactInstanceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2073619154);
            if (((Boolean) this.f10601a.f8332d.get()).booleanValue()) {
                this.f10601a.m8597a();
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1059098691, a);
        }
    }

    /* compiled from: markImpressionLoggedParams */
    class C04851 implements ActionReceiver {
        final /* synthetic */ Fb4aReactInstanceManager f10602a;

        C04851(Fb4aReactInstanceManager fb4aReactInstanceManager) {
            this.f10602a = fb4aReactInstanceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -366823070);
            if (this.f10602a.f8341m) {
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -878547585, a);
                return;
            }
            ((FbReactInstanceHolder) this.f10602a.f8333e.get()).b();
            LogUtils.e(-1592374532, a);
        }
    }

    public static com.facebook.fbreact.fb4a.Fb4aReactInstanceManager m8595a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8329n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbreact.fb4a.Fb4aReactInstanceManager.class;
        monitor-enter(r1);
        r0 = f8329n;	 Catch:{ all -> 0x003a }
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
        r0 = m8596b(r0);	 Catch:{ all -> 0x0035 }
        f8329n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8329n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbreact.fb4a.Fb4aReactInstanceManager.a(com.facebook.inject.InjectorLike):com.facebook.fbreact.fb4a.Fb4aReactInstanceManager");
    }

    private static Fb4aReactInstanceManager m8596b(InjectorLike injectorLike) {
        return new Fb4aReactInstanceManager(IdBasedProvider.a(injectorLike, 3967), IdBasedLazy.a(injectorLike, 3969), IdBasedLazy.a(injectorLike, 3970), IdBasedSingletonScopeProvider.b(injectorLike, 5782), IdBasedProvider.a(injectorLike, 4442), DefaultAppChoreographer.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 476), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), FbReactExceptionManager.m8599a(injectorLike), Fb4aReactMarkerListener.m8647a(injectorLike));
    }

    @Inject
    public Fb4aReactInstanceManager(Provider<Boolean> provider, Lazy<Boolean> lazy, Lazy<Boolean> lazy2, Lazy<FbReactInstanceHolder> lazy3, Provider<String> provider2, AppChoreographer appChoreographer, Lazy<AppStateManager> lazy4, FbBroadcastManager fbBroadcastManager, FbReactExceptionManager fbReactExceptionManager, Fb4aReactMarkerListener fb4aReactMarkerListener) {
        this.f8330b = provider;
        this.f8331c = lazy;
        this.f8332d = lazy2;
        this.f8333e = lazy3;
        this.f8334f = provider2;
        this.f8335g = appChoreographer;
        this.f8336h = lazy4;
        this.f8337i = fbBroadcastManager;
        this.f8338j = fbReactExceptionManager;
        ReactMarker.f8362a = fb4aReactMarkerListener;
    }

    public void init() {
        if (((Boolean) this.f8330b.get()).booleanValue()) {
            this.f8339k = this.f8337i.a().a(AppStateManager.b, new C04842(this)).a(AppStateManager.c, new C04851(this)).a();
            this.f8339k.b();
            if (((Boolean) this.f8331c.get()).booleanValue()) {
                m8597a();
            }
        }
    }

    public final void m8597a() {
        if (((Boolean) this.f8330b.get()).booleanValue() && this.f8334f.get() != null) {
            this.f8335g.a(f8328a + " - React Native Preload", new 3(this), Priority.APPLICATION_LOADED_LOW_PRIORITY, ThreadType.UI);
        }
    }

    public final void m8598b() {
        if (!((AppStateManager) this.f8336h.get()).j() && !((FbReactInstanceHolder) this.f8333e.get()).a()) {
            this.f8340l = new PreloadErrorReportingExceptionHandler();
            this.f8338j.m8603a(this.f8340l);
            ReactInstanceManager c = ((FbReactInstanceHolder) this.f8333e.get()).c();
            if (!c.c()) {
                c.a(new PreloadReactInstanceEventListener(this));
                c.b();
            }
        }
    }
}
