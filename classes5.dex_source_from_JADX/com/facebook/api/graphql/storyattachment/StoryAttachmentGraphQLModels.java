package com.facebook.api.graphql.storyattachment;

import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLInterfaces.NewsFeedDefaultsPlaceFieldsWithoutMedia;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLModels.NewsFeedDefaultsPlaceFieldsWithoutMediaModel.CityModel;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLModels.NewsFeedDefaultsPlaceFieldsWithoutMediaModel.OverallStarRatingModel;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLModels.NewsFeedDefaultsPlaceFieldsWithoutMediaModel.PageVisitsModel;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLModels.NewsFeedDefaultsPlaceFieldsWithoutMediaModel.ViewerVisitsModel;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.SavableTimelineAppCollectionExtraFieldsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLInterfaces.EventAttachment;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLInterfaces.TravelAttachmentFields;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.AudioAttachmentFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.AudioAttachmentFieldsParser.MusicObjectParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.AudioAttachmentFieldsParser.MusicObjectParser.MusiciansParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.AudioAttachmentFieldsParser.MusicObjectParser.PreviewUrlsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.BusinessLocationAttachmentStyleInfoFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.BusinessLocationAttachmentStyleInfoFieldsParser.BoundingBoxParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CollagePhotoAttachmentStyleInfoFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CommentPlaceInfoAttachmentTargetParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CommentPlaceInfoAttachmentTargetParser.PlaceListItemsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CommentPlaceInfoAttachmentTargetParser.PlaceListItemsParser.NodesParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CommentPlaceInfoPageFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CommentPlaceInfoPageFieldsParser.AddressParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CulturalMomentAttachmentFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CulturalMomentAttachmentFieldsParser.CulturalMomentImageParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CulturalMomentAttachmentFieldsParser.FaviconParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.CulturalMomentVideoParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.EventAttachmentParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.EventAttachmentParser.EventCoverPhotoParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.EventAttachmentParser.EventCoverPhotoParser.PhotoParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.ExternalUrlAttachmentParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.ExternalUrlAttachmentParser.OpenGraphNodeParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.ExternalUrlAttachmentParser.OpenGraphNodeParser.OpenGraphMetadataParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FBMediaQuestionFragmentParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FBMediaQuestionFragmentParser.MediaQuestionOptionOrderParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FBMediaQuestionFragmentParser.MediaQuestionOptionOrderParser.EdgesParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FBMediaQuestionFragmentParser.MediaQuestionOptionOrderParser.EdgesParser.NodeParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FBMediaQuestionFragmentParser.MediaQuestionPhotosParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FundraiserPageAttachmentFragmentParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FundraiserPageAttachmentFragmentParser.CampaignParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FundraiserPageAttachmentFragmentParser.CampaignParser.CharityParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FundraiserPageAttachmentFragmentParser.CampaignParser.CharityParser.PageParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FundraiserPersonToCharityAttachmentFragmentParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FundraiserPersonToCharityAttachmentFragmentParser.DonorsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FundraiserPersonToCharityAttachmentFragmentParser.DonorsParser.NodesParser.ProfilePictureParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.FundraiserPersonToCharityAttachmentFragmentParser.OwnerParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GoodwillThrowbackCardAttachmentComponentParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GoodwillThrowbackCardAttachmentComponentParser.ActionLinksParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GoodwillThrowbackCardAttachmentComponentParser.AdditionalAccentImagesParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GoodwillThrowbackCardAttachmentComponentParser.DataPointsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GoodwillThrowbackCardAttachmentComponentParser.DataPointsParser.NodesParser.IconParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GoodwillThrowbackCardAttachmentComponentParser.DataPointsParser.NodesParser.TextParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GoodwillThrowbackCardAttachmentComponentParser.TitleParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GreetingCardFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GreetingCardFieldsParser.GreetingCardTemplateParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GreetingCardFieldsParser.GreetingCardTemplateParser.TemplateThemesParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GreetingCardFieldsParser.SlidesParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GreetingCardFieldsParser.SlidesParser.NodesParser.PhotosParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GreetingCardFieldsParser.SlidesParser.NodesParser.PhotosParser.PhotosNodesParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GreetingCardFieldsParser.SlidesParser.NodesParser.PhotosParser.PhotosNodesParser.LargeImageParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.GreetingCardFieldsParser.SlidesParser.NodesParser.PhotosParser.PhotosNodesParser.MediumImageParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.InstantArticleFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.InstantArticleFieldsParser.InstantArticleParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.InstantArticleFieldsParser.InstantArticleParser.LatestVersionParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.InstantArticleFieldsParser.InstantArticleParser.LatestVersionParser.FeedCoverConfigParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.LocalAdContextAttachmentStyleInfoFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.LocalAdContextAttachmentStyleInfoFieldsParser.PlaceOpenStatusFormatsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.LocalAdContextAttachmentStyleInfoFieldsParser.PlaceOpenStatusFormatsParser.TimeRangeParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.MessengerContentSubscriptionTargetParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.MessengerContentSubscriptionTargetParser.MessengerContentSubscriptionOptionParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.MultiPlaceMapAttachmentStyleInfoFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.MultiPlaceMapAttachmentStyleInfoFieldsParser.LatLongListParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedDefaultsEventPlaceFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedDefaultsEventPlaceFieldsParser.CityParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedStoryAttachmentTargetExperienceFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedStoryAttachmentTargetExperienceFieldsParser.EmployerParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedStoryAttachmentTargetExperienceFieldsParser.SchoolClassParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedStoryAttachmentTargetExperienceFieldsParser.SchoolParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.NewsFeedStoryAttachmentTargetExperienceFieldsParser.WorkProjectParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.OpenGraphActionAttachmentTargetParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.OpenGraphActionAttachmentTargetParser.PrimaryObjectNodeParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.OpenGraphObjectAttachmentTargetParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.PlaceListAttachmentTargetParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.PlaceListAttachmentTargetParser.ListItemsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.PlaceListAttachmentTargetParser.ListItemsParser.NodesParser.PlaceRecommendationPageParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.PlaceListAttachmentTargetParser.ListItemsParser.NodesParser.RecommendingCommentsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.PlaceListAttachmentTargetParser.ListItemsParser.NodesParser.RecommendingCommentsParser.RecommendingCommentsNodesParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.PlaceListAttachmentTargetParser.NonSpecificPlaceToSearchParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.PlaceListAttachmentTargetParser.NonSpecificPlaceToSearchParser.MapBoundingBoxParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.QuestionOptionTargetParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.QuestionOptionTargetParser.TextWithEntitiesParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.QuestionOptionTargetParser.VotersParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.QuestionTargetParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.QuestionTargetParser.OptionsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.QuoteFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.QuoteFieldsParser.QuoteParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.ReadingAttachmentTargetParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.ReadingAttachmentTargetParser.PageLikersParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SingleSongMusicAttachmentParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SingleSongMusicAttachmentParser.GlobalShareParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SouvenirsFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SouvenirsFieldsParser.MediaElementsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SouvenirsFieldsParser.MediaElementsParser.EdgesParser.NodeParser.SouvenirMediaParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SouvenirsFieldsParser.MediaElementsParser.EdgesParser.NodeParser.SouvenirMediaParser.SouvenirMediaEdgesParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SportsAttachmentFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SportsAttachmentFieldsParser.SportsMatchDataParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SportsAttachmentFieldsParser.SportsMatchDataParser.AwayTeamObjectParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SportsAttachmentFieldsParser.SportsMatchDataParser.HomeTeamObjectParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.SportsTeamParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.StoryAttachmentAppAdLinkTargetParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.StoryAttachmentAppAdLinkTargetParser.RatingParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.ThrowbackMediaAttachmentFieldsParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.ThrowbackMediaAttachmentFieldsParser.AttachmentPropertiesParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.ThrowbackMediaAttachmentFieldsParser.MediaParser;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLParsers.TravelAttachmentFieldsParser;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLModels.InnerApplicationFieldsModel;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLModels.DefaultTextWithEntitiesWithRangesFieldsModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLGreetingCardSlideType;
import com.facebook.graphql.enums.GraphQLMusicType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPlaceOpenStatusType;
import com.facebook.graphql.enums.GraphQLQuestionPollAnswersState;
import com.facebook.graphql.enums.GraphQLQuestionResponseMethod;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSouvenirMediaFieldType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DeprecatedCurrencyQuantityFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLModels.SizeAwareMediaModel;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLParsers.SizeAwareMediaParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: android_place_picker_edit_menu_suggest_edits */
public class StoryAttachmentGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -31815589)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class AudioAttachmentFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f9845d;
        @Nullable
        private MusicObjectModel f9846e;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AudioAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m17186a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AudioAttachmentFieldsParser.m18174a(jsonParser);
                Object audioAttachmentFieldsModel = new AudioAttachmentFieldsModel();
                ((BaseModel) audioAttachmentFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (audioAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) audioAttachmentFieldsModel).a();
                }
                return audioAttachmentFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -98127317)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class MusicObjectModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private List<String> f9837d;
            @Nullable
            private InnerApplicationFieldsModel f9838e;
            @Nullable
            private String f9839f;
            private boolean f9840g;
            @Nullable
            private GraphQLMusicType f9841h;
            @Nullable
            private List<MusiciansModel> f9842i;
            @Nullable
            private String f9843j;
            @Nullable
            private List<PreviewUrlsModel> f9844k;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MusicObjectModel.class, new Deserializer());
                }

                public Object m17187a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MusicObjectParser.m18172a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object musicObjectModel = new MusicObjectModel();
                    ((BaseModel) musicObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (musicObjectModel instanceof Postprocessable) {
                        return ((Postprocessable) musicObjectModel).a();
                    }
                    return musicObjectModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 415735059)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class MusiciansModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f9833d;
                @Nullable
                private String f9834e;
                @Nullable
                private String f9835f;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MusiciansModel.class, new Deserializer());
                    }

                    public Object m17188a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MusiciansParser.m18168b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object musiciansModel = new MusiciansModel();
                        ((BaseModel) musiciansModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (musiciansModel instanceof Postprocessable) {
                            return ((Postprocessable) musiciansModel).a();
                        }
                        return musiciansModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<MusiciansModel> {
                    public final void m17189a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MusiciansModel musiciansModel = (MusiciansModel) obj;
                        if (musiciansModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(musiciansModel.m17193a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            musiciansModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MusiciansParser.m18167a(musiciansModel.w_(), musiciansModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MusiciansModel.class, new Serializer());
                    }
                }

                public MusiciansModel() {
                    super(3);
                }

                @Nullable
                private String m17190j() {
                    this.f9833d = super.a(this.f9833d, 0);
                    return this.f9833d;
                }

                @Nullable
                private String m17191k() {
                    this.f9834e = super.a(this.f9834e, 1);
                    return this.f9834e;
                }

                @Nullable
                private String m17192l() {
                    this.f9835f = super.a(this.f9835f, 2);
                    return this.f9835f;
                }

                @Nullable
                public final String m17195a() {
                    return m17190j();
                }

                public final int jK_() {
                    return -1304042141;
                }

                public final GraphQLVisitableModel m17194a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17193a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17190j());
                    int b2 = flatBufferBuilder.b(m17191k());
                    int b3 = flatBufferBuilder.b(m17192l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2144446797)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class PreviewUrlsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f9836d;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PreviewUrlsModel.class, new Deserializer());
                    }

                    public Object m17196a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PreviewUrlsParser.m18171b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object previewUrlsModel = new PreviewUrlsModel();
                        ((BaseModel) previewUrlsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (previewUrlsModel instanceof Postprocessable) {
                            return ((Postprocessable) previewUrlsModel).a();
                        }
                        return previewUrlsModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<PreviewUrlsModel> {
                    public final void m17197a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PreviewUrlsModel previewUrlsModel = (PreviewUrlsModel) obj;
                        if (previewUrlsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(previewUrlsModel.m17199a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            previewUrlsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PreviewUrlsParser.m18170a(previewUrlsModel.w_(), previewUrlsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PreviewUrlsModel.class, new Serializer());
                    }
                }

                public PreviewUrlsModel() {
                    super(1);
                }

                @Nullable
                private String m17198a() {
                    this.f9836d = super.a(this.f9836d, 0);
                    return this.f9836d;
                }

                public final int jK_() {
                    return 63613878;
                }

                public final GraphQLVisitableModel m17200a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17199a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17198a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<MusicObjectModel> {
                public final void m17201a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MusicObjectModel musicObjectModel = (MusicObjectModel) obj;
                    if (musicObjectModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(musicObjectModel.m17209a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        musicObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MusicObjectParser.m18173a(musicObjectModel.w_(), musicObjectModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MusicObjectModel.class, new Serializer());
                }
            }

            public MusicObjectModel() {
                super(8);
            }

            @Nonnull
            private ImmutableList<String> m17202j() {
                this.f9837d = super.a(this.f9837d, 0);
                return (ImmutableList) this.f9837d;
            }

            @Nullable
            private InnerApplicationFieldsModel m17203k() {
                this.f9838e = (InnerApplicationFieldsModel) super.a(this.f9838e, 1, InnerApplicationFieldsModel.class);
                return this.f9838e;
            }

            @Nullable
            private String m17204l() {
                this.f9839f = super.a(this.f9839f, 2);
                return this.f9839f;
            }

            @Nullable
            private GraphQLMusicType m17205m() {
                this.f9841h = (GraphQLMusicType) super.b(this.f9841h, 4, GraphQLMusicType.class, GraphQLMusicType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9841h;
            }

            @Nonnull
            private ImmutableList<MusiciansModel> m17206n() {
                this.f9842i = super.a(this.f9842i, 5, MusiciansModel.class);
                return (ImmutableList) this.f9842i;
            }

            @Nullable
            private String m17207o() {
                this.f9843j = super.a(this.f9843j, 6);
                return this.f9843j;
            }

            @Nonnull
            private ImmutableList<PreviewUrlsModel> m17208p() {
                this.f9844k = super.a(this.f9844k, 7, PreviewUrlsModel.class);
                return (ImmutableList) this.f9844k;
            }

            @Nullable
            public final String m17211a() {
                return m17204l();
            }

            public final int jK_() {
                return -1304042141;
            }

            public final GraphQLVisitableModel m17210a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                Builder a;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17203k() != null) {
                    InnerApplicationFieldsModel innerApplicationFieldsModel = (InnerApplicationFieldsModel) graphQLModelMutatingVisitor.b(m17203k());
                    if (m17203k() != innerApplicationFieldsModel) {
                        graphQLVisitableModel = (MusicObjectModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9838e = innerApplicationFieldsModel;
                    }
                }
                if (m17206n() != null) {
                    a = ModelHelper.a(m17206n(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        MusicObjectModel musicObjectModel = (MusicObjectModel) ModelHelper.a(graphQLVisitableModel, this);
                        musicObjectModel.f9842i = a.b();
                        graphQLVisitableModel = musicObjectModel;
                    }
                }
                if (m17208p() != null) {
                    a = ModelHelper.a(m17208p(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        musicObjectModel = (MusicObjectModel) ModelHelper.a(graphQLVisitableModel, this);
                        musicObjectModel.f9844k = a.b();
                        graphQLVisitableModel = musicObjectModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17209a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int c = flatBufferBuilder.c(m17202j());
                int a = ModelHelper.a(flatBufferBuilder, m17203k());
                int b = flatBufferBuilder.b(m17204l());
                int a2 = flatBufferBuilder.a(m17205m());
                int a3 = ModelHelper.a(flatBufferBuilder, m17206n());
                int b2 = flatBufferBuilder.b(m17207o());
                int a4 = ModelHelper.a(flatBufferBuilder, m17208p());
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, c);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.a(3, this.f9840g);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, b2);
                flatBufferBuilder.b(7, a4);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17212a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9840g = mutableFlatBuffer.a(i, 3);
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<AudioAttachmentFieldsModel> {
            public final void m17213a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AudioAttachmentFieldsModel audioAttachmentFieldsModel = (AudioAttachmentFieldsModel) obj;
                if (audioAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(audioAttachmentFieldsModel.m17216a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    audioAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = audioAttachmentFieldsModel.w_();
                int u_ = audioAttachmentFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("music_object");
                    MusicObjectParser.m18173a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AudioAttachmentFieldsModel.class, new Serializer());
            }
        }

        public AudioAttachmentFieldsModel() {
            super(2);
        }

        public final void m17219a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m17220a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m17214j() {
            this.f9845d = super.a(this.f9845d, 0);
            return this.f9845d;
        }

        @Nullable
        private MusicObjectModel m17215k() {
            this.f9846e = (MusicObjectModel) super.a(this.f9846e, 1, MusicObjectModel.class);
            return this.f9846e;
        }

        @Nullable
        public final String m17218a() {
            return m17214j();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m17217a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17215k() != null) {
                MusicObjectModel musicObjectModel = (MusicObjectModel) graphQLModelMutatingVisitor.b(m17215k());
                if (m17215k() != musicObjectModel) {
                    graphQLVisitableModel = (AudioAttachmentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9846e = musicObjectModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17216a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17214j());
            int a = ModelHelper.a(flatBufferBuilder, m17215k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 973994074)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class BusinessLocationAttachmentStyleInfoFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BoundingBoxModel f9851d;
        @Nullable
        private String f9852e;
        @Nullable
        private DefaultLocationFieldsModel f9853f;
        @Nullable
        private DefaultImageFieldsModel f9854g;
        @Nullable
        private List<DefaultLocationFieldsModel> f9855h;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1076074038)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class BoundingBoxModel extends BaseModel implements GraphQLVisitableModel {
            private double f9847d;
            private double f9848e;
            private double f9849f;
            private double f9850g;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BoundingBoxModel.class, new Deserializer());
                }

                public Object m17221a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BoundingBoxParser.m18175a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object boundingBoxModel = new BoundingBoxModel();
                    ((BaseModel) boundingBoxModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (boundingBoxModel instanceof Postprocessable) {
                        return ((Postprocessable) boundingBoxModel).a();
                    }
                    return boundingBoxModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<BoundingBoxModel> {
                public final void m17222a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BoundingBoxModel boundingBoxModel = (BoundingBoxModel) obj;
                    if (boundingBoxModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(boundingBoxModel.m17223a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        boundingBoxModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BoundingBoxParser.m18176a(boundingBoxModel.w_(), boundingBoxModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(BoundingBoxModel.class, new Serializer());
                }
            }

            public BoundingBoxModel() {
                super(4);
            }

            public final int jK_() {
                return -2036384450;
            }

            public final GraphQLVisitableModel m17224a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17223a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f9847d, 0.0d);
                flatBufferBuilder.a(1, this.f9848e, 0.0d);
                flatBufferBuilder.a(2, this.f9849f, 0.0d);
                flatBufferBuilder.a(3, this.f9850g, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17225a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9847d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f9848e = mutableFlatBuffer.a(i, 1, 0.0d);
                this.f9849f = mutableFlatBuffer.a(i, 2, 0.0d);
                this.f9850g = mutableFlatBuffer.a(i, 3, 0.0d);
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessLocationAttachmentStyleInfoFieldsModel.class, new Deserializer());
            }

            public Object m17226a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BusinessLocationAttachmentStyleInfoFieldsParser.m18177a(jsonParser);
                Object businessLocationAttachmentStyleInfoFieldsModel = new BusinessLocationAttachmentStyleInfoFieldsModel();
                ((BaseModel) businessLocationAttachmentStyleInfoFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (businessLocationAttachmentStyleInfoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) businessLocationAttachmentStyleInfoFieldsModel).a();
                }
                return businessLocationAttachmentStyleInfoFieldsModel;
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<BusinessLocationAttachmentStyleInfoFieldsModel> {
            public final void m17227a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BusinessLocationAttachmentStyleInfoFieldsModel businessLocationAttachmentStyleInfoFieldsModel = (BusinessLocationAttachmentStyleInfoFieldsModel) obj;
                if (businessLocationAttachmentStyleInfoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessLocationAttachmentStyleInfoFieldsModel.m17233a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessLocationAttachmentStyleInfoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = businessLocationAttachmentStyleInfoFieldsModel.w_();
                int u_ = businessLocationAttachmentStyleInfoFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("bounding_box");
                    BoundingBoxParser.m18176a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("label");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("location");
                    DefaultLocationFieldsParser.m9761a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("logo");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("nearby_locations");
                    DefaultLocationFieldsParser.m9762a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BusinessLocationAttachmentStyleInfoFieldsModel.class, new Serializer());
            }
        }

        public BusinessLocationAttachmentStyleInfoFieldsModel() {
            super(5);
        }

        @Nullable
        private BoundingBoxModel m17228a() {
            this.f9851d = (BoundingBoxModel) super.a(this.f9851d, 0, BoundingBoxModel.class);
            return this.f9851d;
        }

        @Nullable
        private String m17229j() {
            this.f9852e = super.a(this.f9852e, 1);
            return this.f9852e;
        }

        @Nullable
        private DefaultLocationFieldsModel m17230k() {
            this.f9853f = (DefaultLocationFieldsModel) super.a(this.f9853f, 2, DefaultLocationFieldsModel.class);
            return this.f9853f;
        }

        @Nullable
        private DefaultImageFieldsModel m17231l() {
            this.f9854g = (DefaultImageFieldsModel) super.a(this.f9854g, 3, DefaultImageFieldsModel.class);
            return this.f9854g;
        }

        @Nonnull
        private ImmutableList<DefaultLocationFieldsModel> m17232m() {
            this.f9855h = super.a(this.f9855h, 4, DefaultLocationFieldsModel.class);
            return (ImmutableList) this.f9855h;
        }

        public final int jK_() {
            return 13420071;
        }

        public final GraphQLVisitableModel m17234a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17228a() != null) {
                BoundingBoxModel boundingBoxModel = (BoundingBoxModel) graphQLModelMutatingVisitor.b(m17228a());
                if (m17228a() != boundingBoxModel) {
                    graphQLVisitableModel = (BusinessLocationAttachmentStyleInfoFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9851d = boundingBoxModel;
                }
            }
            if (m17230k() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m17230k());
                if (m17230k() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (BusinessLocationAttachmentStyleInfoFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9853f = defaultLocationFieldsModel;
                }
            }
            if (m17231l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m17231l());
                if (m17231l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (BusinessLocationAttachmentStyleInfoFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9854g = defaultImageFieldsModel;
                }
            }
            if (m17232m() != null) {
                Builder a = ModelHelper.a(m17232m(), graphQLModelMutatingVisitor);
                if (a != null) {
                    BusinessLocationAttachmentStyleInfoFieldsModel businessLocationAttachmentStyleInfoFieldsModel = (BusinessLocationAttachmentStyleInfoFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    businessLocationAttachmentStyleInfoFieldsModel.f9855h = a.b();
                    graphQLVisitableModel = businessLocationAttachmentStyleInfoFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17233a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17228a());
            int b = flatBufferBuilder.b(m17229j());
            int a2 = ModelHelper.a(flatBufferBuilder, m17230k());
            int a3 = ModelHelper.a(flatBufferBuilder, m17231l());
            int a4 = ModelHelper.a(flatBufferBuilder, m17232m());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -954115762)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class CollagePhotoAttachmentStyleInfoFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f9856d;
        private int f9857e;
        private int f9858f;
        private int f9859g;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollagePhotoAttachmentStyleInfoFieldsModel.class, new Deserializer());
            }

            public Object m17235a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollagePhotoAttachmentStyleInfoFieldsParser.m18180b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collagePhotoAttachmentStyleInfoFieldsModel = new CollagePhotoAttachmentStyleInfoFieldsModel();
                ((BaseModel) collagePhotoAttachmentStyleInfoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collagePhotoAttachmentStyleInfoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) collagePhotoAttachmentStyleInfoFieldsModel).a();
                }
                return collagePhotoAttachmentStyleInfoFieldsModel;
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<CollagePhotoAttachmentStyleInfoFieldsModel> {
            public final void m17236a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollagePhotoAttachmentStyleInfoFieldsModel collagePhotoAttachmentStyleInfoFieldsModel = (CollagePhotoAttachmentStyleInfoFieldsModel) obj;
                if (collagePhotoAttachmentStyleInfoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collagePhotoAttachmentStyleInfoFieldsModel.m17237a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collagePhotoAttachmentStyleInfoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollagePhotoAttachmentStyleInfoFieldsParser.m18179a(collagePhotoAttachmentStyleInfoFieldsModel.w_(), collagePhotoAttachmentStyleInfoFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(CollagePhotoAttachmentStyleInfoFieldsModel.class, new Serializer());
            }
        }

        public CollagePhotoAttachmentStyleInfoFieldsModel() {
            super(4);
        }

        public final int jK_() {
            return -1157537251;
        }

        public final GraphQLVisitableModel m17238a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m17237a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f9856d, 0);
            flatBufferBuilder.a(1, this.f9857e, 0);
            flatBufferBuilder.a(2, this.f9858f, 0);
            flatBufferBuilder.a(3, this.f9859g, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17239a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9856d = mutableFlatBuffer.a(i, 0, 0);
            this.f9857e = mutableFlatBuffer.a(i, 1, 0);
            this.f9858f = mutableFlatBuffer.a(i, 2, 0);
            this.f9859g = mutableFlatBuffer.a(i, 3, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1884074176)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class CommentPlaceInfoAttachmentTargetModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f9862d;
        @Nullable
        private List<CommentPlaceInfoPageFieldsModel> f9863e;
        @Nullable
        private PlaceListItemsModel f9864f;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommentPlaceInfoAttachmentTargetModel.class, new Deserializer());
            }

            public Object m17240a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommentPlaceInfoAttachmentTargetParser.m18185a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commentPlaceInfoAttachmentTargetModel = new CommentPlaceInfoAttachmentTargetModel();
                ((BaseModel) commentPlaceInfoAttachmentTargetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commentPlaceInfoAttachmentTargetModel instanceof Postprocessable) {
                    return ((Postprocessable) commentPlaceInfoAttachmentTargetModel).a();
                }
                return commentPlaceInfoAttachmentTargetModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1931564419)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class PlaceListItemsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f9861d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceListItemsModel.class, new Deserializer());
                }

                public Object m17241a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceListItemsParser.m18183a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeListItemsModel = new PlaceListItemsModel();
                    ((BaseModel) placeListItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeListItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) placeListItemsModel).a();
                    }
                    return placeListItemsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1705788018)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private CommentPlaceInfoPageFieldsModel f9860d;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m17242a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m18181b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m17243a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m17244a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m18182b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                @Nullable
                public final CommentPlaceInfoPageFieldsModel m17245a() {
                    this.f9860d = (CommentPlaceInfoPageFieldsModel) super.a(this.f9860d, 0, CommentPlaceInfoPageFieldsModel.class);
                    return this.f9860d;
                }

                public final int jK_() {
                    return 2113705688;
                }

                public final GraphQLVisitableModel m17246a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17245a() != null) {
                        CommentPlaceInfoPageFieldsModel commentPlaceInfoPageFieldsModel = (CommentPlaceInfoPageFieldsModel) graphQLModelMutatingVisitor.b(m17245a());
                        if (m17245a() != commentPlaceInfoPageFieldsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9860d = commentPlaceInfoPageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17244a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17245a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<PlaceListItemsModel> {
                public final void m17247a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceListItemsModel placeListItemsModel = (PlaceListItemsModel) obj;
                    if (placeListItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeListItemsModel.m17248a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeListItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceListItemsParser.m18184a(placeListItemsModel.w_(), placeListItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PlaceListItemsModel.class, new Serializer());
                }
            }

            public PlaceListItemsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m17250a() {
                this.f9861d = super.a(this.f9861d, 0, NodesModel.class);
                return (ImmutableList) this.f9861d;
            }

            public final int jK_() {
                return 951323338;
            }

            public final GraphQLVisitableModel m17249a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17250a() != null) {
                    Builder a = ModelHelper.a(m17250a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PlaceListItemsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9861d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17248a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17250a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<CommentPlaceInfoAttachmentTargetModel> {
            public final void m17251a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommentPlaceInfoAttachmentTargetModel commentPlaceInfoAttachmentTargetModel = (CommentPlaceInfoAttachmentTargetModel) obj;
                if (commentPlaceInfoAttachmentTargetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commentPlaceInfoAttachmentTargetModel.m17254a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commentPlaceInfoAttachmentTargetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commentPlaceInfoAttachmentTargetModel.w_();
                int u_ = commentPlaceInfoAttachmentTargetModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_edit_attachment");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("pending_places_for_attachment");
                    CommentPlaceInfoPageFieldsParser.m18189a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("place_list_items");
                    PlaceListItemsParser.m18184a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommentPlaceInfoAttachmentTargetModel.class, new Serializer());
            }
        }

        public CommentPlaceInfoAttachmentTargetModel() {
            super(3);
        }

        @Nonnull
        private ImmutableList<CommentPlaceInfoPageFieldsModel> m17252a() {
            this.f9863e = super.a(this.f9863e, 1, CommentPlaceInfoPageFieldsModel.class);
            return (ImmutableList) this.f9863e;
        }

        @Nullable
        private PlaceListItemsModel m17253j() {
            this.f9864f = (PlaceListItemsModel) super.a(this.f9864f, 2, PlaceListItemsModel.class);
            return this.f9864f;
        }

        public final int jK_() {
            return 1332414166;
        }

        public final GraphQLVisitableModel m17255a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            PlaceListItemsModel placeListItemsModel;
            h();
            if (m17252a() != null) {
                Builder a = ModelHelper.a(m17252a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    CommentPlaceInfoAttachmentTargetModel commentPlaceInfoAttachmentTargetModel = (CommentPlaceInfoAttachmentTargetModel) ModelHelper.a(null, this);
                    commentPlaceInfoAttachmentTargetModel.f9863e = a.b();
                    graphQLVisitableModel = commentPlaceInfoAttachmentTargetModel;
                    if (m17253j() != null) {
                        placeListItemsModel = (PlaceListItemsModel) graphQLModelMutatingVisitor.b(m17253j());
                        if (m17253j() != placeListItemsModel) {
                            graphQLVisitableModel = (CommentPlaceInfoAttachmentTargetModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9864f = placeListItemsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m17253j() != null) {
                placeListItemsModel = (PlaceListItemsModel) graphQLModelMutatingVisitor.b(m17253j());
                if (m17253j() != placeListItemsModel) {
                    graphQLVisitableModel = (CommentPlaceInfoAttachmentTargetModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9864f = placeListItemsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m17254a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17252a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17253j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f9862d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17256a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9862d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 146355291)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class CommentPlaceInfoPageFieldsModel extends BaseModel implements NewsFeedDefaultsPlaceFieldsWithoutMedia, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f9866d;
        @Nullable
        private AddressModel f9867e;
        @Nullable
        private List<String> f9868f;
        @Nullable
        private CityModel f9869g;
        @Nullable
        private String f9870h;
        private boolean f9871i;
        @Nullable
        private DefaultLocationFieldsModel f9872j;
        @Nullable
        private String f9873k;
        @Nullable
        private OverallStarRatingModel f9874l;
        @Nullable
        private PageVisitsModel f9875m;
        @Nullable
        private String f9876n;
        @Nullable
        private DefaultImageFieldsModel f9877o;
        private boolean f9878p;
        @Nullable
        private SavableTimelineAppCollectionExtraFieldsModel f9879q;
        private boolean f9880r;
        @Nullable
        private GraphQLPageSuperCategoryType f9881s;
        @Nullable
        private String f9882t;
        @Nullable
        private GraphQLSavedState f9883u;
        @Nullable
        private ViewerVisitsModel f9884v;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2110849367)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9865d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                }

                public Object m17257a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AddressParser.m18186a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object addressModel = new AddressModel();
                    ((BaseModel) addressModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (addressModel instanceof Postprocessable) {
                        return ((Postprocessable) addressModel).a();
                    }
                    return addressModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<AddressModel> {
                public final void m17258a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddressModel addressModel = (AddressModel) obj;
                    if (addressModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addressModel.m17259a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AddressParser.m18187a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AddressModel.class, new Serializer());
                }
            }

            public AddressModel() {
                super(1);
            }

            @Nullable
            public final String m17261a() {
                this.f9865d = super.a(this.f9865d, 0);
                return this.f9865d;
            }

            public final int jK_() {
                return 799251025;
            }

            public final GraphQLVisitableModel m17260a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17259a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17261a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommentPlaceInfoPageFieldsModel.class, new Deserializer());
            }

            public Object m17262a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommentPlaceInfoPageFieldsParser.m18188a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commentPlaceInfoPageFieldsModel = new CommentPlaceInfoPageFieldsModel();
                ((BaseModel) commentPlaceInfoPageFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commentPlaceInfoPageFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) commentPlaceInfoPageFieldsModel).a();
                }
                return commentPlaceInfoPageFieldsModel;
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<CommentPlaceInfoPageFieldsModel> {
            public final void m17263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommentPlaceInfoPageFieldsModel commentPlaceInfoPageFieldsModel = (CommentPlaceInfoPageFieldsModel) obj;
                if (commentPlaceInfoPageFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commentPlaceInfoPageFieldsModel.m17273a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commentPlaceInfoPageFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommentPlaceInfoPageFieldsParser.m18191b(commentPlaceInfoPageFieldsModel.w_(), commentPlaceInfoPageFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommentPlaceInfoPageFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AddressModel m17279b() {
            return m17268v();
        }

        @Nullable
        public final /* synthetic */ DefaultLocationFields bs_() {
            return m17270x();
        }

        @Nullable
        public final /* synthetic */ CityModel m17281d() {
            return m17269w();
        }

        @Nullable
        public final /* synthetic */ OverallStarRatingModel m17283j() {
            return m17271y();
        }

        @Nullable
        public final /* synthetic */ PageVisitsModel m17284k() {
            return m17272z();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m17286m() {
            return m17264A();
        }

        @Nullable
        public final /* synthetic */ SavableTimelineAppCollectionExtraFieldsModel m17288o() {
            return m17265B();
        }

        @Nullable
        public final /* synthetic */ ViewerVisitsModel m17293t() {
            return m17266C();
        }

        public CommentPlaceInfoPageFieldsModel() {
            super(19);
        }

        public final void m17277a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m17278a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m17267u() {
            if (this.b != null && this.f9866d == null) {
                this.f9866d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9866d;
        }

        @Nullable
        private AddressModel m17268v() {
            this.f9867e = (AddressModel) super.a(this.f9867e, 1, AddressModel.class);
            return this.f9867e;
        }

        @Nonnull
        public final ImmutableList<String> m17280c() {
            this.f9868f = super.a(this.f9868f, 2);
            return (ImmutableList) this.f9868f;
        }

        @Nullable
        private CityModel m17269w() {
            this.f9869g = (CityModel) super.a(this.f9869g, 3, CityModel.class);
            return this.f9869g;
        }

        @Nullable
        public final String bq_() {
            this.f9870h = super.a(this.f9870h, 4);
            return this.f9870h;
        }

        public final boolean m17282g() {
            a(0, 5);
            return this.f9871i;
        }

        @Nullable
        private DefaultLocationFieldsModel m17270x() {
            this.f9872j = (DefaultLocationFieldsModel) super.a(this.f9872j, 6, DefaultLocationFieldsModel.class);
            return this.f9872j;
        }

        @Nullable
        public final String br_() {
            this.f9873k = super.a(this.f9873k, 7);
            return this.f9873k;
        }

        @Nullable
        private OverallStarRatingModel m17271y() {
            this.f9874l = (OverallStarRatingModel) super.a(this.f9874l, 8, OverallStarRatingModel.class);
            return this.f9874l;
        }

        @Nullable
        private PageVisitsModel m17272z() {
            this.f9875m = (PageVisitsModel) super.a(this.f9875m, 9, PageVisitsModel.class);
            return this.f9875m;
        }

        @Nullable
        public final String m17285l() {
            this.f9876n = super.a(this.f9876n, 10);
            return this.f9876n;
        }

        @Nullable
        private DefaultImageFieldsModel m17264A() {
            this.f9877o = (DefaultImageFieldsModel) super.a(this.f9877o, 11, DefaultImageFieldsModel.class);
            return this.f9877o;
        }

        public final boolean m17287n() {
            a(1, 4);
            return this.f9878p;
        }

        @Nullable
        private SavableTimelineAppCollectionExtraFieldsModel m17265B() {
            this.f9879q = (SavableTimelineAppCollectionExtraFieldsModel) super.a(this.f9879q, 13, SavableTimelineAppCollectionExtraFieldsModel.class);
            return this.f9879q;
        }

        public final boolean m17289p() {
            a(1, 6);
            return this.f9880r;
        }

        @Nullable
        public final GraphQLPageSuperCategoryType m17290q() {
            this.f9881s = (GraphQLPageSuperCategoryType) super.b(this.f9881s, 15, GraphQLPageSuperCategoryType.class, GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9881s;
        }

        @Nullable
        public final String m17291r() {
            this.f9882t = super.a(this.f9882t, 16);
            return this.f9882t;
        }

        @Nullable
        public final GraphQLSavedState m17292s() {
            this.f9883u = (GraphQLSavedState) super.b(this.f9883u, 17, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9883u;
        }

        @Nullable
        private ViewerVisitsModel m17266C() {
            this.f9884v = (ViewerVisitsModel) super.a(this.f9884v, 18, ViewerVisitsModel.class);
            return this.f9884v;
        }

        @Nullable
        public final String m17275a() {
            return bq_();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m17274a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17268v() != null) {
                AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m17268v());
                if (m17268v() != addressModel) {
                    graphQLVisitableModel = (CommentPlaceInfoPageFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9867e = addressModel;
                }
            }
            if (m17269w() != null) {
                CityModel cityModel = (CityModel) graphQLModelMutatingVisitor.b(m17269w());
                if (m17269w() != cityModel) {
                    graphQLVisitableModel = (CommentPlaceInfoPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9869g = cityModel;
                }
            }
            if (m17270x() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m17270x());
                if (m17270x() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (CommentPlaceInfoPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9872j = defaultLocationFieldsModel;
                }
            }
            if (m17271y() != null) {
                OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m17271y());
                if (m17271y() != overallStarRatingModel) {
                    graphQLVisitableModel = (CommentPlaceInfoPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9874l = overallStarRatingModel;
                }
            }
            if (m17272z() != null) {
                PageVisitsModel pageVisitsModel = (PageVisitsModel) graphQLModelMutatingVisitor.b(m17272z());
                if (m17272z() != pageVisitsModel) {
                    graphQLVisitableModel = (CommentPlaceInfoPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9875m = pageVisitsModel;
                }
            }
            if (m17264A() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m17264A());
                if (m17264A() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (CommentPlaceInfoPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9877o = defaultImageFieldsModel;
                }
            }
            if (m17265B() != null) {
                SavableTimelineAppCollectionExtraFieldsModel savableTimelineAppCollectionExtraFieldsModel = (SavableTimelineAppCollectionExtraFieldsModel) graphQLModelMutatingVisitor.b(m17265B());
                if (m17265B() != savableTimelineAppCollectionExtraFieldsModel) {
                    graphQLVisitableModel = (CommentPlaceInfoPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9879q = savableTimelineAppCollectionExtraFieldsModel;
                }
            }
            if (m17266C() != null) {
                ViewerVisitsModel viewerVisitsModel = (ViewerVisitsModel) graphQLModelMutatingVisitor.b(m17266C());
                if (m17266C() != viewerVisitsModel) {
                    graphQLVisitableModel = (CommentPlaceInfoPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9884v = viewerVisitsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17273a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17267u());
            int a2 = ModelHelper.a(flatBufferBuilder, m17268v());
            int c = flatBufferBuilder.c(m17280c());
            int a3 = ModelHelper.a(flatBufferBuilder, m17269w());
            int b = flatBufferBuilder.b(bq_());
            int a4 = ModelHelper.a(flatBufferBuilder, m17270x());
            int b2 = flatBufferBuilder.b(br_());
            int a5 = ModelHelper.a(flatBufferBuilder, m17271y());
            int a6 = ModelHelper.a(flatBufferBuilder, m17272z());
            int b3 = flatBufferBuilder.b(m17285l());
            int a7 = ModelHelper.a(flatBufferBuilder, m17264A());
            int a8 = ModelHelper.a(flatBufferBuilder, m17265B());
            int a9 = flatBufferBuilder.a(m17290q());
            int b4 = flatBufferBuilder.b(m17291r());
            int a10 = flatBufferBuilder.a(m17292s());
            int a11 = ModelHelper.a(flatBufferBuilder, m17266C());
            flatBufferBuilder.c(19);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, c);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.a(5, this.f9871i);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, a5);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.b(10, b3);
            flatBufferBuilder.b(11, a7);
            flatBufferBuilder.a(12, this.f9878p);
            flatBufferBuilder.b(13, a8);
            flatBufferBuilder.a(14, this.f9880r);
            flatBufferBuilder.b(15, a9);
            flatBufferBuilder.b(16, b4);
            flatBufferBuilder.b(17, a10);
            flatBufferBuilder.b(18, a11);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17276a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9871i = mutableFlatBuffer.a(i, 5);
            this.f9878p = mutableFlatBuffer.a(i, 12);
            this.f9880r = mutableFlatBuffer.a(i, 14);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 76622243)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class CulturalMomentAttachmentFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CulturalMomentImageModel f9893d;
        @Nullable
        private CulturalMomentVideoModel f9894e;
        @Nullable
        private FaviconModel f9895f;
        @Nullable
        private String f9896g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -142592207)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class CulturalMomentImageModel extends BaseModel implements GraphQLVisitableModel {
            private int f9885d;
            private double f9886e;
            @Nullable
            private String f9887f;
            private int f9888g;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CulturalMomentImageModel.class, new Deserializer());
                }

                public Object m17294a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CulturalMomentImageParser.m18192a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object culturalMomentImageModel = new CulturalMomentImageModel();
                    ((BaseModel) culturalMomentImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (culturalMomentImageModel instanceof Postprocessable) {
                        return ((Postprocessable) culturalMomentImageModel).a();
                    }
                    return culturalMomentImageModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<CulturalMomentImageModel> {
                public final void m17295a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CulturalMomentImageModel culturalMomentImageModel = (CulturalMomentImageModel) obj;
                    if (culturalMomentImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(culturalMomentImageModel.m17297a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        culturalMomentImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CulturalMomentImageParser.m18193a(culturalMomentImageModel.w_(), culturalMomentImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CulturalMomentImageModel.class, new Serializer());
                }
            }

            public CulturalMomentImageModel() {
                super(4);
            }

            @Nullable
            private String m17296a() {
                this.f9887f = super.a(this.f9887f, 2);
                return this.f9887f;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m17298a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17297a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17296a());
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f9885d, 0);
                flatBufferBuilder.a(1, this.f9886e, 0.0d);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.a(3, this.f9888g, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17299a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9885d = mutableFlatBuffer.a(i, 0, 0);
                this.f9886e = mutableFlatBuffer.a(i, 1, 0.0d);
                this.f9888g = mutableFlatBuffer.a(i, 3, 0);
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CulturalMomentAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m17300a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CulturalMomentAttachmentFieldsParser.m18196a(jsonParser);
                Object culturalMomentAttachmentFieldsModel = new CulturalMomentAttachmentFieldsModel();
                ((BaseModel) culturalMomentAttachmentFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (culturalMomentAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) culturalMomentAttachmentFieldsModel).a();
                }
                return culturalMomentAttachmentFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -142592207)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class FaviconModel extends BaseModel implements GraphQLVisitableModel {
            private int f9889d;
            private double f9890e;
            @Nullable
            private String f9891f;
            private int f9892g;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FaviconModel.class, new Deserializer());
                }

                public Object m17301a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FaviconParser.m18194a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object faviconModel = new FaviconModel();
                    ((BaseModel) faviconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (faviconModel instanceof Postprocessable) {
                        return ((Postprocessable) faviconModel).a();
                    }
                    return faviconModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<FaviconModel> {
                public final void m17302a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FaviconModel faviconModel = (FaviconModel) obj;
                    if (faviconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(faviconModel.m17304a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        faviconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FaviconParser.m18195a(faviconModel.w_(), faviconModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FaviconModel.class, new Serializer());
                }
            }

            public FaviconModel() {
                super(4);
            }

            @Nullable
            private String m17303a() {
                this.f9891f = super.a(this.f9891f, 2);
                return this.f9891f;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m17305a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17304a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17303a());
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f9889d, 0);
                flatBufferBuilder.a(1, this.f9890e, 0.0d);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.a(3, this.f9892g, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17306a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9889d = mutableFlatBuffer.a(i, 0, 0);
                this.f9890e = mutableFlatBuffer.a(i, 1, 0.0d);
                this.f9892g = mutableFlatBuffer.a(i, 3, 0);
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<CulturalMomentAttachmentFieldsModel> {
            public final void m17307a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CulturalMomentAttachmentFieldsModel culturalMomentAttachmentFieldsModel = (CulturalMomentAttachmentFieldsModel) obj;
                if (culturalMomentAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(culturalMomentAttachmentFieldsModel.m17312a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    culturalMomentAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = culturalMomentAttachmentFieldsModel.w_();
                int u_ = culturalMomentAttachmentFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("cultural_moment_image");
                    CulturalMomentImageParser.m18193a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("cultural_moment_video");
                    CulturalMomentVideoParser.m18198a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("favicon");
                    FaviconParser.m18195a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("image_margin");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CulturalMomentAttachmentFieldsModel.class, new Serializer());
            }
        }

        public CulturalMomentAttachmentFieldsModel() {
            super(4);
        }

        @Nullable
        private CulturalMomentImageModel m17308a() {
            this.f9893d = (CulturalMomentImageModel) super.a(this.f9893d, 0, CulturalMomentImageModel.class);
            return this.f9893d;
        }

        @Nullable
        private CulturalMomentVideoModel m17309j() {
            this.f9894e = (CulturalMomentVideoModel) super.a(this.f9894e, 1, CulturalMomentVideoModel.class);
            return this.f9894e;
        }

        @Nullable
        private FaviconModel m17310k() {
            this.f9895f = (FaviconModel) super.a(this.f9895f, 2, FaviconModel.class);
            return this.f9895f;
        }

        @Nullable
        private String m17311l() {
            this.f9896g = super.a(this.f9896g, 3);
            return this.f9896g;
        }

        public final int jK_() {
            return -1196289854;
        }

        public final GraphQLVisitableModel m17313a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17308a() != null) {
                CulturalMomentImageModel culturalMomentImageModel = (CulturalMomentImageModel) graphQLModelMutatingVisitor.b(m17308a());
                if (m17308a() != culturalMomentImageModel) {
                    graphQLVisitableModel = (CulturalMomentAttachmentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9893d = culturalMomentImageModel;
                }
            }
            if (m17309j() != null) {
                CulturalMomentVideoModel culturalMomentVideoModel = (CulturalMomentVideoModel) graphQLModelMutatingVisitor.b(m17309j());
                if (m17309j() != culturalMomentVideoModel) {
                    graphQLVisitableModel = (CulturalMomentAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9894e = culturalMomentVideoModel;
                }
            }
            if (m17310k() != null) {
                FaviconModel faviconModel = (FaviconModel) graphQLModelMutatingVisitor.b(m17310k());
                if (m17310k() != faviconModel) {
                    graphQLVisitableModel = (CulturalMomentAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9895f = faviconModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17312a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17308a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17309j());
            int a3 = ModelHelper.a(flatBufferBuilder, m17310k());
            int b = flatBufferBuilder.b(m17311l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 807964639)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class CulturalMomentVideoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private int f9897d;
        @Nullable
        private String f9898e;
        @Nullable
        private DefaultImageFieldsModel f9899f;
        private boolean f9900g;
        @Nullable
        private String f9901h;
        private int f9902i;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CulturalMomentVideoModel.class, new Deserializer());
            }

            public Object m17314a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CulturalMomentVideoParser.m18197a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object culturalMomentVideoModel = new CulturalMomentVideoModel();
                ((BaseModel) culturalMomentVideoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (culturalMomentVideoModel instanceof Postprocessable) {
                    return ((Postprocessable) culturalMomentVideoModel).a();
                }
                return culturalMomentVideoModel;
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<CulturalMomentVideoModel> {
            public final void m17315a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CulturalMomentVideoModel culturalMomentVideoModel = (CulturalMomentVideoModel) obj;
                if (culturalMomentVideoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(culturalMomentVideoModel.m17319a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    culturalMomentVideoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CulturalMomentVideoParser.m18198a(culturalMomentVideoModel.w_(), culturalMomentVideoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CulturalMomentVideoModel.class, new Serializer());
            }
        }

        public CulturalMomentVideoModel() {
            super(6);
        }

        @Nullable
        private String m17316j() {
            this.f9898e = super.a(this.f9898e, 1);
            return this.f9898e;
        }

        @Nullable
        private DefaultImageFieldsModel m17317k() {
            this.f9899f = (DefaultImageFieldsModel) super.a(this.f9899f, 2, DefaultImageFieldsModel.class);
            return this.f9899f;
        }

        @Nullable
        private String m17318l() {
            this.f9901h = super.a(this.f9901h, 4);
            return this.f9901h;
        }

        @Nullable
        public final String m17321a() {
            return m17316j();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m17320a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17317k() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m17317k());
                if (m17317k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (CulturalMomentVideoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9899f = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17319a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17316j());
            int a = ModelHelper.a(flatBufferBuilder, m17317k());
            int b2 = flatBufferBuilder.b(m17318l());
            flatBufferBuilder.c(6);
            flatBufferBuilder.a(0, this.f9897d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.a(3, this.f9900g);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.a(5, this.f9902i, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17322a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9897d = mutableFlatBuffer.a(i, 0, 0);
            this.f9900g = mutableFlatBuffer.a(i, 3);
            this.f9902i = mutableFlatBuffer.a(i, 5, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -923568650)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class EventAttachmentModel extends BaseModel implements EventAttachment, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f9908d;
        @Nullable
        private GraphQLConnectionStyle f9909e;
        private long f9910f;
        @Nullable
        private EventCoverPhotoModel f9911g;
        @Nullable
        private NewsFeedDefaultsEventPlaceFieldsModel f9912h;
        @Nullable
        private String f9913i;
        private boolean f9914j;
        @Nullable
        private String f9915k;
        private long f9916l;
        @Nullable
        private String f9917m;
        @Nullable
        private String f9918n;
        @Nullable
        private GraphQLEventGuestStatus f9919o;
        private boolean f9920p;
        @Nullable
        private GraphQLEventWatchStatus f9921q;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventAttachmentModel.class, new Deserializer());
            }

            public Object m17323a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EventAttachmentParser.m18203a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object eventAttachmentModel = new EventAttachmentModel();
                ((BaseModel) eventAttachmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (eventAttachmentModel instanceof Postprocessable) {
                    return ((Postprocessable) eventAttachmentModel).a();
                }
                return eventAttachmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 955899231)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class EventCoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhotoModel f9907d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventCoverPhotoModel.class, new Deserializer());
                }

                public Object m17324a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventCoverPhotoParser.m18201a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventCoverPhotoModel = new EventCoverPhotoModel();
                    ((BaseModel) eventCoverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventCoverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) eventCoverPhotoModel).a();
                    }
                    return eventCoverPhotoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1974396147)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class PhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f9903d;
                @Nullable
                private DefaultImageFieldsModel f9904e;
                @Nullable
                private DefaultTextWithEntitiesFieldsModel f9905f;
                @Nullable
                private String f9906g;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m17325a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoParser.m18199a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object photoModel = new PhotoModel();
                        ((BaseModel) photoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (photoModel instanceof Postprocessable) {
                            return ((Postprocessable) photoModel).a();
                        }
                        return photoModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m17326a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) obj;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m17329a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoParser.m18200a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ DefaultImageFields m17333c() {
                    return m17327j();
                }

                @Nullable
                public final /* synthetic */ DefaultTextWithEntitiesFields m17334d() {
                    return m17328k();
                }

                public PhotoModel() {
                    super(4);
                }

                @Nullable
                public final String m17332b() {
                    this.f9903d = super.a(this.f9903d, 0);
                    return this.f9903d;
                }

                @Nullable
                private DefaultImageFieldsModel m17327j() {
                    this.f9904e = (DefaultImageFieldsModel) super.a(this.f9904e, 1, DefaultImageFieldsModel.class);
                    return this.f9904e;
                }

                @Nullable
                private DefaultTextWithEntitiesFieldsModel m17328k() {
                    this.f9905f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f9905f, 2, DefaultTextWithEntitiesFieldsModel.class);
                    return this.f9905f;
                }

                @Nullable
                public final String bw_() {
                    this.f9906g = super.a(this.f9906g, 3);
                    return this.f9906g;
                }

                @Nullable
                public final String m17331a() {
                    return m17332b();
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m17330a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17327j() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m17327j());
                        if (m17327j() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9904e = defaultImageFieldsModel;
                        }
                    }
                    if (m17328k() != null) {
                        DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m17328k());
                        if (m17328k() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9905f = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17329a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17332b());
                    int a = ModelHelper.a(flatBufferBuilder, m17327j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m17328k());
                    int b2 = flatBufferBuilder.b(bw_());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<EventCoverPhotoModel> {
                public final void m17335a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventCoverPhotoModel eventCoverPhotoModel = (EventCoverPhotoModel) obj;
                    if (eventCoverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventCoverPhotoModel.m17337a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventCoverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventCoverPhotoParser.m18202a(eventCoverPhotoModel.w_(), eventCoverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EventCoverPhotoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PhotoModel m17338a() {
                return m17336j();
            }

            public EventCoverPhotoModel() {
                super(1);
            }

            @Nullable
            private PhotoModel m17336j() {
                this.f9907d = (PhotoModel) super.a(this.f9907d, 0, PhotoModel.class);
                return this.f9907d;
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m17339a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17336j() != null) {
                    PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m17336j());
                    if (m17336j() != photoModel) {
                        graphQLVisitableModel = (EventCoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9907d = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17337a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17336j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<EventAttachmentModel> {
            public final void m17340a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                EventAttachmentModel eventAttachmentModel = (EventAttachmentModel) obj;
                if (eventAttachmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventAttachmentModel.m17347a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventAttachmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                EventAttachmentParser.m18204a(eventAttachmentModel.w_(), eventAttachmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(EventAttachmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ EventCoverPhotoModel bv_() {
            return m17345q();
        }

        @Nullable
        public final /* synthetic */ NewsFeedDefaultsEventPlaceFieldsModel mo1103g() {
            return m17346r();
        }

        public EventAttachmentModel() {
            super(14);
        }

        public final void m17351a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = mo1104j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 7;
            } else if ("viewer_guest_status".equals(str)) {
                consistencyTuple.a = mo1108n();
                consistencyTuple.b = u_();
                consistencyTuple.c = 11;
            } else if ("viewer_has_pending_invite".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(mo1109o());
                consistencyTuple.b = u_();
                consistencyTuple.c = 12;
            } else if ("viewer_watch_status".equals(str)) {
                consistencyTuple.a = mo1110p();
                consistencyTuple.b = u_();
                consistencyTuple.c = 13;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m17352a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m17343a((String) obj);
            } else if ("viewer_guest_status".equals(str)) {
                m17341a((GraphQLEventGuestStatus) obj);
            } else if ("viewer_has_pending_invite".equals(str)) {
                m17344a(((Boolean) obj).booleanValue());
            } else if ("viewer_watch_status".equals(str)) {
                m17342a((GraphQLEventWatchStatus) obj);
            }
        }

        public final boolean mo1097b() {
            a(0, 0);
            return this.f9908d;
        }

        @Nullable
        public final GraphQLConnectionStyle mo1101c() {
            this.f9909e = (GraphQLConnectionStyle) super.b(this.f9909e, 1, GraphQLConnectionStyle.class, GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9909e;
        }

        public final long mo1102d() {
            a(0, 2);
            return this.f9910f;
        }

        @Nullable
        private EventCoverPhotoModel m17345q() {
            this.f9911g = (EventCoverPhotoModel) super.a(this.f9911g, 3, EventCoverPhotoModel.class);
            return this.f9911g;
        }

        @Nullable
        private NewsFeedDefaultsEventPlaceFieldsModel m17346r() {
            this.f9912h = (NewsFeedDefaultsEventPlaceFieldsModel) super.a(this.f9912h, 4, NewsFeedDefaultsEventPlaceFieldsModel.class);
            return this.f9912h;
        }

        @Nullable
        public final String bt_() {
            this.f9913i = super.a(this.f9913i, 5);
            return this.f9913i;
        }

        public final boolean bu_() {
            a(0, 6);
            return this.f9914j;
        }

        @Nullable
        public final String mo1104j() {
            this.f9915k = super.a(this.f9915k, 7);
            return this.f9915k;
        }

        private void m17343a(@Nullable String str) {
            this.f9915k = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 7, str);
            }
        }

        public final long mo1105k() {
            a(1, 0);
            return this.f9916l;
        }

        @Nullable
        public final String mo1106l() {
            this.f9917m = super.a(this.f9917m, 9);
            return this.f9917m;
        }

        @Nullable
        public final String mo1107m() {
            this.f9918n = super.a(this.f9918n, 10);
            return this.f9918n;
        }

        @Nullable
        public final GraphQLEventGuestStatus mo1108n() {
            this.f9919o = (GraphQLEventGuestStatus) super.b(this.f9919o, 11, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9919o;
        }

        private void m17341a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
            this.f9919o = graphQLEventGuestStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 11, graphQLEventGuestStatus != null ? graphQLEventGuestStatus.name() : null);
            }
        }

        public final boolean mo1109o() {
            a(1, 4);
            return this.f9920p;
        }

        private void m17344a(boolean z) {
            this.f9920p = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 12, z);
            }
        }

        @Nullable
        public final GraphQLEventWatchStatus mo1110p() {
            this.f9921q = (GraphQLEventWatchStatus) super.b(this.f9921q, 13, GraphQLEventWatchStatus.class, GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9921q;
        }

        private void m17342a(GraphQLEventWatchStatus graphQLEventWatchStatus) {
            this.f9921q = graphQLEventWatchStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 13, graphQLEventWatchStatus != null ? graphQLEventWatchStatus.name() : null);
            }
        }

        @Nullable
        public final String m17349a() {
            return bt_();
        }

        public final int jK_() {
            return 67338874;
        }

        public final GraphQLVisitableModel m17348a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17345q() != null) {
                EventCoverPhotoModel eventCoverPhotoModel = (EventCoverPhotoModel) graphQLModelMutatingVisitor.b(m17345q());
                if (m17345q() != eventCoverPhotoModel) {
                    graphQLVisitableModel = (EventAttachmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9911g = eventCoverPhotoModel;
                }
            }
            if (m17346r() != null) {
                NewsFeedDefaultsEventPlaceFieldsModel newsFeedDefaultsEventPlaceFieldsModel = (NewsFeedDefaultsEventPlaceFieldsModel) graphQLModelMutatingVisitor.b(m17346r());
                if (m17346r() != newsFeedDefaultsEventPlaceFieldsModel) {
                    graphQLVisitableModel = (EventAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9912h = newsFeedDefaultsEventPlaceFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17347a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(mo1101c());
            int a2 = ModelHelper.a(flatBufferBuilder, m17345q());
            int a3 = ModelHelper.a(flatBufferBuilder, m17346r());
            int b = flatBufferBuilder.b(bt_());
            int b2 = flatBufferBuilder.b(mo1104j());
            int b3 = flatBufferBuilder.b(mo1106l());
            int b4 = flatBufferBuilder.b(mo1107m());
            int a4 = flatBufferBuilder.a(mo1108n());
            int a5 = flatBufferBuilder.a(mo1110p());
            flatBufferBuilder.c(14);
            flatBufferBuilder.a(0, this.f9908d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.a(2, this.f9910f, 0);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b);
            flatBufferBuilder.a(6, this.f9914j);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.a(8, this.f9916l, 0);
            flatBufferBuilder.b(9, b3);
            flatBufferBuilder.b(10, b4);
            flatBufferBuilder.b(11, a4);
            flatBufferBuilder.a(12, this.f9920p);
            flatBufferBuilder.b(13, a5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17350a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9908d = mutableFlatBuffer.a(i, 0);
            this.f9910f = mutableFlatBuffer.a(i, 2, 0);
            this.f9914j = mutableFlatBuffer.a(i, 6);
            this.f9916l = mutableFlatBuffer.a(i, 8, 0);
            this.f9920p = mutableFlatBuffer.a(i, 12);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1166787670)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class ExternalUrlAttachmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private OpenGraphNodeModel f9927d;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ExternalUrlAttachmentModel.class, new Deserializer());
            }

            public Object m17364a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ExternalUrlAttachmentParser.m18209a(jsonParser);
                Object externalUrlAttachmentModel = new ExternalUrlAttachmentModel();
                ((BaseModel) externalUrlAttachmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (externalUrlAttachmentModel instanceof Postprocessable) {
                    return ((Postprocessable) externalUrlAttachmentModel).a();
                }
                return externalUrlAttachmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1401153550)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class OpenGraphNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f9924d;
            @Nullable
            private String f9925e;
            @Nullable
            private OpenGraphMetadataModel f9926f;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OpenGraphNodeModel.class, new Deserializer());
                }

                public Object m17365a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OpenGraphNodeParser.m18207a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object openGraphNodeModel = new OpenGraphNodeModel();
                    ((BaseModel) openGraphNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (openGraphNodeModel instanceof Postprocessable) {
                        return ((Postprocessable) openGraphNodeModel).a();
                    }
                    return openGraphNodeModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1232058160)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class OpenGraphMetadataModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<DeprecatedCurrencyQuantityFieldsModel> f9922d;
                @Nullable
                private String f9923e;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OpenGraphMetadataModel.class, new Deserializer());
                    }

                    public Object m17366a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OpenGraphMetadataParser.m18205a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object openGraphMetadataModel = new OpenGraphMetadataModel();
                        ((BaseModel) openGraphMetadataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (openGraphMetadataModel instanceof Postprocessable) {
                            return ((Postprocessable) openGraphMetadataModel).a();
                        }
                        return openGraphMetadataModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<OpenGraphMetadataModel> {
                    public final void m17367a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OpenGraphMetadataModel openGraphMetadataModel = (OpenGraphMetadataModel) obj;
                        if (openGraphMetadataModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(openGraphMetadataModel.m17370a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            openGraphMetadataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OpenGraphMetadataParser.m18206a(openGraphMetadataModel.w_(), openGraphMetadataModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(OpenGraphMetadataModel.class, new Serializer());
                    }
                }

                public OpenGraphMetadataModel() {
                    super(2);
                }

                @Nonnull
                private ImmutableList<DeprecatedCurrencyQuantityFieldsModel> m17368a() {
                    this.f9922d = super.a(this.f9922d, 0, DeprecatedCurrencyQuantityFieldsModel.class);
                    return (ImmutableList) this.f9922d;
                }

                @Nullable
                private String m17369j() {
                    this.f9923e = super.a(this.f9923e, 1);
                    return this.f9923e;
                }

                public final int jK_() {
                    return 405455955;
                }

                public final GraphQLVisitableModel m17371a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17368a() != null) {
                        Builder a = ModelHelper.a(m17368a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (OpenGraphMetadataModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9922d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17370a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17368a());
                    int b = flatBufferBuilder.b(m17369j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<OpenGraphNodeModel> {
                public final void m17372a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OpenGraphNodeModel openGraphNodeModel = (OpenGraphNodeModel) obj;
                    if (openGraphNodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(openGraphNodeModel.m17376a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        openGraphNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OpenGraphNodeParser.m18208a(openGraphNodeModel.w_(), openGraphNodeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(OpenGraphNodeModel.class, new Serializer());
                }
            }

            public OpenGraphNodeModel() {
                super(3);
            }

            public final void m17379a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17380a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m17373j() {
                if (this.b != null && this.f9924d == null) {
                    this.f9924d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9924d;
            }

            @Nullable
            private String m17374k() {
                this.f9925e = super.a(this.f9925e, 1);
                return this.f9925e;
            }

            @Nullable
            private OpenGraphMetadataModel m17375l() {
                this.f9926f = (OpenGraphMetadataModel) super.a(this.f9926f, 2, OpenGraphMetadataModel.class);
                return this.f9926f;
            }

            @Nullable
            public final String m17378a() {
                return m17374k();
            }

            public final int jK_() {
                return 2433570;
            }

            public final GraphQLVisitableModel m17377a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17375l() != null) {
                    OpenGraphMetadataModel openGraphMetadataModel = (OpenGraphMetadataModel) graphQLModelMutatingVisitor.b(m17375l());
                    if (m17375l() != openGraphMetadataModel) {
                        graphQLVisitableModel = (OpenGraphNodeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9926f = openGraphMetadataModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17376a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17373j());
                int b = flatBufferBuilder.b(m17374k());
                int a2 = ModelHelper.a(flatBufferBuilder, m17375l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<ExternalUrlAttachmentModel> {
            public final void m17381a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ExternalUrlAttachmentModel externalUrlAttachmentModel = (ExternalUrlAttachmentModel) obj;
                if (externalUrlAttachmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(externalUrlAttachmentModel.m17383a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    externalUrlAttachmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = externalUrlAttachmentModel.w_();
                int u_ = externalUrlAttachmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("open_graph_node");
                    OpenGraphNodeParser.m18208a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ExternalUrlAttachmentModel.class, new Serializer());
            }
        }

        public ExternalUrlAttachmentModel() {
            super(1);
        }

        @Nullable
        private OpenGraphNodeModel m17382a() {
            this.f9927d = (OpenGraphNodeModel) super.a(this.f9927d, 0, OpenGraphNodeModel.class);
            return this.f9927d;
        }

        public final int jK_() {
            return 514783620;
        }

        public final GraphQLVisitableModel m17384a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17382a() != null) {
                OpenGraphNodeModel openGraphNodeModel = (OpenGraphNodeModel) graphQLModelMutatingVisitor.b(m17382a());
                if (m17382a() != openGraphNodeModel) {
                    graphQLVisitableModel = (ExternalUrlAttachmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9927d = openGraphNodeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17383a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17382a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1919192962)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class FBMediaQuestionFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f9935d;
        @Nullable
        private MediaQuestionOptionOrderModel f9936e;
        @Nullable
        private List<MediaQuestionPhotosModel> f9937f;
        @Nullable
        private String f9938g;
        private boolean f9939h;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBMediaQuestionFragmentModel.class, new Deserializer());
            }

            public Object m17385a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBMediaQuestionFragmentParser.m18220a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBMediaQuestionFragmentModel = new FBMediaQuestionFragmentModel();
                ((BaseModel) fBMediaQuestionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBMediaQuestionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBMediaQuestionFragmentModel).a();
                }
                return fBMediaQuestionFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 9533444)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class MediaQuestionOptionOrderModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f9933d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaQuestionOptionOrderModel.class, new Deserializer());
                }

                public Object m17386a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaQuestionOptionOrderParser.m18214a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaQuestionOptionOrderModel = new MediaQuestionOptionOrderModel();
                    ((BaseModel) mediaQuestionOptionOrderModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaQuestionOptionOrderModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaQuestionOptionOrderModel).a();
                    }
                    return mediaQuestionOptionOrderModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1453103635)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f9932d;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m17387a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m18212b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 2135716166)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f9928d;
                    @Nullable
                    private String f9929e;
                    private boolean f9930f;
                    private int f9931g;

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m17388a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m18210a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodeModel = new NodeModel();
                            ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodeModel instanceof Postprocessable) {
                                return ((Postprocessable) nodeModel).a();
                            }
                            return nodeModel;
                        }
                    }

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m17389a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m17396a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m18211a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(4);
                    }

                    public final void m17400a(String str, ConsistencyTuple consistencyTuple) {
                        if ("viewer_has_chosen".equals(str)) {
                            consistencyTuple.a = Boolean.valueOf(m17394l());
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 2;
                        } else if ("vote_count".equals(str)) {
                            consistencyTuple.a = Integer.valueOf(m17395m());
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 3;
                        } else {
                            consistencyTuple.a();
                        }
                    }

                    public final void m17401a(String str, Object obj, boolean z) {
                        if ("viewer_has_chosen".equals(str)) {
                            m17391a(((Boolean) obj).booleanValue());
                        } else if ("vote_count".equals(str)) {
                            m17390a(((Integer) obj).intValue());
                        }
                    }

                    @Nullable
                    private String m17392j() {
                        this.f9928d = super.a(this.f9928d, 0);
                        return this.f9928d;
                    }

                    @Nullable
                    private String m17393k() {
                        this.f9929e = super.a(this.f9929e, 1);
                        return this.f9929e;
                    }

                    private boolean m17394l() {
                        a(0, 2);
                        return this.f9930f;
                    }

                    private void m17391a(boolean z) {
                        this.f9930f = z;
                        if (this.b != null && this.b.d) {
                            this.b.a(this.c, 2, z);
                        }
                    }

                    private int m17395m() {
                        a(0, 3);
                        return this.f9931g;
                    }

                    private void m17390a(int i) {
                        this.f9931g = i;
                        if (this.b != null && this.b.d) {
                            this.b.b(this.c, 3, i);
                        }
                    }

                    @Nullable
                    public final String m17398a() {
                        return m17392j();
                    }

                    public final int jK_() {
                        return -1239871265;
                    }

                    public final GraphQLVisitableModel m17397a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m17396a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m17392j());
                        int b2 = flatBufferBuilder.b(m17393k());
                        flatBufferBuilder.c(4);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.a(2, this.f9930f);
                        flatBufferBuilder.a(3, this.f9931g, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m17399a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f9930f = mutableFlatBuffer.a(i, 2);
                        this.f9931g = mutableFlatBuffer.a(i, 3, 0);
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m17402a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m17404a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m18213b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m17403a() {
                    this.f9932d = (NodeModel) super.a(this.f9932d, 0, NodeModel.class);
                    return this.f9932d;
                }

                public final int jK_() {
                    return 34542417;
                }

                public final GraphQLVisitableModel m17405a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17403a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m17403a());
                        if (m17403a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9932d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17404a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17403a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<MediaQuestionOptionOrderModel> {
                public final void m17406a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaQuestionOptionOrderModel mediaQuestionOptionOrderModel = (MediaQuestionOptionOrderModel) obj;
                    if (mediaQuestionOptionOrderModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaQuestionOptionOrderModel.m17408a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaQuestionOptionOrderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaQuestionOptionOrderParser.m18215a(mediaQuestionOptionOrderModel.w_(), mediaQuestionOptionOrderModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaQuestionOptionOrderModel.class, new Serializer());
                }
            }

            public MediaQuestionOptionOrderModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m17407a() {
                this.f9933d = super.a(this.f9933d, 0, EdgesModel.class);
                return (ImmutableList) this.f9933d;
            }

            public final int jK_() {
                return -1448172174;
            }

            public final GraphQLVisitableModel m17409a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17407a() != null) {
                    Builder a = ModelHelper.a(m17407a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MediaQuestionOptionOrderModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9933d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17408a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17407a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1236209140)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class MediaQuestionPhotosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DefaultImageFieldsModel f9934d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaQuestionPhotosModel.class, new Deserializer());
                }

                public Object m17410a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaQuestionPhotosParser.m18218b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaQuestionPhotosModel = new MediaQuestionPhotosModel();
                    ((BaseModel) mediaQuestionPhotosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaQuestionPhotosModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaQuestionPhotosModel).a();
                    }
                    return mediaQuestionPhotosModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<MediaQuestionPhotosModel> {
                public final void m17411a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaQuestionPhotosModel mediaQuestionPhotosModel = (MediaQuestionPhotosModel) obj;
                    if (mediaQuestionPhotosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaQuestionPhotosModel.m17413a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaQuestionPhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaQuestionPhotosParser.m18219b(mediaQuestionPhotosModel.w_(), mediaQuestionPhotosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaQuestionPhotosModel.class, new Serializer());
                }
            }

            public MediaQuestionPhotosModel() {
                super(1);
            }

            @Nullable
            private DefaultImageFieldsModel m17412a() {
                this.f9934d = (DefaultImageFieldsModel) super.a(this.f9934d, 0, DefaultImageFieldsModel.class);
                return this.f9934d;
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m17414a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17412a() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m17412a());
                    if (m17412a() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaQuestionPhotosModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9934d = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17413a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17412a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<FBMediaQuestionFragmentModel> {
            public final void m17415a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBMediaQuestionFragmentModel fBMediaQuestionFragmentModel = (FBMediaQuestionFragmentModel) obj;
                if (fBMediaQuestionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBMediaQuestionFragmentModel.m17420a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBMediaQuestionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBMediaQuestionFragmentModel.w_();
                int u_ = fBMediaQuestionFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("media_question_option_order");
                    MediaQuestionOptionOrderParser.m18215a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("media_question_photos");
                    MediaQuestionPhotosParser.m18217a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("media_question_type");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                boolean a = mutableFlatBuffer.a(u_, 4);
                if (a) {
                    jsonGenerator.a("viewer_has_voted");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBMediaQuestionFragmentModel.class, new Serializer());
            }
        }

        public FBMediaQuestionFragmentModel() {
            super(5);
        }

        @Nullable
        private String m17416j() {
            this.f9935d = super.a(this.f9935d, 0);
            return this.f9935d;
        }

        @Nullable
        private MediaQuestionOptionOrderModel m17417k() {
            this.f9936e = (MediaQuestionOptionOrderModel) super.a(this.f9936e, 1, MediaQuestionOptionOrderModel.class);
            return this.f9936e;
        }

        @Nonnull
        private ImmutableList<MediaQuestionPhotosModel> m17418l() {
            this.f9937f = super.a(this.f9937f, 2, MediaQuestionPhotosModel.class);
            return (ImmutableList) this.f9937f;
        }

        @Nullable
        private String m17419m() {
            this.f9938g = super.a(this.f9938g, 3);
            return this.f9938g;
        }

        @Nullable
        public final String m17422a() {
            return m17416j();
        }

        public final int jK_() {
            return 239016906;
        }

        public final GraphQLVisitableModel m17421a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17417k() != null) {
                MediaQuestionOptionOrderModel mediaQuestionOptionOrderModel = (MediaQuestionOptionOrderModel) graphQLModelMutatingVisitor.b(m17417k());
                if (m17417k() != mediaQuestionOptionOrderModel) {
                    graphQLVisitableModel = (FBMediaQuestionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9936e = mediaQuestionOptionOrderModel;
                }
            }
            if (m17418l() != null) {
                Builder a = ModelHelper.a(m17418l(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FBMediaQuestionFragmentModel fBMediaQuestionFragmentModel = (FBMediaQuestionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    fBMediaQuestionFragmentModel.f9937f = a.b();
                    graphQLVisitableModel = fBMediaQuestionFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17420a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17416j());
            int a = ModelHelper.a(flatBufferBuilder, m17417k());
            int a2 = ModelHelper.a(flatBufferBuilder, m17418l());
            int b2 = flatBufferBuilder.b(m17419m());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.a(4, this.f9939h);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17423a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9939h = mutableFlatBuffer.a(i, 4);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 727284577)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class FundraiserPageAttachmentFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private CampaignModel f9952d;
        @Nullable
        private String f9953e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 76454710)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class CampaignModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f9943d;
            @Nullable
            private String f9944e;
            @Nullable
            private String f9945f;
            @Nullable
            private CharityModel f9946g;
            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel f9947h;
            private boolean f9948i;
            @Nullable
            private String f9949j;
            @Nullable
            private DefaultImageFieldsModel f9950k;
            private double f9951l;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1942565450)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class CharityModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PageModel f9942d;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CharityModel.class, new Deserializer());
                    }

                    public Object m17424a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CharityParser.m18223a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object charityModel = new CharityModel();
                        ((BaseModel) charityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (charityModel instanceof Postprocessable) {
                            return ((Postprocessable) charityModel).a();
                        }
                        return charityModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1128002616)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f9940d;
                    private boolean f9941e;

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                        }

                        public Object m17425a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PageParser.m18221a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object pageModel = new PageModel();
                            ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (pageModel instanceof Postprocessable) {
                                return ((Postprocessable) pageModel).a();
                            }
                            return pageModel;
                        }
                    }

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Serializer extends JsonSerializer<PageModel> {
                        public final void m17426a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageModel pageModel = (PageModel) obj;
                            if (pageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageModel.m17428a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PageParser.m18222a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PageModel.class, new Serializer());
                        }
                    }

                    public PageModel() {
                        super(2);
                    }

                    public final void m17432a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m17433a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private String m17427j() {
                        this.f9940d = super.a(this.f9940d, 0);
                        return this.f9940d;
                    }

                    @Nullable
                    public final String m17430a() {
                        return m17427j();
                    }

                    public final int jK_() {
                        return 2479791;
                    }

                    public final GraphQLVisitableModel m17429a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m17428a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m17427j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.a(1, this.f9941e);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m17431a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f9941e = mutableFlatBuffer.a(i, 1);
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<CharityModel> {
                    public final void m17434a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CharityModel charityModel = (CharityModel) obj;
                        if (charityModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(charityModel.m17436a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            charityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CharityParser.m18224a(charityModel.w_(), charityModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(CharityModel.class, new Serializer());
                    }
                }

                public CharityModel() {
                    super(1);
                }

                @Nullable
                private PageModel m17435a() {
                    this.f9942d = (PageModel) super.a(this.f9942d, 0, PageModel.class);
                    return this.f9942d;
                }

                public final int jK_() {
                    return 1023857133;
                }

                public final GraphQLVisitableModel m17437a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17435a() != null) {
                        PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m17435a());
                        if (m17435a() != pageModel) {
                            graphQLVisitableModel = (CharityModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9942d = pageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17436a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17435a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CampaignModel.class, new Deserializer());
                }

                public Object m17438a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CampaignParser.m18225a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object campaignModel = new CampaignModel();
                    ((BaseModel) campaignModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (campaignModel instanceof Postprocessable) {
                        return ((Postprocessable) campaignModel).a();
                    }
                    return campaignModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<CampaignModel> {
                public final void m17439a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CampaignModel campaignModel = (CampaignModel) obj;
                    if (campaignModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(campaignModel.m17447a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        campaignModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CampaignParser.m18226a(campaignModel.w_(), campaignModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CampaignModel.class, new Serializer());
                }
            }

            public CampaignModel() {
                super(9);
            }

            @Nullable
            private String m17440j() {
                this.f9943d = super.a(this.f9943d, 0);
                return this.f9943d;
            }

            @Nullable
            private String m17441k() {
                this.f9944e = super.a(this.f9944e, 1);
                return this.f9944e;
            }

            @Nullable
            private String m17442l() {
                this.f9945f = super.a(this.f9945f, 2);
                return this.f9945f;
            }

            @Nullable
            private CharityModel m17443m() {
                this.f9946g = (CharityModel) super.a(this.f9946g, 3, CharityModel.class);
                return this.f9946g;
            }

            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel m17444n() {
                this.f9947h = (DefaultTextWithEntitiesWithRangesFieldsModel) super.a(this.f9947h, 4, DefaultTextWithEntitiesWithRangesFieldsModel.class);
                return this.f9947h;
            }

            @Nullable
            private String m17445o() {
                this.f9949j = super.a(this.f9949j, 6);
                return this.f9949j;
            }

            @Nullable
            private DefaultImageFieldsModel m17446p() {
                this.f9950k = (DefaultImageFieldsModel) super.a(this.f9950k, 7, DefaultImageFieldsModel.class);
                return this.f9950k;
            }

            @Nullable
            public final String m17449a() {
                return m17445o();
            }

            public final int jK_() {
                return 98695003;
            }

            public final GraphQLVisitableModel m17448a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17443m() != null) {
                    CharityModel charityModel = (CharityModel) graphQLModelMutatingVisitor.b(m17443m());
                    if (m17443m() != charityModel) {
                        graphQLVisitableModel = (CampaignModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9946g = charityModel;
                    }
                }
                if (m17444n() != null) {
                    DefaultTextWithEntitiesWithRangesFieldsModel defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m17444n());
                    if (m17444n() != defaultTextWithEntitiesWithRangesFieldsModel) {
                        graphQLVisitableModel = (CampaignModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9947h = defaultTextWithEntitiesWithRangesFieldsModel;
                    }
                }
                if (m17446p() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m17446p());
                    if (m17446p() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (CampaignModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9950k = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17447a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17440j());
                int b2 = flatBufferBuilder.b(m17441k());
                int b3 = flatBufferBuilder.b(m17442l());
                int a = ModelHelper.a(flatBufferBuilder, m17443m());
                int a2 = ModelHelper.a(flatBufferBuilder, m17444n());
                int b4 = flatBufferBuilder.b(m17445o());
                int a3 = ModelHelper.a(flatBufferBuilder, m17446p());
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, a);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.a(5, this.f9948i);
                flatBufferBuilder.b(6, b4);
                flatBufferBuilder.b(7, a3);
                flatBufferBuilder.a(8, this.f9951l, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17450a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9948i = mutableFlatBuffer.a(i, 5);
                this.f9951l = mutableFlatBuffer.a(i, 8, 0.0d);
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserPageAttachmentFragmentModel.class, new Deserializer());
            }

            public Object m17451a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FundraiserPageAttachmentFragmentParser.m18227a(jsonParser);
                Object fundraiserPageAttachmentFragmentModel = new FundraiserPageAttachmentFragmentModel();
                ((BaseModel) fundraiserPageAttachmentFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fundraiserPageAttachmentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserPageAttachmentFragmentModel).a();
                }
                return fundraiserPageAttachmentFragmentModel;
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<FundraiserPageAttachmentFragmentModel> {
            public final void m17452a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FundraiserPageAttachmentFragmentModel fundraiserPageAttachmentFragmentModel = (FundraiserPageAttachmentFragmentModel) obj;
                if (fundraiserPageAttachmentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserPageAttachmentFragmentModel.m17455a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserPageAttachmentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fundraiserPageAttachmentFragmentModel.w_();
                int u_ = fundraiserPageAttachmentFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("campaign");
                    CampaignParser.m18226a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FundraiserPageAttachmentFragmentModel.class, new Serializer());
            }
        }

        public FundraiserPageAttachmentFragmentModel() {
            super(2);
        }

        @Nullable
        private CampaignModel m17453j() {
            this.f9952d = (CampaignModel) super.a(this.f9952d, 0, CampaignModel.class);
            return this.f9952d;
        }

        @Nullable
        private String m17454k() {
            this.f9953e = super.a(this.f9953e, 1);
            return this.f9953e;
        }

        @Nullable
        public final String m17457a() {
            return m17454k();
        }

        public final int jK_() {
            return 1147287130;
        }

        public final GraphQLVisitableModel m17456a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17453j() != null) {
                CampaignModel campaignModel = (CampaignModel) graphQLModelMutatingVisitor.b(m17453j());
                if (m17453j() != campaignModel) {
                    graphQLVisitableModel = (FundraiserPageAttachmentFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9952d = campaignModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17455a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17453j());
            int b = flatBufferBuilder.b(m17454k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -416201942)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class FundraiserPersonToCharityAttachmentFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f9962d;
        @Nullable
        private String f9963e;
        @Nullable
        private String f9964f;
        @Nullable
        private CharityModel f9965g;
        @Nullable
        private DonorsModel f9966h;
        @Nullable
        private DefaultTextWithEntitiesWithRangesFieldsModel f9967i;
        private boolean f9968j;
        @Nullable
        private String f9969k;
        @Nullable
        private DefaultImageFieldsModel f9970l;
        @Nullable
        private OwnerModel f9971m;
        private double f9972n;
        @Nullable
        private String f9973o;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1982800973)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class CharityModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PageModel f9956d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CharityModel.class, new Deserializer());
                }

                public Object m17458a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FundraiserPersonToCharityAttachmentFragmentParser.CharityParser.m18230a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object charityModel = new CharityModel();
                    ((BaseModel) charityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (charityModel instanceof Postprocessable) {
                        return ((Postprocessable) charityModel).a();
                    }
                    return charityModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1128002616)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f9954d;
                private boolean f9955e;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                    }

                    public Object m17459a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FundraiserPersonToCharityAttachmentFragmentParser.CharityParser.PageParser.m18228a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageModel = new PageModel();
                        ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageModel instanceof Postprocessable) {
                            return ((Postprocessable) pageModel).a();
                        }
                        return pageModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<PageModel> {
                    public final void m17460a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageModel pageModel = (PageModel) obj;
                        if (pageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageModel.m17462a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FundraiserPersonToCharityAttachmentFragmentParser.CharityParser.PageParser.m18229a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageModel.class, new Serializer());
                    }
                }

                public PageModel() {
                    super(2);
                }

                public final void m17466a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m17467a(String str, Object obj, boolean z) {
                }

                @Nullable
                private String m17461j() {
                    this.f9954d = super.a(this.f9954d, 0);
                    return this.f9954d;
                }

                @Nullable
                public final String m17464a() {
                    return m17461j();
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m17463a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17462a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17461j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f9955e);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m17465a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f9955e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<CharityModel> {
                public final void m17468a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CharityModel charityModel = (CharityModel) obj;
                    if (charityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(charityModel.m17470a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        charityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FundraiserPersonToCharityAttachmentFragmentParser.CharityParser.m18231a(charityModel.w_(), charityModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CharityModel.class, new Serializer());
                }
            }

            public CharityModel() {
                super(1);
            }

            @Nullable
            private PageModel m17469a() {
                this.f9956d = (PageModel) super.a(this.f9956d, 0, PageModel.class);
                return this.f9956d;
            }

            public final int jK_() {
                return 1023857133;
            }

            public final GraphQLVisitableModel m17471a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17469a() != null) {
                    PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m17469a());
                    if (m17469a() != pageModel) {
                        graphQLVisitableModel = (CharityModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9956d = pageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17470a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17469a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserPersonToCharityAttachmentFragmentModel.class, new Deserializer());
            }

            public Object m17472a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FundraiserPersonToCharityAttachmentFragmentParser.m18240a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fundraiserPersonToCharityAttachmentFragmentModel = new FundraiserPersonToCharityAttachmentFragmentModel();
                ((BaseModel) fundraiserPersonToCharityAttachmentFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fundraiserPersonToCharityAttachmentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserPersonToCharityAttachmentFragmentModel).a();
                }
                return fundraiserPersonToCharityAttachmentFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1934074040)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class DonorsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f9959d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DonorsModel.class, new Deserializer());
                }

                public Object m17473a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DonorsParser.m18236a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object donorsModel = new DonorsModel();
                    ((BaseModel) donorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (donorsModel instanceof Postprocessable) {
                        return ((Postprocessable) donorsModel).a();
                    }
                    return donorsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1841651140)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class NodesModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private ProfilePictureModel f9958d;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m17474a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(DonorsParser.NodesParser.m18234b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f9957d;

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m17475a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProfilePictureParser.m18232a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object profilePictureModel = new ProfilePictureModel();
                            ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (profilePictureModel instanceof Postprocessable) {
                                return ((Postprocessable) profilePictureModel).a();
                            }
                            return profilePictureModel;
                        }
                    }

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m17476a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m17478a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ProfilePictureParser.m18233a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    @Nullable
                    private String m17477a() {
                        this.f9957d = super.a(this.f9957d, 0);
                        return this.f9957d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m17479a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m17478a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m17477a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m17480a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m17482a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        DonorsParser.NodesParser.m18235b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                public final void m17484a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m17485a(String str, Object obj, boolean z) {
                }

                @Nullable
                private ProfilePictureModel m17481a() {
                    this.f9958d = (ProfilePictureModel) super.a(this.f9958d, 0, ProfilePictureModel.class);
                    return this.f9958d;
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m17483a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17481a() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m17481a());
                        if (m17481a() != profilePictureModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9958d = profilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17482a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17481a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<DonorsModel> {
                public final void m17486a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DonorsModel donorsModel = (DonorsModel) obj;
                    if (donorsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(donorsModel.m17488a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        donorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DonorsParser.m18237a(donorsModel.w_(), donorsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DonorsModel.class, new Serializer());
                }
            }

            public DonorsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m17487a() {
                this.f9959d = super.a(this.f9959d, 0, NodesModel.class);
                return (ImmutableList) this.f9959d;
            }

            public final int jK_() {
                return -1978703416;
            }

            public final GraphQLVisitableModel m17489a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17487a() != null) {
                    Builder a = ModelHelper.a(m17487a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (DonorsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9959d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17488a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17487a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class OwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f9960d;
            @Nullable
            private String f9961e;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                }

                public Object m17490a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OwnerParser.m18238a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ownerModel = new OwnerModel();
                    ((BaseModel) ownerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ownerModel instanceof Postprocessable) {
                        return ((Postprocessable) ownerModel).a();
                    }
                    return ownerModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<OwnerModel> {
                public final void m17491a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OwnerModel ownerModel = (OwnerModel) obj;
                    if (ownerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ownerModel.m17494a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OwnerParser.m18239a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                }
            }

            public OwnerModel() {
                super(2);
            }

            public final void m17497a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17498a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m17492j() {
                if (this.b != null && this.f9960d == null) {
                    this.f9960d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9960d;
            }

            @Nullable
            private String m17493k() {
                this.f9961e = super.a(this.f9961e, 1);
                return this.f9961e;
            }

            @Nullable
            public final String m17496a() {
                return m17493k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m17495a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17494a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17492j());
                int b = flatBufferBuilder.b(m17493k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<FundraiserPersonToCharityAttachmentFragmentModel> {
            public final void m17499a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FundraiserPersonToCharityAttachmentFragmentModel fundraiserPersonToCharityAttachmentFragmentModel = (FundraiserPersonToCharityAttachmentFragmentModel) obj;
                if (fundraiserPersonToCharityAttachmentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserPersonToCharityAttachmentFragmentModel.m17510a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserPersonToCharityAttachmentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FundraiserPersonToCharityAttachmentFragmentParser.m18241a(fundraiserPersonToCharityAttachmentFragmentModel.w_(), fundraiserPersonToCharityAttachmentFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FundraiserPersonToCharityAttachmentFragmentModel.class, new Serializer());
            }
        }

        public FundraiserPersonToCharityAttachmentFragmentModel() {
            super(12);
        }

        @Nullable
        private String m17500j() {
            this.f9962d = super.a(this.f9962d, 0);
            return this.f9962d;
        }

        @Nullable
        private String m17501k() {
            this.f9963e = super.a(this.f9963e, 1);
            return this.f9963e;
        }

        @Nullable
        private String m17502l() {
            this.f9964f = super.a(this.f9964f, 2);
            return this.f9964f;
        }

        @Nullable
        private CharityModel m17503m() {
            this.f9965g = (CharityModel) super.a(this.f9965g, 3, CharityModel.class);
            return this.f9965g;
        }

        @Nullable
        private DonorsModel m17504n() {
            this.f9966h = (DonorsModel) super.a(this.f9966h, 4, DonorsModel.class);
            return this.f9966h;
        }

        @Nullable
        private DefaultTextWithEntitiesWithRangesFieldsModel m17505o() {
            this.f9967i = (DefaultTextWithEntitiesWithRangesFieldsModel) super.a(this.f9967i, 5, DefaultTextWithEntitiesWithRangesFieldsModel.class);
            return this.f9967i;
        }

        @Nullable
        private String m17506p() {
            this.f9969k = super.a(this.f9969k, 7);
            return this.f9969k;
        }

        @Nullable
        private DefaultImageFieldsModel m17507q() {
            this.f9970l = (DefaultImageFieldsModel) super.a(this.f9970l, 8, DefaultImageFieldsModel.class);
            return this.f9970l;
        }

        @Nullable
        private OwnerModel m17508r() {
            this.f9971m = (OwnerModel) super.a(this.f9971m, 9, OwnerModel.class);
            return this.f9971m;
        }

        @Nullable
        private String m17509s() {
            this.f9973o = super.a(this.f9973o, 11);
            return this.f9973o;
        }

        @Nullable
        public final String m17512a() {
            return m17506p();
        }

        public final int jK_() {
            return -1315407331;
        }

        public final GraphQLVisitableModel m17511a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17503m() != null) {
                CharityModel charityModel = (CharityModel) graphQLModelMutatingVisitor.b(m17503m());
                if (m17503m() != charityModel) {
                    graphQLVisitableModel = (FundraiserPersonToCharityAttachmentFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9965g = charityModel;
                }
            }
            if (m17504n() != null) {
                DonorsModel donorsModel = (DonorsModel) graphQLModelMutatingVisitor.b(m17504n());
                if (m17504n() != donorsModel) {
                    graphQLVisitableModel = (FundraiserPersonToCharityAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9966h = donorsModel;
                }
            }
            if (m17505o() != null) {
                DefaultTextWithEntitiesWithRangesFieldsModel defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m17505o());
                if (m17505o() != defaultTextWithEntitiesWithRangesFieldsModel) {
                    graphQLVisitableModel = (FundraiserPersonToCharityAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9967i = defaultTextWithEntitiesWithRangesFieldsModel;
                }
            }
            if (m17507q() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m17507q());
                if (m17507q() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FundraiserPersonToCharityAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9970l = defaultImageFieldsModel;
                }
            }
            if (m17508r() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m17508r());
                if (m17508r() != ownerModel) {
                    graphQLVisitableModel = (FundraiserPersonToCharityAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9971m = ownerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17510a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17500j());
            int b2 = flatBufferBuilder.b(m17501k());
            int b3 = flatBufferBuilder.b(m17502l());
            int a = ModelHelper.a(flatBufferBuilder, m17503m());
            int a2 = ModelHelper.a(flatBufferBuilder, m17504n());
            int a3 = ModelHelper.a(flatBufferBuilder, m17505o());
            int b4 = flatBufferBuilder.b(m17506p());
            int a4 = ModelHelper.a(flatBufferBuilder, m17507q());
            int a5 = ModelHelper.a(flatBufferBuilder, m17508r());
            int b5 = flatBufferBuilder.b(m17509s());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.a(6, this.f9968j);
            flatBufferBuilder.b(7, b4);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, a5);
            flatBufferBuilder.a(10, this.f9972n, 0.0d);
            flatBufferBuilder.b(11, b5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17513a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9968j = mutableFlatBuffer.a(i, 6);
            this.f9972n = mutableFlatBuffer.a(i, 10, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1573281043)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class GoodwillThrowbackCardAttachmentComponentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DefaultImageFieldsModel f9986d;
        @Nullable
        private List<ActionLinksModel> f9987e;
        @Nullable
        private List<AdditionalAccentImagesModel> f9988f;
        @Nullable
        private DataPointsModel f9989g;
        @Nullable
        private List<SizeAwareMediaModel> f9990h;
        @Nullable
        private List<ThrowbackMediaAttachmentFieldsModel> f9991i;
        @Nullable
        private TitleModel f9992j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1134676274)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class ActionLinksModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f9974d;
            @Nullable
            private String f9975e;
            @Nullable
            private String f9976f;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActionLinksModel.class, new Deserializer());
                }

                public Object m17514a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActionLinksParser.m18245b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actionLinksModel = new ActionLinksModel();
                    ((BaseModel) actionLinksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actionLinksModel instanceof Postprocessable) {
                        return ((Postprocessable) actionLinksModel).a();
                    }
                    return actionLinksModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<ActionLinksModel> {
                public final void m17515a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActionLinksModel actionLinksModel = (ActionLinksModel) obj;
                    if (actionLinksModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actionLinksModel.m17519a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actionLinksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActionLinksParser.m18243a(actionLinksModel.w_(), actionLinksModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ActionLinksModel.class, new Serializer());
                }
            }

            public ActionLinksModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m17516a() {
                if (this.b != null && this.f9974d == null) {
                    this.f9974d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9974d;
            }

            @Nullable
            private String m17517j() {
                this.f9975e = super.a(this.f9975e, 1);
                return this.f9975e;
            }

            @Nullable
            private String m17518k() {
                this.f9976f = super.a(this.f9976f, 2);
                return this.f9976f;
            }

            public final int jK_() {
                return -1747569147;
            }

            public final GraphQLVisitableModel m17520a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17519a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17516a());
                int b = flatBufferBuilder.b(m17517j());
                int b2 = flatBufferBuilder.b(m17518k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 729935302)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class AdditionalAccentImagesModel extends BaseModel implements GraphQLVisitableModel {
            private int f9977d;
            @Nullable
            private String f9978e;
            private int f9979f;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdditionalAccentImagesModel.class, new Deserializer());
                }

                public Object m17521a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdditionalAccentImagesParser.m18249b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object additionalAccentImagesModel = new AdditionalAccentImagesModel();
                    ((BaseModel) additionalAccentImagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (additionalAccentImagesModel instanceof Postprocessable) {
                        return ((Postprocessable) additionalAccentImagesModel).a();
                    }
                    return additionalAccentImagesModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<AdditionalAccentImagesModel> {
                public final void m17522a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdditionalAccentImagesModel additionalAccentImagesModel = (AdditionalAccentImagesModel) obj;
                    if (additionalAccentImagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(additionalAccentImagesModel.m17524a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        additionalAccentImagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdditionalAccentImagesParser.m18247a(additionalAccentImagesModel.w_(), additionalAccentImagesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AdditionalAccentImagesModel.class, new Serializer());
                }
            }

            public AdditionalAccentImagesModel() {
                super(3);
            }

            @Nullable
            private String m17523a() {
                this.f9978e = super.a(this.f9978e, 1);
                return this.f9978e;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m17525a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17524a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17523a());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f9977d, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f9979f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17526a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9977d = mutableFlatBuffer.a(i, 0, 0);
                this.f9979f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2133908370)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class DataPointsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f9984d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DataPointsModel.class, new Deserializer());
                }

                public Object m17527a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DataPointsParser.m18256a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object dataPointsModel = new DataPointsModel();
                    ((BaseModel) dataPointsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (dataPointsModel instanceof Postprocessable) {
                        return ((Postprocessable) dataPointsModel).a();
                    }
                    return dataPointsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1572565855)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private IconModel f9982d;
                @Nullable
                private TextModel f9983e;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m17528a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(DataPointsParser.NodesParser.m18254b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public final class IconModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f9980d;

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(IconModel.class, new Deserializer());
                        }

                        public Object m17529a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(IconParser.m18250a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object iconModel = new IconModel();
                            ((BaseModel) iconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (iconModel instanceof Postprocessable) {
                                return ((Postprocessable) iconModel).a();
                            }
                            return iconModel;
                        }
                    }

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Serializer extends JsonSerializer<IconModel> {
                        public final void m17530a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            IconModel iconModel = (IconModel) obj;
                            if (iconModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(iconModel.m17532a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                iconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            IconParser.m18251a(iconModel.w_(), iconModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(IconModel.class, new Serializer());
                        }
                    }

                    public IconModel() {
                        super(1);
                    }

                    @Nullable
                    private String m17531a() {
                        this.f9980d = super.a(this.f9980d, 0);
                        return this.f9980d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m17533a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m17532a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m17531a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m17534a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m17542a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        DataPointsParser.NodesParser.m18255b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public final class TextModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f9981d;

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TextModel.class, new Deserializer());
                        }

                        public Object m17535a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TextParser.m18252a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object textModel = new TextModel();
                            ((BaseModel) textModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (textModel instanceof Postprocessable) {
                                return ((Postprocessable) textModel).a();
                            }
                            return textModel;
                        }
                    }

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Serializer extends JsonSerializer<TextModel> {
                        public final void m17536a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TextModel textModel = (TextModel) obj;
                            if (textModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(textModel.m17538a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                textModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TextParser.m18253a(textModel.w_(), textModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(TextModel.class, new Serializer());
                        }
                    }

                    public TextModel() {
                        super(1);
                    }

                    @Nullable
                    private String m17537a() {
                        this.f9981d = super.a(this.f9981d, 0);
                        return this.f9981d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m17539a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m17538a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m17537a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public NodesModel() {
                    super(2);
                }

                @Nullable
                private IconModel m17540a() {
                    this.f9982d = (IconModel) super.a(this.f9982d, 0, IconModel.class);
                    return this.f9982d;
                }

                @Nullable
                private TextModel m17541j() {
                    this.f9983e = (TextModel) super.a(this.f9983e, 1, TextModel.class);
                    return this.f9983e;
                }

                public final int jK_() {
                    return 938654280;
                }

                public final GraphQLVisitableModel m17543a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17540a() != null) {
                        IconModel iconModel = (IconModel) graphQLModelMutatingVisitor.b(m17540a());
                        if (m17540a() != iconModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9982d = iconModel;
                        }
                    }
                    if (m17541j() != null) {
                        TextModel textModel = (TextModel) graphQLModelMutatingVisitor.b(m17541j());
                        if (m17541j() != textModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9983e = textModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17542a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17540a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m17541j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<DataPointsModel> {
                public final void m17544a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DataPointsModel dataPointsModel = (DataPointsModel) obj;
                    if (dataPointsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(dataPointsModel.m17546a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        dataPointsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DataPointsParser.m18257a(dataPointsModel.w_(), dataPointsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DataPointsModel.class, new Serializer());
                }
            }

            public DataPointsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m17545a() {
                this.f9984d = super.a(this.f9984d, 0, NodesModel.class);
                return (ImmutableList) this.f9984d;
            }

            public final int jK_() {
                return 608055401;
            }

            public final GraphQLVisitableModel m17547a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17545a() != null) {
                    Builder a = ModelHelper.a(m17545a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (DataPointsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9984d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17546a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17545a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GoodwillThrowbackCardAttachmentComponentModel.class, new Deserializer());
            }

            public Object m17548a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GoodwillThrowbackCardAttachmentComponentParser.m18260a(jsonParser);
                Object goodwillThrowbackCardAttachmentComponentModel = new GoodwillThrowbackCardAttachmentComponentModel();
                ((BaseModel) goodwillThrowbackCardAttachmentComponentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (goodwillThrowbackCardAttachmentComponentModel instanceof Postprocessable) {
                    return ((Postprocessable) goodwillThrowbackCardAttachmentComponentModel).a();
                }
                return goodwillThrowbackCardAttachmentComponentModel;
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<GoodwillThrowbackCardAttachmentComponentModel> {
            public final void m17549a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GoodwillThrowbackCardAttachmentComponentModel goodwillThrowbackCardAttachmentComponentModel = (GoodwillThrowbackCardAttachmentComponentModel) obj;
                if (goodwillThrowbackCardAttachmentComponentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(goodwillThrowbackCardAttachmentComponentModel.m17562a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    goodwillThrowbackCardAttachmentComponentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = goodwillThrowbackCardAttachmentComponentModel.w_();
                int u_ = goodwillThrowbackCardAttachmentComponentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("accent_image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("action_links");
                    ActionLinksParser.m18244a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("additional_accent_images");
                    AdditionalAccentImagesParser.m18248a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("data_points");
                    DataPointsParser.m18257a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("throwback_media");
                    SizeAwareMediaParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("throwback_media_attachments");
                    ThrowbackMediaAttachmentFieldsParser.m18398a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("title");
                    TitleParser.m18259a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GoodwillThrowbackCardAttachmentComponentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9985d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m17550a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m18258a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object titleModel = new TitleModel();
                    ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (titleModel instanceof Postprocessable) {
                        return ((Postprocessable) titleModel).a();
                    }
                    return titleModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m17551a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m17553a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m18259a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            private String m17552a() {
                this.f9985d = super.a(this.f9985d, 0);
                return this.f9985d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m17554a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17553a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17552a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public GoodwillThrowbackCardAttachmentComponentModel() {
            super(7);
        }

        @Nullable
        private DefaultImageFieldsModel m17555a() {
            this.f9986d = (DefaultImageFieldsModel) super.a(this.f9986d, 0, DefaultImageFieldsModel.class);
            return this.f9986d;
        }

        @Nonnull
        private ImmutableList<ActionLinksModel> m17556j() {
            this.f9987e = super.a(this.f9987e, 1, ActionLinksModel.class);
            return (ImmutableList) this.f9987e;
        }

        @Nonnull
        private ImmutableList<AdditionalAccentImagesModel> m17557k() {
            this.f9988f = super.a(this.f9988f, 2, AdditionalAccentImagesModel.class);
            return (ImmutableList) this.f9988f;
        }

        @Nullable
        private DataPointsModel m17558l() {
            this.f9989g = (DataPointsModel) super.a(this.f9989g, 3, DataPointsModel.class);
            return this.f9989g;
        }

        @Nonnull
        private ImmutableList<SizeAwareMediaModel> m17559m() {
            this.f9990h = super.a(this.f9990h, 4, SizeAwareMediaModel.class);
            return (ImmutableList) this.f9990h;
        }

        @Nonnull
        private ImmutableList<ThrowbackMediaAttachmentFieldsModel> m17560n() {
            this.f9991i = super.a(this.f9991i, 5, ThrowbackMediaAttachmentFieldsModel.class);
            return (ImmutableList) this.f9991i;
        }

        @Nullable
        private TitleModel m17561o() {
            this.f9992j = (TitleModel) super.a(this.f9992j, 6, TitleModel.class);
            return this.f9992j;
        }

        public final int jK_() {
            return 543985550;
        }

        public final GraphQLVisitableModel m17563a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17555a() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m17555a());
                if (m17555a() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (GoodwillThrowbackCardAttachmentComponentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9986d = defaultImageFieldsModel;
                }
            }
            if (m17556j() != null) {
                a = ModelHelper.a(m17556j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    GoodwillThrowbackCardAttachmentComponentModel goodwillThrowbackCardAttachmentComponentModel = (GoodwillThrowbackCardAttachmentComponentModel) ModelHelper.a(graphQLVisitableModel, this);
                    goodwillThrowbackCardAttachmentComponentModel.f9987e = a.b();
                    graphQLVisitableModel = goodwillThrowbackCardAttachmentComponentModel;
                }
            }
            if (m17557k() != null) {
                a = ModelHelper.a(m17557k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    goodwillThrowbackCardAttachmentComponentModel = (GoodwillThrowbackCardAttachmentComponentModel) ModelHelper.a(graphQLVisitableModel, this);
                    goodwillThrowbackCardAttachmentComponentModel.f9988f = a.b();
                    graphQLVisitableModel = goodwillThrowbackCardAttachmentComponentModel;
                }
            }
            if (m17558l() != null) {
                DataPointsModel dataPointsModel = (DataPointsModel) graphQLModelMutatingVisitor.b(m17558l());
                if (m17558l() != dataPointsModel) {
                    graphQLVisitableModel = (GoodwillThrowbackCardAttachmentComponentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9989g = dataPointsModel;
                }
            }
            if (m17559m() != null) {
                a = ModelHelper.a(m17559m(), graphQLModelMutatingVisitor);
                if (a != null) {
                    goodwillThrowbackCardAttachmentComponentModel = (GoodwillThrowbackCardAttachmentComponentModel) ModelHelper.a(graphQLVisitableModel, this);
                    goodwillThrowbackCardAttachmentComponentModel.f9990h = a.b();
                    graphQLVisitableModel = goodwillThrowbackCardAttachmentComponentModel;
                }
            }
            if (m17560n() != null) {
                a = ModelHelper.a(m17560n(), graphQLModelMutatingVisitor);
                if (a != null) {
                    goodwillThrowbackCardAttachmentComponentModel = (GoodwillThrowbackCardAttachmentComponentModel) ModelHelper.a(graphQLVisitableModel, this);
                    goodwillThrowbackCardAttachmentComponentModel.f9991i = a.b();
                    graphQLVisitableModel = goodwillThrowbackCardAttachmentComponentModel;
                }
            }
            if (m17561o() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m17561o());
                if (m17561o() != titleModel) {
                    graphQLVisitableModel = (GoodwillThrowbackCardAttachmentComponentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9992j = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17562a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17555a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17556j());
            int a3 = ModelHelper.a(flatBufferBuilder, m17557k());
            int a4 = ModelHelper.a(flatBufferBuilder, m17558l());
            int a5 = ModelHelper.a(flatBufferBuilder, m17559m());
            int a6 = ModelHelper.a(flatBufferBuilder, m17560n());
            int a7 = ModelHelper.a(flatBufferBuilder, m17561o());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.b(6, a7);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1069196104)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class GreetingCardFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GreetingCardTemplateModel f10010d;
        @Nullable
        private DefaultImageFieldsModel f10011e;
        @Nullable
        private SlidesModel f10012f;
        @Nullable
        private String f10013g;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GreetingCardFieldsModel.class, new Deserializer());
            }

            public Object m17564a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GreetingCardFieldsParser.m18277a(jsonParser);
                Object greetingCardFieldsModel = new GreetingCardFieldsModel();
                ((BaseModel) greetingCardFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (greetingCardFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) greetingCardFieldsModel).a();
                }
                return greetingCardFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1915506802)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class GreetingCardTemplateModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f9995d;
            @Nullable
            private List<TemplateThemesModel> f9996e;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GreetingCardTemplateModel.class, new Deserializer());
                }

                public Object m17565a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GreetingCardTemplateParser.m18263a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object greetingCardTemplateModel = new GreetingCardTemplateModel();
                    ((BaseModel) greetingCardTemplateModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (greetingCardTemplateModel instanceof Postprocessable) {
                        return ((Postprocessable) greetingCardTemplateModel).a();
                    }
                    return greetingCardTemplateModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<GreetingCardTemplateModel> {
                public final void m17566a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GreetingCardTemplateModel greetingCardTemplateModel = (GreetingCardTemplateModel) obj;
                    if (greetingCardTemplateModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(greetingCardTemplateModel.m17575a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        greetingCardTemplateModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GreetingCardTemplateParser.m18264a(greetingCardTemplateModel.w_(), greetingCardTemplateModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GreetingCardTemplateModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 320710693)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class TemplateThemesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f9993d;
                @Nullable
                private String f9994e;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TemplateThemesModel.class, new Deserializer());
                    }

                    public Object m17567a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TemplateThemesParser.m18262b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object templateThemesModel = new TemplateThemesModel();
                        ((BaseModel) templateThemesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (templateThemesModel instanceof Postprocessable) {
                            return ((Postprocessable) templateThemesModel).a();
                        }
                        return templateThemesModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<TemplateThemesModel> {
                    public final void m17568a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TemplateThemesModel templateThemesModel = (TemplateThemesModel) obj;
                        if (templateThemesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(templateThemesModel.m17571a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            templateThemesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TemplateThemesParser.m18261a(templateThemesModel.w_(), templateThemesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TemplateThemesModel.class, new Serializer());
                    }
                }

                public TemplateThemesModel() {
                    super(2);
                }

                @Nullable
                private String m17569a() {
                    this.f9993d = super.a(this.f9993d, 0);
                    return this.f9993d;
                }

                @Nullable
                private String m17570j() {
                    this.f9994e = super.a(this.f9994e, 1);
                    return this.f9994e;
                }

                public final int jK_() {
                    return 1582898406;
                }

                public final GraphQLVisitableModel m17572a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17571a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17569a());
                    int b2 = flatBufferBuilder.b(m17570j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public GreetingCardTemplateModel() {
                super(2);
            }

            @Nullable
            private String m17573j() {
                this.f9995d = super.a(this.f9995d, 0);
                return this.f9995d;
            }

            @Nonnull
            private ImmutableList<TemplateThemesModel> m17574k() {
                this.f9996e = super.a(this.f9996e, 1, TemplateThemesModel.class);
                return (ImmutableList) this.f9996e;
            }

            @Nullable
            public final String m17577a() {
                return m17573j();
            }

            public final int jK_() {
                return 538646179;
            }

            public final GraphQLVisitableModel m17576a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17574k() != null) {
                    Builder a = ModelHelper.a(m17574k(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GreetingCardTemplateModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9996e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17575a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17573j());
                int a = ModelHelper.a(flatBufferBuilder, m17574k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<GreetingCardFieldsModel> {
            public final void m17578a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GreetingCardFieldsModel greetingCardFieldsModel = (GreetingCardFieldsModel) obj;
                if (greetingCardFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(greetingCardFieldsModel.m17621a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    greetingCardFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = greetingCardFieldsModel.w_();
                int u_ = greetingCardFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("greeting_card_template");
                    GreetingCardTemplateParser.m18264a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("primary_image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("slides");
                    SlidesParser.m18276a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("theme");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GreetingCardFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 862234463)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class SlidesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f10009d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SlidesModel.class, new Deserializer());
                }

                public Object m17579a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SlidesParser.m18275a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object slidesModel = new SlidesModel();
                    ((BaseModel) slidesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (slidesModel instanceof Postprocessable) {
                        return ((Postprocessable) slidesModel).a();
                    }
                    return slidesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 599695532)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private DefaultTextWithEntitiesFieldsModel f10005d;
                @Nullable
                private PhotosModel f10006e;
                @Nullable
                private GraphQLGreetingCardSlideType f10007f;
                @Nullable
                private DefaultTextWithEntitiesFieldsModel f10008g;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m17580a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SlidesParser.NodesParser.m18273b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -450924924)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public final class PhotosModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<PhotosNodesModel> f10004d;

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PhotosModel.class, new Deserializer());
                        }

                        public Object m17581a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PhotosParser.m18271a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object photosModel = new PhotosModel();
                            ((BaseModel) photosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (photosModel instanceof Postprocessable) {
                                return ((Postprocessable) photosModel).a();
                            }
                            return photosModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 68913236)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public final class PhotosNodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        @Nullable
                        private DefaultVect2FieldsModel f9999d;
                        @Nullable
                        private String f10000e;
                        @Nullable
                        private LargeImageModel f10001f;
                        @Nullable
                        private MediumImageModel f10002g;
                        @Nullable
                        private String f10003h;

                        /* compiled from: android_place_picker_edit_menu_suggest_edits */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(PhotosNodesModel.class, new Deserializer());
                            }

                            public Object m17582a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(PhotosNodesParser.m18269b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object photosNodesModel = new PhotosNodesModel();
                                ((BaseModel) photosNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (photosNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) photosNodesModel).a();
                                }
                                return photosNodesModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 842551240)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: android_place_picker_edit_menu_suggest_edits */
                        public final class LargeImageModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f9997d;

                            /* compiled from: android_place_picker_edit_menu_suggest_edits */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(LargeImageModel.class, new Deserializer());
                                }

                                public Object m17583a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(LargeImageParser.m18265a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object largeImageModel = new LargeImageModel();
                                    ((BaseModel) largeImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (largeImageModel instanceof Postprocessable) {
                                        return ((Postprocessable) largeImageModel).a();
                                    }
                                    return largeImageModel;
                                }
                            }

                            /* compiled from: android_place_picker_edit_menu_suggest_edits */
                            public class Serializer extends JsonSerializer<LargeImageModel> {
                                public final void m17584a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    LargeImageModel largeImageModel = (LargeImageModel) obj;
                                    if (largeImageModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(largeImageModel.m17586a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        largeImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    LargeImageParser.m18266a(largeImageModel.w_(), largeImageModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(LargeImageModel.class, new Serializer());
                                }
                            }

                            public LargeImageModel() {
                                super(1);
                            }

                            @Nullable
                            private String m17585a() {
                                this.f9997d = super.a(this.f9997d, 0);
                                return this.f9997d;
                            }

                            public final int jK_() {
                                return 70760763;
                            }

                            public final GraphQLVisitableModel m17587a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m17586a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m17585a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 842551240)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: android_place_picker_edit_menu_suggest_edits */
                        public final class MediumImageModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f9998d;

                            /* compiled from: android_place_picker_edit_menu_suggest_edits */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(MediumImageModel.class, new Deserializer());
                                }

                                public Object m17588a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(MediumImageParser.m18267a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object mediumImageModel = new MediumImageModel();
                                    ((BaseModel) mediumImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (mediumImageModel instanceof Postprocessable) {
                                        return ((Postprocessable) mediumImageModel).a();
                                    }
                                    return mediumImageModel;
                                }
                            }

                            /* compiled from: android_place_picker_edit_menu_suggest_edits */
                            public class Serializer extends JsonSerializer<MediumImageModel> {
                                public final void m17589a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    MediumImageModel mediumImageModel = (MediumImageModel) obj;
                                    if (mediumImageModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(mediumImageModel.m17591a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mediumImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    MediumImageParser.m18268a(mediumImageModel.w_(), mediumImageModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(MediumImageModel.class, new Serializer());
                                }
                            }

                            public MediumImageModel() {
                                super(1);
                            }

                            @Nullable
                            private String m17590a() {
                                this.f9998d = super.a(this.f9998d, 0);
                                return this.f9998d;
                            }

                            public final int jK_() {
                                return 70760763;
                            }

                            public final GraphQLVisitableModel m17592a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m17591a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m17590a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: android_place_picker_edit_menu_suggest_edits */
                        public class Serializer extends JsonSerializer<PhotosNodesModel> {
                            public final void m17593a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                PhotosNodesModel photosNodesModel = (PhotosNodesModel) obj;
                                if (photosNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(photosNodesModel.m17599a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    photosNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                PhotosNodesParser.m18270b(photosNodesModel.w_(), photosNodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(PhotosNodesModel.class, new Serializer());
                            }
                        }

                        public PhotosNodesModel() {
                            super(5);
                        }

                        @Nullable
                        private DefaultVect2FieldsModel m17594j() {
                            this.f9999d = (DefaultVect2FieldsModel) super.a(this.f9999d, 0, DefaultVect2FieldsModel.class);
                            return this.f9999d;
                        }

                        @Nullable
                        private String m17595k() {
                            this.f10000e = super.a(this.f10000e, 1);
                            return this.f10000e;
                        }

                        @Nullable
                        private LargeImageModel m17596l() {
                            this.f10001f = (LargeImageModel) super.a(this.f10001f, 2, LargeImageModel.class);
                            return this.f10001f;
                        }

                        @Nullable
                        private MediumImageModel m17597m() {
                            this.f10002g = (MediumImageModel) super.a(this.f10002g, 3, MediumImageModel.class);
                            return this.f10002g;
                        }

                        @Nullable
                        private String m17598n() {
                            this.f10003h = super.a(this.f10003h, 4);
                            return this.f10003h;
                        }

                        @Nullable
                        public final String m17601a() {
                            return m17595k();
                        }

                        public final int jK_() {
                            return 77090322;
                        }

                        public final GraphQLVisitableModel m17600a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m17594j() != null) {
                                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m17594j());
                                if (m17594j() != defaultVect2FieldsModel) {
                                    graphQLVisitableModel = (PhotosNodesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f9999d = defaultVect2FieldsModel;
                                }
                            }
                            if (m17596l() != null) {
                                LargeImageModel largeImageModel = (LargeImageModel) graphQLModelMutatingVisitor.b(m17596l());
                                if (m17596l() != largeImageModel) {
                                    graphQLVisitableModel = (PhotosNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f10001f = largeImageModel;
                                }
                            }
                            if (m17597m() != null) {
                                MediumImageModel mediumImageModel = (MediumImageModel) graphQLModelMutatingVisitor.b(m17597m());
                                if (m17597m() != mediumImageModel) {
                                    graphQLVisitableModel = (PhotosNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f10002g = mediumImageModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m17599a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m17594j());
                            int b = flatBufferBuilder.b(m17595k());
                            int a2 = ModelHelper.a(flatBufferBuilder, m17596l());
                            int a3 = ModelHelper.a(flatBufferBuilder, m17597m());
                            int b2 = flatBufferBuilder.b(m17598n());
                            flatBufferBuilder.c(5);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, b);
                            flatBufferBuilder.b(2, a2);
                            flatBufferBuilder.b(3, a3);
                            flatBufferBuilder.b(4, b2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Serializer extends JsonSerializer<PhotosModel> {
                        public final void m17602a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PhotosModel photosModel = (PhotosModel) obj;
                            if (photosModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(photosModel.m17604a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                photosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PhotosParser.m18272a(photosModel.w_(), photosModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(PhotosModel.class, new Serializer());
                        }
                    }

                    public PhotosModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<PhotosNodesModel> m17603a() {
                        this.f10004d = super.a(this.f10004d, 0, PhotosNodesModel.class);
                        return (ImmutableList) this.f10004d;
                    }

                    public final int jK_() {
                        return -530041209;
                    }

                    public final GraphQLVisitableModel m17605a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m17603a() != null) {
                            Builder a = ModelHelper.a(m17603a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (PhotosModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10004d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m17604a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m17603a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m17606a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m17611a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SlidesParser.NodesParser.m18274b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(4);
                }

                @Nullable
                private DefaultTextWithEntitiesFieldsModel m17607a() {
                    this.f10005d = (DefaultTextWithEntitiesFieldsModel) super.a(this.f10005d, 0, DefaultTextWithEntitiesFieldsModel.class);
                    return this.f10005d;
                }

                @Nullable
                private PhotosModel m17608j() {
                    this.f10006e = (PhotosModel) super.a(this.f10006e, 1, PhotosModel.class);
                    return this.f10006e;
                }

                @Nullable
                private GraphQLGreetingCardSlideType m17609k() {
                    this.f10007f = (GraphQLGreetingCardSlideType) super.b(this.f10007f, 2, GraphQLGreetingCardSlideType.class, GraphQLGreetingCardSlideType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f10007f;
                }

                @Nullable
                private DefaultTextWithEntitiesFieldsModel m17610l() {
                    this.f10008g = (DefaultTextWithEntitiesFieldsModel) super.a(this.f10008g, 3, DefaultTextWithEntitiesFieldsModel.class);
                    return this.f10008g;
                }

                public final int jK_() {
                    return 1230654504;
                }

                public final GraphQLVisitableModel m17612a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17607a() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m17607a());
                        if (m17607a() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10005d = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (m17608j() != null) {
                        PhotosModel photosModel = (PhotosModel) graphQLModelMutatingVisitor.b(m17608j());
                        if (m17608j() != photosModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f10006e = photosModel;
                        }
                    }
                    if (m17610l() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m17610l());
                        if (m17610l() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f10008g = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17611a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17607a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m17608j());
                    int a3 = flatBufferBuilder.a(m17609k());
                    int a4 = ModelHelper.a(flatBufferBuilder, m17610l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    flatBufferBuilder.b(3, a4);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<SlidesModel> {
                public final void m17613a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SlidesModel slidesModel = (SlidesModel) obj;
                    if (slidesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(slidesModel.m17615a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        slidesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SlidesParser.m18276a(slidesModel.w_(), slidesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SlidesModel.class, new Serializer());
                }
            }

            public SlidesModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m17614a() {
                this.f10009d = super.a(this.f10009d, 0, NodesModel.class);
                return (ImmutableList) this.f10009d;
            }

            public final int jK_() {
                return 1452454537;
            }

            public final GraphQLVisitableModel m17616a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17614a() != null) {
                    Builder a = ModelHelper.a(m17614a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SlidesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10009d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17615a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17614a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public GreetingCardFieldsModel() {
            super(4);
        }

        @Nullable
        private GreetingCardTemplateModel m17617a() {
            this.f10010d = (GreetingCardTemplateModel) super.a(this.f10010d, 0, GreetingCardTemplateModel.class);
            return this.f10010d;
        }

        @Nullable
        private DefaultImageFieldsModel m17618j() {
            this.f10011e = (DefaultImageFieldsModel) super.a(this.f10011e, 1, DefaultImageFieldsModel.class);
            return this.f10011e;
        }

        @Nullable
        private SlidesModel m17619k() {
            this.f10012f = (SlidesModel) super.a(this.f10012f, 2, SlidesModel.class);
            return this.f10012f;
        }

        @Nullable
        private String m17620l() {
            this.f10013g = super.a(this.f10013g, 3);
            return this.f10013g;
        }

        public final int jK_() {
            return -703791351;
        }

        public final GraphQLVisitableModel m17622a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17617a() != null) {
                GreetingCardTemplateModel greetingCardTemplateModel = (GreetingCardTemplateModel) graphQLModelMutatingVisitor.b(m17617a());
                if (m17617a() != greetingCardTemplateModel) {
                    graphQLVisitableModel = (GreetingCardFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10010d = greetingCardTemplateModel;
                }
            }
            if (m17618j() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m17618j());
                if (m17618j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (GreetingCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10011e = defaultImageFieldsModel;
                }
            }
            if (m17619k() != null) {
                SlidesModel slidesModel = (SlidesModel) graphQLModelMutatingVisitor.b(m17619k());
                if (m17619k() != slidesModel) {
                    graphQLVisitableModel = (GreetingCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10012f = slidesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17621a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17617a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17618j());
            int a3 = ModelHelper.a(flatBufferBuilder, m17619k());
            int b = flatBufferBuilder.b(m17620l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1773263388)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class InstantArticleFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private InstantArticleModel f10020d;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantArticleFieldsModel.class, new Deserializer());
            }

            public Object m17623a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = InstantArticleFieldsParser.m18284a(jsonParser);
                Object instantArticleFieldsModel = new InstantArticleFieldsModel();
                ((BaseModel) instantArticleFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (instantArticleFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) instantArticleFieldsModel).a();
                }
                return instantArticleFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -327374738)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class InstantArticleModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f10017d;
            @Nullable
            private LatestVersionModel f10018e;
            @Nullable
            private String f10019f;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InstantArticleModel.class, new Deserializer());
                }

                public Object m17624a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InstantArticleParser.m18282a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object instantArticleModel = new InstantArticleModel();
                    ((BaseModel) instantArticleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (instantArticleModel instanceof Postprocessable) {
                        return ((Postprocessable) instantArticleModel).a();
                    }
                    return instantArticleModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -587146130)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class LatestVersionModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FeedCoverConfigModel f10016d;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LatestVersionModel.class, new Deserializer());
                    }

                    public Object m17625a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LatestVersionParser.m18280a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object latestVersionModel = new LatestVersionModel();
                        ((BaseModel) latestVersionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (latestVersionModel instanceof Postprocessable) {
                            return ((Postprocessable) latestVersionModel).a();
                        }
                        return latestVersionModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1526058569)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public final class FeedCoverConfigModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f10014d;
                    @Nullable
                    private String f10015e;

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(FeedCoverConfigModel.class, new Deserializer());
                        }

                        public Object m17626a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(FeedCoverConfigParser.m18278a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object feedCoverConfigModel = new FeedCoverConfigModel();
                            ((BaseModel) feedCoverConfigModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (feedCoverConfigModel instanceof Postprocessable) {
                                return ((Postprocessable) feedCoverConfigModel).a();
                            }
                            return feedCoverConfigModel;
                        }
                    }

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Serializer extends JsonSerializer<FeedCoverConfigModel> {
                        public final void m17627a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            FeedCoverConfigModel feedCoverConfigModel = (FeedCoverConfigModel) obj;
                            if (feedCoverConfigModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(feedCoverConfigModel.m17630a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                feedCoverConfigModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            FeedCoverConfigParser.m18279a(feedCoverConfigModel.w_(), feedCoverConfigModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(FeedCoverConfigModel.class, new Serializer());
                        }
                    }

                    public FeedCoverConfigModel() {
                        super(2);
                    }

                    @Nullable
                    private String m17628a() {
                        this.f10014d = super.a(this.f10014d, 0);
                        return this.f10014d;
                    }

                    @Nullable
                    private String m17629j() {
                        this.f10015e = super.a(this.f10015e, 1);
                        return this.f10015e;
                    }

                    public final int jK_() {
                        return -884238688;
                    }

                    public final GraphQLVisitableModel m17631a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m17630a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m17628a());
                        int b2 = flatBufferBuilder.b(m17629j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<LatestVersionModel> {
                    public final void m17632a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LatestVersionModel latestVersionModel = (LatestVersionModel) obj;
                        if (latestVersionModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(latestVersionModel.m17634a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            latestVersionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LatestVersionParser.m18281a(latestVersionModel.w_(), latestVersionModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(LatestVersionModel.class, new Serializer());
                    }
                }

                public LatestVersionModel() {
                    super(1);
                }

                @Nullable
                private FeedCoverConfigModel m17633a() {
                    this.f10016d = (FeedCoverConfigModel) super.a(this.f10016d, 0, FeedCoverConfigModel.class);
                    return this.f10016d;
                }

                public final int jK_() {
                    return 1619159843;
                }

                public final GraphQLVisitableModel m17635a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17633a() != null) {
                        FeedCoverConfigModel feedCoverConfigModel = (FeedCoverConfigModel) graphQLModelMutatingVisitor.b(m17633a());
                        if (m17633a() != feedCoverConfigModel) {
                            graphQLVisitableModel = (LatestVersionModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10016d = feedCoverConfigModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17634a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17633a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<InstantArticleModel> {
                public final void m17636a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InstantArticleModel instantArticleModel = (InstantArticleModel) obj;
                    if (instantArticleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(instantArticleModel.m17640a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        instantArticleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InstantArticleParser.m18283a(instantArticleModel.w_(), instantArticleModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(InstantArticleModel.class, new Serializer());
                }
            }

            public InstantArticleModel() {
                super(3);
            }

            @Nullable
            private String m17637j() {
                this.f10017d = super.a(this.f10017d, 0);
                return this.f10017d;
            }

            @Nullable
            private LatestVersionModel m17638k() {
                this.f10018e = (LatestVersionModel) super.a(this.f10018e, 1, LatestVersionModel.class);
                return this.f10018e;
            }

            @Nullable
            private String m17639l() {
                this.f10019f = super.a(this.f10019f, 2);
                return this.f10019f;
            }

            @Nullable
            public final String m17642a() {
                return m17637j();
            }

            public final int jK_() {
                return 1607392245;
            }

            public final GraphQLVisitableModel m17641a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17638k() != null) {
                    LatestVersionModel latestVersionModel = (LatestVersionModel) graphQLModelMutatingVisitor.b(m17638k());
                    if (m17638k() != latestVersionModel) {
                        graphQLVisitableModel = (InstantArticleModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10018e = latestVersionModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17640a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17637j());
                int a = ModelHelper.a(flatBufferBuilder, m17638k());
                int b2 = flatBufferBuilder.b(m17639l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<InstantArticleFieldsModel> {
            public final void m17643a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                InstantArticleFieldsModel instantArticleFieldsModel = (InstantArticleFieldsModel) obj;
                if (instantArticleFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantArticleFieldsModel.m17645a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantArticleFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = instantArticleFieldsModel.w_();
                int u_ = instantArticleFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("instant_article");
                    InstantArticleParser.m18283a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(InstantArticleFieldsModel.class, new Serializer());
            }
        }

        public InstantArticleFieldsModel() {
            super(1);
        }

        @Nullable
        private InstantArticleModel m17644a() {
            this.f10020d = (InstantArticleModel) super.a(this.f10020d, 0, InstantArticleModel.class);
            return this.f10020d;
        }

        public final int jK_() {
            return 514783620;
        }

        public final GraphQLVisitableModel m17646a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17644a() != null) {
                InstantArticleModel instantArticleModel = (InstantArticleModel) graphQLModelMutatingVisitor.b(m17644a());
                if (m17644a() != instantArticleModel) {
                    graphQLVisitableModel = (InstantArticleFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10020d = instantArticleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17645a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17644a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -432783821)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class LocalAdContextAttachmentStyleInfoFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f10026d;
        @Nullable
        private List<PlaceOpenStatusFormatsModel> f10027e;
        @Nullable
        private String f10028f;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LocalAdContextAttachmentStyleInfoFieldsModel.class, new Deserializer());
            }

            public Object m17647a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LocalAdContextAttachmentStyleInfoFieldsParser.m18291a(jsonParser);
                Object localAdContextAttachmentStyleInfoFieldsModel = new LocalAdContextAttachmentStyleInfoFieldsModel();
                ((BaseModel) localAdContextAttachmentStyleInfoFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (localAdContextAttachmentStyleInfoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) localAdContextAttachmentStyleInfoFieldsModel).a();
                }
                return localAdContextAttachmentStyleInfoFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 435172031)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class PlaceOpenStatusFormatsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLPlaceOpenStatusType f10023d;
            @Nullable
            private TimeRangeModel f10024e;
            @Nullable
            private List<Long> f10025f;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceOpenStatusFormatsModel.class, new Deserializer());
                }

                public Object m17648a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceOpenStatusFormatsParser.m18289b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeOpenStatusFormatsModel = new PlaceOpenStatusFormatsModel();
                    ((BaseModel) placeOpenStatusFormatsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeOpenStatusFormatsModel instanceof Postprocessable) {
                        return ((Postprocessable) placeOpenStatusFormatsModel).a();
                    }
                    return placeOpenStatusFormatsModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<PlaceOpenStatusFormatsModel> {
                public final void m17649a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceOpenStatusFormatsModel placeOpenStatusFormatsModel = (PlaceOpenStatusFormatsModel) obj;
                    if (placeOpenStatusFormatsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeOpenStatusFormatsModel.m17658a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeOpenStatusFormatsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceOpenStatusFormatsParser.m18290b(placeOpenStatusFormatsModel.w_(), placeOpenStatusFormatsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PlaceOpenStatusFormatsModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1244528557)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class TimeRangeModel extends BaseModel implements GraphQLVisitableModel {
                private long f10021d;
                private long f10022e;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TimeRangeModel.class, new Deserializer());
                    }

                    public Object m17650a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TimeRangeParser.m18285a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object timeRangeModel = new TimeRangeModel();
                        ((BaseModel) timeRangeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (timeRangeModel instanceof Postprocessable) {
                            return ((Postprocessable) timeRangeModel).a();
                        }
                        return timeRangeModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<TimeRangeModel> {
                    public final void m17651a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TimeRangeModel timeRangeModel = (TimeRangeModel) obj;
                        if (timeRangeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(timeRangeModel.m17652a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            timeRangeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TimeRangeParser.m18286a(timeRangeModel.w_(), timeRangeModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TimeRangeModel.class, new Serializer());
                    }
                }

                public TimeRangeModel() {
                    super(2);
                }

                public final int jK_() {
                    return 2028064336;
                }

                public final GraphQLVisitableModel m17653a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17652a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f10021d, 0);
                    flatBufferBuilder.a(1, this.f10022e, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m17654a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f10021d = mutableFlatBuffer.a(i, 0, 0);
                    this.f10022e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            public PlaceOpenStatusFormatsModel() {
                super(3);
            }

            @Nullable
            private GraphQLPlaceOpenStatusType m17655a() {
                this.f10023d = (GraphQLPlaceOpenStatusType) super.b(this.f10023d, 0, GraphQLPlaceOpenStatusType.class, GraphQLPlaceOpenStatusType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10023d;
            }

            @Nullable
            private TimeRangeModel m17656j() {
                this.f10024e = (TimeRangeModel) super.a(this.f10024e, 1, TimeRangeModel.class);
                return this.f10024e;
            }

            @Nonnull
            private ImmutableList<Long> m17657k() {
                this.f10025f = super.c(this.f10025f, 2);
                return (ImmutableList) this.f10025f;
            }

            public final int jK_() {
                return 1644908794;
            }

            public final GraphQLVisitableModel m17659a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17656j() != null) {
                    TimeRangeModel timeRangeModel = (TimeRangeModel) graphQLModelMutatingVisitor.b(m17656j());
                    if (m17656j() != timeRangeModel) {
                        graphQLVisitableModel = (PlaceOpenStatusFormatsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10024e = timeRangeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17658a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m17655a());
                int a2 = ModelHelper.a(flatBufferBuilder, m17656j());
                int b = flatBufferBuilder.b(m17657k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<LocalAdContextAttachmentStyleInfoFieldsModel> {
            public final void m17660a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LocalAdContextAttachmentStyleInfoFieldsModel localAdContextAttachmentStyleInfoFieldsModel = (LocalAdContextAttachmentStyleInfoFieldsModel) obj;
                if (localAdContextAttachmentStyleInfoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(localAdContextAttachmentStyleInfoFieldsModel.m17664a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    localAdContextAttachmentStyleInfoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = localAdContextAttachmentStyleInfoFieldsModel.w_();
                int u_ = localAdContextAttachmentStyleInfoFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("category_name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("place_open_status_formats");
                    PlaceOpenStatusFormatsParser.m18288a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("time_zone");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LocalAdContextAttachmentStyleInfoFieldsModel.class, new Serializer());
            }
        }

        public LocalAdContextAttachmentStyleInfoFieldsModel() {
            super(3);
        }

        @Nullable
        private String m17661a() {
            this.f10026d = super.a(this.f10026d, 0);
            return this.f10026d;
        }

        @Nonnull
        private ImmutableList<PlaceOpenStatusFormatsModel> m17662j() {
            this.f10027e = super.a(this.f10027e, 1, PlaceOpenStatusFormatsModel.class);
            return (ImmutableList) this.f10027e;
        }

        @Nullable
        private String m17663k() {
            this.f10028f = super.a(this.f10028f, 2);
            return this.f10028f;
        }

        public final int jK_() {
            return -2113223272;
        }

        public final GraphQLVisitableModel m17665a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17662j() != null) {
                Builder a = ModelHelper.a(m17662j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (LocalAdContextAttachmentStyleInfoFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10027e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17664a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17661a());
            int a = ModelHelper.a(flatBufferBuilder, m17662j());
            int b2 = flatBufferBuilder.b(m17663k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1471914622)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class MessengerContentSubscriptionTargetModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerContentSubscriptionOptionModel f10034d;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessengerContentSubscriptionTargetModel.class, new Deserializer());
            }

            public Object m17666a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MessengerContentSubscriptionTargetParser.m18296a(jsonParser);
                Object messengerContentSubscriptionTargetModel = new MessengerContentSubscriptionTargetModel();
                ((BaseModel) messengerContentSubscriptionTargetModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (messengerContentSubscriptionTargetModel instanceof Postprocessable) {
                    return ((Postprocessable) messengerContentSubscriptionTargetModel).a();
                }
                return messengerContentSubscriptionTargetModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1568195547)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class MessengerContentSubscriptionOptionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10031d;
            @Nullable
            private PageModel f10032e;
            @Nullable
            private String f10033f;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerContentSubscriptionOptionModel.class, new Deserializer());
                }

                public Object m17667a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerContentSubscriptionOptionParser.m18294a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerContentSubscriptionOptionModel = new MessengerContentSubscriptionOptionModel();
                    ((BaseModel) messengerContentSubscriptionOptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerContentSubscriptionOptionModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerContentSubscriptionOptionModel).a();
                    }
                    return messengerContentSubscriptionOptionModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1185712657)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f10029d;
                @Nullable
                private String f10030e;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                    }

                    public Object m17668a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MessengerContentSubscriptionOptionParser.PageParser.m18292a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageModel = new PageModel();
                        ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageModel instanceof Postprocessable) {
                            return ((Postprocessable) pageModel).a();
                        }
                        return pageModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<PageModel> {
                    public final void m17669a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageModel pageModel = (PageModel) obj;
                        if (pageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageModel.m17672a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MessengerContentSubscriptionOptionParser.PageParser.m18293a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageModel.class, new Serializer());
                    }
                }

                public PageModel() {
                    super(2);
                }

                public final void m17675a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m17676a(String str, Object obj, boolean z) {
                }

                @Nullable
                private String m17670j() {
                    this.f10029d = super.a(this.f10029d, 0);
                    return this.f10029d;
                }

                @Nullable
                private String m17671k() {
                    this.f10030e = super.a(this.f10030e, 1);
                    return this.f10030e;
                }

                @Nullable
                public final String m17674a() {
                    return m17670j();
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m17673a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17672a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17670j());
                    int b2 = flatBufferBuilder.b(m17671k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<MessengerContentSubscriptionOptionModel> {
                public final void m17677a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerContentSubscriptionOptionModel messengerContentSubscriptionOptionModel = (MessengerContentSubscriptionOptionModel) obj;
                    if (messengerContentSubscriptionOptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerContentSubscriptionOptionModel.m17681a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerContentSubscriptionOptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerContentSubscriptionOptionParser.m18295a(messengerContentSubscriptionOptionModel.w_(), messengerContentSubscriptionOptionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerContentSubscriptionOptionModel.class, new Serializer());
                }
            }

            public MessengerContentSubscriptionOptionModel() {
                super(3);
            }

            @Nullable
            private String m17678a() {
                this.f10031d = super.a(this.f10031d, 0);
                return this.f10031d;
            }

            @Nullable
            private PageModel m17679j() {
                this.f10032e = (PageModel) super.a(this.f10032e, 1, PageModel.class);
                return this.f10032e;
            }

            @Nullable
            private String m17680k() {
                this.f10033f = super.a(this.f10033f, 2);
                return this.f10033f;
            }

            public final int jK_() {
                return 1459786904;
            }

            public final GraphQLVisitableModel m17682a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17679j() != null) {
                    PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m17679j());
                    if (m17679j() != pageModel) {
                        graphQLVisitableModel = (MessengerContentSubscriptionOptionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10032e = pageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17681a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17678a());
                int a = ModelHelper.a(flatBufferBuilder, m17679j());
                int b2 = flatBufferBuilder.b(m17680k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<MessengerContentSubscriptionTargetModel> {
            public final void m17683a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessengerContentSubscriptionTargetModel messengerContentSubscriptionTargetModel = (MessengerContentSubscriptionTargetModel) obj;
                if (messengerContentSubscriptionTargetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messengerContentSubscriptionTargetModel.m17685a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messengerContentSubscriptionTargetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messengerContentSubscriptionTargetModel.w_();
                int u_ = messengerContentSubscriptionTargetModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_content_subscription_option");
                    MessengerContentSubscriptionOptionParser.m18295a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessengerContentSubscriptionTargetModel.class, new Serializer());
            }
        }

        public MessengerContentSubscriptionTargetModel() {
            super(1);
        }

        @Nullable
        private MessengerContentSubscriptionOptionModel m17684a() {
            this.f10034d = (MessengerContentSubscriptionOptionModel) super.a(this.f10034d, 0, MessengerContentSubscriptionOptionModel.class);
            return this.f10034d;
        }

        public final int jK_() {
            return 514783620;
        }

        public final GraphQLVisitableModel m17686a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17684a() != null) {
                MessengerContentSubscriptionOptionModel messengerContentSubscriptionOptionModel = (MessengerContentSubscriptionOptionModel) graphQLModelMutatingVisitor.b(m17684a());
                if (m17684a() != messengerContentSubscriptionOptionModel) {
                    graphQLVisitableModel = (MessengerContentSubscriptionTargetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10034d = messengerContentSubscriptionOptionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17685a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17684a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1893901264)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class MultiPlaceMapAttachmentStyleInfoFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<LatLongListModel> f10037d;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MultiPlaceMapAttachmentStyleInfoFieldsModel.class, new Deserializer());
            }

            public Object m17687a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MultiPlaceMapAttachmentStyleInfoFieldsParser.m18301a(jsonParser);
                Object multiPlaceMapAttachmentStyleInfoFieldsModel = new MultiPlaceMapAttachmentStyleInfoFieldsModel();
                ((BaseModel) multiPlaceMapAttachmentStyleInfoFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (multiPlaceMapAttachmentStyleInfoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) multiPlaceMapAttachmentStyleInfoFieldsModel).a();
                }
                return multiPlaceMapAttachmentStyleInfoFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 918622653)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class LatLongListModel extends BaseModel implements GraphQLVisitableModel {
            private double f10035d;
            private double f10036e;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LatLongListModel.class, new Deserializer());
                }

                public Object m17688a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LatLongListParser.m18300b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object latLongListModel = new LatLongListModel();
                    ((BaseModel) latLongListModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (latLongListModel instanceof Postprocessable) {
                        return ((Postprocessable) latLongListModel).a();
                    }
                    return latLongListModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<LatLongListModel> {
                public final void m17689a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LatLongListModel latLongListModel = (LatLongListModel) obj;
                    if (latLongListModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(latLongListModel.m17690a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        latLongListModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LatLongListParser.m18298a(latLongListModel.w_(), latLongListModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LatLongListModel.class, new Serializer());
                }
            }

            public LatLongListModel() {
                super(2);
            }

            public final int jK_() {
                return 1965687765;
            }

            public final GraphQLVisitableModel m17691a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17690a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f10035d, 0.0d);
                flatBufferBuilder.a(1, this.f10036e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17692a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10035d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f10036e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<MultiPlaceMapAttachmentStyleInfoFieldsModel> {
            public final void m17693a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MultiPlaceMapAttachmentStyleInfoFieldsModel multiPlaceMapAttachmentStyleInfoFieldsModel = (MultiPlaceMapAttachmentStyleInfoFieldsModel) obj;
                if (multiPlaceMapAttachmentStyleInfoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(multiPlaceMapAttachmentStyleInfoFieldsModel.m17695a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    multiPlaceMapAttachmentStyleInfoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = multiPlaceMapAttachmentStyleInfoFieldsModel.w_();
                int u_ = multiPlaceMapAttachmentStyleInfoFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("lat_long_list");
                    LatLongListParser.m18299a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MultiPlaceMapAttachmentStyleInfoFieldsModel.class, new Serializer());
            }
        }

        public MultiPlaceMapAttachmentStyleInfoFieldsModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<LatLongListModel> m17694a() {
            this.f10037d = super.a(this.f10037d, 0, LatLongListModel.class);
            return (ImmutableList) this.f10037d;
        }

        public final int jK_() {
            return 1462415918;
        }

        public final GraphQLVisitableModel m17696a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17694a() != null) {
                Builder a = ModelHelper.a(m17694a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (MultiPlaceMapAttachmentStyleInfoFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10037d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17695a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17694a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 201949214)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class NewsFeedDefaultsEventPlaceFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10039d;
        @Nullable
        private CityModel f10040e;
        @Nullable
        private String f10041f;
        @Nullable
        private String f10042g;
        @Nullable
        private DefaultLocationFieldsModel f10043h;
        @Nullable
        private String f10044i;
        @Nullable
        private String f10045j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 483014131)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class CityModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f10038d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CityModel.class, new Deserializer());
                }

                public Object m17697a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CityParser.m18302a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object cityModel = new CityModel();
                    ((BaseModel) cityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (cityModel instanceof Postprocessable) {
                        return ((Postprocessable) cityModel).a();
                    }
                    return cityModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<CityModel> {
                public final void m17698a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CityModel cityModel = (CityModel) obj;
                    if (cityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(cityModel.m17699a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        cityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CityParser.m18303a(cityModel.w_(), cityModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CityModel.class, new Serializer());
                }
            }

            public CityModel() {
                super(1);
            }

            public final void m17702a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17703a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m17701a() {
                this.f10038d = super.a(this.f10038d, 0);
                return this.f10038d;
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m17700a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17699a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17701a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NewsFeedDefaultsEventPlaceFieldsModel.class, new Deserializer());
            }

            public Object m17704a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NewsFeedDefaultsEventPlaceFieldsParser.m18304a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object newsFeedDefaultsEventPlaceFieldsModel = new NewsFeedDefaultsEventPlaceFieldsModel();
                ((BaseModel) newsFeedDefaultsEventPlaceFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (newsFeedDefaultsEventPlaceFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) newsFeedDefaultsEventPlaceFieldsModel).a();
                }
                return newsFeedDefaultsEventPlaceFieldsModel;
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<NewsFeedDefaultsEventPlaceFieldsModel> {
            public final void m17705a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NewsFeedDefaultsEventPlaceFieldsModel newsFeedDefaultsEventPlaceFieldsModel = (NewsFeedDefaultsEventPlaceFieldsModel) obj;
                if (newsFeedDefaultsEventPlaceFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(newsFeedDefaultsEventPlaceFieldsModel.m17709a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    newsFeedDefaultsEventPlaceFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NewsFeedDefaultsEventPlaceFieldsParser.m18305a(newsFeedDefaultsEventPlaceFieldsModel.w_(), newsFeedDefaultsEventPlaceFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NewsFeedDefaultsEventPlaceFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CityModel m17715c() {
            return m17707j();
        }

        @Nullable
        public final /* synthetic */ DefaultLocationFields m17717g() {
            return m17708k();
        }

        public NewsFeedDefaultsEventPlaceFieldsModel() {
            super(7);
        }

        public final void m17712a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = by_();
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
                return;
            }
            consistencyTuple.a();
        }

        public final void m17713a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m17706a((String) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m17714b() {
            if (this.b != null && this.f10039d == null) {
                this.f10039d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10039d;
        }

        @Nullable
        private CityModel m17707j() {
            this.f10040e = (CityModel) super.a(this.f10040e, 1, CityModel.class);
            return this.f10040e;
        }

        @Nullable
        public final String m17716d() {
            this.f10041f = super.a(this.f10041f, 2);
            return this.f10041f;
        }

        @Nullable
        public final String bx_() {
            this.f10042g = super.a(this.f10042g, 3);
            return this.f10042g;
        }

        @Nullable
        private DefaultLocationFieldsModel m17708k() {
            this.f10043h = (DefaultLocationFieldsModel) super.a(this.f10043h, 4, DefaultLocationFieldsModel.class);
            return this.f10043h;
        }

        @Nullable
        public final String by_() {
            this.f10044i = super.a(this.f10044i, 5);
            return this.f10044i;
        }

        private void m17706a(@Nullable String str) {
            this.f10044i = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, str);
            }
        }

        @Nullable
        public final String bz_() {
            this.f10045j = super.a(this.f10045j, 6);
            return this.f10045j;
        }

        @Nullable
        public final String m17711a() {
            return bx_();
        }

        public final int jK_() {
            return 77195495;
        }

        public final GraphQLVisitableModel m17710a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17707j() != null) {
                CityModel cityModel = (CityModel) graphQLModelMutatingVisitor.b(m17707j());
                if (m17707j() != cityModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsEventPlaceFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10040e = cityModel;
                }
            }
            if (m17708k() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m17708k());
                if (m17708k() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsEventPlaceFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10043h = defaultLocationFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17709a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17714b());
            int a2 = ModelHelper.a(flatBufferBuilder, m17707j());
            int b = flatBufferBuilder.b(m17716d());
            int b2 = flatBufferBuilder.b(bx_());
            int a3 = ModelHelper.a(flatBufferBuilder, m17708k());
            int b3 = flatBufferBuilder.b(by_());
            int b4 = flatBufferBuilder.b(bz_());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, b4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1849187663)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class NewsFeedStoryAttachmentTargetExperienceFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10050d;
        @Nullable
        private EmployerModel f10051e;
        @Nullable
        private DefaultImageFieldsModel f10052f;
        @Nullable
        private SchoolModel f10053g;
        @Nullable
        private SchoolClassModel f10054h;
        @Nullable
        private WorkProjectModel f10055i;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NewsFeedStoryAttachmentTargetExperienceFieldsModel.class, new Deserializer());
            }

            public Object m17718a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NewsFeedStoryAttachmentTargetExperienceFieldsParser.m18314a(jsonParser);
                Object newsFeedStoryAttachmentTargetExperienceFieldsModel = new NewsFeedStoryAttachmentTargetExperienceFieldsModel();
                ((BaseModel) newsFeedStoryAttachmentTargetExperienceFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (newsFeedStoryAttachmentTargetExperienceFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) newsFeedStoryAttachmentTargetExperienceFieldsModel).a();
                }
                return newsFeedStoryAttachmentTargetExperienceFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class EmployerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f10046d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EmployerModel.class, new Deserializer());
                }

                public Object m17719a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EmployerParser.m18306a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object employerModel = new EmployerModel();
                    ((BaseModel) employerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (employerModel instanceof Postprocessable) {
                        return ((Postprocessable) employerModel).a();
                    }
                    return employerModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<EmployerModel> {
                public final void m17720a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EmployerModel employerModel = (EmployerModel) obj;
                    if (employerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(employerModel.m17722a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        employerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EmployerParser.m18307a(employerModel.w_(), employerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EmployerModel.class, new Serializer());
                }
            }

            public EmployerModel() {
                super(1);
            }

            public final void m17725a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17726a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m17721j() {
                this.f10046d = super.a(this.f10046d, 0);
                return this.f10046d;
            }

            @Nullable
            public final String m17724a() {
                return m17721j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m17723a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17722a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17721j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class SchoolClassModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f10047d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SchoolClassModel.class, new Deserializer());
                }

                public Object m17727a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SchoolClassParser.m18308a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object schoolClassModel = new SchoolClassModel();
                    ((BaseModel) schoolClassModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (schoolClassModel instanceof Postprocessable) {
                        return ((Postprocessable) schoolClassModel).a();
                    }
                    return schoolClassModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<SchoolClassModel> {
                public final void m17728a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SchoolClassModel schoolClassModel = (SchoolClassModel) obj;
                    if (schoolClassModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(schoolClassModel.m17730a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        schoolClassModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SchoolClassParser.m18309a(schoolClassModel.w_(), schoolClassModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SchoolClassModel.class, new Serializer());
                }
            }

            public SchoolClassModel() {
                super(1);
            }

            public final void m17733a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17734a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m17729j() {
                this.f10047d = super.a(this.f10047d, 0);
                return this.f10047d;
            }

            @Nullable
            public final String m17732a() {
                return m17729j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m17731a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17730a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17729j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class SchoolModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f10048d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SchoolModel.class, new Deserializer());
                }

                public Object m17735a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SchoolParser.m18310a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object schoolModel = new SchoolModel();
                    ((BaseModel) schoolModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (schoolModel instanceof Postprocessable) {
                        return ((Postprocessable) schoolModel).a();
                    }
                    return schoolModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<SchoolModel> {
                public final void m17736a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SchoolModel schoolModel = (SchoolModel) obj;
                    if (schoolModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(schoolModel.m17738a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        schoolModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SchoolParser.m18311a(schoolModel.w_(), schoolModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SchoolModel.class, new Serializer());
                }
            }

            public SchoolModel() {
                super(1);
            }

            public final void m17741a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17742a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m17737j() {
                this.f10048d = super.a(this.f10048d, 0);
                return this.f10048d;
            }

            @Nullable
            public final String m17740a() {
                return m17737j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m17739a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17738a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17737j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<NewsFeedStoryAttachmentTargetExperienceFieldsModel> {
            public final void m17743a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NewsFeedStoryAttachmentTargetExperienceFieldsModel newsFeedStoryAttachmentTargetExperienceFieldsModel = (NewsFeedStoryAttachmentTargetExperienceFieldsModel) obj;
                if (newsFeedStoryAttachmentTargetExperienceFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(newsFeedStoryAttachmentTargetExperienceFieldsModel.m17758a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    newsFeedStoryAttachmentTargetExperienceFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = newsFeedStoryAttachmentTargetExperienceFieldsModel.w_();
                int u_ = newsFeedStoryAttachmentTargetExperienceFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("employer");
                    EmployerParser.m18307a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("school");
                    SchoolParser.m18311a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("school_class");
                    SchoolClassParser.m18309a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("work_project");
                    WorkProjectParser.m18313a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NewsFeedStoryAttachmentTargetExperienceFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class WorkProjectModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f10049d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(WorkProjectModel.class, new Deserializer());
                }

                public Object m17744a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(WorkProjectParser.m18312a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object workProjectModel = new WorkProjectModel();
                    ((BaseModel) workProjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (workProjectModel instanceof Postprocessable) {
                        return ((Postprocessable) workProjectModel).a();
                    }
                    return workProjectModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<WorkProjectModel> {
                public final void m17745a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    WorkProjectModel workProjectModel = (WorkProjectModel) obj;
                    if (workProjectModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(workProjectModel.m17747a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        workProjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    WorkProjectParser.m18313a(workProjectModel.w_(), workProjectModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(WorkProjectModel.class, new Serializer());
                }
            }

            public WorkProjectModel() {
                super(1);
            }

            public final void m17750a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17751a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m17746j() {
                this.f10049d = super.a(this.f10049d, 0);
                return this.f10049d;
            }

            @Nullable
            public final String m17749a() {
                return m17746j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m17748a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17747a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17746j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public NewsFeedStoryAttachmentTargetExperienceFieldsModel() {
            super(6);
        }

        public final void m17760a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m17761a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m17752a() {
            if (this.b != null && this.f10050d == null) {
                this.f10050d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10050d;
        }

        @Nullable
        private EmployerModel m17753j() {
            this.f10051e = (EmployerModel) super.a(this.f10051e, 1, EmployerModel.class);
            return this.f10051e;
        }

        @Nullable
        private DefaultImageFieldsModel m17754k() {
            this.f10052f = (DefaultImageFieldsModel) super.a(this.f10052f, 2, DefaultImageFieldsModel.class);
            return this.f10052f;
        }

        @Nullable
        private SchoolModel m17755l() {
            this.f10053g = (SchoolModel) super.a(this.f10053g, 3, SchoolModel.class);
            return this.f10053g;
        }

        @Nullable
        private SchoolClassModel m17756m() {
            this.f10054h = (SchoolClassModel) super.a(this.f10054h, 4, SchoolClassModel.class);
            return this.f10054h;
        }

        @Nullable
        private WorkProjectModel m17757n() {
            this.f10055i = (WorkProjectModel) super.a(this.f10055i, 5, WorkProjectModel.class);
            return this.f10055i;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m17759a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17753j() != null) {
                EmployerModel employerModel = (EmployerModel) graphQLModelMutatingVisitor.b(m17753j());
                if (m17753j() != employerModel) {
                    graphQLVisitableModel = (NewsFeedStoryAttachmentTargetExperienceFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10051e = employerModel;
                }
            }
            if (m17754k() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m17754k());
                if (m17754k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (NewsFeedStoryAttachmentTargetExperienceFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10052f = defaultImageFieldsModel;
                }
            }
            if (m17755l() != null) {
                SchoolModel schoolModel = (SchoolModel) graphQLModelMutatingVisitor.b(m17755l());
                if (m17755l() != schoolModel) {
                    graphQLVisitableModel = (NewsFeedStoryAttachmentTargetExperienceFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10053g = schoolModel;
                }
            }
            if (m17756m() != null) {
                SchoolClassModel schoolClassModel = (SchoolClassModel) graphQLModelMutatingVisitor.b(m17756m());
                if (m17756m() != schoolClassModel) {
                    graphQLVisitableModel = (NewsFeedStoryAttachmentTargetExperienceFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10054h = schoolClassModel;
                }
            }
            if (m17757n() != null) {
                WorkProjectModel workProjectModel = (WorkProjectModel) graphQLModelMutatingVisitor.b(m17757n());
                if (m17757n() != workProjectModel) {
                    graphQLVisitableModel = (NewsFeedStoryAttachmentTargetExperienceFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10055i = workProjectModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17758a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17752a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17753j());
            int a3 = ModelHelper.a(flatBufferBuilder, m17754k());
            int a4 = ModelHelper.a(flatBufferBuilder, m17755l());
            int a5 = ModelHelper.a(flatBufferBuilder, m17756m());
            int a6 = ModelHelper.a(flatBufferBuilder, m17757n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -512570054)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class OpenGraphActionAttachmentTargetModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PrimaryObjectNodeModel f10066d;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OpenGraphActionAttachmentTargetModel.class, new Deserializer());
            }

            public Object m17762a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = OpenGraphActionAttachmentTargetParser.m18317a(jsonParser);
                Object openGraphActionAttachmentTargetModel = new OpenGraphActionAttachmentTargetModel();
                ((BaseModel) openGraphActionAttachmentTargetModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (openGraphActionAttachmentTargetModel instanceof Postprocessable) {
                    return ((Postprocessable) openGraphActionAttachmentTargetModel).a();
                }
                return openGraphActionAttachmentTargetModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 618113230)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class PrimaryObjectNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f10056d;
            @Nullable
            private List<String> f10057e;
            @Nullable
            private InnerApplicationFieldsModel f10058f;
            @Nullable
            private String f10059g;
            private boolean f10060h;
            @Nullable
            private List<DefaultLocationFieldsModel> f10061i;
            @Nullable
            private MusicObjectModel f10062j;
            @Nullable
            private GraphQLMusicType f10063k;
            @Nullable
            private List<MusiciansModel> f10064l;
            @Nullable
            private List<PreviewUrlsModel> f10065m;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrimaryObjectNodeModel.class, new Deserializer());
                }

                public Object m17763a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrimaryObjectNodeParser.m18315a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object primaryObjectNodeModel = new PrimaryObjectNodeModel();
                    ((BaseModel) primaryObjectNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (primaryObjectNodeModel instanceof Postprocessable) {
                        return ((Postprocessable) primaryObjectNodeModel).a();
                    }
                    return primaryObjectNodeModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<PrimaryObjectNodeModel> {
                public final void m17764a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrimaryObjectNodeModel primaryObjectNodeModel = (PrimaryObjectNodeModel) obj;
                    if (primaryObjectNodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(primaryObjectNodeModel.m17774a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        primaryObjectNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrimaryObjectNodeParser.m18316a(primaryObjectNodeModel.w_(), primaryObjectNodeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrimaryObjectNodeModel.class, new Serializer());
                }
            }

            public PrimaryObjectNodeModel() {
                super(10);
            }

            public final void m17778a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17779a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m17765j() {
                if (this.b != null && this.f10056d == null) {
                    this.f10056d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10056d;
            }

            @Nonnull
            private ImmutableList<String> m17766k() {
                this.f10057e = super.a(this.f10057e, 1);
                return (ImmutableList) this.f10057e;
            }

            @Nullable
            private InnerApplicationFieldsModel m17767l() {
                this.f10058f = (InnerApplicationFieldsModel) super.a(this.f10058f, 2, InnerApplicationFieldsModel.class);
                return this.f10058f;
            }

            @Nullable
            private String m17768m() {
                this.f10059g = super.a(this.f10059g, 3);
                return this.f10059g;
            }

            @Nonnull
            private ImmutableList<DefaultLocationFieldsModel> m17769n() {
                this.f10061i = super.a(this.f10061i, 5, DefaultLocationFieldsModel.class);
                return (ImmutableList) this.f10061i;
            }

            @Nullable
            private MusicObjectModel m17770o() {
                this.f10062j = (MusicObjectModel) super.a(this.f10062j, 6, MusicObjectModel.class);
                return this.f10062j;
            }

            @Nullable
            private GraphQLMusicType m17771p() {
                this.f10063k = (GraphQLMusicType) super.b(this.f10063k, 7, GraphQLMusicType.class, GraphQLMusicType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10063k;
            }

            @Nonnull
            private ImmutableList<MusiciansModel> m17772q() {
                this.f10064l = super.a(this.f10064l, 8, MusiciansModel.class);
                return (ImmutableList) this.f10064l;
            }

            @Nonnull
            private ImmutableList<PreviewUrlsModel> m17773r() {
                this.f10065m = super.a(this.f10065m, 9, PreviewUrlsModel.class);
                return (ImmutableList) this.f10065m;
            }

            @Nullable
            public final String m17776a() {
                return m17768m();
            }

            public final int jK_() {
                return 2433570;
            }

            public final GraphQLVisitableModel m17775a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                Builder a;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17767l() != null) {
                    InnerApplicationFieldsModel innerApplicationFieldsModel = (InnerApplicationFieldsModel) graphQLModelMutatingVisitor.b(m17767l());
                    if (m17767l() != innerApplicationFieldsModel) {
                        graphQLVisitableModel = (PrimaryObjectNodeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10058f = innerApplicationFieldsModel;
                    }
                }
                if (m17769n() != null) {
                    a = ModelHelper.a(m17769n(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PrimaryObjectNodeModel primaryObjectNodeModel = (PrimaryObjectNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        primaryObjectNodeModel.f10061i = a.b();
                        graphQLVisitableModel = primaryObjectNodeModel;
                    }
                }
                if (m17770o() != null) {
                    MusicObjectModel musicObjectModel = (MusicObjectModel) graphQLModelMutatingVisitor.b(m17770o());
                    if (m17770o() != musicObjectModel) {
                        graphQLVisitableModel = (PrimaryObjectNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10062j = musicObjectModel;
                    }
                }
                if (m17772q() != null) {
                    a = ModelHelper.a(m17772q(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        primaryObjectNodeModel = (PrimaryObjectNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        primaryObjectNodeModel.f10064l = a.b();
                        graphQLVisitableModel = primaryObjectNodeModel;
                    }
                }
                if (m17773r() != null) {
                    a = ModelHelper.a(m17773r(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        primaryObjectNodeModel = (PrimaryObjectNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        primaryObjectNodeModel.f10065m = a.b();
                        graphQLVisitableModel = primaryObjectNodeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17774a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17765j());
                int c = flatBufferBuilder.c(m17766k());
                int a2 = ModelHelper.a(flatBufferBuilder, m17767l());
                int b = flatBufferBuilder.b(m17768m());
                int a3 = ModelHelper.a(flatBufferBuilder, m17769n());
                int a4 = ModelHelper.a(flatBufferBuilder, m17770o());
                int a5 = flatBufferBuilder.a(m17771p());
                int a6 = ModelHelper.a(flatBufferBuilder, m17772q());
                int a7 = ModelHelper.a(flatBufferBuilder, m17773r());
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, c);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.a(4, this.f10060h);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.b(7, a5);
                flatBufferBuilder.b(8, a6);
                flatBufferBuilder.b(9, a7);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17777a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10060h = mutableFlatBuffer.a(i, 4);
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<OpenGraphActionAttachmentTargetModel> {
            public final void m17780a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                OpenGraphActionAttachmentTargetModel openGraphActionAttachmentTargetModel = (OpenGraphActionAttachmentTargetModel) obj;
                if (openGraphActionAttachmentTargetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(openGraphActionAttachmentTargetModel.m17782a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    openGraphActionAttachmentTargetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = openGraphActionAttachmentTargetModel.w_();
                int u_ = openGraphActionAttachmentTargetModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("primary_object_node");
                    PrimaryObjectNodeParser.m18316a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(OpenGraphActionAttachmentTargetModel.class, new Serializer());
            }
        }

        public OpenGraphActionAttachmentTargetModel() {
            super(1);
        }

        @Nullable
        private PrimaryObjectNodeModel m17781a() {
            this.f10066d = (PrimaryObjectNodeModel) super.a(this.f10066d, 0, PrimaryObjectNodeModel.class);
            return this.f10066d;
        }

        public final int jK_() {
            return -1703624614;
        }

        public final GraphQLVisitableModel m17783a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17781a() != null) {
                PrimaryObjectNodeModel primaryObjectNodeModel = (PrimaryObjectNodeModel) graphQLModelMutatingVisitor.b(m17781a());
                if (m17781a() != primaryObjectNodeModel) {
                    graphQLVisitableModel = (OpenGraphActionAttachmentTargetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10066d = primaryObjectNodeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17782a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17781a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2061874526)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class OpenGraphObjectAttachmentTargetModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f10071d;
        @Nullable
        private GraphQLMusicType f10072e;
        @Nullable
        private List<MusiciansModel> f10073f;
        @Nullable
        private List<PreviewUrlsModel> f10074g;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OpenGraphObjectAttachmentTargetModel.class, new Deserializer());
            }

            public Object m17784a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(OpenGraphObjectAttachmentTargetParser.m18326a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object openGraphObjectAttachmentTargetModel = new OpenGraphObjectAttachmentTargetModel();
                ((BaseModel) openGraphObjectAttachmentTargetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (openGraphObjectAttachmentTargetModel instanceof Postprocessable) {
                    return ((Postprocessable) openGraphObjectAttachmentTargetModel).a();
                }
                return openGraphObjectAttachmentTargetModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 415735059)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class MusiciansModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f10067d;
            @Nullable
            private String f10068e;
            @Nullable
            private String f10069f;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MusiciansModel.class, new Deserializer());
                }

                public Object m17785a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OpenGraphObjectAttachmentTargetParser.MusiciansParser.m18321b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object musiciansModel = new MusiciansModel();
                    ((BaseModel) musiciansModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (musiciansModel instanceof Postprocessable) {
                        return ((Postprocessable) musiciansModel).a();
                    }
                    return musiciansModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<MusiciansModel> {
                public final void m17786a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MusiciansModel musiciansModel = (MusiciansModel) obj;
                    if (musiciansModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(musiciansModel.m17790a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        musiciansModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OpenGraphObjectAttachmentTargetParser.MusiciansParser.m18319a(musiciansModel.w_(), musiciansModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MusiciansModel.class, new Serializer());
                }
            }

            public MusiciansModel() {
                super(3);
            }

            @Nullable
            private String m17787j() {
                this.f10067d = super.a(this.f10067d, 0);
                return this.f10067d;
            }

            @Nullable
            private String m17788k() {
                this.f10068e = super.a(this.f10068e, 1);
                return this.f10068e;
            }

            @Nullable
            private String m17789l() {
                this.f10069f = super.a(this.f10069f, 2);
                return this.f10069f;
            }

            @Nullable
            public final String m17792a() {
                return m17787j();
            }

            public final int jK_() {
                return -1304042141;
            }

            public final GraphQLVisitableModel m17791a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17790a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17787j());
                int b2 = flatBufferBuilder.b(m17788k());
                int b3 = flatBufferBuilder.b(m17789l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2144446797)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class PreviewUrlsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10070d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PreviewUrlsModel.class, new Deserializer());
                }

                public Object m17793a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OpenGraphObjectAttachmentTargetParser.PreviewUrlsParser.m18325b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object previewUrlsModel = new PreviewUrlsModel();
                    ((BaseModel) previewUrlsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (previewUrlsModel instanceof Postprocessable) {
                        return ((Postprocessable) previewUrlsModel).a();
                    }
                    return previewUrlsModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<PreviewUrlsModel> {
                public final void m17794a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PreviewUrlsModel previewUrlsModel = (PreviewUrlsModel) obj;
                    if (previewUrlsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(previewUrlsModel.m17796a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        previewUrlsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OpenGraphObjectAttachmentTargetParser.PreviewUrlsParser.m18323a(previewUrlsModel.w_(), previewUrlsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PreviewUrlsModel.class, new Serializer());
                }
            }

            public PreviewUrlsModel() {
                super(1);
            }

            @Nullable
            private String m17795a() {
                this.f10070d = super.a(this.f10070d, 0);
                return this.f10070d;
            }

            public final int jK_() {
                return 63613878;
            }

            public final GraphQLVisitableModel m17797a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17796a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17795a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<OpenGraphObjectAttachmentTargetModel> {
            public final void m17798a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                OpenGraphObjectAttachmentTargetModel openGraphObjectAttachmentTargetModel = (OpenGraphObjectAttachmentTargetModel) obj;
                if (openGraphObjectAttachmentTargetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(openGraphObjectAttachmentTargetModel.m17802a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    openGraphObjectAttachmentTargetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = openGraphObjectAttachmentTargetModel.w_();
                int u_ = openGraphObjectAttachmentTargetModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("is_music_item");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("music_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("musicians");
                    OpenGraphObjectAttachmentTargetParser.MusiciansParser.m18320a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("preview_urls");
                    OpenGraphObjectAttachmentTargetParser.PreviewUrlsParser.m18324a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(OpenGraphObjectAttachmentTargetModel.class, new Serializer());
            }
        }

        public OpenGraphObjectAttachmentTargetModel() {
            super(4);
        }

        @Nullable
        private GraphQLMusicType m17799a() {
            this.f10072e = (GraphQLMusicType) super.b(this.f10072e, 1, GraphQLMusicType.class, GraphQLMusicType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10072e;
        }

        @Nonnull
        private ImmutableList<MusiciansModel> m17800j() {
            this.f10073f = super.a(this.f10073f, 2, MusiciansModel.class);
            return (ImmutableList) this.f10073f;
        }

        @Nonnull
        private ImmutableList<PreviewUrlsModel> m17801k() {
            this.f10074g = super.a(this.f10074g, 3, PreviewUrlsModel.class);
            return (ImmutableList) this.f10074g;
        }

        public final int jK_() {
            return -1304042141;
        }

        public final GraphQLVisitableModel m17803a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17800j() != null) {
                a = ModelHelper.a(m17800j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (OpenGraphObjectAttachmentTargetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10073f = a.b();
                }
            }
            if (m17801k() != null) {
                a = ModelHelper.a(m17801k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (OpenGraphObjectAttachmentTargetModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10074g = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17802a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m17799a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17800j());
            int a3 = ModelHelper.a(flatBufferBuilder, m17801k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f10071d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17804a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10071d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2111604331)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class PlaceListAttachmentTargetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f10092d;
        @Nullable
        private ListItemsModel f10093e;
        @Nullable
        private NonSpecificPlaceToSearchModel f10094f;
        @Nullable
        private String f10095g;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceListAttachmentTargetModel.class, new Deserializer());
            }

            public Object m17805a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PlaceListAttachmentTargetParser.m18341a(jsonParser);
                Object placeListAttachmentTargetModel = new PlaceListAttachmentTargetModel();
                ((BaseModel) placeListAttachmentTargetModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (placeListAttachmentTargetModel instanceof Postprocessable) {
                    return ((Postprocessable) placeListAttachmentTargetModel).a();
                }
                return placeListAttachmentTargetModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1337179049)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class ListItemsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f10083d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ListItemsModel.class, new Deserializer());
                }

                public Object m17806a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ListItemsParser.m18335a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object listItemsModel = new ListItemsModel();
                    ((BaseModel) listItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (listItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) listItemsModel).a();
                    }
                    return listItemsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 415265282)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f10080d;
                @Nullable
                private PlaceRecommendationPageModel f10081e;
                @Nullable
                private RecommendingCommentsModel f10082f;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m17807a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ListItemsParser.NodesParser.m18333b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1137390974)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public final class PlaceRecommendationPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f10075d;
                    @Nullable
                    private DefaultLocationFieldsModel f10076e;
                    @Nullable
                    private String f10077f;

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PlaceRecommendationPageModel.class, new Deserializer());
                        }

                        public Object m17808a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PlaceRecommendationPageParser.m18327a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object placeRecommendationPageModel = new PlaceRecommendationPageModel();
                            ((BaseModel) placeRecommendationPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (placeRecommendationPageModel instanceof Postprocessable) {
                                return ((Postprocessable) placeRecommendationPageModel).a();
                            }
                            return placeRecommendationPageModel;
                        }
                    }

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Serializer extends JsonSerializer<PlaceRecommendationPageModel> {
                        public final void m17809a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PlaceRecommendationPageModel placeRecommendationPageModel = (PlaceRecommendationPageModel) obj;
                            if (placeRecommendationPageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(placeRecommendationPageModel.m17813a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                placeRecommendationPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PlaceRecommendationPageParser.m18328a(placeRecommendationPageModel.w_(), placeRecommendationPageModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(PlaceRecommendationPageModel.class, new Serializer());
                        }
                    }

                    public PlaceRecommendationPageModel() {
                        super(3);
                    }

                    public final void m17816a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m17817a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private String m17810j() {
                        this.f10075d = super.a(this.f10075d, 0);
                        return this.f10075d;
                    }

                    @Nullable
                    private DefaultLocationFieldsModel m17811k() {
                        this.f10076e = (DefaultLocationFieldsModel) super.a(this.f10076e, 1, DefaultLocationFieldsModel.class);
                        return this.f10076e;
                    }

                    @Nullable
                    private String m17812l() {
                        this.f10077f = super.a(this.f10077f, 2);
                        return this.f10077f;
                    }

                    @Nullable
                    public final String m17815a() {
                        return m17810j();
                    }

                    public final int jK_() {
                        return 2479791;
                    }

                    public final GraphQLVisitableModel m17814a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m17811k() != null) {
                            DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m17811k());
                            if (m17811k() != defaultLocationFieldsModel) {
                                graphQLVisitableModel = (PlaceRecommendationPageModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10076e = defaultLocationFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m17813a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m17810j());
                        int a = ModelHelper.a(flatBufferBuilder, m17811k());
                        int b2 = flatBufferBuilder.b(m17812l());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.b(2, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -551407010)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public final class RecommendingCommentsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<RecommendingCommentsNodesModel> f10079d;

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(RecommendingCommentsModel.class, new Deserializer());
                        }

                        public Object m17818a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(RecommendingCommentsParser.m18331a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object recommendingCommentsModel = new RecommendingCommentsModel();
                            ((BaseModel) recommendingCommentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (recommendingCommentsModel instanceof Postprocessable) {
                                return ((Postprocessable) recommendingCommentsModel).a();
                            }
                            return recommendingCommentsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1801334754)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public final class RecommendingCommentsNodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        @Nullable
                        private String f10078d;

                        /* compiled from: android_place_picker_edit_menu_suggest_edits */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(RecommendingCommentsNodesModel.class, new Deserializer());
                            }

                            public Object m17819a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(RecommendingCommentsNodesParser.m18330b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object recommendingCommentsNodesModel = new RecommendingCommentsNodesModel();
                                ((BaseModel) recommendingCommentsNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (recommendingCommentsNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) recommendingCommentsNodesModel).a();
                                }
                                return recommendingCommentsNodesModel;
                            }
                        }

                        /* compiled from: android_place_picker_edit_menu_suggest_edits */
                        public class Serializer extends JsonSerializer<RecommendingCommentsNodesModel> {
                            public final void m17820a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                RecommendingCommentsNodesModel recommendingCommentsNodesModel = (RecommendingCommentsNodesModel) obj;
                                if (recommendingCommentsNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(recommendingCommentsNodesModel.m17822a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    recommendingCommentsNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                RecommendingCommentsNodesParser.m18329a(recommendingCommentsNodesModel.w_(), recommendingCommentsNodesModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(RecommendingCommentsNodesModel.class, new Serializer());
                            }
                        }

                        public RecommendingCommentsNodesModel() {
                            super(1);
                        }

                        @Nullable
                        private String m17821j() {
                            this.f10078d = super.a(this.f10078d, 0);
                            return this.f10078d;
                        }

                        @Nullable
                        public final String m17824a() {
                            return m17821j();
                        }

                        public final int jK_() {
                            return -1679915457;
                        }

                        public final GraphQLVisitableModel m17823a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m17822a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m17821j());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Serializer extends JsonSerializer<RecommendingCommentsModel> {
                        public final void m17825a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            RecommendingCommentsModel recommendingCommentsModel = (RecommendingCommentsModel) obj;
                            if (recommendingCommentsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(recommendingCommentsModel.m17827a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                recommendingCommentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            RecommendingCommentsParser.m18332a(recommendingCommentsModel.w_(), recommendingCommentsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(RecommendingCommentsModel.class, new Serializer());
                        }
                    }

                    public RecommendingCommentsModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<RecommendingCommentsNodesModel> m17826a() {
                        this.f10079d = super.a(this.f10079d, 0, RecommendingCommentsNodesModel.class);
                        return (ImmutableList) this.f10079d;
                    }

                    public final int jK_() {
                        return -1143816053;
                    }

                    public final GraphQLVisitableModel m17828a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m17826a() != null) {
                            Builder a = ModelHelper.a(m17826a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (RecommendingCommentsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10079d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m17827a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m17826a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m17829a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m17833a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ListItemsParser.NodesParser.m18334b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(3);
                }

                @Nullable
                private String m17830j() {
                    this.f10080d = super.a(this.f10080d, 0);
                    return this.f10080d;
                }

                @Nullable
                private PlaceRecommendationPageModel m17831k() {
                    this.f10081e = (PlaceRecommendationPageModel) super.a(this.f10081e, 1, PlaceRecommendationPageModel.class);
                    return this.f10081e;
                }

                @Nullable
                private RecommendingCommentsModel m17832l() {
                    this.f10082f = (RecommendingCommentsModel) super.a(this.f10082f, 2, RecommendingCommentsModel.class);
                    return this.f10082f;
                }

                @Nullable
                public final String m17835a() {
                    return m17830j();
                }

                public final int jK_() {
                    return 2113705688;
                }

                public final GraphQLVisitableModel m17834a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17831k() != null) {
                        PlaceRecommendationPageModel placeRecommendationPageModel = (PlaceRecommendationPageModel) graphQLModelMutatingVisitor.b(m17831k());
                        if (m17831k() != placeRecommendationPageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10081e = placeRecommendationPageModel;
                        }
                    }
                    if (m17832l() != null) {
                        RecommendingCommentsModel recommendingCommentsModel = (RecommendingCommentsModel) graphQLModelMutatingVisitor.b(m17832l());
                        if (m17832l() != recommendingCommentsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f10082f = recommendingCommentsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17833a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17830j());
                    int a = ModelHelper.a(flatBufferBuilder, m17831k());
                    int a2 = ModelHelper.a(flatBufferBuilder, m17832l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<ListItemsModel> {
                public final void m17836a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ListItemsModel listItemsModel = (ListItemsModel) obj;
                    if (listItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(listItemsModel.m17838a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        listItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ListItemsParser.m18336a(listItemsModel.w_(), listItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ListItemsModel.class, new Serializer());
                }
            }

            public ListItemsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m17837a() {
                this.f10083d = super.a(this.f10083d, 0, NodesModel.class);
                return (ImmutableList) this.f10083d;
            }

            public final int jK_() {
                return 614558686;
            }

            public final GraphQLVisitableModel m17839a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17837a() != null) {
                    Builder a = ModelHelper.a(m17837a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ListItemsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10083d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17838a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17837a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1235046556)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class NonSpecificPlaceToSearchModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f10088d;
            @Nullable
            private DefaultLocationFieldsModel f10089e;
            @Nullable
            private MapBoundingBoxModel f10090f;
            @Nullable
            private String f10091g;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NonSpecificPlaceToSearchModel.class, new Deserializer());
                }

                public Object m17840a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NonSpecificPlaceToSearchParser.m18339a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object nonSpecificPlaceToSearchModel = new NonSpecificPlaceToSearchModel();
                    ((BaseModel) nonSpecificPlaceToSearchModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (nonSpecificPlaceToSearchModel instanceof Postprocessable) {
                        return ((Postprocessable) nonSpecificPlaceToSearchModel).a();
                    }
                    return nonSpecificPlaceToSearchModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1076074038)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class MapBoundingBoxModel extends BaseModel implements GraphQLVisitableModel {
                private double f10084d;
                private double f10085e;
                private double f10086f;
                private double f10087g;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MapBoundingBoxModel.class, new Deserializer());
                    }

                    public Object m17841a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MapBoundingBoxParser.m18337a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object mapBoundingBoxModel = new MapBoundingBoxModel();
                        ((BaseModel) mapBoundingBoxModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (mapBoundingBoxModel instanceof Postprocessable) {
                            return ((Postprocessable) mapBoundingBoxModel).a();
                        }
                        return mapBoundingBoxModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<MapBoundingBoxModel> {
                    public final void m17842a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MapBoundingBoxModel mapBoundingBoxModel = (MapBoundingBoxModel) obj;
                        if (mapBoundingBoxModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mapBoundingBoxModel.m17843a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mapBoundingBoxModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MapBoundingBoxParser.m18338a(mapBoundingBoxModel.w_(), mapBoundingBoxModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MapBoundingBoxModel.class, new Serializer());
                    }
                }

                public MapBoundingBoxModel() {
                    super(4);
                }

                public final int jK_() {
                    return -2036384450;
                }

                public final GraphQLVisitableModel m17844a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17843a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.a(0, this.f10084d, 0.0d);
                    flatBufferBuilder.a(1, this.f10085e, 0.0d);
                    flatBufferBuilder.a(2, this.f10086f, 0.0d);
                    flatBufferBuilder.a(3, this.f10087g, 0.0d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m17845a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f10084d = mutableFlatBuffer.a(i, 0, 0.0d);
                    this.f10085e = mutableFlatBuffer.a(i, 1, 0.0d);
                    this.f10086f = mutableFlatBuffer.a(i, 2, 0.0d);
                    this.f10087g = mutableFlatBuffer.a(i, 3, 0.0d);
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<NonSpecificPlaceToSearchModel> {
                public final void m17846a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NonSpecificPlaceToSearchModel nonSpecificPlaceToSearchModel = (NonSpecificPlaceToSearchModel) obj;
                    if (nonSpecificPlaceToSearchModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nonSpecificPlaceToSearchModel.m17851a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nonSpecificPlaceToSearchModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NonSpecificPlaceToSearchParser.m18340a(nonSpecificPlaceToSearchModel.w_(), nonSpecificPlaceToSearchModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NonSpecificPlaceToSearchModel.class, new Serializer());
                }
            }

            public NonSpecificPlaceToSearchModel() {
                super(4);
            }

            public final void m17854a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17855a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m17847j() {
                this.f10088d = super.a(this.f10088d, 0);
                return this.f10088d;
            }

            @Nullable
            private DefaultLocationFieldsModel m17848k() {
                this.f10089e = (DefaultLocationFieldsModel) super.a(this.f10089e, 1, DefaultLocationFieldsModel.class);
                return this.f10089e;
            }

            @Nullable
            private MapBoundingBoxModel m17849l() {
                this.f10090f = (MapBoundingBoxModel) super.a(this.f10090f, 2, MapBoundingBoxModel.class);
                return this.f10090f;
            }

            @Nullable
            private String m17850m() {
                this.f10091g = super.a(this.f10091g, 3);
                return this.f10091g;
            }

            @Nullable
            public final String m17853a() {
                return m17847j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m17852a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17848k() != null) {
                    DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m17848k());
                    if (m17848k() != defaultLocationFieldsModel) {
                        graphQLVisitableModel = (NonSpecificPlaceToSearchModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10089e = defaultLocationFieldsModel;
                    }
                }
                if (m17849l() != null) {
                    MapBoundingBoxModel mapBoundingBoxModel = (MapBoundingBoxModel) graphQLModelMutatingVisitor.b(m17849l());
                    if (m17849l() != mapBoundingBoxModel) {
                        graphQLVisitableModel = (NonSpecificPlaceToSearchModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10090f = mapBoundingBoxModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17851a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17847j());
                int a = ModelHelper.a(flatBufferBuilder, m17848k());
                int a2 = ModelHelper.a(flatBufferBuilder, m17849l());
                int b2 = flatBufferBuilder.b(m17850m());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<PlaceListAttachmentTargetModel> {
            public final void m17856a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PlaceListAttachmentTargetModel placeListAttachmentTargetModel = (PlaceListAttachmentTargetModel) obj;
                if (placeListAttachmentTargetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeListAttachmentTargetModel.m17861a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeListAttachmentTargetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = placeListAttachmentTargetModel.w_();
                int u_ = placeListAttachmentTargetModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("list_items");
                    ListItemsParser.m18336a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("non_specific_place_to_search");
                    NonSpecificPlaceToSearchParser.m18340a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("place_list_title");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PlaceListAttachmentTargetModel.class, new Serializer());
            }
        }

        public PlaceListAttachmentTargetModel() {
            super(4);
        }

        @Nullable
        private String m17857j() {
            this.f10092d = super.a(this.f10092d, 0);
            return this.f10092d;
        }

        @Nullable
        private ListItemsModel m17858k() {
            this.f10093e = (ListItemsModel) super.a(this.f10093e, 1, ListItemsModel.class);
            return this.f10093e;
        }

        @Nullable
        private NonSpecificPlaceToSearchModel m17859l() {
            this.f10094f = (NonSpecificPlaceToSearchModel) super.a(this.f10094f, 2, NonSpecificPlaceToSearchModel.class);
            return this.f10094f;
        }

        @Nullable
        private String m17860m() {
            this.f10095g = super.a(this.f10095g, 3);
            return this.f10095g;
        }

        @Nullable
        public final String m17863a() {
            return m17857j();
        }

        public final int jK_() {
            return -499039707;
        }

        public final GraphQLVisitableModel m17862a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17858k() != null) {
                ListItemsModel listItemsModel = (ListItemsModel) graphQLModelMutatingVisitor.b(m17858k());
                if (m17858k() != listItemsModel) {
                    graphQLVisitableModel = (PlaceListAttachmentTargetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10093e = listItemsModel;
                }
            }
            if (m17859l() != null) {
                NonSpecificPlaceToSearchModel nonSpecificPlaceToSearchModel = (NonSpecificPlaceToSearchModel) graphQLModelMutatingVisitor.b(m17859l());
                if (m17859l() != nonSpecificPlaceToSearchModel) {
                    graphQLVisitableModel = (PlaceListAttachmentTargetModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10094f = nonSpecificPlaceToSearchModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17861a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17857j());
            int a = ModelHelper.a(flatBufferBuilder, m17858k());
            int a2 = ModelHelper.a(flatBufferBuilder, m17859l());
            int b2 = flatBufferBuilder.b(m17860m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1747713378)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class QuestionOptionTargetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f10103d;
        @Nullable
        private TextWithEntitiesModel f10104e;
        private boolean f10105f;
        @Nullable
        private VotersModel f10106g;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(QuestionOptionTargetModel.class, new Deserializer());
            }

            public Object m17864a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(QuestionOptionTargetParser.m18348b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object questionOptionTargetModel = new QuestionOptionTargetModel();
                ((BaseModel) questionOptionTargetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (questionOptionTargetModel instanceof Postprocessable) {
                    return ((Postprocessable) questionOptionTargetModel).a();
                }
                return questionOptionTargetModel;
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<QuestionOptionTargetModel> {
            public final void m17865a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                QuestionOptionTargetModel questionOptionTargetModel = (QuestionOptionTargetModel) obj;
                if (questionOptionTargetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(questionOptionTargetModel.m17895a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    questionOptionTargetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                QuestionOptionTargetParser.m18349b(questionOptionTargetModel.w_(), questionOptionTargetModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(QuestionOptionTargetModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class TextWithEntitiesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10096d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TextWithEntitiesModel.class, new Deserializer());
                }

                public Object m17866a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TextWithEntitiesParser.m18342a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object textWithEntitiesModel = new TextWithEntitiesModel();
                    ((BaseModel) textWithEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (textWithEntitiesModel instanceof Postprocessable) {
                        return ((Postprocessable) textWithEntitiesModel).a();
                    }
                    return textWithEntitiesModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<TextWithEntitiesModel> {
                public final void m17867a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TextWithEntitiesModel textWithEntitiesModel = (TextWithEntitiesModel) obj;
                    if (textWithEntitiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(textWithEntitiesModel.m17869a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        textWithEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TextWithEntitiesParser.m18343a(textWithEntitiesModel.w_(), textWithEntitiesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TextWithEntitiesModel.class, new Serializer());
                }
            }

            public TextWithEntitiesModel() {
                super(1);
            }

            @Nullable
            private String m17868a() {
                this.f10096d = super.a(this.f10096d, 0);
                return this.f10096d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m17870a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17869a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17868a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -503632867)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class VotersModel extends BaseModel implements GraphQLVisitableModel {
            private int f10101d;
            @Nullable
            private List<NodesModel> f10102e;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VotersModel.class, new Deserializer());
                }

                public Object m17871a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VotersParser.m18346a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object votersModel = new VotersModel();
                    ((BaseModel) votersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (votersModel instanceof Postprocessable) {
                        return ((Postprocessable) votersModel).a();
                    }
                    return votersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 651015677)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f10097d;
                private boolean f10098e;
                @Nullable
                private String f10099f;
                @Nullable
                private DefaultImageFieldsModel f10100g;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m17872a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(VotersParser.NodesParser.m18344b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m17873a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m17877a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        VotersParser.NodesParser.m18345b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(4);
                }

                public final void m17881a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m17882a(String str, Object obj, boolean z) {
                }

                @Nullable
                private String m17874j() {
                    this.f10097d = super.a(this.f10097d, 0);
                    return this.f10097d;
                }

                @Nullable
                private String m17875k() {
                    this.f10099f = super.a(this.f10099f, 2);
                    return this.f10099f;
                }

                @Nullable
                private DefaultImageFieldsModel m17876l() {
                    this.f10100g = (DefaultImageFieldsModel) super.a(this.f10100g, 3, DefaultImageFieldsModel.class);
                    return this.f10100g;
                }

                @Nullable
                public final String m17879a() {
                    return m17874j();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m17878a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17876l() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m17876l());
                        if (m17876l() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10100g = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17877a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17874j());
                    int b2 = flatBufferBuilder.b(m17875k());
                    int a = ModelHelper.a(flatBufferBuilder, m17876l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f10098e);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, a);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m17880a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f10098e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<VotersModel> {
                public final void m17883a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VotersModel votersModel = (VotersModel) obj;
                    if (votersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(votersModel.m17886a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        votersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VotersParser.m18347a(votersModel.w_(), votersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VotersModel.class, new Serializer());
                }
            }

            public VotersModel() {
                super(2);
            }

            public final int m17885a() {
                a(0, 0);
                return this.f10101d;
            }

            public final void m17888a(int i) {
                this.f10101d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            @Nonnull
            private ImmutableList<NodesModel> m17884j() {
                this.f10102e = super.a(this.f10102e, 1, NodesModel.class);
                return (ImmutableList) this.f10102e;
            }

            public final int jK_() {
                return 280409636;
            }

            public final GraphQLVisitableModel m17887a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17884j() != null) {
                    Builder a = ModelHelper.a(m17884j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (VotersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10102e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17886a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17884j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f10101d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17889a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10101d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public QuestionOptionTargetModel() {
            super(4);
        }

        public final void m17899a(String str, ConsistencyTuple consistencyTuple) {
            if ("viewer_has_voted".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m17893l());
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
                return;
            }
            if ("voters.count".equals(str)) {
                VotersModel m = m17894m();
                if (m != null) {
                    consistencyTuple.a = Integer.valueOf(m.m17885a());
                    consistencyTuple.b = m.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            }
            consistencyTuple.a();
        }

        public final void m17900a(String str, Object obj, boolean z) {
            if ("viewer_has_voted".equals(str)) {
                m17890a(((Boolean) obj).booleanValue());
            } else if ("voters.count".equals(str)) {
                VotersModel m = m17894m();
                if (m == null) {
                    return;
                }
                if (z) {
                    m = (VotersModel) m.clone();
                    m.m17888a(((Integer) obj).intValue());
                    this.f10106g = m;
                    return;
                }
                m.m17888a(((Integer) obj).intValue());
            }
        }

        @Nullable
        private String m17891j() {
            this.f10103d = super.a(this.f10103d, 0);
            return this.f10103d;
        }

        @Nullable
        private TextWithEntitiesModel m17892k() {
            this.f10104e = (TextWithEntitiesModel) super.a(this.f10104e, 1, TextWithEntitiesModel.class);
            return this.f10104e;
        }

        private boolean m17893l() {
            a(0, 2);
            return this.f10105f;
        }

        private void m17890a(boolean z) {
            this.f10105f = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, z);
            }
        }

        @Nullable
        private VotersModel m17894m() {
            this.f10106g = (VotersModel) super.a(this.f10106g, 3, VotersModel.class);
            return this.f10106g;
        }

        @Nullable
        public final String m17897a() {
            return m17891j();
        }

        public final int jK_() {
            return 955873307;
        }

        public final GraphQLVisitableModel m17896a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17892k() != null) {
                TextWithEntitiesModel textWithEntitiesModel = (TextWithEntitiesModel) graphQLModelMutatingVisitor.b(m17892k());
                if (m17892k() != textWithEntitiesModel) {
                    graphQLVisitableModel = (QuestionOptionTargetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10104e = textWithEntitiesModel;
                }
            }
            if (m17894m() != null) {
                VotersModel votersModel = (VotersModel) graphQLModelMutatingVisitor.b(m17894m());
                if (m17894m() != votersModel) {
                    graphQLVisitableModel = (QuestionOptionTargetModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10106g = votersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17895a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17891j());
            int a = ModelHelper.a(flatBufferBuilder, m17892k());
            int a2 = ModelHelper.a(flatBufferBuilder, m17894m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.a(2, this.f10105f);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17898a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10105f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -225685603)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class QuestionTargetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private boolean f10108d;
        @Nullable
        private String f10109e;
        @Nullable
        private OptionsModel f10110f;
        @Nullable
        private GraphQLQuestionPollAnswersState f10111g;
        @Nullable
        private GraphQLQuestionResponseMethod f10112h;
        @Nullable
        private String f10113i;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(QuestionTargetModel.class, new Deserializer());
            }

            public Object m17901a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(QuestionTargetParser.m18352a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object questionTargetModel = new QuestionTargetModel();
                ((BaseModel) questionTargetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (questionTargetModel instanceof Postprocessable) {
                    return ((Postprocessable) questionTargetModel).a();
                }
                return questionTargetModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1548974711)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class OptionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<QuestionOptionTargetModel> f10107d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OptionsModel.class, new Deserializer());
                }

                public Object m17902a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OptionsParser.m18350a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object optionsModel = new OptionsModel();
                    ((BaseModel) optionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (optionsModel instanceof Postprocessable) {
                        return ((Postprocessable) optionsModel).a();
                    }
                    return optionsModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<OptionsModel> {
                public final void m17903a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OptionsModel optionsModel = (OptionsModel) obj;
                    if (optionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(optionsModel.m17905a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        optionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OptionsParser.m18351a(optionsModel.w_(), optionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(OptionsModel.class, new Serializer());
                }
            }

            public OptionsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<QuestionOptionTargetModel> m17904a() {
                this.f10107d = super.a(this.f10107d, 0, QuestionOptionTargetModel.class);
                return (ImmutableList) this.f10107d;
            }

            public final int jK_() {
                return -503668554;
            }

            public final GraphQLVisitableModel m17906a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17904a() != null) {
                    Builder a = ModelHelper.a(m17904a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (OptionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10107d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17905a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17904a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<QuestionTargetModel> {
            public final void m17907a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                QuestionTargetModel questionTargetModel = (QuestionTargetModel) obj;
                if (questionTargetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(questionTargetModel.m17913a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    questionTargetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                QuestionTargetParser.m18353a(questionTargetModel.w_(), questionTargetModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(QuestionTargetModel.class, new Serializer());
            }
        }

        public QuestionTargetModel() {
            super(6);
        }

        @Nullable
        private String m17908j() {
            this.f10109e = super.a(this.f10109e, 1);
            return this.f10109e;
        }

        @Nullable
        private OptionsModel m17909k() {
            this.f10110f = (OptionsModel) super.a(this.f10110f, 2, OptionsModel.class);
            return this.f10110f;
        }

        @Nullable
        private GraphQLQuestionPollAnswersState m17910l() {
            this.f10111g = (GraphQLQuestionPollAnswersState) super.b(this.f10111g, 3, GraphQLQuestionPollAnswersState.class, GraphQLQuestionPollAnswersState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10111g;
        }

        @Nullable
        private GraphQLQuestionResponseMethod m17911m() {
            this.f10112h = (GraphQLQuestionResponseMethod) super.b(this.f10112h, 4, GraphQLQuestionResponseMethod.class, GraphQLQuestionResponseMethod.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10112h;
        }

        @Nullable
        private String m17912n() {
            this.f10113i = super.a(this.f10113i, 5);
            return this.f10113i;
        }

        @Nullable
        public final String m17915a() {
            return m17908j();
        }

        public final int jK_() {
            return -1101225978;
        }

        public final GraphQLVisitableModel m17914a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17909k() != null) {
                OptionsModel optionsModel = (OptionsModel) graphQLModelMutatingVisitor.b(m17909k());
                if (m17909k() != optionsModel) {
                    graphQLVisitableModel = (QuestionTargetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10110f = optionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17913a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17908j());
            int a = ModelHelper.a(flatBufferBuilder, m17909k());
            int a2 = flatBufferBuilder.a(m17910l());
            int a3 = flatBufferBuilder.a(m17911m());
            int b2 = flatBufferBuilder.b(m17912n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.a(0, this.f10108d);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17916a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10108d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1275968570)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class QuoteFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private QuoteModel f10115d;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(QuoteFieldsModel.class, new Deserializer());
            }

            public Object m17917a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = QuoteFieldsParser.m18356a(jsonParser);
                Object quoteFieldsModel = new QuoteFieldsModel();
                ((BaseModel) quoteFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (quoteFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) quoteFieldsModel).a();
                }
                return quoteFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class QuoteModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10114d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(QuoteModel.class, new Deserializer());
                }

                public Object m17918a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(QuoteParser.m18354a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object quoteModel = new QuoteModel();
                    ((BaseModel) quoteModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (quoteModel instanceof Postprocessable) {
                        return ((Postprocessable) quoteModel).a();
                    }
                    return quoteModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<QuoteModel> {
                public final void m17919a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    QuoteModel quoteModel = (QuoteModel) obj;
                    if (quoteModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(quoteModel.m17921a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        quoteModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    QuoteParser.m18355a(quoteModel.w_(), quoteModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(QuoteModel.class, new Serializer());
                }
            }

            public QuoteModel() {
                super(1);
            }

            @Nullable
            private String m17920a() {
                this.f10114d = super.a(this.f10114d, 0);
                return this.f10114d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m17922a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17921a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17920a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<QuoteFieldsModel> {
            public final void m17923a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                QuoteFieldsModel quoteFieldsModel = (QuoteFieldsModel) obj;
                if (quoteFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(quoteFieldsModel.m17925a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    quoteFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = quoteFieldsModel.w_();
                int u_ = quoteFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("quote");
                    QuoteParser.m18355a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(QuoteFieldsModel.class, new Serializer());
            }
        }

        public QuoteFieldsModel() {
            super(1);
        }

        @Nullable
        private QuoteModel m17924a() {
            this.f10115d = (QuoteModel) super.a(this.f10115d, 0, QuoteModel.class);
            return this.f10115d;
        }

        public final int jK_() {
            return 514783620;
        }

        public final GraphQLVisitableModel m17926a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17924a() != null) {
                QuoteModel quoteModel = (QuoteModel) graphQLModelMutatingVisitor.b(m17924a());
                if (m17924a() != quoteModel) {
                    graphQLVisitableModel = (QuoteFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10115d = quoteModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17925a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17924a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1708439674)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class ReadingAttachmentTargetModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private String f10117d;
        @Nullable
        private PageLikersModel f10118e;
        @Nullable
        private DefaultImageFieldsModel f10119f;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReadingAttachmentTargetModel.class, new Deserializer());
            }

            public Object m17927a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReadingAttachmentTargetParser.m18359a(jsonParser);
                Object readingAttachmentTargetModel = new ReadingAttachmentTargetModel();
                ((BaseModel) readingAttachmentTargetModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (readingAttachmentTargetModel instanceof Postprocessable) {
                    return ((Postprocessable) readingAttachmentTargetModel).a();
                }
                return readingAttachmentTargetModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f10116d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
                }

                public Object m17928a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageLikersParser.m18357a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageLikersModel = new PageLikersModel();
                    ((BaseModel) pageLikersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageLikersModel instanceof Postprocessable) {
                        return ((Postprocessable) pageLikersModel).a();
                    }
                    return pageLikersModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<PageLikersModel> {
                public final void m17929a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageLikersModel pageLikersModel = (PageLikersModel) obj;
                    if (pageLikersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageLikersModel.m17930a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageLikersParser.m18358a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageLikersModel.class, new Serializer());
                }
            }

            public PageLikersModel() {
                super(1);
            }

            public final int jK_() {
                return 637021669;
            }

            public final GraphQLVisitableModel m17931a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17930a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f10116d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17932a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10116d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<ReadingAttachmentTargetModel> {
            public final void m17933a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReadingAttachmentTargetModel readingAttachmentTargetModel = (ReadingAttachmentTargetModel) obj;
                if (readingAttachmentTargetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(readingAttachmentTargetModel.m17937a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    readingAttachmentTargetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = readingAttachmentTargetModel.w_();
                int u_ = readingAttachmentTargetModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("author_text");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("page_likers");
                    PageLikersParser.m18358a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("rectangular_profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReadingAttachmentTargetModel.class, new Serializer());
            }
        }

        public ReadingAttachmentTargetModel() {
            super(3);
        }

        public final void m17939a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m17940a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m17934a() {
            this.f10117d = super.a(this.f10117d, 0);
            return this.f10117d;
        }

        @Nullable
        private PageLikersModel m17935j() {
            this.f10118e = (PageLikersModel) super.a(this.f10118e, 1, PageLikersModel.class);
            return this.f10118e;
        }

        @Nullable
        private DefaultImageFieldsModel m17936k() {
            this.f10119f = (DefaultImageFieldsModel) super.a(this.f10119f, 2, DefaultImageFieldsModel.class);
            return this.f10119f;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m17938a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17935j() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m17935j());
                if (m17935j() != pageLikersModel) {
                    graphQLVisitableModel = (ReadingAttachmentTargetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10118e = pageLikersModel;
                }
            }
            if (m17936k() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m17936k());
                if (m17936k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (ReadingAttachmentTargetModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10119f = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17937a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17934a());
            int a = ModelHelper.a(flatBufferBuilder, m17935j());
            int a2 = ModelHelper.a(flatBufferBuilder, m17936k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1630733574)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class SingleSongMusicAttachmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f10132d;
        @Nullable
        private List<String> f10133e;
        @Nullable
        private String f10134f;
        @Nullable
        private List<String> f10135g;
        @Nullable
        private String f10136h;
        private int f10137i;
        @Nullable
        private GlobalShareModel f10138j;
        @Nullable
        private String f10139k;
        @Nullable
        private String f10140l;
        @Nullable
        private OwnerModel f10141m;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SingleSongMusicAttachmentModel.class, new Deserializer());
            }

            public Object m17941a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SingleSongMusicAttachmentParser.m18368a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object singleSongMusicAttachmentModel = new SingleSongMusicAttachmentModel();
                ((BaseModel) singleSongMusicAttachmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (singleSongMusicAttachmentModel instanceof Postprocessable) {
                    return ((Postprocessable) singleSongMusicAttachmentModel).a();
                }
                return singleSongMusicAttachmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1271862969)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class GlobalShareModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f10124d;
            @Nullable
            private String f10125e;
            @Nullable
            private OpenGraphNodeModel f10126f;
            @Nullable
            private TitleModel f10127g;
            @Nullable
            private String f10128h;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GlobalShareModel.class, new Deserializer());
                }

                public Object m17942a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GlobalShareParser.m18364a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object globalShareModel = new GlobalShareModel();
                    ((BaseModel) globalShareModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (globalShareModel instanceof Postprocessable) {
                        return ((Postprocessable) globalShareModel).a();
                    }
                    return globalShareModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1125342357)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class OpenGraphNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f10120d;
                @Nullable
                private List<String> f10121e;
                @Nullable
                private String f10122f;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OpenGraphNodeModel.class, new Deserializer());
                    }

                    public Object m17943a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GlobalShareParser.OpenGraphNodeParser.m18360a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object openGraphNodeModel = new OpenGraphNodeModel();
                        ((BaseModel) openGraphNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (openGraphNodeModel instanceof Postprocessable) {
                            return ((Postprocessable) openGraphNodeModel).a();
                        }
                        return openGraphNodeModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<OpenGraphNodeModel> {
                    public final void m17944a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OpenGraphNodeModel openGraphNodeModel = (OpenGraphNodeModel) obj;
                        if (openGraphNodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(openGraphNodeModel.m17948a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            openGraphNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GlobalShareParser.OpenGraphNodeParser.m18361a(openGraphNodeModel.w_(), openGraphNodeModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(OpenGraphNodeModel.class, new Serializer());
                    }
                }

                public OpenGraphNodeModel() {
                    super(3);
                }

                public final void m17951a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m17952a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m17945j() {
                    if (this.b != null && this.f10120d == null) {
                        this.f10120d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f10120d;
                }

                @Nonnull
                private ImmutableList<String> m17946k() {
                    this.f10121e = super.a(this.f10121e, 1);
                    return (ImmutableList) this.f10121e;
                }

                @Nullable
                private String m17947l() {
                    this.f10122f = super.a(this.f10122f, 2);
                    return this.f10122f;
                }

                @Nullable
                public final String m17950a() {
                    return m17947l();
                }

                public final int jK_() {
                    return 2433570;
                }

                public final GraphQLVisitableModel m17949a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17948a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17945j());
                    int c = flatBufferBuilder.c(m17946k());
                    int b = flatBufferBuilder.b(m17947l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, c);
                    flatBufferBuilder.b(2, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<GlobalShareModel> {
                public final void m17953a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GlobalShareModel globalShareModel = (GlobalShareModel) obj;
                    if (globalShareModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(globalShareModel.m17964a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        globalShareModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GlobalShareParser.m18365a(globalShareModel.w_(), globalShareModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GlobalShareModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f10123d;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m17954a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GlobalShareParser.TitleParser.m18362a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object titleModel = new TitleModel();
                        ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (titleModel instanceof Postprocessable) {
                            return ((Postprocessable) titleModel).a();
                        }
                        return titleModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m17955a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m17957a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GlobalShareParser.TitleParser.m18363a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                private String m17956a() {
                    this.f10123d = super.a(this.f10123d, 0);
                    return this.f10123d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m17958a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17957a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17956a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public GlobalShareModel() {
                super(5);
            }

            @Nullable
            private String m17959j() {
                this.f10124d = super.a(this.f10124d, 0);
                return this.f10124d;
            }

            @Nullable
            private String m17960k() {
                this.f10125e = super.a(this.f10125e, 1);
                return this.f10125e;
            }

            @Nullable
            private OpenGraphNodeModel m17961l() {
                this.f10126f = (OpenGraphNodeModel) super.a(this.f10126f, 2, OpenGraphNodeModel.class);
                return this.f10126f;
            }

            @Nullable
            private TitleModel m17962m() {
                this.f10127g = (TitleModel) super.a(this.f10127g, 3, TitleModel.class);
                return this.f10127g;
            }

            @Nullable
            private String m17963n() {
                this.f10128h = super.a(this.f10128h, 4);
                return this.f10128h;
            }

            @Nullable
            public final String m17966a() {
                return m17960k();
            }

            public final int jK_() {
                return 514783620;
            }

            public final GraphQLVisitableModel m17965a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17961l() != null) {
                    OpenGraphNodeModel openGraphNodeModel = (OpenGraphNodeModel) graphQLModelMutatingVisitor.b(m17961l());
                    if (m17961l() != openGraphNodeModel) {
                        graphQLVisitableModel = (GlobalShareModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10126f = openGraphNodeModel;
                    }
                }
                if (m17962m() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m17962m());
                    if (m17962m() != titleModel) {
                        graphQLVisitableModel = (GlobalShareModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10127g = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17964a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17959j());
                int b2 = flatBufferBuilder.b(m17960k());
                int a = ModelHelper.a(flatBufferBuilder, m17961l());
                int a2 = ModelHelper.a(flatBufferBuilder, m17962m());
                int b3 = flatBufferBuilder.b(m17963n());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class OwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f10129d;
            @Nullable
            private String f10130e;
            @Nullable
            private String f10131f;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                }

                public Object m17967a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SingleSongMusicAttachmentParser.OwnerParser.m18366a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ownerModel = new OwnerModel();
                    ((BaseModel) ownerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ownerModel instanceof Postprocessable) {
                        return ((Postprocessable) ownerModel).a();
                    }
                    return ownerModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<OwnerModel> {
                public final void m17968a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OwnerModel ownerModel = (OwnerModel) obj;
                    if (ownerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ownerModel.m17972a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SingleSongMusicAttachmentParser.OwnerParser.m18367a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                }
            }

            public OwnerModel() {
                super(3);
            }

            public final void m17975a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17976a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m17969j() {
                if (this.b != null && this.f10129d == null) {
                    this.f10129d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10129d;
            }

            @Nullable
            private String m17970k() {
                this.f10130e = super.a(this.f10130e, 1);
                return this.f10130e;
            }

            @Nullable
            private String m17971l() {
                this.f10131f = super.a(this.f10131f, 2);
                return this.f10131f;
            }

            @Nullable
            public final String m17974a() {
                return m17970k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m17973a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17972a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17969j());
                int b = flatBufferBuilder.b(m17970k());
                int b2 = flatBufferBuilder.b(m17971l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<SingleSongMusicAttachmentModel> {
            public final void m17977a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SingleSongMusicAttachmentModel singleSongMusicAttachmentModel = (SingleSongMusicAttachmentModel) obj;
                if (singleSongMusicAttachmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(singleSongMusicAttachmentModel.m17987a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    singleSongMusicAttachmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SingleSongMusicAttachmentParser.m18369a(singleSongMusicAttachmentModel.w_(), singleSongMusicAttachmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SingleSongMusicAttachmentModel.class, new Serializer());
            }
        }

        public SingleSongMusicAttachmentModel() {
            super(10);
        }

        @Nullable
        private String m17978j() {
            this.f10132d = super.a(this.f10132d, 0);
            return this.f10132d;
        }

        @Nonnull
        private ImmutableList<String> m17979k() {
            this.f10133e = super.a(this.f10133e, 1);
            return (ImmutableList) this.f10133e;
        }

        @Nullable
        private String m17980l() {
            this.f10134f = super.a(this.f10134f, 2);
            return this.f10134f;
        }

        @Nonnull
        private ImmutableList<String> m17981m() {
            this.f10135g = super.a(this.f10135g, 3);
            return (ImmutableList) this.f10135g;
        }

        @Nullable
        private String m17982n() {
            this.f10136h = super.a(this.f10136h, 4);
            return this.f10136h;
        }

        @Nullable
        private GlobalShareModel m17983o() {
            this.f10138j = (GlobalShareModel) super.a(this.f10138j, 6, GlobalShareModel.class);
            return this.f10138j;
        }

        @Nullable
        private String m17984p() {
            this.f10139k = super.a(this.f10139k, 7);
            return this.f10139k;
        }

        @Nullable
        private String m17985q() {
            this.f10140l = super.a(this.f10140l, 8);
            return this.f10140l;
        }

        @Nullable
        private OwnerModel m17986r() {
            this.f10141m = (OwnerModel) super.a(this.f10141m, 9, OwnerModel.class);
            return this.f10141m;
        }

        @Nullable
        public final String m17989a() {
            return m17984p();
        }

        public final int jK_() {
            return -1221639264;
        }

        public final GraphQLVisitableModel m17988a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17983o() != null) {
                GlobalShareModel globalShareModel = (GlobalShareModel) graphQLModelMutatingVisitor.b(m17983o());
                if (m17983o() != globalShareModel) {
                    graphQLVisitableModel = (SingleSongMusicAttachmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10138j = globalShareModel;
                }
            }
            if (m17986r() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m17986r());
                if (m17986r() != ownerModel) {
                    graphQLVisitableModel = (SingleSongMusicAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10141m = ownerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17987a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17978j());
            int c = flatBufferBuilder.c(m17979k());
            int b2 = flatBufferBuilder.b(m17980l());
            int c2 = flatBufferBuilder.c(m17981m());
            int b3 = flatBufferBuilder.b(m17982n());
            int a = ModelHelper.a(flatBufferBuilder, m17983o());
            int b4 = flatBufferBuilder.b(m17984p());
            int b5 = flatBufferBuilder.b(m17985q());
            int a2 = ModelHelper.a(flatBufferBuilder, m17986r());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, c);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, c2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.a(5, this.f10137i, 0);
            flatBufferBuilder.b(6, a);
            flatBufferBuilder.b(7, b4);
            flatBufferBuilder.b(8, b5);
            flatBufferBuilder.b(9, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17990a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10137i = mutableFlatBuffer.a(i, 5, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -203999170)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class SouvenirsFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MediaElementsModel f10150d;
        @Nullable
        private SizeAwareMediaModel f10151e;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f10152f;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SouvenirsFieldsModel.class, new Deserializer());
            }

            public Object m17991a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SouvenirsFieldsParser.m18380a(jsonParser);
                Object souvenirsFieldsModel = new SouvenirsFieldsModel();
                ((BaseModel) souvenirsFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (souvenirsFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) souvenirsFieldsModel).a();
                }
                return souvenirsFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1365024689)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class MediaElementsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f10149d;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaElementsModel.class, new Deserializer());
                }

                public Object m17992a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaElementsParser.m18378a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaElementsModel = new MediaElementsModel();
                    ((BaseModel) mediaElementsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaElementsModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaElementsModel).a();
                    }
                    return mediaElementsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 541952535)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f10148d;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m17993a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MediaElementsParser.EdgesParser.m18376b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1145371834)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private String f10144d;
                    private boolean f10145e;
                    @Nullable
                    private SouvenirMediaModel f10146f;
                    @Nullable
                    private GraphQLSouvenirMediaFieldType f10147g;

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m17994a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(MediaElementsParser.EdgesParser.NodeParser.m18374a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodeModel = new NodeModel();
                            ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodeModel instanceof Postprocessable) {
                                return ((Postprocessable) nodeModel).a();
                            }
                            return nodeModel;
                        }
                    }

                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m17995a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m18009a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MediaElementsParser.EdgesParser.NodeParser.m18375a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1815213229)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: android_place_picker_edit_menu_suggest_edits */
                    public final class SouvenirMediaModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private List<SouvenirMediaEdgesModel> f10143d;

                        /* compiled from: android_place_picker_edit_menu_suggest_edits */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(SouvenirMediaModel.class, new Deserializer());
                            }

                            public Object m17996a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(SouvenirMediaParser.m18372a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object souvenirMediaModel = new SouvenirMediaModel();
                                ((BaseModel) souvenirMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (souvenirMediaModel instanceof Postprocessable) {
                                    return ((Postprocessable) souvenirMediaModel).a();
                                }
                                return souvenirMediaModel;
                            }
                        }

                        /* compiled from: android_place_picker_edit_menu_suggest_edits */
                        public class Serializer extends JsonSerializer<SouvenirMediaModel> {
                            public final void m17997a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                SouvenirMediaModel souvenirMediaModel = (SouvenirMediaModel) obj;
                                if (souvenirMediaModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(souvenirMediaModel.m18004a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    souvenirMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                SouvenirMediaParser.m18373a(souvenirMediaModel.w_(), souvenirMediaModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(SouvenirMediaModel.class, new Serializer());
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -477526297)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: android_place_picker_edit_menu_suggest_edits */
                        public final class SouvenirMediaEdgesModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private SizeAwareMediaModel f10142d;

                            /* compiled from: android_place_picker_edit_menu_suggest_edits */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(SouvenirMediaEdgesModel.class, new Deserializer());
                                }

                                public Object m17998a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(SouvenirMediaEdgesParser.m18370b(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object souvenirMediaEdgesModel = new SouvenirMediaEdgesModel();
                                    ((BaseModel) souvenirMediaEdgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (souvenirMediaEdgesModel instanceof Postprocessable) {
                                        return ((Postprocessable) souvenirMediaEdgesModel).a();
                                    }
                                    return souvenirMediaEdgesModel;
                                }
                            }

                            /* compiled from: android_place_picker_edit_menu_suggest_edits */
                            public class Serializer extends JsonSerializer<SouvenirMediaEdgesModel> {
                                public final void m17999a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    SouvenirMediaEdgesModel souvenirMediaEdgesModel = (SouvenirMediaEdgesModel) obj;
                                    if (souvenirMediaEdgesModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(souvenirMediaEdgesModel.m18001a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        souvenirMediaEdgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    SouvenirMediaEdgesParser.m18371b(souvenirMediaEdgesModel.w_(), souvenirMediaEdgesModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(SouvenirMediaEdgesModel.class, new Serializer());
                                }
                            }

                            public SouvenirMediaEdgesModel() {
                                super(1);
                            }

                            @Nullable
                            private SizeAwareMediaModel m18000a() {
                                this.f10142d = (SizeAwareMediaModel) super.a(this.f10142d, 0, SizeAwareMediaModel.class);
                                return this.f10142d;
                            }

                            public final int jK_() {
                                return 1607177274;
                            }

                            public final GraphQLVisitableModel m18002a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m18000a() != null) {
                                    SizeAwareMediaModel sizeAwareMediaModel = (SizeAwareMediaModel) graphQLModelMutatingVisitor.b(m18000a());
                                    if (m18000a() != sizeAwareMediaModel) {
                                        graphQLVisitableModel = (SouvenirMediaEdgesModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f10142d = sizeAwareMediaModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m18001a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m18000a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, a);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        public SouvenirMediaModel() {
                            super(1);
                        }

                        @Nonnull
                        private ImmutableList<SouvenirMediaEdgesModel> m18003a() {
                            this.f10143d = super.a(this.f10143d, 0, SouvenirMediaEdgesModel.class);
                            return (ImmutableList) this.f10143d;
                        }

                        public final int jK_() {
                            return 228004763;
                        }

                        public final GraphQLVisitableModel m18005a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m18003a() != null) {
                                Builder a = ModelHelper.a(m18003a(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    graphQLVisitableModel = (SouvenirMediaModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f10143d = a.b();
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m18004a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m18003a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    public NodeModel() {
                        super(4);
                    }

                    @Nullable
                    private String m18006j() {
                        this.f10144d = super.a(this.f10144d, 0);
                        return this.f10144d;
                    }

                    @Nullable
                    private SouvenirMediaModel m18007k() {
                        this.f10146f = (SouvenirMediaModel) super.a(this.f10146f, 2, SouvenirMediaModel.class);
                        return this.f10146f;
                    }

                    @Nullable
                    private GraphQLSouvenirMediaFieldType m18008l() {
                        this.f10147g = (GraphQLSouvenirMediaFieldType) super.b(this.f10147g, 3, GraphQLSouvenirMediaFieldType.class, GraphQLSouvenirMediaFieldType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f10147g;
                    }

                    @Nullable
                    public final String m18011a() {
                        return m18006j();
                    }

                    public final int jK_() {
                        return 1750010695;
                    }

                    public final GraphQLVisitableModel m18010a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m18007k() != null) {
                            SouvenirMediaModel souvenirMediaModel = (SouvenirMediaModel) graphQLModelMutatingVisitor.b(m18007k());
                            if (m18007k() != souvenirMediaModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10146f = souvenirMediaModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m18009a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m18006j());
                        int a = ModelHelper.a(flatBufferBuilder, m18007k());
                        int a2 = flatBufferBuilder.a(m18008l());
                        flatBufferBuilder.c(4);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.a(1, this.f10145e);
                        flatBufferBuilder.b(2, a);
                        flatBufferBuilder.b(3, a2);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m18012a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f10145e = mutableFlatBuffer.a(i, 1);
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m18013a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m18015a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MediaElementsParser.EdgesParser.m18377b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m18014a() {
                    this.f10148d = (NodeModel) super.a(this.f10148d, 0, NodeModel.class);
                    return this.f10148d;
                }

                public final int jK_() {
                    return 1549589842;
                }

                public final GraphQLVisitableModel m18016a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18014a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m18014a());
                        if (m18014a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10148d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18015a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m18014a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<MediaElementsModel> {
                public final void m18017a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaElementsModel mediaElementsModel = (MediaElementsModel) obj;
                    if (mediaElementsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaElementsModel.m18019a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaElementsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaElementsParser.m18379a(mediaElementsModel.w_(), mediaElementsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaElementsModel.class, new Serializer());
                }
            }

            public MediaElementsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m18018a() {
                this.f10149d = super.a(this.f10149d, 0, EdgesModel.class);
                return (ImmutableList) this.f10149d;
            }

            public final int jK_() {
                return 904080051;
            }

            public final GraphQLVisitableModel m18020a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18018a() != null) {
                    Builder a = ModelHelper.a(m18018a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MediaElementsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10149d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18019a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18018a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<SouvenirsFieldsModel> {
            public final void m18021a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SouvenirsFieldsModel souvenirsFieldsModel = (SouvenirsFieldsModel) obj;
                if (souvenirsFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(souvenirsFieldsModel.m18025a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    souvenirsFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = souvenirsFieldsModel.w_();
                int u_ = souvenirsFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("media_elements");
                    MediaElementsParser.m18379a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("souvenir_cover_photo");
                    SizeAwareMediaParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("title");
                    DefaultTextWithEntitiesFieldsParser.m9835a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SouvenirsFieldsModel.class, new Serializer());
            }
        }

        public SouvenirsFieldsModel() {
            super(3);
        }

        @Nullable
        private MediaElementsModel m18022a() {
            this.f10150d = (MediaElementsModel) super.a(this.f10150d, 0, MediaElementsModel.class);
            return this.f10150d;
        }

        @Nullable
        private SizeAwareMediaModel m18023j() {
            this.f10151e = (SizeAwareMediaModel) super.a(this.f10151e, 1, SizeAwareMediaModel.class);
            return this.f10151e;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m18024k() {
            this.f10152f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f10152f, 2, DefaultTextWithEntitiesFieldsModel.class);
            return this.f10152f;
        }

        public final int jK_() {
            return 1814734639;
        }

        public final GraphQLVisitableModel m18026a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18022a() != null) {
                MediaElementsModel mediaElementsModel = (MediaElementsModel) graphQLModelMutatingVisitor.b(m18022a());
                if (m18022a() != mediaElementsModel) {
                    graphQLVisitableModel = (SouvenirsFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10150d = mediaElementsModel;
                }
            }
            if (m18023j() != null) {
                SizeAwareMediaModel sizeAwareMediaModel = (SizeAwareMediaModel) graphQLModelMutatingVisitor.b(m18023j());
                if (m18023j() != sizeAwareMediaModel) {
                    graphQLVisitableModel = (SouvenirsFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10151e = sizeAwareMediaModel;
                }
            }
            if (m18024k() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m18024k());
                if (m18024k() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (SouvenirsFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10152f = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18025a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18022a());
            int a2 = ModelHelper.a(flatBufferBuilder, m18023j());
            int a3 = ModelHelper.a(flatBufferBuilder, m18024k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1499254390)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class SportsAttachmentFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private SportsMatchDataModel f10169d;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SportsAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m18027a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SportsAttachmentFieldsParser.m18387a(jsonParser);
                Object sportsAttachmentFieldsModel = new SportsAttachmentFieldsModel();
                ((BaseModel) sportsAttachmentFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (sportsAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) sportsAttachmentFieldsModel).a();
                }
                return sportsAttachmentFieldsModel;
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<SportsAttachmentFieldsModel> {
            public final void m18028a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SportsAttachmentFieldsModel sportsAttachmentFieldsModel = (SportsAttachmentFieldsModel) obj;
                if (sportsAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(sportsAttachmentFieldsModel.m18064a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    sportsAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = sportsAttachmentFieldsModel.w_();
                int u_ = sportsAttachmentFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("sports_match_data");
                    SportsMatchDataParser.m18386a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SportsAttachmentFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1724523537)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class SportsMatchDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f10157d;
            @Nullable
            private AwayTeamObjectModel f10158e;
            private int f10159f;
            @Nullable
            private String f10160g;
            @Nullable
            private String f10161h;
            @Nullable
            private String f10162i;
            @Nullable
            private HomeTeamObjectModel f10163j;
            private int f10164k;
            @Nullable
            private String f10165l;
            private int f10166m;
            @Nullable
            private String f10167n;
            @Nullable
            private String f10168o;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -132057034)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class AwayTeamObjectModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f10153d;
                @Nullable
                private SportsTeamModel f10154e;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AwayTeamObjectModel.class, new Deserializer());
                    }

                    public Object m18029a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AwayTeamObjectParser.m18381a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object awayTeamObjectModel = new AwayTeamObjectModel();
                        ((BaseModel) awayTeamObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (awayTeamObjectModel instanceof Postprocessable) {
                            return ((Postprocessable) awayTeamObjectModel).a();
                        }
                        return awayTeamObjectModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<AwayTeamObjectModel> {
                    public final void m18030a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AwayTeamObjectModel awayTeamObjectModel = (AwayTeamObjectModel) obj;
                        if (awayTeamObjectModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(awayTeamObjectModel.m18033a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            awayTeamObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AwayTeamObjectParser.m18382a(awayTeamObjectModel.w_(), awayTeamObjectModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(AwayTeamObjectModel.class, new Serializer());
                    }
                }

                public AwayTeamObjectModel() {
                    super(2);
                }

                @Nullable
                private GraphQLObjectType m18031a() {
                    if (this.b != null && this.f10153d == null) {
                        this.f10153d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f10153d;
                }

                @Nullable
                private SportsTeamModel m18032j() {
                    this.f10154e = (SportsTeamModel) super.a(this.f10154e, 1, SportsTeamModel.class);
                    return this.f10154e;
                }

                public final int jK_() {
                    return 2002223772;
                }

                public final GraphQLVisitableModel m18034a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18032j() != null) {
                        SportsTeamModel sportsTeamModel = (SportsTeamModel) graphQLModelMutatingVisitor.b(m18032j());
                        if (m18032j() != sportsTeamModel) {
                            graphQLVisitableModel = (AwayTeamObjectModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10154e = sportsTeamModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18033a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m18031a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m18032j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SportsMatchDataModel.class, new Deserializer());
                }

                public Object m18035a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SportsMatchDataParser.m18385a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sportsMatchDataModel = new SportsMatchDataModel();
                    ((BaseModel) sportsMatchDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sportsMatchDataModel instanceof Postprocessable) {
                        return ((Postprocessable) sportsMatchDataModel).a();
                    }
                    return sportsMatchDataModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -132057034)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public final class HomeTeamObjectModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f10155d;
                @Nullable
                private SportsTeamModel f10156e;

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(HomeTeamObjectModel.class, new Deserializer());
                    }

                    public Object m18036a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(HomeTeamObjectParser.m18383a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object homeTeamObjectModel = new HomeTeamObjectModel();
                        ((BaseModel) homeTeamObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (homeTeamObjectModel instanceof Postprocessable) {
                            return ((Postprocessable) homeTeamObjectModel).a();
                        }
                        return homeTeamObjectModel;
                    }
                }

                /* compiled from: android_place_picker_edit_menu_suggest_edits */
                public class Serializer extends JsonSerializer<HomeTeamObjectModel> {
                    public final void m18037a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        HomeTeamObjectModel homeTeamObjectModel = (HomeTeamObjectModel) obj;
                        if (homeTeamObjectModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(homeTeamObjectModel.m18040a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            homeTeamObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        HomeTeamObjectParser.m18384a(homeTeamObjectModel.w_(), homeTeamObjectModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(HomeTeamObjectModel.class, new Serializer());
                    }
                }

                public HomeTeamObjectModel() {
                    super(2);
                }

                @Nullable
                private GraphQLObjectType m18038a() {
                    if (this.b != null && this.f10155d == null) {
                        this.f10155d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f10155d;
                }

                @Nullable
                private SportsTeamModel m18039j() {
                    this.f10156e = (SportsTeamModel) super.a(this.f10156e, 1, SportsTeamModel.class);
                    return this.f10156e;
                }

                public final int jK_() {
                    return 2002223772;
                }

                public final GraphQLVisitableModel m18041a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18039j() != null) {
                        SportsTeamModel sportsTeamModel = (SportsTeamModel) graphQLModelMutatingVisitor.b(m18039j());
                        if (m18039j() != sportsTeamModel) {
                            graphQLVisitableModel = (HomeTeamObjectModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10156e = sportsTeamModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18040a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m18038a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m18039j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<SportsMatchDataModel> {
                public final void m18042a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SportsMatchDataModel sportsMatchDataModel = (SportsMatchDataModel) obj;
                    if (sportsMatchDataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sportsMatchDataModel.m18057a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sportsMatchDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SportsMatchDataParser.m18386a(sportsMatchDataModel.w_(), sportsMatchDataModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SportsMatchDataModel.class, new Serializer());
                }
            }

            public SportsMatchDataModel() {
                super(12);
            }

            public final void m18061a(String str, ConsistencyTuple consistencyTuple) {
                if ("away_team_score".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m18048l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                } else if ("home_team_score".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m18053q());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 7;
                } else if ("status_text".equals(str)) {
                    consistencyTuple.a = m18056t();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 11;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m18062a(String str, Object obj, boolean z) {
                if ("away_team_score".equals(str)) {
                    m18043a(((Integer) obj).intValue());
                } else if ("home_team_score".equals(str)) {
                    m18045b(((Integer) obj).intValue());
                } else if ("status_text".equals(str)) {
                    m18044a((String) obj);
                }
            }

            @Nullable
            private String m18046j() {
                this.f10157d = super.a(this.f10157d, 0);
                return this.f10157d;
            }

            @Nullable
            private AwayTeamObjectModel m18047k() {
                this.f10158e = (AwayTeamObjectModel) super.a(this.f10158e, 1, AwayTeamObjectModel.class);
                return this.f10158e;
            }

            private int m18048l() {
                a(0, 2);
                return this.f10159f;
            }

            private void m18043a(int i) {
                this.f10159f = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 2, i);
                }
            }

            @Nullable
            private String m18049m() {
                this.f10160g = super.a(this.f10160g, 3);
                return this.f10160g;
            }

            @Nullable
            private String m18050n() {
                this.f10161h = super.a(this.f10161h, 4);
                return this.f10161h;
            }

            @Nullable
            private String m18051o() {
                this.f10162i = super.a(this.f10162i, 5);
                return this.f10162i;
            }

            @Nullable
            private HomeTeamObjectModel m18052p() {
                this.f10163j = (HomeTeamObjectModel) super.a(this.f10163j, 6, HomeTeamObjectModel.class);
                return this.f10163j;
            }

            private int m18053q() {
                a(0, 7);
                return this.f10164k;
            }

            private void m18045b(int i) {
                this.f10164k = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 7, i);
                }
            }

            @Nullable
            private String m18054r() {
                this.f10165l = super.a(this.f10165l, 8);
                return this.f10165l;
            }

            @Nullable
            private String m18055s() {
                this.f10167n = super.a(this.f10167n, 10);
                return this.f10167n;
            }

            @Nullable
            private String m18056t() {
                this.f10168o = super.a(this.f10168o, 11);
                return this.f10168o;
            }

            private void m18044a(@Nullable String str) {
                this.f10168o = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 11, str);
                }
            }

            @Nullable
            public final String m18059a() {
                return m18054r();
            }

            public final int jK_() {
                return 827365670;
            }

            public final GraphQLVisitableModel m18058a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18047k() != null) {
                    AwayTeamObjectModel awayTeamObjectModel = (AwayTeamObjectModel) graphQLModelMutatingVisitor.b(m18047k());
                    if (m18047k() != awayTeamObjectModel) {
                        graphQLVisitableModel = (SportsMatchDataModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10158e = awayTeamObjectModel;
                    }
                }
                if (m18052p() != null) {
                    HomeTeamObjectModel homeTeamObjectModel = (HomeTeamObjectModel) graphQLModelMutatingVisitor.b(m18052p());
                    if (m18052p() != homeTeamObjectModel) {
                        graphQLVisitableModel = (SportsMatchDataModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10163j = homeTeamObjectModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18057a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18046j());
                int a = ModelHelper.a(flatBufferBuilder, m18047k());
                int b2 = flatBufferBuilder.b(m18049m());
                int b3 = flatBufferBuilder.b(m18050n());
                int b4 = flatBufferBuilder.b(m18051o());
                int a2 = ModelHelper.a(flatBufferBuilder, m18052p());
                int b5 = flatBufferBuilder.b(m18054r());
                int b6 = flatBufferBuilder.b(m18055s());
                int b7 = flatBufferBuilder.b(m18056t());
                flatBufferBuilder.c(12);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.a(2, this.f10159f, 0);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, b4);
                flatBufferBuilder.b(6, a2);
                flatBufferBuilder.a(7, this.f10164k, 0);
                flatBufferBuilder.b(8, b5);
                flatBufferBuilder.a(9, this.f10166m, 0);
                flatBufferBuilder.b(10, b6);
                flatBufferBuilder.b(11, b7);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18060a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10159f = mutableFlatBuffer.a(i, 2, 0);
                this.f10164k = mutableFlatBuffer.a(i, 7, 0);
                this.f10166m = mutableFlatBuffer.a(i, 9, 0);
            }
        }

        public SportsAttachmentFieldsModel() {
            super(1);
        }

        public final void m18066a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18067a(String str, Object obj, boolean z) {
        }

        @Nullable
        private SportsMatchDataModel m18063a() {
            this.f10169d = (SportsMatchDataModel) super.a(this.f10169d, 0, SportsMatchDataModel.class);
            return this.f10169d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18065a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18063a() != null) {
                SportsMatchDataModel sportsMatchDataModel = (SportsMatchDataModel) graphQLModelMutatingVisitor.b(m18063a());
                if (m18063a() != sportsMatchDataModel) {
                    graphQLVisitableModel = (SportsAttachmentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10169d = sportsMatchDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18064a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18063a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 93133257)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class SportsTeamModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f10170d;
        @Nullable
        private String f10171e;
        @Nullable
        private DefaultImageFieldsModel f10172f;
        @Nullable
        private String f10173g;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SportsTeamModel.class, new Deserializer());
            }

            public Object m18068a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SportsTeamParser.m18388a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object sportsTeamModel = new SportsTeamModel();
                ((BaseModel) sportsTeamModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (sportsTeamModel instanceof Postprocessable) {
                    return ((Postprocessable) sportsTeamModel).a();
                }
                return sportsTeamModel;
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<SportsTeamModel> {
            public final void m18069a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SportsTeamModel sportsTeamModel = (SportsTeamModel) obj;
                if (sportsTeamModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(sportsTeamModel.m18074a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    sportsTeamModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SportsTeamParser.m18389a(sportsTeamModel.w_(), sportsTeamModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SportsTeamModel.class, new Serializer());
            }
        }

        public SportsTeamModel() {
            super(4);
        }

        public final void m18077a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18078a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m18070j() {
            this.f10170d = super.a(this.f10170d, 0);
            return this.f10170d;
        }

        @Nullable
        private String m18071k() {
            this.f10171e = super.a(this.f10171e, 1);
            return this.f10171e;
        }

        @Nullable
        private DefaultImageFieldsModel m18072l() {
            this.f10172f = (DefaultImageFieldsModel) super.a(this.f10172f, 2, DefaultImageFieldsModel.class);
            return this.f10172f;
        }

        @Nullable
        private String m18073m() {
            this.f10173g = super.a(this.f10173g, 3);
            return this.f10173g;
        }

        @Nullable
        public final String m18076a() {
            return m18070j();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18075a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18072l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m18072l());
                if (m18072l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SportsTeamModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10172f = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18074a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m18070j());
            int b2 = flatBufferBuilder.b(m18071k());
            int a = ModelHelper.a(flatBufferBuilder, m18072l());
            int b3 = flatBufferBuilder.b(m18073m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 860633354)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class StoryAttachmentAppAdLinkTargetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f10176d;
        @Nullable
        private RatingModel f10177e;
        @Nullable
        private String f10178f;

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StoryAttachmentAppAdLinkTargetModel.class, new Deserializer());
            }

            public Object m18079a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = StoryAttachmentAppAdLinkTargetParser.m18392a(jsonParser);
                Object storyAttachmentAppAdLinkTargetModel = new StoryAttachmentAppAdLinkTargetModel();
                ((BaseModel) storyAttachmentAppAdLinkTargetModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (storyAttachmentAppAdLinkTargetModel instanceof Postprocessable) {
                    return ((Postprocessable) storyAttachmentAppAdLinkTargetModel).a();
                }
                return storyAttachmentAppAdLinkTargetModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -963013398)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class RatingModel extends BaseModel implements GraphQLVisitableModel {
            private int f10174d;
            private double f10175e;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RatingModel.class, new Deserializer());
                }

                public Object m18080a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RatingParser.m18390a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ratingModel = new RatingModel();
                    ((BaseModel) ratingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ratingModel instanceof Postprocessable) {
                        return ((Postprocessable) ratingModel).a();
                    }
                    return ratingModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<RatingModel> {
                public final void m18081a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RatingModel ratingModel = (RatingModel) obj;
                    if (ratingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ratingModel.m18082a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ratingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RatingParser.m18391a(ratingModel.w_(), ratingModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RatingModel.class, new Serializer());
                }
            }

            public RatingModel() {
                super(2);
            }

            public final int jK_() {
                return -1854235203;
            }

            public final GraphQLVisitableModel m18083a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18082a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f10174d, 0);
                flatBufferBuilder.a(1, this.f10175e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18084a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10174d = mutableFlatBuffer.a(i, 0, 0);
                this.f10175e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<StoryAttachmentAppAdLinkTargetModel> {
            public final void m18085a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                StoryAttachmentAppAdLinkTargetModel storyAttachmentAppAdLinkTargetModel = (StoryAttachmentAppAdLinkTargetModel) obj;
                if (storyAttachmentAppAdLinkTargetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(storyAttachmentAppAdLinkTargetModel.m18089a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    storyAttachmentAppAdLinkTargetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = storyAttachmentAppAdLinkTargetModel.w_();
                int u_ = storyAttachmentAppAdLinkTargetModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("rating");
                    RatingParser.m18391a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(StoryAttachmentAppAdLinkTargetModel.class, new Serializer());
            }
        }

        public StoryAttachmentAppAdLinkTargetModel() {
            super(3);
        }

        @Nullable
        private String m18086j() {
            this.f10176d = super.a(this.f10176d, 0);
            return this.f10176d;
        }

        @Nullable
        private RatingModel m18087k() {
            this.f10177e = (RatingModel) super.a(this.f10177e, 1, RatingModel.class);
            return this.f10177e;
        }

        @Nullable
        private String m18088l() {
            this.f10178f = super.a(this.f10178f, 2);
            return this.f10178f;
        }

        @Nullable
        public final String m18091a() {
            return m18086j();
        }

        public final int jK_() {
            return -1035968689;
        }

        public final GraphQLVisitableModel m18090a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18087k() != null) {
                RatingModel ratingModel = (RatingModel) graphQLModelMutatingVisitor.b(m18087k());
                if (m18087k() != ratingModel) {
                    graphQLVisitableModel = (StoryAttachmentAppAdLinkTargetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10177e = ratingModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18089a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m18086j());
            int a = ModelHelper.a(flatBufferBuilder, m18087k());
            int b2 = flatBufferBuilder.b(m18088l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1715234912)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class ThrowbackMediaAttachmentFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<AttachmentPropertiesModel> f10207d;
        @Nullable
        private MediaModel f10208e;
        @Nullable
        private List<CollagePhotoAttachmentStyleInfoFieldsModel> f10209f;
        @Nullable
        private List<GraphQLStoryAttachmentStyle> f10210g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2099130720)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class AttachmentPropertiesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10179d;
            @Nullable
            private String f10180e;
            @Nullable
            private String f10181f;
            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel f10182g;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttachmentPropertiesModel.class, new Deserializer());
                }

                public Object m18092a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttachmentPropertiesParser.m18393b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object attachmentPropertiesModel = new AttachmentPropertiesModel();
                    ((BaseModel) attachmentPropertiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (attachmentPropertiesModel instanceof Postprocessable) {
                        return ((Postprocessable) attachmentPropertiesModel).a();
                    }
                    return attachmentPropertiesModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<AttachmentPropertiesModel> {
                public final void m18093a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttachmentPropertiesModel attachmentPropertiesModel = (AttachmentPropertiesModel) obj;
                    if (attachmentPropertiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attachmentPropertiesModel.m18098a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attachmentPropertiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttachmentPropertiesParser.m18394b(attachmentPropertiesModel.w_(), attachmentPropertiesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttachmentPropertiesModel.class, new Serializer());
                }
            }

            public AttachmentPropertiesModel() {
                super(4);
            }

            @Nullable
            private String m18094a() {
                this.f10179d = super.a(this.f10179d, 0);
                return this.f10179d;
            }

            @Nullable
            private String m18095j() {
                this.f10180e = super.a(this.f10180e, 1);
                return this.f10180e;
            }

            @Nullable
            private String m18096k() {
                this.f10181f = super.a(this.f10181f, 2);
                return this.f10181f;
            }

            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel m18097l() {
                this.f10182g = (DefaultTextWithEntitiesWithRangesFieldsModel) super.a(this.f10182g, 3, DefaultTextWithEntitiesWithRangesFieldsModel.class);
                return this.f10182g;
            }

            public final int jK_() {
                return -363494344;
            }

            public final GraphQLVisitableModel m18099a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18097l() != null) {
                    DefaultTextWithEntitiesWithRangesFieldsModel defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m18097l());
                    if (m18097l() != defaultTextWithEntitiesWithRangesFieldsModel) {
                        graphQLVisitableModel = (AttachmentPropertiesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10182g = defaultTextWithEntitiesWithRangesFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18098a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18094a());
                int b2 = flatBufferBuilder.b(m18095j());
                int b3 = flatBufferBuilder.b(m18096k());
                int a = ModelHelper.a(flatBufferBuilder, m18097l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThrowbackMediaAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m18100a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ThrowbackMediaAttachmentFieldsParser.m18399b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object throwbackMediaAttachmentFieldsModel = new ThrowbackMediaAttachmentFieldsModel();
                ((BaseModel) throwbackMediaAttachmentFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (throwbackMediaAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) throwbackMediaAttachmentFieldsModel).a();
                }
                return throwbackMediaAttachmentFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1066505837)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class MediaModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SizeAwareMedia {
            private int f10183A;
            @Nullable
            private GraphQLObjectType f10184d;
            private int f10185e;
            private int f10186f;
            @Nullable
            private String f10187g;
            private long f10188h;
            @Nullable
            private DefaultVect2FieldsModel f10189i;
            private int f10190j;
            private int f10191k;
            private int f10192l;
            @Nullable
            private String f10193m;
            @Nullable
            private DefaultImageFieldsModel f10194n;
            @Nullable
            private DefaultImageFieldsModel f10195o;
            @Nullable
            private DefaultImageFieldsModel f10196p;
            @Nullable
            private DefaultImageFieldsModel f10197q;
            @Nullable
            private DefaultImageFieldsModel f10198r;
            @Nullable
            private DefaultImageFieldsModel f10199s;
            private boolean f10200t;
            private boolean f10201u;
            private boolean f10202v;
            @Nullable
            private String f10203w;
            @Nullable
            private String f10204x;
            private int f10205y;
            @Nullable
            private String f10206z;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                }

                public Object m18101a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaParser.m18395a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaModel = new MediaModel();
                    ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaModel).a();
                    }
                    return mediaModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<MediaModel> {
                public final void m18102a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaModel mediaModel = (MediaModel) obj;
                    if (mediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaModel.m18114a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaParser.m18396a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields bc_() {
                return m18109p();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields bd_() {
                return m18108o();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields be_() {
                return m18105l();
            }

            @Nullable
            public final /* synthetic */ DefaultVect2Fields m18119c() {
                return m18104k();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m18121g() {
                return m18106m();
            }

            public MediaModel() {
                super(24);
            }

            @Nullable
            public final GraphQLObjectType m18118b() {
                if (this.b != null && this.f10184d == null) {
                    this.f10184d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10184d;
            }

            @Nullable
            private String m18103j() {
                this.f10187g = super.a(this.f10187g, 3);
                return this.f10187g;
            }

            @Nullable
            private DefaultVect2FieldsModel m18104k() {
                this.f10189i = (DefaultVect2FieldsModel) super.a(this.f10189i, 5, DefaultVect2FieldsModel.class);
                return this.f10189i;
            }

            @Nullable
            public final String m18120d() {
                this.f10193m = super.a(this.f10193m, 9);
                return this.f10193m;
            }

            @Nullable
            private DefaultImageFieldsModel m18105l() {
                this.f10194n = (DefaultImageFieldsModel) super.a(this.f10194n, 10, DefaultImageFieldsModel.class);
                return this.f10194n;
            }

            @Nullable
            private DefaultImageFieldsModel m18106m() {
                this.f10195o = (DefaultImageFieldsModel) super.a(this.f10195o, 11, DefaultImageFieldsModel.class);
                return this.f10195o;
            }

            @Nullable
            private DefaultImageFieldsModel m18107n() {
                this.f10196p = (DefaultImageFieldsModel) super.a(this.f10196p, 12, DefaultImageFieldsModel.class);
                return this.f10196p;
            }

            @Nullable
            private DefaultImageFieldsModel m18108o() {
                this.f10197q = (DefaultImageFieldsModel) super.a(this.f10197q, 13, DefaultImageFieldsModel.class);
                return this.f10197q;
            }

            @Nullable
            private DefaultImageFieldsModel m18109p() {
                this.f10198r = (DefaultImageFieldsModel) super.a(this.f10198r, 14, DefaultImageFieldsModel.class);
                return this.f10198r;
            }

            @Nullable
            private DefaultImageFieldsModel m18110q() {
                this.f10199s = (DefaultImageFieldsModel) super.a(this.f10199s, 15, DefaultImageFieldsModel.class);
                return this.f10199s;
            }

            @Nullable
            private String m18111r() {
                this.f10203w = super.a(this.f10203w, 19);
                return this.f10203w;
            }

            @Nullable
            private String m18112s() {
                this.f10204x = super.a(this.f10204x, 20);
                return this.f10204x;
            }

            @Nullable
            private String m18113t() {
                this.f10206z = super.a(this.f10206z, 22);
                return this.f10206z;
            }

            @Nullable
            public final String m18116a() {
                return m18120d();
            }

            public final int jK_() {
                return 74219460;
            }

            public final GraphQLVisitableModel m18115a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultImageFieldsModel defaultImageFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18104k() != null) {
                    DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m18104k());
                    if (m18104k() != defaultVect2FieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10189i = defaultVect2FieldsModel;
                    }
                }
                if (m18105l() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m18105l());
                    if (m18105l() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10194n = defaultImageFieldsModel;
                    }
                }
                if (m18106m() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m18106m());
                    if (m18106m() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10195o = defaultImageFieldsModel;
                    }
                }
                if (m18107n() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m18107n());
                    if (m18107n() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10196p = defaultImageFieldsModel;
                    }
                }
                if (m18108o() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m18108o());
                    if (m18108o() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10197q = defaultImageFieldsModel;
                    }
                }
                if (m18109p() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m18109p());
                    if (m18109p() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10198r = defaultImageFieldsModel;
                    }
                }
                if (m18110q() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m18110q());
                    if (m18110q() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10199s = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18114a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18118b());
                int b = flatBufferBuilder.b(m18103j());
                int a2 = ModelHelper.a(flatBufferBuilder, m18104k());
                int b2 = flatBufferBuilder.b(m18120d());
                int a3 = ModelHelper.a(flatBufferBuilder, m18105l());
                int a4 = ModelHelper.a(flatBufferBuilder, m18106m());
                int a5 = ModelHelper.a(flatBufferBuilder, m18107n());
                int a6 = ModelHelper.a(flatBufferBuilder, m18108o());
                int a7 = ModelHelper.a(flatBufferBuilder, m18109p());
                int a8 = ModelHelper.a(flatBufferBuilder, m18110q());
                int b3 = flatBufferBuilder.b(m18111r());
                int b4 = flatBufferBuilder.b(m18112s());
                int b5 = flatBufferBuilder.b(m18113t());
                flatBufferBuilder.c(24);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f10185e, 0);
                flatBufferBuilder.a(2, this.f10186f, 0);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.a(4, this.f10188h, 0);
                flatBufferBuilder.b(5, a2);
                flatBufferBuilder.a(6, this.f10190j, 0);
                flatBufferBuilder.a(7, this.f10191k, 0);
                flatBufferBuilder.a(8, this.f10192l, 0);
                flatBufferBuilder.b(9, b2);
                flatBufferBuilder.b(10, a3);
                flatBufferBuilder.b(11, a4);
                flatBufferBuilder.b(12, a5);
                flatBufferBuilder.b(13, a6);
                flatBufferBuilder.b(14, a7);
                flatBufferBuilder.b(15, a8);
                flatBufferBuilder.a(16, this.f10200t);
                flatBufferBuilder.a(17, this.f10201u);
                flatBufferBuilder.a(18, this.f10202v);
                flatBufferBuilder.b(19, b3);
                flatBufferBuilder.b(20, b4);
                flatBufferBuilder.a(21, this.f10205y, 0);
                flatBufferBuilder.b(22, b5);
                flatBufferBuilder.a(23, this.f10183A, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18117a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10185e = mutableFlatBuffer.a(i, 1, 0);
                this.f10186f = mutableFlatBuffer.a(i, 2, 0);
                this.f10188h = mutableFlatBuffer.a(i, 4, 0);
                this.f10190j = mutableFlatBuffer.a(i, 6, 0);
                this.f10191k = mutableFlatBuffer.a(i, 7, 0);
                this.f10192l = mutableFlatBuffer.a(i, 8, 0);
                this.f10200t = mutableFlatBuffer.a(i, 16);
                this.f10201u = mutableFlatBuffer.a(i, 17);
                this.f10202v = mutableFlatBuffer.a(i, 18);
                this.f10205y = mutableFlatBuffer.a(i, 21, 0);
                this.f10183A = mutableFlatBuffer.a(i, 23, 0);
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<ThrowbackMediaAttachmentFieldsModel> {
            public final void m18122a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ThrowbackMediaAttachmentFieldsModel throwbackMediaAttachmentFieldsModel = (ThrowbackMediaAttachmentFieldsModel) obj;
                if (throwbackMediaAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(throwbackMediaAttachmentFieldsModel.m18127a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    throwbackMediaAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ThrowbackMediaAttachmentFieldsParser.m18400b(throwbackMediaAttachmentFieldsModel.w_(), throwbackMediaAttachmentFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ThrowbackMediaAttachmentFieldsModel.class, new Serializer());
            }
        }

        public ThrowbackMediaAttachmentFieldsModel() {
            super(4);
        }

        @Nonnull
        private ImmutableList<AttachmentPropertiesModel> m18123a() {
            this.f10207d = super.a(this.f10207d, 0, AttachmentPropertiesModel.class);
            return (ImmutableList) this.f10207d;
        }

        @Nullable
        private MediaModel m18124j() {
            this.f10208e = (MediaModel) super.a(this.f10208e, 1, MediaModel.class);
            return this.f10208e;
        }

        @Nonnull
        private ImmutableList<CollagePhotoAttachmentStyleInfoFieldsModel> m18125k() {
            this.f10209f = super.a(this.f10209f, 2, CollagePhotoAttachmentStyleInfoFieldsModel.class);
            return (ImmutableList) this.f10209f;
        }

        @Nonnull
        private ImmutableList<GraphQLStoryAttachmentStyle> m18126l() {
            this.f10210g = super.c(this.f10210g, 3, GraphQLStoryAttachmentStyle.class);
            return (ImmutableList) this.f10210g;
        }

        public final int jK_() {
            return -1267730472;
        }

        public final GraphQLVisitableModel m18128a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            ThrowbackMediaAttachmentFieldsModel throwbackMediaAttachmentFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel;
            MediaModel mediaModel;
            Builder a;
            h();
            if (m18123a() != null) {
                Builder a2 = ModelHelper.a(m18123a(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    throwbackMediaAttachmentFieldsModel = (ThrowbackMediaAttachmentFieldsModel) ModelHelper.a(null, this);
                    throwbackMediaAttachmentFieldsModel.f10207d = a2.b();
                    graphQLVisitableModel = throwbackMediaAttachmentFieldsModel;
                    if (m18124j() != null) {
                        mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m18124j());
                        if (m18124j() != mediaModel) {
                            graphQLVisitableModel = (ThrowbackMediaAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f10208e = mediaModel;
                        }
                    }
                    if (m18125k() != null) {
                        a = ModelHelper.a(m18125k(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            throwbackMediaAttachmentFieldsModel = (ThrowbackMediaAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            throwbackMediaAttachmentFieldsModel.f10209f = a.b();
                            graphQLVisitableModel = throwbackMediaAttachmentFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m18124j() != null) {
                mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m18124j());
                if (m18124j() != mediaModel) {
                    graphQLVisitableModel = (ThrowbackMediaAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10208e = mediaModel;
                }
            }
            if (m18125k() != null) {
                a = ModelHelper.a(m18125k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    throwbackMediaAttachmentFieldsModel = (ThrowbackMediaAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    throwbackMediaAttachmentFieldsModel.f10209f = a.b();
                    graphQLVisitableModel = throwbackMediaAttachmentFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m18127a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18123a());
            int a2 = ModelHelper.a(flatBufferBuilder, m18124j());
            int a3 = ModelHelper.a(flatBufferBuilder, m18125k());
            int d = flatBufferBuilder.d(m18126l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, d);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1216567904)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_edit_menu_suggest_edits */
    public final class TravelAttachmentFieldsModel extends BaseModel implements TravelAttachmentFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10217d;
        @Nullable
        private AddressModel f10218e;
        @Nullable
        private List<String> f10219f;
        @Nullable
        private CityModel f10220g;
        @Nullable
        private String f10221h;
        private boolean f10222i;
        @Nullable
        private DefaultLocationFieldsModel f10223j;
        @Nullable
        private MapBoundingBoxModel f10224k;
        @Nullable
        private String f10225l;
        @Nullable
        private OverallStarRatingModel f10226m;
        @Nullable
        private PageVisitsModel f10227n;
        private boolean f10228o;
        @Nullable
        private SavableTimelineAppCollectionExtraFieldsModel f10229p;
        private boolean f10230q;
        @Nullable
        private GraphQLPageSuperCategoryType f10231r;
        @Nullable
        private String f10232s;
        @Nullable
        private GraphQLSavedState f10233t;
        @Nullable
        private ViewerVisitsModel f10234u;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 516123755)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10211d;
            @Nullable
            private String f10212e;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                }

                public Object m18129a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TravelAttachmentFieldsParser.AddressParser.m18401a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object addressModel = new AddressModel();
                    ((BaseModel) addressModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (addressModel instanceof Postprocessable) {
                        return ((Postprocessable) addressModel).a();
                    }
                    return addressModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<AddressModel> {
                public final void m18130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddressModel addressModel = (AddressModel) obj;
                    if (addressModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addressModel.m18132a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TravelAttachmentFieldsParser.AddressParser.m18402a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AddressModel.class, new Serializer());
                }
            }

            public AddressModel() {
                super(2);
            }

            @Nullable
            public final String m18134a() {
                this.f10211d = super.a(this.f10211d, 0);
                return this.f10211d;
            }

            public final void m18135a(@Nullable String str) {
                this.f10211d = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 0, str);
                }
            }

            @Nullable
            private String m18131j() {
                this.f10212e = super.a(this.f10212e, 1);
                return this.f10212e;
            }

            public final int jK_() {
                return 799251025;
            }

            public final GraphQLVisitableModel m18133a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18132a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18134a());
                int b2 = flatBufferBuilder.b(m18131j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TravelAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m18136a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TravelAttachmentFieldsParser.m18405a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object travelAttachmentFieldsModel = new TravelAttachmentFieldsModel();
                ((BaseModel) travelAttachmentFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (travelAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) travelAttachmentFieldsModel).a();
                }
                return travelAttachmentFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1076074038)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public final class MapBoundingBoxModel extends BaseModel implements GraphQLVisitableModel {
            private double f10213d;
            private double f10214e;
            private double f10215f;
            private double f10216g;

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MapBoundingBoxModel.class, new Deserializer());
                }

                public Object m18137a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TravelAttachmentFieldsParser.MapBoundingBoxParser.m18403a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mapBoundingBoxModel = new MapBoundingBoxModel();
                    ((BaseModel) mapBoundingBoxModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mapBoundingBoxModel instanceof Postprocessable) {
                        return ((Postprocessable) mapBoundingBoxModel).a();
                    }
                    return mapBoundingBoxModel;
                }
            }

            /* compiled from: android_place_picker_edit_menu_suggest_edits */
            public class Serializer extends JsonSerializer<MapBoundingBoxModel> {
                public final void m18138a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MapBoundingBoxModel mapBoundingBoxModel = (MapBoundingBoxModel) obj;
                    if (mapBoundingBoxModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mapBoundingBoxModel.m18139a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mapBoundingBoxModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TravelAttachmentFieldsParser.MapBoundingBoxParser.m18404a(mapBoundingBoxModel.w_(), mapBoundingBoxModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MapBoundingBoxModel.class, new Serializer());
                }
            }

            public MapBoundingBoxModel() {
                super(4);
            }

            public final int jK_() {
                return -2036384450;
            }

            public final GraphQLVisitableModel m18140a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18139a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f10213d, 0.0d);
                flatBufferBuilder.a(1, this.f10214e, 0.0d);
                flatBufferBuilder.a(2, this.f10215f, 0.0d);
                flatBufferBuilder.a(3, this.f10216g, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18141a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10213d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f10214e = mutableFlatBuffer.a(i, 1, 0.0d);
                this.f10215f = mutableFlatBuffer.a(i, 2, 0.0d);
                this.f10216g = mutableFlatBuffer.a(i, 3, 0.0d);
            }
        }

        /* compiled from: android_place_picker_edit_menu_suggest_edits */
        public class Serializer extends JsonSerializer<TravelAttachmentFieldsModel> {
            public final void m18142a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TravelAttachmentFieldsModel travelAttachmentFieldsModel = (TravelAttachmentFieldsModel) obj;
                if (travelAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(travelAttachmentFieldsModel.m18160a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    travelAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TravelAttachmentFieldsParser.m18406a(travelAttachmentFieldsModel.w_(), travelAttachmentFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TravelAttachmentFieldsModel.class, new Serializer());
            }
        }

        public TravelAttachmentFieldsModel() {
            super(18);
        }

        public final void m18164a(String str, ConsistencyTuple consistencyTuple) {
            if ("address.full_address".equals(str)) {
                AddressModel k = m18146k();
                if (k != null) {
                    consistencyTuple.a = k.m18134a();
                    consistencyTuple.b = k.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("name".equals(str)) {
                consistencyTuple.a = m18152q();
                consistencyTuple.b = u_();
                consistencyTuple.c = 8;
                return;
            } else if ("viewer_saved_state".equals(str)) {
                consistencyTuple.a = m18158w();
                consistencyTuple.b = u_();
                consistencyTuple.c = 16;
                return;
            }
            consistencyTuple.a();
        }

        public final void m18165a(String str, Object obj, boolean z) {
            if ("address.full_address".equals(str)) {
                AddressModel k = m18146k();
                if (k == null) {
                    return;
                }
                if (z) {
                    k = (AddressModel) k.clone();
                    k.m18135a((String) obj);
                    this.f10218e = k;
                    return;
                }
                k.m18135a((String) obj);
            } else if ("name".equals(str)) {
                m18144a((String) obj);
            } else if ("viewer_saved_state".equals(str)) {
                m18143a((GraphQLSavedState) obj);
            }
        }

        @Nullable
        private GraphQLObjectType m18145j() {
            if (this.b != null && this.f10217d == null) {
                this.f10217d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10217d;
        }

        @Nullable
        private AddressModel m18146k() {
            this.f10218e = (AddressModel) super.a(this.f10218e, 1, AddressModel.class);
            return this.f10218e;
        }

        @Nonnull
        private ImmutableList<String> m18147l() {
            this.f10219f = super.a(this.f10219f, 2);
            return (ImmutableList) this.f10219f;
        }

        @Nullable
        private CityModel m18148m() {
            this.f10220g = (CityModel) super.a(this.f10220g, 3, CityModel.class);
            return this.f10220g;
        }

        @Nullable
        private String m18149n() {
            this.f10221h = super.a(this.f10221h, 4);
            return this.f10221h;
        }

        @Nullable
        private DefaultLocationFieldsModel m18150o() {
            this.f10223j = (DefaultLocationFieldsModel) super.a(this.f10223j, 6, DefaultLocationFieldsModel.class);
            return this.f10223j;
        }

        @Nullable
        private MapBoundingBoxModel m18151p() {
            this.f10224k = (MapBoundingBoxModel) super.a(this.f10224k, 7, MapBoundingBoxModel.class);
            return this.f10224k;
        }

        @Nullable
        private String m18152q() {
            this.f10225l = super.a(this.f10225l, 8);
            return this.f10225l;
        }

        private void m18144a(@Nullable String str) {
            this.f10225l = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 8, str);
            }
        }

        @Nullable
        private OverallStarRatingModel m18153r() {
            this.f10226m = (OverallStarRatingModel) super.a(this.f10226m, 9, OverallStarRatingModel.class);
            return this.f10226m;
        }

        @Nullable
        private PageVisitsModel m18154s() {
            this.f10227n = (PageVisitsModel) super.a(this.f10227n, 10, PageVisitsModel.class);
            return this.f10227n;
        }

        @Nullable
        private SavableTimelineAppCollectionExtraFieldsModel m18155t() {
            this.f10229p = (SavableTimelineAppCollectionExtraFieldsModel) super.a(this.f10229p, 12, SavableTimelineAppCollectionExtraFieldsModel.class);
            return this.f10229p;
        }

        @Nullable
        private GraphQLPageSuperCategoryType m18156u() {
            this.f10231r = (GraphQLPageSuperCategoryType) super.b(this.f10231r, 14, GraphQLPageSuperCategoryType.class, GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10231r;
        }

        @Nullable
        private String m18157v() {
            this.f10232s = super.a(this.f10232s, 15);
            return this.f10232s;
        }

        @Nullable
        private GraphQLSavedState m18158w() {
            this.f10233t = (GraphQLSavedState) super.b(this.f10233t, 16, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10233t;
        }

        private void m18143a(GraphQLSavedState graphQLSavedState) {
            this.f10233t = graphQLSavedState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 16, graphQLSavedState != null ? graphQLSavedState.name() : null);
            }
        }

        @Nullable
        private ViewerVisitsModel m18159x() {
            this.f10234u = (ViewerVisitsModel) super.a(this.f10234u, 17, ViewerVisitsModel.class);
            return this.f10234u;
        }

        @Nullable
        public final String m18162a() {
            return m18149n();
        }

        public final int jK_() {
            return 77195495;
        }

        public final GraphQLVisitableModel m18161a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18146k() != null) {
                AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m18146k());
                if (m18146k() != addressModel) {
                    graphQLVisitableModel = (TravelAttachmentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10218e = addressModel;
                }
            }
            if (m18148m() != null) {
                CityModel cityModel = (CityModel) graphQLModelMutatingVisitor.b(m18148m());
                if (m18148m() != cityModel) {
                    graphQLVisitableModel = (TravelAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10220g = cityModel;
                }
            }
            if (m18150o() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m18150o());
                if (m18150o() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (TravelAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10223j = defaultLocationFieldsModel;
                }
            }
            if (m18151p() != null) {
                MapBoundingBoxModel mapBoundingBoxModel = (MapBoundingBoxModel) graphQLModelMutatingVisitor.b(m18151p());
                if (m18151p() != mapBoundingBoxModel) {
                    graphQLVisitableModel = (TravelAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10224k = mapBoundingBoxModel;
                }
            }
            if (m18153r() != null) {
                OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m18153r());
                if (m18153r() != overallStarRatingModel) {
                    graphQLVisitableModel = (TravelAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10226m = overallStarRatingModel;
                }
            }
            if (m18154s() != null) {
                PageVisitsModel pageVisitsModel = (PageVisitsModel) graphQLModelMutatingVisitor.b(m18154s());
                if (m18154s() != pageVisitsModel) {
                    graphQLVisitableModel = (TravelAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10227n = pageVisitsModel;
                }
            }
            if (m18155t() != null) {
                SavableTimelineAppCollectionExtraFieldsModel savableTimelineAppCollectionExtraFieldsModel = (SavableTimelineAppCollectionExtraFieldsModel) graphQLModelMutatingVisitor.b(m18155t());
                if (m18155t() != savableTimelineAppCollectionExtraFieldsModel) {
                    graphQLVisitableModel = (TravelAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10229p = savableTimelineAppCollectionExtraFieldsModel;
                }
            }
            if (m18159x() != null) {
                ViewerVisitsModel viewerVisitsModel = (ViewerVisitsModel) graphQLModelMutatingVisitor.b(m18159x());
                if (m18159x() != viewerVisitsModel) {
                    graphQLVisitableModel = (TravelAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10234u = viewerVisitsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18160a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18145j());
            int a2 = ModelHelper.a(flatBufferBuilder, m18146k());
            int c = flatBufferBuilder.c(m18147l());
            int a3 = ModelHelper.a(flatBufferBuilder, m18148m());
            int b = flatBufferBuilder.b(m18149n());
            int a4 = ModelHelper.a(flatBufferBuilder, m18150o());
            int a5 = ModelHelper.a(flatBufferBuilder, m18151p());
            int b2 = flatBufferBuilder.b(m18152q());
            int a6 = ModelHelper.a(flatBufferBuilder, m18153r());
            int a7 = ModelHelper.a(flatBufferBuilder, m18154s());
            int a8 = ModelHelper.a(flatBufferBuilder, m18155t());
            int a9 = flatBufferBuilder.a(m18156u());
            int b3 = flatBufferBuilder.b(m18157v());
            int a10 = flatBufferBuilder.a(m18158w());
            int a11 = ModelHelper.a(flatBufferBuilder, m18159x());
            flatBufferBuilder.c(18);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, c);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.a(5, this.f10222i);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, b2);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.b(10, a7);
            flatBufferBuilder.a(11, this.f10228o);
            flatBufferBuilder.b(12, a8);
            flatBufferBuilder.a(13, this.f10230q);
            flatBufferBuilder.b(14, a9);
            flatBufferBuilder.b(15, b3);
            flatBufferBuilder.b(16, a10);
            flatBufferBuilder.b(17, a11);
            i();
            return flatBufferBuilder.d();
        }

        public final void m18163a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10222i = mutableFlatBuffer.a(i, 5);
            this.f10228o = mutableFlatBuffer.a(i, 11);
            this.f10230q = mutableFlatBuffer.a(i, 13);
        }
    }
}
