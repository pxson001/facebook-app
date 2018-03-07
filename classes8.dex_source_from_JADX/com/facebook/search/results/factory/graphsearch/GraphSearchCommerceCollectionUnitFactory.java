package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment.Results;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: SUBSCRIBE_PAGE_EVENTS_TAP */
public class GraphSearchCommerceCollectionUnitFactory extends GraphSearchBaseCollectionUnitFactory<SearchResultsProductItemUnit> {
    private static volatile GraphSearchCommerceCollectionUnitFactory f22732a;

    public static com.facebook.search.results.factory.graphsearch.GraphSearchCommerceCollectionUnitFactory m26298a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22732a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.results.factory.graphsearch.GraphSearchCommerceCollectionUnitFactory.class;
        monitor-enter(r1);
        r0 = f22732a;	 Catch:{ all -> 0x0039 }
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
        r0 = m26297a();	 Catch:{ all -> 0x0034 }
        f22732a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f22732a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.factory.graphsearch.GraphSearchCommerceCollectionUnitFactory.a(com.facebook.inject.InjectorLike):com.facebook.search.results.factory.graphsearch.GraphSearchCommerceCollectionUnitFactory");
    }

    private static GraphSearchCommerceCollectionUnitFactory m26297a() {
        return new GraphSearchCommerceCollectionUnitFactory();
    }

    @Nullable
    protected final GraphQLObjectType mo1263b(@Nullable Object obj) {
        SearchResultsProductItemUnit searchResultsProductItemUnit = (SearchResultsProductItemUnit) obj;
        return searchResultsProductItemUnit != null ? searchResultsProductItemUnit.f23494a.j() : null;
    }

    @Nullable
    protected final String mo1264c(Object obj) {
        return ((SearchResultsProductItemUnit) obj).f23494a.dp();
    }

    protected final ImmutableList<SearchResultsProductItemUnit> mo1262a(Results results, @Nullable String str) {
        Builder builder = new Builder();
        ImmutableList a = results.m8515a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLNode b = ((ModuleResultEdgeModel) a.get(i)).m8668b();
            if (b != null) {
                builder.c(new SearchResultsProductItemUnit(b, str));
            }
        }
        return builder.b();
    }
}
