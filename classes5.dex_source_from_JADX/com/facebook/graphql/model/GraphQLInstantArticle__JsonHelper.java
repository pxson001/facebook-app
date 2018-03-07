package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fellbackToCachedDataAfterFailedToHitServer */
public final class GraphQLInstantArticle__JsonHelper {
    public static GraphQLInstantArticle m8732a(JsonParser jsonParser) {
        GraphQLInstantArticle graphQLInstantArticle = new GraphQLInstantArticle();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8734a(graphQLInstantArticle, i, jsonParser);
            jsonParser.f();
        }
        return graphQLInstantArticle;
    }

    private static boolean m8734a(GraphQLInstantArticle graphQLInstantArticle, String str, JsonParser jsonParser) {
        GraphQLMessengerContentSubscriptionOption graphQLMessengerContentSubscriptionOption = null;
        if ("feedback".equals(str)) {
            GraphQLFeedback a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLInstantArticle.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticle, "feedback", graphQLInstantArticle.a_, 0, true);
            return true;
        } else if ("fullLatestVersion".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLInstantArticleVersion__JsonHelper.m8730a(FieldAccessQueryTracker.a(jsonParser, "fullLatestVersion"));
            }
            graphQLInstantArticle.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticle, "fullLatestVersion", graphQLInstantArticle.B_(), 1, true);
            return true;
        } else if ("global_share".equals(str)) {
            GraphQLExternalUrl a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLExternalUrl__JsonHelper.m7429a(FieldAccessQueryTracker.a(jsonParser, "global_share"));
            }
            graphQLInstantArticle.f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticle, "global_share", graphQLInstantArticle.B_(), 2, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLInstantArticle.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticle, "id", graphQLInstantArticle.B_(), 3, false);
            return true;
        } else if ("latest_version".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLInstantArticleVersion__JsonHelper.m8730a(FieldAccessQueryTracker.a(jsonParser, "latest_version"));
            }
            graphQLInstantArticle.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticle, "latest_version", graphQLInstantArticle.B_(), 4, true);
            return true;
        } else if ("owner_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLInstantArticle.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticle, "owner_id", graphQLInstantArticle.B_(), 5, false);
            return true;
        } else if ("rich_document_edge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLInstantArticleVersion__JsonHelper.m8730a(FieldAccessQueryTracker.a(jsonParser, "rich_document_edge"));
            }
            graphQLInstantArticle.j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticle, "rich_document_edge", graphQLInstantArticle.B_(), 6, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLInstantArticle.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticle, "url", graphQLInstantArticle.B_(), 7, false);
            return true;
        } else if ("relatedArticleVersion".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLInstantArticleVersion__JsonHelper.m8730a(FieldAccessQueryTracker.a(jsonParser, "relatedArticleVersion"));
            }
            graphQLInstantArticle.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticle, "relatedArticleVersion", graphQLInstantArticle.B_(), 8, true);
            return true;
        } else if (!"messenger_content_subscription_option".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLMessengerContentSubscriptionOption = GraphQLMessengerContentSubscriptionOption__JsonHelper.m9112a(FieldAccessQueryTracker.a(jsonParser, "messenger_content_subscription_option"));
            }
            graphQLInstantArticle.m = graphQLMessengerContentSubscriptionOption;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstantArticle, "messenger_content_subscription_option", graphQLInstantArticle.B_(), 9, true);
            return true;
        }
    }

    public static void m8733a(JsonGenerator jsonGenerator, GraphQLInstantArticle graphQLInstantArticle, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLInstantArticle.j() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLInstantArticle.j(), true);
        }
        if (graphQLInstantArticle.k() != null) {
            jsonGenerator.a("fullLatestVersion");
            GraphQLInstantArticleVersion__JsonHelper.m8731a(jsonGenerator, graphQLInstantArticle.k(), true);
        }
        if (graphQLInstantArticle.l() != null) {
            jsonGenerator.a("global_share");
            GraphQLExternalUrl__JsonHelper.m7430a(jsonGenerator, graphQLInstantArticle.l(), true);
        }
        if (graphQLInstantArticle.m() != null) {
            jsonGenerator.a("id", graphQLInstantArticle.m());
        }
        if (graphQLInstantArticle.n() != null) {
            jsonGenerator.a("latest_version");
            GraphQLInstantArticleVersion__JsonHelper.m8731a(jsonGenerator, graphQLInstantArticle.n(), true);
        }
        if (graphQLInstantArticle.o() != null) {
            jsonGenerator.a("owner_id", graphQLInstantArticle.o());
        }
        if (graphQLInstantArticle.p() != null) {
            jsonGenerator.a("rich_document_edge");
            GraphQLInstantArticleVersion__JsonHelper.m8731a(jsonGenerator, graphQLInstantArticle.p(), true);
        }
        if (graphQLInstantArticle.q() != null) {
            jsonGenerator.a("url", graphQLInstantArticle.q());
        }
        if (graphQLInstantArticle.r() != null) {
            jsonGenerator.a("relatedArticleVersion");
            GraphQLInstantArticleVersion__JsonHelper.m8731a(jsonGenerator, graphQLInstantArticle.r(), true);
        }
        if (graphQLInstantArticle.s() != null) {
            jsonGenerator.a("messenger_content_subscription_option");
            GraphQLMessengerContentSubscriptionOption__JsonHelper.m9113a(jsonGenerator, graphQLInstantArticle.s(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
