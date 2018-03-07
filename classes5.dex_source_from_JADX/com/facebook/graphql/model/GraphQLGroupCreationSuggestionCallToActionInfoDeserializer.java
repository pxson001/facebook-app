package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: owner */
public class GraphQLGroupCreationSuggestionCallToActionInfoDeserializer extends FbJsonDeserializer {
    public Object m8416a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGroupCreationSuggestionCallToActionInfo graphQLGroupCreationSuggestionCallToActionInfo = new GraphQLGroupCreationSuggestionCallToActionInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGroupCreationSuggestionCallToActionInfo = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("creation_suggestion".equals(i)) {
                    GraphQLGroupCreationSuggestion graphQLGroupCreationSuggestion;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLGroupCreationSuggestion = null;
                    } else {
                        graphQLGroupCreationSuggestion = GraphQLGroupCreationSuggestion__JsonHelper.m8429a(FieldAccessQueryTracker.a(jsonParser, "creation_suggestion"));
                    }
                    graphQLGroupCreationSuggestionCallToActionInfo.f4199d = graphQLGroupCreationSuggestion;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupCreationSuggestionCallToActionInfo, "creation_suggestion", graphQLGroupCreationSuggestionCallToActionInfo.a_, 0, true);
                } else {
                    int i2 = 0;
                }
                jsonParser.f();
            }
        }
        return graphQLGroupCreationSuggestionCallToActionInfo;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupCreationSuggestionCallToActionInfo.class, new GraphQLGroupCreationSuggestionCallToActionInfoDeserializer());
    }

    public GraphQLGroupCreationSuggestionCallToActionInfoDeserializer() {
        a(GraphQLGroupCreationSuggestionCallToActionInfo.class);
    }
}
