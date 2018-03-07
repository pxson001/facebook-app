package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTemplatesEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: multiShareHDVideoUrl */
public class GraphQLSearchAwarenessSuggestionDeserializer extends FbJsonDeserializer {
    public Object m21571a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLSearchAwarenessSuggestion graphQLSearchAwarenessSuggestion = new GraphQLSearchAwarenessSuggestion();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLSearchAwarenessSuggestion = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("id".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSearchAwarenessSuggestion.f12989d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchAwarenessSuggestion, "id", graphQLSearchAwarenessSuggestion.a_, 0, false);
                } else if ("keywords_suggestions".equals(i)) {
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
                    graphQLSearchAwarenessSuggestion.f12990e = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchAwarenessSuggestion, "keywords_suggestions", graphQLSearchAwarenessSuggestion.a_, 1, false);
                } else if ("suggestion_description".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSearchAwarenessSuggestion.f12991f = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchAwarenessSuggestion, "suggestion_description", graphQLSearchAwarenessSuggestion.a_, 2, false);
                } else if ("suggestion_template".equals(i)) {
                    graphQLSearchAwarenessSuggestion.f12992g = GraphQLSearchAwarenessTemplatesEnum.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchAwarenessSuggestion, "suggestion_template", graphQLSearchAwarenessSuggestion.a_, 3, false);
                } else if ("suggestion_title".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSearchAwarenessSuggestion.f12993h = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchAwarenessSuggestion, "suggestion_title", graphQLSearchAwarenessSuggestion.a_, 4, false);
                } else if ("test_name".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSearchAwarenessSuggestion.f12994i = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchAwarenessSuggestion, "test_name", graphQLSearchAwarenessSuggestion.a_, 5, false);
                } else if ("url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSearchAwarenessSuggestion.f12995j = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSearchAwarenessSuggestion, "url", graphQLSearchAwarenessSuggestion.a_, 6, false);
                }
                jsonParser.f();
            }
        }
        return graphQLSearchAwarenessSuggestion;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSearchAwarenessSuggestion.class, new GraphQLSearchAwarenessSuggestionDeserializer());
    }

    public GraphQLSearchAwarenessSuggestionDeserializer() {
        a(GraphQLSearchAwarenessSuggestion.class);
    }
}
