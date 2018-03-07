package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: iconImageLarge */
public final class GraphQLExternalUrl__JsonHelper {
    public static GraphQLExternalUrl m7429a(JsonParser jsonParser) {
        GraphQLExternalUrl graphQLExternalUrl = new GraphQLExternalUrl();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7431a(graphQLExternalUrl, i, jsonParser);
            jsonParser.f();
        }
        return graphQLExternalUrl;
    }

    private static boolean m7431a(GraphQLExternalUrl graphQLExternalUrl, String str, JsonParser jsonParser) {
        GraphQLExternalUrl graphQLExternalUrl2 = null;
        if ("all_share_stories".equals(str)) {
            GraphQLAllShareStoriesConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLAllShareStoriesConnection__JsonHelper.m6534a(FieldAccessQueryTracker.a(jsonParser, "all_share_stories"));
            }
            graphQLExternalUrl.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "all_share_stories", graphQLExternalUrl.a_, 0, true);
            return true;
        } else if ("android_urls".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLExternalUrl.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "android_urls", graphQLExternalUrl.B_(), 1, false);
            return true;
        } else if ("application".equals(str)) {
            GraphQLApplication a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLApplication__JsonHelper.m6587a(FieldAccessQueryTracker.a(jsonParser, "application"));
            }
            graphQLExternalUrl.f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "application", graphQLExternalUrl.B_(), 2, true);
            return true;
        } else if ("article_author_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLExternalUrl.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "article_author_name", graphQLExternalUrl.B_(), 3, false);
            return true;
        } else if ("creation_time".equals(str)) {
            graphQLExternalUrl.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "creation_time", graphQLExternalUrl.B_(), 4, false);
            return true;
        } else if ("emotional_analysis".equals(str)) {
            GraphQLEmotionalAnalysis a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLEmotionalAnalysis__JsonHelper.m7035a(FieldAccessQueryTracker.a(jsonParser, "emotional_analysis"));
            }
            graphQLExternalUrl.i = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "emotional_analysis", graphQLExternalUrl.B_(), 5, true);
            return true;
        } else if ("external_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLExternalUrl.j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "external_url", graphQLExternalUrl.B_(), 6, false);
            return true;
        } else if ("external_url_owning_profile".equals(str)) {
            GraphQLProfile a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "external_url_owning_profile"));
            }
            graphQLExternalUrl.k = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "external_url_owning_profile", graphQLExternalUrl.B_(), 7, true);
            return true;
        } else if ("icon".equals(str)) {
            GraphQLIcon a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLIcon__JsonHelper.m8613a(FieldAccessQueryTracker.a(jsonParser, "icon"));
            }
            graphQLExternalUrl.l = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "icon", graphQLExternalUrl.B_(), 8, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLExternalUrl.m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "id", graphQLExternalUrl.B_(), 9, false);
            return true;
        } else if ("instant_article".equals(str)) {
            GraphQLInstantArticle a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLInstantArticle__JsonHelper.m8732a(FieldAccessQueryTracker.a(jsonParser, "instant_article"));
            }
            graphQLExternalUrl.n = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "instant_article", graphQLExternalUrl.B_(), 10, true);
            return true;
        } else if ("link_media".equals(str)) {
            GraphQLMedia a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLMedia__JsonHelper.m9078a(FieldAccessQueryTracker.a(jsonParser, "link_media"));
            }
            graphQLExternalUrl.o = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "link_media", graphQLExternalUrl.B_(), 11, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLExternalUrl.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "name", graphQLExternalUrl.B_(), 12, false);
            return true;
        } else if ("name_search_tokens".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLExternalUrl.q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "name_search_tokens", graphQLExternalUrl.B_(), 13, false);
            return true;
        } else if ("open_graph_node".equals(str)) {
            GraphQLNode a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "open_graph_node"));
            }
            graphQLExternalUrl.r = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "open_graph_node", graphQLExternalUrl.B_(), 14, true);
            return true;
        } else if ("phrases_analysis".equals(str)) {
            GraphQLPhrasesAnalysis a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLPhrasesAnalysis__JsonHelper.m20828a(FieldAccessQueryTracker.a(jsonParser, "phrases_analysis"));
            }
            graphQLExternalUrl.s = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "phrases_analysis", graphQLExternalUrl.B_(), 15, true);
            return true;
        } else if ("quote".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "quote"));
            }
            graphQLExternalUrl.t = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "quote", graphQLExternalUrl.B_(), 16, true);
            return true;
        } else if ("quotes_analysis".equals(str)) {
            GraphQLQuotesAnalysis a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLQuotesAnalysis__JsonHelper.m21302a(FieldAccessQueryTracker.a(jsonParser, "quotes_analysis"));
            }
            graphQLExternalUrl.u = a10;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "quotes_analysis", graphQLExternalUrl.B_(), 17, true);
            return true;
        } else if ("rating".equals(str)) {
            GraphQLRating a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLRating__JsonHelper.m21310a(FieldAccessQueryTracker.a(jsonParser, "rating"));
            }
            graphQLExternalUrl.v = a11;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "rating", graphQLExternalUrl.B_(), 18, true);
            return true;
        } else if ("source".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "source"));
            }
            graphQLExternalUrl.w = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "source", graphQLExternalUrl.B_(), 20, true);
            return true;
        } else if ("summary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "summary"));
            }
            graphQLExternalUrl.x = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "summary", graphQLExternalUrl.B_(), 21, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLExternalUrl.y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "title", graphQLExternalUrl.B_(), 22, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLExternalUrl.z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "titleForSummary", graphQLExternalUrl.B_(), 23, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLExternalUrl.A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "url", graphQLExternalUrl.B_(), 24, false);
            return true;
        } else if ("user_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLExternalUrl.B = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "user_url", graphQLExternalUrl.B_(), 25, false);
            return true;
        } else if ("messenger_content_subscription_option".equals(str)) {
            GraphQLMessengerContentSubscriptionOption a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLMessengerContentSubscriptionOption__JsonHelper.m9112a(FieldAccessQueryTracker.a(jsonParser, "messenger_content_subscription_option"));
            }
            graphQLExternalUrl.C = a12;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "messenger_content_subscription_option", graphQLExternalUrl.B_(), 26, true);
            return true;
        } else if (!"canonical".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLExternalUrl2 = m7429a(FieldAccessQueryTracker.a(jsonParser, "canonical"));
            }
            graphQLExternalUrl.D = graphQLExternalUrl2;
            FieldAccessQueryTracker.a(jsonParser, graphQLExternalUrl, "canonical", graphQLExternalUrl.B_(), 27, true);
            return true;
        }
    }

    public static void m7430a(JsonGenerator jsonGenerator, GraphQLExternalUrl graphQLExternalUrl, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLExternalUrl.j() != null) {
            jsonGenerator.a("all_share_stories");
            GraphQLAllShareStoriesConnection__JsonHelper.m6535a(jsonGenerator, graphQLExternalUrl.j(), true);
        }
        jsonGenerator.a("android_urls");
        if (graphQLExternalUrl.k() != null) {
            jsonGenerator.d();
            for (String str : graphQLExternalUrl.k()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLExternalUrl.l() != null) {
            jsonGenerator.a("application");
            GraphQLApplication__JsonHelper.m6588a(jsonGenerator, graphQLExternalUrl.l(), true);
        }
        if (graphQLExternalUrl.m() != null) {
            jsonGenerator.a("article_author_name", graphQLExternalUrl.m());
        }
        jsonGenerator.a("creation_time", graphQLExternalUrl.n());
        if (graphQLExternalUrl.o() != null) {
            jsonGenerator.a("emotional_analysis");
            GraphQLEmotionalAnalysis__JsonHelper.m7036a(jsonGenerator, graphQLExternalUrl.o(), true);
        }
        if (graphQLExternalUrl.p() != null) {
            jsonGenerator.a("external_url", graphQLExternalUrl.p());
        }
        if (graphQLExternalUrl.q() != null) {
            jsonGenerator.a("external_url_owning_profile");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLExternalUrl.q(), true);
        }
        if (graphQLExternalUrl.r() != null) {
            jsonGenerator.a("icon");
            GraphQLIcon__JsonHelper.m8614a(jsonGenerator, graphQLExternalUrl.r(), true);
        }
        if (graphQLExternalUrl.s() != null) {
            jsonGenerator.a("id", graphQLExternalUrl.s());
        }
        if (graphQLExternalUrl.t() != null) {
            jsonGenerator.a("instant_article");
            GraphQLInstantArticle__JsonHelper.m8733a(jsonGenerator, graphQLExternalUrl.t(), true);
        }
        if (graphQLExternalUrl.u() != null) {
            jsonGenerator.a("link_media");
            GraphQLMedia__JsonHelper.m9079a(jsonGenerator, graphQLExternalUrl.u(), true);
        }
        if (graphQLExternalUrl.v() != null) {
            jsonGenerator.a("name", graphQLExternalUrl.v());
        }
        jsonGenerator.a("name_search_tokens");
        if (graphQLExternalUrl.w() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLExternalUrl.w()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLExternalUrl.x() != null) {
            jsonGenerator.a("open_graph_node");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLExternalUrl.x(), true);
        }
        if (graphQLExternalUrl.y() != null) {
            jsonGenerator.a("phrases_analysis");
            GraphQLPhrasesAnalysis__JsonHelper.m20829a(jsonGenerator, graphQLExternalUrl.y(), true);
        }
        if (graphQLExternalUrl.z() != null) {
            jsonGenerator.a("quote");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLExternalUrl.z(), true);
        }
        if (graphQLExternalUrl.A() != null) {
            jsonGenerator.a("quotes_analysis");
            GraphQLQuotesAnalysis__JsonHelper.m21303a(jsonGenerator, graphQLExternalUrl.A(), true);
        }
        if (graphQLExternalUrl.B() != null) {
            jsonGenerator.a("rating");
            GraphQLRating__JsonHelper.m21311a(jsonGenerator, graphQLExternalUrl.B(), true);
        }
        if (graphQLExternalUrl.C() != null) {
            jsonGenerator.a("source");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLExternalUrl.C(), true);
        }
        if (graphQLExternalUrl.D() != null) {
            jsonGenerator.a("summary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLExternalUrl.D(), true);
        }
        if (graphQLExternalUrl.E() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLExternalUrl.E(), true);
        }
        if (graphQLExternalUrl.F() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLExternalUrl.F(), true);
        }
        if (graphQLExternalUrl.G() != null) {
            jsonGenerator.a("url", graphQLExternalUrl.G());
        }
        if (graphQLExternalUrl.H() != null) {
            jsonGenerator.a("user_url", graphQLExternalUrl.H());
        }
        if (graphQLExternalUrl.I() != null) {
            jsonGenerator.a("messenger_content_subscription_option");
            GraphQLMessengerContentSubscriptionOption__JsonHelper.m9113a(jsonGenerator, graphQLExternalUrl.I(), true);
        }
        if (graphQLExternalUrl.J() != null) {
            jsonGenerator.a("canonical");
            m7430a(jsonGenerator, graphQLExternalUrl.J(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
