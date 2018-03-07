package com.facebook.reaction.protocol.graphql;

import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsAppStoreApplicationGraphQLParser;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.ContextItemsConnectionWithPageInfoFragmentParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryAttachmentDeserializer;
import com.facebook.graphql.deserializers.GraphQLStoryDeserializer;
import com.facebook.graphql.enums.GraphQLAcornLocationType;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.facebook.graphql.enums.GraphQLImageSizingStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLReactionCoreButtonGlyphAlignment;
import com.facebook.graphql.enums.GraphQLReactionCoreImageTextImageSize;
import com.facebook.graphql.enums.GraphQLReactionProfileBadgeType;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.enums.GraphQLSelectedActionState;
import com.facebook.graphql.enums.GraphQLVideoChannelFeedUnitPruneBehavior;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetRedirectionLinkGraphQLParser.RedirectionInfoParser;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.LinkableTextWithEntitiesParser;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.LinkableTextWithEntitiesRangeParser;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultPageInfoFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultTimeRangeFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.linkify.LinkifyTargetGraphQLParsers.LinkifyTargetGraphQLParser.ProfilePictureParser;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLParsers.PageServiceItemParser;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLParsers.VideoDetailFragmentParser;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLParsers.SizeAwareMediaParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.PlaceInfoBlurbFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionFacepileProfileParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionGeoRectangleFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionImageFieldsParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionStoryAttachmentStoryFragmentParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLParsers.ReactionTextWithEntitiesWithImagesParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFragmentParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionPageContextRowsPlaceholderComponentFragmentParser.PageParser.OverallStarRatingParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionReviewUnitComponentFragmentParser.SpotlightStoryPreviewParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitFriendRequestListComponentFragmentParser.FriendingPossibilitiesParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitGametimeFanFavoriteComponentFragmentParser.AwayVotingPageParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitGametimeFanFavoriteComponentFragmentParser.HomeVotingPageParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitGametimeTableComponentFragmentParser.TypedDataParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitPhotoComponentFragmentParser.PhotoParser;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLParsers.ReactionCoreComponentBorderSpecFieldsParser;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLParsers.ReactionCoreComponentMarginSpecFieldsParser;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLParsers.ReactionCoreComponentPaddingSpecFieldsParser;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLParsers.ReactionCoreComponentTextSpecFieldsParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionUnitBadgedProfilesComponentFragmentParser.BadgableProfilesParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionStoryAttachmentActionFragmentParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.VideoTopicFragmentParser;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.StoryHeaderSectionOnClickGraphQLParser.AppSectionParser;
import com.facebook.video.videohome.protocol.VideoHomeQueryParsers.VideoHomeCreatorYouShouldFollowParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: fetch_successful */
public class ReactionUnitComponentsGraphQLParsers {

    /* compiled from: fetch_successful */
    public final class ReactionAPlaceForFooterCardComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class BackgroundImageParser {
            public static int m18018a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18019a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

