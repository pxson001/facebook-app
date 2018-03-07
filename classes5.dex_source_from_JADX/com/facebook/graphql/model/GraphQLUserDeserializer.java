package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: metapage_redirection_notification */
public class GraphQLUserDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLUser.class, new GraphQLUserDeserializer());
    }

    public GraphQLUserDeserializer() {
        a(GraphQLUser.class);
    }

    public Object m22384a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLUser__JsonHelper.a(jsonParser);
    }
}
