package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLBackdatedTimeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_persistent */
public class GraphQLBackdatedTime$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBackdatedTime.class, new GraphQLBackdatedTime$Deserializer());
    }

    public Object m6629a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLBackdatedTimeDeserializer.m4606a(jsonParser, (short) 582);
        Object graphQLBackdatedTime = new GraphQLBackdatedTime();
        ((BaseModel) graphQLBackdatedTime).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLBackdatedTime instanceof Postprocessable) {
            return ((Postprocessable) graphQLBackdatedTime).a();
        }
        return graphQLBackdatedTime;
    }
}
