package com.facebook.reaction.protocol.graphql;

import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsParsers.PlaceQuestionFieldsParser;
import com.facebook.events.graphql.EventsGraphQLParsers.EventCardFragmentParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLReactionProfileBadgeType;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitCollapseState;
import com.facebook.graphql.enums.GraphQLReactionUnitHeaderStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.LinkableTextWithEntitiesParser;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultPageInfoFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.facebook.localcontent.protocol.graphql.PopularProductFragmentsParsers.PageProductParser;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLParsers.PageServiceItemParser;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLParsers.VideoDetailFragmentParser;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLParsers.SizeAwareMediaParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.PageMediaWithAttributionParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionAttributionFooterAttachmentFieldsParser.AttributionParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionCriticReviewAttachmentFieldsParser.ExternalImageParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionCriticReviewAttachmentFieldsParser.ReviewerParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionPageCommerceAttachmentFieldsParser.ProductParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionPageInviteFriendToLikeAttachmentFieldsParser.InviteeParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionPagePromotionAttachmentFieldsParser.ItemParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionStoryAdminPageAttachmentFragmentParser.StoryAdminPageParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionFacepileProfileParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionImageFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionPageFieldsWithPlaceTipsInfoParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionProfileFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionStoryAttachmentStoryFragmentParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionTextWithEntitiesWithImagesParser.ImageRangesParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionAttachmentActionFragmentParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionStoryAttachmentActionFragmentParser;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLParsers.ReactionUnitComponentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: fields_data */
public class FetchReactionGraphQLParsers {

