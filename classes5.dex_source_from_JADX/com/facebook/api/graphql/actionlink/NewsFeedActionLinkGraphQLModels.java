package com.facebook.api.graphql.actionlink;

import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.EditReviewActionLinkFieldsParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.EditReviewActionLinkFieldsParser.ReviewParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.EditReviewActionLinkFieldsParser.ReviewParser.RepresentedProfileParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.EventCreateActionLinkFieldsParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.EventCreateActionLinkFieldsParser.TemporalEventInfoParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.EventCreateActionLinkFieldsParser.TemporalEventInfoParser.ThemeParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.EventCreateActionLinkFieldsParser.TemporalEventInfoParser.ThemeParser.HiResThemeImageParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.EventCreateActionLinkFieldsParser.TemporalEventInfoParser.ThemeParser.LowResThemeImageParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.EventCreateActionLinkFieldsParser.TemporalEventInfoParser.ThemeParser.MedResThemeImageParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.GroupToggleCommentingActionLinkFieldsParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.GroupToggleCommentingActionLinkFieldsParser.FeedbackParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenActionLinkFieldsFragParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenActionLinkFieldsFragParser.ErrorCodesParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenActionLinkFieldsFragParser.LeadGenDataParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenActionLinkFieldsFragParser.LeadGenDataParser.PagesParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenActionLinkFieldsFragParser.LeadGenDataParser.PagesParser.PrivacyDataParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenActionLinkFieldsFragParser.LeadGenUserStatusParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenActionLinkFieldsFragParser.PageParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenActionLinkFieldsFragParser.PageParser.CoverPhotoParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenActionLinkFieldsFragParser.PageParser.CoverPhotoParser.PhotoParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenContextPageFieldsParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenContextPageFieldsParser.ContextCardPhotoParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenContextPageFieldsParser.ContextImageParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenDeepLinkUserStatusFieldsParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenDefaultInfoFieldsParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenLegalContentFieldsParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenLegalContentFieldsParser.CheckboxesParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenLegalContentFieldsParser.CheckboxesParser.CheckboxBodyParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenLegalContentFieldsParser.DisclaimerBodyParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenLegalContentFieldsParser.DisclaimerBodyParser.RangesParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenLegalContentFieldsParser.DisclaimerBodyParser.RangesParser.EntityParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LinkTargetStoreDataFragParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser.DescriptionParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser.EventParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser.PageParser.PageLikersParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser.ParentStoryParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser.PrivacyScopeParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser.ProfileParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser.ProfileParser.ProfilePictureParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser.TaggedAndMentionedUsersParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser.TaggedAndMentionedUsersParser.NodesParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser.TopicParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.OverlayActionLinkFieldsParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.OverlayActionLinkFieldsParser.InfoParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.OverlayActionLinkFieldsParser.InfoParser.CreationSuggestionParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.OverlayActionLinkFieldsParser.InfoParser.CreationSuggestionParser.SuggestedMembersParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.PageOutcomeButtonActionLinkFieldsParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.PageOutcomeButtonActionLinkFieldsParser.PageOutcomeButtonParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.PageOutcomeButtonActionLinkFieldsParser.PageOutcomeButtonParser.ButtonIconImageParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.PageOutcomeButtonActionLinkFieldsParser.PageOutcomeButtonParser.ButtonIconImageParser.IconImageParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.PlaceListConvertActionLinkFieldsParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.PlaceListConvertActionLinkFieldsParser.StoryParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.ReadInstantArticleActionLinkFieldsParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.ReadInstantArticleActionLinkFieldsParser.FeaturedInstantArticleElementParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.ReadInstantArticleActionLinkFieldsParser.InstantArticleParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.VideoAnnotationFieldsParser;
import com.facebook.api.graphql.privacyoptions.NewsFeedPrivacyOptionsGraphQLModels.PrivacyOptionsFieldsModel;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.DefaultSavableObjectExtraFieldsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLInterfaces.EventAttachment;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.EventAttachmentModel.EventCoverPhotoModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.NewsFeedDefaultsEventPlaceFieldsModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultIconFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntityRangesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntityRangesFieldsModel.RangesModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces$ReviewBasicFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewBasicFieldsModel.ValueModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.SelectedPrivacyOptionFieldsModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.UserReviewsParser;
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

