package com.facebook.backgroundtasks;

import com.facebook.common.init.INeedInit;
import com.facebook.inject.InjectorLike;
import java.lang.annotation.Annotation;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fillColor */
public class BackgroundTaskManager implements INeedInit {
    private static volatile BackgroundTaskManager f23699c;
    private final BackgroundTaskRunnerProvider f23700a;
    private BackgroundTaskRunner f23701b;

    public static com.facebook.backgroundtasks.BackgroundTaskManager m32118a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23699c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundtasks.BackgroundTaskManager.class;
        monitor-enter(r1);
        r0 = f23699c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m32119b(r0);	 Catch:{ all -> 0x0035 }
        f23699c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23699c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundtasks.BackgroundTaskManager.a(com.facebook.inject.InjectorLike):com.facebook.backgroundtasks.BackgroundTaskManager");
    }

    private static BackgroundTaskManager m32119b(InjectorLike injectorLike) {
        return new BackgroundTaskManager((BackgroundTaskRunnerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BackgroundTaskRunnerProvider.class));
    }

    @Inject
    public BackgroundTaskManager(BackgroundTaskRunnerProvider backgroundTaskRunnerProvider) {
        this.f23700a = backgroundTaskRunnerProvider;
    }

    public void init() {
        this.f23701b = this.f23700a.m32123a(Long.valueOf(30000), Long.valueOf(300000), Long.valueOf(86400000));
        this.f23701b.a();
    }

    public final void m32121a(Class<? extends Annotation> cls) {
        if (this.f23701b != null) {
            this.f23701b.w.put(cls, Boolean.valueOf(true));
        }
    }

    public final void m32122b(Class<? extends Annotation> cls) {
        if (this.f23701b != null) {
            this.f23701b.b(cls);
        }
    }

    public final void m32120a() {
        if (this.f23701b != null) {
            this.f23701b.b();
        }
    }
}
