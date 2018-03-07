package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_open_status */
public class GraphQLAdsExperienceRemoveResponsePayloadDeserializer extends FbJsonDeserializer {
    public Object m6485a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLAdsExperienceRemoveResponsePayload graphQLAdsExperienceRemoveResponsePayload = new GraphQLAdsExperienceRemoveResponsePayload();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLAdsExperienceRemoveResponsePayload = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("viewer".equals(i)) {
                    GraphQLViewer graphQLViewer;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLViewer = null;
                    } else {
                        graphQLViewer = GraphQLViewer__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "viewer"));
                    }
                    graphQLAdsExperienceRemoveResponsePayload.f3310d = graphQLViewer;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdsExperienceRemoveResponsePayload, "viewer", graphQLAdsExperienceRemoveResponsePayload.a_, 0, true);
                } else {
                    int i2 = 0;
                }
                jsonParser.f();
            }
        }
        return graphQLAdsExperienceRemoveResponsePayload;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAdsExperienceRemoveResponsePayload.class, new GraphQLAdsExperienceRemoveResponsePayloadDeserializer());
    }

    public GraphQLAdsExperienceRemoveResponsePayloadDeserializer() {
        a(GraphQLAdsExperienceRemoveResponsePayload.class);
    }
}
