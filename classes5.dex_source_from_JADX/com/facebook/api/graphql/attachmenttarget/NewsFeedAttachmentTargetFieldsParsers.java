package com.facebook.api.graphql.attachmenttarget;

import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser;
import com.facebook.api.graphql.feedback.NewsFeedFeedbackGraphQLParsers.NewsFeedDefaultsFeedbackParser;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLParsers.NewsFeedDefaultsPlaceFieldsWithoutMediaParser.CityParser;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLParsers.NewsFeedDefaultsPlaceFieldsWithoutMediaParser.OverallStarRatingParser;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLParsers.NewsFeedDefaultsPlaceFieldsWithoutMediaParser.PageVisitsParser;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLParsers.NewsFeedDefaultsPlaceFieldsWithoutMediaParser.ViewerVisitsParser;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLParsers.SavableTimelineAppCollectionExtraFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.AudioAttachmentFieldsParser.MusicObjectParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.BusinessLocationAttachmentStyleInfoFieldsParser.BoundingBoxParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CommentPlaceInfoAttachmentTargetParser.PlaceListItemsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CommentPlaceInfoPageFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CulturalMomentAttachmentFieldsParser.CulturalMomentImageParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CulturalMomentAttachmentFieldsParser.FaviconParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CulturalMomentVideoParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.EventAttachmentParser.EventCoverPhotoParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.ExternalUrlAttachmentParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FBMediaQuestionFragmentParser.MediaQuestionOptionOrderParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FBMediaQuestionFragmentParser.MediaQuestionPhotosParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FundraiserPageAttachmentFragmentParser.CampaignParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FundraiserPersonToCharityAttachmentFragmentParser.CharityParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FundraiserPersonToCharityAttachmentFragmentParser.DonorsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GoodwillThrowbackCardAttachmentComponentParser.ActionLinksParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GoodwillThrowbackCardAttachmentComponentParser.AdditionalAccentImagesParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GoodwillThrowbackCardAttachmentComponentParser.DataPointsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GreetingCardFieldsParser.GreetingCardTemplateParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GreetingCardFieldsParser.SlidesParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.InstantArticleFieldsParser.InstantArticleParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.LocalAdContextAttachmentStyleInfoFieldsParser.PlaceOpenStatusFormatsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.MessengerContentSubscriptionTargetParser.MessengerContentSubscriptionOptionParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.MultiPlaceMapAttachmentStyleInfoFieldsParser.LatLongListParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedDefaultsEventPlaceFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedStoryAttachmentTargetExperienceFieldsParser.EmployerParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedStoryAttachmentTargetExperienceFieldsParser.SchoolClassParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedStoryAttachmentTargetExperienceFieldsParser.SchoolParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedStoryAttachmentTargetExperienceFieldsParser.WorkProjectParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.OpenGraphActionAttachmentTargetParser.PrimaryObjectNodeParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.OpenGraphObjectAttachmentTargetParser.MusiciansParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.OpenGraphObjectAttachmentTargetParser.PreviewUrlsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.PlaceListAttachmentTargetParser.ListItemsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.PlaceListAttachmentTargetParser.NonSpecificPlaceToSearchParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.QuestionTargetParser.OptionsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.QuoteFieldsParser.QuoteParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.ReadingAttachmentTargetParser.PageLikersParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SingleSongMusicAttachmentParser.GlobalShareParser.OpenGraphNodeParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SouvenirsFieldsParser.MediaElementsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SportsAttachmentFieldsParser.SportsMatchDataParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.StoryAttachmentAppAdLinkTargetParser.RatingParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.ThrowbackMediaAttachmentFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.TravelAttachmentFieldsParser.AddressParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.TravelAttachmentFieldsParser.MapBoundingBoxParser;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.AppStoreApplicationFragmentParser;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.InnerApplicationFieldsParser;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.InnerApplicationFieldsParser.AndroidAppConfigParser;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesWithRangesFieldsParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGroupCommercePriceType;
import com.facebook.graphql.enums.GraphQLMusicType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLQuestionPollAnswersState;
import com.facebook.graphql.enums.GraphQLQuestionResponseMethod;
import com.facebook.graphql.enums.GraphQLRedirectionReason;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DeprecatedCurrencyQuantityFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageUriFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLParsers.SizeAwareMediaParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: app_section */
public class NewsFeedAttachmentTargetFieldsParsers {

    /* compiled from: app_section */
    public final class CommonAttachmentTargetFieldsParser {

        /* compiled from: app_section */
        public final class BylinesParser {

            /* compiled from: app_section */
            public final class ConciseTextParser {
                public static int m15626a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m15627a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("text");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15630b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("concise_text")) {
                            iArr[0] = ConciseTextParser.m15626a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static int m15628a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m15630b(jsonParser, flatBufferBuilder)));
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

            public static void m15629a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m15631b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m15631b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("concise_text");
                    ConciseTextParser.m15627a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_section */
        public final class CoverPhotoParser {

            /* compiled from: app_section */
            public final class PhotoParser {
                public static int m15632a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m15633a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("image");
                        DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15634a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("photo")) {
                            iArr[0] = PhotoParser.m15632a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m15635a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    PhotoParser.m15633a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_section */
        public final class MediaParser {
            public static int m15636a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15637a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_section */
        public final class RedirectionInfoParser {
            public static int m15641b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("reason")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLRedirectionReason.fromString(jsonParser.o()));
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

            public static int m15638a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m15641b(jsonParser, flatBufferBuilder)));
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

            public static void m15640a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m15639a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }

