package com.facebook.ufiservices.ui;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLMutualFriendsConnection;
import com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLModels.ProfileListFriendingControllerGraphQLModel;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: curationSurface */
public final class ProfileListConverter {
    @Nullable
    public static ProfileListFriendingControllerGraphQLModel m26785a(GraphQLActor graphQLActor) {
        if (graphQLActor == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int i = 0;
        if (graphQLActor != null) {
            GraphQLObjectType b = graphQLActor.b();
            if (b != null && b.g() == 2645995) {
                int a = flatBufferBuilder.a(graphQLActor.E());
                int b2 = flatBufferBuilder.b(graphQLActor.H());
                GraphQLMutualFriendsConnection Z = graphQLActor.Z();
                int i2 = 0;
                if (Z != null) {
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, Z.a(), 0);
                    i2 = flatBufferBuilder.d();
                    flatBufferBuilder.d(i2);
                }
                int i3 = i2;
                int b3 = flatBufferBuilder.b(graphQLActor.aa());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, i3);
                flatBufferBuilder.b(3, b3);
                i = flatBufferBuilder.d();
                flatBufferBuilder.d(i);
            }
        }
        int i4 = i;
        if (i4 == 0) {
            return null;
        }
        flatBufferBuilder.d(i4);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new ProfileListFriendingControllerGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
