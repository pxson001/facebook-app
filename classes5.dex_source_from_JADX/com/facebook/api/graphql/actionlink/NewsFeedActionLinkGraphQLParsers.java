package com.facebook.api.graphql.actionlink;

import com.facebook.api.graphql.privacyoptions.NewsFeedPrivacyOptionsGraphQLParsers.PrivacyOptionsFieldsParser;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLParsers.DefaultSavableObjectExtraFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.EventAttachmentParser.EventCoverPhotoParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedDefaultsEventPlaceFieldsParser;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.FBFullImageFragmentParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLGroupCreationSuggestionType;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLLeadGenContextPageContentStyle;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputDomain;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputType;
import com.facebook.graphql.enums.GraphQLLeadGenPrivacyType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.enums.GraphQLPageOutcomeButtonRenderType;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultIconFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntityRangesFieldsParser.RangesParser;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLParsers.ImageOverlayFieldsParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewBasicFieldsParser.ValueParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.SelectedPrivacyOptionFieldsParser;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.UserReviewsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: app_settings */
public class NewsFeedActionLinkGraphQLParsers {

    /* compiled from: app_settings */
    public final class EditReviewActionLinkFieldsParser {

        /* compiled from: app_settings */
        public final class ReviewParser {

            /* compiled from: app_settings */
            public final class RepresentedProfileParser {
                public static int m15291a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
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

                public static void m15292a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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
                    jsonGenerator.g();
                }
            }

