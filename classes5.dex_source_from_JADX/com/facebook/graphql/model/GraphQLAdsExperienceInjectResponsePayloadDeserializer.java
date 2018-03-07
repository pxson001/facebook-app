package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_open_status_formats */
public class GraphQLAdsExperienceInjectResponsePayloadDeserializer extends FbJsonDeserializer {
    public Object m6478a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLAdsExperienceInjectResponsePayload graphQLAdsExperienceInjectResponsePayload = new GraphQLAdsExperienceInjectResponsePayload();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLAdsExperienceInjectResponsePayload = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                int i2;
                if ("inject_status".equals(i)) {
                    boolean z;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        z = false;
                    } else {
                        z = jsonParser.H();
                    }
                    graphQLAdsExperienceInjectResponsePayload.f3308d = z;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdsExperienceInjectResponsePayload, "inject_status", graphQLAdsExperienceInjectResponsePayload.a_, 0, false);
                    i2 = 1;
                } else if ("viewer".equals(i)) {
                    GraphQLViewer graphQLViewer;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLViewer = null;
                    } else {
                        graphQLViewer = GraphQLViewer__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "viewer"));
                    }
                    graphQLAdsExperienceInjectResponsePayload.f3309e = graphQLViewer;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdsExperienceInjectResponsePayload, "viewer", graphQLAdsExperienceInjectResponsePayload.a_, 1, true);
                    i2 = 1;
                }
                jsonParser.f();
            }
        }
        return graphQLAdsExperienceInjectResponsePayload;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAdsExperienceInjectResponsePayload.class, new GraphQLAdsExperienceInjectResponsePayloadDeserializer());
    }

    public GraphQLAdsExperienceInjectResponsePayloadDeserializer() {
        a(GraphQLAdsExperienceInjectResponsePayload.class);
    }
}
