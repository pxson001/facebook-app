package com.facebook.video.channelfeed;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory$Builder;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: device_fs */
public class MultiShareNoLinkUtil {
    public static boolean m14667a(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.w() == null || !graphQLStoryAttachment.w().contains(GraphQLStoryAttachmentStyle.MULTI_SHARE_NON_LINK_VIDEO)) {
            return false;
        }
        if (GraphQLStoryAttachmentUtil.p(graphQLStoryAttachment)) {
            return true;
        }
        if (graphQLStoryAttachment.x() == null || graphQLStoryAttachment.x().isEmpty()) {
            return false;
        }
        ImmutableList x = graphQLStoryAttachment.x();
        int size = x.size();
        for (int i = 0; i < size; i++) {
            if (!GraphQLStoryAttachmentUtil.p((GraphQLStoryAttachment) x.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m14670b(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return false;
        }
        return graphQLStoryAttachment.w().contains(GraphQLStoryAttachmentStyle.MULTI_SHARE_FIXED_TEXT);
    }

    public static boolean m14669b(GraphQLStory graphQLStory) {
        if (StoryAttachmentHelper.i(graphQLStory) != null) {
            return false;
        }
        return m14667a(StoryAttachmentHelper.o(graphQLStory));
    }

    public static boolean m14668a(List<FeedProps<GraphQLStory>> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!m14669b((GraphQLStory) ((FeedProps) it.next()).a)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static List<FeedProps<GraphQLStory>> m14671c(GraphQLStory graphQLStory) {
        if (!StoryAttachmentHelper.h(graphQLStory)) {
            return null;
        }
        List<FeedProps<GraphQLStory>> arrayList = new ArrayList();
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        for (GraphQLStoryAttachment graphQLStoryAttachment : StoryAttachmentHelper.i(graphQLStory)) {
            Builder a = Builder.a(graphQLStoryAttachment);
            a.d = null;
            a = a;
            a.q = new ImmutableList.Builder().b(o.w()).b(graphQLStoryAttachment.w()).b();
            GraphQLStoryAttachment a2 = a.a();
            GraphQLStory$Builder a3 = GraphQLStory$Builder.m3407a(graphQLStory);
            a3.f3210m = ImmutableList.of(a2);
            GraphQLStory$Builder graphQLStory$Builder = a3;
            graphQLStory$Builder.f3209l = graphQLStory;
            graphQLStory$Builder = graphQLStory$Builder;
            GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
            builder.i = graphQLStoryAttachment.A();
            graphQLStory$Builder.f3198X = builder.a();
            arrayList.add(FeedProps.c(graphQLStory$Builder.m3419a()));
        }
        return arrayList;
    }

    public static FeedProps<GraphQLStory> m14666a(FeedProps<GraphQLStory> feedProps) {
        if (((GraphQLStory) feedProps.a).L() == null) {
            return feedProps;
        }
        GraphQLStory$Builder a = GraphQLStory$Builder.m3407a((GraphQLStory) feedProps.a);
        a.f3209l = null;
        return FeedProps.c(a.m3419a());
    }
}
