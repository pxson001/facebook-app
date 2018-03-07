package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: WATCHABLE */
public final class GraphQLPlace__JsonHelper {
    public static GraphQLPlace m20921a(JsonParser jsonParser) {
        GraphQLPlace graphQLPlace = new GraphQLPlace();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m20923a(graphQLPlace, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPlace;
    }

    private static boolean m20923a(GraphQLPlace graphQLPlace, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("__type__".equals(str)) {
            GraphQLObjectType a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLObjectType.a(jsonParser);
            }
            graphQLPlace.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "__type__", graphQLPlace.a_, 0, false);
            return true;
        } else if ("address".equals(str)) {
            GraphQLStreetAddress a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLStreetAddress__JsonHelper.m21936a(FieldAccessQueryTracker.a(jsonParser, "address"));
            }
            graphQLPlace.e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "address", graphQLPlace.B_(), 1, true);
            return true;
        } else if ("can_viewer_claim".equals(str)) {
            graphQLPlace.f = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "can_viewer_claim", graphQLPlace.B_(), 3, false);
            return true;
        } else if ("can_viewer_rate".equals(str)) {
            graphQLPlace.g = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "can_viewer_rate", graphQLPlace.B_(), 4, false);
            return true;
        } else if ("category_icon".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "category_icon"));
            }
            graphQLPlace.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "category_icon", graphQLPlace.B_(), 5, true);
            return true;
        } else if ("category_names".equals(str)) {
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
            graphQLPlace.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "category_names", graphQLPlace.B_(), 6, false);
            return true;
        } else if ("category_type".equals(str)) {
            graphQLPlace.j = GraphQLPageCategoryType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "category_type", graphQLPlace.B_(), 7, false);
            return true;
        } else if ("city".equals(str)) {
            GraphQLPage a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "city"));
            }
            graphQLPlace.k = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "city", graphQLPlace.B_(), 8, true);
            return true;
        } else if ("contextual_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPlace.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "contextual_name", graphQLPlace.B_(), 9, false);
            return true;
        } else if ("does_viewer_like".equals(str)) {
            graphQLPlace.m = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "does_viewer_like", graphQLPlace.B_(), 10, false);
            return true;
        } else if ("expressed_as_place".equals(str)) {
            graphQLPlace.n = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "expressed_as_place", graphQLPlace.B_(), 11, false);
            return true;
        } else if ("friends_who_visited".equals(str)) {
            GraphQLFriendsWhoVisitedConnection a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLFriendsWhoVisitedConnection__JsonHelper.m7647a(FieldAccessQueryTracker.a(jsonParser, "friends_who_visited"));
            }
            graphQLPlace.o = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "friends_who_visited", graphQLPlace.B_(), 12, true);
            return true;
        } else if ("full_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPlace.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "full_name", graphQLPlace.B_(), 13, false);
            return true;
        } else if ("hours".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLTimeRange a5 = GraphQLTimeRange__JsonHelper.m22114a(FieldAccessQueryTracker.a(jsonParser, "hours"));
                    if (a5 != null) {
                        r1.add(a5);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPlace.q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "hours", graphQLPlace.B_(), 14, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPlace.r = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "id", graphQLPlace.B_(), 15, false);
            return true;
        } else if ("is_owned".equals(str)) {
            graphQLPlace.s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "is_owned", graphQLPlace.B_(), 16, false);
            return true;
        } else if ("location".equals(str)) {
            GraphQLLocation a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLLocation__JsonHelper.m8965a(FieldAccessQueryTracker.a(jsonParser, "location"));
            }
            graphQLPlace.t = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "location", graphQLPlace.B_(), 17, true);
            return true;
        } else if ("map_bounding_box".equals(str)) {
            GraphQLGeoRectangle a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLGeoRectangle__JsonHelper.m7766a(FieldAccessQueryTracker.a(jsonParser, "map_bounding_box"));
            }
            graphQLPlace.u = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "map_bounding_box", graphQLPlace.B_(), 18, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPlace.v = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "name", graphQLPlace.B_(), 19, false);
            return true;
        } else if ("overall_star_rating".equals(str)) {
            GraphQLRating a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLRating__JsonHelper.m21310a(FieldAccessQueryTracker.a(jsonParser, "overall_star_rating"));
            }
            graphQLPlace.w = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "overall_star_rating", graphQLPlace.B_(), 20, true);
            return true;
        } else if ("page_likers".equals(str)) {
            GraphQLPageLikersConnection a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLPageLikersConnection__JsonHelper.m9494a(FieldAccessQueryTracker.a(jsonParser, "page_likers"));
            }
            graphQLPlace.x = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "page_likers", graphQLPlace.B_(), 21, true);
            return true;
        } else if ("page_visits".equals(str)) {
            GraphQLPageVisitsConnection a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLPageVisitsConnection__JsonHelper.m9551a(FieldAccessQueryTracker.a(jsonParser, "page_visits"));
            }
            graphQLPlace.y = a10;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "page_visits", graphQLPlace.B_(), 22, true);
            return true;
        } else if ("permanently_closed_status".equals(str)) {
            graphQLPlace.z = GraphQLPermanentlyClosedStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "permanently_closed_status", graphQLPlace.B_(), 23, false);
            return true;
        } else if ("placeProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "placeProfilePicture"));
            }
            graphQLPlace.A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "placeProfilePicture", graphQLPlace.B_(), 24, true);
            return true;
        } else if ("place_topic_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPlace.B = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "place_topic_id", graphQLPlace.B_(), 25, false);
            return true;
        } else if ("place_type".equals(str)) {
            graphQLPlace.C = GraphQLPlaceType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "place_type", graphQLPlace.B_(), 26, false);
            return true;
        } else if ("price_range_description".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPlace.D = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "price_range_description", graphQLPlace.B_(), 27, false);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
            }
            graphQLPlace.E = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "profilePicture50", graphQLPlace.B_(), 28, true);
            return true;
        } else if ("profilePicture74".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture74"));
            }
            graphQLPlace.F = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "profilePicture74", graphQLPlace.B_(), 29, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
            }
            graphQLPlace.G = a11;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "profile_photo", graphQLPlace.B_(), 30, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLPlace.H = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "profile_picture", graphQLPlace.B_(), 31, true);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLPlace.I = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "profile_picture_is_silhouette", graphQLPlace.B_(), 32, false);
            return true;
        } else if ("raters".equals(str)) {
            GraphQLPageStarRatersConnection a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLPageStarRatersConnection__JsonHelper.m9521a(FieldAccessQueryTracker.a(jsonParser, "raters"));
            }
            graphQLPlace.J = a12;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "raters", graphQLPlace.B_(), 33, true);
            return true;
        } else if ("redirection_info".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLRedirectionInfo a13 = GraphQLRedirectionInfo__JsonHelper.m21381a(FieldAccessQueryTracker.a(jsonParser, "redirection_info"));
                    if (a13 != null) {
                        r1.add(a13);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPlace.K = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "redirection_info", graphQLPlace.B_(), 34, true);
            return true;
        } else if ("representative_place_photos".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLPhoto a14 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "representative_place_photos"));
                    if (a14 != null) {
                        r1.add(a14);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPlace.L = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "representative_place_photos", graphQLPlace.B_(), 35, true);
            return true;
        } else if ("saved_collection".equals(str)) {
            GraphQLTimelineAppCollection a15;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a15 = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "saved_collection"));
            }
            graphQLPlace.M = a15;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "saved_collection", graphQLPlace.B_(), 36, true);
            return true;
        } else if ("short_category_names".equals(str)) {
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
            graphQLPlace.N = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "short_category_names", graphQLPlace.B_(), 37, false);
            return true;
        } else if ("should_show_reviews_on_profile".equals(str)) {
            graphQLPlace.O = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "should_show_reviews_on_profile", graphQLPlace.B_(), 38, false);
            return true;
        } else if ("spotlight_locals_snippets".equals(str)) {
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
            graphQLPlace.P = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "spotlight_locals_snippets", graphQLPlace.B_(), 39, false);
            return true;
        } else if ("super_category_type".equals(str)) {
            graphQLPlace.Q = GraphQLPageSuperCategoryType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "super_category_type", graphQLPlace.B_(), 40, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPlace.R = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "url", graphQLPlace.B_(), 41, false);
            return true;
        } else if ("viewer_profile_permissions".equals(str)) {
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
            graphQLPlace.S = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "viewer_profile_permissions", graphQLPlace.B_(), 42, false);
            return true;
        } else if ("viewer_saved_state".equals(str)) {
            graphQLPlace.T = GraphQLSavedState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "viewer_saved_state", graphQLPlace.B_(), 43, false);
            return true;
        } else if ("websites".equals(str)) {
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
            graphQLPlace.U = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "websites", graphQLPlace.B_(), 44, false);
            return true;
        } else if ("viewer_visits".equals(str)) {
            GraphQLViewerVisitsConnection a16;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a16 = GraphQLViewerVisitsConnection__JsonHelper.m22492a(FieldAccessQueryTracker.a(jsonParser, "viewer_visits"));
            }
            graphQLPlace.V = a16;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "viewer_visits", graphQLPlace.B_(), 45, true);
            return true;
        } else if ("place_open_status".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "place_open_status"));
            }
            graphQLPlace.W = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "place_open_status", graphQLPlace.B_(), 46, true);
            return true;
        } else if (!"place_open_status_type".equals(str)) {
            return false;
        } else {
            graphQLPlace.X = GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPlace, "place_open_status_type", graphQLPlace.B_(), 47, false);
            return true;
        }
    }

    public static void m20922a(JsonGenerator jsonGenerator, GraphQLPlace graphQLPlace, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPlace.j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLPlace.j().e());
            jsonGenerator.g();
        }
        if (graphQLPlace.k() != null) {
            jsonGenerator.a("address");
            GraphQLStreetAddress__JsonHelper.m21937a(jsonGenerator, graphQLPlace.k(), true);
        }
        jsonGenerator.a("can_viewer_claim", graphQLPlace.l());
        jsonGenerator.a("can_viewer_rate", graphQLPlace.m());
        if (graphQLPlace.n() != null) {
            jsonGenerator.a("category_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPlace.n(), true);
        }
        jsonGenerator.a("category_names");
        if (graphQLPlace.o() != null) {
            jsonGenerator.d();
            for (String str : graphQLPlace.o()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPlace.p() != null) {
            jsonGenerator.a("category_type", graphQLPlace.p().toString());
        }
        if (graphQLPlace.q() != null) {
            jsonGenerator.a("city");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLPlace.q(), true);
        }
        if (graphQLPlace.r() != null) {
            jsonGenerator.a("contextual_name", graphQLPlace.r());
        }
        jsonGenerator.a("does_viewer_like", graphQLPlace.s());
        jsonGenerator.a("expressed_as_place", graphQLPlace.t());
        if (graphQLPlace.u() != null) {
            jsonGenerator.a("friends_who_visited");
            GraphQLFriendsWhoVisitedConnection__JsonHelper.m7648a(jsonGenerator, graphQLPlace.u(), true);
        }
        if (graphQLPlace.v() != null) {
            jsonGenerator.a("full_name", graphQLPlace.v());
        }
        jsonGenerator.a("hours");
        if (graphQLPlace.w() != null) {
            jsonGenerator.d();
            for (GraphQLTimeRange graphQLTimeRange : graphQLPlace.w()) {
                if (graphQLTimeRange != null) {
                    GraphQLTimeRange__JsonHelper.m22115a(jsonGenerator, graphQLTimeRange, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPlace.x() != null) {
            jsonGenerator.a("id", graphQLPlace.x());
        }
        jsonGenerator.a("is_owned", graphQLPlace.y());
        if (graphQLPlace.z() != null) {
            jsonGenerator.a("location");
            GraphQLLocation__JsonHelper.m8966a(jsonGenerator, graphQLPlace.z(), true);
        }
        if (graphQLPlace.A() != null) {
            jsonGenerator.a("map_bounding_box");
            GraphQLGeoRectangle__JsonHelper.m7767a(jsonGenerator, graphQLPlace.A(), true);
        }
        if (graphQLPlace.B() != null) {
            jsonGenerator.a("name", graphQLPlace.B());
        }
        if (graphQLPlace.C() != null) {
            jsonGenerator.a("overall_star_rating");
            GraphQLRating__JsonHelper.m21311a(jsonGenerator, graphQLPlace.C(), true);
        }
        if (graphQLPlace.D() != null) {
            jsonGenerator.a("page_likers");
            GraphQLPageLikersConnection__JsonHelper.m9495a(jsonGenerator, graphQLPlace.D(), true);
        }
        if (graphQLPlace.E() != null) {
            jsonGenerator.a("page_visits");
            GraphQLPageVisitsConnection__JsonHelper.m9552a(jsonGenerator, graphQLPlace.E(), true);
        }
        if (graphQLPlace.F() != null) {
            jsonGenerator.a("permanently_closed_status", graphQLPlace.F().toString());
        }
        if (graphQLPlace.G() != null) {
            jsonGenerator.a("placeProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPlace.G(), true);
        }
        if (graphQLPlace.H() != null) {
            jsonGenerator.a("place_topic_id", graphQLPlace.H());
        }
        if (graphQLPlace.I() != null) {
            jsonGenerator.a("place_type", graphQLPlace.I().toString());
        }
        if (graphQLPlace.J() != null) {
            jsonGenerator.a("price_range_description", graphQLPlace.J());
        }
        if (graphQLPlace.K() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPlace.K(), true);
        }
        if (graphQLPlace.L() != null) {
            jsonGenerator.a("profilePicture74");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPlace.L(), true);
        }
        if (graphQLPlace.M() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLPlace.M(), true);
        }
        if (graphQLPlace.N() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPlace.N(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLPlace.O());
        if (graphQLPlace.P() != null) {
            jsonGenerator.a("raters");
            GraphQLPageStarRatersConnection__JsonHelper.m9522a(jsonGenerator, graphQLPlace.P(), true);
        }
        jsonGenerator.a("redirection_info");
        if (graphQLPlace.Q() != null) {
            jsonGenerator.d();
            for (GraphQLRedirectionInfo graphQLRedirectionInfo : graphQLPlace.Q()) {
                if (graphQLRedirectionInfo != null) {
                    GraphQLRedirectionInfo__JsonHelper.m21382a(jsonGenerator, graphQLRedirectionInfo, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("representative_place_photos");
        if (graphQLPlace.R() != null) {
            jsonGenerator.d();
            for (GraphQLPhoto graphQLPhoto : graphQLPlace.R()) {
                if (graphQLPhoto != null) {
                    GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLPhoto, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPlace.S() != null) {
            jsonGenerator.a("saved_collection");
            GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLPlace.S(), true);
        }
        jsonGenerator.a("short_category_names");
        if (graphQLPlace.T() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLPlace.T()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("should_show_reviews_on_profile", graphQLPlace.U());
        jsonGenerator.a("spotlight_locals_snippets");
        if (graphQLPlace.V() != null) {
            jsonGenerator.d();
            for (String str22 : graphQLPlace.V()) {
                if (str22 != null) {
                    jsonGenerator.b(str22);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPlace.W() != null) {
            jsonGenerator.a("super_category_type", graphQLPlace.W().toString());
        }
        if (graphQLPlace.X() != null) {
            jsonGenerator.a("url", graphQLPlace.X());
        }
        jsonGenerator.a("viewer_profile_permissions");
        if (graphQLPlace.Y() != null) {
            jsonGenerator.d();
            for (String str222 : graphQLPlace.Y()) {
                if (str222 != null) {
                    jsonGenerator.b(str222);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPlace.Z() != null) {
            jsonGenerator.a("viewer_saved_state", graphQLPlace.Z().toString());
        }
        jsonGenerator.a("websites");
        if (graphQLPlace.aa() != null) {
            jsonGenerator.d();
            for (String str2222 : graphQLPlace.aa()) {
                if (str2222 != null) {
                    jsonGenerator.b(str2222);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPlace.ab() != null) {
            jsonGenerator.a("viewer_visits");
            GraphQLViewerVisitsConnection__JsonHelper.m22493a(jsonGenerator, graphQLPlace.ab(), true);
        }
        if (graphQLPlace.ac() != null) {
            jsonGenerator.a("place_open_status");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPlace.ac(), true);
        }
        if (graphQLPlace.ad() != null) {
            jsonGenerator.a("place_open_status_type", graphQLPlace.ad().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
