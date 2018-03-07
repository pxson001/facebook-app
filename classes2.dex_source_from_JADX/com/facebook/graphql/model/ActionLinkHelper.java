package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: logging_client_event_graph_api_android */
public class ActionLinkHelper {
    @Nullable
    public static GraphQLStoryActionLink m22938a(@Nullable List<GraphQLStoryActionLink> list, int i) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            GraphQLObjectType a = ((GraphQLStoryActionLink) list.get(i2)).m22901a();
            if (a != null && a.m22301g() == i) {
                return (GraphQLStoryActionLink) list.get(i2);
            }
        }
        return null;
    }

    @Nullable
    public static GraphQLStoryActionLink m22934a(@Nullable GraphQLStory graphQLStory, int i) {
        if (graphQLStory == null) {
            return null;
        }
        return m22938a(graphQLStory.m22319E(), i);
    }

    @Nullable
    public static GraphQLStoryActionLink m22936a(GraphQLStoryAttachment graphQLStoryAttachment, int i) {
        return m22938a(graphQLStoryAttachment.m23971j(), i);
    }

    @Nullable
    public static GraphQLStoryActionLink m22937a(GraphQLStoryAttachment graphQLStoryAttachment, int[] iArr) {
        GraphQLStoryActionLink graphQLStoryActionLink;
        List j = graphQLStoryAttachment.m23971j();
        if (j == null || iArr.length == 0) {
            graphQLStoryActionLink = null;
        } else {
            int size = j.size();
            loop0:
            for (int i = 0; i < size; i++) {
                GraphQLObjectType a = ((GraphQLStoryActionLink) j.get(i)).m22901a();
                if (a != null) {
                    for (int i2 : iArr) {
                        if (a.m22301g() == i2) {
                            graphQLStoryActionLink = (GraphQLStoryActionLink) j.get(i);
                            break loop0;
                        }
                    }
                    continue;
                }
            }
            graphQLStoryActionLink = null;
        }
        return graphQLStoryActionLink;
    }

    public static boolean m22939b(GraphQLStoryAttachment graphQLStoryAttachment, int i) {
        return m22936a(graphQLStoryAttachment, i) != null;
    }

    public static GraphQLStoryActionLink m22935a(GraphQLStoryAttachment graphQLStoryAttachment) {
        ImmutableList j = graphQLStoryAttachment.m23971j();
        return (j == null || j.size() <= 0) ? null : (GraphQLStoryActionLink) j.get(0);
    }
}
