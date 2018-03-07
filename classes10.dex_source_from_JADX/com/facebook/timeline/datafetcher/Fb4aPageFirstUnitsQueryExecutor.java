package com.facebook.timeline.datafetcher;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import javax.inject.Inject;

/* compiled from: group_edit_name_description_data */
public class Fb4aPageFirstUnitsQueryExecutor extends PageFirstUnitsQueryExecutor {
    @Inject
    public Fb4aPageFirstUnitsQueryExecutor(GraphQLQueryExecutor graphQLQueryExecutor, TimelineFirstUnitsQueryBuilder timelineFirstUnitsQueryBuilder) {
        super(graphQLQueryExecutor, timelineFirstUnitsQueryBuilder);
    }

    public final FirstUnitsObservables mo506a(boolean z, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext) {
        return m10520a(fetchTimelineFirstUnitsParams, callerContext, GraphQLCachePolicy.c);
    }

    public final FirstUnitsObservables mo505a(GraphQLBatchRequest graphQLBatchRequest, int i, boolean z, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext) {
        throw new UnsupportedOperationException("fetchFirstUnits() method should be used instead of this one for pages.");
    }
}
