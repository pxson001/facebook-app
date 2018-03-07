package com.facebook.search.suggestions.nullstate.mutator;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ScopedSearchStyle;
import com.facebook.search.suggestions.nullstate.DefaultSearchNullStateListSupplier;
import com.facebook.search.suggestions.nullstate.NullStateSupplier;
import com.facebook.search.suggestions.nullstate.ScopedNullStateSupplier;
import com.facebook.search.suggestions.nullstate.TabbedSearchNullStateListSupplier;
import com.facebook.search.suggestions.nullstate.VideoScopedNullStateSupplier;
import com.facebook.search.util.GraphSearchConfig;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: waitingToCreateThreadId */
public class NullStateSupplierFactory {
    private static volatile NullStateSupplierFactory f233f;
    private final GraphSearchConfig f234a;
    private final Lazy<DefaultSearchNullStateListSupplier> f235b;
    private final Lazy<TabbedSearchNullStateListSupplier> f236c;
    private final Lazy<ScopedNullStateSupplier> f237d;
    private final Lazy<VideoScopedNullStateSupplier> f238e;

    public static com.facebook.search.suggestions.nullstate.mutator.NullStateSupplierFactory m357a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f233f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.mutator.NullStateSupplierFactory.class;
        monitor-enter(r1);
        r0 = f233f;	 Catch:{ all -> 0x003a }
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
        r0 = m358b(r0);	 Catch:{ all -> 0x0035 }
        f233f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f233f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.mutator.NullStateSupplierFactory.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.mutator.NullStateSupplierFactory");
    }

    private static NullStateSupplierFactory m358b(InjectorLike injectorLike) {
        return new NullStateSupplierFactory(GraphSearchConfig.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10855), IdBasedLazy.a(injectorLike, 10860), IdBasedLazy.a(injectorLike, 10859), IdBasedSingletonScopeProvider.b(injectorLike, 3402));
    }

    @Inject
    public NullStateSupplierFactory(GraphSearchConfig graphSearchConfig, Lazy<DefaultSearchNullStateListSupplier> lazy, Lazy<TabbedSearchNullStateListSupplier> lazy2, Lazy<ScopedNullStateSupplier> lazy3, Lazy<VideoScopedNullStateSupplier> lazy4) {
        this.f234a = graphSearchConfig;
        this.f235b = lazy;
        this.f236c = lazy2;
        this.f237d = lazy3;
        this.f238e = lazy4;
    }

    public final NullStateSupplier m359a(GraphSearchQuery graphSearchQuery) {
        if (GraphSearchConfig.b(graphSearchQuery)) {
            return (NullStateSupplier) this.f238e.get();
        }
        if (this.f234a.e(graphSearchQuery)) {
            return (NullStateSupplier) this.f237d.get();
        }
        Object obj;
        if (graphSearchQuery == null || graphSearchQuery.i != ScopedSearchStyle.TAB || graphSearchQuery.j) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return (NullStateSupplier) this.f236c.get();
        }
        return (NullStateSupplier) this.f235b.get();
    }
}
