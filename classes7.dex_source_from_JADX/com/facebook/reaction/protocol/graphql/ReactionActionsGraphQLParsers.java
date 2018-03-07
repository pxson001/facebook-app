package com.facebook.reaction.protocol.graphql;

import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFundraiserSupportersConnectionType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLNearbyFriendsNuxType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPagePhotoSourceType;
import com.facebook.graphql.enums.GraphQLPhotosByCategoryEntryPoint;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeParsers.ComposerTargetDataPrivacyScopeFieldsParser;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLParsers.PageServiceItemParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionFeedbackFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionImageFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionProfileFieldsParser.CoverPhotoParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.VideoTopicFragmentParser.SquareHeaderImageParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.VideoTopicFragmentParser.VideoChannelSubtitleParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.VideoTopicFragmentParser.VideoChannelTitleParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: ffec61fd63b7529c27a68fc607988607 */
public class ReactionActionsGraphQLParsers {

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionActionFatFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class EventParser {
            public static int m16505a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[9];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("connection_style")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLConnectionStyle.fromString(jsonParser.o()));
                        } else if (i.equals("event_kind")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLEventPrivacyType.fromString(jsonParser.o()));
                        } else if (i.equals("event_place")) {
                            iArr[2] = EventPlaceParser.m16546a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("event_viewer_capability")) {
                            iArr[3] = EventViewerCapabilityParser.m16612a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("live_permalink_time_range_sentence")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[6] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("profile_picture")) {
                            iArr[7] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("viewer_guest_status")) {
                            iArr[8] = flatBufferBuilder.a(GraphQLEventGuestStatus.fromString(jsonParser.o()));
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                flatBufferBuilder.b(7, iArr[7]);
                flatBufferBuilder.b(8, iArr[8]);
                return flatBufferBuilder.d();
            }

            public static void m16506a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("connection_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("event_kind");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                int g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("event_place");
                    EventPlaceParser.m16547a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("event_viewer_capability");
                    EventViewerCapabilityParser.m16613a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("live_permalink_time_range_sentence");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                if (mutableFlatBuffer.g(i, 6) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 8) != 0) {
                    jsonGenerator.a("viewer_guest_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 8));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class GroupParser {
            public static int m16507a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
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

            public static void m16508a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class PageParser {
            public static int m16509a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("profile_picture")) {
                            iArr[2] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
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

            public static void m16510a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                int g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class ProfileParser {
            public static int m16511a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[18];
                boolean[] zArr = new boolean[5];
                boolean[] zArr2 = new boolean[5];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("can_viewer_change_guest_status")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("can_viewer_like")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("can_viewer_message")) {
                            zArr[2] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("category_names")) {
                            iArr[4] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("connection_style")) {
                            iArr[5] = flatBufferBuilder.a(GraphQLConnectionStyle.fromString(jsonParser.o()));
                        } else if (i.equals("cover_photo")) {
                            iArr[6] = CoverPhotoParser.m14710a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("does_viewer_like")) {
                            zArr[3] = true;
                            zArr2[3] = jsonParser.H();
                        } else if (i.equals("event_kind")) {
                            iArr[8] = flatBufferBuilder.a(GraphQLEventPrivacyType.fromString(jsonParser.o()));
                        } else if (i.equals("id")) {
                            iArr[9] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[10] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("profile_picture")) {
                            iArr[11] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("url")) {
                            iArr[12] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("viewer_guest_status")) {
                            iArr[13] = flatBufferBuilder.a(GraphQLEventGuestStatus.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_has_pending_invite")) {
                            zArr[4] = true;
                            zArr2[4] = jsonParser.H();
                        } else if (i.equals("viewer_join_state")) {
                            iArr[15] = flatBufferBuilder.a(GraphQLGroupJoinState.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_saved_state")) {
                            iArr[16] = flatBufferBuilder.a(GraphQLSavedState.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_watch_status")) {
                            iArr[17] = flatBufferBuilder.a(GraphQLEventWatchStatus.fromString(jsonParser.o()));
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(18);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, zArr2[0]);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(2, zArr2[1]);
                }
                if (zArr[2]) {
                    flatBufferBuilder.a(3, zArr2[2]);
                }
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                if (zArr[3]) {
                    flatBufferBuilder.a(7, zArr2[3]);
                }
                flatBufferBuilder.b(8, iArr[8]);
                flatBufferBuilder.b(9, iArr[9]);
                flatBufferBuilder.b(10, iArr[10]);
                flatBufferBuilder.b(11, iArr[11]);
                flatBufferBuilder.b(12, iArr[12]);
                flatBufferBuilder.b(13, iArr[13]);
                if (zArr[4]) {
                    flatBufferBuilder.a(14, zArr2[4]);
                }
                flatBufferBuilder.b(15, iArr[15]);
                flatBufferBuilder.b(16, iArr[16]);
                flatBufferBuilder.b(17, iArr[17]);
                return flatBufferBuilder.d();
            }

            public static void m16512a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("can_viewer_change_guest_status");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 2);
                if (a) {
                    jsonGenerator.a("can_viewer_like");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 3);
                if (a) {
                    jsonGenerator.a("can_viewer_message");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("category_names");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 4), jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("connection_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 5));
                }
                int g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m14711a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.a(i, 7);
                if (a) {
                    jsonGenerator.a("does_viewer_like");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 8) != 0) {
                    jsonGenerator.a("event_kind");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 8));
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                }
                if (mutableFlatBuffer.g(i, 10) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 10));
                }
                g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 12) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 12));
                }
                if (mutableFlatBuffer.g(i, 13) != 0) {
                    jsonGenerator.a("viewer_guest_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 13));
                }
                a = mutableFlatBuffer.a(i, 14);
                if (a) {
                    jsonGenerator.a("viewer_has_pending_invite");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 15) != 0) {
                    jsonGenerator.a("viewer_join_state");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 15));
                }
                if (mutableFlatBuffer.g(i, 16) != 0) {
                    jsonGenerator.a("viewer_saved_state");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 16));
                }
                if (mutableFlatBuffer.g(i, 17) != 0) {
                    jsonGenerator.a("viewer_watch_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 17));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class RelatedUsersParser {
            public static int m16516b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
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

            public static int m16513a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m16516b(jsonParser, flatBufferBuilder)));
                    }
                }
                if (arrayList.isEmpty()) {
                    return 0;
                }
                int[] iArr = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
                return flatBufferBuilder.a(iArr, true);
            }

            public static void m16515a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m16514a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }

            public static void m16514a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class StoryParser {

            /* compiled from: ffec61fd63b7529c27a68fc607988607 */
            public final class FeedbackParser {
                public static int m16517a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("default_comment_ordering")) {
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

                public static void m16518a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("default_comment_ordering");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m16519a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("cache_id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("feedback")) {
                            iArr[1] = FeedbackParser.m16517a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("legacy_api_story_id")) {
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

            public static void m16520a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("cache_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackParser.m16518a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("legacy_api_story_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                jsonGenerator.g();
            }
        }

        public static int m16521a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[50];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("action_default_activated_submessage")) {
                        iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_default_message")) {
                        iArr[2] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_og_object")) {
                        iArr[3] = ActionOgObjectParser.m16562a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("album")) {
                        iArr[4] = AlbumParser.m16568a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("can_share_photo")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("collection")) {
                        iArr[6] = CollectionParser.m16587a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("comment")) {
                        iArr[7] = CommentParser.m16607a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("component_id")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("composer_inline_activity")) {
                        iArr[9] = ComposerInlineActivityParser.m16535a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("connection_type")) {
                        iArr[10] = flatBufferBuilder.a(GraphQLFundraiserSupportersConnectionType.fromString(jsonParser.o()));
                    } else if (i.equals("display_style")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("entry_point")) {
                        iArr[12] = flatBufferBuilder.a(GraphQLPhotosByCategoryEntryPoint.fromString(jsonParser.o()));
                    } else if (i.equals("event")) {
                        iArr[13] = EventParser.m16505a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("event_space")) {
                        iArr[14] = EventSpaceParser.m16537a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("existing_place_items")) {
                        iArr[15] = ReactionWeatherSettingsPlaceItemFragmentParser.m16626b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("friend")) {
                        iArr[16] = FriendParser.m16550a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("full_address")) {
                        iArr[17] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("fundraiser")) {
                        iArr[18] = FundraiserParser.m16617a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("fundraiser_campaign")) {
                        iArr[19] = FundraiserCampaignParser.m16559a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group")) {
                        iArr[20] = GroupParser.m16507a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("guest_status")) {
                        iArr[21] = flatBufferBuilder.a(GraphQLEventWatchStatus.fromString(jsonParser.o()));
                    } else if (i.equals("location")) {
                        iArr[22] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("match_page")) {
                        iArr[23] = MatchPageParser.m16573a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("nux_type")) {
                        iArr[24] = flatBufferBuilder.a(GraphQLNearbyFriendsNuxType.fromString(jsonParser.o()));
                    } else if (i.equals("page")) {
                        iArr[25] = PageParser.m16509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("phone_uri")) {
                        iArr[26] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("photo_source_type")) {
                        iArr[27] = flatBufferBuilder.a(GraphQLPagePhotoSourceType.fromString(jsonParser.o()));
                    } else if (i.equals("place_id")) {
                        iArr[28] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("places_query_location_page")) {
                        iArr[29] = PlacesQueryLocationPageParser.m16565a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("places_query_text")) {
                        iArr[30] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("places_query_topic_id")) {
                        iArr[31] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profile")) {
                        iArr[32] = ProfileParser.m16511a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_pic_uri")) {
                        iArr[33] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("query")) {
                        iArr[34] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("related_users")) {
                        iArr[35] = RelatedUsersParser.m16513a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("replacement_unit")) {
                        iArr[36] = ReplacementUnitParser.m16584a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("service")) {
                        iArr[37] = PageServiceItemParser.m11181a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("settings_token_for_reload")) {
                        iArr[38] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("source")) {
                        iArr[39] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("source_text")) {
                        iArr[40] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("story")) {
                        iArr[41] = StoryParser.m16519a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subscribe_status")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("suggestion_token")) {
                        iArr[43] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("target")) {
                        iArr[44] = ReactionEventInviteFieldsParser.m16544a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temperature_scale")) {
                        iArr[45] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("thread_key")) {
                        iArr[46] = ThreadKeyParser.m16590a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("unit_type_token")) {
                        iArr[47] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("url")) {
                        iArr[48] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("video_channel")) {
                        iArr[49] = VideoChannelParser.m16576a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[0]) {
                flatBufferBuilder.a(5, zArr2[0]);
            }
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
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
            flatBufferBuilder.b(25, iArr[25]);
            flatBufferBuilder.b(26, iArr[26]);
            flatBufferBuilder.b(27, iArr[27]);
            flatBufferBuilder.b(28, iArr[28]);
            flatBufferBuilder.b(29, iArr[29]);
            flatBufferBuilder.b(30, iArr[30]);
            flatBufferBuilder.b(31, iArr[31]);
            flatBufferBuilder.b(32, iArr[32]);
            flatBufferBuilder.b(33, iArr[33]);
            flatBufferBuilder.b(34, iArr[34]);
            flatBufferBuilder.b(35, iArr[35]);
            flatBufferBuilder.b(36, iArr[36]);
            flatBufferBuilder.b(37, iArr[37]);
            flatBufferBuilder.b(38, iArr[38]);
            flatBufferBuilder.b(39, iArr[39]);
            flatBufferBuilder.b(40, iArr[40]);
            flatBufferBuilder.b(41, iArr[41]);
            if (zArr[1]) {
                flatBufferBuilder.a(42, zArr2[1]);
            }
            flatBufferBuilder.b(43, iArr[43]);
            flatBufferBuilder.b(44, iArr[44]);
            flatBufferBuilder.b(45, iArr[45]);
            flatBufferBuilder.b(46, iArr[46]);
            flatBufferBuilder.b(47, iArr[47]);
            flatBufferBuilder.b(48, iArr[48]);
            flatBufferBuilder.b(49, iArr[49]);
            return flatBufferBuilder.d();
        }

        public static void m16522a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("action_default_activated_submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("action_default_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("action_og_object");
                ActionOgObjectParser.m16563a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.m16569a(mutableFlatBuffer, g, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("can_share_photo");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("collection");
                CollectionParser.m16588a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("comment");
                CommentParser.m16608a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("component_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("composer_inline_activity");
                ComposerInlineActivityParser.m16536a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("connection_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 10));
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("display_style");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("entry_point");
                jsonGenerator.b(mutableFlatBuffer.b(i, 12));
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("event");
                EventParser.m16506a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("event_space");
                EventSpaceParser.m16538a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("existing_place_items");
                ReactionWeatherSettingsPlaceItemFragmentParser.m16625a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("friend");
                FriendParser.m16551a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 17) != 0) {
                jsonGenerator.a("full_address");
                jsonGenerator.b(mutableFlatBuffer.c(i, 17));
            }
            g = mutableFlatBuffer.g(i, 18);
            if (g != 0) {
                jsonGenerator.a("fundraiser");
                FundraiserParser.m16618a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 19);
            if (g != 0) {
                jsonGenerator.a("fundraiser_campaign");
                FundraiserCampaignParser.m16560a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 20);
            if (g != 0) {
                jsonGenerator.a("group");
                GroupParser.m16508a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 21) != 0) {
                jsonGenerator.a("guest_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 21));
            }
            g = mutableFlatBuffer.g(i, 22);
            if (g != 0) {
                jsonGenerator.a("location");
                DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 23);
            if (g != 0) {
                jsonGenerator.a("match_page");
                MatchPageParser.m16574a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 24) != 0) {
                jsonGenerator.a("nux_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 24));
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("page");
                PageParser.m16510a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 26) != 0) {
                jsonGenerator.a("phone_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 26));
            }
            if (mutableFlatBuffer.g(i, 27) != 0) {
                jsonGenerator.a("photo_source_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 27));
            }
            if (mutableFlatBuffer.g(i, 28) != 0) {
                jsonGenerator.a("place_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 28));
            }
            g = mutableFlatBuffer.g(i, 29);
            if (g != 0) {
                jsonGenerator.a("places_query_location_page");
                PlacesQueryLocationPageParser.m16566a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 30) != 0) {
                jsonGenerator.a("places_query_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 30));
            }
            if (mutableFlatBuffer.g(i, 31) != 0) {
                jsonGenerator.a("places_query_topic_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 31));
            }
            g = mutableFlatBuffer.g(i, 32);
            if (g != 0) {
                jsonGenerator.a("profile");
                ProfileParser.m16512a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 33) != 0) {
                jsonGenerator.a("profile_pic_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 33));
            }
            if (mutableFlatBuffer.g(i, 34) != 0) {
                jsonGenerator.a("query");
                jsonGenerator.b(mutableFlatBuffer.c(i, 34));
            }
            g = mutableFlatBuffer.g(i, 35);
            if (g != 0) {
                jsonGenerator.a("related_users");
                RelatedUsersParser.m16515a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 36);
            if (g != 0) {
                jsonGenerator.a("replacement_unit");
                ReplacementUnitParser.m16585a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 37);
            if (g != 0) {
                jsonGenerator.a("service");
                PageServiceItemParser.m11184b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 38) != 0) {
                jsonGenerator.a("settings_token_for_reload");
                jsonGenerator.b(mutableFlatBuffer.c(i, 38));
            }
            if (mutableFlatBuffer.g(i, 39) != 0) {
                jsonGenerator.a("source");
                jsonGenerator.b(mutableFlatBuffer.c(i, 39));
            }
            if (mutableFlatBuffer.g(i, 40) != 0) {
                jsonGenerator.a("source_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 40));
            }
            g = mutableFlatBuffer.g(i, 41);
            if (g != 0) {
                jsonGenerator.a("story");
                StoryParser.m16520a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 42);
            if (a) {
                jsonGenerator.a("subscribe_status");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 43) != 0) {
                jsonGenerator.a("suggestion_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 43));
            }
            g = mutableFlatBuffer.g(i, 44);
            if (g != 0) {
                jsonGenerator.a("target");
                ReactionEventInviteFieldsParser.m16545a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 45) != 0) {
                jsonGenerator.a("temperature_scale");
                jsonGenerator.b(mutableFlatBuffer.c(i, 45));
            }
            g = mutableFlatBuffer.g(i, 46);
            if (g != 0) {
                jsonGenerator.a("thread_key");
                ThreadKeyParser.m16591a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 47) != 0) {
                jsonGenerator.a("unit_type_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 47));
            }
            if (mutableFlatBuffer.g(i, 48) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 48));
            }
            g = mutableFlatBuffer.g(i, 49);
            if (g != 0) {
                jsonGenerator.a("video_channel");
                VideoChannelParser.m16577a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionAttachmentActionFragmentParser {
        public static int m16524b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[6];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("message")) {
                        iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[2] = PageParser.m16526a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("stories")) {
                        iArr[3] = StoriesParser.m16593a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("style_list")) {
                        iArr[4] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("url")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
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

        public static int m16523a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m16524b(jsonParser, flatBufferBuilder)));
                }
            }
            if (arrayList.isEmpty()) {
                return 0;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Integer) arrayList.get(i)).intValue();
            }
            return flatBufferBuilder.a(iArr, true);
        }

        public static void m16525b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("page");
                PageParser.m16527a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("stories");
                StoriesParser.m16594a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("style_list");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 4), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionCommerceActionFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class PageParser {
            public static int m16526a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
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

            public static void m16527a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16528a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("page")) {
                        iArr[0] = PageParser.m16526a(jsonParser, flatBufferBuilder);
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

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionComposerActionFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class ComposerInlineActivityParser {

            /* compiled from: ffec61fd63b7529c27a68fc607988607 */
            public final class ObjectParser {
                public static int m16529a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[4];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("id")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("name")) {
                                iArr[2] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("url")) {
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

                public static void m16530a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: ffec61fd63b7529c27a68fc607988607 */
            public final class TaggableActivityIconParser {

                /* compiled from: ffec61fd63b7529c27a68fc607988607 */
                public final class ImageParser {
                    public static int m16531a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("uri")) {
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

                    public static void m16532a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m16533a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("image")) {
                                iArr[0] = ImageParser.m16531a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m16534a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("image");
                        ImageParser.m16532a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m16535a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("object")) {
                            iArr[1] = ObjectParser.m16529a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("taggable_activity")) {
                            iArr[2] = MinutiaeTaggableActivityParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("taggable_activity_icon")) {
                            iArr[3] = TaggableActivityIconParser.m16533a(jsonParser, flatBufferBuilder);
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

            public static void m16536a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("object");
                    ObjectParser.m16530a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("taggable_activity");
                    MinutiaeTaggableActivityParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("taggable_activity_icon");
                    TaggableActivityIconParser.m16534a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class EventSpaceParser {
            public static int m16537a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("posted_item_privacy_scope")) {
                            iArr[2] = ComposerTargetDataPrivacyScopeFieldsParser.a(jsonParser, flatBufferBuilder);
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

            public static void m16538a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                int g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("posted_item_privacy_scope");
                    ComposerTargetDataPrivacyScopeFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16539a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("composer_inline_activity")) {
                        iArr[0] = ComposerInlineActivityParser.m16535a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("event_space")) {
                        iArr[1] = EventSpaceParser.m16537a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("source_text")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionEventInviteFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class EventViewerCapabilityParser {
            public static int m16540a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("is_viewer_admin")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, zArr2[0]);
                }
                return flatBufferBuilder.d();
            }

            public static void m16541a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("is_viewer_admin");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class ParentGroupParser {
            public static int m16542a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
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

            public static void m16543a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m16544a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("event_kind")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLEventPrivacyType.fromString(jsonParser.o()));
                    } else if (i.equals("event_viewer_capability")) {
                        iArr[1] = EventViewerCapabilityParser.m16540a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("parent_group")) {
                        iArr[3] = ParentGroupParser.m16542a(jsonParser, flatBufferBuilder);
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

        public static void m16545a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("event_kind");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("event_viewer_capability");
                EventViewerCapabilityParser.m16541a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("parent_group");
                ParentGroupParser.m16543a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionEventMessageOnlyFriendActionFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class EventParser {

            /* compiled from: ffec61fd63b7529c27a68fc607988607 */
            public final class EventPlaceParser {
                public static int m16546a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("name")) {
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

                public static void m16547a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m16548a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[5];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("event_place")) {
                            iArr[0] = EventPlaceParser.m16546a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("live_permalink_time_range_sentence")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("profile_picture")) {
                            iArr[4] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
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
                return flatBufferBuilder.d();
            }

            public static void m16549a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("event_place");
                    EventPlaceParser.m16547a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("live_permalink_time_range_sentence");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class FriendParser {
            public static int m16550a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
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

            public static void m16551a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16552a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action_default_message")) {
                        iArr[0] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("event")) {
                        iArr[1] = EventParser.m16548a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("friend")) {
                        iArr[2] = FriendParser.m16550a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionFundraiserActionFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class FundraiserCampaignParser {

            /* compiled from: ffec61fd63b7529c27a68fc607988607 */
            public final class FundraiserDetailedProgressTextParser {
                public static int m16553a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m16554a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("text");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: ffec61fd63b7529c27a68fc607988607 */
            public final class FundraiserForCharityTextParser {
                public static int m16555a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m16556a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("text");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: ffec61fd63b7529c27a68fc607988607 */
            public final class OwnerParser {
                public static int m16557a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("profile_picture")) {
                                iArr[1] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
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

                public static void m16558a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("profile_picture");
                        DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m16559a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[6];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("campaign_title")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("fundraiser_detailed_progress_text")) {
                            iArr[2] = FundraiserDetailedProgressTextParser.m16553a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("fundraiser_for_charity_text")) {
                            iArr[3] = FundraiserForCharityTextParser.m16555a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("owner")) {
                            iArr[5] = OwnerParser.m16557a(jsonParser, flatBufferBuilder);
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

            public static void m16560a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("campaign_title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                int g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("fundraiser_detailed_progress_text");
                    FundraiserDetailedProgressTextParser.m16554a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("fundraiser_for_charity_text");
                    FundraiserForCharityTextParser.m16556a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("owner");
                    OwnerParser.m16558a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16561a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("fundraiser_campaign")) {
                        iArr[0] = FundraiserCampaignParser.m16559a(jsonParser, flatBufferBuilder);
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

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionGenericOpenGraphObjectActionFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class ActionOgObjectParser {
            public static int m16562a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                boolean[] zArr = new boolean[2];
                boolean[] zArr2 = new boolean[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("can_viewer_share")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("has_viewer_saved")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("id")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("url")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(4);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, zArr2[0]);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, zArr2[1]);
                }
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                return flatBufferBuilder.d();
            }

            public static void m16563a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_share");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("has_viewer_saved");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16564a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action_og_object")) {
                        iArr[0] = ActionOgObjectParser.m16562a(jsonParser, flatBufferBuilder);
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

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionOpenNearbyPlacesActionFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class PlacesQueryLocationPageParser {
            public static int m16565a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
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

            public static void m16566a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16567a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("places_query_location_page")) {
                        iArr[0] = PlacesQueryLocationPageParser.m16565a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("places_query_text")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("places_query_topic_id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionOpenPageAlbumActionFragmentParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class AlbumParser {
            public static int m16568a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
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

            public static void m16569a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class PageParser {
            public static int m16570a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
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

            public static void m16571a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16572a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("album")) {
                        iArr[0] = AlbumParser.m16568a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[1] = PageParser.m16570a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionOpenPlaysActionFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class MatchPageParser {
            public static int m16573a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
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

            public static void m16574a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16575a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("match_page")) {
                        iArr[0] = MatchPageParser.m16573a(jsonParser, flatBufferBuilder);
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

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionOpenVideoChannelFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class VideoChannelParser {
            public static int m16576a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[9];
                boolean[] zArr = new boolean[4];
                boolean[] zArr2 = new boolean[2];
                int[] iArr2 = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("live_video_count")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("square_header_image")) {
                            iArr[3] = SquareHeaderImageParser.m19015a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video_channel_can_viewer_pin")) {
                            zArr[1] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("video_channel_is_viewer_pinned")) {
                            zArr[2] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("video_channel_max_new_count")) {
                            zArr[3] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("video_channel_subtitle")) {
                            iArr[7] = VideoChannelSubtitleParser.m19017a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video_channel_title")) {
                            iArr[8] = VideoChannelTitleParser.m19019a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                if (zArr[0]) {
                    flatBufferBuilder.a(2, iArr2[0], 0);
                }
                flatBufferBuilder.b(3, iArr[3]);
                if (zArr[1]) {
                    flatBufferBuilder.a(4, zArr2[0]);
                }
                if (zArr[2]) {
                    flatBufferBuilder.a(5, zArr2[1]);
                }
                if (zArr[3]) {
                    flatBufferBuilder.a(6, iArr2[1], 0);
                }
                flatBufferBuilder.b(7, iArr[7]);
                flatBufferBuilder.b(8, iArr[8]);
                return flatBufferBuilder.d();
            }

            public static void m16577a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                int a = mutableFlatBuffer.a(i, 2, 0);
                if (a != 0) {
                    jsonGenerator.a("live_video_count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 3);
                if (a != 0) {
                    jsonGenerator.a("square_header_image");
                    SquareHeaderImageParser.m19016a(mutableFlatBuffer, a, jsonGenerator);
                }
                boolean a2 = mutableFlatBuffer.a(i, 4);
                if (a2) {
                    jsonGenerator.a("video_channel_can_viewer_pin");
                    jsonGenerator.a(a2);
                }
                a2 = mutableFlatBuffer.a(i, 5);
                if (a2) {
                    jsonGenerator.a("video_channel_is_viewer_pinned");
                    jsonGenerator.a(a2);
                }
                a = mutableFlatBuffer.a(i, 6, 0);
                if (a != 0) {
                    jsonGenerator.a("video_channel_max_new_count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 7);
                if (a != 0) {
                    jsonGenerator.a("video_channel_subtitle");
                    VideoChannelSubtitleParser.m19018a(mutableFlatBuffer, a, jsonGenerator);
                }
                a = mutableFlatBuffer.g(i, 8);
                if (a != 0) {
                    jsonGenerator.a("video_channel_title");
                    VideoChannelTitleParser.m19020a(mutableFlatBuffer, a, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16578a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("video_channel")) {
                        iArr[0] = VideoChannelParser.m16576a(jsonParser, flatBufferBuilder);
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

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionReplacementUnitFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class ReplacementUnitParser {

            /* compiled from: ffec61fd63b7529c27a68fc607988607 */
            public final class ReactionUnitComponentsParser {

                /* compiled from: ffec61fd63b7529c27a68fc607988607 */
                public final class ActionParser {
                    public static int m16579a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("__type__")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                } else if (i.equals("action_style")) {
                                    iArr[1] = flatBufferBuilder.a(GraphQLReactionStoryActionStyle.fromString(jsonParser.o()));
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

                    public static void m16580a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("__type__");
                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("action_style");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m16582b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[9];
                    boolean[] zArr = new boolean[1];
                    int[] iArr2 = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("action")) {
                                iArr[1] = ActionParser.m16579a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("auto_execute_action_delay")) {
                                zArr[0] = true;
                                iArr2[0] = jsonParser.E();
                            } else if (i.equals("component_logical_path")) {
                                iArr[3] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("component_style")) {
                                iArr[4] = flatBufferBuilder.a(GraphQLReactionUnitComponentStyle.fromString(jsonParser.o()));
                            } else if (i.equals("component_tracking_data")) {
                                iArr[5] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("icon_image")) {
                                iArr[6] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("message")) {
                                iArr[7] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("sub_message")) {
                                iArr[8] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(9);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(2, iArr2[0], 0);
                    }
                    flatBufferBuilder.b(3, iArr[3]);
                    flatBufferBuilder.b(4, iArr[4]);
                    flatBufferBuilder.b(5, iArr[5]);
                    flatBufferBuilder.b(6, iArr[6]);
                    flatBufferBuilder.b(7, iArr[7]);
                    flatBufferBuilder.b(8, iArr[8]);
                    return flatBufferBuilder.d();
                }

                public static int m16581a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(m16582b(jsonParser, flatBufferBuilder)));
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return 0;
                    }
                    int[] iArr = new int[arrayList.size()];
                    for (int i = 0; i < arrayList.size(); i++) {
                        iArr[i] = ((Integer) arrayList.get(i)).intValue();
                    }
                    return flatBufferBuilder.a(iArr, true);
                }

                public static void m16583b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("action");
                        ActionParser.m16580a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.a(i, 2, 0);
                    if (g != 0) {
                        jsonGenerator.a("auto_execute_action_delay");
                        jsonGenerator.b(g);
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("component_logical_path");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                    }
                    if (mutableFlatBuffer.g(i, 4) != 0) {
                        jsonGenerator.a("component_style");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 4));
                    }
                    if (mutableFlatBuffer.g(i, 5) != 0) {
                        jsonGenerator.a("component_tracking_data");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                    }
                    g = mutableFlatBuffer.g(i, 6);
                    if (g != 0) {
                        jsonGenerator.a("icon_image");
                        ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 7);
                    if (g != 0) {
                        jsonGenerator.a("message");
                        DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 8);
                    if (g != 0) {
                        jsonGenerator.a("sub_message");
                        DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m16584a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[7];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("reaction_unit_components")) {
                            iArr[2] = ReactionUnitComponentsParser.m16581a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("settings_token")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("unit_score")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("unit_style")) {
                            iArr[5] = flatBufferBuilder.a(GraphQLReactionUnitStyle.fromString(jsonParser.o()));
                        } else if (i.equals("unit_type_token")) {
                            iArr[6] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                if (zArr[0]) {
                    flatBufferBuilder.a(4, iArr2[0], 0);
                }
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                return flatBufferBuilder.d();
            }

            public static void m16585a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                int g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("reaction_unit_components");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        ReactionUnitComponentsParser.m16583b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("settings_token");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                g = mutableFlatBuffer.a(i, 4, 0);
                if (g != 0) {
                    jsonGenerator.a("unit_score");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("unit_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 5));
                }
                if (mutableFlatBuffer.g(i, 6) != 0) {
                    jsonGenerator.a("unit_type_token");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16586a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("replacement_unit")) {
                        iArr[0] = ReplacementUnitParser.m16584a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("settings_token_for_reload")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionSeePageCommerceProductsFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class CollectionParser {
            public static int m16587a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
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

            public static void m16588a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16589a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("collection")) {
                        iArr[0] = CollectionParser.m16587a(jsonParser, flatBufferBuilder);
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

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionSendMessageAsPageFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class ThreadKeyParser {
            public static int m16590a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("other_user_id")) {
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

            public static void m16591a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("other_user_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16592a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("thread_key")) {
                        iArr[0] = ThreadKeyParser.m16590a(jsonParser, flatBufferBuilder);
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

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionStoriesActionFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class StoriesParser {
            public static int m16595b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("feedback")) {
                            iArr[0] = ReactionFeedbackFieldsParser.m14686a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static int m16593a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m16595b(jsonParser, flatBufferBuilder)));
                    }
                }
                if (arrayList.isEmpty()) {
                    return 0;
                }
                int[] iArr = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
                return flatBufferBuilder.a(iArr, true);
            }

            public static void m16594a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m16596b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m16596b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    ReactionFeedbackFieldsParser.m14687a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16597a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("stories")) {
                        iArr[0] = StoriesParser.m16593a(jsonParser, flatBufferBuilder);
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

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionStoryAttachmentActionCommonFragmentParser {
        public static int m16599b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[55];
            boolean[] zArr = new boolean[3];
            boolean[] zArr2 = new boolean[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("action_default_activated_message")) {
                        iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_default_activated_submessage")) {
                        iArr[2] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_default_icon")) {
                        iArr[3] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_default_message")) {
                        iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_default_submessage")) {
                        iArr[5] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_is_highlighted")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("action_og_object")) {
                        iArr[7] = ActionOgObjectParser.m16562a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_style")) {
                        iArr[8] = flatBufferBuilder.a(GraphQLReactionStoryActionStyle.fromString(jsonParser.o()));
                    } else if (i.equals("album")) {
                        iArr[9] = AlbumParser.m16568a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("can_share_photo")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("collection")) {
                        iArr[11] = CollectionParser.m16587a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("comment")) {
                        iArr[12] = CommentParser.m16607a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("component_id")) {
                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("composer_inline_activity")) {
                        iArr[14] = ComposerInlineActivityParser.m16535a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("connection_type")) {
                        iArr[15] = flatBufferBuilder.a(GraphQLFundraiserSupportersConnectionType.fromString(jsonParser.o()));
                    } else if (i.equals("display_style")) {
                        iArr[16] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("entry_point")) {
                        iArr[17] = flatBufferBuilder.a(GraphQLPhotosByCategoryEntryPoint.fromString(jsonParser.o()));
                    } else if (i.equals("event")) {
                        iArr[18] = EventParser.m16505a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("event_space")) {
                        iArr[19] = EventSpaceParser.m16537a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("existing_place_items")) {
                        iArr[20] = ReactionWeatherSettingsPlaceItemFragmentParser.m16626b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("friend")) {
                        iArr[21] = FriendParser.m16550a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("full_address")) {
                        iArr[22] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("fundraiser")) {
                        iArr[23] = FundraiserParser.m16617a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("fundraiser_campaign")) {
                        iArr[24] = FundraiserCampaignParser.m16559a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group")) {
                        iArr[25] = GroupParser.m16507a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("guest_status")) {
                        iArr[26] = flatBufferBuilder.a(GraphQLEventWatchStatus.fromString(jsonParser.o()));
                    } else if (i.equals("location")) {
                        iArr[27] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("match_page")) {
                        iArr[28] = MatchPageParser.m16573a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("nux_type")) {
                        iArr[29] = flatBufferBuilder.a(GraphQLNearbyFriendsNuxType.fromString(jsonParser.o()));
                    } else if (i.equals("page")) {
                        iArr[30] = PageParser.m16509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("phone_uri")) {
                        iArr[31] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("photo_source_type")) {
                        iArr[32] = flatBufferBuilder.a(GraphQLPagePhotoSourceType.fromString(jsonParser.o()));
                    } else if (i.equals("place_id")) {
                        iArr[33] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("places_query_location_page")) {
                        iArr[34] = PlacesQueryLocationPageParser.m16565a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("places_query_text")) {
                        iArr[35] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("places_query_topic_id")) {
                        iArr[36] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profile")) {
                        iArr[37] = ProfileParser.m16511a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_pic_uri")) {
                        iArr[38] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("query")) {
                        iArr[39] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("related_users")) {
                        iArr[40] = RelatedUsersParser.m16513a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("replacement_unit")) {
                        iArr[41] = ReplacementUnitParser.m16584a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("service")) {
                        iArr[42] = PageServiceItemParser.m11181a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("settings_token_for_reload")) {
                        iArr[43] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("source")) {
                        iArr[44] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("source_text")) {
                        iArr[45] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("story")) {
                        iArr[46] = StoryParser.m16519a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subscribe_status")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("suggestion_token")) {
                        iArr[48] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("target")) {
                        iArr[49] = ReactionEventInviteFieldsParser.m16544a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temperature_scale")) {
                        iArr[50] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("thread_key")) {
                        iArr[51] = ThreadKeyParser.m16590a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("unit_type_token")) {
                        iArr[52] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("url")) {
                        iArr[53] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("video_channel")) {
                        iArr[54] = VideoChannelParser.m16576a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(55);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            if (zArr[0]) {
                flatBufferBuilder.a(6, zArr2[0]);
            }
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            if (zArr[1]) {
                flatBufferBuilder.a(10, zArr2[1]);
            }
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
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
            flatBufferBuilder.b(25, iArr[25]);
            flatBufferBuilder.b(26, iArr[26]);
            flatBufferBuilder.b(27, iArr[27]);
            flatBufferBuilder.b(28, iArr[28]);
            flatBufferBuilder.b(29, iArr[29]);
            flatBufferBuilder.b(30, iArr[30]);
            flatBufferBuilder.b(31, iArr[31]);
            flatBufferBuilder.b(32, iArr[32]);
            flatBufferBuilder.b(33, iArr[33]);
            flatBufferBuilder.b(34, iArr[34]);
            flatBufferBuilder.b(35, iArr[35]);
            flatBufferBuilder.b(36, iArr[36]);
            flatBufferBuilder.b(37, iArr[37]);
            flatBufferBuilder.b(38, iArr[38]);
            flatBufferBuilder.b(39, iArr[39]);
            flatBufferBuilder.b(40, iArr[40]);
            flatBufferBuilder.b(41, iArr[41]);
            flatBufferBuilder.b(42, iArr[42]);
            flatBufferBuilder.b(43, iArr[43]);
            flatBufferBuilder.b(44, iArr[44]);
            flatBufferBuilder.b(45, iArr[45]);
            flatBufferBuilder.b(46, iArr[46]);
            if (zArr[2]) {
                flatBufferBuilder.a(47, zArr2[2]);
            }
            flatBufferBuilder.b(48, iArr[48]);
            flatBufferBuilder.b(49, iArr[49]);
            flatBufferBuilder.b(50, iArr[50]);
            flatBufferBuilder.b(51, iArr[51]);
            flatBufferBuilder.b(52, iArr[52]);
            flatBufferBuilder.b(53, iArr[53]);
            flatBufferBuilder.b(54, iArr[54]);
            return flatBufferBuilder.d();
        }

        public static int m16598a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m16599b(jsonParser, flatBufferBuilder)));
                }
            }
            if (arrayList.isEmpty()) {
                return 0;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Integer) arrayList.get(i)).intValue();
            }
            return flatBufferBuilder.a(iArr, true);
        }

        public static void m16600b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("action_default_activated_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("action_default_activated_submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("action_default_icon");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("action_default_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("action_default_submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("action_is_highlighted");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("action_og_object");
                ActionOgObjectParser.m16563a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("action_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 8));
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.m16569a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 10);
            if (a) {
                jsonGenerator.a("can_share_photo");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("collection");
                CollectionParser.m16588a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 12);
            if (g != 0) {
                jsonGenerator.a("comment");
                CommentParser.m16608a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("component_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("composer_inline_activity");
                ComposerInlineActivityParser.m16536a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 15) != 0) {
                jsonGenerator.a("connection_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 15));
            }
            if (mutableFlatBuffer.g(i, 16) != 0) {
                jsonGenerator.a("display_style");
                jsonGenerator.b(mutableFlatBuffer.c(i, 16));
            }
            if (mutableFlatBuffer.g(i, 17) != 0) {
                jsonGenerator.a("entry_point");
                jsonGenerator.b(mutableFlatBuffer.b(i, 17));
            }
            g = mutableFlatBuffer.g(i, 18);
            if (g != 0) {
                jsonGenerator.a("event");
                EventParser.m16506a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 19);
            if (g != 0) {
                jsonGenerator.a("event_space");
                EventSpaceParser.m16538a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 20);
            if (g != 0) {
                jsonGenerator.a("existing_place_items");
                ReactionWeatherSettingsPlaceItemFragmentParser.m16625a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 21);
            if (g != 0) {
                jsonGenerator.a("friend");
                FriendParser.m16551a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 22) != 0) {
                jsonGenerator.a("full_address");
                jsonGenerator.b(mutableFlatBuffer.c(i, 22));
            }
            g = mutableFlatBuffer.g(i, 23);
            if (g != 0) {
                jsonGenerator.a("fundraiser");
                FundraiserParser.m16618a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 24);
            if (g != 0) {
                jsonGenerator.a("fundraiser_campaign");
                FundraiserCampaignParser.m16560a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("group");
                GroupParser.m16508a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 26) != 0) {
                jsonGenerator.a("guest_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 26));
            }
            g = mutableFlatBuffer.g(i, 27);
            if (g != 0) {
                jsonGenerator.a("location");
                DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 28);
            if (g != 0) {
                jsonGenerator.a("match_page");
                MatchPageParser.m16574a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 29) != 0) {
                jsonGenerator.a("nux_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 29));
            }
            g = mutableFlatBuffer.g(i, 30);
            if (g != 0) {
                jsonGenerator.a("page");
                PageParser.m16510a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 31) != 0) {
                jsonGenerator.a("phone_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 31));
            }
            if (mutableFlatBuffer.g(i, 32) != 0) {
                jsonGenerator.a("photo_source_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 32));
            }
            if (mutableFlatBuffer.g(i, 33) != 0) {
                jsonGenerator.a("place_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 33));
            }
            g = mutableFlatBuffer.g(i, 34);
            if (g != 0) {
                jsonGenerator.a("places_query_location_page");
                PlacesQueryLocationPageParser.m16566a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 35) != 0) {
                jsonGenerator.a("places_query_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 35));
            }
            if (mutableFlatBuffer.g(i, 36) != 0) {
                jsonGenerator.a("places_query_topic_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 36));
            }
            g = mutableFlatBuffer.g(i, 37);
            if (g != 0) {
                jsonGenerator.a("profile");
                ProfileParser.m16512a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 38) != 0) {
                jsonGenerator.a("profile_pic_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 38));
            }
            if (mutableFlatBuffer.g(i, 39) != 0) {
                jsonGenerator.a("query");
                jsonGenerator.b(mutableFlatBuffer.c(i, 39));
            }
            g = mutableFlatBuffer.g(i, 40);
            if (g != 0) {
                jsonGenerator.a("related_users");
                RelatedUsersParser.m16515a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 41);
            if (g != 0) {
                jsonGenerator.a("replacement_unit");
                ReplacementUnitParser.m16585a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 42);
            if (g != 0) {
                jsonGenerator.a("service");
                PageServiceItemParser.m11184b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 43) != 0) {
                jsonGenerator.a("settings_token_for_reload");
                jsonGenerator.b(mutableFlatBuffer.c(i, 43));
            }
            if (mutableFlatBuffer.g(i, 44) != 0) {
                jsonGenerator.a("source");
                jsonGenerator.b(mutableFlatBuffer.c(i, 44));
            }
            if (mutableFlatBuffer.g(i, 45) != 0) {
                jsonGenerator.a("source_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 45));
            }
            g = mutableFlatBuffer.g(i, 46);
            if (g != 0) {
                jsonGenerator.a("story");
                StoryParser.m16520a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 47);
            if (a) {
                jsonGenerator.a("subscribe_status");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 48) != 0) {
                jsonGenerator.a("suggestion_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 48));
            }
            g = mutableFlatBuffer.g(i, 49);
            if (g != 0) {
                jsonGenerator.a("target");
                ReactionEventInviteFieldsParser.m16545a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 50) != 0) {
                jsonGenerator.a("temperature_scale");
                jsonGenerator.b(mutableFlatBuffer.c(i, 50));
            }
            g = mutableFlatBuffer.g(i, 51);
            if (g != 0) {
                jsonGenerator.a("thread_key");
                ThreadKeyParser.m16591a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 52) != 0) {
                jsonGenerator.a("unit_type_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 52));
            }
            if (mutableFlatBuffer.g(i, 53) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 53));
            }
            g = mutableFlatBuffer.g(i, 54);
            if (g != 0) {
                jsonGenerator.a("video_channel");
                VideoChannelParser.m16577a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionStoryAttachmentActionFragmentParser {
        public static int m16601a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[56];
            boolean[] zArr = new boolean[3];
            boolean[] zArr2 = new boolean[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("action_default_activated_message")) {
                        iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_default_activated_submessage")) {
                        iArr[2] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_default_icon")) {
                        iArr[3] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_default_message")) {
                        iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_default_submessage")) {
                        iArr[5] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_is_highlighted")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("action_og_object")) {
                        iArr[7] = ActionOgObjectParser.m16562a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_style")) {
                        iArr[8] = flatBufferBuilder.a(GraphQLReactionStoryActionStyle.fromString(jsonParser.o()));
                    } else if (i.equals("album")) {
                        iArr[9] = AlbumParser.m16568a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("can_share_photo")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("collection")) {
                        iArr[11] = CollectionParser.m16587a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("comment")) {
                        iArr[12] = CommentParser.m16607a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("component_id")) {
                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("composer_inline_activity")) {
                        iArr[14] = ComposerInlineActivityParser.m16535a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("connection_type")) {
                        iArr[15] = flatBufferBuilder.a(GraphQLFundraiserSupportersConnectionType.fromString(jsonParser.o()));
                    } else if (i.equals("display_style")) {
                        iArr[16] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("entry_point")) {
                        iArr[17] = flatBufferBuilder.a(GraphQLPhotosByCategoryEntryPoint.fromString(jsonParser.o()));
                    } else if (i.equals("event")) {
                        iArr[18] = EventParser.m16505a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("event_space")) {
                        iArr[19] = EventSpaceParser.m16537a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("existing_place_items")) {
                        iArr[20] = ReactionWeatherSettingsPlaceItemFragmentParser.m16626b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("friend")) {
                        iArr[21] = FriendParser.m16550a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("full_address")) {
                        iArr[22] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("fundraiser")) {
                        iArr[23] = FundraiserParser.m16617a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("fundraiser_campaign")) {
                        iArr[24] = FundraiserCampaignParser.m16559a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group")) {
                        iArr[25] = GroupParser.m16507a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("guest_status")) {
                        iArr[26] = flatBufferBuilder.a(GraphQLEventWatchStatus.fromString(jsonParser.o()));
                    } else if (i.equals("item_actions")) {
                        iArr[27] = ReactionStoryAttachmentActionCommonFragmentParser.m16598a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location")) {
                        iArr[28] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("match_page")) {
                        iArr[29] = MatchPageParser.m16573a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("nux_type")) {
                        iArr[30] = flatBufferBuilder.a(GraphQLNearbyFriendsNuxType.fromString(jsonParser.o()));
                    } else if (i.equals("page")) {
                        iArr[31] = PageParser.m16509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("phone_uri")) {
                        iArr[32] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("photo_source_type")) {
                        iArr[33] = flatBufferBuilder.a(GraphQLPagePhotoSourceType.fromString(jsonParser.o()));
                    } else if (i.equals("place_id")) {
                        iArr[34] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("places_query_location_page")) {
                        iArr[35] = PlacesQueryLocationPageParser.m16565a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("places_query_text")) {
                        iArr[36] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("places_query_topic_id")) {
                        iArr[37] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profile")) {
                        iArr[38] = ProfileParser.m16511a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_pic_uri")) {
                        iArr[39] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("query")) {
                        iArr[40] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("related_users")) {
                        iArr[41] = RelatedUsersParser.m16513a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("replacement_unit")) {
                        iArr[42] = ReplacementUnitParser.m16584a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("service")) {
                        iArr[43] = PageServiceItemParser.m11181a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("settings_token_for_reload")) {
                        iArr[44] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("source")) {
                        iArr[45] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("source_text")) {
                        iArr[46] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("story")) {
                        iArr[47] = StoryParser.m16519a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subscribe_status")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("suggestion_token")) {
                        iArr[49] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("target")) {
                        iArr[50] = ReactionEventInviteFieldsParser.m16544a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temperature_scale")) {
                        iArr[51] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("thread_key")) {
                        iArr[52] = ThreadKeyParser.m16590a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("unit_type_token")) {
                        iArr[53] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("url")) {
                        iArr[54] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("video_channel")) {
                        iArr[55] = VideoChannelParser.m16576a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(56);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            if (zArr[0]) {
                flatBufferBuilder.a(6, zArr2[0]);
            }
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            if (zArr[1]) {
                flatBufferBuilder.a(10, zArr2[1]);
            }
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
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
            flatBufferBuilder.b(25, iArr[25]);
            flatBufferBuilder.b(26, iArr[26]);
            flatBufferBuilder.b(27, iArr[27]);
            flatBufferBuilder.b(28, iArr[28]);
            flatBufferBuilder.b(29, iArr[29]);
            flatBufferBuilder.b(30, iArr[30]);
            flatBufferBuilder.b(31, iArr[31]);
            flatBufferBuilder.b(32, iArr[32]);
            flatBufferBuilder.b(33, iArr[33]);
            flatBufferBuilder.b(34, iArr[34]);
            flatBufferBuilder.b(35, iArr[35]);
            flatBufferBuilder.b(36, iArr[36]);
            flatBufferBuilder.b(37, iArr[37]);
            flatBufferBuilder.b(38, iArr[38]);
            flatBufferBuilder.b(39, iArr[39]);
            flatBufferBuilder.b(40, iArr[40]);
            flatBufferBuilder.b(41, iArr[41]);
            flatBufferBuilder.b(42, iArr[42]);
            flatBufferBuilder.b(43, iArr[43]);
            flatBufferBuilder.b(44, iArr[44]);
            flatBufferBuilder.b(45, iArr[45]);
            flatBufferBuilder.b(46, iArr[46]);
            flatBufferBuilder.b(47, iArr[47]);
            if (zArr[2]) {
                flatBufferBuilder.a(48, zArr2[2]);
            }
            flatBufferBuilder.b(49, iArr[49]);
            flatBufferBuilder.b(50, iArr[50]);
            flatBufferBuilder.b(51, iArr[51]);
            flatBufferBuilder.b(52, iArr[52]);
            flatBufferBuilder.b(53, iArr[53]);
            flatBufferBuilder.b(54, iArr[54]);
            flatBufferBuilder.b(55, iArr[55]);
            return flatBufferBuilder.d();
        }

        public static int m16603b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m16601a(jsonParser, flatBufferBuilder)));
                }
            }
            if (arrayList.isEmpty()) {
                return 0;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Integer) arrayList.get(i)).intValue();
            }
            return flatBufferBuilder.a(iArr, true);
        }

        public static void m16602a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m16604b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m16604b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("action_default_activated_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("action_default_activated_submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("action_default_icon");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("action_default_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("action_default_submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("action_is_highlighted");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("action_og_object");
                ActionOgObjectParser.m16563a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("action_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 8));
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.m16569a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 10);
            if (a) {
                jsonGenerator.a("can_share_photo");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("collection");
                CollectionParser.m16588a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 12);
            if (g != 0) {
                jsonGenerator.a("comment");
                CommentParser.m16608a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("component_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("composer_inline_activity");
                ComposerInlineActivityParser.m16536a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 15) != 0) {
                jsonGenerator.a("connection_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 15));
            }
            if (mutableFlatBuffer.g(i, 16) != 0) {
                jsonGenerator.a("display_style");
                jsonGenerator.b(mutableFlatBuffer.c(i, 16));
            }
            if (mutableFlatBuffer.g(i, 17) != 0) {
                jsonGenerator.a("entry_point");
                jsonGenerator.b(mutableFlatBuffer.b(i, 17));
            }
            g = mutableFlatBuffer.g(i, 18);
            if (g != 0) {
                jsonGenerator.a("event");
                EventParser.m16506a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 19);
            if (g != 0) {
                jsonGenerator.a("event_space");
                EventSpaceParser.m16538a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 20);
            if (g != 0) {
                jsonGenerator.a("existing_place_items");
                ReactionWeatherSettingsPlaceItemFragmentParser.m16625a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 21);
            if (g != 0) {
                jsonGenerator.a("friend");
                FriendParser.m16551a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 22) != 0) {
                jsonGenerator.a("full_address");
                jsonGenerator.b(mutableFlatBuffer.c(i, 22));
            }
            g = mutableFlatBuffer.g(i, 23);
            if (g != 0) {
                jsonGenerator.a("fundraiser");
                FundraiserParser.m16618a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 24);
            if (g != 0) {
                jsonGenerator.a("fundraiser_campaign");
                FundraiserCampaignParser.m16560a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("group");
                GroupParser.m16508a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 26) != 0) {
                jsonGenerator.a("guest_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 26));
            }
            g = mutableFlatBuffer.g(i, 27);
            if (g != 0) {
                jsonGenerator.a("item_actions");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    ReactionStoryAttachmentActionCommonFragmentParser.m16600b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 28);
            if (g != 0) {
                jsonGenerator.a("location");
                DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 29);
            if (g != 0) {
                jsonGenerator.a("match_page");
                MatchPageParser.m16574a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 30) != 0) {
                jsonGenerator.a("nux_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 30));
            }
            g = mutableFlatBuffer.g(i, 31);
            if (g != 0) {
                jsonGenerator.a("page");
                PageParser.m16510a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 32) != 0) {
                jsonGenerator.a("phone_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 32));
            }
            if (mutableFlatBuffer.g(i, 33) != 0) {
                jsonGenerator.a("photo_source_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 33));
            }
            if (mutableFlatBuffer.g(i, 34) != 0) {
                jsonGenerator.a("place_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 34));
            }
            g = mutableFlatBuffer.g(i, 35);
            if (g != 0) {
                jsonGenerator.a("places_query_location_page");
                PlacesQueryLocationPageParser.m16566a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 36) != 0) {
                jsonGenerator.a("places_query_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 36));
            }
            if (mutableFlatBuffer.g(i, 37) != 0) {
                jsonGenerator.a("places_query_topic_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 37));
            }
            g = mutableFlatBuffer.g(i, 38);
            if (g != 0) {
                jsonGenerator.a("profile");
                ProfileParser.m16512a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 39) != 0) {
                jsonGenerator.a("profile_pic_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 39));
            }
            if (mutableFlatBuffer.g(i, 40) != 0) {
                jsonGenerator.a("query");
                jsonGenerator.b(mutableFlatBuffer.c(i, 40));
            }
            g = mutableFlatBuffer.g(i, 41);
            if (g != 0) {
                jsonGenerator.a("related_users");
                RelatedUsersParser.m16515a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 42);
            if (g != 0) {
                jsonGenerator.a("replacement_unit");
                ReplacementUnitParser.m16585a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 43);
            if (g != 0) {
                jsonGenerator.a("service");
                PageServiceItemParser.m11184b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 44) != 0) {
                jsonGenerator.a("settings_token_for_reload");
                jsonGenerator.b(mutableFlatBuffer.c(i, 44));
            }
            if (mutableFlatBuffer.g(i, 45) != 0) {
                jsonGenerator.a("source");
                jsonGenerator.b(mutableFlatBuffer.c(i, 45));
            }
            if (mutableFlatBuffer.g(i, 46) != 0) {
                jsonGenerator.a("source_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 46));
            }
            g = mutableFlatBuffer.g(i, 47);
            if (g != 0) {
                jsonGenerator.a("story");
                StoryParser.m16520a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 48);
            if (a) {
                jsonGenerator.a("subscribe_status");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 49) != 0) {
                jsonGenerator.a("suggestion_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 49));
            }
            g = mutableFlatBuffer.g(i, 50);
            if (g != 0) {
                jsonGenerator.a("target");
                ReactionEventInviteFieldsParser.m16545a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 51) != 0) {
                jsonGenerator.a("temperature_scale");
                jsonGenerator.b(mutableFlatBuffer.c(i, 51));
            }
            g = mutableFlatBuffer.g(i, 52);
            if (g != 0) {
                jsonGenerator.a("thread_key");
                ThreadKeyParser.m16591a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 53) != 0) {
                jsonGenerator.a("unit_type_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 53));
            }
            if (mutableFlatBuffer.g(i, 54) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 54));
            }
            g = mutableFlatBuffer.g(i, 55);
            if (g != 0) {
                jsonGenerator.a("video_channel");
                VideoChannelParser.m16577a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionViewCommentActionFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class CommentParser {

            /* compiled from: ffec61fd63b7529c27a68fc607988607 */
            public final class CommentParentParser {
                public static int m16605a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("id")) {
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

                public static void m16606a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m16607a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("comment_parent")) {
                            iArr[0] = CommentParentParser.m16605a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
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

            public static void m16608a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("comment_parent");
                    CommentParentParser.m16606a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class StoryParser {
            public static int m16609a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("cache_id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("id")) {
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

            public static void m16610a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("cache_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16611a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("comment")) {
                        iArr[0] = CommentParser.m16607a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("story")) {
                        iArr[1] = StoryParser.m16609a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionViewEventGuestListActionFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class EventParser {

            /* compiled from: ffec61fd63b7529c27a68fc607988607 */
            public final class EventViewerCapabilityParser {
                public static int m16612a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    boolean[] zArr = new boolean[1];
                    boolean[] zArr2 = new boolean[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("is_viewer_admin")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, zArr2[0]);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m16613a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    boolean a = mutableFlatBuffer.a(i, 0);
                    if (a) {
                        jsonGenerator.a("is_viewer_admin");
                        jsonGenerator.a(a);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m16614a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[6];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("connection_style")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLConnectionStyle.fromString(jsonParser.o()));
                        } else if (i.equals("event_kind")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLEventPrivacyType.fromString(jsonParser.o()));
                        } else if (i.equals("event_viewer_capability")) {
                            iArr[2] = EventViewerCapabilityParser.m16612a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("viewer_guest_status")) {
                            iArr[5] = flatBufferBuilder.a(GraphQLEventGuestStatus.fromString(jsonParser.o()));
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

            public static void m16615a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("connection_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("event_kind");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                int g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("event_viewer_capability");
                    EventViewerCapabilityParser.m16613a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("viewer_guest_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 5));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16616a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("event")) {
                        iArr[0] = EventParser.m16614a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("guest_status")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLEventWatchStatus.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionViewFundraiserSupportersActionFieldsParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class FundraiserParser {
            public static int m16617a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
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

            public static void m16618a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16619a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("connection_type")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLFundraiserSupportersConnectionType.fromString(jsonParser.o()));
                    } else if (i.equals("fundraiser")) {
                        iArr[1] = FundraiserParser.m16617a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: ffec61fd63b7529c27a68fc607988607 */
    public final class ReactionWeatherSettingsPlaceItemFragmentParser {

        /* compiled from: ffec61fd63b7529c27a68fc607988607 */
        public final class ProfileParser {

            /* compiled from: ffec61fd63b7529c27a68fc607988607 */
            public final class ProfilePictureParser {
                public static int m16620a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("uri")) {
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

                public static void m16621a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m16622a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("profile_picture")) {
                            iArr[3] = ProfilePictureParser.m16620a(jsonParser, flatBufferBuilder);
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

            public static void m16623a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                int g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    ProfilePictureParser.m16621a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m16624a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("profile")) {
                        iArr[0] = ProfileParser.m16622a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static int m16626b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m16624a(jsonParser, flatBufferBuilder)));
                }
            }
            if (arrayList.isEmpty()) {
                return 0;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Integer) arrayList.get(i)).intValue();
            }
            return flatBufferBuilder.a(iArr, true);
        }

        public static void m16625a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m16627b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m16627b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("profile");
                ProfileParser.m16623a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }
}