/* compiled from: app_store_application */
public class NewsFeedActionLinkGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 584007459)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: app_store_application */
    public final class EditReviewActionLinkFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ReviewModel f8846d;

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EditReviewActionLinkFieldsModel.class, new Deserializer());
            }

            public Object m14753a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EditReviewActionLinkFieldsParser.m15294a(jsonParser);
                Object editReviewActionLinkFieldsModel = new EditReviewActionLinkFieldsModel();
                ((BaseModel) editReviewActionLinkFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (editReviewActionLinkFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) editReviewActionLinkFieldsModel).a();
                }
                return editReviewActionLinkFieldsModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -325527811)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: app_store_application */
        public final class ReviewModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, ReviewFragmentsInterfaces$ReviewBasicFields {
            @Nullable
            private String f8841d;
            private int f8842e;
            @Nullable
            private SelectedPrivacyOptionFieldsModel f8843f;
            @Nullable
            private RepresentedProfileModel f8844g;
            @Nullable
            private ValueModel f8845h;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReviewModel.class, new Deserializer());
                }

                public Object m14754a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReviewParser.m15293a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reviewModel = new ReviewModel();
                    ((BaseModel) reviewModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reviewModel instanceof Postprocessable) {
                        return ((Postprocessable) reviewModel).a();
                    }
                    return reviewModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1255661007)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_store_application */
            public final class RepresentedProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f8838d;
                @Nullable
                private String f8839e;
                @Nullable
                private String f8840f;

                /* compiled from: app_store_application */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RepresentedProfileModel.class, new Deserializer());
                    }

                    public Object m14755a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RepresentedProfileParser.m15291a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object representedProfileModel = new RepresentedProfileModel();
                        ((BaseModel) representedProfileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (representedProfileModel instanceof Postprocessable) {
                            return ((Postprocessable) representedProfileModel).a();
                        }
                        return representedProfileModel;
                    }
                }

                /* compiled from: app_store_application */
                public class Serializer extends JsonSerializer<RepresentedProfileModel> {
                    public final void m14756a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) obj;
                        if (representedProfileModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(representedProfileModel.m14760a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            representedProfileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RepresentedProfileParser.m15292a(representedProfileModel.w_(), representedProfileModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(RepresentedProfileModel.class, new Serializer());
                    }
                }

                public RepresentedProfileModel() {
                    super(3);
                }

                public final void m14763a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m14764a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m14757j() {
                    if (this.b != null && this.f8838d == null) {
                        this.f8838d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f8838d;
                }

                @Nullable
                private String m14758k() {
                    this.f8839e = super.a(this.f8839e, 1);
                    return this.f8839e;
                }

                @Nullable
                private String m14759l() {
                    this.f8840f = super.a(this.f8840f, 2);
                    return this.f8840f;
                }

                @Nullable
                public final String m14762a() {
                    return m14758k();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m14761a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14760a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14757j());
                    int b = flatBufferBuilder.b(m14758k());
                    int b2 = flatBufferBuilder.b(m14759l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<ReviewModel> {
                public final void m14765a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReviewModel reviewModel = (ReviewModel) obj;
                    if (reviewModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reviewModel.m14770a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserReviewsParser.a(reviewModel.w_(), reviewModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReviewModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ SelectedPrivacyOptionFieldsModel mo1095c() {
                return m14767k();
            }

            @Nullable
            public final /* synthetic */ ValueModel mo1096d() {
                return m14769m();
            }

            public ReviewModel() {
                super(5);
            }

            @Nullable
            private String m14766j() {
                this.f8841d = super.a(this.f8841d, 0);
                return this.f8841d;
            }

            public final int mo1094b() {
                a(0, 1);
                return this.f8842e;
            }

            @Nullable
            private SelectedPrivacyOptionFieldsModel m14767k() {
                this.f8843f = (SelectedPrivacyOptionFieldsModel) super.a(this.f8843f, 2, SelectedPrivacyOptionFieldsModel.class);
                return this.f8843f;
            }

            @Nullable
            private RepresentedProfileModel m14768l() {
                this.f8844g = (RepresentedProfileModel) super.a(this.f8844g, 3, RepresentedProfileModel.class);
                return this.f8844g;
            }

            @Nullable
            private ValueModel m14769m() {
                this.f8845h = (ValueModel) super.a(this.f8845h, 4, ValueModel.class);
                return this.f8845h;
            }

            @Nullable
            public final String m14772a() {
                return m14766j();
            }

            public final int jK_() {
                return -131209055;
            }

            public final GraphQLVisitableModel m14771a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14767k() != null) {
                    SelectedPrivacyOptionFieldsModel selectedPrivacyOptionFieldsModel = (SelectedPrivacyOptionFieldsModel) graphQLModelMutatingVisitor.b(m14767k());
                    if (m14767k() != selectedPrivacyOptionFieldsModel) {
                        graphQLVisitableModel = (ReviewModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8843f = selectedPrivacyOptionFieldsModel;
                    }
                }
                if (m14768l() != null) {
                    RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) graphQLModelMutatingVisitor.b(m14768l());
                    if (m14768l() != representedProfileModel) {
                        graphQLVisitableModel = (ReviewModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8844g = representedProfileModel;
                    }
                }
                if (m14769m() != null) {
                    ValueModel valueModel = (ValueModel) graphQLModelMutatingVisitor.b(m14769m());
                    if (m14769m() != valueModel) {
                        graphQLVisitableModel = (ReviewModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8845h = valueModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14770a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14766j());
                int a = ModelHelper.a(flatBufferBuilder, m14767k());
                int a2 = ModelHelper.a(flatBufferBuilder, m14768l());
                int a3 = ModelHelper.a(flatBufferBuilder, m14769m());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f8842e, 0);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14773a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8842e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<EditReviewActionLinkFieldsModel> {
            public final void m14777a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EditReviewActionLinkFieldsModel editReviewActionLinkFieldsModel = (EditReviewActionLinkFieldsModel) obj;
                if (editReviewActionLinkFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(editReviewActionLinkFieldsModel.m14779a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    editReviewActionLinkFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = editReviewActionLinkFieldsModel.w_();
                int u_ = editReviewActionLinkFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("review");
                    UserReviewsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EditReviewActionLinkFieldsModel.class, new Serializer());
            }
        }

        public EditReviewActionLinkFieldsModel() {
            super(1);
        }

        @Nullable
        private ReviewModel m14778a() {
            this.f8846d = (ReviewModel) super.a(this.f8846d, 0, ReviewModel.class);
            return this.f8846d;
        }

        public final int jK_() {
            return -1160597742;
        }

        public final GraphQLVisitableModel m14780a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14778a() != null) {
                ReviewModel reviewModel = (ReviewModel) graphQLModelMutatingVisitor.b(m14778a());
                if (m14778a() != reviewModel) {
                    graphQLVisitableModel = (EditReviewActionLinkFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8846d = reviewModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14779a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14778a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 389503921)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class EventCreateActionLinkFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private TemporalEventInfoModel f8857d;

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventCreateActionLinkFieldsModel.class, new Deserializer());
            }

            public Object m14781a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventCreateActionLinkFieldsParser.m15305a(jsonParser);
                Object eventCreateActionLinkFieldsModel = new EventCreateActionLinkFieldsModel();
                ((BaseModel) eventCreateActionLinkFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventCreateActionLinkFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) eventCreateActionLinkFieldsModel).a();
                }
                return eventCreateActionLinkFieldsModel;
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<EventCreateActionLinkFieldsModel> {
            public final void m14782a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventCreateActionLinkFieldsModel eventCreateActionLinkFieldsModel = (EventCreateActionLinkFieldsModel) obj;
                if (eventCreateActionLinkFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventCreateActionLinkFieldsModel.m14815a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventCreateActionLinkFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventCreateActionLinkFieldsModel.w_();
                int u_ = eventCreateActionLinkFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("temporal_event_info");
                    TemporalEventInfoParser.m15304a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventCreateActionLinkFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -835680819)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class TemporalEventInfoModel extends BaseModel implements GraphQLVisitableModel {
            private long f8854d;
            @Nullable
            private ThemeModel f8855e;
            @Nullable
            private String f8856f;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TemporalEventInfoModel.class, new Deserializer());
                }

                public Object m14783a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TemporalEventInfoParser.m15303a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object temporalEventInfoModel = new TemporalEventInfoModel();
                    ((BaseModel) temporalEventInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (temporalEventInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) temporalEventInfoModel).a();
                    }
                    return temporalEventInfoModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<TemporalEventInfoModel> {
                public final void m14784a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TemporalEventInfoModel temporalEventInfoModel = (TemporalEventInfoModel) obj;
                    if (temporalEventInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(temporalEventInfoModel.m14811a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        temporalEventInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TemporalEventInfoParser.m15304a(temporalEventInfoModel.w_(), temporalEventInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TemporalEventInfoModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -705372518)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_store_application */
            public final class ThemeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private HiResThemeImageModel f8850d;
                @Nullable
                private String f8851e;
                @Nullable
                private LowResThemeImageModel f8852f;
                @Nullable
                private MedResThemeImageModel f8853g;

                /* compiled from: app_store_application */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ThemeModel.class, new Deserializer());
                    }

                    public Object m14785a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ThemeParser.m15301a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object themeModel = new ThemeModel();
                        ((BaseModel) themeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (themeModel instanceof Postprocessable) {
                            return ((Postprocessable) themeModel).a();
                        }
                        return themeModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: app_store_application */
                public final class HiResThemeImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f8847d;

                    /* compiled from: app_store_application */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(HiResThemeImageModel.class, new Deserializer());
                        }

                        public Object m14786a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(HiResThemeImageParser.m15295a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object hiResThemeImageModel = new HiResThemeImageModel();
                            ((BaseModel) hiResThemeImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (hiResThemeImageModel instanceof Postprocessable) {
                                return ((Postprocessable) hiResThemeImageModel).a();
                            }
                            return hiResThemeImageModel;
                        }
                    }

                    /* compiled from: app_store_application */
                    public class Serializer extends JsonSerializer<HiResThemeImageModel> {
                        public final void m14787a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            HiResThemeImageModel hiResThemeImageModel = (HiResThemeImageModel) obj;
                            if (hiResThemeImageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(hiResThemeImageModel.m14789a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                hiResThemeImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            HiResThemeImageParser.m15296a(hiResThemeImageModel.w_(), hiResThemeImageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(HiResThemeImageModel.class, new Serializer());
                        }
                    }

                    public HiResThemeImageModel() {
                        super(1);
                    }

                    @Nullable
                    private String m14788a() {
                        this.f8847d = super.a(this.f8847d, 0);
                        return this.f8847d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m14790a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m14789a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m14788a());
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
                /* compiled from: app_store_application */
                public final class LowResThemeImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f8848d;

                    /* compiled from: app_store_application */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(LowResThemeImageModel.class, new Deserializer());
                        }

                        public Object m14791a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(LowResThemeImageParser.m15297a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object lowResThemeImageModel = new LowResThemeImageModel();
                            ((BaseModel) lowResThemeImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (lowResThemeImageModel instanceof Postprocessable) {
                                return ((Postprocessable) lowResThemeImageModel).a();
                            }
                            return lowResThemeImageModel;
                        }
                    }

                    /* compiled from: app_store_application */
                    public class Serializer extends JsonSerializer<LowResThemeImageModel> {
                        public final void m14792a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            LowResThemeImageModel lowResThemeImageModel = (LowResThemeImageModel) obj;
                            if (lowResThemeImageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(lowResThemeImageModel.m14794a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                lowResThemeImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            LowResThemeImageParser.m15298a(lowResThemeImageModel.w_(), lowResThemeImageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(LowResThemeImageModel.class, new Serializer());
                        }
                    }

                    public LowResThemeImageModel() {
                        super(1);
                    }

                    @Nullable
                    private String m14793a() {
                        this.f8848d = super.a(this.f8848d, 0);
                        return this.f8848d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m14795a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m14794a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m14793a());
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
                /* compiled from: app_store_application */
                public final class MedResThemeImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f8849d;

                    /* compiled from: app_store_application */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(MedResThemeImageModel.class, new Deserializer());
                        }

                        public Object m14796a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(MedResThemeImageParser.m15299a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object medResThemeImageModel = new MedResThemeImageModel();
                            ((BaseModel) medResThemeImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (medResThemeImageModel instanceof Postprocessable) {
                                return ((Postprocessable) medResThemeImageModel).a();
                            }
                            return medResThemeImageModel;
                        }
                    }

                    /* compiled from: app_store_application */
                    public class Serializer extends JsonSerializer<MedResThemeImageModel> {
                        public final void m14797a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            MedResThemeImageModel medResThemeImageModel = (MedResThemeImageModel) obj;
                            if (medResThemeImageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(medResThemeImageModel.m14799a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                medResThemeImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MedResThemeImageParser.m15300a(medResThemeImageModel.w_(), medResThemeImageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(MedResThemeImageModel.class, new Serializer());
                        }
                    }

                    public MedResThemeImageModel() {
                        super(1);
                    }

                    @Nullable
                    private String m14798a() {
                        this.f8849d = super.a(this.f8849d, 0);
                        return this.f8849d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m14800a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m14799a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m14798a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: app_store_application */
                public class Serializer extends JsonSerializer<ThemeModel> {
                    public final void m14801a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ThemeModel themeModel = (ThemeModel) obj;
                        if (themeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(themeModel.m14806a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            themeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ThemeParser.m15302a(themeModel.w_(), themeModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ThemeModel.class, new Serializer());
                    }
                }

                public ThemeModel() {
                    super(4);
                }

                @Nullable
                private HiResThemeImageModel m14802j() {
                    this.f8850d = (HiResThemeImageModel) super.a(this.f8850d, 0, HiResThemeImageModel.class);
                    return this.f8850d;
                }

                @Nullable
                private String m14803k() {
                    this.f8851e = super.a(this.f8851e, 1);
                    return this.f8851e;
                }

                @Nullable
                private LowResThemeImageModel m14804l() {
                    this.f8852f = (LowResThemeImageModel) super.a(this.f8852f, 2, LowResThemeImageModel.class);
                    return this.f8852f;
                }

                @Nullable
                private MedResThemeImageModel m14805m() {
                    this.f8853g = (MedResThemeImageModel) super.a(this.f8853g, 3, MedResThemeImageModel.class);
                    return this.f8853g;
                }

                @Nullable
                public final String m14808a() {
                    return m14803k();
                }

                public final int jK_() {
                    return -893641725;
                }

                public final GraphQLVisitableModel m14807a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m14802j() != null) {
                        HiResThemeImageModel hiResThemeImageModel = (HiResThemeImageModel) graphQLModelMutatingVisitor.b(m14802j());
                        if (m14802j() != hiResThemeImageModel) {
                            graphQLVisitableModel = (ThemeModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8850d = hiResThemeImageModel;
                        }
                    }
                    if (m14804l() != null) {
                        LowResThemeImageModel lowResThemeImageModel = (LowResThemeImageModel) graphQLModelMutatingVisitor.b(m14804l());
                        if (m14804l() != lowResThemeImageModel) {
                            graphQLVisitableModel = (ThemeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8852f = lowResThemeImageModel;
                        }
                    }
                    if (m14805m() != null) {
                        MedResThemeImageModel medResThemeImageModel = (MedResThemeImageModel) graphQLModelMutatingVisitor.b(m14805m());
                        if (m14805m() != medResThemeImageModel) {
                            graphQLVisitableModel = (ThemeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8853g = medResThemeImageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m14806a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14802j());
                    int b = flatBufferBuilder.b(m14803k());
                    int a2 = ModelHelper.a(flatBufferBuilder, m14804l());
                    int a3 = ModelHelper.a(flatBufferBuilder, m14805m());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, a3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public TemporalEventInfoModel() {
                super(3);
            }

            @Nullable
            private ThemeModel m14809a() {
                this.f8855e = (ThemeModel) super.a(this.f8855e, 1, ThemeModel.class);
                return this.f8855e;
            }

            @Nullable
            private String m14810j() {
                this.f8856f = super.a(this.f8856f, 2);
                return this.f8856f;
            }

            public final int jK_() {
                return 1419332934;
            }

            public final GraphQLVisitableModel m14812a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14809a() != null) {
                    ThemeModel themeModel = (ThemeModel) graphQLModelMutatingVisitor.b(m14809a());
                    if (m14809a() != themeModel) {
                        graphQLVisitableModel = (TemporalEventInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8855e = themeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14811a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14809a());
                int b = flatBufferBuilder.b(m14810j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f8854d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14813a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8854d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public EventCreateActionLinkFieldsModel() {
            super(1);
        }

        @Nullable
        private TemporalEventInfoModel m14814a() {
            this.f8857d = (TemporalEventInfoModel) super.a(this.f8857d, 0, TemporalEventInfoModel.class);
            return this.f8857d;
        }

        public final int jK_() {
            return -89875450;
        }

        public final GraphQLVisitableModel m14816a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14814a() != null) {
                TemporalEventInfoModel temporalEventInfoModel = (TemporalEventInfoModel) graphQLModelMutatingVisitor.b(m14814a());
                if (m14814a() != temporalEventInfoModel) {
                    graphQLVisitableModel = (EventCreateActionLinkFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8857d = temporalEventInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14815a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14814a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -129857762)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class GroupToggleCommentingActionLinkFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeedbackModel f8862d;

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupToggleCommentingActionLinkFieldsModel.class, new Deserializer());
            }

            public Object m14817a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupToggleCommentingActionLinkFieldsParser.m15308a(jsonParser);
                Object groupToggleCommentingActionLinkFieldsModel = new GroupToggleCommentingActionLinkFieldsModel();
                ((BaseModel) groupToggleCommentingActionLinkFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupToggleCommentingActionLinkFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) groupToggleCommentingActionLinkFieldsModel).a();
                }
                return groupToggleCommentingActionLinkFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1250972643)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class FeedbackModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            private boolean f8858d;
            private boolean f8859e;
            @Nullable
            private String f8860f;
            @Nullable
            private String f8861g;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m14818a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackParser.m15306a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object feedbackModel = new FeedbackModel();
                    ((BaseModel) feedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (feedbackModel instanceof Postprocessable) {
                        return ((Postprocessable) feedbackModel).a();
                    }
                    return feedbackModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m14819a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m14826a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackParser.m15307a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(4);
            }

            public final void m14830a(String str, ConsistencyTuple consistencyTuple) {
                if ("can_viewer_comment".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m14822j());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 0;
                } else if ("have_comments_been_disabled".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m14823k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m14831a(String str, Object obj, boolean z) {
                if ("can_viewer_comment".equals(str)) {
                    m14820a(((Boolean) obj).booleanValue());
                } else if ("have_comments_been_disabled".equals(str)) {
                    m14821b(((Boolean) obj).booleanValue());
                }
            }

            private boolean m14822j() {
                a(0, 0);
                return this.f8858d;
            }

            private void m14820a(boolean z) {
                this.f8858d = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 0, z);
                }
            }

            private boolean m14823k() {
                a(0, 1);
                return this.f8859e;
            }

            private void m14821b(boolean z) {
                this.f8859e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            @Nullable
            private String m14824l() {
                this.f8860f = super.a(this.f8860f, 2);
                return this.f8860f;
            }

            @Nullable
            private String m14825m() {
                this.f8861g = super.a(this.f8861g, 3);
                return this.f8861g;
            }

            @Nullable
            public final String m14828a() {
                return m14825m();
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m14827a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14826a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14824l());
                int b2 = flatBufferBuilder.b(m14825m());
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f8858d);
                flatBufferBuilder.a(1, this.f8859e);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14829a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8858d = mutableFlatBuffer.a(i, 0);
                this.f8859e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<GroupToggleCommentingActionLinkFieldsModel> {
            public final void m14832a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupToggleCommentingActionLinkFieldsModel groupToggleCommentingActionLinkFieldsModel = (GroupToggleCommentingActionLinkFieldsModel) obj;
                if (groupToggleCommentingActionLinkFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupToggleCommentingActionLinkFieldsModel.m14834a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupToggleCommentingActionLinkFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupToggleCommentingActionLinkFieldsModel.w_();
                int u_ = groupToggleCommentingActionLinkFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackParser.m15307a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupToggleCommentingActionLinkFieldsModel.class, new Serializer());
            }
        }

        public GroupToggleCommentingActionLinkFieldsModel() {
            super(1);
        }

        @Nullable
        private FeedbackModel m14833a() {
            this.f8862d = (FeedbackModel) super.a(this.f8862d, 0, FeedbackModel.class);
            return this.f8862d;
        }

        public final int jK_() {
            return -1103690310;
        }

        public final GraphQLVisitableModel m14835a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14833a() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m14833a());
                if (m14833a() != feedbackModel) {
                    graphQLVisitableModel = (GroupToggleCommentingActionLinkFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8862d = feedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14834a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14833a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -694563353)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class LeadGenActionLinkFieldsFragModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8885A;
        @Nullable
        private String f8886B;
        @Nullable
        private String f8887C;
        @Nullable
        private String f8888D;
        @Nullable
        private String f8889E;
        @Nullable
        private String f8890F;
        @Nullable
        private String f8891G;
        @Nullable
        private String f8892H;
        @Nullable
        private String f8893I;
        private boolean f8894J;
        @Nullable
        private String f8895K;
        @Nullable
        private String f8896L;
        @Nullable
        private String f8897M;
        @Nullable
        private String f8898N;
        @Nullable
        private String f8899d;
        @Nullable
        private String f8900e;
        private int f8901f;
        private int f8902g;
        @Nullable
        private String f8903h;
        @Nullable
        private String f8904i;
        @Nullable
        private List<ErrorCodesModel> f8905j;
        @Nullable
        private String f8906k;
        @Nullable
        private String f8907l;
        @Nullable
        private String f8908m;
        @Nullable
        private String f8909n;
        @Nullable
        private String f8910o;
        @Nullable
        private String f8911p;
        @Nullable
        private String f8912q;
        @Nullable
        private String f8913r;
        @Nullable
        private LeadGenDataModel f8914s;
        @Nullable
        private String f8915t;
        @Nullable
        private LeadGenDeepLinkUserStatusFieldsModel f8916u;
        @Nullable
        private LeadGenUserStatusModel f8917v;
        @Nullable
        private String f8918w;
        @Nullable
        private String f8919x;
        @Nullable
        private PageModel f8920y;
        @Nullable
        private String f8921z;

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LeadGenActionLinkFieldsFragModel.class, new Deserializer());
            }

            public Object m14836a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LeadGenActionLinkFieldsFragParser.m15327a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object leadGenActionLinkFieldsFragModel = new LeadGenActionLinkFieldsFragModel();
                ((BaseModel) leadGenActionLinkFieldsFragModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (leadGenActionLinkFieldsFragModel instanceof Postprocessable) {
                    return ((Postprocessable) leadGenActionLinkFieldsFragModel).a();
                }
                return leadGenActionLinkFieldsFragModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -449724762)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class ErrorCodesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8863d;
            @Nullable
            private GraphQLLeadGenInfoFieldInputType f8864e;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ErrorCodesModel.class, new Deserializer());
                }

                public Object m14837a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ErrorCodesParser.m15312b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object errorCodesModel = new ErrorCodesModel();
                    ((BaseModel) errorCodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (errorCodesModel instanceof Postprocessable) {
                        return ((Postprocessable) errorCodesModel).a();
                    }
                    return errorCodesModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<ErrorCodesModel> {
                public final void m14838a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ErrorCodesModel errorCodesModel = (ErrorCodesModel) obj;
                    if (errorCodesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(errorCodesModel.m14841a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        errorCodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ErrorCodesParser.m15310a(errorCodesModel.w_(), errorCodesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ErrorCodesModel.class, new Serializer());
                }
            }

            public ErrorCodesModel() {
                super(2);
            }

            @Nullable
            private String m14839a() {
                this.f8863d = super.a(this.f8863d, 0);
                return this.f8863d;
            }

            @Nullable
            private GraphQLLeadGenInfoFieldInputType m14840j() {
                this.f8864e = (GraphQLLeadGenInfoFieldInputType) super.b(this.f8864e, 1, GraphQLLeadGenInfoFieldInputType.class, GraphQLLeadGenInfoFieldInputType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8864e;
            }

            public final int jK_() {
                return -1908897706;
            }

            public final GraphQLVisitableModel m14842a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14841a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14839a());
                int a = flatBufferBuilder.a(m14840j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 745630467)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class LeadGenDataModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private LeadGenContextPageFieldsModel f8869d;
            @Nullable
            private String f8870e;
            @Nullable
            private List<LeadGenDefaultInfoFieldsModel> f8871f;
            @Nullable
            private LeadGenLegalContentFieldsModel f8872g;
            private boolean f8873h;
            @Nullable
            private List<PagesModel> f8874i;
            @Nullable
            private String f8875j;
            @Nullable
            private String f8876k;
            private boolean f8877l;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LeadGenDataModel.class, new Deserializer());
                }

                public Object m14843a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LeadGenDataParser.m15317a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object leadGenDataModel = new LeadGenDataModel();
                    ((BaseModel) leadGenDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (leadGenDataModel instanceof Postprocessable) {
                        return ((Postprocessable) leadGenDataModel).a();
                    }
                    return leadGenDataModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1202903596)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_store_application */
            public final class PagesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<LeadGenDefaultInfoFieldsModel> f8867d;
                @Nullable
                private List<PrivacyDataModel> f8868e;

                /* compiled from: app_store_application */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PagesModel.class, new Deserializer());
                    }

                    public Object m14844a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PagesParser.m15316b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pagesModel = new PagesModel();
                        ((BaseModel) pagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pagesModel instanceof Postprocessable) {
                            return ((Postprocessable) pagesModel).a();
                        }
                        return pagesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 236131661)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: app_store_application */
                public final class PrivacyDataModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f8865d;
                    @Nullable
                    private GraphQLLeadGenPrivacyType f8866e;

                    /* compiled from: app_store_application */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PrivacyDataModel.class, new Deserializer());
                        }

                        public Object m14845a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PrivacyDataParser.m15314b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object privacyDataModel = new PrivacyDataModel();
                            ((BaseModel) privacyDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (privacyDataModel instanceof Postprocessable) {
                                return ((Postprocessable) privacyDataModel).a();
                            }
                            return privacyDataModel;
                        }
                    }

                    /* compiled from: app_store_application */
                    public class Serializer extends JsonSerializer<PrivacyDataModel> {
                        public final void m14846a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PrivacyDataModel privacyDataModel = (PrivacyDataModel) obj;
                            if (privacyDataModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(privacyDataModel.m14849a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                privacyDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PrivacyDataParser.m15313a(privacyDataModel.w_(), privacyDataModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PrivacyDataModel.class, new Serializer());
                        }
                    }

                    public PrivacyDataModel() {
                        super(2);
                    }

                    @Nullable
                    private String m14847a() {
                        this.f8865d = super.a(this.f8865d, 0);
                        return this.f8865d;
                    }

                    @Nullable
                    private GraphQLLeadGenPrivacyType m14848j() {
                        this.f8866e = (GraphQLLeadGenPrivacyType) super.b(this.f8866e, 1, GraphQLLeadGenPrivacyType.class, GraphQLLeadGenPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f8866e;
                    }

                    public final int jK_() {
                        return -1982153002;
                    }

                    public final GraphQLVisitableModel m14850a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m14849a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m14847a());
                        int a = flatBufferBuilder.a(m14848j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: app_store_application */
                public class Serializer extends JsonSerializer<PagesModel> {
                    public final void m14851a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PagesModel pagesModel = (PagesModel) obj;
                        if (pagesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pagesModel.m14854a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        UserReviewsParser.b(pagesModel.w_(), pagesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PagesModel.class, new Serializer());
                    }
                }

                public PagesModel() {
                    super(2);
                }

                @Nonnull
                private ImmutableList<LeadGenDefaultInfoFieldsModel> m14852a() {
                    this.f8867d = super.a(this.f8867d, 0, LeadGenDefaultInfoFieldsModel.class);
                    return (ImmutableList) this.f8867d;
                }

                @Nonnull
                private ImmutableList<PrivacyDataModel> m14853j() {
                    this.f8868e = super.a(this.f8868e, 1, PrivacyDataModel.class);
                    return (ImmutableList) this.f8868e;
                }

                public final int jK_() {
                    return -1255530781;
                }

                public final GraphQLVisitableModel m14855a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    Builder a;
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m14852a() != null) {
                        a = ModelHelper.a(m14852a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (PagesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8867d = a.b();
                        }
                    }
                    if (m14853j() != null) {
                        a = ModelHelper.a(m14853j(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (PagesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8868e = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m14854a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14852a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m14853j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<LeadGenDataModel> {
                public final void m14856a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LeadGenDataModel leadGenDataModel = (LeadGenDataModel) obj;
                    if (leadGenDataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(leadGenDataModel.m14864a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        leadGenDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LeadGenDataParser.m15318a(leadGenDataModel.w_(), leadGenDataModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LeadGenDataModel.class, new Serializer());
                }
            }

            public LeadGenDataModel() {
                super(9);
            }

            @Nullable
            private LeadGenContextPageFieldsModel m14857a() {
                this.f8869d = (LeadGenContextPageFieldsModel) super.a(this.f8869d, 0, LeadGenContextPageFieldsModel.class);
                return this.f8869d;
            }

            @Nullable
            private String m14858j() {
                this.f8870e = super.a(this.f8870e, 1);
                return this.f8870e;
            }

            @Nonnull
            private ImmutableList<LeadGenDefaultInfoFieldsModel> m14859k() {
                this.f8871f = super.a(this.f8871f, 2, LeadGenDefaultInfoFieldsModel.class);
                return (ImmutableList) this.f8871f;
            }

            @Nullable
            private LeadGenLegalContentFieldsModel m14860l() {
                this.f8872g = (LeadGenLegalContentFieldsModel) super.a(this.f8872g, 3, LeadGenLegalContentFieldsModel.class);
                return this.f8872g;
            }

            @Nonnull
            private ImmutableList<PagesModel> m14861m() {
                this.f8874i = super.a(this.f8874i, 5, PagesModel.class);
                return (ImmutableList) this.f8874i;
            }

            @Nullable
            private String m14862n() {
                this.f8875j = super.a(this.f8875j, 6);
                return this.f8875j;
            }

            @Nullable
            private String m14863o() {
                this.f8876k = super.a(this.f8876k, 7);
                return this.f8876k;
            }

            public final int jK_() {
                return -1255887874;
            }

            public final GraphQLVisitableModel m14865a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                Builder a;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14857a() != null) {
                    LeadGenContextPageFieldsModel leadGenContextPageFieldsModel = (LeadGenContextPageFieldsModel) graphQLModelMutatingVisitor.b(m14857a());
                    if (m14857a() != leadGenContextPageFieldsModel) {
                        graphQLVisitableModel = (LeadGenDataModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8869d = leadGenContextPageFieldsModel;
                    }
                }
                if (m14859k() != null) {
                    a = ModelHelper.a(m14859k(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        LeadGenDataModel leadGenDataModel = (LeadGenDataModel) ModelHelper.a(graphQLVisitableModel, this);
                        leadGenDataModel.f8871f = a.b();
                        graphQLVisitableModel = leadGenDataModel;
                    }
                }
                if (m14860l() != null) {
                    LeadGenLegalContentFieldsModel leadGenLegalContentFieldsModel = (LeadGenLegalContentFieldsModel) graphQLModelMutatingVisitor.b(m14860l());
                    if (m14860l() != leadGenLegalContentFieldsModel) {
                        graphQLVisitableModel = (LeadGenDataModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8872g = leadGenLegalContentFieldsModel;
                    }
                }
                if (m14861m() != null) {
                    a = ModelHelper.a(m14861m(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        leadGenDataModel = (LeadGenDataModel) ModelHelper.a(graphQLVisitableModel, this);
                        leadGenDataModel.f8874i = a.b();
                        graphQLVisitableModel = leadGenDataModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14864a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14857a());
                int b = flatBufferBuilder.b(m14858j());
                int a2 = ModelHelper.a(flatBufferBuilder, m14859k());
                int a3 = ModelHelper.a(flatBufferBuilder, m14860l());
                int a4 = ModelHelper.a(flatBufferBuilder, m14861m());
                int b2 = flatBufferBuilder.b(m14862n());
                int b3 = flatBufferBuilder.b(m14863o());
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.a(4, this.f8873h);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, b2);
                flatBufferBuilder.b(7, b3);
                flatBufferBuilder.a(8, this.f8877l);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14866a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8873h = mutableFlatBuffer.a(i, 4);
                this.f8877l = mutableFlatBuffer.a(i, 8);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1034067648)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class LeadGenUserStatusModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            private boolean f8878d;
            @Nullable
            private String f8879e;
            @Nullable
            private String f8880f;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LeadGenUserStatusModel.class, new Deserializer());
                }

                public Object m14867a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LeadGenUserStatusParser.m15319a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object leadGenUserStatusModel = new LeadGenUserStatusModel();
                    ((BaseModel) leadGenUserStatusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (leadGenUserStatusModel instanceof Postprocessable) {
                        return ((Postprocessable) leadGenUserStatusModel).a();
                    }
                    return leadGenUserStatusModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<LeadGenUserStatusModel> {
                public final void m14868a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LeadGenUserStatusModel leadGenUserStatusModel = (LeadGenUserStatusModel) obj;
                    if (leadGenUserStatusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(leadGenUserStatusModel.m14873a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        leadGenUserStatusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LeadGenUserStatusParser.m15320a(leadGenUserStatusModel.w_(), leadGenUserStatusModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LeadGenUserStatusModel.class, new Serializer());
                }
            }

            public LeadGenUserStatusModel() {
                super(3);
            }

            public final void m14877a(String str, ConsistencyTuple consistencyTuple) {
                if ("has_shared_info".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m14870j());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 0;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m14878a(String str, Object obj, boolean z) {
                if ("has_shared_info".equals(str)) {
                    m14869a(((Boolean) obj).booleanValue());
                }
            }

            private boolean m14870j() {
                a(0, 0);
                return this.f8878d;
            }

            private void m14869a(boolean z) {
                this.f8878d = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 0, z);
                }
            }

            @Nullable
            private String m14871k() {
                this.f8879e = super.a(this.f8879e, 1);
                return this.f8879e;
            }

            @Nullable
            private String m14872l() {
                this.f8880f = super.a(this.f8880f, 2);
                return this.f8880f;
            }

            @Nullable
            public final String m14875a() {
                return m14871k();
            }

            public final int jK_() {
                return 925012209;
            }

            public final GraphQLVisitableModel m14874a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14873a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14871k());
                int b2 = flatBufferBuilder.b(m14872l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f8878d);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14876a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8878d = mutableFlatBuffer.a(i, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 875997457)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class PageModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private CoverPhotoModel f8883d;
            @Nullable
            private DefaultImageFieldsModel f8884e;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 218274323)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_store_application */
            public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PhotoModel f8882d;

                /* compiled from: app_store_application */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                    }

                    public Object m14879a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CoverPhotoParser.m15323a(jsonParser, flatBufferBuilder));
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
                /* compiled from: app_store_application */
                public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private DefaultImageFieldsModel f8881d;

                    /* compiled from: app_store_application */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                        }

                        public Object m14880a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PhotoParser.m15321a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: app_store_application */
                    public class Serializer extends JsonSerializer<PhotoModel> {
                        public final void m14881a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PhotoModel photoModel = (PhotoModel) obj;
                            if (photoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(photoModel.m14883a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PhotoParser.m15322a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(PhotoModel.class, new Serializer());
                        }
                    }

                    public PhotoModel() {
                        super(1);
                    }

                    @Nullable
                    private DefaultImageFieldsModel m14882a() {
                        this.f8881d = (DefaultImageFieldsModel) super.a(this.f8881d, 0, DefaultImageFieldsModel.class);
                        return this.f8881d;
                    }

                    public final int jK_() {
                        return 77090322;
                    }

                    public final GraphQLVisitableModel m14884a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m14882a() != null) {
                            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14882a());
                            if (m14882a() != defaultImageFieldsModel) {
                                graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8881d = defaultImageFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m14883a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m14882a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: app_store_application */
                public class Serializer extends JsonSerializer<CoverPhotoModel> {
                    public final void m14885a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                        if (coverPhotoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(coverPhotoModel.m14887a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CoverPhotoParser.m15324a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                    }
                }

                public CoverPhotoModel() {
                    super(1);
                }

                @Nullable
                private PhotoModel m14886a() {
                    this.f8882d = (PhotoModel) super.a(this.f8882d, 0, PhotoModel.class);
                    return this.f8882d;
                }

                public final int jK_() {
                    return 497264923;
                }

                public final GraphQLVisitableModel m14888a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m14886a() != null) {
                        PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m14886a());
                        if (m14886a() != photoModel) {
                            graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8882d = photoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m14887a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14886a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m14889a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m15325a(jsonParser, flatBufferBuilder));
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

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m14890a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m14893a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m15326a(pageModel.w_(), pageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(2);
            }

            public final void m14895a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14896a(String str, Object obj, boolean z) {
            }

            @Nullable
            private CoverPhotoModel m14891a() {
                this.f8883d = (CoverPhotoModel) super.a(this.f8883d, 0, CoverPhotoModel.class);
                return this.f8883d;
            }

            @Nullable
            private DefaultImageFieldsModel m14892j() {
                this.f8884e = (DefaultImageFieldsModel) super.a(this.f8884e, 1, DefaultImageFieldsModel.class);
                return this.f8884e;
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m14894a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14891a() != null) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m14891a());
                    if (m14891a() != coverPhotoModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8883d = coverPhotoModel;
                    }
                }
                if (m14892j() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14892j());
                    if (m14892j() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8884e = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14893a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14891a());
                int a2 = ModelHelper.a(flatBufferBuilder, m14892j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<LeadGenActionLinkFieldsFragModel> {
            public final void m14897a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LeadGenActionLinkFieldsFragModel leadGenActionLinkFieldsFragModel = (LeadGenActionLinkFieldsFragModel) obj;
                if (leadGenActionLinkFieldsFragModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(leadGenActionLinkFieldsFragModel.m14932a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    leadGenActionLinkFieldsFragModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LeadGenActionLinkFieldsFragParser.m15328a(leadGenActionLinkFieldsFragModel.w_(), leadGenActionLinkFieldsFragModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LeadGenActionLinkFieldsFragModel.class, new Serializer());
            }
        }

        public LeadGenActionLinkFieldsFragModel() {
            super(37);
        }

        @Nullable
        private String m14914a() {
            this.f8899d = super.a(this.f8899d, 0);
            return this.f8899d;
        }

        @Nullable
        private String m14915j() {
            this.f8900e = super.a(this.f8900e, 1);
            return this.f8900e;
        }

        @Nullable
        private String m14916k() {
            this.f8903h = super.a(this.f8903h, 4);
            return this.f8903h;
        }

        @Nullable
        private String m14917l() {
            this.f8904i = super.a(this.f8904i, 5);
            return this.f8904i;
        }

        @Nonnull
        private ImmutableList<ErrorCodesModel> m14918m() {
            this.f8905j = super.a(this.f8905j, 6, ErrorCodesModel.class);
            return (ImmutableList) this.f8905j;
        }

        @Nullable
        private String m14919n() {
            this.f8906k = super.a(this.f8906k, 7);
            return this.f8906k;
        }

        @Nullable
        private String m14920o() {
            this.f8907l = super.a(this.f8907l, 8);
            return this.f8907l;
        }

        @Nullable
        private String m14921p() {
            this.f8908m = super.a(this.f8908m, 9);
            return this.f8908m;
        }

        @Nullable
        private String m14922q() {
            this.f8909n = super.a(this.f8909n, 10);
            return this.f8909n;
        }

        @Nullable
        private String m14923r() {
            this.f8910o = super.a(this.f8910o, 11);
            return this.f8910o;
        }

        @Nullable
        private String m14924s() {
            this.f8911p = super.a(this.f8911p, 12);
            return this.f8911p;
        }

        @Nullable
        private String m14925t() {
            this.f8912q = super.a(this.f8912q, 13);
            return this.f8912q;
        }

        @Nullable
        private String m14926u() {
            this.f8913r = super.a(this.f8913r, 14);
            return this.f8913r;
        }

        @Nullable
        private LeadGenDataModel m14927v() {
            this.f8914s = (LeadGenDataModel) super.a(this.f8914s, 15, LeadGenDataModel.class);
            return this.f8914s;
        }

        @Nullable
        private String m14928w() {
            this.f8915t = super.a(this.f8915t, 16);
            return this.f8915t;
        }

        @Nullable
        private LeadGenDeepLinkUserStatusFieldsModel m14929x() {
            this.f8916u = (LeadGenDeepLinkUserStatusFieldsModel) super.a(this.f8916u, 17, LeadGenDeepLinkUserStatusFieldsModel.class);
            return this.f8916u;
        }

        @Nullable
        private LeadGenUserStatusModel m14930y() {
            this.f8917v = (LeadGenUserStatusModel) super.a(this.f8917v, 18, LeadGenUserStatusModel.class);
            return this.f8917v;
        }

        @Nullable
        private String m14931z() {
            this.f8918w = super.a(this.f8918w, 19);
            return this.f8918w;
        }

        @Nullable
        private String m14898A() {
            this.f8919x = super.a(this.f8919x, 20);
            return this.f8919x;
        }

        @Nullable
        private PageModel m14899B() {
            this.f8920y = (PageModel) super.a(this.f8920y, 21, PageModel.class);
            return this.f8920y;
        }

        @Nullable
        private String m14900C() {
            this.f8921z = super.a(this.f8921z, 22);
            return this.f8921z;
        }

        @Nullable
        private String m14901D() {
            this.f8885A = super.a(this.f8885A, 23);
            return this.f8885A;
        }

        @Nullable
        private String m14902E() {
            this.f8886B = super.a(this.f8886B, 24);
            return this.f8886B;
        }

        @Nullable
        private String m14903F() {
            this.f8887C = super.a(this.f8887C, 25);
            return this.f8887C;
        }

        @Nullable
        private String m14904G() {
            this.f8888D = super.a(this.f8888D, 26);
            return this.f8888D;
        }

        @Nullable
        private String m14905H() {
            this.f8889E = super.a(this.f8889E, 27);
            return this.f8889E;
        }

        @Nullable
        private String m14906I() {
            this.f8890F = super.a(this.f8890F, 28);
            return this.f8890F;
        }

        @Nullable
        private String m14907J() {
            this.f8891G = super.a(this.f8891G, 29);
            return this.f8891G;
        }

        @Nullable
        private String m14908K() {
            this.f8892H = super.a(this.f8892H, 30);
            return this.f8892H;
        }

        @Nullable
        private String m14909L() {
            this.f8893I = super.a(this.f8893I, 31);
            return this.f8893I;
        }

        @Nullable
        private String m14910M() {
            this.f8895K = super.a(this.f8895K, 33);
            return this.f8895K;
        }

        @Nullable
        private String m14911N() {
            this.f8896L = super.a(this.f8896L, 34);
            return this.f8896L;
        }

        @Nullable
        private String m14912O() {
            this.f8897M = super.a(this.f8897M, 35);
            return this.f8897M;
        }

        @Nullable
        private String m14913P() {
            this.f8898N = super.a(this.f8898N, 36);
            return this.f8898N;
        }

        public final int jK_() {
            return 1185006756;
        }

        public final GraphQLVisitableModel m14933a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            LeadGenDataModel leadGenDataModel;
            LeadGenDeepLinkUserStatusFieldsModel leadGenDeepLinkUserStatusFieldsModel;
            LeadGenUserStatusModel leadGenUserStatusModel;
            PageModel pageModel;
            h();
            if (m14918m() != null) {
                Builder a = ModelHelper.a(m14918m(), graphQLModelMutatingVisitor);
                if (a != null) {
                    LeadGenActionLinkFieldsFragModel leadGenActionLinkFieldsFragModel = (LeadGenActionLinkFieldsFragModel) ModelHelper.a(null, this);
                    leadGenActionLinkFieldsFragModel.f8905j = a.b();
                    graphQLVisitableModel = leadGenActionLinkFieldsFragModel;
                    if (m14927v() != null) {
                        leadGenDataModel = (LeadGenDataModel) graphQLModelMutatingVisitor.b(m14927v());
                        if (m14927v() != leadGenDataModel) {
                            graphQLVisitableModel = (LeadGenActionLinkFieldsFragModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8914s = leadGenDataModel;
                        }
                    }
                    if (m14929x() != null) {
                        leadGenDeepLinkUserStatusFieldsModel = (LeadGenDeepLinkUserStatusFieldsModel) graphQLModelMutatingVisitor.b(m14929x());
                        if (m14929x() != leadGenDeepLinkUserStatusFieldsModel) {
                            graphQLVisitableModel = (LeadGenActionLinkFieldsFragModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8916u = leadGenDeepLinkUserStatusFieldsModel;
                        }
                    }
                    if (m14930y() != null) {
                        leadGenUserStatusModel = (LeadGenUserStatusModel) graphQLModelMutatingVisitor.b(m14930y());
                        if (m14930y() != leadGenUserStatusModel) {
                            graphQLVisitableModel = (LeadGenActionLinkFieldsFragModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8917v = leadGenUserStatusModel;
                        }
                    }
                    if (m14899B() != null) {
                        pageModel = (PageModel) graphQLModelMutatingVisitor.b(m14899B());
                        if (m14899B() != pageModel) {
                            graphQLVisitableModel = (LeadGenActionLinkFieldsFragModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8920y = pageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m14927v() != null) {
                leadGenDataModel = (LeadGenDataModel) graphQLModelMutatingVisitor.b(m14927v());
                if (m14927v() != leadGenDataModel) {
                    graphQLVisitableModel = (LeadGenActionLinkFieldsFragModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8914s = leadGenDataModel;
                }
            }
            if (m14929x() != null) {
                leadGenDeepLinkUserStatusFieldsModel = (LeadGenDeepLinkUserStatusFieldsModel) graphQLModelMutatingVisitor.b(m14929x());
                if (m14929x() != leadGenDeepLinkUserStatusFieldsModel) {
                    graphQLVisitableModel = (LeadGenActionLinkFieldsFragModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8916u = leadGenDeepLinkUserStatusFieldsModel;
                }
            }
            if (m14930y() != null) {
                leadGenUserStatusModel = (LeadGenUserStatusModel) graphQLModelMutatingVisitor.b(m14930y());
                if (m14930y() != leadGenUserStatusModel) {
                    graphQLVisitableModel = (LeadGenActionLinkFieldsFragModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8917v = leadGenUserStatusModel;
                }
            }
            if (m14899B() != null) {
                pageModel = (PageModel) graphQLModelMutatingVisitor.b(m14899B());
                if (m14899B() != pageModel) {
                    graphQLVisitableModel = (LeadGenActionLinkFieldsFragModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8920y = pageModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m14932a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m14914a());
            int b2 = flatBufferBuilder.b(m14915j());
            int b3 = flatBufferBuilder.b(m14916k());
            int b4 = flatBufferBuilder.b(m14917l());
            int a = ModelHelper.a(flatBufferBuilder, m14918m());
            int b5 = flatBufferBuilder.b(m14919n());
            int b6 = flatBufferBuilder.b(m14920o());
            int b7 = flatBufferBuilder.b(m14921p());
            int b8 = flatBufferBuilder.b(m14922q());
            int b9 = flatBufferBuilder.b(m14923r());
            int b10 = flatBufferBuilder.b(m14924s());
            int b11 = flatBufferBuilder.b(m14925t());
            int b12 = flatBufferBuilder.b(m14926u());
            int a2 = ModelHelper.a(flatBufferBuilder, m14927v());
            int b13 = flatBufferBuilder.b(m14928w());
            int a3 = ModelHelper.a(flatBufferBuilder, m14929x());
            int a4 = ModelHelper.a(flatBufferBuilder, m14930y());
            int b14 = flatBufferBuilder.b(m14931z());
            int b15 = flatBufferBuilder.b(m14898A());
            int a5 = ModelHelper.a(flatBufferBuilder, m14899B());
            int b16 = flatBufferBuilder.b(m14900C());
            int b17 = flatBufferBuilder.b(m14901D());
            int b18 = flatBufferBuilder.b(m14902E());
            int b19 = flatBufferBuilder.b(m14903F());
            int b20 = flatBufferBuilder.b(m14904G());
            int b21 = flatBufferBuilder.b(m14905H());
            int b22 = flatBufferBuilder.b(m14906I());
            int b23 = flatBufferBuilder.b(m14907J());
            int b24 = flatBufferBuilder.b(m14908K());
            int b25 = flatBufferBuilder.b(m14909L());
            int b26 = flatBufferBuilder.b(m14910M());
            int b27 = flatBufferBuilder.b(m14911N());
            int b28 = flatBufferBuilder.b(m14912O());
            int b29 = flatBufferBuilder.b(m14913P());
            flatBufferBuilder.c(37);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.a(2, this.f8901f, 0);
            flatBufferBuilder.a(3, this.f8902g, 0);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.b(6, a);
            flatBufferBuilder.b(7, b5);
            flatBufferBuilder.b(8, b6);
            flatBufferBuilder.b(9, b7);
            flatBufferBuilder.b(10, b8);
            flatBufferBuilder.b(11, b9);
            flatBufferBuilder.b(12, b10);
            flatBufferBuilder.b(13, b11);
            flatBufferBuilder.b(14, b12);
            flatBufferBuilder.b(15, a2);
            flatBufferBuilder.b(16, b13);
            flatBufferBuilder.b(17, a3);
            flatBufferBuilder.b(18, a4);
            flatBufferBuilder.b(19, b14);
            flatBufferBuilder.b(20, b15);
            flatBufferBuilder.b(21, a5);
            flatBufferBuilder.b(22, b16);
            flatBufferBuilder.b(23, b17);
            flatBufferBuilder.b(24, b18);
            flatBufferBuilder.b(25, b19);
            flatBufferBuilder.b(26, b20);
            flatBufferBuilder.b(27, b21);
            flatBufferBuilder.b(28, b22);
            flatBufferBuilder.b(29, b23);
            flatBufferBuilder.b(30, b24);
            flatBufferBuilder.b(31, b25);
            flatBufferBuilder.a(32, this.f8894J);
            flatBufferBuilder.b(33, b26);
            flatBufferBuilder.b(34, b27);
            flatBufferBuilder.b(35, b28);
            flatBufferBuilder.b(36, b29);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14934a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8901f = mutableFlatBuffer.a(i, 2, 0);
            this.f8902g = mutableFlatBuffer.a(i, 3, 0);
            this.f8894J = mutableFlatBuffer.a(i, 32);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1273250258)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class LeadGenContextPageFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ContextCardPhotoModel f8926d;
        @Nullable
        private List<String> f8927e;
        @Nullable
        private GraphQLLeadGenContextPageContentStyle f8928f;
        @Nullable
        private String f8929g;
        @Nullable
        private ContextImageModel f8930h;
        @Nullable
        private String f8931i;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 141940779)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class ContextCardPhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f8922d;
            @Nullable
            private FBFullImageFragmentModel f8923e;
            @Nullable
            private String f8924f;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ContextCardPhotoModel.class, new Deserializer());
                }

                public Object m14935a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ContextCardPhotoParser.m15329a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object contextCardPhotoModel = new ContextCardPhotoModel();
                    ((BaseModel) contextCardPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (contextCardPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) contextCardPhotoModel).a();
                    }
                    return contextCardPhotoModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<ContextCardPhotoModel> {
                public final void m14936a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ContextCardPhotoModel contextCardPhotoModel = (ContextCardPhotoModel) obj;
                    if (contextCardPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(contextCardPhotoModel.m14940a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        contextCardPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ContextCardPhotoParser.m15330a(contextCardPhotoModel.w_(), contextCardPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ContextCardPhotoModel.class, new Serializer());
                }
            }

            public ContextCardPhotoModel() {
                super(3);
            }

            @Nullable
            private String m14937j() {
                this.f8922d = super.a(this.f8922d, 0);
                return this.f8922d;
            }

            @Nullable
            private FBFullImageFragmentModel m14938k() {
                this.f8923e = (FBFullImageFragmentModel) super.a(this.f8923e, 1, FBFullImageFragmentModel.class);
                return this.f8923e;
            }

            @Nullable
            private String m14939l() {
                this.f8924f = super.a(this.f8924f, 2);
                return this.f8924f;
            }

            @Nullable
            public final String m14942a() {
                return m14937j();
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m14941a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14938k() != null) {
                    FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m14938k());
                    if (m14938k() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (ContextCardPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8923e = fBFullImageFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14940a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14937j());
                int a = ModelHelper.a(flatBufferBuilder, m14938k());
                int b2 = flatBufferBuilder.b(m14939l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class ContextImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8925d;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ContextImageModel.class, new Deserializer());
                }

                public Object m14943a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ContextImageParser.m15331a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object contextImageModel = new ContextImageModel();
                    ((BaseModel) contextImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (contextImageModel instanceof Postprocessable) {
                        return ((Postprocessable) contextImageModel).a();
                    }
                    return contextImageModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<ContextImageModel> {
                public final void m14944a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ContextImageModel contextImageModel = (ContextImageModel) obj;
                    if (contextImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(contextImageModel.m14946a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        contextImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ContextImageParser.m15332a(contextImageModel.w_(), contextImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ContextImageModel.class, new Serializer());
                }
            }

            public ContextImageModel() {
                super(1);
            }

            @Nullable
            private String m14945a() {
                this.f8925d = super.a(this.f8925d, 0);
                return this.f8925d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m14947a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14946a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14945a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LeadGenContextPageFieldsModel.class, new Deserializer());
            }

            public Object m14948a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LeadGenContextPageFieldsParser.m15333a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object leadGenContextPageFieldsModel = new LeadGenContextPageFieldsModel();
                ((BaseModel) leadGenContextPageFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (leadGenContextPageFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) leadGenContextPageFieldsModel).a();
                }
                return leadGenContextPageFieldsModel;
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<LeadGenContextPageFieldsModel> {
            public final void m14949a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LeadGenContextPageFieldsModel leadGenContextPageFieldsModel = (LeadGenContextPageFieldsModel) obj;
                if (leadGenContextPageFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(leadGenContextPageFieldsModel.m14956a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    leadGenContextPageFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LeadGenContextPageFieldsParser.m15334a(leadGenContextPageFieldsModel.w_(), leadGenContextPageFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LeadGenContextPageFieldsModel.class, new Serializer());
            }
        }

        public LeadGenContextPageFieldsModel() {
            super(6);
        }

        @Nullable
        private ContextCardPhotoModel m14950a() {
            this.f8926d = (ContextCardPhotoModel) super.a(this.f8926d, 0, ContextCardPhotoModel.class);
            return this.f8926d;
        }

        @Nonnull
        private ImmutableList<String> m14951j() {
            this.f8927e = super.a(this.f8927e, 1);
            return (ImmutableList) this.f8927e;
        }

        @Nullable
        private GraphQLLeadGenContextPageContentStyle m14952k() {
            this.f8928f = (GraphQLLeadGenContextPageContentStyle) super.b(this.f8928f, 2, GraphQLLeadGenContextPageContentStyle.class, GraphQLLeadGenContextPageContentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8928f;
        }

        @Nullable
        private String m14953l() {
            this.f8929g = super.a(this.f8929g, 3);
            return this.f8929g;
        }

        @Nullable
        private ContextImageModel m14954m() {
            this.f8930h = (ContextImageModel) super.a(this.f8930h, 4, ContextImageModel.class);
            return this.f8930h;
        }

        @Nullable
        private String m14955n() {
            this.f8931i = super.a(this.f8931i, 5);
            return this.f8931i;
        }

        public final int jK_() {
            return 706615818;
        }

        public final GraphQLVisitableModel m14957a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14950a() != null) {
                ContextCardPhotoModel contextCardPhotoModel = (ContextCardPhotoModel) graphQLModelMutatingVisitor.b(m14950a());
                if (m14950a() != contextCardPhotoModel) {
                    graphQLVisitableModel = (LeadGenContextPageFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8926d = contextCardPhotoModel;
                }
            }
            if (m14954m() != null) {
                ContextImageModel contextImageModel = (ContextImageModel) graphQLModelMutatingVisitor.b(m14954m());
                if (m14954m() != contextImageModel) {
                    graphQLVisitableModel = (LeadGenContextPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8930h = contextImageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14956a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14950a());
            int c = flatBufferBuilder.c(m14951j());
            int a2 = flatBufferBuilder.a(m14952k());
            int b = flatBufferBuilder.b(m14953l());
            int a3 = ModelHelper.a(flatBufferBuilder, m14954m());
            int b2 = flatBufferBuilder.b(m14955n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, c);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1034067648)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class LeadGenDeepLinkUserStatusFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f8932d;
        @Nullable
        private String f8933e;
        @Nullable
        private String f8934f;

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LeadGenDeepLinkUserStatusFieldsModel.class, new Deserializer());
            }

            public Object m14958a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LeadGenDeepLinkUserStatusFieldsParser.m15335a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object leadGenDeepLinkUserStatusFieldsModel = new LeadGenDeepLinkUserStatusFieldsModel();
                ((BaseModel) leadGenDeepLinkUserStatusFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (leadGenDeepLinkUserStatusFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) leadGenDeepLinkUserStatusFieldsModel).a();
                }
                return leadGenDeepLinkUserStatusFieldsModel;
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<LeadGenDeepLinkUserStatusFieldsModel> {
            public final void m14959a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LeadGenDeepLinkUserStatusFieldsModel leadGenDeepLinkUserStatusFieldsModel = (LeadGenDeepLinkUserStatusFieldsModel) obj;
                if (leadGenDeepLinkUserStatusFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(leadGenDeepLinkUserStatusFieldsModel.m14964a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    leadGenDeepLinkUserStatusFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LeadGenDeepLinkUserStatusFieldsParser.m15336a(leadGenDeepLinkUserStatusFieldsModel.w_(), leadGenDeepLinkUserStatusFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(LeadGenDeepLinkUserStatusFieldsModel.class, new Serializer());
            }
        }

        public LeadGenDeepLinkUserStatusFieldsModel() {
            super(3);
        }

        public final void m14968a(String str, ConsistencyTuple consistencyTuple) {
            if ("has_shared_info".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m14961j());
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
                return;
            }
            consistencyTuple.a();
        }

        public final void m14969a(String str, Object obj, boolean z) {
            if ("has_shared_info".equals(str)) {
                m14960a(((Boolean) obj).booleanValue());
            }
        }

        private boolean m14961j() {
            a(0, 0);
            return this.f8932d;
        }

        private void m14960a(boolean z) {
            this.f8932d = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, z);
            }
        }

        @Nullable
        private String m14962k() {
            this.f8933e = super.a(this.f8933e, 1);
            return this.f8933e;
        }

        @Nullable
        private String m14963l() {
            this.f8934f = super.a(this.f8934f, 2);
            return this.f8934f;
        }

        @Nullable
        public final String m14966a() {
            return m14962k();
        }

        public final int jK_() {
            return 771298455;
        }

        public final GraphQLVisitableModel m14965a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14964a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m14962k());
            int b2 = flatBufferBuilder.b(m14963l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f8932d);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14967a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8932d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -629350063)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class LeadGenDefaultInfoFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<String> f8935d;
        @Nullable
        private String f8936e;
        @Nullable
        private GraphQLLeadGenInfoFieldInputDomain f8937f;
        @Nullable
        private GraphQLLeadGenInfoFieldInputType f8938g;
        private boolean f8939h;
        private boolean f8940i;
        private boolean f8941j;
        @Nullable
        private String f8942k;
        @Nullable
        private String f8943l;
        @Nullable
        private List<String> f8944m;

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LeadGenDefaultInfoFieldsModel.class, new Deserializer());
            }

            public Object m14970a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LeadGenDefaultInfoFieldsParser.m15340b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object leadGenDefaultInfoFieldsModel = new LeadGenDefaultInfoFieldsModel();
                ((BaseModel) leadGenDefaultInfoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (leadGenDefaultInfoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) leadGenDefaultInfoFieldsModel).a();
                }
                return leadGenDefaultInfoFieldsModel;
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<LeadGenDefaultInfoFieldsModel> {
            public final void m14971a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LeadGenDefaultInfoFieldsModel leadGenDefaultInfoFieldsModel = (LeadGenDefaultInfoFieldsModel) obj;
                if (leadGenDefaultInfoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(leadGenDefaultInfoFieldsModel.m14979a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    leadGenDefaultInfoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LeadGenDefaultInfoFieldsParser.m15338a(leadGenDefaultInfoFieldsModel.w_(), leadGenDefaultInfoFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(LeadGenDefaultInfoFieldsModel.class, new Serializer());
            }
        }

        public LeadGenDefaultInfoFieldsModel() {
            super(10);
        }

        @Nonnull
        private ImmutableList<String> m14972a() {
            this.f8935d = super.a(this.f8935d, 0);
            return (ImmutableList) this.f8935d;
        }

        @Nullable
        private String m14973j() {
            this.f8936e = super.a(this.f8936e, 1);
            return this.f8936e;
        }

        @Nullable
        private GraphQLLeadGenInfoFieldInputDomain m14974k() {
            this.f8937f = (GraphQLLeadGenInfoFieldInputDomain) super.b(this.f8937f, 2, GraphQLLeadGenInfoFieldInputDomain.class, GraphQLLeadGenInfoFieldInputDomain.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8937f;
        }

        @Nullable
        private GraphQLLeadGenInfoFieldInputType m14975l() {
            this.f8938g = (GraphQLLeadGenInfoFieldInputType) super.b(this.f8938g, 3, GraphQLLeadGenInfoFieldInputType.class, GraphQLLeadGenInfoFieldInputType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8938g;
        }

        @Nullable
        private String m14976m() {
            this.f8942k = super.a(this.f8942k, 7);
            return this.f8942k;
        }

        @Nullable
        private String m14977n() {
            this.f8943l = super.a(this.f8943l, 8);
            return this.f8943l;
        }

        @Nonnull
        private ImmutableList<String> m14978o() {
            this.f8944m = super.a(this.f8944m, 9);
            return (ImmutableList) this.f8944m;
        }

        public final int jK_() {
            return 1236596962;
        }

        public final GraphQLVisitableModel m14980a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14979a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m14972a());
            int b = flatBufferBuilder.b(m14973j());
            int a = flatBufferBuilder.a(m14974k());
            int a2 = flatBufferBuilder.a(m14975l());
            int b2 = flatBufferBuilder.b(m14976m());
            int b3 = flatBufferBuilder.b(m14977n());
            int c2 = flatBufferBuilder.c(m14978o());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, c);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.a(4, this.f8939h);
            flatBufferBuilder.a(5, this.f8940i);
            flatBufferBuilder.a(6, this.f8941j);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, b3);
            flatBufferBuilder.b(9, c2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14981a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8939h = mutableFlatBuffer.a(i, 4);
            this.f8940i = mutableFlatBuffer.a(i, 5);
            this.f8941j = mutableFlatBuffer.a(i, 6);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 804839401)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class LeadGenLegalContentFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8957d;
        @Nullable
        private List<CheckboxesModel> f8958e;
        @Nullable
        private List<DisclaimerBodyModel> f8959f;
        @Nullable
        private String f8960g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 952628976)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class CheckboxesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CheckboxBodyModel f8946d;
            private boolean f8947e;
            private boolean f8948f;
            @Nullable
            private String f8949g;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_store_application */
            public final class CheckboxBodyModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8945d;

                /* compiled from: app_store_application */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CheckboxBodyModel.class, new Deserializer());
                    }

                    public Object m14982a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CheckboxBodyParser.m15341a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object checkboxBodyModel = new CheckboxBodyModel();
                        ((BaseModel) checkboxBodyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (checkboxBodyModel instanceof Postprocessable) {
                            return ((Postprocessable) checkboxBodyModel).a();
                        }
                        return checkboxBodyModel;
                    }
                }

                /* compiled from: app_store_application */
                public class Serializer extends JsonSerializer<CheckboxBodyModel> {
                    public final void m14983a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CheckboxBodyModel checkboxBodyModel = (CheckboxBodyModel) obj;
                        if (checkboxBodyModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(checkboxBodyModel.m14985a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            checkboxBodyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CheckboxBodyParser.m15342a(checkboxBodyModel.w_(), checkboxBodyModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CheckboxBodyModel.class, new Serializer());
                    }
                }

                public CheckboxBodyModel() {
                    super(1);
                }

                @Nullable
                private String m14984a() {
                    this.f8945d = super.a(this.f8945d, 0);
                    return this.f8945d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m14986a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14985a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m14984a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CheckboxesModel.class, new Deserializer());
                }

                public Object m14987a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CheckboxesParser.m15343b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object checkboxesModel = new CheckboxesModel();
                    ((BaseModel) checkboxesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (checkboxesModel instanceof Postprocessable) {
                        return ((Postprocessable) checkboxesModel).a();
                    }
                    return checkboxesModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<CheckboxesModel> {
                public final void m14988a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CheckboxesModel checkboxesModel = (CheckboxesModel) obj;
                    if (checkboxesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(checkboxesModel.m14991a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        checkboxesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CheckboxesParser.m15344b(checkboxesModel.w_(), checkboxesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CheckboxesModel.class, new Serializer());
                }
            }

            public CheckboxesModel() {
                super(4);
            }

            @Nullable
            private CheckboxBodyModel m14989a() {
                this.f8946d = (CheckboxBodyModel) super.a(this.f8946d, 0, CheckboxBodyModel.class);
                return this.f8946d;
            }

            @Nullable
            private String m14990j() {
                this.f8949g = super.a(this.f8949g, 3);
                return this.f8949g;
            }

            public final int jK_() {
                return -1082774601;
            }

            public final GraphQLVisitableModel m14992a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14989a() != null) {
                    CheckboxBodyModel checkboxBodyModel = (CheckboxBodyModel) graphQLModelMutatingVisitor.b(m14989a());
                    if (m14989a() != checkboxBodyModel) {
                        graphQLVisitableModel = (CheckboxesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8946d = checkboxBodyModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14991a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14989a());
                int b = flatBufferBuilder.b(m14990j());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f8947e);
                flatBufferBuilder.a(2, this.f8948f);
                flatBufferBuilder.b(3, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14993a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8947e = mutableFlatBuffer.a(i, 1);
                this.f8948f = mutableFlatBuffer.a(i, 2);
            }
        }

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LeadGenLegalContentFieldsModel.class, new Deserializer());
            }

            public Object m14994a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LeadGenLegalContentFieldsParser.m15352a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object leadGenLegalContentFieldsModel = new LeadGenLegalContentFieldsModel();
                ((BaseModel) leadGenLegalContentFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (leadGenLegalContentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) leadGenLegalContentFieldsModel).a();
                }
                return leadGenLegalContentFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 175460717)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class DisclaimerBodyModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<RangesModel> f8955d;
            @Nullable
            private String f8956e;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DisclaimerBodyModel.class, new Deserializer());
                }

                public Object m14995a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DisclaimerBodyParser.m15350b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object disclaimerBodyModel = new DisclaimerBodyModel();
                    ((BaseModel) disclaimerBodyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (disclaimerBodyModel instanceof Postprocessable) {
                        return ((Postprocessable) disclaimerBodyModel).a();
                    }
                    return disclaimerBodyModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1604766088)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_store_application */
            public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private EntityModel f8952d;
                private int f8953e;
                private int f8954f;

                /* compiled from: app_store_application */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                    }

                    public Object m14996a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RangesParser.m15347b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object rangesModel = new RangesModel();
                        ((BaseModel) rangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (rangesModel instanceof Postprocessable) {
                            return ((Postprocessable) rangesModel).a();
                        }
                        return rangesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1205772718)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: app_store_application */
                public final class EntityModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GraphQLObjectType f8950d;
                    @Nullable
                    private String f8951e;

                    /* compiled from: app_store_application */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
                        }

                        public Object m14997a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EntityParser.m15345a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object entityModel = new EntityModel();
                            ((BaseModel) entityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (entityModel instanceof Postprocessable) {
                                return ((Postprocessable) entityModel).a();
                            }
                            return entityModel;
                        }
                    }

                    /* compiled from: app_store_application */
                    public class Serializer extends JsonSerializer<EntityModel> {
                        public final void m14998a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EntityModel entityModel = (EntityModel) obj;
                            if (entityModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(entityModel.m15001a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EntityParser.m15346a(entityModel.w_(), entityModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(EntityModel.class, new Serializer());
                        }
                    }

                    public EntityModel() {
                        super(2);
                    }

                    @Nullable
                    private GraphQLObjectType m14999a() {
                        if (this.b != null && this.f8950d == null) {
                            this.f8950d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f8950d;
                    }

                    @Nullable
                    private String m15000j() {
                        this.f8951e = super.a(this.f8951e, 1);
                        return this.f8951e;
                    }

                    public final int jK_() {
                        return 2080559107;
                    }

                    public final GraphQLVisitableModel m15002a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m15001a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m14999a());
                        int b = flatBufferBuilder.b(m15000j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: app_store_application */
                public class Serializer extends JsonSerializer<RangesModel> {
                    public final void m15003a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RangesModel rangesModel = (RangesModel) obj;
                        if (rangesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(rangesModel.m15005a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RangesParser.m15348b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(RangesModel.class, new Serializer());
                    }
                }

                public RangesModel() {
                    super(3);
                }

                @Nullable
                private EntityModel m15004a() {
                    this.f8952d = (EntityModel) super.a(this.f8952d, 0, EntityModel.class);
                    return this.f8952d;
                }

                public final int jK_() {
                    return -1024511161;
                }

                public final GraphQLVisitableModel m15006a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15004a() != null) {
                        EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m15004a());
                        if (m15004a() != entityModel) {
                            graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8952d = entityModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15005a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15004a());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f8953e, 0);
                    flatBufferBuilder.a(2, this.f8954f, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m15007a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f8953e = mutableFlatBuffer.a(i, 1, 0);
                    this.f8954f = mutableFlatBuffer.a(i, 2, 0);
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<DisclaimerBodyModel> {
                public final void m15008a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DisclaimerBodyModel disclaimerBodyModel = (DisclaimerBodyModel) obj;
                    if (disclaimerBodyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(disclaimerBodyModel.m15011a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        disclaimerBodyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DisclaimerBodyParser.m15351b(disclaimerBodyModel.w_(), disclaimerBodyModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DisclaimerBodyModel.class, new Serializer());
                }
            }

            public DisclaimerBodyModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<RangesModel> m15009a() {
                this.f8955d = super.a(this.f8955d, 0, RangesModel.class);
                return (ImmutableList) this.f8955d;
            }

            @Nullable
            private String m15010j() {
                this.f8956e = super.a(this.f8956e, 1);
                return this.f8956e;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m15012a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15009a() != null) {
                    Builder a = ModelHelper.a(m15009a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (DisclaimerBodyModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8955d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15011a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15009a());
                int b = flatBufferBuilder.b(m15010j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<LeadGenLegalContentFieldsModel> {
            public final void m15013a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LeadGenLegalContentFieldsModel leadGenLegalContentFieldsModel = (LeadGenLegalContentFieldsModel) obj;
                if (leadGenLegalContentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(leadGenLegalContentFieldsModel.m15018a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    leadGenLegalContentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LeadGenLegalContentFieldsParser.m15353a(leadGenLegalContentFieldsModel.w_(), leadGenLegalContentFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LeadGenLegalContentFieldsModel.class, new Serializer());
            }
        }

        public LeadGenLegalContentFieldsModel() {
            super(4);
        }

        @Nullable
        private String m15014a() {
            this.f8957d = super.a(this.f8957d, 0);
            return this.f8957d;
        }

        @Nonnull
        private ImmutableList<CheckboxesModel> m15015j() {
            this.f8958e = super.a(this.f8958e, 1, CheckboxesModel.class);
            return (ImmutableList) this.f8958e;
        }

        @Nonnull
        private ImmutableList<DisclaimerBodyModel> m15016k() {
            this.f8959f = super.a(this.f8959f, 2, DisclaimerBodyModel.class);
            return (ImmutableList) this.f8959f;
        }

        @Nullable
        private String m15017l() {
            this.f8960g = super.a(this.f8960g, 3);
            return this.f8960g;
        }

        public final int jK_() {
            return -1148993580;
        }

        public final GraphQLVisitableModel m15019a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15015j() != null) {
                a = ModelHelper.a(m15015j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (LeadGenLegalContentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8958e = a.b();
                }
            }
            if (m15016k() != null) {
                a = ModelHelper.a(m15016k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (LeadGenLegalContentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8959f = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15018a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15014a());
            int a = ModelHelper.a(flatBufferBuilder, m15015j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15016k());
            int b2 = flatBufferBuilder.b(m15017l());
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
    @ModelWithFlatBufferFormatHash(a = 852791024)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class LinkTargetStoreDataFragModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8961d;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f8962e;
        private boolean f8963f;
        private boolean f8964g;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f8965h;

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LinkTargetStoreDataFragModel.class, new Deserializer());
            }

            public Object m15020a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LinkTargetStoreDataFragParser.m15354a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object linkTargetStoreDataFragModel = new LinkTargetStoreDataFragModel();
                ((BaseModel) linkTargetStoreDataFragModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (linkTargetStoreDataFragModel instanceof Postprocessable) {
                    return ((Postprocessable) linkTargetStoreDataFragModel).a();
                }
                return linkTargetStoreDataFragModel;
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<LinkTargetStoreDataFragModel> {
            public final void m15021a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LinkTargetStoreDataFragModel linkTargetStoreDataFragModel = (LinkTargetStoreDataFragModel) obj;
                if (linkTargetStoreDataFragModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(linkTargetStoreDataFragModel.m15025a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    linkTargetStoreDataFragModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LinkTargetStoreDataFragParser.m15355a(linkTargetStoreDataFragModel.w_(), linkTargetStoreDataFragModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LinkTargetStoreDataFragModel.class, new Serializer());
            }
        }

        public LinkTargetStoreDataFragModel() {
            super(5);
        }

        @Nullable
        private String m15022a() {
            this.f8961d = super.a(this.f8961d, 0);
            return this.f8961d;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m15023j() {
            this.f8962e = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f8962e, 1, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f8962e;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m15024k() {
            this.f8965h = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f8965h, 4, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f8965h;
        }

        public final int jK_() {
            return 1258324512;
        }

        public final GraphQLVisitableModel m15026a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15023j() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15023j());
                if (m15023j() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (LinkTargetStoreDataFragModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8962e = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m15024k() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15024k());
                if (m15024k() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (LinkTargetStoreDataFragModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8965h = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15025a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15022a());
            int a = ModelHelper.a(flatBufferBuilder, m15023j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15024k());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.a(2, this.f8963f);
            flatBufferBuilder.a(3, this.f8964g);
            flatBufferBuilder.b(4, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15027a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8963f = mutableFlatBuffer.a(i, 2);
            this.f8964g = mutableFlatBuffer.a(i, 3);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 849153123)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: app_store_application */
    public final class NewsFeedDefaultsStoryActionLinkFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<String> f9010A;
        @Nullable
        private String f9011B;
        @Nullable
        private String f9012C;
        @Nullable
        private String f9013D;
        @Nullable
        private InfoModel f9014E;
        @Nullable
        private InstantArticleModel f9015F;
        @Nullable
        private DefaultSavableObjectExtraFieldsModel f9016G;
        @Nullable
        private String f9017H;
        @Nullable
        private String f9018I;
        @Nullable
        private LeadGenDataModel f9019J;
        @Nullable
        private String f9020K;
        @Nullable
        private LeadGenDeepLinkUserStatusFieldsModel f9021L;
        @Nullable
        private LeadGenUserStatusModel f9022M;
        @Nullable
        private String f9023N;
        @Nullable
        private String f9024O;
        @Nullable
        private DefaultImageFieldsModel f9025P;
        @Nullable
        private GraphQLCallToActionStyle f9026Q;
        @Nullable
        private LinkTargetStoreDataFragModel f9027R;
        @Nullable
        private String f9028S;
        @Nullable
        private GraphQLCallToActionType f9029T;
        @Nullable
        private DefaultImageFieldsModel f9030U;
        @Nullable
        private String f9031V;
        @Nullable
        private List<String> f9032W;
        @Nullable
        private String f9033X;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f9034Y;
        @Nullable
        private String f9035Z;
        @Nullable
        private String aA;
        @Nullable
        private ImageOverlayFieldsModel aB;
        @Nullable
        private StoryModel aC;
        @Nullable
        private String aD;
        @Nullable
        private TaggedAndMentionedUsersModel aE;
        @Nullable
        private TemporalEventInfoModel aF;
        @Nullable
        private String aG;
        @Nullable
        private TopicModel aH;
        @Nullable
        private String aI;
        @Nullable
        private String aJ;
        @Nullable
        private List<VideoAnnotationFieldsModel> aK;
        @Nullable
        private String aa;
        @Nullable
        private PageModel ab;
        @Nullable
        private PageOutcomeButtonModel ac;
        @Nullable
        private ParentStoryModel ad;
        @Nullable
        private String ae;
        @Nullable
        private String af;
        @Nullable
        private PrivacyScopeModel ag;
        @Nullable
        private String ah;
        @Nullable
        private ProfileModel ai;
        @Nullable
        private String aj;
        @Nullable
        private String ak;
        @Nullable
        private String al;
        private int am;
        @Nullable
        private ReviewModel an;
        @Nullable
        private String ao;
        @Nullable
        private String ap;
        @Nullable
        private String aq;
        @Nullable
        private String ar;
        @Nullable
        private String as;
        @Nullable
        private String at;
        private boolean au;
        private boolean av;
        private boolean aw;
        private boolean ax;
        @Nullable
        private String ay;
        @Nullable
        private String az;
        @Nullable
        private GraphQLObjectType f9036d;
        @Nullable
        private GraphQLProfilePictureActionLinkType f9037e;
        @Nullable
        private String f9038f;
        @Nullable
        private String f9039g;
        private int f9040h;
        private int f9041i;
        private boolean f9042j;
        private boolean f9043k;
        private long f9044l;
        @Nullable
        private DescriptionModel f9045m;
        @Nullable
        private GraphQLStoryActionLinkDestinationType f9046n;
        @Nullable
        private String f9047o;
        @Nullable
        private String f9048p;
        @Nullable
        private List<ErrorCodesModel> f9049q;
        @Nullable
        private String f9050r;
        @Nullable
        private String f9051s;
        @Nullable
        private EventModel f9052t;
        @Nullable
        private String f9053u;
        @Nullable
        private String f9054v;
        @Nullable
        private FeaturedInstantArticleElementModel f9055w;
        @Nullable
        private FeedbackModel f9056x;
        @Nullable
        private String f9057y;
        @Nullable
        private String f9058z;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -873801115)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class DescriptionModel extends BaseModel implements DefaultTextWithEntityRangesFields, GraphQLVisitableModel {
            @Nullable
            private List<RangesModel> f8966d;
            @Nullable
            private String f8967e;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DescriptionModel.class, new Deserializer());
                }

                public Object m15028a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DescriptionParser.m15356a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object descriptionModel = new DescriptionModel();
                    ((BaseModel) descriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (descriptionModel instanceof Postprocessable) {
                        return ((Postprocessable) descriptionModel).a();
                    }
                    return descriptionModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<DescriptionModel> {
                public final void m15029a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DescriptionModel descriptionModel = (DescriptionModel) obj;
                    if (descriptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(descriptionModel.m15031a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        descriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DescriptionParser.m15357a(descriptionModel.w_(), descriptionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DescriptionModel.class, new Serializer());
                }
            }

            public DescriptionModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<RangesModel> m15030j() {
                this.f8966d = super.a(this.f8966d, 0, RangesModel.class);
                return (ImmutableList) this.f8966d;
            }

            @Nullable
            public final String m15033a() {
                this.f8967e = super.a(this.f8967e, 1);
                return this.f8967e;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m15032a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15030j() != null) {
                    Builder a = ModelHelper.a(m15030j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (DescriptionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8966d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15031a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15030j());
                int b = flatBufferBuilder.b(m15033a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NewsFeedDefaultsStoryActionLinkFieldsModel.class, new Deserializer());
            }

            public Object m15034a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NewsFeedDefaultsStoryActionLinkFieldsParser.m15380b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object newsFeedDefaultsStoryActionLinkFieldsModel = new NewsFeedDefaultsStoryActionLinkFieldsModel();
                ((BaseModel) newsFeedDefaultsStoryActionLinkFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (newsFeedDefaultsStoryActionLinkFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) newsFeedDefaultsStoryActionLinkFieldsModel).a();
                }
                return newsFeedDefaultsStoryActionLinkFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -923568650)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class EventModel extends BaseModel implements EventAttachment, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            private boolean f8968d;
            @Nullable
            private GraphQLConnectionStyle f8969e;
            private long f8970f;
            @Nullable
            private EventCoverPhotoModel f8971g;
            @Nullable
            private NewsFeedDefaultsEventPlaceFieldsModel f8972h;
            @Nullable
            private String f8973i;
            private boolean f8974j;
            @Nullable
            private String f8975k;
            private long f8976l;
            @Nullable
            private String f8977m;
            @Nullable
            private String f8978n;
            @Nullable
            private GraphQLEventGuestStatus f8979o;
            private boolean f8980p;
            @Nullable
            private GraphQLEventWatchStatus f8981q;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventModel.class, new Deserializer());
                }

                public Object m15035a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventParser.m15358a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventModel = new EventModel();
                    ((BaseModel) eventModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventModel instanceof Postprocessable) {
                        return ((Postprocessable) eventModel).a();
                    }
                    return eventModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<EventModel> {
                public final void m15036a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventModel eventModel = (EventModel) obj;
                    if (eventModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventModel.m15043a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventParser.m15359a(eventModel.w_(), eventModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EventModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ EventCoverPhotoModel bv_() {
                return m15041q();
            }

            @Nullable
            public final /* synthetic */ NewsFeedDefaultsEventPlaceFieldsModel mo1103g() {
                return m15042r();
            }

            public EventModel() {
                super(14);
            }

            public final void m15047a(String str, ConsistencyTuple consistencyTuple) {
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

            public final void m15048a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m15039a((String) obj);
                } else if ("viewer_guest_status".equals(str)) {
                    m15037a((GraphQLEventGuestStatus) obj);
                } else if ("viewer_has_pending_invite".equals(str)) {
                    m15040a(((Boolean) obj).booleanValue());
                } else if ("viewer_watch_status".equals(str)) {
                    m15038a((GraphQLEventWatchStatus) obj);
                }
            }

            public final boolean mo1097b() {
                a(0, 0);
                return this.f8968d;
            }

            @Nullable
            public final GraphQLConnectionStyle mo1101c() {
                this.f8969e = (GraphQLConnectionStyle) super.b(this.f8969e, 1, GraphQLConnectionStyle.class, GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8969e;
            }

            public final long mo1102d() {
                a(0, 2);
                return this.f8970f;
            }

            @Nullable
            private EventCoverPhotoModel m15041q() {
                this.f8971g = (EventCoverPhotoModel) super.a(this.f8971g, 3, EventCoverPhotoModel.class);
                return this.f8971g;
            }

            @Nullable
            private NewsFeedDefaultsEventPlaceFieldsModel m15042r() {
                this.f8972h = (NewsFeedDefaultsEventPlaceFieldsModel) super.a(this.f8972h, 4, NewsFeedDefaultsEventPlaceFieldsModel.class);
                return this.f8972h;
            }

            @Nullable
            public final String bt_() {
                this.f8973i = super.a(this.f8973i, 5);
                return this.f8973i;
            }

            public final boolean bu_() {
                a(0, 6);
                return this.f8974j;
            }

            @Nullable
            public final String mo1104j() {
                this.f8975k = super.a(this.f8975k, 7);
                return this.f8975k;
            }

            private void m15039a(@Nullable String str) {
                this.f8975k = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 7, str);
                }
            }

            public final long mo1105k() {
                a(1, 0);
                return this.f8976l;
            }

            @Nullable
            public final String mo1106l() {
                this.f8977m = super.a(this.f8977m, 9);
                return this.f8977m;
            }

            @Nullable
            public final String mo1107m() {
                this.f8978n = super.a(this.f8978n, 10);
                return this.f8978n;
            }

            @Nullable
            public final GraphQLEventGuestStatus mo1108n() {
                this.f8979o = (GraphQLEventGuestStatus) super.b(this.f8979o, 11, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8979o;
            }

            private void m15037a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
                this.f8979o = graphQLEventGuestStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 11, graphQLEventGuestStatus != null ? graphQLEventGuestStatus.name() : null);
                }
            }

            public final boolean mo1109o() {
                a(1, 4);
                return this.f8980p;
            }

            private void m15040a(boolean z) {
                this.f8980p = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 12, z);
                }
            }

            @Nullable
            public final GraphQLEventWatchStatus mo1110p() {
                this.f8981q = (GraphQLEventWatchStatus) super.b(this.f8981q, 13, GraphQLEventWatchStatus.class, GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8981q;
            }

            private void m15038a(GraphQLEventWatchStatus graphQLEventWatchStatus) {
                this.f8981q = graphQLEventWatchStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 13, graphQLEventWatchStatus != null ? graphQLEventWatchStatus.name() : null);
                }
            }

            @Nullable
            public final String m15045a() {
                return bt_();
            }

            public final int jK_() {
                return 67338874;
            }

            public final GraphQLVisitableModel m15044a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15041q() != null) {
                    EventCoverPhotoModel eventCoverPhotoModel = (EventCoverPhotoModel) graphQLModelMutatingVisitor.b(m15041q());
                    if (m15041q() != eventCoverPhotoModel) {
                        graphQLVisitableModel = (EventModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8971g = eventCoverPhotoModel;
                    }
                }
                if (m15042r() != null) {
                    NewsFeedDefaultsEventPlaceFieldsModel newsFeedDefaultsEventPlaceFieldsModel = (NewsFeedDefaultsEventPlaceFieldsModel) graphQLModelMutatingVisitor.b(m15042r());
                    if (m15042r() != newsFeedDefaultsEventPlaceFieldsModel) {
                        graphQLVisitableModel = (EventModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8972h = newsFeedDefaultsEventPlaceFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15043a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(mo1101c());
                int a2 = ModelHelper.a(flatBufferBuilder, m15041q());
                int a3 = ModelHelper.a(flatBufferBuilder, m15042r());
                int b = flatBufferBuilder.b(bt_());
                int b2 = flatBufferBuilder.b(mo1104j());
                int b3 = flatBufferBuilder.b(mo1106l());
                int b4 = flatBufferBuilder.b(mo1107m());
                int a4 = flatBufferBuilder.a(mo1108n());
                int a5 = flatBufferBuilder.a(mo1110p());
                flatBufferBuilder.c(14);
                flatBufferBuilder.a(0, this.f8968d);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.a(2, this.f8970f, 0);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, b);
                flatBufferBuilder.a(6, this.f8974j);
                flatBufferBuilder.b(7, b2);
                flatBufferBuilder.a(8, this.f8976l, 0);
                flatBufferBuilder.b(9, b3);
                flatBufferBuilder.b(10, b4);
                flatBufferBuilder.b(11, a4);
                flatBufferBuilder.a(12, this.f8980p);
                flatBufferBuilder.b(13, a5);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15046a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8968d = mutableFlatBuffer.a(i, 0);
                this.f8970f = mutableFlatBuffer.a(i, 2, 0);
                this.f8974j = mutableFlatBuffer.a(i, 6);
                this.f8976l = mutableFlatBuffer.a(i, 8, 0);
                this.f8980p = mutableFlatBuffer.a(i, 12);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1720292333)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private List<String> f8983d;
            @Nullable
            private CoverPhotoModel f8984e;
            private boolean f8985f;
            @Nullable
            private String f8986g;
            @Nullable
            private String f8987h;
            @Nullable
            private PageLikersModel f8988i;
            @Nullable
            private DefaultImageFieldsModel f8989j;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m15060a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NewsFeedDefaultsStoryActionLinkFieldsParser.PageParser.m15362a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_store_application */
            public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
                private int f8982d;

                /* compiled from: app_store_application */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
                    }

                    public Object m15061a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageLikersParser.m15360a(jsonParser, flatBufferBuilder));
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

                /* compiled from: app_store_application */
                public class Serializer extends JsonSerializer<PageLikersModel> {
                    public final void m15062a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageLikersModel pageLikersModel = (PageLikersModel) obj;
                        if (pageLikersModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageLikersModel.m15063a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageLikersParser.m15361a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator);
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

                public final GraphQLVisitableModel m15064a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15063a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f8982d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m15065a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f8982d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m15066a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m15075a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NewsFeedDefaultsStoryActionLinkFieldsParser.PageParser.m15363a(pageModel.w_(), pageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(7);
            }

            public final void m15079a(String str, ConsistencyTuple consistencyTuple) {
                if ("does_viewer_like".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m15070l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m15080a(String str, Object obj, boolean z) {
                if ("does_viewer_like".equals(str)) {
                    m15067a(((Boolean) obj).booleanValue());
                }
            }

            @Nonnull
            private ImmutableList<String> m15068j() {
                this.f8983d = super.a(this.f8983d, 0);
                return (ImmutableList) this.f8983d;
            }

            @Nullable
            private CoverPhotoModel m15069k() {
                this.f8984e = (CoverPhotoModel) super.a(this.f8984e, 1, CoverPhotoModel.class);
                return this.f8984e;
            }

            private boolean m15070l() {
                a(0, 2);
                return this.f8985f;
            }

            private void m15067a(boolean z) {
                this.f8985f = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, z);
                }
            }

            @Nullable
            private String m15071m() {
                this.f8986g = super.a(this.f8986g, 3);
                return this.f8986g;
            }

            @Nullable
            private String m15072n() {
                this.f8987h = super.a(this.f8987h, 4);
                return this.f8987h;
            }

            @Nullable
            private PageLikersModel m15073o() {
                this.f8988i = (PageLikersModel) super.a(this.f8988i, 5, PageLikersModel.class);
                return this.f8988i;
            }

            @Nullable
            private DefaultImageFieldsModel m15074p() {
                this.f8989j = (DefaultImageFieldsModel) super.a(this.f8989j, 6, DefaultImageFieldsModel.class);
                return this.f8989j;
            }

            @Nullable
            public final String m15077a() {
                return m15071m();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m15076a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15069k() != null) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m15069k());
                    if (m15069k() != coverPhotoModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8984e = coverPhotoModel;
                    }
                }
                if (m15073o() != null) {
                    PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m15073o());
                    if (m15073o() != pageLikersModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8988i = pageLikersModel;
                    }
                }
                if (m15074p() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15074p());
                    if (m15074p() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8989j = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15075a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int c = flatBufferBuilder.c(m15068j());
                int a = ModelHelper.a(flatBufferBuilder, m15069k());
                int b = flatBufferBuilder.b(m15071m());
                int b2 = flatBufferBuilder.b(m15072n());
                int a2 = ModelHelper.a(flatBufferBuilder, m15073o());
                int a3 = ModelHelper.a(flatBufferBuilder, m15074p());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, c);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.a(2, this.f8985f);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a2);
                flatBufferBuilder.b(6, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15078a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8985f = mutableFlatBuffer.a(i, 2);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1739105429)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class ParentStoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f8990d;
            @Nullable
            private String f8991e;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ParentStoryModel.class, new Deserializer());
                }

                public Object m15081a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ParentStoryParser.m15364a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object parentStoryModel = new ParentStoryModel();
                    ((BaseModel) parentStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (parentStoryModel instanceof Postprocessable) {
                        return ((Postprocessable) parentStoryModel).a();
                    }
                    return parentStoryModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<ParentStoryModel> {
                public final void m15082a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ParentStoryModel parentStoryModel = (ParentStoryModel) obj;
                    if (parentStoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(parentStoryModel.m15085a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        parentStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ParentStoryParser.m15365a(parentStoryModel.w_(), parentStoryModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ParentStoryModel.class, new Serializer());
                }
            }

            public ParentStoryModel() {
                super(2);
            }

            public final void m15088a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15089a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m15083j() {
                this.f8990d = super.a(this.f8990d, 0);
                return this.f8990d;
            }

            @Nullable
            private String m15084k() {
                this.f8991e = super.a(this.f8991e, 1);
                return this.f8991e;
            }

            @Nullable
            public final String m15087a() {
                return m15084k();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m15086a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15085a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15083j());
                int b2 = flatBufferBuilder.b(m15084k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1494953219)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class PrivacyScopeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DefaultIconFieldsModel f8992d;
            @Nullable
            private String f8993e;
            @Nullable
            private PrivacyOptionsFieldsModel f8994f;
            @Nullable
            private String f8995g;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacyScopeModel.class, new Deserializer());
                }

                public Object m15090a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyScopeParser.m15366a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object privacyScopeModel = new PrivacyScopeModel();
                    ((BaseModel) privacyScopeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (privacyScopeModel instanceof Postprocessable) {
                        return ((Postprocessable) privacyScopeModel).a();
                    }
                    return privacyScopeModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<PrivacyScopeModel> {
                public final void m15091a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) obj;
                    if (privacyScopeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacyScopeModel.m15096a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacyScopeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyScopeParser.m15367a(privacyScopeModel.w_(), privacyScopeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacyScopeModel.class, new Serializer());
                }
            }

            public PrivacyScopeModel() {
                super(4);
            }

            @Nullable
            private DefaultIconFieldsModel m15092a() {
                this.f8992d = (DefaultIconFieldsModel) super.a(this.f8992d, 0, DefaultIconFieldsModel.class);
                return this.f8992d;
            }

            @Nullable
            private String m15093j() {
                this.f8993e = super.a(this.f8993e, 1);
                return this.f8993e;
            }

            @Nullable
            private PrivacyOptionsFieldsModel m15094k() {
                this.f8994f = (PrivacyOptionsFieldsModel) super.a(this.f8994f, 2, PrivacyOptionsFieldsModel.class);
                return this.f8994f;
            }

            @Nullable
            private String m15095l() {
                this.f8995g = super.a(this.f8995g, 3);
                return this.f8995g;
            }

            public final int jK_() {
                return -476351540;
            }

            public final GraphQLVisitableModel m15097a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15092a() != null) {
                    DefaultIconFieldsModel defaultIconFieldsModel = (DefaultIconFieldsModel) graphQLModelMutatingVisitor.b(m15092a());
                    if (m15092a() != defaultIconFieldsModel) {
                        graphQLVisitableModel = (PrivacyScopeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8992d = defaultIconFieldsModel;
                    }
                }
                if (m15094k() != null) {
                    PrivacyOptionsFieldsModel privacyOptionsFieldsModel = (PrivacyOptionsFieldsModel) graphQLModelMutatingVisitor.b(m15094k());
                    if (m15094k() != privacyOptionsFieldsModel) {
                        graphQLVisitableModel = (PrivacyScopeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8994f = privacyOptionsFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15096a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15092a());
                int b = flatBufferBuilder.b(m15093j());
                int a2 = ModelHelper.a(flatBufferBuilder, m15094k());
                int b2 = flatBufferBuilder.b(m15095l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1117412694)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class ProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f8997d;
            private boolean f8998e;
            @Nullable
            private String f8999f;
            @Nullable
            private String f9000g;
            @Nullable
            private ProfilePictureModel f9001h;
            @Nullable
            private GraphQLSubscribeStatus f9002i;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileModel.class, new Deserializer());
                }

                public Object m15098a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileParser.m15370a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileModel = new ProfileModel();
                    ((BaseModel) profileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileModel instanceof Postprocessable) {
                        return ((Postprocessable) profileModel).a();
                    }
                    return profileModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_store_application */
            public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8996d;

                /* compiled from: app_store_application */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                    }

                    public Object m15099a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfilePictureParser.m15368a(jsonParser, flatBufferBuilder));
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

                /* compiled from: app_store_application */
                public class Serializer extends JsonSerializer<ProfilePictureModel> {
                    public final void m15100a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                        if (profilePictureModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(profilePictureModel.m15102a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfilePictureParser.m15369a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                    }
                }

                public ProfilePictureModel() {
                    super(1);
                }

                @Nullable
                private String m15101a() {
                    this.f8996d = super.a(this.f8996d, 0);
                    return this.f8996d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m15103a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15102a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15101a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<ProfileModel> {
                public final void m15104a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileModel profileModel = (ProfileModel) obj;
                    if (profileModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileModel.m15113a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileParser.m15371a(profileModel.w_(), profileModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileModel.class, new Serializer());
                }
            }

            public ProfileModel() {
                super(6);
            }

            public final void m15117a(String str, ConsistencyTuple consistencyTuple) {
                if ("does_viewer_like".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m15108k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else if ("subscribe_status".equals(str)) {
                    consistencyTuple.a = m15112o();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 5;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m15118a(String str, Object obj, boolean z) {
                if ("does_viewer_like".equals(str)) {
                    m15106a(((Boolean) obj).booleanValue());
                } else if ("subscribe_status".equals(str)) {
                    m15105a((GraphQLSubscribeStatus) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m15107j() {
                if (this.b != null && this.f8997d == null) {
                    this.f8997d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8997d;
            }

            private boolean m15108k() {
                a(0, 1);
                return this.f8998e;
            }

            private void m15106a(boolean z) {
                this.f8998e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            @Nullable
            private String m15109l() {
                this.f8999f = super.a(this.f8999f, 2);
                return this.f8999f;
            }

            @Nullable
            private String m15110m() {
                this.f9000g = super.a(this.f9000g, 3);
                return this.f9000g;
            }

            @Nullable
            private ProfilePictureModel m15111n() {
                this.f9001h = (ProfilePictureModel) super.a(this.f9001h, 4, ProfilePictureModel.class);
                return this.f9001h;
            }

            @Nullable
            private GraphQLSubscribeStatus m15112o() {
                this.f9002i = (GraphQLSubscribeStatus) super.b(this.f9002i, 5, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9002i;
            }

            private void m15105a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                this.f9002i = graphQLSubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 5, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                }
            }

            @Nullable
            public final String m15115a() {
                return m15109l();
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m15114a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15111n() != null) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m15111n());
                    if (m15111n() != profilePictureModel) {
                        graphQLVisitableModel = (ProfileModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9001h = profilePictureModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15113a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15107j());
                int b = flatBufferBuilder.b(m15109l());
                int b2 = flatBufferBuilder.b(m15110m());
                int a2 = ModelHelper.a(flatBufferBuilder, m15111n());
                int a3 = flatBufferBuilder.a(m15112o());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f8998e);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15116a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8998e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<NewsFeedDefaultsStoryActionLinkFieldsModel> {
            public final void m15119a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NewsFeedDefaultsStoryActionLinkFieldsModel newsFeedDefaultsStoryActionLinkFieldsModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) obj;
                if (newsFeedDefaultsStoryActionLinkFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(newsFeedDefaultsStoryActionLinkFieldsModel.m15186a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    newsFeedDefaultsStoryActionLinkFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NewsFeedDefaultsStoryActionLinkFieldsParser.m15381b(newsFeedDefaultsStoryActionLinkFieldsModel.w_(), newsFeedDefaultsStoryActionLinkFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NewsFeedDefaultsStoryActionLinkFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1728959214)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class TaggedAndMentionedUsersModel extends BaseModel implements GraphQLVisitableModel {
            private int f9005d;
            @Nullable
            private List<NodesModel> f9006e;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TaggedAndMentionedUsersModel.class, new Deserializer());
                }

                public Object m15120a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TaggedAndMentionedUsersParser.m15374a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object taggedAndMentionedUsersModel = new TaggedAndMentionedUsersModel();
                    ((BaseModel) taggedAndMentionedUsersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (taggedAndMentionedUsersModel instanceof Postprocessable) {
                        return ((Postprocessable) taggedAndMentionedUsersModel).a();
                    }
                    return taggedAndMentionedUsersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1185712657)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_store_application */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f9003d;
                @Nullable
                private String f9004e;

                /* compiled from: app_store_application */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m15121a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m15373b(jsonParser, flatBufferBuilder));
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

                /* compiled from: app_store_application */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m15122a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m15125a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m15372a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                public final void m15128a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m15129a(String str, Object obj, boolean z) {
                }

                @Nullable
                private String m15123j() {
                    this.f9003d = super.a(this.f9003d, 0);
                    return this.f9003d;
                }

                @Nullable
                private String m15124k() {
                    this.f9004e = super.a(this.f9004e, 1);
                    return this.f9004e;
                }

                @Nullable
                public final String m15127a() {
                    return m15123j();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m15126a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15125a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15123j());
                    int b2 = flatBufferBuilder.b(m15124k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<TaggedAndMentionedUsersModel> {
                public final void m15130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TaggedAndMentionedUsersModel taggedAndMentionedUsersModel = (TaggedAndMentionedUsersModel) obj;
                    if (taggedAndMentionedUsersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(taggedAndMentionedUsersModel.m15132a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        taggedAndMentionedUsersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TaggedAndMentionedUsersParser.m15375a(taggedAndMentionedUsersModel.w_(), taggedAndMentionedUsersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TaggedAndMentionedUsersModel.class, new Serializer());
                }
            }

            public TaggedAndMentionedUsersModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<NodesModel> m15131a() {
                this.f9006e = super.a(this.f9006e, 1, NodesModel.class);
                return (ImmutableList) this.f9006e;
            }

            public final int jK_() {
                return -262754594;
            }

            public final GraphQLVisitableModel m15133a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15131a() != null) {
                    Builder a = ModelHelper.a(m15131a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TaggedAndMentionedUsersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9006e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15132a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15131a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f9005d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15134a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9005d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1466269706)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class TopicModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f9007d;
            @Nullable
            private String f9008e;
            @Nullable
            private String f9009f;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TopicModel.class, new Deserializer());
                }

                public Object m15135a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TopicParser.m15376a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object topicModel = new TopicModel();
                    ((BaseModel) topicModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (topicModel instanceof Postprocessable) {
                        return ((Postprocessable) topicModel).a();
                    }
                    return topicModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<TopicModel> {
                public final void m15136a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TopicModel topicModel = (TopicModel) obj;
                    if (topicModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(topicModel.m15140a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        topicModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TopicParser.m15377a(topicModel.w_(), topicModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TopicModel.class, new Serializer());
                }
            }

            public TopicModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m15137a() {
                if (this.b != null && this.f9007d == null) {
                    this.f9007d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9007d;
            }

            @Nullable
            private String m15138j() {
                this.f9008e = super.a(this.f9008e, 1);
                return this.f9008e;
            }

            @Nullable
            private String m15139k() {
                this.f9009f = super.a(this.f9009f, 2);
                return this.f9009f;
            }

            public final int jK_() {
                return 80993551;
            }

            public final GraphQLVisitableModel m15141a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15140a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15137a());
                int b = flatBufferBuilder.b(m15138j());
                int b2 = flatBufferBuilder.b(m15139k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public NewsFeedDefaultsStoryActionLinkFieldsModel() {
            super(86);
        }

        @Nullable
        private GraphQLObjectType m15168a() {
            if (this.b != null && this.f9036d == null) {
                this.f9036d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9036d;
        }

        @Nullable
        private GraphQLProfilePictureActionLinkType m15169j() {
            this.f9037e = (GraphQLProfilePictureActionLinkType) super.b(this.f9037e, 1, GraphQLProfilePictureActionLinkType.class, GraphQLProfilePictureActionLinkType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9037e;
        }

        @Nullable
        private String m15170k() {
            this.f9038f = super.a(this.f9038f, 2);
            return this.f9038f;
        }

        @Nullable
        private String m15171l() {
            this.f9039g = super.a(this.f9039g, 3);
            return this.f9039g;
        }

        @Nullable
        private DescriptionModel m15172m() {
            this.f9045m = (DescriptionModel) super.a(this.f9045m, 9, DescriptionModel.class);
            return this.f9045m;
        }

        @Nullable
        private GraphQLStoryActionLinkDestinationType m15173n() {
            this.f9046n = (GraphQLStoryActionLinkDestinationType) super.b(this.f9046n, 10, GraphQLStoryActionLinkDestinationType.class, GraphQLStoryActionLinkDestinationType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9046n;
        }

        @Nullable
        private String m15174o() {
            this.f9047o = super.a(this.f9047o, 11);
            return this.f9047o;
        }

        @Nullable
        private String m15175p() {
            this.f9048p = super.a(this.f9048p, 12);
            return this.f9048p;
        }

        @Nonnull
        private ImmutableList<ErrorCodesModel> m15176q() {
            this.f9049q = super.a(this.f9049q, 13, ErrorCodesModel.class);
            return (ImmutableList) this.f9049q;
        }

        @Nullable
        private String m15177r() {
            this.f9050r = super.a(this.f9050r, 14);
            return this.f9050r;
        }

        @Nullable
        private String m15178s() {
            this.f9051s = super.a(this.f9051s, 15);
            return this.f9051s;
        }

        @Nullable
        private EventModel m15179t() {
            this.f9052t = (EventModel) super.a(this.f9052t, 16, EventModel.class);
            return this.f9052t;
        }

        @Nullable
        private String m15180u() {
            this.f9053u = super.a(this.f9053u, 17);
            return this.f9053u;
        }

        @Nullable
        private String m15181v() {
            this.f9054v = super.a(this.f9054v, 18);
            return this.f9054v;
        }

        @Nullable
        private FeaturedInstantArticleElementModel m15182w() {
            this.f9055w = (FeaturedInstantArticleElementModel) super.a(this.f9055w, 19, FeaturedInstantArticleElementModel.class);
            return this.f9055w;
        }

        @Nullable
        private FeedbackModel m15183x() {
            this.f9056x = (FeedbackModel) super.a(this.f9056x, 20, FeedbackModel.class);
            return this.f9056x;
        }

        @Nullable
        private String m15184y() {
            this.f9057y = super.a(this.f9057y, 21);
            return this.f9057y;
        }

        @Nullable
        private String m15185z() {
            this.f9058z = super.a(this.f9058z, 22);
            return this.f9058z;
        }

        @Nonnull
        private ImmutableList<String> m15142A() {
            this.f9010A = super.a(this.f9010A, 23);
            return (ImmutableList) this.f9010A;
        }

        @Nullable
        private String m15143B() {
            this.f9011B = super.a(this.f9011B, 24);
            return this.f9011B;
        }

        @Nullable
        private String m15144C() {
            this.f9012C = super.a(this.f9012C, 25);
            return this.f9012C;
        }

        @Nullable
        private String m15145D() {
            this.f9013D = super.a(this.f9013D, 26);
            return this.f9013D;
        }

        @Nullable
        private InfoModel m15146E() {
            this.f9014E = (InfoModel) super.a(this.f9014E, 27, InfoModel.class);
            return this.f9014E;
        }

        @Nullable
        private InstantArticleModel m15147F() {
            this.f9015F = (InstantArticleModel) super.a(this.f9015F, 28, InstantArticleModel.class);
            return this.f9015F;
        }

        @Nullable
        private DefaultSavableObjectExtraFieldsModel m15148G() {
            this.f9016G = (DefaultSavableObjectExtraFieldsModel) super.a(this.f9016G, 29, DefaultSavableObjectExtraFieldsModel.class);
            return this.f9016G;
        }

        @Nullable
        private String m15149H() {
            this.f9017H = super.a(this.f9017H, 30);
            return this.f9017H;
        }

        @Nullable
        private String m15150I() {
            this.f9018I = super.a(this.f9018I, 31);
            return this.f9018I;
        }

        @Nullable
        private LeadGenDataModel m15151J() {
            this.f9019J = (LeadGenDataModel) super.a(this.f9019J, 32, LeadGenDataModel.class);
            return this.f9019J;
        }

        @Nullable
        private String m15152K() {
            this.f9020K = super.a(this.f9020K, 33);
            return this.f9020K;
        }

        @Nullable
        private LeadGenDeepLinkUserStatusFieldsModel m15153L() {
            this.f9021L = (LeadGenDeepLinkUserStatusFieldsModel) super.a(this.f9021L, 34, LeadGenDeepLinkUserStatusFieldsModel.class);
            return this.f9021L;
        }

        @Nullable
        private LeadGenUserStatusModel m15154M() {
            this.f9022M = (LeadGenUserStatusModel) super.a(this.f9022M, 35, LeadGenUserStatusModel.class);
            return this.f9022M;
        }

        @Nullable
        private String m15155N() {
            this.f9023N = super.a(this.f9023N, 36);
            return this.f9023N;
        }

        @Nullable
        private String m15156O() {
            this.f9024O = super.a(this.f9024O, 37);
            return this.f9024O;
        }

        @Nullable
        private DefaultImageFieldsModel m15157P() {
            this.f9025P = (DefaultImageFieldsModel) super.a(this.f9025P, 38, DefaultImageFieldsModel.class);
            return this.f9025P;
        }

        @Nullable
        private GraphQLCallToActionStyle m15158Q() {
            this.f9026Q = (GraphQLCallToActionStyle) super.b(this.f9026Q, 39, GraphQLCallToActionStyle.class, GraphQLCallToActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9026Q;
        }

        @Nullable
        private LinkTargetStoreDataFragModel m15159R() {
            this.f9027R = (LinkTargetStoreDataFragModel) super.a(this.f9027R, 40, LinkTargetStoreDataFragModel.class);
            return this.f9027R;
        }

        @Nullable
        private String m15160S() {
            this.f9028S = super.a(this.f9028S, 41);
            return this.f9028S;
        }

        @Nullable
        private GraphQLCallToActionType m15161T() {
            this.f9029T = (GraphQLCallToActionType) super.b(this.f9029T, 42, GraphQLCallToActionType.class, GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9029T;
        }

        @Nullable
        private DefaultImageFieldsModel m15162U() {
            this.f9030U = (DefaultImageFieldsModel) super.a(this.f9030U, 43, DefaultImageFieldsModel.class);
            return this.f9030U;
        }

        @Nullable
        private String m15163V() {
            this.f9031V = super.a(this.f9031V, 44);
            return this.f9031V;
        }

        @Nonnull
        private ImmutableList<String> m15164W() {
            this.f9032W = super.a(this.f9032W, 45);
            return (ImmutableList) this.f9032W;
        }

        @Nullable
        private String m15165X() {
            this.f9033X = super.a(this.f9033X, 46);
            return this.f9033X;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m15166Y() {
            this.f9034Y = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9034Y, 47, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f9034Y;
        }

        @Nullable
        private String m15167Z() {
            this.f9035Z = super.a(this.f9035Z, 48);
            return this.f9035Z;
        }

        @Nullable
        private String aa() {
            this.aa = super.a(this.aa, 49);
            return this.aa;
        }

        @Nullable
        private PageModel ab() {
            this.ab = (PageModel) super.a(this.ab, 50, PageModel.class);
            return this.ab;
        }

        @Nullable
        private PageOutcomeButtonModel ac() {
            this.ac = (PageOutcomeButtonModel) super.a(this.ac, 51, PageOutcomeButtonModel.class);
            return this.ac;
        }

        @Nullable
        private ParentStoryModel ad() {
            this.ad = (ParentStoryModel) super.a(this.ad, 52, ParentStoryModel.class);
            return this.ad;
        }

        @Nullable
        private String ae() {
            this.ae = super.a(this.ae, 53);
            return this.ae;
        }

        @Nullable
        private String af() {
            this.af = super.a(this.af, 54);
            return this.af;
        }

        @Nullable
        private PrivacyScopeModel ag() {
            this.ag = (PrivacyScopeModel) super.a(this.ag, 55, PrivacyScopeModel.class);
            return this.ag;
        }

        @Nullable
        private String ah() {
            this.ah = super.a(this.ah, 56);
            return this.ah;
        }

        @Nullable
        private ProfileModel ai() {
            this.ai = (ProfileModel) super.a(this.ai, 57, ProfileModel.class);
            return this.ai;
        }

        @Nullable
        private String aj() {
            this.aj = super.a(this.aj, 58);
            return this.aj;
        }

        @Nullable
        private String ak() {
            this.ak = super.a(this.ak, 59);
            return this.ak;
        }

        @Nullable
        private String al() {
            this.al = super.a(this.al, 60);
            return this.al;
        }

        @Nullable
        private ReviewModel am() {
            this.an = (ReviewModel) super.a(this.an, 62, ReviewModel.class);
            return this.an;
        }

        @Nullable
        private String an() {
            this.ao = super.a(this.ao, 63);
            return this.ao;
        }

        @Nullable
        private String ao() {
            this.ap = super.a(this.ap, 64);
            return this.ap;
        }

        @Nullable
        private String ap() {
            this.aq = super.a(this.aq, 65);
            return this.aq;
        }

        @Nullable
        private String aq() {
            this.ar = super.a(this.ar, 66);
            return this.ar;
        }

        @Nullable
        private String ar() {
            this.as = super.a(this.as, 67);
            return this.as;
        }

        @Nullable
        private String as() {
            this.at = super.a(this.at, 68);
            return this.at;
        }

        @Nullable
        private String at() {
            this.ay = super.a(this.ay, 73);
            return this.ay;
        }

        @Nullable
        private String au() {
            this.az = super.a(this.az, 74);
            return this.az;
        }

        @Nullable
        private String av() {
            this.aA = super.a(this.aA, 75);
            return this.aA;
        }

        @Nullable
        private ImageOverlayFieldsModel aw() {
            this.aB = (ImageOverlayFieldsModel) super.a(this.aB, 76, ImageOverlayFieldsModel.class);
            return this.aB;
        }

        @Nullable
        private StoryModel ax() {
            this.aC = (StoryModel) super.a(this.aC, 77, StoryModel.class);
            return this.aC;
        }

        @Nullable
        private String ay() {
            this.aD = super.a(this.aD, 78);
            return this.aD;
        }

        @Nullable
        private TaggedAndMentionedUsersModel az() {
            this.aE = (TaggedAndMentionedUsersModel) super.a(this.aE, 79, TaggedAndMentionedUsersModel.class);
            return this.aE;
        }

        @Nullable
        private TemporalEventInfoModel aA() {
            this.aF = (TemporalEventInfoModel) super.a(this.aF, 80, TemporalEventInfoModel.class);
            return this.aF;
        }

        @Nullable
        private String aB() {
            this.aG = super.a(this.aG, 81);
            return this.aG;
        }

        @Nullable
        private TopicModel aC() {
            this.aH = (TopicModel) super.a(this.aH, 82, TopicModel.class);
            return this.aH;
        }

        @Nullable
        private String aD() {
            this.aI = super.a(this.aI, 83);
            return this.aI;
        }

        @Nullable
        private String aE() {
            this.aJ = super.a(this.aJ, 84);
            return this.aJ;
        }

        @Nonnull
        private ImmutableList<VideoAnnotationFieldsModel> aF() {
            this.aK = super.a(this.aK, 85, VideoAnnotationFieldsModel.class);
            return (ImmutableList) this.aK;
        }

        public final int jK_() {
            return -1747569147;
        }

        public final GraphQLVisitableModel m15187a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15172m() != null) {
                DescriptionModel descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m15172m());
                if (m15172m() != descriptionModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9045m = descriptionModel;
                }
            }
            if (m15176q() != null) {
                a = ModelHelper.a(m15176q(), graphQLModelMutatingVisitor);
                if (a != null) {
                    NewsFeedDefaultsStoryActionLinkFieldsModel newsFeedDefaultsStoryActionLinkFieldsModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    newsFeedDefaultsStoryActionLinkFieldsModel.f9049q = a.b();
                    graphQLVisitableModel = newsFeedDefaultsStoryActionLinkFieldsModel;
                }
            }
            if (m15179t() != null) {
                EventModel eventModel = (EventModel) graphQLModelMutatingVisitor.b(m15179t());
                if (m15179t() != eventModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9052t = eventModel;
                }
            }
            if (m15182w() != null) {
                FeaturedInstantArticleElementModel featuredInstantArticleElementModel = (FeaturedInstantArticleElementModel) graphQLModelMutatingVisitor.b(m15182w());
                if (m15182w() != featuredInstantArticleElementModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9055w = featuredInstantArticleElementModel;
                }
            }
            if (m15183x() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m15183x());
                if (m15183x() != feedbackModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9056x = feedbackModel;
                }
            }
            if (m15146E() != null) {
                InfoModel infoModel = (InfoModel) graphQLModelMutatingVisitor.b(m15146E());
                if (m15146E() != infoModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9014E = infoModel;
                }
            }
            if (m15147F() != null) {
                InstantArticleModel instantArticleModel = (InstantArticleModel) graphQLModelMutatingVisitor.b(m15147F());
                if (m15147F() != instantArticleModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9015F = instantArticleModel;
                }
            }
            if (m15148G() != null) {
                DefaultSavableObjectExtraFieldsModel defaultSavableObjectExtraFieldsModel = (DefaultSavableObjectExtraFieldsModel) graphQLModelMutatingVisitor.b(m15148G());
                if (m15148G() != defaultSavableObjectExtraFieldsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9016G = defaultSavableObjectExtraFieldsModel;
                }
            }
            if (m15151J() != null) {
                LeadGenDataModel leadGenDataModel = (LeadGenDataModel) graphQLModelMutatingVisitor.b(m15151J());
                if (m15151J() != leadGenDataModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9019J = leadGenDataModel;
                }
            }
            if (m15153L() != null) {
                LeadGenDeepLinkUserStatusFieldsModel leadGenDeepLinkUserStatusFieldsModel = (LeadGenDeepLinkUserStatusFieldsModel) graphQLModelMutatingVisitor.b(m15153L());
                if (m15153L() != leadGenDeepLinkUserStatusFieldsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9021L = leadGenDeepLinkUserStatusFieldsModel;
                }
            }
            if (m15154M() != null) {
                LeadGenUserStatusModel leadGenUserStatusModel = (LeadGenUserStatusModel) graphQLModelMutatingVisitor.b(m15154M());
                if (m15154M() != leadGenUserStatusModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9022M = leadGenUserStatusModel;
                }
            }
            if (m15157P() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15157P());
                if (m15157P() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9025P = defaultImageFieldsModel;
                }
            }
            if (m15159R() != null) {
                LinkTargetStoreDataFragModel linkTargetStoreDataFragModel = (LinkTargetStoreDataFragModel) graphQLModelMutatingVisitor.b(m15159R());
                if (m15159R() != linkTargetStoreDataFragModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9027R = linkTargetStoreDataFragModel;
                }
            }
            if (m15162U() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15162U());
                if (m15162U() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9030U = defaultImageFieldsModel;
                }
            }
            if (m15166Y() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15166Y());
                if (m15166Y() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9034Y = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (ab() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(ab());
                if (ab() != pageModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ab = pageModel;
                }
            }
            if (ac() != null) {
                PageOutcomeButtonModel pageOutcomeButtonModel = (PageOutcomeButtonModel) graphQLModelMutatingVisitor.b(ac());
                if (ac() != pageOutcomeButtonModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ac = pageOutcomeButtonModel;
                }
            }
            if (ad() != null) {
                ParentStoryModel parentStoryModel = (ParentStoryModel) graphQLModelMutatingVisitor.b(ad());
                if (ad() != parentStoryModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ad = parentStoryModel;
                }
            }
            if (ag() != null) {
                PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) graphQLModelMutatingVisitor.b(ag());
                if (ag() != privacyScopeModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ag = privacyScopeModel;
                }
            }
            if (ai() != null) {
                ProfileModel profileModel = (ProfileModel) graphQLModelMutatingVisitor.b(ai());
                if (ai() != profileModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ai = profileModel;
                }
            }
            if (am() != null) {
                ReviewModel reviewModel = (ReviewModel) graphQLModelMutatingVisitor.b(am());
                if (am() != reviewModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.an = reviewModel;
                }
            }
            if (aw() != null) {
                ImageOverlayFieldsModel imageOverlayFieldsModel = (ImageOverlayFieldsModel) graphQLModelMutatingVisitor.b(aw());
                if (aw() != imageOverlayFieldsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aB = imageOverlayFieldsModel;
                }
            }
            if (ax() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(ax());
                if (ax() != storyModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aC = storyModel;
                }
            }
            if (az() != null) {
                TaggedAndMentionedUsersModel taggedAndMentionedUsersModel = (TaggedAndMentionedUsersModel) graphQLModelMutatingVisitor.b(az());
                if (az() != taggedAndMentionedUsersModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aE = taggedAndMentionedUsersModel;
                }
            }
            if (aA() != null) {
                TemporalEventInfoModel temporalEventInfoModel = (TemporalEventInfoModel) graphQLModelMutatingVisitor.b(aA());
                if (aA() != temporalEventInfoModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aF = temporalEventInfoModel;
                }
            }
            if (aC() != null) {
                TopicModel topicModel = (TopicModel) graphQLModelMutatingVisitor.b(aC());
                if (aC() != topicModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aH = topicModel;
                }
            }
            if (aF() != null) {
                a = ModelHelper.a(aF(), graphQLModelMutatingVisitor);
                if (a != null) {
                    newsFeedDefaultsStoryActionLinkFieldsModel = (NewsFeedDefaultsStoryActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    newsFeedDefaultsStoryActionLinkFieldsModel.aK = a.b();
                    graphQLVisitableModel = newsFeedDefaultsStoryActionLinkFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15186a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15168a());
            int a2 = flatBufferBuilder.a(m15169j());
            int b = flatBufferBuilder.b(m15170k());
            int b2 = flatBufferBuilder.b(m15171l());
            int a3 = ModelHelper.a(flatBufferBuilder, m15172m());
            int a4 = flatBufferBuilder.a(m15173n());
            int b3 = flatBufferBuilder.b(m15174o());
            int b4 = flatBufferBuilder.b(m15175p());
            int a5 = ModelHelper.a(flatBufferBuilder, m15176q());
            int b5 = flatBufferBuilder.b(m15177r());
            int b6 = flatBufferBuilder.b(m15178s());
            int a6 = ModelHelper.a(flatBufferBuilder, m15179t());
            int b7 = flatBufferBuilder.b(m15180u());
            int b8 = flatBufferBuilder.b(m15181v());
            int a7 = ModelHelper.a(flatBufferBuilder, m15182w());
            int a8 = ModelHelper.a(flatBufferBuilder, m15183x());
            int b9 = flatBufferBuilder.b(m15184y());
            int b10 = flatBufferBuilder.b(m15185z());
            int c = flatBufferBuilder.c(m15142A());
            int b11 = flatBufferBuilder.b(m15143B());
            int b12 = flatBufferBuilder.b(m15144C());
            int b13 = flatBufferBuilder.b(m15145D());
            int a9 = ModelHelper.a(flatBufferBuilder, m15146E());
            int a10 = ModelHelper.a(flatBufferBuilder, m15147F());
            int a11 = ModelHelper.a(flatBufferBuilder, m15148G());
            int b14 = flatBufferBuilder.b(m15149H());
            int b15 = flatBufferBuilder.b(m15150I());
            int a12 = ModelHelper.a(flatBufferBuilder, m15151J());
            int b16 = flatBufferBuilder.b(m15152K());
            int a13 = ModelHelper.a(flatBufferBuilder, m15153L());
            int a14 = ModelHelper.a(flatBufferBuilder, m15154M());
            int b17 = flatBufferBuilder.b(m15155N());
            int b18 = flatBufferBuilder.b(m15156O());
            int a15 = ModelHelper.a(flatBufferBuilder, m15157P());
            int a16 = flatBufferBuilder.a(m15158Q());
            int a17 = ModelHelper.a(flatBufferBuilder, m15159R());
            int b19 = flatBufferBuilder.b(m15160S());
            int a18 = flatBufferBuilder.a(m15161T());
            int a19 = ModelHelper.a(flatBufferBuilder, m15162U());
            int b20 = flatBufferBuilder.b(m15163V());
            int c2 = flatBufferBuilder.c(m15164W());
            int b21 = flatBufferBuilder.b(m15165X());
            int a20 = ModelHelper.a(flatBufferBuilder, m15166Y());
            int b22 = flatBufferBuilder.b(m15167Z());
            int b23 = flatBufferBuilder.b(aa());
            int a21 = ModelHelper.a(flatBufferBuilder, ab());
            int a22 = ModelHelper.a(flatBufferBuilder, ac());
            int a23 = ModelHelper.a(flatBufferBuilder, ad());
            int b24 = flatBufferBuilder.b(ae());
            int b25 = flatBufferBuilder.b(af());
            int a24 = ModelHelper.a(flatBufferBuilder, ag());
            int b26 = flatBufferBuilder.b(ah());
            int a25 = ModelHelper.a(flatBufferBuilder, ai());
            int b27 = flatBufferBuilder.b(aj());
            int b28 = flatBufferBuilder.b(ak());
            int b29 = flatBufferBuilder.b(al());
            int a26 = ModelHelper.a(flatBufferBuilder, am());
            int b30 = flatBufferBuilder.b(an());
            int b31 = flatBufferBuilder.b(ao());
            int b32 = flatBufferBuilder.b(ap());
            int b33 = flatBufferBuilder.b(aq());
            int b34 = flatBufferBuilder.b(ar());
            int b35 = flatBufferBuilder.b(as());
            int b36 = flatBufferBuilder.b(at());
            int b37 = flatBufferBuilder.b(au());
            int b38 = flatBufferBuilder.b(av());
            int a27 = ModelHelper.a(flatBufferBuilder, aw());
            int a28 = ModelHelper.a(flatBufferBuilder, ax());
            int b39 = flatBufferBuilder.b(ay());
            int a29 = ModelHelper.a(flatBufferBuilder, az());
            int a30 = ModelHelper.a(flatBufferBuilder, aA());
            int b40 = flatBufferBuilder.b(aB());
            int a31 = ModelHelper.a(flatBufferBuilder, aC());
            int b41 = flatBufferBuilder.b(aD());
            int b42 = flatBufferBuilder.b(aE());
            int a32 = ModelHelper.a(flatBufferBuilder, aF());
            flatBufferBuilder.c(86);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.a(4, this.f9040h, 0);
            flatBufferBuilder.a(5, this.f9041i, 0);
            flatBufferBuilder.a(6, this.f9042j);
            flatBufferBuilder.a(7, this.f9043k);
            flatBufferBuilder.a(8, this.f9044l, 0);
            flatBufferBuilder.b(9, a3);
            flatBufferBuilder.b(10, a4);
            flatBufferBuilder.b(11, b3);
            flatBufferBuilder.b(12, b4);
            flatBufferBuilder.b(13, a5);
            flatBufferBuilder.b(14, b5);
            flatBufferBuilder.b(15, b6);
            flatBufferBuilder.b(16, a6);
            flatBufferBuilder.b(17, b7);
            flatBufferBuilder.b(18, b8);
            flatBufferBuilder.b(19, a7);
            flatBufferBuilder.b(20, a8);
            flatBufferBuilder.b(21, b9);
            flatBufferBuilder.b(22, b10);
            flatBufferBuilder.b(23, c);
            flatBufferBuilder.b(24, b11);
            flatBufferBuilder.b(25, b12);
            flatBufferBuilder.b(26, b13);
            flatBufferBuilder.b(27, a9);
            flatBufferBuilder.b(28, a10);
            flatBufferBuilder.b(29, a11);
            flatBufferBuilder.b(30, b14);
            flatBufferBuilder.b(31, b15);
            flatBufferBuilder.b(32, a12);
            flatBufferBuilder.b(33, b16);
            flatBufferBuilder.b(34, a13);
            flatBufferBuilder.b(35, a14);
            flatBufferBuilder.b(36, b17);
            flatBufferBuilder.b(37, b18);
            flatBufferBuilder.b(38, a15);
            flatBufferBuilder.b(39, a16);
            flatBufferBuilder.b(40, a17);
            flatBufferBuilder.b(41, b19);
            flatBufferBuilder.b(42, a18);
            flatBufferBuilder.b(43, a19);
            flatBufferBuilder.b(44, b20);
            flatBufferBuilder.b(45, c2);
            flatBufferBuilder.b(46, b21);
            flatBufferBuilder.b(47, a20);
            flatBufferBuilder.b(48, b22);
            flatBufferBuilder.b(49, b23);
            flatBufferBuilder.b(50, a21);
            flatBufferBuilder.b(51, a22);
            flatBufferBuilder.b(52, a23);
            flatBufferBuilder.b(53, b24);
            flatBufferBuilder.b(54, b25);
            flatBufferBuilder.b(55, a24);
            flatBufferBuilder.b(56, b26);
            flatBufferBuilder.b(57, a25);
            flatBufferBuilder.b(58, b27);
            flatBufferBuilder.b(59, b28);
            flatBufferBuilder.b(60, b29);
            flatBufferBuilder.a(61, this.am, 0);
            flatBufferBuilder.b(62, a26);
            flatBufferBuilder.b(63, b30);
            flatBufferBuilder.b(64, b31);
            flatBufferBuilder.b(65, b32);
            flatBufferBuilder.b(66, b33);
            flatBufferBuilder.b(67, b34);
            flatBufferBuilder.b(68, b35);
            flatBufferBuilder.a(69, this.au);
            flatBufferBuilder.a(70, this.av);
            flatBufferBuilder.a(71, this.aw);
            flatBufferBuilder.a(72, this.ax);
            flatBufferBuilder.b(73, b36);
            flatBufferBuilder.b(74, b37);
            flatBufferBuilder.b(75, b38);
            flatBufferBuilder.b(76, a27);
            flatBufferBuilder.b(77, a28);
            flatBufferBuilder.b(78, b39);
            flatBufferBuilder.b(79, a29);
            flatBufferBuilder.b(80, a30);
            flatBufferBuilder.b(81, b40);
            flatBufferBuilder.b(82, a31);
            flatBufferBuilder.b(83, b41);
            flatBufferBuilder.b(84, b42);
            flatBufferBuilder.b(85, a32);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15188a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9040h = mutableFlatBuffer.a(i, 4, 0);
            this.f9041i = mutableFlatBuffer.a(i, 5, 0);
            this.f9042j = mutableFlatBuffer.a(i, 6);
            this.f9043k = mutableFlatBuffer.a(i, 7);
            this.f9044l = mutableFlatBuffer.a(i, 8, 0);
            this.am = mutableFlatBuffer.a(i, 61, 0);
            this.au = mutableFlatBuffer.a(i, 69);
            this.av = mutableFlatBuffer.a(i, 70);
            this.aw = mutableFlatBuffer.a(i, 71);
            this.ax = mutableFlatBuffer.a(i, 72);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 743886402)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class OverlayActionLinkFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DescriptionModel f9069d;
        @Nullable
        private InfoModel f9070e;
        @Nullable
        private String f9071f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class DescriptionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9059d;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DescriptionModel.class, new Deserializer());
                }

                public Object m15189a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OverlayActionLinkFieldsParser.DescriptionParser.m15382a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object descriptionModel = new DescriptionModel();
                    ((BaseModel) descriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (descriptionModel instanceof Postprocessable) {
                        return ((Postprocessable) descriptionModel).a();
                    }
                    return descriptionModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<DescriptionModel> {
                public final void m15190a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DescriptionModel descriptionModel = (DescriptionModel) obj;
                    if (descriptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(descriptionModel.m15192a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        descriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OverlayActionLinkFieldsParser.DescriptionParser.m15383a(descriptionModel.w_(), descriptionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(DescriptionModel.class, new Serializer());
                }
            }

            public DescriptionModel() {
                super(1);
            }

            @Nullable
            private String m15191a() {
                this.f9059d = super.a(this.f9059d, 0);
                return this.f9059d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m15193a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15192a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15191a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OverlayActionLinkFieldsModel.class, new Deserializer());
            }

            public Object m15194a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = OverlayActionLinkFieldsParser.m15390a(jsonParser);
                Object overlayActionLinkFieldsModel = new OverlayActionLinkFieldsModel();
                ((BaseModel) overlayActionLinkFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (overlayActionLinkFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) overlayActionLinkFieldsModel).a();
                }
                return overlayActionLinkFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -80850687)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class InfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f9066d;
            @Nullable
            private CreationSuggestionModel f9067e;
            @Nullable
            private String f9068f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1436889218)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_store_application */
            public final class CreationSuggestionModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f9061d;
                @Nullable
                private GraphQLGroupVisibility f9062e;
                @Nullable
                private List<SuggestedMembersModel> f9063f;
                @Nullable
                private String f9064g;
                @Nullable
                private GraphQLGroupCreationSuggestionType f9065h;

                /* compiled from: app_store_application */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CreationSuggestionModel.class, new Deserializer());
                    }

                    public Object m15195a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CreationSuggestionParser.m15386a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object creationSuggestionModel = new CreationSuggestionModel();
                        ((BaseModel) creationSuggestionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (creationSuggestionModel instanceof Postprocessable) {
                            return ((Postprocessable) creationSuggestionModel).a();
                        }
                        return creationSuggestionModel;
                    }
                }

                /* compiled from: app_store_application */
                public class Serializer extends JsonSerializer<CreationSuggestionModel> {
                    public final void m15196a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CreationSuggestionModel creationSuggestionModel = (CreationSuggestionModel) obj;
                        if (creationSuggestionModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(creationSuggestionModel.m15210a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            creationSuggestionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CreationSuggestionParser.m15387a(creationSuggestionModel.w_(), creationSuggestionModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(CreationSuggestionModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1801334754)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: app_store_application */
                public final class SuggestedMembersModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f9060d;

                    /* compiled from: app_store_application */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(SuggestedMembersModel.class, new Deserializer());
                        }

                        public Object m15197a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(SuggestedMembersParser.m15385b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object suggestedMembersModel = new SuggestedMembersModel();
                            ((BaseModel) suggestedMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (suggestedMembersModel instanceof Postprocessable) {
                                return ((Postprocessable) suggestedMembersModel).a();
                            }
                            return suggestedMembersModel;
                        }
                    }

                    /* compiled from: app_store_application */
                    public class Serializer extends JsonSerializer<SuggestedMembersModel> {
                        public final void m15198a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            SuggestedMembersModel suggestedMembersModel = (SuggestedMembersModel) obj;
                            if (suggestedMembersModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(suggestedMembersModel.m15200a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                suggestedMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            SuggestedMembersParser.m15384a(suggestedMembersModel.w_(), suggestedMembersModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(SuggestedMembersModel.class, new Serializer());
                        }
                    }

                    public SuggestedMembersModel() {
                        super(1);
                    }

                    public final void m15203a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m15204a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private String m15199j() {
                        this.f9060d = super.a(this.f9060d, 0);
                        return this.f9060d;
                    }

                    @Nullable
                    public final String m15202a() {
                        return m15199j();
                    }

                    public final int jK_() {
                        return 2645995;
                    }

                    public final GraphQLVisitableModel m15201a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m15200a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m15199j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public CreationSuggestionModel() {
                    super(5);
                }

                @Nullable
                private String m15205a() {
                    this.f9061d = super.a(this.f9061d, 0);
                    return this.f9061d;
                }

                @Nullable
                private GraphQLGroupVisibility m15206j() {
                    this.f9062e = (GraphQLGroupVisibility) super.b(this.f9062e, 1, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f9062e;
                }

                @Nonnull
                private ImmutableList<SuggestedMembersModel> m15207k() {
                    this.f9063f = super.a(this.f9063f, 2, SuggestedMembersModel.class);
                    return (ImmutableList) this.f9063f;
                }

                @Nullable
                private String m15208l() {
                    this.f9064g = super.a(this.f9064g, 3);
                    return this.f9064g;
                }

                @Nullable
                private GraphQLGroupCreationSuggestionType m15209m() {
                    this.f9065h = (GraphQLGroupCreationSuggestionType) super.b(this.f9065h, 4, GraphQLGroupCreationSuggestionType.class, GraphQLGroupCreationSuggestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f9065h;
                }

                public final int jK_() {
                    return 1818481410;
                }

                public final GraphQLVisitableModel m15211a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15207k() != null) {
                        Builder a = ModelHelper.a(m15207k(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (CreationSuggestionModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9063f = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15210a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15205a());
                    int a = flatBufferBuilder.a(m15206j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m15207k());
                    int b2 = flatBufferBuilder.b(m15208l());
                    int a3 = flatBufferBuilder.a(m15209m());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, b2);
                    flatBufferBuilder.b(4, a3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InfoModel.class, new Deserializer());
                }

                public Object m15212a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InfoParser.m15388a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object infoModel = new InfoModel();
                    ((BaseModel) infoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (infoModel instanceof Postprocessable) {
                        return ((Postprocessable) infoModel).a();
                    }
                    return infoModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<InfoModel> {
                public final void m15213a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InfoModel infoModel = (InfoModel) obj;
                    if (infoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(infoModel.m15217a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        infoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InfoParser.m15389a(infoModel.w_(), infoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(InfoModel.class, new Serializer());
                }
            }

            public InfoModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m15214a() {
                if (this.b != null && this.f9066d == null) {
                    this.f9066d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9066d;
            }

            @Nullable
            private CreationSuggestionModel m15215j() {
                this.f9067e = (CreationSuggestionModel) super.a(this.f9067e, 1, CreationSuggestionModel.class);
                return this.f9067e;
            }

            @Nullable
            private String m15216k() {
                this.f9068f = super.a(this.f9068f, 2);
                return this.f9068f;
            }

            public final int jK_() {
                return 1570278061;
            }

            public final GraphQLVisitableModel m15218a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15215j() != null) {
                    CreationSuggestionModel creationSuggestionModel = (CreationSuggestionModel) graphQLModelMutatingVisitor.b(m15215j());
                    if (m15215j() != creationSuggestionModel) {
                        graphQLVisitableModel = (InfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9067e = creationSuggestionModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15217a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15214a());
                int a2 = ModelHelper.a(flatBufferBuilder, m15215j());
                int b = flatBufferBuilder.b(m15216k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<OverlayActionLinkFieldsModel> {
            public final void m15219a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                OverlayActionLinkFieldsModel overlayActionLinkFieldsModel = (OverlayActionLinkFieldsModel) obj;
                if (overlayActionLinkFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(overlayActionLinkFieldsModel.m15223a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    overlayActionLinkFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = overlayActionLinkFieldsModel.w_();
                int u_ = overlayActionLinkFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("description");
                    OverlayActionLinkFieldsParser.DescriptionParser.m15383a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("info");
                    InfoParser.m15389a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("title");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(OverlayActionLinkFieldsModel.class, new Serializer());
            }
        }

        public OverlayActionLinkFieldsModel() {
            super(3);
        }

        @Nullable
        private DescriptionModel m15220a() {
            this.f9069d = (DescriptionModel) super.a(this.f9069d, 0, DescriptionModel.class);
            return this.f9069d;
        }

        @Nullable
        private InfoModel m15221j() {
            this.f9070e = (InfoModel) super.a(this.f9070e, 1, InfoModel.class);
            return this.f9070e;
        }

        @Nullable
        private String m15222k() {
            this.f9071f = super.a(this.f9071f, 2);
            return this.f9071f;
        }

        public final int jK_() {
            return -1260727392;
        }

        public final GraphQLVisitableModel m15224a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15220a() != null) {
                DescriptionModel descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m15220a());
                if (m15220a() != descriptionModel) {
                    graphQLVisitableModel = (OverlayActionLinkFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9069d = descriptionModel;
                }
            }
            if (m15221j() != null) {
                InfoModel infoModel = (InfoModel) graphQLModelMutatingVisitor.b(m15221j());
                if (m15221j() != infoModel) {
                    graphQLVisitableModel = (OverlayActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9070e = infoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15223a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15220a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15221j());
            int b = flatBufferBuilder.b(m15222k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2011360297)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class PageOutcomeButtonActionLinkFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageOutcomeButtonModel f9078d;

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageOutcomeButtonActionLinkFieldsModel.class, new Deserializer());
            }

            public Object m15225a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageOutcomeButtonActionLinkFieldsParser.m15397a(jsonParser);
                Object pageOutcomeButtonActionLinkFieldsModel = new PageOutcomeButtonActionLinkFieldsModel();
                ((BaseModel) pageOutcomeButtonActionLinkFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageOutcomeButtonActionLinkFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) pageOutcomeButtonActionLinkFieldsModel).a();
                }
                return pageOutcomeButtonActionLinkFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1674077625)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class PageOutcomeButtonModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ButtonIconImageModel f9074d;
            @Nullable
            private GraphQLPageCallToActionType f9075e;
            @Nullable
            private String f9076f;
            @Nullable
            private GraphQLPageOutcomeButtonRenderType f9077g;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1302003800)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: app_store_application */
            public final class ButtonIconImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private IconImageModel f9073d;

                /* compiled from: app_store_application */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ButtonIconImageModel.class, new Deserializer());
                    }

                    public Object m15226a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ButtonIconImageParser.m15393a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object buttonIconImageModel = new ButtonIconImageModel();
                        ((BaseModel) buttonIconImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (buttonIconImageModel instanceof Postprocessable) {
                            return ((Postprocessable) buttonIconImageModel).a();
                        }
                        return buttonIconImageModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: app_store_application */
                public final class IconImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f9072d;

                    /* compiled from: app_store_application */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(IconImageModel.class, new Deserializer());
                        }

                        public Object m15227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(IconImageParser.m15391a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object iconImageModel = new IconImageModel();
                            ((BaseModel) iconImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (iconImageModel instanceof Postprocessable) {
                                return ((Postprocessable) iconImageModel).a();
                            }
                            return iconImageModel;
                        }
                    }

                    /* compiled from: app_store_application */
                    public class Serializer extends JsonSerializer<IconImageModel> {
                        public final void m15228a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            IconImageModel iconImageModel = (IconImageModel) obj;
                            if (iconImageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(iconImageModel.m15230a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                iconImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            IconImageParser.m15392a(iconImageModel.w_(), iconImageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(IconImageModel.class, new Serializer());
                        }
                    }

                    public IconImageModel() {
                        super(1);
                    }

                    @Nullable
                    private String m15229a() {
                        this.f9072d = super.a(this.f9072d, 0);
                        return this.f9072d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m15231a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m15230a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m15229a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: app_store_application */
                public class Serializer extends JsonSerializer<ButtonIconImageModel> {
                    public final void m15232a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ButtonIconImageModel buttonIconImageModel = (ButtonIconImageModel) obj;
                        if (buttonIconImageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(buttonIconImageModel.m15234a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            buttonIconImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ButtonIconImageParser.m15394a(buttonIconImageModel.w_(), buttonIconImageModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ButtonIconImageModel.class, new Serializer());
                    }
                }

                public ButtonIconImageModel() {
                    super(1);
                }

                @Nullable
                private IconImageModel m15233a() {
                    this.f9073d = (IconImageModel) super.a(this.f9073d, 0, IconImageModel.class);
                    return this.f9073d;
                }

                public final int jK_() {
                    return 1667242696;
                }

                public final GraphQLVisitableModel m15235a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15233a() != null) {
                        IconImageModel iconImageModel = (IconImageModel) graphQLModelMutatingVisitor.b(m15233a());
                        if (m15233a() != iconImageModel) {
                            graphQLVisitableModel = (ButtonIconImageModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9073d = iconImageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15234a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15233a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageOutcomeButtonModel.class, new Deserializer());
                }

                public Object m15236a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageOutcomeButtonParser.m15395a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageOutcomeButtonModel = new PageOutcomeButtonModel();
                    ((BaseModel) pageOutcomeButtonModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageOutcomeButtonModel instanceof Postprocessable) {
                        return ((Postprocessable) pageOutcomeButtonModel).a();
                    }
                    return pageOutcomeButtonModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<PageOutcomeButtonModel> {
                public final void m15237a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageOutcomeButtonModel pageOutcomeButtonModel = (PageOutcomeButtonModel) obj;
                    if (pageOutcomeButtonModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageOutcomeButtonModel.m15242a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageOutcomeButtonModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageOutcomeButtonParser.m15396a(pageOutcomeButtonModel.w_(), pageOutcomeButtonModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageOutcomeButtonModel.class, new Serializer());
                }
            }

            public PageOutcomeButtonModel() {
                super(4);
            }

            @Nullable
            private ButtonIconImageModel m15238a() {
                this.f9074d = (ButtonIconImageModel) super.a(this.f9074d, 0, ButtonIconImageModel.class);
                return this.f9074d;
            }

            @Nullable
            private GraphQLPageCallToActionType m15239j() {
                this.f9075e = (GraphQLPageCallToActionType) super.b(this.f9075e, 1, GraphQLPageCallToActionType.class, GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9075e;
            }

            @Nullable
            private String m15240k() {
                this.f9076f = super.a(this.f9076f, 2);
                return this.f9076f;
            }

            @Nullable
            private GraphQLPageOutcomeButtonRenderType m15241l() {
                this.f9077g = (GraphQLPageOutcomeButtonRenderType) super.b(this.f9077g, 3, GraphQLPageOutcomeButtonRenderType.class, GraphQLPageOutcomeButtonRenderType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9077g;
            }

            public final int jK_() {
                return -630013259;
            }

            public final GraphQLVisitableModel m15243a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15238a() != null) {
                    ButtonIconImageModel buttonIconImageModel = (ButtonIconImageModel) graphQLModelMutatingVisitor.b(m15238a());
                    if (m15238a() != buttonIconImageModel) {
                        graphQLVisitableModel = (PageOutcomeButtonModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9074d = buttonIconImageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15242a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15238a());
                int a2 = flatBufferBuilder.a(m15239j());
                int b = flatBufferBuilder.b(m15240k());
                int a3 = flatBufferBuilder.a(m15241l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<PageOutcomeButtonActionLinkFieldsModel> {
            public final void m15244a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageOutcomeButtonActionLinkFieldsModel pageOutcomeButtonActionLinkFieldsModel = (PageOutcomeButtonActionLinkFieldsModel) obj;
                if (pageOutcomeButtonActionLinkFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageOutcomeButtonActionLinkFieldsModel.m15246a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageOutcomeButtonActionLinkFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageOutcomeButtonActionLinkFieldsModel.w_();
                int u_ = pageOutcomeButtonActionLinkFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page_outcome_button");
                    PageOutcomeButtonParser.m15396a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageOutcomeButtonActionLinkFieldsModel.class, new Serializer());
            }
        }

        public PageOutcomeButtonActionLinkFieldsModel() {
            super(1);
        }

        @Nullable
        private PageOutcomeButtonModel m15245a() {
            this.f9078d = (PageOutcomeButtonModel) super.a(this.f9078d, 0, PageOutcomeButtonModel.class);
            return this.f9078d;
        }

        public final int jK_() {
            return 1850349541;
        }

        public final GraphQLVisitableModel m15247a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15245a() != null) {
                PageOutcomeButtonModel pageOutcomeButtonModel = (PageOutcomeButtonModel) graphQLModelMutatingVisitor.b(m15245a());
                if (m15245a() != pageOutcomeButtonModel) {
                    graphQLVisitableModel = (PageOutcomeButtonActionLinkFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9078d = pageOutcomeButtonModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15246a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15245a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1298410259)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class PlaceListConvertActionLinkFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StoryModel f9080d;

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceListConvertActionLinkFieldsModel.class, new Deserializer());
            }

            public Object m15248a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PlaceListConvertActionLinkFieldsParser.m15400a(jsonParser);
                Object placeListConvertActionLinkFieldsModel = new PlaceListConvertActionLinkFieldsModel();
                ((BaseModel) placeListConvertActionLinkFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (placeListConvertActionLinkFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) placeListConvertActionLinkFieldsModel).a();
                }
                return placeListConvertActionLinkFieldsModel;
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<PlaceListConvertActionLinkFieldsModel> {
            public final void m15249a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PlaceListConvertActionLinkFieldsModel placeListConvertActionLinkFieldsModel = (PlaceListConvertActionLinkFieldsModel) obj;
                if (placeListConvertActionLinkFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeListConvertActionLinkFieldsModel.m15259a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeListConvertActionLinkFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = placeListConvertActionLinkFieldsModel.w_();
                int u_ = placeListConvertActionLinkFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("story");
                    StoryParser.m15399a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PlaceListConvertActionLinkFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class StoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f9079d;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StoryModel.class, new Deserializer());
                }

                public Object m15250a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StoryParser.m15398a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object storyModel = new StoryModel();
                    ((BaseModel) storyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (storyModel instanceof Postprocessable) {
                        return ((Postprocessable) storyModel).a();
                    }
                    return storyModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<StoryModel> {
                public final void m15251a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StoryModel storyModel = (StoryModel) obj;
                    if (storyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(storyModel.m15253a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        storyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StoryParser.m15399a(storyModel.w_(), storyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(StoryModel.class, new Serializer());
                }
            }

            public StoryModel() {
                super(1);
            }

            public final void m15256a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15257a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m15252j() {
                this.f9079d = super.a(this.f9079d, 0);
                return this.f9079d;
            }

            @Nullable
            public final String m15255a() {
                return m15252j();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m15254a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15253a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15252j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public PlaceListConvertActionLinkFieldsModel() {
            super(1);
        }

        @Nullable
        private StoryModel m15258a() {
            this.f9080d = (StoryModel) super.a(this.f9080d, 0, StoryModel.class);
            return this.f9080d;
        }

        public final int jK_() {
            return 1410677182;
        }

        public final GraphQLVisitableModel m15260a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15258a() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m15258a());
                if (m15258a() != storyModel) {
                    graphQLVisitableModel = (PlaceListConvertActionLinkFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9080d = storyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15259a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15258a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1617504198)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class ReadInstantArticleActionLinkFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeaturedInstantArticleElementModel f9085d;
        @Nullable
        private InstantArticleModel f9086e;

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReadInstantArticleActionLinkFieldsModel.class, new Deserializer());
            }

            public Object m15261a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReadInstantArticleActionLinkFieldsParser.m15405a(jsonParser);
                Object readInstantArticleActionLinkFieldsModel = new ReadInstantArticleActionLinkFieldsModel();
                ((BaseModel) readInstantArticleActionLinkFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (readInstantArticleActionLinkFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) readInstantArticleActionLinkFieldsModel).a();
                }
                return readInstantArticleActionLinkFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1385623029)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class FeaturedInstantArticleElementModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f9081d;
            @Nullable
            private GraphQLDocumentElementType f9082e;
            @Nullable
            private String f9083f;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeaturedInstantArticleElementModel.class, new Deserializer());
                }

                public Object m15262a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeaturedInstantArticleElementParser.m15401a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object featuredInstantArticleElementModel = new FeaturedInstantArticleElementModel();
                    ((BaseModel) featuredInstantArticleElementModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (featuredInstantArticleElementModel instanceof Postprocessable) {
                        return ((Postprocessable) featuredInstantArticleElementModel).a();
                    }
                    return featuredInstantArticleElementModel;
                }
            }

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<FeaturedInstantArticleElementModel> {
                public final void m15263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeaturedInstantArticleElementModel featuredInstantArticleElementModel = (FeaturedInstantArticleElementModel) obj;
                    if (featuredInstantArticleElementModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(featuredInstantArticleElementModel.m15267a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        featuredInstantArticleElementModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeaturedInstantArticleElementParser.m15402a(featuredInstantArticleElementModel.w_(), featuredInstantArticleElementModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FeaturedInstantArticleElementModel.class, new Serializer());
                }
            }

            public FeaturedInstantArticleElementModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m15264j() {
                if (this.b != null && this.f9081d == null) {
                    this.f9081d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9081d;
            }

            @Nullable
            private GraphQLDocumentElementType m15265k() {
                this.f9082e = (GraphQLDocumentElementType) super.b(this.f9082e, 1, GraphQLDocumentElementType.class, GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9082e;
            }

            @Nullable
            private String m15266l() {
                this.f9083f = super.a(this.f9083f, 2);
                return this.f9083f;
            }

            @Nullable
            public final String m15269a() {
                return m15266l();
            }

            public final int jK_() {
                return 473184577;
            }

            public final GraphQLVisitableModel m15268a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15267a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15264j());
                int a2 = flatBufferBuilder.a(m15265k());
                int b = flatBufferBuilder.b(m15266l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_store_application */
        public final class InstantArticleModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f9084d;

            /* compiled from: app_store_application */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InstantArticleModel.class, new Deserializer());
                }

                public Object m15270a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InstantArticleParser.m15403a(jsonParser, flatBufferBuilder));
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

            /* compiled from: app_store_application */
            public class Serializer extends JsonSerializer<InstantArticleModel> {
                public final void m15271a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InstantArticleModel instantArticleModel = (InstantArticleModel) obj;
                    if (instantArticleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(instantArticleModel.m15273a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        instantArticleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InstantArticleParser.m15404a(instantArticleModel.w_(), instantArticleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(InstantArticleModel.class, new Serializer());
                }
            }

            public InstantArticleModel() {
                super(1);
            }

            @Nullable
            private String m15272j() {
                this.f9084d = super.a(this.f9084d, 0);
                return this.f9084d;
            }

            @Nullable
            public final String m15275a() {
                return m15272j();
            }

            public final int jK_() {
                return 1607392245;
            }

            public final GraphQLVisitableModel m15274a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15273a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15272j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<ReadInstantArticleActionLinkFieldsModel> {
            public final void m15276a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReadInstantArticleActionLinkFieldsModel readInstantArticleActionLinkFieldsModel = (ReadInstantArticleActionLinkFieldsModel) obj;
                if (readInstantArticleActionLinkFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(readInstantArticleActionLinkFieldsModel.m15279a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    readInstantArticleActionLinkFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = readInstantArticleActionLinkFieldsModel.w_();
                int u_ = readInstantArticleActionLinkFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("featured_instant_article_element");
                    FeaturedInstantArticleElementParser.m15402a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("instant_article");
                    InstantArticleParser.m15404a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReadInstantArticleActionLinkFieldsModel.class, new Serializer());
            }
        }

        public ReadInstantArticleActionLinkFieldsModel() {
            super(2);
        }

        @Nullable
        private FeaturedInstantArticleElementModel m15277a() {
            this.f9085d = (FeaturedInstantArticleElementModel) super.a(this.f9085d, 0, FeaturedInstantArticleElementModel.class);
            return this.f9085d;
        }

        @Nullable
        private InstantArticleModel m15278j() {
            this.f9086e = (InstantArticleModel) super.a(this.f9086e, 1, InstantArticleModel.class);
            return this.f9086e;
        }

        public final int jK_() {
            return -1787941669;
        }

        public final GraphQLVisitableModel m15280a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15277a() != null) {
                FeaturedInstantArticleElementModel featuredInstantArticleElementModel = (FeaturedInstantArticleElementModel) graphQLModelMutatingVisitor.b(m15277a());
                if (m15277a() != featuredInstantArticleElementModel) {
                    graphQLVisitableModel = (ReadInstantArticleActionLinkFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9085d = featuredInstantArticleElementModel;
                }
            }
            if (m15278j() != null) {
                InstantArticleModel instantArticleModel = (InstantArticleModel) graphQLModelMutatingVisitor.b(m15278j());
                if (m15278j() != instantArticleModel) {
                    graphQLVisitableModel = (ReadInstantArticleActionLinkFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9086e = instantArticleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15279a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15277a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15278j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 688619580)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_store_application */
    public final class VideoAnnotationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f9087d;
        @Nullable
        private String f9088e;
        @Nullable
        private String f9089f;
        @Nullable
        private String f9090g;
        @Nullable
        private String f9091h;
        @Nullable
        private String f9092i;
        private int f9093j;

        /* compiled from: app_store_application */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoAnnotationFieldsModel.class, new Deserializer());
            }

            public Object m15281a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(VideoAnnotationFieldsParser.m15408b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object videoAnnotationFieldsModel = new VideoAnnotationFieldsModel();
                ((BaseModel) videoAnnotationFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (videoAnnotationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) videoAnnotationFieldsModel).a();
                }
                return videoAnnotationFieldsModel;
            }
        }

        /* compiled from: app_store_application */
        public class Serializer extends JsonSerializer<VideoAnnotationFieldsModel> {
            public final void m15282a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                VideoAnnotationFieldsModel videoAnnotationFieldsModel = (VideoAnnotationFieldsModel) obj;
                if (videoAnnotationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoAnnotationFieldsModel.m15288a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoAnnotationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                VideoAnnotationFieldsParser.m15407a(videoAnnotationFieldsModel.w_(), videoAnnotationFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(VideoAnnotationFieldsModel.class, new Serializer());
            }
        }

        public VideoAnnotationFieldsModel() {
            super(7);
        }

        @Nullable
        private String m15283a() {
            this.f9088e = super.a(this.f9088e, 1);
            return this.f9088e;
        }

        @Nullable
        private String m15284j() {
            this.f9089f = super.a(this.f9089f, 2);
            return this.f9089f;
        }

        @Nullable
        private String m15285k() {
            this.f9090g = super.a(this.f9090g, 3);
            return this.f9090g;
        }

        @Nullable
        private String m15286l() {
            this.f9091h = super.a(this.f9091h, 4);
            return this.f9091h;
        }

        @Nullable
        private String m15287m() {
            this.f9092i = super.a(this.f9092i, 5);
            return this.f9092i;
        }

        public final int jK_() {
            return -1321372182;
        }

        public final GraphQLVisitableModel m15289a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m15288a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15283a());
            int b2 = flatBufferBuilder.b(m15284j());
            int b3 = flatBufferBuilder.b(m15285k());
            int b4 = flatBufferBuilder.b(m15286l());
            int b5 = flatBufferBuilder.b(m15287m());
            flatBufferBuilder.c(7);
            flatBufferBuilder.a(0, this.f9087d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, b4);
            flatBufferBuilder.b(5, b5);
            flatBufferBuilder.a(6, this.f9093j, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15290a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9087d = mutableFlatBuffer.a(i, 0, 0);
            this.f9093j = mutableFlatBuffer.a(i, 6, 0);
        }
    }
}
