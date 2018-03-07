package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ogObjectId */
public class GraphQLNearbySearchSuggestionDeserializer extends FbJsonDeserializer {
    public Object m9229a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLNearbySearchSuggestion graphQLNearbySearchSuggestion = new GraphQLNearbySearchSuggestion();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLNearbySearchSuggestion = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLPage graphQLPage = null;
                if ("bounds".equals(i)) {
                    GraphQLGeoRectangle a;
                    if (jsonParser.g() != JsonToken.VALUE_NULL) {
                        a = GraphQLGeoRectangle__JsonHelper.m7766a(FieldAccessQueryTracker.a(jsonParser, "bounds"));
                    }
                    graphQLNearbySearchSuggestion.f4543d = a;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNearbySearchSuggestion, "bounds", graphQLNearbySearchSuggestion.a_, 0, true);
                } else if ("results_title".equals(i)) {
                    if (jsonParser.g() != JsonToken.VALUE_NULL) {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "results_title"));
                    }
                    graphQLNearbySearchSuggestion.f4544e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNearbySearchSuggestion, "results_title", graphQLNearbySearchSuggestion.a_, 1, true);
                } else if ("suggestion_text".equals(i)) {
                    if (jsonParser.g() != JsonToken.VALUE_NULL) {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "suggestion_text"));
                    }
                    graphQLNearbySearchSuggestion.f4545f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNearbySearchSuggestion, "suggestion_text", graphQLNearbySearchSuggestion.a_, 2, true);
                } else if ("topic".equals(i)) {
                    if (jsonParser.g() != JsonToken.VALUE_NULL) {
                        graphQLPage = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "topic"));
                    }
                    graphQLNearbySearchSuggestion.f4546g = graphQLPage;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNearbySearchSuggestion, "topic", graphQLNearbySearchSuggestion.a_, 3, true);
                } else {
                    int i2 = 0;
                }
                jsonParser.f();
            }
        }
        return graphQLNearbySearchSuggestion;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNearbySearchSuggestion.class, new GraphQLNearbySearchSuggestionDeserializer());
    }

    public GraphQLNearbySearchSuggestionDeserializer() {
        a(GraphQLNearbySearchSuggestion.class);
    }
}
