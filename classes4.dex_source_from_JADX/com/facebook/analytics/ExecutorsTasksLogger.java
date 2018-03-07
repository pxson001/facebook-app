package com.facebook.analytics;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.ConstrainedExecutorsStatusController;
import com.facebook.common.init.INeedInit;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messenger_image_pipeline_wrapper */
public class ExecutorsTasksLogger implements INeedInit {
    private static volatile ExecutorsTasksLogger f7980d;
    public final FbNetworkManager f7981a;
    public final AnalyticsLogger f7982b;
    private final ConstrainedExecutorsStatusController f7983c;

    /* compiled from: messenger_image_pipeline_wrapper */
    public class C04361 {
        final /* synthetic */ ExecutorsTasksLogger f9758a;

        public C04361(ExecutorsTasksLogger executorsTasksLogger) {
            this.f9758a = executorsTasksLogger;
        }

        public final void m10165a(String str, int i, String str2, long j, boolean z, int i2) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("android_constrained_executor_task");
            honeyClientEvent.b("executor_name", str).b("task_name", str2).a("executor_concurrency", i).a("duration_ms", j).a("success", z).a("queue_size", i2).b("network_type", this.f9758a.f7981a.k()).b("network_subtype", this.f9758a.f7981a.l());
            this.f9758a.f7982b.a(honeyClientEvent);
        }
    }

    public static com.facebook.analytics.ExecutorsTasksLogger m8310a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7980d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.ExecutorsTasksLogger.class;
        monitor-enter(r1);
        r0 = f7980d;	 Catch:{ all -> 0x003a }
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
        r0 = m8311b(r0);	 Catch:{ all -> 0x0035 }
        f7980d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7980d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.ExecutorsTasksLogger.a(com.facebook.inject.InjectorLike):com.facebook.analytics.ExecutorsTasksLogger");
    }

    private static ExecutorsTasksLogger m8311b(InjectorLike injectorLike) {
        return new ExecutorsTasksLogger(FbNetworkManager.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ConstrainedExecutorsStatusController.a(injectorLike));
    }

    @Inject
    public ExecutorsTasksLogger(FbNetworkManager fbNetworkManager, AnalyticsLogger analyticsLogger, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        this.f7981a = fbNetworkManager;
        this.f7982b = analyticsLogger;
        this.f7983c = constrainedExecutorsStatusController;
    }

    public void init() {
        ConstrainedExecutorsStatusController constrainedExecutorsStatusController = this.f7983c;
        constrainedExecutorsStatusController.a.add(new C04361(this));
    }
}
