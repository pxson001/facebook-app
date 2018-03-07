package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEntityAtRangeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: intern_match_manager_suggest_match */
public class GraphQLEntityAtRange$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEntityAtRange.class, new GraphQLEntityAtRange$Deserializer());
    }

    public Object m7040a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEntityAtRangeDeserializer.m4747a(jsonParser, (short) 134);
        Object graphQLEntityAtRange = new GraphQLEntityAtRange();
        ((BaseModel) graphQLEntityAtRange).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEntityAtRange instanceof Postprocessable) {
            return ((Postprocessable) graphQLEntityAtRange).a();
        }
        return graphQLEntityAtRange;
    }
}
