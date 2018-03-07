package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: parent_ids */
public class GraphQLEventUserBlockResponsePayloadDeserializer extends FbJsonDeserializer {
    public Object m7310a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLEventUserBlockResponsePayload graphQLEventUserBlockResponsePayload = new GraphQLEventUserBlockResponsePayload();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLEventUserBlockResponsePayload = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("user".equals(i)) {
                    GraphQLUser graphQLUser;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLUser = null;
                    } else {
                        graphQLUser = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "user"));
                    }
                    graphQLEventUserBlockResponsePayload.f3673d = graphQLUser;
                    FieldAccessQueryTracker.a(jsonParser, graphQLEventUserBlockResponsePayload, "user", graphQLEventUserBlockResponsePayload.a_, 0, true);
                } else {
                    int i2 = 0;
                }
                jsonParser.f();
            }
        }
        return graphQLEventUserBlockResponsePayload;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventUserBlockResponsePayload.class, new GraphQLEventUserBlockResponsePayloadDeserializer());
    }

    public GraphQLEventUserBlockResponsePayloadDeserializer() {
        a(GraphQLEventUserBlockResponsePayload.class);
    }
}
