package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLMediaDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: fb4a_profile_more */
public class GraphQLMedia$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMedia.class, new GraphQLMedia$Deserializer());
    }

    public Object m9012a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLMediaDeserializer.m5339a(jsonParser, (short) 226);
        Object graphQLMedia = new GraphQLMedia();
        ((BaseModel) graphQLMedia).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLMedia instanceof Postprocessable) {
            return ((Postprocessable) graphQLMedia).a();
        }
        return graphQLMedia;
    }
}
