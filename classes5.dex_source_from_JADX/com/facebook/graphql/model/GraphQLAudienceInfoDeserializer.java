package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pickup_note */
public class GraphQLAudienceInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAudienceInfo.class, new GraphQLAudienceInfoDeserializer());
    }

    public GraphQLAudienceInfoDeserializer() {
        a(GraphQLAudienceInfo.class);
    }

    public Object m6621a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAudienceInfo__JsonHelper.a(jsonParser);
    }
}
