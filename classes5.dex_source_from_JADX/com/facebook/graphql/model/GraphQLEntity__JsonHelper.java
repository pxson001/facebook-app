package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: install_state */
public final class GraphQLEntity__JsonHelper {
    public static GraphQLEntity m7102a(JsonParser jsonParser) {
        GraphQLEntity graphQLEntity = new GraphQLEntity();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
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
                graphQLEntity.d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "__type__", graphQLEntity.a_, 0, false);
            } else if ("android_urls".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        Object o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                        if (o != null) {
                            r3.add(o);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLEntity.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "android_urls", graphQLEntity.a_, 1, false);
            } else if ("app_section".equals(i)) {
                GraphQLTimelineAppSection graphQLTimelineAppSection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTimelineAppSection = null;
                } else {
                    graphQLTimelineAppSection = GraphQLTimelineAppSection__JsonHelper.m22179a(FieldAccessQueryTracker.a(jsonParser, "app_section"));
                }
                graphQLEntity.f = graphQLTimelineAppSection;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "app_section", graphQLEntity.a_, 2, true);
            } else if ("backing_application".equals(i)) {
                GraphQLAppStoreApplication graphQLAppStoreApplication;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLAppStoreApplication = null;
                } else {
                    graphQLAppStoreApplication = GraphQLAppStoreApplication__JsonHelper.m6574a(FieldAccessQueryTracker.a(jsonParser, "backing_application"));
                }
                graphQLEntity.g = graphQLAppStoreApplication;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "backing_application", graphQLEntity.a_, 3, true);
            } else if ("cache_id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "cache_id", graphQLEntity.a_, 4, false);
            } else if ("event_buy_ticket_display_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "event_buy_ticket_display_url", graphQLEntity.a_, 5, false);
            } else if ("event_buy_ticket_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "event_buy_ticket_url", graphQLEntity.a_, 6, false);
            } else if ("external_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "external_url", graphQLEntity.a_, 7, false);
            } else if ("friendship_status".equals(i)) {
                graphQLEntity.l = GraphQLFriendshipStatus.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "friendship_status", graphQLEntity.a_, 8, false);
            } else if ("height".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLEntity.m = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "height", graphQLEntity.a_, 9, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.n = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "id", graphQLEntity.a_, 10, false);
            } else if ("image".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
                }
                graphQLEntity.o = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "image", graphQLEntity.a_, 11, true);
            } else if ("initial_view_heading_degrees".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLEntity.p = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "initial_view_heading_degrees", graphQLEntity.a_, 12, false);
            } else if ("initial_view_pitch_degrees".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLEntity.q = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "initial_view_pitch_degrees", graphQLEntity.a_, 13, false);
            } else if ("initial_view_roll_degrees".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLEntity.r = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "initial_view_roll_degrees", graphQLEntity.a_, 14, false);
            } else if ("intermediate_image".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "intermediate_image"));
                }
                graphQLEntity.s = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "intermediate_image", graphQLEntity.a_, 15, true);
            } else if ("is_spherical".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLEntity.t = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "is_spherical", graphQLEntity.a_, 16, false);
            } else if ("message".equals(i)) {
                GraphQLTextWithEntities graphQLTextWithEntities;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = null;
                } else {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
                }
                graphQLEntity.u = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "message", graphQLEntity.a_, 17, true);
            } else if ("name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.v = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "name", graphQLEntity.a_, 18, false);
            } else if ("page".equals(i)) {
                GraphQLPage graphQLPage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPage = null;
                } else {
                    graphQLPage = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "page"));
                }
                graphQLEntity.w = graphQLPage;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "page", graphQLEntity.a_, 19, true);
            } else if ("playable_duration_in_ms".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLEntity.x = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "playable_duration_in_ms", graphQLEntity.a_, 20, false);
            } else if ("playable_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.y = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "playable_url", graphQLEntity.a_, 21, false);
            } else if ("playable_url_hd".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.z = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "playable_url_hd", graphQLEntity.a_, 22, false);
            } else if ("playable_url_preferred".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.A = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "playable_url_preferred", graphQLEntity.a_, 23, false);
            } else if ("playlist".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.B = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "playlist", graphQLEntity.a_, 24, false);
            } else if ("preview_payload".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.C = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "preview_payload", graphQLEntity.a_, 25, false);
            } else if ("profilePicture50".equals(i)) {
                graphQLEntity.D = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "profilePicture50", graphQLEntity.a_, 26, true);
            } else if ("profile_picture".equals(i)) {
                graphQLEntity.E = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "profile_picture", graphQLEntity.a_, 27, true);
            } else if ("projection_type".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.F = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "projection_type", graphQLEntity.a_, 28, false);
            } else if ("redirection_info".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLRedirectionInfo a = GraphQLRedirectionInfo__JsonHelper.m21381a(FieldAccessQueryTracker.a(jsonParser, "redirection_info"));
                        if (a != null) {
                            r3.add(a);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLEntity.G = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "redirection_info", graphQLEntity.a_, 29, true);
            } else if ("shareable".equals(i)) {
                GraphQLEntity graphQLEntity2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLEntity2 = null;
                } else {
                    graphQLEntity2 = m7102a(FieldAccessQueryTracker.a(jsonParser, "shareable"));
                }
                graphQLEntity.H = graphQLEntity2;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "shareable", graphQLEntity.a_, 30, true);
            } else if ("sphericalFullscreenAspectRatio".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0.0d;
                } else {
                    r3 = jsonParser.G();
                }
                graphQLEntity.I = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "sphericalFullscreenAspectRatio", graphQLEntity.a_, 31, false);
            } else if ("sphericalInlineAspectRatio".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0.0d;
                } else {
                    r3 = jsonParser.G();
                }
                graphQLEntity.J = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "sphericalInlineAspectRatio", graphQLEntity.a_, 32, false);
            } else if ("sphericalPlayableUrlHdString".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.K = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "sphericalPlayableUrlHdString", graphQLEntity.a_, 33, false);
            } else if ("sphericalPlayableUrlSdString".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.L = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "sphericalPlayableUrlSdString", graphQLEntity.a_, 34, false);
            } else if ("sphericalPreferredFov".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLEntity.M = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "sphericalPreferredFov", graphQLEntity.a_, 35, false);
            } else if ("subscribe_status".equals(i)) {
                graphQLEntity.N = GraphQLSubscribeStatus.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "subscribe_status", graphQLEntity.a_, 36, false);
            } else if ("tag".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.O = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "tag", graphQLEntity.a_, 37, false);
            } else if ("url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.P = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "url", graphQLEntity.a_, 38, false);
            } else if ("video_preview_image".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "video_preview_image"));
                }
                graphQLEntity.Q = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "video_preview_image", graphQLEntity.a_, 39, true);
            } else if ("width".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLEntity.R = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "width", graphQLEntity.a_, 40, false);
            } else if ("sphericalPlaylist".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntity.S = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntity, "sphericalPlaylist", graphQLEntity.a_, 41, false);
            }
            jsonParser.f();
        }
        return graphQLEntity;
    }

    public static void m7103a(JsonGenerator jsonGenerator, GraphQLEntity graphQLEntity, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEntity.b() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLEntity.b().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("android_urls");
        if (graphQLEntity.c() != null) {
            jsonGenerator.d();
            for (String str : graphQLEntity.c()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEntity.j() != null) {
            jsonGenerator.a("app_section");
            GraphQLTimelineAppSection__JsonHelper.m22180a(jsonGenerator, graphQLEntity.j(), true);
        }
        if (graphQLEntity.k() != null) {
            jsonGenerator.a("backing_application");
            GraphQLAppStoreApplication__JsonHelper.m6575a(jsonGenerator, graphQLEntity.k(), true);
        }
        if (graphQLEntity.l() != null) {
            jsonGenerator.a("cache_id", graphQLEntity.l());
        }
        if (graphQLEntity.m() != null) {
            jsonGenerator.a("event_buy_ticket_display_url", graphQLEntity.m());
        }
        if (graphQLEntity.n() != null) {
            jsonGenerator.a("event_buy_ticket_url", graphQLEntity.n());
        }
        if (graphQLEntity.o() != null) {
            jsonGenerator.a("external_url", graphQLEntity.o());
        }
        if (graphQLEntity.p() != null) {
            jsonGenerator.a("friendship_status", graphQLEntity.p().toString());
        }
        jsonGenerator.a("height", graphQLEntity.q());
        if (graphQLEntity.d() != null) {
            jsonGenerator.a("id", graphQLEntity.d());
        }
        if (graphQLEntity.r() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEntity.r(), true);
        }
        jsonGenerator.a("initial_view_heading_degrees", graphQLEntity.s());
        jsonGenerator.a("initial_view_pitch_degrees", graphQLEntity.t());
        jsonGenerator.a("initial_view_roll_degrees", graphQLEntity.u());
        if (graphQLEntity.v() != null) {
            jsonGenerator.a("intermediate_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEntity.v(), true);
        }
        jsonGenerator.a("is_spherical", graphQLEntity.w());
        if (graphQLEntity.x() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEntity.x(), true);
        }
        if (graphQLEntity.C_() != null) {
            jsonGenerator.a("name", graphQLEntity.C_());
        }
        if (graphQLEntity.y() != null) {
            jsonGenerator.a("page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLEntity.y(), true);
        }
        jsonGenerator.a("playable_duration_in_ms", graphQLEntity.z());
        if (graphQLEntity.A() != null) {
            jsonGenerator.a("playable_url", graphQLEntity.A());
        }
        if (graphQLEntity.B() != null) {
            jsonGenerator.a("playable_url_hd", graphQLEntity.B());
        }
        if (graphQLEntity.C() != null) {
            jsonGenerator.a("playable_url_preferred", graphQLEntity.C());
        }
        if (graphQLEntity.D() != null) {
            jsonGenerator.a("playlist", graphQLEntity.D());
        }
        if (graphQLEntity.E() != null) {
            jsonGenerator.a("preview_payload", graphQLEntity.E());
        }
        if (graphQLEntity.F() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEntity.F(), true);
        }
        if (graphQLEntity.G() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEntity.G(), true);
        }
        if (graphQLEntity.H() != null) {
            jsonGenerator.a("projection_type", graphQLEntity.H());
        }
        jsonGenerator.a("redirection_info");
        if (graphQLEntity.I() != null) {
            jsonGenerator.d();
            for (GraphQLRedirectionInfo graphQLRedirectionInfo : graphQLEntity.I()) {
                if (graphQLRedirectionInfo != null) {
                    GraphQLRedirectionInfo__JsonHelper.m21382a(jsonGenerator, graphQLRedirectionInfo, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEntity.J() != null) {
            jsonGenerator.a("shareable");
            m7103a(jsonGenerator, graphQLEntity.J(), true);
        }
        jsonGenerator.a("sphericalFullscreenAspectRatio", graphQLEntity.K());
        jsonGenerator.a("sphericalInlineAspectRatio", graphQLEntity.L());
        if (graphQLEntity.M() != null) {
            jsonGenerator.a("sphericalPlayableUrlHdString", graphQLEntity.M());
        }
        if (graphQLEntity.N() != null) {
            jsonGenerator.a("sphericalPlayableUrlSdString", graphQLEntity.N());
        }
        jsonGenerator.a("sphericalPreferredFov", graphQLEntity.O());
        if (graphQLEntity.P() != null) {
            jsonGenerator.a("subscribe_status", graphQLEntity.P().toString());
        }
        if (graphQLEntity.g() != null) {
            jsonGenerator.a("tag", graphQLEntity.g());
        }
        if (graphQLEntity.D_() != null) {
            jsonGenerator.a("url", graphQLEntity.D_());
        }
        if (graphQLEntity.Q() != null) {
            jsonGenerator.a("video_preview_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEntity.Q(), true);
        }
        jsonGenerator.a("width", graphQLEntity.R());
        if (graphQLEntity.S() != null) {
            jsonGenerator.a("sphericalPlaylist", graphQLEntity.S());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
