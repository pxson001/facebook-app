package com.facebook.search.results.protocol;

import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.SphericalMetadataParser.GuidedTourParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryDeserializer;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser.RangesParser;
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryParsers.SearchResultsSeeMoreQueryParser;
import com.facebook.search.results.protocol.common.SearchResultsDecorationParsers.SearchResultsDecorationParser;
import com.facebook.search.results.protocol.entity.SearchResultsEventParsers.SearchResultsEventParser.EventPlaceParser;
import com.facebook.search.results.protocol.entity.SearchResultsGroupParsers.SearchResultsGroupParser.GroupMembersParser;
import com.facebook.search.results.protocol.entity.SearchResultsGroupParsers.SearchResultsGroupParser.SocialContextParser;
import com.facebook.search.results.protocol.entity.SearchResultsGroupParsers.SearchResultsGroupParser.VisibilitySentenceParser;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageCTAParser;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageParser.CoverPhotoParser;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageParser.PageLikersParser;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceParsers.SearchResultsPlaceParser.AddressParser;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceParsers.SearchResultsPlaceParser.LocationParser;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceParsers.SearchResultsPlaceParser.OverallStarRatingParser;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceParsers.SearchResultsPlaceParser.PlaceOpenStatusParser;
import com.facebook.search.results.protocol.entity.SearchResultsUserParsers.SearchResultsUserParser.BioTextParser;
import com.facebook.search.results.protocol.entity.SearchResultsUserParsers.SearchResultsUserParser.MutualFriendsParser;
import com.facebook.search.results.protocol.pulse.PulseEmotionAnalysisExternalUrlParsers.PulseEmotionAnalysisExternalUrlParser.EmotionalAnalysisParser;
import com.facebook.search.results.protocol.pulse.PulsePhrasesAnalysisExternalUrlParsers.PulsePhrasesAnalysisExternalUrlParser.PhrasesAnalysisParser;
import com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlParsers.PulseQuotesAnalysisExternalUrlParser.QuotesAnalysisParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.InstantArticleParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.LinkMediaParser.PulseCoverPhotoParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.OpenGraphNodeParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.SummaryParser;
import com.facebook.search.results.protocol.video.SearchResultsVideoParsers.SearchResultsVideoParser.OwnerParser;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoParsers.SearchResultsWebVideoParser.AllShareStoriesParser;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoParsers.SearchResultsWebVideoParser.LinkMediaParser;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoParsers.SearchResultsWebVideoParser.VideoShareParser;
import com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleParsers.SearchResultsWikiModulePageParser.BestDescriptionParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: module_results */
public class SearchResultsEdgeParsers {

    /* compiled from: module_results */
    public final class SearchResultsEdgeParser {

        /* compiled from: module_results */
        public final class NodeParser {

            /* compiled from: module_results */
            public final class ModuleResultsParser {

                /* compiled from: module_results */
                public final class EdgesParser {

                    /* compiled from: module_results */
                    public final class EdgesNodeParser {

                        /* compiled from: module_results */
                        public final class AllShareStoriesParser {
                            public static int m9776a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                boolean[] zArr = new boolean[1];
                                int[] iArr = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("count")) {
                                            zArr[0] = true;
                                            iArr[0] = jsonParser.E();
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(1);
                                if (zArr[0]) {
                                    flatBufferBuilder.a(0, iArr[0], 0);
                                }
                                return flatBufferBuilder.d();
                            }

                            public static void m9777a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                jsonGenerator.f();
                                int a = mutableFlatBuffer.a(i, 0, 0);
                                if (a != 0) {
                                    jsonGenerator.a("count");
                                    jsonGenerator.b(a);
                                }
                                jsonGenerator.g();
                            }
                        }

                        /* compiled from: module_results */
                        public final class LinkMediaParser {

                            /* compiled from: module_results */
                            public final class ImageParser {
                                public static int m9778a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                    int[] iArr = new int[3];
                                    boolean[] zArr = new boolean[2];
                                    int[] iArr2 = new int[2];
                                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                                        String i = jsonParser.i();
                                        jsonParser.c();
                                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                            if (i.equals("height")) {
                                                zArr[0] = true;
                                                iArr2[0] = jsonParser.E();
                                            } else if (i.equals("uri")) {
                                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                            } else if (i.equals("width")) {
                                                zArr[1] = true;
                                                iArr2[1] = jsonParser.E();
                                            } else {
                                                jsonParser.f();
                                            }
                                        }
                                    }
                                    flatBufferBuilder.c(3);
                                    if (zArr[0]) {
                                        flatBufferBuilder.a(0, iArr2[0], 0);
                                    }
                                    flatBufferBuilder.b(1, iArr[1]);
                                    if (zArr[1]) {
                                        flatBufferBuilder.a(2, iArr2[1], 0);
                                    }
                                    return flatBufferBuilder.d();
                                }

                                public static void m9779a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                    jsonGenerator.f();
                                    int a = mutableFlatBuffer.a(i, 0, 0);
                                    if (a != 0) {
                                        jsonGenerator.a("height");
                                        jsonGenerator.b(a);
                                    }
                                    if (mutableFlatBuffer.g(i, 1) != 0) {
                                        jsonGenerator.a("uri");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                                    }
                                    a = mutableFlatBuffer.a(i, 2, 0);
                                    if (a != 0) {
                                        jsonGenerator.a("width");
                                        jsonGenerator.b(a);
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            public static int m9780a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[3];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("__type__")) {
                                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                        } else if (i.equals("image")) {
                                            iArr[1] = ImageParser.m9778a(jsonParser, flatBufferBuilder);
                                        } else if (i.equals("pulseCoverPhoto")) {
                                            iArr[2] = PulseCoverPhotoParser.m10517a(jsonParser, flatBufferBuilder);
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(3);
                                flatBufferBuilder.b(0, iArr[0]);
                                flatBufferBuilder.b(1, iArr[1]);
                                flatBufferBuilder.b(2, iArr[2]);
                                return flatBufferBuilder.d();
                            }