        /* compiled from: fetch_successful */
        public final class FaviconParser {
            public static int m18020a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18021a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18022a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("background_image")) {
                        iArr[0] = BackgroundImageParser.m18018a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("background_video_uri")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("favicon")) {
                        iArr[2] = FaviconParser.m18020a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[3] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionAPlaceForHeaderCardComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class BackgroundImageParser {
            public static int m18023a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18024a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

        /* compiled from: fetch_successful */
        public final class ProfileImageParser {
            public static int m18025a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("uri")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("width")) {
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

            public static void m18026a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int a = mutableFlatBuffer.a(i, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("width");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m18027a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[8];
            boolean[] zArr = new boolean[1];
            double[] dArr = new double[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("background_image")) {
                        iArr[0] = BackgroundImageParser.m18023a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("background_video_uri")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("message")) {
                        iArr[2] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_color")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profile_image")) {
                        iArr[4] = ProfileImageParser.m18025a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_image_background_height_ratio")) {
                        zArr[0] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("sub_message")) {
                        iArr[6] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_message_color")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
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
            if (zArr[0]) {
                flatBufferBuilder.a(5, dArr[0], 0.0d);
            }
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            return flatBufferBuilder.d();
        }

        public static void m18028a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("background_image");
                BackgroundImageParser.m18024a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("background_video_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("message_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("profile_image");
                ProfileImageParser.m18026a(mutableFlatBuffer, g, jsonGenerator);
            }
            double a = mutableFlatBuffer.a(i, 5, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("profile_image_background_height_ratio");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("sub_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("sub_message_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionAPlaceForStoryCardComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class HeroImageParser {
            public static int m18029a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18030a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m18031a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("bottom_border")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("hero_image")) {
                        iArr[1] = HeroImageParser.m18029a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hero_video_uri")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("message")) {
                        iArr[3] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(4);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionCrisisActionComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class CrisisParser {
            public static int m18032a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18033a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m18034a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action_default_message")) {
                        iArr[0] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("action_style")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLReactionStoryActionStyle.fromString(jsonParser.o()));
                    } else if (i.equals("crisis")) {
                        iArr[2] = CrisisParser.m18032a(jsonParser, flatBufferBuilder);
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

        public static void m18035a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("action_default_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("action_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("crisis");
                CrisisParser.m18033a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionExpandableSubComponentFragmentParser {
        public static int m18036a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[211];
            boolean[] zArr = new boolean[30];
            boolean[] zArr2 = new boolean[13];
            int[] iArr2 = new int[6];
            long[] jArr = new long[1];
            double[] dArr = new double[10];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("action")) {
                        iArr[1] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("actions")) {
                        iArr[2] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("album")) {
                        iArr[3] = AlbumParser.m18213a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("all_cards_enabled_message")) {
                        iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("all_cards_enabled_submessage")) {
                        iArr[5] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("auto_execute_action_delay")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("auto_paginate_count")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("aux_action")) {
                        iArr[8] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("aux_message")) {
                        iArr[9] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("auxiliary_action")) {
                        iArr[10] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("away_voting_page")) {
                        iArr[11] = AwayVotingPageParser.m15226a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("background_color")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("background_image")) {
                        iArr[13] = BackgroundImageParser.m18107a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("background_video_uri")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("badgable_profiles")) {
                        iArr[15] = BadgableProfilesParser.m15718a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("badge_icon")) {
                        iArr[16] = BadgeIconParser.m18058a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("bar_message")) {
                        iArr[17] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("boosted_component_status")) {
                        iArr[18] = flatBufferBuilder.a(GraphQLBoostedComponentStatus.fromString(jsonParser.o()));
                    } else if (i.equals("border_color")) {
                        iArr[19] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("bottom_border")) {
                        zArr[2] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("breadcrumbs")) {
                        iArr[21] = BreadcrumbsParser.m18109a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("card_action")) {
                        iArr[22] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("category_name")) {
                        iArr[23] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("center_location")) {
                        iArr[24] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("close_action")) {
                        iArr[25] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("comment")) {
                        iArr[26] = CommentParser.m18104a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("component_logical_path")) {
                        iArr[27] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("component_style")) {
                        iArr[28] = flatBufferBuilder.a(GraphQLReactionUnitComponentStyle.fromString(jsonParser.o()));
                    } else if (i.equals("component_tracking_data")) {
                        iArr[29] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("context_list")) {
                        iArr[30] = ContextListParser.m18231a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_attribute_aspect_ratio_value")) {
                        zArr[3] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("core_attribute_background_color")) {
                        iArr[32] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("core_attribute_border")) {
                        iArr[33] = ReactionCoreComponentBorderSpecFieldsParser.m15284a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_attribute_glyph_alignment")) {
                        iArr[34] = flatBufferBuilder.a(GraphQLReactionCoreButtonGlyphAlignment.fromString(jsonParser.o()));
                    } else if (i.equals("core_attribute_image_size")) {
                        iArr[35] = flatBufferBuilder.a(GraphQLReactionCoreImageTextImageSize.fromString(jsonParser.o()));
                    } else if (i.equals("core_attribute_margin")) {
                        iArr[36] = ReactionCoreComponentMarginSpecFieldsParser.m15286a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_attribute_padding")) {
                        iArr[37] = ReactionCoreComponentPaddingSpecFieldsParser.m15288a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_glyph")) {
                        iArr[38] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_image")) {
                        iArr[39] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("counts")) {
                        iArr[40] = CountsParser.m18160a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("cover_photo")) {
                        iArr[41] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("customer_data")) {
                        iArr[42] = CustomerDataParser.m18054a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("date_summary_text")) {
                        iArr[43] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("date_summary_text_long")) {
                        iArr[44] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("date_text")) {
                        iArr[45] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("day_time_text")) {
                        iArr[46] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("decoration_icon")) {
                        iArr[47] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("description")) {
                        iArr[48] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("detail_items")) {
                        iArr[49] = DefaultTextWithEntitiesFieldsParser.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("display_decision")) {
                        iArr[50] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                    } else if (i.equals("distance_string")) {
                        iArr[51] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("distance_text")) {
                        iArr[52] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("empty_state_action")) {
                        iArr[53] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("example_frame_image")) {
                        iArr[54] = ExampleFrameImageParser.m18068a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("explore_feed")) {
                        iArr[55] = VideoTopicFragmentParser.m19021a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("facepile")) {
                        iArr[56] = FacepileParser.m18222a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("favicon")) {
                        iArr[57] = FaviconParser.m18020a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feed_unit")) {
                        iArr[58] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("first_value")) {
                        iArr[59] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("first_value_description")) {
                        iArr[60] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("footer")) {
                        iArr[61] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("friending_possibilities")) {
                        iArr[62] = FriendingPossibilitiesParser.m15221a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_id")) {
                        iArr[63] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("has_bottom_border")) {
                        zArr[4] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("has_disabled_units")) {
                        zArr[5] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("has_inner_borders")) {
                        zArr[6] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("has_top_border")) {
                        zArr[7] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("header")) {
                        iArr[68] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_image100")) {
                        iArr[69] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_text")) {
                        iArr[70] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hero_image")) {
                        iArr[71] = HeroImageParser.m18029a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hero_video_uri")) {
                        iArr[72] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("high_temperature")) {
                        iArr[73] = HighTemperatureParser.m18236a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("highlight_color")) {
                        iArr[74] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("home_voting_page")) {
                        iArr[75] = HomeVotingPageParser.m15228a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hour_ranges")) {
                        iArr[76] = DefaultTimeRangeFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon")) {
                        iArr[77] = IconParser.m18113a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image")) {
                        iArr[78] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image_after")) {
                        iArr[79] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image_before")) {
                        iArr[80] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image")) {
                        iArr[81] = ImageParser.m18115a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image_background")) {
                        iArr[82] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image_block_image")) {
                        iArr[83] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image_block_image_48")) {
                        iArr[84] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("images")) {
                        iArr[85] = ReactionImageFieldsParser.m14693b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("images_with_overlay")) {
                        iArr[86] = ImagesWithOverlayParser.m18170a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("impressum")) {
                        iArr[87] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("impressum_action")) {
                        iArr[88] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_join_request_sent")) {
                        zArr[8] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("is_pinned")) {
                        zArr[9] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("is_place_tip")) {
                        zArr[10] = true;
                        zArr2[7] = jsonParser.H();
                    } else if (i.equals("is_saved_place")) {
                        zArr[11] = true;
                        zArr2[8] = jsonParser.H();
                    } else if (i.equals("is_self_location")) {
                        zArr[12] = true;
                        zArr2[9] = jsonParser.H();
                    } else if (i.equals("is_verified")) {
                        zArr[13] = true;
                        zArr2[10] = jsonParser.H();
                    } else if (i.equals("label_one")) {
                        iArr[95] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("label_one_color")) {
                        iArr[96] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("label_two")) {
                        iArr[97] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("label_two_color")) {
                        iArr[98] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_color")) {
                        iArr[99] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_label")) {
                        iArr[100] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_value")) {
                        zArr[14] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("location")) {
                        iArr[102] = LocationParser.m18117a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location_text")) {
                        iArr[103] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location_type")) {
                        iArr[104] = flatBufferBuilder.a(GraphQLAcornLocationType.fromString(jsonParser.o()));
                    } else if (i.equals("locations")) {
                        iArr[105] = LocationsParser.m18195a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("low_temperature")) {
                        iArr[106] = LowTemperatureParser.m18238a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("main_info")) {
                        iArr[107] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("map_bounding_box")) {
                        iArr[108] = ReactionGeoRectangleFieldsParser.m14688a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("match")) {
                        iArr[109] = MatchParser.m18133a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[110] = MessageParser.m18141a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_after")) {
                        iArr[111] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_before")) {
                        iArr[112] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_color")) {
                        iArr[113] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("message_snippet")) {
                        iArr[114] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("month_text")) {
                        iArr[115] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("notifications_default_count")) {
                        zArr[15] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("notifications_empty_message")) {
                        iArr[117] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("notifications_inline_expansion_count")) {
                        zArr[16] = true;
                        iArr2[3] = jsonParser.E();
                    } else if (i.equals("notifications_inline_expansion_message")) {
                        iArr[119] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("notifications_view_all_message")) {
                        iArr[120] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("only_display_status")) {
                        zArr[17] = true;
                        zArr2[11] = jsonParser.H();
                    } else if (i.equals("open_album_actions")) {
                        iArr[122] = ReactionUnitOpenAlbumActionsFragmentParser.m18191a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("other_user_name")) {
                        iArr[123] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[124] = PageParser.m18143a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("percent_of_goal_reached")) {
                        zArr[18] = true;
                        dArr[2] = jsonParser.G();
                    } else if (i.equals("phone_number_action")) {
                        iArr[126] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("phone_text")) {
                        iArr[127] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photo")) {
                        iArr[128] = PhotoParser.m15240a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photo_attachments")) {
                        iArr[129] = GraphQLStoryAttachmentDeserializer.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photos")) {
                        iArr[130] = SizeAwareMediaParser.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_category")) {
                        iArr[131] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_image")) {
                        iArr[132] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_breadcrumbs")) {
                        iArr[133] = PlaceInfoBlurbBreadcrumbsParser.m18216a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_page")) {
                        iArr[134] = PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_rating")) {
                        zArr[19] = true;
                        dArr[3] = jsonParser.G();
                    } else if (i.equals("place_metadata_page")) {
                        iArr[136] = PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_type")) {
                        iArr[137] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                    } else if (i.equals("plays")) {
                        iArr[138] = GametimeDataFactFragmentParser.m15184b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("price_range")) {
                        iArr[139] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("primary_icon")) {
                        iArr[140] = PrimaryIconParser.m18175a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("primary_message")) {
                        iArr[141] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("primary_spec")) {
                        iArr[142] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_image")) {
                        iArr[143] = ProfileImageParser.m18025a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_image_background_height_ratio")) {
                        zArr[20] = true;
                        dArr[4] = jsonParser.G();
                    } else if (i.equals("profile_photo")) {
                        iArr[145] = ProfilePhotoParser.m18070a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profiles")) {
                        iArr[146] = ProfilesParser.m18145a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("progress_bar_color")) {
                        iArr[147] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("progress_segments")) {
                        iArr[148] = ProgressSegmentsParser.m18073a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("prompt_text")) {
                        iArr[149] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("prune_behavior")) {
                        iArr[150] = flatBufferBuilder.a(GraphQLVideoChannelFeedUnitPruneBehavior.fromString(jsonParser.o()));
                    } else if (i.equals("publisher_context")) {
                        iArr[151] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("rating_count")) {
                        zArr[21] = true;
                        dArr[5] = jsonParser.G();
                    } else if (i.equals("rating_message")) {
                        iArr[153] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("rating_scale")) {
                        zArr[22] = true;
                        dArr[6] = jsonParser.G();
                    } else if (i.equals("rating_value")) {
                        zArr[23] = true;
                        dArr[7] = jsonParser.G();
                    } else if (i.equals("recommendation_context")) {
                        iArr[156] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("response_delay")) {
                        iArr[157] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("responsive_badge")) {
                        iArr[158] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("responsive_badge_color")) {
                        iArr[159] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("review_count_message")) {
                        iArr[160] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("right_color")) {
                        iArr[161] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("right_label")) {
                        iArr[162] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("right_value")) {
                        zArr[24] = true;
                        dArr[8] = jsonParser.G();
                    } else if (i.equals("second_value")) {
                        iArr[164] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("second_value_description")) {
                        iArr[165] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secondary_actions")) {
                        iArr[166] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secondary_message")) {
                        iArr[167] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secondary_spec")) {
                        iArr[168] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("see_all_ratings_action")) {
                        iArr[169] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("service")) {
                        iArr[170] = PageServiceItemParser.m11181a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("services")) {
                        iArr[171] = PageServiceItemParser.m11183b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("should_upsell_location")) {
                        zArr[25] = true;
                        zArr2[12] = jsonParser.H();
                    } else if (i.equals("sports_fact")) {
                        iArr[173] = GametimeDataFactFragmentParser.m15182a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("spotlight_story_preview")) {
                        iArr[174] = SpotlightStoryPreviewParser.m15209a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("status_message")) {
                        iArr[175] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("status_text")) {
                        iArr[176] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("story")) {
                        iArr[177] = ReactionStoryAttachmentStoryFragmentParser.m14719a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_component_width_ratio")) {
                        zArr[26] = true;
                        dArr[9] = jsonParser.G();
                    } else if (i.equals("sub_components")) {
                        iArr[179] = ReactionUnitSubComponentParser.m18229b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_message")) {
                        iArr[180] = SubMessageParser.m18149a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_message_color")) {
                        iArr[181] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("subheader")) {
                        iArr[182] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submessage")) {
                        iArr[183] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submessage_after")) {
                        iArr[184] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submessage_before")) {
                        iArr[185] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subtitle")) {
                        iArr[186] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temperature")) {
                        iArr[187] = TemperatureParser.m18240a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temperature_text")) {
                        iArr[188] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_message")) {
                        iArr[189] = TertiaryMessageParser.m18151a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_spec")) {
                        iArr[190] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_title")) {
                        iArr[191] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("text_color")) {
                        iArr[192] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("time_bucket")) {
                        iArr[193] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("timestamp")) {
                        zArr[27] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("timezone")) {
                        iArr[195] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("title")) {
                        iArr[196] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("total_votes")) {
                        zArr[28] = true;
                        iArr2[4] = jsonParser.E();
                    } else if (i.equals("truncation_string")) {
                        iArr[198] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("typed_data")) {
                        iArr[199] = TypedDataParser.m15231a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("typed_headers")) {
                        iArr[200] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("venue_name")) {
                        iArr[201] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video")) {
                        iArr[202] = VideoDetailFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video_channel")) {
                        iArr[203] = VideoHomeCreatorYouShouldFollowParser.m19748a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("weather_icon")) {
                        iArr[204] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("weather_tap_action")) {
                        iArr[205] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("website")) {
                        iArr[206] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("website_action")) {
                        iArr[207] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("write_review_action")) {
                        iArr[208] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("xout_nux_type")) {
                        iArr[209] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("zoom_level")) {
                        zArr[29] = true;
                        iArr2[5] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(211);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            if (zArr[0]) {
                flatBufferBuilder.a(6, iArr2[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(7, iArr2[1], 0);
            }
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
            if (zArr[2]) {
                flatBufferBuilder.a(20, zArr2[0]);
            }
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
            if (zArr[3]) {
                flatBufferBuilder.a(31, dArr[0], 0.0d);
            }
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
            flatBufferBuilder.b(61, iArr[61]);
            flatBufferBuilder.b(62, iArr[62]);
            flatBufferBuilder.b(63, iArr[63]);
            if (zArr[4]) {
                flatBufferBuilder.a(64, zArr2[1]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(65, zArr2[2]);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(66, zArr2[3]);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(67, zArr2[4]);
            }
            flatBufferBuilder.b(68, iArr[68]);
            flatBufferBuilder.b(69, iArr[69]);
            flatBufferBuilder.b(70, iArr[70]);
            flatBufferBuilder.b(71, iArr[71]);
            flatBufferBuilder.b(72, iArr[72]);
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
            flatBufferBuilder.b(86, iArr[86]);
            flatBufferBuilder.b(87, iArr[87]);
            flatBufferBuilder.b(88, iArr[88]);
            if (zArr[8]) {
                flatBufferBuilder.a(89, zArr2[5]);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(90, zArr2[6]);
            }
            if (zArr[10]) {
                flatBufferBuilder.a(91, zArr2[7]);
            }
            if (zArr[11]) {
                flatBufferBuilder.a(92, zArr2[8]);
            }
            if (zArr[12]) {
                flatBufferBuilder.a(93, zArr2[9]);
            }
            if (zArr[13]) {
                flatBufferBuilder.a(94, zArr2[10]);
            }
            flatBufferBuilder.b(95, iArr[95]);
            flatBufferBuilder.b(96, iArr[96]);
            flatBufferBuilder.b(97, iArr[97]);
            flatBufferBuilder.b(98, iArr[98]);
            flatBufferBuilder.b(99, iArr[99]);
            flatBufferBuilder.b(100, iArr[100]);
            if (zArr[14]) {
                flatBufferBuilder.a(101, dArr[1], 0.0d);
            }
            flatBufferBuilder.b(102, iArr[102]);
            flatBufferBuilder.b(103, iArr[103]);
            flatBufferBuilder.b(104, iArr[104]);
            flatBufferBuilder.b(105, iArr[105]);
            flatBufferBuilder.b(106, iArr[106]);
            flatBufferBuilder.b(107, iArr[107]);
            flatBufferBuilder.b(108, iArr[108]);
            flatBufferBuilder.b(109, iArr[109]);
            flatBufferBuilder.b(110, iArr[110]);
            flatBufferBuilder.b(111, iArr[111]);
            flatBufferBuilder.b(112, iArr[112]);
            flatBufferBuilder.b(113, iArr[113]);
            flatBufferBuilder.b(114, iArr[114]);
            flatBufferBuilder.b(115, iArr[115]);
            if (zArr[15]) {
                flatBufferBuilder.a(116, iArr2[2], 0);
            }
            flatBufferBuilder.b(117, iArr[117]);
            if (zArr[16]) {
                flatBufferBuilder.a(118, iArr2[3], 0);
            }
            flatBufferBuilder.b(119, iArr[119]);
            flatBufferBuilder.b(120, iArr[120]);
            if (zArr[17]) {
                flatBufferBuilder.a(121, zArr2[11]);
            }
            flatBufferBuilder.b(122, iArr[122]);
            flatBufferBuilder.b(123, iArr[123]);
            flatBufferBuilder.b(124, iArr[124]);
            if (zArr[18]) {
                flatBufferBuilder.a(125, dArr[2], 0.0d);
            }
            flatBufferBuilder.b(126, iArr[126]);
            flatBufferBuilder.b(127, iArr[127]);
            flatBufferBuilder.b(128, iArr[128]);
            flatBufferBuilder.b(129, iArr[129]);
            flatBufferBuilder.b(130, iArr[130]);
            flatBufferBuilder.b(131, iArr[131]);
            flatBufferBuilder.b(132, iArr[132]);
            flatBufferBuilder.b(133, iArr[133]);
            flatBufferBuilder.b(134, iArr[134]);
            if (zArr[19]) {
                flatBufferBuilder.a(135, dArr[3], 0.0d);
            }
            flatBufferBuilder.b(136, iArr[136]);
            flatBufferBuilder.b(137, iArr[137]);
            flatBufferBuilder.b(138, iArr[138]);
            flatBufferBuilder.b(139, iArr[139]);
            flatBufferBuilder.b(140, iArr[140]);
            flatBufferBuilder.b(141, iArr[141]);
            flatBufferBuilder.b(142, iArr[142]);
            flatBufferBuilder.b(143, iArr[143]);
            if (zArr[20]) {
                flatBufferBuilder.a(144, dArr[4], 0.0d);
            }
            flatBufferBuilder.b(145, iArr[145]);
            flatBufferBuilder.b(146, iArr[146]);
            flatBufferBuilder.b(147, iArr[147]);
            flatBufferBuilder.b(148, iArr[148]);
            flatBufferBuilder.b(149, iArr[149]);
            flatBufferBuilder.b(150, iArr[150]);
            flatBufferBuilder.b(151, iArr[151]);
            if (zArr[21]) {
                flatBufferBuilder.a(152, dArr[5], 0.0d);
            }
            flatBufferBuilder.b(153, iArr[153]);
            if (zArr[22]) {
                flatBufferBuilder.a(154, dArr[6], 0.0d);
            }
            if (zArr[23]) {
                flatBufferBuilder.a(155, dArr[7], 0.0d);
            }
            flatBufferBuilder.b(156, iArr[156]);
            flatBufferBuilder.b(157, iArr[157]);
            flatBufferBuilder.b(158, iArr[158]);
            flatBufferBuilder.b(159, iArr[159]);
            flatBufferBuilder.b(160, iArr[160]);
            flatBufferBuilder.b(161, iArr[161]);
            flatBufferBuilder.b(162, iArr[162]);
            if (zArr[24]) {
                flatBufferBuilder.a(163, dArr[8], 0.0d);
            }
            flatBufferBuilder.b(164, iArr[164]);
            flatBufferBuilder.b(165, iArr[165]);
            flatBufferBuilder.b(166, iArr[166]);
            flatBufferBuilder.b(167, iArr[167]);
            flatBufferBuilder.b(168, iArr[168]);
            flatBufferBuilder.b(169, iArr[169]);
            flatBufferBuilder.b(170, iArr[170]);
            flatBufferBuilder.b(171, iArr[171]);
            if (zArr[25]) {
                flatBufferBuilder.a(172, zArr2[12]);
            }
            flatBufferBuilder.b(173, iArr[173]);
            flatBufferBuilder.b(174, iArr[174]);
            flatBufferBuilder.b(175, iArr[175]);
            flatBufferBuilder.b(176, iArr[176]);
            flatBufferBuilder.b(177, iArr[177]);
            if (zArr[26]) {
                flatBufferBuilder.a(178, dArr[9], 0.0d);
            }
            flatBufferBuilder.b(179, iArr[179]);
            flatBufferBuilder.b(180, iArr[180]);
            flatBufferBuilder.b(181, iArr[181]);
            flatBufferBuilder.b(182, iArr[182]);
            flatBufferBuilder.b(183, iArr[183]);
            flatBufferBuilder.b(184, iArr[184]);
            flatBufferBuilder.b(185, iArr[185]);
            flatBufferBuilder.b(186, iArr[186]);
            flatBufferBuilder.b(187, iArr[187]);
            flatBufferBuilder.b(188, iArr[188]);
            flatBufferBuilder.b(189, iArr[189]);
            flatBufferBuilder.b(190, iArr[190]);
            flatBufferBuilder.b(191, iArr[191]);
            flatBufferBuilder.b(192, iArr[192]);
            flatBufferBuilder.b(193, iArr[193]);
            if (zArr[27]) {
                flatBufferBuilder.a(194, jArr[0], 0);
            }
            flatBufferBuilder.b(195, iArr[195]);
            flatBufferBuilder.b(196, iArr[196]);
            if (zArr[28]) {
                flatBufferBuilder.a(197, iArr2[4], 0);
            }
            flatBufferBuilder.b(198, iArr[198]);
            flatBufferBuilder.b(199, iArr[199]);
            flatBufferBuilder.b(200, iArr[200]);
            flatBufferBuilder.b(201, iArr[201]);
            flatBufferBuilder.b(202, iArr[202]);
            flatBufferBuilder.b(203, iArr[203]);
            flatBufferBuilder.b(204, iArr[204]);
            flatBufferBuilder.b(205, iArr[205]);
            flatBufferBuilder.b(206, iArr[206]);
            flatBufferBuilder.b(207, iArr[207]);
            flatBufferBuilder.b(208, iArr[208]);
            flatBufferBuilder.b(209, iArr[209]);
            if (zArr[29]) {
                flatBufferBuilder.a(210, iArr2[5], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m18037a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("actions");
                ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.m18214a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("all_cards_enabled_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("all_cards_enabled_submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 6, 0);
            if (g != 0) {
                jsonGenerator.a("auto_execute_action_delay");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 7, 0);
            if (g != 0) {
                jsonGenerator.a("auto_paginate_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("aux_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("aux_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("auxiliary_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("away_voting_page");
                AwayVotingPageParser.m15227a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("background_image");
                BackgroundImageParser.m18108a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("background_video_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("badgable_profiles");
                BadgableProfilesParser.m15719a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("badge_icon");
                BadgeIconParser.m18059a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 17);
            if (g != 0) {
                jsonGenerator.a("bar_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("boosted_component_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 18));
            }
            if (mutableFlatBuffer.g(i, 19) != 0) {
                jsonGenerator.a("border_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 19));
            }
            boolean a = mutableFlatBuffer.a(i, 20);
            if (a) {
                jsonGenerator.a("bottom_border");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 21);
            if (g != 0) {
                jsonGenerator.a("breadcrumbs");
                BreadcrumbsParser.m18110a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 22);
            if (g != 0) {
                jsonGenerator.a("card_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 23);
            if (g != 0) {
                jsonGenerator.a("category_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 24);
            if (g != 0) {
                jsonGenerator.a("center_location");
                DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("close_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 26);
            if (g != 0) {
                jsonGenerator.a("comment");
                CommentParser.m18105a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 27) != 0) {
                jsonGenerator.a("component_logical_path");
                jsonGenerator.b(mutableFlatBuffer.c(i, 27));
            }
            if (mutableFlatBuffer.g(i, 28) != 0) {
                jsonGenerator.a("component_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 28));
            }
            if (mutableFlatBuffer.g(i, 29) != 0) {
                jsonGenerator.a("component_tracking_data");
                jsonGenerator.b(mutableFlatBuffer.c(i, 29));
            }
            g = mutableFlatBuffer.g(i, 30);
            if (g != 0) {
                jsonGenerator.a("context_list");
                ContextListParser.m18233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            double a2 = mutableFlatBuffer.a(i, 31, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("core_attribute_aspect_ratio_value");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 32) != 0) {
                jsonGenerator.a("core_attribute_background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 32));
            }
            g = mutableFlatBuffer.g(i, 33);
            if (g != 0) {
                jsonGenerator.a("core_attribute_border");
                ReactionCoreComponentBorderSpecFieldsParser.m15285a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 34) != 0) {
                jsonGenerator.a("core_attribute_glyph_alignment");
                jsonGenerator.b(mutableFlatBuffer.b(i, 34));
            }
            if (mutableFlatBuffer.g(i, 35) != 0) {
                jsonGenerator.a("core_attribute_image_size");
                jsonGenerator.b(mutableFlatBuffer.b(i, 35));
            }
            g = mutableFlatBuffer.g(i, 36);
            if (g != 0) {
                jsonGenerator.a("core_attribute_margin");
                ReactionCoreComponentMarginSpecFieldsParser.m15287a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 37);
            if (g != 0) {
                jsonGenerator.a("core_attribute_padding");
                ReactionCoreComponentPaddingSpecFieldsParser.m15289a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 38);
            if (g != 0) {
                jsonGenerator.a("core_glyph");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 39);
            if (g != 0) {
                jsonGenerator.a("core_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 40);
            if (g != 0) {
                jsonGenerator.a("counts");
                CountsParser.m18161a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 41);
            if (g != 0) {
                jsonGenerator.a("cover_photo");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 42);
            if (g != 0) {
                jsonGenerator.a("customer_data");
                CustomerDataParser.m18055a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 43);
            if (g != 0) {
                jsonGenerator.a("date_summary_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 44);
            if (g != 0) {
                jsonGenerator.a("date_summary_text_long");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 45) != 0) {
                jsonGenerator.a("date_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 45));
            }
            g = mutableFlatBuffer.g(i, 46);
            if (g != 0) {
                jsonGenerator.a("day_time_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 47);
            if (g != 0) {
                jsonGenerator.a("decoration_icon");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 48);
            if (g != 0) {
                jsonGenerator.a("description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 49);
            if (g != 0) {
                jsonGenerator.a("detail_items");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 50) != 0) {
                jsonGenerator.a("display_decision");
                jsonGenerator.b(mutableFlatBuffer.b(i, 50));
            }
            if (mutableFlatBuffer.g(i, 51) != 0) {
                jsonGenerator.a("distance_string");
                jsonGenerator.b(mutableFlatBuffer.c(i, 51));
            }
            g = mutableFlatBuffer.g(i, 52);
            if (g != 0) {
                jsonGenerator.a("distance_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 53);
            if (g != 0) {
                jsonGenerator.a("empty_state_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 54);
            if (g != 0) {
                jsonGenerator.a("example_frame_image");
                ExampleFrameImageParser.m18069a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 55);
            if (g != 0) {
                jsonGenerator.a("explore_feed");
                VideoTopicFragmentParser.m19022b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 56);
            if (g != 0) {
                jsonGenerator.a("facepile");
                FacepileParser.m18223a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 57);
            if (g != 0) {
                jsonGenerator.a("favicon");
                FaviconParser.m18021a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 58);
            if (g != 0) {
                jsonGenerator.a("feed_unit");
                GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 59);
            if (g != 0) {
                jsonGenerator.a("first_value");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 60);
            if (g != 0) {
                jsonGenerator.a("first_value_description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 61);
            if (g != 0) {
                jsonGenerator.a("footer");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 62);
            if (g != 0) {
                jsonGenerator.a("friending_possibilities");
                FriendingPossibilitiesParser.m15222a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 63) != 0) {
                jsonGenerator.a("group_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 63));
            }
            a = mutableFlatBuffer.a(i, 64);
            if (a) {
                jsonGenerator.a("has_bottom_border");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 65);
            if (a) {
                jsonGenerator.a("has_disabled_units");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 66);
            if (a) {
                jsonGenerator.a("has_inner_borders");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 67);
            if (a) {
                jsonGenerator.a("has_top_border");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 68);
            if (g != 0) {
                jsonGenerator.a("header");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 69);
            if (g != 0) {
                jsonGenerator.a("header_image100");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 70);
            if (g != 0) {
                jsonGenerator.a("header_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 71);
            if (g != 0) {
                jsonGenerator.a("hero_image");
                HeroImageParser.m18030a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 72) != 0) {
                jsonGenerator.a("hero_video_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 72));
            }
            g = mutableFlatBuffer.g(i, 73);
            if (g != 0) {
                jsonGenerator.a("high_temperature");
                HighTemperatureParser.m18237a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 74) != 0) {
                jsonGenerator.a("highlight_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 74));
            }
            g = mutableFlatBuffer.g(i, 75);
            if (g != 0) {
                jsonGenerator.a("home_voting_page");
                HomeVotingPageParser.m15229a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 76);
            if (g != 0) {
                jsonGenerator.a("hour_ranges");
                DefaultTimeRangeFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 77);
            if (g != 0) {
                jsonGenerator.a("icon");
                IconParser.m18114a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 78);
            if (g != 0) {
                jsonGenerator.a("icon_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 79);
            if (g != 0) {
                jsonGenerator.a("icon_image_after");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 80);
            if (g != 0) {
                jsonGenerator.a("icon_image_before");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 81);
            if (g != 0) {
                jsonGenerator.a("image");
                ImageParser.m18116a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 82) != 0) {
                jsonGenerator.a("image_background");
                jsonGenerator.b(mutableFlatBuffer.c(i, 82));
            }
            g = mutableFlatBuffer.g(i, 83);
            if (g != 0) {
                jsonGenerator.a("image_block_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 84);
            if (g != 0) {
                jsonGenerator.a("image_block_image_48");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 85);
            if (g != 0) {
                jsonGenerator.a("images");
                ReactionImageFieldsParser.m14692a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 86);
            if (g != 0) {
                jsonGenerator.a("images_with_overlay");
                ImagesWithOverlayParser.m18171a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 87);
            if (g != 0) {
                jsonGenerator.a("impressum");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 88);
            if (g != 0) {
                jsonGenerator.a("impressum_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 89);
            if (a) {
                jsonGenerator.a("is_join_request_sent");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 90);
            if (a) {
                jsonGenerator.a("is_pinned");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 91);
            if (a) {
                jsonGenerator.a("is_place_tip");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 92);
            if (a) {
                jsonGenerator.a("is_saved_place");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 93);
            if (a) {
                jsonGenerator.a("is_self_location");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 94);
            if (a) {
                jsonGenerator.a("is_verified");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 95);
            if (g != 0) {
                jsonGenerator.a("label_one");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 96) != 0) {
                jsonGenerator.a("label_one_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 96));
            }
            g = mutableFlatBuffer.g(i, 97);
            if (g != 0) {
                jsonGenerator.a("label_two");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 98) != 0) {
                jsonGenerator.a("label_two_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 98));
            }
            if (mutableFlatBuffer.g(i, 99) != 0) {
                jsonGenerator.a("left_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 99));
            }
            if (mutableFlatBuffer.g(i, 100) != 0) {
                jsonGenerator.a("left_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 100));
            }
            a2 = mutableFlatBuffer.a(i, 101, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("left_value");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 102);
            if (g != 0) {
                jsonGenerator.a("location");
                LocationParser.m18118a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 103);
            if (g != 0) {
                jsonGenerator.a("location_text");
                ReactionTextWithEntitiesWithImagesParser.m14726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 104) != 0) {
                jsonGenerator.a("location_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 104));
            }
            g = mutableFlatBuffer.g(i, 105);
            if (g != 0) {
                jsonGenerator.a("locations");
                LocationsParser.m18197a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 106);
            if (g != 0) {
                jsonGenerator.a("low_temperature");
                LowTemperatureParser.m18239a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 107);
            if (g != 0) {
                jsonGenerator.a("main_info");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 108);
            if (g != 0) {
                jsonGenerator.a("map_bounding_box");
                ReactionGeoRectangleFieldsParser.m14689a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 109);
            if (g != 0) {
                jsonGenerator.a("match");
                MatchParser.m18134a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 110);
            if (g != 0) {
                jsonGenerator.a("message");
                MessageParser.m18142a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 111);
            if (g != 0) {
                jsonGenerator.a("message_after");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 112);
            if (g != 0) {
                jsonGenerator.a("message_before");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 113) != 0) {
                jsonGenerator.a("message_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 113));
            }
            g = mutableFlatBuffer.g(i, 114);
            if (g != 0) {
                jsonGenerator.a("message_snippet");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 115) != 0) {
                jsonGenerator.a("month_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 115));
            }
            g = mutableFlatBuffer.a(i, 116, 0);
            if (g != 0) {
                jsonGenerator.a("notifications_default_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 117);
            if (g != 0) {
                jsonGenerator.a("notifications_empty_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 118, 0);
            if (g != 0) {
                jsonGenerator.a("notifications_inline_expansion_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 119);
            if (g != 0) {
                jsonGenerator.a("notifications_inline_expansion_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 120);
            if (g != 0) {
                jsonGenerator.a("notifications_view_all_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 121);
            if (a) {
                jsonGenerator.a("only_display_status");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 122);
            if (g != 0) {
                jsonGenerator.a("open_album_actions");
                ReactionUnitOpenAlbumActionsFragmentParser.m18192a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 123);
            if (g != 0) {
                jsonGenerator.a("other_user_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 124);
            if (g != 0) {
                jsonGenerator.a("page");
                PageParser.m18144a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 125, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("percent_of_goal_reached");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 126);
            if (g != 0) {
                jsonGenerator.a("phone_number_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 127);
            if (g != 0) {
                jsonGenerator.a("phone_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 128);
            if (g != 0) {
                jsonGenerator.a("photo");
                PhotoParser.m15241a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 129);
            if (g != 0) {
                jsonGenerator.a("photo_attachments");
                GraphQLStoryAttachmentDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 130);
            if (g != 0) {
                jsonGenerator.a("photos");
                SizeAwareMediaParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 131);
            if (g != 0) {
                jsonGenerator.a("place_category");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 132);
            if (g != 0) {
                jsonGenerator.a("place_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 133);
            if (g != 0) {
                jsonGenerator.a("place_info_blurb_breadcrumbs");
                PlaceInfoBlurbBreadcrumbsParser.m18217a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 134);
            if (g != 0) {
                jsonGenerator.a("place_info_blurb_page");
                PlaceInfoBlurbFieldsParser.m14683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 135, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("place_info_blurb_rating");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 136);
            if (g != 0) {
                jsonGenerator.a("place_metadata_page");
                PlaceInfoBlurbFieldsParser.m14683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 137) != 0) {
                jsonGenerator.a("place_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 137));
            }
            g = mutableFlatBuffer.g(i, 138);
            if (g != 0) {
                jsonGenerator.a("plays");
                GametimeDataFactFragmentParser.m15183a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 139) != 0) {
                jsonGenerator.a("price_range");
                jsonGenerator.b(mutableFlatBuffer.c(i, 139));
            }
            g = mutableFlatBuffer.g(i, 140);
            if (g != 0) {
                jsonGenerator.a("primary_icon");
                PrimaryIconParser.m18176a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 141);
            if (g != 0) {
                jsonGenerator.a("primary_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 142);
            if (g != 0) {
                jsonGenerator.a("primary_spec");
                ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 143);
            if (g != 0) {
                jsonGenerator.a("profile_image");
                ProfileImageParser.m18026a(mutableFlatBuffer, g, jsonGenerator);
            }
            a2 = mutableFlatBuffer.a(i, 144, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("profile_image_background_height_ratio");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 145);
            if (g != 0) {
                jsonGenerator.a("profile_photo");
                ProfilePhotoParser.m18071a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 146);
            if (g != 0) {
                jsonGenerator.a("profiles");
                ProfilesParser.m18146a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 147) != 0) {
                jsonGenerator.a("progress_bar_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 147));
            }
            g = mutableFlatBuffer.g(i, 148);
            if (g != 0) {
                jsonGenerator.a("progress_segments");
                ProgressSegmentsParser.m18075a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 149) != 0) {
                jsonGenerator.a("prompt_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 149));
            }
            if (mutableFlatBuffer.g(i, 150) != 0) {
                jsonGenerator.a("prune_behavior");
                jsonGenerator.b(mutableFlatBuffer.b(i, 150));
            }
            g = mutableFlatBuffer.g(i, 151);
            if (g != 0) {
                jsonGenerator.a("publisher_context");
                ReactionTextWithEntitiesWithImagesParser.m14726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 152, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("rating_count");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 153);
            if (g != 0) {
                jsonGenerator.a("rating_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a2 = mutableFlatBuffer.a(i, 154, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("rating_scale");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 155, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("rating_value");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 156);
            if (g != 0) {
                jsonGenerator.a("recommendation_context");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 157);
            if (g != 0) {
                jsonGenerator.a("response_delay");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 158);
            if (g != 0) {
                jsonGenerator.a("responsive_badge");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 159) != 0) {
                jsonGenerator.a("responsive_badge_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 159));
            }
            g = mutableFlatBuffer.g(i, 160);
            if (g != 0) {
                jsonGenerator.a("review_count_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 161) != 0) {
                jsonGenerator.a("right_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 161));
            }
            if (mutableFlatBuffer.g(i, 162) != 0) {
                jsonGenerator.a("right_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 162));
            }
            a2 = mutableFlatBuffer.a(i, 163, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("right_value");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 164);
            if (g != 0) {
                jsonGenerator.a("second_value");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 165);
            if (g != 0) {
                jsonGenerator.a("second_value_description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 166);
            if (g != 0) {
                jsonGenerator.a("secondary_actions");
                ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 167);
            if (g != 0) {
                jsonGenerator.a("secondary_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 168);
            if (g != 0) {
                jsonGenerator.a("secondary_spec");
                ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 169);
            if (g != 0) {
                jsonGenerator.a("see_all_ratings_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 170);
            if (g != 0) {
                jsonGenerator.a("service");
                PageServiceItemParser.m11184b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 171);
            if (g != 0) {
                jsonGenerator.a("services");
                PageServiceItemParser.m11182a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 172);
            if (a) {
                jsonGenerator.a("should_upsell_location");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 173);
            if (g != 0) {
                jsonGenerator.a("sports_fact");
                GametimeDataFactFragmentParser.m15185b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 174);
            if (g != 0) {
                jsonGenerator.a("spotlight_story_preview");
                SpotlightStoryPreviewParser.m15210a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 175);
            if (g != 0) {
                jsonGenerator.a("status_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 176) != 0) {
                jsonGenerator.a("status_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 176));
            }
            g = mutableFlatBuffer.g(i, 177);
            if (g != 0) {
                jsonGenerator.a("story");
                ReactionStoryAttachmentStoryFragmentParser.m14720a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 178, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("sub_component_width_ratio");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 179);
            if (g != 0) {
                jsonGenerator.a("sub_components");
                ReactionUnitSubComponentParser.m18228a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 180);
            if (g != 0) {
                jsonGenerator.a("sub_message");
                SubMessageParser.m18150a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 181) != 0) {
                jsonGenerator.a("sub_message_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 181));
            }
            g = mutableFlatBuffer.g(i, 182);
            if (g != 0) {
                jsonGenerator.a("subheader");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 183);
            if (g != 0) {
                jsonGenerator.a("submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 184);
            if (g != 0) {
                jsonGenerator.a("submessage_after");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 185);
            if (g != 0) {
                jsonGenerator.a("submessage_before");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 186);
            if (g != 0) {
                jsonGenerator.a("subtitle");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 187);
            if (g != 0) {
                jsonGenerator.a("temperature");
                TemperatureParser.m18241a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 188);
            if (g != 0) {
                jsonGenerator.a("temperature_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 189);
            if (g != 0) {
                jsonGenerator.a("tertiary_message");
                TertiaryMessageParser.m18152a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 190);
            if (g != 0) {
                jsonGenerator.a("tertiary_spec");
                ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 191);
            if (g != 0) {
                jsonGenerator.a("tertiary_title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 192) != 0) {
                jsonGenerator.a("text_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 192));
            }
            if (mutableFlatBuffer.g(i, 193) != 0) {
                jsonGenerator.a("time_bucket");
                jsonGenerator.b(mutableFlatBuffer.c(i, 193));
            }
            long a3 = mutableFlatBuffer.a(i, 194, 0);
            if (a3 != 0) {
                jsonGenerator.a("timestamp");
                jsonGenerator.a(a3);
            }
            if (mutableFlatBuffer.g(i, 195) != 0) {
                jsonGenerator.a("timezone");
                jsonGenerator.b(mutableFlatBuffer.c(i, 195));
            }
            g = mutableFlatBuffer.g(i, 196);
            if (g != 0) {
                jsonGenerator.a("title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 197, 0);
            if (g != 0) {
                jsonGenerator.a("total_votes");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 198);
            if (g != 0) {
                jsonGenerator.a("truncation_string");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 199);
            if (g != 0) {
                jsonGenerator.a("typed_data");
                TypedDataParser.m15233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 200) != 0) {
                jsonGenerator.a("typed_headers");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 200), jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 201);
            if (g != 0) {
                jsonGenerator.a("venue_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 202);
            if (g != 0) {
                jsonGenerator.a("video");
                VideoDetailFragmentParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 203);
            if (g != 0) {
                jsonGenerator.a("video_channel");
                VideoHomeCreatorYouShouldFollowParser.m19749a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 204);
            if (g != 0) {
                jsonGenerator.a("weather_icon");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 205);
            if (g != 0) {
                jsonGenerator.a("weather_tap_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 206);
            if (g != 0) {
                jsonGenerator.a("website");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 207);
            if (g != 0) {
                jsonGenerator.a("website_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 208);
            if (g != 0) {
                jsonGenerator.a("write_review_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 209) != 0) {
                jsonGenerator.a("xout_nux_type");
                jsonGenerator.b(mutableFlatBuffer.c(i, 209));
            }
            g = mutableFlatBuffer.a(i, 210, 0);
            if (g != 0) {
                jsonGenerator.a("zoom_level");
                jsonGenerator.b(g);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionMoreComponentsResultParser {

        /* compiled from: fetch_successful */
        public final class ReactionPaginatedComponentsParser {

            /* compiled from: fetch_successful */
            public final class EdgesParser {
                public static int m18038b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = ReactionUnitComponentParser.m18157a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m18039b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        ReactionUnitComponentParser.m18159b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18040a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m18038b(jsonParser, flatBufferBuilder)));
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

            public static void m18041a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m18039b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
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

        public static MutableFlatBuffer m18042a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("reaction_paginated_components")) {
                        iArr[0] = ReactionPaginatedComponentsParser.m18040a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetch_successful */
    public final class ReactionMoreSubComponentsResultParser {

        /* compiled from: fetch_successful */
        public final class ReactionPaginatedComponentsParser {

            /* compiled from: fetch_successful */
            public final class EdgesParser {
                public static int m18043b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = ReactionUnitSubComponentParser.m18227a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m18044b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        ReactionUnitSubComponentParser.m18230b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18045a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m18043b(jsonParser, flatBufferBuilder)));
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

            public static void m18046a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m18044b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
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

        public static MutableFlatBuffer m18047a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("reaction_paginated_components")) {
                        iArr[0] = ReactionPaginatedComponentsParser.m18045a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetch_successful */
    public final class ReactionPageMessageBlockComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class CustomerDataParser {

            /* compiled from: fetch_successful */
            public final class CustomTagLinksParser {

                /* compiled from: fetch_successful */
                public final class NodesParser {

                    /* compiled from: fetch_successful */
                    public final class CustomTagParser {
                        public static int m18048a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[5];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("border_color")) {
                                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("color")) {
                                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("fill_color")) {
                                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("id")) {
                                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("name")) {
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

                        public static void m18049a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            if (mutableFlatBuffer.g(i, 0) != 0) {
                                jsonGenerator.a("border_color");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                            }
                            if (mutableFlatBuffer.g(i, 1) != 0) {
                                jsonGenerator.a("color");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                            }
                            if (mutableFlatBuffer.g(i, 2) != 0) {
                                jsonGenerator.a("fill_color");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                            }
                            if (mutableFlatBuffer.g(i, 3) != 0) {
                                jsonGenerator.a("id");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                            }
                            if (mutableFlatBuffer.g(i, 4) != 0) {
                                jsonGenerator.a("name");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m18050b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("custom_tag")) {
                                    iArr[0] = CustomTagParser.m18048a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m18051b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("custom_tag");
                            CustomTagParser.m18049a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18052a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                        arrayList.add(Integer.valueOf(NodesParser.m18050b(jsonParser, flatBufferBuilder)));
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

                public static void m18053a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("nodes");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            NodesParser.m18051b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.e();
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18054a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("custom_tag_links")) {
                            iArr[0] = CustomTagLinksParser.m18052a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m18055a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("custom_tag_links");
                    CustomTagLinksParser.m18053a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static int m18056a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[8];
            boolean[] zArr = new boolean[1];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("background_color")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("customer_data")) {
                        iArr[2] = CustomerDataParser.m18054a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image_block_image")) {
                        iArr[3] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_snippet")) {
                        iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("other_user_name")) {
                        iArr[5] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_message")) {
                        iArr[6] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("timestamp")) {
                        zArr[0] = true;
                        jArr[0] = jsonParser.F();
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
            if (zArr[0]) {
                flatBufferBuilder.a(7, jArr[0], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m18057a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("customer_data");
                CustomerDataParser.m18055a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("image_block_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("message_snippet");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("other_user_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("tertiary_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            long a = mutableFlatBuffer.a(i, 7, 0);
            if (a != 0) {
                jsonGenerator.a("timestamp");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionPageVeryResponsiveToMessagesComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class BadgeIconParser {
            public static int m18058a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("icon_image")) {
                            iArr[0] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("icon_sizing")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLImageSizingStyle.fromString(jsonParser.o()));
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

            public static void m18059a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("icon_image");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("icon_sizing");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18060a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("badge_icon")) {
                        iArr[1] = BadgeIconParser.m18058a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("response_delay")) {
                        iArr[2] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("responsive_badge")) {
                        iArr[3] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("responsive_badge_color")) {
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionPaginatedComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class PaginatedComponentsParser {

            /* compiled from: fetch_successful */
            public final class ReactionPaginatedComponentsParser {

                /* compiled from: fetch_successful */
                public final class EdgesParser {
                    public static int m18061b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("node")) {
                                    iArr[0] = ReactionUnitSubComponentParser.m18227a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m18062b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("node");
                            ReactionUnitSubComponentParser.m18230b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18063a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                        arrayList.add(Integer.valueOf(EdgesParser.m18061b(jsonParser, flatBufferBuilder)));
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

                public static void m18064a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("edges");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            EdgesParser.m18062b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
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

            public static int m18065a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("reaction_paginated_components")) {
                            iArr[1] = ReactionPaginatedComponentsParser.m18063a(jsonParser, flatBufferBuilder);
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

            public static void m18066a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("reaction_paginated_components");
                    ReactionPaginatedComponentsParser.m18064a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18067a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("paginated_components")) {
                        iArr[0] = PaginatedComponentsParser.m18065a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetch_successful */
    public final class ReactionProfileFrameComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class ExampleFrameImageParser {
            public static int m18068a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18069a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetch_successful */
        public final class ProfilePhotoParser {
            public static int m18070a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18071a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18072a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("example_frame_image")) {
                        iArr[1] = ExampleFrameImageParser.m18068a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[2] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_photo")) {
                        iArr[3] = ProfilePhotoParser.m18070a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionSegmentedProgressBarComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class ProgressSegmentsParser {
            public static int m18076b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("color")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("weight")) {
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

            public static int m18073a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m18076b(jsonParser, flatBufferBuilder)));
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

            public static void m18075a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m18074a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }

            public static void m18074a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int a = mutableFlatBuffer.a(i, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("weight");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18077a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("progress_segments")) {
                        iArr[1] = ProgressSegmentsParser.m18073a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetch_successful */
    public final class ReactionTabSwitcherComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class TabsParser {

            /* compiled from: fetch_successful */
            public final class ComponentParser {
                public static int m18078a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[7];
                    boolean[] zArr = new boolean[3];
                    boolean[] zArr2 = new boolean[3];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("component_style")) {
                                iArr[1] = flatBufferBuilder.a(GraphQLReactionUnitComponentStyle.fromString(jsonParser.o()));
                            } else if (i.equals("empty_state_action")) {
                                iArr[2] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("has_bottom_border")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("has_inner_borders")) {
                                zArr[1] = true;
                                zArr2[1] = jsonParser.H();
                            } else if (i.equals("has_top_border")) {
                                zArr[2] = true;
                                zArr2[2] = jsonParser.H();
                            } else if (i.equals("sub_components")) {
                                iArr[6] = ReactionUnitSubComponentParser.m18229b(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(7);
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
                        flatBufferBuilder.a(5, zArr2[2]);
                    }
                    flatBufferBuilder.b(6, iArr[6]);
                    return flatBufferBuilder.d();
                }

                public static void m18079a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("component_style");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                    }
                    int g = mutableFlatBuffer.g(i, 2);
                    if (g != 0) {
                        jsonGenerator.a("empty_state_action");
                        ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    boolean a = mutableFlatBuffer.a(i, 3);
                    if (a) {
                        jsonGenerator.a("has_bottom_border");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 4);
                    if (a) {
                        jsonGenerator.a("has_inner_borders");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 5);
                    if (a) {
                        jsonGenerator.a("has_top_border");
                        jsonGenerator.a(a);
                    }
                    g = mutableFlatBuffer.g(i, 6);
                    if (g != 0) {
                        jsonGenerator.a("sub_components");
                        ReactionUnitSubComponentParser.m18228a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: fetch_successful */
            public final class LabelParser {
                public static int m18080a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m18081a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("text");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18084b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("component")) {
                            iArr[0] = ComponentParser.m18078a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("label")) {
                            iArr[1] = LabelParser.m18080a(jsonParser, flatBufferBuilder);
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

            public static int m18082a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m18084b(jsonParser, flatBufferBuilder)));
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

            public static void m18083a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m18085b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m18085b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("component");
                    ComponentParser.m18079a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("label");
                    LabelParser.m18081a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18086a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("tabs")) {
                        iArr[0] = TabsParser.m18082a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetch_successful */
    public final class ReactionUnitCommentComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class CommentParser {

            /* compiled from: fetch_successful */
            public final class AttachmentsParser {

                /* compiled from: fetch_successful */
                public final class SourceParser {
                    public static int m18087a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m18088a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("text");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18090b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[7];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("description")) {
                                iArr[0] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("media")) {
                                iArr[1] = SizeAwareMediaParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("media_reference_token")) {
                                iArr[2] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("source")) {
                                iArr[3] = SourceParser.m18087a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("style_list")) {
                                iArr[4] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("title")) {
                                iArr[5] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("url")) {
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
                    flatBufferBuilder.b(4, iArr[4]);
                    flatBufferBuilder.b(5, iArr[5]);
                    flatBufferBuilder.b(6, iArr[6]);
                    return flatBufferBuilder.d();
                }

                public static int m18089a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(m18090b(jsonParser, flatBufferBuilder)));
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

                public static void m18091b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("description");
                        LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("media");
                        SizeAwareMediaParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("media_reference_token");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    g = mutableFlatBuffer.g(i, 3);
                    if (g != 0) {
                        jsonGenerator.a("source");
                        SourceParser.m18088a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 4) != 0) {
                        jsonGenerator.a("style_list");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 4), jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 5) != 0) {
                        jsonGenerator.a("title");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                    }
                    if (mutableFlatBuffer.g(i, 6) != 0) {
                        jsonGenerator.a("url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: fetch_successful */
            public final class AuthorParser {

                /* compiled from: fetch_successful */
                public final class ProfilePictureParser {
                    public static int m18092a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m18093a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18094a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                iArr[3] = ProfilePictureParser.m18092a(jsonParser, flatBufferBuilder);
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

                public static void m18095a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                        ProfilePictureParser.m18093a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: fetch_successful */
            public final class EditHistoryParser {
                public static int m18096a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m18097a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: fetch_successful */
            public final class FeedbackParser {

                /* compiled from: fetch_successful */
                public final class LikersParser {
                    public static int m18098a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m18099a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        int a = mutableFlatBuffer.a(i, 0, 0);
                        if (a != 0) {
                            jsonGenerator.a("count");
                            jsonGenerator.b(a);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18100a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[6];
                    boolean[] zArr = new boolean[3];
                    boolean[] zArr2 = new boolean[3];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("can_viewer_comment")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("can_viewer_like")) {
                                zArr[1] = true;
                                zArr2[1] = jsonParser.H();
                            } else if (i.equals("does_viewer_like")) {
                                zArr[2] = true;
                                zArr2[2] = jsonParser.H();
                            } else if (i.equals("id")) {
                                iArr[3] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("legacy_api_post_id")) {
                                iArr[4] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("likers")) {
                                iArr[5] = LikersParser.m18098a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(6);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, zArr2[0]);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(1, zArr2[1]);
                    }
                    if (zArr[2]) {
                        flatBufferBuilder.a(2, zArr2[2]);
                    }
                    flatBufferBuilder.b(3, iArr[3]);
                    flatBufferBuilder.b(4, iArr[4]);
                    flatBufferBuilder.b(5, iArr[5]);
                    return flatBufferBuilder.d();
                }

                public static void m18101a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    boolean a = mutableFlatBuffer.a(i, 0);
                    if (a) {
                        jsonGenerator.a("can_viewer_comment");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 1);
                    if (a) {
                        jsonGenerator.a("can_viewer_like");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 2);
                    if (a) {
                        jsonGenerator.a("does_viewer_like");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                    }
                    if (mutableFlatBuffer.g(i, 4) != 0) {
                        jsonGenerator.a("legacy_api_post_id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                    }
                    int g = mutableFlatBuffer.g(i, 5);
                    if (g != 0) {
                        jsonGenerator.a("likers");
                        LikersParser.m18099a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: fetch_successful */
            public final class ParentFeedbackParser {
                public static int m18102a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("legacy_api_post_id")) {
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

                public static void m18103a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("legacy_api_post_id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18104a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[7];
                boolean[] zArr = new boolean[1];
                long[] jArr = new long[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("attachments")) {
                            iArr[0] = AttachmentsParser.m18089a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("author")) {
                            iArr[1] = AuthorParser.m18094a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("body")) {
                            iArr[2] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("created_time")) {
                            zArr[0] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("edit_history")) {
                            iArr[4] = EditHistoryParser.m18096a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("feedback")) {
                            iArr[5] = FeedbackParser.m18100a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("parent_feedback")) {
                            iArr[6] = ParentFeedbackParser.m18102a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                if (zArr[0]) {
                    flatBufferBuilder.a(3, jArr[0], 0);
                }
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                return flatBufferBuilder.d();
            }

            public static void m18105a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("attachments");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        AttachmentsParser.m18091b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("author");
                    AuthorParser.m18095a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("body");
                    LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                long a = mutableFlatBuffer.a(i, 3, 0);
                if (a != 0) {
                    jsonGenerator.a("created_time");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("edit_history");
                    EditHistoryParser.m18097a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackParser.m18101a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("parent_feedback");
                    ParentFeedbackParser.m18103a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18106a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("comment")) {
                        iArr[1] = CommentParser.m18104a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetch_successful */
    public final class ReactionUnitComponentFieldsParser {

        /* compiled from: fetch_successful */
        public final class BackgroundImageParser {
            public static int m18107a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18108a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

        /* compiled from: fetch_successful */
        public final class BreadcrumbsParser {
            public static int m18111b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("action")) {
                            iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("text")) {
                            iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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

            public static int m18109a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m18111b(jsonParser, flatBufferBuilder)));
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

            public static void m18110a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m18112b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m18112b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetch_successful */
        public final class IconParser {
            public static int m18113a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18114a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

        /* compiled from: fetch_successful */
        public final class ImageParser {
            public static int m18115a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18116a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

        /* compiled from: fetch_successful */
        public final class LocationParser {
            public static int m18117a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[2];
                double[] dArr = new double[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("latitude")) {
                            zArr[0] = true;
                            dArr[0] = jsonParser.G();
                        } else if (i.equals("longitude")) {
                            zArr[1] = true;
                            dArr[1] = jsonParser.G();
                        } else if (i.equals("timezone")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, dArr[0], 0.0d);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, dArr[1], 0.0d);
                }
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static void m18118a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                double a = mutableFlatBuffer.a(i, 0, 0.0d);
                if (a != 0.0d) {
                    jsonGenerator.a("latitude");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 1, 0.0d);
                if (a != 0.0d) {
                    jsonGenerator.a("longitude");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("timezone");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetch_successful */
        public final class MatchParser {

            /* compiled from: fetch_successful */
            public final class AwayTeamObjectParser {

                /* compiled from: fetch_successful */
                public final class OfficialPageParser {

                    /* compiled from: fetch_successful */
                    public final class PageLogoParser {
                        public static int m18119a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                        public static void m18120a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            if (mutableFlatBuffer.g(i, 0) != 0) {
                                jsonGenerator.a("uri");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m18121a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("page_logo")) {
                                    iArr[0] = PageLogoParser.m18119a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m18122a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("page_logo");
                            PageLogoParser.m18120a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18123a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("official_page")) {
                                iArr[1] = OfficialPageParser.m18121a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("team_shortened_name")) {
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

                public static void m18124a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("official_page");
                        OfficialPageParser.m18122a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("team_shortened_name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: fetch_successful */
            public final class HomeTeamObjectParser {

                /* compiled from: fetch_successful */
                public final class OfficialPageParser {

                    /* compiled from: fetch_successful */
                    public final class PageLogoParser {
                        public static int m18125a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                        public static void m18126a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            if (mutableFlatBuffer.g(i, 0) != 0) {
                                jsonGenerator.a("uri");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m18127a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("page_logo")) {
                                    iArr[0] = PageLogoParser.m18125a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m18128a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("page_logo");
                            PageLogoParser.m18126a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18129a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("official_page")) {
                                iArr[1] = OfficialPageParser.m18127a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("team_shortened_name")) {
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

                public static void m18130a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("official_page");
                        OfficialPageParser.m18128a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("team_shortened_name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: fetch_successful */
            public final class MatchPageParser {
                public static int m18131a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("id")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
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

                public static void m18132a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18133a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[15];
                boolean[] zArr = new boolean[7];
                boolean[] zArr2 = new boolean[2];
                int[] iArr2 = new int[4];
                long[] jArr = new long[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("away_team_fan_count")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("away_team_object")) {
                            iArr[1] = AwayTeamObjectParser.m18123a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("away_team_primary_color")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("away_team_score")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("broadcast_network")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("clock")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("has_match_started")) {
                            zArr[2] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("home_team_fan_count")) {
                            zArr[3] = true;
                            iArr2[2] = jsonParser.E();
                        } else if (i.equals("home_team_object")) {
                            iArr[8] = HomeTeamObjectParser.m18129a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("home_team_primary_color")) {
                            iArr[9] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("home_team_score")) {
                            zArr[4] = true;
                            iArr2[3] = jsonParser.E();
                        } else if (i.equals("id")) {
                            iArr[11] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("match_page")) {
                            iArr[12] = MatchPageParser.m18131a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("scheduled_start_time")) {
                            zArr[5] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("viewer_can_vote_fan_favorite")) {
                            zArr[6] = true;
                            zArr2[1] = jsonParser.H();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(15);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr2[0], 0);
                }
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                if (zArr[1]) {
                    flatBufferBuilder.a(3, iArr2[1], 0);
                }
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                if (zArr[2]) {
                    flatBufferBuilder.a(6, zArr2[0]);
                }
                if (zArr[3]) {
                    flatBufferBuilder.a(7, iArr2[2], 0);
                }
                flatBufferBuilder.b(8, iArr[8]);
                flatBufferBuilder.b(9, iArr[9]);
                if (zArr[4]) {
                    flatBufferBuilder.a(10, iArr2[3], 0);
                }
                flatBufferBuilder.b(11, iArr[11]);
                flatBufferBuilder.b(12, iArr[12]);
                if (zArr[5]) {
                    flatBufferBuilder.a(13, jArr[0], 0);
                }
                if (zArr[6]) {
                    flatBufferBuilder.a(14, zArr2[1]);
                }
                return flatBufferBuilder.d();
            }

            public static void m18134a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("away_team_fan_count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 1);
                if (a != 0) {
                    jsonGenerator.a("away_team_object");
                    AwayTeamObjectParser.m18124a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("away_team_primary_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                a = mutableFlatBuffer.a(i, 3, 0);
                if (a != 0) {
                    jsonGenerator.a("away_team_score");
                    jsonGenerator.b(a);
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("broadcast_network");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("clock");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                boolean a2 = mutableFlatBuffer.a(i, 6);
                if (a2) {
                    jsonGenerator.a("has_match_started");
                    jsonGenerator.a(a2);
                }
                a = mutableFlatBuffer.a(i, 7, 0);
                if (a != 0) {
                    jsonGenerator.a("home_team_fan_count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 8);
                if (a != 0) {
                    jsonGenerator.a("home_team_object");
                    HomeTeamObjectParser.m18130a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("home_team_primary_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                }
                a = mutableFlatBuffer.a(i, 10, 0);
                if (a != 0) {
                    jsonGenerator.a("home_team_score");
                    jsonGenerator.b(a);
                }
                if (mutableFlatBuffer.g(i, 11) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 11));
                }
                a = mutableFlatBuffer.g(i, 12);
                if (a != 0) {
                    jsonGenerator.a("match_page");
                    MatchPageParser.m18132a(mutableFlatBuffer, a, jsonGenerator);
                }
                long a3 = mutableFlatBuffer.a(i, 13, 0);
                if (a3 != 0) {
                    jsonGenerator.a("scheduled_start_time");
                    jsonGenerator.a(a3);
                }
                a2 = mutableFlatBuffer.a(i, 14);
                if (a2) {
                    jsonGenerator.a("viewer_can_vote_fan_favorite");
                    jsonGenerator.a(a2);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetch_successful */
        public final class MessageParser {

            /* compiled from: fetch_successful */
            public final class RangesParser {

                /* compiled from: fetch_successful */
                public final class EntityParser {

                    /* compiled from: fetch_successful */
                    public final class PageParser {
                        public static int m18135a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                        iArr[3] = ProfilePictureParser.a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("url")) {
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

                        public static void m18136a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                                ProfilePictureParser.a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            if (mutableFlatBuffer.g(i, 4) != 0) {
                                jsonGenerator.a("url");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m18137a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[11];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("__type__")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                } else if (i.equals("android_urls")) {
                                    iArr[1] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("app_section")) {
                                    iArr[2] = AppSectionParser.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("backing_application")) {
                                    iArr[3] = GetNativeAppDetailsAppStoreApplicationGraphQLParser.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("id")) {
                                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("name")) {
                                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("page")) {
                                    iArr[6] = PageParser.m18135a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("profile_picture")) {
                                    iArr[7] = com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.ProfilePictureParser.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("redirection_info")) {
                                    iArr[8] = RedirectionInfoParser.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("tag")) {
                                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("url")) {
                                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(11);
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
                        return flatBufferBuilder.d();
                    }

                    public static void m18138a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("__type__");
                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("android_urls");
                            SerializerHelpers.a(mutableFlatBuffer.f(i, 1), jsonGenerator);
                        }
                        int g = mutableFlatBuffer.g(i, 2);
                        if (g != 0) {
                            jsonGenerator.a("app_section");
                            AppSectionParser.a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        g = mutableFlatBuffer.g(i, 3);
                        if (g != 0) {
                            jsonGenerator.a("backing_application");
                            GetNativeAppDetailsAppStoreApplicationGraphQLParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        if (mutableFlatBuffer.g(i, 4) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                        }
                        if (mutableFlatBuffer.g(i, 5) != 0) {
                            jsonGenerator.a("name");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                        }
                        g = mutableFlatBuffer.g(i, 6);
                        if (g != 0) {
                            jsonGenerator.a("page");
                            PageParser.m18136a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        g = mutableFlatBuffer.g(i, 7);
                        if (g != 0) {
                            jsonGenerator.a("profile_picture");
                            com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.ProfilePictureParser.a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        g = mutableFlatBuffer.g(i, 8);
                        if (g != 0) {
                            jsonGenerator.a("redirection_info");
                            RedirectionInfoParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        if (mutableFlatBuffer.g(i, 9) != 0) {
                            jsonGenerator.a("tag");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                        }
                        if (mutableFlatBuffer.g(i, 10) != 0) {
                            jsonGenerator.a("url");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18139b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
                    boolean[] zArr = new boolean[2];
                    int[] iArr2 = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("entity")) {
                                iArr[0] = EntityParser.m18137a(jsonParser, flatBufferBuilder);
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

                public static void m18140b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("entity");
                        EntityParser.m18138a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
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

            public static int m18141a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(RangesParser.m18139b(jsonParser, flatBufferBuilder)));
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

            public static void m18142a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("ranges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        RangesParser.m18140b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
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

        /* compiled from: fetch_successful */
        public final class PageParser {
            public static int m18143a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[8];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("city")) {
                            iArr[0] = CityParser.m18202a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("contextItemRows")) {
                            iArr[1] = ContextItemsConnectionWithPageInfoFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("location")) {
                            iArr[3] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("name")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("overall_star_rating")) {
                            iArr[5] = OverallStarRatingParser.m15202a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("profile_picture")) {
                            iArr[6] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("viewer_profile_permissions")) {
                            iArr[7] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
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

            public static void m18144a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("city");
                    CityParser.m18203a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("contextItemRows");
                    ContextItemsConnectionWithPageInfoFragmentParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("location");
                    DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("overall_star_rating");
                    OverallStarRatingParser.m15203a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 7) != 0) {
                    jsonGenerator.a("viewer_profile_permissions");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 7), jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetch_successful */
        public final class ProfilesParser {
            public static int m18147b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("profilePictureLarge")) {
                            iArr[2] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("profile_picture")) {
                            iArr[3] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
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

            public static int m18145a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m18147b(jsonParser, flatBufferBuilder)));
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

            public static void m18146a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m18148b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m18148b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                    jsonGenerator.a("profilePictureLarge");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetch_successful */
        public final class SubMessageParser {
            public static int m18149a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("ranges")) {
                            iArr[0] = LinkableTextWithEntitiesRangeParser.a(jsonParser, flatBufferBuilder);
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

            public static void m18150a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("ranges");
                    LinkableTextWithEntitiesRangeParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetch_successful */
        public final class TertiaryMessageParser {
            public static int m18151a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("ranges")) {
                            iArr[0] = LinkableTextWithEntitiesRangeParser.a(jsonParser, flatBufferBuilder);
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

            public static void m18152a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("ranges");
                    LinkableTextWithEntitiesRangeParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static int m18155b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[208];
            boolean[] zArr = new boolean[29];
            boolean[] zArr2 = new boolean[12];
            int[] iArr2 = new int[6];
            long[] jArr = new long[1];
            double[] dArr = new double[10];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("action")) {
                        iArr[1] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("actions")) {
                        iArr[2] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("album")) {
                        iArr[3] = AlbumParser.m18213a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("all_cards_enabled_message")) {
                        iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("all_cards_enabled_submessage")) {
                        iArr[5] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("auto_execute_action_delay")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("auto_paginate_count")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("aux_action")) {
                        iArr[8] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("aux_message")) {
                        iArr[9] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("auxiliary_action")) {
                        iArr[10] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("away_voting_page")) {
                        iArr[11] = AwayVotingPageParser.m15226a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("background_color")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("background_image")) {
                        iArr[13] = BackgroundImageParser.m18107a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("background_video_uri")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("badgable_profiles")) {
                        iArr[15] = BadgableProfilesParser.m15718a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("badge_icon")) {
                        iArr[16] = BadgeIconParser.m18058a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("bar_message")) {
                        iArr[17] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("boosted_component_status")) {
                        iArr[18] = flatBufferBuilder.a(GraphQLBoostedComponentStatus.fromString(jsonParser.o()));
                    } else if (i.equals("border_color")) {
                        iArr[19] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("bottom_border")) {
                        zArr[2] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("breadcrumbs")) {
                        iArr[21] = BreadcrumbsParser.m18109a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("card_action")) {
                        iArr[22] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("category_name")) {
                        iArr[23] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("center_location")) {
                        iArr[24] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("close_action")) {
                        iArr[25] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("comment")) {
                        iArr[26] = CommentParser.m18104a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("component_logical_path")) {
                        iArr[27] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("component_style")) {
                        iArr[28] = flatBufferBuilder.a(GraphQLReactionUnitComponentStyle.fromString(jsonParser.o()));
                    } else if (i.equals("component_tracking_data")) {
                        iArr[29] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("context_list")) {
                        iArr[30] = ContextListParser.m18231a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_attribute_aspect_ratio_value")) {
                        zArr[3] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("core_attribute_background_color")) {
                        iArr[32] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("core_attribute_border")) {
                        iArr[33] = ReactionCoreComponentBorderSpecFieldsParser.m15284a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_attribute_glyph_alignment")) {
                        iArr[34] = flatBufferBuilder.a(GraphQLReactionCoreButtonGlyphAlignment.fromString(jsonParser.o()));
                    } else if (i.equals("core_attribute_image_size")) {
                        iArr[35] = flatBufferBuilder.a(GraphQLReactionCoreImageTextImageSize.fromString(jsonParser.o()));
                    } else if (i.equals("core_attribute_margin")) {
                        iArr[36] = ReactionCoreComponentMarginSpecFieldsParser.m15286a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_attribute_padding")) {
                        iArr[37] = ReactionCoreComponentPaddingSpecFieldsParser.m15288a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_glyph")) {
                        iArr[38] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_image")) {
                        iArr[39] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("counts")) {
                        iArr[40] = CountsParser.m18160a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("cover_photo")) {
                        iArr[41] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("customer_data")) {
                        iArr[42] = CustomerDataParser.m18054a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("date_summary_text")) {
                        iArr[43] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("date_summary_text_long")) {
                        iArr[44] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("date_text")) {
                        iArr[45] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("day_time_text")) {
                        iArr[46] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("decoration_icon")) {
                        iArr[47] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("description")) {
                        iArr[48] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("detail_items")) {
                        iArr[49] = DefaultTextWithEntitiesFieldsParser.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("display_decision")) {
                        iArr[50] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                    } else if (i.equals("distance_string")) {
                        iArr[51] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("distance_text")) {
                        iArr[52] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("example_frame_image")) {
                        iArr[53] = ExampleFrameImageParser.m18068a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("explore_feed")) {
                        iArr[54] = VideoTopicFragmentParser.m19021a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("facepile")) {
                        iArr[55] = FacepileParser.m18222a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("favicon")) {
                        iArr[56] = FaviconParser.m18020a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feed_unit")) {
                        iArr[57] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("first_value")) {
                        iArr[58] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("first_value_description")) {
                        iArr[59] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("footer")) {
                        iArr[60] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("friending_possibilities")) {
                        iArr[61] = FriendingPossibilitiesParser.m15221a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_id")) {
                        iArr[62] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("has_bottom_border")) {
                        zArr[4] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("has_disabled_units")) {
                        zArr[5] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("has_top_border")) {
                        zArr[6] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("header")) {
                        iArr[66] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_image100")) {
                        iArr[67] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_text")) {
                        iArr[68] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hero_image")) {
                        iArr[69] = HeroImageParser.m18029a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hero_video_uri")) {
                        iArr[70] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("high_temperature")) {
                        iArr[71] = HighTemperatureParser.m18236a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("highlight_color")) {
                        iArr[72] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("home_voting_page")) {
                        iArr[73] = HomeVotingPageParser.m15228a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hour_ranges")) {
                        iArr[74] = DefaultTimeRangeFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon")) {
                        iArr[75] = IconParser.m18113a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image")) {
                        iArr[76] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image_after")) {
                        iArr[77] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image_before")) {
                        iArr[78] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image")) {
                        iArr[79] = ImageParser.m18115a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image_background")) {
                        iArr[80] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image_block_image")) {
                        iArr[81] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image_block_image_48")) {
                        iArr[82] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("images")) {
                        iArr[83] = ReactionImageFieldsParser.m14693b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("images_with_overlay")) {
                        iArr[84] = ImagesWithOverlayParser.m18170a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("impressum")) {
                        iArr[85] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("impressum_action")) {
                        iArr[86] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_join_request_sent")) {
                        zArr[7] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("is_pinned")) {
                        zArr[8] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("is_place_tip")) {
                        zArr[9] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("is_saved_place")) {
                        zArr[10] = true;
                        zArr2[7] = jsonParser.H();
                    } else if (i.equals("is_self_location")) {
                        zArr[11] = true;
                        zArr2[8] = jsonParser.H();
                    } else if (i.equals("is_verified")) {
                        zArr[12] = true;
                        zArr2[9] = jsonParser.H();
                    } else if (i.equals("label_one")) {
                        iArr[93] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("label_one_color")) {
                        iArr[94] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("label_two")) {
                        iArr[95] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("label_two_color")) {
                        iArr[96] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_color")) {
                        iArr[97] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_label")) {
                        iArr[98] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_value")) {
                        zArr[13] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("location")) {
                        iArr[100] = LocationParser.m18117a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location_text")) {
                        iArr[101] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location_type")) {
                        iArr[102] = flatBufferBuilder.a(GraphQLAcornLocationType.fromString(jsonParser.o()));
                    } else if (i.equals("locations")) {
                        iArr[103] = LocationsParser.m18195a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("low_temperature")) {
                        iArr[104] = LowTemperatureParser.m18238a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("main_info")) {
                        iArr[105] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("map_bounding_box")) {
                        iArr[106] = ReactionGeoRectangleFieldsParser.m14688a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("match")) {
                        iArr[107] = MatchParser.m18133a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[108] = MessageParser.m18141a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_after")) {
                        iArr[109] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_before")) {
                        iArr[110] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_color")) {
                        iArr[111] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("message_snippet")) {
                        iArr[112] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("month_text")) {
                        iArr[113] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("notifications_default_count")) {
                        zArr[14] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("notifications_empty_message")) {
                        iArr[115] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("notifications_inline_expansion_count")) {
                        zArr[15] = true;
                        iArr2[3] = jsonParser.E();
                    } else if (i.equals("notifications_inline_expansion_message")) {
                        iArr[117] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("notifications_view_all_message")) {
                        iArr[118] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("only_display_status")) {
                        zArr[16] = true;
                        zArr2[10] = jsonParser.H();
                    } else if (i.equals("open_album_actions")) {
                        iArr[120] = ReactionUnitOpenAlbumActionsFragmentParser.m18191a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("other_user_name")) {
                        iArr[121] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[122] = PageParser.m18143a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("percent_of_goal_reached")) {
                        zArr[17] = true;
                        dArr[2] = jsonParser.G();
                    } else if (i.equals("phone_number_action")) {
                        iArr[124] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("phone_text")) {
                        iArr[125] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photo")) {
                        iArr[126] = PhotoParser.m15240a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photo_attachments")) {
                        iArr[127] = GraphQLStoryAttachmentDeserializer.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photos")) {
                        iArr[128] = SizeAwareMediaParser.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_category")) {
                        iArr[129] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_image")) {
                        iArr[130] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_breadcrumbs")) {
                        iArr[131] = PlaceInfoBlurbBreadcrumbsParser.m18216a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_page")) {
                        iArr[132] = PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_rating")) {
                        zArr[18] = true;
                        dArr[3] = jsonParser.G();
                    } else if (i.equals("place_metadata_page")) {
                        iArr[134] = PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_type")) {
                        iArr[135] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                    } else if (i.equals("plays")) {
                        iArr[136] = GametimeDataFactFragmentParser.m15184b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("price_range")) {
                        iArr[137] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("primary_icon")) {
                        iArr[138] = PrimaryIconParser.m18175a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("primary_message")) {
                        iArr[139] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("primary_spec")) {
                        iArr[140] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_image")) {
                        iArr[141] = ProfileImageParser.m18025a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_image_background_height_ratio")) {
                        zArr[19] = true;
                        dArr[4] = jsonParser.G();
                    } else if (i.equals("profile_photo")) {
                        iArr[143] = ProfilePhotoParser.m18070a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profiles")) {
                        iArr[144] = ProfilesParser.m18145a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("progress_bar_color")) {
                        iArr[145] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("progress_segments")) {
                        iArr[146] = ProgressSegmentsParser.m18073a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("prompt_text")) {
                        iArr[147] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("prune_behavior")) {
                        iArr[148] = flatBufferBuilder.a(GraphQLVideoChannelFeedUnitPruneBehavior.fromString(jsonParser.o()));
                    } else if (i.equals("publisher_context")) {
                        iArr[149] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("rating_count")) {
                        zArr[20] = true;
                        dArr[5] = jsonParser.G();
                    } else if (i.equals("rating_message")) {
                        iArr[151] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("rating_scale")) {
                        zArr[21] = true;
                        dArr[6] = jsonParser.G();
                    } else if (i.equals("rating_value")) {
                        zArr[22] = true;
                        dArr[7] = jsonParser.G();
                    } else if (i.equals("recommendation_context")) {
                        iArr[154] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("response_delay")) {
                        iArr[155] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("responsive_badge")) {
                        iArr[156] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("responsive_badge_color")) {
                        iArr[157] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("review_count_message")) {
                        iArr[158] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("right_color")) {
                        iArr[159] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("right_label")) {
                        iArr[160] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("right_value")) {
                        zArr[23] = true;
                        dArr[8] = jsonParser.G();
                    } else if (i.equals("second_value")) {
                        iArr[162] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("second_value_description")) {
                        iArr[163] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secondary_actions")) {
                        iArr[164] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secondary_message")) {
                        iArr[165] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secondary_spec")) {
                        iArr[166] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("see_all_ratings_action")) {
                        iArr[167] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("service")) {
                        iArr[168] = PageServiceItemParser.m11181a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("services")) {
                        iArr[169] = PageServiceItemParser.m11183b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("should_upsell_location")) {
                        zArr[24] = true;
                        zArr2[11] = jsonParser.H();
                    } else if (i.equals("sports_fact")) {
                        iArr[171] = GametimeDataFactFragmentParser.m15182a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("spotlight_story_preview")) {
                        iArr[172] = SpotlightStoryPreviewParser.m15209a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("status_message")) {
                        iArr[173] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("status_text")) {
                        iArr[174] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("story")) {
                        iArr[175] = ReactionStoryAttachmentStoryFragmentParser.m14719a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_component_width_ratio")) {
                        zArr[25] = true;
                        dArr[9] = jsonParser.G();
                    } else if (i.equals("sub_message")) {
                        iArr[177] = SubMessageParser.m18149a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_message_color")) {
                        iArr[178] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("subheader")) {
                        iArr[179] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submessage")) {
                        iArr[180] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submessage_after")) {
                        iArr[181] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submessage_before")) {
                        iArr[182] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subtitle")) {
                        iArr[183] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temperature")) {
                        iArr[184] = TemperatureParser.m18240a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temperature_text")) {
                        iArr[185] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_message")) {
                        iArr[186] = TertiaryMessageParser.m18151a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_spec")) {
                        iArr[187] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_title")) {
                        iArr[188] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("text_color")) {
                        iArr[189] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("time_bucket")) {
                        iArr[190] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("timestamp")) {
                        zArr[26] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("timezone")) {
                        iArr[192] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("title")) {
                        iArr[193] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("total_votes")) {
                        zArr[27] = true;
                        iArr2[4] = jsonParser.E();
                    } else if (i.equals("truncation_string")) {
                        iArr[195] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("typed_data")) {
                        iArr[196] = TypedDataParser.m15231a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("typed_headers")) {
                        iArr[197] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("venue_name")) {
                        iArr[198] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video")) {
                        iArr[199] = VideoDetailFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video_channel")) {
                        iArr[200] = VideoHomeCreatorYouShouldFollowParser.m19748a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("weather_icon")) {
                        iArr[201] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("weather_tap_action")) {
                        iArr[202] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("website")) {
                        iArr[203] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("website_action")) {
                        iArr[204] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("write_review_action")) {
                        iArr[205] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("xout_nux_type")) {
                        iArr[206] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("zoom_level")) {
                        zArr[28] = true;
                        iArr2[5] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(208);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            if (zArr[0]) {
                flatBufferBuilder.a(6, iArr2[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(7, iArr2[1], 0);
            }
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
            if (zArr[2]) {
                flatBufferBuilder.a(20, zArr2[0]);
            }
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
            if (zArr[3]) {
                flatBufferBuilder.a(31, dArr[0], 0.0d);
            }
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
            flatBufferBuilder.b(61, iArr[61]);
            flatBufferBuilder.b(62, iArr[62]);
            if (zArr[4]) {
                flatBufferBuilder.a(63, zArr2[1]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(64, zArr2[2]);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(65, zArr2[3]);
            }
            flatBufferBuilder.b(66, iArr[66]);
            flatBufferBuilder.b(67, iArr[67]);
            flatBufferBuilder.b(68, iArr[68]);
            flatBufferBuilder.b(69, iArr[69]);
            flatBufferBuilder.b(70, iArr[70]);
            flatBufferBuilder.b(71, iArr[71]);
            flatBufferBuilder.b(72, iArr[72]);
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
            flatBufferBuilder.b(86, iArr[86]);
            if (zArr[7]) {
                flatBufferBuilder.a(87, zArr2[4]);
            }
            if (zArr[8]) {
                flatBufferBuilder.a(88, zArr2[5]);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(89, zArr2[6]);
            }
            if (zArr[10]) {
                flatBufferBuilder.a(90, zArr2[7]);
            }
            if (zArr[11]) {
                flatBufferBuilder.a(91, zArr2[8]);
            }
            if (zArr[12]) {
                flatBufferBuilder.a(92, zArr2[9]);
            }
            flatBufferBuilder.b(93, iArr[93]);
            flatBufferBuilder.b(94, iArr[94]);
            flatBufferBuilder.b(95, iArr[95]);
            flatBufferBuilder.b(96, iArr[96]);
            flatBufferBuilder.b(97, iArr[97]);
            flatBufferBuilder.b(98, iArr[98]);
            if (zArr[13]) {
                flatBufferBuilder.a(99, dArr[1], 0.0d);
            }
            flatBufferBuilder.b(100, iArr[100]);
            flatBufferBuilder.b(101, iArr[101]);
            flatBufferBuilder.b(102, iArr[102]);
            flatBufferBuilder.b(103, iArr[103]);
            flatBufferBuilder.b(104, iArr[104]);
            flatBufferBuilder.b(105, iArr[105]);
            flatBufferBuilder.b(106, iArr[106]);
            flatBufferBuilder.b(107, iArr[107]);
            flatBufferBuilder.b(108, iArr[108]);
            flatBufferBuilder.b(109, iArr[109]);
            flatBufferBuilder.b(110, iArr[110]);
            flatBufferBuilder.b(111, iArr[111]);
            flatBufferBuilder.b(112, iArr[112]);
            flatBufferBuilder.b(113, iArr[113]);
            if (zArr[14]) {
                flatBufferBuilder.a(114, iArr2[2], 0);
            }
            flatBufferBuilder.b(115, iArr[115]);
            if (zArr[15]) {
                flatBufferBuilder.a(116, iArr2[3], 0);
            }
            flatBufferBuilder.b(117, iArr[117]);
            flatBufferBuilder.b(118, iArr[118]);
            if (zArr[16]) {
                flatBufferBuilder.a(119, zArr2[10]);
            }
            flatBufferBuilder.b(120, iArr[120]);
            flatBufferBuilder.b(121, iArr[121]);
            flatBufferBuilder.b(122, iArr[122]);
            if (zArr[17]) {
                flatBufferBuilder.a(123, dArr[2], 0.0d);
            }
            flatBufferBuilder.b(124, iArr[124]);
            flatBufferBuilder.b(125, iArr[125]);
            flatBufferBuilder.b(126, iArr[126]);
            flatBufferBuilder.b(127, iArr[127]);
            flatBufferBuilder.b(128, iArr[128]);
            flatBufferBuilder.b(129, iArr[129]);
            flatBufferBuilder.b(130, iArr[130]);
            flatBufferBuilder.b(131, iArr[131]);
            flatBufferBuilder.b(132, iArr[132]);
            if (zArr[18]) {
                flatBufferBuilder.a(133, dArr[3], 0.0d);
            }
            flatBufferBuilder.b(134, iArr[134]);
            flatBufferBuilder.b(135, iArr[135]);
            flatBufferBuilder.b(136, iArr[136]);
            flatBufferBuilder.b(137, iArr[137]);
            flatBufferBuilder.b(138, iArr[138]);
            flatBufferBuilder.b(139, iArr[139]);
            flatBufferBuilder.b(140, iArr[140]);
            flatBufferBuilder.b(141, iArr[141]);
            if (zArr[19]) {
                flatBufferBuilder.a(142, dArr[4], 0.0d);
            }
            flatBufferBuilder.b(143, iArr[143]);
            flatBufferBuilder.b(144, iArr[144]);
            flatBufferBuilder.b(145, iArr[145]);
            flatBufferBuilder.b(146, iArr[146]);
            flatBufferBuilder.b(147, iArr[147]);
            flatBufferBuilder.b(148, iArr[148]);
            flatBufferBuilder.b(149, iArr[149]);
            if (zArr[20]) {
                flatBufferBuilder.a(150, dArr[5], 0.0d);
            }
            flatBufferBuilder.b(151, iArr[151]);
            if (zArr[21]) {
                flatBufferBuilder.a(152, dArr[6], 0.0d);
            }
            if (zArr[22]) {
                flatBufferBuilder.a(153, dArr[7], 0.0d);
            }
            flatBufferBuilder.b(154, iArr[154]);
            flatBufferBuilder.b(155, iArr[155]);
            flatBufferBuilder.b(156, iArr[156]);
            flatBufferBuilder.b(157, iArr[157]);
            flatBufferBuilder.b(158, iArr[158]);
            flatBufferBuilder.b(159, iArr[159]);
            flatBufferBuilder.b(160, iArr[160]);
            if (zArr[23]) {
                flatBufferBuilder.a(161, dArr[8], 0.0d);
            }
            flatBufferBuilder.b(162, iArr[162]);
            flatBufferBuilder.b(163, iArr[163]);
            flatBufferBuilder.b(164, iArr[164]);
            flatBufferBuilder.b(165, iArr[165]);
            flatBufferBuilder.b(166, iArr[166]);
            flatBufferBuilder.b(167, iArr[167]);
            flatBufferBuilder.b(168, iArr[168]);
            flatBufferBuilder.b(169, iArr[169]);
            if (zArr[24]) {
                flatBufferBuilder.a(170, zArr2[11]);
            }
            flatBufferBuilder.b(171, iArr[171]);
            flatBufferBuilder.b(172, iArr[172]);
            flatBufferBuilder.b(173, iArr[173]);
            flatBufferBuilder.b(174, iArr[174]);
            flatBufferBuilder.b(175, iArr[175]);
            if (zArr[25]) {
                flatBufferBuilder.a(176, dArr[9], 0.0d);
            }
            flatBufferBuilder.b(177, iArr[177]);
            flatBufferBuilder.b(178, iArr[178]);
            flatBufferBuilder.b(179, iArr[179]);
            flatBufferBuilder.b(180, iArr[180]);
            flatBufferBuilder.b(181, iArr[181]);
            flatBufferBuilder.b(182, iArr[182]);
            flatBufferBuilder.b(183, iArr[183]);
            flatBufferBuilder.b(184, iArr[184]);
            flatBufferBuilder.b(185, iArr[185]);
            flatBufferBuilder.b(186, iArr[186]);
            flatBufferBuilder.b(187, iArr[187]);
            flatBufferBuilder.b(188, iArr[188]);
            flatBufferBuilder.b(189, iArr[189]);
            flatBufferBuilder.b(190, iArr[190]);
            if (zArr[26]) {
                flatBufferBuilder.a(191, jArr[0], 0);
            }
            flatBufferBuilder.b(192, iArr[192]);
            flatBufferBuilder.b(193, iArr[193]);
            if (zArr[27]) {
                flatBufferBuilder.a(194, iArr2[4], 0);
            }
            flatBufferBuilder.b(195, iArr[195]);
            flatBufferBuilder.b(196, iArr[196]);
            flatBufferBuilder.b(197, iArr[197]);
            flatBufferBuilder.b(198, iArr[198]);
            flatBufferBuilder.b(199, iArr[199]);
            flatBufferBuilder.b(200, iArr[200]);
            flatBufferBuilder.b(201, iArr[201]);
            flatBufferBuilder.b(202, iArr[202]);
            flatBufferBuilder.b(203, iArr[203]);
            flatBufferBuilder.b(204, iArr[204]);
            flatBufferBuilder.b(205, iArr[205]);
            flatBufferBuilder.b(206, iArr[206]);
            if (zArr[28]) {
                flatBufferBuilder.a(207, iArr2[5], 0);
            }
            return flatBufferBuilder.d();
        }

        public static int m18153a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m18155b(jsonParser, flatBufferBuilder)));
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

        public static void m18154a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m18156b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m18156b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("actions");
                ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.m18214a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("all_cards_enabled_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("all_cards_enabled_submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 6, 0);
            if (g != 0) {
                jsonGenerator.a("auto_execute_action_delay");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 7, 0);
            if (g != 0) {
                jsonGenerator.a("auto_paginate_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("aux_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("aux_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("auxiliary_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("away_voting_page");
                AwayVotingPageParser.m15227a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("background_image");
                BackgroundImageParser.m18108a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("background_video_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("badgable_profiles");
                BadgableProfilesParser.m15719a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("badge_icon");
                BadgeIconParser.m18059a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 17);
            if (g != 0) {
                jsonGenerator.a("bar_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("boosted_component_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 18));
            }
            if (mutableFlatBuffer.g(i, 19) != 0) {
                jsonGenerator.a("border_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 19));
            }
            boolean a = mutableFlatBuffer.a(i, 20);
            if (a) {
                jsonGenerator.a("bottom_border");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 21);
            if (g != 0) {
                jsonGenerator.a("breadcrumbs");
                BreadcrumbsParser.m18110a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 22);
            if (g != 0) {
                jsonGenerator.a("card_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 23);
            if (g != 0) {
                jsonGenerator.a("category_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 24);
            if (g != 0) {
                jsonGenerator.a("center_location");
                DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("close_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 26);
            if (g != 0) {
                jsonGenerator.a("comment");
                CommentParser.m18105a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 27) != 0) {
                jsonGenerator.a("component_logical_path");
                jsonGenerator.b(mutableFlatBuffer.c(i, 27));
            }
            if (mutableFlatBuffer.g(i, 28) != 0) {
                jsonGenerator.a("component_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 28));
            }
            if (mutableFlatBuffer.g(i, 29) != 0) {
                jsonGenerator.a("component_tracking_data");
                jsonGenerator.b(mutableFlatBuffer.c(i, 29));
            }
            g = mutableFlatBuffer.g(i, 30);
            if (g != 0) {
                jsonGenerator.a("context_list");
                ContextListParser.m18233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            double a2 = mutableFlatBuffer.a(i, 31, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("core_attribute_aspect_ratio_value");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 32) != 0) {
                jsonGenerator.a("core_attribute_background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 32));
            }
            g = mutableFlatBuffer.g(i, 33);
            if (g != 0) {
                jsonGenerator.a("core_attribute_border");
                ReactionCoreComponentBorderSpecFieldsParser.m15285a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 34) != 0) {
                jsonGenerator.a("core_attribute_glyph_alignment");
                jsonGenerator.b(mutableFlatBuffer.b(i, 34));
            }
            if (mutableFlatBuffer.g(i, 35) != 0) {
                jsonGenerator.a("core_attribute_image_size");
                jsonGenerator.b(mutableFlatBuffer.b(i, 35));
            }
            g = mutableFlatBuffer.g(i, 36);
            if (g != 0) {
                jsonGenerator.a("core_attribute_margin");
                ReactionCoreComponentMarginSpecFieldsParser.m15287a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 37);
            if (g != 0) {
                jsonGenerator.a("core_attribute_padding");
                ReactionCoreComponentPaddingSpecFieldsParser.m15289a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 38);
            if (g != 0) {
                jsonGenerator.a("core_glyph");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 39);
            if (g != 0) {
                jsonGenerator.a("core_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 40);
            if (g != 0) {
                jsonGenerator.a("counts");
                CountsParser.m18161a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 41);
            if (g != 0) {
                jsonGenerator.a("cover_photo");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 42);
            if (g != 0) {
                jsonGenerator.a("customer_data");
                CustomerDataParser.m18055a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 43);
            if (g != 0) {
                jsonGenerator.a("date_summary_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 44);
            if (g != 0) {
                jsonGenerator.a("date_summary_text_long");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 45) != 0) {
                jsonGenerator.a("date_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 45));
            }
            g = mutableFlatBuffer.g(i, 46);
            if (g != 0) {
                jsonGenerator.a("day_time_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 47);
            if (g != 0) {
                jsonGenerator.a("decoration_icon");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 48);
            if (g != 0) {
                jsonGenerator.a("description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 49);
            if (g != 0) {
                jsonGenerator.a("detail_items");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 50) != 0) {
                jsonGenerator.a("display_decision");
                jsonGenerator.b(mutableFlatBuffer.b(i, 50));
            }
            if (mutableFlatBuffer.g(i, 51) != 0) {
                jsonGenerator.a("distance_string");
                jsonGenerator.b(mutableFlatBuffer.c(i, 51));
            }
            g = mutableFlatBuffer.g(i, 52);
            if (g != 0) {
                jsonGenerator.a("distance_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 53);
            if (g != 0) {
                jsonGenerator.a("example_frame_image");
                ExampleFrameImageParser.m18069a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 54);
            if (g != 0) {
                jsonGenerator.a("explore_feed");
                VideoTopicFragmentParser.m19022b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 55);
            if (g != 0) {
                jsonGenerator.a("facepile");
                FacepileParser.m18223a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 56);
            if (g != 0) {
                jsonGenerator.a("favicon");
                FaviconParser.m18021a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 57);
            if (g != 0) {
                jsonGenerator.a("feed_unit");
                GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 58);
            if (g != 0) {
                jsonGenerator.a("first_value");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 59);
            if (g != 0) {
                jsonGenerator.a("first_value_description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 60);
            if (g != 0) {
                jsonGenerator.a("footer");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 61);
            if (g != 0) {
                jsonGenerator.a("friending_possibilities");
                FriendingPossibilitiesParser.m15222a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 62) != 0) {
                jsonGenerator.a("group_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 62));
            }
            a = mutableFlatBuffer.a(i, 63);
            if (a) {
                jsonGenerator.a("has_bottom_border");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 64);
            if (a) {
                jsonGenerator.a("has_disabled_units");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 65);
            if (a) {
                jsonGenerator.a("has_top_border");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 66);
            if (g != 0) {
                jsonGenerator.a("header");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 67);
            if (g != 0) {
                jsonGenerator.a("header_image100");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 68);
            if (g != 0) {
                jsonGenerator.a("header_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 69);
            if (g != 0) {
                jsonGenerator.a("hero_image");
                HeroImageParser.m18030a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 70) != 0) {
                jsonGenerator.a("hero_video_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 70));
            }
            g = mutableFlatBuffer.g(i, 71);
            if (g != 0) {
                jsonGenerator.a("high_temperature");
                HighTemperatureParser.m18237a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 72) != 0) {
                jsonGenerator.a("highlight_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 72));
            }
            g = mutableFlatBuffer.g(i, 73);
            if (g != 0) {
                jsonGenerator.a("home_voting_page");
                HomeVotingPageParser.m15229a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 74);
            if (g != 0) {
                jsonGenerator.a("hour_ranges");
                DefaultTimeRangeFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 75);
            if (g != 0) {
                jsonGenerator.a("icon");
                IconParser.m18114a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 76);
            if (g != 0) {
                jsonGenerator.a("icon_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 77);
            if (g != 0) {
                jsonGenerator.a("icon_image_after");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 78);
            if (g != 0) {
                jsonGenerator.a("icon_image_before");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 79);
            if (g != 0) {
                jsonGenerator.a("image");
                ImageParser.m18116a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 80) != 0) {
                jsonGenerator.a("image_background");
                jsonGenerator.b(mutableFlatBuffer.c(i, 80));
            }
            g = mutableFlatBuffer.g(i, 81);
            if (g != 0) {
                jsonGenerator.a("image_block_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 82);
            if (g != 0) {
                jsonGenerator.a("image_block_image_48");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 83);
            if (g != 0) {
                jsonGenerator.a("images");
                ReactionImageFieldsParser.m14692a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 84);
            if (g != 0) {
                jsonGenerator.a("images_with_overlay");
                ImagesWithOverlayParser.m18171a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 85);
            if (g != 0) {
                jsonGenerator.a("impressum");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 86);
            if (g != 0) {
                jsonGenerator.a("impressum_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 87);
            if (a) {
                jsonGenerator.a("is_join_request_sent");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 88);
            if (a) {
                jsonGenerator.a("is_pinned");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 89);
            if (a) {
                jsonGenerator.a("is_place_tip");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 90);
            if (a) {
                jsonGenerator.a("is_saved_place");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 91);
            if (a) {
                jsonGenerator.a("is_self_location");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 92);
            if (a) {
                jsonGenerator.a("is_verified");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 93);
            if (g != 0) {
                jsonGenerator.a("label_one");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 94) != 0) {
                jsonGenerator.a("label_one_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 94));
            }
            g = mutableFlatBuffer.g(i, 95);
            if (g != 0) {
                jsonGenerator.a("label_two");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 96) != 0) {
                jsonGenerator.a("label_two_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 96));
            }
            if (mutableFlatBuffer.g(i, 97) != 0) {
                jsonGenerator.a("left_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 97));
            }
            if (mutableFlatBuffer.g(i, 98) != 0) {
                jsonGenerator.a("left_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 98));
            }
            a2 = mutableFlatBuffer.a(i, 99, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("left_value");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 100);
            if (g != 0) {
                jsonGenerator.a("location");
                LocationParser.m18118a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 101);
            if (g != 0) {
                jsonGenerator.a("location_text");
                ReactionTextWithEntitiesWithImagesParser.m14726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 102) != 0) {
                jsonGenerator.a("location_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 102));
            }
            g = mutableFlatBuffer.g(i, 103);
            if (g != 0) {
                jsonGenerator.a("locations");
                LocationsParser.m18197a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 104);
            if (g != 0) {
                jsonGenerator.a("low_temperature");
                LowTemperatureParser.m18239a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 105);
            if (g != 0) {
                jsonGenerator.a("main_info");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 106);
            if (g != 0) {
                jsonGenerator.a("map_bounding_box");
                ReactionGeoRectangleFieldsParser.m14689a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 107);
            if (g != 0) {
                jsonGenerator.a("match");
                MatchParser.m18134a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 108);
            if (g != 0) {
                jsonGenerator.a("message");
                MessageParser.m18142a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 109);
            if (g != 0) {
                jsonGenerator.a("message_after");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 110);
            if (g != 0) {
                jsonGenerator.a("message_before");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 111) != 0) {
                jsonGenerator.a("message_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 111));
            }
            g = mutableFlatBuffer.g(i, 112);
            if (g != 0) {
                jsonGenerator.a("message_snippet");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 113) != 0) {
                jsonGenerator.a("month_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 113));
            }
            g = mutableFlatBuffer.a(i, 114, 0);
            if (g != 0) {
                jsonGenerator.a("notifications_default_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 115);
            if (g != 0) {
                jsonGenerator.a("notifications_empty_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 116, 0);
            if (g != 0) {
                jsonGenerator.a("notifications_inline_expansion_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 117);
            if (g != 0) {
                jsonGenerator.a("notifications_inline_expansion_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 118);
            if (g != 0) {
                jsonGenerator.a("notifications_view_all_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 119);
            if (a) {
                jsonGenerator.a("only_display_status");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 120);
            if (g != 0) {
                jsonGenerator.a("open_album_actions");
                ReactionUnitOpenAlbumActionsFragmentParser.m18192a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 121);
            if (g != 0) {
                jsonGenerator.a("other_user_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 122);
            if (g != 0) {
                jsonGenerator.a("page");
                PageParser.m18144a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 123, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("percent_of_goal_reached");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 124);
            if (g != 0) {
                jsonGenerator.a("phone_number_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 125);
            if (g != 0) {
                jsonGenerator.a("phone_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 126);
            if (g != 0) {
                jsonGenerator.a("photo");
                PhotoParser.m15241a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 127);
            if (g != 0) {
                jsonGenerator.a("photo_attachments");
                GraphQLStoryAttachmentDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 128);
            if (g != 0) {
                jsonGenerator.a("photos");
                SizeAwareMediaParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 129);
            if (g != 0) {
                jsonGenerator.a("place_category");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 130);
            if (g != 0) {
                jsonGenerator.a("place_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 131);
            if (g != 0) {
                jsonGenerator.a("place_info_blurb_breadcrumbs");
                PlaceInfoBlurbBreadcrumbsParser.m18217a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 132);
            if (g != 0) {
                jsonGenerator.a("place_info_blurb_page");
                PlaceInfoBlurbFieldsParser.m14683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 133, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("place_info_blurb_rating");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 134);
            if (g != 0) {
                jsonGenerator.a("place_metadata_page");
                PlaceInfoBlurbFieldsParser.m14683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 135) != 0) {
                jsonGenerator.a("place_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 135));
            }
            g = mutableFlatBuffer.g(i, 136);
            if (g != 0) {
                jsonGenerator.a("plays");
                GametimeDataFactFragmentParser.m15183a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 137) != 0) {
                jsonGenerator.a("price_range");
                jsonGenerator.b(mutableFlatBuffer.c(i, 137));
            }
            g = mutableFlatBuffer.g(i, 138);
            if (g != 0) {
                jsonGenerator.a("primary_icon");
                PrimaryIconParser.m18176a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 139);
            if (g != 0) {
                jsonGenerator.a("primary_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 140);
            if (g != 0) {
                jsonGenerator.a("primary_spec");
                ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 141);
            if (g != 0) {
                jsonGenerator.a("profile_image");
                ProfileImageParser.m18026a(mutableFlatBuffer, g, jsonGenerator);
            }
            a2 = mutableFlatBuffer.a(i, 142, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("profile_image_background_height_ratio");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 143);
            if (g != 0) {
                jsonGenerator.a("profile_photo");
                ProfilePhotoParser.m18071a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 144);
            if (g != 0) {
                jsonGenerator.a("profiles");
                ProfilesParser.m18146a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 145) != 0) {
                jsonGenerator.a("progress_bar_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 145));
            }
            g = mutableFlatBuffer.g(i, 146);
            if (g != 0) {
                jsonGenerator.a("progress_segments");
                ProgressSegmentsParser.m18075a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 147) != 0) {
                jsonGenerator.a("prompt_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 147));
            }
            if (mutableFlatBuffer.g(i, 148) != 0) {
                jsonGenerator.a("prune_behavior");
                jsonGenerator.b(mutableFlatBuffer.b(i, 148));
            }
            g = mutableFlatBuffer.g(i, 149);
            if (g != 0) {
                jsonGenerator.a("publisher_context");
                ReactionTextWithEntitiesWithImagesParser.m14726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 150, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("rating_count");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 151);
            if (g != 0) {
                jsonGenerator.a("rating_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a2 = mutableFlatBuffer.a(i, 152, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("rating_scale");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 153, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("rating_value");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 154);
            if (g != 0) {
                jsonGenerator.a("recommendation_context");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 155);
            if (g != 0) {
                jsonGenerator.a("response_delay");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 156);
            if (g != 0) {
                jsonGenerator.a("responsive_badge");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 157) != 0) {
                jsonGenerator.a("responsive_badge_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 157));
            }
            g = mutableFlatBuffer.g(i, 158);
            if (g != 0) {
                jsonGenerator.a("review_count_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 159) != 0) {
                jsonGenerator.a("right_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 159));
            }
            if (mutableFlatBuffer.g(i, 160) != 0) {
                jsonGenerator.a("right_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 160));
            }
            a2 = mutableFlatBuffer.a(i, 161, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("right_value");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 162);
            if (g != 0) {
                jsonGenerator.a("second_value");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 163);
            if (g != 0) {
                jsonGenerator.a("second_value_description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 164);
            if (g != 0) {
                jsonGenerator.a("secondary_actions");
                ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 165);
            if (g != 0) {
                jsonGenerator.a("secondary_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 166);
            if (g != 0) {
                jsonGenerator.a("secondary_spec");
                ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 167);
            if (g != 0) {
                jsonGenerator.a("see_all_ratings_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 168);
            if (g != 0) {
                jsonGenerator.a("service");
                PageServiceItemParser.m11184b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 169);
            if (g != 0) {
                jsonGenerator.a("services");
                PageServiceItemParser.m11182a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 170);
            if (a) {
                jsonGenerator.a("should_upsell_location");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 171);
            if (g != 0) {
                jsonGenerator.a("sports_fact");
                GametimeDataFactFragmentParser.m15185b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 172);
            if (g != 0) {
                jsonGenerator.a("spotlight_story_preview");
                SpotlightStoryPreviewParser.m15210a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 173);
            if (g != 0) {
                jsonGenerator.a("status_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 174) != 0) {
                jsonGenerator.a("status_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 174));
            }
            g = mutableFlatBuffer.g(i, 175);
            if (g != 0) {
                jsonGenerator.a("story");
                ReactionStoryAttachmentStoryFragmentParser.m14720a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 176, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("sub_component_width_ratio");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 177);
            if (g != 0) {
                jsonGenerator.a("sub_message");
                SubMessageParser.m18150a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 178) != 0) {
                jsonGenerator.a("sub_message_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 178));
            }
            g = mutableFlatBuffer.g(i, 179);
            if (g != 0) {
                jsonGenerator.a("subheader");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 180);
            if (g != 0) {
                jsonGenerator.a("submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 181);
            if (g != 0) {
                jsonGenerator.a("submessage_after");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 182);
            if (g != 0) {
                jsonGenerator.a("submessage_before");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 183);
            if (g != 0) {
                jsonGenerator.a("subtitle");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 184);
            if (g != 0) {
                jsonGenerator.a("temperature");
                TemperatureParser.m18241a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 185);
            if (g != 0) {
                jsonGenerator.a("temperature_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 186);
            if (g != 0) {
                jsonGenerator.a("tertiary_message");
                TertiaryMessageParser.m18152a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 187);
            if (g != 0) {
                jsonGenerator.a("tertiary_spec");
                ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 188);
            if (g != 0) {
                jsonGenerator.a("tertiary_title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 189) != 0) {
                jsonGenerator.a("text_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 189));
            }
            if (mutableFlatBuffer.g(i, 190) != 0) {
                jsonGenerator.a("time_bucket");
                jsonGenerator.b(mutableFlatBuffer.c(i, 190));
            }
            long a3 = mutableFlatBuffer.a(i, 191, 0);
            if (a3 != 0) {
                jsonGenerator.a("timestamp");
                jsonGenerator.a(a3);
            }
            if (mutableFlatBuffer.g(i, 192) != 0) {
                jsonGenerator.a("timezone");
                jsonGenerator.b(mutableFlatBuffer.c(i, 192));
            }
            g = mutableFlatBuffer.g(i, 193);
            if (g != 0) {
                jsonGenerator.a("title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 194, 0);
            if (g != 0) {
                jsonGenerator.a("total_votes");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 195);
            if (g != 0) {
                jsonGenerator.a("truncation_string");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 196);
            if (g != 0) {
                jsonGenerator.a("typed_data");
                TypedDataParser.m15233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 197) != 0) {
                jsonGenerator.a("typed_headers");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 197), jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 198);
            if (g != 0) {
                jsonGenerator.a("venue_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 199);
            if (g != 0) {
                jsonGenerator.a("video");
                VideoDetailFragmentParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 200);
            if (g != 0) {
                jsonGenerator.a("video_channel");
                VideoHomeCreatorYouShouldFollowParser.m19749a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 201);
            if (g != 0) {
                jsonGenerator.a("weather_icon");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 202);
            if (g != 0) {
                jsonGenerator.a("weather_tap_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 203);
            if (g != 0) {
                jsonGenerator.a("website");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 204);
            if (g != 0) {
                jsonGenerator.a("website_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 205);
            if (g != 0) {
                jsonGenerator.a("write_review_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 206) != 0) {
                jsonGenerator.a("xout_nux_type");
                jsonGenerator.b(mutableFlatBuffer.c(i, 206));
            }
            g = mutableFlatBuffer.a(i, 207, 0);
            if (g != 0) {
                jsonGenerator.a("zoom_level");
                jsonGenerator.b(g);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionUnitComponentParser {
        public static int m18157a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[215];
            boolean[] zArr = new boolean[30];
            boolean[] zArr2 = new boolean[13];
            int[] iArr2 = new int[6];
            long[] jArr = new long[1];
            double[] dArr = new double[10];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("action")) {
                        iArr[1] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("actions")) {
                        iArr[2] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("album")) {
                        iArr[3] = AlbumParser.m18213a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("all_cards_enabled_message")) {
                        iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("all_cards_enabled_submessage")) {
                        iArr[5] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("auto_execute_action_delay")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("auto_paginate_count")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("aux_action")) {
                        iArr[8] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("aux_message")) {
                        iArr[9] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("auxiliary_action")) {
                        iArr[10] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("away_voting_page")) {
                        iArr[11] = AwayVotingPageParser.m15226a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("background_color")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("background_image")) {
                        iArr[13] = BackgroundImageParser.m18107a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("background_video_uri")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("badgable_profiles")) {
                        iArr[15] = BadgableProfilesParser.m15718a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("badge_icon")) {
                        iArr[16] = BadgeIconParser.m18058a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("bar_message")) {
                        iArr[17] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("boosted_component_status")) {
                        iArr[18] = flatBufferBuilder.a(GraphQLBoostedComponentStatus.fromString(jsonParser.o()));
                    } else if (i.equals("border_color")) {
                        iArr[19] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("bottom_border")) {
                        zArr[2] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("breadcrumbs")) {
                        iArr[21] = BreadcrumbsParser.m18109a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("card_action")) {
                        iArr[22] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("category_name")) {
                        iArr[23] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("center_location")) {
                        iArr[24] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("close_action")) {
                        iArr[25] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("comment")) {
                        iArr[26] = CommentParser.m18104a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("component_logical_path")) {
                        iArr[27] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("component_style")) {
                        iArr[28] = flatBufferBuilder.a(GraphQLReactionUnitComponentStyle.fromString(jsonParser.o()));
                    } else if (i.equals("component_tracking_data")) {
                        iArr[29] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("context_list")) {
                        iArr[30] = ContextListParser.m18231a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_attribute_aspect_ratio_value")) {
                        zArr[3] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("core_attribute_background_color")) {
                        iArr[32] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("core_attribute_border")) {
                        iArr[33] = ReactionCoreComponentBorderSpecFieldsParser.m15284a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_attribute_glyph_alignment")) {
                        iArr[34] = flatBufferBuilder.a(GraphQLReactionCoreButtonGlyphAlignment.fromString(jsonParser.o()));
                    } else if (i.equals("core_attribute_image_size")) {
                        iArr[35] = flatBufferBuilder.a(GraphQLReactionCoreImageTextImageSize.fromString(jsonParser.o()));
                    } else if (i.equals("core_attribute_margin")) {
                        iArr[36] = ReactionCoreComponentMarginSpecFieldsParser.m15286a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_attribute_padding")) {
                        iArr[37] = ReactionCoreComponentPaddingSpecFieldsParser.m15288a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_glyph")) {
                        iArr[38] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_image")) {
                        iArr[39] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("counts")) {
                        iArr[40] = CountsParser.m18160a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("cover_photo")) {
                        iArr[41] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("customer_data")) {
                        iArr[42] = CustomerDataParser.m18054a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("date_summary_text")) {
                        iArr[43] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("date_summary_text_long")) {
                        iArr[44] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("date_text")) {
                        iArr[45] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("day_time_text")) {
                        iArr[46] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("decoration_icon")) {
                        iArr[47] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("description")) {
                        iArr[48] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("detail_items")) {
                        iArr[49] = DefaultTextWithEntitiesFieldsParser.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("display_decision")) {
                        iArr[50] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                    } else if (i.equals("distance_string")) {
                        iArr[51] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("distance_text")) {
                        iArr[52] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("empty_state_action")) {
                        iArr[53] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("example_frame_image")) {
                        iArr[54] = ExampleFrameImageParser.m18068a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("expand_prompt")) {
                        iArr[55] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("explore_feed")) {
                        iArr[56] = VideoTopicFragmentParser.m19021a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("facepile")) {
                        iArr[57] = FacepileParser.m18222a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("favicon")) {
                        iArr[58] = FaviconParser.m18020a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feed_unit")) {
                        iArr[59] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("first_value")) {
                        iArr[60] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("first_value_description")) {
                        iArr[61] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("footer")) {
                        iArr[62] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("friending_possibilities")) {
                        iArr[63] = FriendingPossibilitiesParser.m15221a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_id")) {
                        iArr[64] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("has_bottom_border")) {
                        zArr[4] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("has_disabled_units")) {
                        zArr[5] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("has_inner_borders")) {
                        zArr[6] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("has_top_border")) {
                        zArr[7] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("header")) {
                        iArr[69] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_image100")) {
                        iArr[70] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_text")) {
                        iArr[71] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hero_image")) {
                        iArr[72] = HeroImageParser.m18029a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hero_video_uri")) {
                        iArr[73] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("high_temperature")) {
                        iArr[74] = HighTemperatureParser.m18236a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("highlight_color")) {
                        iArr[75] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("home_voting_page")) {
                        iArr[76] = HomeVotingPageParser.m15228a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hour_ranges")) {
                        iArr[77] = DefaultTimeRangeFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon")) {
                        iArr[78] = IconParser.m18113a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image")) {
                        iArr[79] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image_after")) {
                        iArr[80] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image_before")) {
                        iArr[81] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image")) {
                        iArr[82] = ImageParser.m18115a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image_background")) {
                        iArr[83] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image_block_image")) {
                        iArr[84] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image_block_image_48")) {
                        iArr[85] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("images")) {
                        iArr[86] = ReactionImageFieldsParser.m14693b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("images_with_overlay")) {
                        iArr[87] = ImagesWithOverlayParser.m18170a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("impressum")) {
                        iArr[88] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("impressum_action")) {
                        iArr[89] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_join_request_sent")) {
                        zArr[8] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("is_pinned")) {
                        zArr[9] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("is_place_tip")) {
                        zArr[10] = true;
                        zArr2[7] = jsonParser.H();
                    } else if (i.equals("is_saved_place")) {
                        zArr[11] = true;
                        zArr2[8] = jsonParser.H();
                    } else if (i.equals("is_self_location")) {
                        zArr[12] = true;
                        zArr2[9] = jsonParser.H();
                    } else if (i.equals("is_verified")) {
                        zArr[13] = true;
                        zArr2[10] = jsonParser.H();
                    } else if (i.equals("label_one")) {
                        iArr[96] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("label_one_color")) {
                        iArr[97] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("label_two")) {
                        iArr[98] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("label_two_color")) {
                        iArr[99] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_color")) {
                        iArr[100] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_label")) {
                        iArr[101] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_value")) {
                        zArr[14] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("location")) {
                        iArr[103] = LocationParser.m18117a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location_text")) {
                        iArr[104] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location_type")) {
                        iArr[105] = flatBufferBuilder.a(GraphQLAcornLocationType.fromString(jsonParser.o()));
                    } else if (i.equals("locations")) {
                        iArr[106] = LocationsParser.m18195a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("low_temperature")) {
                        iArr[107] = LowTemperatureParser.m18238a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("main_info")) {
                        iArr[108] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("map_bounding_box")) {
                        iArr[109] = ReactionGeoRectangleFieldsParser.m14688a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("match")) {
                        iArr[110] = MatchParser.m18133a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[111] = MessageParser.m18141a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_after")) {
                        iArr[112] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_before")) {
                        iArr[113] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_color")) {
                        iArr[114] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("message_snippet")) {
                        iArr[115] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("month_text")) {
                        iArr[116] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("notifications_default_count")) {
                        zArr[15] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("notifications_empty_message")) {
                        iArr[118] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("notifications_inline_expansion_count")) {
                        zArr[16] = true;
                        iArr2[3] = jsonParser.E();
                    } else if (i.equals("notifications_inline_expansion_message")) {
                        iArr[120] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("notifications_view_all_message")) {
                        iArr[121] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("only_display_status")) {
                        zArr[17] = true;
                        zArr2[11] = jsonParser.H();
                    } else if (i.equals("open_album_actions")) {
                        iArr[123] = ReactionUnitOpenAlbumActionsFragmentParser.m18191a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("other_user_name")) {
                        iArr[124] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[125] = PageParser.m18143a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("paginated_components")) {
                        iArr[126] = PaginatedComponentsParser.m18065a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("percent_of_goal_reached")) {
                        zArr[18] = true;
                        dArr[2] = jsonParser.G();
                    } else if (i.equals("phone_number_action")) {
                        iArr[128] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("phone_text")) {
                        iArr[129] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photo")) {
                        iArr[130] = PhotoParser.m15240a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photo_attachments")) {
                        iArr[131] = GraphQLStoryAttachmentDeserializer.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photos")) {
                        iArr[132] = SizeAwareMediaParser.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_category")) {
                        iArr[133] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_image")) {
                        iArr[134] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_breadcrumbs")) {
                        iArr[135] = PlaceInfoBlurbBreadcrumbsParser.m18216a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_page")) {
                        iArr[136] = PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_rating")) {
                        zArr[19] = true;
                        dArr[3] = jsonParser.G();
                    } else if (i.equals("place_metadata_page")) {
                        iArr[138] = PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_type")) {
                        iArr[139] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                    } else if (i.equals("plays")) {
                        iArr[140] = GametimeDataFactFragmentParser.m15184b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("price_range")) {
                        iArr[141] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("primary_icon")) {
                        iArr[142] = PrimaryIconParser.m18175a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("primary_message")) {
                        iArr[143] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("primary_spec")) {
                        iArr[144] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_image")) {
                        iArr[145] = ProfileImageParser.m18025a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_image_background_height_ratio")) {
                        zArr[20] = true;
                        dArr[4] = jsonParser.G();
                    } else if (i.equals("profile_photo")) {
                        iArr[147] = ProfilePhotoParser.m18070a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profiles")) {
                        iArr[148] = ProfilesParser.m18145a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("progress_bar_color")) {
                        iArr[149] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("progress_segments")) {
                        iArr[150] = ProgressSegmentsParser.m18073a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("prompt_text")) {
                        iArr[151] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("prune_behavior")) {
                        iArr[152] = flatBufferBuilder.a(GraphQLVideoChannelFeedUnitPruneBehavior.fromString(jsonParser.o()));
                    } else if (i.equals("publisher_context")) {
                        iArr[153] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("rating_count")) {
                        zArr[21] = true;
                        dArr[5] = jsonParser.G();
                    } else if (i.equals("rating_message")) {
                        iArr[155] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("rating_scale")) {
                        zArr[22] = true;
                        dArr[6] = jsonParser.G();
                    } else if (i.equals("rating_value")) {
                        zArr[23] = true;
                        dArr[7] = jsonParser.G();
                    } else if (i.equals("recommendation_context")) {
                        iArr[158] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("response_delay")) {
                        iArr[159] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("responsive_badge")) {
                        iArr[160] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("responsive_badge_color")) {
                        iArr[161] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("review_count_message")) {
                        iArr[162] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("right_color")) {
                        iArr[163] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("right_label")) {
                        iArr[164] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("right_value")) {
                        zArr[24] = true;
                        dArr[8] = jsonParser.G();
                    } else if (i.equals("second_value")) {
                        iArr[166] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("second_value_description")) {
                        iArr[167] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secondary_actions")) {
                        iArr[168] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secondary_message")) {
                        iArr[169] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secondary_spec")) {
                        iArr[170] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("see_all_ratings_action")) {
                        iArr[171] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("service")) {
                        iArr[172] = PageServiceItemParser.m11181a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("services")) {
                        iArr[173] = PageServiceItemParser.m11183b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("should_upsell_location")) {
                        zArr[25] = true;
                        zArr2[12] = jsonParser.H();
                    } else if (i.equals("sports_fact")) {
                        iArr[175] = GametimeDataFactFragmentParser.m15182a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("spotlight_story_preview")) {
                        iArr[176] = SpotlightStoryPreviewParser.m15209a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("status_message")) {
                        iArr[177] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("status_text")) {
                        iArr[178] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("story")) {
                        iArr[179] = ReactionStoryAttachmentStoryFragmentParser.m14719a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_component")) {
                        iArr[180] = ReactionExpandableSubComponentFragmentParser.m18036a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_component_width_ratio")) {
                        zArr[26] = true;
                        dArr[9] = jsonParser.G();
                    } else if (i.equals("sub_components")) {
                        iArr[182] = ReactionUnitSubComponentParser.m18229b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_message")) {
                        iArr[183] = SubMessageParser.m18149a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_message_color")) {
                        iArr[184] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("subheader")) {
                        iArr[185] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submessage")) {
                        iArr[186] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submessage_after")) {
                        iArr[187] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submessage_before")) {
                        iArr[188] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subtitle")) {
                        iArr[189] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tabs")) {
                        iArr[190] = TabsParser.m18082a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temperature")) {
                        iArr[191] = TemperatureParser.m18240a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temperature_text")) {
                        iArr[192] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_message")) {
                        iArr[193] = TertiaryMessageParser.m18151a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_spec")) {
                        iArr[194] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_title")) {
                        iArr[195] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("text_color")) {
                        iArr[196] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("time_bucket")) {
                        iArr[197] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("timestamp")) {
                        zArr[27] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("timezone")) {
                        iArr[199] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("title")) {
                        iArr[200] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("total_votes")) {
                        zArr[28] = true;
                        iArr2[4] = jsonParser.E();
                    } else if (i.equals("truncation_string")) {
                        iArr[202] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("typed_data")) {
                        iArr[203] = TypedDataParser.m15231a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("typed_headers")) {
                        iArr[204] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("venue_name")) {
                        iArr[205] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video")) {
                        iArr[206] = VideoDetailFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video_channel")) {
                        iArr[207] = VideoHomeCreatorYouShouldFollowParser.m19748a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("weather_icon")) {
                        iArr[208] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("weather_tap_action")) {
                        iArr[209] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("website")) {
                        iArr[210] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("website_action")) {
                        iArr[211] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("write_review_action")) {
                        iArr[212] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("xout_nux_type")) {
                        iArr[213] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("zoom_level")) {
                        zArr[29] = true;
                        iArr2[5] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(215);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            if (zArr[0]) {
                flatBufferBuilder.a(6, iArr2[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(7, iArr2[1], 0);
            }
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
            if (zArr[2]) {
                flatBufferBuilder.a(20, zArr2[0]);
            }
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
            if (zArr[3]) {
                flatBufferBuilder.a(31, dArr[0], 0.0d);
            }
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
            flatBufferBuilder.b(61, iArr[61]);
            flatBufferBuilder.b(62, iArr[62]);
            flatBufferBuilder.b(63, iArr[63]);
            flatBufferBuilder.b(64, iArr[64]);
            if (zArr[4]) {
                flatBufferBuilder.a(65, zArr2[1]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(66, zArr2[2]);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(67, zArr2[3]);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(68, zArr2[4]);
            }
            flatBufferBuilder.b(69, iArr[69]);
            flatBufferBuilder.b(70, iArr[70]);
            flatBufferBuilder.b(71, iArr[71]);
            flatBufferBuilder.b(72, iArr[72]);
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
            flatBufferBuilder.b(86, iArr[86]);
            flatBufferBuilder.b(87, iArr[87]);
            flatBufferBuilder.b(88, iArr[88]);
            flatBufferBuilder.b(89, iArr[89]);
            if (zArr[8]) {
                flatBufferBuilder.a(90, zArr2[5]);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(91, zArr2[6]);
            }
            if (zArr[10]) {
                flatBufferBuilder.a(92, zArr2[7]);
            }
            if (zArr[11]) {
                flatBufferBuilder.a(93, zArr2[8]);
            }
            if (zArr[12]) {
                flatBufferBuilder.a(94, zArr2[9]);
            }
            if (zArr[13]) {
                flatBufferBuilder.a(95, zArr2[10]);
            }
            flatBufferBuilder.b(96, iArr[96]);
            flatBufferBuilder.b(97, iArr[97]);
            flatBufferBuilder.b(98, iArr[98]);
            flatBufferBuilder.b(99, iArr[99]);
            flatBufferBuilder.b(100, iArr[100]);
            flatBufferBuilder.b(101, iArr[101]);
            if (zArr[14]) {
                flatBufferBuilder.a(102, dArr[1], 0.0d);
            }
            flatBufferBuilder.b(103, iArr[103]);
            flatBufferBuilder.b(104, iArr[104]);
            flatBufferBuilder.b(105, iArr[105]);
            flatBufferBuilder.b(106, iArr[106]);
            flatBufferBuilder.b(107, iArr[107]);
            flatBufferBuilder.b(108, iArr[108]);
            flatBufferBuilder.b(109, iArr[109]);
            flatBufferBuilder.b(110, iArr[110]);
            flatBufferBuilder.b(111, iArr[111]);
            flatBufferBuilder.b(112, iArr[112]);
            flatBufferBuilder.b(113, iArr[113]);
            flatBufferBuilder.b(114, iArr[114]);
            flatBufferBuilder.b(115, iArr[115]);
            flatBufferBuilder.b(116, iArr[116]);
            if (zArr[15]) {
                flatBufferBuilder.a(117, iArr2[2], 0);
            }
            flatBufferBuilder.b(118, iArr[118]);
            if (zArr[16]) {
                flatBufferBuilder.a(119, iArr2[3], 0);
            }
            flatBufferBuilder.b(120, iArr[120]);
            flatBufferBuilder.b(121, iArr[121]);
            if (zArr[17]) {
                flatBufferBuilder.a(122, zArr2[11]);
            }
            flatBufferBuilder.b(123, iArr[123]);
            flatBufferBuilder.b(124, iArr[124]);
            flatBufferBuilder.b(125, iArr[125]);
            flatBufferBuilder.b(126, iArr[126]);
            if (zArr[18]) {
                flatBufferBuilder.a(127, dArr[2], 0.0d);
            }
            flatBufferBuilder.b(128, iArr[128]);
            flatBufferBuilder.b(129, iArr[129]);
            flatBufferBuilder.b(130, iArr[130]);
            flatBufferBuilder.b(131, iArr[131]);
            flatBufferBuilder.b(132, iArr[132]);
            flatBufferBuilder.b(133, iArr[133]);
            flatBufferBuilder.b(134, iArr[134]);
            flatBufferBuilder.b(135, iArr[135]);
            flatBufferBuilder.b(136, iArr[136]);
            if (zArr[19]) {
                flatBufferBuilder.a(137, dArr[3], 0.0d);
            }
            flatBufferBuilder.b(138, iArr[138]);
            flatBufferBuilder.b(139, iArr[139]);
            flatBufferBuilder.b(140, iArr[140]);
            flatBufferBuilder.b(141, iArr[141]);
            flatBufferBuilder.b(142, iArr[142]);
            flatBufferBuilder.b(143, iArr[143]);
            flatBufferBuilder.b(144, iArr[144]);
            flatBufferBuilder.b(145, iArr[145]);
            if (zArr[20]) {
                flatBufferBuilder.a(146, dArr[4], 0.0d);
            }
            flatBufferBuilder.b(147, iArr[147]);
            flatBufferBuilder.b(148, iArr[148]);
            flatBufferBuilder.b(149, iArr[149]);
            flatBufferBuilder.b(150, iArr[150]);
            flatBufferBuilder.b(151, iArr[151]);
            flatBufferBuilder.b(152, iArr[152]);
            flatBufferBuilder.b(153, iArr[153]);
            if (zArr[21]) {
                flatBufferBuilder.a(154, dArr[5], 0.0d);
            }
            flatBufferBuilder.b(155, iArr[155]);
            if (zArr[22]) {
                flatBufferBuilder.a(156, dArr[6], 0.0d);
            }
            if (zArr[23]) {
                flatBufferBuilder.a(157, dArr[7], 0.0d);
            }
            flatBufferBuilder.b(158, iArr[158]);
            flatBufferBuilder.b(159, iArr[159]);
            flatBufferBuilder.b(160, iArr[160]);
            flatBufferBuilder.b(161, iArr[161]);
            flatBufferBuilder.b(162, iArr[162]);
            flatBufferBuilder.b(163, iArr[163]);
            flatBufferBuilder.b(164, iArr[164]);
            if (zArr[24]) {
                flatBufferBuilder.a(165, dArr[8], 0.0d);
            }
            flatBufferBuilder.b(166, iArr[166]);
            flatBufferBuilder.b(167, iArr[167]);
            flatBufferBuilder.b(168, iArr[168]);
            flatBufferBuilder.b(169, iArr[169]);
            flatBufferBuilder.b(170, iArr[170]);
            flatBufferBuilder.b(171, iArr[171]);
            flatBufferBuilder.b(172, iArr[172]);
            flatBufferBuilder.b(173, iArr[173]);
            if (zArr[25]) {
                flatBufferBuilder.a(174, zArr2[12]);
            }
            flatBufferBuilder.b(175, iArr[175]);
            flatBufferBuilder.b(176, iArr[176]);
            flatBufferBuilder.b(177, iArr[177]);
            flatBufferBuilder.b(178, iArr[178]);
            flatBufferBuilder.b(179, iArr[179]);
            flatBufferBuilder.b(180, iArr[180]);
            if (zArr[26]) {
                flatBufferBuilder.a(181, dArr[9], 0.0d);
            }
            flatBufferBuilder.b(182, iArr[182]);
            flatBufferBuilder.b(183, iArr[183]);
            flatBufferBuilder.b(184, iArr[184]);
            flatBufferBuilder.b(185, iArr[185]);
            flatBufferBuilder.b(186, iArr[186]);
            flatBufferBuilder.b(187, iArr[187]);
            flatBufferBuilder.b(188, iArr[188]);
            flatBufferBuilder.b(189, iArr[189]);
            flatBufferBuilder.b(190, iArr[190]);
            flatBufferBuilder.b(191, iArr[191]);
            flatBufferBuilder.b(192, iArr[192]);
            flatBufferBuilder.b(193, iArr[193]);
            flatBufferBuilder.b(194, iArr[194]);
            flatBufferBuilder.b(195, iArr[195]);
            flatBufferBuilder.b(196, iArr[196]);
            flatBufferBuilder.b(197, iArr[197]);
            if (zArr[27]) {
                flatBufferBuilder.a(198, jArr[0], 0);
            }
            flatBufferBuilder.b(199, iArr[199]);
            flatBufferBuilder.b(200, iArr[200]);
            if (zArr[28]) {
                flatBufferBuilder.a(201, iArr2[4], 0);
            }
            flatBufferBuilder.b(202, iArr[202]);
            flatBufferBuilder.b(203, iArr[203]);
            flatBufferBuilder.b(204, iArr[204]);
            flatBufferBuilder.b(205, iArr[205]);
            flatBufferBuilder.b(206, iArr[206]);
            flatBufferBuilder.b(207, iArr[207]);
            flatBufferBuilder.b(208, iArr[208]);
            flatBufferBuilder.b(209, iArr[209]);
            flatBufferBuilder.b(210, iArr[210]);
            flatBufferBuilder.b(211, iArr[211]);
            flatBufferBuilder.b(212, iArr[212]);
            flatBufferBuilder.b(213, iArr[213]);
            if (zArr[29]) {
                flatBufferBuilder.a(214, iArr2[5], 0);
            }
            return flatBufferBuilder.d();
        }

        public static int m18158b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m18157a(jsonParser, flatBufferBuilder)));
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

        public static void m18159b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("actions");
                ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.m18214a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("all_cards_enabled_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("all_cards_enabled_submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 6, 0);
            if (g != 0) {
                jsonGenerator.a("auto_execute_action_delay");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 7, 0);
            if (g != 0) {
                jsonGenerator.a("auto_paginate_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("aux_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("aux_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("auxiliary_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("away_voting_page");
                AwayVotingPageParser.m15227a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("background_image");
                BackgroundImageParser.m18108a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("background_video_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("badgable_profiles");
                BadgableProfilesParser.m15719a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("badge_icon");
                BadgeIconParser.m18059a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 17);
            if (g != 0) {
                jsonGenerator.a("bar_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("boosted_component_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 18));
            }
            if (mutableFlatBuffer.g(i, 19) != 0) {
                jsonGenerator.a("border_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 19));
            }
            boolean a = mutableFlatBuffer.a(i, 20);
            if (a) {
                jsonGenerator.a("bottom_border");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 21);
            if (g != 0) {
                jsonGenerator.a("breadcrumbs");
                BreadcrumbsParser.m18110a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 22);
            if (g != 0) {
                jsonGenerator.a("card_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 23);
            if (g != 0) {
                jsonGenerator.a("category_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 24);
            if (g != 0) {
                jsonGenerator.a("center_location");
                DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("close_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 26);
            if (g != 0) {
                jsonGenerator.a("comment");
                CommentParser.m18105a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 27) != 0) {
                jsonGenerator.a("component_logical_path");
                jsonGenerator.b(mutableFlatBuffer.c(i, 27));
            }
            if (mutableFlatBuffer.g(i, 28) != 0) {
                jsonGenerator.a("component_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 28));
            }
            if (mutableFlatBuffer.g(i, 29) != 0) {
                jsonGenerator.a("component_tracking_data");
                jsonGenerator.b(mutableFlatBuffer.c(i, 29));
            }
            g = mutableFlatBuffer.g(i, 30);
            if (g != 0) {
                jsonGenerator.a("context_list");
                ContextListParser.m18233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            double a2 = mutableFlatBuffer.a(i, 31, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("core_attribute_aspect_ratio_value");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 32) != 0) {
                jsonGenerator.a("core_attribute_background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 32));
            }
            g = mutableFlatBuffer.g(i, 33);
            if (g != 0) {
                jsonGenerator.a("core_attribute_border");
                ReactionCoreComponentBorderSpecFieldsParser.m15285a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 34) != 0) {
                jsonGenerator.a("core_attribute_glyph_alignment");
                jsonGenerator.b(mutableFlatBuffer.b(i, 34));
            }
            if (mutableFlatBuffer.g(i, 35) != 0) {
                jsonGenerator.a("core_attribute_image_size");
                jsonGenerator.b(mutableFlatBuffer.b(i, 35));
            }
            g = mutableFlatBuffer.g(i, 36);
            if (g != 0) {
                jsonGenerator.a("core_attribute_margin");
                ReactionCoreComponentMarginSpecFieldsParser.m15287a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 37);
            if (g != 0) {
                jsonGenerator.a("core_attribute_padding");
                ReactionCoreComponentPaddingSpecFieldsParser.m15289a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 38);
            if (g != 0) {
                jsonGenerator.a("core_glyph");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 39);
            if (g != 0) {
                jsonGenerator.a("core_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 40);
            if (g != 0) {
                jsonGenerator.a("counts");
                CountsParser.m18161a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 41);
            if (g != 0) {
                jsonGenerator.a("cover_photo");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 42);
            if (g != 0) {
                jsonGenerator.a("customer_data");
                CustomerDataParser.m18055a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 43);
            if (g != 0) {
                jsonGenerator.a("date_summary_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 44);
            if (g != 0) {
                jsonGenerator.a("date_summary_text_long");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 45) != 0) {
                jsonGenerator.a("date_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 45));
            }
            g = mutableFlatBuffer.g(i, 46);
            if (g != 0) {
                jsonGenerator.a("day_time_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 47);
            if (g != 0) {
                jsonGenerator.a("decoration_icon");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 48);
            if (g != 0) {
                jsonGenerator.a("description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 49);
            if (g != 0) {
                jsonGenerator.a("detail_items");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 50) != 0) {
                jsonGenerator.a("display_decision");
                jsonGenerator.b(mutableFlatBuffer.b(i, 50));
            }
            if (mutableFlatBuffer.g(i, 51) != 0) {
                jsonGenerator.a("distance_string");
                jsonGenerator.b(mutableFlatBuffer.c(i, 51));
            }
            g = mutableFlatBuffer.g(i, 52);
            if (g != 0) {
                jsonGenerator.a("distance_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 53);
            if (g != 0) {
                jsonGenerator.a("empty_state_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 54);
            if (g != 0) {
                jsonGenerator.a("example_frame_image");
                ExampleFrameImageParser.m18069a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 55);
            if (g != 0) {
                jsonGenerator.a("expand_prompt");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 56);
            if (g != 0) {
                jsonGenerator.a("explore_feed");
                VideoTopicFragmentParser.m19022b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 57);
            if (g != 0) {
                jsonGenerator.a("facepile");
                FacepileParser.m18223a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 58);
            if (g != 0) {
                jsonGenerator.a("favicon");
                FaviconParser.m18021a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 59);
            if (g != 0) {
                jsonGenerator.a("feed_unit");
                GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 60);
            if (g != 0) {
                jsonGenerator.a("first_value");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 61);
            if (g != 0) {
                jsonGenerator.a("first_value_description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 62);
            if (g != 0) {
                jsonGenerator.a("footer");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 63);
            if (g != 0) {
                jsonGenerator.a("friending_possibilities");
                FriendingPossibilitiesParser.m15222a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 64) != 0) {
                jsonGenerator.a("group_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 64));
            }
            a = mutableFlatBuffer.a(i, 65);
            if (a) {
                jsonGenerator.a("has_bottom_border");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 66);
            if (a) {
                jsonGenerator.a("has_disabled_units");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 67);
            if (a) {
                jsonGenerator.a("has_inner_borders");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 68);
            if (a) {
                jsonGenerator.a("has_top_border");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 69);
            if (g != 0) {
                jsonGenerator.a("header");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 70);
            if (g != 0) {
                jsonGenerator.a("header_image100");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 71);
            if (g != 0) {
                jsonGenerator.a("header_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 72);
            if (g != 0) {
                jsonGenerator.a("hero_image");
                HeroImageParser.m18030a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 73) != 0) {
                jsonGenerator.a("hero_video_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 73));
            }
            g = mutableFlatBuffer.g(i, 74);
            if (g != 0) {
                jsonGenerator.a("high_temperature");
                HighTemperatureParser.m18237a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 75) != 0) {
                jsonGenerator.a("highlight_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 75));
            }
            g = mutableFlatBuffer.g(i, 76);
            if (g != 0) {
                jsonGenerator.a("home_voting_page");
                HomeVotingPageParser.m15229a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 77);
            if (g != 0) {
                jsonGenerator.a("hour_ranges");
                DefaultTimeRangeFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 78);
            if (g != 0) {
                jsonGenerator.a("icon");
                IconParser.m18114a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 79);
            if (g != 0) {
                jsonGenerator.a("icon_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 80);
            if (g != 0) {
                jsonGenerator.a("icon_image_after");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 81);
            if (g != 0) {
                jsonGenerator.a("icon_image_before");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 82);
            if (g != 0) {
                jsonGenerator.a("image");
                ImageParser.m18116a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 83) != 0) {
                jsonGenerator.a("image_background");
                jsonGenerator.b(mutableFlatBuffer.c(i, 83));
            }
            g = mutableFlatBuffer.g(i, 84);
            if (g != 0) {
                jsonGenerator.a("image_block_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 85);
            if (g != 0) {
                jsonGenerator.a("image_block_image_48");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 86);
            if (g != 0) {
                jsonGenerator.a("images");
                ReactionImageFieldsParser.m14692a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 87);
            if (g != 0) {
                jsonGenerator.a("images_with_overlay");
                ImagesWithOverlayParser.m18171a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 88);
            if (g != 0) {
                jsonGenerator.a("impressum");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 89);
            if (g != 0) {
                jsonGenerator.a("impressum_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 90);
            if (a) {
                jsonGenerator.a("is_join_request_sent");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 91);
            if (a) {
                jsonGenerator.a("is_pinned");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 92);
            if (a) {
                jsonGenerator.a("is_place_tip");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 93);
            if (a) {
                jsonGenerator.a("is_saved_place");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 94);
            if (a) {
                jsonGenerator.a("is_self_location");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 95);
            if (a) {
                jsonGenerator.a("is_verified");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 96);
            if (g != 0) {
                jsonGenerator.a("label_one");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 97) != 0) {
                jsonGenerator.a("label_one_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 97));
            }
            g = mutableFlatBuffer.g(i, 98);
            if (g != 0) {
                jsonGenerator.a("label_two");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 99) != 0) {
                jsonGenerator.a("label_two_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 99));
            }
            if (mutableFlatBuffer.g(i, 100) != 0) {
                jsonGenerator.a("left_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 100));
            }
            if (mutableFlatBuffer.g(i, 101) != 0) {
                jsonGenerator.a("left_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 101));
            }
            a2 = mutableFlatBuffer.a(i, 102, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("left_value");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 103);
            if (g != 0) {
                jsonGenerator.a("location");
                LocationParser.m18118a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 104);
            if (g != 0) {
                jsonGenerator.a("location_text");
                ReactionTextWithEntitiesWithImagesParser.m14726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 105) != 0) {
                jsonGenerator.a("location_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 105));
            }
            g = mutableFlatBuffer.g(i, 106);
            if (g != 0) {
                jsonGenerator.a("locations");
                LocationsParser.m18197a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 107);
            if (g != 0) {
                jsonGenerator.a("low_temperature");
                LowTemperatureParser.m18239a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 108);
            if (g != 0) {
                jsonGenerator.a("main_info");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 109);
            if (g != 0) {
                jsonGenerator.a("map_bounding_box");
                ReactionGeoRectangleFieldsParser.m14689a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 110);
            if (g != 0) {
                jsonGenerator.a("match");
                MatchParser.m18134a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 111);
            if (g != 0) {
                jsonGenerator.a("message");
                MessageParser.m18142a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 112);
            if (g != 0) {
                jsonGenerator.a("message_after");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 113);
            if (g != 0) {
                jsonGenerator.a("message_before");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 114) != 0) {
                jsonGenerator.a("message_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 114));
            }
            g = mutableFlatBuffer.g(i, 115);
            if (g != 0) {
                jsonGenerator.a("message_snippet");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 116) != 0) {
                jsonGenerator.a("month_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 116));
            }
            g = mutableFlatBuffer.a(i, 117, 0);
            if (g != 0) {
                jsonGenerator.a("notifications_default_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 118);
            if (g != 0) {
                jsonGenerator.a("notifications_empty_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 119, 0);
            if (g != 0) {
                jsonGenerator.a("notifications_inline_expansion_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 120);
            if (g != 0) {
                jsonGenerator.a("notifications_inline_expansion_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 121);
            if (g != 0) {
                jsonGenerator.a("notifications_view_all_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 122);
            if (a) {
                jsonGenerator.a("only_display_status");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 123);
            if (g != 0) {
                jsonGenerator.a("open_album_actions");
                ReactionUnitOpenAlbumActionsFragmentParser.m18192a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 124);
            if (g != 0) {
                jsonGenerator.a("other_user_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 125);
            if (g != 0) {
                jsonGenerator.a("page");
                PageParser.m18144a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 126);
            if (g != 0) {
                jsonGenerator.a("paginated_components");
                PaginatedComponentsParser.m18066a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 127, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("percent_of_goal_reached");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 128);
            if (g != 0) {
                jsonGenerator.a("phone_number_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 129);
            if (g != 0) {
                jsonGenerator.a("phone_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 130);
            if (g != 0) {
                jsonGenerator.a("photo");
                PhotoParser.m15241a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 131);
            if (g != 0) {
                jsonGenerator.a("photo_attachments");
                GraphQLStoryAttachmentDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 132);
            if (g != 0) {
                jsonGenerator.a("photos");
                SizeAwareMediaParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 133);
            if (g != 0) {
                jsonGenerator.a("place_category");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 134);
            if (g != 0) {
                jsonGenerator.a("place_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 135);
            if (g != 0) {
                jsonGenerator.a("place_info_blurb_breadcrumbs");
                PlaceInfoBlurbBreadcrumbsParser.m18217a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 136);
            if (g != 0) {
                jsonGenerator.a("place_info_blurb_page");
                PlaceInfoBlurbFieldsParser.m14683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 137, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("place_info_blurb_rating");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 138);
            if (g != 0) {
                jsonGenerator.a("place_metadata_page");
                PlaceInfoBlurbFieldsParser.m14683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 139) != 0) {
                jsonGenerator.a("place_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 139));
            }
            g = mutableFlatBuffer.g(i, 140);
            if (g != 0) {
                jsonGenerator.a("plays");
                GametimeDataFactFragmentParser.m15183a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 141) != 0) {
                jsonGenerator.a("price_range");
                jsonGenerator.b(mutableFlatBuffer.c(i, 141));
            }
            g = mutableFlatBuffer.g(i, 142);
            if (g != 0) {
                jsonGenerator.a("primary_icon");
                PrimaryIconParser.m18176a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 143);
            if (g != 0) {
                jsonGenerator.a("primary_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 144);
            if (g != 0) {
                jsonGenerator.a("primary_spec");
                ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 145);
            if (g != 0) {
                jsonGenerator.a("profile_image");
                ProfileImageParser.m18026a(mutableFlatBuffer, g, jsonGenerator);
            }
            a2 = mutableFlatBuffer.a(i, 146, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("profile_image_background_height_ratio");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 147);
            if (g != 0) {
                jsonGenerator.a("profile_photo");
                ProfilePhotoParser.m18071a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 148);
            if (g != 0) {
                jsonGenerator.a("profiles");
                ProfilesParser.m18146a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 149) != 0) {
                jsonGenerator.a("progress_bar_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 149));
            }
            g = mutableFlatBuffer.g(i, 150);
            if (g != 0) {
                jsonGenerator.a("progress_segments");
                ProgressSegmentsParser.m18075a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 151) != 0) {
                jsonGenerator.a("prompt_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 151));
            }
            if (mutableFlatBuffer.g(i, 152) != 0) {
                jsonGenerator.a("prune_behavior");
                jsonGenerator.b(mutableFlatBuffer.b(i, 152));
            }
            g = mutableFlatBuffer.g(i, 153);
            if (g != 0) {
                jsonGenerator.a("publisher_context");
                ReactionTextWithEntitiesWithImagesParser.m14726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 154, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("rating_count");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 155);
            if (g != 0) {
                jsonGenerator.a("rating_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a2 = mutableFlatBuffer.a(i, 156, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("rating_scale");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 157, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("rating_value");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 158);
            if (g != 0) {
                jsonGenerator.a("recommendation_context");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 159);
            if (g != 0) {
                jsonGenerator.a("response_delay");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 160);
            if (g != 0) {
                jsonGenerator.a("responsive_badge");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 161) != 0) {
                jsonGenerator.a("responsive_badge_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 161));
            }
            g = mutableFlatBuffer.g(i, 162);
            if (g != 0) {
                jsonGenerator.a("review_count_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 163) != 0) {
                jsonGenerator.a("right_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 163));
            }
            if (mutableFlatBuffer.g(i, 164) != 0) {
                jsonGenerator.a("right_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 164));
            }
            a2 = mutableFlatBuffer.a(i, 165, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("right_value");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 166);
            if (g != 0) {
                jsonGenerator.a("second_value");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 167);
            if (g != 0) {
                jsonGenerator.a("second_value_description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 168);
            if (g != 0) {
                jsonGenerator.a("secondary_actions");
                ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 169);
            if (g != 0) {
                jsonGenerator.a("secondary_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 170);
            if (g != 0) {
                jsonGenerator.a("secondary_spec");
                ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 171);
            if (g != 0) {
                jsonGenerator.a("see_all_ratings_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 172);
            if (g != 0) {
                jsonGenerator.a("service");
                PageServiceItemParser.m11184b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 173);
            if (g != 0) {
                jsonGenerator.a("services");
                PageServiceItemParser.m11182a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 174);
            if (a) {
                jsonGenerator.a("should_upsell_location");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 175);
            if (g != 0) {
                jsonGenerator.a("sports_fact");
                GametimeDataFactFragmentParser.m15185b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 176);
            if (g != 0) {
                jsonGenerator.a("spotlight_story_preview");
                SpotlightStoryPreviewParser.m15210a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 177);
            if (g != 0) {
                jsonGenerator.a("status_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 178) != 0) {
                jsonGenerator.a("status_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 178));
            }
            g = mutableFlatBuffer.g(i, 179);
            if (g != 0) {
                jsonGenerator.a("story");
                ReactionStoryAttachmentStoryFragmentParser.m14720a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 180);
            if (g != 0) {
                jsonGenerator.a("sub_component");
                ReactionExpandableSubComponentFragmentParser.m18037a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 181, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("sub_component_width_ratio");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 182);
            if (g != 0) {
                jsonGenerator.a("sub_components");
                ReactionUnitSubComponentParser.m18228a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 183);
            if (g != 0) {
                jsonGenerator.a("sub_message");
                SubMessageParser.m18150a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 184) != 0) {
                jsonGenerator.a("sub_message_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 184));
            }
            g = mutableFlatBuffer.g(i, 185);
            if (g != 0) {
                jsonGenerator.a("subheader");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 186);
            if (g != 0) {
                jsonGenerator.a("submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 187);
            if (g != 0) {
                jsonGenerator.a("submessage_after");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 188);
            if (g != 0) {
                jsonGenerator.a("submessage_before");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 189);
            if (g != 0) {
                jsonGenerator.a("subtitle");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 190);
            if (g != 0) {
                jsonGenerator.a("tabs");
                TabsParser.m18083a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 191);
            if (g != 0) {
                jsonGenerator.a("temperature");
                TemperatureParser.m18241a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 192);
            if (g != 0) {
                jsonGenerator.a("temperature_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 193);
            if (g != 0) {
                jsonGenerator.a("tertiary_message");
                TertiaryMessageParser.m18152a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 194);
            if (g != 0) {
                jsonGenerator.a("tertiary_spec");
                ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 195);
            if (g != 0) {
                jsonGenerator.a("tertiary_title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 196) != 0) {
                jsonGenerator.a("text_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 196));
            }
            if (mutableFlatBuffer.g(i, 197) != 0) {
                jsonGenerator.a("time_bucket");
                jsonGenerator.b(mutableFlatBuffer.c(i, 197));
            }
            long a3 = mutableFlatBuffer.a(i, 198, 0);
            if (a3 != 0) {
                jsonGenerator.a("timestamp");
                jsonGenerator.a(a3);
            }
            if (mutableFlatBuffer.g(i, 199) != 0) {
                jsonGenerator.a("timezone");
                jsonGenerator.b(mutableFlatBuffer.c(i, 199));
            }
            g = mutableFlatBuffer.g(i, 200);
            if (g != 0) {
                jsonGenerator.a("title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 201, 0);
            if (g != 0) {
                jsonGenerator.a("total_votes");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 202);
            if (g != 0) {
                jsonGenerator.a("truncation_string");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 203);
            if (g != 0) {
                jsonGenerator.a("typed_data");
                TypedDataParser.m15233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 204) != 0) {
                jsonGenerator.a("typed_headers");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 204), jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 205);
            if (g != 0) {
                jsonGenerator.a("venue_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 206);
            if (g != 0) {
                jsonGenerator.a("video");
                VideoDetailFragmentParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 207);
            if (g != 0) {
                jsonGenerator.a("video_channel");
                VideoHomeCreatorYouShouldFollowParser.m19749a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 208);
            if (g != 0) {
                jsonGenerator.a("weather_icon");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 209);
            if (g != 0) {
                jsonGenerator.a("weather_tap_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 210);
            if (g != 0) {
                jsonGenerator.a("website");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 211);
            if (g != 0) {
                jsonGenerator.a("website_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 212);
            if (g != 0) {
                jsonGenerator.a("write_review_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 213) != 0) {
                jsonGenerator.a("xout_nux_type");
                jsonGenerator.b(mutableFlatBuffer.c(i, 213));
            }
            g = mutableFlatBuffer.a(i, 214, 0);
            if (g != 0) {
                jsonGenerator.a("zoom_level");
                jsonGenerator.b(g);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionUnitCountsComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class CountsParser {
            public static int m18162b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("action")) {
                            iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("count")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("label")) {
                            iArr[2] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static int m18160a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m18162b(jsonParser, flatBufferBuilder)));
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

            public static void m18161a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m18163b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m18163b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 1, 0);
                if (g != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("label");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18164a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("counts")) {
                        iArr[0] = CountsParser.m18160a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetch_successful */
    public final class ReactionUnitCrisisActionWithComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class NegativeComponentParser {
            public static int m18165a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[211];
                boolean[] zArr = new boolean[30];
                boolean[] zArr2 = new boolean[13];
                int[] iArr2 = new int[6];
                long[] jArr = new long[1];
                double[] dArr = new double[10];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("action")) {
                            iArr[1] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("actions")) {
                            iArr[2] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("album")) {
                            iArr[3] = AlbumParser.m18213a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("all_cards_enabled_message")) {
                            iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("all_cards_enabled_submessage")) {
                            iArr[5] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("auto_execute_action_delay")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("auto_paginate_count")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("aux_action")) {
                            iArr[8] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("aux_message")) {
                            iArr[9] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("auxiliary_action")) {
                            iArr[10] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("away_voting_page")) {
                            iArr[11] = AwayVotingPageParser.m15226a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("background_color")) {
                            iArr[12] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("background_image")) {
                            iArr[13] = BackgroundImageParser.m18107a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("background_video_uri")) {
                            iArr[14] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("badgable_profiles")) {
                            iArr[15] = BadgableProfilesParser.m15718a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("badge_icon")) {
                            iArr[16] = BadgeIconParser.m18058a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("bar_message")) {
                            iArr[17] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("boosted_component_status")) {
                            iArr[18] = flatBufferBuilder.a(GraphQLBoostedComponentStatus.fromString(jsonParser.o()));
                        } else if (i.equals("border_color")) {
                            iArr[19] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("bottom_border")) {
                            zArr[2] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("breadcrumbs")) {
                            iArr[21] = BreadcrumbsParser.m18109a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("card_action")) {
                            iArr[22] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("category_name")) {
                            iArr[23] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("center_location")) {
                            iArr[24] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("close_action")) {
                            iArr[25] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("comment")) {
                            iArr[26] = CommentParser.m18104a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("component_logical_path")) {
                            iArr[27] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("component_style")) {
                            iArr[28] = flatBufferBuilder.a(GraphQLReactionUnitComponentStyle.fromString(jsonParser.o()));
                        } else if (i.equals("component_tracking_data")) {
                            iArr[29] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("context_list")) {
                            iArr[30] = ContextListParser.m18231a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("core_attribute_aspect_ratio_value")) {
                            zArr[3] = true;
                            dArr[0] = jsonParser.G();
                        } else if (i.equals("core_attribute_background_color")) {
                            iArr[32] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("core_attribute_border")) {
                            iArr[33] = ReactionCoreComponentBorderSpecFieldsParser.m15284a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("core_attribute_glyph_alignment")) {
                            iArr[34] = flatBufferBuilder.a(GraphQLReactionCoreButtonGlyphAlignment.fromString(jsonParser.o()));
                        } else if (i.equals("core_attribute_image_size")) {
                            iArr[35] = flatBufferBuilder.a(GraphQLReactionCoreImageTextImageSize.fromString(jsonParser.o()));
                        } else if (i.equals("core_attribute_margin")) {
                            iArr[36] = ReactionCoreComponentMarginSpecFieldsParser.m15286a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("core_attribute_padding")) {
                            iArr[37] = ReactionCoreComponentPaddingSpecFieldsParser.m15288a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("core_glyph")) {
                            iArr[38] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("core_image")) {
                            iArr[39] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("counts")) {
                            iArr[40] = CountsParser.m18160a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("cover_photo")) {
                            iArr[41] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("customer_data")) {
                            iArr[42] = CustomerDataParser.m18054a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("date_summary_text")) {
                            iArr[43] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("date_summary_text_long")) {
                            iArr[44] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("date_text")) {
                            iArr[45] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("day_time_text")) {
                            iArr[46] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("decoration_icon")) {
                            iArr[47] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("description")) {
                            iArr[48] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("detail_items")) {
                            iArr[49] = DefaultTextWithEntitiesFieldsParser.b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("display_decision")) {
                            iArr[50] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                        } else if (i.equals("distance_string")) {
                            iArr[51] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("distance_text")) {
                            iArr[52] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("empty_state_action")) {
                            iArr[53] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("example_frame_image")) {
                            iArr[54] = ExampleFrameImageParser.m18068a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("explore_feed")) {
                            iArr[55] = VideoTopicFragmentParser.m19021a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("facepile")) {
                            iArr[56] = FacepileParser.m18222a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("favicon")) {
                            iArr[57] = FaviconParser.m18020a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("feed_unit")) {
                            iArr[58] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("first_value")) {
                            iArr[59] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("first_value_description")) {
                            iArr[60] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("footer")) {
                            iArr[61] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("friending_possibilities")) {
                            iArr[62] = FriendingPossibilitiesParser.m15221a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("group_id")) {
                            iArr[63] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("has_bottom_border")) {
                            zArr[4] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("has_disabled_units")) {
                            zArr[5] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("has_inner_borders")) {
                            zArr[6] = true;
                            zArr2[3] = jsonParser.H();
                        } else if (i.equals("has_top_border")) {
                            zArr[7] = true;
                            zArr2[4] = jsonParser.H();
                        } else if (i.equals("header")) {
                            iArr[68] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("header_image100")) {
                            iArr[69] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("header_text")) {
                            iArr[70] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("hero_image")) {
                            iArr[71] = HeroImageParser.m18029a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("hero_video_uri")) {
                            iArr[72] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("high_temperature")) {
                            iArr[73] = HighTemperatureParser.m18236a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("highlight_color")) {
                            iArr[74] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("home_voting_page")) {
                            iArr[75] = HomeVotingPageParser.m15228a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("hour_ranges")) {
                            iArr[76] = DefaultTimeRangeFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("icon")) {
                            iArr[77] = IconParser.m18113a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("icon_image")) {
                            iArr[78] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("icon_image_after")) {
                            iArr[79] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("icon_image_before")) {
                            iArr[80] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("image")) {
                            iArr[81] = ImageParser.m18115a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("image_background")) {
                            iArr[82] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("image_block_image")) {
                            iArr[83] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("image_block_image_48")) {
                            iArr[84] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("images")) {
                            iArr[85] = ReactionImageFieldsParser.m14693b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("images_with_overlay")) {
                            iArr[86] = ImagesWithOverlayParser.m18170a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("impressum")) {
                            iArr[87] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("impressum_action")) {
                            iArr[88] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("is_join_request_sent")) {
                            zArr[8] = true;
                            zArr2[5] = jsonParser.H();
                        } else if (i.equals("is_pinned")) {
                            zArr[9] = true;
                            zArr2[6] = jsonParser.H();
                        } else if (i.equals("is_place_tip")) {
                            zArr[10] = true;
                            zArr2[7] = jsonParser.H();
                        } else if (i.equals("is_saved_place")) {
                            zArr[11] = true;
                            zArr2[8] = jsonParser.H();
                        } else if (i.equals("is_self_location")) {
                            zArr[12] = true;
                            zArr2[9] = jsonParser.H();
                        } else if (i.equals("is_verified")) {
                            zArr[13] = true;
                            zArr2[10] = jsonParser.H();
                        } else if (i.equals("label_one")) {
                            iArr[95] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("label_one_color")) {
                            iArr[96] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("label_two")) {
                            iArr[97] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("label_two_color")) {
                            iArr[98] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("left_color")) {
                            iArr[99] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("left_label")) {
                            iArr[100] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("left_value")) {
                            zArr[14] = true;
                            dArr[1] = jsonParser.G();
                        } else if (i.equals("location")) {
                            iArr[102] = LocationParser.m18117a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("location_text")) {
                            iArr[103] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("location_type")) {
                            iArr[104] = flatBufferBuilder.a(GraphQLAcornLocationType.fromString(jsonParser.o()));
                        } else if (i.equals("locations")) {
                            iArr[105] = LocationsParser.m18195a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("low_temperature")) {
                            iArr[106] = LowTemperatureParser.m18238a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("main_info")) {
                            iArr[107] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("map_bounding_box")) {
                            iArr[108] = ReactionGeoRectangleFieldsParser.m14688a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("match")) {
                            iArr[109] = MatchParser.m18133a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("message")) {
                            iArr[110] = MessageParser.m18141a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("message_after")) {
                            iArr[111] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("message_before")) {
                            iArr[112] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("message_color")) {
                            iArr[113] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("message_snippet")) {
                            iArr[114] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("month_text")) {
                            iArr[115] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("notifications_default_count")) {
                            zArr[15] = true;
                            iArr2[2] = jsonParser.E();
                        } else if (i.equals("notifications_empty_message")) {
                            iArr[117] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("notifications_inline_expansion_count")) {
                            zArr[16] = true;
                            iArr2[3] = jsonParser.E();
                        } else if (i.equals("notifications_inline_expansion_message")) {
                            iArr[119] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("notifications_view_all_message")) {
                            iArr[120] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("only_display_status")) {
                            zArr[17] = true;
                            zArr2[11] = jsonParser.H();
                        } else if (i.equals("open_album_actions")) {
                            iArr[122] = ReactionUnitOpenAlbumActionsFragmentParser.m18191a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("other_user_name")) {
                            iArr[123] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("page")) {
                            iArr[124] = PageParser.m18143a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("percent_of_goal_reached")) {
                            zArr[18] = true;
                            dArr[2] = jsonParser.G();
                        } else if (i.equals("phone_number_action")) {
                            iArr[126] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("phone_text")) {
                            iArr[127] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("photo")) {
                            iArr[128] = PhotoParser.m15240a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("photo_attachments")) {
                            iArr[129] = GraphQLStoryAttachmentDeserializer.b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("photos")) {
                            iArr[130] = SizeAwareMediaParser.b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_category")) {
                            iArr[131] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_image")) {
                            iArr[132] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_info_blurb_breadcrumbs")) {
                            iArr[133] = PlaceInfoBlurbBreadcrumbsParser.m18216a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_info_blurb_page")) {
                            iArr[134] = PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_info_blurb_rating")) {
                            zArr[19] = true;
                            dArr[3] = jsonParser.G();
                        } else if (i.equals("place_metadata_page")) {
                            iArr[136] = PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_type")) {
                            iArr[137] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                        } else if (i.equals("plays")) {
                            iArr[138] = GametimeDataFactFragmentParser.m15184b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("price_range")) {
                            iArr[139] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("primary_icon")) {
                            iArr[140] = PrimaryIconParser.m18175a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("primary_message")) {
                            iArr[141] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("primary_spec")) {
                            iArr[142] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("profile_image")) {
                            iArr[143] = ProfileImageParser.m18025a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("profile_image_background_height_ratio")) {
                            zArr[20] = true;
                            dArr[4] = jsonParser.G();
                        } else if (i.equals("profile_photo")) {
                            iArr[145] = ProfilePhotoParser.m18070a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("profiles")) {
                            iArr[146] = ProfilesParser.m18145a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("progress_bar_color")) {
                            iArr[147] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("progress_segments")) {
                            iArr[148] = ProgressSegmentsParser.m18073a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("prompt_text")) {
                            iArr[149] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("prune_behavior")) {
                            iArr[150] = flatBufferBuilder.a(GraphQLVideoChannelFeedUnitPruneBehavior.fromString(jsonParser.o()));
                        } else if (i.equals("publisher_context")) {
                            iArr[151] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("rating_count")) {
                            zArr[21] = true;
                            dArr[5] = jsonParser.G();
                        } else if (i.equals("rating_message")) {
                            iArr[153] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("rating_scale")) {
                            zArr[22] = true;
                            dArr[6] = jsonParser.G();
                        } else if (i.equals("rating_value")) {
                            zArr[23] = true;
                            dArr[7] = jsonParser.G();
                        } else if (i.equals("recommendation_context")) {
                            iArr[156] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("response_delay")) {
                            iArr[157] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("responsive_badge")) {
                            iArr[158] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("responsive_badge_color")) {
                            iArr[159] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("review_count_message")) {
                            iArr[160] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("right_color")) {
                            iArr[161] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("right_label")) {
                            iArr[162] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("right_value")) {
                            zArr[24] = true;
                            dArr[8] = jsonParser.G();
                        } else if (i.equals("second_value")) {
                            iArr[164] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("second_value_description")) {
                            iArr[165] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("secondary_actions")) {
                            iArr[166] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("secondary_message")) {
                            iArr[167] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("secondary_spec")) {
                            iArr[168] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("see_all_ratings_action")) {
                            iArr[169] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("service")) {
                            iArr[170] = PageServiceItemParser.m11181a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("services")) {
                            iArr[171] = PageServiceItemParser.m11183b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("should_upsell_location")) {
                            zArr[25] = true;
                            zArr2[12] = jsonParser.H();
                        } else if (i.equals("sports_fact")) {
                            iArr[173] = GametimeDataFactFragmentParser.m15182a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("spotlight_story_preview")) {
                            iArr[174] = SpotlightStoryPreviewParser.m15209a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("status_message")) {
                            iArr[175] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("status_text")) {
                            iArr[176] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("story")) {
                            iArr[177] = ReactionStoryAttachmentStoryFragmentParser.m14719a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("sub_component_width_ratio")) {
                            zArr[26] = true;
                            dArr[9] = jsonParser.G();
                        } else if (i.equals("sub_components")) {
                            iArr[179] = ReactionUnitComponentFieldsParser.m18153a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("sub_message")) {
                            iArr[180] = SubMessageParser.m18149a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("sub_message_color")) {
                            iArr[181] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("subheader")) {
                            iArr[182] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("submessage")) {
                            iArr[183] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("submessage_after")) {
                            iArr[184] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("submessage_before")) {
                            iArr[185] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("subtitle")) {
                            iArr[186] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("temperature")) {
                            iArr[187] = TemperatureParser.m18240a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("temperature_text")) {
                            iArr[188] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("tertiary_message")) {
                            iArr[189] = TertiaryMessageParser.m18151a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("tertiary_spec")) {
                            iArr[190] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("tertiary_title")) {
                            iArr[191] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("text_color")) {
                            iArr[192] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("time_bucket")) {
                            iArr[193] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("timestamp")) {
                            zArr[27] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("timezone")) {
                            iArr[195] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("title")) {
                            iArr[196] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("total_votes")) {
                            zArr[28] = true;
                            iArr2[4] = jsonParser.E();
                        } else if (i.equals("truncation_string")) {
                            iArr[198] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("typed_data")) {
                            iArr[199] = TypedDataParser.m15231a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("typed_headers")) {
                            iArr[200] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("venue_name")) {
                            iArr[201] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video")) {
                            iArr[202] = VideoDetailFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video_channel")) {
                            iArr[203] = VideoHomeCreatorYouShouldFollowParser.m19748a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("weather_icon")) {
                            iArr[204] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("weather_tap_action")) {
                            iArr[205] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("website")) {
                            iArr[206] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("website_action")) {
                            iArr[207] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("write_review_action")) {
                            iArr[208] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("xout_nux_type")) {
                            iArr[209] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("zoom_level")) {
                            zArr[29] = true;
                            iArr2[5] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(211);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                if (zArr[0]) {
                    flatBufferBuilder.a(6, iArr2[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(7, iArr2[1], 0);
                }
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
                if (zArr[2]) {
                    flatBufferBuilder.a(20, zArr2[0]);
                }
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
                if (zArr[3]) {
                    flatBufferBuilder.a(31, dArr[0], 0.0d);
                }
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
                flatBufferBuilder.b(61, iArr[61]);
                flatBufferBuilder.b(62, iArr[62]);
                flatBufferBuilder.b(63, iArr[63]);
                if (zArr[4]) {
                    flatBufferBuilder.a(64, zArr2[1]);
                }
                if (zArr[5]) {
                    flatBufferBuilder.a(65, zArr2[2]);
                }
                if (zArr[6]) {
                    flatBufferBuilder.a(66, zArr2[3]);
                }
                if (zArr[7]) {
                    flatBufferBuilder.a(67, zArr2[4]);
                }
                flatBufferBuilder.b(68, iArr[68]);
                flatBufferBuilder.b(69, iArr[69]);
                flatBufferBuilder.b(70, iArr[70]);
                flatBufferBuilder.b(71, iArr[71]);
                flatBufferBuilder.b(72, iArr[72]);
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
                flatBufferBuilder.b(86, iArr[86]);
                flatBufferBuilder.b(87, iArr[87]);
                flatBufferBuilder.b(88, iArr[88]);
                if (zArr[8]) {
                    flatBufferBuilder.a(89, zArr2[5]);
                }
                if (zArr[9]) {
                    flatBufferBuilder.a(90, zArr2[6]);
                }
                if (zArr[10]) {
                    flatBufferBuilder.a(91, zArr2[7]);
                }
                if (zArr[11]) {
                    flatBufferBuilder.a(92, zArr2[8]);
                }
                if (zArr[12]) {
                    flatBufferBuilder.a(93, zArr2[9]);
                }
                if (zArr[13]) {
                    flatBufferBuilder.a(94, zArr2[10]);
                }
                flatBufferBuilder.b(95, iArr[95]);
                flatBufferBuilder.b(96, iArr[96]);
                flatBufferBuilder.b(97, iArr[97]);
                flatBufferBuilder.b(98, iArr[98]);
                flatBufferBuilder.b(99, iArr[99]);
                flatBufferBuilder.b(100, iArr[100]);
                if (zArr[14]) {
                    flatBufferBuilder.a(101, dArr[1], 0.0d);
                }
                flatBufferBuilder.b(102, iArr[102]);
                flatBufferBuilder.b(103, iArr[103]);
                flatBufferBuilder.b(104, iArr[104]);
                flatBufferBuilder.b(105, iArr[105]);
                flatBufferBuilder.b(106, iArr[106]);
                flatBufferBuilder.b(107, iArr[107]);
                flatBufferBuilder.b(108, iArr[108]);
                flatBufferBuilder.b(109, iArr[109]);
                flatBufferBuilder.b(110, iArr[110]);
                flatBufferBuilder.b(111, iArr[111]);
                flatBufferBuilder.b(112, iArr[112]);
                flatBufferBuilder.b(113, iArr[113]);
                flatBufferBuilder.b(114, iArr[114]);
                flatBufferBuilder.b(115, iArr[115]);
                if (zArr[15]) {
                    flatBufferBuilder.a(116, iArr2[2], 0);
                }
                flatBufferBuilder.b(117, iArr[117]);
                if (zArr[16]) {
                    flatBufferBuilder.a(118, iArr2[3], 0);
                }
                flatBufferBuilder.b(119, iArr[119]);
                flatBufferBuilder.b(120, iArr[120]);
                if (zArr[17]) {
                    flatBufferBuilder.a(121, zArr2[11]);
                }
                flatBufferBuilder.b(122, iArr[122]);
                flatBufferBuilder.b(123, iArr[123]);
                flatBufferBuilder.b(124, iArr[124]);
                if (zArr[18]) {
                    flatBufferBuilder.a(125, dArr[2], 0.0d);
                }
                flatBufferBuilder.b(126, iArr[126]);
                flatBufferBuilder.b(127, iArr[127]);
                flatBufferBuilder.b(128, iArr[128]);
                flatBufferBuilder.b(129, iArr[129]);
                flatBufferBuilder.b(130, iArr[130]);
                flatBufferBuilder.b(131, iArr[131]);
                flatBufferBuilder.b(132, iArr[132]);
                flatBufferBuilder.b(133, iArr[133]);
                flatBufferBuilder.b(134, iArr[134]);
                if (zArr[19]) {
                    flatBufferBuilder.a(135, dArr[3], 0.0d);
                }
                flatBufferBuilder.b(136, iArr[136]);
                flatBufferBuilder.b(137, iArr[137]);
                flatBufferBuilder.b(138, iArr[138]);
                flatBufferBuilder.b(139, iArr[139]);
                flatBufferBuilder.b(140, iArr[140]);
                flatBufferBuilder.b(141, iArr[141]);
                flatBufferBuilder.b(142, iArr[142]);
                flatBufferBuilder.b(143, iArr[143]);
                if (zArr[20]) {
                    flatBufferBuilder.a(144, dArr[4], 0.0d);
                }
                flatBufferBuilder.b(145, iArr[145]);
                flatBufferBuilder.b(146, iArr[146]);
                flatBufferBuilder.b(147, iArr[147]);
                flatBufferBuilder.b(148, iArr[148]);
                flatBufferBuilder.b(149, iArr[149]);
                flatBufferBuilder.b(150, iArr[150]);
                flatBufferBuilder.b(151, iArr[151]);
                if (zArr[21]) {
                    flatBufferBuilder.a(152, dArr[5], 0.0d);
                }
                flatBufferBuilder.b(153, iArr[153]);
                if (zArr[22]) {
                    flatBufferBuilder.a(154, dArr[6], 0.0d);
                }
                if (zArr[23]) {
                    flatBufferBuilder.a(155, dArr[7], 0.0d);
                }
                flatBufferBuilder.b(156, iArr[156]);
                flatBufferBuilder.b(157, iArr[157]);
                flatBufferBuilder.b(158, iArr[158]);
                flatBufferBuilder.b(159, iArr[159]);
                flatBufferBuilder.b(160, iArr[160]);
                flatBufferBuilder.b(161, iArr[161]);
                flatBufferBuilder.b(162, iArr[162]);
                if (zArr[24]) {
                    flatBufferBuilder.a(163, dArr[8], 0.0d);
                }
                flatBufferBuilder.b(164, iArr[164]);
                flatBufferBuilder.b(165, iArr[165]);
                flatBufferBuilder.b(166, iArr[166]);
                flatBufferBuilder.b(167, iArr[167]);
                flatBufferBuilder.b(168, iArr[168]);
                flatBufferBuilder.b(169, iArr[169]);
                flatBufferBuilder.b(170, iArr[170]);
                flatBufferBuilder.b(171, iArr[171]);
                if (zArr[25]) {
                    flatBufferBuilder.a(172, zArr2[12]);
                }
                flatBufferBuilder.b(173, iArr[173]);
                flatBufferBuilder.b(174, iArr[174]);
                flatBufferBuilder.b(175, iArr[175]);
                flatBufferBuilder.b(176, iArr[176]);
                flatBufferBuilder.b(177, iArr[177]);
                if (zArr[26]) {
                    flatBufferBuilder.a(178, dArr[9], 0.0d);
                }
                flatBufferBuilder.b(179, iArr[179]);
                flatBufferBuilder.b(180, iArr[180]);
                flatBufferBuilder.b(181, iArr[181]);
                flatBufferBuilder.b(182, iArr[182]);
                flatBufferBuilder.b(183, iArr[183]);
                flatBufferBuilder.b(184, iArr[184]);
                flatBufferBuilder.b(185, iArr[185]);
                flatBufferBuilder.b(186, iArr[186]);
                flatBufferBuilder.b(187, iArr[187]);
                flatBufferBuilder.b(188, iArr[188]);
                flatBufferBuilder.b(189, iArr[189]);
                flatBufferBuilder.b(190, iArr[190]);
                flatBufferBuilder.b(191, iArr[191]);
                flatBufferBuilder.b(192, iArr[192]);
                flatBufferBuilder.b(193, iArr[193]);
                if (zArr[27]) {
                    flatBufferBuilder.a(194, jArr[0], 0);
                }
                flatBufferBuilder.b(195, iArr[195]);
                flatBufferBuilder.b(196, iArr[196]);
                if (zArr[28]) {
                    flatBufferBuilder.a(197, iArr2[4], 0);
                }
                flatBufferBuilder.b(198, iArr[198]);
                flatBufferBuilder.b(199, iArr[199]);
                flatBufferBuilder.b(200, iArr[200]);
                flatBufferBuilder.b(201, iArr[201]);
                flatBufferBuilder.b(202, iArr[202]);
                flatBufferBuilder.b(203, iArr[203]);
                flatBufferBuilder.b(204, iArr[204]);
                flatBufferBuilder.b(205, iArr[205]);
                flatBufferBuilder.b(206, iArr[206]);
                flatBufferBuilder.b(207, iArr[207]);
                flatBufferBuilder.b(208, iArr[208]);
                flatBufferBuilder.b(209, iArr[209]);
                if (zArr[29]) {
                    flatBufferBuilder.a(210, iArr2[5], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m18166a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("actions");
                    ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("album");
                    AlbumParser.m18214a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("all_cards_enabled_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("all_cards_enabled_submessage");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 6, 0);
                if (g != 0) {
                    jsonGenerator.a("auto_execute_action_delay");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 7, 0);
                if (g != 0) {
                    jsonGenerator.a("auto_paginate_count");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 8);
                if (g != 0) {
                    jsonGenerator.a("aux_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 9);
                if (g != 0) {
                    jsonGenerator.a("aux_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("auxiliary_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("away_voting_page");
                    AwayVotingPageParser.m15227a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 12) != 0) {
                    jsonGenerator.a("background_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 12));
                }
                g = mutableFlatBuffer.g(i, 13);
                if (g != 0) {
                    jsonGenerator.a("background_image");
                    BackgroundImageParser.m18108a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 14) != 0) {
                    jsonGenerator.a("background_video_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 14));
                }
                g = mutableFlatBuffer.g(i, 15);
                if (g != 0) {
                    jsonGenerator.a("badgable_profiles");
                    BadgableProfilesParser.m15719a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 16);
                if (g != 0) {
                    jsonGenerator.a("badge_icon");
                    BadgeIconParser.m18059a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("bar_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 18) != 0) {
                    jsonGenerator.a("boosted_component_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 18));
                }
                if (mutableFlatBuffer.g(i, 19) != 0) {
                    jsonGenerator.a("border_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 19));
                }
                boolean a = mutableFlatBuffer.a(i, 20);
                if (a) {
                    jsonGenerator.a("bottom_border");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 21);
                if (g != 0) {
                    jsonGenerator.a("breadcrumbs");
                    BreadcrumbsParser.m18110a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 22);
                if (g != 0) {
                    jsonGenerator.a("card_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 23);
                if (g != 0) {
                    jsonGenerator.a("category_name");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 24);
                if (g != 0) {
                    jsonGenerator.a("center_location");
                    DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 25);
                if (g != 0) {
                    jsonGenerator.a("close_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 26);
                if (g != 0) {
                    jsonGenerator.a("comment");
                    CommentParser.m18105a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 27) != 0) {
                    jsonGenerator.a("component_logical_path");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 27));
                }
                if (mutableFlatBuffer.g(i, 28) != 0) {
                    jsonGenerator.a("component_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 28));
                }
                if (mutableFlatBuffer.g(i, 29) != 0) {
                    jsonGenerator.a("component_tracking_data");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 29));
                }
                g = mutableFlatBuffer.g(i, 30);
                if (g != 0) {
                    jsonGenerator.a("context_list");
                    ContextListParser.m18233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                double a2 = mutableFlatBuffer.a(i, 31, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("core_attribute_aspect_ratio_value");
                    jsonGenerator.a(a2);
                }
                if (mutableFlatBuffer.g(i, 32) != 0) {
                    jsonGenerator.a("core_attribute_background_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 32));
                }
                g = mutableFlatBuffer.g(i, 33);
                if (g != 0) {
                    jsonGenerator.a("core_attribute_border");
                    ReactionCoreComponentBorderSpecFieldsParser.m15285a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 34) != 0) {
                    jsonGenerator.a("core_attribute_glyph_alignment");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 34));
                }
                if (mutableFlatBuffer.g(i, 35) != 0) {
                    jsonGenerator.a("core_attribute_image_size");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 35));
                }
                g = mutableFlatBuffer.g(i, 36);
                if (g != 0) {
                    jsonGenerator.a("core_attribute_margin");
                    ReactionCoreComponentMarginSpecFieldsParser.m15287a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 37);
                if (g != 0) {
                    jsonGenerator.a("core_attribute_padding");
                    ReactionCoreComponentPaddingSpecFieldsParser.m15289a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 38);
                if (g != 0) {
                    jsonGenerator.a("core_glyph");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 39);
                if (g != 0) {
                    jsonGenerator.a("core_image");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 40);
                if (g != 0) {
                    jsonGenerator.a("counts");
                    CountsParser.m18161a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 41);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 42);
                if (g != 0) {
                    jsonGenerator.a("customer_data");
                    CustomerDataParser.m18055a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 43);
                if (g != 0) {
                    jsonGenerator.a("date_summary_text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 44);
                if (g != 0) {
                    jsonGenerator.a("date_summary_text_long");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 45) != 0) {
                    jsonGenerator.a("date_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 45));
                }
                g = mutableFlatBuffer.g(i, 46);
                if (g != 0) {
                    jsonGenerator.a("day_time_text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 47);
                if (g != 0) {
                    jsonGenerator.a("decoration_icon");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 48);
                if (g != 0) {
                    jsonGenerator.a("description");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 49);
                if (g != 0) {
                    jsonGenerator.a("detail_items");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 50) != 0) {
                    jsonGenerator.a("display_decision");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 50));
                }
                if (mutableFlatBuffer.g(i, 51) != 0) {
                    jsonGenerator.a("distance_string");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 51));
                }
                g = mutableFlatBuffer.g(i, 52);
                if (g != 0) {
                    jsonGenerator.a("distance_text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 53);
                if (g != 0) {
                    jsonGenerator.a("empty_state_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 54);
                if (g != 0) {
                    jsonGenerator.a("example_frame_image");
                    ExampleFrameImageParser.m18069a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 55);
                if (g != 0) {
                    jsonGenerator.a("explore_feed");
                    VideoTopicFragmentParser.m19022b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 56);
                if (g != 0) {
                    jsonGenerator.a("facepile");
                    FacepileParser.m18223a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 57);
                if (g != 0) {
                    jsonGenerator.a("favicon");
                    FaviconParser.m18021a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 58);
                if (g != 0) {
                    jsonGenerator.a("feed_unit");
                    GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 59);
                if (g != 0) {
                    jsonGenerator.a("first_value");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 60);
                if (g != 0) {
                    jsonGenerator.a("first_value_description");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 61);
                if (g != 0) {
                    jsonGenerator.a("footer");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 62);
                if (g != 0) {
                    jsonGenerator.a("friending_possibilities");
                    FriendingPossibilitiesParser.m15222a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 63) != 0) {
                    jsonGenerator.a("group_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 63));
                }
                a = mutableFlatBuffer.a(i, 64);
                if (a) {
                    jsonGenerator.a("has_bottom_border");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 65);
                if (a) {
                    jsonGenerator.a("has_disabled_units");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 66);
                if (a) {
                    jsonGenerator.a("has_inner_borders");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 67);
                if (a) {
                    jsonGenerator.a("has_top_border");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 68);
                if (g != 0) {
                    jsonGenerator.a("header");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 69);
                if (g != 0) {
                    jsonGenerator.a("header_image100");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 70);
                if (g != 0) {
                    jsonGenerator.a("header_text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 71);
                if (g != 0) {
                    jsonGenerator.a("hero_image");
                    HeroImageParser.m18030a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 72) != 0) {
                    jsonGenerator.a("hero_video_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 72));
                }
                g = mutableFlatBuffer.g(i, 73);
                if (g != 0) {
                    jsonGenerator.a("high_temperature");
                    HighTemperatureParser.m18237a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 74) != 0) {
                    jsonGenerator.a("highlight_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 74));
                }
                g = mutableFlatBuffer.g(i, 75);
                if (g != 0) {
                    jsonGenerator.a("home_voting_page");
                    HomeVotingPageParser.m15229a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 76);
                if (g != 0) {
                    jsonGenerator.a("hour_ranges");
                    DefaultTimeRangeFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 77);
                if (g != 0) {
                    jsonGenerator.a("icon");
                    IconParser.m18114a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 78);
                if (g != 0) {
                    jsonGenerator.a("icon_image");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 79);
                if (g != 0) {
                    jsonGenerator.a("icon_image_after");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 80);
                if (g != 0) {
                    jsonGenerator.a("icon_image_before");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 81);
                if (g != 0) {
                    jsonGenerator.a("image");
                    ImageParser.m18116a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 82) != 0) {
                    jsonGenerator.a("image_background");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 82));
                }
                g = mutableFlatBuffer.g(i, 83);
                if (g != 0) {
                    jsonGenerator.a("image_block_image");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 84);
                if (g != 0) {
                    jsonGenerator.a("image_block_image_48");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 85);
                if (g != 0) {
                    jsonGenerator.a("images");
                    ReactionImageFieldsParser.m14692a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 86);
                if (g != 0) {
                    jsonGenerator.a("images_with_overlay");
                    ImagesWithOverlayParser.m18171a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 87);
                if (g != 0) {
                    jsonGenerator.a("impressum");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 88);
                if (g != 0) {
                    jsonGenerator.a("impressum_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.a(i, 89);
                if (a) {
                    jsonGenerator.a("is_join_request_sent");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 90);
                if (a) {
                    jsonGenerator.a("is_pinned");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 91);
                if (a) {
                    jsonGenerator.a("is_place_tip");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 92);
                if (a) {
                    jsonGenerator.a("is_saved_place");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 93);
                if (a) {
                    jsonGenerator.a("is_self_location");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 94);
                if (a) {
                    jsonGenerator.a("is_verified");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 95);
                if (g != 0) {
                    jsonGenerator.a("label_one");
                    LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 96) != 0) {
                    jsonGenerator.a("label_one_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 96));
                }
                g = mutableFlatBuffer.g(i, 97);
                if (g != 0) {
                    jsonGenerator.a("label_two");
                    LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 98) != 0) {
                    jsonGenerator.a("label_two_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 98));
                }
                if (mutableFlatBuffer.g(i, 99) != 0) {
                    jsonGenerator.a("left_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 99));
                }
                if (mutableFlatBuffer.g(i, 100) != 0) {
                    jsonGenerator.a("left_label");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 100));
                }
                a2 = mutableFlatBuffer.a(i, 101, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("left_value");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 102);
                if (g != 0) {
                    jsonGenerator.a("location");
                    LocationParser.m18118a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 103);
                if (g != 0) {
                    jsonGenerator.a("location_text");
                    ReactionTextWithEntitiesWithImagesParser.m14726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 104) != 0) {
                    jsonGenerator.a("location_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 104));
                }
                g = mutableFlatBuffer.g(i, 105);
                if (g != 0) {
                    jsonGenerator.a("locations");
                    LocationsParser.m18197a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 106);
                if (g != 0) {
                    jsonGenerator.a("low_temperature");
                    LowTemperatureParser.m18239a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 107);
                if (g != 0) {
                    jsonGenerator.a("main_info");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 108);
                if (g != 0) {
                    jsonGenerator.a("map_bounding_box");
                    ReactionGeoRectangleFieldsParser.m14689a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 109);
                if (g != 0) {
                    jsonGenerator.a("match");
                    MatchParser.m18134a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 110);
                if (g != 0) {
                    jsonGenerator.a("message");
                    MessageParser.m18142a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 111);
                if (g != 0) {
                    jsonGenerator.a("message_after");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 112);
                if (g != 0) {
                    jsonGenerator.a("message_before");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 113) != 0) {
                    jsonGenerator.a("message_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 113));
                }
                g = mutableFlatBuffer.g(i, 114);
                if (g != 0) {
                    jsonGenerator.a("message_snippet");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 115) != 0) {
                    jsonGenerator.a("month_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 115));
                }
                g = mutableFlatBuffer.a(i, 116, 0);
                if (g != 0) {
                    jsonGenerator.a("notifications_default_count");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 117);
                if (g != 0) {
                    jsonGenerator.a("notifications_empty_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 118, 0);
                if (g != 0) {
                    jsonGenerator.a("notifications_inline_expansion_count");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 119);
                if (g != 0) {
                    jsonGenerator.a("notifications_inline_expansion_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 120);
                if (g != 0) {
                    jsonGenerator.a("notifications_view_all_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                a = mutableFlatBuffer.a(i, 121);
                if (a) {
                    jsonGenerator.a("only_display_status");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 122);
                if (g != 0) {
                    jsonGenerator.a("open_album_actions");
                    ReactionUnitOpenAlbumActionsFragmentParser.m18192a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 123);
                if (g != 0) {
                    jsonGenerator.a("other_user_name");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 124);
                if (g != 0) {
                    jsonGenerator.a("page");
                    PageParser.m18144a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a2 = mutableFlatBuffer.a(i, 125, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("percent_of_goal_reached");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 126);
                if (g != 0) {
                    jsonGenerator.a("phone_number_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 127);
                if (g != 0) {
                    jsonGenerator.a("phone_text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 128);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    PhotoParser.m15241a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 129);
                if (g != 0) {
                    jsonGenerator.a("photo_attachments");
                    GraphQLStoryAttachmentDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 130);
                if (g != 0) {
                    jsonGenerator.a("photos");
                    SizeAwareMediaParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 131);
                if (g != 0) {
                    jsonGenerator.a("place_category");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 132);
                if (g != 0) {
                    jsonGenerator.a("place_image");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 133);
                if (g != 0) {
                    jsonGenerator.a("place_info_blurb_breadcrumbs");
                    PlaceInfoBlurbBreadcrumbsParser.m18217a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 134);
                if (g != 0) {
                    jsonGenerator.a("place_info_blurb_page");
                    PlaceInfoBlurbFieldsParser.m14683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a2 = mutableFlatBuffer.a(i, 135, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("place_info_blurb_rating");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 136);
                if (g != 0) {
                    jsonGenerator.a("place_metadata_page");
                    PlaceInfoBlurbFieldsParser.m14683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 137) != 0) {
                    jsonGenerator.a("place_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 137));
                }
                g = mutableFlatBuffer.g(i, 138);
                if (g != 0) {
                    jsonGenerator.a("plays");
                    GametimeDataFactFragmentParser.m15183a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 139) != 0) {
                    jsonGenerator.a("price_range");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 139));
                }
                g = mutableFlatBuffer.g(i, 140);
                if (g != 0) {
                    jsonGenerator.a("primary_icon");
                    PrimaryIconParser.m18176a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 141);
                if (g != 0) {
                    jsonGenerator.a("primary_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 142);
                if (g != 0) {
                    jsonGenerator.a("primary_spec");
                    ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 143);
                if (g != 0) {
                    jsonGenerator.a("profile_image");
                    ProfileImageParser.m18026a(mutableFlatBuffer, g, jsonGenerator);
                }
                a2 = mutableFlatBuffer.a(i, 144, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("profile_image_background_height_ratio");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 145);
                if (g != 0) {
                    jsonGenerator.a("profile_photo");
                    ProfilePhotoParser.m18071a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 146);
                if (g != 0) {
                    jsonGenerator.a("profiles");
                    ProfilesParser.m18146a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 147) != 0) {
                    jsonGenerator.a("progress_bar_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 147));
                }
                g = mutableFlatBuffer.g(i, 148);
                if (g != 0) {
                    jsonGenerator.a("progress_segments");
                    ProgressSegmentsParser.m18075a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 149) != 0) {
                    jsonGenerator.a("prompt_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 149));
                }
                if (mutableFlatBuffer.g(i, 150) != 0) {
                    jsonGenerator.a("prune_behavior");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 150));
                }
                g = mutableFlatBuffer.g(i, 151);
                if (g != 0) {
                    jsonGenerator.a("publisher_context");
                    ReactionTextWithEntitiesWithImagesParser.m14726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a2 = mutableFlatBuffer.a(i, 152, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("rating_count");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 153);
                if (g != 0) {
                    jsonGenerator.a("rating_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                a2 = mutableFlatBuffer.a(i, 154, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("rating_scale");
                    jsonGenerator.a(a2);
                }
                a2 = mutableFlatBuffer.a(i, 155, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("rating_value");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 156);
                if (g != 0) {
                    jsonGenerator.a("recommendation_context");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 157);
                if (g != 0) {
                    jsonGenerator.a("response_delay");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 158);
                if (g != 0) {
                    jsonGenerator.a("responsive_badge");
                    LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 159) != 0) {
                    jsonGenerator.a("responsive_badge_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 159));
                }
                g = mutableFlatBuffer.g(i, 160);
                if (g != 0) {
                    jsonGenerator.a("review_count_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 161) != 0) {
                    jsonGenerator.a("right_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 161));
                }
                if (mutableFlatBuffer.g(i, 162) != 0) {
                    jsonGenerator.a("right_label");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 162));
                }
                a2 = mutableFlatBuffer.a(i, 163, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("right_value");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 164);
                if (g != 0) {
                    jsonGenerator.a("second_value");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 165);
                if (g != 0) {
                    jsonGenerator.a("second_value_description");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 166);
                if (g != 0) {
                    jsonGenerator.a("secondary_actions");
                    ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 167);
                if (g != 0) {
                    jsonGenerator.a("secondary_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 168);
                if (g != 0) {
                    jsonGenerator.a("secondary_spec");
                    ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 169);
                if (g != 0) {
                    jsonGenerator.a("see_all_ratings_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 170);
                if (g != 0) {
                    jsonGenerator.a("service");
                    PageServiceItemParser.m11184b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 171);
                if (g != 0) {
                    jsonGenerator.a("services");
                    PageServiceItemParser.m11182a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.a(i, 172);
                if (a) {
                    jsonGenerator.a("should_upsell_location");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 173);
                if (g != 0) {
                    jsonGenerator.a("sports_fact");
                    GametimeDataFactFragmentParser.m15185b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 174);
                if (g != 0) {
                    jsonGenerator.a("spotlight_story_preview");
                    SpotlightStoryPreviewParser.m15210a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 175);
                if (g != 0) {
                    jsonGenerator.a("status_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 176) != 0) {
                    jsonGenerator.a("status_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 176));
                }
                g = mutableFlatBuffer.g(i, 177);
                if (g != 0) {
                    jsonGenerator.a("story");
                    ReactionStoryAttachmentStoryFragmentParser.m14720a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a2 = mutableFlatBuffer.a(i, 178, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("sub_component_width_ratio");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 179);
                if (g != 0) {
                    jsonGenerator.a("sub_components");
                    ReactionUnitComponentFieldsParser.m18154a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 180);
                if (g != 0) {
                    jsonGenerator.a("sub_message");
                    SubMessageParser.m18150a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 181) != 0) {
                    jsonGenerator.a("sub_message_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 181));
                }
                g = mutableFlatBuffer.g(i, 182);
                if (g != 0) {
                    jsonGenerator.a("subheader");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 183);
                if (g != 0) {
                    jsonGenerator.a("submessage");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 184);
                if (g != 0) {
                    jsonGenerator.a("submessage_after");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 185);
                if (g != 0) {
                    jsonGenerator.a("submessage_before");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 186);
                if (g != 0) {
                    jsonGenerator.a("subtitle");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 187);
                if (g != 0) {
                    jsonGenerator.a("temperature");
                    TemperatureParser.m18241a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 188);
                if (g != 0) {
                    jsonGenerator.a("temperature_text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 189);
                if (g != 0) {
                    jsonGenerator.a("tertiary_message");
                    TertiaryMessageParser.m18152a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 190);
                if (g != 0) {
                    jsonGenerator.a("tertiary_spec");
                    ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 191);
                if (g != 0) {
                    jsonGenerator.a("tertiary_title");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 192) != 0) {
                    jsonGenerator.a("text_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 192));
                }
                if (mutableFlatBuffer.g(i, 193) != 0) {
                    jsonGenerator.a("time_bucket");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 193));
                }
                long a3 = mutableFlatBuffer.a(i, 194, 0);
                if (a3 != 0) {
                    jsonGenerator.a("timestamp");
                    jsonGenerator.a(a3);
                }
                if (mutableFlatBuffer.g(i, 195) != 0) {
                    jsonGenerator.a("timezone");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 195));
                }
                g = mutableFlatBuffer.g(i, 196);
                if (g != 0) {
                    jsonGenerator.a("title");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 197, 0);
                if (g != 0) {
                    jsonGenerator.a("total_votes");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 198);
                if (g != 0) {
                    jsonGenerator.a("truncation_string");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 199);
                if (g != 0) {
                    jsonGenerator.a("typed_data");
                    TypedDataParser.m15233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 200) != 0) {
                    jsonGenerator.a("typed_headers");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 200), jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 201);
                if (g != 0) {
                    jsonGenerator.a("venue_name");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 202);
                if (g != 0) {
                    jsonGenerator.a("video");
                    VideoDetailFragmentParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 203);
                if (g != 0) {
                    jsonGenerator.a("video_channel");
                    VideoHomeCreatorYouShouldFollowParser.m19749a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 204);
                if (g != 0) {
                    jsonGenerator.a("weather_icon");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 205);
                if (g != 0) {
                    jsonGenerator.a("weather_tap_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 206);
                if (g != 0) {
                    jsonGenerator.a("website");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 207);
                if (g != 0) {
                    jsonGenerator.a("website_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 208);
                if (g != 0) {
                    jsonGenerator.a("write_review_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 209) != 0) {
                    jsonGenerator.a("xout_nux_type");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 209));
                }
                g = mutableFlatBuffer.a(i, 210, 0);
                if (g != 0) {
                    jsonGenerator.a("zoom_level");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetch_successful */
        public final class PositiveComponentParser {
            public static int m18167a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[211];
                boolean[] zArr = new boolean[30];
                boolean[] zArr2 = new boolean[13];
                int[] iArr2 = new int[6];
                long[] jArr = new long[1];
                double[] dArr = new double[10];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("action")) {
                            iArr[1] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("actions")) {
                            iArr[2] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("album")) {
                            iArr[3] = AlbumParser.m18213a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("all_cards_enabled_message")) {
                            iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("all_cards_enabled_submessage")) {
                            iArr[5] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("auto_execute_action_delay")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("auto_paginate_count")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("aux_action")) {
                            iArr[8] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("aux_message")) {
                            iArr[9] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("auxiliary_action")) {
                            iArr[10] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("away_voting_page")) {
                            iArr[11] = AwayVotingPageParser.m15226a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("background_color")) {
                            iArr[12] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("background_image")) {
                            iArr[13] = BackgroundImageParser.m18107a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("background_video_uri")) {
                            iArr[14] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("badgable_profiles")) {
                            iArr[15] = BadgableProfilesParser.m15718a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("badge_icon")) {
                            iArr[16] = BadgeIconParser.m18058a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("bar_message")) {
                            iArr[17] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("boosted_component_status")) {
                            iArr[18] = flatBufferBuilder.a(GraphQLBoostedComponentStatus.fromString(jsonParser.o()));
                        } else if (i.equals("border_color")) {
                            iArr[19] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("bottom_border")) {
                            zArr[2] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("breadcrumbs")) {
                            iArr[21] = BreadcrumbsParser.m18109a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("card_action")) {
                            iArr[22] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("category_name")) {
                            iArr[23] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("center_location")) {
                            iArr[24] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("close_action")) {
                            iArr[25] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("comment")) {
                            iArr[26] = CommentParser.m18104a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("component_logical_path")) {
                            iArr[27] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("component_style")) {
                            iArr[28] = flatBufferBuilder.a(GraphQLReactionUnitComponentStyle.fromString(jsonParser.o()));
                        } else if (i.equals("component_tracking_data")) {
                            iArr[29] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("context_list")) {
                            iArr[30] = ContextListParser.m18231a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("core_attribute_aspect_ratio_value")) {
                            zArr[3] = true;
                            dArr[0] = jsonParser.G();
                        } else if (i.equals("core_attribute_background_color")) {
                            iArr[32] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("core_attribute_border")) {
                            iArr[33] = ReactionCoreComponentBorderSpecFieldsParser.m15284a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("core_attribute_glyph_alignment")) {
                            iArr[34] = flatBufferBuilder.a(GraphQLReactionCoreButtonGlyphAlignment.fromString(jsonParser.o()));
                        } else if (i.equals("core_attribute_image_size")) {
                            iArr[35] = flatBufferBuilder.a(GraphQLReactionCoreImageTextImageSize.fromString(jsonParser.o()));
                        } else if (i.equals("core_attribute_margin")) {
                            iArr[36] = ReactionCoreComponentMarginSpecFieldsParser.m15286a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("core_attribute_padding")) {
                            iArr[37] = ReactionCoreComponentPaddingSpecFieldsParser.m15288a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("core_glyph")) {
                            iArr[38] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("core_image")) {
                            iArr[39] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("counts")) {
                            iArr[40] = CountsParser.m18160a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("cover_photo")) {
                            iArr[41] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("customer_data")) {
                            iArr[42] = CustomerDataParser.m18054a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("date_summary_text")) {
                            iArr[43] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("date_summary_text_long")) {
                            iArr[44] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("date_text")) {
                            iArr[45] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("day_time_text")) {
                            iArr[46] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("decoration_icon")) {
                            iArr[47] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("description")) {
                            iArr[48] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("detail_items")) {
                            iArr[49] = DefaultTextWithEntitiesFieldsParser.b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("display_decision")) {
                            iArr[50] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                        } else if (i.equals("distance_string")) {
                            iArr[51] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("distance_text")) {
                            iArr[52] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("empty_state_action")) {
                            iArr[53] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("example_frame_image")) {
                            iArr[54] = ExampleFrameImageParser.m18068a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("explore_feed")) {
                            iArr[55] = VideoTopicFragmentParser.m19021a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("facepile")) {
                            iArr[56] = FacepileParser.m18222a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("favicon")) {
                            iArr[57] = FaviconParser.m18020a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("feed_unit")) {
                            iArr[58] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("first_value")) {
                            iArr[59] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("first_value_description")) {
                            iArr[60] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("footer")) {
                            iArr[61] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("friending_possibilities")) {
                            iArr[62] = FriendingPossibilitiesParser.m15221a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("group_id")) {
                            iArr[63] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("has_bottom_border")) {
                            zArr[4] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("has_disabled_units")) {
                            zArr[5] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("has_inner_borders")) {
                            zArr[6] = true;
                            zArr2[3] = jsonParser.H();
                        } else if (i.equals("has_top_border")) {
                            zArr[7] = true;
                            zArr2[4] = jsonParser.H();
                        } else if (i.equals("header")) {
                            iArr[68] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("header_image100")) {
                            iArr[69] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("header_text")) {
                            iArr[70] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("hero_image")) {
                            iArr[71] = HeroImageParser.m18029a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("hero_video_uri")) {
                            iArr[72] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("high_temperature")) {
                            iArr[73] = HighTemperatureParser.m18236a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("highlight_color")) {
                            iArr[74] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("home_voting_page")) {
                            iArr[75] = HomeVotingPageParser.m15228a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("hour_ranges")) {
                            iArr[76] = DefaultTimeRangeFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("icon")) {
                            iArr[77] = IconParser.m18113a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("icon_image")) {
                            iArr[78] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("icon_image_after")) {
                            iArr[79] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("icon_image_before")) {
                            iArr[80] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("image")) {
                            iArr[81] = ImageParser.m18115a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("image_background")) {
                            iArr[82] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("image_block_image")) {
                            iArr[83] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("image_block_image_48")) {
                            iArr[84] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("images")) {
                            iArr[85] = ReactionImageFieldsParser.m14693b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("images_with_overlay")) {
                            iArr[86] = ImagesWithOverlayParser.m18170a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("impressum")) {
                            iArr[87] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("impressum_action")) {
                            iArr[88] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("is_join_request_sent")) {
                            zArr[8] = true;
                            zArr2[5] = jsonParser.H();
                        } else if (i.equals("is_pinned")) {
                            zArr[9] = true;
                            zArr2[6] = jsonParser.H();
                        } else if (i.equals("is_place_tip")) {
                            zArr[10] = true;
                            zArr2[7] = jsonParser.H();
                        } else if (i.equals("is_saved_place")) {
                            zArr[11] = true;
                            zArr2[8] = jsonParser.H();
                        } else if (i.equals("is_self_location")) {
                            zArr[12] = true;
                            zArr2[9] = jsonParser.H();
                        } else if (i.equals("is_verified")) {
                            zArr[13] = true;
                            zArr2[10] = jsonParser.H();
                        } else if (i.equals("label_one")) {
                            iArr[95] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("label_one_color")) {
                            iArr[96] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("label_two")) {
                            iArr[97] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("label_two_color")) {
                            iArr[98] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("left_color")) {
                            iArr[99] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("left_label")) {
                            iArr[100] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("left_value")) {
                            zArr[14] = true;
                            dArr[1] = jsonParser.G();
                        } else if (i.equals("location")) {
                            iArr[102] = LocationParser.m18117a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("location_text")) {
                            iArr[103] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("location_type")) {
                            iArr[104] = flatBufferBuilder.a(GraphQLAcornLocationType.fromString(jsonParser.o()));
                        } else if (i.equals("locations")) {
                            iArr[105] = LocationsParser.m18195a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("low_temperature")) {
                            iArr[106] = LowTemperatureParser.m18238a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("main_info")) {
                            iArr[107] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("map_bounding_box")) {
                            iArr[108] = ReactionGeoRectangleFieldsParser.m14688a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("match")) {
                            iArr[109] = MatchParser.m18133a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("message")) {
                            iArr[110] = MessageParser.m18141a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("message_after")) {
                            iArr[111] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("message_before")) {
                            iArr[112] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("message_color")) {
                            iArr[113] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("message_snippet")) {
                            iArr[114] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("month_text")) {
                            iArr[115] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("notifications_default_count")) {
                            zArr[15] = true;
                            iArr2[2] = jsonParser.E();
                        } else if (i.equals("notifications_empty_message")) {
                            iArr[117] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("notifications_inline_expansion_count")) {
                            zArr[16] = true;
                            iArr2[3] = jsonParser.E();
                        } else if (i.equals("notifications_inline_expansion_message")) {
                            iArr[119] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("notifications_view_all_message")) {
                            iArr[120] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("only_display_status")) {
                            zArr[17] = true;
                            zArr2[11] = jsonParser.H();
                        } else if (i.equals("open_album_actions")) {
                            iArr[122] = ReactionUnitOpenAlbumActionsFragmentParser.m18191a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("other_user_name")) {
                            iArr[123] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("page")) {
                            iArr[124] = PageParser.m18143a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("percent_of_goal_reached")) {
                            zArr[18] = true;
                            dArr[2] = jsonParser.G();
                        } else if (i.equals("phone_number_action")) {
                            iArr[126] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("phone_text")) {
                            iArr[127] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("photo")) {
                            iArr[128] = PhotoParser.m15240a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("photo_attachments")) {
                            iArr[129] = GraphQLStoryAttachmentDeserializer.b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("photos")) {
                            iArr[130] = SizeAwareMediaParser.b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_category")) {
                            iArr[131] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_image")) {
                            iArr[132] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_info_blurb_breadcrumbs")) {
                            iArr[133] = PlaceInfoBlurbBreadcrumbsParser.m18216a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_info_blurb_page")) {
                            iArr[134] = PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_info_blurb_rating")) {
                            zArr[19] = true;
                            dArr[3] = jsonParser.G();
                        } else if (i.equals("place_metadata_page")) {
                            iArr[136] = PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_type")) {
                            iArr[137] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                        } else if (i.equals("plays")) {
                            iArr[138] = GametimeDataFactFragmentParser.m15184b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("price_range")) {
                            iArr[139] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("primary_icon")) {
                            iArr[140] = PrimaryIconParser.m18175a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("primary_message")) {
                            iArr[141] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("primary_spec")) {
                            iArr[142] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("profile_image")) {
                            iArr[143] = ProfileImageParser.m18025a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("profile_image_background_height_ratio")) {
                            zArr[20] = true;
                            dArr[4] = jsonParser.G();
                        } else if (i.equals("profile_photo")) {
                            iArr[145] = ProfilePhotoParser.m18070a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("profiles")) {
                            iArr[146] = ProfilesParser.m18145a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("progress_bar_color")) {
                            iArr[147] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("progress_segments")) {
                            iArr[148] = ProgressSegmentsParser.m18073a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("prompt_text")) {
                            iArr[149] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("prune_behavior")) {
                            iArr[150] = flatBufferBuilder.a(GraphQLVideoChannelFeedUnitPruneBehavior.fromString(jsonParser.o()));
                        } else if (i.equals("publisher_context")) {
                            iArr[151] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("rating_count")) {
                            zArr[21] = true;
                            dArr[5] = jsonParser.G();
                        } else if (i.equals("rating_message")) {
                            iArr[153] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("rating_scale")) {
                            zArr[22] = true;
                            dArr[6] = jsonParser.G();
                        } else if (i.equals("rating_value")) {
                            zArr[23] = true;
                            dArr[7] = jsonParser.G();
                        } else if (i.equals("recommendation_context")) {
                            iArr[156] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("response_delay")) {
                            iArr[157] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("responsive_badge")) {
                            iArr[158] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("responsive_badge_color")) {
                            iArr[159] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("review_count_message")) {
                            iArr[160] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("right_color")) {
                            iArr[161] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("right_label")) {
                            iArr[162] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("right_value")) {
                            zArr[24] = true;
                            dArr[8] = jsonParser.G();
                        } else if (i.equals("second_value")) {
                            iArr[164] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("second_value_description")) {
                            iArr[165] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("secondary_actions")) {
                            iArr[166] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("secondary_message")) {
                            iArr[167] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("secondary_spec")) {
                            iArr[168] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("see_all_ratings_action")) {
                            iArr[169] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("service")) {
                            iArr[170] = PageServiceItemParser.m11181a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("services")) {
                            iArr[171] = PageServiceItemParser.m11183b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("should_upsell_location")) {
                            zArr[25] = true;
                            zArr2[12] = jsonParser.H();
                        } else if (i.equals("sports_fact")) {
                            iArr[173] = GametimeDataFactFragmentParser.m15182a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("spotlight_story_preview")) {
                            iArr[174] = SpotlightStoryPreviewParser.m15209a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("status_message")) {
                            iArr[175] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("status_text")) {
                            iArr[176] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("story")) {
                            iArr[177] = ReactionStoryAttachmentStoryFragmentParser.m14719a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("sub_component_width_ratio")) {
                            zArr[26] = true;
                            dArr[9] = jsonParser.G();
                        } else if (i.equals("sub_components")) {
                            iArr[179] = ReactionUnitComponentFieldsParser.m18153a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("sub_message")) {
                            iArr[180] = SubMessageParser.m18149a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("sub_message_color")) {
                            iArr[181] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("subheader")) {
                            iArr[182] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("submessage")) {
                            iArr[183] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("submessage_after")) {
                            iArr[184] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("submessage_before")) {
                            iArr[185] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("subtitle")) {
                            iArr[186] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("temperature")) {
                            iArr[187] = TemperatureParser.m18240a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("temperature_text")) {
                            iArr[188] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("tertiary_message")) {
                            iArr[189] = TertiaryMessageParser.m18151a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("tertiary_spec")) {
                            iArr[190] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("tertiary_title")) {
                            iArr[191] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("text_color")) {
                            iArr[192] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("time_bucket")) {
                            iArr[193] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("timestamp")) {
                            zArr[27] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("timezone")) {
                            iArr[195] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("title")) {
                            iArr[196] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("total_votes")) {
                            zArr[28] = true;
                            iArr2[4] = jsonParser.E();
                        } else if (i.equals("truncation_string")) {
                            iArr[198] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("typed_data")) {
                            iArr[199] = TypedDataParser.m15231a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("typed_headers")) {
                            iArr[200] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("venue_name")) {
                            iArr[201] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video")) {
                            iArr[202] = VideoDetailFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video_channel")) {
                            iArr[203] = VideoHomeCreatorYouShouldFollowParser.m19748a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("weather_icon")) {
                            iArr[204] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("weather_tap_action")) {
                            iArr[205] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("website")) {
                            iArr[206] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("website_action")) {
                            iArr[207] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("write_review_action")) {
                            iArr[208] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("xout_nux_type")) {
                            iArr[209] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("zoom_level")) {
                            zArr[29] = true;
                            iArr2[5] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(211);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                if (zArr[0]) {
                    flatBufferBuilder.a(6, iArr2[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(7, iArr2[1], 0);
                }
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
                if (zArr[2]) {
                    flatBufferBuilder.a(20, zArr2[0]);
                }
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
                if (zArr[3]) {
                    flatBufferBuilder.a(31, dArr[0], 0.0d);
                }
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
                flatBufferBuilder.b(61, iArr[61]);
                flatBufferBuilder.b(62, iArr[62]);
                flatBufferBuilder.b(63, iArr[63]);
                if (zArr[4]) {
                    flatBufferBuilder.a(64, zArr2[1]);
                }
                if (zArr[5]) {
                    flatBufferBuilder.a(65, zArr2[2]);
                }
                if (zArr[6]) {
                    flatBufferBuilder.a(66, zArr2[3]);
                }
                if (zArr[7]) {
                    flatBufferBuilder.a(67, zArr2[4]);
                }
                flatBufferBuilder.b(68, iArr[68]);
                flatBufferBuilder.b(69, iArr[69]);
                flatBufferBuilder.b(70, iArr[70]);
                flatBufferBuilder.b(71, iArr[71]);
                flatBufferBuilder.b(72, iArr[72]);
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
                flatBufferBuilder.b(86, iArr[86]);
                flatBufferBuilder.b(87, iArr[87]);
                flatBufferBuilder.b(88, iArr[88]);
                if (zArr[8]) {
                    flatBufferBuilder.a(89, zArr2[5]);
                }
                if (zArr[9]) {
                    flatBufferBuilder.a(90, zArr2[6]);
                }
                if (zArr[10]) {
                    flatBufferBuilder.a(91, zArr2[7]);
                }
                if (zArr[11]) {
                    flatBufferBuilder.a(92, zArr2[8]);
                }
                if (zArr[12]) {
                    flatBufferBuilder.a(93, zArr2[9]);
                }
                if (zArr[13]) {
                    flatBufferBuilder.a(94, zArr2[10]);
                }
                flatBufferBuilder.b(95, iArr[95]);
                flatBufferBuilder.b(96, iArr[96]);
                flatBufferBuilder.b(97, iArr[97]);
                flatBufferBuilder.b(98, iArr[98]);
                flatBufferBuilder.b(99, iArr[99]);
                flatBufferBuilder.b(100, iArr[100]);
                if (zArr[14]) {
                    flatBufferBuilder.a(101, dArr[1], 0.0d);
                }
                flatBufferBuilder.b(102, iArr[102]);
                flatBufferBuilder.b(103, iArr[103]);
                flatBufferBuilder.b(104, iArr[104]);
                flatBufferBuilder.b(105, iArr[105]);
                flatBufferBuilder.b(106, iArr[106]);
                flatBufferBuilder.b(107, iArr[107]);
                flatBufferBuilder.b(108, iArr[108]);
                flatBufferBuilder.b(109, iArr[109]);
                flatBufferBuilder.b(110, iArr[110]);
                flatBufferBuilder.b(111, iArr[111]);
                flatBufferBuilder.b(112, iArr[112]);
                flatBufferBuilder.b(113, iArr[113]);
                flatBufferBuilder.b(114, iArr[114]);
                flatBufferBuilder.b(115, iArr[115]);
                if (zArr[15]) {
                    flatBufferBuilder.a(116, iArr2[2], 0);
                }
                flatBufferBuilder.b(117, iArr[117]);
                if (zArr[16]) {
                    flatBufferBuilder.a(118, iArr2[3], 0);
                }
                flatBufferBuilder.b(119, iArr[119]);
                flatBufferBuilder.b(120, iArr[120]);
                if (zArr[17]) {
                    flatBufferBuilder.a(121, zArr2[11]);
                }
                flatBufferBuilder.b(122, iArr[122]);
                flatBufferBuilder.b(123, iArr[123]);
                flatBufferBuilder.b(124, iArr[124]);
                if (zArr[18]) {
                    flatBufferBuilder.a(125, dArr[2], 0.0d);
                }
                flatBufferBuilder.b(126, iArr[126]);
                flatBufferBuilder.b(127, iArr[127]);
                flatBufferBuilder.b(128, iArr[128]);
                flatBufferBuilder.b(129, iArr[129]);
                flatBufferBuilder.b(130, iArr[130]);
                flatBufferBuilder.b(131, iArr[131]);
                flatBufferBuilder.b(132, iArr[132]);
                flatBufferBuilder.b(133, iArr[133]);
                flatBufferBuilder.b(134, iArr[134]);
                if (zArr[19]) {
                    flatBufferBuilder.a(135, dArr[3], 0.0d);
                }
                flatBufferBuilder.b(136, iArr[136]);
                flatBufferBuilder.b(137, iArr[137]);
                flatBufferBuilder.b(138, iArr[138]);
                flatBufferBuilder.b(139, iArr[139]);
                flatBufferBuilder.b(140, iArr[140]);
                flatBufferBuilder.b(141, iArr[141]);
                flatBufferBuilder.b(142, iArr[142]);
                flatBufferBuilder.b(143, iArr[143]);
                if (zArr[20]) {
                    flatBufferBuilder.a(144, dArr[4], 0.0d);
                }
                flatBufferBuilder.b(145, iArr[145]);
                flatBufferBuilder.b(146, iArr[146]);
                flatBufferBuilder.b(147, iArr[147]);
                flatBufferBuilder.b(148, iArr[148]);
                flatBufferBuilder.b(149, iArr[149]);
                flatBufferBuilder.b(150, iArr[150]);
                flatBufferBuilder.b(151, iArr[151]);
                if (zArr[21]) {
                    flatBufferBuilder.a(152, dArr[5], 0.0d);
                }
                flatBufferBuilder.b(153, iArr[153]);
                if (zArr[22]) {
                    flatBufferBuilder.a(154, dArr[6], 0.0d);
                }
                if (zArr[23]) {
                    flatBufferBuilder.a(155, dArr[7], 0.0d);
                }
                flatBufferBuilder.b(156, iArr[156]);
                flatBufferBuilder.b(157, iArr[157]);
                flatBufferBuilder.b(158, iArr[158]);
                flatBufferBuilder.b(159, iArr[159]);
                flatBufferBuilder.b(160, iArr[160]);
                flatBufferBuilder.b(161, iArr[161]);
                flatBufferBuilder.b(162, iArr[162]);
                if (zArr[24]) {
                    flatBufferBuilder.a(163, dArr[8], 0.0d);
                }
                flatBufferBuilder.b(164, iArr[164]);
                flatBufferBuilder.b(165, iArr[165]);
                flatBufferBuilder.b(166, iArr[166]);
                flatBufferBuilder.b(167, iArr[167]);
                flatBufferBuilder.b(168, iArr[168]);
                flatBufferBuilder.b(169, iArr[169]);
                flatBufferBuilder.b(170, iArr[170]);
                flatBufferBuilder.b(171, iArr[171]);
                if (zArr[25]) {
                    flatBufferBuilder.a(172, zArr2[12]);
                }
                flatBufferBuilder.b(173, iArr[173]);
                flatBufferBuilder.b(174, iArr[174]);
                flatBufferBuilder.b(175, iArr[175]);
                flatBufferBuilder.b(176, iArr[176]);
                flatBufferBuilder.b(177, iArr[177]);
                if (zArr[26]) {
                    flatBufferBuilder.a(178, dArr[9], 0.0d);
                }
                flatBufferBuilder.b(179, iArr[179]);
                flatBufferBuilder.b(180, iArr[180]);
                flatBufferBuilder.b(181, iArr[181]);
                flatBufferBuilder.b(182, iArr[182]);
                flatBufferBuilder.b(183, iArr[183]);
                flatBufferBuilder.b(184, iArr[184]);
                flatBufferBuilder.b(185, iArr[185]);
                flatBufferBuilder.b(186, iArr[186]);
                flatBufferBuilder.b(187, iArr[187]);
                flatBufferBuilder.b(188, iArr[188]);
                flatBufferBuilder.b(189, iArr[189]);
                flatBufferBuilder.b(190, iArr[190]);
                flatBufferBuilder.b(191, iArr[191]);
                flatBufferBuilder.b(192, iArr[192]);
                flatBufferBuilder.b(193, iArr[193]);
                if (zArr[27]) {
                    flatBufferBuilder.a(194, jArr[0], 0);
                }
                flatBufferBuilder.b(195, iArr[195]);
                flatBufferBuilder.b(196, iArr[196]);
                if (zArr[28]) {
                    flatBufferBuilder.a(197, iArr2[4], 0);
                }
                flatBufferBuilder.b(198, iArr[198]);
                flatBufferBuilder.b(199, iArr[199]);
                flatBufferBuilder.b(200, iArr[200]);
                flatBufferBuilder.b(201, iArr[201]);
                flatBufferBuilder.b(202, iArr[202]);
                flatBufferBuilder.b(203, iArr[203]);
                flatBufferBuilder.b(204, iArr[204]);
                flatBufferBuilder.b(205, iArr[205]);
                flatBufferBuilder.b(206, iArr[206]);
                flatBufferBuilder.b(207, iArr[207]);
                flatBufferBuilder.b(208, iArr[208]);
                flatBufferBuilder.b(209, iArr[209]);
                if (zArr[29]) {
                    flatBufferBuilder.a(210, iArr2[5], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m18168a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("actions");
                    ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("album");
                    AlbumParser.m18214a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("all_cards_enabled_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("all_cards_enabled_submessage");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 6, 0);
                if (g != 0) {
                    jsonGenerator.a("auto_execute_action_delay");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 7, 0);
                if (g != 0) {
                    jsonGenerator.a("auto_paginate_count");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 8);
                if (g != 0) {
                    jsonGenerator.a("aux_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 9);
                if (g != 0) {
                    jsonGenerator.a("aux_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("auxiliary_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("away_voting_page");
                    AwayVotingPageParser.m15227a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 12) != 0) {
                    jsonGenerator.a("background_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 12));
                }
                g = mutableFlatBuffer.g(i, 13);
                if (g != 0) {
                    jsonGenerator.a("background_image");
                    BackgroundImageParser.m18108a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 14) != 0) {
                    jsonGenerator.a("background_video_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 14));
                }
                g = mutableFlatBuffer.g(i, 15);
                if (g != 0) {
                    jsonGenerator.a("badgable_profiles");
                    BadgableProfilesParser.m15719a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 16);
                if (g != 0) {
                    jsonGenerator.a("badge_icon");
                    BadgeIconParser.m18059a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("bar_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 18) != 0) {
                    jsonGenerator.a("boosted_component_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 18));
                }
                if (mutableFlatBuffer.g(i, 19) != 0) {
                    jsonGenerator.a("border_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 19));
                }
                boolean a = mutableFlatBuffer.a(i, 20);
                if (a) {
                    jsonGenerator.a("bottom_border");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 21);
                if (g != 0) {
                    jsonGenerator.a("breadcrumbs");
                    BreadcrumbsParser.m18110a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 22);
                if (g != 0) {
                    jsonGenerator.a("card_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 23);
                if (g != 0) {
                    jsonGenerator.a("category_name");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 24);
                if (g != 0) {
                    jsonGenerator.a("center_location");
                    DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 25);
                if (g != 0) {
                    jsonGenerator.a("close_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 26);
                if (g != 0) {
                    jsonGenerator.a("comment");
                    CommentParser.m18105a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 27) != 0) {
                    jsonGenerator.a("component_logical_path");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 27));
                }
                if (mutableFlatBuffer.g(i, 28) != 0) {
                    jsonGenerator.a("component_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 28));
                }
                if (mutableFlatBuffer.g(i, 29) != 0) {
                    jsonGenerator.a("component_tracking_data");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 29));
                }
                g = mutableFlatBuffer.g(i, 30);
                if (g != 0) {
                    jsonGenerator.a("context_list");
                    ContextListParser.m18233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                double a2 = mutableFlatBuffer.a(i, 31, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("core_attribute_aspect_ratio_value");
                    jsonGenerator.a(a2);
                }
                if (mutableFlatBuffer.g(i, 32) != 0) {
                    jsonGenerator.a("core_attribute_background_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 32));
                }
                g = mutableFlatBuffer.g(i, 33);
                if (g != 0) {
                    jsonGenerator.a("core_attribute_border");
                    ReactionCoreComponentBorderSpecFieldsParser.m15285a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 34) != 0) {
                    jsonGenerator.a("core_attribute_glyph_alignment");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 34));
                }
                if (mutableFlatBuffer.g(i, 35) != 0) {
                    jsonGenerator.a("core_attribute_image_size");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 35));
                }
                g = mutableFlatBuffer.g(i, 36);
                if (g != 0) {
                    jsonGenerator.a("core_attribute_margin");
                    ReactionCoreComponentMarginSpecFieldsParser.m15287a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 37);
                if (g != 0) {
                    jsonGenerator.a("core_attribute_padding");
                    ReactionCoreComponentPaddingSpecFieldsParser.m15289a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 38);
                if (g != 0) {
                    jsonGenerator.a("core_glyph");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 39);
                if (g != 0) {
                    jsonGenerator.a("core_image");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 40);
                if (g != 0) {
                    jsonGenerator.a("counts");
                    CountsParser.m18161a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 41);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 42);
                if (g != 0) {
                    jsonGenerator.a("customer_data");
                    CustomerDataParser.m18055a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 43);
                if (g != 0) {
                    jsonGenerator.a("date_summary_text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 44);
                if (g != 0) {
                    jsonGenerator.a("date_summary_text_long");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 45) != 0) {
                    jsonGenerator.a("date_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 45));
                }
                g = mutableFlatBuffer.g(i, 46);
                if (g != 0) {
                    jsonGenerator.a("day_time_text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 47);
                if (g != 0) {
                    jsonGenerator.a("decoration_icon");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 48);
                if (g != 0) {
                    jsonGenerator.a("description");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 49);
                if (g != 0) {
                    jsonGenerator.a("detail_items");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 50) != 0) {
                    jsonGenerator.a("display_decision");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 50));
                }
                if (mutableFlatBuffer.g(i, 51) != 0) {
                    jsonGenerator.a("distance_string");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 51));
                }
                g = mutableFlatBuffer.g(i, 52);
                if (g != 0) {
                    jsonGenerator.a("distance_text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 53);
                if (g != 0) {
                    jsonGenerator.a("empty_state_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 54);
                if (g != 0) {
                    jsonGenerator.a("example_frame_image");
                    ExampleFrameImageParser.m18069a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 55);
                if (g != 0) {
                    jsonGenerator.a("explore_feed");
                    VideoTopicFragmentParser.m19022b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 56);
                if (g != 0) {
                    jsonGenerator.a("facepile");
                    FacepileParser.m18223a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 57);
                if (g != 0) {
                    jsonGenerator.a("favicon");
                    FaviconParser.m18021a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 58);
                if (g != 0) {
                    jsonGenerator.a("feed_unit");
                    GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 59);
                if (g != 0) {
                    jsonGenerator.a("first_value");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 60);
                if (g != 0) {
                    jsonGenerator.a("first_value_description");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 61);
                if (g != 0) {
                    jsonGenerator.a("footer");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 62);
                if (g != 0) {
                    jsonGenerator.a("friending_possibilities");
                    FriendingPossibilitiesParser.m15222a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 63) != 0) {
                    jsonGenerator.a("group_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 63));
                }
                a = mutableFlatBuffer.a(i, 64);
                if (a) {
                    jsonGenerator.a("has_bottom_border");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 65);
                if (a) {
                    jsonGenerator.a("has_disabled_units");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 66);
                if (a) {
                    jsonGenerator.a("has_inner_borders");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 67);
                if (a) {
                    jsonGenerator.a("has_top_border");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 68);
                if (g != 0) {
                    jsonGenerator.a("header");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 69);
                if (g != 0) {
                    jsonGenerator.a("header_image100");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 70);
                if (g != 0) {
                    jsonGenerator.a("header_text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 71);
                if (g != 0) {
                    jsonGenerator.a("hero_image");
                    HeroImageParser.m18030a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 72) != 0) {
                    jsonGenerator.a("hero_video_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 72));
                }
                g = mutableFlatBuffer.g(i, 73);
                if (g != 0) {
                    jsonGenerator.a("high_temperature");
                    HighTemperatureParser.m18237a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 74) != 0) {
                    jsonGenerator.a("highlight_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 74));
                }
                g = mutableFlatBuffer.g(i, 75);
                if (g != 0) {
                    jsonGenerator.a("home_voting_page");
                    HomeVotingPageParser.m15229a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 76);
                if (g != 0) {
                    jsonGenerator.a("hour_ranges");
                    DefaultTimeRangeFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 77);
                if (g != 0) {
                    jsonGenerator.a("icon");
                    IconParser.m18114a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 78);
                if (g != 0) {
                    jsonGenerator.a("icon_image");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 79);
                if (g != 0) {
                    jsonGenerator.a("icon_image_after");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 80);
                if (g != 0) {
                    jsonGenerator.a("icon_image_before");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 81);
                if (g != 0) {
                    jsonGenerator.a("image");
                    ImageParser.m18116a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 82) != 0) {
                    jsonGenerator.a("image_background");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 82));
                }
                g = mutableFlatBuffer.g(i, 83);
                if (g != 0) {
                    jsonGenerator.a("image_block_image");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 84);
                if (g != 0) {
                    jsonGenerator.a("image_block_image_48");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 85);
                if (g != 0) {
                    jsonGenerator.a("images");
                    ReactionImageFieldsParser.m14692a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 86);
                if (g != 0) {
                    jsonGenerator.a("images_with_overlay");
                    ImagesWithOverlayParser.m18171a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 87);
                if (g != 0) {
                    jsonGenerator.a("impressum");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 88);
                if (g != 0) {
                    jsonGenerator.a("impressum_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.a(i, 89);
                if (a) {
                    jsonGenerator.a("is_join_request_sent");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 90);
                if (a) {
                    jsonGenerator.a("is_pinned");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 91);
                if (a) {
                    jsonGenerator.a("is_place_tip");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 92);
                if (a) {
                    jsonGenerator.a("is_saved_place");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 93);
                if (a) {
                    jsonGenerator.a("is_self_location");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 94);
                if (a) {
                    jsonGenerator.a("is_verified");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 95);
                if (g != 0) {
                    jsonGenerator.a("label_one");
                    LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 96) != 0) {
                    jsonGenerator.a("label_one_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 96));
                }
                g = mutableFlatBuffer.g(i, 97);
                if (g != 0) {
                    jsonGenerator.a("label_two");
                    LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 98) != 0) {
                    jsonGenerator.a("label_two_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 98));
                }
                if (mutableFlatBuffer.g(i, 99) != 0) {
                    jsonGenerator.a("left_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 99));
                }
                if (mutableFlatBuffer.g(i, 100) != 0) {
                    jsonGenerator.a("left_label");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 100));
                }
                a2 = mutableFlatBuffer.a(i, 101, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("left_value");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 102);
                if (g != 0) {
                    jsonGenerator.a("location");
                    LocationParser.m18118a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 103);
                if (g != 0) {
                    jsonGenerator.a("location_text");
                    ReactionTextWithEntitiesWithImagesParser.m14726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 104) != 0) {
                    jsonGenerator.a("location_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 104));
                }
                g = mutableFlatBuffer.g(i, 105);
                if (g != 0) {
                    jsonGenerator.a("locations");
                    LocationsParser.m18197a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 106);
                if (g != 0) {
                    jsonGenerator.a("low_temperature");
                    LowTemperatureParser.m18239a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 107);
                if (g != 0) {
                    jsonGenerator.a("main_info");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 108);
                if (g != 0) {
                    jsonGenerator.a("map_bounding_box");
                    ReactionGeoRectangleFieldsParser.m14689a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 109);
                if (g != 0) {
                    jsonGenerator.a("match");
                    MatchParser.m18134a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 110);
                if (g != 0) {
                    jsonGenerator.a("message");
                    MessageParser.m18142a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 111);
                if (g != 0) {
                    jsonGenerator.a("message_after");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 112);
                if (g != 0) {
                    jsonGenerator.a("message_before");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 113) != 0) {
                    jsonGenerator.a("message_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 113));
                }
                g = mutableFlatBuffer.g(i, 114);
                if (g != 0) {
                    jsonGenerator.a("message_snippet");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 115) != 0) {
                    jsonGenerator.a("month_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 115));
                }
                g = mutableFlatBuffer.a(i, 116, 0);
                if (g != 0) {
                    jsonGenerator.a("notifications_default_count");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 117);
                if (g != 0) {
                    jsonGenerator.a("notifications_empty_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 118, 0);
                if (g != 0) {
                    jsonGenerator.a("notifications_inline_expansion_count");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 119);
                if (g != 0) {
                    jsonGenerator.a("notifications_inline_expansion_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 120);
                if (g != 0) {
                    jsonGenerator.a("notifications_view_all_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                a = mutableFlatBuffer.a(i, 121);
                if (a) {
                    jsonGenerator.a("only_display_status");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 122);
                if (g != 0) {
                    jsonGenerator.a("open_album_actions");
                    ReactionUnitOpenAlbumActionsFragmentParser.m18192a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 123);
                if (g != 0) {
                    jsonGenerator.a("other_user_name");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 124);
                if (g != 0) {
                    jsonGenerator.a("page");
                    PageParser.m18144a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a2 = mutableFlatBuffer.a(i, 125, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("percent_of_goal_reached");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 126);
                if (g != 0) {
                    jsonGenerator.a("phone_number_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 127);
                if (g != 0) {
                    jsonGenerator.a("phone_text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 128);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    PhotoParser.m15241a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 129);
                if (g != 0) {
                    jsonGenerator.a("photo_attachments");
                    GraphQLStoryAttachmentDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 130);
                if (g != 0) {
                    jsonGenerator.a("photos");
                    SizeAwareMediaParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 131);
                if (g != 0) {
                    jsonGenerator.a("place_category");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 132);
                if (g != 0) {
                    jsonGenerator.a("place_image");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 133);
                if (g != 0) {
                    jsonGenerator.a("place_info_blurb_breadcrumbs");
                    PlaceInfoBlurbBreadcrumbsParser.m18217a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 134);
                if (g != 0) {
                    jsonGenerator.a("place_info_blurb_page");
                    PlaceInfoBlurbFieldsParser.m14683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a2 = mutableFlatBuffer.a(i, 135, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("place_info_blurb_rating");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 136);
                if (g != 0) {
                    jsonGenerator.a("place_metadata_page");
                    PlaceInfoBlurbFieldsParser.m14683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 137) != 0) {
                    jsonGenerator.a("place_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 137));
                }
                g = mutableFlatBuffer.g(i, 138);
                if (g != 0) {
                    jsonGenerator.a("plays");
                    GametimeDataFactFragmentParser.m15183a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 139) != 0) {
                    jsonGenerator.a("price_range");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 139));
                }
                g = mutableFlatBuffer.g(i, 140);
                if (g != 0) {
                    jsonGenerator.a("primary_icon");
                    PrimaryIconParser.m18176a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 141);
                if (g != 0) {
                    jsonGenerator.a("primary_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 142);
                if (g != 0) {
                    jsonGenerator.a("primary_spec");
                    ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 143);
                if (g != 0) {
                    jsonGenerator.a("profile_image");
                    ProfileImageParser.m18026a(mutableFlatBuffer, g, jsonGenerator);
                }
                a2 = mutableFlatBuffer.a(i, 144, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("profile_image_background_height_ratio");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 145);
                if (g != 0) {
                    jsonGenerator.a("profile_photo");
                    ProfilePhotoParser.m18071a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 146);
                if (g != 0) {
                    jsonGenerator.a("profiles");
                    ProfilesParser.m18146a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 147) != 0) {
                    jsonGenerator.a("progress_bar_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 147));
                }
                g = mutableFlatBuffer.g(i, 148);
                if (g != 0) {
                    jsonGenerator.a("progress_segments");
                    ProgressSegmentsParser.m18075a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 149) != 0) {
                    jsonGenerator.a("prompt_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 149));
                }
                if (mutableFlatBuffer.g(i, 150) != 0) {
                    jsonGenerator.a("prune_behavior");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 150));
                }
                g = mutableFlatBuffer.g(i, 151);
                if (g != 0) {
                    jsonGenerator.a("publisher_context");
                    ReactionTextWithEntitiesWithImagesParser.m14726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a2 = mutableFlatBuffer.a(i, 152, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("rating_count");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 153);
                if (g != 0) {
                    jsonGenerator.a("rating_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                a2 = mutableFlatBuffer.a(i, 154, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("rating_scale");
                    jsonGenerator.a(a2);
                }
                a2 = mutableFlatBuffer.a(i, 155, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("rating_value");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 156);
                if (g != 0) {
                    jsonGenerator.a("recommendation_context");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 157);
                if (g != 0) {
                    jsonGenerator.a("response_delay");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 158);
                if (g != 0) {
                    jsonGenerator.a("responsive_badge");
                    LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 159) != 0) {
                    jsonGenerator.a("responsive_badge_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 159));
                }
                g = mutableFlatBuffer.g(i, 160);
                if (g != 0) {
                    jsonGenerator.a("review_count_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 161) != 0) {
                    jsonGenerator.a("right_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 161));
                }
                if (mutableFlatBuffer.g(i, 162) != 0) {
                    jsonGenerator.a("right_label");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 162));
                }
                a2 = mutableFlatBuffer.a(i, 163, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("right_value");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 164);
                if (g != 0) {
                    jsonGenerator.a("second_value");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 165);
                if (g != 0) {
                    jsonGenerator.a("second_value_description");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 166);
                if (g != 0) {
                    jsonGenerator.a("secondary_actions");
                    ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 167);
                if (g != 0) {
                    jsonGenerator.a("secondary_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 168);
                if (g != 0) {
                    jsonGenerator.a("secondary_spec");
                    ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 169);
                if (g != 0) {
                    jsonGenerator.a("see_all_ratings_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 170);
                if (g != 0) {
                    jsonGenerator.a("service");
                    PageServiceItemParser.m11184b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 171);
                if (g != 0) {
                    jsonGenerator.a("services");
                    PageServiceItemParser.m11182a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.a(i, 172);
                if (a) {
                    jsonGenerator.a("should_upsell_location");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 173);
                if (g != 0) {
                    jsonGenerator.a("sports_fact");
                    GametimeDataFactFragmentParser.m15185b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 174);
                if (g != 0) {
                    jsonGenerator.a("spotlight_story_preview");
                    SpotlightStoryPreviewParser.m15210a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 175);
                if (g != 0) {
                    jsonGenerator.a("status_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 176) != 0) {
                    jsonGenerator.a("status_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 176));
                }
                g = mutableFlatBuffer.g(i, 177);
                if (g != 0) {
                    jsonGenerator.a("story");
                    ReactionStoryAttachmentStoryFragmentParser.m14720a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a2 = mutableFlatBuffer.a(i, 178, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("sub_component_width_ratio");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 179);
                if (g != 0) {
                    jsonGenerator.a("sub_components");
                    ReactionUnitComponentFieldsParser.m18154a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 180);
                if (g != 0) {
                    jsonGenerator.a("sub_message");
                    SubMessageParser.m18150a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 181) != 0) {
                    jsonGenerator.a("sub_message_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 181));
                }
                g = mutableFlatBuffer.g(i, 182);
                if (g != 0) {
                    jsonGenerator.a("subheader");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 183);
                if (g != 0) {
                    jsonGenerator.a("submessage");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 184);
                if (g != 0) {
                    jsonGenerator.a("submessage_after");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 185);
                if (g != 0) {
                    jsonGenerator.a("submessage_before");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 186);
                if (g != 0) {
                    jsonGenerator.a("subtitle");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 187);
                if (g != 0) {
                    jsonGenerator.a("temperature");
                    TemperatureParser.m18241a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 188);
                if (g != 0) {
                    jsonGenerator.a("temperature_text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 189);
                if (g != 0) {
                    jsonGenerator.a("tertiary_message");
                    TertiaryMessageParser.m18152a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 190);
                if (g != 0) {
                    jsonGenerator.a("tertiary_spec");
                    ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 191);
                if (g != 0) {
                    jsonGenerator.a("tertiary_title");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 192) != 0) {
                    jsonGenerator.a("text_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 192));
                }
                if (mutableFlatBuffer.g(i, 193) != 0) {
                    jsonGenerator.a("time_bucket");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 193));
                }
                long a3 = mutableFlatBuffer.a(i, 194, 0);
                if (a3 != 0) {
                    jsonGenerator.a("timestamp");
                    jsonGenerator.a(a3);
                }
                if (mutableFlatBuffer.g(i, 195) != 0) {
                    jsonGenerator.a("timezone");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 195));
                }
                g = mutableFlatBuffer.g(i, 196);
                if (g != 0) {
                    jsonGenerator.a("title");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 197, 0);
                if (g != 0) {
                    jsonGenerator.a("total_votes");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 198);
                if (g != 0) {
                    jsonGenerator.a("truncation_string");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 199);
                if (g != 0) {
                    jsonGenerator.a("typed_data");
                    TypedDataParser.m15233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 200) != 0) {
                    jsonGenerator.a("typed_headers");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 200), jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 201);
                if (g != 0) {
                    jsonGenerator.a("venue_name");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 202);
                if (g != 0) {
                    jsonGenerator.a("video");
                    VideoDetailFragmentParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 203);
                if (g != 0) {
                    jsonGenerator.a("video_channel");
                    VideoHomeCreatorYouShouldFollowParser.m19749a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 204);
                if (g != 0) {
                    jsonGenerator.a("weather_icon");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 205);
                if (g != 0) {
                    jsonGenerator.a("weather_tap_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 206);
                if (g != 0) {
                    jsonGenerator.a("website");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 207);
                if (g != 0) {
                    jsonGenerator.a("website_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 208);
                if (g != 0) {
                    jsonGenerator.a("write_review_action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 209) != 0) {
                    jsonGenerator.a("xout_nux_type");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 209));
                }
                g = mutableFlatBuffer.a(i, 210, 0);
                if (g != 0) {
                    jsonGenerator.a("zoom_level");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18169a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("negative_action")) {
                        iArr[0] = ReactionCrisisActionComponentFragmentParser.m18034a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("negative_component")) {
                        iArr[1] = NegativeComponentParser.m18165a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("positive_action")) {
                        iArr[2] = ReactionCrisisActionComponentFragmentParser.m18034a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("positive_component")) {
                        iArr[3] = PositiveComponentParser.m18167a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("selected_state")) {
                        iArr[4] = flatBufferBuilder.a(GraphQLSelectedActionState.fromString(jsonParser.o()));
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

    /* compiled from: fetch_successful */
    public final class ReactionUnitImageWithOverlayComponentFragementParser {

        /* compiled from: fetch_successful */
        public final class ImagesWithOverlayParser {
            public static int m18172b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[5];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("action")) {
                            iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("dominant_color")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("image")) {
                            iArr[2] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("label")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("overlay")) {
                            iArr[4] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
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

            public static int m18170a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m18172b(jsonParser, flatBufferBuilder)));
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

            public static void m18171a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m18173b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m18173b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("dominant_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("image");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("label");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("overlay");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18174a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("images_with_overlay")) {
                        iArr[0] = ImagesWithOverlayParser.m18170a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetch_successful */
    public final class ReactionUnitInfoRowComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class PrimaryIconParser {
            public static int m18175a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("icon_image")) {
                            iArr[0] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("icon_sizing")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLImageSizingStyle.fromString(jsonParser.o()));
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

            public static void m18176a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("icon_image");
                    ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("icon_sizing");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18177a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("primary_icon")) {
                        iArr[1] = PrimaryIconParser.m18175a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subtitle")) {
                        iArr[2] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_title")) {
                        iArr[3] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetch_successful */
    public final class ReactionUnitMessageAndBreadcrumbsComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class BreadcrumbsParser {
            public static int m18178b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("action")) {
                            iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("text")) {
                            iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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

            public static void m18179b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m18180a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("breadcrumbs")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(BreadcrumbsParser.m18178b(jsonParser, flatBufferBuilder)));
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
                    } else if (i.equals("message")) {
                        iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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
    }

    /* compiled from: fetch_successful */
    public final class ReactionUnitOpenAlbumActionsFragmentParser {

        /* compiled from: fetch_successful */
        public final class AlbumParser {

            /* compiled from: fetch_successful */
            public final class AlbumCoverPhotoParser {

                /* compiled from: fetch_successful */
                public final class ImageLowParser {
                    public static int m18181a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m18182a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18183a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("id")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("imageLow")) {
                                iArr[1] = ImageLowParser.m18181a(jsonParser, flatBufferBuilder);
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

                public static void m18184a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("imageLow");
                        ImageLowParser.m18182a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: fetch_successful */
            public final class PhotoItemsParser {
                public static int m18185a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m18186a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18187a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("album_cover_photo")) {
                            iArr[0] = AlbumCoverPhotoParser.m18183a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("photo_items")) {
                            iArr[2] = PhotoItemsParser.m18185a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("title")) {
                            iArr[3] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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

            public static void m18188a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("album_cover_photo");
                    AlbumCoverPhotoParser.m18184a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("photo_items");
                    PhotoItemsParser.m18186a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("title");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetch_successful */
        public final class PageParser {
            public static int m18189a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18190a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m18193b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("album")) {
                        iArr[0] = AlbumParser.m18187a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[1] = PageParser.m18189a(jsonParser, flatBufferBuilder);
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

        public static int m18191a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m18193b(jsonParser, flatBufferBuilder)));
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

        public static void m18192a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m18194b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m18194b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.m18188a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("page");
                PageParser.m18190a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionUnitPageMapComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class LocationsParser {
            public static int m18198b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[2];
                double[] dArr = new double[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("latitude")) {
                            zArr[0] = true;
                            dArr[0] = jsonParser.G();
                        } else if (i.equals("longitude")) {
                            zArr[1] = true;
                            dArr[1] = jsonParser.G();
                        } else if (i.equals("timezone")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, dArr[0], 0.0d);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, dArr[1], 0.0d);
                }
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static int m18195a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m18198b(jsonParser, flatBufferBuilder)));
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

            public static void m18197a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m18196a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }

            public static void m18196a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                double a = mutableFlatBuffer.a(i, 0, 0.0d);
                if (a != 0.0d) {
                    jsonGenerator.a("latitude");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 1, 0.0d);
                if (a != 0.0d) {
                    jsonGenerator.a("longitude");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("timezone");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        public static int m18199a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[6];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_self_location")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("locations")) {
                        iArr[2] = LocationsParser.m18195a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("map_bounding_box")) {
                        iArr[3] = ReactionGeoRectangleFieldsParser.m14688a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_type")) {
                        iArr[4] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                    } else if (i.equals("zoom_level")) {
                        zArr[1] = true;
                        iArr2[0] = jsonParser.E();
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
            if (zArr[1]) {
                flatBufferBuilder.a(5, iArr2[0], 0);
            }
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionUnitPageMapWithNavigationComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class LocationParser {
            public static int m18200a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[2];
                double[] dArr = new double[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("latitude")) {
                            zArr[0] = true;
                            dArr[0] = jsonParser.G();
                        } else if (i.equals("longitude")) {
                            zArr[1] = true;
                            dArr[1] = jsonParser.G();
                        } else if (i.equals("timezone")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, dArr[0], 0.0d);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, dArr[1], 0.0d);
                }
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static void m18201a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                double a = mutableFlatBuffer.a(i, 0, 0.0d);
                if (a != 0.0d) {
                    jsonGenerator.a("latitude");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 1, 0.0d);
                if (a != 0.0d) {
                    jsonGenerator.a("longitude");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("timezone");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetch_successful */
        public final class PageParser {

            /* compiled from: fetch_successful */
            public final class CityParser {
                public static int m18202a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("contextual_name")) {
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

                public static void m18203a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("contextual_name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18204a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("city")) {
                            iArr[0] = CityParser.m18202a(jsonParser, flatBufferBuilder);
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

            public static void m18205a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("city");
                    CityParser.m18203a(mutableFlatBuffer, g, jsonGenerator);
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

        public static int m18206a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[8];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("aux_action")) {
                        iArr[1] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("category_name")) {
                        iArr[2] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location")) {
                        iArr[3] = LocationParser.m18200a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("map_bounding_box")) {
                        iArr[4] = ReactionGeoRectangleFieldsParser.m14688a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[5] = PageParser.m18204a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("venue_name")) {
                        iArr[6] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("zoom_level")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
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
            if (zArr[0]) {
                flatBufferBuilder.a(7, iArr2[0], 0);
            }
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionUnitPagePhotoAlbumComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class AlbumParser {

            /* compiled from: fetch_successful */
            public final class AlbumCoverPhotoParser {

                /* compiled from: fetch_successful */
                public final class ImageLowParser {
                    public static int m18207a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m18208a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m18209a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("id")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("imageLow")) {
                                iArr[1] = ImageLowParser.m18207a(jsonParser, flatBufferBuilder);
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

                public static void m18210a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("imageLow");
                        ImageLowParser.m18208a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: fetch_successful */
            public final class PhotoItemsParser {
                public static int m18211a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m18212a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m18213a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("album_cover_photo")) {
                            iArr[0] = AlbumCoverPhotoParser.m18209a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("photo_items")) {
                            iArr[2] = PhotoItemsParser.m18211a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("title")) {
                            iArr[3] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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

            public static void m18214a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("album_cover_photo");
                    AlbumCoverPhotoParser.m18210a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("photo_items");
                    PhotoItemsParser.m18212a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("title");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18215a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("album")) {
                        iArr[1] = AlbumParser.m18213a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetch_successful */
    public final class ReactionUnitPlaceInfoBlurbWithBreadcrumbsComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class PlaceInfoBlurbBreadcrumbsParser {
            public static int m18218b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("action")) {
                            iArr[0] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("text")) {
                            iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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

            public static int m18216a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m18218b(jsonParser, flatBufferBuilder)));
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

            public static void m18217a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m18219b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m18219b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("text");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m18220a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[7];
            boolean[] zArr = new boolean[2];
            double[] dArr = new double[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("hour_ranges")) {
                        iArr[0] = DefaultTimeRangeFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_category")) {
                        iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_breadcrumbs")) {
                        iArr[2] = PlaceInfoBlurbBreadcrumbsParser.m18216a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_rating")) {
                        zArr[0] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("price_range")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("rating_count")) {
                        zArr[1] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("timezone")) {
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
            if (zArr[0]) {
                flatBufferBuilder.a(3, dArr[0], 0.0d);
            }
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[1]) {
                flatBufferBuilder.a(5, dArr[1], 0.0d);
            }
            flatBufferBuilder.b(6, iArr[6]);
            return flatBufferBuilder.d();
        }

        public static void m18221a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("hour_ranges");
                DefaultTimeRangeFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("place_category");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("place_info_blurb_breadcrumbs");
                PlaceInfoBlurbBreadcrumbsParser.m18217a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            double a = mutableFlatBuffer.a(i, 3, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("place_info_blurb_rating");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("price_range");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            a = mutableFlatBuffer.a(i, 5, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("rating_count");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("timezone");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionUnitPostPivotComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class FacepileParser {
            public static int m18224b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static int m18222a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m18224b(jsonParser, flatBufferBuilder)));
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

            public static void m18223a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m18225b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m18225b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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

        public static MutableFlatBuffer m18226a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("facepile")) {
                        iArr[0] = FacepileParser.m18222a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetch_successful */
    public final class ReactionUnitSubComponentParser {
        public static int m18227a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[216];
            boolean[] zArr = new boolean[30];
            boolean[] zArr2 = new boolean[13];
            int[] iArr2 = new int[6];
            long[] jArr = new long[1];
            double[] dArr = new double[10];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("action")) {
                        iArr[1] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("actions")) {
                        iArr[2] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("album")) {
                        iArr[3] = AlbumParser.m18213a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("all_cards_enabled_message")) {
                        iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("all_cards_enabled_submessage")) {
                        iArr[5] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("auto_execute_action_delay")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("auto_paginate_count")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("aux_action")) {
                        iArr[8] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("aux_message")) {
                        iArr[9] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("auxiliary_action")) {
                        iArr[10] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("away_voting_page")) {
                        iArr[11] = AwayVotingPageParser.m15226a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("background_color")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("background_image")) {
                        iArr[13] = BackgroundImageParser.m18107a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("background_video_uri")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("badgable_profiles")) {
                        iArr[15] = BadgableProfilesParser.m15718a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("badge_icon")) {
                        iArr[16] = BadgeIconParser.m18058a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("bar_message")) {
                        iArr[17] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("boosted_component_status")) {
                        iArr[18] = flatBufferBuilder.a(GraphQLBoostedComponentStatus.fromString(jsonParser.o()));
                    } else if (i.equals("border_color")) {
                        iArr[19] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("bottom_border")) {
                        zArr[2] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("breadcrumbs")) {
                        iArr[21] = BreadcrumbsParser.m18109a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("card_action")) {
                        iArr[22] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("category_name")) {
                        iArr[23] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("center_location")) {
                        iArr[24] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("close_action")) {
                        iArr[25] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("comment")) {
                        iArr[26] = CommentParser.m18104a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("component_logical_path")) {
                        iArr[27] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("component_style")) {
                        iArr[28] = flatBufferBuilder.a(GraphQLReactionUnitComponentStyle.fromString(jsonParser.o()));
                    } else if (i.equals("component_tracking_data")) {
                        iArr[29] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("context_list")) {
                        iArr[30] = ContextListParser.m18231a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_attribute_aspect_ratio_value")) {
                        zArr[3] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("core_attribute_background_color")) {
                        iArr[32] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("core_attribute_border")) {
                        iArr[33] = ReactionCoreComponentBorderSpecFieldsParser.m15284a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_attribute_glyph_alignment")) {
                        iArr[34] = flatBufferBuilder.a(GraphQLReactionCoreButtonGlyphAlignment.fromString(jsonParser.o()));
                    } else if (i.equals("core_attribute_image_size")) {
                        iArr[35] = flatBufferBuilder.a(GraphQLReactionCoreImageTextImageSize.fromString(jsonParser.o()));
                    } else if (i.equals("core_attribute_margin")) {
                        iArr[36] = ReactionCoreComponentMarginSpecFieldsParser.m15286a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_attribute_padding")) {
                        iArr[37] = ReactionCoreComponentPaddingSpecFieldsParser.m15288a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_glyph")) {
                        iArr[38] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("core_image")) {
                        iArr[39] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("counts")) {
                        iArr[40] = CountsParser.m18160a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("cover_photo")) {
                        iArr[41] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("customer_data")) {
                        iArr[42] = CustomerDataParser.m18054a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("date_summary_text")) {
                        iArr[43] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("date_summary_text_long")) {
                        iArr[44] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("date_text")) {
                        iArr[45] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("day_time_text")) {
                        iArr[46] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("decoration_icon")) {
                        iArr[47] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("description")) {
                        iArr[48] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("detail_items")) {
                        iArr[49] = DefaultTextWithEntitiesFieldsParser.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("display_decision")) {
                        iArr[50] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                    } else if (i.equals("distance_string")) {
                        iArr[51] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("distance_text")) {
                        iArr[52] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("empty_state_action")) {
                        iArr[53] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("example_frame_image")) {
                        iArr[54] = ExampleFrameImageParser.m18068a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("explore_feed")) {
                        iArr[55] = VideoTopicFragmentParser.m19021a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("facepile")) {
                        iArr[56] = FacepileParser.m18222a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("favicon")) {
                        iArr[57] = FaviconParser.m18020a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feed_unit")) {
                        iArr[58] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("first_value")) {
                        iArr[59] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("first_value_description")) {
                        iArr[60] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("footer")) {
                        iArr[61] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("friending_possibilities")) {
                        iArr[62] = FriendingPossibilitiesParser.m15221a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("group_id")) {
                        iArr[63] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("has_bottom_border")) {
                        zArr[4] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("has_disabled_units")) {
                        zArr[5] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("has_inner_borders")) {
                        zArr[6] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("has_top_border")) {
                        zArr[7] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("header")) {
                        iArr[68] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_image100")) {
                        iArr[69] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_text")) {
                        iArr[70] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hero_image")) {
                        iArr[71] = HeroImageParser.m18029a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hero_video_uri")) {
                        iArr[72] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("high_temperature")) {
                        iArr[73] = HighTemperatureParser.m18236a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("highlight_color")) {
                        iArr[74] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("home_voting_page")) {
                        iArr[75] = HomeVotingPageParser.m15228a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("hour_ranges")) {
                        iArr[76] = DefaultTimeRangeFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon")) {
                        iArr[77] = IconParser.m18113a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image")) {
                        iArr[78] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image_after")) {
                        iArr[79] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon_image_before")) {
                        iArr[80] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image")) {
                        iArr[81] = ImageParser.m18115a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image_background")) {
                        iArr[82] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image_block_image")) {
                        iArr[83] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image_block_image_48")) {
                        iArr[84] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("images")) {
                        iArr[85] = ReactionImageFieldsParser.m14693b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("images_with_overlay")) {
                        iArr[86] = ImagesWithOverlayParser.m18170a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("impressum")) {
                        iArr[87] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("impressum_action")) {
                        iArr[88] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_join_request_sent")) {
                        zArr[8] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("is_pinned")) {
                        zArr[9] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("is_place_tip")) {
                        zArr[10] = true;
                        zArr2[7] = jsonParser.H();
                    } else if (i.equals("is_saved_place")) {
                        zArr[11] = true;
                        zArr2[8] = jsonParser.H();
                    } else if (i.equals("is_self_location")) {
                        zArr[12] = true;
                        zArr2[9] = jsonParser.H();
                    } else if (i.equals("is_verified")) {
                        zArr[13] = true;
                        zArr2[10] = jsonParser.H();
                    } else if (i.equals("label_one")) {
                        iArr[95] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("label_one_color")) {
                        iArr[96] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("label_two")) {
                        iArr[97] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("label_two_color")) {
                        iArr[98] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_color")) {
                        iArr[99] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_label")) {
                        iArr[100] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_value")) {
                        zArr[14] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("location")) {
                        iArr[102] = LocationParser.m18117a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location_text")) {
                        iArr[103] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location_type")) {
                        iArr[104] = flatBufferBuilder.a(GraphQLAcornLocationType.fromString(jsonParser.o()));
                    } else if (i.equals("locations")) {
                        iArr[105] = LocationsParser.m18195a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("low_temperature")) {
                        iArr[106] = LowTemperatureParser.m18238a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("main_info")) {
                        iArr[107] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("map_bounding_box")) {
                        iArr[108] = ReactionGeoRectangleFieldsParser.m14688a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("match")) {
                        iArr[109] = MatchParser.m18133a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[110] = MessageParser.m18141a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_after")) {
                        iArr[111] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_before")) {
                        iArr[112] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message_color")) {
                        iArr[113] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("message_snippet")) {
                        iArr[114] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("month_text")) {
                        iArr[115] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("negative_action")) {
                        iArr[116] = ReactionCrisisActionComponentFragmentParser.m18034a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("negative_component")) {
                        iArr[117] = NegativeComponentParser.m18165a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("notifications_default_count")) {
                        zArr[15] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("notifications_empty_message")) {
                        iArr[119] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("notifications_inline_expansion_count")) {
                        zArr[16] = true;
                        iArr2[3] = jsonParser.E();
                    } else if (i.equals("notifications_inline_expansion_message")) {
                        iArr[121] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("notifications_view_all_message")) {
                        iArr[122] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("only_display_status")) {
                        zArr[17] = true;
                        zArr2[11] = jsonParser.H();
                    } else if (i.equals("open_album_actions")) {
                        iArr[124] = ReactionUnitOpenAlbumActionsFragmentParser.m18191a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("other_user_name")) {
                        iArr[125] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[126] = PageParser.m18143a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("percent_of_goal_reached")) {
                        zArr[18] = true;
                        dArr[2] = jsonParser.G();
                    } else if (i.equals("phone_number_action")) {
                        iArr[128] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("phone_text")) {
                        iArr[129] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photo")) {
                        iArr[130] = PhotoParser.m15240a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photo_attachments")) {
                        iArr[131] = GraphQLStoryAttachmentDeserializer.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photos")) {
                        iArr[132] = SizeAwareMediaParser.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_category")) {
                        iArr[133] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_image")) {
                        iArr[134] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_breadcrumbs")) {
                        iArr[135] = PlaceInfoBlurbBreadcrumbsParser.m18216a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_page")) {
                        iArr[136] = PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_info_blurb_rating")) {
                        zArr[19] = true;
                        dArr[3] = jsonParser.G();
                    } else if (i.equals("place_metadata_page")) {
                        iArr[138] = PlaceInfoBlurbFieldsParser.m14682a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_type")) {
                        iArr[139] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                    } else if (i.equals("plays")) {
                        iArr[140] = GametimeDataFactFragmentParser.m15184b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("positive_action")) {
                        iArr[141] = ReactionCrisisActionComponentFragmentParser.m18034a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("positive_component")) {
                        iArr[142] = PositiveComponentParser.m18167a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("price_range")) {
                        iArr[143] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("primary_icon")) {
                        iArr[144] = PrimaryIconParser.m18175a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("primary_message")) {
                        iArr[145] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("primary_spec")) {
                        iArr[146] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_image")) {
                        iArr[147] = ProfileImageParser.m18025a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_image_background_height_ratio")) {
                        zArr[20] = true;
                        dArr[4] = jsonParser.G();
                    } else if (i.equals("profile_photo")) {
                        iArr[149] = ProfilePhotoParser.m18070a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profiles")) {
                        iArr[150] = ProfilesParser.m18145a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("progress_bar_color")) {
                        iArr[151] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("progress_segments")) {
                        iArr[152] = ProgressSegmentsParser.m18073a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("prompt_text")) {
                        iArr[153] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("prune_behavior")) {
                        iArr[154] = flatBufferBuilder.a(GraphQLVideoChannelFeedUnitPruneBehavior.fromString(jsonParser.o()));
                    } else if (i.equals("publisher_context")) {
                        iArr[155] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("rating_count")) {
                        zArr[21] = true;
                        dArr[5] = jsonParser.G();
                    } else if (i.equals("rating_message")) {
                        iArr[157] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("rating_scale")) {
                        zArr[22] = true;
                        dArr[6] = jsonParser.G();
                    } else if (i.equals("rating_value")) {
                        zArr[23] = true;
                        dArr[7] = jsonParser.G();
                    } else if (i.equals("recommendation_context")) {
                        iArr[160] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("response_delay")) {
                        iArr[161] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("responsive_badge")) {
                        iArr[162] = LinkableTextWithEntitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("responsive_badge_color")) {
                        iArr[163] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("review_count_message")) {
                        iArr[164] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("right_color")) {
                        iArr[165] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("right_label")) {
                        iArr[166] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("right_value")) {
                        zArr[24] = true;
                        dArr[8] = jsonParser.G();
                    } else if (i.equals("second_value")) {
                        iArr[168] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("second_value_description")) {
                        iArr[169] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secondary_actions")) {
                        iArr[170] = ReactionStoryAttachmentActionFragmentParser.m16603b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secondary_message")) {
                        iArr[171] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("secondary_spec")) {
                        iArr[172] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("see_all_ratings_action")) {
                        iArr[173] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("selected_state")) {
                        iArr[174] = flatBufferBuilder.a(GraphQLSelectedActionState.fromString(jsonParser.o()));
                    } else if (i.equals("service")) {
                        iArr[175] = PageServiceItemParser.m11181a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("services")) {
                        iArr[176] = PageServiceItemParser.m11183b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("should_upsell_location")) {
                        zArr[25] = true;
                        zArr2[12] = jsonParser.H();
                    } else if (i.equals("sports_fact")) {
                        iArr[178] = GametimeDataFactFragmentParser.m15182a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("spotlight_story_preview")) {
                        iArr[179] = SpotlightStoryPreviewParser.m15209a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("status_message")) {
                        iArr[180] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("status_text")) {
                        iArr[181] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("story")) {
                        iArr[182] = ReactionStoryAttachmentStoryFragmentParser.m14719a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_component_width_ratio")) {
                        zArr[26] = true;
                        dArr[9] = jsonParser.G();
                    } else if (i.equals("sub_components")) {
                        iArr[184] = ReactionUnitComponentFieldsParser.m18153a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_message")) {
                        iArr[185] = SubMessageParser.m18149a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sub_message_color")) {
                        iArr[186] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("subheader")) {
                        iArr[187] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submessage")) {
                        iArr[188] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submessage_after")) {
                        iArr[189] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("submessage_before")) {
                        iArr[190] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subtitle")) {
                        iArr[191] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temperature")) {
                        iArr[192] = TemperatureParser.m18240a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temperature_text")) {
                        iArr[193] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_message")) {
                        iArr[194] = TertiaryMessageParser.m18151a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_spec")) {
                        iArr[195] = ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tertiary_title")) {
                        iArr[196] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("text_color")) {
                        iArr[197] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("time_bucket")) {
                        iArr[198] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("timestamp")) {
                        zArr[27] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("timezone")) {
                        iArr[200] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("title")) {
                        iArr[201] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("total_votes")) {
                        zArr[28] = true;
                        iArr2[4] = jsonParser.E();
                    } else if (i.equals("truncation_string")) {
                        iArr[203] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("typed_data")) {
                        iArr[204] = TypedDataParser.m15231a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("typed_headers")) {
                        iArr[205] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("venue_name")) {
                        iArr[206] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video")) {
                        iArr[207] = VideoDetailFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video_channel")) {
                        iArr[208] = VideoHomeCreatorYouShouldFollowParser.m19748a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("weather_icon")) {
                        iArr[209] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("weather_tap_action")) {
                        iArr[210] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("website")) {
                        iArr[211] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("website_action")) {
                        iArr[212] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("write_review_action")) {
                        iArr[213] = ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("xout_nux_type")) {
                        iArr[214] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("zoom_level")) {
                        zArr[29] = true;
                        iArr2[5] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(216);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            if (zArr[0]) {
                flatBufferBuilder.a(6, iArr2[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(7, iArr2[1], 0);
            }
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
            if (zArr[2]) {
                flatBufferBuilder.a(20, zArr2[0]);
            }
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
            if (zArr[3]) {
                flatBufferBuilder.a(31, dArr[0], 0.0d);
            }
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
            flatBufferBuilder.b(61, iArr[61]);
            flatBufferBuilder.b(62, iArr[62]);
            flatBufferBuilder.b(63, iArr[63]);
            if (zArr[4]) {
                flatBufferBuilder.a(64, zArr2[1]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(65, zArr2[2]);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(66, zArr2[3]);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(67, zArr2[4]);
            }
            flatBufferBuilder.b(68, iArr[68]);
            flatBufferBuilder.b(69, iArr[69]);
            flatBufferBuilder.b(70, iArr[70]);
            flatBufferBuilder.b(71, iArr[71]);
            flatBufferBuilder.b(72, iArr[72]);
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
            flatBufferBuilder.b(86, iArr[86]);
            flatBufferBuilder.b(87, iArr[87]);
            flatBufferBuilder.b(88, iArr[88]);
            if (zArr[8]) {
                flatBufferBuilder.a(89, zArr2[5]);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(90, zArr2[6]);
            }
            if (zArr[10]) {
                flatBufferBuilder.a(91, zArr2[7]);
            }
            if (zArr[11]) {
                flatBufferBuilder.a(92, zArr2[8]);
            }
            if (zArr[12]) {
                flatBufferBuilder.a(93, zArr2[9]);
            }
            if (zArr[13]) {
                flatBufferBuilder.a(94, zArr2[10]);
            }
            flatBufferBuilder.b(95, iArr[95]);
            flatBufferBuilder.b(96, iArr[96]);
            flatBufferBuilder.b(97, iArr[97]);
            flatBufferBuilder.b(98, iArr[98]);
            flatBufferBuilder.b(99, iArr[99]);
            flatBufferBuilder.b(100, iArr[100]);
            if (zArr[14]) {
                flatBufferBuilder.a(101, dArr[1], 0.0d);
            }
            flatBufferBuilder.b(102, iArr[102]);
            flatBufferBuilder.b(103, iArr[103]);
            flatBufferBuilder.b(104, iArr[104]);
            flatBufferBuilder.b(105, iArr[105]);
            flatBufferBuilder.b(106, iArr[106]);
            flatBufferBuilder.b(107, iArr[107]);
            flatBufferBuilder.b(108, iArr[108]);
            flatBufferBuilder.b(109, iArr[109]);
            flatBufferBuilder.b(110, iArr[110]);
            flatBufferBuilder.b(111, iArr[111]);
            flatBufferBuilder.b(112, iArr[112]);
            flatBufferBuilder.b(113, iArr[113]);
            flatBufferBuilder.b(114, iArr[114]);
            flatBufferBuilder.b(115, iArr[115]);
            flatBufferBuilder.b(116, iArr[116]);
            flatBufferBuilder.b(117, iArr[117]);
            if (zArr[15]) {
                flatBufferBuilder.a(118, iArr2[2], 0);
            }
            flatBufferBuilder.b(119, iArr[119]);
            if (zArr[16]) {
                flatBufferBuilder.a(120, iArr2[3], 0);
            }
            flatBufferBuilder.b(121, iArr[121]);
            flatBufferBuilder.b(122, iArr[122]);
            if (zArr[17]) {
                flatBufferBuilder.a(123, zArr2[11]);
            }
            flatBufferBuilder.b(124, iArr[124]);
            flatBufferBuilder.b(125, iArr[125]);
            flatBufferBuilder.b(126, iArr[126]);
            if (zArr[18]) {
                flatBufferBuilder.a(127, dArr[2], 0.0d);
            }
            flatBufferBuilder.b(128, iArr[128]);
            flatBufferBuilder.b(129, iArr[129]);
            flatBufferBuilder.b(130, iArr[130]);
            flatBufferBuilder.b(131, iArr[131]);
            flatBufferBuilder.b(132, iArr[132]);
            flatBufferBuilder.b(133, iArr[133]);
            flatBufferBuilder.b(134, iArr[134]);
            flatBufferBuilder.b(135, iArr[135]);
            flatBufferBuilder.b(136, iArr[136]);
            if (zArr[19]) {
                flatBufferBuilder.a(137, dArr[3], 0.0d);
            }
            flatBufferBuilder.b(138, iArr[138]);
            flatBufferBuilder.b(139, iArr[139]);
            flatBufferBuilder.b(140, iArr[140]);
            flatBufferBuilder.b(141, iArr[141]);
            flatBufferBuilder.b(142, iArr[142]);
            flatBufferBuilder.b(143, iArr[143]);
            flatBufferBuilder.b(144, iArr[144]);
            flatBufferBuilder.b(145, iArr[145]);
            flatBufferBuilder.b(146, iArr[146]);
            flatBufferBuilder.b(147, iArr[147]);
            if (zArr[20]) {
                flatBufferBuilder.a(148, dArr[4], 0.0d);
            }
            flatBufferBuilder.b(149, iArr[149]);
            flatBufferBuilder.b(150, iArr[150]);
            flatBufferBuilder.b(151, iArr[151]);
            flatBufferBuilder.b(152, iArr[152]);
            flatBufferBuilder.b(153, iArr[153]);
            flatBufferBuilder.b(154, iArr[154]);
            flatBufferBuilder.b(155, iArr[155]);
            if (zArr[21]) {
                flatBufferBuilder.a(156, dArr[5], 0.0d);
            }
            flatBufferBuilder.b(157, iArr[157]);
            if (zArr[22]) {
                flatBufferBuilder.a(158, dArr[6], 0.0d);
            }
            if (zArr[23]) {
                flatBufferBuilder.a(159, dArr[7], 0.0d);
            }
            flatBufferBuilder.b(160, iArr[160]);
            flatBufferBuilder.b(161, iArr[161]);
            flatBufferBuilder.b(162, iArr[162]);
            flatBufferBuilder.b(163, iArr[163]);
            flatBufferBuilder.b(164, iArr[164]);
            flatBufferBuilder.b(165, iArr[165]);
            flatBufferBuilder.b(166, iArr[166]);
            if (zArr[24]) {
                flatBufferBuilder.a(167, dArr[8], 0.0d);
            }
            flatBufferBuilder.b(168, iArr[168]);
            flatBufferBuilder.b(169, iArr[169]);
            flatBufferBuilder.b(170, iArr[170]);
            flatBufferBuilder.b(171, iArr[171]);
            flatBufferBuilder.b(172, iArr[172]);
            flatBufferBuilder.b(173, iArr[173]);
            flatBufferBuilder.b(174, iArr[174]);
            flatBufferBuilder.b(175, iArr[175]);
            flatBufferBuilder.b(176, iArr[176]);
            if (zArr[25]) {
                flatBufferBuilder.a(177, zArr2[12]);
            }
            flatBufferBuilder.b(178, iArr[178]);
            flatBufferBuilder.b(179, iArr[179]);
            flatBufferBuilder.b(180, iArr[180]);
            flatBufferBuilder.b(181, iArr[181]);
            flatBufferBuilder.b(182, iArr[182]);
            if (zArr[26]) {
                flatBufferBuilder.a(183, dArr[9], 0.0d);
            }
            flatBufferBuilder.b(184, iArr[184]);
            flatBufferBuilder.b(185, iArr[185]);
            flatBufferBuilder.b(186, iArr[186]);
            flatBufferBuilder.b(187, iArr[187]);
            flatBufferBuilder.b(188, iArr[188]);
            flatBufferBuilder.b(189, iArr[189]);
            flatBufferBuilder.b(190, iArr[190]);
            flatBufferBuilder.b(191, iArr[191]);
            flatBufferBuilder.b(192, iArr[192]);
            flatBufferBuilder.b(193, iArr[193]);
            flatBufferBuilder.b(194, iArr[194]);
            flatBufferBuilder.b(195, iArr[195]);
            flatBufferBuilder.b(196, iArr[196]);
            flatBufferBuilder.b(197, iArr[197]);
            flatBufferBuilder.b(198, iArr[198]);
            if (zArr[27]) {
                flatBufferBuilder.a(199, jArr[0], 0);
            }
            flatBufferBuilder.b(200, iArr[200]);
            flatBufferBuilder.b(201, iArr[201]);
            if (zArr[28]) {
                flatBufferBuilder.a(202, iArr2[4], 0);
            }
            flatBufferBuilder.b(203, iArr[203]);
            flatBufferBuilder.b(204, iArr[204]);
            flatBufferBuilder.b(205, iArr[205]);
            flatBufferBuilder.b(206, iArr[206]);
            flatBufferBuilder.b(207, iArr[207]);
            flatBufferBuilder.b(208, iArr[208]);
            flatBufferBuilder.b(209, iArr[209]);
            flatBufferBuilder.b(210, iArr[210]);
            flatBufferBuilder.b(211, iArr[211]);
            flatBufferBuilder.b(212, iArr[212]);
            flatBufferBuilder.b(213, iArr[213]);
            flatBufferBuilder.b(214, iArr[214]);
            if (zArr[29]) {
                flatBufferBuilder.a(215, iArr2[5], 0);
            }
            return flatBufferBuilder.d();
        }

        public static int m18229b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m18227a(jsonParser, flatBufferBuilder)));
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

        public static void m18228a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m18230b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m18230b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("actions");
                ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.m18214a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("all_cards_enabled_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("all_cards_enabled_submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 6, 0);
            if (g != 0) {
                jsonGenerator.a("auto_execute_action_delay");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 7, 0);
            if (g != 0) {
                jsonGenerator.a("auto_paginate_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("aux_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("aux_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("auxiliary_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("away_voting_page");
                AwayVotingPageParser.m15227a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("background_image");
                BackgroundImageParser.m18108a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("background_video_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("badgable_profiles");
                BadgableProfilesParser.m15719a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("badge_icon");
                BadgeIconParser.m18059a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 17);
            if (g != 0) {
                jsonGenerator.a("bar_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("boosted_component_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 18));
            }
            if (mutableFlatBuffer.g(i, 19) != 0) {
                jsonGenerator.a("border_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 19));
            }
            boolean a = mutableFlatBuffer.a(i, 20);
            if (a) {
                jsonGenerator.a("bottom_border");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 21);
            if (g != 0) {
                jsonGenerator.a("breadcrumbs");
                BreadcrumbsParser.m18110a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 22);
            if (g != 0) {
                jsonGenerator.a("card_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 23);
            if (g != 0) {
                jsonGenerator.a("category_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 24);
            if (g != 0) {
                jsonGenerator.a("center_location");
                DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("close_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 26);
            if (g != 0) {
                jsonGenerator.a("comment");
                CommentParser.m18105a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 27) != 0) {
                jsonGenerator.a("component_logical_path");
                jsonGenerator.b(mutableFlatBuffer.c(i, 27));
            }
            if (mutableFlatBuffer.g(i, 28) != 0) {
                jsonGenerator.a("component_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 28));
            }
            if (mutableFlatBuffer.g(i, 29) != 0) {
                jsonGenerator.a("component_tracking_data");
                jsonGenerator.b(mutableFlatBuffer.c(i, 29));
            }
            g = mutableFlatBuffer.g(i, 30);
            if (g != 0) {
                jsonGenerator.a("context_list");
                ContextListParser.m18233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            double a2 = mutableFlatBuffer.a(i, 31, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("core_attribute_aspect_ratio_value");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 32) != 0) {
                jsonGenerator.a("core_attribute_background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 32));
            }
            g = mutableFlatBuffer.g(i, 33);
            if (g != 0) {
                jsonGenerator.a("core_attribute_border");
                ReactionCoreComponentBorderSpecFieldsParser.m15285a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 34) != 0) {
                jsonGenerator.a("core_attribute_glyph_alignment");
                jsonGenerator.b(mutableFlatBuffer.b(i, 34));
            }
            if (mutableFlatBuffer.g(i, 35) != 0) {
                jsonGenerator.a("core_attribute_image_size");
                jsonGenerator.b(mutableFlatBuffer.b(i, 35));
            }
            g = mutableFlatBuffer.g(i, 36);
            if (g != 0) {
                jsonGenerator.a("core_attribute_margin");
                ReactionCoreComponentMarginSpecFieldsParser.m15287a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 37);
            if (g != 0) {
                jsonGenerator.a("core_attribute_padding");
                ReactionCoreComponentPaddingSpecFieldsParser.m15289a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 38);
            if (g != 0) {
                jsonGenerator.a("core_glyph");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 39);
            if (g != 0) {
                jsonGenerator.a("core_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 40);
            if (g != 0) {
                jsonGenerator.a("counts");
                CountsParser.m18161a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 41);
            if (g != 0) {
                jsonGenerator.a("cover_photo");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 42);
            if (g != 0) {
                jsonGenerator.a("customer_data");
                CustomerDataParser.m18055a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 43);
            if (g != 0) {
                jsonGenerator.a("date_summary_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 44);
            if (g != 0) {
                jsonGenerator.a("date_summary_text_long");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 45) != 0) {
                jsonGenerator.a("date_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 45));
            }
            g = mutableFlatBuffer.g(i, 46);
            if (g != 0) {
                jsonGenerator.a("day_time_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 47);
            if (g != 0) {
                jsonGenerator.a("decoration_icon");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 48);
            if (g != 0) {
                jsonGenerator.a("description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 49);
            if (g != 0) {
                jsonGenerator.a("detail_items");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 50) != 0) {
                jsonGenerator.a("display_decision");
                jsonGenerator.b(mutableFlatBuffer.b(i, 50));
            }
            if (mutableFlatBuffer.g(i, 51) != 0) {
                jsonGenerator.a("distance_string");
                jsonGenerator.b(mutableFlatBuffer.c(i, 51));
            }
            g = mutableFlatBuffer.g(i, 52);
            if (g != 0) {
                jsonGenerator.a("distance_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 53);
            if (g != 0) {
                jsonGenerator.a("empty_state_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 54);
            if (g != 0) {
                jsonGenerator.a("example_frame_image");
                ExampleFrameImageParser.m18069a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 55);
            if (g != 0) {
                jsonGenerator.a("explore_feed");
                VideoTopicFragmentParser.m19022b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 56);
            if (g != 0) {
                jsonGenerator.a("facepile");
                FacepileParser.m18223a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 57);
            if (g != 0) {
                jsonGenerator.a("favicon");
                FaviconParser.m18021a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 58);
            if (g != 0) {
                jsonGenerator.a("feed_unit");
                GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 59);
            if (g != 0) {
                jsonGenerator.a("first_value");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 60);
            if (g != 0) {
                jsonGenerator.a("first_value_description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 61);
            if (g != 0) {
                jsonGenerator.a("footer");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 62);
            if (g != 0) {
                jsonGenerator.a("friending_possibilities");
                FriendingPossibilitiesParser.m15222a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 63) != 0) {
                jsonGenerator.a("group_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 63));
            }
            a = mutableFlatBuffer.a(i, 64);
            if (a) {
                jsonGenerator.a("has_bottom_border");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 65);
            if (a) {
                jsonGenerator.a("has_disabled_units");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 66);
            if (a) {
                jsonGenerator.a("has_inner_borders");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 67);
            if (a) {
                jsonGenerator.a("has_top_border");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 68);
            if (g != 0) {
                jsonGenerator.a("header");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 69);
            if (g != 0) {
                jsonGenerator.a("header_image100");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 70);
            if (g != 0) {
                jsonGenerator.a("header_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 71);
            if (g != 0) {
                jsonGenerator.a("hero_image");
                HeroImageParser.m18030a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 72) != 0) {
                jsonGenerator.a("hero_video_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 72));
            }
            g = mutableFlatBuffer.g(i, 73);
            if (g != 0) {
                jsonGenerator.a("high_temperature");
                HighTemperatureParser.m18237a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 74) != 0) {
                jsonGenerator.a("highlight_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 74));
            }
            g = mutableFlatBuffer.g(i, 75);
            if (g != 0) {
                jsonGenerator.a("home_voting_page");
                HomeVotingPageParser.m15229a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 76);
            if (g != 0) {
                jsonGenerator.a("hour_ranges");
                DefaultTimeRangeFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 77);
            if (g != 0) {
                jsonGenerator.a("icon");
                IconParser.m18114a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 78);
            if (g != 0) {
                jsonGenerator.a("icon_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 79);
            if (g != 0) {
                jsonGenerator.a("icon_image_after");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 80);
            if (g != 0) {
                jsonGenerator.a("icon_image_before");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 81);
            if (g != 0) {
                jsonGenerator.a("image");
                ImageParser.m18116a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 82) != 0) {
                jsonGenerator.a("image_background");
                jsonGenerator.b(mutableFlatBuffer.c(i, 82));
            }
            g = mutableFlatBuffer.g(i, 83);
            if (g != 0) {
                jsonGenerator.a("image_block_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 84);
            if (g != 0) {
                jsonGenerator.a("image_block_image_48");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 85);
            if (g != 0) {
                jsonGenerator.a("images");
                ReactionImageFieldsParser.m14692a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 86);
            if (g != 0) {
                jsonGenerator.a("images_with_overlay");
                ImagesWithOverlayParser.m18171a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 87);
            if (g != 0) {
                jsonGenerator.a("impressum");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 88);
            if (g != 0) {
                jsonGenerator.a("impressum_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 89);
            if (a) {
                jsonGenerator.a("is_join_request_sent");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 90);
            if (a) {
                jsonGenerator.a("is_pinned");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 91);
            if (a) {
                jsonGenerator.a("is_place_tip");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 92);
            if (a) {
                jsonGenerator.a("is_saved_place");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 93);
            if (a) {
                jsonGenerator.a("is_self_location");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 94);
            if (a) {
                jsonGenerator.a("is_verified");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 95);
            if (g != 0) {
                jsonGenerator.a("label_one");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 96) != 0) {
                jsonGenerator.a("label_one_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 96));
            }
            g = mutableFlatBuffer.g(i, 97);
            if (g != 0) {
                jsonGenerator.a("label_two");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 98) != 0) {
                jsonGenerator.a("label_two_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 98));
            }
            if (mutableFlatBuffer.g(i, 99) != 0) {
                jsonGenerator.a("left_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 99));
            }
            if (mutableFlatBuffer.g(i, 100) != 0) {
                jsonGenerator.a("left_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 100));
            }
            a2 = mutableFlatBuffer.a(i, 101, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("left_value");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 102);
            if (g != 0) {
                jsonGenerator.a("location");
                LocationParser.m18118a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 103);
            if (g != 0) {
                jsonGenerator.a("location_text");
                ReactionTextWithEntitiesWithImagesParser.m14726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 104) != 0) {
                jsonGenerator.a("location_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 104));
            }
            g = mutableFlatBuffer.g(i, 105);
            if (g != 0) {
                jsonGenerator.a("locations");
                LocationsParser.m18197a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 106);
            if (g != 0) {
                jsonGenerator.a("low_temperature");
                LowTemperatureParser.m18239a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 107);
            if (g != 0) {
                jsonGenerator.a("main_info");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 108);
            if (g != 0) {
                jsonGenerator.a("map_bounding_box");
                ReactionGeoRectangleFieldsParser.m14689a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 109);
            if (g != 0) {
                jsonGenerator.a("match");
                MatchParser.m18134a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 110);
            if (g != 0) {
                jsonGenerator.a("message");
                MessageParser.m18142a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 111);
            if (g != 0) {
                jsonGenerator.a("message_after");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 112);
            if (g != 0) {
                jsonGenerator.a("message_before");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 113) != 0) {
                jsonGenerator.a("message_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 113));
            }
            g = mutableFlatBuffer.g(i, 114);
            if (g != 0) {
                jsonGenerator.a("message_snippet");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 115) != 0) {
                jsonGenerator.a("month_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 115));
            }
            g = mutableFlatBuffer.g(i, 116);
            if (g != 0) {
                jsonGenerator.a("negative_action");
                ReactionCrisisActionComponentFragmentParser.m18035a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 117);
            if (g != 0) {
                jsonGenerator.a("negative_component");
                NegativeComponentParser.m18166a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.a(i, 118, 0);
            if (g != 0) {
                jsonGenerator.a("notifications_default_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 119);
            if (g != 0) {
                jsonGenerator.a("notifications_empty_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 120, 0);
            if (g != 0) {
                jsonGenerator.a("notifications_inline_expansion_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 121);
            if (g != 0) {
                jsonGenerator.a("notifications_inline_expansion_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 122);
            if (g != 0) {
                jsonGenerator.a("notifications_view_all_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 123);
            if (a) {
                jsonGenerator.a("only_display_status");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 124);
            if (g != 0) {
                jsonGenerator.a("open_album_actions");
                ReactionUnitOpenAlbumActionsFragmentParser.m18192a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 125);
            if (g != 0) {
                jsonGenerator.a("other_user_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 126);
            if (g != 0) {
                jsonGenerator.a("page");
                PageParser.m18144a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 127, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("percent_of_goal_reached");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 128);
            if (g != 0) {
                jsonGenerator.a("phone_number_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 129);
            if (g != 0) {
                jsonGenerator.a("phone_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 130);
            if (g != 0) {
                jsonGenerator.a("photo");
                PhotoParser.m15241a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 131);
            if (g != 0) {
                jsonGenerator.a("photo_attachments");
                GraphQLStoryAttachmentDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 132);
            if (g != 0) {
                jsonGenerator.a("photos");
                SizeAwareMediaParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 133);
            if (g != 0) {
                jsonGenerator.a("place_category");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 134);
            if (g != 0) {
                jsonGenerator.a("place_image");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 135);
            if (g != 0) {
                jsonGenerator.a("place_info_blurb_breadcrumbs");
                PlaceInfoBlurbBreadcrumbsParser.m18217a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 136);
            if (g != 0) {
                jsonGenerator.a("place_info_blurb_page");
                PlaceInfoBlurbFieldsParser.m14683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 137, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("place_info_blurb_rating");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 138);
            if (g != 0) {
                jsonGenerator.a("place_metadata_page");
                PlaceInfoBlurbFieldsParser.m14683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 139) != 0) {
                jsonGenerator.a("place_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 139));
            }
            g = mutableFlatBuffer.g(i, 140);
            if (g != 0) {
                jsonGenerator.a("plays");
                GametimeDataFactFragmentParser.m15183a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 141);
            if (g != 0) {
                jsonGenerator.a("positive_action");
                ReactionCrisisActionComponentFragmentParser.m18035a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 142);
            if (g != 0) {
                jsonGenerator.a("positive_component");
                PositiveComponentParser.m18168a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 143) != 0) {
                jsonGenerator.a("price_range");
                jsonGenerator.b(mutableFlatBuffer.c(i, 143));
            }
            g = mutableFlatBuffer.g(i, 144);
            if (g != 0) {
                jsonGenerator.a("primary_icon");
                PrimaryIconParser.m18176a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 145);
            if (g != 0) {
                jsonGenerator.a("primary_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 146);
            if (g != 0) {
                jsonGenerator.a("primary_spec");
                ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 147);
            if (g != 0) {
                jsonGenerator.a("profile_image");
                ProfileImageParser.m18026a(mutableFlatBuffer, g, jsonGenerator);
            }
            a2 = mutableFlatBuffer.a(i, 148, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("profile_image_background_height_ratio");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 149);
            if (g != 0) {
                jsonGenerator.a("profile_photo");
                ProfilePhotoParser.m18071a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 150);
            if (g != 0) {
                jsonGenerator.a("profiles");
                ProfilesParser.m18146a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 151) != 0) {
                jsonGenerator.a("progress_bar_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 151));
            }
            g = mutableFlatBuffer.g(i, 152);
            if (g != 0) {
                jsonGenerator.a("progress_segments");
                ProgressSegmentsParser.m18075a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 153) != 0) {
                jsonGenerator.a("prompt_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 153));
            }
            if (mutableFlatBuffer.g(i, 154) != 0) {
                jsonGenerator.a("prune_behavior");
                jsonGenerator.b(mutableFlatBuffer.b(i, 154));
            }
            g = mutableFlatBuffer.g(i, 155);
            if (g != 0) {
                jsonGenerator.a("publisher_context");
                ReactionTextWithEntitiesWithImagesParser.m14726a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 156, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("rating_count");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 157);
            if (g != 0) {
                jsonGenerator.a("rating_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a2 = mutableFlatBuffer.a(i, 158, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("rating_scale");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 159, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("rating_value");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 160);
            if (g != 0) {
                jsonGenerator.a("recommendation_context");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 161);
            if (g != 0) {
                jsonGenerator.a("response_delay");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 162);
            if (g != 0) {
                jsonGenerator.a("responsive_badge");
                LinkableTextWithEntitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 163) != 0) {
                jsonGenerator.a("responsive_badge_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 163));
            }
            g = mutableFlatBuffer.g(i, 164);
            if (g != 0) {
                jsonGenerator.a("review_count_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 165) != 0) {
                jsonGenerator.a("right_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 165));
            }
            if (mutableFlatBuffer.g(i, 166) != 0) {
                jsonGenerator.a("right_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 166));
            }
            a2 = mutableFlatBuffer.a(i, 167, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("right_value");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 168);
            if (g != 0) {
                jsonGenerator.a("second_value");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 169);
            if (g != 0) {
                jsonGenerator.a("second_value_description");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 170);
            if (g != 0) {
                jsonGenerator.a("secondary_actions");
                ReactionStoryAttachmentActionFragmentParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 171);
            if (g != 0) {
                jsonGenerator.a("secondary_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 172);
            if (g != 0) {
                jsonGenerator.a("secondary_spec");
                ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 173);
            if (g != 0) {
                jsonGenerator.a("see_all_ratings_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 174) != 0) {
                jsonGenerator.a("selected_state");
                jsonGenerator.b(mutableFlatBuffer.b(i, 174));
            }
            g = mutableFlatBuffer.g(i, 175);
            if (g != 0) {
                jsonGenerator.a("service");
                PageServiceItemParser.m11184b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 176);
            if (g != 0) {
                jsonGenerator.a("services");
                PageServiceItemParser.m11182a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 177);
            if (a) {
                jsonGenerator.a("should_upsell_location");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 178);
            if (g != 0) {
                jsonGenerator.a("sports_fact");
                GametimeDataFactFragmentParser.m15185b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 179);
            if (g != 0) {
                jsonGenerator.a("spotlight_story_preview");
                SpotlightStoryPreviewParser.m15210a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 180);
            if (g != 0) {
                jsonGenerator.a("status_message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 181) != 0) {
                jsonGenerator.a("status_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 181));
            }
            g = mutableFlatBuffer.g(i, 182);
            if (g != 0) {
                jsonGenerator.a("story");
                ReactionStoryAttachmentStoryFragmentParser.m14720a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a2 = mutableFlatBuffer.a(i, 183, 0.0d);
            if (a2 != 0.0d) {
                jsonGenerator.a("sub_component_width_ratio");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 184);
            if (g != 0) {
                jsonGenerator.a("sub_components");
                ReactionUnitComponentFieldsParser.m18154a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 185);
            if (g != 0) {
                jsonGenerator.a("sub_message");
                SubMessageParser.m18150a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 186) != 0) {
                jsonGenerator.a("sub_message_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 186));
            }
            g = mutableFlatBuffer.g(i, 187);
            if (g != 0) {
                jsonGenerator.a("subheader");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 188);
            if (g != 0) {
                jsonGenerator.a("submessage");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 189);
            if (g != 0) {
                jsonGenerator.a("submessage_after");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 190);
            if (g != 0) {
                jsonGenerator.a("submessage_before");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 191);
            if (g != 0) {
                jsonGenerator.a("subtitle");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 192);
            if (g != 0) {
                jsonGenerator.a("temperature");
                TemperatureParser.m18241a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 193);
            if (g != 0) {
                jsonGenerator.a("temperature_text");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 194);
            if (g != 0) {
                jsonGenerator.a("tertiary_message");
                TertiaryMessageParser.m18152a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 195);
            if (g != 0) {
                jsonGenerator.a("tertiary_spec");
                ReactionCoreComponentTextSpecFieldsParser.m15291a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 196);
            if (g != 0) {
                jsonGenerator.a("tertiary_title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 197) != 0) {
                jsonGenerator.a("text_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 197));
            }
            if (mutableFlatBuffer.g(i, 198) != 0) {
                jsonGenerator.a("time_bucket");
                jsonGenerator.b(mutableFlatBuffer.c(i, 198));
            }
            long a3 = mutableFlatBuffer.a(i, 199, 0);
            if (a3 != 0) {
                jsonGenerator.a("timestamp");
                jsonGenerator.a(a3);
            }
            if (mutableFlatBuffer.g(i, 200) != 0) {
                jsonGenerator.a("timezone");
                jsonGenerator.b(mutableFlatBuffer.c(i, 200));
            }
            g = mutableFlatBuffer.g(i, 201);
            if (g != 0) {
                jsonGenerator.a("title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 202, 0);
            if (g != 0) {
                jsonGenerator.a("total_votes");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 203);
            if (g != 0) {
                jsonGenerator.a("truncation_string");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 204);
            if (g != 0) {
                jsonGenerator.a("typed_data");
                TypedDataParser.m15233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 205) != 0) {
                jsonGenerator.a("typed_headers");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 205), jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 206);
            if (g != 0) {
                jsonGenerator.a("venue_name");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 207);
            if (g != 0) {
                jsonGenerator.a("video");
                VideoDetailFragmentParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 208);
            if (g != 0) {
                jsonGenerator.a("video_channel");
                VideoHomeCreatorYouShouldFollowParser.m19749a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 209);
            if (g != 0) {
                jsonGenerator.a("weather_icon");
                ReactionImageFieldsParser.m14691a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 210);
            if (g != 0) {
                jsonGenerator.a("weather_tap_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 211);
            if (g != 0) {
                jsonGenerator.a("website");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 212);
            if (g != 0) {
                jsonGenerator.a("website_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 213);
            if (g != 0) {
                jsonGenerator.a("write_review_action");
                ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 214) != 0) {
                jsonGenerator.a("xout_nux_type");
                jsonGenerator.b(mutableFlatBuffer.c(i, 214));
            }
            g = mutableFlatBuffer.a(i, 215, 0);
            if (g != 0) {
                jsonGenerator.a("zoom_level");
                jsonGenerator.b(g);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetch_successful */
    public final class ReactionUnitVideoChannelFeedUnitComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class ContextListParser {
            public static int m18234b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static int m18231a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m18234b(jsonParser, flatBufferBuilder)));
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

            public static void m18233a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m18232a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }

            public static void m18232a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18235a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("context_list")) {
                        iArr[0] = ContextListParser.m18231a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feed_unit")) {
                        iArr[1] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("prune_behavior")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLVideoChannelFeedUnitPruneBehavior.fromString(jsonParser.o()));
                    } else if (i.equals("publisher_context")) {
                        iArr[3] = ReactionTextWithEntitiesWithImagesParser.m14725a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("recommendation_context")) {
                        iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetch_successful */
    public final class ReactionUnitWeatherConditionComponentFragmentParser {

        /* compiled from: fetch_successful */
        public final class HighTemperatureParser {
            public static int m18236a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18237a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetch_successful */
        public final class LowTemperatureParser {
            public static int m18238a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18239a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetch_successful */
        public final class TemperatureParser {
            public static int m18240a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m18241a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m18242a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("high_temperature")) {
                        iArr[0] = HighTemperatureParser.m18236a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("icon")) {
                        iArr[1] = ReactionImageFieldsParser.m14690a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("low_temperature")) {
                        iArr[2] = LowTemperatureParser.m18238a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("temperature")) {
                        iArr[3] = TemperatureParser.m18240a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("time_bucket")) {
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
