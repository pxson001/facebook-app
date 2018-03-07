package com.facebook.api.graphql.fetchcomments;

import com.facebook.api.graphql.comments.NewsFeedCommentsGraphQLParsers.TopLevelCommentsConnectionFragmentParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentFragmentWithoutFeedbackOrAttachmentParser.AuthorParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentFragmentWithoutFeedbackOrAttachmentParser.BodyMarkdownHtmlParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentFragmentWithoutFeedbackOrAttachmentParser.EditHistoryParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentFragmentWithoutFeedbackParser.AttachmentsParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentTranslatabilityFragmentParser.TranslatabilityForViewerParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.SimpleReactionsFeedbackFieldsParser.ReactorsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsFeedbackFieldsParser.SupportedReactionsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsSocialFeedbackFieldsParser.ImportantReactorsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsSocialFeedbackFieldsParser.ViewerActsAsPersonParser;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesWithRangesFieldsParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: animationSpeed */
public class FetchSingleCommentGraphQLParsers {

    /* compiled from: animationSpeed */
    public final class FetchSingleCommentQueryParser {

        /* compiled from: animationSpeed */
        public final class FeedbackParser {

            /* compiled from: animationSpeed */
            public final class LikersParser {
                public static int m16487a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m16488a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: animationSpeed */
            public final class SeenByParser {
                public static int m16489a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m16490a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: animationSpeed */
            public final class ViewerActsAsPageParser {
                public static int m16491a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                iArr[2] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
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

                public static void m16492a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                        DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m16493a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[30];
                boolean[] zArr = new boolean[13];
                boolean[] zArr2 = new boolean[12];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("can_see_voice_switcher")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("can_viewer_comment")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("can_viewer_comment_with_photo")) {
                            zArr[2] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("can_viewer_comment_with_sticker")) {
                            zArr[3] = true;
                            zArr2[3] = jsonParser.H();
                        } else if (i.equals("can_viewer_comment_with_video")) {
                            zArr[4] = true;
                            zArr2[4] = jsonParser.H();
                        } else if (i.equals("can_viewer_like")) {
                            zArr[5] = true;
                            zArr2[5] = jsonParser.H();
                        } else if (i.equals("can_viewer_react")) {
                            zArr[6] = true;
                            zArr2[6] = jsonParser.H();
                        } else if (i.equals("can_viewer_subscribe")) {
                            zArr[7] = true;
                            zArr2[7] = jsonParser.H();
                        } else if (i.equals("comments_disabled_notice")) {
                            iArr[8] = DefaultTextWithEntitiesLongFieldsParser.m9842a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("comments_mirroring_domain")) {
                            iArr[9] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("display_reactions")) {
                            zArr[8] = true;
                            zArr2[8] = jsonParser.H();
                        } else if (i.equals("does_viewer_like")) {
                            zArr[9] = true;
                            zArr2[9] = jsonParser.H();
                        } else if (i.equals("have_comments_been_disabled")) {
                            zArr[10] = true;
                            zArr2[10] = jsonParser.H();
                        } else if (i.equals("id")) {
                            iArr[13] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("important_reactors")) {
                            iArr[14] = ImportantReactorsParser.m17181a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("is_viewer_subscribed")) {
                            zArr[11] = true;
                            zArr2[11] = jsonParser.H();
                        } else if (i.equals("legacy_api_post_id")) {
                            iArr[16] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("like_sentence")) {
                            iArr[17] = DefaultTextWithEntitiesWithRangesFieldsParser.m3144a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("likers")) {
                            iArr[18] = LikersParser.m16487a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("reactors")) {
                            iArr[19] = ReactorsParser.m17162a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("remixable_photo_uri")) {
                            iArr[20] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("seen_by")) {
                            iArr[21] = SeenByParser.m16489a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("supported_reactions")) {
                            iArr[22] = SupportedReactionsParser.m17165a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("top_level_comments")) {
                            iArr[23] = TopLevelCommentsConnectionFragmentParser.m15680a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("top_reactions")) {
                            iArr[24] = TopReactionsParser.m17159a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("viewer_acts_as_page")) {
                            iArr[25] = ViewerActsAsPageParser.m16491a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("viewer_acts_as_person")) {
                            iArr[26] = ViewerActsAsPersonParser.m17183a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("viewer_does_not_like_sentence")) {
                            iArr[27] = DefaultTextWithEntitiesWithRangesFieldsParser.m3144a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("viewer_feedback_reaction_key")) {
                            zArr[12] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("viewer_likes_sentence")) {
                            iArr[29] = DefaultTextWithEntitiesWithRangesFieldsParser.m3144a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(30);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, zArr2[0]);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, zArr2[1]);
                }
                if (zArr[2]) {
                    flatBufferBuilder.a(2, zArr2[2]);
                }
                if (zArr[3]) {
                    flatBufferBuilder.a(3, zArr2[3]);
                }
                if (zArr[4]) {
                    flatBufferBuilder.a(4, zArr2[4]);
                }
                if (zArr[5]) {
                    flatBufferBuilder.a(5, zArr2[5]);
                }
                if (zArr[6]) {
                    flatBufferBuilder.a(6, zArr2[6]);
                }
                if (zArr[7]) {
                    flatBufferBuilder.a(7, zArr2[7]);
                }
                flatBufferBuilder.b(8, iArr[8]);
                flatBufferBuilder.b(9, iArr[9]);
                if (zArr[8]) {
                    flatBufferBuilder.a(10, zArr2[8]);
                }
                if (zArr[9]) {
                    flatBufferBuilder.a(11, zArr2[9]);
                }
                if (zArr[10]) {
                    flatBufferBuilder.a(12, zArr2[10]);
                }
                flatBufferBuilder.b(13, iArr[13]);
                flatBufferBuilder.b(14, iArr[14]);
                if (zArr[11]) {
                    flatBufferBuilder.a(15, zArr2[11]);
                }
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
                if (zArr[12]) {
                    flatBufferBuilder.a(28, iArr2[0], 0);
                }
                flatBufferBuilder.b(29, iArr[29]);
                return flatBufferBuilder.d();
            }

