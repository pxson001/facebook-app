package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentFormatVersion;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: isTagsUserSelected */
public final class GraphQLComposedDocument__JsonHelper {
    public static GraphQLComposedDocument m6838a(JsonParser jsonParser) {
        GraphQLComposedDocument graphQLComposedDocument = new GraphQLComposedDocument();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6840a(graphQLComposedDocument, i, jsonParser);
            jsonParser.f();
        }
        return graphQLComposedDocument;
    }

    private static boolean m6840a(GraphQLComposedDocument graphQLComposedDocument, String str, JsonParser jsonParser) {
        long j = 0;
        String str2 = null;
        if ("creation_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLComposedDocument.f3482d = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLComposedDocument, "creation_time", graphQLComposedDocument.a_, 0, false);
            return true;
        } else if ("document_owner".equals(str)) {
            graphQLComposedDocument.f3483e = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "document_owner"));
            FieldAccessQueryTracker.a(jsonParser, graphQLComposedDocument, "document_owner", graphQLComposedDocument.B_(), 1, true);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLComposedDocument.f3484f = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLComposedDocument, "feedback", graphQLComposedDocument.B_(), 2, true);
            return true;
        } else if ("feedback_options".equals(str)) {
            graphQLComposedDocument.f3485g = GraphQLDocumentFeedbackOptions.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLComposedDocument, "feedback_options", graphQLComposedDocument.B_(), 3, false);
            return true;
        } else if ("format_version".equals(str)) {
            graphQLComposedDocument.f3486h = GraphQLDocumentFormatVersion.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLComposedDocument, "format_version", graphQLComposedDocument.B_(), 4, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLComposedDocument.f3487i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLComposedDocument, "id", graphQLComposedDocument.B_(), 5, false);
            return true;
        } else if ("modified_timestamp".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLComposedDocument.f3488j = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLComposedDocument, "modified_timestamp", graphQLComposedDocument.B_(), 6, false);
            return true;
        } else if ("publish_timestamp".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLComposedDocument.f3489k = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLComposedDocument, "publish_timestamp", graphQLComposedDocument.B_(), 7, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLComposedDocument.f3490l = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLComposedDocument, "url", graphQLComposedDocument.B_(), 8, false);
            return true;
        }
    }

    public static void m6839a(JsonGenerator jsonGenerator, GraphQLComposedDocument graphQLComposedDocument, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("creation_time", graphQLComposedDocument.m6827j());
        if (graphQLComposedDocument.m6828k() != null) {
            jsonGenerator.a("document_owner");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLComposedDocument.m6828k(), true);
        }
        if (graphQLComposedDocument.m6829l() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLComposedDocument.m6829l(), true);
        }
        if (graphQLComposedDocument.m6830m() != null) {
            jsonGenerator.a("feedback_options", graphQLComposedDocument.m6830m().toString());
        }
        if (graphQLComposedDocument.m6831n() != null) {
            jsonGenerator.a("format_version", graphQLComposedDocument.m6831n().toString());
        }
        if (graphQLComposedDocument.m6832o() != null) {
            jsonGenerator.a("id", graphQLComposedDocument.m6832o());
        }
        jsonGenerator.a("modified_timestamp", graphQLComposedDocument.m6833p());
        jsonGenerator.a("publish_timestamp", graphQLComposedDocument.m6834q());
        if (graphQLComposedDocument.m6835r() != null) {
            jsonGenerator.a("url", graphQLComposedDocument.m6835r());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
