package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.conversion.GraphQLNodeConversionHelper;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment.Results;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import com.facebook.search.protocol.SearchModelConversionHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: SRC */
public class GraphSearchStoryCollectionUnitFactory extends GraphSearchBaseCollectionUnitFactory<GraphQLStory> {
    private static final GraphQLObjectType f22764a = new GraphQLObjectType(80218325);
    private static volatile GraphSearchStoryCollectionUnitFactory f22765b;

    public static com.facebook.search.results.factory.graphsearch.GraphSearchStoryCollectionUnitFactory m26388a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f22765b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.results.factory.graphsearch.GraphSearchStoryCollectionUnitFactory.class;
        monitor-enter(r1);
        r0 = f22765b;	 Catch:{ all -> 0x0039 }
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
        r0 = m26389b();	 Catch:{ all -> 0x0034 }
        f22765b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f22765b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.factory.graphsearch.GraphSearchStoryCollectionUnitFactory.a(com.facebook.inject.InjectorLike):com.facebook.search.results.factory.graphsearch.GraphSearchStoryCollectionUnitFactory");
    }

    private static GraphSearchStoryCollectionUnitFactory m26389b() {
        return new GraphSearchStoryCollectionUnitFactory();
    }

    @Nullable
    protected final String mo1264c(Object obj) {
        return ((GraphQLStory) obj).c();
    }

    protected final ImmutableList<GraphQLStory> mo1262a(Results results, @Nullable String str) {
        Builder builder = new Builder();
        ImmutableList a = results.m8515a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ModuleResultEdgeModel moduleResultEdgeModel = (ModuleResultEdgeModel) a.get(i);
            GraphQLNode b = moduleResultEdgeModel.m8668b();
            if (b != null) {
                GraphQLStory a2 = GraphQLNodeConversionHelper.a(b);
                if (a2 != null) {
                    PropertyHelper.a(a2, SearchModelConversionHelper.m8989a(moduleResultEdgeModel.m8669c()));
                    builder.c(a2);
                }
            }
        }
        return builder.b();
    }

    @Nullable
    protected final GraphQLObjectType mo1263b(@Nullable Object obj) {
        return f22764a;
    }
}
