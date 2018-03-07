package com.facebook.feedback.reactions.util;

import com.facebook.api.graphql.reactions.C0143x5a63f940;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLFeedbackReactionInfo;
import com.facebook.graphql.model.GraphQLTopReactionsConnection;
import com.facebook.graphql.model.GraphQLTopReactionsEdge;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: rtt_trigger */
public final class ReactionsModelConversionHelper {
    private static int m3302a(FlatBufferBuilder flatBufferBuilder, GraphQLTopReactionsConnection graphQLTopReactionsConnection) {
        if (graphQLTopReactionsConnection == null) {
            return 0;
        }
        int a;
        ImmutableList a2 = graphQLTopReactionsConnection.a();
        if (a2 != null) {
            int[] iArr = new int[a2.size()];
            for (int i = 0; i < a2.size(); i++) {
                GraphQLTopReactionsEdge graphQLTopReactionsEdge = (GraphQLTopReactionsEdge) a2.get(i);
                int i2 = 0;
                if (graphQLTopReactionsEdge != null) {
                    GraphQLFeedbackReactionInfo a3 = graphQLTopReactionsEdge.a();
                    int i3 = 0;
                    if (a3 != null) {
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, a3.m(), 0);
                        i3 = flatBufferBuilder.d();
                        flatBufferBuilder.d(i3);
                    }
                    int i4 = i3;
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, i4);
                    flatBufferBuilder.a(1, graphQLTopReactionsEdge.j(), 0);
                    i2 = flatBufferBuilder.d();
                    flatBufferBuilder.d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static C0143x5a63f940 m3303a(GraphQLTopReactionsConnection graphQLTopReactionsConnection) {
        if (graphQLTopReactionsConnection == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m3302a(flatBufferBuilder, graphQLTopReactionsConnection);
        if (a == 0) {
            return null;
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new C0143x5a63f940(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
