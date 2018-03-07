package com.facebook.composer.feedattachment.minutiae;

import com.facebook.composer.feedattachment.minutiae.MinutiaeAttachmentController.SubController;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: getView */
public class MinutiaeAttachmentControllerMap {
    private final Map<GraphQLStoryAttachmentStyle, Lazy<? extends SubController>> f6528a;
    public final ImmutableList<GraphQLStoryAttachmentStyle> f6529b = ImmutableList.copyOf(this.f6528a.keySet());

    @Inject
    public MinutiaeAttachmentControllerMap(Lazy<MinutiaeSimplePageComposerAttachmentController> lazy, Lazy<EventComposerAttachmentController> lazy2) {
        this.f6528a = ImmutableMap.of(GraphQLStoryAttachmentStyle.OG_COMPOSER_SIMPLE, lazy, GraphQLStoryAttachmentStyle.FALLBACK, lazy, GraphQLStoryAttachmentStyle.AVATAR, lazy, GraphQLStoryAttachmentStyle.MINUTIAE_EVENT, lazy2, GraphQLStoryAttachmentStyle.EVENT, lazy2);
    }

    public final boolean m7987a(List<GraphQLStoryAttachmentStyle> list) {
        return m7986c(list) != null;
    }

    @Nullable
    public final SubController m7988b(List<GraphQLStoryAttachmentStyle> list) {
        GraphQLStoryAttachmentStyle c = m7986c(list);
        if (c == null) {
            return null;
        }
        return (SubController) ((Lazy) this.f6528a.get(c)).get();
    }

    @Nullable
    private GraphQLStoryAttachmentStyle m7986c(List<GraphQLStoryAttachmentStyle> list) {
        for (GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle : list) {
            if (this.f6528a.containsKey(graphQLStoryAttachmentStyle)) {
                return graphQLStoryAttachmentStyle;
            }
        }
        return null;
    }
}
