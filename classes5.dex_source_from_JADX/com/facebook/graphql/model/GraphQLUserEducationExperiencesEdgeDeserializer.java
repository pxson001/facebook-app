package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: metapage_redirect_dialog */
public class GraphQLUserEducationExperiencesEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLUserEducationExperiencesEdge.class, new GraphQLUserEducationExperiencesEdgeDeserializer());
    }

    public GraphQLUserEducationExperiencesEdgeDeserializer() {
        a(GraphQLUserEducationExperiencesEdge.class);
    }

    public Object m22396a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLUserEducationExperiencesEdge__JsonHelper.m22398a(jsonParser);
    }
}
