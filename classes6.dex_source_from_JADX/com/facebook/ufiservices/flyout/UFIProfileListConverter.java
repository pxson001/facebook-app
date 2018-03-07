package com.facebook.ufiservices.flyout;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMutualFriendsConnection;

/* compiled from: customizations */
public final class UFIProfileListConverter {
    public static int m26639a(FlatBufferBuilder flatBufferBuilder, GraphQLActor graphQLActor) {
        if (graphQLActor == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(graphQLActor.b());
        int a2 = flatBufferBuilder.a(graphQLActor.E());
        int b = flatBufferBuilder.b(graphQLActor.H());
        GraphQLMutualFriendsConnection Z = graphQLActor.Z();
        int i = 0;
        if (Z != null) {
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, Z.a(), 0);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        int b2 = flatBufferBuilder.b(graphQLActor.aa());
        GraphQLImage ai = graphQLActor.ai();
        i = 0;
        if (ai != null) {
            int b3 = flatBufferBuilder.b(ai.b());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, ai.a(), 0);
            flatBufferBuilder.b(1, b3);
            flatBufferBuilder.a(2, ai.c(), 0);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i3 = i;
        int b4 = flatBufferBuilder.b(graphQLActor.aw());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, i2);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, i3);
        flatBufferBuilder.b(6, b4);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }
}
