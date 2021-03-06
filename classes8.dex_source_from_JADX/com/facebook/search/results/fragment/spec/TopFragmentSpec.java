package com.facebook.search.results.fragment.spec;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.results.fragment.GraphSearchResultFragment;
import com.facebook.search.results.fragment.SearchResultsBaseFragment;
import com.facebook.search.results.fragment.SearchResultsFragment;
import com.facebook.search.results.fragment.feed.SearchResultsFeedFragment;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SECONDS_SINCE_MESSAGE_RECEIVED */
public class TopFragmentSpec extends AbstractFragmentSpec<SearchResultsBaseFragment> {
    private static volatile TopFragmentSpec f23163b;
    private final GatekeeperStoreImpl f23164a;

    public static com.facebook.search.results.fragment.spec.TopFragmentSpec m26860a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23163b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.results.fragment.spec.TopFragmentSpec.class;
        monitor-enter(r1);
        r0 = f23163b;	 Catch:{ all -> 0x003a }
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
        r0 = m26861b(r0);	 Catch:{ all -> 0x0035 }
        f23163b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23163b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.fragment.spec.TopFragmentSpec.a(com.facebook.inject.InjectorLike):com.facebook.search.results.fragment.spec.TopFragmentSpec");
    }

    private static TopFragmentSpec m26861b(InjectorLike injectorLike) {
        return new TopFragmentSpec(ResourcesMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TopFragmentSpec(Resources resources, GatekeeperStoreImpl gatekeeperStoreImpl, QeAccessor qeAccessor) {
        super(resources, GraphQLGraphSearchResultsDisplayStyle.BLENDED, 2131237481, qeAccessor.a(ExperimentsForSearchAbTestModule.l, false));
        this.f23164a = gatekeeperStoreImpl;
    }

    public final GraphSearchResultFragment mo1308c() {
        return this.f23164a.a(SearchAbTestGatekeepers.h, false) ? SearchResultsFragment.m26590a("graph_search_results_page_blended") : SearchResultsFeedFragment.m26674c("graph_search_results_page_blended");
    }
}