            public static void m16494a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("can_see_voice_switcher");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("can_viewer_comment");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 2);
                if (a) {
                    jsonGenerator.a("can_viewer_comment_with_photo");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 3);
                if (a) {
                    jsonGenerator.a("can_viewer_comment_with_sticker");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 4);
                if (a) {
                    jsonGenerator.a("can_viewer_comment_with_video");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 5);
                if (a) {
                    jsonGenerator.a("can_viewer_like");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 6);
                if (a) {
                    jsonGenerator.a("can_viewer_react");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 7);
                if (a) {
                    jsonGenerator.a("can_viewer_subscribe");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(i, 8);
                if (g != 0) {
                    jsonGenerator.a("comments_disabled_notice");
                    DefaultTextWithEntitiesLongFieldsParser.m9844b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("comments_mirroring_domain");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                }
                a = mutableFlatBuffer.a(i, 10);
                if (a) {
                    jsonGenerator.a("display_reactions");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 11);
                if (a) {
                    jsonGenerator.a("does_viewer_like");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 12);
                if (a) {
                    jsonGenerator.a("have_comments_been_disabled");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 13) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 13));
                }
                g = mutableFlatBuffer.g(i, 14);
                if (g != 0) {
                    jsonGenerator.a("important_reactors");
                    ImportantReactorsParser.m17182a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.a(i, 15);
                if (a) {
                    jsonGenerator.a("is_viewer_subscribed");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 16) != 0) {
                    jsonGenerator.a("legacy_api_post_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 16));
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("like_sentence");
                    DefaultTextWithEntitiesWithRangesFieldsParser.m3145a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 18);
                if (g != 0) {
                    jsonGenerator.a("likers");
                    LikersParser.m16488a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 19);
                if (g != 0) {
                    jsonGenerator.a("reactors");
                    ReactorsParser.m17163a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 20) != 0) {
                    jsonGenerator.a("remixable_photo_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 20));
                }
                g = mutableFlatBuffer.g(i, 21);
                if (g != 0) {
                    jsonGenerator.a("seen_by");
                    SeenByParser.m16490a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 22);
                if (g != 0) {
                    jsonGenerator.a("supported_reactions");
                    SupportedReactionsParser.m17167a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 23);
                if (g != 0) {
                    jsonGenerator.a("top_level_comments");
                    TopLevelCommentsConnectionFragmentParser.m15681a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 24);
                if (g != 0) {
                    jsonGenerator.a("top_reactions");
                    TopReactionsParser.m17160a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 25);
                if (g != 0) {
                    jsonGenerator.a("viewer_acts_as_page");
                    ViewerActsAsPageParser.m16492a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 26);
                if (g != 0) {
                    jsonGenerator.a("viewer_acts_as_person");
                    ViewerActsAsPersonParser.m17184a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 27);
                if (g != 0) {
                    jsonGenerator.a("viewer_does_not_like_sentence");
                    DefaultTextWithEntitiesWithRangesFieldsParser.m3145a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 28, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer_feedback_reaction_key");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 29);
                if (g != 0) {
                    jsonGenerator.a("viewer_likes_sentence");
                    DefaultTextWithEntitiesWithRangesFieldsParser.m3145a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: animationSpeed */
        public final class PermalinkTitleParser {

            /* compiled from: animationSpeed */
            public final class RangesParser {

                /* compiled from: animationSpeed */
                public final class EntityParser {
                    public static int m16495a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("__type__")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
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

                    public static void m16496a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("__type__");
                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m16497b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
                    boolean[] zArr = new boolean[2];
                    int[] iArr2 = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("entity")) {
                                iArr[0] = EntityParser.m16495a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("length")) {
                                zArr[0] = true;
                                iArr2[0] = jsonParser.E();
                            } else if (i.equals("offset")) {
                                zArr[1] = true;
                                iArr2[1] = jsonParser.E();
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, iArr[0]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(1, iArr2[0], 0);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(2, iArr2[1], 0);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m16498b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("entity");
                        EntityParser.m16496a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.a(i, 1, 0);
                    if (g != 0) {
                        jsonGenerator.a("length");
                        jsonGenerator.b(g);
                    }
                    g = mutableFlatBuffer.a(i, 2, 0);
                    if (g != 0) {
                        jsonGenerator.a("offset");
                        jsonGenerator.b(g);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m16499a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("ranges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(RangesParser.m16497b(jsonParser, flatBufferBuilder)));
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

            public static void m16500a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("ranges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        RangesParser.m16498b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static int m16501a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[15];
            boolean[] zArr = new boolean[6];
            boolean[] zArr2 = new boolean[5];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("attachments")) {
                        iArr[0] = AttachmentsParser.m15835a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("author")) {
                        iArr[1] = AuthorParser.m15827a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("body")) {
                        iArr[2] = DefaultTextWithEntitiesLongFieldsParser.m9842a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("body_markdown_html")) {
                        iArr[3] = BodyMarkdownHtmlParser.m15829a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("can_viewer_delete")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_viewer_edit")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("created_time")) {
                        zArr[2] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("edit_history")) {
                        iArr[7] = EditHistoryParser.m15831a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback")) {
                        iArr[8] = FeedbackParser.m16493a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_featured")) {
                        zArr[3] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("is_marked_as_spam")) {
                        zArr[4] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("is_pinned")) {
                        zArr[5] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("permalink_title")) {
                        iArr[13] = PermalinkTitleParser.m16499a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("translatability_for_viewer")) {
                        iArr[14] = TranslatabilityForViewerParser.m15841a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            if (zArr[0]) {
                flatBufferBuilder.a(4, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(5, zArr2[1]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(6, jArr[0], 0);
            }
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            if (zArr[3]) {
                flatBufferBuilder.a(10, zArr2[2]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(11, zArr2[3]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(12, zArr2[4]);
            }
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            return flatBufferBuilder.d();
        }

        public static void m16502a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("attachments");
                AttachmentsParser.m15836a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("author");
                AuthorParser.m15828a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("body");
                DefaultTextWithEntitiesLongFieldsParser.m9844b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("body_markdown_html");
                BodyMarkdownHtmlParser.m15830a(mutableFlatBuffer, g, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 4);
            if (a) {
                jsonGenerator.a("can_viewer_delete");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("can_viewer_edit");
                jsonGenerator.a(a);
            }
            long a2 = mutableFlatBuffer.a(i, 6, 0);
            if (a2 != 0) {
                jsonGenerator.a("created_time");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("edit_history");
                EditHistoryParser.m15832a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("feedback");
                FeedbackParser.m16494a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            a = mutableFlatBuffer.a(i, 10);
            if (a) {
                jsonGenerator.a("is_featured");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 11);
            if (a) {
                jsonGenerator.a("is_marked_as_spam");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 12);
            if (a) {
                jsonGenerator.a("is_pinned");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("permalink_title");
                PermalinkTitleParser.m16500a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("translatability_for_viewer");
                TranslatabilityForViewerParser.m15842a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }
}
