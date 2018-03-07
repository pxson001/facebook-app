package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLWithTagsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TargetingDescription */
public class GraphQLWithTagsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLWithTagsConnection.class, new GraphQLWithTagsConnection$Deserializer());
    }

    public Object m22496a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLWithTagsConnectionDeserializer.m6206a(jsonParser, (short) 157);
        Object graphQLWithTagsConnection = new GraphQLWithTagsConnection();
        ((BaseModel) graphQLWithTagsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLWithTagsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLWithTagsConnection).a();
        }
        return graphQLWithTagsConnection;
    }
}