            public static void m15639a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("reason");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_section */
        public final class SocialContextParser {
            public static int m15642a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15643a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15644a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[11];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("android_urls")) {
                        iArr[1] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("application")) {
                        iArr[2] = InnerApplicationFieldsParser.m3081a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("bylines")) {
                        iArr[3] = BylinesParser.m15628a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("cover_photo")) {
                        iArr[4] = CoverPhotoParser.m15634a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback")) {
                        iArr[5] = NewsFeedDefaultsFeedbackParser.m16377a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("media")) {
                        iArr[7] = MediaParser.m15636a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_picture")) {
                        iArr[8] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("redirection_info")) {
                        iArr[9] = RedirectionInfoParser.m15638a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("social_context")) {
                        iArr[10] = SocialContextParser.m15642a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: app_section */
    public final class StoryAttachmentFieldsWithoutMediaParser {

        /* compiled from: app_section */
        public final class AttachmentPropertiesParser {
            public static int m15647b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("key")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("title")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("type")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("value")) {
                            iArr[3] = DefaultTextWithEntitiesWithRangesFieldsParser.m3144a(jsonParser, flatBufferBuilder);
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

            public static int m15645a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m15647b(jsonParser, flatBufferBuilder)));
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

            public static void m15646a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m15648b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m15648b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("key");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("type");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                int g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("value");
                    DefaultTextWithEntitiesWithRangesFieldsParser.m3145a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_section */
        public final class SourceParser {
            public static int m15649a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15650a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_section */
        public final class StyleInfosParser {
            public static int m15653b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[19];
                boolean[] zArr = new boolean[4];
                int[] iArr2 = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("bounding_box")) {
                            iArr[1] = BoundingBoxParser.m18175a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("category_name")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("game_uri")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("instant_game_id")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("label")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("lat_long_list")) {
                            iArr[6] = LatLongListParser.m18297a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("layout_height")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("layout_width")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("layout_x")) {
                            zArr[2] = true;
                            iArr2[2] = jsonParser.E();
                        } else if (i.equals("layout_y")) {
                            zArr[3] = true;
                            iArr2[3] = jsonParser.E();
                        } else if (i.equals("location")) {
                            iArr[11] = DefaultLocationFieldsParser.m9760a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("logo")) {
                            iArr[12] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("mobile_game_uri")) {
                            iArr[13] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("nearby_locations")) {
                            iArr[14] = DefaultLocationFieldsParser.m9763b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_open_status_formats")) {
                            iArr[15] = PlaceOpenStatusFormatsParser.m18287a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("splash_uri")) {
                            iArr[16] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("time_zone")) {
                            iArr[17] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("video_uri")) {
                            iArr[18] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(19);
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
                if (zArr[1]) {
                    flatBufferBuilder.a(8, iArr2[1], 0);
                }
                if (zArr[2]) {
                    flatBufferBuilder.a(9, iArr2[2], 0);
                }
                if (zArr[3]) {
                    flatBufferBuilder.a(10, iArr2[3], 0);
                }
                flatBufferBuilder.b(11, iArr[11]);
                flatBufferBuilder.b(12, iArr[12]);
                flatBufferBuilder.b(13, iArr[13]);
                flatBufferBuilder.b(14, iArr[14]);
                flatBufferBuilder.b(15, iArr[15]);
                flatBufferBuilder.b(16, iArr[16]);
                flatBufferBuilder.b(17, iArr[17]);
                flatBufferBuilder.b(18, iArr[18]);
                return flatBufferBuilder.d();
            }

            public static int m15651a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m15653b(jsonParser, flatBufferBuilder)));
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

