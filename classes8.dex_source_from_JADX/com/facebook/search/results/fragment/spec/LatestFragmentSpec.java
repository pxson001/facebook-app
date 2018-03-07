package com.facebook.search.results.fragment.spec;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.KeywordTypeaheadUnit.Builder;
import com.facebook.search.model.ReactionSearchData;
import com.facebook.search.results.fragment.GraphSearchResultFragment;
import com.facebook.search.results.fragment.feed.SearchResultsLiveFeedFragment;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SEE_ALL_PYMK */
public class LatestFragmentSpec extends AbstractFragmentSpec<SearchResultsLiveFeedFragment> {
    private static volatile LatestFragmentSpec f23153a;

    public static com.facebook.search.results.fragment.spec.LatestFragmentSpec m26834a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23153a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.results.fragment.spec.LatestFragmentSpec.class;
        monitor-enter(r1);
        r0 = f23153a;	 Catch:{ all -> 0x003a }
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
        r0 = m26835b(r0);	 Catch:{ all -> 0x0035 }
        f23153a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23153a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.fragment.spec.LatestFragmentSpec.a(com.facebook.inject.InjectorLike):com.facebook.search.results.fragment.spec.LatestFragmentSpec");
    }

    private static LatestFragmentSpec m26835b(InjectorLike injectorLike) {
        return new LatestFragmentSpec(ResourcesMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LatestFragmentSpec(Resources resources, QeAccessor qeAccessor) {
        super(resources, GraphQLGraphSearchResultsDisplayStyle.LATEST, 2131237482, qeAccessor.a(ExperimentsForSearchAbTestModule.l, false));
    }

    public final GraphSearchResultFragment mo1308c() {
        return new SearchResultsLiveFeedFragment();
    }

    public final GraphSearchQuerySpec mo1309a(String str, String str2, String str3, String str4, ReactionSearchData reactionSearchData, ExactMatchInputExactMatch exactMatchInputExactMatch) {
        String a = str4.equals("news_v2") ? SearchQueryFunctions.a(str2, str) : SearchQueryFunctions.l(str);
        Builder builder = new Builder();
        builder.f22087b = str;
        builder = builder;
        builder.f22088c = a;
        Builder builder2 = builder;
        builder2.f22089d = str3;
        builder2 = builder2;
        builder2.f22090e = str4;
        builder2 = builder2;
        builder2.f22095j = reactionSearchData;
        builder2 = builder2;
        builder2.f22107v = ImmutableList.of(GraphQLGraphSearchResultsDisplayStyle.LATEST);
        builder2 = builder2;
        builder2.f22091f = exactMatchInputExactMatch;
        return builder2.m25651b();
    }
}
