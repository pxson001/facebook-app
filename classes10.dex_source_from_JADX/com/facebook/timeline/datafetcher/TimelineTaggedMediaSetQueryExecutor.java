package com.facebook.timeline.datafetcher;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.timeline.protocol.FetchTimelineTaggedMediaSetGraphQL.TimelineTaggedMediaSetQueryString;
import com.facebook.timeline.protocol.FetchTimelineTaggedMediaSetGraphQLInterfaces.TimelineTaggedMediaSetFields;
import com.facebook.timeline.protocol.FetchTimelineTaggedMediaSetGraphQLModels.TimelineTaggedMediaSetQueryModel;
import com.google.common.base.Function;

/* compiled from: greeting_card_composer */
public class TimelineTaggedMediaSetQueryExecutor {

    /* compiled from: greeting_card_composer */
    final class C15561 implements Function<GraphQLResult<TimelineTaggedMediaSetQueryModel>, TimelineTaggedMediaSetFields> {
        C15561() {
        }

        public final Object apply(Object obj) {
            return ((TimelineTaggedMediaSetQueryModel) ((GraphQLResult) obj).e).a();
        }
    }

    public static RequestObservable<TimelineTaggedMediaSetFields> m10732a(GraphQLBatchRequest graphQLBatchRequest, String str, int i, CallerContext callerContext, GraphQLCachePolicy graphQLCachePolicy) {
        GraphQLRequest a = GraphQLRequest.a((TimelineTaggedMediaSetQueryString) new TimelineTaggedMediaSetQueryString().a("profile_id", str)).a(RequestPriority.NON_INTERACTIVE);
        a.y = i;
        a = a;
        a.f = callerContext;
        return graphQLBatchRequest.a(a.a(graphQLCachePolicy)).a(new C15561());
    }
}
