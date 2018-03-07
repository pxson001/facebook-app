package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_bored_top_of_feed */
public class GraphQLTargetingDescriptionSentenceDeserializer extends FbJsonDeserializer {
    public Object m22096a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLTargetingDescriptionSentence graphQLTargetingDescriptionSentence = new GraphQLTargetingDescriptionSentence();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLTargetingDescriptionSentence = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String str = null;
                if ("text".equals(i)) {
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                        str = jsonParser.o();
                    }
                    graphQLTargetingDescriptionSentence.f13284d = str;
                    FieldAccessQueryTracker.a(jsonParser, graphQLTargetingDescriptionSentence, "text", graphQLTargetingDescriptionSentence.a_, 0, false);
                }
                jsonParser.f();
            }
        }
        return graphQLTargetingDescriptionSentence;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTargetingDescriptionSentence.class, new GraphQLTargetingDescriptionSentenceDeserializer());
    }

    public GraphQLTargetingDescriptionSentenceDeserializer() {
        a(GraphQLTargetingDescriptionSentence.class);
    }
}
