package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTaggableActivityAllIconsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNSUB */
public class GraphQLTaggableActivityAllIconsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTaggableActivityAllIconsConnection.class, new GraphQLTaggableActivityAllIconsConnection$Deserializer());
    }

    public Object m22042a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTaggableActivityAllIconsConnectionDeserializer.m6030a(jsonParser, (short) 290);
        Object graphQLTaggableActivityAllIconsConnection = new GraphQLTaggableActivityAllIconsConnection();
        ((BaseModel) graphQLTaggableActivityAllIconsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTaggableActivityAllIconsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLTaggableActivityAllIconsConnection).a();
        }
        return graphQLTaggableActivityAllIconsConnection;
    }
}
