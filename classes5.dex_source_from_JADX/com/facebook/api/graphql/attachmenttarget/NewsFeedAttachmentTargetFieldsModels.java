package com.facebook.api.graphql.attachmenttarget;

import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLModels.NewsFeedDefaultsStoryActionLinkFieldsModel;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.CommonAttachmentTargetFieldsParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.CommonAttachmentTargetFieldsParser.BylinesParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.CommonAttachmentTargetFieldsParser.BylinesParser.ConciseTextParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.CommonAttachmentTargetFieldsParser.CoverPhotoParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.CommonAttachmentTargetFieldsParser.CoverPhotoParser.PhotoParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.CommonAttachmentTargetFieldsParser.MediaParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.CommonAttachmentTargetFieldsParser.RedirectionInfoParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.CommonAttachmentTargetFieldsParser.SocialContextParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.AttachmentPropertiesParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.SourceParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.StyleInfosParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.TargetParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.TargetParser.GlobalShareParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.TargetParser.GlobalShareParser.TitleParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.TargetParser.ItemPriceParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.TargetParser.OwnerParser;
import com.facebook.api.graphql.feedback.NewsFeedFeedbackGraphQLModels.NewsFeedDefaultsFeedbackModel;
import com.facebook.api.graphql.feedback.NewsFeedFeedbackGraphQLParsers.NewsFeedDefaultsFeedbackParser;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLModels.NewsFeedDefaultsPlaceFieldsWithoutMediaModel.CityModel;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLModels.NewsFeedDefaultsPlaceFieldsWithoutMediaModel.OverallStarRatingModel;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLModels.NewsFeedDefaultsPlaceFieldsWithoutMediaModel.PageVisitsModel;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLModels.NewsFeedDefaultsPlaceFieldsWithoutMediaModel.ViewerVisitsModel;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.SavableTimelineAppCollectionExtraFieldsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLInterfaces.EventAttachment;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLInterfaces.TravelAttachmentFields;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.AudioAttachmentFieldsModel.MusicObjectModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.BusinessLocationAttachmentStyleInfoFieldsModel.BoundingBoxModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.CommentPlaceInfoAttachmentTargetModel.PlaceListItemsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.CommentPlaceInfoPageFieldsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.CulturalMomentAttachmentFieldsModel.CulturalMomentImageModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.CulturalMomentAttachmentFieldsModel.FaviconModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.CulturalMomentVideoModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.EventAttachmentModel.EventCoverPhotoModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.ExternalUrlAttachmentModel.OpenGraphNodeModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.FBMediaQuestionFragmentModel.MediaQuestionOptionOrderModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.FBMediaQuestionFragmentModel.MediaQuestionPhotosModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.FundraiserPageAttachmentFragmentModel.CampaignModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.FundraiserPersonToCharityAttachmentFragmentModel.CharityModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.FundraiserPersonToCharityAttachmentFragmentModel.DonorsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.GoodwillThrowbackCardAttachmentComponentModel.ActionLinksModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.GoodwillThrowbackCardAttachmentComponentModel.AdditionalAccentImagesModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.GoodwillThrowbackCardAttachmentComponentModel.DataPointsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.GreetingCardFieldsModel.GreetingCardTemplateModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.GreetingCardFieldsModel.SlidesModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.InstantArticleFieldsModel.InstantArticleModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.LocalAdContextAttachmentStyleInfoFieldsModel.PlaceOpenStatusFormatsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.MessengerContentSubscriptionTargetModel.MessengerContentSubscriptionOptionModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.MultiPlaceMapAttachmentStyleInfoFieldsModel.LatLongListModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.NewsFeedDefaultsEventPlaceFieldsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.NewsFeedStoryAttachmentTargetExperienceFieldsModel.EmployerModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.NewsFeedStoryAttachmentTargetExperienceFieldsModel.SchoolClassModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.NewsFeedStoryAttachmentTargetExperienceFieldsModel.SchoolModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.NewsFeedStoryAttachmentTargetExperienceFieldsModel.WorkProjectModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.OpenGraphActionAttachmentTargetModel.PrimaryObjectNodeModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.OpenGraphObjectAttachmentTargetModel.MusiciansModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.OpenGraphObjectAttachmentTargetModel.PreviewUrlsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.PlaceListAttachmentTargetModel.ListItemsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.PlaceListAttachmentTargetModel.NonSpecificPlaceToSearchModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.QuestionTargetModel.OptionsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.QuoteFieldsModel.QuoteModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.ReadingAttachmentTargetModel.PageLikersModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.SouvenirsFieldsModel.MediaElementsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.SportsAttachmentFieldsModel.SportsMatchDataModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.StoryAttachmentAppAdLinkTargetModel.RatingModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.ThrowbackMediaAttachmentFieldsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.TravelAttachmentFieldsModel.AddressModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.TravelAttachmentFieldsModel.MapBoundingBoxModel;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLModels.AppStoreApplicationFragmentModel;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLModels.InnerApplicationFieldsModel;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLModels.InnerApplicationFieldsModel.AndroidAppConfigModel;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.InnerApplicationFieldsParser;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLModels.DefaultTextWithEntitiesWithRangesFieldsModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
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
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DeprecatedCurrencyQuantityFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageUriFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLModels.SizeAwareMediaModel;
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

