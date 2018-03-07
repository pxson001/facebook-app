package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: metapage_redirect_dialog_lang_q */
public class GraphQLUserEducationExperiencesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLUserEducationExperiencesConnection.class, new GraphQLUserEducationExperiencesConnectionDeserializer());
    }

    public GraphQLUserEducationExperiencesConnectionDeserializer() {
        a(GraphQLUserEducationExperiencesConnection.class);
    }

    public Object m22387a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLUserEducationExperiencesConnection__JsonHelper.m22389a(jsonParser);
    }
}
