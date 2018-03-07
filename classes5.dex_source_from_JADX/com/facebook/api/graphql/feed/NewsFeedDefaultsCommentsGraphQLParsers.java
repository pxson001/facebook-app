package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.AttachmentPropertiesParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.SourceParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.StyleInfosParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.TargetParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsStoryAttachmentGraphQLParsers.StoryAttachmentFieldsParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsStoryAttachmentGraphQLParsers.StoryAttachmentFieldsParser.MediaParser;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.AppStoreApplicationFragmentParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultNameFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: app_center_cover_image */
public class NewsFeedDefaultsCommentsGraphQLParsers {

    /* compiled from: app_center_cover_image */
    public final class CommentFragmentWithoutFeedbackOrAttachmentParser {

        /* compiled from: app_center_cover_image */
        public final class AuthorParser {
            public static int m15827a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[8];
                boolean[] zArr = new boolean[3];
                boolean[] zArr2 = new boolean[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("is_viewer_coworker")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("is_viewer_friend")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("is_work_user")) {
                            zArr[2] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("name")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("profile_picture")) {
                            iArr[6] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("structured_name")) {
                            iArr[7] = DefaultNameFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                if (zArr[0]) {
                    flatBufferBuilder.a(2, zArr2[0]);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(3, zArr2[1]);
                }
                if (zArr[2]) {
                    flatBufferBuilder.a(4, zArr2[2]);
                }
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                flatBufferBuilder.b(7, iArr[7]);
                return flatBufferBuilder.d();
            }

