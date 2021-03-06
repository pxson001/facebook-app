package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLQuotesAnalysisItem;
import com.facebook.graphql.model.GraphQLQuotesAnalysisItemsEdge;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment.Results;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: STATIC */
public class GraphSearchPulseQuotesCollectionUnitFactory extends GraphSearchBaseCollectionUnitFactory<GraphQLQuotesAnalysisItem> {
    private static final GraphQLObjectType f22749a = new GraphQLObjectType(2019851078);
    private static volatile GraphSearchPulseQuotesCollectionUnitFactory f22750b;

    public static com.facebook.search.results.factory.graphsearch.GraphSearchPulseQuotesCollectionUnitFactory m26345a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22750b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.results.factory.graphsearch.GraphSearchPulseQuotesCollectionUnitFactory.class;
        monitor-enter(r1);
        r0 = f22750b;	 Catch:{ all -> 0x0039 }
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
        r0 = m26346c();	 Catch:{ all -> 0x0034 }
        f22750b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f22750b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.factory.graphsearch.GraphSearchPulseQuotesCollectionUnitFactory.a(com.facebook.inject.InjectorLike):com.facebook.search.results.factory.graphsearch.GraphSearchPulseQuotesCollectionUnitFactory");
    }

    private static GraphSearchPulseQuotesCollectionUnitFactory m26346c() {
        return new GraphSearchPulseQuotesCollectionUnitFactory();
    }

    protected final ImmutableList<GraphQLQuotesAnalysisItem> mo1262a(Results results, @Nullable String str) {
        Builder builder = new Builder();
        ImmutableList a = results.m8515a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLNode b = ((ModuleResultEdgeModel) a.get(i)).m8668b();
            if (!(b == null || b.gp() == null || b.gp().a() == null || b.gp().a().a() == null)) {
                ImmutableList a2 = b.gp().a().a();
                int size2 = a2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    GraphQLQuotesAnalysisItemsEdge graphQLQuotesAnalysisItemsEdge = (GraphQLQuotesAnalysisItemsEdge) a2.get(i2);
                    if (graphQLQuotesAnalysisItemsEdge.a() != null) {
                        builder.c(graphQLQuotesAnalysisItemsEdge.a());
                    }
                }
            }
        }
        return builder.b();
    }

    @Nullable
    protected final String mo1264c(Object obj) {
        return null;
    }

    @Nullable
    protected final GraphQLObjectType mo1263b(@Nullable Object obj) {
        return f22749a;
    }
}
