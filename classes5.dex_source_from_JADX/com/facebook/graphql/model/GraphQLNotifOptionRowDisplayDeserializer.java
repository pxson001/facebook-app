package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLNotifOptionRowDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: official_page */
public class GraphQLNotifOptionRowDisplayDeserializer extends FbJsonDeserializer {
    public Object m9355a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLNotifOptionRowDisplay graphQLNotifOptionRowDisplay = new GraphQLNotifOptionRowDisplay();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLNotifOptionRowDisplay = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    GraphQLObjectType graphQLObjectType;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLObjectType = null;
                    } else {
                        graphQLObjectType = GraphQLObjectType.a(jsonParser);
                    }
                    graphQLNotifOptionRowDisplay.f4646d = graphQLObjectType;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRowDisplay, "__type__", graphQLNotifOptionRowDisplay.a_, 0, false);
                } else if ("bg_color".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLNotifOptionRowDisplay.f4647e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRowDisplay, "bg_color", graphQLNotifOptionRowDisplay.a_, 1, false);
                } else if ("image_glyph".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLNotifOptionRowDisplay.f4648f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRowDisplay, "image_glyph", graphQLNotifOptionRowDisplay.a_, 2, false);
                } else if ("image_source".equals(i)) {
                    GraphQLImage graphQLImage;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLImage = null;
                    } else {
                        graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image_source"));
                    }
                    graphQLNotifOptionRowDisplay.f4649g = graphQLImage;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRowDisplay, "image_source", graphQLNotifOptionRowDisplay.a_, 3, true);
                } else if ("style".equals(i)) {
                    graphQLNotifOptionRowDisplay.f4650h = GraphQLNotifOptionRowDisplayStyle.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRowDisplay, "style", graphQLNotifOptionRowDisplay.a_, 5, false);
                } else if ("subtext".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "subtext"));
                    }
                    graphQLNotifOptionRowDisplay.f4651i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRowDisplay, "subtext", graphQLNotifOptionRowDisplay.a_, 6, true);
                } else if ("tertiary_text".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "tertiary_text"));
                    }
                    graphQLNotifOptionRowDisplay.f4652j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRowDisplay, "tertiary_text", graphQLNotifOptionRowDisplay.a_, 7, true);
                } else if ("tertiary_text_color".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLNotifOptionRowDisplay.f4653k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRowDisplay, "tertiary_text_color", graphQLNotifOptionRowDisplay.a_, 8, false);
                } else if ("text".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "text"));
                    }
                    graphQLNotifOptionRowDisplay.f4654l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRowDisplay, "text", graphQLNotifOptionRowDisplay.a_, 9, true);
                } else if ("undo_text".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "undo_text"));
                    }
                    graphQLNotifOptionRowDisplay.f4655m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNotifOptionRowDisplay, "undo_text", graphQLNotifOptionRowDisplay.a_, 10, true);
                }
                jsonParser.f();
            }
        }
        return graphQLNotifOptionRowDisplay;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNotifOptionRowDisplay.class, new GraphQLNotifOptionRowDisplayDeserializer());
    }

    public GraphQLNotifOptionRowDisplayDeserializer() {
        a(GraphQLNotifOptionRowDisplay.class);
    }
}
