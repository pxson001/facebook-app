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

/* compiled from: mtouch_feed_post_like_chaining */
public class GraphQLSearchSuggestionsConnectionDeserializer extends FbJsonDeserializer {
    public Object m21615a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLSearchSuggestionsConnection graphQLSearchSuggestionsConnection = new GraphQLSearchSuggestionsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLSearchSuggestionsConnection = null;
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
                            GraphQLSearchSuggestionsEdge a = GraphQLSearchSuggestionsEdge__JsonHelper.m21626a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                    graphQLSearchSuggestionsConnection.f13016d = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionsConnection, "edges", graphQLSearchSuggestionsConnection.a_, 0, true);
                } else {
                    int i2 = 0;
                }
                jsonParser.f();
            }
        }
        return graphQLSearchSuggestionsConnection;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSearchSuggestionsConnection.class, new GraphQLSearchSuggestionsConnectionDeserializer());
    }

    public GraphQLSearchSuggestionsConnectionDeserializer() {
        a(GraphQLSearchSuggestionsConnection.class);
    }
}
