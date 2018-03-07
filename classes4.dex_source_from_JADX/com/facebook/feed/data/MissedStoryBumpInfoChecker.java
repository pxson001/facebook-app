package com.facebook.feed.data;

import android.util.Pair;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.logging.ViewportLoggingHelper;
import com.facebook.graphql.enums.GraphQLBumpReason;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: webrtc_publish */
public class MissedStoryBumpInfoChecker {
    private final ViewportLoggingHelper f145a;
    private final Clock f146b;

    public static MissedStoryBumpInfoChecker m184a(InjectorLike injectorLike) {
        return new MissedStoryBumpInfoChecker((Clock) SystemClockMethodAutoProvider.a(injectorLike), ViewportLoggingHelper.a(injectorLike));
    }

    @Inject
    public MissedStoryBumpInfoChecker(Clock clock, ViewportLoggingHelper viewportLoggingHelper) {
        this.f146b = clock;
        this.f145a = viewportLoggingHelper;
    }

    private boolean m185a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, long j) {
        if (!(graphQLFeedUnitEdge.c() instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) graphQLFeedUnitEdge.c();
        if (graphQLStory != null) {
            ViewportLoggingHelper viewportLoggingHelper = this.f145a;
            Preconditions.checkNotNull(graphQLStory);
            Object obj = (!viewportLoggingHelper.b(graphQLStory) || viewportLoggingHelper.a.a(graphQLStory).e >= j) ? null : 1;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public final Pair<Integer, Integer> m186a(FetchFeedResult fetchFeedResult, FeedUnitCollection feedUnitCollection, long j) {
        if (fetchFeedResult.d() == null) {
            return new Pair(Integer.valueOf(0), Integer.valueOf(0));
        }
        ImmutableList d = fetchFeedResult.d();
        int size = d.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < size) {
            int i4;
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) d.get(i);
            if (GraphQLBumpReason.BUMP_UNREAD.equals(graphQLFeedUnitEdge.m())) {
                i3++;
                List a = feedUnitCollection.a(graphQLFeedUnitEdge.c().g());
                if (a.isEmpty()) {
                    i4 = i2 + 1;
                    i2 = i3;
                } else if (m185a((GraphQLFeedUnitEdge) a.get(0), j)) {
                    i4 = i2 + 1;
                    i2 = i3;
                }
                i++;
                i3 = i2;
                i2 = i4;
            }
            i4 = i2;
            i2 = i3;
            i++;
            i3 = i2;
            i2 = i4;
        }
        return new Pair(Integer.valueOf(i3), Integer.valueOf(i2));
    }
}
