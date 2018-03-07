package com.facebook.imagepipeline.internal;

import com.facebook.common.executors.C0447x2dfc81a;
import com.facebook.common.executors.C0452xa2c83932;
import com.facebook.common.executors.C0453x8aad3da;
import com.facebook.common.executors.C0454xad4e5f1e;
import com.facebook.common.executors.ImageCacheRequestExecutor;
import com.facebook.common.executors.PrioritizedExecutorService;
import com.facebook.common.executors.PrioritizedExecutorService.TaskPriority;
import com.facebook.imagepipeline.abtest.ExperimentsForImagePipelineAbTestModule;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: page/%s/album_list */
public class FbExecutorSupplier implements ExecutorSupplier {
    static final TaskPriority f10600a = TaskPriority.NORMAL;
    static final TaskPriority f10601b = TaskPriority.HIGH;
    private static volatile FbExecutorSupplier f10602i;
    private final QeAccessor f10603c;
    private final Executor f10604d;
    private final Executor f10605e;
    private final Executor f10606f;
    private final ListeningExecutorService f10607g;
    private final ListeningExecutorService f10608h;

    public static com.facebook.imagepipeline.internal.FbExecutorSupplier m15788a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10602i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.imagepipeline.internal.FbExecutorSupplier.class;
        monitor-enter(r1);
        r0 = f10602i;	 Catch:{ all -> 0x003a }
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
        r0 = m15790b(r0);	 Catch:{ all -> 0x0035 }
        f10602i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10602i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.internal.FbExecutorSupplier.a(com.facebook.inject.InjectorLike):com.facebook.imagepipeline.internal.FbExecutorSupplier");
    }

    private static FbExecutorSupplier m15790b(InjectorLike injectorLike) {
        return new FbExecutorSupplier(C0447x2dfc81a.m15801a(injectorLike), C0452xa2c83932.m15809a(injectorLike), C0453x8aad3da.m15811a(injectorLike), C0454xad4e5f1e.m15813a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public FbExecutorSupplier(@ImageCacheRequestExecutor PrioritizedExecutorService prioritizedExecutorService, ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2, ListeningExecutorService listeningExecutorService3, QeAccessor qeAccessor) {
        this.f10604d = prioritizedExecutorService.mo2027a(f10601b);
        this.f10605e = prioritizedExecutorService.mo2027a(f10600a);
        this.f10606f = listeningExecutorService;
        this.f10607g = listeningExecutorService2;
        this.f10608h = listeningExecutorService3;
        this.f10603c = qeAccessor;
    }

    public final Executor mo2022a() {
        return m15789a(this.f10604d, this.f10603c.mo572a(ExperimentsForImagePipelineAbTestModule.f10693f, Integer.MIN_VALUE));
    }

    public final Executor mo2023b() {
        return m15789a(this.f10605e, this.f10603c.mo572a(ExperimentsForImagePipelineAbTestModule.f10694g, Integer.MIN_VALUE));
    }

    public final Executor mo2024c() {
        return m15789a(this.f10606f, this.f10603c.mo572a(ExperimentsForImagePipelineAbTestModule.f10691d, Integer.MIN_VALUE));
    }

    public final Executor mo2025d() {
        return m15789a(this.f10607g, this.f10603c.mo572a(ExperimentsForImagePipelineAbTestModule.f10690c, Integer.MIN_VALUE));
    }

    public final Executor mo2026e() {
        return m15789a(this.f10608h, this.f10603c.mo572a(ExperimentsForImagePipelineAbTestModule.f10692e, Integer.MIN_VALUE));
    }

    private static Executor m15789a(Executor executor, int i) {
        return i == Integer.MIN_VALUE ? executor : new PriorityOverridingExecutor(executor, i);
    }
}
