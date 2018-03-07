package com.facebook.reaction.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsModels.PlaceQuestionFieldsModel;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCardFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventCardFragmentModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLReactionProfileBadgeType;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitCollapseState;
import com.facebook.graphql.enums.GraphQLReactionUnitHeaderStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.LinkableTextWithEntitiesModel;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.localcontent.protocol.graphql.PopularProductFragmentsModels.PageProductModel;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLModels.SizeAwareMediaModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.PageMediaWithAttribution;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.PageMediaWithAttributionModel;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLInterfaces.ReactionAttributionFooterAttachmentFields;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLInterfaces.ReactionCriticReviewAttachmentFields;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLInterfaces.ReactionPageCommerceAttachmentFields;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLInterfaces.ReactionPageInviteFriendToLikeAttachmentFields;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLInterfaces.ReactionPagePromotionAttachmentFields;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLInterfaces.ReactionStoryAdminPageAttachmentFragment;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLModels.ReactionAttributionFooterAttachmentFieldsModel.AttributionModel;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLModels.ReactionCriticReviewAttachmentFieldsModel.ExternalImageModel;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLModels.ReactionCriticReviewAttachmentFieldsModel.ReviewerModel;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLModels.ReactionPageCommerceAttachmentFieldsModel.ProductModel;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLModels.ReactionPageInviteFriendToLikeAttachmentFieldsModel.InviteeModel;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLModels.ReactionPagePromotionAttachmentFieldsModel.ItemModel;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLModels.ReactionStoryAdminPageAttachmentFragmentModel.StoryAdminPageModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionFacepileProfile;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionProfileFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionTextWithEntitiesWithImages;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionFacepileProfileModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionImageFieldsModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionPageFieldsWithPlaceTipsInfoModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionProfileFieldsModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionTextWithEntitiesWithImagesModel.ImageRangesModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionAggregateUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStoryFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStoryTopicAttachmentFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitBadgedProfilesComponentFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitDefaultFields;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.PlaceTipWelcomeHeaderFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.PlaceTipsFeedUnitFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.PlaceTipsFeedUnitFragmentParser.FooterParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionAggregateUnitFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionAggregateUnitFragmentParser.ReactionAggregatedUnitsParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionMoreAttachmentsResultParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionMoreAttachmentsResultParser.ReactionAttachmentsParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionMoreAttachmentsResultParser.ReactionAttachmentsParser.EdgesParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionProfileAttachmentFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionProfileAttachmentsResultParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionQueryFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionQueryFragmentParser.ReactionUnitsParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionStoriesParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionStoryAttachmentFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionStoryAttachmentFragmentParser.MessageParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionStoryAttachmentFragmentParser.PageParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionStoryFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionStoryTopicAttachmentFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionStoryTopicAttachmentFragmentParser.TopicParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionSuggestedEventsQueryFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionSuggestedEventsQueryParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionUnitBadgedProfilesComponentFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionUnitBadgedProfilesComponentFragmentParser.BadgableProfilesParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionUnitDefaultFieldsParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionUnitExpirationConditionFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionUnitFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.ReactionUnitHeaderFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionStoryAttachmentActionFragmentParser;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
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

