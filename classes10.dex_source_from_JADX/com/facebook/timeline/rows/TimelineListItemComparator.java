package com.facebook.timeline.rows;

import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.feed.rows.core.ListItemComparator;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.units.model.TimelineSectionData.LoadingIndicator;
import com.facebook.timeline.units.model.TimelineSectionData.TimelinePostsLabel;
import com.facebook.timeline.units.model.TimelineSectionData.TimelineSectionLabel;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_theme_selector_event_description */
public class TimelineListItemComparator<T> implements ListItemComparator<T> {
    public final OptimisticStoryStateCache f12616a;

    public static TimelineListItemComparator m12577a(InjectorLike injectorLike) {
        return new TimelineListItemComparator(OptimisticStoryStateCache.a(injectorLike));
    }

    @Inject
    public TimelineListItemComparator(OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f12616a = optimisticStoryStateCache;
    }

    public final boolean m12580a(T t, @Nullable T t2) {
        if (m12578b(t, t2)) {
            boolean z;
            GraphQLStory graphQLStory = (GraphQLStory) t;
            GraphQLStory graphQLStory2 = (GraphQLStory) t2;
            boolean z2;
            if (graphQLStory.g() == null) {
                z2 = false;
                if (!(this.f12616a.a(graphQLStory) == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || this.f12616a.a(graphQLStory2) == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || graphQLStory.V() != graphQLStory2.V())) {
                    z2 = true;
                }
                z = z2;
            } else {
                z2 = graphQLStory == graphQLStory2 || graphQLStory.g().equals(graphQLStory2.g());
                z = z2;
            }
            return z;
        }
        if (!m12579c(t, t2)) {
            Object obj;
            if ((t instanceof TimelineSectionLabel) && (t2 instanceof TimelineSectionLabel)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                obj = ((t instanceof LoadingIndicator) && (t2 instanceof LoadingIndicator)) ? 1 : null;
                if (obj == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean m12581a(T t, T t2, long j) {
        if (m12578b(t, t2)) {
            GraphQLStory graphQLStory = (GraphQLStory) t;
            GraphQLStory graphQLStory2 = (GraphQLStory) t2;
            boolean z = false;
            if (graphQLStory.g() != null && graphQLStory.g().equals(graphQLStory2.g()) && graphQLStory.T_() == j) {
                z = true;
            }
            return z;
        } else if (!m12579c(t, t2)) {
            return false;
        } else {
            return ((TimelinePostsLabel) t).f12784a == ((TimelinePostsLabel) t2).f12784a;
        }
    }

    private static boolean m12578b(Object obj, Object obj2) {
        return (obj instanceof GraphQLStory) && (obj2 instanceof GraphQLStory);
    }

    private static boolean m12579c(Object obj, Object obj2) {
        return (obj instanceof TimelinePostsLabel) && (obj2 instanceof TimelinePostsLabel);
    }
}
