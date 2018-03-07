package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLAppStoreApplicationInstallState;
import com.facebook.graphql.enums.GraphQLAppStoreDownloadConnectivityPolicy;
import com.facebook.graphql.enums.GraphQLDigitalGoodStoreType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: is_viewer_suggested_tagger */
public final class GraphQLAppStoreApplication__JsonHelper {
    public static GraphQLAppStoreApplication m6574a(JsonParser jsonParser) {
        GraphQLAppStoreApplication graphQLAppStoreApplication = new GraphQLAppStoreApplication();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("app_name".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAppStoreApplication.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "app_name", graphQLAppStoreApplication.a_, 0, false);
            } else if ("app_store_identifier".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAppStoreApplication.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "app_store_identifier", graphQLAppStoreApplication.a_, 1, false);
            } else if ("artifact_size_description".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAppStoreApplication.f = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "artifact_size_description", graphQLAppStoreApplication.a_, 2, false);
            } else if ("banner_screenshots".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "banner_screenshots"));
                        if (r4 != null) {
                            r3.add(r4);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLAppStoreApplication.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "banner_screenshots", graphQLAppStoreApplication.a_, 3, true);
            } else if ("description".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "description"));
                }
                graphQLAppStoreApplication.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "description", graphQLAppStoreApplication.a_, 4, true);
            } else if ("download_connectivity_policy".equals(i)) {
                graphQLAppStoreApplication.i = GraphQLAppStoreDownloadConnectivityPolicy.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "download_connectivity_policy", graphQLAppStoreApplication.a_, 5, false);
            } else if ("icon_url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAppStoreApplication.j = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "icon_url", graphQLAppStoreApplication.a_, 6, false);
            } else if ("install_id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAppStoreApplication.k = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "install_id", graphQLAppStoreApplication.a_, 7, false);
            } else if ("install_state".equals(i)) {
                graphQLAppStoreApplication.l = GraphQLAppStoreApplicationInstallState.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "install_state", graphQLAppStoreApplication.a_, 8, false);
            } else if ("likes_context_sentence".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "likes_context_sentence"));
                }
                graphQLAppStoreApplication.m = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "likes_context_sentence", graphQLAppStoreApplication.a_, 9, true);
            } else if ("permissions".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        Object o2 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                        if (o2 != null) {
                            r3.add(o2);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLAppStoreApplication.n = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "permissions", graphQLAppStoreApplication.a_, 10, false);
            } else if ("phone_screenshots".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "phone_screenshots"));
                        if (r4 != null) {
                            r3.add(r4);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLAppStoreApplication.o = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "phone_screenshots", graphQLAppStoreApplication.a_, 11, true);
            } else if ("platform_application".equals(i)) {
                GraphQLApplication graphQLApplication;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLApplication = null;
                } else {
                    graphQLApplication = GraphQLApplication__JsonHelper.m6587a(FieldAccessQueryTracker.a(jsonParser, "platform_application"));
                }
                graphQLAppStoreApplication.p = graphQLApplication;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "platform_application", graphQLAppStoreApplication.a_, 12, true);
            } else if ("publisher".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAppStoreApplication.q = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "publisher", graphQLAppStoreApplication.a_, 13, false);
            } else if ("supported_app_stores".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLDigitalGoodStoreType fromString = GraphQLDigitalGoodStoreType.fromString(jsonParser.o());
                        if (fromString != null) {
                            r3.add(fromString);
                        }
                    }
                }
                graphQLAppStoreApplication.r = r3 == null ? null : ImmutableList.copyOf(r3);
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "supported_app_stores", graphQLAppStoreApplication.a_, 14, false);
            } else if ("usage_context_sentence".equals(i)) {
                graphQLAppStoreApplication.s = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "usage_context_sentence"));
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "usage_context_sentence", graphQLAppStoreApplication.a_, 15, true);
            } else if ("version_code".equals(i)) {
                graphQLAppStoreApplication.t = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "version_code", graphQLAppStoreApplication.a_, 16, false);
            } else if ("version_name".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAppStoreApplication.u = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppStoreApplication, "version_name", graphQLAppStoreApplication.a_, 17, false);
            }
            jsonParser.f();
        }
        return graphQLAppStoreApplication;
    }

    public static void m6575a(JsonGenerator jsonGenerator, GraphQLAppStoreApplication graphQLAppStoreApplication, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLAppStoreApplication.a() != null) {
            jsonGenerator.a("app_name", graphQLAppStoreApplication.a());
        }
        if (graphQLAppStoreApplication.j() != null) {
            jsonGenerator.a("app_store_identifier", graphQLAppStoreApplication.j());
        }
        if (graphQLAppStoreApplication.k() != null) {
            jsonGenerator.a("artifact_size_description", graphQLAppStoreApplication.k());
        }
        jsonGenerator.a("banner_screenshots");
        if (graphQLAppStoreApplication.l() != null) {
            jsonGenerator.d();
            for (GraphQLImage graphQLImage : graphQLAppStoreApplication.l()) {
                if (graphQLImage != null) {
                    GraphQLImage__JsonHelper.a(jsonGenerator, graphQLImage, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLAppStoreApplication.m() != null) {
            jsonGenerator.a("description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLAppStoreApplication.m(), true);
        }
        if (graphQLAppStoreApplication.n() != null) {
            jsonGenerator.a("download_connectivity_policy", graphQLAppStoreApplication.n().toString());
        }
        if (graphQLAppStoreApplication.o() != null) {
            jsonGenerator.a("icon_url", graphQLAppStoreApplication.o());
        }
        if (graphQLAppStoreApplication.p() != null) {
            jsonGenerator.a("install_id", graphQLAppStoreApplication.p());
        }
        if (graphQLAppStoreApplication.q() != null) {
            jsonGenerator.a("install_state", graphQLAppStoreApplication.q().toString());
        }
        if (graphQLAppStoreApplication.r() != null) {
            jsonGenerator.a("likes_context_sentence");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLAppStoreApplication.r(), true);
        }
        jsonGenerator.a("permissions");
        if (graphQLAppStoreApplication.s() != null) {
            jsonGenerator.d();
            for (String str : graphQLAppStoreApplication.s()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("phone_screenshots");
        if (graphQLAppStoreApplication.t() != null) {
            jsonGenerator.d();
            for (GraphQLImage graphQLImage2 : graphQLAppStoreApplication.t()) {
                if (graphQLImage2 != null) {
                    GraphQLImage__JsonHelper.a(jsonGenerator, graphQLImage2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLAppStoreApplication.u() != null) {
            jsonGenerator.a("platform_application");
            GraphQLApplication__JsonHelper.m6588a(jsonGenerator, graphQLAppStoreApplication.u(), true);
        }
        if (graphQLAppStoreApplication.v() != null) {
            jsonGenerator.a("publisher", graphQLAppStoreApplication.v());
        }
        jsonGenerator.a("supported_app_stores");
        if (graphQLAppStoreApplication.w() != null) {
            jsonGenerator.d();
            for (GraphQLDigitalGoodStoreType graphQLDigitalGoodStoreType : graphQLAppStoreApplication.w()) {
                if (graphQLDigitalGoodStoreType != null) {
                    jsonGenerator.b(graphQLDigitalGoodStoreType.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLAppStoreApplication.x() != null) {
            jsonGenerator.a("usage_context_sentence");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLAppStoreApplication.x(), true);
        }
        jsonGenerator.a("version_code", graphQLAppStoreApplication.y());
        if (graphQLAppStoreApplication.z() != null) {
            jsonGenerator.a("version_name", graphQLAppStoreApplication.z());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
