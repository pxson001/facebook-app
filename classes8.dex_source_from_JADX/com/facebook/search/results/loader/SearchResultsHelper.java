package com.facebook.search.results.loader;

import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.GraphSearchQuerySpecHelper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SEARCH_BUTTON */
public class SearchResultsHelper {
    private static final Class f23234a = SearchResultsHelper.class;
    private static volatile SearchResultsHelper f23235d;
    private final FbDataConnectionManager f23236b;
    private final QeAccessor f23237c;

    public static com.facebook.search.results.loader.SearchResultsHelper m26942a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23235d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.results.loader.SearchResultsHelper.class;
        monitor-enter(r1);
        r0 = f23235d;	 Catch:{ all -> 0x003a }
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
        r0 = m26943b(r0);	 Catch:{ all -> 0x0035 }
        f23235d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23235d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.loader.SearchResultsHelper.a(com.facebook.inject.InjectorLike):com.facebook.search.results.loader.SearchResultsHelper");
    }

    private static SearchResultsHelper m26943b(InjectorLike injectorLike) {
        return new SearchResultsHelper(FbDataConnectionManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SearchResultsHelper(FbDataConnectionManager fbDataConnectionManager, QeAccessor qeAccessor) {
        this.f23236b = fbDataConnectionManager;
        this.f23237c = qeAccessor;
    }

    public final boolean m26944a(GraphSearchQuerySpec graphSearchQuerySpec) {
        if (GraphSearchQuerySpecHelper.m25629b(graphSearchQuerySpec)) {
            return false;
        }
        Object obj;
        String b = graphSearchQuerySpec.mo1212b();
        if (b == null || !(b.startsWith("keywords_top") || b.startsWith("keywords_search") || b.startsWith("keywords_topic_trending") || b.startsWith("keywords_topic_sport_match"))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null && (!SearchQueryFunctions.e(b) || !this.f23237c.a(ExperimentsForSearchAbTestModule.r, false))) {
            return false;
        }
        ConnectionQuality b2 = this.f23236b.b();
        b2.name();
        if (b2 == ConnectionQuality.EXCELLENT || b2 == ConnectionQuality.GOOD) {
            return true;
        }
        if (SearchQueryFunctions.a(b) || SearchQueryFunctions.b(b)) {
            return true;
        }
        return false;
    }
}
