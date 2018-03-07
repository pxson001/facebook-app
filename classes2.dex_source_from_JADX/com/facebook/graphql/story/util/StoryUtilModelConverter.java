package com.facebook.graphql.story.util;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLSubstoriesConnection;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLModels.HasFeedbackTargetOfTypeGraphQLModel;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: hearts */
public final class StoryUtilModelConverter {
    public static C0842x298717ad m28877a(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        int b = m28878b(flatBufferBuilder, graphQLStory);
        if (b == 0) {
            return null;
        }
        flatBufferBuilder.m21513d(b);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
        wrap.position(0);
        return new C0842x298717ad(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public static int m28873a(FlatBufferBuilder flatBufferBuilder, GraphQLNode graphQLNode) {
        if (graphQLNode == null) {
            return 0;
        }
        int a = flatBufferBuilder.m21475a(graphQLNode.m23390j());
        int b = flatBufferBuilder.m21502b(graphQLNode.dp());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m28874a(FlatBufferBuilder flatBufferBuilder, GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return 0;
        }
        int a;
        ImmutableList M = graphQLStory.m22327M();
        if (M != null) {
            int[] iArr = new int[M.size()];
            for (int i = 0; i < M.size(); i++) {
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(i);
                int i2 = 0;
                if (graphQLStoryAttachment != null) {
                    int d = flatBufferBuilder.m21512d(graphQLStoryAttachment.m23984w());
                    int a2 = m28873a(flatBufferBuilder, graphQLStoryAttachment.m23987z());
                    flatBufferBuilder.m21510c(2);
                    flatBufferBuilder.m21507b(0, d);
                    flatBufferBuilder.m21507b(1, a2);
                    i2 = flatBufferBuilder.m21511d();
                    flatBufferBuilder.m21513d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.m21487a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        int d2 = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d2);
        return d2;
    }

    private static int m28875a(FlatBufferBuilder flatBufferBuilder, GraphQLSubstoriesConnection graphQLSubstoriesConnection) {
        if (graphQLSubstoriesConnection == null) {
            return 0;
        }
        int a;
        ImmutableList j = graphQLSubstoriesConnection.m22608j();
        if (j != null) {
            int[] iArr = new int[j.size()];
            for (int i = 0; i < j.size(); i++) {
                iArr[i] = m28874a(flatBufferBuilder, (GraphQLStory) j.get(i));
            }
            a = flatBufferBuilder.m21487a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m28878b(FlatBufferBuilder flatBufferBuilder, GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return 0;
        }
        int i;
        int a;
        ImmutableList b = graphQLStory.m22349b();
        if (b != null) {
            int[] iArr = new int[b.size()];
            for (i = 0; i < b.size(); i++) {
                GraphQLActor graphQLActor = (GraphQLActor) b.get(i);
                int i2 = 0;
                if (graphQLActor != null) {
                    int a2 = flatBufferBuilder.m21475a(graphQLActor.m23790b());
                    int b2 = flatBufferBuilder.m21502b(graphQLActor.m23765H());
                    flatBufferBuilder.m21510c(2);
                    flatBufferBuilder.m21507b(0, a2);
                    flatBufferBuilder.m21507b(1, b2);
                    i2 = flatBufferBuilder.m21511d();
                    flatBufferBuilder.m21513d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.m21487a(iArr, true);
        } else {
            a = 0;
        }
        i = m28875a(flatBufferBuilder, graphQLStory.m22321G());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, i);
        flatBufferBuilder.m21498a(2, graphQLStory.ac());
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    public static HasFeedbackTargetOfTypeGraphQLModel m28876a(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        int i = 0;
        if (graphQLStoryAttachment != null) {
            int a = m28873a(flatBufferBuilder, graphQLStoryAttachment.m23987z());
            flatBufferBuilder.m21510c(1);
            flatBufferBuilder.m21507b(0, a);
            i = flatBufferBuilder.m21511d();
            flatBufferBuilder.m21513d(i);
        }
        int i2 = i;
        if (i2 == 0) {
            return null;
        }
        flatBufferBuilder.m21513d(i2);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
        wrap.position(0);
        return new HasFeedbackTargetOfTypeGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
