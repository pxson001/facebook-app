package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: messenger_group_attachment */
public class GraphQLUserWorkExperiencesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLUserWorkExperiencesConnection.class, new GraphQLUserWorkExperiencesConnectionDeserializer());
    }

    public GraphQLUserWorkExperiencesConnectionDeserializer() {
        a(GraphQLUserWorkExperiencesConnection.class);
    }

    public Object m22403a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLUserWorkExperiencesConnection__JsonHelper.m22405a(jsonParser);
    }
}
