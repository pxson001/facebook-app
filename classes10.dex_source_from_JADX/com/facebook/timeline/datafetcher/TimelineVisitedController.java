package com.facebook.timeline.datafetcher;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.timeline.event.TimelineVisitedEventBus;
import javax.inject.Inject;

/* compiled from: graphQuickInviteSendInvite */
public class TimelineVisitedController {
    public final GraphQLQueryExecutor f10686a;
    public final TimelineVisitedEventBus f10687b;
    public boolean f10688c = false;

    @Inject
    public TimelineVisitedController(GraphQLQueryExecutor graphQLQueryExecutor, TimelineVisitedEventBus timelineVisitedEventBus) {
        this.f10686a = graphQLQueryExecutor;
        this.f10687b = timelineVisitedEventBus;
    }
}
