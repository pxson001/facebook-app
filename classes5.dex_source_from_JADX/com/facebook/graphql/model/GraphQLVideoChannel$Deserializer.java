package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLVideoChannelDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Tigon */
public class GraphQLVideoChannel$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoChannel.class, new GraphQLVideoChannel$Deserializer());
    }

    public Object m22435a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLVideoChannelDeserializer.m6177a(jsonParser, (short) 246);
        Object graphQLVideoChannel = new GraphQLVideoChannel();
        ((BaseModel) graphQLVideoChannel).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLVideoChannel instanceof Postprocessable) {
            return ((Postprocessable) graphQLVideoChannel).a();
        }
        return graphQLVideoChannel;
    }
}
