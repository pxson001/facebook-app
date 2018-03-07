package com.facebook.timeline.cursor;

import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.Configuration;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.connection.iterator.EmptyTailRowIterator;
import com.facebook.graphql.connection.iterator.TailRowIterator;
import com.facebook.graphql.cursor.database.PageInfo;
import com.facebook.graphql.cursor.database.SortKeyHelper;
import com.facebook.graphql.cursor.iterator.BufferRowArrayList;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResponseParser;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.graphql.model.GraphQLTimelineSectionUnitsEdge;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.inject.Assisted;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryBuilder;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: group_for_sale_posts */
public class TimelineFirstUnitsSelfConfiguration extends Configuration {
    private final FetchTimelineFirstUnitsParams f10389a;
    private final TimelineFirstUnitsQueryBuilder f10390b;

    @Inject
    public TimelineFirstUnitsSelfConfiguration(@Assisted FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, TimelineFirstUnitsQueryBuilder timelineFirstUnitsQueryBuilder) {
        this.f10389a = fetchTimelineFirstUnitsParams;
        this.f10390b = timelineFirstUnitsQueryBuilder;
    }

    public final String m10505a() {
        return "TimelineFirstUnitsSelf";
    }

    public final GraphQLRequest<GraphQLUser> m10504a(TailFetchLocation tailFetchLocation) {
        Preconditions.checkArgument(tailFetchLocation.b == null);
        return GraphQLRequest.a(this.f10390b.m10589a(this.f10389a));
    }

    public final RowIterator m10503a(TailFetchLocation tailFetchLocation, GraphQLResult graphQLResult) {
        Preconditions.checkArgument(tailFetchLocation.b == null);
        if (graphQLResult.d() == null) {
            return new EmptyTailRowIterator(tailFetchLocation);
        }
        GraphQLUser graphQLUser = (GraphQLUser) BufferRowArrayList.a((GraphQLUser) graphQLResult.d());
        if (graphQLUser == null || graphQLUser.bc() == null || graphQLUser.bc().a().isEmpty() || graphQLUser.I() == null || graphQLUser.I().a().isEmpty()) {
            return new EmptyTailRowIterator(tailFetchLocation);
        }
        GraphQLTimelineSection graphQLTimelineSection = (GraphQLTimelineSection) graphQLUser.I().a().get(0);
        if (graphQLTimelineSection.l() == null || graphQLTimelineSection.l().j() == null) {
            return new EmptyTailRowIterator(tailFetchLocation);
        }
        TailFetchLocation tailFetchLocation2;
        BufferRowArrayList bufferRowArrayList = new BufferRowArrayList();
        Builder builder = new Builder();
        ImmutableList a = graphQLUser.bc().a();
        int size = a.size() - 1;
        Object obj = null;
        while (size >= 0) {
            GraphQLTimelineSection graphQLTimelineSection2 = (GraphQLTimelineSection) a.get(size);
            TailFetchLocation a2 = TailFetchLocation.a(TailFetchLocation.a(graphQLResult.b()), TimelineRowIteratorHelper.m10506a(graphQLTimelineSection2.j()), true);
            Preconditions.checkState(a2.b != null);
            bufferRowArrayList.a(graphQLTimelineSection2.u_(), graphQLTimelineSection2.getClass(), SortKeyHelper.b(a2.a, 0), null, size == 0 ? 2 : 1);
            builder.c(new PageInfo(SortKeyHelper.d(a2.a), SortKeyHelper.e(a2.a), null, a2.b, true, a2.c, 1));
            size--;
            tailFetchLocation2 = a2;
        }
        tailFetchLocation2 = (TailFetchLocation) Preconditions.checkNotNull(obj);
        GraphQLPageInfo j = graphQLTimelineSection.l().j();
        TailFetchLocation a3 = TailFetchLocation.a(tailFetchLocation2, TimelineRowIteratorHelper.m10507a(graphQLTimelineSection.j(), j.a()), j.b());
        ImmutableList a4 = graphQLTimelineSection.l().a();
        builder.c(TailFetchLocation.a(a3, a4.size()));
        for (int i = 0; i < a4.size(); i++) {
            GraphQLTimelineSectionUnitsEdge graphQLTimelineSectionUnitsEdge = (GraphQLTimelineSectionUnitsEdge) a4.get(i);
            if (graphQLTimelineSectionUnitsEdge.j() != null) {
                bufferRowArrayList.a(graphQLTimelineSectionUnitsEdge.j().u_(), graphQLTimelineSectionUnitsEdge.j().getClass(), a3.a(i), GraphQLResponseParser.a(graphQLTimelineSectionUnitsEdge.j()), 0);
            }
        }
        return new TailRowIterator(graphQLUser, bufferRowArrayList, builder.b(), !bufferRowArrayList.b(), a3);
    }
}
