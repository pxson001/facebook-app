package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLImageSizingStyle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: interesting_comments */
public final class GraphQLEntityCardContextItemIcon__JsonHelper {
    public static GraphQLEntityCardContextItemIcon m7068a(JsonParser jsonParser) {
        GraphQLEntityCardContextItemIcon graphQLEntityCardContextItemIcon = new GraphQLEntityCardContextItemIcon();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7070a(graphQLEntityCardContextItemIcon, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEntityCardContextItemIcon;
    }

    private static boolean m7070a(GraphQLEntityCardContextItemIcon graphQLEntityCardContextItemIcon, String str, JsonParser jsonParser) {
        if ("icon_image".equals(str)) {
            GraphQLImage graphQLImage;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                graphQLImage = null;
            } else {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "icon_image"));
            }
            graphQLEntityCardContextItemIcon.f3543d = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItemIcon, "icon_image", graphQLEntityCardContextItemIcon.a_, 0, true);
            return true;
        } else if (!"icon_sizing".equals(str)) {
            return false;
        } else {
            graphQLEntityCardContextItemIcon.f3544e = GraphQLImageSizingStyle.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItemIcon, "icon_sizing", graphQLEntityCardContextItemIcon.B_(), 1, false);
            return true;
        }
    }

    public static void m7069a(JsonGenerator jsonGenerator, GraphQLEntityCardContextItemIcon graphQLEntityCardContextItemIcon, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEntityCardContextItemIcon.m7063a() != null) {
            jsonGenerator.a("icon_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEntityCardContextItemIcon.m7063a(), true);
        }
        if (graphQLEntityCardContextItemIcon.m7065j() != null) {
            jsonGenerator.a("icon_sizing", graphQLEntityCardContextItemIcon.m7065j().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
