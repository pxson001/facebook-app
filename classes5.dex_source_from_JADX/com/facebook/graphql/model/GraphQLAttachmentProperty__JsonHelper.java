package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_see_first_bumped */
public final class GraphQLAttachmentProperty__JsonHelper {
    public static GraphQLAttachmentProperty m6609a(JsonParser jsonParser) {
        GraphQLAttachmentProperty graphQLAttachmentProperty = new GraphQLAttachmentProperty();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("attachment_property_type".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAttachmentProperty.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAttachmentProperty, "attachment_property_type", graphQLAttachmentProperty.a_, 0, false);
            } else if ("key".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAttachmentProperty.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAttachmentProperty, "key", graphQLAttachmentProperty.a_, 1, false);
            } else if ("title".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAttachmentProperty.f = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAttachmentProperty, "title", graphQLAttachmentProperty.a_, 2, false);
            } else if ("type".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAttachmentProperty.g = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAttachmentProperty, "type", graphQLAttachmentProperty.a_, 3, false);
            } else if ("value".equals(i)) {
                GraphQLTextWithEntities graphQLTextWithEntities;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = null;
                } else {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "value"));
                }
                graphQLAttachmentProperty.h = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLAttachmentProperty, "value", graphQLAttachmentProperty.a_, 4, true);
            }
            jsonParser.f();
        }
        return graphQLAttachmentProperty;
    }

    public static void m6610a(JsonGenerator jsonGenerator, GraphQLAttachmentProperty graphQLAttachmentProperty, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLAttachmentProperty.a() != null) {
            jsonGenerator.a("attachment_property_type", graphQLAttachmentProperty.a());
        }
        if (graphQLAttachmentProperty.j() != null) {
            jsonGenerator.a("key", graphQLAttachmentProperty.j());
        }
        if (graphQLAttachmentProperty.k() != null) {
            jsonGenerator.a("title", graphQLAttachmentProperty.k());
        }
        if (graphQLAttachmentProperty.l() != null) {
            jsonGenerator.a("type", graphQLAttachmentProperty.l());
        }
        if (graphQLAttachmentProperty.m() != null) {
            jsonGenerator.a("value");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLAttachmentProperty.m(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
