package com.facebook.api.feed.data;

import com.facebook.api.feed.data.AppendOnlyGraphQLObjectCollectionGraphQLModels.AppendOnlyPageInfoGraphQLModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLPageInfo;
import java.nio.ByteBuffer;

/* compiled from: at index  */
public final class AppendOnlyGraphQLObjectCollectionConverter {
    public static AppendOnlyPageInfoGraphQLModel m14662a(GraphQLPageInfo graphQLPageInfo) {
        if (graphQLPageInfo == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int i = 0;
        if (graphQLPageInfo != null) {
            int b = flatBufferBuilder.b(graphQLPageInfo.a());
            int b2 = flatBufferBuilder.b(graphQLPageInfo.v_());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, graphQLPageInfo.b());
            flatBufferBuilder.a(2, graphQLPageInfo.c());
            flatBufferBuilder.b(3, b2);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        if (i2 == 0) {
            return null;
        }
        flatBufferBuilder.d(i2);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new AppendOnlyPageInfoGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
