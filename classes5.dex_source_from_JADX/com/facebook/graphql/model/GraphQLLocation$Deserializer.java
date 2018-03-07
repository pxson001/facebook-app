package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLLocationDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: fb_sync */
public class GraphQLLocation$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLocation.class, new GraphQLLocation$Deserializer());
    }

    public Object m8961a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLLocationDeserializer.m5331a(jsonParser, (short) 110);
        Object graphQLLocation = new GraphQLLocation();
        ((BaseModel) graphQLLocation).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLLocation instanceof Postprocessable) {
            return ((Postprocessable) graphQLLocation).a();
        }
        return graphQLLocation;
    }
}
