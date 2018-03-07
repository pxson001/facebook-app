package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: Unable to retrieve Wifi power stats */
public final class GraphQLStoryAttachmentStyleInfo__JsonHelper {
    public static GraphQLStoryAttachmentStyleInfo m21859a(JsonParser jsonParser) {
        GraphQLStoryAttachmentStyleInfo graphQLStoryAttachmentStyleInfo = new GraphQLStoryAttachmentStyleInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21861a(graphQLStoryAttachmentStyleInfo, i, jsonParser);
            jsonParser.f();
        }
        return graphQLStoryAttachmentStyleInfo;
    }

    private static boolean m21861a(GraphQLStoryAttachmentStyleInfo graphQLStoryAttachmentStyleInfo, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            GraphQLObjectType a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLObjectType.a(jsonParser);
            }
            graphQLStoryAttachmentStyleInfo.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "__type__", graphQLStoryAttachmentStyleInfo.a_, 0, false);
            return true;
        } else if ("bounding_box".equals(str)) {
            GraphQLGeoRectangle a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGeoRectangle__JsonHelper.m7766a(FieldAccessQueryTracker.a(jsonParser, "bounding_box"));
            }
            graphQLStoryAttachmentStyleInfo.e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "bounding_box", graphQLStoryAttachmentStyleInfo.B_(), 1, true);
            return true;
        } else if ("category_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachmentStyleInfo.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "category_name", graphQLStoryAttachmentStyleInfo.B_(), 2, false);
            return true;
        } else if ("label".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachmentStyleInfo.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "label", graphQLStoryAttachmentStyleInfo.B_(), 3, false);
            return true;
        } else if ("lat_long_list".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLLocation__JsonHelper.m8965a(FieldAccessQueryTracker.a(jsonParser, "lat_long_list"));
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
            graphQLStoryAttachmentStyleInfo.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "lat_long_list", graphQLStoryAttachmentStyleInfo.B_(), 4, true);
            return true;
        } else if ("layout_height".equals(str)) {
            graphQLStoryAttachmentStyleInfo.i = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "layout_height", graphQLStoryAttachmentStyleInfo.B_(), 5, false);
            return true;
        } else if ("layout_width".equals(str)) {
            graphQLStoryAttachmentStyleInfo.j = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "layout_width", graphQLStoryAttachmentStyleInfo.B_(), 6, false);
            return true;
        } else if ("layout_x".equals(str)) {
            graphQLStoryAttachmentStyleInfo.k = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "layout_x", graphQLStoryAttachmentStyleInfo.B_(), 7, false);
            return true;
        } else if ("layout_y".equals(str)) {
            graphQLStoryAttachmentStyleInfo.l = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "layout_y", graphQLStoryAttachmentStyleInfo.B_(), 8, false);
            return true;
        } else if ("location".equals(str)) {
            GraphQLLocation a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLLocation__JsonHelper.m8965a(FieldAccessQueryTracker.a(jsonParser, "location"));
            }
            graphQLStoryAttachmentStyleInfo.m = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "location", graphQLStoryAttachmentStyleInfo.B_(), 9, true);
            return true;
        } else if ("place_open_status_formats".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLPlaceOpenStatusFormat a4 = GraphQLPlaceOpenStatusFormat__JsonHelper.m20886a(FieldAccessQueryTracker.a(jsonParser, "place_open_status_formats"));
                    if (a4 != null) {
                        r1.add(a4);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLStoryAttachmentStyleInfo.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "place_open_status_formats", graphQLStoryAttachmentStyleInfo.B_(), 10, true);
            return true;
        } else if ("time_zone".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachmentStyleInfo.o = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "time_zone", graphQLStoryAttachmentStyleInfo.B_(), 11, false);
            return true;
        } else if ("logo".equals(str)) {
            GraphQLImage a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "logo"));
            }
            graphQLStoryAttachmentStyleInfo.p = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "logo", graphQLStoryAttachmentStyleInfo.B_(), 12, true);
            return true;
        } else if ("nearby_locations".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLLocation__JsonHelper.m8965a(FieldAccessQueryTracker.a(jsonParser, "nearby_locations"));
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
            graphQLStoryAttachmentStyleInfo.q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "nearby_locations", graphQLStoryAttachmentStyleInfo.B_(), 13, true);
            return true;
        } else if ("autoplay_on_cell".equals(str)) {
            graphQLStoryAttachmentStyleInfo.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "autoplay_on_cell", graphQLStoryAttachmentStyleInfo.B_(), 14, false);
            return true;
        } else if ("autoplay_on_wifi".equals(str)) {
            graphQLStoryAttachmentStyleInfo.s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "autoplay_on_wifi", graphQLStoryAttachmentStyleInfo.B_(), 15, false);
            return true;
        } else if ("game_uri".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachmentStyleInfo.t = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "game_uri", graphQLStoryAttachmentStyleInfo.B_(), 16, false);
            return true;
        } else if ("instant_game_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachmentStyleInfo.u = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "instant_game_id", graphQLStoryAttachmentStyleInfo.B_(), 17, false);
            return true;
        } else if ("mobile_game_uri".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachmentStyleInfo.v = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "mobile_game_uri", graphQLStoryAttachmentStyleInfo.B_(), 18, false);
            return true;
        } else if ("show_objectionable_warning".equals(str)) {
            graphQLStoryAttachmentStyleInfo.w = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "show_objectionable_warning", graphQLStoryAttachmentStyleInfo.B_(), 19, false);
            return true;
        } else if ("splash_uri".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachmentStyleInfo.x = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "splash_uri", graphQLStoryAttachmentStyleInfo.B_(), 20, false);
            return true;
        } else if (!"video_uri".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryAttachmentStyleInfo.y = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryAttachmentStyleInfo, "video_uri", graphQLStoryAttachmentStyleInfo.B_(), 21, false);
            return true;
        }
    }

    public static void m21860a(JsonGenerator jsonGenerator, GraphQLStoryAttachmentStyleInfo graphQLStoryAttachmentStyleInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLStoryAttachmentStyleInfo.a() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLStoryAttachmentStyleInfo.a().e());
            jsonGenerator.g();
        }
        if (graphQLStoryAttachmentStyleInfo.j() != null) {
            jsonGenerator.a("bounding_box");
            GraphQLGeoRectangle__JsonHelper.m7767a(jsonGenerator, graphQLStoryAttachmentStyleInfo.j(), true);
        }
        if (graphQLStoryAttachmentStyleInfo.k() != null) {
            jsonGenerator.a("category_name", graphQLStoryAttachmentStyleInfo.k());
        }
        if (graphQLStoryAttachmentStyleInfo.l() != null) {
            jsonGenerator.a("label", graphQLStoryAttachmentStyleInfo.l());
        }
        jsonGenerator.a("lat_long_list");
        if (graphQLStoryAttachmentStyleInfo.m() != null) {
            jsonGenerator.d();
            for (GraphQLLocation graphQLLocation : graphQLStoryAttachmentStyleInfo.m()) {
                if (graphQLLocation != null) {
                    GraphQLLocation__JsonHelper.m8966a(jsonGenerator, graphQLLocation, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("layout_height", graphQLStoryAttachmentStyleInfo.n());
        jsonGenerator.a("layout_width", graphQLStoryAttachmentStyleInfo.o());
        jsonGenerator.a("layout_x", graphQLStoryAttachmentStyleInfo.p());
        jsonGenerator.a("layout_y", graphQLStoryAttachmentStyleInfo.q());
        if (graphQLStoryAttachmentStyleInfo.r() != null) {
            jsonGenerator.a("location");
            GraphQLLocation__JsonHelper.m8966a(jsonGenerator, graphQLStoryAttachmentStyleInfo.r(), true);
        }
        jsonGenerator.a("place_open_status_formats");
        if (graphQLStoryAttachmentStyleInfo.s() != null) {
            jsonGenerator.d();
            for (GraphQLPlaceOpenStatusFormat graphQLPlaceOpenStatusFormat : graphQLStoryAttachmentStyleInfo.s()) {
                if (graphQLPlaceOpenStatusFormat != null) {
                    GraphQLPlaceOpenStatusFormat__JsonHelper.m20887a(jsonGenerator, graphQLPlaceOpenStatusFormat, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStoryAttachmentStyleInfo.t() != null) {
            jsonGenerator.a("time_zone", graphQLStoryAttachmentStyleInfo.t());
        }
        if (graphQLStoryAttachmentStyleInfo.u() != null) {
            jsonGenerator.a("logo");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLStoryAttachmentStyleInfo.u(), true);
        }
        jsonGenerator.a("nearby_locations");
        if (graphQLStoryAttachmentStyleInfo.v() != null) {
            jsonGenerator.d();
            for (GraphQLLocation graphQLLocation2 : graphQLStoryAttachmentStyleInfo.v()) {
                if (graphQLLocation2 != null) {
                    GraphQLLocation__JsonHelper.m8966a(jsonGenerator, graphQLLocation2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("autoplay_on_cell", graphQLStoryAttachmentStyleInfo.w());
        jsonGenerator.a("autoplay_on_wifi", graphQLStoryAttachmentStyleInfo.x());
        if (graphQLStoryAttachmentStyleInfo.y() != null) {
            jsonGenerator.a("game_uri", graphQLStoryAttachmentStyleInfo.y());
        }
        if (graphQLStoryAttachmentStyleInfo.z() != null) {
            jsonGenerator.a("instant_game_id", graphQLStoryAttachmentStyleInfo.z());
        }
        if (graphQLStoryAttachmentStyleInfo.A() != null) {
            jsonGenerator.a("mobile_game_uri", graphQLStoryAttachmentStyleInfo.A());
        }
        jsonGenerator.a("show_objectionable_warning", graphQLStoryAttachmentStyleInfo.B());
        if (graphQLStoryAttachmentStyleInfo.C() != null) {
            jsonGenerator.a("splash_uri", graphQLStoryAttachmentStyleInfo.C());
        }
        if (graphQLStoryAttachmentStyleInfo.D() != null) {
            jsonGenerator.a("video_uri", graphQLStoryAttachmentStyleInfo.D());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
