package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLNameDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: extras */
public class GraphQLName$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLName.class, new GraphQLName$Deserializer());
    }

    public Object m9148a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLNameDeserializer.m5384a(jsonParser, (short) 272);
        Object graphQLName = new GraphQLName();
        ((BaseModel) graphQLName).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLName instanceof Postprocessable) {
            return ((Postprocessable) graphQLName).a();
        }
        return graphQLName;
    }
}
