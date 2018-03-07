package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLNamePartDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: extra_target_id */
public class GraphQLNamePart$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNamePart.class, new GraphQLNamePart$Deserializer());
    }

    public Object m9151a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLNamePartDeserializer.m5389a(jsonParser, (short) 273);
        Object graphQLNamePart = new GraphQLNamePart();
        ((BaseModel) graphQLNamePart).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLNamePart instanceof Postprocessable) {
            return ((Postprocessable) graphQLNamePart).a();
        }
        return graphQLNamePart;
    }
}
