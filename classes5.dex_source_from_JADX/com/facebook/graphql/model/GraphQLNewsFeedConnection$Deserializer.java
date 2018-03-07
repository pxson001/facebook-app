package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLNewsFeedConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: events_calendar_subscription_status */
public class GraphQLNewsFeedConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNewsFeedConnection.class, new GraphQLNewsFeedConnection$Deserializer());
    }

    public Object m9251a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLNewsFeedConnectionDeserializer.m5422a(jsonParser, (short) 376);
        Object graphQLNewsFeedConnection = new GraphQLNewsFeedConnection();
        ((BaseModel) graphQLNewsFeedConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLNewsFeedConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLNewsFeedConnection).a();
        }
        return graphQLNewsFeedConnection;
    }
}
