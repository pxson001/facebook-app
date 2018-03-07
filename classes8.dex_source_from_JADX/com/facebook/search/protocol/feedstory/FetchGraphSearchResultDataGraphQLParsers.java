package com.facebook.search.protocol.feedstory;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGraphSearchSpellerConfidence;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.search.results.protocol.common.SearchResultsDecorationParsers.SearchResultsDecorationParser;
import com.facebook.search.results.protocol.entity.SearchResultsEventParsers.SearchResultsEventParser.EventPlaceParser;
import com.facebook.search.results.protocol.entity.SearchResultsGroupParsers.SearchResultsGroupParser.GroupMembersParser;
import com.facebook.search.results.protocol.entity.SearchResultsGroupParsers.SearchResultsGroupParser.SocialContextParser;
import com.facebook.search.results.protocol.entity.SearchResultsGroupParsers.SearchResultsGroupParser.VisibilitySentenceParser;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageCTAParser;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageParser.CoverPhotoParser;
import com.facebook.search.results.protocol.entity.SearchResultsPageParsers.SearchResultsPageParser.PageLikersParser;
import com.facebook.search.results.protocol.entity.SearchResultsUserParsers.SearchResultsUserParser.BioTextParser;
import com.facebook.search.results.protocol.entity.SearchResultsUserParsers.SearchResultsUserParser.MutualFriendsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: native_ad_type */
public class FetchGraphSearchResultDataGraphQLParsers {

    /* compiled from: native_ad_type */
    public final class FBGraphSearchQueryDetailsFragmentParser {

        /* compiled from: native_ad_type */
        public final class ModulesParser {

            /* compiled from: native_ad_type */
            public final class CorrectedQueryParser {

