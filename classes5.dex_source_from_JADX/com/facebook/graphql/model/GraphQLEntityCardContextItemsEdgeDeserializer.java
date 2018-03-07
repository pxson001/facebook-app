package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pendingIntent */
public class GraphQLEntityCardContextItemsEdgeDeserializer extends FbJsonDeserializer {
    public Object m7091a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLEntityCardContextItemsEdge graphQLEntityCardContextItemsEdge = new GraphQLEntityCardContextItemsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLEntityCardContextItemsEdge = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("node".equals(i)) {
                    GraphQLEntityCardContextItem graphQLEntityCardContextItem;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLEntityCardContextItem = null;
                    } else {
                        graphQLEntityCardContextItem = GraphQLEntityCardContextItem__JsonHelper.m7083a(FieldAccessQueryTracker.a(jsonParser, "node"));
                    }
                    graphQLEntityCardContextItemsEdge.f3548d = graphQLEntityCardContextItem;
                    FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItemsEdge, "node", graphQLEntityCardContextItemsEdge.a_, 0, true);
                } else {
                    int i2 = 0;
                }
                jsonParser.f();
            }
        }
        return graphQLEntityCardContextItemsEdge;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEntityCardContextItemsEdge.class, new GraphQLEntityCardContextItemsEdgeDeserializer());
    }

    public GraphQLEntityCardContextItemsEdgeDeserializer() {
        a(GraphQLEntityCardContextItemsEdge.class);
    }
}
