package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLSouvenirMediaFieldType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UnseenStoriesConnection */
public final class GraphQLSouvenirMediaElement__JsonHelper {
    public static GraphQLSouvenirMediaElement m21748a(JsonParser jsonParser) {
        GraphQLSouvenirMediaElement graphQLSouvenirMediaElement = new GraphQLSouvenirMediaElement();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLSouvenirMediaElement.f13035d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLSouvenirMediaElement, "id", graphQLSouvenirMediaElement.a_, 0, false);
            } else if ("is_highlighted".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLSouvenirMediaElement.f13036e = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLSouvenirMediaElement, "is_highlighted", graphQLSouvenirMediaElement.a_, 1, false);
            } else if ("souvenir_media".equals(i)) {
                GraphQLSouvenirMediaElementMediaConnection graphQLSouvenirMediaElementMediaConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLSouvenirMediaElementMediaConnection = null;
                } else {
                    graphQLSouvenirMediaElementMediaConnection = GraphQLSouvenirMediaElementMediaConnection__JsonHelper.m21736a(FieldAccessQueryTracker.a(jsonParser, "souvenir_media"));
                }
                graphQLSouvenirMediaElement.f13037f = graphQLSouvenirMediaElementMediaConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLSouvenirMediaElement, "souvenir_media", graphQLSouvenirMediaElement.a_, 2, true);
            } else if ("souvenir_media_type".equals(i)) {
                graphQLSouvenirMediaElement.f13038g = GraphQLSouvenirMediaFieldType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLSouvenirMediaElement, "souvenir_media_type", graphQLSouvenirMediaElement.a_, 3, false);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLSouvenirMediaElement.f13039h = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLSouvenirMediaElement, "url", graphQLSouvenirMediaElement.a_, 4, false);
            }
            jsonParser.f();
        }
        return graphQLSouvenirMediaElement;
    }

    public static void m21749a(JsonGenerator jsonGenerator, GraphQLSouvenirMediaElement graphQLSouvenirMediaElement, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSouvenirMediaElement.m21723j() != null) {
            jsonGenerator.a("id", graphQLSouvenirMediaElement.m21723j());
        }
        jsonGenerator.a("is_highlighted", graphQLSouvenirMediaElement.m21724k());
        if (graphQLSouvenirMediaElement.m21725l() != null) {
            jsonGenerator.a("souvenir_media");
            GraphQLSouvenirMediaElementMediaConnection__JsonHelper.m21737a(jsonGenerator, graphQLSouvenirMediaElement.m21725l(), true);
        }
        if (graphQLSouvenirMediaElement.m21726m() != null) {
            jsonGenerator.a("souvenir_media_type", graphQLSouvenirMediaElement.m21726m().toString());
        }
        if (graphQLSouvenirMediaElement.m21727n() != null) {
            jsonGenerator.a("url", graphQLSouvenirMediaElement.m21727n());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
