package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: period */
public class GraphQLEligibleClashUnitsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEligibleClashUnitsConnection.class, new GraphQLEligibleClashUnitsConnectionDeserializer());
    }

    public GraphQLEligibleClashUnitsConnectionDeserializer() {
        a(GraphQLEligibleClashUnitsConnection.class);
    }

    public Object m6988a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEligibleClashUnitsConnection__JsonHelper.m6990a(jsonParser);
    }
}
