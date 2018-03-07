package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: permalink_relationship_bar */
public class GraphQLDiscoveryCardItemDeserializer extends FbJsonDeserializer {
    public Object m6948a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLDiscoveryCardItem graphQLDiscoveryCardItem = new GraphQLDiscoveryCardItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLDiscoveryCardItem = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String str = null;
                if ("id".equals(i)) {
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                        str = jsonParser.o();
                    }
                    graphQLDiscoveryCardItem.f3513d = str;
                    FieldAccessQueryTracker.a(jsonParser, graphQLDiscoveryCardItem, "id", graphQLDiscoveryCardItem.a_, 0, false);
                }
                jsonParser.f();
            }
        }
        return graphQLDiscoveryCardItem;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLDiscoveryCardItem.class, new GraphQLDiscoveryCardItemDeserializer());
    }

    public GraphQLDiscoveryCardItemDeserializer() {
        a(GraphQLDiscoveryCardItem.class);
    }
}
