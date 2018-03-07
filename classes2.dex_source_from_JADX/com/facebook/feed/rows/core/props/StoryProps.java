package com.facebook.feed.rows.core.props;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.GraphQLSubstoriesConnection;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: instant_articles_ads_x_out_ui */
public class StoryProps {
    @Nullable
    public static FeedUnit m27454a(FeedProps<GraphQLStory> feedProps) {
        Flattenable c = feedProps.m19807c();
        if (c == null || !(c instanceof FeedUnit)) {
            return null;
        }
        return (FeedUnit) c;
    }

    @Nullable
    public static GraphQLStory m27456c(FeedProps<GraphQLStory> feedProps) {
        Flattenable c = feedProps.m19807c();
        if (c == null || !(c instanceof GraphQLStory)) {
            return null;
        }
        return (GraphQLStory) c;
    }

    public static GraphQLStory m27457d(FeedProps<GraphQLStory> feedProps) {
        return (GraphQLStory) m27458e(feedProps).f13444a;
    }

    @Nullable
    public static FeedProps<GraphQLStory> m27453a(FeedProps<GraphQLStory> feedProps, String str) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (graphQLStory.mo2507g() != null && Objects.equal(graphQLStory.mo2507g(), str)) {
            return feedProps;
        }
        if (graphQLStory.m22326L() != null) {
            FeedProps<GraphQLStory> a = m27453a(feedProps.m19803a(graphQLStory.m22326L()), str);
            if (a != null) {
                return a;
            }
        }
        if (StoryHierarchyHelper.m27434a(graphQLStory) != null) {
            ImmutableList j = StoryHierarchyHelper.m27434a(graphQLStory).m22608j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                FeedProps<GraphQLStory> a2 = m27453a(feedProps.m19803a((GraphQLStory) j.get(i)), str);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }

    @Nullable
    public static FeedProps<GraphQLStoryAttachment> m27461i(FeedProps<GraphQLStory> feedProps) {
        return feedProps.m19803a(StoryAttachmentHelper.m28042o((GraphQLStory) feedProps.f13444a));
    }

    public static FeedUnit m27459f(FeedProps<GraphQLStory> feedProps) {
        Flattenable b = feedProps.m19806b();
        if (b == null || !(b instanceof GraphQLStorySet)) {
            return m27457d(feedProps);
        }
        return (GraphQLStorySet) b;
    }

    @Nullable
    public static GraphQLStorySet m27460h(FeedProps<GraphQLStory> feedProps) {
        Flattenable c = feedProps.m19807c();
        if (c == null || !(c instanceof GraphQLStorySet)) {
            return null;
        }
        return (GraphQLStorySet) c;
    }

    public static FeedProps<GraphQLStory> m27462j(FeedProps<GraphQLStory> feedProps) {
        Preconditions.checkNotNull(feedProps);
        Flattenable flattenable = (GraphQLStory) feedProps.f13444a;
        if (flattenable.m22326L() == null) {
            return feedProps;
        }
        Builder builder = new Builder();
        builder.m1065b(feedProps.m19808d().reverse());
        while (flattenable.m22326L() != null) {
            builder.m1069c(flattenable);
            flattenable = flattenable.m22326L();
        }
        return FeedProps.m19801a(flattenable, builder.m1068b().reverse());
    }

    public static boolean m27463k(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory c = m27456c(feedProps);
        if (!(c == null || StoryHierarchyHelper.m27438e(c))) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
            GraphQLStory c2 = m27456c(feedProps);
            Object obj = (c2 == null || !StoryHierarchyHelper.m27437d(c2) || c2.m22326L() == graphQLStory) ? null : 1;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static FeedProps<GraphQLStory> m27455b(FeedProps<GraphQLStory> feedProps) {
        FeedProps<GraphQLStory> feedProps2 = feedProps.f13445b;
        return (feedProps2 == null || !(feedProps2.f13444a instanceof GraphQLStory)) ? null : feedProps2;
    }

    public static FeedProps<GraphQLStory> m27458e(FeedProps<GraphQLStory> feedProps) {
        while (feedProps.f13445b != null && (feedProps.f13445b.f13444a instanceof GraphQLStory)) {
            feedProps = feedProps.f13445b;
        }
        return feedProps;
    }

    public static boolean m27464m(@Nullable FeedProps<GraphQLStory> feedProps) {
        if (feedProps == null) {
            return false;
        }
        return StoryHierarchyHelper.m27438e((GraphQLStory) feedProps.f13444a);
    }

    public static boolean m27465n(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory c = m27456c(feedProps);
        boolean z = (((GraphQLStory) feedProps.f13444a).ay() == null || m27464m(feedProps)) ? false : true;
        if (c == null) {
            return z;
        }
        if (m27465n(m27455b(feedProps))) {
            return false;
        }
        return z || c.ay() != null;
    }

    public static boolean m27466p(FeedProps<GraphQLStory> feedProps) {
        if (((GraphQLStory) feedProps.f13444a).mo2895u()) {
            return true;
        }
        ImmutableList d = feedProps.m19808d();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            Flattenable flattenable = (Flattenable) d.get(i);
            if (!(flattenable instanceof GraphQLStory)) {
                return false;
            }
            if (((GraphQLStory) flattenable).mo2895u()) {
                return true;
            }
        }
        return false;
    }

    public static String m27467r(FeedProps<GraphQLStory> feedProps) {
        Object obj = 1;
        GraphQLStory c = m27456c(feedProps);
        if (c == null) {
            return null;
        }
        GraphQLSubstoriesConnection a = StoryHierarchyHelper.m27434a(c);
        if (!StoryHierarchyHelper.m27437d(c) || c.aD() <= 1 || a == GraphQLHelper.f15766g) {
            return null;
        }
        if (!c.aC().contains(GraphQLSubstoriesGroupingReason.COMPACTNESS) || c.aC().contains(GraphQLSubstoriesGroupingReason.POST_CHANNEL)) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        ImmutableList j = a.m22608j();
        if (j == null || j.isEmpty()) {
            return null;
        }
        ObjectMapper i = FbObjectMapper.m6612i();
        for (int i2 = 0; i2 < j.size(); i2++) {
            if (((GraphQLStory) feedProps.f13444a).equals(j.get(i2))) {
                return i.m6668e().m5129a("scroll_index", i2).toString();
            }
        }
        return null;
    }
}