                /* compiled from: native_ad_type */
                public final class QueryTitleParser {
                    public static int m9367a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("text")) {
                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m9368a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("text");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m9369a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("query_function")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("query_title")) {
                                iArr[1] = QueryTitleParser.m9367a(jsonParser, flatBufferBuilder);
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

                public static void m9370a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("query_function");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("query_title");
                        QueryTitleParser.m9368a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m9371a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("corrected_query")) {
                            iArr[0] = CorrectedQueryParser.m9369a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("session_id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("speller_confidence")) {
                            iArr[2] = flatBufferBuilder.a(GraphQLGraphSearchSpellerConfidence.fromString(jsonParser.o()));
                        } else if (i.equals("vertical_to_log")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
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

            public static void m9372a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("corrected_query");
                    CorrectedQueryParser.m9370a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("session_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("speller_confidence");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("vertical_to_log");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: native_ad_type */
        public final class QueryTitleParser {
            public static int m9373a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("text")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m9374a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m9375a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("modules")) {
                        iArr[1] = ModulesParser.m9371a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("query_function")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("query_title")) {
                        iArr[3] = QueryTitleParser.m9373a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("search_result_style_list")) {
                        iArr[4] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: native_ad_type */
    public final class FBGraphSearchQueryParser {

        /* compiled from: native_ad_type */
        public final class FilteredQueryParser {
            public static int m9376a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[6];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("modules")) {
                            iArr[1] = ModulesParser.m9371a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("query_function")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("query_title")) {
                            iArr[3] = QueryTitleParser.m9373a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("results")) {
                            iArr[4] = FBGraphSearchQueryResultFragmentParser.m9385a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("search_result_style_list")) {
                            iArr[5] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                return flatBufferBuilder.d();
            }

            public static void m9377a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("modules");
                    ModulesParser.m9372a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("query_function");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("query_title");
                    QueryTitleParser.m9374a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("results");
                    FBGraphSearchQueryResultFragmentParser.m9386a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("search_result_style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 5), jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m9378a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("filtered_query")) {
                        iArr[0] = FilteredQueryParser.m9376a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: native_ad_type */
    public final class FBGraphSearchQueryResultFragmentParser {

        /* compiled from: native_ad_type */
        public final class EdgesParser {

            /* compiled from: native_ad_type */
            public final class NodeParser {
                public static int m9379a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[25];
                    boolean[] zArr = new boolean[4];
                    boolean[] zArr2 = new boolean[4];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("app_center_categories")) {
                                iArr[1] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("bio_text")) {
                                iArr[2] = BioTextParser.m10130a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("can_viewer_join")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("can_viewer_like")) {
                                zArr[1] = true;
                                zArr2[1] = jsonParser.H();
                            } else if (i.equals("category_names")) {
                                iArr[5] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("cover_photo")) {
                                iArr[6] = CoverPhotoParser.m10037a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("does_viewer_like")) {
                                zArr[2] = true;
                                zArr2[2] = jsonParser.H();
                            } else if (i.equals("event_place")) {
                                iArr[8] = EventPlaceParser.m9911a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("friendship_status")) {
                                iArr[9] = flatBufferBuilder.a(GraphQLFriendshipStatus.fromString(jsonParser.o()));
                            } else if (i.equals("group_members")) {
                                iArr[10] = GroupMembersParser.m9960a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("id")) {
                                iArr[11] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("image")) {
                                iArr[12] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("imageHigh")) {
                                iArr[13] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("is_verified")) {
                                zArr[3] = true;
                                zArr2[3] = jsonParser.H();
                            } else if (i.equals("mutual_friends")) {
                                iArr[15] = MutualFriendsParser.m10132a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("name")) {
                                iArr[16] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("page_call_to_action")) {
                                iArr[17] = SearchResultsPageCTAParser.m10031a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("page_likers")) {
                                iArr[18] = PageLikersParser.m10039a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("profile_picture")) {
                                iArr[19] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("social_context")) {
                                iArr[20] = SocialContextParser.m9962a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("time_range_sentence")) {
                                iArr[21] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("viewer_guest_status")) {
                                iArr[22] = flatBufferBuilder.a(GraphQLEventGuestStatus.fromString(jsonParser.o()));
                            } else if (i.equals("viewer_join_state")) {
                                iArr[23] = flatBufferBuilder.a(GraphQLGroupJoinState.fromString(jsonParser.o()));
                            } else if (i.equals("visibility_sentence")) {
                                iArr[24] = VisibilitySentenceParser.m9964a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(25);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    flatBufferBuilder.b(2, iArr[2]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(3, zArr2[0]);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(4, zArr2[1]);
                    }
                    flatBufferBuilder.b(5, iArr[5]);
                    flatBufferBuilder.b(6, iArr[6]);
                    if (zArr[2]) {
                        flatBufferBuilder.a(7, zArr2[2]);
                    }
                    flatBufferBuilder.b(8, iArr[8]);
                    flatBufferBuilder.b(9, iArr[9]);
                    flatBufferBuilder.b(10, iArr[10]);
                    flatBufferBuilder.b(11, iArr[11]);
                    flatBufferBuilder.b(12, iArr[12]);
                    flatBufferBuilder.b(13, iArr[13]);
                    if (zArr[3]) {
                        flatBufferBuilder.a(14, zArr2[3]);
                    }
                    flatBufferBuilder.b(15, iArr[15]);
                    flatBufferBuilder.b(16, iArr[16]);
                    flatBufferBuilder.b(17, iArr[17]);
                    flatBufferBuilder.b(18, iArr[18]);
                    flatBufferBuilder.b(19, iArr[19]);
                    flatBufferBuilder.b(20, iArr[20]);
                    flatBufferBuilder.b(21, iArr[21]);
                    flatBufferBuilder.b(22, iArr[22]);
                    flatBufferBuilder.b(23, iArr[23]);
                    flatBufferBuilder.b(24, iArr[24]);
                    return flatBufferBuilder.d();
                }

                public static void m9380a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("app_center_categories");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 1), jsonGenerator);
                    }
                    int g = mutableFlatBuffer.g(i, 2);
                    if (g != 0) {
                        jsonGenerator.a("bio_text");
                        BioTextParser.m10131a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    boolean a = mutableFlatBuffer.a(i, 3);
                    if (a) {
                        jsonGenerator.a("can_viewer_join");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 4);
                    if (a) {
                        jsonGenerator.a("can_viewer_like");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 5) != 0) {
                        jsonGenerator.a("category_names");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 5), jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 6);
                    if (g != 0) {
                        jsonGenerator.a("cover_photo");
                        CoverPhotoParser.m10038a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    a = mutableFlatBuffer.a(i, 7);
                    if (a) {
                        jsonGenerator.a("does_viewer_like");
                        jsonGenerator.a(a);
                    }
                    g = mutableFlatBuffer.g(i, 8);
                    if (g != 0) {
                        jsonGenerator.a("event_place");
                        EventPlaceParser.m9912a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 9) != 0) {
                        jsonGenerator.a("friendship_status");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 9));
                    }
                    g = mutableFlatBuffer.g(i, 10);
                    if (g != 0) {
                        jsonGenerator.a("group_members");
                        GroupMembersParser.m9961a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 11) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 11));
                    }
                    g = mutableFlatBuffer.g(i, 12);
                    if (g != 0) {
                        jsonGenerator.a("image");
                        DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 13);
                    if (g != 0) {
                        jsonGenerator.a("imageHigh");
                        DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    a = mutableFlatBuffer.a(i, 14);
                    if (a) {
                        jsonGenerator.a("is_verified");
                        jsonGenerator.a(a);
                    }
                    g = mutableFlatBuffer.g(i, 15);
                    if (g != 0) {
                        jsonGenerator.a("mutual_friends");
                        MutualFriendsParser.m10133a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 16) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 16));
                    }
                    g = mutableFlatBuffer.g(i, 17);
                    if (g != 0) {
                        jsonGenerator.a("page_call_to_action");
                        SearchResultsPageCTAParser.m10032a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 18);
                    if (g != 0) {
                        jsonGenerator.a("page_likers");
                        PageLikersParser.m10040a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 19);
                    if (g != 0) {
                        jsonGenerator.a("profile_picture");
                        DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 20);
                    if (g != 0) {
                        jsonGenerator.a("social_context");
                        SocialContextParser.m9963a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 21) != 0) {
                        jsonGenerator.a("time_range_sentence");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 21));
                    }
                    if (mutableFlatBuffer.g(i, 22) != 0) {
                        jsonGenerator.a("viewer_guest_status");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 22));
                    }
                    if (mutableFlatBuffer.g(i, 23) != 0) {
                        jsonGenerator.a("viewer_join_state");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 23));
                    }
                    g = mutableFlatBuffer.g(i, 24);
                    if (g != 0) {
                        jsonGenerator.a("visibility_sentence");
                        VisibilitySentenceParser.m9965a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m9381b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("node")) {
                            iArr[0] = NodeParser.m9379a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("result_decoration")) {
                            iArr[1] = SearchResultsDecorationParser.m9877a(jsonParser, flatBufferBuilder);
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

            public static void m9382b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("node");
                    NodeParser.m9380a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("result_decoration");
                    SearchResultsDecorationParser.m9878a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: native_ad_type */
        public final class PageInfoParser {
            public static int m9383a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("end_cursor")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("has_next_page")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, zArr2[0]);
                }
                return flatBufferBuilder.d();
            }

            public static void m9384a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("end_cursor");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                boolean a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("has_next_page");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m9385a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("edges")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(EdgesParser.m9381b(jsonParser, flatBufferBuilder)));
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
                    } else if (i.equals("page_info")) {
                        iArr[1] = PageInfoParser.m9383a(jsonParser, flatBufferBuilder);
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

        public static void m9386a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("edges");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    EdgesParser.m9382b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("page_info");
                PageInfoParser.m9384a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }
}
