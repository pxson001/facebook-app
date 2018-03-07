package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ownerBuffer */
public class GraphQLGroupConfigurationsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupConfigurationsConnection.class, new GraphQLGroupConfigurationsConnectionDeserializer());
    }

    public GraphQLGroupConfigurationsConnectionDeserializer() {
        a(GraphQLGroupConfigurationsConnection.class);
    }

    public Object m8396a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroupConfigurationsConnection__JsonHelper.m8398a(jsonParser);
    }
}
