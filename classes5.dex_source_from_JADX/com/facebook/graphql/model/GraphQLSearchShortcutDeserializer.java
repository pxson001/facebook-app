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

/* compiled from: mtouch_profile_picture */
public class GraphQLSearchShortcutDeserializer extends FbJsonDeserializer {
    public Object m21586a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLSearchShortcut graphQLSearchShortcut = new GraphQLSearchShortcut();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLSearchShortcut = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("fallback_path".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSearchShortcut.f12996d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchShortcut, "fallback_path", graphQLSearchShortcut.a_, 0, false);
                } else if ("icon_uri".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSearchShortcut.f12997e = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchShortcut, "icon_uri", graphQLSearchShortcut.a_, 1, false);
                } else if ("id".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSearchShortcut.f12998f = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchShortcut, "id", graphQLSearchShortcut.a_, 2, false);
                } else if ("name".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSearchShortcut.f12999g = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchShortcut, "name", graphQLSearchShortcut.a_, 3, false);
                } else if ("name_search_tokens".equals(i)) {
                    List list;
                    Collection collection = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        collection = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            Object o2 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                            if (o2 != null) {
                                collection.add(o2);
                            }
                        }
                    }
                    if (collection == null) {
                        list = null;
                    } else {
                        list = ImmutableList.copyOf(collection);
                    }
                    graphQLSearchShortcut.f13000h = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchShortcut, "name_search_tokens", graphQLSearchShortcut.a_, 4, false);
                } else if ("page_uri".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSearchShortcut.f13001i = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchShortcut, "page_uri", graphQLSearchShortcut.a_, 5, false);
                } else if ("path".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSearchShortcut.f13002j = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchShortcut, "path", graphQLSearchShortcut.a_, 6, false);
                } else if ("url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSearchShortcut.f13003k = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchShortcut, "url", graphQLSearchShortcut.a_, 7, false);
                }
                jsonParser.f();
            }
        }
        return graphQLSearchShortcut;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSearchShortcut.class, new GraphQLSearchShortcutDeserializer());
    }

    public GraphQLSearchShortcutDeserializer() {
        a(GraphQLSearchShortcut.class);
    }
}
