package com.facebook.search.results.factory.graphsearch.answer;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel.ResultsModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import com.facebook.search.results.factory.graphsearch.GraphSearchFeedUnitFactory;
import com.facebook.search.results.model.unit.answer.SearchResultsTimeUnit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.TimeZone;
import javax.inject.Singleton;

@Singleton
/* compiled from: SPECIAL */
public class TimeUnitFactory extends GraphSearchFeedUnitFactory<SearchResultsTimeUnit> {
    private static volatile TimeUnitFactory f22770a;

    public static com.facebook.search.results.factory.graphsearch.answer.TimeUnitFactory m26404a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22770a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.results.factory.graphsearch.answer.TimeUnitFactory.class;
        monitor-enter(r1);
        r0 = f22770a;	 Catch:{ all -> 0x0039 }
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
        r0 = m26405b();	 Catch:{ all -> 0x0034 }
        f22770a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f22770a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.factory.graphsearch.answer.TimeUnitFactory.a(com.facebook.inject.InjectorLike):com.facebook.search.results.factory.graphsearch.answer.TimeUnitFactory");
    }

    private static TimeUnitFactory m26405b() {
        return new TimeUnitFactory();
    }

    public final ImmutableList<SearchResultsTimeUnit> mo1268a(KeywordSearchModuleFragment keywordSearchModuleFragment) {
        ResultsModel g = keywordSearchModuleFragment.m8541g();
        if (g == null) {
            return RegularImmutableList.a;
        }
        Builder builder = new Builder();
        ImmutableList a = g.m8515a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLNode b = ((ModuleResultEdgeModel) a.get(i)).m8668b();
            if (b != null) {
                Uri uri;
                if (b.br() == null || b.br().j() == null) {
                    uri = null;
                } else {
                    uri = Uri.parse(b.br().j().L().b());
                }
                builder.c(new SearchResultsTimeUnit(b.eP(), TimeZone.getTimeZone(keywordSearchModuleFragment.m8543k()), uri));
            }
        }
        return builder.b();
    }

    protected final FeedUnit mo1265a(ModuleResultEdgeModel moduleResultEdgeModel, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, String str) {
        return null;
    }
}
