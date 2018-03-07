package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: needy_page_suggestion_megaphone */
public class GraphQLQPTemplateParameterDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQPTemplateParameter.class, new GraphQLQPTemplateParameterDeserializer());
    }

    public GraphQLQPTemplateParameterDeserializer() {
        a(GraphQLQPTemplateParameter.class);
    }

    public Object m21136a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQPTemplateParameter__JsonHelper.m21138a(jsonParser);
    }
}
