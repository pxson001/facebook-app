package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLLikedProfilesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: feed_ad */
public class GraphQLLikedProfilesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLikedProfilesConnection.class, new GraphQLLikedProfilesConnection$Deserializer());
    }

    public Object m8910a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLLikedProfilesConnectionDeserializer.m5316a(jsonParser, (short) 462);
        Object graphQLLikedProfilesConnection = new GraphQLLikedProfilesConnection();
        ((BaseModel) graphQLLikedProfilesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLLikedProfilesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLLikedProfilesConnection).a();
        }
        return graphQLLikedProfilesConnection;
    }
}
