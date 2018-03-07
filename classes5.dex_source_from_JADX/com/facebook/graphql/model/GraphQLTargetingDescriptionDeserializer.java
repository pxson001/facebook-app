package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_create_group */
public class GraphQLTargetingDescriptionDeserializer extends FbJsonDeserializer {
    public Object m22090a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLTargetingDescription graphQLTargetingDescription = new GraphQLTargetingDescription();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLTargetingDescription = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String str = null;
                if ("content".equals(i)) {
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                        str = jsonParser.o();
                    }
                    graphQLTargetingDescription.f13283d = str;
                    FieldAccessQueryTracker.a(jsonParser, graphQLTargetingDescription, "content", graphQLTargetingDescription.a_, 0, false);
                }
                jsonParser.f();
            }
        }
        return graphQLTargetingDescription;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTargetingDescription.class, new GraphQLTargetingDescriptionDeserializer());
    }

    public GraphQLTargetingDescriptionDeserializer() {
        a(GraphQLTargetingDescription.class);
    }
}
