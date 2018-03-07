package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Unable to upload bug report. */
public final class GraphQLSticker__JsonHelper {
    public static GraphQLSticker m21836a(JsonParser jsonParser) {
        GraphQLSticker graphQLSticker = new GraphQLSticker();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21838a(graphQLSticker, i, jsonParser);
            jsonParser.f();
        }
        return graphQLSticker;
    }

    private static boolean m21838a(GraphQLSticker graphQLSticker, String str, JsonParser jsonParser) {
        GraphQLImage graphQLImage = null;
        if ("animated_gif".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "animated_gif"));
            }
            graphQLSticker.d = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "animated_gif", graphQLSticker.a_, 0, true);
            return true;
        } else if ("animated_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "animated_image"));
            }
            graphQLSticker.e = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "animated_image", graphQLSticker.B_(), 1, true);
            return true;
        } else if ("associated_pages".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLProfile a = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "associated_pages"));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLSticker.f = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "associated_pages", graphQLSticker.B_(), 2, true);
            return true;
        } else if ("atom_size".equals(str)) {
            graphQLSticker.g = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "atom_size", graphQLSticker.B_(), 3, false);
            return true;
        } else if ("bitrate".equals(str)) {
            graphQLSticker.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "bitrate", graphQLSticker.B_(), 5, false);
            return true;
        } else if ("hdAtomSize".equals(str)) {
            graphQLSticker.i = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "hdAtomSize", graphQLSticker.B_(), 6, false);
            return true;
        } else if ("hdBitrate".equals(str)) {
            graphQLSticker.j = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "hdBitrate", graphQLSticker.B_(), 7, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSticker.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "id", graphQLSticker.B_(), 8, false);
            return true;
        } else if ("image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
            }
            graphQLSticker.l = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "image", graphQLSticker.B_(), 9, true);
            return true;
        } else if ("imageHigh".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHigh"));
            }
            graphQLSticker.m = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imageHigh", graphQLSticker.B_(), 10, true);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLSticker.n = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imageHighOrig", graphQLSticker.B_(), 11, true);
            return true;
        } else if ("imageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLarge"));
            }
            graphQLSticker.o = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imageLarge", graphQLSticker.B_(), 12, true);
            return true;
        } else if ("imageLargeAspect".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLargeAspect"));
            }
            graphQLSticker.p = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imageLargeAspect", graphQLSticker.B_(), 13, true);
            return true;
        } else if ("imageLargeSquare".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLargeSquare"));
            }
            graphQLSticker.q = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imageLargeSquare", graphQLSticker.B_(), 14, true);
            return true;
        } else if ("imageLow".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLow"));
            }
            graphQLSticker.r = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imageLow", graphQLSticker.B_(), 15, true);
            return true;
        } else if ("imageMedium".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageMedium"));
            }
            graphQLSticker.s = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imageMedium", graphQLSticker.B_(), 16, true);
            return true;
        } else if ("imagePreview".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imagePreview"));
            }
            graphQLSticker.t = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imagePreview", graphQLSticker.B_(), 17, true);
            return true;
        } else if ("imageSmallCover".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageSmallCover"));
            }
            graphQLSticker.u = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imageSmallCover", graphQLSticker.B_(), 18, true);
            return true;
        } else if ("imageSmallSquare".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageSmallSquare"));
            }
            graphQLSticker.v = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imageSmallSquare", graphQLSticker.B_(), 19, true);
            return true;
        } else if ("imageTallCover".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageTallCover"));
            }
            graphQLSticker.w = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imageTallCover", graphQLSticker.B_(), 20, true);
            return true;
        } else if ("imageThumbnail".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageThumbnail"));
            }
            graphQLSticker.x = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imageThumbnail", graphQLSticker.B_(), 21, true);
            return true;
        } else if ("is_age_restricted".equals(str)) {
            graphQLSticker.y = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "is_age_restricted", graphQLSticker.B_(), 22, false);
            return true;
        } else if ("is_playable".equals(str)) {
            graphQLSticker.z = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "is_playable", graphQLSticker.B_(), 23, false);
            return true;
        } else if ("landscape".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "landscape"));
            }
            graphQLSticker.A = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "landscape", graphQLSticker.B_(), 24, true);
            return true;
        } else if ("largePortraitImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "largePortraitImage"));
            }
            graphQLSticker.B = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "largePortraitImage", graphQLSticker.B_(), 25, true);
            return true;
        } else if ("largeThumbnail".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "largeThumbnail"));
            }
            graphQLSticker.C = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "largeThumbnail", graphQLSticker.B_(), 26, true);
            return true;
        } else if ("lowres".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "lowres"));
            }
            graphQLSticker.D = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "lowres", graphQLSticker.B_(), 27, true);
            return true;
        } else if ("multiShareHDVideoUrl".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSticker.E = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "multiShareHDVideoUrl", graphQLSticker.B_(), 28, false);
            return true;
        } else if ("multiShareItemSquareImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "multiShareItemSquareImage"));
            }
            graphQLSticker.F = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "multiShareItemSquareImage", graphQLSticker.B_(), 29, true);
            return true;
        } else if ("multiShareVideoUrl".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSticker.G = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "multiShareVideoUrl", graphQLSticker.B_(), 30, false);
            return true;
        } else if ("narrowLandscapeImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "narrowLandscapeImage"));
            }
            graphQLSticker.H = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "narrowLandscapeImage", graphQLSticker.B_(), 31, true);
            return true;
        } else if ("narrowPortraitImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "narrowPortraitImage"));
            }
            graphQLSticker.I = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "narrowPortraitImage", graphQLSticker.B_(), 32, true);
            return true;
        } else if ("playableUrlHdString".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSticker.J = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "playableUrlHdString", graphQLSticker.B_(), 33, false);
            return true;
        } else if ("playableUrlRtmpString".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSticker.K = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "playableUrlRtmpString", graphQLSticker.B_(), 34, false);
            return true;
        } else if ("playable_duration".equals(str)) {
            graphQLSticker.L = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "playable_duration", graphQLSticker.B_(), 35, false);
            return true;
        } else if ("playable_duration_in_ms".equals(str)) {
            graphQLSticker.M = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "playable_duration_in_ms", graphQLSticker.B_(), 36, false);
            return true;
        } else if ("playable_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSticker.N = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "playable_url", graphQLSticker.B_(), 37, false);
            return true;
        } else if ("portrait".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "portrait"));
            }
            graphQLSticker.O = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "portrait", graphQLSticker.B_(), 38, true);
            return true;
        } else if ("preferredPlayableUrlString".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSticker.P = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "preferredPlayableUrlString", graphQLSticker.B_(), 39, false);
            return true;
        } else if ("preview_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "preview_image"));
            }
            graphQLSticker.Q = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "preview_image", graphQLSticker.B_(), 40, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLSticker.R = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "profileImageLarge", graphQLSticker.B_(), 41, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLSticker.S = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "profileImageSmall", graphQLSticker.B_(), 42, true);
            return true;
        } else if ("pulseCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "pulseCoverPhoto"));
            }
            graphQLSticker.T = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "pulseCoverPhoto", graphQLSticker.B_(), 43, true);
            return true;
        } else if ("squareLargeImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "squareLargeImage"));
            }
            graphQLSticker.U = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "squareLargeImage", graphQLSticker.B_(), 44, true);
            return true;
        } else if ("sticker_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "sticker_image"));
            }
            graphQLSticker.V = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "sticker_image", graphQLSticker.B_(), 45, true);
            return true;
        } else if ("thread_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "thread_image"));
            }
            graphQLSticker.W = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "thread_image", graphQLSticker.B_(), 46, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSticker.X = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "url", graphQLSticker.B_(), 47, false);
            return true;
        } else if ("imageNatural".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageNatural"));
            }
            graphQLSticker.Y = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "imageNatural", graphQLSticker.B_(), 48, true);
            return true;
        } else if ("image_blurred".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image_blurred"));
            }
            graphQLSticker.Z = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "image_blurred", graphQLSticker.B_(), 49, true);
            return true;
        } else if (!"video_full_size".equals(str)) {
            return false;
        } else {
            graphQLSticker.aa = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSticker, "video_full_size", graphQLSticker.B_(), 53, false);
            return true;
        }
    }

    public static void m21837a(JsonGenerator jsonGenerator, GraphQLSticker graphQLSticker, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSticker.j() != null) {
            jsonGenerator.a("animated_gif");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.j(), true);
        }
        if (graphQLSticker.k() != null) {
            jsonGenerator.a("animated_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.k(), true);
        }
        jsonGenerator.a("associated_pages");
        if (graphQLSticker.l() != null) {
            jsonGenerator.d();
            for (GraphQLProfile graphQLProfile : graphQLSticker.l()) {
                if (graphQLProfile != null) {
                    GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLProfile, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("atom_size", graphQLSticker.m());
        jsonGenerator.a("bitrate", graphQLSticker.n());
        jsonGenerator.a("hdAtomSize", graphQLSticker.o());
        jsonGenerator.a("hdBitrate", graphQLSticker.p());
        if (graphQLSticker.q() != null) {
            jsonGenerator.a("id", graphQLSticker.q());
        }
        if (graphQLSticker.r() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.r(), true);
        }
        if (graphQLSticker.s() != null) {
            jsonGenerator.a("imageHigh");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.s(), true);
        }
        if (graphQLSticker.t() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.t(), true);
        }
        if (graphQLSticker.u() != null) {
            jsonGenerator.a("imageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.u(), true);
        }
        if (graphQLSticker.v() != null) {
            jsonGenerator.a("imageLargeAspect");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.v(), true);
        }
        if (graphQLSticker.w() != null) {
            jsonGenerator.a("imageLargeSquare");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.w(), true);
        }
        if (graphQLSticker.x() != null) {
            jsonGenerator.a("imageLow");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.x(), true);
        }
        if (graphQLSticker.y() != null) {
            jsonGenerator.a("imageMedium");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.y(), true);
        }
        if (graphQLSticker.z() != null) {
            jsonGenerator.a("imagePreview");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.z(), true);
        }
        if (graphQLSticker.A() != null) {
            jsonGenerator.a("imageSmallCover");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.A(), true);
        }
        if (graphQLSticker.B() != null) {
            jsonGenerator.a("imageSmallSquare");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.B(), true);
        }
        if (graphQLSticker.C() != null) {
            jsonGenerator.a("imageTallCover");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.C(), true);
        }
        if (graphQLSticker.D() != null) {
            jsonGenerator.a("imageThumbnail");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.D(), true);
        }
        jsonGenerator.a("is_age_restricted", graphQLSticker.E());
        jsonGenerator.a("is_playable", graphQLSticker.F());
        if (graphQLSticker.G() != null) {
            jsonGenerator.a("landscape");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.G(), true);
        }
        if (graphQLSticker.H() != null) {
            jsonGenerator.a("largePortraitImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.H(), true);
        }
        if (graphQLSticker.I() != null) {
            jsonGenerator.a("largeThumbnail");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.I(), true);
        }
        if (graphQLSticker.J() != null) {
            jsonGenerator.a("lowres");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.J(), true);
        }
        if (graphQLSticker.K() != null) {
            jsonGenerator.a("multiShareHDVideoUrl", graphQLSticker.K());
        }
        if (graphQLSticker.L() != null) {
            jsonGenerator.a("multiShareItemSquareImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.L(), true);
        }
        if (graphQLSticker.M() != null) {
            jsonGenerator.a("multiShareVideoUrl", graphQLSticker.M());
        }
        if (graphQLSticker.N() != null) {
            jsonGenerator.a("narrowLandscapeImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.N(), true);
        }
        if (graphQLSticker.O() != null) {
            jsonGenerator.a("narrowPortraitImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.O(), true);
        }
        if (graphQLSticker.P() != null) {
            jsonGenerator.a("playableUrlHdString", graphQLSticker.P());
        }
        if (graphQLSticker.Q() != null) {
            jsonGenerator.a("playableUrlRtmpString", graphQLSticker.Q());
        }
        jsonGenerator.a("playable_duration", graphQLSticker.R());
        jsonGenerator.a("playable_duration_in_ms", graphQLSticker.S());
        if (graphQLSticker.T() != null) {
            jsonGenerator.a("playable_url", graphQLSticker.T());
        }
        if (graphQLSticker.U() != null) {
            jsonGenerator.a("portrait");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.U(), true);
        }
        if (graphQLSticker.V() != null) {
            jsonGenerator.a("preferredPlayableUrlString", graphQLSticker.V());
        }
        if (graphQLSticker.W() != null) {
            jsonGenerator.a("preview_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.W(), true);
        }
        if (graphQLSticker.X() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.X(), true);
        }
        if (graphQLSticker.Y() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.Y(), true);
        }
        if (graphQLSticker.Z() != null) {
            jsonGenerator.a("pulseCoverPhoto");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.Z(), true);
        }
        if (graphQLSticker.aa() != null) {
            jsonGenerator.a("squareLargeImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.aa(), true);
        }
        if (graphQLSticker.ab() != null) {
            jsonGenerator.a("sticker_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.ab(), true);
        }
        if (graphQLSticker.ac() != null) {
            jsonGenerator.a("thread_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.ac(), true);
        }
        if (graphQLSticker.ad() != null) {
            jsonGenerator.a("url", graphQLSticker.ad());
        }
        if (graphQLSticker.ae() != null) {
            jsonGenerator.a("imageNatural");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.ae(), true);
        }
        if (graphQLSticker.af() != null) {
            jsonGenerator.a("image_blurred");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSticker.af(), true);
        }
        jsonGenerator.a("video_full_size", graphQLSticker.ag());
        if (z) {
            jsonGenerator.g();
        }
    }
}
