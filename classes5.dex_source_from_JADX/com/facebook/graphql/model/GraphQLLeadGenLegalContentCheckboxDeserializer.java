package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: optin_confirm_button_text */
public class GraphQLLeadGenLegalContentCheckboxDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenLegalContentCheckbox.class, new GraphQLLeadGenLegalContentCheckboxDeserializer());
    }

    public GraphQLLeadGenLegalContentCheckboxDeserializer() {
        a(GraphQLLeadGenLegalContentCheckbox.class);
    }

    public Object m8874a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLeadGenLegalContentCheckbox__JsonHelper.m8876a(jsonParser);
    }
}