            public static void m15828a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                boolean a = mutableFlatBuffer.a(i, 2);
                if (a) {
                    jsonGenerator.a("is_viewer_coworker");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 3);
                if (a) {
                    jsonGenerator.a("is_viewer_friend");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 4);
                if (a) {
                    jsonGenerator.a("is_work_user");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                int g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("structured_name");
                    DefaultNameFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_center_cover_image */
        public final class BodyMarkdownHtmlParser {
            public static int m15829a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15830a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_center_cover_image */
        public final class EditHistoryParser {
            public static int m15831a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15832a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m15833a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[12];
            boolean[] zArr = new boolean[6];
            boolean[] zArr2 = new boolean[5];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("author")) {
                        iArr[0] = AuthorParser.m15827a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("body")) {
                        iArr[1] = DefaultTextWithEntitiesLongFieldsParser.m9842a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("body_markdown_html")) {
                        iArr[2] = BodyMarkdownHtmlParser.m15829a(jsonParser, flatBufferBuilder);
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
                        iArr[6] = EditHistoryParser.m15831a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_featured")) {
                        zArr[3] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("is_marked_as_spam")) {
                        zArr[4] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("is_pinned")) {
                        zArr[5] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("translatability_for_viewer")) {
                        iArr[11] = TranslatabilityForViewerParser.m15841a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            if (zArr[0]) {
                flatBufferBuilder.a(3, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(4, zArr2[1]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(5, jArr[0], 0);
            }
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            if (zArr[3]) {
                flatBufferBuilder.a(8, zArr2[2]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(9, zArr2[3]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(10, zArr2[4]);
            }
            flatBufferBuilder.b(11, iArr[11]);
            return flatBufferBuilder.d();
        }

        public static void m15834a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("author");
                AuthorParser.m15828a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("body");
                DefaultTextWithEntitiesLongFieldsParser.m9844b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("body_markdown_html");
                BodyMarkdownHtmlParser.m15830a(mutableFlatBuffer, g, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 3);
            if (a) {
                jsonGenerator.a("can_viewer_delete");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 4);
            if (a) {
                jsonGenerator.a("can_viewer_edit");
                jsonGenerator.a(a);
            }
            long a2 = mutableFlatBuffer.a(i, 5, 0);
            if (a2 != 0) {
                jsonGenerator.a("created_time");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("edit_history");
                EditHistoryParser.m15832a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            a = mutableFlatBuffer.a(i, 8);
            if (a) {
                jsonGenerator.a("is_featured");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 9);
            if (a) {
                jsonGenerator.a("is_marked_as_spam");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 10);
            if (a) {
                jsonGenerator.a("is_pinned");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("translatability_for_viewer");
                TranslatabilityForViewerParser.m15842a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: app_center_cover_image */
    public final class CommentFragmentWithoutFeedbackParser {

        /* compiled from: app_center_cover_image */
        public final class AttachmentsParser {
            public static int m15837b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[16];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("action_links")) {
                            iArr[0] = NewsFeedDefaultsStoryActionLinkFieldsParser.m15378a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("associated_application")) {
                            iArr[1] = AppStoreApplicationFragmentParser.m3075a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("attachment_properties")) {
                            iArr[2] = AttachmentPropertiesParser.m15645a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("deduplication_key")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("description")) {
                            iArr[4] = DefaultTextWithEntitiesLongFieldsParser.m9842a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("media")) {
                            iArr[5] = MediaParser.m16136a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("media_reference_token")) {
                            iArr[6] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("source")) {
                            iArr[7] = SourceParser.m15649a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("style_infos")) {
                            iArr[8] = StyleInfosParser.m15651a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("style_list")) {
                            iArr[9] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("subattachments")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(StoryAttachmentFieldsParser.m16138b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr2 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr2, true);
                            }
                            iArr[10] = i2;
                        } else if (i.equals("subtitle")) {
                            iArr[11] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("target")) {
                            iArr[12] = TargetParser.m15665a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("title")) {
                            iArr[13] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("tracking")) {
                            iArr[14] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("url")) {
                            iArr[15] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(16);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
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
                return flatBufferBuilder.d();
            }

            public static int m15835a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m15837b(jsonParser, flatBufferBuilder)));
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

            public static void m15836a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m15838b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m15838b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("action_links");
                    NewsFeedDefaultsStoryActionLinkFieldsParser.m15379a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("associated_application");
                    AppStoreApplicationFragmentParser.m3076a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("attachment_properties");
                    AttachmentPropertiesParser.m15646a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("deduplication_key");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("description");
                    DefaultTextWithEntitiesLongFieldsParser.m9844b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("media");
                    MediaParser.m16137a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 6) != 0) {
                    jsonGenerator.a("media_reference_token");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("source");
                    SourceParser.m15650a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 8);
                if (g != 0) {
                    jsonGenerator.a("style_infos");
                    StyleInfosParser.m15652a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 9), jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("subattachments");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        StoryAttachmentFieldsParser.m16139b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                if (mutableFlatBuffer.g(i, 11) != 0) {
                    jsonGenerator.a("subtitle");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 11));
                }
                g = mutableFlatBuffer.g(i, 12);
                if (g != 0) {
                    jsonGenerator.a("target");
                    TargetParser.m15666a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 13) != 0) {
                    jsonGenerator.a("title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 13));
                }
                if (mutableFlatBuffer.g(i, 14) != 0) {
                    jsonGenerator.a("tracking");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 14));
                }
                if (mutableFlatBuffer.g(i, 15) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 15));
                }
                jsonGenerator.g();
            }
        }

        public static int m15839a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[13];
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
                    } else if (i.equals("id")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_featured")) {
                        zArr[3] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("is_marked_as_spam")) {
                        zArr[4] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("is_pinned")) {
                        zArr[5] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("translatability_for_viewer")) {
                        iArr[12] = TranslatabilityForViewerParser.m15841a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(13);
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
            if (zArr[3]) {
                flatBufferBuilder.a(9, zArr2[2]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(10, zArr2[3]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(11, zArr2[4]);
            }
            flatBufferBuilder.b(12, iArr[12]);
            return flatBufferBuilder.d();
        }

        public static void m15840a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            a = mutableFlatBuffer.a(i, 9);
            if (a) {
                jsonGenerator.a("is_featured");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 10);
            if (a) {
                jsonGenerator.a("is_marked_as_spam");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 11);
            if (a) {
                jsonGenerator.a("is_pinned");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 12);
            if (g != 0) {
                jsonGenerator.a("translatability_for_viewer");
                TranslatabilityForViewerParser.m15842a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: app_center_cover_image */
    public final class CommentTranslatabilityFragmentParser {

        /* compiled from: app_center_cover_image */
        public final class TranslatabilityForViewerParser {
            public static int m15841a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("translation_type")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLTranslatabilityType.fromString(jsonParser.o()));
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m15842a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("translation_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15843a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("translatability_for_viewer")) {
                        iArr[0] = TranslatabilityForViewerParser.m15841a(jsonParser, flatBufferBuilder);
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
}
