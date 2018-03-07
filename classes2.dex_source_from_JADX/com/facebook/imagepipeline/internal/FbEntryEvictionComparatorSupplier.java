package com.facebook.imagepipeline.internal;

import com.facebook.cache.disk.DefaultEntryEvictionComparatorSupplier;
import com.facebook.cache.disk.EntryEvictionComparator;
import com.facebook.cache.disk.EntryEvictionComparatorSupplier;
import com.facebook.cache.disk.ScoreBasedEvictionComparatorSupplier;
import com.facebook.imagepipeline.abtest.ExperimentsForImagePipelineAbTestModule;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: other_fb */
public class FbEntryEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    private static volatile FbEntryEvictionComparatorSupplier f10673b;
    private final QeAccessor f10674a;

    public static com.facebook.imagepipeline.internal.FbEntryEvictionComparatorSupplier m15953a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10673b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.imagepipeline.internal.FbEntryEvictionComparatorSupplier.class;
        monitor-enter(r1);
        r0 = f10673b;	 Catch:{ all -> 0x003a }
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
        r0 = m15954b(r0);	 Catch:{ all -> 0x0035 }
        f10673b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10673b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.internal.FbEntryEvictionComparatorSupplier.a(com.facebook.inject.InjectorLike):com.facebook.imagepipeline.internal.FbEntryEvictionComparatorSupplier");
    }

    private static FbEntryEvictionComparatorSupplier m15954b(InjectorLike injectorLike) {
        return new FbEntryEvictionComparatorSupplier(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public FbEntryEvictionComparatorSupplier(QeAccessor qeAccessor) {
        this.f10674a = qeAccessor;
    }

    public final EntryEvictionComparator mo2057a() {
        if (this.f10674a.mo596a(ExperimentsForImagePipelineAbTestModule.f10699l, false)) {
            return new ScoreBasedEvictionComparatorSupplier(this.f10674a.mo571a(ExperimentsForImagePipelineAbTestModule.f10695h, 1.0f), this.f10674a.mo571a(ExperimentsForImagePipelineAbTestModule.f10701n, 0.0f)).a();
        }
        return new DefaultEntryEvictionComparatorSupplier().mo2057a();
    }
}
