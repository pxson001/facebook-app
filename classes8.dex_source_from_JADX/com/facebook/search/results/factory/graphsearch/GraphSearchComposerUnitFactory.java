package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import com.facebook.search.results.model.GameStatusHelper;
import com.facebook.search.results.model.GameStatusHelper.GameStatus;
import com.facebook.search.results.model.unit.SearchResultsComposerUnit;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: SUBSCRIBED */
public class GraphSearchComposerUnitFactory extends GraphSearchSingleFeedUnitFactory<SearchResultsComposerUnit> {
    private static volatile GraphSearchComposerUnitFactory f22733a;

    public static com.facebook.search.results.factory.graphsearch.GraphSearchComposerUnitFactory m26303a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22733a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.results.factory.graphsearch.GraphSearchComposerUnitFactory.class;
        monitor-enter(r1);
        r0 = f22733a;	 Catch:{ all -> 0x0039 }
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
        r0 = m26302a();	 Catch:{ all -> 0x0034 }
        f22733a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f22733a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.factory.graphsearch.GraphSearchComposerUnitFactory.a(com.facebook.inject.InjectorLike):com.facebook.search.results.factory.graphsearch.GraphSearchComposerUnitFactory");
    }

    private static GraphSearchComposerUnitFactory m26302a() {
        return new GraphSearchComposerUnitFactory();
    }

    @Nullable
    protected final FeedUnit mo1261a(KeywordSearchModuleFragmentModel keywordSearchModuleFragmentModel) {
        GraphQLNode b = GraphSearchModulesUtil.m26328b(keywordSearchModuleFragmentModel);
        if (b == null || b.hI() == null) {
            return new SearchResultsComposerUnit("Join the conversation...", null, null, keywordSearchModuleFragmentModel.m8539c());
        }
        return new SearchResultsComposerUnit(GameStatusHelper.m27022a(b.hI().C(), b.hI().G()) == GameStatus.PREGAME ? "Who are you rooting for?" : "Join the conversation...", keywordSearchModuleFragmentModel.m8542j(), b.dp(), keywordSearchModuleFragmentModel.m8539c());
    }
}
