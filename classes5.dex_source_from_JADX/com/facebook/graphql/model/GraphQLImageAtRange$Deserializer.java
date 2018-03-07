package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLImageAtRangeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: follow_up_action_text */
public class GraphQLImageAtRange$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLImageAtRange.class, new GraphQLImageAtRange$Deserializer());
    }

    public Object m8618a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLImageAtRangeDeserializer.m5223a(jsonParser, (short) 140);
        Object graphQLImageAtRange = new GraphQLImageAtRange();
        ((BaseModel) graphQLImageAtRange).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLImageAtRange instanceof Postprocessable) {
            return ((Postprocessable) graphQLImageAtRange).a();
        }
        return graphQLImageAtRange;
    }
}