/* compiled from: app_section_actor */
public class NewsFeedAttachmentTargetFieldsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1539113028)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_section_actor */
    public final class CommonAttachmentTargetFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f9106d;
        @Nullable
        private List<String> f9107e;
        @Nullable
        private InnerApplicationFieldsModel f9108f;
        @Nullable
        private List<BylinesModel> f9109g;
        @Nullable
        private CoverPhotoModel f9110h;
        @Nullable
        private NewsFeedDefaultsFeedbackModel f9111i;
        @Nullable
        private String f9112j;
        @Nullable
        private MediaModel f9113k;
        @Nullable
        private DefaultImageFieldsModel f9114l;
        @Nullable
        private List<RedirectionInfoModel> f9115m;
        @Nullable
        private SocialContextModel f9116n;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -850016866)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_section_actor */
        public final class BylinesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ConciseTextModel f9099d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_section_actor */
            public final class ConciseTextModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f9098d;

                /* compiled from: app_section_actor */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ConciseTextModel.class, new Deserializer());
                    }

                    public Object m15422a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ConciseTextParser.m15626a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object conciseTextModel = new ConciseTextModel();
                        ((BaseModel) conciseTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (conciseTextModel instanceof Postprocessable) {
                            return ((Postprocessable) conciseTextModel).a();
                        }
                        return conciseTextModel;
                    }
                }

                /* compiled from: app_section_actor */
                public class Serializer extends JsonSerializer<ConciseTextModel> {
                    public final void m15423a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ConciseTextModel conciseTextModel = (ConciseTextModel) obj;
                        if (conciseTextModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(conciseTextModel.m15425a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            conciseTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ConciseTextParser.m15627a(conciseTextModel.w_(), conciseTextModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ConciseTextModel.class, new Serializer());
                    }
                }

                public ConciseTextModel() {
                    super(1);
                }

                @Nullable
                private String m15424a() {
                    this.f9098d = super.a(this.f9098d, 0);
                    return this.f9098d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m15426a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15425a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15424a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: app_section_actor */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BylinesModel.class, new Deserializer());
                }

                public Object m15427a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BylinesParser.m15630b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object bylinesModel = new BylinesModel();
                    ((BaseModel) bylinesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (bylinesModel instanceof Postprocessable) {
                        return ((Postprocessable) bylinesModel).a();
                    }
                    return bylinesModel;
                }
            }

            /* compiled from: app_section_actor */
            public class Serializer extends JsonSerializer<BylinesModel> {
                public final void m15428a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BylinesModel bylinesModel = (BylinesModel) obj;
                    if (bylinesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(bylinesModel.m15430a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        bylinesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BylinesParser.m15631b(bylinesModel.w_(), bylinesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BylinesModel.class, new Serializer());
                }
            }

            public BylinesModel() {
                super(1);
            }

            @Nullable
            private ConciseTextModel m15429a() {
                this.f9099d = (ConciseTextModel) super.a(this.f9099d, 0, ConciseTextModel.class);
                return this.f9099d;
            }

            public final int jK_() {
                return 1608962139;
            }

            public final GraphQLVisitableModel m15431a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15429a() != null) {
                    ConciseTextModel conciseTextModel = (ConciseTextModel) graphQLModelMutatingVisitor.b(m15429a());
                    if (m15429a() != conciseTextModel) {
                        graphQLVisitableModel = (BylinesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9099d = conciseTextModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15430a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15429a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 353968125)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_section_actor */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhotoModel f9101d;

            /* compiled from: app_section_actor */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m15432a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoverPhotoParser.m15634a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object coverPhotoModel = new CoverPhotoModel();
                    ((BaseModel) coverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (coverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) coverPhotoModel).a();
                    }
                    return coverPhotoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1236209140)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_section_actor */
            public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private DefaultImageFieldsModel f9100d;

                /* compiled from: app_section_actor */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m15433a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoParser.m15632a(jsonParser, flatBufferBuilder));
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

                /* compiled from: app_section_actor */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m15434a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) obj;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m15436a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoParser.m15633a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                public PhotoModel() {
                    super(1);
                }

                @Nullable
                private DefaultImageFieldsModel m15435a() {
                    this.f9100d = (DefaultImageFieldsModel) super.a(this.f9100d, 0, DefaultImageFieldsModel.class);
                    return this.f9100d;
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m15437a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15435a() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15435a());
                        if (m15435a() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9100d = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15436a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15435a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: app_section_actor */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m15438a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m15440a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoverPhotoParser.m15635a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            public CoverPhotoModel() {
                super(1);
            }

            @Nullable
            private PhotoModel m15439a() {
                this.f9101d = (PhotoModel) super.a(this.f9101d, 0, PhotoModel.class);
                return this.f9101d;
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m15441a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15439a() != null) {
                    PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m15439a());
                    if (m15439a() != photoModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9101d = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15440a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15439a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_section_actor */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommonAttachmentTargetFieldsModel.class, new Deserializer());
            }

            public Object m15442a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommonAttachmentTargetFieldsParser.m15644a(jsonParser);
                Object commonAttachmentTargetFieldsModel = new CommonAttachmentTargetFieldsModel();
                ((BaseModel) commonAttachmentTargetFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commonAttachmentTargetFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) commonAttachmentTargetFieldsModel).a();
                }
                return commonAttachmentTargetFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_section_actor */
        public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
            private int f9102d;

            /* compiled from: app_section_actor */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                }

                public Object m15443a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaParser.m15636a(jsonParser, flatBufferBuilder));
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

            /* compiled from: app_section_actor */
            public class Serializer extends JsonSerializer<MediaModel> {
                public final void m15444a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaModel mediaModel = (MediaModel) obj;
                    if (mediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaModel.m15445a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaParser.m15637a(mediaModel.w_(), mediaModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MediaModel.class, new Serializer());
                }
            }

            public MediaModel() {
                super(1);
            }

            public final int jK_() {
                return 747633668;
            }

            public final GraphQLVisitableModel m15446a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15445a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9102d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15447a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9102d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 315620844)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_section_actor */
        public final class RedirectionInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLRedirectionReason f9103d;
            @Nullable
            private String f9104e;

            /* compiled from: app_section_actor */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RedirectionInfoModel.class, new Deserializer());
                }

                public Object m15448a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RedirectionInfoParser.m15641b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object redirectionInfoModel = new RedirectionInfoModel();
                    ((BaseModel) redirectionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (redirectionInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) redirectionInfoModel).a();
                    }
                    return redirectionInfoModel;
                }
            }

            /* compiled from: app_section_actor */
            public class Serializer extends JsonSerializer<RedirectionInfoModel> {
                public final void m15449a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RedirectionInfoModel redirectionInfoModel = (RedirectionInfoModel) obj;
                    if (redirectionInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(redirectionInfoModel.m15452a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        redirectionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RedirectionInfoParser.m15639a(redirectionInfoModel.w_(), redirectionInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RedirectionInfoModel.class, new Serializer());
                }
            }

            public RedirectionInfoModel() {
                super(2);
            }

            @Nullable
            private GraphQLRedirectionReason m15450a() {
                this.f9103d = (GraphQLRedirectionReason) super.b(this.f9103d, 0, GraphQLRedirectionReason.class, GraphQLRedirectionReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9103d;
            }

            @Nullable
            private String m15451j() {
                this.f9104e = super.a(this.f9104e, 1);
                return this.f9104e;
            }

            public final int jK_() {
                return -986866342;
            }

            public final GraphQLVisitableModel m15453a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15452a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m15450a());
                int b = flatBufferBuilder.b(m15451j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_section_actor */
        public class Serializer extends JsonSerializer<CommonAttachmentTargetFieldsModel> {
            public final void m15454a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommonAttachmentTargetFieldsModel commonAttachmentTargetFieldsModel = (CommonAttachmentTargetFieldsModel) obj;
                if (commonAttachmentTargetFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commonAttachmentTargetFieldsModel.m15471a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commonAttachmentTargetFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commonAttachmentTargetFieldsModel.w_();
                int u_ = commonAttachmentTargetFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("android_urls");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 1), jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("application");
                    InnerApplicationFieldsParser.m3082a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("bylines");
                    BylinesParser.m15629a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m15635a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    NewsFeedDefaultsFeedbackParser.m16378a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 6) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 6));
                }
                g = mutableFlatBuffer.g(u_, 7);
                if (g != 0) {
                    jsonGenerator.a("media");
                    MediaParser.m15637a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 8);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 9);
                if (g != 0) {
                    jsonGenerator.a("redirection_info");
                    RedirectionInfoParser.m15640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 10);
                if (g != 0) {
                    jsonGenerator.a("social_context");
                    SocialContextParser.m15643a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommonAttachmentTargetFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_section_actor */
        public final class SocialContextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9105d;

            /* compiled from: app_section_actor */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SocialContextModel.class, new Deserializer());
                }

                public Object m15455a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SocialContextParser.m15642a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object socialContextModel = new SocialContextModel();
                    ((BaseModel) socialContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (socialContextModel instanceof Postprocessable) {
                        return ((Postprocessable) socialContextModel).a();
                    }
                    return socialContextModel;
                }
            }

            /* compiled from: app_section_actor */
            public class Serializer extends JsonSerializer<SocialContextModel> {
                public final void m15456a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SocialContextModel socialContextModel = (SocialContextModel) obj;
                    if (socialContextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(socialContextModel.m15458a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        socialContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SocialContextParser.m15643a(socialContextModel.w_(), socialContextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SocialContextModel.class, new Serializer());
                }
            }

            public SocialContextModel() {
                super(1);
            }

            @Nullable
            private String m15457a() {
                this.f9105d = super.a(this.f9105d, 0);
                return this.f9105d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m15459a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15458a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15457a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public CommonAttachmentTargetFieldsModel() {
            super(11);
        }

        public final void m15474a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m15475a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m15460j() {
            if (this.b != null && this.f9106d == null) {
                this.f9106d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9106d;
        }

        @Nonnull
        private ImmutableList<String> m15461k() {
            this.f9107e = super.a(this.f9107e, 1);
            return (ImmutableList) this.f9107e;
        }

        @Nullable
        private InnerApplicationFieldsModel m15462l() {
            this.f9108f = (InnerApplicationFieldsModel) super.a(this.f9108f, 2, InnerApplicationFieldsModel.class);
            return this.f9108f;
        }

        @Nonnull
        private ImmutableList<BylinesModel> m15463m() {
            this.f9109g = super.a(this.f9109g, 3, BylinesModel.class);
            return (ImmutableList) this.f9109g;
        }

        @Nullable
        private CoverPhotoModel m15464n() {
            this.f9110h = (CoverPhotoModel) super.a(this.f9110h, 4, CoverPhotoModel.class);
            return this.f9110h;
        }

        @Nullable
        private NewsFeedDefaultsFeedbackModel m15465o() {
            this.f9111i = (NewsFeedDefaultsFeedbackModel) super.a(this.f9111i, 5, NewsFeedDefaultsFeedbackModel.class);
            return this.f9111i;
        }

        @Nullable
        private String m15466p() {
            this.f9112j = super.a(this.f9112j, 6);
            return this.f9112j;
        }

        @Nullable
        private MediaModel m15467q() {
            this.f9113k = (MediaModel) super.a(this.f9113k, 7, MediaModel.class);
            return this.f9113k;
        }

        @Nullable
        private DefaultImageFieldsModel m15468r() {
            this.f9114l = (DefaultImageFieldsModel) super.a(this.f9114l, 8, DefaultImageFieldsModel.class);
            return this.f9114l;
        }

        @Nonnull
        private ImmutableList<RedirectionInfoModel> m15469s() {
            this.f9115m = super.a(this.f9115m, 9, RedirectionInfoModel.class);
            return (ImmutableList) this.f9115m;
        }

        @Nullable
        private SocialContextModel m15470t() {
            this.f9116n = (SocialContextModel) super.a(this.f9116n, 10, SocialContextModel.class);
            return this.f9116n;
        }

        @Nullable
        public final String m15473a() {
            return m15466p();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m15472a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15462l() != null) {
                InnerApplicationFieldsModel innerApplicationFieldsModel = (InnerApplicationFieldsModel) graphQLModelMutatingVisitor.b(m15462l());
                if (m15462l() != innerApplicationFieldsModel) {
                    graphQLVisitableModel = (CommonAttachmentTargetFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9108f = innerApplicationFieldsModel;
                }
            }
            if (m15463m() != null) {
                a = ModelHelper.a(m15463m(), graphQLModelMutatingVisitor);
                if (a != null) {
                    CommonAttachmentTargetFieldsModel commonAttachmentTargetFieldsModel = (CommonAttachmentTargetFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    commonAttachmentTargetFieldsModel.f9109g = a.b();
                    graphQLVisitableModel = commonAttachmentTargetFieldsModel;
                }
            }
            if (m15464n() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m15464n());
                if (m15464n() != coverPhotoModel) {
                    graphQLVisitableModel = (CommonAttachmentTargetFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9110h = coverPhotoModel;
                }
            }
            if (m15465o() != null) {
                NewsFeedDefaultsFeedbackModel newsFeedDefaultsFeedbackModel = (NewsFeedDefaultsFeedbackModel) graphQLModelMutatingVisitor.b(m15465o());
                if (m15465o() != newsFeedDefaultsFeedbackModel) {
                    graphQLVisitableModel = (CommonAttachmentTargetFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9111i = newsFeedDefaultsFeedbackModel;
                }
            }
            if (m15467q() != null) {
                MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m15467q());
                if (m15467q() != mediaModel) {
                    graphQLVisitableModel = (CommonAttachmentTargetFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9113k = mediaModel;
                }
            }
            if (m15468r() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15468r());
                if (m15468r() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (CommonAttachmentTargetFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9114l = defaultImageFieldsModel;
                }
            }
            if (m15469s() != null) {
                a = ModelHelper.a(m15469s(), graphQLModelMutatingVisitor);
                if (a != null) {
                    commonAttachmentTargetFieldsModel = (CommonAttachmentTargetFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    commonAttachmentTargetFieldsModel.f9115m = a.b();
                    graphQLVisitableModel = commonAttachmentTargetFieldsModel;
                }
            }
            if (m15470t() != null) {
                SocialContextModel socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(m15470t());
                if (m15470t() != socialContextModel) {
                    graphQLVisitableModel = (CommonAttachmentTargetFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9116n = socialContextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15471a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15460j());
            int c = flatBufferBuilder.c(m15461k());
            int a2 = ModelHelper.a(flatBufferBuilder, m15462l());
            int a3 = ModelHelper.a(flatBufferBuilder, m15463m());
            int a4 = ModelHelper.a(flatBufferBuilder, m15464n());
            int a5 = ModelHelper.a(flatBufferBuilder, m15465o());
            int b = flatBufferBuilder.b(m15466p());
            int a6 = ModelHelper.a(flatBufferBuilder, m15467q());
            int a7 = ModelHelper.a(flatBufferBuilder, m15468r());
            int a8 = ModelHelper.a(flatBufferBuilder, m15469s());
            int a9 = ModelHelper.a(flatBufferBuilder, m15470t());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, c);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, b);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.b(8, a7);
            flatBufferBuilder.b(9, a8);
            flatBufferBuilder.b(10, a9);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 204157185)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: app_section_actor */
    public final class StoryAttachmentFieldsWithoutMediaModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<NewsFeedDefaultsStoryActionLinkFieldsModel> f9205d;
        @Nullable
        private AppStoreApplicationFragmentModel f9206e;
        @Nullable
        private List<AttachmentPropertiesModel> f9207f;
        @Nullable
        private String f9208g;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f9209h;
        @Nullable
        private String f9210i;
        @Nullable
        private SourceModel f9211j;
        @Nullable
        private List<StyleInfosModel> f9212k;
        @Nullable
        private List<GraphQLStoryAttachmentStyle> f9213l;
        @Nullable
        private String f9214m;
        @Nullable
        private TargetModel f9215n;
        @Nullable
        private String f9216o;
        @Nullable
        private String f9217p;
        @Nullable
        private String f9218q;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2099130720)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_section_actor */
        public final class AttachmentPropertiesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9117d;
            @Nullable
            private String f9118e;
            @Nullable
            private String f9119f;
            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel f9120g;

            /* compiled from: app_section_actor */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttachmentPropertiesModel.class, new Deserializer());
                }

                public Object m15476a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttachmentPropertiesParser.m15647b(jsonParser, flatBufferBuilder));
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

            /* compiled from: app_section_actor */
            public class Serializer extends JsonSerializer<AttachmentPropertiesModel> {
                public final void m15477a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttachmentPropertiesModel attachmentPropertiesModel = (AttachmentPropertiesModel) obj;
                    if (attachmentPropertiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attachmentPropertiesModel.m15482a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attachmentPropertiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttachmentPropertiesParser.m15648b(attachmentPropertiesModel.w_(), attachmentPropertiesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttachmentPropertiesModel.class, new Serializer());
                }
            }

            public AttachmentPropertiesModel() {
                super(4);
            }

            @Nullable
            private String m15478a() {
                this.f9117d = super.a(this.f9117d, 0);
                return this.f9117d;
            }

            @Nullable
            private String m15479j() {
                this.f9118e = super.a(this.f9118e, 1);
                return this.f9118e;
            }

            @Nullable
            private String m15480k() {
                this.f9119f = super.a(this.f9119f, 2);
                return this.f9119f;
            }

            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel m15481l() {
                this.f9120g = (DefaultTextWithEntitiesWithRangesFieldsModel) super.a(this.f9120g, 3, DefaultTextWithEntitiesWithRangesFieldsModel.class);
                return this.f9120g;
            }

            public final int jK_() {
                return -363494344;
            }

            public final GraphQLVisitableModel m15483a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15481l() != null) {
                    DefaultTextWithEntitiesWithRangesFieldsModel defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m15481l());
                    if (m15481l() != defaultTextWithEntitiesWithRangesFieldsModel) {
                        graphQLVisitableModel = (AttachmentPropertiesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9120g = defaultTextWithEntitiesWithRangesFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15482a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15478a());
                int b2 = flatBufferBuilder.b(m15479j());
                int b3 = flatBufferBuilder.b(m15480k());
                int a = ModelHelper.a(flatBufferBuilder, m15481l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_section_actor */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StoryAttachmentFieldsWithoutMediaModel.class, new Deserializer());
            }

            public Object m15484a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = StoryAttachmentFieldsWithoutMediaParser.m15667a(jsonParser);
                Object storyAttachmentFieldsWithoutMediaModel = new StoryAttachmentFieldsWithoutMediaModel();
                ((BaseModel) storyAttachmentFieldsWithoutMediaModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (storyAttachmentFieldsWithoutMediaModel instanceof Postprocessable) {
                    return ((Postprocessable) storyAttachmentFieldsWithoutMediaModel).a();
                }
                return storyAttachmentFieldsWithoutMediaModel;
            }
        }

        /* compiled from: app_section_actor */
        public class Serializer extends JsonSerializer<StoryAttachmentFieldsWithoutMediaModel> {
            public final void m15485a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StoryAttachmentFieldsWithoutMediaModel storyAttachmentFieldsWithoutMediaModel = (StoryAttachmentFieldsWithoutMediaModel) obj;
                if (storyAttachmentFieldsWithoutMediaModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(storyAttachmentFieldsWithoutMediaModel.m15624a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    storyAttachmentFieldsWithoutMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StoryAttachmentFieldsWithoutMediaParser.m15668a(storyAttachmentFieldsWithoutMediaModel.w_(), storyAttachmentFieldsWithoutMediaModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StoryAttachmentFieldsWithoutMediaModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_section_actor */
        public final class SourceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9121d;

            /* compiled from: app_section_actor */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SourceModel.class, new Deserializer());
                }

                public Object m15486a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SourceParser.m15649a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sourceModel = new SourceModel();
                    ((BaseModel) sourceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sourceModel instanceof Postprocessable) {
                        return ((Postprocessable) sourceModel).a();
                    }
                    return sourceModel;
                }
            }

            /* compiled from: app_section_actor */
            public class Serializer extends JsonSerializer<SourceModel> {
                public final void m15487a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SourceModel sourceModel = (SourceModel) obj;
                    if (sourceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sourceModel.m15489a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sourceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SourceParser.m15650a(sourceModel.w_(), sourceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SourceModel.class, new Serializer());
                }
            }

            public SourceModel() {
                super(1);
            }

            @Nullable
            private String m15488a() {
                this.f9121d = super.a(this.f9121d, 0);
                return this.f9121d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m15490a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15489a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15488a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 409286214)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_section_actor */
        public final class StyleInfosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f9122d;
            @Nullable
            private BoundingBoxModel f9123e;
            @Nullable
            private String f9124f;
            @Nullable
            private String f9125g;
            @Nullable
            private String f9126h;
            @Nullable
            private String f9127i;
            @Nullable
            private List<LatLongListModel> f9128j;
            private int f9129k;
            private int f9130l;
            private int f9131m;
            private int f9132n;
            @Nullable
            private DefaultLocationFieldsModel f9133o;
            @Nullable
            private DefaultImageFieldsModel f9134p;
            @Nullable
            private String f9135q;
            @Nullable
            private List<DefaultLocationFieldsModel> f9136r;
            @Nullable
            private List<PlaceOpenStatusFormatsModel> f9137s;
            @Nullable
            private String f9138t;
            @Nullable
            private String f9139u;
            @Nullable
            private String f9140v;

            /* compiled from: app_section_actor */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StyleInfosModel.class, new Deserializer());
                }

                public Object m15491a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StyleInfosParser.m15653b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object styleInfosModel = new StyleInfosModel();
                    ((BaseModel) styleInfosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (styleInfosModel instanceof Postprocessable) {
                        return ((Postprocessable) styleInfosModel).a();
                    }
                    return styleInfosModel;
                }
            }

            /* compiled from: app_section_actor */
            public class Serializer extends JsonSerializer<StyleInfosModel> {
                public final void m15492a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StyleInfosModel styleInfosModel = (StyleInfosModel) obj;
                    if (styleInfosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(styleInfosModel.m15508a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        styleInfosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StyleInfosParser.m15654b(styleInfosModel.w_(), styleInfosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StyleInfosModel.class, new Serializer());
                }
            }

            public StyleInfosModel() {
                super(19);
            }

            @Nullable
            private GraphQLObjectType m15493a() {
                if (this.b != null && this.f9122d == null) {
                    this.f9122d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9122d;
            }

            @Nullable
            private BoundingBoxModel m15494j() {
                this.f9123e = (BoundingBoxModel) super.a(this.f9123e, 1, BoundingBoxModel.class);
                return this.f9123e;
            }

            @Nullable
            private String m15495k() {
                this.f9124f = super.a(this.f9124f, 2);
                return this.f9124f;
            }

            @Nullable
            private String m15496l() {
                this.f9125g = super.a(this.f9125g, 3);
                return this.f9125g;
            }

            @Nullable
            private String m15497m() {
                this.f9126h = super.a(this.f9126h, 4);
                return this.f9126h;
            }

            @Nullable
            private String m15498n() {
                this.f9127i = super.a(this.f9127i, 5);
                return this.f9127i;
            }

            @Nonnull
            private ImmutableList<LatLongListModel> m15499o() {
                this.f9128j = super.a(this.f9128j, 6, LatLongListModel.class);
                return (ImmutableList) this.f9128j;
            }

            @Nullable
            private DefaultLocationFieldsModel m15500p() {
                this.f9133o = (DefaultLocationFieldsModel) super.a(this.f9133o, 11, DefaultLocationFieldsModel.class);
                return this.f9133o;
            }

            @Nullable
            private DefaultImageFieldsModel m15501q() {
                this.f9134p = (DefaultImageFieldsModel) super.a(this.f9134p, 12, DefaultImageFieldsModel.class);
                return this.f9134p;
            }

            @Nullable
            private String m15502r() {
                this.f9135q = super.a(this.f9135q, 13);
                return this.f9135q;
            }

            @Nonnull
            private ImmutableList<DefaultLocationFieldsModel> m15503s() {
                this.f9136r = super.a(this.f9136r, 14, DefaultLocationFieldsModel.class);
                return (ImmutableList) this.f9136r;
            }

            @Nonnull
            private ImmutableList<PlaceOpenStatusFormatsModel> m15504t() {
                this.f9137s = super.a(this.f9137s, 15, PlaceOpenStatusFormatsModel.class);
                return (ImmutableList) this.f9137s;
            }

            @Nullable
            private String m15505u() {
                this.f9138t = super.a(this.f9138t, 16);
                return this.f9138t;
            }

            @Nullable
            private String m15506v() {
                this.f9139u = super.a(this.f9139u, 17);
                return this.f9139u;
            }

            @Nullable
            private String m15507w() {
                this.f9140v = super.a(this.f9140v, 18);
                return this.f9140v;
            }

            public final int jK_() {
                return -1248513785;
            }

            public final GraphQLVisitableModel m15509a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                Builder a;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15494j() != null) {
                    BoundingBoxModel boundingBoxModel = (BoundingBoxModel) graphQLModelMutatingVisitor.b(m15494j());
                    if (m15494j() != boundingBoxModel) {
                        graphQLVisitableModel = (StyleInfosModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9123e = boundingBoxModel;
                    }
                }
                if (m15499o() != null) {
                    a = ModelHelper.a(m15499o(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        StyleInfosModel styleInfosModel = (StyleInfosModel) ModelHelper.a(graphQLVisitableModel, this);
                        styleInfosModel.f9128j = a.b();
                        graphQLVisitableModel = styleInfosModel;
                    }
                }
                if (m15500p() != null) {
                    DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m15500p());
                    if (m15500p() != defaultLocationFieldsModel) {
                        graphQLVisitableModel = (StyleInfosModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9133o = defaultLocationFieldsModel;
                    }
                }
                if (m15501q() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15501q());
                    if (m15501q() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (StyleInfosModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9134p = defaultImageFieldsModel;
                    }
                }
                if (m15503s() != null) {
                    a = ModelHelper.a(m15503s(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        styleInfosModel = (StyleInfosModel) ModelHelper.a(graphQLVisitableModel, this);
                        styleInfosModel.f9136r = a.b();
                        graphQLVisitableModel = styleInfosModel;
                    }
                }
                if (m15504t() != null) {
                    a = ModelHelper.a(m15504t(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        styleInfosModel = (StyleInfosModel) ModelHelper.a(graphQLVisitableModel, this);
                        styleInfosModel.f9137s = a.b();
                        graphQLVisitableModel = styleInfosModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15508a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15493a());
                int a2 = ModelHelper.a(flatBufferBuilder, m15494j());
                int b = flatBufferBuilder.b(m15495k());
                int b2 = flatBufferBuilder.b(m15496l());
                int b3 = flatBufferBuilder.b(m15497m());
                int b4 = flatBufferBuilder.b(m15498n());
                int a3 = ModelHelper.a(flatBufferBuilder, m15499o());
                int a4 = ModelHelper.a(flatBufferBuilder, m15500p());
                int a5 = ModelHelper.a(flatBufferBuilder, m15501q());
                int b5 = flatBufferBuilder.b(m15502r());
                int a6 = ModelHelper.a(flatBufferBuilder, m15503s());
                int a7 = ModelHelper.a(flatBufferBuilder, m15504t());
                int b6 = flatBufferBuilder.b(m15505u());
                int b7 = flatBufferBuilder.b(m15506v());
                int b8 = flatBufferBuilder.b(m15507w());
                flatBufferBuilder.c(19);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, b4);
                flatBufferBuilder.b(6, a3);
                flatBufferBuilder.a(7, this.f9129k, 0);
                flatBufferBuilder.a(8, this.f9130l, 0);
                flatBufferBuilder.a(9, this.f9131m, 0);
                flatBufferBuilder.a(10, this.f9132n, 0);
                flatBufferBuilder.b(11, a4);
                flatBufferBuilder.b(12, a5);
                flatBufferBuilder.b(13, b5);
                flatBufferBuilder.b(14, a6);
                flatBufferBuilder.b(15, a7);
                flatBufferBuilder.b(16, b6);
                flatBufferBuilder.b(17, b7);
                flatBufferBuilder.b(18, b8);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15510a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9129k = mutableFlatBuffer.a(i, 7, 0);
                this.f9130l = mutableFlatBuffer.a(i, 8, 0);
                this.f9131m = mutableFlatBuffer.a(i, 9, 0);
                this.f9132n = mutableFlatBuffer.a(i, 10, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1426532674)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_section_actor */
        public final class TargetModel extends BaseModel implements EventAttachment, TravelAttachmentFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            private boolean f9156A;
            private boolean f9157B;
            @Nullable
            private String f9158C;
            @Nullable
            private List<String> f9159D;
            @Nullable
            private CharityModel f9160E;
            @Nullable
            private CityModel f9161F;
            @Nullable
            private List<String> f9162G;
            @Nullable
            private GraphQLConnectionStyle f9163H;
            @Nullable
            private String f9164I;
            @Nullable
            private CoverPhotoModel f9165J;
            @Nullable
            private String f9166K;
            @Nullable
            private CulturalMomentImageModel f9167L;
            @Nullable
            private CulturalMomentVideoModel f9168M;
            @Nullable
            private DeprecatedCurrencyQuantityFieldsModel f9169N;
            @Nullable
            private DataPointsModel f9170O;
            @Nullable
            private DonorsModel f9171P;
            private int f9172Q;
            @Nullable
            private EmployerModel f9173R;
            private long f9174S;
            @Nullable
            private EventCoverPhotoModel f9175T;
            @Nullable
            private NewsFeedDefaultsEventPlaceFieldsModel f9176U;
            private long f9177V;
            @Nullable
            private FaviconModel f9178W;
            @Nullable
            private NewsFeedDefaultsFeedbackModel f9179X;
            @Nullable
            private GraphQLFriendshipStatus f9180Y;
            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel f9181Z;
            @Nullable
            private MessengerContentSubscriptionOptionModel aA;
            @Nullable
            private MusicObjectModel aB;
            @Nullable
            private String aC;
            @Nullable
            private GraphQLMusicType aD;
            @Nullable
            private List<MusiciansModel> aE;
            @Nullable
            private String aF;
            @Nullable
            private NonSpecificPlaceToSearchModel aG;
            @Nullable
            private OpenGraphNodeModel aH;
            @Nullable
            private OptionsModel aI;
            @Nullable
            private OverallStarRatingModel aJ;
            @Nullable
            private OwnerModel aK;
            @Nullable
            private PageLikersModel aL;
            @Nullable
            private PageVisitsModel aM;
            @Nullable
            private List<CommentPlaceInfoPageFieldsModel> aN;
            private double aO;
            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel aP;
            @Nullable
            private PlaceListItemsModel aQ;
            @Nullable
            private String aR;
            @Nullable
            private GraphQLQuestionPollAnswersState aS;
            @Nullable
            private List<PreviewUrlsModel> aT;
            @Nullable
            private GraphQLGroupCommercePriceType aU;
            @Nullable
            private DefaultImageFieldsModel aV;
            @Nullable
            private PrimaryObjectNodeModel aW;
            @Nullable
            private DefaultImageFieldsModel aX;
            private boolean aY;
            @Nullable
            private QuoteModel aZ;
            @Nullable
            private GlobalShareModel aa;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel ab;
            @Nullable
            private GreetingCardTemplateModel ac;
            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel ad;
            private boolean ae;
            @Nullable
            private String af;
            @Nullable
            private DefaultImageFieldsModel ag;
            @Nullable
            private String ah;
            @Nullable
            private InstantArticleModel ai;
            private boolean aj;
            private boolean ak;
            private boolean al;
            private boolean am;
            private boolean an;
            private boolean ao;
            @Nullable
            private ItemPriceModel ap;
            @Nullable
            private ListItemsModel aq;
            @Nullable
            private DefaultLocationFieldsModel ar;
            @Nullable
            private DefaultImageFieldsModel as;
            @Nullable
            private MapBoundingBoxModel at;
            @Nullable
            private MediaModel au;
            @Nullable
            private MediaElementsModel av;
            @Nullable
            private MediaQuestionOptionOrderModel aw;
            @Nullable
            private List<MediaQuestionPhotosModel> ax;
            @Nullable
            private String ay;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel az;
            @Nullable
            private String bA;
            @Nullable
            private GraphQLEventGuestStatus bB;
            private boolean bC;
            private boolean bD;
            @Nullable
            private GraphQLSavedState bE;
            @Nullable
            private ViewerVisitsModel bF;
            @Nullable
            private GraphQLEventWatchStatus bG;
            @Nullable
            private WorkProjectModel bH;
            @Nullable
            private RatingModel ba;
            @Nullable
            private DefaultImageFieldsModel bb;
            @Nullable
            private List<RedirectionInfoModel> bc;
            @Nullable
            private GraphQLQuestionResponseMethod bd;
            @Nullable
            private SavableTimelineAppCollectionExtraFieldsModel be;
            @Nullable
            private SchoolModel bf;
            @Nullable
            private SchoolClassModel bg;
            private boolean bh;
            private boolean bi;
            private boolean bj;
            @Nullable
            private SlidesModel bk;
            @Nullable
            private SocialContextModel bl;
            @Nullable
            private String bm;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel bn;
            @Nullable
            private SizeAwareMediaModel bo;
            @Nullable
            private SportsMatchDataModel bp;
            @Nullable
            private DefaultImageUriFieldsModel bq;
            private long br;
            @Nullable
            private String bs;
            @Nullable
            private GraphQLPageSuperCategoryType bt;
            @Nullable
            private String bu;
            @Nullable
            private String bv;
            @Nullable
            private List<SizeAwareMediaModel> bw;
            @Nullable
            private List<ThrowbackMediaAttachmentFieldsModel> bx;
            @Nullable
            private String by;
            @Nullable
            private TitleModel bz;
            @Nullable
            private GraphQLObjectType f9182d;
            @Nullable
            private DefaultImageFieldsModel f9183e;
            @Nullable
            private List<ActionLinksModel> f9184f;
            @Nullable
            private List<AdditionalAccentImagesModel> f9185g;
            @Nullable
            private AddressModel f9186h;
            private long f9187i;
            @Nullable
            private String f9188j;
            @Nullable
            private AndroidAppConfigModel f9189k;
            @Nullable
            private String f9190l;
            @Nullable
            private List<String> f9191m;
            @Nullable
            private DefaultImageFieldsModel f9192n;
            @Nullable
            private InnerApplicationFieldsModel f9193o;
            @Nullable
            private String f9194p;
            @Nullable
            private List<String> f9195q;
            @Nullable
            private String f9196r;
            @Nullable
            private String f9197s;
            private double f9198t;
            @Nullable
            private List<BylinesModel> f9199u;
            @Nullable
            private CampaignModel f9200v;
            @Nullable
            private String f9201w;
            @Nullable
            private String f9202x;
            private boolean f9203y;
            private boolean f9204z;

            /* compiled from: app_section_actor */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TargetModel.class, new Deserializer());
                }

                public Object m15511a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TargetParser.m15665a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object targetModel = new TargetModel();
                    ((BaseModel) targetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (targetModel instanceof Postprocessable) {
                        return ((Postprocessable) targetModel).a();
                    }
                    return targetModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1077796150)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_section_actor */
            public final class GlobalShareModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private List<String> f9142d;
                @Nullable
                private String f9143e;
                @Nullable
                private String f9144f;
                @Nullable
                private com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.SingleSongMusicAttachmentModel.GlobalShareModel.OpenGraphNodeModel f9145g;
                @Nullable
                private TitleModel f9146h;
                @Nullable
                private String f9147i;

                /* compiled from: app_section_actor */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(GlobalShareModel.class, new Deserializer());
                    }

                    public Object m15512a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GlobalShareParser.m15657a(jsonParser, flatBufferBuilder));
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

                /* compiled from: app_section_actor */
                public class Serializer extends JsonSerializer<GlobalShareModel> {
                    public final void m15513a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        GlobalShareModel globalShareModel = (GlobalShareModel) obj;
                        if (globalShareModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(globalShareModel.m15525a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            globalShareModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GlobalShareParser.m15658a(globalShareModel.w_(), globalShareModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(GlobalShareModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: app_section_actor */
                public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f9141d;

                    /* compiled from: app_section_actor */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                        }

                        public Object m15514a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TitleParser.m15655a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: app_section_actor */
                    public class Serializer extends JsonSerializer<TitleModel> {
                        public final void m15515a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TitleModel titleModel = (TitleModel) obj;
                            if (titleModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(titleModel.m15517a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TitleParser.m15656a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(TitleModel.class, new Serializer());
                        }
                    }

                    public TitleModel() {
                        super(1);
                    }

                    @Nullable
                    private String m15516a() {
                        this.f9141d = super.a(this.f9141d, 0);
                        return this.f9141d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m15518a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m15517a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m15516a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public GlobalShareModel() {
                    super(6);
                }

                @Nonnull
                private ImmutableList<String> m15519j() {
                    this.f9142d = super.a(this.f9142d, 0);
                    return (ImmutableList) this.f9142d;
                }

                @Nullable
                private String m15520k() {
                    this.f9143e = super.a(this.f9143e, 1);
                    return this.f9143e;
                }

                @Nullable
                private String m15521l() {
                    this.f9144f = super.a(this.f9144f, 2);
                    return this.f9144f;
                }

                @Nullable
                private com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.SingleSongMusicAttachmentModel.GlobalShareModel.OpenGraphNodeModel m15522m() {
                    this.f9145g = (com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.SingleSongMusicAttachmentModel.GlobalShareModel.OpenGraphNodeModel) super.a(this.f9145g, 3, com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.SingleSongMusicAttachmentModel.GlobalShareModel.OpenGraphNodeModel.class);
                    return this.f9145g;
                }

                @Nullable
                private TitleModel m15523n() {
                    this.f9146h = (TitleModel) super.a(this.f9146h, 4, TitleModel.class);
                    return this.f9146h;
                }

                @Nullable
                private String m15524o() {
                    this.f9147i = super.a(this.f9147i, 5);
                    return this.f9147i;
                }

                @Nullable
                public final String m15527a() {
                    return m15521l();
                }

                public final int jK_() {
                    return 514783620;
                }

                public final GraphQLVisitableModel m15526a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15522m() != null) {
                        com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.SingleSongMusicAttachmentModel.GlobalShareModel.OpenGraphNodeModel openGraphNodeModel = (com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.SingleSongMusicAttachmentModel.GlobalShareModel.OpenGraphNodeModel) graphQLModelMutatingVisitor.b(m15522m());
                        if (m15522m() != openGraphNodeModel) {
                            graphQLVisitableModel = (GlobalShareModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9145g = openGraphNodeModel;
                        }
                    }
                    if (m15523n() != null) {
                        TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m15523n());
                        if (m15523n() != titleModel) {
                            graphQLVisitableModel = (GlobalShareModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9146h = titleModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15525a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int c = flatBufferBuilder.c(m15519j());
                    int b = flatBufferBuilder.b(m15520k());
                    int b2 = flatBufferBuilder.b(m15521l());
                    int a = ModelHelper.a(flatBufferBuilder, m15522m());
                    int a2 = ModelHelper.a(flatBufferBuilder, m15523n());
                    int b3 = flatBufferBuilder.b(m15524o());
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, c);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, a);
                    flatBufferBuilder.b(4, a2);
                    flatBufferBuilder.b(5, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1685569197)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_section_actor */
            public final class ItemPriceModel extends BaseModel implements GraphQLVisitableModel {
                private double f9148d;
                @Nullable
                private String f9149e;
                private int f9150f;
                @Nullable
                private String f9151g;

                /* compiled from: app_section_actor */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ItemPriceModel.class, new Deserializer());
                    }

                    public Object m15528a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ItemPriceParser.m15659a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object itemPriceModel = new ItemPriceModel();
                        ((BaseModel) itemPriceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (itemPriceModel instanceof Postprocessable) {
                            return ((Postprocessable) itemPriceModel).a();
                        }
                        return itemPriceModel;
                    }
                }

                /* compiled from: app_section_actor */
                public class Serializer extends JsonSerializer<ItemPriceModel> {
                    public final void m15529a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ItemPriceModel itemPriceModel = (ItemPriceModel) obj;
                        if (itemPriceModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(itemPriceModel.m15532a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            itemPriceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ItemPriceParser.m15660a(itemPriceModel.w_(), itemPriceModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ItemPriceModel.class, new Serializer());
                    }
                }

                public ItemPriceModel() {
                    super(4);
                }

                @Nullable
                private String m15530a() {
                    this.f9149e = super.a(this.f9149e, 1);
                    return this.f9149e;
                }

                @Nullable
                private String m15531j() {
                    this.f9151g = super.a(this.f9151g, 3);
                    return this.f9151g;
                }

                public final int jK_() {
                    return 753818588;
                }

                public final GraphQLVisitableModel m15533a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15532a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15530a());
                    int b2 = flatBufferBuilder.b(m15531j());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.a(0, this.f9148d, 0.0d);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.a(2, this.f9150f, 0);
                    flatBufferBuilder.b(3, b2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m15534a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f9148d = mutableFlatBuffer.a(i, 0, 0.0d);
                    this.f9150f = mutableFlatBuffer.a(i, 2, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1255661007)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_section_actor */
            public final class OwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f9152d;
                @Nullable
                private String f9153e;
                @Nullable
                private String f9154f;

                /* compiled from: app_section_actor */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                    }

                    public Object m15535a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OwnerParser.m15661a(jsonParser, flatBufferBuilder));
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

                /* compiled from: app_section_actor */
                public class Serializer extends JsonSerializer<OwnerModel> {
                    public final void m15536a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OwnerModel ownerModel = (OwnerModel) obj;
                        if (ownerModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ownerModel.m15540a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OwnerParser.m15662a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(OwnerModel.class, new Serializer());
                    }
                }

                public OwnerModel() {
                    super(3);
                }

                public final void m15543a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m15544a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m15537j() {
                    if (this.b != null && this.f9152d == null) {
                        this.f9152d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f9152d;
                }

                @Nullable
                private String m15538k() {
                    this.f9153e = super.a(this.f9153e, 1);
                    return this.f9153e;
                }

                @Nullable
                private String m15539l() {
                    this.f9154f = super.a(this.f9154f, 2);
                    return this.f9154f;
                }

                @Nullable
                public final String m15542a() {
                    return m15538k();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m15541a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15540a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15537j());
                    int b = flatBufferBuilder.b(m15538k());
                    int b2 = flatBufferBuilder.b(m15539l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: app_section_actor */
            public class Serializer extends JsonSerializer<TargetModel> {
                public final void m15545a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TargetModel targetModel = (TargetModel) obj;
                    if (targetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(targetModel.m15593a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        targetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TargetParser.m15666a(targetModel.w_(), targetModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TargetModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_section_actor */
            public final class TitleModel extends BaseModel implements DefaultTextWithEntitiesFields, GraphQLVisitableModel {
                @Nullable
                private String f9155d;

                /* compiled from: app_section_actor */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m15546a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TargetParser.TitleParser.m15663a(jsonParser, flatBufferBuilder));
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

                /* compiled from: app_section_actor */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m15547a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m15548a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TargetParser.TitleParser.m15664a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                public final String m15550a() {
                    this.f9155d = super.a(this.f9155d, 0);
                    return this.f9155d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m15549a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15548a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15550a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ EventCoverPhotoModel bv_() {
                return m15574X();
            }

            @Nullable
            public final /* synthetic */ NewsFeedDefaultsEventPlaceFieldsModel mo1103g() {
                return m15575Y();
            }

            public TargetModel() {
                super(135);
            }

            public final void m15597a(String str, ConsistencyTuple consistencyTuple) {
                if ("friendship_status".equals(str)) {
                    consistencyTuple.a = ab();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 47;
                } else if ("is_sold".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(ak());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 63;
                } else if ("viewer_guest_status".equals(str)) {
                    consistencyTuple.a = mo1108n();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 128;
                } else if ("viewer_has_pending_invite".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(mo1109o());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 129;
                } else if ("viewer_saved_state".equals(str)) {
                    consistencyTuple.a = bo();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 131;
                } else if ("viewer_watch_status".equals(str)) {
                    consistencyTuple.a = mo1110p();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 133;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m15598a(String str, Object obj, boolean z) {
                if ("friendship_status".equals(str)) {
                    m15579a((GraphQLFriendshipStatus) obj);
                } else if ("is_sold".equals(str)) {
                    m15581a(((Boolean) obj).booleanValue());
                } else if ("viewer_guest_status".equals(str)) {
                    m15577a((GraphQLEventGuestStatus) obj);
                } else if ("viewer_has_pending_invite".equals(str)) {
                    m15582b(((Boolean) obj).booleanValue());
                } else if ("viewer_saved_state".equals(str)) {
                    m15580a((GraphQLSavedState) obj);
                } else if ("viewer_watch_status".equals(str)) {
                    m15578a((GraphQLEventWatchStatus) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m15583q() {
                if (this.b != null && this.f9182d == null) {
                    this.f9182d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9182d;
            }

            @Nullable
            private DefaultImageFieldsModel m15584r() {
                this.f9183e = (DefaultImageFieldsModel) super.a(this.f9183e, 1, DefaultImageFieldsModel.class);
                return this.f9183e;
            }

            @Nonnull
            private ImmutableList<ActionLinksModel> m15585s() {
                this.f9184f = super.a(this.f9184f, 2, ActionLinksModel.class);
                return (ImmutableList) this.f9184f;
            }

            @Nonnull
            private ImmutableList<AdditionalAccentImagesModel> m15586t() {
                this.f9185g = super.a(this.f9185g, 3, AdditionalAccentImagesModel.class);
                return (ImmutableList) this.f9185g;
            }

            @Nullable
            private AddressModel m15587u() {
                this.f9186h = (AddressModel) super.a(this.f9186h, 4, AddressModel.class);
                return this.f9186h;
            }

            @Nullable
            private String m15588v() {
                this.f9188j = super.a(this.f9188j, 6);
                return this.f9188j;
            }

            @Nullable
            private AndroidAppConfigModel m15589w() {
                this.f9189k = (AndroidAppConfigModel) super.a(this.f9189k, 7, AndroidAppConfigModel.class);
                return this.f9189k;
            }

            @Nullable
            private String m15590x() {
                this.f9190l = super.a(this.f9190l, 8);
                return this.f9190l;
            }

            @Nonnull
            private ImmutableList<String> m15591y() {
                this.f9191m = super.a(this.f9191m, 9);
                return (ImmutableList) this.f9191m;
            }

            @Nullable
            private DefaultImageFieldsModel m15592z() {
                this.f9192n = (DefaultImageFieldsModel) super.a(this.f9192n, 10, DefaultImageFieldsModel.class);
                return this.f9192n;
            }

            @Nullable
            private InnerApplicationFieldsModel m15551A() {
                this.f9193o = (InnerApplicationFieldsModel) super.a(this.f9193o, 11, InnerApplicationFieldsModel.class);
                return this.f9193o;
            }

            @Nullable
            private String m15552B() {
                this.f9194p = super.a(this.f9194p, 12);
                return this.f9194p;
            }

            @Nonnull
            private ImmutableList<String> m15553C() {
                this.f9195q = super.a(this.f9195q, 13);
                return (ImmutableList) this.f9195q;
            }

            @Nullable
            private String m15554D() {
                this.f9196r = super.a(this.f9196r, 14);
                return this.f9196r;
            }

            @Nullable
            private String m15555E() {
                this.f9197s = super.a(this.f9197s, 15);
                return this.f9197s;
            }

            @Nonnull
            private ImmutableList<BylinesModel> m15556F() {
                this.f9199u = super.a(this.f9199u, 17, BylinesModel.class);
                return (ImmutableList) this.f9199u;
            }

            @Nullable
            private CampaignModel m15557G() {
                this.f9200v = (CampaignModel) super.a(this.f9200v, 18, CampaignModel.class);
                return this.f9200v;
            }

            @Nullable
            private String m15558H() {
                this.f9201w = super.a(this.f9201w, 19);
                return this.f9201w;
            }

            @Nullable
            private String m15559I() {
                this.f9202x = super.a(this.f9202x, 20);
                return this.f9202x;
            }

            public final boolean mo1097b() {
                a(2, 6);
                return this.f9204z;
            }

            @Nullable
            private String m15560J() {
                this.f9158C = super.a(this.f9158C, 25);
                return this.f9158C;
            }

            @Nonnull
            private ImmutableList<String> m15561K() {
                this.f9159D = super.a(this.f9159D, 26);
                return (ImmutableList) this.f9159D;
            }

            @Nullable
            private CharityModel m15562L() {
                this.f9160E = (CharityModel) super.a(this.f9160E, 27, CharityModel.class);
                return this.f9160E;
            }

            @Nullable
            private CityModel m15563M() {
                this.f9161F = (CityModel) super.a(this.f9161F, 28, CityModel.class);
                return this.f9161F;
            }

            @Nonnull
            private ImmutableList<String> m15564N() {
                this.f9162G = super.a(this.f9162G, 29);
                return (ImmutableList) this.f9162G;
            }

            @Nullable
            public final GraphQLConnectionStyle mo1101c() {
                this.f9163H = (GraphQLConnectionStyle) super.b(this.f9163H, 30, GraphQLConnectionStyle.class, GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9163H;
            }

            @Nullable
            private String m15565O() {
                this.f9164I = super.a(this.f9164I, 31);
                return this.f9164I;
            }

            @Nullable
            private CoverPhotoModel m15566P() {
                this.f9165J = (CoverPhotoModel) super.a(this.f9165J, 32, CoverPhotoModel.class);
                return this.f9165J;
            }

            @Nullable
            private String m15567Q() {
                this.f9166K = super.a(this.f9166K, 33);
                return this.f9166K;
            }

            @Nullable
            private CulturalMomentImageModel m15568R() {
                this.f9167L = (CulturalMomentImageModel) super.a(this.f9167L, 34, CulturalMomentImageModel.class);
                return this.f9167L;
            }

            @Nullable
            private CulturalMomentVideoModel m15569S() {
                this.f9168M = (CulturalMomentVideoModel) super.a(this.f9168M, 35, CulturalMomentVideoModel.class);
                return this.f9168M;
            }

            @Nullable
            private DeprecatedCurrencyQuantityFieldsModel m15570T() {
                this.f9169N = (DeprecatedCurrencyQuantityFieldsModel) super.a(this.f9169N, 36, DeprecatedCurrencyQuantityFieldsModel.class);
                return this.f9169N;
            }

            @Nullable
            private DataPointsModel m15571U() {
                this.f9170O = (DataPointsModel) super.a(this.f9170O, 37, DataPointsModel.class);
                return this.f9170O;
            }

            @Nullable
            private DonorsModel m15572V() {
                this.f9171P = (DonorsModel) super.a(this.f9171P, 38, DonorsModel.class);
                return this.f9171P;
            }

            @Nullable
            private EmployerModel m15573W() {
                this.f9173R = (EmployerModel) super.a(this.f9173R, 40, EmployerModel.class);
                return this.f9173R;
            }

            public final long mo1102d() {
                a(5, 1);
                return this.f9174S;
            }

            @Nullable
            private EventCoverPhotoModel m15574X() {
                this.f9175T = (EventCoverPhotoModel) super.a(this.f9175T, 42, EventCoverPhotoModel.class);
                return this.f9175T;
            }

            @Nullable
            private NewsFeedDefaultsEventPlaceFieldsModel m15575Y() {
                this.f9176U = (NewsFeedDefaultsEventPlaceFieldsModel) super.a(this.f9176U, 43, NewsFeedDefaultsEventPlaceFieldsModel.class);
                return this.f9176U;
            }

            @Nullable
            private FaviconModel m15576Z() {
                this.f9178W = (FaviconModel) super.a(this.f9178W, 45, FaviconModel.class);
                return this.f9178W;
            }

            @Nullable
            private NewsFeedDefaultsFeedbackModel aa() {
                this.f9179X = (NewsFeedDefaultsFeedbackModel) super.a(this.f9179X, 46, NewsFeedDefaultsFeedbackModel.class);
                return this.f9179X;
            }

            @Nullable
            private GraphQLFriendshipStatus ab() {
                this.f9180Y = (GraphQLFriendshipStatus) super.b(this.f9180Y, 47, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9180Y;
            }

            private void m15579a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                this.f9180Y = graphQLFriendshipStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 47, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                }
            }

            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel ac() {
                this.f9181Z = (DefaultTextWithEntitiesWithRangesFieldsModel) super.a(this.f9181Z, 48, DefaultTextWithEntitiesWithRangesFieldsModel.class);
                return this.f9181Z;
            }

            @Nullable
            private GlobalShareModel ad() {
                this.aa = (GlobalShareModel) super.a(this.aa, 49, GlobalShareModel.class);
                return this.aa;
            }

            @Nullable
            private DefaultTextWithEntitiesFieldsModel ae() {
                this.ab = (DefaultTextWithEntitiesFieldsModel) super.a(this.ab, 50, DefaultTextWithEntitiesFieldsModel.class);
                return this.ab;
            }

            @Nullable
            private GreetingCardTemplateModel af() {
                this.ac = (GreetingCardTemplateModel) super.a(this.ac, 51, GreetingCardTemplateModel.class);
                return this.ac;
            }

            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel ag() {
                this.ad = (DefaultTextWithEntitiesWithRangesFieldsModel) super.a(this.ad, 52, DefaultTextWithEntitiesWithRangesFieldsModel.class);
                return this.ad;
            }

            @Nullable
            public final String bt_() {
                this.af = super.a(this.af, 54);
                return this.af;
            }

            @Nullable
            private DefaultImageFieldsModel ah() {
                this.ag = (DefaultImageFieldsModel) super.a(this.ag, 55, DefaultImageFieldsModel.class);
                return this.ag;
            }

            @Nullable
            private String ai() {
                this.ah = super.a(this.ah, 56);
                return this.ah;
            }

            @Nullable
            private InstantArticleModel aj() {
                this.ai = (InstantArticleModel) super.a(this.ai, 57, InstantArticleModel.class);
                return this.ai;
            }

            public final boolean bu_() {
                a(7, 2);
                return this.aj;
            }

            private boolean ak() {
                a(7, 7);
                return this.ao;
            }

            private void m15581a(boolean z) {
                this.ao = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 63, z);
                }
            }

            @Nullable
            private ItemPriceModel al() {
                this.ap = (ItemPriceModel) super.a(this.ap, 64, ItemPriceModel.class);
                return this.ap;
            }

            @Nullable
            private ListItemsModel am() {
                this.aq = (ListItemsModel) super.a(this.aq, 65, ListItemsModel.class);
                return this.aq;
            }

            @Nullable
            private DefaultLocationFieldsModel an() {
                this.ar = (DefaultLocationFieldsModel) super.a(this.ar, 66, DefaultLocationFieldsModel.class);
                return this.ar;
            }

            @Nullable
            private DefaultImageFieldsModel ao() {
                this.as = (DefaultImageFieldsModel) super.a(this.as, 67, DefaultImageFieldsModel.class);
                return this.as;
            }

            @Nullable
            private MapBoundingBoxModel ap() {
                this.at = (MapBoundingBoxModel) super.a(this.at, 68, MapBoundingBoxModel.class);
                return this.at;
            }

            @Nullable
            private MediaModel aq() {
                this.au = (MediaModel) super.a(this.au, 69, MediaModel.class);
                return this.au;
            }

            @Nullable
            private MediaElementsModel ar() {
                this.av = (MediaElementsModel) super.a(this.av, 70, MediaElementsModel.class);
                return this.av;
            }

            @Nullable
            private MediaQuestionOptionOrderModel as() {
                this.aw = (MediaQuestionOptionOrderModel) super.a(this.aw, 71, MediaQuestionOptionOrderModel.class);
                return this.aw;
            }

            @Nonnull
            private ImmutableList<MediaQuestionPhotosModel> at() {
                this.ax = super.a(this.ax, 72, MediaQuestionPhotosModel.class);
                return (ImmutableList) this.ax;
            }

            @Nullable
            private String au() {
                this.ay = super.a(this.ay, 73);
                return this.ay;
            }

            @Nullable
            private DefaultTextWithEntitiesFieldsModel av() {
                this.az = (DefaultTextWithEntitiesFieldsModel) super.a(this.az, 74, DefaultTextWithEntitiesFieldsModel.class);
                return this.az;
            }

            @Nullable
            private MessengerContentSubscriptionOptionModel aw() {
                this.aA = (MessengerContentSubscriptionOptionModel) super.a(this.aA, 75, MessengerContentSubscriptionOptionModel.class);
                return this.aA;
            }

            @Nullable
            private MusicObjectModel ax() {
                this.aB = (MusicObjectModel) super.a(this.aB, 76, MusicObjectModel.class);
                return this.aB;
            }

            @Nullable
            private String ay() {
                this.aC = super.a(this.aC, 77);
                return this.aC;
            }

            @Nullable
            private GraphQLMusicType az() {
                this.aD = (GraphQLMusicType) super.b(this.aD, 78, GraphQLMusicType.class, GraphQLMusicType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.aD;
            }

            @Nonnull
            private ImmutableList<MusiciansModel> aA() {
                this.aE = super.a(this.aE, 79, MusiciansModel.class);
                return (ImmutableList) this.aE;
            }

            @Nullable
            public final String mo1104j() {
                this.aF = super.a(this.aF, 80);
                return this.aF;
            }

            @Nullable
            private NonSpecificPlaceToSearchModel aB() {
                this.aG = (NonSpecificPlaceToSearchModel) super.a(this.aG, 81, NonSpecificPlaceToSearchModel.class);
                return this.aG;
            }

            @Nullable
            private OpenGraphNodeModel aC() {
                this.aH = (OpenGraphNodeModel) super.a(this.aH, 82, OpenGraphNodeModel.class);
                return this.aH;
            }

            @Nullable
            private OptionsModel aD() {
                this.aI = (OptionsModel) super.a(this.aI, 83, OptionsModel.class);
                return this.aI;
            }

            @Nullable
            private OverallStarRatingModel aE() {
                this.aJ = (OverallStarRatingModel) super.a(this.aJ, 84, OverallStarRatingModel.class);
                return this.aJ;
            }

            @Nullable
            private OwnerModel aF() {
                this.aK = (OwnerModel) super.a(this.aK, 85, OwnerModel.class);
                return this.aK;
            }

            @Nullable
            private PageLikersModel aG() {
                this.aL = (PageLikersModel) super.a(this.aL, 86, PageLikersModel.class);
                return this.aL;
            }

            @Nullable
            private PageVisitsModel aH() {
                this.aM = (PageVisitsModel) super.a(this.aM, 87, PageVisitsModel.class);
                return this.aM;
            }

            @Nonnull
            private ImmutableList<CommentPlaceInfoPageFieldsModel> aI() {
                this.aN = super.a(this.aN, 88, CommentPlaceInfoPageFieldsModel.class);
                return (ImmutableList) this.aN;
            }

            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel aJ() {
                this.aP = (DefaultTextWithEntitiesWithRangesFieldsModel) super.a(this.aP, 90, DefaultTextWithEntitiesWithRangesFieldsModel.class);
                return this.aP;
            }

            @Nullable
            private PlaceListItemsModel aK() {
                this.aQ = (PlaceListItemsModel) super.a(this.aQ, 91, PlaceListItemsModel.class);
                return this.aQ;
            }

            @Nullable
            private String aL() {
                this.aR = super.a(this.aR, 92);
                return this.aR;
            }

            @Nullable
            private GraphQLQuestionPollAnswersState aM() {
                this.aS = (GraphQLQuestionPollAnswersState) super.b(this.aS, 93, GraphQLQuestionPollAnswersState.class, GraphQLQuestionPollAnswersState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.aS;
            }

            @Nonnull
            private ImmutableList<PreviewUrlsModel> aN() {
                this.aT = super.a(this.aT, 94, PreviewUrlsModel.class);
                return (ImmutableList) this.aT;
            }

            @Nullable
            private GraphQLGroupCommercePriceType aO() {
                this.aU = (GraphQLGroupCommercePriceType) super.b(this.aU, 95, GraphQLGroupCommercePriceType.class, GraphQLGroupCommercePriceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.aU;
            }

            @Nullable
            private DefaultImageFieldsModel aP() {
                this.aV = (DefaultImageFieldsModel) super.a(this.aV, 96, DefaultImageFieldsModel.class);
                return this.aV;
            }

            @Nullable
            private PrimaryObjectNodeModel aQ() {
                this.aW = (PrimaryObjectNodeModel) super.a(this.aW, 97, PrimaryObjectNodeModel.class);
                return this.aW;
            }

            @Nullable
            private DefaultImageFieldsModel aR() {
                this.aX = (DefaultImageFieldsModel) super.a(this.aX, 98, DefaultImageFieldsModel.class);
                return this.aX;
            }

            @Nullable
            private QuoteModel aS() {
                this.aZ = (QuoteModel) super.a(this.aZ, 100, QuoteModel.class);
                return this.aZ;
            }

            @Nullable
            private RatingModel aT() {
                this.ba = (RatingModel) super.a(this.ba, 101, RatingModel.class);
                return this.ba;
            }

            @Nullable
            private DefaultImageFieldsModel aU() {
                this.bb = (DefaultImageFieldsModel) super.a(this.bb, 102, DefaultImageFieldsModel.class);
                return this.bb;
            }

            @Nonnull
            private ImmutableList<RedirectionInfoModel> aV() {
                this.bc = super.a(this.bc, 103, RedirectionInfoModel.class);
                return (ImmutableList) this.bc;
            }

            @Nullable
            private GraphQLQuestionResponseMethod aW() {
                this.bd = (GraphQLQuestionResponseMethod) super.b(this.bd, 104, GraphQLQuestionResponseMethod.class, GraphQLQuestionResponseMethod.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.bd;
            }

            @Nullable
            private SavableTimelineAppCollectionExtraFieldsModel aX() {
                this.be = (SavableTimelineAppCollectionExtraFieldsModel) super.a(this.be, 105, SavableTimelineAppCollectionExtraFieldsModel.class);
                return this.be;
            }

            @Nullable
            private SchoolModel aY() {
                this.bf = (SchoolModel) super.a(this.bf, 106, SchoolModel.class);
                return this.bf;
            }

            @Nullable
            private SchoolClassModel aZ() {
                this.bg = (SchoolClassModel) super.a(this.bg, 107, SchoolClassModel.class);
                return this.bg;
            }

            @Nullable
            private SlidesModel ba() {
                this.bk = (SlidesModel) super.a(this.bk, 111, SlidesModel.class);
                return this.bk;
            }

            @Nullable
            private SocialContextModel bb() {
                this.bl = (SocialContextModel) super.a(this.bl, 112, SocialContextModel.class);
                return this.bl;
            }

            @Nullable
            private String bc() {
                this.bm = super.a(this.bm, 113);
                return this.bm;
            }

            @Nullable
            private DefaultTextWithEntitiesFieldsModel bd() {
                this.bn = (DefaultTextWithEntitiesFieldsModel) super.a(this.bn, 114, DefaultTextWithEntitiesFieldsModel.class);
                return this.bn;
            }

            @Nullable
            private SizeAwareMediaModel be() {
                this.bo = (SizeAwareMediaModel) super.a(this.bo, 115, SizeAwareMediaModel.class);
                return this.bo;
            }

            @Nullable
            private SportsMatchDataModel bf() {
                this.bp = (SportsMatchDataModel) super.a(this.bp, 116, SportsMatchDataModel.class);
                return this.bp;
            }

            @Nullable
            private DefaultImageUriFieldsModel bg() {
                this.bq = (DefaultImageUriFieldsModel) super.a(this.bq, 117, DefaultImageUriFieldsModel.class);
                return this.bq;
            }

            public final long mo1105k() {
                a(14, 6);
                return this.br;
            }

            @Nullable
            private String bh() {
                this.bs = super.a(this.bs, 119);
                return this.bs;
            }

            @Nullable
            private GraphQLPageSuperCategoryType bi() {
                this.bt = (GraphQLPageSuperCategoryType) super.b(this.bt, 120, GraphQLPageSuperCategoryType.class, GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.bt;
            }

            @Nullable
            private String bj() {
                this.bu = super.a(this.bu, 121);
                return this.bu;
            }

            @Nullable
            private String bk() {
                this.bv = super.a(this.bv, 122);
                return this.bv;
            }

            @Nonnull
            private ImmutableList<SizeAwareMediaModel> bl() {
                this.bw = super.a(this.bw, 123, SizeAwareMediaModel.class);
                return (ImmutableList) this.bw;
            }

            @Nonnull
            private ImmutableList<ThrowbackMediaAttachmentFieldsModel> bm() {
                this.bx = super.a(this.bx, 124, ThrowbackMediaAttachmentFieldsModel.class);
                return (ImmutableList) this.bx;
            }

            @Nullable
            public final String mo1106l() {
                this.by = super.a(this.by, 125);
                return this.by;
            }

            @Nullable
            private TitleModel bn() {
                this.bz = (TitleModel) super.a(this.bz, 126, TitleModel.class);
                return this.bz;
            }

            @Nullable
            public final String mo1107m() {
                this.bA = super.a(this.bA, 127);
                return this.bA;
            }

            @Nullable
            public final GraphQLEventGuestStatus mo1108n() {
                this.bB = (GraphQLEventGuestStatus) super.b(this.bB, 128, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.bB;
            }

            private void m15577a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
                this.bB = graphQLEventGuestStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 128, graphQLEventGuestStatus != null ? graphQLEventGuestStatus.name() : null);
                }
            }

            public final boolean mo1109o() {
                a(16, 1);
                return this.bC;
            }

            private void m15582b(boolean z) {
                this.bC = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 129, z);
                }
            }

            @Nullable
            private GraphQLSavedState bo() {
                this.bE = (GraphQLSavedState) super.b(this.bE, 131, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.bE;
            }

            private void m15580a(GraphQLSavedState graphQLSavedState) {
                this.bE = graphQLSavedState;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 131, graphQLSavedState != null ? graphQLSavedState.name() : null);
                }
            }

            @Nullable
            private ViewerVisitsModel bp() {
                this.bF = (ViewerVisitsModel) super.a(this.bF, 132, ViewerVisitsModel.class);
                return this.bF;
            }

            @Nullable
            public final GraphQLEventWatchStatus mo1110p() {
                this.bG = (GraphQLEventWatchStatus) super.b(this.bG, 133, GraphQLEventWatchStatus.class, GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.bG;
            }

            private void m15578a(GraphQLEventWatchStatus graphQLEventWatchStatus) {
                this.bG = graphQLEventWatchStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 133, graphQLEventWatchStatus != null ? graphQLEventWatchStatus.name() : null);
                }
            }

            @Nullable
            private WorkProjectModel bq() {
                this.bH = (WorkProjectModel) super.a(this.bH, 134, WorkProjectModel.class);
                return this.bH;
            }

            @Nullable
            public final String m15595a() {
                return bt_();
            }

            public final int jK_() {
                return 2433570;
            }

            public final GraphQLVisitableModel m15594a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultImageFieldsModel defaultImageFieldsModel;
                Builder a;
                DefaultTextWithEntitiesWithRangesFieldsModel defaultTextWithEntitiesWithRangesFieldsModel;
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15584r() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15584r());
                    if (m15584r() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9183e = defaultImageFieldsModel;
                    }
                }
                if (m15585s() != null) {
                    a = ModelHelper.a(m15585s(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        TargetModel targetModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        targetModel.f9184f = a.b();
                        graphQLVisitableModel = targetModel;
                    }
                }
                if (m15586t() != null) {
                    a = ModelHelper.a(m15586t(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        targetModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        targetModel.f9185g = a.b();
                        graphQLVisitableModel = targetModel;
                    }
                }
                if (m15587u() != null) {
                    AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m15587u());
                    if (m15587u() != addressModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9186h = addressModel;
                    }
                }
                if (m15589w() != null) {
                    AndroidAppConfigModel androidAppConfigModel = (AndroidAppConfigModel) graphQLModelMutatingVisitor.b(m15589w());
                    if (m15589w() != androidAppConfigModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9189k = androidAppConfigModel;
                    }
                }
                if (m15592z() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15592z());
                    if (m15592z() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9192n = defaultImageFieldsModel;
                    }
                }
                if (m15551A() != null) {
                    InnerApplicationFieldsModel innerApplicationFieldsModel = (InnerApplicationFieldsModel) graphQLModelMutatingVisitor.b(m15551A());
                    if (m15551A() != innerApplicationFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9193o = innerApplicationFieldsModel;
                    }
                }
                if (m15556F() != null) {
                    a = ModelHelper.a(m15556F(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        targetModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        targetModel.f9199u = a.b();
                        graphQLVisitableModel = targetModel;
                    }
                }
                if (m15557G() != null) {
                    CampaignModel campaignModel = (CampaignModel) graphQLModelMutatingVisitor.b(m15557G());
                    if (m15557G() != campaignModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9200v = campaignModel;
                    }
                }
                if (m15562L() != null) {
                    CharityModel charityModel = (CharityModel) graphQLModelMutatingVisitor.b(m15562L());
                    if (m15562L() != charityModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9160E = charityModel;
                    }
                }
                if (m15563M() != null) {
                    CityModel cityModel = (CityModel) graphQLModelMutatingVisitor.b(m15563M());
                    if (m15563M() != cityModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9161F = cityModel;
                    }
                }
                if (m15566P() != null) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m15566P());
                    if (m15566P() != coverPhotoModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9165J = coverPhotoModel;
                    }
                }
                if (m15568R() != null) {
                    CulturalMomentImageModel culturalMomentImageModel = (CulturalMomentImageModel) graphQLModelMutatingVisitor.b(m15568R());
                    if (m15568R() != culturalMomentImageModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9167L = culturalMomentImageModel;
                    }
                }
                if (m15569S() != null) {
                    CulturalMomentVideoModel culturalMomentVideoModel = (CulturalMomentVideoModel) graphQLModelMutatingVisitor.b(m15569S());
                    if (m15569S() != culturalMomentVideoModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9168M = culturalMomentVideoModel;
                    }
                }
                if (m15570T() != null) {
                    DeprecatedCurrencyQuantityFieldsModel deprecatedCurrencyQuantityFieldsModel = (DeprecatedCurrencyQuantityFieldsModel) graphQLModelMutatingVisitor.b(m15570T());
                    if (m15570T() != deprecatedCurrencyQuantityFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9169N = deprecatedCurrencyQuantityFieldsModel;
                    }
                }
                if (m15571U() != null) {
                    DataPointsModel dataPointsModel = (DataPointsModel) graphQLModelMutatingVisitor.b(m15571U());
                    if (m15571U() != dataPointsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9170O = dataPointsModel;
                    }
                }
                if (m15572V() != null) {
                    DonorsModel donorsModel = (DonorsModel) graphQLModelMutatingVisitor.b(m15572V());
                    if (m15572V() != donorsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9171P = donorsModel;
                    }
                }
                if (m15573W() != null) {
                    EmployerModel employerModel = (EmployerModel) graphQLModelMutatingVisitor.b(m15573W());
                    if (m15573W() != employerModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9173R = employerModel;
                    }
                }
                if (m15574X() != null) {
                    EventCoverPhotoModel eventCoverPhotoModel = (EventCoverPhotoModel) graphQLModelMutatingVisitor.b(m15574X());
                    if (m15574X() != eventCoverPhotoModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9175T = eventCoverPhotoModel;
                    }
                }
                if (m15575Y() != null) {
                    NewsFeedDefaultsEventPlaceFieldsModel newsFeedDefaultsEventPlaceFieldsModel = (NewsFeedDefaultsEventPlaceFieldsModel) graphQLModelMutatingVisitor.b(m15575Y());
                    if (m15575Y() != newsFeedDefaultsEventPlaceFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9176U = newsFeedDefaultsEventPlaceFieldsModel;
                    }
                }
                if (m15576Z() != null) {
                    FaviconModel faviconModel = (FaviconModel) graphQLModelMutatingVisitor.b(m15576Z());
                    if (m15576Z() != faviconModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9178W = faviconModel;
                    }
                }
                if (aa() != null) {
                    NewsFeedDefaultsFeedbackModel newsFeedDefaultsFeedbackModel = (NewsFeedDefaultsFeedbackModel) graphQLModelMutatingVisitor.b(aa());
                    if (aa() != newsFeedDefaultsFeedbackModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9179X = newsFeedDefaultsFeedbackModel;
                    }
                }
                if (ac() != null) {
                    defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(ac());
                    if (ac() != defaultTextWithEntitiesWithRangesFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9181Z = defaultTextWithEntitiesWithRangesFieldsModel;
                    }
                }
                if (ad() != null) {
                    GlobalShareModel globalShareModel = (GlobalShareModel) graphQLModelMutatingVisitor.b(ad());
                    if (ad() != globalShareModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aa = globalShareModel;
                    }
                }
                if (ae() != null) {
                    defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ae());
                    if (ae() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ab = defaultTextWithEntitiesFieldsModel;
                    }
                }
                if (af() != null) {
                    GreetingCardTemplateModel greetingCardTemplateModel = (GreetingCardTemplateModel) graphQLModelMutatingVisitor.b(af());
                    if (af() != greetingCardTemplateModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ac = greetingCardTemplateModel;
                    }
                }
                if (ag() != null) {
                    defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(ag());
                    if (ag() != defaultTextWithEntitiesWithRangesFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ad = defaultTextWithEntitiesWithRangesFieldsModel;
                    }
                }
                if (ah() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(ah());
                    if (ah() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ag = defaultImageFieldsModel;
                    }
                }
                if (aj() != null) {
                    InstantArticleModel instantArticleModel = (InstantArticleModel) graphQLModelMutatingVisitor.b(aj());
                    if (aj() != instantArticleModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ai = instantArticleModel;
                    }
                }
                if (al() != null) {
                    ItemPriceModel itemPriceModel = (ItemPriceModel) graphQLModelMutatingVisitor.b(al());
                    if (al() != itemPriceModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ap = itemPriceModel;
                    }
                }
                if (am() != null) {
                    ListItemsModel listItemsModel = (ListItemsModel) graphQLModelMutatingVisitor.b(am());
                    if (am() != listItemsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aq = listItemsModel;
                    }
                }
                if (an() != null) {
                    DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(an());
                    if (an() != defaultLocationFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ar = defaultLocationFieldsModel;
                    }
                }
                if (ao() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(ao());
                    if (ao() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.as = defaultImageFieldsModel;
                    }
                }
                if (ap() != null) {
                    MapBoundingBoxModel mapBoundingBoxModel = (MapBoundingBoxModel) graphQLModelMutatingVisitor.b(ap());
                    if (ap() != mapBoundingBoxModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.at = mapBoundingBoxModel;
                    }
                }
                if (aq() != null) {
                    MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(aq());
                    if (aq() != mediaModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.au = mediaModel;
                    }
                }
                if (ar() != null) {
                    MediaElementsModel mediaElementsModel = (MediaElementsModel) graphQLModelMutatingVisitor.b(ar());
                    if (ar() != mediaElementsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.av = mediaElementsModel;
                    }
                }
                if (as() != null) {
                    MediaQuestionOptionOrderModel mediaQuestionOptionOrderModel = (MediaQuestionOptionOrderModel) graphQLModelMutatingVisitor.b(as());
                    if (as() != mediaQuestionOptionOrderModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aw = mediaQuestionOptionOrderModel;
                    }
                }
                if (at() != null) {
                    a = ModelHelper.a(at(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        targetModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        targetModel.ax = a.b();
                        graphQLVisitableModel = targetModel;
                    }
                }
                if (av() != null) {
                    defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(av());
                    if (av() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.az = defaultTextWithEntitiesFieldsModel;
                    }
                }
                if (aw() != null) {
                    MessengerContentSubscriptionOptionModel messengerContentSubscriptionOptionModel = (MessengerContentSubscriptionOptionModel) graphQLModelMutatingVisitor.b(aw());
                    if (aw() != messengerContentSubscriptionOptionModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aA = messengerContentSubscriptionOptionModel;
                    }
                }
                if (ax() != null) {
                    MusicObjectModel musicObjectModel = (MusicObjectModel) graphQLModelMutatingVisitor.b(ax());
                    if (ax() != musicObjectModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aB = musicObjectModel;
                    }
                }
                if (aA() != null) {
                    a = ModelHelper.a(aA(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        targetModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        targetModel.aE = a.b();
                        graphQLVisitableModel = targetModel;
                    }
                }
                if (aB() != null) {
                    NonSpecificPlaceToSearchModel nonSpecificPlaceToSearchModel = (NonSpecificPlaceToSearchModel) graphQLModelMutatingVisitor.b(aB());
                    if (aB() != nonSpecificPlaceToSearchModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aG = nonSpecificPlaceToSearchModel;
                    }
                }
                if (aC() != null) {
                    OpenGraphNodeModel openGraphNodeModel = (OpenGraphNodeModel) graphQLModelMutatingVisitor.b(aC());
                    if (aC() != openGraphNodeModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aH = openGraphNodeModel;
                    }
                }
                if (aD() != null) {
                    OptionsModel optionsModel = (OptionsModel) graphQLModelMutatingVisitor.b(aD());
                    if (aD() != optionsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aI = optionsModel;
                    }
                }
                if (aE() != null) {
                    OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(aE());
                    if (aE() != overallStarRatingModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aJ = overallStarRatingModel;
                    }
                }
                if (aF() != null) {
                    OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(aF());
                    if (aF() != ownerModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aK = ownerModel;
                    }
                }
                if (aG() != null) {
                    PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(aG());
                    if (aG() != pageLikersModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aL = pageLikersModel;
                    }
                }
                if (aH() != null) {
                    PageVisitsModel pageVisitsModel = (PageVisitsModel) graphQLModelMutatingVisitor.b(aH());
                    if (aH() != pageVisitsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aM = pageVisitsModel;
                    }
                }
                if (aI() != null) {
                    a = ModelHelper.a(aI(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        targetModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        targetModel.aN = a.b();
                        graphQLVisitableModel = targetModel;
                    }
                }
                if (aJ() != null) {
                    defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(aJ());
                    if (aJ() != defaultTextWithEntitiesWithRangesFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aP = defaultTextWithEntitiesWithRangesFieldsModel;
                    }
                }
                if (aK() != null) {
                    PlaceListItemsModel placeListItemsModel = (PlaceListItemsModel) graphQLModelMutatingVisitor.b(aK());
                    if (aK() != placeListItemsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aQ = placeListItemsModel;
                    }
                }
                if (aN() != null) {
                    a = ModelHelper.a(aN(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        targetModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        targetModel.aT = a.b();
                        graphQLVisitableModel = targetModel;
                    }
                }
                if (aP() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(aP());
                    if (aP() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aV = defaultImageFieldsModel;
                    }
                }
                if (aQ() != null) {
                    PrimaryObjectNodeModel primaryObjectNodeModel = (PrimaryObjectNodeModel) graphQLModelMutatingVisitor.b(aQ());
                    if (aQ() != primaryObjectNodeModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aW = primaryObjectNodeModel;
                    }
                }
                if (aR() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(aR());
                    if (aR() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aX = defaultImageFieldsModel;
                    }
                }
                if (aS() != null) {
                    QuoteModel quoteModel = (QuoteModel) graphQLModelMutatingVisitor.b(aS());
                    if (aS() != quoteModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.aZ = quoteModel;
                    }
                }
                if (aT() != null) {
                    RatingModel ratingModel = (RatingModel) graphQLModelMutatingVisitor.b(aT());
                    if (aT() != ratingModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.ba = ratingModel;
                    }
                }
                if (aU() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(aU());
                    if (aU() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.bb = defaultImageFieldsModel;
                    }
                }
                if (aV() != null) {
                    a = ModelHelper.a(aV(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        targetModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        targetModel.bc = a.b();
                        graphQLVisitableModel = targetModel;
                    }
                }
                if (aX() != null) {
                    SavableTimelineAppCollectionExtraFieldsModel savableTimelineAppCollectionExtraFieldsModel = (SavableTimelineAppCollectionExtraFieldsModel) graphQLModelMutatingVisitor.b(aX());
                    if (aX() != savableTimelineAppCollectionExtraFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.be = savableTimelineAppCollectionExtraFieldsModel;
                    }
                }
                if (aY() != null) {
                    SchoolModel schoolModel = (SchoolModel) graphQLModelMutatingVisitor.b(aY());
                    if (aY() != schoolModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.bf = schoolModel;
                    }
                }
                if (aZ() != null) {
                    SchoolClassModel schoolClassModel = (SchoolClassModel) graphQLModelMutatingVisitor.b(aZ());
                    if (aZ() != schoolClassModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.bg = schoolClassModel;
                    }
                }
                if (ba() != null) {
                    SlidesModel slidesModel = (SlidesModel) graphQLModelMutatingVisitor.b(ba());
                    if (ba() != slidesModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.bk = slidesModel;
                    }
                }
                if (bb() != null) {
                    SocialContextModel socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(bb());
                    if (bb() != socialContextModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.bl = socialContextModel;
                    }
                }
                if (bd() != null) {
                    defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(bd());
                    if (bd() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.bn = defaultTextWithEntitiesFieldsModel;
                    }
                }
                if (be() != null) {
                    SizeAwareMediaModel sizeAwareMediaModel = (SizeAwareMediaModel) graphQLModelMutatingVisitor.b(be());
                    if (be() != sizeAwareMediaModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.bo = sizeAwareMediaModel;
                    }
                }
                if (bf() != null) {
                    SportsMatchDataModel sportsMatchDataModel = (SportsMatchDataModel) graphQLModelMutatingVisitor.b(bf());
                    if (bf() != sportsMatchDataModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.bp = sportsMatchDataModel;
                    }
                }
                if (bg() != null) {
                    DefaultImageUriFieldsModel defaultImageUriFieldsModel = (DefaultImageUriFieldsModel) graphQLModelMutatingVisitor.b(bg());
                    if (bg() != defaultImageUriFieldsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.bq = defaultImageUriFieldsModel;
                    }
                }
                if (bl() != null) {
                    a = ModelHelper.a(bl(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        targetModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        targetModel.bw = a.b();
                        graphQLVisitableModel = targetModel;
                    }
                }
                if (bm() != null) {
                    a = ModelHelper.a(bm(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        targetModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        targetModel.bx = a.b();
                        graphQLVisitableModel = targetModel;
                    }
                }
                if (bn() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(bn());
                    if (bn() != titleModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.bz = titleModel;
                    }
                }
                if (bp() != null) {
                    ViewerVisitsModel viewerVisitsModel = (ViewerVisitsModel) graphQLModelMutatingVisitor.b(bp());
                    if (bp() != viewerVisitsModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.bF = viewerVisitsModel;
                    }
                }
                if (bq() != null) {
                    WorkProjectModel workProjectModel = (WorkProjectModel) graphQLModelMutatingVisitor.b(bq());
                    if (bq() != workProjectModel) {
                        graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.bH = workProjectModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15593a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15583q());
                int a2 = ModelHelper.a(flatBufferBuilder, m15584r());
                int a3 = ModelHelper.a(flatBufferBuilder, m15585s());
                int a4 = ModelHelper.a(flatBufferBuilder, m15586t());
                int a5 = ModelHelper.a(flatBufferBuilder, m15587u());
                int b = flatBufferBuilder.b(m15588v());
                int a6 = ModelHelper.a(flatBufferBuilder, m15589w());
                int b2 = flatBufferBuilder.b(m15590x());
                int c = flatBufferBuilder.c(m15591y());
                int a7 = ModelHelper.a(flatBufferBuilder, m15592z());
                int a8 = ModelHelper.a(flatBufferBuilder, m15551A());
                int b3 = flatBufferBuilder.b(m15552B());
                int c2 = flatBufferBuilder.c(m15553C());
                int b4 = flatBufferBuilder.b(m15554D());
                int b5 = flatBufferBuilder.b(m15555E());
                int a9 = ModelHelper.a(flatBufferBuilder, m15556F());
                int a10 = ModelHelper.a(flatBufferBuilder, m15557G());
                int b6 = flatBufferBuilder.b(m15558H());
                int b7 = flatBufferBuilder.b(m15559I());
                int b8 = flatBufferBuilder.b(m15560J());
                int c3 = flatBufferBuilder.c(m15561K());
                int a11 = ModelHelper.a(flatBufferBuilder, m15562L());
                int a12 = ModelHelper.a(flatBufferBuilder, m15563M());
                int c4 = flatBufferBuilder.c(m15564N());
                int a13 = flatBufferBuilder.a(mo1101c());
                int b9 = flatBufferBuilder.b(m15565O());
                int a14 = ModelHelper.a(flatBufferBuilder, m15566P());
                int b10 = flatBufferBuilder.b(m15567Q());
                int a15 = ModelHelper.a(flatBufferBuilder, m15568R());
                int a16 = ModelHelper.a(flatBufferBuilder, m15569S());
                int a17 = ModelHelper.a(flatBufferBuilder, m15570T());
                int a18 = ModelHelper.a(flatBufferBuilder, m15571U());
                int a19 = ModelHelper.a(flatBufferBuilder, m15572V());
                int a20 = ModelHelper.a(flatBufferBuilder, m15573W());
                int a21 = ModelHelper.a(flatBufferBuilder, m15574X());
                int a22 = ModelHelper.a(flatBufferBuilder, m15575Y());
                int a23 = ModelHelper.a(flatBufferBuilder, m15576Z());
                int a24 = ModelHelper.a(flatBufferBuilder, aa());
                int a25 = flatBufferBuilder.a(ab());
                int a26 = ModelHelper.a(flatBufferBuilder, ac());
                int a27 = ModelHelper.a(flatBufferBuilder, ad());
                int a28 = ModelHelper.a(flatBufferBuilder, ae());
                int a29 = ModelHelper.a(flatBufferBuilder, af());
                int a30 = ModelHelper.a(flatBufferBuilder, ag());
                int b11 = flatBufferBuilder.b(bt_());
                int a31 = ModelHelper.a(flatBufferBuilder, ah());
                int b12 = flatBufferBuilder.b(ai());
                int a32 = ModelHelper.a(flatBufferBuilder, aj());
                int a33 = ModelHelper.a(flatBufferBuilder, al());
                int a34 = ModelHelper.a(flatBufferBuilder, am());
                int a35 = ModelHelper.a(flatBufferBuilder, an());
                int a36 = ModelHelper.a(flatBufferBuilder, ao());
                int a37 = ModelHelper.a(flatBufferBuilder, ap());
                int a38 = ModelHelper.a(flatBufferBuilder, aq());
                int a39 = ModelHelper.a(flatBufferBuilder, ar());
                int a40 = ModelHelper.a(flatBufferBuilder, as());
                int a41 = ModelHelper.a(flatBufferBuilder, at());
                int b13 = flatBufferBuilder.b(au());
                int a42 = ModelHelper.a(flatBufferBuilder, av());
                int a43 = ModelHelper.a(flatBufferBuilder, aw());
                int a44 = ModelHelper.a(flatBufferBuilder, ax());
                int b14 = flatBufferBuilder.b(ay());
                int a45 = flatBufferBuilder.a(az());
                int a46 = ModelHelper.a(flatBufferBuilder, aA());
                int b15 = flatBufferBuilder.b(mo1104j());
                int a47 = ModelHelper.a(flatBufferBuilder, aB());
                int a48 = ModelHelper.a(flatBufferBuilder, aC());
                int a49 = ModelHelper.a(flatBufferBuilder, aD());
                int a50 = ModelHelper.a(flatBufferBuilder, aE());
                int a51 = ModelHelper.a(flatBufferBuilder, aF());
                int a52 = ModelHelper.a(flatBufferBuilder, aG());
                int a53 = ModelHelper.a(flatBufferBuilder, aH());
                int a54 = ModelHelper.a(flatBufferBuilder, aI());
                int a55 = ModelHelper.a(flatBufferBuilder, aJ());
                int a56 = ModelHelper.a(flatBufferBuilder, aK());
                int b16 = flatBufferBuilder.b(aL());
                int a57 = flatBufferBuilder.a(aM());
                int a58 = ModelHelper.a(flatBufferBuilder, aN());
                int a59 = flatBufferBuilder.a(aO());
                int a60 = ModelHelper.a(flatBufferBuilder, aP());
                int a61 = ModelHelper.a(flatBufferBuilder, aQ());
                int a62 = ModelHelper.a(flatBufferBuilder, aR());
                int a63 = ModelHelper.a(flatBufferBuilder, aS());
                int a64 = ModelHelper.a(flatBufferBuilder, aT());
                int a65 = ModelHelper.a(flatBufferBuilder, aU());
                int a66 = ModelHelper.a(flatBufferBuilder, aV());
                int a67 = flatBufferBuilder.a(aW());
                int a68 = ModelHelper.a(flatBufferBuilder, aX());
                int a69 = ModelHelper.a(flatBufferBuilder, aY());
                int a70 = ModelHelper.a(flatBufferBuilder, aZ());
                int a71 = ModelHelper.a(flatBufferBuilder, ba());
                int a72 = ModelHelper.a(flatBufferBuilder, bb());
                int b17 = flatBufferBuilder.b(bc());
                int a73 = ModelHelper.a(flatBufferBuilder, bd());
                int a74 = ModelHelper.a(flatBufferBuilder, be());
                int a75 = ModelHelper.a(flatBufferBuilder, bf());
                int a76 = ModelHelper.a(flatBufferBuilder, bg());
                int b18 = flatBufferBuilder.b(bh());
                int a77 = flatBufferBuilder.a(bi());
                int b19 = flatBufferBuilder.b(bj());
                int b20 = flatBufferBuilder.b(bk());
                int a78 = ModelHelper.a(flatBufferBuilder, bl());
                int a79 = ModelHelper.a(flatBufferBuilder, bm());
                int b21 = flatBufferBuilder.b(mo1106l());
                int a80 = ModelHelper.a(flatBufferBuilder, bn());
                int b22 = flatBufferBuilder.b(mo1107m());
                int a81 = flatBufferBuilder.a(mo1108n());
                int a82 = flatBufferBuilder.a(bo());
                int a83 = ModelHelper.a(flatBufferBuilder, bp());
                int a84 = flatBufferBuilder.a(mo1110p());
                int a85 = ModelHelper.a(flatBufferBuilder, bq());
                flatBufferBuilder.c(135);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, a5);
                flatBufferBuilder.a(5, this.f9187i, 0);
                flatBufferBuilder.b(6, b);
                flatBufferBuilder.b(7, a6);
                flatBufferBuilder.b(8, b2);
                flatBufferBuilder.b(9, c);
                flatBufferBuilder.b(10, a7);
                flatBufferBuilder.b(11, a8);
                flatBufferBuilder.b(12, b3);
                flatBufferBuilder.b(13, c2);
                flatBufferBuilder.b(14, b4);
                flatBufferBuilder.b(15, b5);
                flatBufferBuilder.a(16, this.f9198t, 0.0d);
                flatBufferBuilder.b(17, a9);
                flatBufferBuilder.b(18, a10);
                flatBufferBuilder.b(19, b6);
                flatBufferBuilder.b(20, b7);
                flatBufferBuilder.a(21, this.f9203y);
                flatBufferBuilder.a(22, this.f9204z);
                flatBufferBuilder.a(23, this.f9156A);
                flatBufferBuilder.a(24, this.f9157B);
                flatBufferBuilder.b(25, b8);
                flatBufferBuilder.b(26, c3);
                flatBufferBuilder.b(27, a11);
                flatBufferBuilder.b(28, a12);
                flatBufferBuilder.b(29, c4);
                flatBufferBuilder.b(30, a13);
                flatBufferBuilder.b(31, b9);
                flatBufferBuilder.b(32, a14);
                flatBufferBuilder.b(33, b10);
                flatBufferBuilder.b(34, a15);
                flatBufferBuilder.b(35, a16);
                flatBufferBuilder.b(36, a17);
                flatBufferBuilder.b(37, a18);
                flatBufferBuilder.b(38, a19);
                flatBufferBuilder.a(39, this.f9172Q, 0);
                flatBufferBuilder.b(40, a20);
                flatBufferBuilder.a(41, this.f9174S, 0);
                flatBufferBuilder.b(42, a21);
                flatBufferBuilder.b(43, a22);
                flatBufferBuilder.a(44, this.f9177V, 0);
                flatBufferBuilder.b(45, a23);
                flatBufferBuilder.b(46, a24);
                flatBufferBuilder.b(47, a25);
                flatBufferBuilder.b(48, a26);
                flatBufferBuilder.b(49, a27);
                flatBufferBuilder.b(50, a28);
                flatBufferBuilder.b(51, a29);
                flatBufferBuilder.b(52, a30);
                flatBufferBuilder.a(53, this.ae);
                flatBufferBuilder.b(54, b11);
                flatBufferBuilder.b(55, a31);
                flatBufferBuilder.b(56, b12);
                flatBufferBuilder.b(57, a32);
                flatBufferBuilder.a(58, this.aj);
                flatBufferBuilder.a(59, this.ak);
                flatBufferBuilder.a(60, this.al);
                flatBufferBuilder.a(61, this.am);
                flatBufferBuilder.a(62, this.an);
                flatBufferBuilder.a(63, this.ao);
                flatBufferBuilder.b(64, a33);
                flatBufferBuilder.b(65, a34);
                flatBufferBuilder.b(66, a35);
                flatBufferBuilder.b(67, a36);
                flatBufferBuilder.b(68, a37);
                flatBufferBuilder.b(69, a38);
                flatBufferBuilder.b(70, a39);
                flatBufferBuilder.b(71, a40);
                flatBufferBuilder.b(72, a41);
                flatBufferBuilder.b(73, b13);
                flatBufferBuilder.b(74, a42);
                flatBufferBuilder.b(75, a43);
                flatBufferBuilder.b(76, a44);
                flatBufferBuilder.b(77, b14);
                flatBufferBuilder.b(78, a45);
                flatBufferBuilder.b(79, a46);
                flatBufferBuilder.b(80, b15);
                flatBufferBuilder.b(81, a47);
                flatBufferBuilder.b(82, a48);
                flatBufferBuilder.b(83, a49);
                flatBufferBuilder.b(84, a50);
                flatBufferBuilder.b(85, a51);
                flatBufferBuilder.b(86, a52);
                flatBufferBuilder.b(87, a53);
                flatBufferBuilder.b(88, a54);
                flatBufferBuilder.a(89, this.aO, 0.0d);
                flatBufferBuilder.b(90, a55);
                flatBufferBuilder.b(91, a56);
                flatBufferBuilder.b(92, b16);
                flatBufferBuilder.b(93, a57);
                flatBufferBuilder.b(94, a58);
                flatBufferBuilder.b(95, a59);
                flatBufferBuilder.b(96, a60);
                flatBufferBuilder.b(97, a61);
                flatBufferBuilder.b(98, a62);
                flatBufferBuilder.a(99, this.aY);
                flatBufferBuilder.b(100, a63);
                flatBufferBuilder.b(101, a64);
                flatBufferBuilder.b(102, a65);
                flatBufferBuilder.b(103, a66);
                flatBufferBuilder.b(104, a67);
                flatBufferBuilder.b(105, a68);
                flatBufferBuilder.b(106, a69);
                flatBufferBuilder.b(107, a70);
                flatBufferBuilder.a(108, this.bh);
                flatBufferBuilder.a(109, this.bi);
                flatBufferBuilder.a(110, this.bj);
                flatBufferBuilder.b(111, a71);
                flatBufferBuilder.b(112, a72);
                flatBufferBuilder.b(113, b17);
                flatBufferBuilder.b(114, a73);
                flatBufferBuilder.b(115, a74);
                flatBufferBuilder.b(116, a75);
                flatBufferBuilder.b(117, a76);
                flatBufferBuilder.a(118, this.br, 0);
                flatBufferBuilder.b(119, b18);
                flatBufferBuilder.b(120, a77);
                flatBufferBuilder.b(121, b19);
                flatBufferBuilder.b(122, b20);
                flatBufferBuilder.b(123, a78);
                flatBufferBuilder.b(124, a79);
                flatBufferBuilder.b(125, b21);
                flatBufferBuilder.b(126, a80);
                flatBufferBuilder.b(127, b22);
                flatBufferBuilder.b(128, a81);
                flatBufferBuilder.a(129, this.bC);
                flatBufferBuilder.a(130, this.bD);
                flatBufferBuilder.b(131, a82);
                flatBufferBuilder.b(132, a83);
                flatBufferBuilder.b(133, a84);
                flatBufferBuilder.b(134, a85);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15596a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9187i = mutableFlatBuffer.a(i, 5, 0);
                this.f9198t = mutableFlatBuffer.a(i, 16, 0.0d);
                this.f9203y = mutableFlatBuffer.a(i, 21);
                this.f9204z = mutableFlatBuffer.a(i, 22);
                this.f9156A = mutableFlatBuffer.a(i, 23);
                this.f9157B = mutableFlatBuffer.a(i, 24);
                this.f9172Q = mutableFlatBuffer.a(i, 39, 0);
                this.f9174S = mutableFlatBuffer.a(i, 41, 0);
                this.f9177V = mutableFlatBuffer.a(i, 44, 0);
                this.ae = mutableFlatBuffer.a(i, 53);
                this.aj = mutableFlatBuffer.a(i, 58);
                this.ak = mutableFlatBuffer.a(i, 59);
                this.al = mutableFlatBuffer.a(i, 60);
                this.am = mutableFlatBuffer.a(i, 61);
                this.an = mutableFlatBuffer.a(i, 62);
                this.ao = mutableFlatBuffer.a(i, 63);
                this.aO = mutableFlatBuffer.a(i, 89, 0.0d);
                this.aY = mutableFlatBuffer.a(i, 99);
                this.bh = mutableFlatBuffer.a(i, 108);
                this.bi = mutableFlatBuffer.a(i, 109);
                this.bj = mutableFlatBuffer.a(i, 110);
                this.br = mutableFlatBuffer.a(i, 118, 0);
                this.bC = mutableFlatBuffer.a(i, 129);
                this.bD = mutableFlatBuffer.a(i, 130);
            }
        }

        public StoryAttachmentFieldsWithoutMediaModel() {
            super(14);
        }

        @Nonnull
        private ImmutableList<NewsFeedDefaultsStoryActionLinkFieldsModel> m15610a() {
            this.f9205d = super.a(this.f9205d, 0, NewsFeedDefaultsStoryActionLinkFieldsModel.class);
            return (ImmutableList) this.f9205d;
        }

        @Nullable
        private AppStoreApplicationFragmentModel m15611j() {
            this.f9206e = (AppStoreApplicationFragmentModel) super.a(this.f9206e, 1, AppStoreApplicationFragmentModel.class);
            return this.f9206e;
        }

        @Nonnull
        private ImmutableList<AttachmentPropertiesModel> m15612k() {
            this.f9207f = super.a(this.f9207f, 2, AttachmentPropertiesModel.class);
            return (ImmutableList) this.f9207f;
        }

        @Nullable
        private String m15613l() {
            this.f9208g = super.a(this.f9208g, 3);
            return this.f9208g;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m15614m() {
            this.f9209h = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9209h, 4, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f9209h;
        }

        @Nullable
        private String m15615n() {
            this.f9210i = super.a(this.f9210i, 5);
            return this.f9210i;
        }

        @Nullable
        private SourceModel m15616o() {
            this.f9211j = (SourceModel) super.a(this.f9211j, 6, SourceModel.class);
            return this.f9211j;
        }

        @Nonnull
        private ImmutableList<StyleInfosModel> m15617p() {
            this.f9212k = super.a(this.f9212k, 7, StyleInfosModel.class);
            return (ImmutableList) this.f9212k;
        }

        @Nonnull
        private ImmutableList<GraphQLStoryAttachmentStyle> m15618q() {
            this.f9213l = super.c(this.f9213l, 8, GraphQLStoryAttachmentStyle.class);
            return (ImmutableList) this.f9213l;
        }

        @Nullable
        private String m15619r() {
            this.f9214m = super.a(this.f9214m, 9);
            return this.f9214m;
        }

        @Nullable
        private TargetModel m15620s() {
            this.f9215n = (TargetModel) super.a(this.f9215n, 10, TargetModel.class);
            return this.f9215n;
        }

        @Nullable
        private String m15621t() {
            this.f9216o = super.a(this.f9216o, 11);
            return this.f9216o;
        }

        @Nullable
        private String m15622u() {
            this.f9217p = super.a(this.f9217p, 12);
            return this.f9217p;
        }

        @Nullable
        private String m15623v() {
            this.f9218q = super.a(this.f9218q, 13);
            return this.f9218q;
        }

        public final int jK_() {
            return -1267730472;
        }

        public final GraphQLVisitableModel m15625a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            StoryAttachmentFieldsWithoutMediaModel storyAttachmentFieldsWithoutMediaModel;
            GraphQLVisitableModel graphQLVisitableModel;
            AppStoreApplicationFragmentModel appStoreApplicationFragmentModel;
            Builder a;
            DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
            SourceModel sourceModel;
            TargetModel targetModel;
            h();
            if (m15610a() != null) {
                Builder a2 = ModelHelper.a(m15610a(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    storyAttachmentFieldsWithoutMediaModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(null, this);
                    storyAttachmentFieldsWithoutMediaModel.f9205d = a2.b();
                    graphQLVisitableModel = storyAttachmentFieldsWithoutMediaModel;
                    if (m15611j() != null) {
                        appStoreApplicationFragmentModel = (AppStoreApplicationFragmentModel) graphQLModelMutatingVisitor.b(m15611j());
                        if (m15611j() != appStoreApplicationFragmentModel) {
                            graphQLVisitableModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9206e = appStoreApplicationFragmentModel;
                        }
                    }
                    if (m15612k() != null) {
                        a = ModelHelper.a(m15612k(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            storyAttachmentFieldsWithoutMediaModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                            storyAttachmentFieldsWithoutMediaModel.f9207f = a.b();
                            graphQLVisitableModel = storyAttachmentFieldsWithoutMediaModel;
                        }
                    }
                    if (m15614m() != null) {
                        defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15614m());
                        if (m15614m() != defaultTextWithEntitiesLongFieldsModel) {
                            graphQLVisitableModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9209h = defaultTextWithEntitiesLongFieldsModel;
                        }
                    }
                    if (m15616o() != null) {
                        sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m15616o());
                        if (m15616o() != sourceModel) {
                            graphQLVisitableModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9211j = sourceModel;
                        }
                    }
                    if (m15617p() != null) {
                        a = ModelHelper.a(m15617p(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            storyAttachmentFieldsWithoutMediaModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                            storyAttachmentFieldsWithoutMediaModel.f9212k = a.b();
                            graphQLVisitableModel = storyAttachmentFieldsWithoutMediaModel;
                        }
                    }
                    if (m15620s() != null) {
                        targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m15620s());
                        if (m15620s() != targetModel) {
                            graphQLVisitableModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9215n = targetModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m15611j() != null) {
                appStoreApplicationFragmentModel = (AppStoreApplicationFragmentModel) graphQLModelMutatingVisitor.b(m15611j());
                if (m15611j() != appStoreApplicationFragmentModel) {
                    graphQLVisitableModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9206e = appStoreApplicationFragmentModel;
                }
            }
            if (m15612k() != null) {
                a = ModelHelper.a(m15612k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    storyAttachmentFieldsWithoutMediaModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentFieldsWithoutMediaModel.f9207f = a.b();
                    graphQLVisitableModel = storyAttachmentFieldsWithoutMediaModel;
                }
            }
            if (m15614m() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15614m());
                if (m15614m() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9209h = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m15616o() != null) {
                sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m15616o());
                if (m15616o() != sourceModel) {
                    graphQLVisitableModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9211j = sourceModel;
                }
            }
            if (m15617p() != null) {
                a = ModelHelper.a(m15617p(), graphQLModelMutatingVisitor);
                if (a != null) {
                    storyAttachmentFieldsWithoutMediaModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentFieldsWithoutMediaModel.f9212k = a.b();
                    graphQLVisitableModel = storyAttachmentFieldsWithoutMediaModel;
                }
            }
            if (m15620s() != null) {
                targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m15620s());
                if (m15620s() != targetModel) {
                    graphQLVisitableModel = (StoryAttachmentFieldsWithoutMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9215n = targetModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m15624a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15610a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15611j());
            int a3 = ModelHelper.a(flatBufferBuilder, m15612k());
            int b = flatBufferBuilder.b(m15613l());
            int a4 = ModelHelper.a(flatBufferBuilder, m15614m());
            int b2 = flatBufferBuilder.b(m15615n());
            int a5 = ModelHelper.a(flatBufferBuilder, m15616o());
            int a6 = ModelHelper.a(flatBufferBuilder, m15617p());
            int d = flatBufferBuilder.d(m15618q());
            int b3 = flatBufferBuilder.b(m15619r());
            int a7 = ModelHelper.a(flatBufferBuilder, m15620s());
            int b4 = flatBufferBuilder.b(m15621t());
            int b5 = flatBufferBuilder.b(m15622u());
            int b6 = flatBufferBuilder.b(m15623v());
            flatBufferBuilder.c(14);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.b(8, d);
            flatBufferBuilder.b(9, b3);
            flatBufferBuilder.b(10, a7);
            flatBufferBuilder.b(11, b4);
            flatBufferBuilder.b(12, b5);
            flatBufferBuilder.b(13, b6);
            i();
            return flatBufferBuilder.d();
        }
    }
}
