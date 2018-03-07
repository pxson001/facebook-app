package com.facebook.controller.mutation.util;

import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLNode.Builder;
import com.facebook.graphql.model.GraphQLTimelineAppCollection;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: sample_rate */
public class AttachmentTargetMutator {
    public static AttachmentTargetMutator m10674a(InjectorLike injectorLike) {
        return new AttachmentTargetMutator();
    }

    public static GraphQLNode m10675a(GraphQLNode graphQLNode, @Nullable String str, boolean z) {
        Preconditions.checkNotNull(graphQLNode);
        if (StringUtil.m3589a((CharSequence) str)) {
            return graphQLNode;
        }
        Builder a = Builder.a(graphQLNode);
        if (!graphQLNode.jp().isEmpty()) {
            a.kG = m10677a(graphQLNode.jp(), graphQLNode.jo(), str, z);
            return a.a();
        } else if (graphQLNode.fZ() == null || graphQLNode.fZ().jp().isEmpty()) {
            return graphQLNode;
        } else {
            Builder a2 = Builder.a(graphQLNode.fZ());
            a2.kG = m10677a(graphQLNode.fZ().jp(), graphQLNode.fZ().jo(), str, z);
            a.gR = a2.a();
            return a.a();
        }
    }

    private static ImmutableList<GraphQLTimelineAppCollection> m10677a(ImmutableList<GraphQLTimelineAppCollection> immutableList, ImmutableList<GraphQLTimelineAppCollection> immutableList2, String str, boolean z) {
        if (z) {
            return m10676a((ImmutableList) immutableList, (ImmutableList) immutableList2, str);
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList2.size();
        for (int i = 0; i < size; i++) {
            GraphQLTimelineAppCollection graphQLTimelineAppCollection = (GraphQLTimelineAppCollection) immutableList2.get(i);
            if (!Objects.equal(graphQLTimelineAppCollection.mo2915b(), str)) {
                builder.m1069c(graphQLTimelineAppCollection);
            }
        }
        return builder.m1068b();
    }

    private static ImmutableList<GraphQLTimelineAppCollection> m10676a(ImmutableList<GraphQLTimelineAppCollection> immutableList, ImmutableList<GraphQLTimelineAppCollection> immutableList2, String str) {
        GraphQLTimelineAppCollection graphQLTimelineAppCollection;
        if (StringUtil.m3589a((CharSequence) str) || immutableList == null) {
            graphQLTimelineAppCollection = null;
        } else {
            for (GraphQLTimelineAppCollection graphQLTimelineAppCollection2 : immutableList) {
                if (str.equals(graphQLTimelineAppCollection2.mo2915b())) {
                    break;
                }
            }
            graphQLTimelineAppCollection2 = null;
        }
        GraphQLTimelineAppCollection graphQLTimelineAppCollection3 = graphQLTimelineAppCollection2;
        if (graphQLTimelineAppCollection3 == null) {
            return immutableList2;
        }
        return ImmutableList.builder().m1065b((Iterable) immutableList2).m1069c(graphQLTimelineAppCollection3).m1068b();
    }
}
