package com.facebook.search.results.factory.graphsearch;

import com.facebook.common.build.BuildConstants;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLMediaQuestion;
import com.facebook.graphql.model.GraphQLMediaQuestionOption;
import com.facebook.graphql.model.GraphQLMediaQuestionOptionsConnection;
import com.facebook.graphql.model.GraphQLMediaQuestionOptionsEdge;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLSportsDataMatchData;
import com.facebook.graphql.model.GraphQLSportsDataMatchToFanFavoriteConnection;
import com.facebook.graphql.model.GraphQLSportsDataMatchToFanFavoriteEdge;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment.Results;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import com.facebook.search.results.model.SportsTeam;
import com.facebook.search.results.model.SportsTeam.Type;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: STACKED */
public class GraphSearchSportsTeamCollectionUnitFactory extends GraphSearchBaseCollectionUnitFactory<SportsTeam> {
    private static final GraphQLObjectType f22759a = new GraphQLObjectType(1705737269);
    private static volatile GraphSearchSportsTeamCollectionUnitFactory f22760b;

    public static com.facebook.search.results.factory.graphsearch.GraphSearchSportsTeamCollectionUnitFactory m26370a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22760b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.results.factory.graphsearch.GraphSearchSportsTeamCollectionUnitFactory.class;
        monitor-enter(r1);
        r0 = f22760b;	 Catch:{ all -> 0x0039 }
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
        r0 = m26375b();	 Catch:{ all -> 0x0034 }
        f22760b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f22760b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.factory.graphsearch.GraphSearchSportsTeamCollectionUnitFactory.a(com.facebook.inject.InjectorLike):com.facebook.search.results.factory.graphsearch.GraphSearchSportsTeamCollectionUnitFactory");
    }

    private static GraphSearchSportsTeamCollectionUnitFactory m26375b() {
        return new GraphSearchSportsTeamCollectionUnitFactory();
    }

    @Nullable
    protected final String mo1264c(Object obj) {
        return ((SportsTeam) obj).f23396e;
    }

    protected final ImmutableList<SportsTeam> mo1262a(Results results, @Nullable String str) {
        Builder builder = new Builder();
        GraphQLNode b = ((ModuleResultEdgeModel) results.m8515a().get(0)).m8668b();
        if (!(b == null || b.hI() == null || b.hI().k() == null || b.hI().u() == null)) {
            GraphQLSportsDataMatchData hI = b.hI();
            int v = hI.v() + hI.l();
            SportsTeam a = m26371a(hI.x(), Type.HOME_TEAM, hI.w(), hI.u(), hI.v(), v, hI.t());
            SportsTeam a2 = m26371a(hI.n(), Type.AWAY_TEAM, hI.m(), hI.k(), hI.l(), v, hI.t());
            builder.c(a);
            builder.c(a2);
        }
        return builder.b();
    }

    @Nullable
    protected final GraphQLObjectType mo1263b(@Nullable Object obj) {
        return f22759a;
    }

    private static SportsTeam m26371a(String str, Type type, String str2, GraphQLPage graphQLPage, int i, int i2, GraphQLSportsDataMatchToFanFavoriteConnection graphQLSportsDataMatchToFanFavoriteConnection) {
        return new SportsTeam(graphQLPage.aG(), type, str, str2, graphQLPage.ae(), m26376b(graphQLPage.ae(), graphQLSportsDataMatchToFanFavoriteConnection), i, i2, graphQLPage.bs() != null ? ImageUtil.a(graphQLPage.bs()) : null, m26374a(graphQLPage.ae(), graphQLSportsDataMatchToFanFavoriteConnection));
    }

    private static boolean m26374a(String str, GraphQLSportsDataMatchToFanFavoriteConnection graphQLSportsDataMatchToFanFavoriteConnection) {
        if (graphQLSportsDataMatchToFanFavoriteConnection == null || graphQLSportsDataMatchToFanFavoriteConnection.a().isEmpty()) {
            return false;
        }
        ImmutableList a = m26372a(((GraphQLSportsDataMatchToFanFavoriteEdge) graphQLSportsDataMatchToFanFavoriteConnection.a().get(0)).a());
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLMediaQuestionOptionsEdge graphQLMediaQuestionOptionsEdge = (GraphQLMediaQuestionOptionsEdge) a.get(i);
            if (m26373a(str, graphQLMediaQuestionOptionsEdge)) {
                Object obj;
                if (graphQLMediaQuestionOptionsEdge.a() == null || !graphQLMediaQuestionOptionsEdge.a().m()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final ImmutableList<SearchResultsCollectionUnit<SportsTeam>> mo1266a(KeywordSearchModuleFragment keywordSearchModuleFragment) {
        return BuildConstants.i ? super.mo1266a((KeywordSearchModuleFragmentModel) keywordSearchModuleFragment) : null;
    }

    @Nullable
    private static String m26376b(String str, GraphQLSportsDataMatchToFanFavoriteConnection graphQLSportsDataMatchToFanFavoriteConnection) {
        int i = 0;
        if (graphQLSportsDataMatchToFanFavoriteConnection == null || graphQLSportsDataMatchToFanFavoriteConnection.a().isEmpty()) {
            return null;
        }
        ImmutableList a = m26372a(((GraphQLSportsDataMatchToFanFavoriteEdge) graphQLSportsDataMatchToFanFavoriteConnection.a().get(0)).a());
        int size = a.size();
        while (i < size) {
            GraphQLMediaQuestionOptionsEdge graphQLMediaQuestionOptionsEdge = (GraphQLMediaQuestionOptionsEdge) a.get(i);
            if (m26373a(str, graphQLMediaQuestionOptionsEdge)) {
                String j;
                if (graphQLMediaQuestionOptionsEdge.a() != null) {
                    j = graphQLMediaQuestionOptionsEdge.a().j();
                } else {
                    j = null;
                }
                return j;
            }
            i++;
        }
        return null;
    }

    private static boolean m26373a(@Nullable String str, GraphQLMediaQuestionOptionsEdge graphQLMediaQuestionOptionsEdge) {
        if (str == null) {
            return false;
        }
        GraphQLMediaQuestionOption a = graphQLMediaQuestionOptionsEdge.a();
        if (a != null) {
            return str.equals(a.k());
        }
        return false;
    }

    private static ImmutableList<GraphQLMediaQuestionOptionsEdge> m26372a(@Nullable GraphQLMediaQuestion graphQLMediaQuestion) {
        if (graphQLMediaQuestion != null) {
            GraphQLMediaQuestionOptionsConnection k = graphQLMediaQuestion.k();
            if (k != null && k.a().size() == 2) {
                return k.a();
            }
        }
        return RegularImmutableList.a;
    }
}