            public static int m15293a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[5];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("page_rating")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("privacy_scope")) {
                            iArr[2] = SelectedPrivacyOptionFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("represented_profile")) {
                            iArr[3] = RepresentedProfileParser.m15291a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("value")) {
                            iArr[4] = ValueParser.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, iArr2[0], 0);
                }
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                return flatBufferBuilder.d();
            }
        }

        public static MutableFlatBuffer m15294a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("review")) {
                        iArr[0] = ReviewParser.m15293a(jsonParser, flatBufferBuilder);
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

    /* compiled from: app_settings */
    public final class EventCreateActionLinkFieldsParser {

        /* compiled from: app_settings */
        public final class TemporalEventInfoParser {

            /* compiled from: app_settings */
            public final class ThemeParser {

                /* compiled from: app_settings */
                public final class HiResThemeImageParser {
                    public static int m15295a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m15296a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: app_settings */
                public final class LowResThemeImageParser {
                    public static int m15297a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m15298a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: app_settings */
                public final class MedResThemeImageParser {
                    public static int m15299a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m15300a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m15301a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[4];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("hi_res_theme_image")) {
                                iArr[0] = HiResThemeImageParser.m15295a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("id")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("low_res_theme_image")) {
                                iArr[2] = LowResThemeImageParser.m15297a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("med_res_theme_image")) {
                                iArr[3] = MedResThemeImageParser.m15299a(jsonParser, flatBufferBuilder);
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

                public static void m15302a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("hi_res_theme_image");
                        HiResThemeImageParser.m15296a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    g = mutableFlatBuffer.g(i, 2);
                    if (g != 0) {
                        jsonGenerator.a("low_res_theme_image");
                        LowResThemeImageParser.m15298a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 3);
                    if (g != 0) {
                        jsonGenerator.a("med_res_theme_image");
                        MedResThemeImageParser.m15300a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15303a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[1];
                long[] jArr = new long[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("start_time")) {
                            zArr[0] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("theme")) {
                            iArr[1] = ThemeParser.m15301a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("title")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, jArr[0], 0);
                }
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static void m15304a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                long a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("start_time");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("theme");
                    ThemeParser.m15302a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15305a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("temporal_event_info")) {
                        iArr[0] = TemporalEventInfoParser.m15303a(jsonParser, flatBufferBuilder);
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

    /* compiled from: app_settings */
    public final class GroupToggleCommentingActionLinkFieldsParser {

        /* compiled from: app_settings */
        public final class FeedbackParser {
            public static int m15306a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                boolean[] zArr = new boolean[2];
                boolean[] zArr2 = new boolean[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("can_viewer_comment")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("have_comments_been_disabled")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("id")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("legacy_api_post_id")) {
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

            public static void m15307a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_comment");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("have_comments_been_disabled");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("legacy_api_post_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15308a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("feedback")) {
                        iArr[0] = FeedbackParser.m15306a(jsonParser, flatBufferBuilder);
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

    /* compiled from: app_settings */
    public final class LeadGenActionLinkFieldsFragParser {

        /* compiled from: app_settings */
        public final class ErrorCodesParser {
            public static int m15312b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("error_text")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("input_type")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLLeadGenInfoFieldInputType.fromString(jsonParser.o()));
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

            public static int m15309a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m15312b(jsonParser, flatBufferBuilder)));
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

            public static void m15311a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m15310a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }

            public static void m15310a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("error_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("input_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class LeadGenDataParser {

            /* compiled from: app_settings */
            public final class PagesParser {

                /* compiled from: app_settings */
                public final class PrivacyDataParser {
                    public static int m15314b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("privacy_text")) {
                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("privacy_type")) {
                                    iArr[1] = flatBufferBuilder.a(GraphQLLeadGenPrivacyType.fromString(jsonParser.o()));
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

                    public static void m15313a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("privacy_text");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("privacy_type");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m15316b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("info_fields")) {
                                iArr[0] = LeadGenDefaultInfoFieldsParser.m15337a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("privacy_data")) {
                                int i2 = 0;
                                ArrayList arrayList = new ArrayList();
                                if (jsonParser.g() == JsonToken.START_ARRAY) {
                                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                                        arrayList.add(Integer.valueOf(PrivacyDataParser.m15314b(jsonParser, flatBufferBuilder)));
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    int[] iArr2 = new int[arrayList.size()];
                                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                        iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                    }
                                    i2 = flatBufferBuilder.a(iArr2, true);
                                }
                                iArr[1] = i2;
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

                public static int m15315a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(m15316b(jsonParser, flatBufferBuilder)));
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
            }

            public static int m15317a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[9];
                boolean[] zArr = new boolean[2];
                boolean[] zArr2 = new boolean[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("context_page")) {
                            iArr[0] = LeadGenContextPageFieldsParser.m15333a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("follow_up_title")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("info_fields_data")) {
                            iArr[2] = LeadGenDefaultInfoFieldsParser.m15337a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("legal_content")) {
                            iArr[3] = LeadGenLegalContentFieldsParser.m15352a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("need_split_flow")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("pages")) {
                            iArr[5] = PagesParser.m15315a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("policy_url")) {
                            iArr[6] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("split_flow_request_method")) {
                            iArr[7] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("split_flow_use_post")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
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
                if (zArr[0]) {
                    flatBufferBuilder.a(4, zArr2[0]);
                }
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                flatBufferBuilder.b(7, iArr[7]);
                if (zArr[1]) {
                    flatBufferBuilder.a(8, zArr2[1]);
                }
                return flatBufferBuilder.d();
            }

            public static void m15318a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("context_page");
                    LeadGenContextPageFieldsParser.m15334a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("follow_up_title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("info_fields_data");
                    LeadGenDefaultInfoFieldsParser.m15339a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("legal_content");
                    LeadGenLegalContentFieldsParser.m15353a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(i, 4);
                if (a) {
                    jsonGenerator.a("need_split_flow");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("pages");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        UserReviewsParser.b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                if (mutableFlatBuffer.g(i, 6) != 0) {
                    jsonGenerator.a("policy_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                }
                if (mutableFlatBuffer.g(i, 7) != 0) {
                    jsonGenerator.a("split_flow_request_method");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                }
                a = mutableFlatBuffer.a(i, 8);
                if (a) {
                    jsonGenerator.a("split_flow_use_post");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class LeadGenUserStatusParser {
            public static int m15319a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("has_shared_info")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("signed_request")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, zArr2[0]);
                }
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static void m15320a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("has_shared_info");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("signed_request");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class PageParser {

            /* compiled from: app_settings */
            public final class CoverPhotoParser {

                /* compiled from: app_settings */
                public final class PhotoParser {
                    public static int m15321a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("image")) {
                                    iArr[0] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m15322a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("image");
                            DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m15323a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("photo")) {
                                iArr[0] = PhotoParser.m15321a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m15324a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("photo");
                        PhotoParser.m15322a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15325a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("cover_photo")) {
                            iArr[0] = CoverPhotoParser.m15323a(jsonParser, flatBufferBuilder);
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

            public static void m15326a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m15324a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m15327a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[37];
            boolean[] zArr = new boolean[3];
            boolean[] zArr2 = new boolean[1];
            int[] iArr2 = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("ad_id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("agree_to_privacy_text")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("android_minimal_screen_form_height")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("android_small_screen_phone_threshold")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("disclaimer_accept_button_text")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("disclaimer_continue_button_text")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("error_codes")) {
                        iArr[6] = ErrorCodesParser.m15309a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("error_message_brief")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("error_message_detail")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("fb_data_policy_setting_description")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("fb_data_policy_url")) {
                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("follow_up_action_text")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("follow_up_action_url")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("landing_page_cta")) {
                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("landing_page_redirect_instruction")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("lead_gen_data")) {
                        iArr[15] = LeadGenDataParser.m15317a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("lead_gen_data_id")) {
                        iArr[16] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("lead_gen_deep_link_user_status")) {
                        iArr[17] = LeadGenDeepLinkUserStatusFieldsParser.m15335a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("lead_gen_user_status")) {
                        iArr[18] = LeadGenUserStatusParser.m15319a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("nux_description")) {
                        iArr[19] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("nux_title")) {
                        iArr[20] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("page")) {
                        iArr[21] = PageParser.m15325a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("primary_button_text")) {
                        iArr[22] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("privacy_checkbox_error")) {
                        iArr[23] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("privacy_setting_description")) {
                        iArr[24] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("progress_text")) {
                        iArr[25] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("secure_sharing_text")) {
                        iArr[26] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("select_text_hint")) {
                        iArr[27] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("send_description")) {
                        iArr[28] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sent_text")) {
                        iArr[29] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("share_id")) {
                        iArr[30] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("short_secure_sharing_text")) {
                        iArr[31] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("skip_experiments")) {
                        zArr[2] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("split_flow_landing_page_hint_text")) {
                        iArr[33] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("split_flow_landing_page_hint_title")) {
                        iArr[34] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("submit_card_instruction_text")) {
                        iArr[35] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("unsubscribe_description")) {
                        iArr[36] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(37);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, iArr2[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(3, iArr2[1], 0);
            }
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
            if (zArr[2]) {
                flatBufferBuilder.a(32, zArr2[0]);
            }
            flatBufferBuilder.b(33, iArr[33]);
            flatBufferBuilder.b(34, iArr[34]);
            flatBufferBuilder.b(35, iArr[35]);
            flatBufferBuilder.b(36, iArr[36]);
            return flatBufferBuilder.d();
        }

        public static void m15328a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("ad_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("agree_to_privacy_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            int a = mutableFlatBuffer.a(i, 2, 0);
            if (a != 0) {
                jsonGenerator.a("android_minimal_screen_form_height");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.a(i, 3, 0);
            if (a != 0) {
                jsonGenerator.a("android_small_screen_phone_threshold");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("disclaimer_accept_button_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("disclaimer_continue_button_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            a = mutableFlatBuffer.g(i, 6);
            if (a != 0) {
                jsonGenerator.a("error_codes");
                ErrorCodesParser.m15311a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("error_message_brief");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("error_message_detail");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("fb_data_policy_setting_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("fb_data_policy_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("follow_up_action_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("follow_up_action_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("landing_page_cta");
                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("landing_page_redirect_instruction");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            a = mutableFlatBuffer.g(i, 15);
            if (a != 0) {
                jsonGenerator.a("lead_gen_data");
                LeadGenDataParser.m15318a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 16) != 0) {
                jsonGenerator.a("lead_gen_data_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 16));
            }
            a = mutableFlatBuffer.g(i, 17);
            if (a != 0) {
                jsonGenerator.a("lead_gen_deep_link_user_status");
                LeadGenDeepLinkUserStatusFieldsParser.m15336a(mutableFlatBuffer, a, jsonGenerator);
            }
            a = mutableFlatBuffer.g(i, 18);
            if (a != 0) {
                jsonGenerator.a("lead_gen_user_status");
                LeadGenUserStatusParser.m15320a(mutableFlatBuffer, a, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 19) != 0) {
                jsonGenerator.a("nux_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 19));
            }
            if (mutableFlatBuffer.g(i, 20) != 0) {
                jsonGenerator.a("nux_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 20));
            }
            a = mutableFlatBuffer.g(i, 21);
            if (a != 0) {
                jsonGenerator.a("page");
                PageParser.m15326a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 22) != 0) {
                jsonGenerator.a("primary_button_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 22));
            }
            if (mutableFlatBuffer.g(i, 23) != 0) {
                jsonGenerator.a("privacy_checkbox_error");
                jsonGenerator.b(mutableFlatBuffer.c(i, 23));
            }
            if (mutableFlatBuffer.g(i, 24) != 0) {
                jsonGenerator.a("privacy_setting_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 24));
            }
            if (mutableFlatBuffer.g(i, 25) != 0) {
                jsonGenerator.a("progress_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 25));
            }
            if (mutableFlatBuffer.g(i, 26) != 0) {
                jsonGenerator.a("secure_sharing_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 26));
            }
            if (mutableFlatBuffer.g(i, 27) != 0) {
                jsonGenerator.a("select_text_hint");
                jsonGenerator.b(mutableFlatBuffer.c(i, 27));
            }
            if (mutableFlatBuffer.g(i, 28) != 0) {
                jsonGenerator.a("send_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 28));
            }
            if (mutableFlatBuffer.g(i, 29) != 0) {
                jsonGenerator.a("sent_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 29));
            }
            if (mutableFlatBuffer.g(i, 30) != 0) {
                jsonGenerator.a("share_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 30));
            }
            if (mutableFlatBuffer.g(i, 31) != 0) {
                jsonGenerator.a("short_secure_sharing_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 31));
            }
            boolean a2 = mutableFlatBuffer.a(i, 32);
            if (a2) {
                jsonGenerator.a("skip_experiments");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 33) != 0) {
                jsonGenerator.a("split_flow_landing_page_hint_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 33));
            }
            if (mutableFlatBuffer.g(i, 34) != 0) {
                jsonGenerator.a("split_flow_landing_page_hint_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 34));
            }
            if (mutableFlatBuffer.g(i, 35) != 0) {
                jsonGenerator.a("submit_card_instruction_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 35));
            }
            if (mutableFlatBuffer.g(i, 36) != 0) {
                jsonGenerator.a("unsubscribe_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 36));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: app_settings */
    public final class LeadGenContextPageFieldsParser {

        /* compiled from: app_settings */
        public final class ContextCardPhotoParser {
            public static int m15329a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("image")) {
                            iArr[1] = FBFullImageFragmentParser.m20114a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("preview_payload")) {
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
                return flatBufferBuilder.d();
            }

            public static void m15330a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("image");
                    FBFullImageFragmentParser.m20115a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("preview_payload");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class ContextImageParser {
            public static int m15331a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15332a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m15333a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[6];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("context_card_photo")) {
                        iArr[0] = ContextCardPhotoParser.m15329a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("context_content")) {
                        iArr[1] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("context_content_style")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLLeadGenContextPageContentStyle.fromString(jsonParser.o()));
                    } else if (i.equals("context_cta")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("context_image")) {
                        iArr[4] = ContextImageParser.m15331a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("context_title")) {
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

        public static void m15334a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("context_card_photo");
                ContextCardPhotoParser.m15330a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("context_content");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 1), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("context_content_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("context_cta");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("context_image");
                ContextImageParser.m15332a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("context_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: app_settings */
    public final class LeadGenDeepLinkUserStatusFieldsParser {
        public static int m15335a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("has_shared_info")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("signed_request")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            return flatBufferBuilder.d();
        }

        public static void m15336a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("has_shared_info");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("signed_request");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: app_settings */
    public final class LeadGenDefaultInfoFieldsParser {
        public static int m15340b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[10];
            boolean[] zArr = new boolean[3];
            boolean[] zArr2 = new boolean[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("customized_tokens")) {
                        iArr[0] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("field_key")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("input_domain")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLLeadGenInfoFieldInputDomain.fromString(jsonParser.o()));
                    } else if (i.equals("input_type")) {
                        iArr[3] = flatBufferBuilder.a(GraphQLLeadGenInfoFieldInputType.fromString(jsonParser.o()));
                    } else if (i.equals("is_custom_type")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("is_editable")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("is_required")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("name")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("place_holder")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("values")) {
                        iArr[9] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(10);
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
                flatBufferBuilder.a(6, zArr2[2]);
            }
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            return flatBufferBuilder.d();
        }

        public static int m15337a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m15340b(jsonParser, flatBufferBuilder)));
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

        public static void m15339a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m15338a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
            }
            jsonGenerator.e();
        }

        public static void m15338a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("customized_tokens");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 0), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("field_key");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("input_domain");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("input_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 3));
            }
            boolean a = mutableFlatBuffer.a(i, 4);
            if (a) {
                jsonGenerator.a("is_custom_type");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("is_editable");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("is_required");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("place_holder");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("values");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 9), jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: app_settings */
    public final class LeadGenLegalContentFieldsParser {

        /* compiled from: app_settings */
        public final class CheckboxesParser {

            /* compiled from: app_settings */
            public final class CheckboxBodyParser {
                public static int m15341a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m15342a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("text");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15343b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                boolean[] zArr = new boolean[2];
                boolean[] zArr2 = new boolean[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("checkbox_body")) {
                            iArr[0] = CheckboxBodyParser.m15341a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("is_checked_by_default")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("is_required")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("token_key")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, zArr2[0]);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(2, zArr2[1]);
                }
                flatBufferBuilder.b(3, iArr[3]);
                return flatBufferBuilder.d();
            }

            public static void m15344b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("checkbox_body");
                    CheckboxBodyParser.m15342a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("is_checked_by_default");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 2);
                if (a) {
                    jsonGenerator.a("is_required");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("token_key");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class DisclaimerBodyParser {

            /* compiled from: app_settings */
            public final class RangesParser {

                /* compiled from: app_settings */
                public final class EntityParser {
                    public static int m15345a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("__type__")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                } else if (i.equals("url")) {
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

                    public static void m15346a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("__type__");
                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("url");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m15347b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
                    boolean[] zArr = new boolean[2];
                    int[] iArr2 = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("entity")) {
                                iArr[0] = EntityParser.m15345a(jsonParser, flatBufferBuilder);
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

                public static void m15348b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("entity");
                        EntityParser.m15346a(mutableFlatBuffer, g, jsonGenerator);
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

            public static int m15350b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(RangesParser.m15347b(jsonParser, flatBufferBuilder)));
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

            public static int m15349a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m15350b(jsonParser, flatBufferBuilder)));
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

            public static void m15351b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("ranges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        RangesParser.m15348b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
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

        public static int m15352a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("advertiser_privacy_policy_name")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("checkboxes")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(CheckboxesParser.m15343b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr2 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr2, true);
                        }
                        iArr[1] = i2;
                    } else if (i.equals("disclaimer_body")) {
                        iArr[2] = DisclaimerBodyParser.m15349a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("disclaimer_title")) {
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

        public static void m15353a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            int i2;
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("advertiser_privacy_policy_name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("checkboxes");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    CheckboxesParser.m15344b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("disclaimer_body");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    DisclaimerBodyParser.m15351b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("disclaimer_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: app_settings */
    public final class LinkTargetStoreDataFragParser {
        public static int m15354a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("icon_url")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[1] = DefaultTextWithEntitiesLongFieldsParser.m9842a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("show_beeper")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("show_store_overlay")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("store_context")) {
                        iArr[4] = DefaultTextWithEntitiesLongFieldsParser.m9842a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(3, zArr2[1]);
            }
            flatBufferBuilder.b(4, iArr[4]);
            return flatBufferBuilder.d();
        }

        public static void m15355a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("icon_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("name");
                DefaultTextWithEntitiesLongFieldsParser.m9844b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            boolean a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("show_beeper");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 3);
            if (a) {
                jsonGenerator.a("show_store_overlay");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("store_context");
                DefaultTextWithEntitiesLongFieldsParser.m9844b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: app_settings */
    public final class NewsFeedDefaultsStoryActionLinkFieldsParser {

        /* compiled from: app_settings */
        public final class DescriptionParser {
            public static int m15356a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("ranges")) {
                            iArr[0] = RangesParser.m9849a(jsonParser, flatBufferBuilder);
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

            public static void m15357a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("ranges");
                    RangesParser.m9851a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class EventParser {
            public static int m15358a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[14];
                boolean[] zArr = new boolean[5];
                boolean[] zArr2 = new boolean[3];
                long[] jArr = new long[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("can_viewer_change_guest_status")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("connection_style")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLConnectionStyle.fromString(jsonParser.o()));
                        } else if (i.equals("end_timestamp")) {
                            zArr[1] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("event_cover_photo")) {
                            iArr[3] = EventCoverPhotoParser.m18201a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("event_place")) {
                            iArr[4] = NewsFeedDefaultsEventPlaceFieldsParser.m18304a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("is_all_day")) {
                            zArr[2] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("name")) {
                            iArr[7] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("start_timestamp")) {
                            zArr[3] = true;
                            jArr[1] = jsonParser.F();
                        } else if (i.equals("timezone")) {
                            iArr[9] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("url")) {
                            iArr[10] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("viewer_guest_status")) {
                            iArr[11] = flatBufferBuilder.a(GraphQLEventGuestStatus.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_has_pending_invite")) {
                            zArr[4] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("viewer_watch_status")) {
                            iArr[13] = flatBufferBuilder.a(GraphQLEventWatchStatus.fromString(jsonParser.o()));
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(14);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, zArr2[0]);
                }
                flatBufferBuilder.b(1, iArr[1]);
                if (zArr[1]) {
                    flatBufferBuilder.a(2, jArr[0], 0);
                }
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                if (zArr[2]) {
                    flatBufferBuilder.a(6, zArr2[1]);
                }
                flatBufferBuilder.b(7, iArr[7]);
                if (zArr[3]) {
                    flatBufferBuilder.a(8, jArr[1], 0);
                }
                flatBufferBuilder.b(9, iArr[9]);
                flatBufferBuilder.b(10, iArr[10]);
                flatBufferBuilder.b(11, iArr[11]);
                if (zArr[4]) {
                    flatBufferBuilder.a(12, zArr2[2]);
                }
                flatBufferBuilder.b(13, iArr[13]);
                return flatBufferBuilder.d();
            }

            public static void m15359a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_change_guest_status");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("connection_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                long a2 = mutableFlatBuffer.a(i, 2, 0);
                if (a2 != 0) {
                    jsonGenerator.a("end_timestamp");
                    jsonGenerator.a(a2);
                }
                int g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("event_cover_photo");
                    EventCoverPhotoParser.m18202a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("event_place");
                    NewsFeedDefaultsEventPlaceFieldsParser.m18305a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                a = mutableFlatBuffer.a(i, 6);
                if (a) {
                    jsonGenerator.a("is_all_day");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 7) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                }
                a2 = mutableFlatBuffer.a(i, 8, 0);
                if (a2 != 0) {
                    jsonGenerator.a("start_timestamp");
                    jsonGenerator.a(a2);
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("timezone");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                }
                if (mutableFlatBuffer.g(i, 10) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 10));
                }
                if (mutableFlatBuffer.g(i, 11) != 0) {
                    jsonGenerator.a("viewer_guest_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 11));
                }
                a = mutableFlatBuffer.a(i, 12);
                if (a) {
                    jsonGenerator.a("viewer_has_pending_invite");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 13) != 0) {
                    jsonGenerator.a("viewer_watch_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 13));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class PageParser {

            /* compiled from: app_settings */
            public final class PageLikersParser {
                public static int m15360a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m15361a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15362a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[7];
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("category_names")) {
                            iArr[0] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("cover_photo")) {
                            iArr[1] = CoverPhotoParser.m15323a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("does_viewer_like")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("id")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("page_likers")) {
                            iArr[5] = PageLikersParser.m15360a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("profile_picture")) {
                            iArr[6] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                if (zArr[0]) {
                    flatBufferBuilder.a(2, zArr2[0]);
                }
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                return flatBufferBuilder.d();
            }

            public static void m15363a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("category_names");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 0), jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m15324a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(i, 2);
                if (a) {
                    jsonGenerator.a("does_viewer_like");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("page_likers");
                    PageLikersParser.m15361a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class ParentStoryParser {
            public static int m15364a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15365a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

        /* compiled from: app_settings */
        public final class PrivacyScopeParser {
            public static int m15366a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("icon")) {
                            iArr[0] = DefaultIconFieldsParser.m9650a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("label")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("selectedPrivacyOption")) {
                            iArr[2] = PrivacyOptionsFieldsParser.m2878a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("type")) {
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

            public static void m15367a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("icon");
                    DefaultIconFieldsParser.m9651a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("label");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("selectedPrivacyOption");
                    PrivacyOptionsFieldsParser.m2879a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("type");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class ProfileParser {

            /* compiled from: app_settings */
            public final class ProfilePictureParser {
                public static int m15368a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m15369a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15370a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[6];
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("does_viewer_like")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("id")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("profile_picture")) {
                            iArr[4] = ProfilePictureParser.m15368a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("subscribe_status")) {
                            iArr[5] = flatBufferBuilder.a(GraphQLSubscribeStatus.fromString(jsonParser.o()));
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, zArr2[0]);
                }
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                return flatBufferBuilder.d();
            }

            public static void m15371a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("does_viewer_like");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                int g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    ProfilePictureParser.m15369a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("subscribe_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 5));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class TaggedAndMentionedUsersParser {

            /* compiled from: app_settings */
            public final class NodesParser {
                public static int m15373b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m15372a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

            public static int m15374a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("count")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("nodes")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(NodesParser.m15373b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr3 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr3[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr3, true);
                            }
                            iArr[1] = i2;
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr2[0], 0);
                }
                flatBufferBuilder.b(1, iArr[1]);
                return flatBufferBuilder.d();
            }

            public static void m15375a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 1);
                if (a != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                        NodesParser.m15372a(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class TopicParser {
            public static int m15376a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("name")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("tag")) {
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
                return flatBufferBuilder.d();
            }

            public static void m15377a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("tag");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        public static int m15380b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[86];
            boolean[] zArr = new boolean[10];
            boolean[] zArr2 = new boolean[6];
            int[] iArr2 = new int[3];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("action_link_type")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLProfilePictureActionLinkType.fromString(jsonParser.o()));
                    } else if (i.equals("ad_id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("agree_to_privacy_text")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("android_minimal_screen_form_height")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("android_small_screen_phone_threshold")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("can_viewer_add_contributors")) {
                        zArr[2] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_watch_and_browse")) {
                        zArr[3] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("default_expiration_time")) {
                        zArr[4] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("description")) {
                        iArr[9] = DescriptionParser.m15356a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("destination_type")) {
                        iArr[10] = flatBufferBuilder.a(GraphQLStoryActionLinkDestinationType.fromString(jsonParser.o()));
                    } else if (i.equals("disclaimer_accept_button_text")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("disclaimer_continue_button_text")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("error_codes")) {
                        iArr[13] = ErrorCodesParser.m15309a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("error_message_brief")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("error_message_detail")) {
                        iArr[15] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("event")) {
                        iArr[16] = EventParser.m15358a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("fb_data_policy_setting_description")) {
                        iArr[17] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("fb_data_policy_url")) {
                        iArr[18] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("featured_instant_article_element")) {
                        iArr[19] = FeaturedInstantArticleElementParser.m15401a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback")) {
                        iArr[20] = FeedbackParser.m15306a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("follow_up_action_text")) {
                        iArr[21] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("follow_up_action_url")) {
                        iArr[22] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("followup_choices")) {
                        iArr[23] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("followup_question")) {
                        iArr[24] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("frame_id")) {
                        iArr[25] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("header_color")) {
                        iArr[26] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("info")) {
                        iArr[27] = InfoParser.m15388a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("instant_article")) {
                        iArr[28] = InstantArticleParser.m15403a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("item")) {
                        iArr[29] = DefaultSavableObjectExtraFieldsParser.m2942a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("landing_page_cta")) {
                        iArr[30] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("landing_page_redirect_instruction")) {
                        iArr[31] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("lead_gen_data")) {
                        iArr[32] = LeadGenDataParser.m15317a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("lead_gen_data_id")) {
                        iArr[33] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("lead_gen_deep_link_user_status")) {
                        iArr[34] = LeadGenDeepLinkUserStatusFieldsParser.m15335a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("lead_gen_user_status")) {
                        iArr[35] = LeadGenUserStatusParser.m15319a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("link_description")) {
                        iArr[36] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("link_display")) {
                        iArr[37] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("link_icon_image")) {
                        iArr[38] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("link_style")) {
                        iArr[39] = flatBufferBuilder.a(GraphQLCallToActionStyle.fromString(jsonParser.o()));
                    } else if (i.equals("link_target_store_data")) {
                        iArr[40] = LinkTargetStoreDataFragParser.m15354a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("link_title")) {
                        iArr[41] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("link_type")) {
                        iArr[42] = flatBufferBuilder.a(GraphQLCallToActionType.fromString(jsonParser.o()));
                    } else if (i.equals("link_video_endscreen_icon")) {
                        iArr[43] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("logo_uri")) {
                        iArr[44] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("main_choices")) {
                        iArr[45] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("main_question")) {
                        iArr[46] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("message")) {
                        iArr[47] = DefaultTextWithEntitiesLongFieldsParser.m9842a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("nux_description")) {
                        iArr[48] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("nux_title")) {
                        iArr[49] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("page")) {
                        iArr[50] = PageParser.m15362a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page_outcome_button")) {
                        iArr[51] = PageOutcomeButtonParser.m15395a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("parent_story")) {
                        iArr[52] = ParentStoryParser.m15364a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("primary_button_text")) {
                        iArr[53] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("privacy_checkbox_error")) {
                        iArr[54] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("privacy_scope")) {
                        iArr[55] = PrivacyScopeParser.m15366a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("privacy_setting_description")) {
                        iArr[56] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profile")) {
                        iArr[57] = ProfileParser.m15370a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("progress_text")) {
                        iArr[58] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("promotion_tag")) {
                        iArr[59] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("prompt_id")) {
                        iArr[60] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("rating")) {
                        zArr[5] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("review")) {
                        iArr[62] = ReviewParser.m15293a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secure_sharing_text")) {
                        iArr[63] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("select_text_hint")) {
                        iArr[64] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("send_description")) {
                        iArr[65] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sent_text")) {
                        iArr[66] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("share_id")) {
                        iArr[67] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("short_secure_sharing_text")) {
                        iArr[68] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("show_even_if_installed")) {
                        zArr[6] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("show_in_feed")) {
                        zArr[7] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("show_in_permalink")) {
                        zArr[8] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("skip_experiments")) {
                        zArr[9] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("split_flow_landing_page_hint_text")) {
                        iArr[73] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("split_flow_landing_page_hint_title")) {
                        iArr[74] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("stateful_title")) {
                        iArr[75] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sticker")) {
                        iArr[76] = ImageOverlayFieldsParser.m22830a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("story")) {
                        iArr[77] = StoryParser.m15398a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submit_card_instruction_text")) {
                        iArr[78] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("tagged_and_mentioned_users")) {
                        iArr[79] = TaggedAndMentionedUsersParser.m15374a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temporal_event_info")) {
                        iArr[80] = TemporalEventInfoParser.m15303a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[81] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("topic")) {
                        iArr[82] = TopicParser.m15376a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("unsubscribe_description")) {
                        iArr[83] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("url")) {
                        iArr[84] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("video_annotations")) {
                        iArr[85] = VideoAnnotationFieldsParser.m15406a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(86);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            if (zArr[0]) {
                flatBufferBuilder.a(4, iArr2[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(5, iArr2[1], 0);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(6, zArr2[0]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(7, zArr2[1]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(8, jArr[0], 0);
            }
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
            flatBufferBuilder.b(42, iArr[42]);
            flatBufferBuilder.b(43, iArr[43]);
            flatBufferBuilder.b(44, iArr[44]);
            flatBufferBuilder.b(45, iArr[45]);
            flatBufferBuilder.b(46, iArr[46]);
            flatBufferBuilder.b(47, iArr[47]);
            flatBufferBuilder.b(48, iArr[48]);
            flatBufferBuilder.b(49, iArr[49]);
            flatBufferBuilder.b(50, iArr[50]);
            flatBufferBuilder.b(51, iArr[51]);
            flatBufferBuilder.b(52, iArr[52]);
            flatBufferBuilder.b(53, iArr[53]);
            flatBufferBuilder.b(54, iArr[54]);
            flatBufferBuilder.b(55, iArr[55]);
            flatBufferBuilder.b(56, iArr[56]);
            flatBufferBuilder.b(57, iArr[57]);
            flatBufferBuilder.b(58, iArr[58]);
            flatBufferBuilder.b(59, iArr[59]);
            flatBufferBuilder.b(60, iArr[60]);
            if (zArr[5]) {
                flatBufferBuilder.a(61, iArr2[2], 0);
            }
            flatBufferBuilder.b(62, iArr[62]);
            flatBufferBuilder.b(63, iArr[63]);
            flatBufferBuilder.b(64, iArr[64]);
            flatBufferBuilder.b(65, iArr[65]);
            flatBufferBuilder.b(66, iArr[66]);
            flatBufferBuilder.b(67, iArr[67]);
            flatBufferBuilder.b(68, iArr[68]);
            if (zArr[6]) {
                flatBufferBuilder.a(69, zArr2[2]);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(70, zArr2[3]);
            }
            if (zArr[8]) {
                flatBufferBuilder.a(71, zArr2[4]);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(72, zArr2[5]);
            }
            flatBufferBuilder.b(73, iArr[73]);
            flatBufferBuilder.b(74, iArr[74]);
            flatBufferBuilder.b(75, iArr[75]);
            flatBufferBuilder.b(76, iArr[76]);
            flatBufferBuilder.b(77, iArr[77]);
            flatBufferBuilder.b(78, iArr[78]);
            flatBufferBuilder.b(79, iArr[79]);
            flatBufferBuilder.b(80, iArr[80]);
            flatBufferBuilder.b(81, iArr[81]);
            flatBufferBuilder.b(82, iArr[82]);
            flatBufferBuilder.b(83, iArr[83]);
            flatBufferBuilder.b(84, iArr[84]);
            flatBufferBuilder.b(85, iArr[85]);
            return flatBufferBuilder.d();
        }

        public static int m15378a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m15380b(jsonParser, flatBufferBuilder)));
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

        public static void m15379a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m15381b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m15381b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("action_link_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("ad_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("agree_to_privacy_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            int a = mutableFlatBuffer.a(i, 4, 0);
            if (a != 0) {
                jsonGenerator.a("android_minimal_screen_form_height");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.a(i, 5, 0);
            if (a != 0) {
                jsonGenerator.a("android_small_screen_phone_threshold");
                jsonGenerator.b(a);
            }
            boolean a2 = mutableFlatBuffer.a(i, 6);
            if (a2) {
                jsonGenerator.a("can_viewer_add_contributors");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 7);
            if (a2) {
                jsonGenerator.a("can_watch_and_browse");
                jsonGenerator.a(a2);
            }
            long a3 = mutableFlatBuffer.a(i, 8, 0);
            if (a3 != 0) {
                jsonGenerator.a("default_expiration_time");
                jsonGenerator.a(a3);
            }
            a = mutableFlatBuffer.g(i, 9);
            if (a != 0) {
                jsonGenerator.a("description");
                DescriptionParser.m15357a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("destination_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 10));
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("disclaimer_accept_button_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("disclaimer_continue_button_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            a = mutableFlatBuffer.g(i, 13);
            if (a != 0) {
                jsonGenerator.a("error_codes");
                ErrorCodesParser.m15311a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("error_message_brief");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            if (mutableFlatBuffer.g(i, 15) != 0) {
                jsonGenerator.a("error_message_detail");
                jsonGenerator.b(mutableFlatBuffer.c(i, 15));
            }
            a = mutableFlatBuffer.g(i, 16);
            if (a != 0) {
                jsonGenerator.a("event");
                EventParser.m15359a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 17) != 0) {
                jsonGenerator.a("fb_data_policy_setting_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 17));
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("fb_data_policy_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 18));
            }
            a = mutableFlatBuffer.g(i, 19);
            if (a != 0) {
                jsonGenerator.a("featured_instant_article_element");
                FeaturedInstantArticleElementParser.m15402a(mutableFlatBuffer, a, jsonGenerator);
            }
            a = mutableFlatBuffer.g(i, 20);
            if (a != 0) {
                jsonGenerator.a("feedback");
                FeedbackParser.m15307a(mutableFlatBuffer, a, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 21) != 0) {
                jsonGenerator.a("follow_up_action_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 21));
            }
            if (mutableFlatBuffer.g(i, 22) != 0) {
                jsonGenerator.a("follow_up_action_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 22));
            }
            if (mutableFlatBuffer.g(i, 23) != 0) {
                jsonGenerator.a("followup_choices");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 23), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 24) != 0) {
                jsonGenerator.a("followup_question");
                jsonGenerator.b(mutableFlatBuffer.c(i, 24));
            }
            if (mutableFlatBuffer.g(i, 25) != 0) {
                jsonGenerator.a("frame_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 25));
            }
            if (mutableFlatBuffer.g(i, 26) != 0) {
                jsonGenerator.a("header_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 26));
            }
            a = mutableFlatBuffer.g(i, 27);
            if (a != 0) {
                jsonGenerator.a("info");
                InfoParser.m15389a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 28);
            if (a != 0) {
                jsonGenerator.a("instant_article");
                InstantArticleParser.m15404a(mutableFlatBuffer, a, jsonGenerator);
            }
            a = mutableFlatBuffer.g(i, 29);
            if (a != 0) {
                jsonGenerator.a("item");
                DefaultSavableObjectExtraFieldsParser.m2943a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 30) != 0) {
                jsonGenerator.a("landing_page_cta");
                jsonGenerator.b(mutableFlatBuffer.c(i, 30));
            }
            if (mutableFlatBuffer.g(i, 31) != 0) {
                jsonGenerator.a("landing_page_redirect_instruction");
                jsonGenerator.b(mutableFlatBuffer.c(i, 31));
            }
            a = mutableFlatBuffer.g(i, 32);
            if (a != 0) {
                jsonGenerator.a("lead_gen_data");
                LeadGenDataParser.m15318a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 33) != 0) {
                jsonGenerator.a("lead_gen_data_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 33));
            }
            a = mutableFlatBuffer.g(i, 34);
            if (a != 0) {
                jsonGenerator.a("lead_gen_deep_link_user_status");
                LeadGenDeepLinkUserStatusFieldsParser.m15336a(mutableFlatBuffer, a, jsonGenerator);
            }
            a = mutableFlatBuffer.g(i, 35);
            if (a != 0) {
                jsonGenerator.a("lead_gen_user_status");
                LeadGenUserStatusParser.m15320a(mutableFlatBuffer, a, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 36) != 0) {
                jsonGenerator.a("link_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 36));
            }
            if (mutableFlatBuffer.g(i, 37) != 0) {
                jsonGenerator.a("link_display");
                jsonGenerator.b(mutableFlatBuffer.c(i, 37));
            }
            a = mutableFlatBuffer.g(i, 38);
            if (a != 0) {
                jsonGenerator.a("link_icon_image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, a, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 39) != 0) {
                jsonGenerator.a("link_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 39));
            }
            a = mutableFlatBuffer.g(i, 40);
            if (a != 0) {
                jsonGenerator.a("link_target_store_data");
                LinkTargetStoreDataFragParser.m15355a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 41) != 0) {
                jsonGenerator.a("link_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 41));
            }
            if (mutableFlatBuffer.g(i, 42) != 0) {
                jsonGenerator.a("link_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 42));
            }
            a = mutableFlatBuffer.g(i, 43);
            if (a != 0) {
                jsonGenerator.a("link_video_endscreen_icon");
                DefaultImageFieldsParser.a(mutableFlatBuffer, a, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 44) != 0) {
                jsonGenerator.a("logo_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 44));
            }
            if (mutableFlatBuffer.g(i, 45) != 0) {
                jsonGenerator.a("main_choices");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 45), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 46) != 0) {
                jsonGenerator.a("main_question");
                jsonGenerator.b(mutableFlatBuffer.c(i, 46));
            }
            a = mutableFlatBuffer.g(i, 47);
            if (a != 0) {
                jsonGenerator.a("message");
                DefaultTextWithEntitiesLongFieldsParser.m9844b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 48) != 0) {
                jsonGenerator.a("nux_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 48));
            }
            if (mutableFlatBuffer.g(i, 49) != 0) {
                jsonGenerator.a("nux_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 49));
            }
            a = mutableFlatBuffer.g(i, 50);
            if (a != 0) {
                jsonGenerator.a("page");
                PageParser.m15363a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 51);
            if (a != 0) {
                jsonGenerator.a("page_outcome_button");
                PageOutcomeButtonParser.m15396a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 52);
            if (a != 0) {
                jsonGenerator.a("parent_story");
                ParentStoryParser.m15365a(mutableFlatBuffer, a, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 53) != 0) {
                jsonGenerator.a("primary_button_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 53));
            }
            if (mutableFlatBuffer.g(i, 54) != 0) {
                jsonGenerator.a("privacy_checkbox_error");
                jsonGenerator.b(mutableFlatBuffer.c(i, 54));
            }
            a = mutableFlatBuffer.g(i, 55);
            if (a != 0) {
                jsonGenerator.a("privacy_scope");
                PrivacyScopeParser.m15367a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 56) != 0) {
                jsonGenerator.a("privacy_setting_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 56));
            }
            a = mutableFlatBuffer.g(i, 57);
            if (a != 0) {
                jsonGenerator.a("profile");
                ProfileParser.m15371a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 58) != 0) {
                jsonGenerator.a("progress_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 58));
            }
            if (mutableFlatBuffer.g(i, 59) != 0) {
                jsonGenerator.a("promotion_tag");
                jsonGenerator.b(mutableFlatBuffer.c(i, 59));
            }
            if (mutableFlatBuffer.g(i, 60) != 0) {
                jsonGenerator.a("prompt_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 60));
            }
            a = mutableFlatBuffer.a(i, 61, 0);
            if (a != 0) {
                jsonGenerator.a("rating");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.g(i, 62);
            if (a != 0) {
                jsonGenerator.a("review");
                UserReviewsParser.a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 63) != 0) {
                jsonGenerator.a("secure_sharing_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 63));
            }
            if (mutableFlatBuffer.g(i, 64) != 0) {
                jsonGenerator.a("select_text_hint");
                jsonGenerator.b(mutableFlatBuffer.c(i, 64));
            }
            if (mutableFlatBuffer.g(i, 65) != 0) {
                jsonGenerator.a("send_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 65));
            }
            if (mutableFlatBuffer.g(i, 66) != 0) {
                jsonGenerator.a("sent_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 66));
            }
            if (mutableFlatBuffer.g(i, 67) != 0) {
                jsonGenerator.a("share_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 67));
            }
            if (mutableFlatBuffer.g(i, 68) != 0) {
                jsonGenerator.a("short_secure_sharing_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 68));
            }
            a2 = mutableFlatBuffer.a(i, 69);
            if (a2) {
                jsonGenerator.a("show_even_if_installed");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 70);
            if (a2) {
                jsonGenerator.a("show_in_feed");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 71);
            if (a2) {
                jsonGenerator.a("show_in_permalink");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 72);
            if (a2) {
                jsonGenerator.a("skip_experiments");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 73) != 0) {
                jsonGenerator.a("split_flow_landing_page_hint_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 73));
            }
            if (mutableFlatBuffer.g(i, 74) != 0) {
                jsonGenerator.a("split_flow_landing_page_hint_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 74));
            }
            if (mutableFlatBuffer.g(i, 75) != 0) {
                jsonGenerator.a("stateful_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 75));
            }
            a = mutableFlatBuffer.g(i, 76);
            if (a != 0) {
                jsonGenerator.a("sticker");
                ImageOverlayFieldsParser.m22833b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 77);
            if (a != 0) {
                jsonGenerator.a("story");
                StoryParser.m15399a(mutableFlatBuffer, a, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 78) != 0) {
                jsonGenerator.a("submit_card_instruction_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 78));
            }
            a = mutableFlatBuffer.g(i, 79);
            if (a != 0) {
                jsonGenerator.a("tagged_and_mentioned_users");
                TaggedAndMentionedUsersParser.m15375a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 80);
            if (a != 0) {
                jsonGenerator.a("temporal_event_info");
                TemporalEventInfoParser.m15304a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 81) != 0) {
                jsonGenerator.a("title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 81));
            }
            a = mutableFlatBuffer.g(i, 82);
            if (a != 0) {
                jsonGenerator.a("topic");
                TopicParser.m15377a(mutableFlatBuffer, a, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 83) != 0) {
                jsonGenerator.a("unsubscribe_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 83));
            }
            if (mutableFlatBuffer.g(i, 84) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 84));
            }
            a = mutableFlatBuffer.g(i, 85);
            if (a != 0) {
                jsonGenerator.a("video_annotations");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                    VideoAnnotationFieldsParser.m15407a(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: app_settings */
    public final class OverlayActionLinkFieldsParser {

        /* compiled from: app_settings */
        public final class DescriptionParser {
            public static int m15382a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15383a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class InfoParser {

            /* compiled from: app_settings */
            public final class CreationSuggestionParser {

                /* compiled from: app_settings */
                public final class SuggestedMembersParser {
                    public static int m15385b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m15384a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m15386a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[5];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("default_group_name")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("default_visibility")) {
                                iArr[1] = flatBufferBuilder.a(GraphQLGroupVisibility.fromString(jsonParser.o()));
                            } else if (i.equals("suggested_members")) {
                                int i2 = 0;
                                ArrayList arrayList = new ArrayList();
                                if (jsonParser.g() == JsonToken.START_ARRAY) {
                                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                                        arrayList.add(Integer.valueOf(SuggestedMembersParser.m15385b(jsonParser, flatBufferBuilder)));
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    int[] iArr2 = new int[arrayList.size()];
                                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                        iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                    }
                                    i2 = flatBufferBuilder.a(iArr2, true);
                                }
                                iArr[2] = i2;
                            } else if (i.equals("suggestion_identifier")) {
                                iArr[3] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("suggestion_type")) {
                                iArr[4] = flatBufferBuilder.a(GraphQLGroupCreationSuggestionType.fromString(jsonParser.o()));
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

                public static void m15387a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("default_group_name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("default_visibility");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                    }
                    int g = mutableFlatBuffer.g(i, 2);
                    if (g != 0) {
                        jsonGenerator.a("suggested_members");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            SuggestedMembersParser.m15384a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                        }
                        jsonGenerator.e();
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("suggestion_identifier");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                    }
                    if (mutableFlatBuffer.g(i, 4) != 0) {
                        jsonGenerator.a("suggestion_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 4));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15388a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("creation_suggestion")) {
                            iArr[1] = CreationSuggestionParser.m15386a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("group_id")) {
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
                return flatBufferBuilder.d();
            }

            public static void m15389a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("creation_suggestion");
                    CreationSuggestionParser.m15387a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("group_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15390a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("description")) {
                        iArr[0] = DescriptionParser.m15382a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("info")) {
                        iArr[1] = InfoParser.m15388a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
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

    /* compiled from: app_settings */
    public final class PageOutcomeButtonActionLinkFieldsParser {

        /* compiled from: app_settings */
        public final class PageOutcomeButtonParser {

            /* compiled from: app_settings */
            public final class ButtonIconImageParser {

                /* compiled from: app_settings */
                public final class IconImageParser {
                    public static int m15391a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m15392a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m15393a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("icon_image")) {
                                iArr[0] = IconImageParser.m15391a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m15394a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("icon_image");
                        IconImageParser.m15392a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15395a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("button_icon_image")) {
                            iArr[0] = ButtonIconImageParser.m15393a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("button_type")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLPageCallToActionType.fromString(jsonParser.o()));
                        } else if (i.equals("button_uri")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("render_type")) {
                            iArr[3] = flatBufferBuilder.a(GraphQLPageOutcomeButtonRenderType.fromString(jsonParser.o()));
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

            public static void m15396a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("button_icon_image");
                    ButtonIconImageParser.m15394a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("button_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("button_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("render_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 3));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15397a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("page_outcome_button")) {
                        iArr[0] = PageOutcomeButtonParser.m15395a(jsonParser, flatBufferBuilder);
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

    /* compiled from: app_settings */
    public final class PlaceListConvertActionLinkFieldsParser {

        /* compiled from: app_settings */
        public final class StoryParser {
            public static int m15398a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15399a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15400a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("story")) {
                        iArr[0] = StoryParser.m15398a(jsonParser, flatBufferBuilder);
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

    /* compiled from: app_settings */
    public final class ReadInstantArticleActionLinkFieldsParser {

        /* compiled from: app_settings */
        public final class FeaturedInstantArticleElementParser {
            public static int m15401a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("document_element_type")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLDocumentElementType.fromString(jsonParser.o()));
                        } else if (i.equals("id")) {
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
                return flatBufferBuilder.d();
            }

            public static void m15402a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_settings */
        public final class InstantArticleParser {
            public static int m15403a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15404a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15405a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("featured_instant_article_element")) {
                        iArr[0] = FeaturedInstantArticleElementParser.m15401a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("instant_article")) {
                        iArr[1] = InstantArticleParser.m15403a(jsonParser, flatBufferBuilder);
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

    /* compiled from: app_settings */
    public final class VideoAnnotationFieldsParser {
        public static int m15408b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[7];
            boolean[] zArr = new boolean[2];
            int[] iArr2 = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("end_time_in_sec")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("image_uri")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("link")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("link_caption")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("link_description")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("link_title")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("start_time_in_sec")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(7);
            if (zArr[0]) {
                flatBufferBuilder.a(0, iArr2[0], 0);
            }
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            if (zArr[1]) {
                flatBufferBuilder.a(6, iArr2[1], 0);
            }
            return flatBufferBuilder.d();
        }

        public static int m15406a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m15408b(jsonParser, flatBufferBuilder)));
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

        public static void m15407a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            int a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("end_time_in_sec");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("image_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("link");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("link_caption");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("link_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("link_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            a = mutableFlatBuffer.a(i, 6, 0);
            if (a != 0) {
                jsonGenerator.a("start_time_in_sec");
                jsonGenerator.b(a);
            }
            jsonGenerator.g();
        }
    }
}
