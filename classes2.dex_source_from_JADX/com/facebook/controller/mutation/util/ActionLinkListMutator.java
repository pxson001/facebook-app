package com.facebook.controller.mutation.util;

import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import java.util.List;

/* compiled from: samples_to_latency_change */
public class ActionLinkListMutator {
    public static ActionLinkListMutator m10664a(InjectorLike injectorLike) {
        return new ActionLinkListMutator();
    }

    public final ImmutableList<GraphQLStoryActionLink> m10670a(List<GraphQLStoryActionLink> list, GraphQLStoryActionLink graphQLStoryActionLink) {
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(graphQLStoryActionLink);
        Builder builder = new Builder();
        for (Object obj : list) {
            Object obj2;
            Object obj3 = 1;
            Object obj4 = (obj2.m22901a() == null || !obj2.m22901a().equals(graphQLStoryActionLink.m22901a())) ? null : 1;
            Object obj5;
            if (obj2.ab() == null || (graphQLStoryActionLink.ab() != null && obj2.ab().ae().equals(graphQLStoryActionLink.ab().ae()))) {
                obj5 = 1;
            } else {
                obj5 = null;
            }
            boolean equal = Objects.equal(obj2.m22913r(), graphQLStoryActionLink.m22913r());
            if (obj4 == null || r7 == null || !equal) {
                obj3 = null;
            }
            if (obj3 != null) {
                obj2 = graphQLStoryActionLink;
            }
            builder.m1069c(obj2);
        }
        return builder.m1068b();
    }

    public final ImmutableList<GraphQLStoryActionLink> m10668a(ImmutableList<GraphQLStoryActionLink> immutableList, GraphQLSavedState graphQLSavedState) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) immutableList.get(i);
            if (graphQLStoryActionLink.m22901a() != null && graphQLStoryActionLink.m22901a().m22301g() == -908457779 && GraphQLHelper.m22484a(graphQLStoryActionLink)) {
                builder.m1069c(m10665a(graphQLStoryActionLink, graphQLSavedState));
            } else {
                builder.m1069c(graphQLStoryActionLink);
            }
        }
        return builder.m1068b();
    }

    public final ImmutableList<GraphQLStoryActionLink> m10669a(ImmutableList<GraphQLStoryActionLink> immutableList, ImmutableMap<String, Boolean> immutableMap) {
        if (immutableList.isEmpty()) {
            return immutableList;
        }
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) immutableList.get(i);
            if (graphQLStoryActionLink.m22901a() != null && graphQLStoryActionLink.m22901a().m22301g() == -908457779 && GraphQLHelper.m22484a(graphQLStoryActionLink) && immutableMap.containsKey(graphQLStoryActionLink.m22883J().dp())) {
                GraphQLSavedState graphQLSavedState;
                if (((Boolean) immutableMap.get(graphQLStoryActionLink.m22883J().dp())).booleanValue()) {
                    graphQLSavedState = GraphQLSavedState.SAVED;
                } else {
                    graphQLSavedState = GraphQLSavedState.NOT_SAVED;
                }
                builder.m1069c(m10665a(graphQLStoryActionLink, graphQLSavedState));
            } else {
                builder.m1069c(graphQLStoryActionLink);
            }
        }
        return builder.m1068b();
    }

    public static ImmutableList<GraphQLStoryActionLink> m10666a(ImmutableList<GraphQLStoryActionLink> immutableList, GraphQLStoryActionLink graphQLStoryActionLink) {
        if (!m10667a(graphQLStoryActionLink)) {
            return immutableList;
        }
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryActionLink graphQLStoryActionLink2 = (GraphQLStoryActionLink) immutableList.get(i);
            if (m10667a(graphQLStoryActionLink2)) {
                builder.m1069c(graphQLStoryActionLink);
            } else {
                builder.m1069c(graphQLStoryActionLink2);
            }
        }
        return builder.m1068b();
    }

    private static boolean m10667a(GraphQLStoryActionLink graphQLStoryActionLink) {
        if (graphQLStoryActionLink == null || graphQLStoryActionLink.m22901a() == null || graphQLStoryActionLink.m22901a().m22301g() != -1103690310) {
            return false;
        }
        return true;
    }

    private static GraphQLStoryActionLink m10665a(GraphQLStoryActionLink graphQLStoryActionLink, GraphQLSavedState graphQLSavedState) {
        GraphQLStoryActionLink.Builder a = GraphQLStoryActionLink.Builder.a(graphQLStoryActionLink);
        a.K = GraphQLNode.Builder.a(graphQLStoryActionLink.m22883J()).a(graphQLSavedState).a();
        return a.a();
    }
}