                            public static void m9781a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("__type__");
                                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                                }
                                int g = mutableFlatBuffer.g(i, 1);
                                if (g != 0) {
                                    jsonGenerator.a("image");
                                    ImageParser.m9779a(mutableFlatBuffer, g, jsonGenerator);
                                }
                                g = mutableFlatBuffer.g(i, 2);
                                if (g != 0) {
                                    jsonGenerator.a("pulseCoverPhoto");
                                    PulseCoverPhotoParser.m10518a(mutableFlatBuffer, g, jsonGenerator);
                                }
                                jsonGenerator.g();
                            }
                        }

                        /* compiled from: module_results */
                        public final class SourceParser {
                            public static int m9782a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[2];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("ranges")) {
                                            iArr[0] = RangesParser.a(jsonParser, flatBufferBuilder);
                                        } else if (i.equals("text")) {
                                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(2);
                                flatBufferBuilder.b(0, iArr[0]);
                                flatBufferBuilder.b(1, iArr[1]);
                                return flatBufferBuilder.d();
                            }

                            public static void m9783a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                int g = mutableFlatBuffer.g(i, 0);
                                if (g != 0) {
                                    jsonGenerator.a("ranges");
                                    RangesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                }
                                if (mutableFlatBuffer.g(i, 1) != 0) {
                                    jsonGenerator.a("text");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                                }
                                jsonGenerator.g();
                            }
                        }

                        /* compiled from: module_results */
                        public final class TitleParser {
                            public static int m9784a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[2];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("ranges")) {
                                            iArr[0] = RangesParser.a(jsonParser, flatBufferBuilder);
                                        } else if (i.equals("text")) {
                                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(2);
                                flatBufferBuilder.b(0, iArr[0]);
                                flatBufferBuilder.b(1, iArr[1]);
                                return flatBufferBuilder.d();
                            }

                            public static void m9785a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                int g = mutableFlatBuffer.g(i, 0);
                                if (g != 0) {
                                    jsonGenerator.a("ranges");
                                    RangesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                }
                                if (mutableFlatBuffer.g(i, 1) != 0) {
                                    jsonGenerator.a("text");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                                }
                                jsonGenerator.g();
                            }
                        }

                        /* compiled from: module_results */
                        public final class VideoShareParser {
                            public static int m9786a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[2];
                                boolean[] zArr = new boolean[1];
                                int[] iArr2 = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("domain")) {
                                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                        } else if (i.equals("duration")) {
                                            zArr[0] = true;
                                            iArr2[0] = jsonParser.E();
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(2);
                                flatBufferBuilder.b(0, iArr[0]);
                                if (zArr[0]) {
                                    flatBufferBuilder.a(1, iArr2[0], 0);
                                }
                                return flatBufferBuilder.d();
                            }

                            public static void m9787a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("domain");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                }
                                int a = mutableFlatBuffer.a(i, 1, 0);
                                if (a != 0) {
                                    jsonGenerator.a("duration");
                                    jsonGenerator.b(a);
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m9788a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[50];
                            boolean[] zArr = new boolean[21];
                            boolean[] zArr2 = new boolean[7];
                            int[] iArr2 = new int[10];
                            long[] jArr = new long[2];
                            double[] dArr = new double[2];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("__type__")) {
                                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                    } else if (i.equals("all_share_stories")) {
                                        iArr[1] = AllShareStoriesParser.m9776a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("best_description")) {
                                        iArr[2] = BestDescriptionParser.m10636a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("broadcast_status")) {
                                        iArr[3] = flatBufferBuilder.a(GraphQLVideoBroadcastStatus.fromString(jsonParser.o()));
                                    } else if (i.equals("created_time")) {
                                        zArr[0] = true;
                                        jArr[0] = jsonParser.F();
                                    } else if (i.equals("creation_story")) {
                                        iArr[5] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("creation_time")) {
                                        zArr[1] = true;
                                        jArr[1] = jsonParser.F();
                                    } else if (i.equals("emotional_analysis")) {
                                        iArr[7] = EmotionalAnalysisParser.m10285a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("external_url")) {
                                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("guided_tour")) {
                                        iArr[9] = GuidedTourParser.a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("has_viewer_viewed")) {
                                        zArr[2] = true;
                                        zArr2[0] = jsonParser.H();
                                    } else if (i.equals("has_viewer_watched_video")) {
                                        zArr[3] = true;
                                        zArr2[1] = jsonParser.H();
                                    } else if (i.equals("height")) {
                                        zArr[4] = true;
                                        iArr2[0] = jsonParser.E();
                                    } else if (i.equals("id")) {
                                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("image")) {
                                        iArr[14] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("imageHigh")) {
                                        iArr[15] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("imageVideoThumbnail")) {
                                        iArr[16] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("initial_view_heading_degrees")) {
                                        zArr[5] = true;
                                        iArr2[1] = jsonParser.E();
                                    } else if (i.equals("initial_view_pitch_degrees")) {
                                        zArr[6] = true;
                                        iArr2[2] = jsonParser.E();
                                    } else if (i.equals("initial_view_roll_degrees")) {
                                        zArr[7] = true;
                                        iArr2[3] = jsonParser.E();
                                    } else if (i.equals("instant_article")) {
                                        iArr[20] = InstantArticleParser.m10513a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("is_live_streaming")) {
                                        zArr[8] = true;
                                        zArr2[2] = jsonParser.H();
                                    } else if (i.equals("is_looping")) {
                                        zArr[9] = true;
                                        zArr2[3] = jsonParser.H();
                                    } else if (i.equals("is_spherical")) {
                                        zArr[10] = true;
                                        zArr2[4] = jsonParser.H();
                                    } else if (i.equals("is_video_broadcast")) {
                                        zArr[11] = true;
                                        zArr2[5] = jsonParser.H();
                                    } else if (i.equals("link_media")) {
                                        iArr[25] = LinkMediaParser.m9780a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("live_viewer_count_read_only")) {
                                        zArr[12] = true;
                                        iArr2[4] = jsonParser.E();
                                    } else if (i.equals("loop_count")) {
                                        zArr[13] = true;
                                        iArr2[5] = jsonParser.E();
                                    } else if (i.equals("message")) {
                                        iArr[28] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("name")) {
                                        iArr[29] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("open_graph_node")) {
                                        iArr[30] = OpenGraphNodeParser.m10521a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("owner")) {
                                        iArr[31] = OwnerParser.m10568a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("phrases_analysis")) {
                                        iArr[32] = PhrasesAnalysisParser.m10370a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("play_count")) {
                                        zArr[14] = true;
                                        iArr2[6] = jsonParser.E();
                                    } else if (i.equals("playable_duration")) {
                                        zArr[15] = true;
                                        iArr2[7] = jsonParser.E();
                                    } else if (i.equals("playlist")) {
                                        iArr[35] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("projection_type")) {
                                        iArr[36] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("quotes_analysis")) {
                                        iArr[37] = QuotesAnalysisParser.m10414a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("source")) {
                                        iArr[38] = SourceParser.m9782a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("sphericalFullscreenAspectRatio")) {
                                        zArr[16] = true;
                                        dArr[0] = jsonParser.G();
                                    } else if (i.equals("sphericalInlineAspectRatio")) {
                                        zArr[17] = true;
                                        dArr[1] = jsonParser.G();
                                    } else if (i.equals("sphericalPlayableUrlHdString")) {
                                        iArr[41] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("sphericalPlayableUrlSdString")) {
                                        iArr[42] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("sphericalPreferredFov")) {
                                        zArr[18] = true;
                                        iArr2[8] = jsonParser.E();
                                    } else if (i.equals("summary")) {
                                        iArr[44] = SummaryParser.m10525a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("supports_time_slices")) {
                                        zArr[19] = true;
                                        zArr2[6] = jsonParser.H();
                                    } else if (i.equals("title")) {
                                        iArr[46] = TitleParser.m9784a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("url")) {
                                        iArr[47] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("video_share")) {
                                        iArr[48] = VideoShareParser.m9786a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("width")) {
                                        zArr[20] = true;
                                        iArr2[9] = jsonParser.E();
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(50);
                            flatBufferBuilder.b(0, iArr[0]);
                            flatBufferBuilder.b(1, iArr[1]);
                            flatBufferBuilder.b(2, iArr[2]);
                            flatBufferBuilder.b(3, iArr[3]);
                            if (zArr[0]) {
                                flatBufferBuilder.a(4, jArr[0], 0);
                            }
                            flatBufferBuilder.b(5, iArr[5]);
                            if (zArr[1]) {
                                flatBufferBuilder.a(6, jArr[1], 0);
                            }
                            flatBufferBuilder.b(7, iArr[7]);
                            flatBufferBuilder.b(8, iArr[8]);
                            flatBufferBuilder.b(9, iArr[9]);
                            if (zArr[2]) {
                                flatBufferBuilder.a(10, zArr2[0]);
                            }
                            if (zArr[3]) {
                                flatBufferBuilder.a(11, zArr2[1]);
                            }
                            if (zArr[4]) {
                                flatBufferBuilder.a(12, iArr2[0], 0);
                            }
                            flatBufferBuilder.b(13, iArr[13]);
                            flatBufferBuilder.b(14, iArr[14]);
                            flatBufferBuilder.b(15, iArr[15]);
                            flatBufferBuilder.b(16, iArr[16]);
                            if (zArr[5]) {
                                flatBufferBuilder.a(17, iArr2[1], 0);
                            }
                            if (zArr[6]) {
                                flatBufferBuilder.a(18, iArr2[2], 0);
                            }
                            if (zArr[7]) {
                                flatBufferBuilder.a(19, iArr2[3], 0);
                            }
                            flatBufferBuilder.b(20, iArr[20]);
                            if (zArr[8]) {
                                flatBufferBuilder.a(21, zArr2[2]);
                            }
                            if (zArr[9]) {
                                flatBufferBuilder.a(22, zArr2[3]);
                            }
                            if (zArr[10]) {
                                flatBufferBuilder.a(23, zArr2[4]);
                            }
                            if (zArr[11]) {
                                flatBufferBuilder.a(24, zArr2[5]);
                            }
                            flatBufferBuilder.b(25, iArr[25]);
                            if (zArr[12]) {
                                flatBufferBuilder.a(26, iArr2[4], 0);
                            }
                            if (zArr[13]) {
                                flatBufferBuilder.a(27, iArr2[5], 0);
                            }
                            flatBufferBuilder.b(28, iArr[28]);
                            flatBufferBuilder.b(29, iArr[29]);
                            flatBufferBuilder.b(30, iArr[30]);
                            flatBufferBuilder.b(31, iArr[31]);
                            flatBufferBuilder.b(32, iArr[32]);
                            if (zArr[14]) {
                                flatBufferBuilder.a(33, iArr2[6], 0);
                            }
                            if (zArr[15]) {
                                flatBufferBuilder.a(34, iArr2[7], 0);
                            }
                            flatBufferBuilder.b(35, iArr[35]);
                            flatBufferBuilder.b(36, iArr[36]);
                            flatBufferBuilder.b(37, iArr[37]);
                            flatBufferBuilder.b(38, iArr[38]);
                            if (zArr[16]) {
                                flatBufferBuilder.a(39, dArr[0], 0.0d);
                            }
                            if (zArr[17]) {
                                flatBufferBuilder.a(40, dArr[1], 0.0d);
                            }
                            flatBufferBuilder.b(41, iArr[41]);
                            flatBufferBuilder.b(42, iArr[42]);
                            if (zArr[18]) {
                                flatBufferBuilder.a(43, iArr2[8], 0);
                            }
                            flatBufferBuilder.b(44, iArr[44]);
                            if (zArr[19]) {
                                flatBufferBuilder.a(45, zArr2[6]);
                            }
                            flatBufferBuilder.b(46, iArr[46]);
                            flatBufferBuilder.b(47, iArr[47]);
                            flatBufferBuilder.b(48, iArr[48]);
                            if (zArr[20]) {
                                flatBufferBuilder.a(49, iArr2[9], 0);
                            }
                            return flatBufferBuilder.d();
                        }

                        public static void m9789a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            if (mutableFlatBuffer.g(i, 0) != 0) {
                                jsonGenerator.a("__type__");
                                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                            }
                            int g = mutableFlatBuffer.g(i, 1);
                            if (g != 0) {
                                jsonGenerator.a("all_share_stories");
                                AllShareStoriesParser.m9777a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            g = mutableFlatBuffer.g(i, 2);
                            if (g != 0) {
                                jsonGenerator.a("best_description");
                                BestDescriptionParser.m10637a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            if (mutableFlatBuffer.g(i, 3) != 0) {
                                jsonGenerator.a("broadcast_status");
                                jsonGenerator.b(mutableFlatBuffer.b(i, 3));
                            }
                            long a = mutableFlatBuffer.a(i, 4, 0);
                            if (a != 0) {
                                jsonGenerator.a("created_time");
                                jsonGenerator.a(a);
                            }
                            g = mutableFlatBuffer.g(i, 5);
                            if (g != 0) {
                                jsonGenerator.a("creation_story");
                                GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            a = mutableFlatBuffer.a(i, 6, 0);
                            if (a != 0) {
                                jsonGenerator.a("creation_time");
                                jsonGenerator.a(a);
                            }
                            g = mutableFlatBuffer.g(i, 7);
                            if (g != 0) {
                                jsonGenerator.a("emotional_analysis");
                                EmotionalAnalysisParser.m10286a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            if (mutableFlatBuffer.g(i, 8) != 0) {
                                jsonGenerator.a("external_url");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
                            }
                            g = mutableFlatBuffer.g(i, 9);
                            if (g != 0) {
                                jsonGenerator.a("guided_tour");
                                GuidedTourParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            boolean a2 = mutableFlatBuffer.a(i, 10);
                            if (a2) {
                                jsonGenerator.a("has_viewer_viewed");
                                jsonGenerator.a(a2);
                            }
                            a2 = mutableFlatBuffer.a(i, 11);
                            if (a2) {
                                jsonGenerator.a("has_viewer_watched_video");
                                jsonGenerator.a(a2);
                            }
                            g = mutableFlatBuffer.a(i, 12, 0);
                            if (g != 0) {
                                jsonGenerator.a("height");
                                jsonGenerator.b(g);
                            }
                            if (mutableFlatBuffer.g(i, 13) != 0) {
                                jsonGenerator.a("id");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
                            }
                            g = mutableFlatBuffer.g(i, 14);
                            if (g != 0) {
                                jsonGenerator.a("image");
                                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            g = mutableFlatBuffer.g(i, 15);
                            if (g != 0) {
                                jsonGenerator.a("imageHigh");
                                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            g = mutableFlatBuffer.g(i, 16);
                            if (g != 0) {
                                jsonGenerator.a("imageVideoThumbnail");
                                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            g = mutableFlatBuffer.a(i, 17, 0);
                            if (g != 0) {
                                jsonGenerator.a("initial_view_heading_degrees");
                                jsonGenerator.b(g);
                            }
                            g = mutableFlatBuffer.a(i, 18, 0);
                            if (g != 0) {
                                jsonGenerator.a("initial_view_pitch_degrees");
                                jsonGenerator.b(g);
                            }
                            g = mutableFlatBuffer.a(i, 19, 0);
                            if (g != 0) {
                                jsonGenerator.a("initial_view_roll_degrees");
                                jsonGenerator.b(g);
                            }
                            g = mutableFlatBuffer.g(i, 20);
                            if (g != 0) {
                                jsonGenerator.a("instant_article");
                                InstantArticleParser.m10514a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            a2 = mutableFlatBuffer.a(i, 21);
                            if (a2) {
                                jsonGenerator.a("is_live_streaming");
                                jsonGenerator.a(a2);
                            }
                            a2 = mutableFlatBuffer.a(i, 22);
                            if (a2) {
                                jsonGenerator.a("is_looping");
                                jsonGenerator.a(a2);
                            }
                            a2 = mutableFlatBuffer.a(i, 23);
                            if (a2) {
                                jsonGenerator.a("is_spherical");
                                jsonGenerator.a(a2);
                            }
                            a2 = mutableFlatBuffer.a(i, 24);
                            if (a2) {
                                jsonGenerator.a("is_video_broadcast");
                                jsonGenerator.a(a2);
                            }
                            g = mutableFlatBuffer.g(i, 25);
                            if (g != 0) {
                                jsonGenerator.a("link_media");
                                LinkMediaParser.m9781a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            g = mutableFlatBuffer.a(i, 26, 0);
                            if (g != 0) {
                                jsonGenerator.a("live_viewer_count_read_only");
                                jsonGenerator.b(g);
                            }
                            g = mutableFlatBuffer.a(i, 27, 0);
                            if (g != 0) {
                                jsonGenerator.a("loop_count");
                                jsonGenerator.b(g);
                            }
                            g = mutableFlatBuffer.g(i, 28);
                            if (g != 0) {
                                jsonGenerator.a("message");
                                DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            if (mutableFlatBuffer.g(i, 29) != 0) {
                                jsonGenerator.a("name");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 29));
                            }
                            g = mutableFlatBuffer.g(i, 30);
                            if (g != 0) {
                                jsonGenerator.a("open_graph_node");
                                OpenGraphNodeParser.m10522a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            g = mutableFlatBuffer.g(i, 31);
                            if (g != 0) {
                                jsonGenerator.a("owner");
                                OwnerParser.m10569a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            g = mutableFlatBuffer.g(i, 32);
                            if (g != 0) {
                                jsonGenerator.a("phrases_analysis");
                                PhrasesAnalysisParser.m10371a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            g = mutableFlatBuffer.a(i, 33, 0);
                            if (g != 0) {
                                jsonGenerator.a("play_count");
                                jsonGenerator.b(g);
                            }
                            g = mutableFlatBuffer.a(i, 34, 0);
                            if (g != 0) {
                                jsonGenerator.a("playable_duration");
                                jsonGenerator.b(g);
                            }
                            if (mutableFlatBuffer.g(i, 35) != 0) {
                                jsonGenerator.a("playlist");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 35));
                            }
                            if (mutableFlatBuffer.g(i, 36) != 0) {
                                jsonGenerator.a("projection_type");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 36));
                            }
                            g = mutableFlatBuffer.g(i, 37);
                            if (g != 0) {
                                jsonGenerator.a("quotes_analysis");
                                QuotesAnalysisParser.m10415a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            g = mutableFlatBuffer.g(i, 38);
                            if (g != 0) {
                                jsonGenerator.a("source");
                                SourceParser.m9783a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            double a3 = mutableFlatBuffer.a(i, 39, 0.0d);
                            if (a3 != 0.0d) {
                                jsonGenerator.a("sphericalFullscreenAspectRatio");
                                jsonGenerator.a(a3);
                            }
                            a3 = mutableFlatBuffer.a(i, 40, 0.0d);
                            if (a3 != 0.0d) {
                                jsonGenerator.a("sphericalInlineAspectRatio");
                                jsonGenerator.a(a3);
                            }
                            if (mutableFlatBuffer.g(i, 41) != 0) {
                                jsonGenerator.a("sphericalPlayableUrlHdString");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 41));
                            }
                            if (mutableFlatBuffer.g(i, 42) != 0) {
                                jsonGenerator.a("sphericalPlayableUrlSdString");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 42));
                            }
                            g = mutableFlatBuffer.a(i, 43, 0);
                            if (g != 0) {
                                jsonGenerator.a("sphericalPreferredFov");
                                jsonGenerator.b(g);
                            }
                            g = mutableFlatBuffer.g(i, 44);
                            if (g != 0) {
                                jsonGenerator.a("summary");
                                SummaryParser.m10526a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            a2 = mutableFlatBuffer.a(i, 45);
                            if (a2) {
                                jsonGenerator.a("supports_time_slices");
                                jsonGenerator.a(a2);
                            }
                            g = mutableFlatBuffer.g(i, 46);
                            if (g != 0) {
                                jsonGenerator.a("title");
                                TitleParser.m9785a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            if (mutableFlatBuffer.g(i, 47) != 0) {
                                jsonGenerator.a("url");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 47));
                            }
                            g = mutableFlatBuffer.g(i, 48);
                            if (g != 0) {
                                jsonGenerator.a("video_share");
                                VideoShareParser.m9787a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            g = mutableFlatBuffer.a(i, 49, 0);
                            if (g != 0) {
                                jsonGenerator.a("width");
                                jsonGenerator.b(g);
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m9790b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("node")) {
                                    iArr[0] = EdgesNodeParser.m9788a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("result_role")) {
                                    iArr[1] = flatBufferBuilder.a(GraphQLGraphSearchResultRole.fromString(jsonParser.o()));
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, iArr[0]);
                        flatBufferBuilder.b(1, iArr[1]);
                        return flatBufferBuilder.d();
                    }

                    public static void m9791b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("node");
                            EdgesNodeParser.m9789a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("result_role");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m9792a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("edges")) {
                                int i2 = 0;
                                ArrayList arrayList = new ArrayList();
                                if (jsonParser.g() == JsonToken.START_ARRAY) {
                                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                                        arrayList.add(Integer.valueOf(EdgesParser.m9790b(jsonParser, flatBufferBuilder)));
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    int[] iArr2 = new int[arrayList.size()];
                                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                        iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                    }
                                    i2 = flatBufferBuilder.a(iArr2, true);
                                }
                                iArr[0] = i2;
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m9793a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("edges");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            EdgesParser.m9791b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.e();
                    }
                    jsonGenerator.g();
                }
            }

            public static int m9794a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[77];
                boolean[] zArr = new boolean[27];
                boolean[] zArr2 = new boolean[12];
                int[] iArr2 = new int[11];
                long[] jArr = new long[2];
                double[] dArr = new double[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("address")) {
                            iArr[1] = AddressParser.m10090a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("all_share_stories")) {
                            iArr[2] = AllShareStoriesParser.m10612a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("app_center_categories")) {
                            iArr[3] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("bio_text")) {
                            iArr[4] = BioTextParser.m10130a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("broadcast_status")) {
                            iArr[5] = flatBufferBuilder.a(GraphQLVideoBroadcastStatus.fromString(jsonParser.o()));
                        } else if (i.equals("can_viewer_join")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("can_viewer_like")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("category_names")) {
                            iArr[8] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("cover_photo")) {
                            iArr[9] = CoverPhotoParser.m10037a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("created_time")) {
                            zArr[2] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("creation_story")) {
                            iArr[11] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("creation_time")) {
                            zArr[3] = true;
                            jArr[1] = jsonParser.F();
                        } else if (i.equals("display_style")) {
                            iArr[13] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("does_viewer_like")) {
                            zArr[4] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("event_place")) {
                            iArr[15] = EventPlaceParser.m9911a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("expressed_as_place")) {
                            zArr[5] = true;
                            zArr2[3] = jsonParser.H();
                        } else if (i.equals("external_url")) {
                            iArr[17] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("friendship_status")) {
                            iArr[18] = flatBufferBuilder.a(GraphQLFriendshipStatus.fromString(jsonParser.o()));
                        } else if (i.equals("group_members")) {
                            iArr[19] = GroupMembersParser.m9960a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("guided_tour")) {
                            iArr[20] = GuidedTourParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("has_viewer_viewed")) {
                            zArr[6] = true;
                            zArr2[4] = jsonParser.H();
                        } else if (i.equals("has_viewer_watched_video")) {
                            zArr[7] = true;
                            zArr2[5] = jsonParser.H();
                        } else if (i.equals("height")) {
                            zArr[8] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("id")) {
                            iArr[24] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("image")) {
                            iArr[25] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("imageHigh")) {
                            iArr[26] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("imageVideoThumbnail")) {
                            iArr[27] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("initial_view_heading_degrees")) {
                            zArr[9] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("initial_view_pitch_degrees")) {
                            zArr[10] = true;
                            iArr2[2] = jsonParser.E();
                        } else if (i.equals("initial_view_roll_degrees")) {
                            zArr[11] = true;
                            iArr2[3] = jsonParser.E();
                        } else if (i.equals("is_live_streaming")) {
                            zArr[12] = true;
                            zArr2[6] = jsonParser.H();
                        } else if (i.equals("is_looping")) {
                            zArr[13] = true;
                            zArr2[7] = jsonParser.H();
                        } else if (i.equals("is_spherical")) {
                            zArr[14] = true;
                            zArr2[8] = jsonParser.H();
                        } else if (i.equals("is_verified")) {
                            zArr[15] = true;
                            zArr2[9] = jsonParser.H();
                        } else if (i.equals("is_video_broadcast")) {
                            zArr[16] = true;
                            zArr2[10] = jsonParser.H();
                        } else if (i.equals("link_media")) {
                            iArr[36] = LinkMediaParser.m10614a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("live_viewer_count_read_only")) {
                            zArr[17] = true;
                            iArr2[4] = jsonParser.E();
                        } else if (i.equals("location")) {
                            iArr[38] = LocationParser.m10092a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("loop_count")) {
                            zArr[18] = true;
                            iArr2[5] = jsonParser.E();
                        } else if (i.equals("message")) {
                            iArr[40] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("module_results")) {
                            iArr[41] = ModuleResultsParser.m9792a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("module_role")) {
                            iArr[42] = flatBufferBuilder.a(GraphQLGraphSearchResultRole.fromString(jsonParser.o()));
                        } else if (i.equals("module_size_estimate")) {
                            zArr[19] = true;
                            iArr2[6] = jsonParser.E();
                        } else if (i.equals("module_title")) {
                            iArr[44] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("mutual_friends")) {
                            iArr[45] = MutualFriendsParser.m10132a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("name")) {
                            iArr[46] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("overall_star_rating")) {
                            iArr[47] = OverallStarRatingParser.m10094a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("owner")) {
                            iArr[48] = OwnerParser.m10568a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("page_call_to_action")) {
                            iArr[49] = SearchResultsPageCTAParser.m10031a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("page_likers")) {
                            iArr[50] = PageLikersParser.m10039a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_open_status")) {
                            iArr[51] = PlaceOpenStatusParser.m10096a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_open_status_type")) {
                            iArr[52] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                        } else if (i.equals("play_count")) {
                            zArr[20] = true;
                            iArr2[7] = jsonParser.E();
                        } else if (i.equals("playable_duration")) {
                            zArr[21] = true;
                            iArr2[8] = jsonParser.E();
                        } else if (i.equals("playlist")) {
                            iArr[55] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("price_range_description")) {
                            iArr[56] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("profile_picture")) {
                            iArr[57] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("projection_type")) {
                            iArr[58] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("see_more_query")) {
                            iArr[59] = SearchResultsSeeMoreQueryParser.m9849a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("social_context")) {
                            iArr[60] = SocialContextParser.m9962a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("source")) {
                            iArr[61] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("sphericalFullscreenAspectRatio")) {
                            zArr[22] = true;
                            dArr[0] = jsonParser.G();
                        } else if (i.equals("sphericalInlineAspectRatio")) {
                            zArr[23] = true;
                            dArr[1] = jsonParser.G();
                        } else if (i.equals("sphericalPlayableUrlHdString")) {
                            iArr[64] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("sphericalPlayableUrlSdString")) {
                            iArr[65] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("sphericalPreferredFov")) {
                            zArr[24] = true;
                            iArr2[9] = jsonParser.E();
                        } else if (i.equals("supports_time_slices")) {
                            zArr[25] = true;
                            zArr2[11] = jsonParser.H();
                        } else if (i.equals("time_range_sentence")) {
                            iArr[68] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("title")) {
                            iArr[69] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("url")) {
                            iArr[70] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("video_share")) {
                            iArr[71] = VideoShareParser.m10616a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("viewer_guest_status")) {
                            iArr[72] = flatBufferBuilder.a(GraphQLEventGuestStatus.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_join_state")) {
                            iArr[73] = flatBufferBuilder.a(GraphQLGroupJoinState.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_saved_state")) {
                            iArr[74] = flatBufferBuilder.a(GraphQLSavedState.fromString(jsonParser.o()));
                        } else if (i.equals("visibility_sentence")) {
                            iArr[75] = VisibilitySentenceParser.m9964a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("width")) {
                            zArr[26] = true;
                            iArr2[10] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(77);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                if (zArr[0]) {
                    flatBufferBuilder.a(6, zArr2[0]);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(7, zArr2[1]);
                }
                flatBufferBuilder.b(8, iArr[8]);
                flatBufferBuilder.b(9, iArr[9]);
                if (zArr[2]) {
                    flatBufferBuilder.a(10, jArr[0], 0);
                }
                flatBufferBuilder.b(11, iArr[11]);
                if (zArr[3]) {
                    flatBufferBuilder.a(12, jArr[1], 0);
                }
                flatBufferBuilder.b(13, iArr[13]);
                if (zArr[4]) {
                    flatBufferBuilder.a(14, zArr2[2]);
                }
                flatBufferBuilder.b(15, iArr[15]);
                if (zArr[5]) {
                    flatBufferBuilder.a(16, zArr2[3]);
                }
                flatBufferBuilder.b(17, iArr[17]);
                flatBufferBuilder.b(18, iArr[18]);
                flatBufferBuilder.b(19, iArr[19]);
                flatBufferBuilder.b(20, iArr[20]);
                if (zArr[6]) {
                    flatBufferBuilder.a(21, zArr2[4]);
                }
                if (zArr[7]) {
                    flatBufferBuilder.a(22, zArr2[5]);
                }
                if (zArr[8]) {
                    flatBufferBuilder.a(23, iArr2[0], 0);
                }
                flatBufferBuilder.b(24, iArr[24]);
                flatBufferBuilder.b(25, iArr[25]);
                flatBufferBuilder.b(26, iArr[26]);
                flatBufferBuilder.b(27, iArr[27]);
                if (zArr[9]) {
                    flatBufferBuilder.a(28, iArr2[1], 0);
                }
                if (zArr[10]) {
                    flatBufferBuilder.a(29, iArr2[2], 0);
                }
                if (zArr[11]) {
                    flatBufferBuilder.a(30, iArr2[3], 0);
                }
                if (zArr[12]) {
                    flatBufferBuilder.a(31, zArr2[6]);
                }
                if (zArr[13]) {
                    flatBufferBuilder.a(32, zArr2[7]);
                }
                if (zArr[14]) {
                    flatBufferBuilder.a(33, zArr2[8]);
                }
                if (zArr[15]) {
                    flatBufferBuilder.a(34, zArr2[9]);
                }
                if (zArr[16]) {
                    flatBufferBuilder.a(35, zArr2[10]);
                }
                flatBufferBuilder.b(36, iArr[36]);
                if (zArr[17]) {
                    flatBufferBuilder.a(37, iArr2[4], 0);
                }
                flatBufferBuilder.b(38, iArr[38]);
                if (zArr[18]) {
                    flatBufferBuilder.a(39, iArr2[5], 0);
                }
                flatBufferBuilder.b(40, iArr[40]);
                flatBufferBuilder.b(41, iArr[41]);
                flatBufferBuilder.b(42, iArr[42]);
                if (zArr[19]) {
                    flatBufferBuilder.a(43, iArr2[6], 0);
                }
                flatBufferBuilder.b(44, iArr[44]);
                flatBufferBuilder.b(45, iArr[45]);
                flatBufferBuilder.b(46, iArr[46]);
                flatBufferBuilder.b(47, iArr[47]);
                flatBufferBuilder.b(48, iArr[48]);
                flatBufferBuilder.b(49, iArr[49]);
                flatBufferBuilder.b(50, iArr[50]);
                flatBufferBuilder.b(51, iArr[51]);
                flatBufferBuilder.b(52, iArr[52]);
                if (zArr[20]) {
                    flatBufferBuilder.a(53, iArr2[7], 0);
                }
                if (zArr[21]) {
                    flatBufferBuilder.a(54, iArr2[8], 0);
                }
                flatBufferBuilder.b(55, iArr[55]);
                flatBufferBuilder.b(56, iArr[56]);
                flatBufferBuilder.b(57, iArr[57]);
                flatBufferBuilder.b(58, iArr[58]);
                flatBufferBuilder.b(59, iArr[59]);
                flatBufferBuilder.b(60, iArr[60]);
                flatBufferBuilder.b(61, iArr[61]);
                if (zArr[22]) {
                    flatBufferBuilder.a(62, dArr[0], 0.0d);
                }
                if (zArr[23]) {
                    flatBufferBuilder.a(63, dArr[1], 0.0d);
                }
                flatBufferBuilder.b(64, iArr[64]);
                flatBufferBuilder.b(65, iArr[65]);
                if (zArr[24]) {
                    flatBufferBuilder.a(66, iArr2[9], 0);
                }
                if (zArr[25]) {
                    flatBufferBuilder.a(67, zArr2[11]);
                }
                flatBufferBuilder.b(68, iArr[68]);
                flatBufferBuilder.b(69, iArr[69]);
                flatBufferBuilder.b(70, iArr[70]);
                flatBufferBuilder.b(71, iArr[71]);
                flatBufferBuilder.b(72, iArr[72]);
                flatBufferBuilder.b(73, iArr[73]);
                flatBufferBuilder.b(74, iArr[74]);
                flatBufferBuilder.b(75, iArr[75]);
                if (zArr[26]) {
                    flatBufferBuilder.a(76, iArr2[10], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m9795a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("address");
                    AddressParser.m10091a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("all_share_stories");
                    AllShareStoriesParser.m10613a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("app_center_categories");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 3), jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("bio_text");
                    BioTextParser.m10131a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("broadcast_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 5));
                }
                boolean a = mutableFlatBuffer.a(i, 6);
                if (a) {
                    jsonGenerator.a("can_viewer_join");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 7);
                if (a) {
                    jsonGenerator.a("can_viewer_like");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 8) != 0) {
                    jsonGenerator.a("category_names");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 8), jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 9);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m10038a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                long a2 = mutableFlatBuffer.a(i, 10, 0);
                if (a2 != 0) {
                    jsonGenerator.a("created_time");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("creation_story");
                    GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a2 = mutableFlatBuffer.a(i, 12, 0);
                if (a2 != 0) {
                    jsonGenerator.a("creation_time");
                    jsonGenerator.a(a2);
                }
                if (mutableFlatBuffer.g(i, 13) != 0) {
                    jsonGenerator.a("display_style");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 13), jsonGenerator);
                }
                a = mutableFlatBuffer.a(i, 14);
                if (a) {
                    jsonGenerator.a("does_viewer_like");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 15);
                if (g != 0) {
                    jsonGenerator.a("event_place");
                    EventPlaceParser.m9912a(mutableFlatBuffer, g, jsonGenerator);
                }
                a = mutableFlatBuffer.a(i, 16);
                if (a) {
                    jsonGenerator.a("expressed_as_place");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 17) != 0) {
                    jsonGenerator.a("external_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 17));
                }
                if (mutableFlatBuffer.g(i, 18) != 0) {
                    jsonGenerator.a("friendship_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 18));
                }
                g = mutableFlatBuffer.g(i, 19);
                if (g != 0) {
                    jsonGenerator.a("group_members");
                    GroupMembersParser.m9961a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 20);
                if (g != 0) {
                    jsonGenerator.a("guided_tour");
                    GuidedTourParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.a(i, 21);
                if (a) {
                    jsonGenerator.a("has_viewer_viewed");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 22);
                if (a) {
                    jsonGenerator.a("has_viewer_watched_video");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.a(i, 23, 0);
                if (g != 0) {
                    jsonGenerator.a("height");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 24) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 24));
                }
                g = mutableFlatBuffer.g(i, 25);
                if (g != 0) {
                    jsonGenerator.a("image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 26);
                if (g != 0) {
                    jsonGenerator.a("imageHigh");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 27);
                if (g != 0) {
                    jsonGenerator.a("imageVideoThumbnail");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 28, 0);
                if (g != 0) {
                    jsonGenerator.a("initial_view_heading_degrees");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 29, 0);
                if (g != 0) {
                    jsonGenerator.a("initial_view_pitch_degrees");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 30, 0);
                if (g != 0) {
                    jsonGenerator.a("initial_view_roll_degrees");
                    jsonGenerator.b(g);
                }
                a = mutableFlatBuffer.a(i, 31);
                if (a) {
                    jsonGenerator.a("is_live_streaming");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 32);
                if (a) {
                    jsonGenerator.a("is_looping");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 33);
                if (a) {
                    jsonGenerator.a("is_spherical");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 34);
                if (a) {
                    jsonGenerator.a("is_verified");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 35);
                if (a) {
                    jsonGenerator.a("is_video_broadcast");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 36);
                if (g != 0) {
                    jsonGenerator.a("link_media");
                    LinkMediaParser.m10615a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 37, 0);
                if (g != 0) {
                    jsonGenerator.a("live_viewer_count_read_only");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 38);
                if (g != 0) {
                    jsonGenerator.a("location");
                    LocationParser.m10093a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 39, 0);
                if (g != 0) {
                    jsonGenerator.a("loop_count");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 40);
                if (g != 0) {
                    jsonGenerator.a("message");
                    DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 41);
                if (g != 0) {
                    jsonGenerator.a("module_results");
                    ModuleResultsParser.m9793a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 42) != 0) {
                    jsonGenerator.a("module_role");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 42));
                }
                g = mutableFlatBuffer.a(i, 43, 0);
                if (g != 0) {
                    jsonGenerator.a("module_size_estimate");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 44) != 0) {
                    jsonGenerator.a("module_title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 44));
                }
                g = mutableFlatBuffer.g(i, 45);
                if (g != 0) {
                    jsonGenerator.a("mutual_friends");
                    MutualFriendsParser.m10133a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 46) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 46));
                }
                g = mutableFlatBuffer.g(i, 47);
                if (g != 0) {
                    jsonGenerator.a("overall_star_rating");
                    OverallStarRatingParser.m10095a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 48);
                if (g != 0) {
                    jsonGenerator.a("owner");
                    OwnerParser.m10569a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 49);
                if (g != 0) {
                    jsonGenerator.a("page_call_to_action");
                    SearchResultsPageCTAParser.m10032a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 50);
                if (g != 0) {
                    jsonGenerator.a("page_likers");
                    PageLikersParser.m10040a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 51);
                if (g != 0) {
                    jsonGenerator.a("place_open_status");
                    PlaceOpenStatusParser.m10097a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 52) != 0) {
                    jsonGenerator.a("place_open_status_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 52));
                }
                g = mutableFlatBuffer.a(i, 53, 0);
                if (g != 0) {
                    jsonGenerator.a("play_count");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 54, 0);
                if (g != 0) {
                    jsonGenerator.a("playable_duration");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 55) != 0) {
                    jsonGenerator.a("playlist");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 55));
                }
                if (mutableFlatBuffer.g(i, 56) != 0) {
                    jsonGenerator.a("price_range_description");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 56));
                }
                g = mutableFlatBuffer.g(i, 57);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 58) != 0) {
                    jsonGenerator.a("projection_type");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 58));
                }
                g = mutableFlatBuffer.g(i, 59);
                if (g != 0) {
                    jsonGenerator.a("see_more_query");
                    SearchResultsSeeMoreQueryParser.m9850a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 60);
                if (g != 0) {
                    jsonGenerator.a("social_context");
                    SocialContextParser.m9963a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 61);
                if (g != 0) {
                    jsonGenerator.a("source");
                    DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                double a3 = mutableFlatBuffer.a(i, 62, 0.0d);
                if (a3 != 0.0d) {
                    jsonGenerator.a("sphericalFullscreenAspectRatio");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 63, 0.0d);
                if (a3 != 0.0d) {
                    jsonGenerator.a("sphericalInlineAspectRatio");
                    jsonGenerator.a(a3);
                }
                if (mutableFlatBuffer.g(i, 64) != 0) {
                    jsonGenerator.a("sphericalPlayableUrlHdString");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 64));
                }
                if (mutableFlatBuffer.g(i, 65) != 0) {
                    jsonGenerator.a("sphericalPlayableUrlSdString");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 65));
                }
                g = mutableFlatBuffer.a(i, 66, 0);
                if (g != 0) {
                    jsonGenerator.a("sphericalPreferredFov");
                    jsonGenerator.b(g);
                }
                a = mutableFlatBuffer.a(i, 67);
                if (a) {
                    jsonGenerator.a("supports_time_slices");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 68) != 0) {
                    jsonGenerator.a("time_range_sentence");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 68));
                }
                g = mutableFlatBuffer.g(i, 69);
                if (g != 0) {
                    jsonGenerator.a("title");
                    DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 70) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 70));
                }
                g = mutableFlatBuffer.g(i, 71);
                if (g != 0) {
                    jsonGenerator.a("video_share");
                    VideoShareParser.m10617a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 72) != 0) {
                    jsonGenerator.a("viewer_guest_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 72));
                }
                if (mutableFlatBuffer.g(i, 73) != 0) {
                    jsonGenerator.a("viewer_join_state");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 73));
                }
                if (mutableFlatBuffer.g(i, 74) != 0) {
                    jsonGenerator.a("viewer_saved_state");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 74));
                }
                g = mutableFlatBuffer.g(i, 75);
                if (g != 0) {
                    jsonGenerator.a("visibility_sentence");
                    VisibilitySentenceParser.m9965a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 76, 0);
                if (g != 0) {
                    jsonGenerator.a("width");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }
        }

        public static int m9796b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("node")) {
                        iArr[0] = NodeParser.m9794a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("result_decoration")) {
                        iArr[1] = SearchResultsDecorationParser.m9877a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("result_display_styles")) {
                        iArr[2] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("result_role")) {
                        iArr[3] = flatBufferBuilder.a(GraphQLGraphSearchResultRole.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            return flatBufferBuilder.d();
        }

        public static void m9797b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("node");
                NodeParser.m9795a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("result_decoration");
                SearchResultsDecorationParser.m9878a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("result_display_styles");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 2), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("result_role");
                jsonGenerator.b(mutableFlatBuffer.b(i, 3));
            }
            jsonGenerator.g();
        }
    }
}
