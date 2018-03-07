package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEntityDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: intern_match_manager_suggest_phone */
public class GraphQLEntity$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEntity.class, new GraphQLEntity$Deserializer());
    }

    public Object m7037a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEntityDeserializer.m4764a(jsonParser, (short) 135);
        Object graphQLEntity = new GraphQLEntity();
        ((BaseModel) graphQLEntity).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEntity instanceof Postprocessable) {
            return ((Postprocessable) graphQLEntity).a();
        }
        return graphQLEntity;
    }
}