            public static void m15652a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m15654b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m15654b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("bounding_box");
                    BoundingBoxParser.m18176a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("category_name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("game_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("instant_game_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("label");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("lat_long_list");
                    LatLongListParser.m18299a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 7, 0);
                if (g != 0) {
                    jsonGenerator.a("layout_height");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 8, 0);
                if (g != 0) {
                    jsonGenerator.a("layout_width");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 9, 0);
                if (g != 0) {
                    jsonGenerator.a("layout_x");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 10, 0);
                if (g != 0) {
                    jsonGenerator.a("layout_y");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("location");
                    DefaultLocationFieldsParser.m9761a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 12);
                if (g != 0) {
                    jsonGenerator.a("logo");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 13) != 0) {
                    jsonGenerator.a("mobile_game_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 13));
                }
                g = mutableFlatBuffer.g(i, 14);
                if (g != 0) {
                    jsonGenerator.a("nearby_locations");
                    DefaultLocationFieldsParser.m9762a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 15);
                if (g != 0) {
                    jsonGenerator.a("place_open_status_formats");
                    PlaceOpenStatusFormatsParser.m18288a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 16) != 0) {
                    jsonGenerator.a("splash_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 16));
                }
                if (mutableFlatBuffer.g(i, 17) != 0) {
                    jsonGenerator.a("time_zone");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 17));
                }
                if (mutableFlatBuffer.g(i, 18) != 0) {
                    jsonGenerator.a("video_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 18));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: app_section */
        public final class TargetParser {

            /* compiled from: app_section */
            public final class GlobalShareParser {

                /* compiled from: app_section */
                public final class TitleParser {
                    public static int m15655a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m15656a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("text");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m15657a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[6];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("android_urls")) {
                                iArr[0] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("external_url")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("id")) {
                                iArr[2] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("open_graph_node")) {
                                iArr[3] = OpenGraphNodeParser.m18360a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("title")) {
                                iArr[4] = TitleParser.m15655a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("user_url")) {
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

                public static void m15658a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("android_urls");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 0), jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("external_url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    int g = mutableFlatBuffer.g(i, 3);
                    if (g != 0) {
                        jsonGenerator.a("open_graph_node");
                        OpenGraphNodeParser.m18361a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 4);
                    if (g != 0) {
                        jsonGenerator.a("title");
                        TitleParser.m15656a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 5) != 0) {
                        jsonGenerator.a("user_url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: app_section */
            public final class ItemPriceParser {
                public static int m15659a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[4];
                    boolean[] zArr = new boolean[2];
                    int[] iArr2 = new int[1];
                    double[] dArr = new double[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("amount")) {
                                zArr[0] = true;
                                dArr[0] = jsonParser.G();
                            } else if (i.equals("currency")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("offset")) {
                                zArr[1] = true;
                                iArr2[0] = jsonParser.E();
                            } else if (i.equals("offset_amount")) {
                                iArr[3] = flatBufferBuilder.b(jsonParser.o());
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(4);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, dArr[0], 0.0d);
                    }
                    flatBufferBuilder.b(1, iArr[1]);
                    if (zArr[1]) {
                        flatBufferBuilder.a(2, iArr2[0], 0);
                    }
                    flatBufferBuilder.b(3, iArr[3]);
                    return flatBufferBuilder.d();
                }

                public static void m15660a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    double a = mutableFlatBuffer.a(i, 0, 0.0d);
                    if (a != 0.0d) {
                        jsonGenerator.a("amount");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("currency");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    int a2 = mutableFlatBuffer.a(i, 2, 0);
                    if (a2 != 0) {
                        jsonGenerator.a("offset");
                        jsonGenerator.b(a2);
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("offset_amount");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: app_section */
            public final class OwnerParser {
                public static int m15661a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m15662a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

            /* compiled from: app_section */
            public final class TitleParser {
                public static int m15663a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m15664a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("text");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15665a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[135];
                boolean[] zArr = new boolean[24];
                boolean[] zArr2 = new boolean[17];
                int[] iArr2 = new int[1];
                long[] jArr = new long[4];
                double[] dArr = new double[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("accent_image")) {
                            iArr[1] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("action_links")) {
                            iArr[2] = ActionLinksParser.m18242a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("additional_accent_images")) {
                            iArr[3] = AdditionalAccentImagesParser.m18246a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("address")) {
                            iArr[4] = AddressParser.m18401a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("album_release_date")) {
                            zArr[0] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("amount_raised_text")) {
                            iArr[6] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("android_app_config")) {
                            iArr[7] = AndroidAppConfigParser.m3079a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("android_store_url")) {
                            iArr[8] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("android_urls")) {
                            iArr[9] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("app_center_cover_image")) {
                            iArr[10] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("application")) {
                            iArr[11] = InnerApplicationFieldsParser.m3081a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("application_name")) {
                            iArr[12] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("artist_names")) {
                            iArr[13] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("audio_url")) {
                            iArr[14] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("author_text")) {
                            iArr[15] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("average_star_rating")) {
                            zArr[1] = true;
                            dArr[0] = jsonParser.G();
                        } else if (i.equals("bylines")) {
                            iArr[17] = BylinesParser.m15628a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("campaign")) {
                            iArr[18] = CampaignParser.m18225a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("campaign_goal_text")) {
                            iArr[19] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("campaign_title")) {
                            iArr[20] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("can_viewer_change_availability")) {
                            zArr[2] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("can_viewer_change_guest_status")) {
                            zArr[3] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("can_viewer_edit_attachment")) {
                            zArr[4] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("can_viewer_post")) {
                            zArr[5] = true;
                            zArr2[3] = jsonParser.H();
                        } else if (i.equals("canvas_url")) {
                            iArr[25] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("category_names")) {
                            iArr[26] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("charity")) {
                            iArr[27] = CharityParser.m18230a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("city")) {
                            iArr[28] = CityParser.m2844a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("collection_names")) {
                            iArr[29] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("connection_style")) {
                            iArr[30] = flatBufferBuilder.a(GraphQLConnectionStyle.fromString(jsonParser.o()));
                        } else if (i.equals("copy_right")) {
                            iArr[31] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("cover_photo")) {
                            iArr[32] = CoverPhotoParser.m15634a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("cover_url")) {
                            iArr[33] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("cultural_moment_image")) {
                            iArr[34] = CulturalMomentImageParser.m18192a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("cultural_moment_video")) {
                            iArr[35] = CulturalMomentVideoParser.m18197a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("current_price")) {
                            iArr[36] = DeprecatedCurrencyQuantityFieldsParser.m9658a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("data_points")) {
                            iArr[37] = DataPointsParser.m18256a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("donors")) {
                            iArr[38] = DonorsParser.m18236a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("duration_ms")) {
                            zArr[6] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("employer")) {
                            iArr[40] = EmployerParser.m18306a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("end_timestamp")) {
                            zArr[7] = true;
                            jArr[1] = jsonParser.F();
                        } else if (i.equals("event_cover_photo")) {
                            iArr[42] = EventCoverPhotoParser.m18201a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("event_place")) {
                            iArr[43] = NewsFeedDefaultsEventPlaceFieldsParser.m18304a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("expiration_time")) {
                            zArr[8] = true;
                            jArr[2] = jsonParser.F();
                        } else if (i.equals("favicon")) {
                            iArr[45] = FaviconParser.m18194a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("feedback")) {
                            iArr[46] = NewsFeedDefaultsFeedbackParser.m16377a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("friendship_status")) {
                            iArr[47] = flatBufferBuilder.a(GraphQLFriendshipStatus.fromString(jsonParser.o()));
                        } else if (i.equals("fundraiser_for_charity_text")) {
                            iArr[48] = DefaultTextWithEntitiesWithRangesFieldsParser.m3144a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("global_share")) {
                            iArr[49] = GlobalShareParser.m15657a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("global_usage_summary_sentence")) {
                            iArr[50] = DefaultTextWithEntitiesFieldsParser.m9834a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("greeting_card_template")) {
                            iArr[51] = GreetingCardTemplateParser.m18263a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("group_commerce_item_description")) {
                            iArr[52] = DefaultTextWithEntitiesWithRangesFieldsParser.m3144a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("has_goal_amount")) {
                            zArr[9] = true;
                            zArr2[4] = jsonParser.H();
                        } else if (i.equals("id")) {
                            iArr[54] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("image")) {
                            iArr[55] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("image_margin")) {
                            iArr[56] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("instant_article")) {
                            iArr[57] = InstantArticleParser.m18282a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("is_all_day")) {
                            zArr[10] = true;
                            zArr2[5] = jsonParser.H();
                        } else if (i.equals("is_expired")) {
                            zArr[11] = true;
                            zArr2[6] = jsonParser.H();
                        } else if (i.equals("is_music_item")) {
                            zArr[12] = true;
                            zArr2[7] = jsonParser.H();
                        } else if (i.equals("is_on_sale")) {
                            zArr[13] = true;
                            zArr2[8] = jsonParser.H();
                        } else if (i.equals("is_owned")) {
                            zArr[14] = true;
                            zArr2[9] = jsonParser.H();
                        } else if (i.equals("is_sold")) {
                            zArr[15] = true;
                            zArr2[10] = jsonParser.H();
                        } else if (i.equals("item_price")) {
                            iArr[64] = ItemPriceParser.m15659a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("list_items")) {
                            iArr[65] = ListItemsParser.m18335a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("location")) {
                            iArr[66] = DefaultLocationFieldsParser.m9760a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("logo_image")) {
                            iArr[67] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("map_bounding_box")) {
                            iArr[68] = MapBoundingBoxParser.m18403a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("media")) {
                            iArr[69] = MediaParser.m15636a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("media_elements")) {
                            iArr[70] = MediaElementsParser.m18378a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("media_question_option_order")) {
                            iArr[71] = MediaQuestionOptionOrderParser.m18214a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("media_question_photos")) {
                            iArr[72] = MediaQuestionPhotosParser.m18216a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("media_question_type")) {
                            iArr[73] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("message")) {
                            iArr[74] = DefaultTextWithEntitiesFieldsParser.m9834a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("messenger_content_subscription_option")) {
                            iArr[75] = MessengerContentSubscriptionOptionParser.m18294a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("music_object")) {
                            iArr[76] = MusicObjectParser.m18172a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("music_title")) {
                            iArr[77] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("music_type")) {
                            iArr[78] = flatBufferBuilder.a(GraphQLMusicType.fromString(jsonParser.o()));
                        } else if (i.equals("musicians")) {
                            iArr[79] = MusiciansParser.m18318a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("name")) {
                            iArr[80] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("non_specific_place_to_search")) {
                            iArr[81] = NonSpecificPlaceToSearchParser.m18339a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("open_graph_node")) {
                            iArr[82] = ExternalUrlAttachmentParser.OpenGraphNodeParser.m18207a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("options")) {
                            iArr[83] = OptionsParser.m18350a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("overall_star_rating")) {
                            iArr[84] = OverallStarRatingParser.m2846a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("owner")) {
                            iArr[85] = OwnerParser.m15661a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("page_likers")) {
                            iArr[86] = PageLikersParser.m18357a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("page_visits")) {
                            iArr[87] = PageVisitsParser.m2848a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("pending_places_for_attachment")) {
                            iArr[88] = CommentPlaceInfoPageFieldsParser.m18190b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("percent_of_goal_reached")) {
                            zArr[16] = true;
                            dArr[1] = jsonParser.G();
                        } else if (i.equals("pickup_note")) {
                            iArr[90] = DefaultTextWithEntitiesWithRangesFieldsParser.m3144a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_list_items")) {
                            iArr[91] = PlaceListItemsParser.m18183a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_list_title")) {
                            iArr[92] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("poll_answers_state")) {
                            iArr[93] = flatBufferBuilder.a(GraphQLQuestionPollAnswersState.fromString(jsonParser.o()));
                        } else if (i.equals("preview_urls")) {
                            iArr[94] = PreviewUrlsParser.m18322a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("price_type")) {
                            iArr[95] = flatBufferBuilder.a(GraphQLGroupCommercePriceType.fromString(jsonParser.o()));
                        } else if (i.equals("primary_image")) {
                            iArr[96] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("primary_object_node")) {
                            iArr[97] = PrimaryObjectNodeParser.m18315a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("profile_picture")) {
                            iArr[98] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("profile_picture_is_silhouette")) {
                            zArr[17] = true;
                            zArr2[11] = jsonParser.H();
                        } else if (i.equals("quote")) {
                            iArr[100] = QuoteParser.m18354a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("rating")) {
                            iArr[101] = RatingParser.m18390a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("rectangular_profile_picture")) {
                            iArr[102] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("redirection_info")) {
                            iArr[103] = RedirectionInfoParser.m15638a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("response_method")) {
                            iArr[104] = flatBufferBuilder.a(GraphQLQuestionResponseMethod.fromString(jsonParser.o()));
                        } else if (i.equals("saved_collection")) {
                            iArr[105] = SavableTimelineAppCollectionExtraFieldsParser.m2952a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("school")) {
                            iArr[106] = SchoolParser.m18310a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("school_class")) {
                            iArr[107] = SchoolClassParser.m18308a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("should_intercept_delete_post")) {
                            zArr[18] = true;
                            zArr2[12] = jsonParser.H();
                        } else if (i.equals("should_show_reviews_on_profile")) {
                            zArr[19] = true;
                            zArr2[13] = jsonParser.H();
                        } else if (i.equals("show_mark_as_sold_button")) {
                            zArr[20] = true;
                            zArr2[14] = jsonParser.H();
                        } else if (i.equals("slides")) {
                            iArr[111] = SlidesParser.m18275a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("social_context")) {
                            iArr[112] = SocialContextParser.m15642a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("social_context_text")) {
                            iArr[113] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("social_usage_summary_sentence")) {
                            iArr[114] = DefaultTextWithEntitiesFieldsParser.m9834a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("souvenir_cover_photo")) {
                            iArr[115] = SizeAwareMediaParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("sports_match_data")) {
                            iArr[116] = SportsMatchDataParser.m18385a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("square_logo")) {
                            iArr[117] = DefaultImageUriFieldsParser.m9758a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("start_timestamp")) {
                            zArr[21] = true;
                            jArr[3] = jsonParser.F();
                        } else if (i.equals("status_text")) {
                            iArr[119] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("super_category_type")) {
                            iArr[120] = flatBufferBuilder.a(GraphQLPageSuperCategoryType.fromString(jsonParser.o()));
                        } else if (i.equals("text")) {
                            iArr[121] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("theme")) {
                            iArr[122] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("throwback_media")) {
                            iArr[123] = SizeAwareMediaParser.b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("throwback_media_attachments")) {
                            iArr[124] = ThrowbackMediaAttachmentFieldsParser.m18397a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("timezone")) {
                            iArr[125] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("title")) {
                            iArr[126] = TitleParser.m15663a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("url")) {
                            iArr[127] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("viewer_guest_status")) {
                            iArr[128] = flatBufferBuilder.a(GraphQLEventGuestStatus.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_has_pending_invite")) {
                            zArr[22] = true;
                            zArr2[15] = jsonParser.H();
                        } else if (i.equals("viewer_has_voted")) {
                            zArr[23] = true;
                            zArr2[16] = jsonParser.H();
                        } else if (i.equals("viewer_saved_state")) {
                            iArr[131] = flatBufferBuilder.a(GraphQLSavedState.fromString(jsonParser.o()));
                        } else if (i.equals("viewer_visits")) {
                            iArr[132] = ViewerVisitsParser.m2850a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("viewer_watch_status")) {
                            iArr[133] = flatBufferBuilder.a(GraphQLEventWatchStatus.fromString(jsonParser.o()));
                        } else if (i.equals("work_project")) {
                            iArr[134] = WorkProjectParser.m18312a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(135);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                if (zArr[0]) {
                    flatBufferBuilder.a(5, jArr[0], 0);
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
                if (zArr[1]) {
                    flatBufferBuilder.a(16, dArr[0], 0.0d);
                }
                flatBufferBuilder.b(17, iArr[17]);
                flatBufferBuilder.b(18, iArr[18]);
                flatBufferBuilder.b(19, iArr[19]);
                flatBufferBuilder.b(20, iArr[20]);
                if (zArr[2]) {
                    flatBufferBuilder.a(21, zArr2[0]);
                }
                if (zArr[3]) {
                    flatBufferBuilder.a(22, zArr2[1]);
                }
                if (zArr[4]) {
                    flatBufferBuilder.a(23, zArr2[2]);
                }
                if (zArr[5]) {
                    flatBufferBuilder.a(24, zArr2[3]);
                }
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
                if (zArr[6]) {
                    flatBufferBuilder.a(39, iArr2[0], 0);
                }
                flatBufferBuilder.b(40, iArr[40]);
                if (zArr[7]) {
                    flatBufferBuilder.a(41, jArr[1], 0);
                }
                flatBufferBuilder.b(42, iArr[42]);
                flatBufferBuilder.b(43, iArr[43]);
                if (zArr[8]) {
                    flatBufferBuilder.a(44, jArr[2], 0);
                }
                flatBufferBuilder.b(45, iArr[45]);
                flatBufferBuilder.b(46, iArr[46]);
                flatBufferBuilder.b(47, iArr[47]);
                flatBufferBuilder.b(48, iArr[48]);
                flatBufferBuilder.b(49, iArr[49]);
                flatBufferBuilder.b(50, iArr[50]);
                flatBufferBuilder.b(51, iArr[51]);
                flatBufferBuilder.b(52, iArr[52]);
                if (zArr[9]) {
                    flatBufferBuilder.a(53, zArr2[4]);
                }
                flatBufferBuilder.b(54, iArr[54]);
                flatBufferBuilder.b(55, iArr[55]);
                flatBufferBuilder.b(56, iArr[56]);
                flatBufferBuilder.b(57, iArr[57]);
                if (zArr[10]) {
                    flatBufferBuilder.a(58, zArr2[5]);
                }
                if (zArr[11]) {
                    flatBufferBuilder.a(59, zArr2[6]);
                }
                if (zArr[12]) {
                    flatBufferBuilder.a(60, zArr2[7]);
                }
                if (zArr[13]) {
                    flatBufferBuilder.a(61, zArr2[8]);
                }
                if (zArr[14]) {
                    flatBufferBuilder.a(62, zArr2[9]);
                }
                if (zArr[15]) {
                    flatBufferBuilder.a(63, zArr2[10]);
                }
                flatBufferBuilder.b(64, iArr[64]);
                flatBufferBuilder.b(65, iArr[65]);
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
                flatBufferBuilder.b(87, iArr[87]);
                flatBufferBuilder.b(88, iArr[88]);
                if (zArr[16]) {
                    flatBufferBuilder.a(89, dArr[1], 0.0d);
                }
                flatBufferBuilder.b(90, iArr[90]);
                flatBufferBuilder.b(91, iArr[91]);
                flatBufferBuilder.b(92, iArr[92]);
                flatBufferBuilder.b(93, iArr[93]);
                flatBufferBuilder.b(94, iArr[94]);
                flatBufferBuilder.b(95, iArr[95]);
                flatBufferBuilder.b(96, iArr[96]);
                flatBufferBuilder.b(97, iArr[97]);
                flatBufferBuilder.b(98, iArr[98]);
                if (zArr[17]) {
                    flatBufferBuilder.a(99, zArr2[11]);
                }
                flatBufferBuilder.b(100, iArr[100]);
                flatBufferBuilder.b(101, iArr[101]);
                flatBufferBuilder.b(102, iArr[102]);
                flatBufferBuilder.b(103, iArr[103]);
                flatBufferBuilder.b(104, iArr[104]);
                flatBufferBuilder.b(105, iArr[105]);
                flatBufferBuilder.b(106, iArr[106]);
                flatBufferBuilder.b(107, iArr[107]);
                if (zArr[18]) {
                    flatBufferBuilder.a(108, zArr2[12]);
                }
                if (zArr[19]) {
                    flatBufferBuilder.a(109, zArr2[13]);
                }
                if (zArr[20]) {
                    flatBufferBuilder.a(110, zArr2[14]);
                }
                flatBufferBuilder.b(111, iArr[111]);
                flatBufferBuilder.b(112, iArr[112]);
                flatBufferBuilder.b(113, iArr[113]);
                flatBufferBuilder.b(114, iArr[114]);
                flatBufferBuilder.b(115, iArr[115]);
                flatBufferBuilder.b(116, iArr[116]);
                flatBufferBuilder.b(117, iArr[117]);
                if (zArr[21]) {
                    flatBufferBuilder.a(118, jArr[3], 0);
                }
                flatBufferBuilder.b(119, iArr[119]);
                flatBufferBuilder.b(120, iArr[120]);
                flatBufferBuilder.b(121, iArr[121]);
                flatBufferBuilder.b(122, iArr[122]);
                flatBufferBuilder.b(123, iArr[123]);
                flatBufferBuilder.b(124, iArr[124]);
                flatBufferBuilder.b(125, iArr[125]);
                flatBufferBuilder.b(126, iArr[126]);
                flatBufferBuilder.b(127, iArr[127]);
                flatBufferBuilder.b(128, iArr[128]);
                if (zArr[22]) {
                    flatBufferBuilder.a(129, zArr2[15]);
                }
                if (zArr[23]) {
                    flatBufferBuilder.a(130, zArr2[16]);
                }
                flatBufferBuilder.b(131, iArr[131]);
                flatBufferBuilder.b(132, iArr[132]);
                flatBufferBuilder.b(133, iArr[133]);
                flatBufferBuilder.b(134, iArr[134]);
                return flatBufferBuilder.d();
            }

            public static void m15666a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("accent_image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("action_links");
                    ActionLinksParser.m18244a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("additional_accent_images");
                    AdditionalAccentImagesParser.m18248a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("address");
                    AddressParser.m18402a(mutableFlatBuffer, g, jsonGenerator);
                }
                long a = mutableFlatBuffer.a(i, 5, 0);
                if (a != 0) {
                    jsonGenerator.a("album_release_date");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 6) != 0) {
                    jsonGenerator.a("amount_raised_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("android_app_config");
                    AndroidAppConfigParser.m3080a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 8) != 0) {
                    jsonGenerator.a("android_store_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 8));
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("android_urls");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 9), jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("app_center_cover_image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("application");
                    InnerApplicationFieldsParser.m3082a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 12) != 0) {
                    jsonGenerator.a("application_name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 12));
                }
                if (mutableFlatBuffer.g(i, 13) != 0) {
                    jsonGenerator.a("artist_names");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 13), jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 14) != 0) {
                    jsonGenerator.a("audio_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 14));
                }
                if (mutableFlatBuffer.g(i, 15) != 0) {
                    jsonGenerator.a("author_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 15));
                }
                double a2 = mutableFlatBuffer.a(i, 16, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("average_star_rating");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("bylines");
                    BylinesParser.m15629a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 18);
                if (g != 0) {
                    jsonGenerator.a("campaign");
                    CampaignParser.m18226a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 19) != 0) {
                    jsonGenerator.a("campaign_goal_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 19));
                }
                if (mutableFlatBuffer.g(i, 20) != 0) {
                    jsonGenerator.a("campaign_title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 20));
                }
                boolean a3 = mutableFlatBuffer.a(i, 21);
                if (a3) {
                    jsonGenerator.a("can_viewer_change_availability");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 22);
                if (a3) {
                    jsonGenerator.a("can_viewer_change_guest_status");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 23);
                if (a3) {
                    jsonGenerator.a("can_viewer_edit_attachment");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 24);
                if (a3) {
                    jsonGenerator.a("can_viewer_post");
                    jsonGenerator.a(a3);
                }
                if (mutableFlatBuffer.g(i, 25) != 0) {
                    jsonGenerator.a("canvas_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 25));
                }
                if (mutableFlatBuffer.g(i, 26) != 0) {
                    jsonGenerator.a("category_names");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 26), jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 27);
                if (g != 0) {
                    jsonGenerator.a("charity");
                    CharityParser.m18231a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 28);
                if (g != 0) {
                    jsonGenerator.a("city");
                    CityParser.m2845a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 29) != 0) {
                    jsonGenerator.a("collection_names");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 29), jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 30) != 0) {
                    jsonGenerator.a("connection_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 30));
                }
                if (mutableFlatBuffer.g(i, 31) != 0) {
                    jsonGenerator.a("copy_right");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 31));
                }
                g = mutableFlatBuffer.g(i, 32);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m15635a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 33) != 0) {
                    jsonGenerator.a("cover_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 33));
                }
                g = mutableFlatBuffer.g(i, 34);
                if (g != 0) {
                    jsonGenerator.a("cultural_moment_image");
                    CulturalMomentImageParser.m18193a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 35);
                if (g != 0) {
                    jsonGenerator.a("cultural_moment_video");
                    CulturalMomentVideoParser.m18198a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 36);
                if (g != 0) {
                    jsonGenerator.a("current_price");
                    DeprecatedCurrencyQuantityFieldsParser.m9659a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 37);
                if (g != 0) {
                    jsonGenerator.a("data_points");
                    DataPointsParser.m18257a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 38);
                if (g != 0) {
                    jsonGenerator.a("donors");
                    DonorsParser.m18237a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 39, 0);
                if (g != 0) {
                    jsonGenerator.a("duration_ms");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 40);
                if (g != 0) {
                    jsonGenerator.a("employer");
                    EmployerParser.m18307a(mutableFlatBuffer, g, jsonGenerator);
                }
                a = mutableFlatBuffer.a(i, 41, 0);
                if (a != 0) {
                    jsonGenerator.a("end_timestamp");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 42);
                if (g != 0) {
                    jsonGenerator.a("event_cover_photo");
                    EventCoverPhotoParser.m18202a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 43);
                if (g != 0) {
                    jsonGenerator.a("event_place");
                    NewsFeedDefaultsEventPlaceFieldsParser.m18305a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.a(i, 44, 0);
                if (a != 0) {
                    jsonGenerator.a("expiration_time");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 45);
                if (g != 0) {
                    jsonGenerator.a("favicon");
                    FaviconParser.m18195a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 46);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    NewsFeedDefaultsFeedbackParser.m16378a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 47) != 0) {
                    jsonGenerator.a("friendship_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 47));
                }
                g = mutableFlatBuffer.g(i, 48);
                if (g != 0) {
                    jsonGenerator.a("fundraiser_for_charity_text");
                    DefaultTextWithEntitiesWithRangesFieldsParser.m3145a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 49);
                if (g != 0) {
                    jsonGenerator.a("global_share");
                    GlobalShareParser.m15658a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 50);
                if (g != 0) {
                    jsonGenerator.a("global_usage_summary_sentence");
                    DefaultTextWithEntitiesFieldsParser.m9835a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 51);
                if (g != 0) {
                    jsonGenerator.a("greeting_card_template");
                    GreetingCardTemplateParser.m18264a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 52);
                if (g != 0) {
                    jsonGenerator.a("group_commerce_item_description");
                    DefaultTextWithEntitiesWithRangesFieldsParser.m3145a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a3 = mutableFlatBuffer.a(i, 53);
                if (a3) {
                    jsonGenerator.a("has_goal_amount");
                    jsonGenerator.a(a3);
                }
                if (mutableFlatBuffer.g(i, 54) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 54));
                }
                g = mutableFlatBuffer.g(i, 55);
                if (g != 0) {
                    jsonGenerator.a("image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 56) != 0) {
                    jsonGenerator.a("image_margin");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 56));
                }
                g = mutableFlatBuffer.g(i, 57);
                if (g != 0) {
                    jsonGenerator.a("instant_article");
                    InstantArticleParser.m18283a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a3 = mutableFlatBuffer.a(i, 58);
                if (a3) {
                    jsonGenerator.a("is_all_day");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 59);
                if (a3) {
                    jsonGenerator.a("is_expired");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 60);
                if (a3) {
                    jsonGenerator.a("is_music_item");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 61);
                if (a3) {
                    jsonGenerator.a("is_on_sale");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 62);
                if (a3) {
                    jsonGenerator.a("is_owned");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 63);
                if (a3) {
                    jsonGenerator.a("is_sold");
                    jsonGenerator.a(a3);
                }
                g = mutableFlatBuffer.g(i, 64);
                if (g != 0) {
                    jsonGenerator.a("item_price");
                    ItemPriceParser.m15660a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 65);
                if (g != 0) {
                    jsonGenerator.a("list_items");
                    ListItemsParser.m18336a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 66);
                if (g != 0) {
                    jsonGenerator.a("location");
                    DefaultLocationFieldsParser.m9761a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 67);
                if (g != 0) {
                    jsonGenerator.a("logo_image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 68);
                if (g != 0) {
                    jsonGenerator.a("map_bounding_box");
                    MapBoundingBoxParser.m18404a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 69);
                if (g != 0) {
                    jsonGenerator.a("media");
                    MediaParser.m15637a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 70);
                if (g != 0) {
                    jsonGenerator.a("media_elements");
                    MediaElementsParser.m18379a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 71);
                if (g != 0) {
                    jsonGenerator.a("media_question_option_order");
                    MediaQuestionOptionOrderParser.m18215a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 72);
                if (g != 0) {
                    jsonGenerator.a("media_question_photos");
                    MediaQuestionPhotosParser.m18217a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 73) != 0) {
                    jsonGenerator.a("media_question_type");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 73));
                }
                g = mutableFlatBuffer.g(i, 74);
                if (g != 0) {
                    jsonGenerator.a("message");
                    DefaultTextWithEntitiesFieldsParser.m9835a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 75);
                if (g != 0) {
                    jsonGenerator.a("messenger_content_subscription_option");
                    MessengerContentSubscriptionOptionParser.m18295a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 76);
                if (g != 0) {
                    jsonGenerator.a("music_object");
                    MusicObjectParser.m18173a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 77) != 0) {
                    jsonGenerator.a("music_title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 77));
                }
                if (mutableFlatBuffer.g(i, 78) != 0) {
                    jsonGenerator.a("music_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 78));
                }
                g = mutableFlatBuffer.g(i, 79);
                if (g != 0) {
                    jsonGenerator.a("musicians");
                    MusiciansParser.m18320a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 80) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 80));
                }
                g = mutableFlatBuffer.g(i, 81);
                if (g != 0) {
                    jsonGenerator.a("non_specific_place_to_search");
                    NonSpecificPlaceToSearchParser.m18340a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 82);
                if (g != 0) {
                    jsonGenerator.a("open_graph_node");
                    ExternalUrlAttachmentParser.OpenGraphNodeParser.m18208a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 83);
                if (g != 0) {
                    jsonGenerator.a("options");
                    OptionsParser.m18351a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 84);
                if (g != 0) {
                    jsonGenerator.a("overall_star_rating");
                    OverallStarRatingParser.m2847a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 85);
                if (g != 0) {
                    jsonGenerator.a("owner");
                    OwnerParser.m15662a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 86);
                if (g != 0) {
                    jsonGenerator.a("page_likers");
                    PageLikersParser.m18358a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 87);
                if (g != 0) {
                    jsonGenerator.a("page_visits");
                    PageVisitsParser.m2849a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 88);
                if (g != 0) {
                    jsonGenerator.a("pending_places_for_attachment");
                    CommentPlaceInfoPageFieldsParser.m18189a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a2 = mutableFlatBuffer.a(i, 89, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("percent_of_goal_reached");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 90);
                if (g != 0) {
                    jsonGenerator.a("pickup_note");
                    DefaultTextWithEntitiesWithRangesFieldsParser.m3145a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 91);
                if (g != 0) {
                    jsonGenerator.a("place_list_items");
                    PlaceListItemsParser.m18184a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 92) != 0) {
                    jsonGenerator.a("place_list_title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 92));
                }
                if (mutableFlatBuffer.g(i, 93) != 0) {
                    jsonGenerator.a("poll_answers_state");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 93));
                }
                g = mutableFlatBuffer.g(i, 94);
                if (g != 0) {
                    jsonGenerator.a("preview_urls");
                    PreviewUrlsParser.m18324a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 95) != 0) {
                    jsonGenerator.a("price_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 95));
                }
                g = mutableFlatBuffer.g(i, 96);
                if (g != 0) {
                    jsonGenerator.a("primary_image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 97);
                if (g != 0) {
                    jsonGenerator.a("primary_object_node");
                    PrimaryObjectNodeParser.m18316a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 98);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                a3 = mutableFlatBuffer.a(i, 99);
                if (a3) {
                    jsonGenerator.a("profile_picture_is_silhouette");
                    jsonGenerator.a(a3);
                }
                g = mutableFlatBuffer.g(i, 100);
                if (g != 0) {
                    jsonGenerator.a("quote");
                    QuoteParser.m18355a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 101);
                if (g != 0) {
                    jsonGenerator.a("rating");
                    RatingParser.m18391a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 102);
                if (g != 0) {
                    jsonGenerator.a("rectangular_profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 103);
                if (g != 0) {
                    jsonGenerator.a("redirection_info");
                    RedirectionInfoParser.m15640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 104) != 0) {
                    jsonGenerator.a("response_method");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 104));
                }
                g = mutableFlatBuffer.g(i, 105);
                if (g != 0) {
                    jsonGenerator.a("saved_collection");
                    SavableTimelineAppCollectionExtraFieldsParser.m2953a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 106);
                if (g != 0) {
                    jsonGenerator.a("school");
                    SchoolParser.m18311a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 107);
                if (g != 0) {
                    jsonGenerator.a("school_class");
                    SchoolClassParser.m18309a(mutableFlatBuffer, g, jsonGenerator);
                }
                a3 = mutableFlatBuffer.a(i, 108);
                if (a3) {
                    jsonGenerator.a("should_intercept_delete_post");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 109);
                if (a3) {
                    jsonGenerator.a("should_show_reviews_on_profile");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 110);
                if (a3) {
                    jsonGenerator.a("show_mark_as_sold_button");
                    jsonGenerator.a(a3);
                }
                g = mutableFlatBuffer.g(i, 111);
                if (g != 0) {
                    jsonGenerator.a("slides");
                    SlidesParser.m18276a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 112);
                if (g != 0) {
                    jsonGenerator.a("social_context");
                    SocialContextParser.m15643a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 113) != 0) {
                    jsonGenerator.a("social_context_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 113));
                }
                g = mutableFlatBuffer.g(i, 114);
                if (g != 0) {
                    jsonGenerator.a("social_usage_summary_sentence");
                    DefaultTextWithEntitiesFieldsParser.m9835a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 115);
                if (g != 0) {
                    jsonGenerator.a("souvenir_cover_photo");
                    SizeAwareMediaParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 116);
                if (g != 0) {
                    jsonGenerator.a("sports_match_data");
                    SportsMatchDataParser.m18386a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 117);
                if (g != 0) {
                    jsonGenerator.a("square_logo");
                    DefaultImageUriFieldsParser.m9759a(mutableFlatBuffer, g, jsonGenerator);
                }
                a = mutableFlatBuffer.a(i, 118, 0);
                if (a != 0) {
                    jsonGenerator.a("start_timestamp");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 119) != 0) {
                    jsonGenerator.a("status_text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 119));
                }
                if (mutableFlatBuffer.g(i, 120) != 0) {
                    jsonGenerator.a("super_category_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 120));
                }
                if (mutableFlatBuffer.g(i, 121) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 121));
                }
                if (mutableFlatBuffer.g(i, 122) != 0) {
                    jsonGenerator.a("theme");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 122));
                }
                g = mutableFlatBuffer.g(i, 123);
                if (g != 0) {
                    jsonGenerator.a("throwback_media");
                    SizeAwareMediaParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 124);
                if (g != 0) {
                    jsonGenerator.a("throwback_media_attachments");
                    ThrowbackMediaAttachmentFieldsParser.m18398a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 125) != 0) {
                    jsonGenerator.a("timezone");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 125));
                }
                g = mutableFlatBuffer.g(i, 126);
                if (g != 0) {
                    jsonGenerator.a("title");
                    TitleParser.m15664a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 127) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 127));
                }
                if (mutableFlatBuffer.g(i, 128) != 0) {
                    jsonGenerator.a("viewer_guest_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 128));
                }
                a3 = mutableFlatBuffer.a(i, 129);
                if (a3) {
                    jsonGenerator.a("viewer_has_pending_invite");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 130);
                if (a3) {
                    jsonGenerator.a("viewer_has_voted");
                    jsonGenerator.a(a3);
                }
                if (mutableFlatBuffer.g(i, 131) != 0) {
                    jsonGenerator.a("viewer_saved_state");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 131));
                }
                g = mutableFlatBuffer.g(i, 132);
                if (g != 0) {
                    jsonGenerator.a("viewer_visits");
                    ViewerVisitsParser.m2851a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 133) != 0) {
                    jsonGenerator.a("viewer_watch_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 133));
                }
                g = mutableFlatBuffer.g(i, 134);
                if (g != 0) {
                    jsonGenerator.a("work_project");
                    WorkProjectParser.m18313a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15667a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[14];
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
                    } else if (i.equals("media_reference_token")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("source")) {
                        iArr[6] = SourceParser.m15649a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("style_infos")) {
                        iArr[7] = StyleInfosParser.m15651a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("style_list")) {
                        iArr[8] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subtitle")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("target")) {
                        iArr[10] = TargetParser.m15665a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("tracking")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("url")) {
                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
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
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }

        public static void m15668a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("media_reference_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("source");
                SourceParser.m15650a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("style_infos");
                StyleInfosParser.m15652a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("style_list");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 8), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("subtitle");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("target");
                TargetParser.m15666a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("tracking");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
            }
            jsonGenerator.g();
        }
    }
}
