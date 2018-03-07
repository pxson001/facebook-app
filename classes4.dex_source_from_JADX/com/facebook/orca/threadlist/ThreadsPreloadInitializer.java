package com.facebook.orca.threadlist;

import android.os.Bundle;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.common.android.FbLocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListParamsBuilder;
import com.facebook.orca.background.FetchThreadsIntoMemoryCacheBackgroundTask;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: logged_out_remotely */
public class ThreadsPreloadInitializer implements INeedInit {
    private static volatile ThreadsPreloadInitializer f8946g;
    private final DefaultBlueServiceOperationFactory f8947a;
    public final FetchThreadsIntoMemoryCacheBackgroundTask f8948b;
    public final FbLocalBroadcastManager f8949c;
    private final Provider<Boolean> f8950d;
    private final Executor f8951e;
    public final FbSharedPreferences f8952f;

    public static com.facebook.orca.threadlist.ThreadsPreloadInitializer m9295a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8946g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.threadlist.ThreadsPreloadInitializer.class;
        monitor-enter(r1);
        r0 = f8946g;	 Catch:{ all -> 0x003a }
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
        r0 = m9296b(r0);	 Catch:{ all -> 0x0035 }
        f8946g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8946g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadlist.ThreadsPreloadInitializer.a(com.facebook.inject.InjectorLike):com.facebook.orca.threadlist.ThreadsPreloadInitializer");
    }

    private static ThreadsPreloadInitializer m9296b(InjectorLike injectorLike) {
        return new ThreadsPreloadInitializer(DefaultBlueServiceOperationFactory.b(injectorLike), FetchThreadsIntoMemoryCacheBackgroundTask.m9298a(injectorLike), FbLocalBroadcastManagerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4096), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public ThreadsPreloadInitializer(BlueServiceOperationFactory blueServiceOperationFactory, FetchThreadsIntoMemoryCacheBackgroundTask fetchThreadsIntoMemoryCacheBackgroundTask, FbLocalBroadcastManager fbLocalBroadcastManager, Provider<Boolean> provider, Executor executor, FbSharedPreferences fbSharedPreferences) {
        this.f8947a = blueServiceOperationFactory;
        this.f8948b = fetchThreadsIntoMemoryCacheBackgroundTask;
        this.f8949c = fbLocalBroadcastManager;
        this.f8950d = provider;
        this.f8951e = executor;
        this.f8952f = fbSharedPreferences;
    }

    public void init() {
        if (((Boolean) this.f8950d.get()).booleanValue()) {
            FetchThreadListParamsBuilder newBuilder = FetchThreadListParams.newBuilder();
            newBuilder.a = DataFreshnessParam.DO_NOT_CHECK_SERVER;
            newBuilder = newBuilder;
            newBuilder.b = FolderName.INBOX;
            FetchThreadListParams h = newBuilder.h();
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchThreadListParams", h);
            Futures.a(BlueServiceOperationFactoryDetour.a(this.f8947a, "fetch_thread_list", bundle, CallerContext.a(ThreadsPreloadInitializer.class), 231851608).a(), new 1(this), this.f8951e);
        }
    }
}
