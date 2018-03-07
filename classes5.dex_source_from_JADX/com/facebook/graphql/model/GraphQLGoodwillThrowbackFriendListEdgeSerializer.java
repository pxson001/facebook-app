package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: global_brand_v2_unlinked_child_fan_restoration */
public class GraphQLGoodwillThrowbackFriendListEdgeSerializer extends JsonSerializer<GraphQLGoodwillThrowbackFriendListEdge> {
    public final void m8010a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackFriendListEdge__JsonHelper.m8012a(jsonGenerator, (GraphQLGoodwillThrowbackFriendListEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackFriendListEdge.class, new GraphQLGoodwillThrowbackFriendListEdgeSerializer());
    }
}
