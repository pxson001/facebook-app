package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: save_for_later */
public final class GraphQLPostTranslatability__JsonHelper {
    public static GraphQLPostTranslatability m3251a(JsonParser jsonParser) {
        GraphQLPostTranslatability graphQLPostTranslatability = new GraphQLPostTranslatability();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m3253a(graphQLPostTranslatability, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPostTranslatability;
    }

    private static boolean m3253a(GraphQLPostTranslatability graphQLPostTranslatability, String str, JsonParser jsonParser) {
        GraphQLTranslationMetaData graphQLTranslationMetaData = null;
        if ("auto_translated_message".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "auto_translated_message"));
            }
            graphQLPostTranslatability.d = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPostTranslatability, "auto_translated_message", graphQLPostTranslatability.a_, 0, true);
            return true;
        } else if ("source_dialect".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPostTranslatability.e = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPostTranslatability, "source_dialect", graphQLPostTranslatability.B_(), 1, false);
            return true;
        } else if ("source_dialect_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPostTranslatability.f = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPostTranslatability, "source_dialect_name", graphQLPostTranslatability.B_(), 2, false);
            return true;
        } else if ("target_dialect".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPostTranslatability.g = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPostTranslatability, "target_dialect", graphQLPostTranslatability.B_(), 3, false);
            return true;
        } else if ("target_dialect_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPostTranslatability.h = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPostTranslatability, "target_dialect_name", graphQLPostTranslatability.B_(), 4, false);
            return true;
        } else if ("translation_metadata".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTranslationMetaData = GraphQLTranslationMetaData__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "translation_metadata"));
            }
            graphQLPostTranslatability.i = graphQLTranslationMetaData;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPostTranslatability, "translation_metadata", graphQLPostTranslatability.B_(), 5, true);
            return true;
        } else if (!"translation_type".equals(str)) {
            return false;
        } else {
            graphQLPostTranslatability.j = GraphQLTranslatabilityType.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPostTranslatability, "translation_type", graphQLPostTranslatability.B_(), 6, false);
            return true;
        }
    }

    public static void m3252a(JsonGenerator jsonGenerator, GraphQLPostTranslatability graphQLPostTranslatability, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPostTranslatability.a() != null) {
            jsonGenerator.a("auto_translated_message");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLPostTranslatability.a(), true);
        }
        if (graphQLPostTranslatability.j() != null) {
            jsonGenerator.a("source_dialect", graphQLPostTranslatability.j());
        }
        if (graphQLPostTranslatability.k() != null) {
            jsonGenerator.a("source_dialect_name", graphQLPostTranslatability.k());
        }
        if (graphQLPostTranslatability.l() != null) {
            jsonGenerator.a("target_dialect", graphQLPostTranslatability.l());
        }
        if (graphQLPostTranslatability.m() != null) {
            jsonGenerator.a("target_dialect_name", graphQLPostTranslatability.m());
        }
        if (graphQLPostTranslatability.n() != null) {
            jsonGenerator.a("translation_metadata");
            GraphQLTranslationMetaData__JsonHelper.a(jsonGenerator, graphQLPostTranslatability.n(), true);
        }
        if (graphQLPostTranslatability.o() != null) {
            jsonGenerator.a("translation_type", graphQLPostTranslatability.o().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
