package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLMusicType;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: eventProfilePicture */
public final class GraphQLOpenGraphObject__JsonHelper {
    public static GraphQLOpenGraphObject m9409a(JsonParser jsonParser) {
        GraphQLOpenGraphObject graphQLOpenGraphObject = new GraphQLOpenGraphObject();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9411a(graphQLOpenGraphObject, i, jsonParser);
            jsonParser.f();
        }
        return graphQLOpenGraphObject;
    }

    private static boolean m9411a(GraphQLOpenGraphObject graphQLOpenGraphObject, String str, JsonParser jsonParser) {
        List list = null;
        Collection arrayList;
        if ("android_urls".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    Object o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    if (o != null) {
                        arrayList.add(o);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                list = ImmutableList.copyOf(arrayList);
            }
            graphQLOpenGraphObject.d = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "android_urls", graphQLOpenGraphObject.a_, 0, false);
            return true;
        } else if ("application".equals(str)) {
            GraphQLApplication a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLApplication__JsonHelper.m6587a(FieldAccessQueryTracker.a(jsonParser, "application"));
            }
            graphQLOpenGraphObject.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "application", graphQLOpenGraphObject.B_(), 1, true);
            return true;
        } else if ("can_viewer_share".equals(str)) {
            graphQLOpenGraphObject.f = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "can_viewer_share", graphQLOpenGraphObject.B_(), 2, false);
            return true;
        } else if ("category_icon".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "category_icon"));
            }
            graphQLOpenGraphObject.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "category_icon", graphQLOpenGraphObject.B_(), 3, true);
            return true;
        } else if ("concise_description".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLOpenGraphObject.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "concise_description", graphQLOpenGraphObject.B_(), 4, false);
            return true;
        } else if ("contextual_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLOpenGraphObject.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "contextual_name", graphQLOpenGraphObject.B_(), 5, false);
            return true;
        } else if ("creation_time".equals(str)) {
            graphQLOpenGraphObject.j = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "creation_time", graphQLOpenGraphObject.B_(), 6, false);
            return true;
        } else if ("feedAwesomizerProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
            }
            graphQLOpenGraphObject.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "feedAwesomizerProfilePicture", graphQLOpenGraphObject.B_(), 8, true);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLOpenGraphObject.l = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "feedback", graphQLOpenGraphObject.B_(), 9, true);
            return true;
        } else if ("global_share".equals(str)) {
            GraphQLExternalUrl a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLExternalUrl__JsonHelper.m7429a(FieldAccessQueryTracker.a(jsonParser, "global_share"));
            }
            graphQLOpenGraphObject.m = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "global_share", graphQLOpenGraphObject.B_(), 10, true);
            return true;
        } else if ("has_viewer_saved".equals(str)) {
            graphQLOpenGraphObject.n = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "has_viewer_saved", graphQLOpenGraphObject.B_(), 11, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLOpenGraphObject.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "id", graphQLOpenGraphObject.B_(), 12, false);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLOpenGraphObject.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "imageHighOrig", graphQLOpenGraphObject.B_(), 13, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLOpenGraphObject.q = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "inline_activities", graphQLOpenGraphObject.B_(), 14, true);
            return true;
        } else if ("is_music_item".equals(str)) {
            graphQLOpenGraphObject.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "is_music_item", graphQLOpenGraphObject.B_(), 15, false);
            return true;
        } else if ("location".equals(str)) {
            GraphQLLocation a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLLocation__JsonHelper.m8965a(FieldAccessQueryTracker.a(jsonParser, "location"));
            }
            graphQLOpenGraphObject.s = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "location", graphQLOpenGraphObject.B_(), 16, true);
            return true;
        } else if ("map_bounding_box".equals(str)) {
            GraphQLGeoRectangle a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLGeoRectangle__JsonHelper.m7766a(FieldAccessQueryTracker.a(jsonParser, "map_bounding_box"));
            }
            graphQLOpenGraphObject.t = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "map_bounding_box", graphQLOpenGraphObject.B_(), 17, true);
            return true;
        } else if ("map_points".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLLocation a7 = GraphQLLocation__JsonHelper.m8965a(FieldAccessQueryTracker.a(jsonParser, "map_points"));
                    if (a7 != null) {
                        arrayList.add(a7);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                list = ImmutableList.copyOf(arrayList);
            }
            graphQLOpenGraphObject.u = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "map_points", graphQLOpenGraphObject.B_(), 18, true);
            return true;
        } else if ("map_zoom_level".equals(str)) {
            graphQLOpenGraphObject.v = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "map_zoom_level", graphQLOpenGraphObject.B_(), 19, false);
            return true;
        } else if ("music_type".equals(str)) {
            graphQLOpenGraphObject.w = GraphQLMusicType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "music_type", graphQLOpenGraphObject.B_(), 20, false);
            return true;
        } else if ("musicians".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLOpenGraphObject a8 = m9409a(FieldAccessQueryTracker.a(jsonParser, "musicians"));
                    if (a8 != null) {
                        arrayList.add(a8);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                list = ImmutableList.copyOf(arrayList);
            }
            graphQLOpenGraphObject.x = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "musicians", graphQLOpenGraphObject.B_(), 21, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLOpenGraphObject.y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "name", graphQLOpenGraphObject.B_(), 22, false);
            return true;
        } else if ("open_graph_composer_preview".equals(str)) {
            GraphQLStoryAttachment a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "open_graph_composer_preview"));
            }
            graphQLOpenGraphObject.z = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "open_graph_composer_preview", graphQLOpenGraphObject.B_(), 23, true);
            return true;
        } else if ("open_graph_metadata".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLOpenGraphMetadata__JsonHelper.m9402a(FieldAccessQueryTracker.a(jsonParser, "open_graph_metadata"));
            }
            graphQLOpenGraphObject.A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "open_graph_metadata", graphQLOpenGraphObject.B_(), 24, true);
            return true;
        } else if ("placeProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "placeProfilePicture"));
            }
            graphQLOpenGraphObject.B = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "placeProfilePicture", graphQLOpenGraphObject.B_(), 25, true);
            return true;
        } else if ("place_topic_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLOpenGraphObject.C = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "place_topic_id", graphQLOpenGraphObject.B_(), 26, false);
            return true;
        } else if ("place_type".equals(str)) {
            graphQLOpenGraphObject.D = GraphQLPlaceType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "place_type", graphQLOpenGraphObject.B_(), 27, false);
            return true;
        } else if ("preview_urls".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLAudio a10 = GraphQLAudio__JsonHelper.m6627a(FieldAccessQueryTracker.a(jsonParser, "preview_urls"));
                    if (a10 != null) {
                        arrayList.add(a10);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                list = ImmutableList.copyOf(arrayList);
            }
            graphQLOpenGraphObject.E = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "preview_urls", graphQLOpenGraphObject.B_(), 28, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLOpenGraphObject.F = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "profileImageLarge", graphQLOpenGraphObject.B_(), 29, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLOpenGraphObject.G = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "profileImageSmall", graphQLOpenGraphObject.B_(), 30, true);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
            }
            graphQLOpenGraphObject.H = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "profilePicture50", graphQLOpenGraphObject.B_(), 31, true);
            return true;
        } else if ("profilePictureHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
            }
            graphQLOpenGraphObject.I = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "profilePictureHighRes", graphQLOpenGraphObject.B_(), 32, true);
            return true;
        } else if ("profilePictureLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
            }
            graphQLOpenGraphObject.J = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "profilePictureLarge", graphQLOpenGraphObject.B_(), 33, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
            }
            graphQLOpenGraphObject.K = a11;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "profile_photo", graphQLOpenGraphObject.B_(), 34, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLOpenGraphObject.L = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "profile_picture", graphQLOpenGraphObject.B_(), 35, true);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLOpenGraphObject.M = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "profile_picture_is_silhouette", graphQLOpenGraphObject.B_(), 36, false);
            return true;
        } else if ("saved_collection".equals(str)) {
            GraphQLTimelineAppCollection a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "saved_collection"));
            }
            graphQLOpenGraphObject.N = a12;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "saved_collection", graphQLOpenGraphObject.B_(), 37, true);
            return true;
        } else if ("streaming_profile_picture".equals(str)) {
            GraphQLStreamingImage a13;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a13 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
            }
            graphQLOpenGraphObject.O = a13;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "streaming_profile_picture", graphQLOpenGraphObject.B_(), 38, true);
            return true;
        } else if ("taggable_object_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
            }
            graphQLOpenGraphObject.P = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "taggable_object_profile_picture", graphQLOpenGraphObject.B_(), 39, true);
            return true;
        } else if ("thirdPartyOwner".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLOpenGraphMetadata__JsonHelper.m9402a(FieldAccessQueryTracker.a(jsonParser, "thirdPartyOwner"));
            }
            graphQLOpenGraphObject.Q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "thirdPartyOwner", graphQLOpenGraphObject.B_(), 40, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLOpenGraphObject.R = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "url", graphQLOpenGraphObject.B_(), 41, false);
            return true;
        } else if ("viewer_saved_state".equals(str)) {
            graphQLOpenGraphObject.S = GraphQLSavedState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "viewer_saved_state", graphQLOpenGraphObject.B_(), 42, false);
            return true;
        } else if ("viewer_timeline_collections_containing".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "viewer_timeline_collections_containing"));
                    if (r2 != null) {
                        arrayList.add(r2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                list = ImmutableList.copyOf(arrayList);
            }
            graphQLOpenGraphObject.T = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "viewer_timeline_collections_containing", graphQLOpenGraphObject.B_(), 43, true);
            return true;
        } else if (!"viewer_timeline_collections_supported".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "viewer_timeline_collections_supported"));
                    if (r2 != null) {
                        arrayList.add(r2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                list = ImmutableList.copyOf(arrayList);
            }
            graphQLOpenGraphObject.U = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphObject, "viewer_timeline_collections_supported", graphQLOpenGraphObject.B_(), 44, true);
            return true;
        }
    }

    public static void m9410a(JsonGenerator jsonGenerator, GraphQLOpenGraphObject graphQLOpenGraphObject, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("android_urls");
        if (graphQLOpenGraphObject.j() != null) {
            jsonGenerator.d();
            for (String str : graphQLOpenGraphObject.j()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLOpenGraphObject.k() != null) {
            jsonGenerator.a("application");
            GraphQLApplication__JsonHelper.m6588a(jsonGenerator, graphQLOpenGraphObject.k(), true);
        }
        jsonGenerator.a("can_viewer_share", graphQLOpenGraphObject.l());
        if (graphQLOpenGraphObject.m() != null) {
            jsonGenerator.a("category_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLOpenGraphObject.m(), true);
        }
        if (graphQLOpenGraphObject.n() != null) {
            jsonGenerator.a("concise_description", graphQLOpenGraphObject.n());
        }
        if (graphQLOpenGraphObject.o() != null) {
            jsonGenerator.a("contextual_name", graphQLOpenGraphObject.o());
        }
        jsonGenerator.a("creation_time", graphQLOpenGraphObject.p());
        if (graphQLOpenGraphObject.q() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLOpenGraphObject.q(), true);
        }
        if (graphQLOpenGraphObject.r() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLOpenGraphObject.r(), true);
        }
        if (graphQLOpenGraphObject.s() != null) {
            jsonGenerator.a("global_share");
            GraphQLExternalUrl__JsonHelper.m7430a(jsonGenerator, graphQLOpenGraphObject.s(), true);
        }
        jsonGenerator.a("has_viewer_saved", graphQLOpenGraphObject.t());
        if (graphQLOpenGraphObject.u() != null) {
            jsonGenerator.a("id", graphQLOpenGraphObject.u());
        }
        if (graphQLOpenGraphObject.v() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLOpenGraphObject.v(), true);
        }
        if (graphQLOpenGraphObject.w() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLOpenGraphObject.w(), true);
        }
        jsonGenerator.a("is_music_item", graphQLOpenGraphObject.x());
        if (graphQLOpenGraphObject.y() != null) {
            jsonGenerator.a("location");
            GraphQLLocation__JsonHelper.m8966a(jsonGenerator, graphQLOpenGraphObject.y(), true);
        }
        if (graphQLOpenGraphObject.z() != null) {
            jsonGenerator.a("map_bounding_box");
            GraphQLGeoRectangle__JsonHelper.m7767a(jsonGenerator, graphQLOpenGraphObject.z(), true);
        }
        jsonGenerator.a("map_points");
        if (graphQLOpenGraphObject.A() != null) {
            jsonGenerator.d();
            for (GraphQLLocation graphQLLocation : graphQLOpenGraphObject.A()) {
                if (graphQLLocation != null) {
                    GraphQLLocation__JsonHelper.m8966a(jsonGenerator, graphQLLocation, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("map_zoom_level", graphQLOpenGraphObject.B());
        if (graphQLOpenGraphObject.C() != null) {
            jsonGenerator.a("music_type", graphQLOpenGraphObject.C().toString());
        }
        jsonGenerator.a("musicians");
        if (graphQLOpenGraphObject.D() != null) {
            jsonGenerator.d();
            for (GraphQLOpenGraphObject graphQLOpenGraphObject2 : graphQLOpenGraphObject.D()) {
                if (graphQLOpenGraphObject2 != null) {
                    m9410a(jsonGenerator, graphQLOpenGraphObject2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLOpenGraphObject.E() != null) {
            jsonGenerator.a("name", graphQLOpenGraphObject.E());
        }
        if (graphQLOpenGraphObject.F() != null) {
            jsonGenerator.a("open_graph_composer_preview");
            GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLOpenGraphObject.F(), true);
        }
        if (graphQLOpenGraphObject.G() != null) {
            jsonGenerator.a("open_graph_metadata");
            GraphQLOpenGraphMetadata__JsonHelper.m9403a(jsonGenerator, graphQLOpenGraphObject.G(), true);
        }
        if (graphQLOpenGraphObject.H() != null) {
            jsonGenerator.a("placeProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLOpenGraphObject.H(), true);
        }
        if (graphQLOpenGraphObject.I() != null) {
            jsonGenerator.a("place_topic_id", graphQLOpenGraphObject.I());
        }
        if (graphQLOpenGraphObject.J() != null) {
            jsonGenerator.a("place_type", graphQLOpenGraphObject.J().toString());
        }
        jsonGenerator.a("preview_urls");
        if (graphQLOpenGraphObject.K() != null) {
            jsonGenerator.d();
            for (GraphQLAudio graphQLAudio : graphQLOpenGraphObject.K()) {
                if (graphQLAudio != null) {
                    GraphQLAudio__JsonHelper.m6628a(jsonGenerator, graphQLAudio, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLOpenGraphObject.L() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLOpenGraphObject.L(), true);
        }
        if (graphQLOpenGraphObject.M() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLOpenGraphObject.M(), true);
        }
        if (graphQLOpenGraphObject.N() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLOpenGraphObject.N(), true);
        }
        if (graphQLOpenGraphObject.O() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLOpenGraphObject.O(), true);
        }
        if (graphQLOpenGraphObject.P() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLOpenGraphObject.P(), true);
        }
        if (graphQLOpenGraphObject.Q() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLOpenGraphObject.Q(), true);
        }
        if (graphQLOpenGraphObject.R() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLOpenGraphObject.R(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLOpenGraphObject.S());
        if (graphQLOpenGraphObject.T() != null) {
            jsonGenerator.a("saved_collection");
            GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLOpenGraphObject.T(), true);
        }
        if (graphQLOpenGraphObject.U() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLOpenGraphObject.U(), true);
        }
        if (graphQLOpenGraphObject.V() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLOpenGraphObject.V(), true);
        }
        if (graphQLOpenGraphObject.W() != null) {
            jsonGenerator.a("thirdPartyOwner");
            GraphQLOpenGraphMetadata__JsonHelper.m9403a(jsonGenerator, graphQLOpenGraphObject.W(), true);
        }
        if (graphQLOpenGraphObject.X() != null) {
            jsonGenerator.a("url", graphQLOpenGraphObject.X());
        }
        if (graphQLOpenGraphObject.Y() != null) {
            jsonGenerator.a("viewer_saved_state", graphQLOpenGraphObject.Y().toString());
        }
        jsonGenerator.a("viewer_timeline_collections_containing");
        if (graphQLOpenGraphObject.Z() != null) {
            jsonGenerator.d();
            for (GraphQLTimelineAppCollection graphQLTimelineAppCollection : graphQLOpenGraphObject.Z()) {
                if (graphQLTimelineAppCollection != null) {
                    GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLTimelineAppCollection, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("viewer_timeline_collections_supported");
        if (graphQLOpenGraphObject.aa() != null) {
            jsonGenerator.d();
            for (GraphQLTimelineAppCollection graphQLTimelineAppCollection2 : graphQLOpenGraphObject.aa()) {
                if (graphQLTimelineAppCollection2 != null) {
                    GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLTimelineAppCollection2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
