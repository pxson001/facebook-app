package com.facebook.goodwill.feed.data;

import android.text.TextUtils;
import com.facebook.api.feed.FeedFetchContext;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.protocol.FetchFeedQueryUtil;
import com.facebook.feed.util.injection.FeedClientSideInjectionTool;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQL.ThrowbackFeedQueryString;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQL.ThrowbackMoreStoriesQueryString;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLModels.ThrowbackFeedFragmentModel;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLModels.ThrowbackFeedFragmentModel.AccentImagesModel.NodesModel;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLModels.ThrowbackFeedFragmentModel.ThemeModel;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLModels.ThrowbackFeedQueryModel;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLModels.ThrowbackFeedUnitEdgeModel;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLModels.ThrowbackFeedUnitsConnectionFragmentModel;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLModels.ThrowbackMoreStoriesQueryModel;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLModels.ThrowbackSectionFragmentModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackAnniversaryCampaignStory;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendListEdge;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendversaryStory;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackMissedMemoriesStory;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.conversion.GraphQLGoodwillThrowbackFeedUnitConversionHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Videohome prefetching toast */
public class ThrowbackFeedPagerProtocol {
    public final Function<GraphQLResult<ThrowbackFeedQueryModel>, ThrowbackFeedStories> f21071a = new C30001(this);
    public final Function<GraphQLResult<ThrowbackMoreStoriesQueryModel>, ThrowbackFeedStories> f21072b = new C30012(this);
    private final Executor f21073c;
    private GraphQLQueryExecutor f21074d;
    private final GraphQLStoryHelper f21075e;
    private final FetchFeedQueryUtil f21076f;
    private final Lazy<FeedClientSideInjectionTool> f21077g;
    private final FetchVideoChannelParamBuilderUtil f21078h;
    public int f21079i;
    public FeedType f21080j;

    /* compiled from: Videohome prefetching toast */
    class C30001 implements Function<GraphQLResult<ThrowbackFeedQueryModel>, ThrowbackFeedStories> {
        final /* synthetic */ ThrowbackFeedPagerProtocol f21069a;

        C30001(ThrowbackFeedPagerProtocol throwbackFeedPagerProtocol) {
            this.f21069a = throwbackFeedPagerProtocol;
        }

        public Object apply(@Nullable Object obj) {
            return ThrowbackFeedPagerProtocol.m22038a(this.f21069a, (GraphQLResult) obj);
        }
    }

    /* compiled from: Videohome prefetching toast */
    class C30012 implements Function<GraphQLResult<ThrowbackMoreStoriesQueryModel>, ThrowbackFeedStories> {
        final /* synthetic */ ThrowbackFeedPagerProtocol f21070a;

        C30012(ThrowbackFeedPagerProtocol throwbackFeedPagerProtocol) {
            this.f21070a = throwbackFeedPagerProtocol;
        }

        public Object apply(@Nullable Object obj) {
            return ThrowbackFeedPagerProtocol.m22043b(this.f21070a, (GraphQLResult) obj);
        }
    }

