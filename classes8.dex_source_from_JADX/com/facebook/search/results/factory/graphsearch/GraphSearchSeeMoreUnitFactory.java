package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel.SeeMoreQueryModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel.SeeMoreQueryModel.QueryTitleModel;
import com.facebook.search.results.model.unit.SearchResultsSeeMorePostsUnit;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: STACK_CHILD_INTERACTION */
public class GraphSearchSeeMoreUnitFactory extends GraphSearchSingleFeedUnitFactory<SearchResultsSeeMorePostsUnit> {
    private static volatile GraphSearchSeeMoreUnitFactory f22758a;

    public static com.facebook.search.results.factory.graphsearch.GraphSearchSeeMoreUnitFactory m26368a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22758a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.results.factory.graphsearch.GraphSearchSeeMoreUnitFactory.class;
        monitor-enter(r1);
        r0 = f22758a;	 Catch:{ all -> 0x0039 }
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
        r0 = m26367a();	 Catch:{ all -> 0x0034 }
        f22758a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f22758a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.factory.graphsearch.GraphSearchSeeMoreUnitFactory.a(com.facebook.inject.InjectorLike):com.facebook.search.results.factory.graphsearch.GraphSearchSeeMoreUnitFactory");
    }

    private static GraphSearchSeeMoreUnitFactory m26367a() {
        return new GraphSearchSeeMoreUnitFactory();
    }

    @Nullable
    protected final FeedUnit mo1261a(KeywordSearchModuleFragmentModel keywordSearchModuleFragmentModel) {
        String a;
        String str;
        GraphQLGraphSearchResultRole jx_;
        SeeMoreQueryModel jy_ = keywordSearchModuleFragmentModel.jy_();
        String k = keywordSearchModuleFragmentModel.m8543k();
        if (jy_ != null) {
            QueryTitleModel b = jy_.m8527b();
            if (b != null) {
                a = b.m8521a();
                str = a;
                String a2 = jy_ == null ? jy_.m8526a() : null;
                jx_ = keywordSearchModuleFragmentModel.jx_();
                GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle = keywordSearchModuleFragmentModel.m8536a().isEmpty() ? GraphQLGraphSearchResultsDisplayStyle.STORIES : (GraphQLGraphSearchResultsDisplayStyle) keywordSearchModuleFragmentModel.m8536a().get(0);
                if (jx_ != null || a2 == null || k == null) {
                    return null;
                }
                return new SearchResultsSeeMorePostsUnit(jx_, k, keywordSearchModuleFragmentModel.m8539c(), str, a2, graphQLGraphSearchResultsDisplayStyle);
            }
        }
        a = null;
        str = a;
        if (jy_ == null) {
        }
        jx_ = keywordSearchModuleFragmentModel.jx_();
        if (keywordSearchModuleFragmentModel.m8536a().isEmpty()) {
        }
        if (jx_ != null) {
        }
        return null;
    }
}
