package com.facebook.goodwill.dailydialogue.data;

import com.facebook.common.executors.C0055x2995691a;
import com.facebook.device.ScreenUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedUnitEdge.Builder;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: percent_feed_unit_seen */
public class DailyDialoguePinnedUnitsProtocol {
    public final Function<GraphQLResult<GraphQLViewer>, DailyDialogueFetchResult> f10246a = new C04281(this);
    public final Executor f10247b;
    public final GraphQLQueryExecutor f10248c;
    public final ScreenUtil f10249d;

    /* compiled from: percent_feed_unit_seen */
    class C04281 implements Function<GraphQLResult<GraphQLViewer>, DailyDialogueFetchResult> {
        final /* synthetic */ DailyDialoguePinnedUnitsProtocol f10250a;

        C04281(DailyDialoguePinnedUnitsProtocol dailyDialoguePinnedUnitsProtocol) {
            this.f10250a = dailyDialoguePinnedUnitsProtocol;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.f6203e == null || ((GraphQLViewer) graphQLResult.f6203e).m11358p() == null) {
                return null;
            }
            Object p = ((GraphQLViewer) graphQLResult.f6203e).m11358p();
            Builder builder = new Builder();
            builder.f15732i = p;
            builder = builder;
            builder.f15729f = p.mo2834a();
            return new DailyDialogueFetchResult(this.f10250a, builder.m22415a(), ((GraphQLViewer) graphQLResult.f6203e).m11358p().mo2877k());
        }
    }

    public static DailyDialoguePinnedUnitsProtocol m15335b(InjectorLike injectorLike) {
        return new DailyDialoguePinnedUnitsProtocol(C0055x2995691a.m1881a(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), ScreenUtil.m8695a(injectorLike));
    }

    @Inject
    public DailyDialoguePinnedUnitsProtocol(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, ScreenUtil screenUtil) {
        this.f10247b = executorService;
        this.f10249d = screenUtil;
        this.f10248c = graphQLQueryExecutor;
    }
}