    public static ThrowbackFeedPagerProtocol m22037a(InjectorLike injectorLike) {
        return new ThrowbackFeedPagerProtocol((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), GraphQLStoryHelper.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 6094), FetchFeedQueryUtil.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike));
    }

    @Inject
    public ThrowbackFeedPagerProtocol(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLStoryHelper graphQLStoryHelper, Lazy<FeedClientSideInjectionTool> lazy, FetchFeedQueryUtil fetchFeedQueryUtil, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil) {
        this.f21073c = executorService;
        this.f21074d = graphQLQueryExecutor;
        this.f21075e = graphQLStoryHelper;
        this.f21076f = fetchFeedQueryUtil;
        this.f21077g = lazy;
        this.f21078h = fetchVideoChannelParamBuilderUtil;
    }

    private GraphQLRequest<ThrowbackMoreStoriesQueryModel> m22041a(String str, FetchFeedCause fetchFeedCause) {
        FetchFeedParamsBuilder fetchFeedParamsBuilder = new FetchFeedParamsBuilder();
        fetchFeedParamsBuilder.c = this.f21079i;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.b = this.f21080j;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.l = FeedFetchContext.a;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder.a(fetchFeedCause);
        fetchFeedParamsBuilder.f = str;
        FetchFeedParams q = fetchFeedParamsBuilder.q();
        GraphQlQueryString throwbackMoreStoriesQueryString = new ThrowbackMoreStoriesQueryString();
        m22042a(throwbackMoreStoriesQueryString, q);
        return GraphQLRequest.a(throwbackMoreStoriesQueryString).a(GraphQLCachePolicy.c);
    }

    private GraphQLRequest<ThrowbackFeedQueryModel> m22040a(FetchFeedCause fetchFeedCause, Map<String, String> map) {
        FetchFeedParamsBuilder fetchFeedParamsBuilder = new FetchFeedParamsBuilder();
        fetchFeedParamsBuilder.c = this.f21079i;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.b = this.f21080j;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.l = FeedFetchContext.a;
        FetchFeedParams q = fetchFeedParamsBuilder.a(fetchFeedCause).q();
        GraphQlQueryString throwbackFeedQueryString = new ThrowbackFeedQueryString();
        m22042a(throwbackFeedQueryString, q);
        throwbackFeedQueryString.a("image_scale", GraphQlQueryDefaults.a());
        if (!(throwbackFeedQueryString == null || map == null || map.isEmpty())) {
            String str = (String) map.get("source");
            if (!TextUtils.isEmpty(str)) {
                throwbackFeedQueryString.a("source", str);
            }
            Object obj = (String) map.get("campaign_id");
            if (TextUtils.isEmpty(obj)) {
                obj = (String) map.get("story_id");
            }
            if (!TextUtils.isEmpty(obj)) {
                throwbackFeedQueryString.a("storyID", obj);
            }
        }
        return GraphQLRequest.a(throwbackFeedQueryString).a(GraphQLCachePolicy.c);
    }

    private void m22042a(GraphQlQueryString graphQlQueryString, @Nullable FetchFeedParams fetchFeedParams) {
        this.f21076f.a(graphQlQueryString);
        this.f21076f.b(graphQlQueryString);
        FetchFeedQueryUtil.a(graphQlQueryString, fetchFeedParams, null, "after");
        this.f21076f.c(graphQlQueryString);
        FetchFeedQueryUtil.d(graphQlQueryString);
        graphQlQueryString.a("max_friendversary_friends", "50");
        graphQlQueryString.a("profile_image_size", GraphQLStoryHelper.a());
        if (fetchFeedParams != null) {
            graphQlQueryString.a("first", String.valueOf(fetchFeedParams.c));
        }
        this.f21078h.a(graphQlQueryString);
    }

    public final ListenableFuture<ThrowbackFeedStories> m22044a(String str, FetchFeedCause fetchFeedCause, Map<String, String> map) {
        if ((str == null ? 1 : null) != null) {
            return Futures.a(this.f21074d.a(m22040a(fetchFeedCause, (Map) map)), this.f21071a, this.f21073c);
        }
        return Futures.a(this.f21074d.a(m22041a(str, fetchFeedCause)), this.f21072b, this.f21073c);
    }

    public static ThrowbackFeedStories m22038a(ThrowbackFeedPagerProtocol throwbackFeedPagerProtocol, GraphQLResult graphQLResult) {
        if (graphQLResult == null || graphQLResult.d() == null || ((ThrowbackFeedQueryModel) graphQLResult.d()).a() == null) {
            return null;
        }
        ThrowbackFeedFragmentModel a = ((ThrowbackFeedQueryModel) graphQLResult.d()).a();
        ThrowbackFeedStories a2 = throwbackFeedPagerProtocol.m22039a(a.y(), graphQLResult.a());
        if (a2 == null) {
            return null;
        }
        String str;
        String str2;
        Builder builder = new Builder();
        if (!(a.a() == null || a.a().a() == null)) {
            ImmutableList a3 = a.a().a();
            int size = a3.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) a3.get(i);
                if (!(nodesModel.a() == null || nodesModel.a().b() == null)) {
                    builder.c(nodesModel.a().b());
                }
            }
        }
        long z = a.z();
        DefaultImageFieldsModel o = a.o();
        ThemeModel w = a.w();
        DefaultImageFieldsModel j = a.j();
        String k = a.k();
        DefaultImageFieldsModel r = a.r();
        String t = a.t();
        String u = a.u();
        String s = a.s();
        String q = a.q();
        String p = a.p();
        if (a.x() == null) {
            str = null;
        } else {
            str = a.x().a();
        }
        ImmutableList b = builder.b();
        String v = a.v();
        DefaultImageFieldsModel l = a.l();
        if (a.n() == null) {
            str2 = null;
        } else {
            str2 = a.n().a();
        }
        ThrowbackFeedResources throwbackFeedResources = new ThrowbackFeedResources(z, o, w, j, k, r, t, u, s, q, p, str, b, v, l, str2, a.m());
        ThrowbackFeedStories.Builder builder2 = new ThrowbackFeedStories.Builder();
        return ThrowbackFeedStories.Builder.m22046a(a2).m22048a(throwbackFeedResources).m22052a();
    }

    public static ThrowbackFeedStories m22043b(ThrowbackFeedPagerProtocol throwbackFeedPagerProtocol, GraphQLResult graphQLResult) {
        if (graphQLResult == null || graphQLResult.e == null || ((ThrowbackMoreStoriesQueryModel) graphQLResult.e).a() == null) {
            return null;
        }
        return throwbackFeedPagerProtocol.m22039a(((ThrowbackMoreStoriesQueryModel) graphQLResult.e).a().a(), graphQLResult.freshness);
    }

    private ThrowbackFeedStories m22039a(ThrowbackFeedUnitsConnectionFragmentModel throwbackFeedUnitsConnectionFragmentModel, DataFreshnessResult dataFreshnessResult) {
        int i = 0;
        if (throwbackFeedUnitsConnectionFragmentModel == null || throwbackFeedUnitsConnectionFragmentModel.a() == null) {
            return null;
        }
        int i2;
        ImmutableList d;
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        ImmutableMap.Builder builder3 = ImmutableMap.builder();
        for (i2 = 0; i2 < throwbackFeedUnitsConnectionFragmentModel.a().size(); i2++) {
            try {
                String str;
                ThrowbackFeedUnitEdgeModel throwbackFeedUnitEdgeModel = (ThrowbackFeedUnitEdgeModel) throwbackFeedUnitsConnectionFragmentModel.a().get(i2);
                GraphQLGoodwillThrowbackFriendversaryStory b = GraphQLGoodwillThrowbackFeedUnitConversionHelper.b(throwbackFeedUnitEdgeModel.a());
                FeedUnit c = GraphQLGoodwillThrowbackFeedUnitConversionHelper.c(throwbackFeedUnitEdgeModel.a());
                GraphQLGoodwillThrowbackAnniversaryCampaignStory d2 = GraphQLGoodwillThrowbackFeedUnitConversionHelper.d(throwbackFeedUnitEdgeModel.a());
                GraphQLGoodwillThrowbackMissedMemoriesStory e = GraphQLGoodwillThrowbackFeedUnitConversionHelper.e(throwbackFeedUnitEdgeModel.a());
                if (c != null) {
                    str = "FriendversaryCampaignStory-" + (c.l() != null ? c.l().m() : null);
                } else if (b != null) {
                    str = "FriendversaryStory-" + ((GraphQLGoodwillThrowbackFriendListEdge) b.l().a().get(0)).a().P();
                    c = b;
                } else if (d2 != null) {
                    str = "AnniversaryStory-" + d2.k().p();
                    c = d2;
                } else if (e == null || !(e instanceof GraphQLGoodwillThrowbackMissedMemoriesStory)) {
                    c = GraphQLGoodwillThrowbackFeedUnitConversionHelper.a(throwbackFeedUnitEdgeModel.a());
                    if (c != null) {
                        c = GraphQLStory.Builder.a(c).a(GoodwillFeedModelConversionHelper.m22026a(throwbackFeedUnitEdgeModel.k())).a();
                    }
                    str = c.c();
                } else {
                    String str2 = "";
                    if (e.a() == null || e.a().isEmpty() || ((GraphQLStoryAttachment) e.a().get(0)).a() == null) {
                        str = str2;
                    } else {
                        str = ((GraphQLStoryAttachment) e.a().get(0)).a().b();
                    }
                    if (!(!TextUtils.isEmpty(str) || e.b() == null || e.b().isEmpty())) {
                        str = ((GraphQLStory) e.b().get(0)).c();
                    }
                    str = "MissedMemoryStory-" + str;
                    c = e;
                }
                builder.c(new GraphQLFeedUnitEdge.Builder().a(c).b(str).a());
                builder2.c(throwbackFeedUnitEdgeModel.j());
            } catch (Throwable e2) {
                BLog.b(ThrowbackFeedPagerProtocol.class, "Caught exception converting ThrowbackUnit into GraphQLStory.", e2);
            }
        }
        ImmutableList k = throwbackFeedUnitsConnectionFragmentModel.k();
        i2 = k.size();
        while (i < i2) {
            ThrowbackSectionFragmentModel throwbackSectionFragmentModel = (ThrowbackSectionFragmentModel) k.get(i);
            builder3.b(throwbackSectionFragmentModel.a(), throwbackSectionFragmentModel);
            i++;
        }
        ImmutableList b2 = builder.b();
        FetchFeedResult a = ((FeedClientSideInjectionTool) this.f21077g.get()).a(new FetchFeedResult(new FetchFeedParamsBuilder().a(this.f21079i).a(this.f21080j).a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).a(FeedFetchContext.a).q(), builder.b(), DefaultGraphQLConversionHelper.a(throwbackFeedUnitsConnectionFragmentModel.j()), "", null, 0, true));
        if (a.d().size() >= b2.size()) {
            d = a.d();
        } else {
            d = b2;
        }
        k = builder2.b();
        if (d.size() == 1 && k.size() == 0) {
            builder2.c("0");
            k = builder2.b();
        }
        return new ThrowbackFeedStories.Builder().m22050a(d).m22053b(k).m22051a(builder3.b()).m22049a(throwbackFeedUnitsConnectionFragmentModel.j()).m22047a(dataFreshnessResult).m22052a();
    }
}
