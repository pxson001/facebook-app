package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_android_place_creation */
public class GraphQLTextWithEntitiesDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTextWithEntities.class, new GraphQLTextWithEntitiesDeserializer());
    }

    public GraphQLTextWithEntitiesDeserializer() {
        a(GraphQLTextWithEntities.class);
    }

    public Object m22108a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTextWithEntities__JsonHelper.a(jsonParser);
    }
}
