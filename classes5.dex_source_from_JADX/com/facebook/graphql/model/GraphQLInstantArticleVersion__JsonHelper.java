package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentFormatVersion;
import com.facebook.graphql.enums.GraphQLDocumentTextDirectionEnum;
import com.facebook.graphql.enums.GraphQLInstantArticlePublishStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fetchAndUpdateInterstitialsParams */
public final class GraphQLInstantArticleVersion__JsonHelper {
    public static GraphQLInstantArticleVersion m8730a(JsonParser jsonParser) {
        GraphQLInstantArticleVersion graphQLInstantArticleVersion = new GraphQLInstantArticleVersion();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("article_canonical_url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLInstantArticleVersion.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "article_canonical_url", graphQLInstantArticleVersion.a_, 0, false);
            } else if ("article_version_number".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLInstantArticleVersion.e = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "article_version_number", graphQLInstantArticleVersion.a_, 1, false);
            } else if ("creation_time".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.F();
                }
                graphQLInstantArticleVersion.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "creation_time", graphQLInstantArticleVersion.a_, 2, false);
            } else if ("document_owner".equals(i)) {
                GraphQLProfile graphQLProfile;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLProfile = null;
                } else {
                    graphQLProfile = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "document_owner"));
                }
                graphQLInstantArticleVersion.g = graphQLProfile;
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "document_owner", graphQLInstantArticleVersion.a_, 3, true);
            } else if ("feed_attachment".equals(i)) {
                GraphQLStoryAttachment graphQLStoryAttachment;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLStoryAttachment = null;
                } else {
                    graphQLStoryAttachment = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "feed_attachment"));
                }
                graphQLInstantArticleVersion.h = graphQLStoryAttachment;
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "feed_attachment", graphQLInstantArticleVersion.a_, 4, true);
            } else if ("feedback".equals(i)) {
                GraphQLFeedback graphQLFeedback;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLFeedback = null;
                } else {
                    graphQLFeedback = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
                }
                graphQLInstantArticleVersion.i = graphQLFeedback;
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "feedback", graphQLInstantArticleVersion.a_, 6, true);
            } else if ("feedback_options".equals(i)) {
                graphQLInstantArticleVersion.j = GraphQLDocumentFeedbackOptions.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "feedback_options", graphQLInstantArticleVersion.a_, 7, false);
            } else if ("format_version".equals(i)) {
                graphQLInstantArticleVersion.k = GraphQLDocumentFormatVersion.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "format_version", graphQLInstantArticleVersion.a_, 8, false);
            } else if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLInstantArticleVersion.l = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "id", graphQLInstantArticleVersion.a_, 9, false);
            } else if ("modified_timestamp".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.F();
                }
                graphQLInstantArticleVersion.m = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "modified_timestamp", graphQLInstantArticleVersion.a_, 10, false);
            } else if ("publish_status".equals(i)) {
                graphQLInstantArticleVersion.n = GraphQLInstantArticlePublishStatus.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "publish_status", graphQLInstantArticleVersion.a_, 11, false);
            } else if ("publish_timestamp".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.F();
                }
                graphQLInstantArticleVersion.o = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "publish_timestamp", graphQLInstantArticleVersion.a_, 12, false);
            } else if ("text_direction".equals(i)) {
                graphQLInstantArticleVersion.p = GraphQLDocumentTextDirectionEnum.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "text_direction", graphQLInstantArticleVersion.a_, 13, false);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLInstantArticleVersion.q = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "url", graphQLInstantArticleVersion.a_, 14, false);
            } else if ("cover_media".equals(i)) {
                GraphQLDocumentElement graphQLDocumentElement;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLDocumentElement = null;
                } else {
                    graphQLDocumentElement = GraphQLDocumentElement__JsonHelper.m6954a(FieldAccessQueryTracker.a(jsonParser, "cover_media"));
                }
                graphQLInstantArticleVersion.r = graphQLDocumentElement;
                FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticleVersion, "cover_media", graphQLInstantArticleVersion.a_, 15, true);
            }
            jsonParser.f();
        }
        return graphQLInstantArticleVersion;
    }

    public static void m8731a(JsonGenerator jsonGenerator, GraphQLInstantArticleVersion graphQLInstantArticleVersion, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLInstantArticleVersion.j() != null) {
            jsonGenerator.a("article_canonical_url", graphQLInstantArticleVersion.j());
        }
        jsonGenerator.a("article_version_number", graphQLInstantArticleVersion.k());
        jsonGenerator.a("creation_time", graphQLInstantArticleVersion.l());
        if (graphQLInstantArticleVersion.m() != null) {
            jsonGenerator.a("document_owner");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLInstantArticleVersion.m(), true);
        }
        if (graphQLInstantArticleVersion.n() != null) {
            jsonGenerator.a("feed_attachment");
            GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLInstantArticleVersion.n(), true);
        }
        if (graphQLInstantArticleVersion.o() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLInstantArticleVersion.o(), true);
        }
        if (graphQLInstantArticleVersion.p() != null) {
            jsonGenerator.a("feedback_options", graphQLInstantArticleVersion.p().toString());
        }
        if (graphQLInstantArticleVersion.q() != null) {
            jsonGenerator.a("format_version", graphQLInstantArticleVersion.q().toString());
        }
        if (graphQLInstantArticleVersion.r() != null) {
            jsonGenerator.a("id", graphQLInstantArticleVersion.r());
        }
        jsonGenerator.a("modified_timestamp", graphQLInstantArticleVersion.s());
        if (graphQLInstantArticleVersion.t() != null) {
            jsonGenerator.a("publish_status", graphQLInstantArticleVersion.t().toString());
        }
        jsonGenerator.a("publish_timestamp", graphQLInstantArticleVersion.u());
        if (graphQLInstantArticleVersion.v() != null) {
            jsonGenerator.a("text_direction", graphQLInstantArticleVersion.v().toString());
        }
        if (graphQLInstantArticleVersion.w() != null) {
            jsonGenerator.a("url", graphQLInstantArticleVersion.w());
        }
        if (graphQLInstantArticleVersion.x() != null) {
            jsonGenerator.a("cover_media");
            GraphQLDocumentElement__JsonHelper.m6955a(jsonGenerator, graphQLInstantArticleVersion.x(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