    /* compiled from: fields_data */
    public final class PlaceTipWelcomeHeaderFragmentParser {
        public static int m15671a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[6];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("nux_message")) {
                        iArr[0] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("nux_submessage")) {
                        iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[2] = ReactionPageFieldsWithPlaceTipsInfoParser.m14699a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page_info_message")) {
                        iArr[3] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("welcome_header_photo")) {
                        iArr[4] = SizeAwareMediaParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("welcome_note_message")) {
                        iArr[5] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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

        public static void m15672a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("nux_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("nux_submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("page");
                ReactionPageFieldsWithPlaceTipsInfoParser.m14700a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("page_info_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("welcome_header_photo");
                SizeAwareMediaParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("welcome_note_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fields_data */
    public final class PlaceTipsFeedUnitFragmentParser {

        /* compiled from: fields_data */
        public final class FooterParser {
            public static int m15673a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("description")) {
                            iArr[0] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("question")) {
                            iArr[1] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("thank_you_text")) {
                            iArr[2] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
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

            public static void m15674a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("description");
                    DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("question");
                    DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("thank_you_text");
                    DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static int m15675a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("footer")) {
                        iArr[0] = FooterParser.m15673a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subtitle")) {
                        iArr[1] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[2] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
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

        public static void m15676a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("footer");
                FooterParser.m15674a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("subtitle");
                DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("title");
                DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fields_data */
    public final class ReactionAggregateUnitFragmentParser {

        /* compiled from: fields_data */
        public final class ReactionAggregatedUnitsParser {
            public static int m15677a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("nodes")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(ReactionUnitDefaultFieldsParser.m15723b(jsonParser, flatBufferBuilder)));
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

            public static void m15678a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        ReactionUnitDefaultFieldsParser.m15724b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15679a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("reaction_aggregated_units")) {
                        iArr[0] = ReactionAggregatedUnitsParser.m15677a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fields_data */
    public final class ReactionMoreAttachmentsResultParser {

        /* compiled from: fields_data */
        public final class ReactionAttachmentsParser {

            /* compiled from: fields_data */
            public final class EdgesParser {
                public static int m15680b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = ReactionStoryAttachmentFragmentParser.m15705a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m15681b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        ReactionStoryAttachmentFragmentParser.m15706a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15682a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m15680b(jsonParser, flatBufferBuilder)));
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
                            iArr[1] = DefaultPageInfoFieldsParser.a(jsonParser, flatBufferBuilder);
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

            public static void m15683a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m15681b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("page_info");
                    DefaultPageInfoFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15684a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("reaction_attachments")) {
                        iArr[0] = ReactionAttachmentsParser.m15682a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fields_data */
    public final class ReactionProfileAttachmentFragmentParser {
        public static int m15685a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("description")) {
                        iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[2] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile")) {
                        iArr[3] = ReactionProfileFieldsParser.m14712a(jsonParser, flatBufferBuilder);
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

        public static void m15686a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("profile");
                ReactionProfileFieldsParser.m14713a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fields_data */
    public final class ReactionProfileAttachmentsResultParser {

        /* compiled from: fields_data */
        public final class ReactionAttachmentsParser {

            /* compiled from: fields_data */
            public final class EdgesParser {
                public static int m15687b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = ReactionProfileAttachmentFragmentParser.m15685a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m15688b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        ReactionProfileAttachmentFragmentParser.m15686a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15689a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m15687b(jsonParser, flatBufferBuilder)));
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
                            iArr[1] = DefaultPageInfoFieldsParser.a(jsonParser, flatBufferBuilder);
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

            public static void m15690a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m15688b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("page_info");
                    DefaultPageInfoFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15691a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("reaction_attachments")) {
                        iArr[0] = ReactionAttachmentsParser.m15689a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fields_data */
    public final class ReactionQueryFragmentParser {

        /* compiled from: fields_data */
        public final class ReactionUnitsParser {
            public static int m15692a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("edges")) {
                            iArr[0] = EdgesParser.m15695a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("page_info")) {
                            iArr[1] = DefaultPageInfoFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_tips_welcome_header")) {
                            iArr[2] = PlaceTipWelcomeHeaderFragmentParser.m15671a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("session_id")) {
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

            public static void m15693a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    EdgesParser.m15696a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("page_info");
                    DefaultPageInfoFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("place_tips_welcome_header");
                    PlaceTipWelcomeHeaderFragmentParser.m15672a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("session_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15694a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("reaction_units")) {
                        iArr[0] = ReactionUnitsParser.m15692a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fields_data */
    public final class ReactionStoriesParser {

        /* compiled from: fields_data */
        public final class EdgesParser {
            public static int m15697b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("node")) {
                            iArr[0] = ReactionUnitFragmentParser.m15727a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static int m15695a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m15697b(jsonParser, flatBufferBuilder)));
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

            public static void m15696a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m15698b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m15698b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("node");
                    ReactionUnitFragmentParser.m15728a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static int m15699a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("edges")) {
                        iArr[0] = EdgesParser.m15695a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page_info")) {
                        iArr[1] = DefaultPageInfoFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("session_id")) {
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

        public static void m15700a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("edges");
                EdgesParser.m15696a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("page_info");
                DefaultPageInfoFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("session_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fields_data */
    public final class ReactionStoryAttachmentFragmentParser {

        /* compiled from: fields_data */
        public final class MessageParser {
            public static int m15701a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("image_ranges")) {
                            iArr[0] = ImageRangesParser.m14721a(jsonParser, flatBufferBuilder);
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

            public static void m15702a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("image_ranges");
                    ImageRangesParser.m14722a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fields_data */
        public final class PageParser {
            public static int m15703a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15704a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m15705a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[57];
            boolean[] zArr = new boolean[6];
            boolean[] zArr2 = new boolean[1];
            int[] iArr2 = new int[4];
            double[] dArr = new double[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("actions")) {
                        iArr[1] = ReactionAttachmentActionFragmentParser.m16523a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("album")) {
                        iArr[2] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("album_artwork_url")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("artist")) {
                        iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("attribution")) {
                        iArr[5] = AttributionParser.m14376a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("badge_count")) {
                        iArr[6] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("body")) {
                        iArr[7] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("byline")) {
                        iArr[8] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("description")) {
                        iArr[9] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("detailed_story")) {
                        iArr[10] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("duration_ms")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("event")) {
                        iArr[12] = EventCardFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("external_image")) {
                        iArr[13] = ExternalImageParser.m14379a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("external_url")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("footer")) {
                        iArr[15] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image")) {
                        iArr[16] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("invitee")) {
                        iArr[17] = InviteeParser.m14391a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_pinned")) {
                        zArr[1] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("item")) {
                        iArr[19] = ItemParser.m14396a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("label")) {
                        iArr[20] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("left_subtitle")) {
                        iArr[21] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("left_title")) {
                        iArr[22] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location")) {
                        iArr[23] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[24] = MessageParser.m15701a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[25] = PageParser.m15703a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page_post")) {
                        iArr[26] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page_product")) {
                        iArr[27] = PageProductParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page_service")) {
                        iArr[28] = PageServiceItemParser.m11181a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photo")) {
                        iArr[29] = SizeAwareMediaParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("pin_subtitle")) {
                        iArr[30] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("pin_title")) {
                        iArr[31] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("place_question")) {
                        iArr[32] = PlaceQuestionFieldsParser.m2483a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_survey_thank_you_subtitle")) {
                        iArr[33] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_survey_thank_you_title")) {
                        iArr[34] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("position_ms")) {
                        zArr[2] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("product")) {
                        iArr[36] = ProductParser.m14388a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile")) {
                        iArr[37] = ReactionProfileFieldsParser.m14712a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("published_on")) {
                        iArr[38] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("radius")) {
                        zArr[3] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("reaction_photo_with_attribution")) {
                        iArr[40] = PageMediaWithAttributionParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("review_title")) {
                        iArr[41] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("reviewer")) {
                        iArr[42] = ReviewerParser.m14383a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("right_subtitle")) {
                        iArr[43] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("right_title")) {
                        iArr[44] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("scaled_image")) {
                        iArr[45] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("song_name")) {
                        iArr[46] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("story")) {
                        iArr[47] = ReactionStoryAttachmentStoryFragmentParser.m14719a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("story_admin_page")) {
                        iArr[48] = StoryAdminPageParser.m14399a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("story_attachments_icon_image")) {
                        iArr[49] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("summary")) {
                        iArr[50] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("topic")) {
                        iArr[51] = TopicParser.m15712a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("total_likes")) {
                        zArr[4] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("total_likes_label")) {
                        iArr[53] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("total_visits")) {
                        zArr[5] = true;
                        iArr2[3] = jsonParser.E();
                    } else if (i.equals("total_visits_label")) {
                        iArr[55] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video")) {
                        iArr[56] = VideoDetailFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(57);
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
            if (zArr[0]) {
                flatBufferBuilder.a(11, iArr2[0], 0);
            }
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            flatBufferBuilder.b(15, iArr[15]);
            flatBufferBuilder.b(16, iArr[16]);
            flatBufferBuilder.b(17, iArr[17]);
            if (zArr[1]) {
                flatBufferBuilder.a(18, zArr2[0]);
            }
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
            if (zArr[2]) {
                flatBufferBuilder.a(35, iArr2[1], 0);
            }
            flatBufferBuilder.b(36, iArr[36]);
            flatBufferBuilder.b(37, iArr[37]);
            flatBufferBuilder.b(38, iArr[38]);
            if (zArr[3]) {
                flatBufferBuilder.a(39, dArr[0], 0.0d);
            }
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
            if (zArr[4]) {
                flatBufferBuilder.a(52, iArr2[2], 0);
            }
            flatBufferBuilder.b(53, iArr[53]);
            if (zArr[5]) {
                flatBufferBuilder.a(54, iArr2[3], 0);
            }
            flatBufferBuilder.b(55, iArr[55]);
            flatBufferBuilder.b(56, iArr[56]);
            return flatBufferBuilder.d();
        }

        public static void m15706a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("actions");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    ReactionAttachmentActionFragmentParser.m16525b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("album");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("album_artwork_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("artist");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("attribution");
                AttributionParser.m14377a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("badge_count");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("body");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("byline");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("detailed_story");
                GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.a(i, 11, 0);
            if (g != 0) {
                jsonGenerator.a("duration_ms");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 12);
            if (g != 0) {
                jsonGenerator.a("event");
                EventCardFragmentParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("external_image");
                ExternalImageParser.m14380a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("external_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("footer");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 17);
            if (g != 0) {
                jsonGenerator.a("invitee");
                InviteeParser.m14392a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            boolean a = mutableFlatBuffer.a(i, 18);
            if (a) {
                jsonGenerator.a("is_pinned");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 19);
            if (g != 0) {
                jsonGenerator.a("item");
                ItemParser.m14397a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 20);
            if (g != 0) {
                jsonGenerator.a("label");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 21);
            if (g != 0) {
                jsonGenerator.a("left_subtitle");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 22);
            if (g != 0) {
                jsonGenerator.a("left_title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 23);
            if (g != 0) {
                jsonGenerator.a("location");
                DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 24);
            if (g != 0) {
                jsonGenerator.a("message");
                MessageParser.m15702a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("page");
                PageParser.m15704a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 26);
            if (g != 0) {
                jsonGenerator.a("page_post");
                GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 27);
            if (g != 0) {
                jsonGenerator.a("page_product");
                PageProductParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 28);
            if (g != 0) {
                jsonGenerator.a("page_service");
                PageServiceItemParser.m11184b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 29);
            if (g != 0) {
                jsonGenerator.a("photo");
                SizeAwareMediaParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 30) != 0) {
                jsonGenerator.a("pin_subtitle");
                jsonGenerator.b(mutableFlatBuffer.c(i, 30));
            }
            if (mutableFlatBuffer.g(i, 31) != 0) {
                jsonGenerator.a("pin_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 31));
            }
            g = mutableFlatBuffer.g(i, 32);
            if (g != 0) {
                jsonGenerator.a("place_question");
                PlaceQuestionFieldsParser.m2484b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 33);
            if (g != 0) {
                jsonGenerator.a("place_survey_thank_you_subtitle");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 34);
            if (g != 0) {
                jsonGenerator.a("place_survey_thank_you_title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 35, 0);
            if (g != 0) {
                jsonGenerator.a("position_ms");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 36);
            if (g != 0) {
                jsonGenerator.a("product");
                ProductParser.m14389a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 37);
            if (g != 0) {
                jsonGenerator.a("profile");
                ReactionProfileFieldsParser.m14713a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 38);
            if (g != 0) {
                jsonGenerator.a("published_on");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            double a2 = mutableFlatBuffer.a(i, 39, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("radius");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 40);
            if (g != 0) {
                jsonGenerator.a("reaction_photo_with_attribution");
                PageMediaWithAttributionParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 41);
            if (g != 0) {
                jsonGenerator.a("review_title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 42);
            if (g != 0) {
                jsonGenerator.a("reviewer");
                ReviewerParser.m14384a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 43);
            if (g != 0) {
                jsonGenerator.a("right_subtitle");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 44);
            if (g != 0) {
                jsonGenerator.a("right_title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 45);
            if (g != 0) {
                jsonGenerator.a("scaled_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 46);
            if (g != 0) {
                jsonGenerator.a("song_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 47);
            if (g != 0) {
                jsonGenerator.a("story");
                ReactionStoryAttachmentStoryFragmentParser.m14720a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 48);
            if (g != 0) {
                jsonGenerator.a("story_admin_page");
                StoryAdminPageParser.m14400a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 49);
            if (g != 0) {
                jsonGenerator.a("story_attachments_icon_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 50);
            if (g != 0) {
                jsonGenerator.a("summary");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 51);
            if (g != 0) {
                jsonGenerator.a("topic");
                TopicParser.m15713a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.a(i, 52, 0);
            if (g != 0) {
                jsonGenerator.a("total_likes");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 53);
            if (g != 0) {
                jsonGenerator.a("total_likes_label");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 54, 0);
            if (g != 0) {
                jsonGenerator.a("total_visits");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 55);
            if (g != 0) {
                jsonGenerator.a("total_visits_label");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 56);
            if (g != 0) {
                jsonGenerator.a("video");
                VideoDetailFragmentParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fields_data */
    public final class ReactionStoryFragmentParser {

        /* compiled from: fields_data */
        public final class ReactionAttachmentsParser {

            /* compiled from: fields_data */
            public final class EdgesParser {
                public static int m15707b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = ReactionStoryAttachmentFragmentParser.m15705a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m15708b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        ReactionStoryAttachmentFragmentParser.m15706a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15709a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("actions")) {
                            iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(EdgesParser.m15707b(jsonParser, flatBufferBuilder)));
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
                        } else if (i.equals("page_info")) {
                            iArr[2] = DefaultPageInfoFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("style")) {
                            iArr[3] = flatBufferBuilder.a(GraphQLReactionStoryAttachmentsStyle.fromString(jsonParser.o()));
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

            public static void m15710a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("actions");
                    ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m15708b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("page_info");
                    DefaultPageInfoFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 3));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15711a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("reaction_attachments")) {
                        iArr[0] = ReactionAttachmentsParser.m15709a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fields_data */
    public final class ReactionStoryTopicAttachmentFragmentParser {

        /* compiled from: fields_data */
        public final class TopicParser {
            public static int m15712a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[5];
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
                            iArr[3] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("related_article_title")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
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

            public static void m15713a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("related_article_title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15714a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("topic")) {
                        iArr[0] = TopicParser.m15712a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fields_data */
    public final class ReactionSuggestedEventsQueryFragmentParser {
        public static int m15715a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("reaction_units")) {
                        iArr[0] = ReactionStoriesParser.m15699a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static void m15716a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("reaction_units");
                ReactionStoriesParser.m15700a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fields_data */
    public final class ReactionSuggestedEventsQueryParser {
        public static MutableFlatBuffer m15717a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("suggested_events_reaction_units")) {
                        iArr[0] = ReactionSuggestedEventsQueryFragmentParser.m15715a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fields_data */
    public final class ReactionUnitBadgedProfilesComponentFragmentParser {

        /* compiled from: fields_data */
        public final class BadgableProfilesParser {
            public static int m15720b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("badge_type")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLReactionProfileBadgeType.fromString(jsonParser.o()));
                        } else if (i.equals("profile")) {
                            iArr[1] = ReactionFacepileProfileParser.m14684a(jsonParser, flatBufferBuilder);
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

            public static int m15718a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m15720b(jsonParser, flatBufferBuilder)));
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

            public static void m15719a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m15721b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m15721b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("badge_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("profile");
                    ReactionFacepileProfileParser.m14685b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15722a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("badgable_profiles")) {
                        iArr[1] = BadgableProfilesParser.m15718a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fields_data */
    public final class ReactionUnitDefaultFieldsParser {
        public static int m15723b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[14];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("collapse_state")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLReactionUnitCollapseState.fromString(jsonParser.o()));
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("impression_info")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("page")) {
                        iArr[4] = ReactionPageFieldsWithPlaceTipsInfoParser.m14699a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("reaction_attachments")) {
                        iArr[5] = ReactionAttachmentsParser.m15709a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("reaction_unit_header")) {
                        iArr[6] = ReactionUnitHeaderFieldsParser.m15729a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("settings_token")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("unit_expiration_condition")) {
                        iArr[8] = ReactionUnitExpirationConditionFragmentParser.m15725a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("unit_score")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("unit_style")) {
                        iArr[10] = flatBufferBuilder.a(GraphQLReactionUnitStyle.fromString(jsonParser.o()));
                    } else if (i.equals("unit_type_token")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("welcome_note_message")) {
                        iArr[12] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("welcome_note_photo")) {
                        iArr[13] = SizeAwareMediaParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(14);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            if (zArr[0]) {
                flatBufferBuilder.a(9, iArr2[0], 0);
            }
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            return flatBufferBuilder.d();
        }

        public static void m15724b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("collapse_state");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("impression_info");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            int g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("page");
                ReactionPageFieldsWithPlaceTipsInfoParser.m14700a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("reaction_attachments");
                ReactionAttachmentsParser.m15710a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("reaction_unit_header");
                ReactionUnitHeaderFieldsParser.m15730a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("settings_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("unit_expiration_condition");
                ReactionUnitExpirationConditionFragmentParser.m15726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.a(i, 9, 0);
            if (g != 0) {
                jsonGenerator.a("unit_score");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("unit_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 10));
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("unit_type_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            g = mutableFlatBuffer.g(i, 12);
            if (g != 0) {
                jsonGenerator.a("welcome_note_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("welcome_note_photo");
                SizeAwareMediaParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fields_data */
    public final class ReactionUnitExpirationConditionFragmentParser {
        public static int m15725a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            boolean[] zArr = new boolean[2];
            int[] iArr2 = new int[1];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("radius")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("radius_center")) {
                        iArr[1] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("time")) {
                        zArr[1] = true;
                        jArr[0] = jsonParser.F();
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
                flatBufferBuilder.a(2, jArr[0], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m15726a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("radius");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.g(i, 1);
            if (a != 0) {
                jsonGenerator.a("radius_center");
                DefaultLocationFieldsParser.a(mutableFlatBuffer, a, jsonGenerator);
            }
            long a2 = mutableFlatBuffer.a(i, 2, 0);
            if (a2 != 0) {
                jsonGenerator.a("time");
                jsonGenerator.a(a2);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fields_data */
    public final class ReactionUnitFragmentParser {
        public static int m15727a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[17];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("collapse_state")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLReactionUnitCollapseState.fromString(jsonParser.o()));
                    } else if (i.equals("has_inner_borders")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("id")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("impression_info")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("page")) {
                        iArr[5] = ReactionPageFieldsWithPlaceTipsInfoParser.m14699a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("reaction_aggregated_units")) {
                        iArr[6] = ReactionAggregatedUnitsParser.m15677a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("reaction_attachments")) {
                        iArr[7] = ReactionAttachmentsParser.m15709a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("reaction_unit_components")) {
                        iArr[8] = ReactionUnitComponentParser.m18158b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("reaction_unit_header")) {
                        iArr[9] = ReactionUnitHeaderFieldsParser.m15729a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("settings_token")) {
                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("unit_expiration_condition")) {
                        iArr[11] = ReactionUnitExpirationConditionFragmentParser.m15725a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("unit_score")) {
                        zArr[1] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("unit_style")) {
                        iArr[13] = flatBufferBuilder.a(GraphQLReactionUnitStyle.fromString(jsonParser.o()));
                    } else if (i.equals("unit_type_token")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("welcome_note_message")) {
                        iArr[15] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("welcome_note_photo")) {
                        iArr[16] = SizeAwareMediaParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(17);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, zArr2[0]);
            }
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            if (zArr[1]) {
                flatBufferBuilder.a(12, iArr2[0], 0);
            }
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            flatBufferBuilder.b(15, iArr[15]);
            flatBufferBuilder.b(16, iArr[16]);
            return flatBufferBuilder.d();
        }

        public static void m15728a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("collapse_state");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            boolean a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("has_inner_borders");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("impression_info");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            int g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("page");
                ReactionPageFieldsWithPlaceTipsInfoParser.m14700a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("reaction_aggregated_units");
                ReactionAggregatedUnitsParser.m15678a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("reaction_attachments");
                ReactionAttachmentsParser.m15710a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("reaction_unit_components");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    ReactionUnitComponentParser.m18159b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("reaction_unit_header");
                ReactionUnitHeaderFieldsParser.m15730a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("settings_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("unit_expiration_condition");
                ReactionUnitExpirationConditionFragmentParser.m15726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.a(i, 12, 0);
            if (g != 0) {
                jsonGenerator.a("unit_score");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("unit_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 13));
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("unit_type_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("welcome_note_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("welcome_note_photo");
                SizeAwareMediaParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fields_data */
    public final class ReactionUnitHeaderFieldsParser {
        public static int m15729a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[8];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("action")) {
                        iArr[1] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_style")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLReactionUnitHeaderStyle.fromString(jsonParser.o()));
                    } else if (i.equals("icon_image")) {
                        iArr[3] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[4] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profiles")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(ReactionFacepileProfileParser.m14684a(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr2 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr2, true);
                        }
                        iArr[5] = i2;
                    } else if (i.equals("secondary_actions")) {
                        iArr[6] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_message")) {
                        iArr[7] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            return flatBufferBuilder.d();
        }

        public static void m15730a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("header_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("icon_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("message");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("profiles");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    ReactionFacepileProfileParser.m14685b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("secondary_actions");
                ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("sub_message");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }
}
