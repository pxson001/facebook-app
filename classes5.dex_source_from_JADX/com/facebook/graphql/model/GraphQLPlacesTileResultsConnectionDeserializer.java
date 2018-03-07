package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: netego_replace */
public class GraphQLPlacesTileResultsConnectionDeserializer extends FbJsonDeserializer {
    public Object m20929a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLPlacesTileResultsConnection graphQLPlacesTileResultsConnection = new GraphQLPlacesTileResultsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLPlacesTileResultsConnection = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                List list = null;
                if ("edges".equals(i)) {
                    Collection arrayList;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        arrayList = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            GraphQLPlacesTileResultsEdge a = GraphQLPlacesTileResultsEdge__JsonHelper.m20942a(FieldAccessQueryTracker.a(jsonParser, "edges"));
                            if (a != null) {
                                arrayList.add(a);
                            }
                        }
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        list = ImmutableList.copyOf(arrayList);
                    }
                    graphQLPlacesTileResultsConnection.f12670d = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPlacesTileResultsConnection, "edges", graphQLPlacesTileResultsConnection.a_, 0, true);
                } else {
                    int i2 = 0;
                }
                jsonParser.f();
            }
        }
        return graphQLPlacesTileResultsConnection;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlacesTileResultsConnection.class, new GraphQLPlacesTileResultsConnectionDeserializer());
    }

    public GraphQLPlacesTileResultsConnectionDeserializer() {
        a(GraphQLPlacesTileResultsConnection.class);
    }
}
