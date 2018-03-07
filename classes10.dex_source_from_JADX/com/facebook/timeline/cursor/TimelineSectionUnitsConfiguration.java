package com.facebook.timeline.cursor;

import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.Configuration;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.connection.iterator.EmptyTailRowIterator;
import com.facebook.graphql.connection.iterator.TailRowIterator;
import com.facebook.graphql.cursor.iterator.BufferRowArrayList;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResponseParser;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.graphql.model.GraphQLTimelineSectionUnitsEdge;
import com.facebook.timeline.datafetcher.TimelineSectionQueryBuilder;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: group_fbid */
public class TimelineSectionUnitsConfiguration extends Configuration {
    private final TimelineSectionQueryBuilder f10391a;

    @Inject
    public TimelineSectionUnitsConfiguration(TimelineSectionQueryBuilder timelineSectionQueryBuilder) {
        this.f10391a = timelineSectionQueryBuilder;
    }

    public final String m10511a() {
        return "TimelineSectionUnits";
    }

    public final GraphQLRequest<GraphQLTimelineSection> m10510a(TailFetchLocation tailFetchLocation) {
        Preconditions.checkArgument(tailFetchLocation.b != null);
        String b = TimelineRowIteratorHelper.m10508b(tailFetchLocation.b);
        String str = tailFetchLocation.b;
        String substring = str.substring(str.indexOf(32) + 1);
        if (substring.isEmpty()) {
            substring = null;
        }
        return GraphQLRequest.a(this.f10391a.m10659a(new Builder().m10742a(b).m10744b(substring).m10745b(), 8));
    }

    public final RowIterator m10509a(TailFetchLocation tailFetchLocation, GraphQLResult graphQLResult) {
        boolean z = false;
        Preconditions.checkArgument(tailFetchLocation.b != null);
        if (graphQLResult.e == null) {
            return new EmptyTailRowIterator(tailFetchLocation);
        }
        GraphQLTimelineSection graphQLTimelineSection = (GraphQLTimelineSection) BufferRowArrayList.a((GraphQLTimelineSection) graphQLResult.e);
        if (graphQLTimelineSection.l() == null || graphQLTimelineSection.l().j() == null) {
            return new EmptyTailRowIterator(tailFetchLocation);
        }
        String b = TimelineRowIteratorHelper.m10508b(tailFetchLocation.b);
        BufferRowArrayList bufferRowArrayList = new BufferRowArrayList();
        GraphQLPageInfo j = graphQLTimelineSection.l().j();
        TailFetchLocation a = TailFetchLocation.a(tailFetchLocation, TimelineRowIteratorHelper.m10507a(b, j.a()), j.b());
        ImmutableList a2 = graphQLTimelineSection.l().a();
        for (int i = 0; i < graphQLTimelineSection.l().a().size(); i++) {
            GraphQLTimelineSectionUnitsEdge graphQLTimelineSectionUnitsEdge = (GraphQLTimelineSectionUnitsEdge) a2.get(i);
            if (graphQLTimelineSectionUnitsEdge.j() != null) {
                bufferRowArrayList.a(graphQLTimelineSectionUnitsEdge.j().u_(), graphQLTimelineSectionUnitsEdge.j().getClass(), a.a(i), GraphQLResponseParser.a(graphQLTimelineSectionUnitsEdge.j()), 0);
            }
        }
        ImmutableList of = ImmutableList.of(TailFetchLocation.a(a, a2.size()));
        if (!bufferRowArrayList.b()) {
            z = true;
        }
        return new TailRowIterator(graphQLTimelineSection, bufferRowArrayList, of, z, a);
    }
}