/* compiled from: file IO exception on reading */
public class FetchReactionGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 381446753)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: file IO exception on reading */
    public final class PlaceTipWelcomeHeaderFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12454d;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12455e;
        @Nullable
        private ReactionPageFieldsWithPlaceTipsInfoModel f12456f;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12457g;
        @Nullable
        private SizeAwareMediaModel f12458h;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12459i;

        /* compiled from: file IO exception on reading */
        public final class Builder {
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12448a;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12449b;
            @Nullable
            public ReactionPageFieldsWithPlaceTipsInfoModel f12450c;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12451d;
            @Nullable
            public SizeAwareMediaModel f12452e;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12453f;
        }

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceTipWelcomeHeaderFragmentModel.class, new Deserializer());
            }

            public Object m15337a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlaceTipWelcomeHeaderFragmentParser.m15671a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object placeTipWelcomeHeaderFragmentModel = new PlaceTipWelcomeHeaderFragmentModel();
                ((BaseModel) placeTipWelcomeHeaderFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (placeTipWelcomeHeaderFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) placeTipWelcomeHeaderFragmentModel).a();
                }
                return placeTipWelcomeHeaderFragmentModel;
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<PlaceTipWelcomeHeaderFragmentModel> {
            public final void m15338a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlaceTipWelcomeHeaderFragmentModel placeTipWelcomeHeaderFragmentModel = (PlaceTipWelcomeHeaderFragmentModel) obj;
                if (placeTipWelcomeHeaderFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeTipWelcomeHeaderFragmentModel.m15346a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeTipWelcomeHeaderFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlaceTipWelcomeHeaderFragmentParser.m15672a(placeTipWelcomeHeaderFragmentModel.w_(), placeTipWelcomeHeaderFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlaceTipWelcomeHeaderFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15347a() {
            return m15340j();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15349b() {
            return m15341k();
        }

        @Nullable
        public final /* synthetic */ ReactionPageFieldsWithPlaceTipsInfoModel m15350c() {
            return m15342l();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15351d() {
            return m15343m();
        }

        @Nullable
        public final /* synthetic */ SizeAwareMedia fq_() {
            return m15344n();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15352g() {
            return m15345o();
        }

        public PlaceTipWelcomeHeaderFragmentModel() {
            super(6);
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15340j() {
            this.f12454d = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12454d, 0, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12454d;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15341k() {
            this.f12455e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12455e, 1, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12455e;
        }

        @Nullable
        private ReactionPageFieldsWithPlaceTipsInfoModel m15342l() {
            this.f12456f = (ReactionPageFieldsWithPlaceTipsInfoModel) super.a(this.f12456f, 2, ReactionPageFieldsWithPlaceTipsInfoModel.class);
            return this.f12456f;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15343m() {
            this.f12457g = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12457g, 3, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12457g;
        }

        @Nullable
        private SizeAwareMediaModel m15344n() {
            this.f12458h = (SizeAwareMediaModel) super.a(this.f12458h, 4, SizeAwareMediaModel.class);
            return this.f12458h;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15345o() {
            this.f12459i = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12459i, 5, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12459i;
        }

        public static PlaceTipWelcomeHeaderFragmentModel m15339a(PlaceTipWelcomeHeaderFragmentModel placeTipWelcomeHeaderFragmentModel) {
            if (placeTipWelcomeHeaderFragmentModel == null) {
                return null;
            }
            if (placeTipWelcomeHeaderFragmentModel instanceof PlaceTipWelcomeHeaderFragmentModel) {
                return placeTipWelcomeHeaderFragmentModel;
            }
            Builder builder = new Builder();
            builder.f12448a = DefaultTextWithEntitiesFieldsModel.a(placeTipWelcomeHeaderFragmentModel.m15347a());
            builder.f12449b = DefaultTextWithEntitiesFieldsModel.a(placeTipWelcomeHeaderFragmentModel.m15349b());
            builder.f12450c = ReactionPageFieldsWithPlaceTipsInfoModel.m14528a(placeTipWelcomeHeaderFragmentModel.m15350c());
            builder.f12451d = DefaultTextWithEntitiesFieldsModel.a(placeTipWelcomeHeaderFragmentModel.m15351d());
            builder.f12452e = SizeAwareMediaModel.a(placeTipWelcomeHeaderFragmentModel.fq_());
            builder.f12453f = DefaultTextWithEntitiesFieldsModel.a(placeTipWelcomeHeaderFragmentModel.m15352g());
            return new PlaceTipWelcomeHeaderFragmentModel(builder);
        }

        public PlaceTipWelcomeHeaderFragmentModel(Builder builder) {
            super(6);
            this.f12454d = builder.f12448a;
            this.f12455e = builder.f12449b;
            this.f12456f = builder.f12450c;
            this.f12457g = builder.f12451d;
            this.f12458h = builder.f12452e;
            this.f12459i = builder.f12453f;
        }

        public final int jK_() {
            return 1634720443;
        }

        public final GraphQLVisitableModel m15348a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15340j() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15340j());
                if (m15340j() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (PlaceTipWelcomeHeaderFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12454d = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15341k() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15341k());
                if (m15341k() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (PlaceTipWelcomeHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12455e = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15342l() != null) {
                ReactionPageFieldsWithPlaceTipsInfoModel reactionPageFieldsWithPlaceTipsInfoModel = (ReactionPageFieldsWithPlaceTipsInfoModel) graphQLModelMutatingVisitor.b(m15342l());
                if (m15342l() != reactionPageFieldsWithPlaceTipsInfoModel) {
                    graphQLVisitableModel = (PlaceTipWelcomeHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12456f = reactionPageFieldsWithPlaceTipsInfoModel;
                }
            }
            if (m15343m() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15343m());
                if (m15343m() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (PlaceTipWelcomeHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12457g = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15344n() != null) {
                SizeAwareMediaModel sizeAwareMediaModel = (SizeAwareMediaModel) graphQLModelMutatingVisitor.b(m15344n());
                if (m15344n() != sizeAwareMediaModel) {
                    graphQLVisitableModel = (PlaceTipWelcomeHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12458h = sizeAwareMediaModel;
                }
            }
            if (m15345o() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15345o());
                if (m15345o() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (PlaceTipWelcomeHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12459i = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15346a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15340j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15341k());
            int a3 = ModelHelper.a(flatBufferBuilder, m15342l());
            int a4 = ModelHelper.a(flatBufferBuilder, m15343m());
            int a5 = ModelHelper.a(flatBufferBuilder, m15344n());
            int a6 = ModelHelper.a(flatBufferBuilder, m15345o());
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
    @ModelWithFlatBufferFormatHash(a = -549912185)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: file IO exception on reading */
    public final class PlaceTipsFeedUnitFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FooterModel f12463d;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f12464e;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f12465f;

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceTipsFeedUnitFragmentModel.class, new Deserializer());
            }

            public Object m15353a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlaceTipsFeedUnitFragmentParser.m15675a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object placeTipsFeedUnitFragmentModel = new PlaceTipsFeedUnitFragmentModel();
                ((BaseModel) placeTipsFeedUnitFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (placeTipsFeedUnitFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) placeTipsFeedUnitFragmentModel).a();
                }
                return placeTipsFeedUnitFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2041088003)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: file IO exception on reading */
        public final class FooterModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel f12460d;
            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel f12461e;
            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel f12462f;

            /* compiled from: file IO exception on reading */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FooterModel.class, new Deserializer());
                }

                public Object m15354a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FooterParser.m15673a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object footerModel = new FooterModel();
                    ((BaseModel) footerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (footerModel instanceof Postprocessable) {
                        return ((Postprocessable) footerModel).a();
                    }
                    return footerModel;
                }
            }

            /* compiled from: file IO exception on reading */
            public class Serializer extends JsonSerializer<FooterModel> {
                public final void m15355a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FooterModel footerModel = (FooterModel) obj;
                    if (footerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(footerModel.m15359a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        footerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FooterParser.m15674a(footerModel.w_(), footerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FooterModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesLongFields m15360a() {
                return m15356j();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesLongFields m15362b() {
                return m15357k();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesLongFields m15363c() {
                return m15358l();
            }

            public FooterModel() {
                super(3);
            }

            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel m15356j() {
                this.f12460d = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f12460d, 0, DefaultTextWithEntitiesLongFieldsModel.class);
                return this.f12460d;
            }

            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel m15357k() {
                this.f12461e = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f12461e, 1, DefaultTextWithEntitiesLongFieldsModel.class);
                return this.f12461e;
            }

            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel m15358l() {
                this.f12462f = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f12462f, 2, DefaultTextWithEntitiesLongFieldsModel.class);
                return this.f12462f;
            }

            public final int jK_() {
                return -123892497;
            }

            public final GraphQLVisitableModel m15361a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15356j() != null) {
                    defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15356j());
                    if (m15356j() != defaultTextWithEntitiesLongFieldsModel) {
                        graphQLVisitableModel = (FooterModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12460d = defaultTextWithEntitiesLongFieldsModel;
                    }
                }
                if (m15357k() != null) {
                    defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15357k());
                    if (m15357k() != defaultTextWithEntitiesLongFieldsModel) {
                        graphQLVisitableModel = (FooterModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12461e = defaultTextWithEntitiesLongFieldsModel;
                    }
                }
                if (m15358l() != null) {
                    defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15358l());
                    if (m15358l() != defaultTextWithEntitiesLongFieldsModel) {
                        graphQLVisitableModel = (FooterModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12462f = defaultTextWithEntitiesLongFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15359a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15356j());
                int a2 = ModelHelper.a(flatBufferBuilder, m15357k());
                int a3 = ModelHelper.a(flatBufferBuilder, m15358l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<PlaceTipsFeedUnitFragmentModel> {
            public final void m15364a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlaceTipsFeedUnitFragmentModel placeTipsFeedUnitFragmentModel = (PlaceTipsFeedUnitFragmentModel) obj;
                if (placeTipsFeedUnitFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeTipsFeedUnitFragmentModel.m15366a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeTipsFeedUnitFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlaceTipsFeedUnitFragmentParser.m15676a(placeTipsFeedUnitFragmentModel.w_(), placeTipsFeedUnitFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlaceTipsFeedUnitFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FooterModel m15368a() {
            return m15365l();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields m15369b() {
            return m15371j();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields m15370c() {
            return m15372k();
        }

        public PlaceTipsFeedUnitFragmentModel() {
            super(3);
        }

        @Nullable
        private FooterModel m15365l() {
            this.f12463d = (FooterModel) super.a(this.f12463d, 0, FooterModel.class);
            return this.f12463d;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m15371j() {
            this.f12464e = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f12464e, 1, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f12464e;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m15372k() {
            this.f12465f = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f12465f, 2, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f12465f;
        }

        public final int jK_() {
            return 611747478;
        }

        public final GraphQLVisitableModel m15367a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15365l() != null) {
                FooterModel footerModel = (FooterModel) graphQLModelMutatingVisitor.b(m15365l());
                if (m15365l() != footerModel) {
                    graphQLVisitableModel = (PlaceTipsFeedUnitFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12463d = footerModel;
                }
            }
            if (m15371j() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15371j());
                if (m15371j() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (PlaceTipsFeedUnitFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12464e = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m15372k() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15372k());
                if (m15372k() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (PlaceTipsFeedUnitFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12465f = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15366a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15365l());
            int a2 = ModelHelper.a(flatBufferBuilder, m15371j());
            int a3 = ModelHelper.a(flatBufferBuilder, m15372k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -427626207)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: file IO exception on reading */
    public final class ReactionAggregateUnitFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionAggregateUnitFragment {
        @Nullable
        private ReactionAggregatedUnitsModel f12468d;

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionAggregateUnitFragmentModel.class, new Deserializer());
            }

            public Object m15373a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionAggregateUnitFragmentParser.m15679a(jsonParser);
                Object reactionAggregateUnitFragmentModel = new ReactionAggregateUnitFragmentModel();
                ((BaseModel) reactionAggregateUnitFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionAggregateUnitFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionAggregateUnitFragmentModel).a();
                }
                return reactionAggregateUnitFragmentModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -780227931)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: file IO exception on reading */
        public final class ReactionAggregatedUnitsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ReactionUnitDefaultFieldsModel> f12467d;

            /* compiled from: file IO exception on reading */
            public final class Builder {
                @Nullable
                public ImmutableList<ReactionUnitDefaultFieldsModel> f12466a;
            }

            /* compiled from: file IO exception on reading */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactionAggregatedUnitsModel.class, new Deserializer());
                }

                public Object m15374a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionAggregatedUnitsParser.m15677a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactionAggregatedUnitsModel = new ReactionAggregatedUnitsModel();
                    ((BaseModel) reactionAggregatedUnitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactionAggregatedUnitsModel instanceof Postprocessable) {
                        return ((Postprocessable) reactionAggregatedUnitsModel).a();
                    }
                    return reactionAggregatedUnitsModel;
                }
            }

            /* compiled from: file IO exception on reading */
            public class Serializer extends JsonSerializer<ReactionAggregatedUnitsModel> {
                public final void m15375a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactionAggregatedUnitsModel reactionAggregatedUnitsModel = (ReactionAggregatedUnitsModel) obj;
                    if (reactionAggregatedUnitsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactionAggregatedUnitsModel.m15377a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactionAggregatedUnitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionAggregatedUnitsParser.m15678a(reactionAggregatedUnitsModel.w_(), reactionAggregatedUnitsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReactionAggregatedUnitsModel.class, new Serializer());
                }
            }

            public ReactionAggregatedUnitsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ReactionUnitDefaultFieldsModel> m15379a() {
                this.f12467d = super.a(this.f12467d, 0, ReactionUnitDefaultFieldsModel.class);
                return (ImmutableList) this.f12467d;
            }

            public static ReactionAggregatedUnitsModel m15376a(ReactionAggregatedUnitsModel reactionAggregatedUnitsModel) {
                if (reactionAggregatedUnitsModel == null) {
                    return null;
                }
                if (reactionAggregatedUnitsModel instanceof ReactionAggregatedUnitsModel) {
                    return reactionAggregatedUnitsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < reactionAggregatedUnitsModel.m15379a().size(); i++) {
                    builder2.c(ReactionUnitDefaultFieldsModel.m15594a((ReactionUnitDefaultFields) reactionAggregatedUnitsModel.m15379a().get(i)));
                }
                builder.f12466a = builder2.b();
                return new ReactionAggregatedUnitsModel(builder);
            }

            public ReactionAggregatedUnitsModel(Builder builder) {
                super(1);
                this.f12467d = builder.f12466a;
            }

            public final int jK_() {
                return -1949299681;
            }

            public final GraphQLVisitableModel m15378a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15379a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m15379a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ReactionAggregatedUnitsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12467d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15377a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15379a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionAggregateUnitFragmentModel> {
            public final void m15380a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionAggregateUnitFragmentModel reactionAggregateUnitFragmentModel = (ReactionAggregateUnitFragmentModel) obj;
                if (reactionAggregateUnitFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionAggregateUnitFragmentModel.m15382a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionAggregateUnitFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionAggregateUnitFragmentModel.w_();
                int u_ = reactionAggregateUnitFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reaction_aggregated_units");
                    ReactionAggregatedUnitsParser.m15678a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionAggregateUnitFragmentModel.class, new Serializer());
            }
        }

        public ReactionAggregateUnitFragmentModel() {
            super(1);
        }

        @Nullable
        private ReactionAggregatedUnitsModel m15381a() {
            this.f12468d = (ReactionAggregatedUnitsModel) super.a(this.f12468d, 0, ReactionAggregatedUnitsModel.class);
            return this.f12468d;
        }

        public final int jK_() {
            return -1244013907;
        }

        public final GraphQLVisitableModel m15383a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15381a() != null) {
                ReactionAggregatedUnitsModel reactionAggregatedUnitsModel = (ReactionAggregatedUnitsModel) graphQLModelMutatingVisitor.b(m15381a());
                if (m15381a() != reactionAggregatedUnitsModel) {
                    graphQLVisitableModel = (ReactionAggregateUnitFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12468d = reactionAggregatedUnitsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15382a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15381a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1251587820)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: file IO exception on reading */
    public final class ReactionMoreAttachmentsResultModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ReactionAttachmentsModel f12472d;

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionMoreAttachmentsResultModel.class, new Deserializer());
            }

            public Object m15384a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionMoreAttachmentsResultParser.m15684a(jsonParser);
                Object reactionMoreAttachmentsResultModel = new ReactionMoreAttachmentsResultModel();
                ((BaseModel) reactionMoreAttachmentsResultModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionMoreAttachmentsResultModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionMoreAttachmentsResultModel).a();
                }
                return reactionMoreAttachmentsResultModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 471539363)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: file IO exception on reading */
        public final class ReactionAttachmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f12470d;
            @Nullable
            private DefaultPageInfoFieldsModel f12471e;

            /* compiled from: file IO exception on reading */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactionAttachmentsModel.class, new Deserializer());
                }

                public Object m15385a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionAttachmentsParser.m15682a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactionAttachmentsModel = new ReactionAttachmentsModel();
                    ((BaseModel) reactionAttachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactionAttachmentsModel instanceof Postprocessable) {
                        return ((Postprocessable) reactionAttachmentsModel).a();
                    }
                    return reactionAttachmentsModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -910659432)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: file IO exception on reading */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ReactionStoryAttachmentFragmentModel f12469d;

                /* compiled from: file IO exception on reading */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m15386a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m15680b(jsonParser, flatBufferBuilder));
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

                /* compiled from: file IO exception on reading */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m15387a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m15389a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m15681b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ReactionStoryAttachmentFragmentModel m15391a() {
                    return m15388j();
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private ReactionStoryAttachmentFragmentModel m15388j() {
                    this.f12469d = (ReactionStoryAttachmentFragmentModel) super.a(this.f12469d, 0, ReactionStoryAttachmentFragmentModel.class);
                    return this.f12469d;
                }

                public final int jK_() {
                    return -1682513983;
                }

                public final GraphQLVisitableModel m15390a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15388j() != null) {
                        ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel = (ReactionStoryAttachmentFragmentModel) graphQLModelMutatingVisitor.b(m15388j());
                        if (m15388j() != reactionStoryAttachmentFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12469d = reactionStoryAttachmentFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15389a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15388j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: file IO exception on reading */
            public class Serializer extends JsonSerializer<ReactionAttachmentsModel> {
                public final void m15392a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) obj;
                    if (reactionAttachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactionAttachmentsModel.m15393a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactionAttachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionAttachmentsParser.m15683a(reactionAttachmentsModel.w_(), reactionAttachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReactionAttachmentsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultPageInfoFields m15396b() {
                return m15397j();
            }

            public ReactionAttachmentsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m15395a() {
                this.f12470d = super.a(this.f12470d, 0, EdgesModel.class);
                return (ImmutableList) this.f12470d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m15397j() {
                this.f12471e = (DefaultPageInfoFieldsModel) super.a(this.f12471e, 1, DefaultPageInfoFieldsModel.class);
                return this.f12471e;
            }

            public final int jK_() {
                return -972595742;
            }

            public final GraphQLVisitableModel m15394a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m15395a() != null) {
                    Builder a = ModelHelper.a(m15395a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) ModelHelper.a(null, this);
                        reactionAttachmentsModel.f12470d = a.b();
                        graphQLVisitableModel = reactionAttachmentsModel;
                        if (m15397j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15397j());
                            if (m15397j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (ReactionAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f12471e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m15397j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15397j());
                    if (m15397j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (ReactionAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12471e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m15393a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15395a());
                int a2 = ModelHelper.a(flatBufferBuilder, m15397j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionMoreAttachmentsResultModel> {
            public final void m15398a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionMoreAttachmentsResultModel reactionMoreAttachmentsResultModel = (ReactionMoreAttachmentsResultModel) obj;
                if (reactionMoreAttachmentsResultModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionMoreAttachmentsResultModel.m15399a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionMoreAttachmentsResultModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionMoreAttachmentsResultModel.w_();
                int u_ = reactionMoreAttachmentsResultModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reaction_attachments");
                    ReactionAttachmentsParser.m15683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionMoreAttachmentsResultModel.class, new Serializer());
            }
        }

        public ReactionMoreAttachmentsResultModel() {
            super(1);
        }

        @Nullable
        public final ReactionAttachmentsModel m15401a() {
            this.f12472d = (ReactionAttachmentsModel) super.a(this.f12472d, 0, ReactionAttachmentsModel.class);
            return this.f12472d;
        }

        public final int jK_() {
            return -859090900;
        }

        public final GraphQLVisitableModel m15400a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15401a() != null) {
                ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) graphQLModelMutatingVisitor.b(m15401a());
                if (m15401a() != reactionAttachmentsModel) {
                    graphQLVisitableModel = (ReactionMoreAttachmentsResultModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12472d = reactionAttachmentsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15399a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15401a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1660159510)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: file IO exception on reading */
    public final class ReactionProfileAttachmentFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f12473d;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12474e;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12475f;
        @Nullable
        private ReactionProfileFieldsModel f12476g;

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionProfileAttachmentFragmentModel.class, new Deserializer());
            }

            public Object m15402a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionProfileAttachmentFragmentParser.m15685a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionProfileAttachmentFragmentModel = new ReactionProfileAttachmentFragmentModel();
                ((BaseModel) reactionProfileAttachmentFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionProfileAttachmentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionProfileAttachmentFragmentModel).a();
                }
                return reactionProfileAttachmentFragmentModel;
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionProfileAttachmentFragmentModel> {
            public final void m15403a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionProfileAttachmentFragmentModel reactionProfileAttachmentFragmentModel = (ReactionProfileAttachmentFragmentModel) obj;
                if (reactionProfileAttachmentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionProfileAttachmentFragmentModel.m15408a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionProfileAttachmentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionProfileAttachmentFragmentParser.m15686a(reactionProfileAttachmentFragmentModel.w_(), reactionProfileAttachmentFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionProfileAttachmentFragmentModel.class, new Serializer());
            }
        }

        public ReactionProfileAttachmentFragmentModel() {
            super(4);
        }

        @Nullable
        private GraphQLObjectType m15404a() {
            if (this.b != null && this.f12473d == null) {
                this.f12473d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12473d;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15405j() {
            this.f12474e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12474e, 1, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12474e;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15406k() {
            this.f12475f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12475f, 2, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12475f;
        }

        @Nullable
        private ReactionProfileFieldsModel m15407l() {
            this.f12476g = (ReactionProfileFieldsModel) super.a(this.f12476g, 3, ReactionProfileFieldsModel.class);
            return this.f12476g;
        }

        public final int jK_() {
            return -1677771153;
        }

        public final GraphQLVisitableModel m15409a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15405j() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15405j());
                if (m15405j() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionProfileAttachmentFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12474e = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15406k() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15406k());
                if (m15406k() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionProfileAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12475f = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15407l() != null) {
                ReactionProfileFieldsModel reactionProfileFieldsModel = (ReactionProfileFieldsModel) graphQLModelMutatingVisitor.b(m15407l());
                if (m15407l() != reactionProfileFieldsModel) {
                    graphQLVisitableModel = (ReactionProfileAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12476g = reactionProfileFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15408a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15404a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15405j());
            int a3 = ModelHelper.a(flatBufferBuilder, m15406k());
            int a4 = ModelHelper.a(flatBufferBuilder, m15407l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -771506062)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: file IO exception on reading */
    public final class ReactionProfileAttachmentsResultModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ReactionAttachmentsModel f12480d;

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionProfileAttachmentsResultModel.class, new Deserializer());
            }

            public Object m15410a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionProfileAttachmentsResultParser.m15691a(jsonParser);
                Object reactionProfileAttachmentsResultModel = new ReactionProfileAttachmentsResultModel();
                ((BaseModel) reactionProfileAttachmentsResultModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionProfileAttachmentsResultModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionProfileAttachmentsResultModel).a();
                }
                return reactionProfileAttachmentsResultModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 730421924)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: file IO exception on reading */
        public final class ReactionAttachmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f12478d;
            @Nullable
            private DefaultPageInfoFieldsModel f12479e;

            /* compiled from: file IO exception on reading */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactionAttachmentsModel.class, new Deserializer());
                }

                public Object m15411a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionProfileAttachmentsResultParser.ReactionAttachmentsParser.m15689a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactionAttachmentsModel = new ReactionAttachmentsModel();
                    ((BaseModel) reactionAttachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactionAttachmentsModel instanceof Postprocessable) {
                        return ((Postprocessable) reactionAttachmentsModel).a();
                    }
                    return reactionAttachmentsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -654829649)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: file IO exception on reading */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ReactionProfileAttachmentFragmentModel f12477d;

                /* compiled from: file IO exception on reading */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m15412a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ReactionProfileAttachmentsResultParser.ReactionAttachmentsParser.EdgesParser.m15687b(jsonParser, flatBufferBuilder));
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

                /* compiled from: file IO exception on reading */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m15413a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m15415a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ReactionProfileAttachmentsResultParser.ReactionAttachmentsParser.EdgesParser.m15688b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private ReactionProfileAttachmentFragmentModel m15414a() {
                    this.f12477d = (ReactionProfileAttachmentFragmentModel) super.a(this.f12477d, 0, ReactionProfileAttachmentFragmentModel.class);
                    return this.f12477d;
                }

                public final int jK_() {
                    return -1682513983;
                }

                public final GraphQLVisitableModel m15416a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15414a() != null) {
                        ReactionProfileAttachmentFragmentModel reactionProfileAttachmentFragmentModel = (ReactionProfileAttachmentFragmentModel) graphQLModelMutatingVisitor.b(m15414a());
                        if (m15414a() != reactionProfileAttachmentFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12477d = reactionProfileAttachmentFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15415a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15414a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: file IO exception on reading */
            public class Serializer extends JsonSerializer<ReactionAttachmentsModel> {
                public final void m15417a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) obj;
                    if (reactionAttachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactionAttachmentsModel.m15420a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactionAttachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionProfileAttachmentsResultParser.ReactionAttachmentsParser.m15690a(reactionAttachmentsModel.w_(), reactionAttachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReactionAttachmentsModel.class, new Serializer());
                }
            }

            public ReactionAttachmentsModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m15418a() {
                this.f12478d = super.a(this.f12478d, 0, EdgesModel.class);
                return (ImmutableList) this.f12478d;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m15419j() {
                this.f12479e = (DefaultPageInfoFieldsModel) super.a(this.f12479e, 1, DefaultPageInfoFieldsModel.class);
                return this.f12479e;
            }

            public final int jK_() {
                return -972595742;
            }

            public final GraphQLVisitableModel m15421a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m15418a() != null) {
                    Builder a = ModelHelper.a(m15418a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) ModelHelper.a(null, this);
                        reactionAttachmentsModel.f12478d = a.b();
                        graphQLVisitableModel = reactionAttachmentsModel;
                        if (m15419j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15419j());
                            if (m15419j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (ReactionAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f12479e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m15419j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15419j());
                    if (m15419j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (ReactionAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12479e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m15420a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15418a());
                int a2 = ModelHelper.a(flatBufferBuilder, m15419j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionProfileAttachmentsResultModel> {
            public final void m15422a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionProfileAttachmentsResultModel reactionProfileAttachmentsResultModel = (ReactionProfileAttachmentsResultModel) obj;
                if (reactionProfileAttachmentsResultModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionProfileAttachmentsResultModel.m15424a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionProfileAttachmentsResultModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionProfileAttachmentsResultModel.w_();
                int u_ = reactionProfileAttachmentsResultModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reaction_attachments");
                    ReactionProfileAttachmentsResultParser.ReactionAttachmentsParser.m15690a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionProfileAttachmentsResultModel.class, new Serializer());
            }
        }

        public ReactionProfileAttachmentsResultModel() {
            super(1);
        }

        @Nullable
        private ReactionAttachmentsModel m15423a() {
            this.f12480d = (ReactionAttachmentsModel) super.a(this.f12480d, 0, ReactionAttachmentsModel.class);
            return this.f12480d;
        }

        public final int jK_() {
            return -859090900;
        }

        public final GraphQLVisitableModel m15425a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15423a() != null) {
                ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) graphQLModelMutatingVisitor.b(m15423a());
                if (m15423a() != reactionAttachmentsModel) {
                    graphQLVisitableModel = (ReactionProfileAttachmentsResultModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12480d = reactionAttachmentsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15424a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15423a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1053042682)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: file IO exception on reading */
    public final class ReactionQueryFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ReactionUnitsModel f12485d;

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionQueryFragmentModel.class, new Deserializer());
            }

            public Object m15426a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionQueryFragmentParser.m15694a(jsonParser);
                Object reactionQueryFragmentModel = new ReactionQueryFragmentModel();
                ((BaseModel) reactionQueryFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionQueryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionQueryFragmentModel).a();
                }
                return reactionQueryFragmentModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1967160805)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: file IO exception on reading */
        public final class ReactionUnitsModel extends BaseModel implements GraphQLVisitableModel, ReactionStories {
            @Nullable
            private List<EdgesModel> f12481d;
            @Nullable
            private DefaultPageInfoFieldsModel f12482e;
            @Nullable
            private PlaceTipWelcomeHeaderFragmentModel f12483f;
            @Nullable
            private String f12484g;

            /* compiled from: file IO exception on reading */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactionUnitsModel.class, new Deserializer());
                }

                public Object m15427a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionUnitsParser.m15692a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactionUnitsModel = new ReactionUnitsModel();
                    ((BaseModel) reactionUnitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactionUnitsModel instanceof Postprocessable) {
                        return ((Postprocessable) reactionUnitsModel).a();
                    }
                    return reactionUnitsModel;
                }
            }

            /* compiled from: file IO exception on reading */
            public class Serializer extends JsonSerializer<ReactionUnitsModel> {
                public final void m15428a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactionUnitsModel reactionUnitsModel = (ReactionUnitsModel) obj;
                    if (reactionUnitsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactionUnitsModel.m15431a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactionUnitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionUnitsParser.m15693a(reactionUnitsModel.w_(), reactionUnitsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReactionUnitsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PlaceTipWelcomeHeaderFragmentModel m15434b() {
                return m15430k();
            }

            @Nullable
            public final /* synthetic */ DefaultPageInfoFields mo829c() {
                return m15429j();
            }

            public ReactionUnitsModel() {
                super(4);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> mo828a() {
                this.f12481d = super.a(this.f12481d, 0, EdgesModel.class);
                return (ImmutableList) this.f12481d;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m15429j() {
                this.f12482e = (DefaultPageInfoFieldsModel) super.a(this.f12482e, 1, DefaultPageInfoFieldsModel.class);
                return this.f12482e;
            }

            @Nullable
            private PlaceTipWelcomeHeaderFragmentModel m15430k() {
                this.f12483f = (PlaceTipWelcomeHeaderFragmentModel) super.a(this.f12483f, 2, PlaceTipWelcomeHeaderFragmentModel.class);
                return this.f12483f;
            }

            @Nullable
            public final String mo830d() {
                this.f12484g = super.a(this.f12484g, 3);
                return this.f12484g;
            }

            public final int jK_() {
                return 1178956324;
            }

            public final GraphQLVisitableModel m15432a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                PlaceTipWelcomeHeaderFragmentModel placeTipWelcomeHeaderFragmentModel;
                h();
                if (mo828a() != null) {
                    Builder a = ModelHelper.a(mo828a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        ReactionUnitsModel reactionUnitsModel = (ReactionUnitsModel) ModelHelper.a(null, this);
                        reactionUnitsModel.f12481d = a.b();
                        graphQLVisitableModel = reactionUnitsModel;
                        if (m15429j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15429j());
                            if (m15429j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (ReactionUnitsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f12482e = defaultPageInfoFieldsModel;
                            }
                        }
                        if (m15430k() != null) {
                            placeTipWelcomeHeaderFragmentModel = (PlaceTipWelcomeHeaderFragmentModel) graphQLModelMutatingVisitor.b(m15430k());
                            if (m15430k() != placeTipWelcomeHeaderFragmentModel) {
                                graphQLVisitableModel = (ReactionUnitsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f12483f = placeTipWelcomeHeaderFragmentModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m15429j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15429j());
                    if (m15429j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (ReactionUnitsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12482e = defaultPageInfoFieldsModel;
                    }
                }
                if (m15430k() != null) {
                    placeTipWelcomeHeaderFragmentModel = (PlaceTipWelcomeHeaderFragmentModel) graphQLModelMutatingVisitor.b(m15430k());
                    if (m15430k() != placeTipWelcomeHeaderFragmentModel) {
                        graphQLVisitableModel = (ReactionUnitsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12483f = placeTipWelcomeHeaderFragmentModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m15431a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, mo828a());
                int a2 = ModelHelper.a(flatBufferBuilder, m15429j());
                int a3 = ModelHelper.a(flatBufferBuilder, m15430k());
                int b = flatBufferBuilder.b(mo830d());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionQueryFragmentModel> {
            public final void m15437a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionQueryFragmentModel reactionQueryFragmentModel = (ReactionQueryFragmentModel) obj;
                if (reactionQueryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionQueryFragmentModel.m15438a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionQueryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionQueryFragmentModel.w_();
                int u_ = reactionQueryFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reaction_units");
                    ReactionUnitsParser.m15693a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionQueryFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ReactionUnitsModel m15440a() {
            return m15441j();
        }

        public ReactionQueryFragmentModel() {
            super(1);
        }

        @Nullable
        public final ReactionUnitsModel m15441j() {
            this.f12485d = (ReactionUnitsModel) super.a(this.f12485d, 0, ReactionUnitsModel.class);
            return this.f12485d;
        }

        public final int jK_() {
            return -128271569;
        }

        public final GraphQLVisitableModel m15439a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15441j() != null) {
                ReactionUnitsModel reactionUnitsModel = (ReactionUnitsModel) graphQLModelMutatingVisitor.b(m15441j());
                if (m15441j() != reactionUnitsModel) {
                    graphQLVisitableModel = (ReactionQueryFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12485d = reactionUnitsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15438a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15441j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 638259996)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: file IO exception on reading */
    public final class ReactionStoriesModel extends BaseModel implements GraphQLVisitableModel, ReactionStories {
        @Nullable
        private List<EdgesModel> f12491d;
        @Nullable
        private DefaultPageInfoFieldsModel f12492e;
        @Nullable
        private String f12493f;

        /* compiled from: file IO exception on reading */
        public final class Builder {
            @Nullable
            public ImmutableList<EdgesModel> f12486a;
            @Nullable
            public DefaultPageInfoFieldsModel f12487b;
            @Nullable
            public String f12488c;

            public final ReactionStoriesModel m15442a() {
                return new ReactionStoriesModel(this);
            }
        }

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionStoriesModel.class, new Deserializer());
            }

            public Object m15443a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionStoriesParser.m15699a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionStoriesModel = new ReactionStoriesModel();
                ((BaseModel) reactionStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionStoriesModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionStoriesModel).a();
                }
                return reactionStoriesModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1861402480)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: file IO exception on reading */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ReactionUnitFragmentModel f12490d;

            /* compiled from: file IO exception on reading */
            public final class Builder {
                @Nullable
                public ReactionUnitFragmentModel f12489a;

                public final EdgesModel m15444a() {
                    return new EdgesModel(this);
                }
            }

            /* compiled from: file IO exception on reading */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m15445a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionStoriesParser.EdgesParser.m15697b(jsonParser, flatBufferBuilder));
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

            /* compiled from: file IO exception on reading */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m15446a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m15448a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionStoriesParser.EdgesParser.m15698b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ReactionUnitFragment m15450a() {
                return m15451j();
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            public final ReactionUnitFragmentModel m15451j() {
                this.f12490d = (ReactionUnitFragmentModel) super.a(this.f12490d, 0, ReactionUnitFragmentModel.class);
                return this.f12490d;
            }

            public static EdgesModel m15447a(EdgesModel edgesModel) {
                if (edgesModel == null) {
                    return null;
                }
                if (edgesModel instanceof EdgesModel) {
                    return edgesModel;
                }
                Builder builder = new Builder();
                builder.f12489a = ReactionUnitFragmentModel.m15630a(edgesModel.m15450a());
                return builder.m15444a();
            }

            public EdgesModel(Builder builder) {
                super(1);
                this.f12490d = builder.f12489a;
            }

            public final int jK_() {
                return 1478610307;
            }

            public final GraphQLVisitableModel m15449a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15451j() != null) {
                    ReactionUnitFragmentModel reactionUnitFragmentModel = (ReactionUnitFragmentModel) graphQLModelMutatingVisitor.b(m15451j());
                    if (m15451j() != reactionUnitFragmentModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12490d = reactionUnitFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15448a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15451j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionStoriesModel> {
            public final void m15452a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionStoriesModel reactionStoriesModel = (ReactionStoriesModel) obj;
                if (reactionStoriesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionStoriesModel.m15454a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionStoriesParser.m15700a(reactionStoriesModel.w_(), reactionStoriesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionStoriesModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultPageInfoFields mo829c() {
            return m15459j();
        }

        public ReactionStoriesModel() {
            super(3);
        }

        @Nonnull
        public final ImmutableList<EdgesModel> mo828a() {
            this.f12491d = super.a(this.f12491d, 0, EdgesModel.class);
            return (ImmutableList) this.f12491d;
        }

        @Nullable
        public final DefaultPageInfoFieldsModel m15459j() {
            this.f12492e = (DefaultPageInfoFieldsModel) super.a(this.f12492e, 1, DefaultPageInfoFieldsModel.class);
            return this.f12492e;
        }

        @Nullable
        public final String mo830d() {
            this.f12493f = super.a(this.f12493f, 2);
            return this.f12493f;
        }

        public static ReactionStoriesModel m15453a(ReactionStories reactionStories) {
            if (reactionStories == null) {
                return null;
            }
            if (reactionStories instanceof ReactionStoriesModel) {
                return (ReactionStoriesModel) reactionStories;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < reactionStories.mo828a().size(); i++) {
                builder2.c(EdgesModel.m15447a((EdgesModel) reactionStories.mo828a().get(i)));
            }
            builder.f12486a = builder2.b();
            builder.f12487b = DefaultPageInfoFieldsModel.a(reactionStories.mo829c());
            builder.f12488c = reactionStories.mo830d();
            return builder.m15442a();
        }

        public ReactionStoriesModel(Builder builder) {
            super(3);
            this.f12491d = builder.f12486a;
            this.f12492e = builder.f12487b;
            this.f12493f = builder.f12488c;
        }

        public final int jK_() {
            return 1178956324;
        }

        public final GraphQLVisitableModel m15455a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (mo828a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(mo828a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ReactionStoriesModel reactionStoriesModel = (ReactionStoriesModel) ModelHelper.a(null, this);
                    reactionStoriesModel.f12491d = a.b();
                    graphQLVisitableModel = reactionStoriesModel;
                    if (m15459j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15459j());
                        if (m15459j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (ReactionStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12492e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m15459j() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15459j());
                if (m15459j() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (ReactionStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12492e = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m15454a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo828a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15459j());
            int b = flatBufferBuilder.b(mo830d());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 103974643)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: file IO exception on reading */
    public final class ReactionStoryAttachmentFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionAttributionFooterAttachmentFields, ReactionCriticReviewAttachmentFields, ReactionPageCommerceAttachmentFields, ReactionPageInviteFriendToLikeAttachmentFields, ReactionPagePromotionAttachmentFields, ReactionStoryAdminPageAttachmentFragment, ReactionStoryTopicAttachmentFragment {
        @Nullable
        private DefaultLocationFieldsModel f12552A;
        @Nullable
        private MessageModel f12553B;
        @Nullable
        private PageModel f12554C;
        @Nullable
        private GraphQLStory f12555D;
        @Nullable
        private PageProductModel f12556E;
        @Nullable
        private PageServiceItemModel f12557F;
        @Nullable
        private SizeAwareMediaModel f12558G;
        @Nullable
        private String f12559H;
        @Nullable
        private String f12560I;
        @Nullable
        private PlaceQuestionFieldsModel f12561J;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12562K;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12563L;
        private int f12564M;
        @Nullable
        private ProductModel f12565N;
        @Nullable
        private ReactionProfileFieldsModel f12566O;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12567P;
        private double f12568Q;
        @Nullable
        private PageMediaWithAttributionModel f12569R;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12570S;
        @Nullable
        private ReviewerModel f12571T;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12572U;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12573V;
        @Nullable
        private ReactionImageFieldsModel f12574W;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12575X;
        @Nullable
        private ReactionStoryAttachmentStoryFragmentModel f12576Y;
        @Nullable
        private StoryAdminPageModel f12577Z;
        @Nullable
        private ReactionImageFieldsModel aa;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel ab;
        @Nullable
        private TopicModel ac;
        private int ad;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel ae;
        private int af;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel ag;
        @Nullable
        private VideoDetailFragmentModel ah;
        @Nullable
        private GraphQLObjectType f12578d;
        @Nullable
        private List<ReactionAttachmentActionFragmentModel> f12579e;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12580f;
        @Nullable
        private String f12581g;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12582h;
        @Nullable
        private AttributionModel f12583i;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12584j;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12585k;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12586l;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12587m;
        @Nullable
        private GraphQLStory f12588n;
        private int f12589o;
        @Nullable
        private EventCardFragmentModel f12590p;
        @Nullable
        private ExternalImageModel f12591q;
        @Nullable
        private String f12592r;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12593s;
        @Nullable
        private ReactionImageFieldsModel f12594t;
        @Nullable
        private InviteeModel f12595u;
        private boolean f12596v;
        @Nullable
        private ItemModel f12597w;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12598x;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12599y;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12600z;

        /* compiled from: file IO exception on reading */
        public final class Builder {
            @Nullable
            public GraphQLStory f12494A;
            @Nullable
            public PageProductModel f12495B;
            @Nullable
            public PageServiceItemModel f12496C;
            @Nullable
            public SizeAwareMediaModel f12497D;
            @Nullable
            public String f12498E;
            @Nullable
            public String f12499F;
            @Nullable
            public PlaceQuestionFieldsModel f12500G;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12501H;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12502I;
            public int f12503J;
            @Nullable
            public ProductModel f12504K;
            @Nullable
            public ReactionProfileFieldsModel f12505L;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12506M;
            public double f12507N;
            @Nullable
            public PageMediaWithAttributionModel f12508O;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12509P;
            @Nullable
            public ReviewerModel f12510Q;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12511R;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12512S;
            @Nullable
            public ReactionImageFieldsModel f12513T;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12514U;
            @Nullable
            public ReactionStoryAttachmentStoryFragmentModel f12515V;
            @Nullable
            public StoryAdminPageModel f12516W;
            @Nullable
            public ReactionImageFieldsModel f12517X;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12518Y;
            @Nullable
            public TopicModel f12519Z;
            @Nullable
            public GraphQLObjectType f12520a;
            public int aa;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel ab;
            public int ac;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel ad;
            @Nullable
            public VideoDetailFragmentModel ae;
            @Nullable
            public ImmutableList<ReactionAttachmentActionFragmentModel> f12521b;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12522c;
            @Nullable
            public String f12523d;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12524e;
            @Nullable
            public AttributionModel f12525f;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12526g;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12527h;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12528i;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12529j;
            @Nullable
            public GraphQLStory f12530k;
            public int f12531l;
            @Nullable
            public EventCardFragmentModel f12532m;
            @Nullable
            public ExternalImageModel f12533n;
            @Nullable
            public String f12534o;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12535p;
            @Nullable
            public ReactionImageFieldsModel f12536q;
            @Nullable
            public InviteeModel f12537r;
            public boolean f12538s;
            @Nullable
            public ItemModel f12539t;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12540u;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12541v;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12542w;
            @Nullable
            public DefaultLocationFieldsModel f12543x;
            @Nullable
            public MessageModel f12544y;
            @Nullable
            public PageModel f12545z;
        }

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionStoryAttachmentFragmentModel.class, new Deserializer());
            }

            public Object m15460a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionStoryAttachmentFragmentParser.m15705a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionStoryAttachmentFragmentModel = new ReactionStoryAttachmentFragmentModel();
                ((BaseModel) reactionStoryAttachmentFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionStoryAttachmentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionStoryAttachmentFragmentModel).a();
                }
                return reactionStoryAttachmentFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -278075691)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: file IO exception on reading */
        public final class MessageModel extends BaseModel implements DefaultTextWithEntitiesFields, GraphQLVisitableModel, ReactionTextWithEntitiesWithImages {
            @Nullable
            private List<ImageRangesModel> f12548d;
            @Nullable
            private String f12549e;

            /* compiled from: file IO exception on reading */
            public final class Builder {
                @Nullable
                public ImmutableList<ImageRangesModel> f12546a;
                @Nullable
                public String f12547b;
            }

            /* compiled from: file IO exception on reading */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageModel.class, new Deserializer());
                }

                public Object m15461a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageParser.m15701a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messageModel = new MessageModel();
                    ((BaseModel) messageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messageModel instanceof Postprocessable) {
                        return ((Postprocessable) messageModel).a();
                    }
                    return messageModel;
                }
            }

            /* compiled from: file IO exception on reading */
            public class Serializer extends JsonSerializer<MessageModel> {
                public final void m15462a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageModel messageModel = (MessageModel) obj;
                    if (messageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageModel.m15464a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageParser.m15702a(messageModel.w_(), messageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessageModel.class, new Serializer());
                }
            }

            public MessageModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<ImageRangesModel> mo786b() {
                this.f12548d = super.a(this.f12548d, 0, ImageRangesModel.class);
                return (ImmutableList) this.f12548d;
            }

            @Nullable
            public final String mo785a() {
                this.f12549e = super.a(this.f12549e, 1);
                return this.f12549e;
            }

            public static MessageModel m15463a(MessageModel messageModel) {
                if (messageModel == null) {
                    return null;
                }
                if (messageModel instanceof MessageModel) {
                    return messageModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < messageModel.mo786b().size(); i++) {
                    builder2.c(ImageRangesModel.m14660a((ImageRangesModel) messageModel.mo786b().get(i)));
                }
                builder.f12546a = builder2.b();
                builder.f12547b = messageModel.mo785a();
                return new MessageModel(builder);
            }

            public MessageModel(Builder builder) {
                super(2);
                this.f12548d = builder.f12546a;
                this.f12549e = builder.f12547b;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m15465a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (mo786b() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(mo786b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12548d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15464a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, mo786b());
                int b = flatBufferBuilder.b(mo785a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: file IO exception on reading */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12551d;

            /* compiled from: file IO exception on reading */
            public final class Builder {
                @Nullable
                public String f12550a;
            }

            /* compiled from: file IO exception on reading */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m15468a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m15703a(jsonParser, flatBufferBuilder));
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

            /* compiled from: file IO exception on reading */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m15469a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m15471a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m15704a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(1);
            }

            public final void m15474a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15475a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m15476b() {
                this.f12551d = super.a(this.f12551d, 0);
                return this.f12551d;
            }

            public static PageModel m15470a(PageModel pageModel) {
                if (pageModel == null) {
                    return null;
                }
                if (pageModel instanceof PageModel) {
                    return pageModel;
                }
                Builder builder = new Builder();
                builder.f12550a = pageModel.m15476b();
                return new PageModel(builder);
            }

            public PageModel(Builder builder) {
                super(1);
                this.f12551d = builder.f12550a;
            }

            @Nullable
            public final String m15473a() {
                return m15476b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m15472a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15471a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15476b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionStoryAttachmentFragmentModel> {
            public final void m15477a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel = (ReactionStoryAttachmentFragmentModel) obj;
                if (reactionStoryAttachmentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionStoryAttachmentFragmentModel.m15505a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionStoryAttachmentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionStoryAttachmentFragmentParser.m15706a(reactionStoryAttachmentFragmentModel.w_(), reactionStoryAttachmentFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionStoryAttachmentFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PageModel m15479A() {
            return ay();
        }

        @Nullable
        public final /* synthetic */ PageProductModel m15481C() {
            return az();
        }

        @Nullable
        public final /* synthetic */ PageServiceItemModel m15482D() {
            return aA();
        }

        @Nullable
        public final /* synthetic */ SizeAwareMedia m15483E() {
            return aB();
        }

        @Nullable
        public final /* synthetic */ PlaceQuestionFieldsModel m15486H() {
            return aC();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15487I() {
            return aD();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15488J() {
            return aE();
        }

        @Nullable
        public final /* synthetic */ ProductModel m15490L() {
            return aF();
        }

        @Nullable
        public final /* synthetic */ ReactionProfileFields m15491M() {
            return aG();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15492N() {
            return aH();
        }

        @Nullable
        public final /* synthetic */ PageMediaWithAttribution m15494P() {
            return aI();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15495Q() {
            return aJ();
        }

        @Nullable
        public final /* synthetic */ ReviewerModel m15496R() {
            return aK();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15497S() {
            return aL();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15498T() {
            return aM();
        }

        @Nullable
        public final /* synthetic */ ReactionImageFields m15499U() {
            return aN();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15500V() {
            return aO();
        }

        @Nullable
        public final /* synthetic */ ReactionStoryAttachmentStoryFragmentModel m15501W() {
            return aP();
        }

        @Nullable
        public final /* synthetic */ StoryAdminPageModel m15502X() {
            return aQ();
        }

        @Nullable
        public final /* synthetic */ ReactionImageFields m15503Y() {
            return aR();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15504Z() {
            return aS();
        }

        @Nullable
        public final /* synthetic */ TopicModel aa() {
            return aT();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields ac() {
            return aU();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields ae() {
            return aV();
        }

        @Nullable
        public final /* synthetic */ VideoDetailFragmentModel af() {
            return aW();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15510c() {
            return ag();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields fr_() {
            return ak();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields fs_() {
            return aj();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields ft_() {
            return ah();
        }

        @Nullable
        public final /* synthetic */ AttributionModel m15512g() {
            return ai();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15513j() {
            return al();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15514k() {
            return am();
        }

        @Nullable
        public final /* synthetic */ EventCardFragment m15517n() {
            return an();
        }

        @Nullable
        public final /* synthetic */ ExternalImageModel m15518o() {
            return ao();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15520q() {
            return ap();
        }

        @Nullable
        public final /* synthetic */ ReactionImageFields m15521r() {
            return aq();
        }

        @Nullable
        public final /* synthetic */ InviteeModel m15522s() {
            return ar();
        }

        @Nullable
        public final /* synthetic */ ItemModel m15524u() {
            return as();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15525v() {
            return at();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15526w() {
            return au();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15527x() {
            return av();
        }

        @Nullable
        public final /* synthetic */ DefaultLocationFields m15528y() {
            return aw();
        }

        @Nullable
        public final /* synthetic */ MessageModel m15529z() {
            return ax();
        }

        public ReactionStoryAttachmentFragmentModel() {
            super(57);
        }

        @Nullable
        public final GraphQLObjectType m15506a() {
            if (this.b != null && this.f12578d == null) {
                this.f12578d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12578d;
        }

        @Nonnull
        public final ImmutableList<ReactionAttachmentActionFragmentModel> m15509b() {
            this.f12579e = super.a(this.f12579e, 1, ReactionAttachmentActionFragmentModel.class);
            return (ImmutableList) this.f12579e;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel ag() {
            this.f12580f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12580f, 2, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12580f;
        }

        @Nullable
        public final String m15511d() {
            this.f12581g = super.a(this.f12581g, 3);
            return this.f12581g;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel ah() {
            this.f12582h = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12582h, 4, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12582h;
        }

        @Nullable
        private AttributionModel ai() {
            this.f12583i = (AttributionModel) super.a(this.f12583i, 5, AttributionModel.class);
            return this.f12583i;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel aj() {
            this.f12584j = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12584j, 6, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12584j;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel ak() {
            this.f12585k = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12585k, 7, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12585k;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel al() {
            this.f12586l = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12586l, 8, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12586l;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel am() {
            this.f12587m = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12587m, 9, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12587m;
        }

        @Nullable
        public final GraphQLStory m15515l() {
            this.f12588n = (GraphQLStory) super.a(this.f12588n, 10, GraphQLStory.class);
            return this.f12588n;
        }

        public final int m15516m() {
            a(1, 3);
            return this.f12589o;
        }

        @Nullable
        private EventCardFragmentModel an() {
            this.f12590p = (EventCardFragmentModel) super.a(this.f12590p, 12, EventCardFragmentModel.class);
            return this.f12590p;
        }

        @Nullable
        private ExternalImageModel ao() {
            this.f12591q = (ExternalImageModel) super.a(this.f12591q, 13, ExternalImageModel.class);
            return this.f12591q;
        }

        @Nullable
        public final String m15519p() {
            this.f12592r = super.a(this.f12592r, 14);
            return this.f12592r;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel ap() {
            this.f12593s = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12593s, 15, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12593s;
        }

        @Nullable
        private ReactionImageFieldsModel aq() {
            this.f12594t = (ReactionImageFieldsModel) super.a(this.f12594t, 16, ReactionImageFieldsModel.class);
            return this.f12594t;
        }

        @Nullable
        private InviteeModel ar() {
            this.f12595u = (InviteeModel) super.a(this.f12595u, 17, InviteeModel.class);
            return this.f12595u;
        }

        public final boolean m15523t() {
            a(2, 2);
            return this.f12596v;
        }

        @Nullable
        private ItemModel as() {
            this.f12597w = (ItemModel) super.a(this.f12597w, 19, ItemModel.class);
            return this.f12597w;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel at() {
            this.f12598x = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12598x, 20, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12598x;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel au() {
            this.f12599y = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12599y, 21, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12599y;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel av() {
            this.f12600z = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12600z, 22, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12600z;
        }

        @Nullable
        private DefaultLocationFieldsModel aw() {
            this.f12552A = (DefaultLocationFieldsModel) super.a(this.f12552A, 23, DefaultLocationFieldsModel.class);
            return this.f12552A;
        }

        @Nullable
        private MessageModel ax() {
            this.f12553B = (MessageModel) super.a(this.f12553B, 24, MessageModel.class);
            return this.f12553B;
        }

        @Nullable
        private PageModel ay() {
            this.f12554C = (PageModel) super.a(this.f12554C, 25, PageModel.class);
            return this.f12554C;
        }

        @Nullable
        public final GraphQLStory m15480B() {
            this.f12555D = (GraphQLStory) super.a(this.f12555D, 26, GraphQLStory.class);
            return this.f12555D;
        }

        @Nullable
        private PageProductModel az() {
            this.f12556E = (PageProductModel) super.a(this.f12556E, 27, PageProductModel.class);
            return this.f12556E;
        }

        @Nullable
        private PageServiceItemModel aA() {
            this.f12557F = (PageServiceItemModel) super.a(this.f12557F, 28, PageServiceItemModel.class);
            return this.f12557F;
        }

        @Nullable
        private SizeAwareMediaModel aB() {
            this.f12558G = (SizeAwareMediaModel) super.a(this.f12558G, 29, SizeAwareMediaModel.class);
            return this.f12558G;
        }

        @Nullable
        public final String m15484F() {
            this.f12559H = super.a(this.f12559H, 30);
            return this.f12559H;
        }

        @Nullable
        public final String m15485G() {
            this.f12560I = super.a(this.f12560I, 31);
            return this.f12560I;
        }

        @Nullable
        private PlaceQuestionFieldsModel aC() {
            this.f12561J = (PlaceQuestionFieldsModel) super.a(this.f12561J, 32, PlaceQuestionFieldsModel.class);
            return this.f12561J;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel aD() {
            this.f12562K = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12562K, 33, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12562K;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel aE() {
            this.f12563L = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12563L, 34, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12563L;
        }

        public final int m15489K() {
            a(4, 3);
            return this.f12564M;
        }

        @Nullable
        private ProductModel aF() {
            this.f12565N = (ProductModel) super.a(this.f12565N, 36, ProductModel.class);
            return this.f12565N;
        }

        @Nullable
        private ReactionProfileFieldsModel aG() {
            this.f12566O = (ReactionProfileFieldsModel) super.a(this.f12566O, 37, ReactionProfileFieldsModel.class);
            return this.f12566O;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel aH() {
            this.f12567P = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12567P, 38, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12567P;
        }

        public final double m15493O() {
            a(4, 7);
            return this.f12568Q;
        }

        @Nullable
        private PageMediaWithAttributionModel aI() {
            this.f12569R = (PageMediaWithAttributionModel) super.a(this.f12569R, 40, PageMediaWithAttributionModel.class);
            return this.f12569R;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel aJ() {
            this.f12570S = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12570S, 41, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12570S;
        }

        @Nullable
        private ReviewerModel aK() {
            this.f12571T = (ReviewerModel) super.a(this.f12571T, 42, ReviewerModel.class);
            return this.f12571T;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel aL() {
            this.f12572U = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12572U, 43, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12572U;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel aM() {
            this.f12573V = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12573V, 44, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12573V;
        }

        @Nullable
        private ReactionImageFieldsModel aN() {
            this.f12574W = (ReactionImageFieldsModel) super.a(this.f12574W, 45, ReactionImageFieldsModel.class);
            return this.f12574W;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel aO() {
            this.f12575X = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12575X, 46, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12575X;
        }

        @Nullable
        private ReactionStoryAttachmentStoryFragmentModel aP() {
            this.f12576Y = (ReactionStoryAttachmentStoryFragmentModel) super.a(this.f12576Y, 47, ReactionStoryAttachmentStoryFragmentModel.class);
            return this.f12576Y;
        }

        @Nullable
        private StoryAdminPageModel aQ() {
            this.f12577Z = (StoryAdminPageModel) super.a(this.f12577Z, 48, StoryAdminPageModel.class);
            return this.f12577Z;
        }

        @Nullable
        private ReactionImageFieldsModel aR() {
            this.aa = (ReactionImageFieldsModel) super.a(this.aa, 49, ReactionImageFieldsModel.class);
            return this.aa;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel aS() {
            this.ab = (DefaultTextWithEntitiesFieldsModel) super.a(this.ab, 50, DefaultTextWithEntitiesFieldsModel.class);
            return this.ab;
        }

        @Nullable
        private TopicModel aT() {
            this.ac = (TopicModel) super.a(this.ac, 51, TopicModel.class);
            return this.ac;
        }

        public final int ab() {
            a(6, 4);
            return this.ad;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel aU() {
            this.ae = (DefaultTextWithEntitiesFieldsModel) super.a(this.ae, 53, DefaultTextWithEntitiesFieldsModel.class);
            return this.ae;
        }

        public final int ad() {
            a(6, 6);
            return this.af;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel aV() {
            this.ag = (DefaultTextWithEntitiesFieldsModel) super.a(this.ag, 55, DefaultTextWithEntitiesFieldsModel.class);
            return this.ag;
        }

        @Nullable
        private VideoDetailFragmentModel aW() {
            this.ah = (VideoDetailFragmentModel) super.a(this.ah, 56, VideoDetailFragmentModel.class);
            return this.ah;
        }

        public static ReactionStoryAttachmentFragmentModel m15478a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
            if (reactionStoryAttachmentFragmentModel == null) {
                return null;
            }
            if (reactionStoryAttachmentFragmentModel instanceof ReactionStoryAttachmentFragmentModel) {
                return reactionStoryAttachmentFragmentModel;
            }
            Builder builder = new Builder();
            builder.f12520a = reactionStoryAttachmentFragmentModel.m15506a();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < reactionStoryAttachmentFragmentModel.m15509b().size(); i++) {
                builder2.c(ReactionAttachmentActionFragmentModel.m15943a((ReactionAttachmentActionFragmentModel) reactionStoryAttachmentFragmentModel.m15509b().get(i)));
            }
            builder.f12521b = builder2.b();
            builder.f12522c = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15510c());
            builder.f12523d = reactionStoryAttachmentFragmentModel.m15511d();
            builder.f12524e = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.ft_());
            builder.f12525f = AttributionModel.m14249a(reactionStoryAttachmentFragmentModel.m15512g());
            builder.f12526g = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.fs_());
            builder.f12527h = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.fr_());
            builder.f12528i = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15513j());
            builder.f12529j = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15514k());
            builder.f12530k = reactionStoryAttachmentFragmentModel.m15515l();
            builder.f12531l = reactionStoryAttachmentFragmentModel.m15516m();
            builder.f12532m = EventCardFragmentModel.a(reactionStoryAttachmentFragmentModel.m15517n());
            builder.f12533n = ExternalImageModel.m14264a(reactionStoryAttachmentFragmentModel.m15518o());
            builder.f12534o = reactionStoryAttachmentFragmentModel.m15519p();
            builder.f12535p = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15520q());
            builder.f12536q = ReactionImageFieldsModel.m14497a(reactionStoryAttachmentFragmentModel.m15521r());
            builder.f12537r = InviteeModel.m14321a(reactionStoryAttachmentFragmentModel.m15522s());
            builder.f12538s = reactionStoryAttachmentFragmentModel.m15523t();
            builder.f12539t = ItemModel.m14347a(reactionStoryAttachmentFragmentModel.m15524u());
            builder.f12540u = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15525v());
            builder.f12541v = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15526w());
            builder.f12542w = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15527x());
            builder.f12543x = DefaultLocationFieldsModel.a(reactionStoryAttachmentFragmentModel.m15528y());
            builder.f12544y = MessageModel.m15463a(reactionStoryAttachmentFragmentModel.m15529z());
            builder.f12545z = PageModel.m15470a(reactionStoryAttachmentFragmentModel.m15479A());
            builder.f12494A = reactionStoryAttachmentFragmentModel.m15480B();
            builder.f12495B = PageProductModel.a(reactionStoryAttachmentFragmentModel.m15481C());
            builder.f12496C = PageServiceItemModel.m11119a(reactionStoryAttachmentFragmentModel.m15482D());
            builder.f12497D = SizeAwareMediaModel.a(reactionStoryAttachmentFragmentModel.m15483E());
            builder.f12498E = reactionStoryAttachmentFragmentModel.m15484F();
            builder.f12499F = reactionStoryAttachmentFragmentModel.m15485G();
            builder.f12500G = PlaceQuestionFieldsModel.m2453a(reactionStoryAttachmentFragmentModel.m15486H());
            builder.f12501H = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15487I());
            builder.f12502I = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15488J());
            builder.f12503J = reactionStoryAttachmentFragmentModel.m15489K();
            builder.f12504K = ProductModel.m14305a(reactionStoryAttachmentFragmentModel.m15490L());
            builder.f12505L = ReactionProfileFieldsModel.m14604a(reactionStoryAttachmentFragmentModel.m15491M());
            builder.f12506M = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15492N());
            builder.f12507N = reactionStoryAttachmentFragmentModel.m15493O();
            builder.f12508O = PageMediaWithAttributionModel.a(reactionStoryAttachmentFragmentModel.m15494P());
            builder.f12509P = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15495Q());
            builder.f12510Q = ReviewerModel.m14276a(reactionStoryAttachmentFragmentModel.m15496R());
            builder.f12511R = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15497S());
            builder.f12512S = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15498T());
            builder.f12513T = ReactionImageFieldsModel.m14497a(reactionStoryAttachmentFragmentModel.m15499U());
            builder.f12514U = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15500V());
            builder.f12515V = ReactionStoryAttachmentStoryFragmentModel.m14644a(reactionStoryAttachmentFragmentModel.m15501W());
            builder.f12516W = StoryAdminPageModel.m14362a(reactionStoryAttachmentFragmentModel.m15502X());
            builder.f12517X = ReactionImageFieldsModel.m14497a(reactionStoryAttachmentFragmentModel.m15503Y());
            builder.f12518Y = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.m15504Z());
            builder.f12519Z = TopicModel.m15556a(reactionStoryAttachmentFragmentModel.aa());
            builder.aa = reactionStoryAttachmentFragmentModel.ab();
            builder.ab = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.ac());
            builder.ac = reactionStoryAttachmentFragmentModel.ad();
            builder.ad = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentFragmentModel.ae());
            builder.ae = VideoDetailFragmentModel.a(reactionStoryAttachmentFragmentModel.af());
            return new ReactionStoryAttachmentFragmentModel(builder);
        }

        public ReactionStoryAttachmentFragmentModel(Builder builder) {
            super(57);
            this.f12578d = builder.f12520a;
            this.f12579e = builder.f12521b;
            this.f12580f = builder.f12522c;
            this.f12581g = builder.f12523d;
            this.f12582h = builder.f12524e;
            this.f12583i = builder.f12525f;
            this.f12584j = builder.f12526g;
            this.f12585k = builder.f12527h;
            this.f12586l = builder.f12528i;
            this.f12587m = builder.f12529j;
            this.f12588n = builder.f12530k;
            this.f12589o = builder.f12531l;
            this.f12590p = builder.f12532m;
            this.f12591q = builder.f12533n;
            this.f12592r = builder.f12534o;
            this.f12593s = builder.f12535p;
            this.f12594t = builder.f12536q;
            this.f12595u = builder.f12537r;
            this.f12596v = builder.f12538s;
            this.f12597w = builder.f12539t;
            this.f12598x = builder.f12540u;
            this.f12599y = builder.f12541v;
            this.f12600z = builder.f12542w;
            this.f12552A = builder.f12543x;
            this.f12553B = builder.f12544y;
            this.f12554C = builder.f12545z;
            this.f12555D = builder.f12494A;
            this.f12556E = builder.f12495B;
            this.f12557F = builder.f12496C;
            this.f12558G = builder.f12497D;
            this.f12559H = builder.f12498E;
            this.f12560I = builder.f12499F;
            this.f12561J = builder.f12500G;
            this.f12562K = builder.f12501H;
            this.f12563L = builder.f12502I;
            this.f12564M = builder.f12503J;
            this.f12565N = builder.f12504K;
            this.f12566O = builder.f12505L;
            this.f12567P = builder.f12506M;
            this.f12568Q = builder.f12507N;
            this.f12569R = builder.f12508O;
            this.f12570S = builder.f12509P;
            this.f12571T = builder.f12510Q;
            this.f12572U = builder.f12511R;
            this.f12573V = builder.f12512S;
            this.f12574W = builder.f12513T;
            this.f12575X = builder.f12514U;
            this.f12576Y = builder.f12515V;
            this.f12577Z = builder.f12516W;
            this.aa = builder.f12517X;
            this.ab = builder.f12518Y;
            this.ac = builder.f12519Z;
            this.ad = builder.aa;
            this.ae = builder.ab;
            this.af = builder.ac;
            this.ag = builder.ad;
            this.ah = builder.ae;
        }

        public final int jK_() {
            return -1677771153;
        }

        public final GraphQLVisitableModel m15507a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            AttributionModel attributionModel;
            GraphQLStory graphQLStory;
            EventCardFragmentModel eventCardFragmentModel;
            ExternalImageModel externalImageModel;
            ReactionImageFieldsModel reactionImageFieldsModel;
            InviteeModel inviteeModel;
            ItemModel itemModel;
            DefaultLocationFieldsModel defaultLocationFieldsModel;
            MessageModel messageModel;
            PageModel pageModel;
            PageProductModel pageProductModel;
            PageServiceItemModel pageServiceItemModel;
            SizeAwareMediaModel sizeAwareMediaModel;
            PlaceQuestionFieldsModel placeQuestionFieldsModel;
            ProductModel productModel;
            ReactionProfileFieldsModel reactionProfileFieldsModel;
            PageMediaWithAttributionModel pageMediaWithAttributionModel;
            ReviewerModel reviewerModel;
            ReactionStoryAttachmentStoryFragmentModel reactionStoryAttachmentStoryFragmentModel;
            StoryAdminPageModel storyAdminPageModel;
            TopicModel topicModel;
            VideoDetailFragmentModel videoDetailFragmentModel;
            h();
            if (m15509b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m15509b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(null, this);
                    reactionStoryAttachmentFragmentModel.f12579e = a.b();
                    graphQLVisitableModel = reactionStoryAttachmentFragmentModel;
                    if (ag() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ag());
                        if (ag() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12580f = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (ah() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ah());
                        if (ah() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12582h = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (ai() != null) {
                        attributionModel = (AttributionModel) graphQLModelMutatingVisitor.b(ai());
                        if (ai() != attributionModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12583i = attributionModel;
                        }
                    }
                    if (aj() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aj());
                        if (aj() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12584j = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (ak() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ak());
                        if (ak() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12585k = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (al() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(al());
                        if (al() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12586l = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (am() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(am());
                        if (am() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12587m = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (m15515l() != null) {
                        graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m15515l());
                        if (m15515l() != graphQLStory) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12588n = graphQLStory;
                        }
                    }
                    if (an() != null) {
                        eventCardFragmentModel = (EventCardFragmentModel) graphQLModelMutatingVisitor.b(an());
                        if (an() != eventCardFragmentModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12590p = eventCardFragmentModel;
                        }
                    }
                    if (ao() != null) {
                        externalImageModel = (ExternalImageModel) graphQLModelMutatingVisitor.b(ao());
                        if (ao() != externalImageModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12591q = externalImageModel;
                        }
                    }
                    if (ap() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ap());
                        if (ap() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12593s = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (aq() != null) {
                        reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(aq());
                        if (aq() != reactionImageFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12594t = reactionImageFieldsModel;
                        }
                    }
                    if (ar() != null) {
                        inviteeModel = (InviteeModel) graphQLModelMutatingVisitor.b(ar());
                        if (ar() != inviteeModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12595u = inviteeModel;
                        }
                    }
                    if (as() != null) {
                        itemModel = (ItemModel) graphQLModelMutatingVisitor.b(as());
                        if (as() != itemModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12597w = itemModel;
                        }
                    }
                    if (at() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(at());
                        if (at() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12598x = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (au() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(au());
                        if (au() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12599y = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (av() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(av());
                        if (av() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12600z = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (aw() != null) {
                        defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(aw());
                        if (aw() != defaultLocationFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12552A = defaultLocationFieldsModel;
                        }
                    }
                    if (ax() != null) {
                        messageModel = (MessageModel) graphQLModelMutatingVisitor.b(ax());
                        if (ax() != messageModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12553B = messageModel;
                        }
                    }
                    if (ay() != null) {
                        pageModel = (PageModel) graphQLModelMutatingVisitor.b(ay());
                        if (ay() != pageModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12554C = pageModel;
                        }
                    }
                    if (m15480B() != null) {
                        graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m15480B());
                        if (m15480B() != graphQLStory) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12555D = graphQLStory;
                        }
                    }
                    if (az() != null) {
                        pageProductModel = (PageProductModel) graphQLModelMutatingVisitor.b(az());
                        if (az() != pageProductModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12556E = pageProductModel;
                        }
                    }
                    if (aA() != null) {
                        pageServiceItemModel = (PageServiceItemModel) graphQLModelMutatingVisitor.b(aA());
                        if (aA() != pageServiceItemModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12557F = pageServiceItemModel;
                        }
                    }
                    if (aB() != null) {
                        sizeAwareMediaModel = (SizeAwareMediaModel) graphQLModelMutatingVisitor.b(aB());
                        if (aB() != sizeAwareMediaModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12558G = sizeAwareMediaModel;
                        }
                    }
                    if (aC() != null) {
                        placeQuestionFieldsModel = (PlaceQuestionFieldsModel) graphQLModelMutatingVisitor.b(aC());
                        if (aC() != placeQuestionFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12561J = placeQuestionFieldsModel;
                        }
                    }
                    if (aD() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aD());
                        if (aD() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12562K = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (aE() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aE());
                        if (aE() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12563L = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (aF() != null) {
                        productModel = (ProductModel) graphQLModelMutatingVisitor.b(aF());
                        if (aF() != productModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12565N = productModel;
                        }
                    }
                    if (aG() != null) {
                        reactionProfileFieldsModel = (ReactionProfileFieldsModel) graphQLModelMutatingVisitor.b(aG());
                        if (aG() != reactionProfileFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12566O = reactionProfileFieldsModel;
                        }
                    }
                    if (aH() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aH());
                        if (aH() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12567P = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (aI() != null) {
                        pageMediaWithAttributionModel = (PageMediaWithAttributionModel) graphQLModelMutatingVisitor.b(aI());
                        if (aI() != pageMediaWithAttributionModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12569R = pageMediaWithAttributionModel;
                        }
                    }
                    if (aJ() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aJ());
                        if (aJ() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12570S = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (aK() != null) {
                        reviewerModel = (ReviewerModel) graphQLModelMutatingVisitor.b(aK());
                        if (aK() != reviewerModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12571T = reviewerModel;
                        }
                    }
                    if (aL() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aL());
                        if (aL() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12572U = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (aM() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aM());
                        if (aM() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12573V = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (aN() != null) {
                        reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(aN());
                        if (aN() != reactionImageFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12574W = reactionImageFieldsModel;
                        }
                    }
                    if (aO() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aO());
                        if (aO() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12575X = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (aP() != null) {
                        reactionStoryAttachmentStoryFragmentModel = (ReactionStoryAttachmentStoryFragmentModel) graphQLModelMutatingVisitor.b(aP());
                        if (aP() != reactionStoryAttachmentStoryFragmentModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12576Y = reactionStoryAttachmentStoryFragmentModel;
                        }
                    }
                    if (aQ() != null) {
                        storyAdminPageModel = (StoryAdminPageModel) graphQLModelMutatingVisitor.b(aQ());
                        if (aQ() != storyAdminPageModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12577Z = storyAdminPageModel;
                        }
                    }
                    if (aR() != null) {
                        reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(aR());
                        if (aR() != reactionImageFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.aa = reactionImageFieldsModel;
                        }
                    }
                    if (aS() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aS());
                        if (aS() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.ab = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (aT() != null) {
                        topicModel = (TopicModel) graphQLModelMutatingVisitor.b(aT());
                        if (aT() != topicModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.ac = topicModel;
                        }
                    }
                    if (aU() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aU());
                        if (aU() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.ae = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (aV() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aV());
                        if (aV() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.ag = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (aW() != null) {
                        videoDetailFragmentModel = (VideoDetailFragmentModel) graphQLModelMutatingVisitor.b(aW());
                        if (aW() != videoDetailFragmentModel) {
                            graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.ah = videoDetailFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (ag() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ag());
                if (ag() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12580f = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (ah() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ah());
                if (ah() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12582h = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (ai() != null) {
                attributionModel = (AttributionModel) graphQLModelMutatingVisitor.b(ai());
                if (ai() != attributionModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12583i = attributionModel;
                }
            }
            if (aj() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aj());
                if (aj() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12584j = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (ak() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ak());
                if (ak() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12585k = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (al() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(al());
                if (al() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12586l = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (am() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(am());
                if (am() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12587m = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15515l() != null) {
                graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m15515l());
                if (m15515l() != graphQLStory) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12588n = graphQLStory;
                }
            }
            if (an() != null) {
                eventCardFragmentModel = (EventCardFragmentModel) graphQLModelMutatingVisitor.b(an());
                if (an() != eventCardFragmentModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12590p = eventCardFragmentModel;
                }
            }
            if (ao() != null) {
                externalImageModel = (ExternalImageModel) graphQLModelMutatingVisitor.b(ao());
                if (ao() != externalImageModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12591q = externalImageModel;
                }
            }
            if (ap() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ap());
                if (ap() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12593s = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aq() != null) {
                reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(aq());
                if (aq() != reactionImageFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12594t = reactionImageFieldsModel;
                }
            }
            if (ar() != null) {
                inviteeModel = (InviteeModel) graphQLModelMutatingVisitor.b(ar());
                if (ar() != inviteeModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12595u = inviteeModel;
                }
            }
            if (as() != null) {
                itemModel = (ItemModel) graphQLModelMutatingVisitor.b(as());
                if (as() != itemModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12597w = itemModel;
                }
            }
            if (at() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(at());
                if (at() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12598x = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (au() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(au());
                if (au() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12599y = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (av() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(av());
                if (av() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12600z = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aw() != null) {
                defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(aw());
                if (aw() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12552A = defaultLocationFieldsModel;
                }
            }
            if (ax() != null) {
                messageModel = (MessageModel) graphQLModelMutatingVisitor.b(ax());
                if (ax() != messageModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12553B = messageModel;
                }
            }
            if (ay() != null) {
                pageModel = (PageModel) graphQLModelMutatingVisitor.b(ay());
                if (ay() != pageModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12554C = pageModel;
                }
            }
            if (m15480B() != null) {
                graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m15480B());
                if (m15480B() != graphQLStory) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12555D = graphQLStory;
                }
            }
            if (az() != null) {
                pageProductModel = (PageProductModel) graphQLModelMutatingVisitor.b(az());
                if (az() != pageProductModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12556E = pageProductModel;
                }
            }
            if (aA() != null) {
                pageServiceItemModel = (PageServiceItemModel) graphQLModelMutatingVisitor.b(aA());
                if (aA() != pageServiceItemModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12557F = pageServiceItemModel;
                }
            }
            if (aB() != null) {
                sizeAwareMediaModel = (SizeAwareMediaModel) graphQLModelMutatingVisitor.b(aB());
                if (aB() != sizeAwareMediaModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12558G = sizeAwareMediaModel;
                }
            }
            if (aC() != null) {
                placeQuestionFieldsModel = (PlaceQuestionFieldsModel) graphQLModelMutatingVisitor.b(aC());
                if (aC() != placeQuestionFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12561J = placeQuestionFieldsModel;
                }
            }
            if (aD() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aD());
                if (aD() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12562K = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aE() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aE());
                if (aE() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12563L = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aF() != null) {
                productModel = (ProductModel) graphQLModelMutatingVisitor.b(aF());
                if (aF() != productModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12565N = productModel;
                }
            }
            if (aG() != null) {
                reactionProfileFieldsModel = (ReactionProfileFieldsModel) graphQLModelMutatingVisitor.b(aG());
                if (aG() != reactionProfileFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12566O = reactionProfileFieldsModel;
                }
            }
            if (aH() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aH());
                if (aH() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12567P = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aI() != null) {
                pageMediaWithAttributionModel = (PageMediaWithAttributionModel) graphQLModelMutatingVisitor.b(aI());
                if (aI() != pageMediaWithAttributionModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12569R = pageMediaWithAttributionModel;
                }
            }
            if (aJ() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aJ());
                if (aJ() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12570S = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aK() != null) {
                reviewerModel = (ReviewerModel) graphQLModelMutatingVisitor.b(aK());
                if (aK() != reviewerModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12571T = reviewerModel;
                }
            }
            if (aL() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aL());
                if (aL() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12572U = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aM() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aM());
                if (aM() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12573V = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aN() != null) {
                reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(aN());
                if (aN() != reactionImageFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12574W = reactionImageFieldsModel;
                }
            }
            if (aO() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aO());
                if (aO() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12575X = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aP() != null) {
                reactionStoryAttachmentStoryFragmentModel = (ReactionStoryAttachmentStoryFragmentModel) graphQLModelMutatingVisitor.b(aP());
                if (aP() != reactionStoryAttachmentStoryFragmentModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12576Y = reactionStoryAttachmentStoryFragmentModel;
                }
            }
            if (aQ() != null) {
                storyAdminPageModel = (StoryAdminPageModel) graphQLModelMutatingVisitor.b(aQ());
                if (aQ() != storyAdminPageModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12577Z = storyAdminPageModel;
                }
            }
            if (aR() != null) {
                reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(aR());
                if (aR() != reactionImageFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aa = reactionImageFieldsModel;
                }
            }
            if (aS() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aS());
                if (aS() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ab = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aT() != null) {
                topicModel = (TopicModel) graphQLModelMutatingVisitor.b(aT());
                if (aT() != topicModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ac = topicModel;
                }
            }
            if (aU() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aU());
                if (aU() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ae = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aV() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aV());
                if (aV() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ag = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aW() != null) {
                videoDetailFragmentModel = (VideoDetailFragmentModel) graphQLModelMutatingVisitor.b(aW());
                if (aW() != videoDetailFragmentModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ah = videoDetailFragmentModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m15505a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15506a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15509b());
            int a3 = ModelHelper.a(flatBufferBuilder, ag());
            int b = flatBufferBuilder.b(m15511d());
            int a4 = ModelHelper.a(flatBufferBuilder, ah());
            int a5 = ModelHelper.a(flatBufferBuilder, ai());
            int a6 = ModelHelper.a(flatBufferBuilder, aj());
            int a7 = ModelHelper.a(flatBufferBuilder, ak());
            int a8 = ModelHelper.a(flatBufferBuilder, al());
            int a9 = ModelHelper.a(flatBufferBuilder, am());
            int a10 = ModelHelper.a(flatBufferBuilder, m15515l());
            int a11 = ModelHelper.a(flatBufferBuilder, an());
            int a12 = ModelHelper.a(flatBufferBuilder, ao());
            int b2 = flatBufferBuilder.b(m15519p());
            int a13 = ModelHelper.a(flatBufferBuilder, ap());
            int a14 = ModelHelper.a(flatBufferBuilder, aq());
            int a15 = ModelHelper.a(flatBufferBuilder, ar());
            int a16 = ModelHelper.a(flatBufferBuilder, as());
            int a17 = ModelHelper.a(flatBufferBuilder, at());
            int a18 = ModelHelper.a(flatBufferBuilder, au());
            int a19 = ModelHelper.a(flatBufferBuilder, av());
            int a20 = ModelHelper.a(flatBufferBuilder, aw());
            int a21 = ModelHelper.a(flatBufferBuilder, ax());
            int a22 = ModelHelper.a(flatBufferBuilder, ay());
            int a23 = ModelHelper.a(flatBufferBuilder, m15480B());
            int a24 = ModelHelper.a(flatBufferBuilder, az());
            int a25 = ModelHelper.a(flatBufferBuilder, aA());
            int a26 = ModelHelper.a(flatBufferBuilder, aB());
            int b3 = flatBufferBuilder.b(m15484F());
            int b4 = flatBufferBuilder.b(m15485G());
            int a27 = ModelHelper.a(flatBufferBuilder, aC());
            int a28 = ModelHelper.a(flatBufferBuilder, aD());
            int a29 = ModelHelper.a(flatBufferBuilder, aE());
            int a30 = ModelHelper.a(flatBufferBuilder, aF());
            int a31 = ModelHelper.a(flatBufferBuilder, aG());
            int a32 = ModelHelper.a(flatBufferBuilder, aH());
            int a33 = ModelHelper.a(flatBufferBuilder, aI());
            int a34 = ModelHelper.a(flatBufferBuilder, aJ());
            int a35 = ModelHelper.a(flatBufferBuilder, aK());
            int a36 = ModelHelper.a(flatBufferBuilder, aL());
            int a37 = ModelHelper.a(flatBufferBuilder, aM());
            int a38 = ModelHelper.a(flatBufferBuilder, aN());
            int a39 = ModelHelper.a(flatBufferBuilder, aO());
            int a40 = ModelHelper.a(flatBufferBuilder, aP());
            int a41 = ModelHelper.a(flatBufferBuilder, aQ());
            int a42 = ModelHelper.a(flatBufferBuilder, aR());
            int a43 = ModelHelper.a(flatBufferBuilder, aS());
            int a44 = ModelHelper.a(flatBufferBuilder, aT());
            int a45 = ModelHelper.a(flatBufferBuilder, aU());
            int a46 = ModelHelper.a(flatBufferBuilder, aV());
            int a47 = ModelHelper.a(flatBufferBuilder, aW());
            flatBufferBuilder.c(57);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, a8);
            flatBufferBuilder.b(9, a9);
            flatBufferBuilder.b(10, a10);
            flatBufferBuilder.a(11, this.f12589o, 0);
            flatBufferBuilder.b(12, a11);
            flatBufferBuilder.b(13, a12);
            flatBufferBuilder.b(14, b2);
            flatBufferBuilder.b(15, a13);
            flatBufferBuilder.b(16, a14);
            flatBufferBuilder.b(17, a15);
            flatBufferBuilder.a(18, this.f12596v);
            flatBufferBuilder.b(19, a16);
            flatBufferBuilder.b(20, a17);
            flatBufferBuilder.b(21, a18);
            flatBufferBuilder.b(22, a19);
            flatBufferBuilder.b(23, a20);
            flatBufferBuilder.b(24, a21);
            flatBufferBuilder.b(25, a22);
            flatBufferBuilder.b(26, a23);
            flatBufferBuilder.b(27, a24);
            flatBufferBuilder.b(28, a25);
            flatBufferBuilder.b(29, a26);
            flatBufferBuilder.b(30, b3);
            flatBufferBuilder.b(31, b4);
            flatBufferBuilder.b(32, a27);
            flatBufferBuilder.b(33, a28);
            flatBufferBuilder.b(34, a29);
            flatBufferBuilder.a(35, this.f12564M, 0);
            flatBufferBuilder.b(36, a30);
            flatBufferBuilder.b(37, a31);
            flatBufferBuilder.b(38, a32);
            flatBufferBuilder.a(39, this.f12568Q, 0.0d);
            flatBufferBuilder.b(40, a33);
            flatBufferBuilder.b(41, a34);
            flatBufferBuilder.b(42, a35);
            flatBufferBuilder.b(43, a36);
            flatBufferBuilder.b(44, a37);
            flatBufferBuilder.b(45, a38);
            flatBufferBuilder.b(46, a39);
            flatBufferBuilder.b(47, a40);
            flatBufferBuilder.b(48, a41);
            flatBufferBuilder.b(49, a42);
            flatBufferBuilder.b(50, a43);
            flatBufferBuilder.b(51, a44);
            flatBufferBuilder.a(52, this.ad, 0);
            flatBufferBuilder.b(53, a45);
            flatBufferBuilder.a(54, this.af, 0);
            flatBufferBuilder.b(55, a46);
            flatBufferBuilder.b(56, a47);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15508a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12589o = mutableFlatBuffer.a(i, 11, 0);
            this.f12596v = mutableFlatBuffer.a(i, 18);
            this.f12564M = mutableFlatBuffer.a(i, 35, 0);
            this.f12568Q = mutableFlatBuffer.a(i, 39, 0.0d);
            this.ad = mutableFlatBuffer.a(i, 52, 0);
            this.af = mutableFlatBuffer.a(i, 54, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 8050735)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: file IO exception on reading */
    public final class ReactionStoryFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionStoryFragment {
        @Nullable
        private ReactionAttachmentsModel f12611d;

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionStoryFragmentModel.class, new Deserializer());
            }

            public Object m15530a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionStoryFragmentParser.m15711a(jsonParser);
                Object reactionStoryFragmentModel = new ReactionStoryFragmentModel();
                ((BaseModel) reactionStoryFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionStoryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionStoryFragmentModel).a();
                }
                return reactionStoryFragmentModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 369787915)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: file IO exception on reading */
        public final class ReactionAttachmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ReactionStoryAttachmentActionFragmentModel> f12607d;
            @Nullable
            private List<EdgesModel> f12608e;
            @Nullable
            private DefaultPageInfoFieldsModel f12609f;
            @Nullable
            private GraphQLReactionStoryAttachmentsStyle f12610g;

            /* compiled from: file IO exception on reading */
            public final class Builder {
                @Nullable
                public ImmutableList<ReactionStoryAttachmentActionFragmentModel> f12601a;
                @Nullable
                public ImmutableList<EdgesModel> f12602b;
                @Nullable
                public DefaultPageInfoFieldsModel f12603c;
                @Nullable
                public GraphQLReactionStoryAttachmentsStyle f12604d;
            }

            /* compiled from: file IO exception on reading */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactionAttachmentsModel.class, new Deserializer());
                }

                public Object m15531a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionStoryFragmentParser.ReactionAttachmentsParser.m15709a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactionAttachmentsModel = new ReactionAttachmentsModel();
                    ((BaseModel) reactionAttachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactionAttachmentsModel instanceof Postprocessable) {
                        return ((Postprocessable) reactionAttachmentsModel).a();
                    }
                    return reactionAttachmentsModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -910659432)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: file IO exception on reading */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ReactionStoryAttachmentFragmentModel f12606d;

                /* compiled from: file IO exception on reading */
                public final class Builder {
                    @Nullable
                    public ReactionStoryAttachmentFragmentModel f12605a;
                }

                /* compiled from: file IO exception on reading */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m15532a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ReactionStoryFragmentParser.ReactionAttachmentsParser.EdgesParser.m15707b(jsonParser, flatBufferBuilder));
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

                /* compiled from: file IO exception on reading */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m15533a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m15536a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ReactionStoryFragmentParser.ReactionAttachmentsParser.EdgesParser.m15708b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ReactionStoryAttachmentFragmentModel m15538a() {
                    return m15535j();
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private ReactionStoryAttachmentFragmentModel m15535j() {
                    this.f12606d = (ReactionStoryAttachmentFragmentModel) super.a(this.f12606d, 0, ReactionStoryAttachmentFragmentModel.class);
                    return this.f12606d;
                }

                public static EdgesModel m15534a(EdgesModel edgesModel) {
                    if (edgesModel == null) {
                        return null;
                    }
                    if (edgesModel instanceof EdgesModel) {
                        return edgesModel;
                    }
                    Builder builder = new Builder();
                    builder.f12605a = ReactionStoryAttachmentFragmentModel.m15478a(edgesModel.m15538a());
                    return new EdgesModel(builder);
                }

                public EdgesModel(Builder builder) {
                    super(1);
                    this.f12606d = builder.f12605a;
                }

                public final int jK_() {
                    return -1682513983;
                }

                public final GraphQLVisitableModel m15537a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15535j() != null) {
                        ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel = (ReactionStoryAttachmentFragmentModel) graphQLModelMutatingVisitor.b(m15535j());
                        if (m15535j() != reactionStoryAttachmentFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12606d = reactionStoryAttachmentFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15536a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15535j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: file IO exception on reading */
            public class Serializer extends JsonSerializer<ReactionAttachmentsModel> {
                public final void m15539a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) obj;
                    if (reactionAttachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactionAttachmentsModel.m15542a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactionAttachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionStoryFragmentParser.ReactionAttachmentsParser.m15710a(reactionAttachmentsModel.w_(), reactionAttachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReactionAttachmentsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultPageInfoFields m15546c() {
                return m15541j();
            }

            public ReactionAttachmentsModel() {
                super(4);
            }

            @Nonnull
            public final ImmutableList<ReactionStoryAttachmentActionFragmentModel> m15544a() {
                this.f12607d = super.a(this.f12607d, 0, ReactionStoryAttachmentActionFragmentModel.class);
                return (ImmutableList) this.f12607d;
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m15545b() {
                this.f12608e = super.a(this.f12608e, 1, EdgesModel.class);
                return (ImmutableList) this.f12608e;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m15541j() {
                this.f12609f = (DefaultPageInfoFieldsModel) super.a(this.f12609f, 2, DefaultPageInfoFieldsModel.class);
                return this.f12609f;
            }

            @Nullable
            public final GraphQLReactionStoryAttachmentsStyle m15547d() {
                this.f12610g = (GraphQLReactionStoryAttachmentsStyle) super.b(this.f12610g, 3, GraphQLReactionStoryAttachmentsStyle.class, GraphQLReactionStoryAttachmentsStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12610g;
            }

            public static ReactionAttachmentsModel m15540a(ReactionAttachmentsModel reactionAttachmentsModel) {
                int i = 0;
                if (reactionAttachmentsModel == null) {
                    return null;
                }
                if (reactionAttachmentsModel instanceof ReactionAttachmentsModel) {
                    return reactionAttachmentsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i2 = 0; i2 < reactionAttachmentsModel.m15544a().size(); i2++) {
                    builder2.c(ReactionStoryAttachmentActionFragmentModel.m16357a((ReactionStoryAttachmentActionFragmentModel) reactionAttachmentsModel.m15544a().get(i2)));
                }
                builder.f12601a = builder2.b();
                com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
                while (i < reactionAttachmentsModel.m15545b().size()) {
                    builder3.c(EdgesModel.m15534a((EdgesModel) reactionAttachmentsModel.m15545b().get(i)));
                    i++;
                }
                builder.f12602b = builder3.b();
                builder.f12603c = DefaultPageInfoFieldsModel.a(reactionAttachmentsModel.m15546c());
                builder.f12604d = reactionAttachmentsModel.m15547d();
                return new ReactionAttachmentsModel(builder);
            }

            public ReactionAttachmentsModel(Builder builder) {
                super(4);
                this.f12607d = builder.f12601a;
                this.f12608e = builder.f12602b;
                this.f12609f = builder.f12603c;
                this.f12610g = builder.f12604d;
            }

            public final int jK_() {
                return -972595742;
            }

            public final GraphQLVisitableModel m15543a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                com.google.common.collect.ImmutableList.Builder a;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15544a() != null) {
                    a = ModelHelper.a(m15544a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ReactionAttachmentsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12607d = a.b();
                    }
                }
                if (m15545b() != null) {
                    a = ModelHelper.a(m15545b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ReactionAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12608e = a.b();
                    }
                }
                GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
                if (m15541j() != null) {
                    DefaultPageInfoFieldsModel defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15541j());
                    if (m15541j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel2 = (ReactionAttachmentsModel) ModelHelper.a(graphQLVisitableModel2, this);
                        graphQLVisitableModel2.f12609f = defaultPageInfoFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
            }

            public final int m15542a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15544a());
                int a2 = ModelHelper.a(flatBufferBuilder, m15545b());
                int a3 = ModelHelper.a(flatBufferBuilder, m15541j());
                int a4 = flatBufferBuilder.a(m15547d());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionStoryFragmentModel> {
            public final void m15548a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionStoryFragmentModel reactionStoryFragmentModel = (ReactionStoryFragmentModel) obj;
                if (reactionStoryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionStoryFragmentModel.m15550a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionStoryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionStoryFragmentModel.w_();
                int u_ = reactionStoryFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reaction_attachments");
                    ReactionStoryFragmentParser.ReactionAttachmentsParser.m15710a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionStoryFragmentModel.class, new Serializer());
            }
        }

        public ReactionStoryFragmentModel() {
            super(1);
        }

        @Nullable
        private ReactionAttachmentsModel m15549a() {
            this.f12611d = (ReactionAttachmentsModel) super.a(this.f12611d, 0, ReactionAttachmentsModel.class);
            return this.f12611d;
        }

        public final int jK_() {
            return -859090900;
        }

        public final GraphQLVisitableModel m15551a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15549a() != null) {
                ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) graphQLModelMutatingVisitor.b(m15549a());
                if (m15549a() != reactionAttachmentsModel) {
                    graphQLVisitableModel = (ReactionStoryFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12611d = reactionAttachmentsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15550a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15549a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -966130667)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: file IO exception on reading */
    public final class ReactionStoryTopicAttachmentFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionStoryTopicAttachmentFragment {
        @Nullable
        private TopicModel f12622d;

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionStoryTopicAttachmentFragmentModel.class, new Deserializer());
            }

            public Object m15552a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionStoryTopicAttachmentFragmentParser.m15714a(jsonParser);
                Object reactionStoryTopicAttachmentFragmentModel = new ReactionStoryTopicAttachmentFragmentModel();
                ((BaseModel) reactionStoryTopicAttachmentFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionStoryTopicAttachmentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionStoryTopicAttachmentFragmentModel).a();
                }
                return reactionStoryTopicAttachmentFragmentModel;
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionStoryTopicAttachmentFragmentModel> {
            public final void m15553a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionStoryTopicAttachmentFragmentModel reactionStoryTopicAttachmentFragmentModel = (ReactionStoryTopicAttachmentFragmentModel) obj;
                if (reactionStoryTopicAttachmentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionStoryTopicAttachmentFragmentModel.m15566a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionStoryTopicAttachmentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionStoryTopicAttachmentFragmentModel.w_();
                int u_ = reactionStoryTopicAttachmentFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("topic");
                    TopicParser.m15713a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionStoryTopicAttachmentFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 799491561)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: file IO exception on reading */
        public final class TopicModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f12617d;
            @Nullable
            private String f12618e;
            @Nullable
            private String f12619f;
            @Nullable
            private ReactionImageFieldsModel f12620g;
            @Nullable
            private String f12621h;

            /* compiled from: file IO exception on reading */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f12612a;
                @Nullable
                public String f12613b;
                @Nullable
                public String f12614c;
                @Nullable
                public ReactionImageFieldsModel f12615d;
                @Nullable
                public String f12616e;
            }

            /* compiled from: file IO exception on reading */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TopicModel.class, new Deserializer());
                }

                public Object m15554a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TopicParser.m15712a(jsonParser, flatBufferBuilder));
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

            /* compiled from: file IO exception on reading */
            public class Serializer extends JsonSerializer<TopicModel> {
                public final void m15555a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TopicModel topicModel = (TopicModel) obj;
                    if (topicModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(topicModel.m15558a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        topicModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TopicParser.m15713a(topicModel.w_(), topicModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TopicModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ReactionImageFields fu_() {
                return m15557j();
            }

            public TopicModel() {
                super(5);
            }

            @Nullable
            public final GraphQLObjectType m15561b() {
                if (this.b != null && this.f12617d == null) {
                    this.f12617d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12617d;
            }

            @Nullable
            public final String m15562c() {
                this.f12618e = super.a(this.f12618e, 1);
                return this.f12618e;
            }

            @Nullable
            public final String m15563d() {
                this.f12619f = super.a(this.f12619f, 2);
                return this.f12619f;
            }

            @Nullable
            private ReactionImageFieldsModel m15557j() {
                this.f12620g = (ReactionImageFieldsModel) super.a(this.f12620g, 3, ReactionImageFieldsModel.class);
                return this.f12620g;
            }

            @Nullable
            public final String m15564g() {
                this.f12621h = super.a(this.f12621h, 4);
                return this.f12621h;
            }

            public static TopicModel m15556a(TopicModel topicModel) {
                if (topicModel == null) {
                    return null;
                }
                if (topicModel instanceof TopicModel) {
                    return topicModel;
                }
                Builder builder = new Builder();
                builder.f12612a = topicModel.m15561b();
                builder.f12613b = topicModel.m15562c();
                builder.f12614c = topicModel.m15563d();
                builder.f12615d = ReactionImageFieldsModel.m14497a(topicModel.fu_());
                builder.f12616e = topicModel.m15564g();
                return new TopicModel(builder);
            }

            public TopicModel(Builder builder) {
                super(5);
                this.f12617d = builder.f12612a;
                this.f12618e = builder.f12613b;
                this.f12619f = builder.f12614c;
                this.f12620g = builder.f12615d;
                this.f12621h = builder.f12616e;
            }

            @Nullable
            public final String m15560a() {
                return m15562c();
            }

            public final int jK_() {
                return 80993551;
            }

            public final GraphQLVisitableModel m15559a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15557j() != null) {
                    ReactionImageFieldsModel reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(m15557j());
                    if (m15557j() != reactionImageFieldsModel) {
                        graphQLVisitableModel = (TopicModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12620g = reactionImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15558a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15561b());
                int b = flatBufferBuilder.b(m15562c());
                int b2 = flatBufferBuilder.b(m15563d());
                int a2 = ModelHelper.a(flatBufferBuilder, m15557j());
                int b3 = flatBufferBuilder.b(m15564g());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ReactionStoryTopicAttachmentFragmentModel() {
            super(1);
        }

        @Nullable
        private TopicModel m15565a() {
            this.f12622d = (TopicModel) super.a(this.f12622d, 0, TopicModel.class);
            return this.f12622d;
        }

        public final int jK_() {
            return -2133844506;
        }

        public final GraphQLVisitableModel m15567a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15565a() != null) {
                TopicModel topicModel = (TopicModel) graphQLModelMutatingVisitor.b(m15565a());
                if (m15565a() != topicModel) {
                    graphQLVisitableModel = (ReactionStoryTopicAttachmentFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12622d = topicModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15566a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15565a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1881967026)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: file IO exception on reading */
    public final class ReactionSuggestedEventsQueryFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ReactionStoriesModel f12623d;

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionSuggestedEventsQueryFragmentModel.class, new Deserializer());
            }

            public Object m15568a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionSuggestedEventsQueryFragmentParser.m15715a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionSuggestedEventsQueryFragmentModel = new ReactionSuggestedEventsQueryFragmentModel();
                ((BaseModel) reactionSuggestedEventsQueryFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionSuggestedEventsQueryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionSuggestedEventsQueryFragmentModel).a();
                }
                return reactionSuggestedEventsQueryFragmentModel;
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionSuggestedEventsQueryFragmentModel> {
            public final void m15569a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionSuggestedEventsQueryFragmentModel reactionSuggestedEventsQueryFragmentModel = (ReactionSuggestedEventsQueryFragmentModel) obj;
                if (reactionSuggestedEventsQueryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionSuggestedEventsQueryFragmentModel.m15570a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionSuggestedEventsQueryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionSuggestedEventsQueryFragmentParser.m15716a(reactionSuggestedEventsQueryFragmentModel.w_(), reactionSuggestedEventsQueryFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionSuggestedEventsQueryFragmentModel.class, new Serializer());
            }
        }

        public ReactionSuggestedEventsQueryFragmentModel() {
            super(1);
        }

        @Nullable
        public final ReactionStoriesModel m15572a() {
            this.f12623d = (ReactionStoriesModel) super.a(this.f12623d, 0, ReactionStoriesModel.class);
            return this.f12623d;
        }

        public final int jK_() {
            return -128271569;
        }

        public final GraphQLVisitableModel m15571a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15572a() != null) {
                ReactionStoriesModel reactionStoriesModel = (ReactionStoriesModel) graphQLModelMutatingVisitor.b(m15572a());
                if (m15572a() != reactionStoriesModel) {
                    graphQLVisitableModel = (ReactionSuggestedEventsQueryFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12623d = reactionStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15570a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15572a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1592437010)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: file IO exception on reading */
    public final class ReactionSuggestedEventsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ReactionSuggestedEventsQueryFragmentModel f12624d;

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionSuggestedEventsQueryModel.class, new Deserializer());
            }

            public Object m15573a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionSuggestedEventsQueryParser.m15717a(jsonParser);
                Object reactionSuggestedEventsQueryModel = new ReactionSuggestedEventsQueryModel();
                ((BaseModel) reactionSuggestedEventsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionSuggestedEventsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionSuggestedEventsQueryModel).a();
                }
                return reactionSuggestedEventsQueryModel;
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionSuggestedEventsQueryModel> {
            public final void m15574a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionSuggestedEventsQueryModel reactionSuggestedEventsQueryModel = (ReactionSuggestedEventsQueryModel) obj;
                if (reactionSuggestedEventsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionSuggestedEventsQueryModel.m15575a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionSuggestedEventsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionSuggestedEventsQueryModel.w_();
                int u_ = reactionSuggestedEventsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("suggested_events_reaction_units");
                    ReactionSuggestedEventsQueryFragmentParser.m15716a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionSuggestedEventsQueryModel.class, new Serializer());
            }
        }

        public ReactionSuggestedEventsQueryModel() {
            super(1);
        }

        @Nullable
        public final ReactionSuggestedEventsQueryFragmentModel m15577a() {
            this.f12624d = (ReactionSuggestedEventsQueryFragmentModel) super.a(this.f12624d, 0, ReactionSuggestedEventsQueryFragmentModel.class);
            return this.f12624d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m15576a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15577a() != null) {
                ReactionSuggestedEventsQueryFragmentModel reactionSuggestedEventsQueryFragmentModel = (ReactionSuggestedEventsQueryFragmentModel) graphQLModelMutatingVisitor.b(m15577a());
                if (m15577a() != reactionSuggestedEventsQueryFragmentModel) {
                    graphQLVisitableModel = (ReactionSuggestedEventsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12624d = reactionSuggestedEventsQueryFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15575a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15577a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -808034507)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: file IO exception on reading */
    public final class ReactionUnitBadgedProfilesComponentFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionUnitBadgedProfilesComponentFragment {
        @Nullable
        private ReactionStoryAttachmentActionFragmentModel f12629d;
        @Nullable
        private List<BadgableProfilesModel> f12630e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 522147733)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: file IO exception on reading */
        public final class BadgableProfilesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLReactionProfileBadgeType f12627d;
            @Nullable
            private ReactionFacepileProfileModel f12628e;

            /* compiled from: file IO exception on reading */
            public final class Builder {
                @Nullable
                public GraphQLReactionProfileBadgeType f12625a;
                @Nullable
                public ReactionFacepileProfileModel f12626b;
            }

            /* compiled from: file IO exception on reading */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BadgableProfilesModel.class, new Deserializer());
                }

                public Object m15578a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BadgableProfilesParser.m15720b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object badgableProfilesModel = new BadgableProfilesModel();
                    ((BaseModel) badgableProfilesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (badgableProfilesModel instanceof Postprocessable) {
                        return ((Postprocessable) badgableProfilesModel).a();
                    }
                    return badgableProfilesModel;
                }
            }

            /* compiled from: file IO exception on reading */
            public class Serializer extends JsonSerializer<BadgableProfilesModel> {
                public final void m15579a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BadgableProfilesModel badgableProfilesModel = (BadgableProfilesModel) obj;
                    if (badgableProfilesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(badgableProfilesModel.m15582a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        badgableProfilesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BadgableProfilesParser.m15721b(badgableProfilesModel.w_(), badgableProfilesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BadgableProfilesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ReactionFacepileProfile m15585b() {
                return m15581j();
            }

            public BadgableProfilesModel() {
                super(2);
            }

            @Nullable
            public final GraphQLReactionProfileBadgeType m15583a() {
                this.f12627d = (GraphQLReactionProfileBadgeType) super.b(this.f12627d, 0, GraphQLReactionProfileBadgeType.class, GraphQLReactionProfileBadgeType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12627d;
            }

            @Nullable
            private ReactionFacepileProfileModel m15581j() {
                this.f12628e = (ReactionFacepileProfileModel) super.a(this.f12628e, 1, ReactionFacepileProfileModel.class);
                return this.f12628e;
            }

            public static BadgableProfilesModel m15580a(BadgableProfilesModel badgableProfilesModel) {
                if (badgableProfilesModel == null) {
                    return null;
                }
                if (badgableProfilesModel instanceof BadgableProfilesModel) {
                    return badgableProfilesModel;
                }
                Builder builder = new Builder();
                builder.f12625a = badgableProfilesModel.m15583a();
                builder.f12626b = ReactionFacepileProfileModel.m14459a(badgableProfilesModel.m15585b());
                return new BadgableProfilesModel(builder);
            }

            public BadgableProfilesModel(Builder builder) {
                super(2);
                this.f12627d = builder.f12625a;
                this.f12628e = builder.f12626b;
            }

            public final int jK_() {
                return -1290545372;
            }

            public final GraphQLVisitableModel m15584a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15581j() != null) {
                    ReactionFacepileProfileModel reactionFacepileProfileModel = (ReactionFacepileProfileModel) graphQLModelMutatingVisitor.b(m15581j());
                    if (m15581j() != reactionFacepileProfileModel) {
                        graphQLVisitableModel = (BadgableProfilesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12628e = reactionFacepileProfileModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15582a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m15583a());
                int a2 = ModelHelper.a(flatBufferBuilder, m15581j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionUnitBadgedProfilesComponentFragmentModel.class, new Deserializer());
            }

            public Object m15586a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionUnitBadgedProfilesComponentFragmentParser.m15722a(jsonParser);
                Object reactionUnitBadgedProfilesComponentFragmentModel = new ReactionUnitBadgedProfilesComponentFragmentModel();
                ((BaseModel) reactionUnitBadgedProfilesComponentFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionUnitBadgedProfilesComponentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionUnitBadgedProfilesComponentFragmentModel).a();
                }
                return reactionUnitBadgedProfilesComponentFragmentModel;
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionUnitBadgedProfilesComponentFragmentModel> {
            public final void m15587a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionUnitBadgedProfilesComponentFragmentModel reactionUnitBadgedProfilesComponentFragmentModel = (ReactionUnitBadgedProfilesComponentFragmentModel) obj;
                if (reactionUnitBadgedProfilesComponentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionUnitBadgedProfilesComponentFragmentModel.m15590a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionUnitBadgedProfilesComponentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionUnitBadgedProfilesComponentFragmentModel.w_();
                int u_ = reactionUnitBadgedProfilesComponentFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("action");
                    ReactionStoryAttachmentActionFragmentParser.m16604b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("badgable_profiles");
                    BadgableProfilesParser.m15719a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionUnitBadgedProfilesComponentFragmentModel.class, new Serializer());
            }
        }

        public ReactionUnitBadgedProfilesComponentFragmentModel() {
            super(2);
        }

        @Nullable
        private ReactionStoryAttachmentActionFragmentModel m15588a() {
            this.f12629d = (ReactionStoryAttachmentActionFragmentModel) super.a(this.f12629d, 0, ReactionStoryAttachmentActionFragmentModel.class);
            return this.f12629d;
        }

        @Nonnull
        private ImmutableList<BadgableProfilesModel> m15589j() {
            this.f12630e = super.a(this.f12630e, 1, BadgableProfilesModel.class);
            return (ImmutableList) this.f12630e;
        }

        public final int jK_() {
            return 446384110;
        }

        public final GraphQLVisitableModel m15591a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15588a() != null) {
                ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) graphQLModelMutatingVisitor.b(m15588a());
                if (m15588a() != reactionStoryAttachmentActionFragmentModel) {
                    graphQLVisitableModel = (ReactionUnitBadgedProfilesComponentFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12629d = reactionStoryAttachmentActionFragmentModel;
                }
            }
            if (m15589j() != null) {
                Builder a = ModelHelper.a(m15589j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ReactionUnitBadgedProfilesComponentFragmentModel reactionUnitBadgedProfilesComponentFragmentModel = (ReactionUnitBadgedProfilesComponentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    reactionUnitBadgedProfilesComponentFragmentModel.f12630e = a.b();
                    graphQLVisitableModel = reactionUnitBadgedProfilesComponentFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15590a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15588a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15589j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1676664577)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: file IO exception on reading */
    public final class ReactionUnitDefaultFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, ReactionUnitDefaultFields {
        @Nullable
        private GraphQLObjectType f12645d;
        @Nullable
        private GraphQLReactionUnitCollapseState f12646e;
        @Nullable
        private String f12647f;
        @Nullable
        private String f12648g;
        @Nullable
        private ReactionPageFieldsWithPlaceTipsInfoModel f12649h;
        @Nullable
        private ReactionAttachmentsModel f12650i;
        @Nullable
        private ReactionUnitHeaderFieldsModel f12651j;
        @Nullable
        private String f12652k;
        @Nullable
        private ReactionUnitExpirationConditionFragmentModel f12653l;
        private int f12654m;
        @Nullable
        private GraphQLReactionUnitStyle f12655n;
        @Nullable
        private String f12656o;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12657p;
        @Nullable
        private SizeAwareMediaModel f12658q;

        /* compiled from: file IO exception on reading */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f12631a;
            @Nullable
            public GraphQLReactionUnitCollapseState f12632b;
            @Nullable
            public String f12633c;
            @Nullable
            public String f12634d;
            @Nullable
            public ReactionPageFieldsWithPlaceTipsInfoModel f12635e;
            @Nullable
            public ReactionAttachmentsModel f12636f;
            @Nullable
            public ReactionUnitHeaderFieldsModel f12637g;
            @Nullable
            public String f12638h;
            @Nullable
            public ReactionUnitExpirationConditionFragmentModel f12639i;
            public int f12640j;
            @Nullable
            public GraphQLReactionUnitStyle f12641k;
            @Nullable
            public String f12642l;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12643m;
            @Nullable
            public SizeAwareMediaModel f12644n;
        }

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionUnitDefaultFieldsModel.class, new Deserializer());
            }

            public Object m15592a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionUnitDefaultFieldsParser.m15723b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionUnitDefaultFieldsModel = new ReactionUnitDefaultFieldsModel();
                ((BaseModel) reactionUnitDefaultFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionUnitDefaultFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionUnitDefaultFieldsModel).a();
                }
                return reactionUnitDefaultFieldsModel;
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionUnitDefaultFieldsModel> {
            public final void m15593a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionUnitDefaultFieldsModel reactionUnitDefaultFieldsModel = (ReactionUnitDefaultFieldsModel) obj;
                if (reactionUnitDefaultFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionUnitDefaultFieldsModel.m15601a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionUnitDefaultFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionUnitDefaultFieldsParser.m15724b(reactionUnitDefaultFieldsModel.w_(), reactionUnitDefaultFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionUnitDefaultFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ReactionUnitHeaderFieldsModel fw_() {
            return m15597s();
        }

        @Nullable
        public final /* synthetic */ ReactionAttachmentsModel fx_() {
            return m15596r();
        }

        @Nullable
        public final /* synthetic */ ReactionPageFieldsWithPlaceTipsInfoModel mo820g() {
            return m15595q();
        }

        @Nullable
        public final /* synthetic */ ReactionUnitExpirationConditionFragmentModel mo822k() {
            return m15598t();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields mo826o() {
            return m15599u();
        }

        @Nullable
        public final /* synthetic */ SizeAwareMedia mo827p() {
            return m15600v();
        }

        public ReactionUnitDefaultFieldsModel() {
            super(14);
        }

        @Nullable
        public final GraphQLObjectType mo814b() {
            if (this.b != null && this.f12645d == null) {
                this.f12645d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12645d;
        }

        @Nullable
        public final GraphQLReactionUnitCollapseState mo815c() {
            this.f12646e = (GraphQLReactionUnitCollapseState) super.b(this.f12646e, 1, GraphQLReactionUnitCollapseState.class, GraphQLReactionUnitCollapseState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12646e;
        }

        @Nullable
        public final String mo816d() {
            this.f12647f = super.a(this.f12647f, 2);
            return this.f12647f;
        }

        @Nullable
        public final String fv_() {
            this.f12648g = super.a(this.f12648g, 3);
            return this.f12648g;
        }

        @Nullable
        private ReactionPageFieldsWithPlaceTipsInfoModel m15595q() {
            this.f12649h = (ReactionPageFieldsWithPlaceTipsInfoModel) super.a(this.f12649h, 4, ReactionPageFieldsWithPlaceTipsInfoModel.class);
            return this.f12649h;
        }

        @Nullable
        private ReactionAttachmentsModel m15596r() {
            this.f12650i = (ReactionAttachmentsModel) super.a(this.f12650i, 5, ReactionAttachmentsModel.class);
            return this.f12650i;
        }

        @Nullable
        private ReactionUnitHeaderFieldsModel m15597s() {
            this.f12651j = (ReactionUnitHeaderFieldsModel) super.a(this.f12651j, 6, ReactionUnitHeaderFieldsModel.class);
            return this.f12651j;
        }

        @Nullable
        public final String mo821j() {
            this.f12652k = super.a(this.f12652k, 7);
            return this.f12652k;
        }

        @Nullable
        private ReactionUnitExpirationConditionFragmentModel m15598t() {
            this.f12653l = (ReactionUnitExpirationConditionFragmentModel) super.a(this.f12653l, 8, ReactionUnitExpirationConditionFragmentModel.class);
            return this.f12653l;
        }

        public final int mo823l() {
            a(1, 1);
            return this.f12654m;
        }

        @Nullable
        public final GraphQLReactionUnitStyle mo824m() {
            this.f12655n = (GraphQLReactionUnitStyle) super.b(this.f12655n, 10, GraphQLReactionUnitStyle.class, GraphQLReactionUnitStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12655n;
        }

        @Nullable
        public final String mo825n() {
            this.f12656o = super.a(this.f12656o, 11);
            return this.f12656o;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15599u() {
            this.f12657p = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12657p, 12, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12657p;
        }

        @Nullable
        private SizeAwareMediaModel m15600v() {
            this.f12658q = (SizeAwareMediaModel) super.a(this.f12658q, 13, SizeAwareMediaModel.class);
            return this.f12658q;
        }

        public static ReactionUnitDefaultFieldsModel m15594a(ReactionUnitDefaultFields reactionUnitDefaultFields) {
            if (reactionUnitDefaultFields == null) {
                return null;
            }
            if (reactionUnitDefaultFields instanceof ReactionUnitDefaultFieldsModel) {
                return (ReactionUnitDefaultFieldsModel) reactionUnitDefaultFields;
            }
            Builder builder = new Builder();
            builder.f12631a = reactionUnitDefaultFields.mo814b();
            builder.f12632b = reactionUnitDefaultFields.mo815c();
            builder.f12633c = reactionUnitDefaultFields.mo816d();
            builder.f12634d = reactionUnitDefaultFields.fv_();
            builder.f12635e = ReactionPageFieldsWithPlaceTipsInfoModel.m14528a(reactionUnitDefaultFields.mo820g());
            builder.f12636f = ReactionAttachmentsModel.m15540a(reactionUnitDefaultFields.fx_());
            builder.f12637g = ReactionUnitHeaderFieldsModel.m15659a(reactionUnitDefaultFields.fw_());
            builder.f12638h = reactionUnitDefaultFields.mo821j();
            builder.f12639i = ReactionUnitExpirationConditionFragmentModel.m15618a(reactionUnitDefaultFields.mo822k());
            builder.f12640j = reactionUnitDefaultFields.mo823l();
            builder.f12641k = reactionUnitDefaultFields.mo824m();
            builder.f12642l = reactionUnitDefaultFields.mo825n();
            builder.f12643m = DefaultTextWithEntitiesFieldsModel.a(reactionUnitDefaultFields.mo826o());
            builder.f12644n = SizeAwareMediaModel.a(reactionUnitDefaultFields.mo827p());
            return new ReactionUnitDefaultFieldsModel(builder);
        }

        public ReactionUnitDefaultFieldsModel(Builder builder) {
            super(14);
            this.f12645d = builder.f12631a;
            this.f12646e = builder.f12632b;
            this.f12647f = builder.f12633c;
            this.f12648g = builder.f12634d;
            this.f12649h = builder.f12635e;
            this.f12650i = builder.f12636f;
            this.f12651j = builder.f12637g;
            this.f12652k = builder.f12638h;
            this.f12653l = builder.f12639i;
            this.f12654m = builder.f12640j;
            this.f12655n = builder.f12641k;
            this.f12656o = builder.f12642l;
            this.f12657p = builder.f12643m;
            this.f12658q = builder.f12644n;
        }

        @Nullable
        public final String m15603a() {
            return mo816d();
        }

        public final int jK_() {
            return -1551679635;
        }

        public final GraphQLVisitableModel m15602a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15595q() != null) {
                ReactionPageFieldsWithPlaceTipsInfoModel reactionPageFieldsWithPlaceTipsInfoModel = (ReactionPageFieldsWithPlaceTipsInfoModel) graphQLModelMutatingVisitor.b(m15595q());
                if (m15595q() != reactionPageFieldsWithPlaceTipsInfoModel) {
                    graphQLVisitableModel = (ReactionUnitDefaultFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12649h = reactionPageFieldsWithPlaceTipsInfoModel;
                }
            }
            if (m15596r() != null) {
                ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) graphQLModelMutatingVisitor.b(m15596r());
                if (m15596r() != reactionAttachmentsModel) {
                    graphQLVisitableModel = (ReactionUnitDefaultFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12650i = reactionAttachmentsModel;
                }
            }
            if (m15597s() != null) {
                ReactionUnitHeaderFieldsModel reactionUnitHeaderFieldsModel = (ReactionUnitHeaderFieldsModel) graphQLModelMutatingVisitor.b(m15597s());
                if (m15597s() != reactionUnitHeaderFieldsModel) {
                    graphQLVisitableModel = (ReactionUnitDefaultFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12651j = reactionUnitHeaderFieldsModel;
                }
            }
            if (m15598t() != null) {
                ReactionUnitExpirationConditionFragmentModel reactionUnitExpirationConditionFragmentModel = (ReactionUnitExpirationConditionFragmentModel) graphQLModelMutatingVisitor.b(m15598t());
                if (m15598t() != reactionUnitExpirationConditionFragmentModel) {
                    graphQLVisitableModel = (ReactionUnitDefaultFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12653l = reactionUnitExpirationConditionFragmentModel;
                }
            }
            if (m15599u() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15599u());
                if (m15599u() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionUnitDefaultFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12657p = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15600v() != null) {
                SizeAwareMediaModel sizeAwareMediaModel = (SizeAwareMediaModel) graphQLModelMutatingVisitor.b(m15600v());
                if (m15600v() != sizeAwareMediaModel) {
                    graphQLVisitableModel = (ReactionUnitDefaultFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12658q = sizeAwareMediaModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15601a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo814b());
            int a2 = flatBufferBuilder.a(mo815c());
            int b = flatBufferBuilder.b(mo816d());
            int b2 = flatBufferBuilder.b(fv_());
            int a3 = ModelHelper.a(flatBufferBuilder, m15595q());
            int a4 = ModelHelper.a(flatBufferBuilder, m15596r());
            int a5 = ModelHelper.a(flatBufferBuilder, m15597s());
            int b3 = flatBufferBuilder.b(mo821j());
            int a6 = ModelHelper.a(flatBufferBuilder, m15598t());
            int a7 = flatBufferBuilder.a(mo824m());
            int b4 = flatBufferBuilder.b(mo825n());
            int a8 = ModelHelper.a(flatBufferBuilder, m15599u());
            int a9 = ModelHelper.a(flatBufferBuilder, m15600v());
            flatBufferBuilder.c(14);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, b3);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.a(9, this.f12654m, 0);
            flatBufferBuilder.b(10, a7);
            flatBufferBuilder.b(11, b4);
            flatBufferBuilder.b(12, a8);
            flatBufferBuilder.b(13, a9);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15604a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12654m = mutableFlatBuffer.a(i, 9, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1571822667)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: file IO exception on reading */
    public final class ReactionUnitExpirationConditionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private int f12662d;
        @Nullable
        private DefaultLocationFieldsModel f12663e;
        private long f12664f;

        /* compiled from: file IO exception on reading */
        public final class Builder {
            public int f12659a;
            @Nullable
            public DefaultLocationFieldsModel f12660b;
            public long f12661c;
        }

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionUnitExpirationConditionFragmentModel.class, new Deserializer());
            }

            public Object m15616a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionUnitExpirationConditionFragmentParser.m15725a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionUnitExpirationConditionFragmentModel = new ReactionUnitExpirationConditionFragmentModel();
                ((BaseModel) reactionUnitExpirationConditionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionUnitExpirationConditionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionUnitExpirationConditionFragmentModel).a();
                }
                return reactionUnitExpirationConditionFragmentModel;
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionUnitExpirationConditionFragmentModel> {
            public final void m15617a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionUnitExpirationConditionFragmentModel reactionUnitExpirationConditionFragmentModel = (ReactionUnitExpirationConditionFragmentModel) obj;
                if (reactionUnitExpirationConditionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionUnitExpirationConditionFragmentModel.m15621a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionUnitExpirationConditionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionUnitExpirationConditionFragmentParser.m15726a(reactionUnitExpirationConditionFragmentModel.w_(), reactionUnitExpirationConditionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionUnitExpirationConditionFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultLocationFields m15624b() {
            return m15619j();
        }

        public ReactionUnitExpirationConditionFragmentModel() {
            super(3);
        }

        public final int m15620a() {
            a(0, 0);
            return this.f12662d;
        }

        @Nullable
        private DefaultLocationFieldsModel m15619j() {
            this.f12663e = (DefaultLocationFieldsModel) super.a(this.f12663e, 1, DefaultLocationFieldsModel.class);
            return this.f12663e;
        }

        public final long m15625c() {
            a(0, 2);
            return this.f12664f;
        }

        public static ReactionUnitExpirationConditionFragmentModel m15618a(ReactionUnitExpirationConditionFragmentModel reactionUnitExpirationConditionFragmentModel) {
            if (reactionUnitExpirationConditionFragmentModel == null) {
                return null;
            }
            if (reactionUnitExpirationConditionFragmentModel instanceof ReactionUnitExpirationConditionFragmentModel) {
                return reactionUnitExpirationConditionFragmentModel;
            }
            Builder builder = new Builder();
            builder.f12659a = reactionUnitExpirationConditionFragmentModel.m15620a();
            builder.f12660b = DefaultLocationFieldsModel.a(reactionUnitExpirationConditionFragmentModel.m15624b());
            builder.f12661c = reactionUnitExpirationConditionFragmentModel.m15625c();
            return new ReactionUnitExpirationConditionFragmentModel(builder);
        }

        public ReactionUnitExpirationConditionFragmentModel(Builder builder) {
            super(3);
            this.f12662d = builder.f12659a;
            this.f12663e = builder.f12660b;
            this.f12664f = builder.f12661c;
        }

        public final int jK_() {
            return -1534572929;
        }

        public final GraphQLVisitableModel m15622a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15619j() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m15619j());
                if (m15619j() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (ReactionUnitExpirationConditionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12663e = defaultLocationFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15621a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15619j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f12662d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.a(2, this.f12664f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15623a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12662d = mutableFlatBuffer.a(i, 0, 0);
            this.f12664f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 344214568)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: file IO exception on reading */
    public final class ReactionUnitFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, ReactionUnitFragment {
        @Nullable
        private GraphQLObjectType f12682d;
        @Nullable
        private GraphQLReactionUnitCollapseState f12683e;
        private boolean f12684f;
        @Nullable
        private String f12685g;
        @Nullable
        private String f12686h;
        @Nullable
        private ReactionPageFieldsWithPlaceTipsInfoModel f12687i;
        @Nullable
        private ReactionAggregatedUnitsModel f12688j;
        @Nullable
        private ReactionAttachmentsModel f12689k;
        @Nullable
        private List<ReactionUnitComponentModel> f12690l;
        @Nullable
        private ReactionUnitHeaderFieldsModel f12691m;
        @Nullable
        private String f12692n;
        @Nullable
        private ReactionUnitExpirationConditionFragmentModel f12693o;
        private int f12694p;
        @Nullable
        private GraphQLReactionUnitStyle f12695q;
        @Nullable
        private String f12696r;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12697s;
        @Nullable
        private SizeAwareMediaModel f12698t;

        /* compiled from: file IO exception on reading */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f12665a;
            @Nullable
            public GraphQLReactionUnitCollapseState f12666b;
            public boolean f12667c;
            @Nullable
            public String f12668d;
            @Nullable
            public String f12669e;
            @Nullable
            public ReactionPageFieldsWithPlaceTipsInfoModel f12670f;
            @Nullable
            public ReactionAggregatedUnitsModel f12671g;
            @Nullable
            public ReactionAttachmentsModel f12672h;
            @Nullable
            public ImmutableList<ReactionUnitComponentModel> f12673i;
            @Nullable
            public ReactionUnitHeaderFieldsModel f12674j;
            @Nullable
            public String f12675k;
            @Nullable
            public ReactionUnitExpirationConditionFragmentModel f12676l;
            public int f12677m;
            @Nullable
            public GraphQLReactionUnitStyle f12678n;
            @Nullable
            public String f12679o;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12680p;
            @Nullable
            public SizeAwareMediaModel f12681q;

            public static Builder m15626a(ReactionUnitFragmentModel reactionUnitFragmentModel) {
                Builder builder = new Builder();
                builder.f12665a = reactionUnitFragmentModel.mo814b();
                builder.f12666b = reactionUnitFragmentModel.mo815c();
                builder.f12667c = reactionUnitFragmentModel.mo831q();
                builder.f12668d = reactionUnitFragmentModel.mo816d();
                builder.f12669e = reactionUnitFragmentModel.fv_();
                builder.f12670f = reactionUnitFragmentModel.m15649t();
                builder.f12671g = reactionUnitFragmentModel.m15650u();
                builder.f12672h = reactionUnitFragmentModel.m15651v();
                builder.f12673i = reactionUnitFragmentModel.mo833s();
                builder.f12674j = reactionUnitFragmentModel.m15652w();
                builder.f12675k = reactionUnitFragmentModel.mo821j();
                builder.f12676l = reactionUnitFragmentModel.m15653x();
                builder.f12677m = reactionUnitFragmentModel.mo823l();
                builder.f12678n = reactionUnitFragmentModel.mo824m();
                builder.f12679o = reactionUnitFragmentModel.mo825n();
                builder.f12680p = reactionUnitFragmentModel.m15654y();
                builder.f12681q = reactionUnitFragmentModel.m15655z();
                return builder;
            }

            public final ReactionUnitFragmentModel m15627a() {
                return new ReactionUnitFragmentModel(this);
            }
        }

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionUnitFragmentModel.class, new Deserializer());
            }

            public Object m15628a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionUnitFragmentParser.m15727a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionUnitFragmentModel = new ReactionUnitFragmentModel();
                ((BaseModel) reactionUnitFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionUnitFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionUnitFragmentModel).a();
                }
                return reactionUnitFragmentModel;
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionUnitFragmentModel> {
            public final void m15629a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionUnitFragmentModel reactionUnitFragmentModel = (ReactionUnitFragmentModel) obj;
                if (reactionUnitFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionUnitFragmentModel.m15631a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionUnitFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionUnitFragmentParser.m15728a(reactionUnitFragmentModel.w_(), reactionUnitFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionUnitFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ReactionUnitHeaderFieldsModel fw_() {
            return m15652w();
        }

        @Nullable
        public final /* synthetic */ ReactionAttachmentsModel fx_() {
            return m15651v();
        }

        @Nullable
        public final /* synthetic */ ReactionPageFieldsWithPlaceTipsInfoModel mo820g() {
            return m15649t();
        }

        @Nullable
        public final /* synthetic */ ReactionUnitExpirationConditionFragmentModel mo822k() {
            return m15653x();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields mo826o() {
            return m15654y();
        }

        @Nullable
        public final /* synthetic */ SizeAwareMedia mo827p() {
            return m15655z();
        }

        @Nullable
        public final /* synthetic */ ReactionAggregatedUnitsModel mo832r() {
            return m15650u();
        }

        public ReactionUnitFragmentModel() {
            super(17);
        }

        @Nullable
        public final GraphQLObjectType mo814b() {
            if (this.b != null && this.f12682d == null) {
                this.f12682d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12682d;
        }

        @Nullable
        public final GraphQLReactionUnitCollapseState mo815c() {
            this.f12683e = (GraphQLReactionUnitCollapseState) super.b(this.f12683e, 1, GraphQLReactionUnitCollapseState.class, GraphQLReactionUnitCollapseState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12683e;
        }

        public final boolean mo831q() {
            a(0, 2);
            return this.f12684f;
        }

        @Nullable
        public final String mo816d() {
            this.f12685g = super.a(this.f12685g, 3);
            return this.f12685g;
        }

        @Nullable
        public final String fv_() {
            this.f12686h = super.a(this.f12686h, 4);
            return this.f12686h;
        }

        @Nullable
        public final ReactionPageFieldsWithPlaceTipsInfoModel m15649t() {
            this.f12687i = (ReactionPageFieldsWithPlaceTipsInfoModel) super.a(this.f12687i, 5, ReactionPageFieldsWithPlaceTipsInfoModel.class);
            return this.f12687i;
        }

        @Nullable
        public final ReactionAggregatedUnitsModel m15650u() {
            this.f12688j = (ReactionAggregatedUnitsModel) super.a(this.f12688j, 6, ReactionAggregatedUnitsModel.class);
            return this.f12688j;
        }

        @Nullable
        public final ReactionAttachmentsModel m15651v() {
            this.f12689k = (ReactionAttachmentsModel) super.a(this.f12689k, 7, ReactionAttachmentsModel.class);
            return this.f12689k;
        }

        @Nonnull
        public final ImmutableList<ReactionUnitComponentModel> mo833s() {
            this.f12690l = super.a(this.f12690l, 8, ReactionUnitComponentModel.class);
            return (ImmutableList) this.f12690l;
        }

        @Nullable
        public final ReactionUnitHeaderFieldsModel m15652w() {
            this.f12691m = (ReactionUnitHeaderFieldsModel) super.a(this.f12691m, 9, ReactionUnitHeaderFieldsModel.class);
            return this.f12691m;
        }

        @Nullable
        public final String mo821j() {
            this.f12692n = super.a(this.f12692n, 10);
            return this.f12692n;
        }

        @Nullable
        public final ReactionUnitExpirationConditionFragmentModel m15653x() {
            this.f12693o = (ReactionUnitExpirationConditionFragmentModel) super.a(this.f12693o, 11, ReactionUnitExpirationConditionFragmentModel.class);
            return this.f12693o;
        }

        public final int mo823l() {
            a(1, 4);
            return this.f12694p;
        }

        @Nullable
        public final GraphQLReactionUnitStyle mo824m() {
            this.f12695q = (GraphQLReactionUnitStyle) super.b(this.f12695q, 13, GraphQLReactionUnitStyle.class, GraphQLReactionUnitStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12695q;
        }

        @Nullable
        public final String mo825n() {
            this.f12696r = super.a(this.f12696r, 14);
            return this.f12696r;
        }

        @Nullable
        public final DefaultTextWithEntitiesFieldsModel m15654y() {
            this.f12697s = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12697s, 15, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12697s;
        }

        @Nullable
        public final SizeAwareMediaModel m15655z() {
            this.f12698t = (SizeAwareMediaModel) super.a(this.f12698t, 16, SizeAwareMediaModel.class);
            return this.f12698t;
        }

        public static ReactionUnitFragmentModel m15630a(ReactionUnitFragment reactionUnitFragment) {
            if (reactionUnitFragment == null) {
                return null;
            }
            if (reactionUnitFragment instanceof ReactionUnitFragmentModel) {
                return (ReactionUnitFragmentModel) reactionUnitFragment;
            }
            Builder builder = new Builder();
            builder.f12665a = reactionUnitFragment.mo814b();
            builder.f12666b = reactionUnitFragment.mo815c();
            builder.f12667c = reactionUnitFragment.mo831q();
            builder.f12668d = reactionUnitFragment.mo816d();
            builder.f12669e = reactionUnitFragment.fv_();
            builder.f12670f = ReactionPageFieldsWithPlaceTipsInfoModel.m14528a(reactionUnitFragment.mo820g());
            builder.f12671g = ReactionAggregatedUnitsModel.m15376a(reactionUnitFragment.mo832r());
            builder.f12672h = ReactionAttachmentsModel.m15540a(reactionUnitFragment.fx_());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < reactionUnitFragment.mo833s().size(); i++) {
                builder2.c(ReactionUnitComponentModel.m17503a((ReactionUnitComponentModel) reactionUnitFragment.mo833s().get(i)));
            }
            builder.f12673i = builder2.b();
            builder.f12674j = ReactionUnitHeaderFieldsModel.m15659a(reactionUnitFragment.fw_());
            builder.f12675k = reactionUnitFragment.mo821j();
            builder.f12676l = ReactionUnitExpirationConditionFragmentModel.m15618a(reactionUnitFragment.mo822k());
            builder.f12677m = reactionUnitFragment.mo823l();
            builder.f12678n = reactionUnitFragment.mo824m();
            builder.f12679o = reactionUnitFragment.mo825n();
            builder.f12680p = DefaultTextWithEntitiesFieldsModel.a(reactionUnitFragment.mo826o());
            builder.f12681q = SizeAwareMediaModel.a(reactionUnitFragment.mo827p());
            return builder.m15627a();
        }

        public ReactionUnitFragmentModel(Builder builder) {
            super(17);
            this.f12682d = builder.f12665a;
            this.f12683e = builder.f12666b;
            this.f12684f = builder.f12667c;
            this.f12685g = builder.f12668d;
            this.f12686h = builder.f12669e;
            this.f12687i = builder.f12670f;
            this.f12688j = builder.f12671g;
            this.f12689k = builder.f12672h;
            this.f12690l = builder.f12673i;
            this.f12691m = builder.f12674j;
            this.f12692n = builder.f12675k;
            this.f12693o = builder.f12676l;
            this.f12694p = builder.f12677m;
            this.f12695q = builder.f12678n;
            this.f12696r = builder.f12679o;
            this.f12697s = builder.f12680p;
            this.f12698t = builder.f12681q;
        }

        @Nullable
        public final String m15633a() {
            return mo816d();
        }

        public final int jK_() {
            return -1551679635;
        }

        public final GraphQLVisitableModel m15632a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15649t() != null) {
                ReactionPageFieldsWithPlaceTipsInfoModel reactionPageFieldsWithPlaceTipsInfoModel = (ReactionPageFieldsWithPlaceTipsInfoModel) graphQLModelMutatingVisitor.b(m15649t());
                if (m15649t() != reactionPageFieldsWithPlaceTipsInfoModel) {
                    graphQLVisitableModel = (ReactionUnitFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12687i = reactionPageFieldsWithPlaceTipsInfoModel;
                }
            }
            if (m15650u() != null) {
                ReactionAggregatedUnitsModel reactionAggregatedUnitsModel = (ReactionAggregatedUnitsModel) graphQLModelMutatingVisitor.b(m15650u());
                if (m15650u() != reactionAggregatedUnitsModel) {
                    graphQLVisitableModel = (ReactionUnitFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12688j = reactionAggregatedUnitsModel;
                }
            }
            if (m15651v() != null) {
                ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) graphQLModelMutatingVisitor.b(m15651v());
                if (m15651v() != reactionAttachmentsModel) {
                    graphQLVisitableModel = (ReactionUnitFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12689k = reactionAttachmentsModel;
                }
            }
            if (mo833s() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(mo833s(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ReactionUnitFragmentModel reactionUnitFragmentModel = (ReactionUnitFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    reactionUnitFragmentModel.f12690l = a.b();
                    graphQLVisitableModel = reactionUnitFragmentModel;
                }
            }
            if (m15652w() != null) {
                ReactionUnitHeaderFieldsModel reactionUnitHeaderFieldsModel = (ReactionUnitHeaderFieldsModel) graphQLModelMutatingVisitor.b(m15652w());
                if (m15652w() != reactionUnitHeaderFieldsModel) {
                    graphQLVisitableModel = (ReactionUnitFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12691m = reactionUnitHeaderFieldsModel;
                }
            }
            if (m15653x() != null) {
                ReactionUnitExpirationConditionFragmentModel reactionUnitExpirationConditionFragmentModel = (ReactionUnitExpirationConditionFragmentModel) graphQLModelMutatingVisitor.b(m15653x());
                if (m15653x() != reactionUnitExpirationConditionFragmentModel) {
                    graphQLVisitableModel = (ReactionUnitFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12693o = reactionUnitExpirationConditionFragmentModel;
                }
            }
            if (m15654y() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15654y());
                if (m15654y() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionUnitFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12697s = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15655z() != null) {
                SizeAwareMediaModel sizeAwareMediaModel = (SizeAwareMediaModel) graphQLModelMutatingVisitor.b(m15655z());
                if (m15655z() != sizeAwareMediaModel) {
                    graphQLVisitableModel = (ReactionUnitFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12698t = sizeAwareMediaModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15631a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo814b());
            int a2 = flatBufferBuilder.a(mo815c());
            int b = flatBufferBuilder.b(mo816d());
            int b2 = flatBufferBuilder.b(fv_());
            int a3 = ModelHelper.a(flatBufferBuilder, m15649t());
            int a4 = ModelHelper.a(flatBufferBuilder, m15650u());
            int a5 = ModelHelper.a(flatBufferBuilder, m15651v());
            int a6 = ModelHelper.a(flatBufferBuilder, mo833s());
            int a7 = ModelHelper.a(flatBufferBuilder, m15652w());
            int b3 = flatBufferBuilder.b(mo821j());
            int a8 = ModelHelper.a(flatBufferBuilder, m15653x());
            int a9 = flatBufferBuilder.a(mo824m());
            int b4 = flatBufferBuilder.b(mo825n());
            int a10 = ModelHelper.a(flatBufferBuilder, m15654y());
            int a11 = ModelHelper.a(flatBufferBuilder, m15655z());
            flatBufferBuilder.c(17);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f12684f);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.b(10, b3);
            flatBufferBuilder.b(11, a8);
            flatBufferBuilder.a(12, this.f12694p, 0);
            flatBufferBuilder.b(13, a9);
            flatBufferBuilder.b(14, b4);
            flatBufferBuilder.b(15, a10);
            flatBufferBuilder.b(16, a11);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15634a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12684f = mutableFlatBuffer.a(i, 2);
            this.f12694p = mutableFlatBuffer.a(i, 12, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1803923279)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: file IO exception on reading */
    public final class ReactionUnitHeaderFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f12707d;
        @Nullable
        private ReactionStoryAttachmentActionFragmentModel f12708e;
        @Nullable
        private GraphQLReactionUnitHeaderStyle f12709f;
        @Nullable
        private ReactionImageFieldsModel f12710g;
        @Nullable
        private LinkableTextWithEntitiesModel f12711h;
        @Nullable
        private List<ReactionFacepileProfileModel> f12712i;
        @Nullable
        private List<ReactionStoryAttachmentActionFragmentModel> f12713j;
        @Nullable
        private LinkableTextWithEntitiesModel f12714k;

        /* compiled from: file IO exception on reading */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f12699a;
            @Nullable
            public ReactionStoryAttachmentActionFragmentModel f12700b;
            @Nullable
            public GraphQLReactionUnitHeaderStyle f12701c;
            @Nullable
            public ReactionImageFieldsModel f12702d;
            @Nullable
            public LinkableTextWithEntitiesModel f12703e;
            @Nullable
            public ImmutableList<ReactionFacepileProfileModel> f12704f;
            @Nullable
            public ImmutableList<ReactionStoryAttachmentActionFragmentModel> f12705g;
            @Nullable
            public LinkableTextWithEntitiesModel f12706h;

            public final ReactionUnitHeaderFieldsModel m15656a() {
                return new ReactionUnitHeaderFieldsModel(this);
            }
        }

        /* compiled from: file IO exception on reading */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionUnitHeaderFieldsModel.class, new Deserializer());
            }

            public Object m15657a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionUnitHeaderFieldsParser.m15729a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionUnitHeaderFieldsModel = new ReactionUnitHeaderFieldsModel();
                ((BaseModel) reactionUnitHeaderFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionUnitHeaderFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionUnitHeaderFieldsModel).a();
                }
                return reactionUnitHeaderFieldsModel;
            }
        }

        /* compiled from: file IO exception on reading */
        public class Serializer extends JsonSerializer<ReactionUnitHeaderFieldsModel> {
            public final void m15658a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionUnitHeaderFieldsModel reactionUnitHeaderFieldsModel = (ReactionUnitHeaderFieldsModel) obj;
                if (reactionUnitHeaderFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionUnitHeaderFieldsModel.m15660a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionUnitHeaderFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionUnitHeaderFieldsParser.m15730a(reactionUnitHeaderFieldsModel.w_(), reactionUnitHeaderFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionUnitHeaderFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ReactionStoryAttachmentActionFragmentModel m15663b() {
            return m15667j();
        }

        @Nullable
        public final /* synthetic */ ReactionImageFields m15665d() {
            return m15668k();
        }

        @Nullable
        public final /* synthetic */ LinkableTextWithEntities fA_() {
            return m15669l();
        }

        @Nullable
        public final /* synthetic */ LinkableTextWithEntities fz_() {
            return m15670m();
        }

        public ReactionUnitHeaderFieldsModel() {
            super(8);
        }

        @Nullable
        public final GraphQLObjectType m15661a() {
            if (this.b != null && this.f12707d == null) {
                this.f12707d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12707d;
        }

        @Nullable
        public final ReactionStoryAttachmentActionFragmentModel m15667j() {
            this.f12708e = (ReactionStoryAttachmentActionFragmentModel) super.a(this.f12708e, 1, ReactionStoryAttachmentActionFragmentModel.class);
            return this.f12708e;
        }

        @Nullable
        public final GraphQLReactionUnitHeaderStyle m15664c() {
            this.f12709f = (GraphQLReactionUnitHeaderStyle) super.b(this.f12709f, 2, GraphQLReactionUnitHeaderStyle.class, GraphQLReactionUnitHeaderStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12709f;
        }

        @Nullable
        public final ReactionImageFieldsModel m15668k() {
            this.f12710g = (ReactionImageFieldsModel) super.a(this.f12710g, 3, ReactionImageFieldsModel.class);
            return this.f12710g;
        }

        @Nullable
        public final LinkableTextWithEntitiesModel m15669l() {
            this.f12711h = (LinkableTextWithEntitiesModel) super.a(this.f12711h, 4, LinkableTextWithEntitiesModel.class);
            return this.f12711h;
        }

        @Nonnull
        public final ImmutableList<ReactionFacepileProfileModel> m15666g() {
            this.f12712i = super.a(this.f12712i, 5, ReactionFacepileProfileModel.class);
            return (ImmutableList) this.f12712i;
        }

        @Nonnull
        public final ImmutableList<ReactionStoryAttachmentActionFragmentModel> fy_() {
            this.f12713j = super.a(this.f12713j, 6, ReactionStoryAttachmentActionFragmentModel.class);
            return (ImmutableList) this.f12713j;
        }

        @Nullable
        public final LinkableTextWithEntitiesModel m15670m() {
            this.f12714k = (LinkableTextWithEntitiesModel) super.a(this.f12714k, 7, LinkableTextWithEntitiesModel.class);
            return this.f12714k;
        }

        public static ReactionUnitHeaderFieldsModel m15659a(ReactionUnitHeaderFieldsModel reactionUnitHeaderFieldsModel) {
            int i = 0;
            if (reactionUnitHeaderFieldsModel == null) {
                return null;
            }
            if (reactionUnitHeaderFieldsModel instanceof ReactionUnitHeaderFieldsModel) {
                return reactionUnitHeaderFieldsModel;
            }
            Builder builder = new Builder();
            builder.f12699a = reactionUnitHeaderFieldsModel.m15661a();
            builder.f12700b = ReactionStoryAttachmentActionFragmentModel.m16357a(reactionUnitHeaderFieldsModel.m15663b());
            builder.f12701c = reactionUnitHeaderFieldsModel.m15664c();
            builder.f12702d = ReactionImageFieldsModel.m14497a(reactionUnitHeaderFieldsModel.m15665d());
            builder.f12703e = LinkableTextWithEntitiesModel.a(reactionUnitHeaderFieldsModel.fA_());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i2 = 0; i2 < reactionUnitHeaderFieldsModel.m15666g().size(); i2++) {
                builder2.c(ReactionFacepileProfileModel.m14459a((ReactionFacepileProfile) reactionUnitHeaderFieldsModel.m15666g().get(i2)));
            }
            builder.f12704f = builder2.b();
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            while (i < reactionUnitHeaderFieldsModel.fy_().size()) {
                builder3.c(ReactionStoryAttachmentActionFragmentModel.m16357a((ReactionStoryAttachmentActionFragmentModel) reactionUnitHeaderFieldsModel.fy_().get(i)));
                i++;
            }
            builder.f12705g = builder3.b();
            builder.f12706h = LinkableTextWithEntitiesModel.a(reactionUnitHeaderFieldsModel.fz_());
            return builder.m15656a();
        }

        public ReactionUnitHeaderFieldsModel(Builder builder) {
            super(8);
            this.f12707d = builder.f12699a;
            this.f12708e = builder.f12700b;
            this.f12709f = builder.f12701c;
            this.f12710g = builder.f12702d;
            this.f12711h = builder.f12703e;
            this.f12712i = builder.f12704f;
            this.f12713j = builder.f12705g;
            this.f12714k = builder.f12706h;
        }

        public final int jK_() {
            return 1685653594;
        }

        public final GraphQLVisitableModel m15662a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            LinkableTextWithEntitiesModel linkableTextWithEntitiesModel;
            com.google.common.collect.ImmutableList.Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15667j() != null) {
                ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) graphQLModelMutatingVisitor.b(m15667j());
                if (m15667j() != reactionStoryAttachmentActionFragmentModel) {
                    graphQLVisitableModel = (ReactionUnitHeaderFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12708e = reactionStoryAttachmentActionFragmentModel;
                }
            }
            if (m15668k() != null) {
                ReactionImageFieldsModel reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(m15668k());
                if (m15668k() != reactionImageFieldsModel) {
                    graphQLVisitableModel = (ReactionUnitHeaderFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12710g = reactionImageFieldsModel;
                }
            }
            if (m15669l() != null) {
                linkableTextWithEntitiesModel = (LinkableTextWithEntitiesModel) graphQLModelMutatingVisitor.b(m15669l());
                if (m15669l() != linkableTextWithEntitiesModel) {
                    graphQLVisitableModel = (ReactionUnitHeaderFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12711h = linkableTextWithEntitiesModel;
                }
            }
            if (m15666g() != null) {
                a = ModelHelper.a(m15666g(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ReactionUnitHeaderFieldsModel reactionUnitHeaderFieldsModel = (ReactionUnitHeaderFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    reactionUnitHeaderFieldsModel.f12712i = a.b();
                    graphQLVisitableModel = reactionUnitHeaderFieldsModel;
                }
            }
            if (fy_() != null) {
                a = ModelHelper.a(fy_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    reactionUnitHeaderFieldsModel = (ReactionUnitHeaderFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    reactionUnitHeaderFieldsModel.f12713j = a.b();
                    graphQLVisitableModel = reactionUnitHeaderFieldsModel;
                }
            }
            if (m15670m() != null) {
                linkableTextWithEntitiesModel = (LinkableTextWithEntitiesModel) graphQLModelMutatingVisitor.b(m15670m());
                if (m15670m() != linkableTextWithEntitiesModel) {
                    graphQLVisitableModel = (ReactionUnitHeaderFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12714k = linkableTextWithEntitiesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15660a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15661a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15667j());
            int a3 = flatBufferBuilder.a(m15664c());
            int a4 = ModelHelper.a(flatBufferBuilder, m15668k());
            int a5 = ModelHelper.a(flatBufferBuilder, m15669l());
            int a6 = ModelHelper.a(flatBufferBuilder, m15666g());
            int a7 = ModelHelper.a(flatBufferBuilder, fy_());
            int a8 = ModelHelper.a(flatBufferBuilder, m15670m());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.b(6, a7);
            flatBufferBuilder.b(7, a8);
            i();
            return flatBufferBuilder.d();
        }
    }
}
