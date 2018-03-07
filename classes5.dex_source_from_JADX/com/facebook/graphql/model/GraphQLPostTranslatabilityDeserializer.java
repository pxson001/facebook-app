package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego_price_range_survey */
public class GraphQLPostTranslatabilityDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPostTranslatability.class, new GraphQLPostTranslatabilityDeserializer());
    }

    public GraphQLPostTranslatabilityDeserializer() {
        a(GraphQLPostTranslatability.class);
    }

    public Object m20968a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPostTranslatability__JsonHelper.a(jsonParser);
    }
}
