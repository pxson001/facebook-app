package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLGraphSearchResultDecoration;
import com.facebook.graphql.model.GraphQLGraphSearchSnippet;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.conversion.GraphQLNodeConversionHelper;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import com.facebook.search.protocol.SearchModelConversionHelper;
import com.facebook.search.results.model.unit.SearchResultsStoryUnit;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: SS_SEE_MORE_BUTTON */
public class GraphSearchStoriesFactory extends GraphSearchFeedUnitFactory<SearchResultsStoryUnit> {
    private static volatile GraphSearchStoriesFactory f22763a;

    public static com.facebook.search.results.factory.graphsearch.GraphSearchStoriesFactory m26386a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f22763a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.results.factory.graphsearch.GraphSearchStoriesFactory.class;
        monitor-enter(r1);
        r0 = f22763a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m26385a();	 Catch:{ all -> 0x0034 }
        f22763a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f22763a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.factory.graphsearch.GraphSearchStoriesFactory.a(com.facebook.inject.InjectorLike):com.facebook.search.results.factory.graphsearch.GraphSearchStoriesFactory");
    }

    private static GraphSearchStoriesFactory m26385a() {
        return new GraphSearchStoriesFactory();
    }

    @Nullable
    protected final FeedUnit mo1265a(ModuleResultEdgeModel moduleResultEdgeModel, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, String str) {
        FeedUnit feedUnit = null;
        GraphQLNode b = moduleResultEdgeModel.m8668b();
        GraphQLStory a = b != null ? GraphQLNodeConversionHelper.a(b) : null;
        if (!(b == null || a == null)) {
            String a2;
            GraphQLGraphSearchResultDecoration a3 = SearchModelConversionHelper.m8989a(moduleResultEdgeModel.m8669c());
            PropertyHelper.a(a, a3);
            if (a3 != null) {
                ImmutableList n = a3.n();
                if (!(n == null || n.isEmpty())) {
                    GraphQLTextWithEntities j = ((GraphQLGraphSearchSnippet) n.get(0)).j();
                    if (j != null) {
                        a2 = j.a();
                        feedUnit = new SearchResultsStoryUnit(graphQLGraphSearchResultRole, a, str, a2, a3 == null ? a3.o() : null);
                    }
                }
            }
            a2 = null;
            if (a3 == null) {
            }
            feedUnit = new SearchResultsStoryUnit(graphQLGraphSearchResultRole, a, str, a2, a3 == null ? a3.o() : null);
        }
        return feedUnit;
    }
}
