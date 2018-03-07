package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_open_status_type */
public class GraphQLAdsExperienceDeclineResponsePayloadDeserializer extends FbJsonDeserializer {
    public Object m6469a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLAdsExperienceDeclineResponsePayload graphQLAdsExperienceDeclineResponsePayload = new GraphQLAdsExperienceDeclineResponsePayload();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLAdsExperienceDeclineResponsePayload = null;
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
                    graphQLAdsExperienceDeclineResponsePayload.f3307d = graphQLViewer;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdsExperienceDeclineResponsePayload, "viewer", graphQLAdsExperienceDeclineResponsePayload.a_, 0, true);
                } else {
                    int i2 = 0;
                }
                jsonParser.f();
            }
        }
        return graphQLAdsExperienceDeclineResponsePayload;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAdsExperienceDeclineResponsePayload.class, new GraphQLAdsExperienceDeclineResponsePayloadDeserializer());
    }

    public GraphQLAdsExperienceDeclineResponsePayloadDeserializer() {
        a(GraphQLAdsExperienceDeclineResponsePayload.class);
    }
}
