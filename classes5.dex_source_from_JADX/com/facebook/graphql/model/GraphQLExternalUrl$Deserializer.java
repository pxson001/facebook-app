package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLExternalUrlDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: icon_dominant_color */
public class GraphQLExternalUrl$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLExternalUrl.class, new GraphQLExternalUrl$Deserializer());
    }

    public Object m7425a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLExternalUrlDeserializer.m4868a(jsonParser, (short) 15);
        Object graphQLExternalUrl = new GraphQLExternalUrl();
        ((BaseModel) graphQLExternalUrl).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLExternalUrl instanceof Postprocessable) {
            return ((Postprocessable) graphQLExternalUrl).a();
        }
        return graphQLExternalUrl;
    }
}
