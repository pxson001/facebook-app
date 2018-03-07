package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: phoneapp */
public class GraphQLCulturalMomentDeserializer extends FbJsonDeserializer {
    public Object m6916a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLCulturalMoment graphQLCulturalMoment = new GraphQLCulturalMoment();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLCulturalMoment = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLCulturalMoment__JsonHelper.m6918a(graphQLCulturalMoment, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLCulturalMoment;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCulturalMoment.class, new GraphQLCulturalMomentDeserializer());
    }

    public GraphQLCulturalMomentDeserializer() {
        a(GraphQLCulturalMoment.class);
    }
}
