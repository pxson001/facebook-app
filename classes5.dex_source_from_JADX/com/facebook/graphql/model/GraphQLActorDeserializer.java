package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_review_feed_unit */
public class GraphQLActorDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLActor.class, new GraphQLActorDeserializer());
    }

    public GraphQLActorDeserializer() {
        a(GraphQLActor.class);
    }

    public Object m6398a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLActor__JsonHelper.a(jsonParser);
    }
}
