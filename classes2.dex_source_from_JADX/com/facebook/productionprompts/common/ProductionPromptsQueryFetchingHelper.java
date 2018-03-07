package com.facebook.productionprompts.common;

import android.content.Context;
import android.location.LocationManager;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.constants.PromptConstants;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.productionprompts.graphql.C0582x78ef048a;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQL$FetchProductionPromptsQueryString;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.prefs.PromptsPrefKeys;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: network_info_celltower_changed */
public class ProductionPromptsQueryFetchingHelper {
    private final Context f12693a;
    public final Clock f12694b;
    public final FbSharedPreferences f12695c;
    public final GraphQLQueryExecutor f12696d;
    private final GraphQLStoryHelper f12697e;
    public final DefaultProcessIdleExecutor f12698f;
    private final FetchVideoChannelParamBuilderUtil f12699g;

    public static ProductionPromptsQueryFetchingHelper m18758b(InjectorLike injectorLike) {
        return new ProductionPromptsQueryFetchingHelper((Context) injectorLike.getInstance(Context.class), SystemClockMethodAutoProvider.m1498a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), GraphQLStoryHelper.m10197a(injectorLike), IdleExecutor_DefaultIdleExecutorMethodAutoProvider.m2724a(injectorLike), FetchVideoChannelParamBuilderUtil.m10180a(injectorLike));
    }

    @Inject
    public ProductionPromptsQueryFetchingHelper(Context context, Clock clock, FbSharedPreferences fbSharedPreferences, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLStoryHelper graphQLStoryHelper, DefaultProcessIdleExecutor defaultProcessIdleExecutor, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil) {
        this.f12693a = context;
        this.f12694b = clock;
        this.f12695c = fbSharedPreferences;
        this.f12696d = graphQLQueryExecutor;
        this.f12697e = graphQLStoryHelper;
        this.f12698f = defaultProcessIdleExecutor;
        this.f12699g = fetchVideoChannelParamBuilderUtil;
    }

    public final GraphQLRequest<C0582x78ef048a> m18759a() {
        return m18757b(this.f12695c.mo277a(PromptsPrefKeys.f12780b, this.f12694b.mo211a() / 1000)).m11594a(GraphQLCachePolicy.f7110b);
    }

    public final ListenableFuture<GraphQLResult<C0582x78ef048a>> m18760a(@Nullable final Function<GraphQLResult<C0582x78ef048a>, Boolean> function) {
        return Futures.m2461b(this.f12696d.m10446a(m18759a()), new AsyncFunction<GraphQLResult<C0582x78ef048a>, GraphQLResult<C0582x78ef048a>>(this) {
            final /* synthetic */ ProductionPromptsQueryFetchingHelper f14001b;

            /* compiled from: network_info_celltower_changed */
            class C07801 implements Callable<GraphQLResult<C0582x78ef048a>> {
                final /* synthetic */ C05841 f19791a;

                C07801(C05841 c05841) {
                    this.f19791a = c05841;
                }

                public Object call() {
                    long a = this.f19791a.f14001b.f12694b.mo211a() / 1000;
                    GraphQLResult graphQLResult = (GraphQLResult) FutureDetour.a(this.f19791a.f14001b.f12696d.m10446a(ProductionPromptsQueryFetchingHelper.m18755a(this.f19791a.f14001b, a)), 166666557);
                    this.f19791a.f14001b.f12695c.edit().mo1275a(PromptsPrefKeys.f12780b, a).commit();
                    return graphQLResult;
                }
            }

            public final ListenableFuture mo352a(Object obj) {
                Object obj2;
                obj = (GraphQLResult) obj;
                if (function == null) {
                    obj2 = obj == null ? 1 : null;
                } else if (((Boolean) function.apply(obj)).booleanValue()) {
                    obj2 = null;
                } else {
                    int i = 1;
                }
                return obj2 != null ? this.f14001b.f12698f.mo271a(new C07801(this)) : Futures.m2452a(obj);
            }
        }, MoreExecutors.m1813a());
    }

    public final boolean m18761a(ProductionPrompt productionPrompt) {
        return !productionPrompt.j() || (productionPrompt.j() && ((LocationManager) this.f12693a.getSystemService("location")).isProviderEnabled("gps"));
    }

    public static ImmutableList<FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel> m18756a(GraphQLResult<C0582x78ef048a> graphQLResult) {
        return (graphQLResult == null || graphQLResult.f6203e == null || ((C0582x78ef048a) graphQLResult.f6203e).m20286j() == null || ((C0582x78ef048a) graphQLResult.f6203e).m20286j().m21605a().isEmpty()) ? null : ((C0582x78ef048a) graphQLResult.f6203e).m20286j().m21605a();
    }

    public static GraphQLRequest m18755a(ProductionPromptsQueryFetchingHelper productionPromptsQueryFetchingHelper, long j) {
        return productionPromptsQueryFetchingHelper.m18757b(j).m11594a(GraphQLCachePolicy.f7112d);
    }

    private GraphQLRequest<C0582x78ef048a> m18757b(long j) {
        Enum a = GraphQlQueryDefaults.m11417a();
        TypedGraphQlQueryString fetchProductionPromptsGraphQL$FetchProductionPromptsQueryString = new FetchProductionPromptsGraphQL$FetchProductionPromptsQueryString();
        fetchProductionPromptsGraphQL$FetchProductionPromptsQueryString.m11314a("start_time", Long.valueOf(j)).m11314a("end_time", Long.valueOf(7200 + j)).m11314a("count", Integer.valueOf(5)).m11313a("image_scale", a).m11313a("frame_scale", a).m11314a("image_size", Integer.valueOf(32)).m11314a("image_high_width", this.f12697e.m10229x()).m11314a("activity_count", Integer.valueOf(10)).m11316a("supported_prompts", PromptConstants.f13946a);
        this.f12699g.m10182a((GraphQlQueryString) fetchProductionPromptsGraphQL$FetchProductionPromptsQueryString);
        return GraphQLRequest.m11587a(fetchProductionPromptsGraphQL$FetchProductionPromptsQueryString).m11590a(900);
    }
}
