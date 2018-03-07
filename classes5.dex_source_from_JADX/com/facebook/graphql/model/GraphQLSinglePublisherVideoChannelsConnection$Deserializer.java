package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSinglePublisherVideoChannelsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VACATION_HOME_RENTAL */
public class GraphQLSinglePublisherVideoChannelsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSinglePublisherVideoChannelsConnection.class, new GraphQLSinglePublisherVideoChannelsConnection$Deserializer());
    }

    public Object m21658a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSinglePublisherVideoChannelsConnectionDeserializer.m5890a(jsonParser, (short) 393);
        Object graphQLSinglePublisherVideoChannelsConnection = new GraphQLSinglePublisherVideoChannelsConnection();
        ((BaseModel) graphQLSinglePublisherVideoChannelsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSinglePublisherVideoChannelsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLSinglePublisherVideoChannelsConnection).a();
        }
        return graphQLSinglePublisherVideoChannelsConnection;
    }
}
