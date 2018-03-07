package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_group_join */
public class GraphQLTagExpansionEducationInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTagExpansionEducationInfo.class, new GraphQLTagExpansionEducationInfoDeserializer());
    }

    public GraphQLTagExpansionEducationInfoDeserializer() {
        a(GraphQLTagExpansionEducationInfo.class);
    }

    public Object m22034a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTagExpansionEducationInfo__JsonHelper.m22036a(jsonParser);
    }
}
