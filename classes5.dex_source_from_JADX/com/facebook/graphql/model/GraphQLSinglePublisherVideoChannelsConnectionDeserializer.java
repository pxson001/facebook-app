package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: msite_report_merged_pages_url */
public class GraphQLSinglePublisherVideoChannelsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSinglePublisherVideoChannelsConnection.class, new GraphQLSinglePublisherVideoChannelsConnectionDeserializer());
    }

    public GraphQLSinglePublisherVideoChannelsConnectionDeserializer() {
        a(GraphQLSinglePublisherVideoChannelsConnection.class);
    }

    public Object m21660a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSinglePublisherVideoChannelsConnection__JsonHelper.m21662a(jsonParser);
    }
}
