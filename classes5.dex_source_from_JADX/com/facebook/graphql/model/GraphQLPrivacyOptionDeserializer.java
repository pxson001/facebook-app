package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: View/Override/Expire QE configuration */
public class GraphQLPrivacyOptionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyOption.class, new GraphQLPrivacyOptionDeserializer());
    }

    public GraphQLPrivacyOptionDeserializer() {
        a(GraphQLPrivacyOption.class);
    }

    public Object m20994a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPrivacyOption__JsonHelper.a(jsonParser);
    }
}
