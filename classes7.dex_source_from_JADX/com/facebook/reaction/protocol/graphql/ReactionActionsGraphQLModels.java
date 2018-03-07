package com.facebook.reaction.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFundraiserSupportersConnectionType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLNearbyFriendsNuxType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPagePhotoSourceType;
import com.facebook.graphql.enums.GraphQLPhotosByCategoryEntryPoint;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentActionStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeModels.ComposerTargetDataPrivacyScopeFieldsModel;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionProfileFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionFeedbackFieldsModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionImageFieldsModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionProfileFieldsModel.CoverPhotoModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitComponentBaseFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionActionFatFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionCommerceActionFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionComposerActionFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionEventMessageOnlyFriendActionFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionEventMessageOnlyFriendActionFields.Event;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionFundraiserActionFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionGenericOpenGraphObjectActionFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionOpenNearbyPlacesActionFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionOpenPageAlbumActionFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionOpenPlaysActionFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionOpenVideoChannelFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionReplacementUnitFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionSeePageCommerceProductsFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionSendMessageAsPageFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoriesActionFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionCommonFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionViewCommentActionFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionViewEventGuestListActionFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionViewFundraiserSupportersActionFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionActionFatFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionActionFatFieldsParser.EventParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionActionFatFieldsParser.GroupParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionActionFatFieldsParser.PageParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionActionFatFieldsParser.ProfileParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionActionFatFieldsParser.RelatedUsersParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionActionFatFieldsParser.StoryParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionActionFatFieldsParser.StoryParser.FeedbackParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionAttachmentActionFragmentParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionCommerceActionFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionComposerActionFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionComposerActionFieldsParser.ComposerInlineActivityParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionComposerActionFieldsParser.ComposerInlineActivityParser.ObjectParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionComposerActionFieldsParser.ComposerInlineActivityParser.TaggableActivityIconParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionComposerActionFieldsParser.ComposerInlineActivityParser.TaggableActivityIconParser.ImageParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionComposerActionFieldsParser.EventSpaceParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionEventInviteFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionEventInviteFieldsParser.EventViewerCapabilityParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionEventInviteFieldsParser.ParentGroupParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionEventMessageOnlyFriendActionFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionEventMessageOnlyFriendActionFieldsParser.EventParser.EventPlaceParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionEventMessageOnlyFriendActionFieldsParser.FriendParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionFundraiserActionFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionFundraiserActionFieldsParser.FundraiserCampaignParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionFundraiserActionFieldsParser.FundraiserCampaignParser.FundraiserDetailedProgressTextParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionFundraiserActionFieldsParser.FundraiserCampaignParser.FundraiserForCharityTextParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionFundraiserActionFieldsParser.FundraiserCampaignParser.OwnerParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionGenericOpenGraphObjectActionFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionGenericOpenGraphObjectActionFieldsParser.ActionOgObjectParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionOpenNearbyPlacesActionFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionOpenNearbyPlacesActionFieldsParser.PlacesQueryLocationPageParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionOpenPageAlbumActionFragmentParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionOpenPageAlbumActionFragmentParser.AlbumParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionOpenPlaysActionFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionOpenPlaysActionFieldsParser.MatchPageParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionOpenVideoChannelFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionOpenVideoChannelFieldsParser.VideoChannelParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionReplacementUnitFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionReplacementUnitFieldsParser.ReplacementUnitParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionReplacementUnitFieldsParser.ReplacementUnitParser.ReactionUnitComponentsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionReplacementUnitFieldsParser.ReplacementUnitParser.ReactionUnitComponentsParser.ActionParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionSeePageCommerceProductsFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionSeePageCommerceProductsFieldsParser.CollectionParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionSendMessageAsPageFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionSendMessageAsPageFieldsParser.ThreadKeyParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionStoriesActionFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionStoriesActionFieldsParser.StoriesParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionStoryAttachmentActionCommonFragmentParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionStoryAttachmentActionFragmentParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionViewCommentActionFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionViewCommentActionFieldsParser.CommentParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionViewCommentActionFieldsParser.CommentParser.CommentParentParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionViewEventGuestListActionFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionViewFundraiserSupportersActionFieldsParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionViewFundraiserSupportersActionFieldsParser.FundraiserParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionWeatherSettingsPlaceItemFragmentParser;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLParsers.ReactionWeatherSettingsPlaceItemFragmentParser.ProfileParser.ProfilePictureParser;
import com.facebook.topics.protocol.TopicFavoritesQueryInterfaces.VideoTopicFragment;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicFragmentModel.SquareHeaderImageModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicFragmentModel.VideoChannelSubtitleModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicFragmentModel.VideoChannelTitleModel;
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

/* compiled from: field_icon */
public class ReactionActionsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 43671179)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionActionFatFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionActionFatFields {
        @Nullable
        private MatchPageModel f12791A;
        @Nullable
        private GraphQLNearbyFriendsNuxType f12792B;
        @Nullable
        private PageModel f12793C;
        @Nullable
        private String f12794D;
        @Nullable
        private GraphQLPagePhotoSourceType f12795E;
        @Nullable
        private String f12796F;
        @Nullable
        private PlacesQueryLocationPageModel f12797G;
        @Nullable
        private String f12798H;
        @Nullable
        private String f12799I;
        @Nullable
        private ProfileModel f12800J;
        @Nullable
        private String f12801K;
        @Nullable
        private String f12802L;
        @Nullable
        private List<RelatedUsersModel> f12803M;
        @Nullable
        private ReplacementUnitModel f12804N;
        @Nullable
        private PageServiceItemModel f12805O;
        @Nullable
        private String f12806P;
        @Nullable
        private String f12807Q;
        @Nullable
        private String f12808R;
        @Nullable
        private StoryModel f12809S;
        private boolean f12810T;
        @Nullable
        private String f12811U;
        @Nullable
        private ReactionEventInviteFieldsModel f12812V;
        @Nullable
        private String f12813W;
        @Nullable
        private ThreadKeyModel f12814X;
        @Nullable
        private String f12815Y;
        @Nullable
        private String f12816Z;
        @Nullable
        private VideoChannelModel aa;
        @Nullable
        private GraphQLObjectType f12817d;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12818e;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12819f;
        @Nullable
        private ActionOgObjectModel f12820g;
        @Nullable
        private AlbumModel f12821h;
        private boolean f12822i;
        @Nullable
        private CollectionModel f12823j;
        @Nullable
        private CommentModel f12824k;
        @Nullable
        private String f12825l;
        @Nullable
        private ComposerInlineActivityModel f12826m;
        @Nullable
        private GraphQLFundraiserSupportersConnectionType f12827n;
        @Nullable
        private String f12828o;
        @Nullable
        private GraphQLPhotosByCategoryEntryPoint f12829p;
        @Nullable
        private EventModel f12830q;
        @Nullable
        private EventSpaceModel f12831r;
        @Nullable
        private List<ReactionWeatherSettingsPlaceItemFragmentModel> f12832s;
        @Nullable
        private FriendModel f12833t;
        @Nullable
        private String f12834u;
        @Nullable
        private FundraiserModel f12835v;
        @Nullable
        private FundraiserCampaignModel f12836w;
        @Nullable
        private GroupModel f12837x;
        @Nullable
        private GraphQLEventWatchStatus f12838y;
        @Nullable
        private DefaultLocationFieldsModel f12839z;

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionActionFatFieldsModel.class, new Deserializer());
            }

            public Object m15788a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionActionFatFieldsParser.m16521a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionActionFatFieldsModel = new ReactionActionFatFieldsModel();
                ((BaseModel) reactionActionFatFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionActionFatFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionActionFatFieldsModel).a();
                }
                return reactionActionFatFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -849473002)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class EventModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, Event, ReactionViewEventGuestListActionFields.Event {
            @Nullable
            private GraphQLConnectionStyle f12724d;
            @Nullable
            private GraphQLEventPrivacyType f12725e;
            @Nullable
            private EventPlaceModel f12726f;
            @Nullable
            private EventViewerCapabilityModel f12727g;
            @Nullable
            private String f12728h;
            @Nullable
            private String f12729i;
            @Nullable
            private String f12730j;
            @Nullable
            private DefaultImageFieldsModel f12731k;
            @Nullable
            private GraphQLEventGuestStatus f12732l;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public GraphQLConnectionStyle f12715a;
                @Nullable
                public GraphQLEventPrivacyType f12716b;
                @Nullable
                public EventPlaceModel f12717c;
                @Nullable
                public EventViewerCapabilityModel f12718d;
                @Nullable
                public String f12719e;
                @Nullable
                public String f12720f;
                @Nullable
                public String f12721g;
                @Nullable
                public DefaultImageFieldsModel f12722h;
                @Nullable
                public GraphQLEventGuestStatus f12723i;

                public final EventModel m15789a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = flatBufferBuilder.a(this.f12715a);
                    int a2 = flatBufferBuilder.a(this.f12716b);
                    int a3 = ModelHelper.a(flatBufferBuilder, this.f12717c);
                    int a4 = ModelHelper.a(flatBufferBuilder, this.f12718d);
                    int b = flatBufferBuilder.b(this.f12719e);
                    int b2 = flatBufferBuilder.b(this.f12720f);
                    int b3 = flatBufferBuilder.b(this.f12721g);
                    int a5 = ModelHelper.a(flatBufferBuilder, this.f12722h);
                    int a6 = flatBufferBuilder.a(this.f12723i);
                    flatBufferBuilder.c(9);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    flatBufferBuilder.b(3, a4);
                    flatBufferBuilder.b(4, b);
                    flatBufferBuilder.b(5, b2);
                    flatBufferBuilder.b(6, b3);
                    flatBufferBuilder.b(7, a5);
                    flatBufferBuilder.b(8, a6);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventModel.class, new Deserializer());
                }

                public Object m15790a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventParser.m16505a(jsonParser, flatBufferBuilder));
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

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<EventModel> {
                public final void m15791a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventModel eventModel = (EventModel) obj;
                    if (eventModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventModel.m15798a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventParser.m16506a(eventModel.w_(), eventModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EventModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ EventPlaceModel m15805d() {
                return m15795l();
            }

            @Nullable
            public final /* synthetic */ EventViewerCapabilityModel fD_() {
                return m15796m();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m15807j() {
                return m15797n();
            }

            public EventModel() {
                super(9);
            }

            public EventModel(MutableFlatBuffer mutableFlatBuffer) {
                super(9);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m15801a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = fC_();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 6;
                } else if ("viewer_guest_status".equals(str)) {
                    consistencyTuple.a = mo839k();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 8;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m15802a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m15794a((String) obj);
                } else if ("viewer_guest_status".equals(str)) {
                    m15793a((GraphQLEventGuestStatus) obj);
                }
            }

            @Nullable
            public final GraphQLConnectionStyle mo834b() {
                this.f12724d = (GraphQLConnectionStyle) super.b(this.f12724d, 0, GraphQLConnectionStyle.class, GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12724d;
            }

            @Nullable
            public final GraphQLEventPrivacyType mo835c() {
                this.f12725e = (GraphQLEventPrivacyType) super.b(this.f12725e, 1, GraphQLEventPrivacyType.class, GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12725e;
            }

            @Nullable
            private EventPlaceModel m15795l() {
                this.f12726f = (EventPlaceModel) super.a(this.f12726f, 2, EventPlaceModel.class);
                return this.f12726f;
            }

            @Nullable
            private EventViewerCapabilityModel m15796m() {
                this.f12727g = (EventViewerCapabilityModel) super.a(this.f12727g, 3, EventViewerCapabilityModel.class);
                return this.f12727g;
            }

            @Nullable
            public final String mo838g() {
                this.f12728h = super.a(this.f12728h, 4);
                return this.f12728h;
            }

            @Nullable
            public final String fB_() {
                this.f12729i = super.a(this.f12729i, 5);
                return this.f12729i;
            }

            @Nullable
            public final String fC_() {
                this.f12730j = super.a(this.f12730j, 6);
                return this.f12730j;
            }

            private void m15794a(@Nullable String str) {
                this.f12730j = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 6, str);
                }
            }

            @Nullable
            private DefaultImageFieldsModel m15797n() {
                this.f12731k = (DefaultImageFieldsModel) super.a(this.f12731k, 7, DefaultImageFieldsModel.class);
                return this.f12731k;
            }

            @Nullable
            public final GraphQLEventGuestStatus mo839k() {
                this.f12732l = (GraphQLEventGuestStatus) super.b(this.f12732l, 8, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12732l;
            }

            private void m15793a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
                this.f12732l = graphQLEventGuestStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 8, graphQLEventGuestStatus != null ? graphQLEventGuestStatus.name() : null);
                }
            }

            public static EventModel m15792a(EventModel eventModel) {
                if (eventModel == null) {
                    return null;
                }
                if (eventModel instanceof EventModel) {
                    return eventModel;
                }
                Builder builder = new Builder();
                builder.f12715a = eventModel.mo834b();
                builder.f12716b = eventModel.mo835c();
                builder.f12717c = EventPlaceModel.m16056a(eventModel.m15805d());
                builder.f12718d = EventViewerCapabilityModel.m16444a(eventModel.fD_());
                builder.f12719e = eventModel.mo838g();
                builder.f12720f = eventModel.fB_();
                builder.f12721g = eventModel.fC_();
                builder.f12722h = DefaultImageFieldsModel.a(eventModel.m15807j());
                builder.f12723i = eventModel.mo839k();
                return builder.m15789a();
            }

            @Nullable
            public final String m15800a() {
                return mo838g();
            }

            public final int jK_() {
                return 67338874;
            }

            public final GraphQLVisitableModel m15799a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15795l() != null) {
                    EventPlaceModel eventPlaceModel = (EventPlaceModel) graphQLModelMutatingVisitor.b(m15795l());
                    if (m15795l() != eventPlaceModel) {
                        graphQLVisitableModel = (EventModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12726f = eventPlaceModel;
                    }
                }
                if (m15796m() != null) {
                    EventViewerCapabilityModel eventViewerCapabilityModel = (EventViewerCapabilityModel) graphQLModelMutatingVisitor.b(m15796m());
                    if (m15796m() != eventViewerCapabilityModel) {
                        graphQLVisitableModel = (EventModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12727g = eventViewerCapabilityModel;
                    }
                }
                if (m15797n() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15797n());
                    if (m15797n() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (EventModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12731k = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15798a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(mo834b());
                int a2 = flatBufferBuilder.a(mo835c());
                int a3 = ModelHelper.a(flatBufferBuilder, m15795l());
                int a4 = ModelHelper.a(flatBufferBuilder, m15796m());
                int b = flatBufferBuilder.b(mo838g());
                int b2 = flatBufferBuilder.b(fB_());
                int b3 = flatBufferBuilder.b(fC_());
                int a5 = ModelHelper.a(flatBufferBuilder, m15797n());
                int a6 = flatBufferBuilder.a(mo839k());
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, b);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.b(6, b3);
                flatBufferBuilder.b(7, a5);
                flatBufferBuilder.b(8, a6);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12734d;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f12733a;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m15809a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupParser.m16507a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupModel = new GroupModel();
                    ((BaseModel) groupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupModel instanceof Postprocessable) {
                        return ((Postprocessable) groupModel).a();
                    }
                    return groupModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m15810a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m15812a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupParser.m16508a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(1);
            }

            public GroupModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m15815a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15816a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m15817b() {
                this.f12734d = super.a(this.f12734d, 0);
                return this.f12734d;
            }

            public static GroupModel m15811a(GroupModel groupModel) {
                if (groupModel == null) {
                    return null;
                }
                if (groupModel instanceof GroupModel) {
                    return groupModel;
                }
                Builder builder = new Builder();
                builder.f12733a = groupModel.m15817b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12733a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GroupModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m15814a() {
                return m15817b();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m15813a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15812a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15817b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 604215985)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12738d;
            @Nullable
            private String f12739e;
            @Nullable
            private ReactionImageFieldsModel f12740f;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f12735a;
                @Nullable
                public String f12736b;
                @Nullable
                public ReactionImageFieldsModel f12737c;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m15818a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m16509a(jsonParser, flatBufferBuilder));
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

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m15819a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m15822a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m16510a(pageModel.w_(), pageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ReactionImageFields m15829d() {
                return m15821j();
            }

            public PageModel() {
                super(3);
            }

            public PageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m15825a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15826a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m15827b() {
                this.f12738d = super.a(this.f12738d, 0);
                return this.f12738d;
            }

            @Nullable
            public final String m15828c() {
                this.f12739e = super.a(this.f12739e, 1);
                return this.f12739e;
            }

            @Nullable
            private ReactionImageFieldsModel m15821j() {
                this.f12740f = (ReactionImageFieldsModel) super.a(this.f12740f, 2, ReactionImageFieldsModel.class);
                return this.f12740f;
            }

            public static PageModel m15820a(PageModel pageModel) {
                if (pageModel == null) {
                    return null;
                }
                if (pageModel instanceof PageModel) {
                    return pageModel;
                }
                Builder builder = new Builder();
                builder.f12735a = pageModel.m15827b();
                builder.f12736b = pageModel.m15828c();
                builder.f12737c = ReactionImageFieldsModel.m14497a(pageModel.m15829d());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12735a);
                int b2 = flatBufferBuilder.b(builder.f12736b);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12737c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m15824a() {
                return m15827b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m15823a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15821j() != null) {
                    ReactionImageFieldsModel reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(m15821j());
                    if (m15821j() != reactionImageFieldsModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12740f = reactionImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15822a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15827b());
                int b2 = flatBufferBuilder.b(m15828c());
                int a = ModelHelper.a(flatBufferBuilder, m15821j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1340646002)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class ProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ReactionProfileFields {
            @Nullable
            private GraphQLObjectType f12759d;
            private boolean f12760e;
            private boolean f12761f;
            private boolean f12762g;
            @Nullable
            private List<String> f12763h;
            @Nullable
            private GraphQLConnectionStyle f12764i;
            @Nullable
            private CoverPhotoModel f12765j;
            private boolean f12766k;
            @Nullable
            private GraphQLEventPrivacyType f12767l;
            @Nullable
            private String f12768m;
            @Nullable
            private String f12769n;
            @Nullable
            private ReactionImageFieldsModel f12770o;
            @Nullable
            private String f12771p;
            @Nullable
            private GraphQLEventGuestStatus f12772q;
            private boolean f12773r;
            @Nullable
            private GraphQLGroupJoinState f12774s;
            @Nullable
            private GraphQLSavedState f12775t;
            @Nullable
            private GraphQLEventWatchStatus f12776u;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f12741a;
                public boolean f12742b;
                public boolean f12743c;
                public boolean f12744d;
                @Nullable
                public ImmutableList<String> f12745e;
                @Nullable
                public GraphQLConnectionStyle f12746f;
                @Nullable
                public CoverPhotoModel f12747g;
                public boolean f12748h;
                @Nullable
                public GraphQLEventPrivacyType f12749i;
                @Nullable
                public String f12750j;
                @Nullable
                public String f12751k;
                @Nullable
                public ReactionImageFieldsModel f12752l;
                @Nullable
                public String f12753m;
                @Nullable
                public GraphQLEventGuestStatus f12754n;
                public boolean f12755o;
                @Nullable
                public GraphQLGroupJoinState f12756p;
                @Nullable
                public GraphQLSavedState f12757q;
                @Nullable
                public GraphQLEventWatchStatus f12758r;

                public final ProfileModel m15830a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f12741a);
                    int c = flatBufferBuilder.c(this.f12745e);
                    int a2 = flatBufferBuilder.a(this.f12746f);
                    int a3 = ModelHelper.a(flatBufferBuilder, this.f12747g);
                    int a4 = flatBufferBuilder.a(this.f12749i);
                    int b = flatBufferBuilder.b(this.f12750j);
                    int b2 = flatBufferBuilder.b(this.f12751k);
                    int a5 = ModelHelper.a(flatBufferBuilder, this.f12752l);
                    int b3 = flatBufferBuilder.b(this.f12753m);
                    int a6 = flatBufferBuilder.a(this.f12754n);
                    int a7 = flatBufferBuilder.a(this.f12756p);
                    int a8 = flatBufferBuilder.a(this.f12757q);
                    int a9 = flatBufferBuilder.a(this.f12758r);
                    flatBufferBuilder.c(18);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f12742b);
                    flatBufferBuilder.a(2, this.f12743c);
                    flatBufferBuilder.a(3, this.f12744d);
                    flatBufferBuilder.b(4, c);
                    flatBufferBuilder.b(5, a2);
                    flatBufferBuilder.b(6, a3);
                    flatBufferBuilder.a(7, this.f12748h);
                    flatBufferBuilder.b(8, a4);
                    flatBufferBuilder.b(9, b);
                    flatBufferBuilder.b(10, b2);
                    flatBufferBuilder.b(11, a5);
                    flatBufferBuilder.b(12, b3);
                    flatBufferBuilder.b(13, a6);
                    flatBufferBuilder.a(14, this.f12755o);
                    flatBufferBuilder.b(15, a7);
                    flatBufferBuilder.b(16, a8);
                    flatBufferBuilder.b(17, a9);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ProfileModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileModel.class, new Deserializer());
                }

                public Object m15831a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileParser.m16511a(jsonParser, flatBufferBuilder));
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

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<ProfileModel> {
                public final void m15832a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileModel profileModel = (ProfileModel) obj;
                    if (profileModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileModel.m15841a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileParser.m16512a(profileModel.w_(), profileModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ CoverPhotoModel mo780g() {
                return m15839u();
            }

            @Nullable
            public final /* synthetic */ ReactionImageFields mo782k() {
                return m15840v();
            }

            public ProfileModel() {
                super(18);
            }

            public ProfileModel(MutableFlatBuffer mutableFlatBuffer) {
                super(18);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m15845a(String str, ConsistencyTuple consistencyTuple) {
                if ("does_viewer_like".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(eK_());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 7;
                } else if ("viewer_guest_status".equals(str)) {
                    consistencyTuple.a = m15858q();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 13;
                } else if ("viewer_has_pending_invite".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m15859r());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 14;
                } else if ("viewer_join_state".equals(str)) {
                    consistencyTuple.a = m15860s();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 15;
                } else if ("viewer_watch_status".equals(str)) {
                    consistencyTuple.a = m15861t();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 17;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m15846a(String str, Object obj, boolean z) {
                if ("does_viewer_like".equals(str)) {
                    m15837a(((Boolean) obj).booleanValue());
                } else if ("viewer_guest_status".equals(str)) {
                    m15834a((GraphQLEventGuestStatus) obj);
                } else if ("viewer_has_pending_invite".equals(str)) {
                    m15838b(((Boolean) obj).booleanValue());
                } else if ("viewer_join_state".equals(str)) {
                    m15836a((GraphQLGroupJoinState) obj);
                } else if ("viewer_watch_status".equals(str)) {
                    m15835a((GraphQLEventWatchStatus) obj);
                }
            }

            @Nullable
            public final GraphQLObjectType mo774b() {
                if (this.b != null && this.f12759d == null) {
                    this.f12759d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12759d;
            }

            public final boolean m15855n() {
                a(0, 1);
                return this.f12760e;
            }

            public final boolean mo775c() {
                a(0, 2);
                return this.f12761f;
            }

            public final boolean mo776d() {
                a(0, 3);
                return this.f12762g;
            }

            @Nonnull
            public final ImmutableList<String> eJ_() {
                this.f12763h = super.a(this.f12763h, 4);
                return (ImmutableList) this.f12763h;
            }

            @Nullable
            public final GraphQLConnectionStyle m15856o() {
                this.f12764i = (GraphQLConnectionStyle) super.b(this.f12764i, 5, GraphQLConnectionStyle.class, GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12764i;
            }

            @Nullable
            private CoverPhotoModel m15839u() {
                this.f12765j = (CoverPhotoModel) super.a(this.f12765j, 6, CoverPhotoModel.class);
                return this.f12765j;
            }

            public final boolean eK_() {
                a(0, 7);
                return this.f12766k;
            }

            private void m15837a(boolean z) {
                this.f12766k = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 7, z);
                }
            }

            @Nullable
            public final GraphQLEventPrivacyType m15857p() {
                this.f12767l = (GraphQLEventPrivacyType) super.b(this.f12767l, 8, GraphQLEventPrivacyType.class, GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12767l;
            }

            @Nullable
            public final String eL_() {
                this.f12768m = super.a(this.f12768m, 9);
                return this.f12768m;
            }

            @Nullable
            public final String mo781j() {
                this.f12769n = super.a(this.f12769n, 10);
                return this.f12769n;
            }

            @Nullable
            private ReactionImageFieldsModel m15840v() {
                this.f12770o = (ReactionImageFieldsModel) super.a(this.f12770o, 11, ReactionImageFieldsModel.class);
                return this.f12770o;
            }

            @Nullable
            public final String mo783l() {
                this.f12771p = super.a(this.f12771p, 12);
                return this.f12771p;
            }

            @Nullable
            public final GraphQLEventGuestStatus m15858q() {
                this.f12772q = (GraphQLEventGuestStatus) super.b(this.f12772q, 13, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12772q;
            }

            private void m15834a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
                this.f12772q = graphQLEventGuestStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 13, graphQLEventGuestStatus != null ? graphQLEventGuestStatus.name() : null);
                }
            }

            public final boolean m15859r() {
                a(1, 6);
                return this.f12773r;
            }

            private void m15838b(boolean z) {
                this.f12773r = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 14, z);
                }
            }

            @Nullable
            public final GraphQLGroupJoinState m15860s() {
                this.f12774s = (GraphQLGroupJoinState) super.b(this.f12774s, 15, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12774s;
            }

            private void m15836a(GraphQLGroupJoinState graphQLGroupJoinState) {
                this.f12774s = graphQLGroupJoinState;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 15, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
                }
            }

            @Nullable
            public final GraphQLSavedState mo784m() {
                this.f12775t = (GraphQLSavedState) super.b(this.f12775t, 16, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12775t;
            }

            @Nullable
            public final GraphQLEventWatchStatus m15861t() {
                this.f12776u = (GraphQLEventWatchStatus) super.b(this.f12776u, 17, GraphQLEventWatchStatus.class, GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12776u;
            }

            private void m15835a(GraphQLEventWatchStatus graphQLEventWatchStatus) {
                this.f12776u = graphQLEventWatchStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 17, graphQLEventWatchStatus != null ? graphQLEventWatchStatus.name() : null);
                }
            }

            public static ProfileModel m15833a(ProfileModel profileModel) {
                if (profileModel == null) {
                    return null;
                }
                if (profileModel instanceof ProfileModel) {
                    return profileModel;
                }
                Builder builder = new Builder();
                builder.f12741a = profileModel.mo774b();
                builder.f12742b = profileModel.m15855n();
                builder.f12743c = profileModel.mo775c();
                builder.f12744d = profileModel.mo776d();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < profileModel.eJ_().size(); i++) {
                    builder2.c(profileModel.eJ_().get(i));
                }
                builder.f12745e = builder2.b();
                builder.f12746f = profileModel.m15856o();
                builder.f12747g = CoverPhotoModel.m14597a(profileModel.mo780g());
                builder.f12748h = profileModel.eK_();
                builder.f12749i = profileModel.m15857p();
                builder.f12750j = profileModel.eL_();
                builder.f12751k = profileModel.mo781j();
                builder.f12752l = ReactionImageFieldsModel.m14497a(profileModel.mo782k());
                builder.f12753m = profileModel.mo783l();
                builder.f12754n = profileModel.m15858q();
                builder.f12755o = profileModel.m15859r();
                builder.f12756p = profileModel.m15860s();
                builder.f12757q = profileModel.mo784m();
                builder.f12758r = profileModel.m15861t();
                return builder.m15830a();
            }

            @Nullable
            public final String m15843a() {
                return eL_();
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m15842a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15839u() != null) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m15839u());
                    if (m15839u() != coverPhotoModel) {
                        graphQLVisitableModel = (ProfileModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12765j = coverPhotoModel;
                    }
                }
                if (m15840v() != null) {
                    ReactionImageFieldsModel reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(m15840v());
                    if (m15840v() != reactionImageFieldsModel) {
                        graphQLVisitableModel = (ProfileModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12770o = reactionImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15841a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, mo774b());
                int c = flatBufferBuilder.c(eJ_());
                int a2 = flatBufferBuilder.a(m15856o());
                int a3 = ModelHelper.a(flatBufferBuilder, m15839u());
                int a4 = flatBufferBuilder.a(m15857p());
                int b = flatBufferBuilder.b(eL_());
                int b2 = flatBufferBuilder.b(mo781j());
                int a5 = ModelHelper.a(flatBufferBuilder, m15840v());
                int b3 = flatBufferBuilder.b(mo783l());
                int a6 = flatBufferBuilder.a(m15858q());
                int a7 = flatBufferBuilder.a(m15860s());
                int a8 = flatBufferBuilder.a(mo784m());
                int a9 = flatBufferBuilder.a(m15861t());
                flatBufferBuilder.c(18);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f12760e);
                flatBufferBuilder.a(2, this.f12761f);
                flatBufferBuilder.a(3, this.f12762g);
                flatBufferBuilder.b(4, c);
                flatBufferBuilder.b(5, a2);
                flatBufferBuilder.b(6, a3);
                flatBufferBuilder.a(7, this.f12766k);
                flatBufferBuilder.b(8, a4);
                flatBufferBuilder.b(9, b);
                flatBufferBuilder.b(10, b2);
                flatBufferBuilder.b(11, a5);
                flatBufferBuilder.b(12, b3);
                flatBufferBuilder.b(13, a6);
                flatBufferBuilder.a(14, this.f12773r);
                flatBufferBuilder.b(15, a7);
                flatBufferBuilder.b(16, a8);
                flatBufferBuilder.b(17, a9);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15844a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12760e = mutableFlatBuffer.a(i, 1);
                this.f12761f = mutableFlatBuffer.a(i, 2);
                this.f12762g = mutableFlatBuffer.a(i, 3);
                this.f12766k = mutableFlatBuffer.a(i, 7);
                this.f12773r = mutableFlatBuffer.a(i, 14);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1185712657)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class RelatedUsersModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12779d;
            @Nullable
            private String f12780e;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f12777a;
                @Nullable
                public String f12778b;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RelatedUsersModel.class, new Deserializer());
                }

                public Object m15862a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RelatedUsersParser.m16516b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object relatedUsersModel = new RelatedUsersModel();
                    ((BaseModel) relatedUsersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (relatedUsersModel instanceof Postprocessable) {
                        return ((Postprocessable) relatedUsersModel).a();
                    }
                    return relatedUsersModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<RelatedUsersModel> {
                public final void m15863a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RelatedUsersModel relatedUsersModel = (RelatedUsersModel) obj;
                    if (relatedUsersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(relatedUsersModel.m15865a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        relatedUsersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RelatedUsersParser.m16514a(relatedUsersModel.w_(), relatedUsersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RelatedUsersModel.class, new Serializer());
                }
            }

            public RelatedUsersModel() {
                super(2);
            }

            public RelatedUsersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m15868a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15869a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m15870b() {
                this.f12779d = super.a(this.f12779d, 0);
                return this.f12779d;
            }

            @Nullable
            public final String m15871c() {
                this.f12780e = super.a(this.f12780e, 1);
                return this.f12780e;
            }

            public static RelatedUsersModel m15864a(RelatedUsersModel relatedUsersModel) {
                if (relatedUsersModel == null) {
                    return null;
                }
                if (relatedUsersModel instanceof RelatedUsersModel) {
                    return relatedUsersModel;
                }
                Builder builder = new Builder();
                builder.f12777a = relatedUsersModel.m15870b();
                builder.f12778b = relatedUsersModel.m15871c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12777a);
                int b2 = flatBufferBuilder.b(builder.f12778b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new RelatedUsersModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m15867a() {
                return m15870b();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m15866a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15865a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15870b());
                int b2 = flatBufferBuilder.b(m15871c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionActionFatFieldsModel> {
            public final void m15872a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionActionFatFieldsModel reactionActionFatFieldsModel = (ReactionActionFatFieldsModel) obj;
                if (reactionActionFatFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionActionFatFieldsModel.m15937a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionActionFatFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionActionFatFieldsParser.m16522a(reactionActionFatFieldsModel.w_(), reactionActionFatFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionActionFatFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 859217127)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class StoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12787d;
            @Nullable
            private FeedbackModel f12788e;
            @Nullable
            private String f12789f;
            @Nullable
            private String f12790g;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f12781a;
                @Nullable
                public FeedbackModel f12782b;
                @Nullable
                public String f12783c;
                @Nullable
                public String f12784d;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StoryModel.class, new Deserializer());
                }

                public Object m15873a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StoryParser.m16519a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 989329089)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: field_icon */
            public final class FeedbackModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private String f12786d;

                /* compiled from: field_icon */
                public final class Builder {
                    @Nullable
                    public String f12785a;
                }

                /* compiled from: field_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                    }

                    public Object m15874a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FeedbackParser.m16517a(jsonParser, flatBufferBuilder));
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

                /* compiled from: field_icon */
                public class Serializer extends JsonSerializer<FeedbackModel> {
                    public final void m15875a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FeedbackModel feedbackModel = (FeedbackModel) obj;
                        if (feedbackModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(feedbackModel.m15877a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FeedbackParser.m16518a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                    }
                }

                public FeedbackModel() {
                    super(1);
                }

                public FeedbackModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m15880a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m15881a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m15879a() {
                    this.f12786d = super.a(this.f12786d, 0);
                    return this.f12786d;
                }

                public static FeedbackModel m15876a(FeedbackModel feedbackModel) {
                    if (feedbackModel == null) {
                        return null;
                    }
                    if (feedbackModel instanceof FeedbackModel) {
                        return feedbackModel;
                    }
                    Builder builder = new Builder();
                    builder.f12785a = feedbackModel.m15879a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f12785a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new FeedbackModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -126857307;
                }

                public final GraphQLVisitableModel m15878a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15877a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15879a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<StoryModel> {
                public final void m15882a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StoryModel storyModel = (StoryModel) obj;
                    if (storyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(storyModel.m15885a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        storyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StoryParser.m16520a(storyModel.w_(), storyModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StoryModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ FeedbackModel m15891c() {
                return m15884j();
            }

            public StoryModel() {
                super(4);
            }

            public StoryModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m15888a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15889a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m15890b() {
                this.f12787d = super.a(this.f12787d, 0);
                return this.f12787d;
            }

            @Nullable
            private FeedbackModel m15884j() {
                this.f12788e = (FeedbackModel) super.a(this.f12788e, 1, FeedbackModel.class);
                return this.f12788e;
            }

            @Nullable
            public final String m15892d() {
                this.f12789f = super.a(this.f12789f, 2);
                return this.f12789f;
            }

            @Nullable
            public final String fE_() {
                this.f12790g = super.a(this.f12790g, 3);
                return this.f12790g;
            }

            public static StoryModel m15883a(StoryModel storyModel) {
                if (storyModel == null) {
                    return null;
                }
                if (storyModel instanceof StoryModel) {
                    return storyModel;
                }
                Builder builder = new Builder();
                builder.f12781a = storyModel.m15890b();
                builder.f12782b = FeedbackModel.m15876a(storyModel.m15891c());
                builder.f12783c = storyModel.m15892d();
                builder.f12784d = storyModel.fE_();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12781a);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12782b);
                int b2 = flatBufferBuilder.b(builder.f12783c);
                int b3 = flatBufferBuilder.b(builder.f12784d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new StoryModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m15887a() {
                return m15892d();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m15886a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15884j() != null) {
                    FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m15884j());
                    if (m15884j() != feedbackModel) {
                        graphQLVisitableModel = (StoryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12788e = feedbackModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15885a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15890b());
                int a = ModelHelper.a(flatBufferBuilder, m15884j());
                int b2 = flatBufferBuilder.b(m15892d());
                int b3 = flatBufferBuilder.b(fE_());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ReactionActionFatFieldsModel() {
            super(50);
        }

        @Nullable
        private GraphQLObjectType m15919a() {
            if (this.b != null && this.f12817d == null) {
                this.f12817d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12817d;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15920j() {
            this.f12818e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12818e, 1, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12818e;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15921k() {
            this.f12819f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12819f, 2, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12819f;
        }

        @Nullable
        private ActionOgObjectModel m15922l() {
            this.f12820g = (ActionOgObjectModel) super.a(this.f12820g, 3, ActionOgObjectModel.class);
            return this.f12820g;
        }

        @Nullable
        private AlbumModel m15923m() {
            this.f12821h = (AlbumModel) super.a(this.f12821h, 4, AlbumModel.class);
            return this.f12821h;
        }

        @Nullable
        private CollectionModel m15924n() {
            this.f12823j = (CollectionModel) super.a(this.f12823j, 6, CollectionModel.class);
            return this.f12823j;
        }

        @Nullable
        private CommentModel m15925o() {
            this.f12824k = (CommentModel) super.a(this.f12824k, 7, CommentModel.class);
            return this.f12824k;
        }

        @Nullable
        private String m15926p() {
            this.f12825l = super.a(this.f12825l, 8);
            return this.f12825l;
        }

        @Nullable
        private ComposerInlineActivityModel m15927q() {
            this.f12826m = (ComposerInlineActivityModel) super.a(this.f12826m, 9, ComposerInlineActivityModel.class);
            return this.f12826m;
        }

        @Nullable
        private GraphQLFundraiserSupportersConnectionType m15928r() {
            this.f12827n = (GraphQLFundraiserSupportersConnectionType) super.b(this.f12827n, 10, GraphQLFundraiserSupportersConnectionType.class, GraphQLFundraiserSupportersConnectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12827n;
        }

        @Nullable
        private String m15929s() {
            this.f12828o = super.a(this.f12828o, 11);
            return this.f12828o;
        }

        @Nullable
        private GraphQLPhotosByCategoryEntryPoint m15930t() {
            this.f12829p = (GraphQLPhotosByCategoryEntryPoint) super.b(this.f12829p, 12, GraphQLPhotosByCategoryEntryPoint.class, GraphQLPhotosByCategoryEntryPoint.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12829p;
        }

        @Nullable
        private EventModel m15931u() {
            this.f12830q = (EventModel) super.a(this.f12830q, 13, EventModel.class);
            return this.f12830q;
        }

        @Nullable
        private EventSpaceModel m15932v() {
            this.f12831r = (EventSpaceModel) super.a(this.f12831r, 14, EventSpaceModel.class);
            return this.f12831r;
        }

        @Nonnull
        private ImmutableList<ReactionWeatherSettingsPlaceItemFragmentModel> m15933w() {
            this.f12832s = super.a(this.f12832s, 15, ReactionWeatherSettingsPlaceItemFragmentModel.class);
            return (ImmutableList) this.f12832s;
        }

        @Nullable
        private FriendModel m15934x() {
            this.f12833t = (FriendModel) super.a(this.f12833t, 16, FriendModel.class);
            return this.f12833t;
        }

        @Nullable
        private String m15935y() {
            this.f12834u = super.a(this.f12834u, 17);
            return this.f12834u;
        }

        @Nullable
        private FundraiserModel m15936z() {
            this.f12835v = (FundraiserModel) super.a(this.f12835v, 18, FundraiserModel.class);
            return this.f12835v;
        }

        @Nullable
        private FundraiserCampaignModel m15893A() {
            this.f12836w = (FundraiserCampaignModel) super.a(this.f12836w, 19, FundraiserCampaignModel.class);
            return this.f12836w;
        }

        @Nullable
        private GroupModel m15894B() {
            this.f12837x = (GroupModel) super.a(this.f12837x, 20, GroupModel.class);
            return this.f12837x;
        }

        @Nullable
        private GraphQLEventWatchStatus m15895C() {
            this.f12838y = (GraphQLEventWatchStatus) super.b(this.f12838y, 21, GraphQLEventWatchStatus.class, GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12838y;
        }

        @Nullable
        private DefaultLocationFieldsModel m15896D() {
            this.f12839z = (DefaultLocationFieldsModel) super.a(this.f12839z, 22, DefaultLocationFieldsModel.class);
            return this.f12839z;
        }

        @Nullable
        private MatchPageModel m15897E() {
            this.f12791A = (MatchPageModel) super.a(this.f12791A, 23, MatchPageModel.class);
            return this.f12791A;
        }

        @Nullable
        private GraphQLNearbyFriendsNuxType m15898F() {
            this.f12792B = (GraphQLNearbyFriendsNuxType) super.b(this.f12792B, 24, GraphQLNearbyFriendsNuxType.class, GraphQLNearbyFriendsNuxType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12792B;
        }

        @Nullable
        private PageModel m15899G() {
            this.f12793C = (PageModel) super.a(this.f12793C, 25, PageModel.class);
            return this.f12793C;
        }

        @Nullable
        private String m15900H() {
            this.f12794D = super.a(this.f12794D, 26);
            return this.f12794D;
        }

        @Nullable
        private GraphQLPagePhotoSourceType m15901I() {
            this.f12795E = (GraphQLPagePhotoSourceType) super.b(this.f12795E, 27, GraphQLPagePhotoSourceType.class, GraphQLPagePhotoSourceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12795E;
        }

        @Nullable
        private String m15902J() {
            this.f12796F = super.a(this.f12796F, 28);
            return this.f12796F;
        }

        @Nullable
        private PlacesQueryLocationPageModel m15903K() {
            this.f12797G = (PlacesQueryLocationPageModel) super.a(this.f12797G, 29, PlacesQueryLocationPageModel.class);
            return this.f12797G;
        }

        @Nullable
        private String m15904L() {
            this.f12798H = super.a(this.f12798H, 30);
            return this.f12798H;
        }

        @Nullable
        private String m15905M() {
            this.f12799I = super.a(this.f12799I, 31);
            return this.f12799I;
        }

        @Nullable
        private ProfileModel m15906N() {
            this.f12800J = (ProfileModel) super.a(this.f12800J, 32, ProfileModel.class);
            return this.f12800J;
        }

        @Nullable
        private String m15907O() {
            this.f12801K = super.a(this.f12801K, 33);
            return this.f12801K;
        }

        @Nullable
        private String m15908P() {
            this.f12802L = super.a(this.f12802L, 34);
            return this.f12802L;
        }

        @Nonnull
        private ImmutableList<RelatedUsersModel> m15909Q() {
            this.f12803M = super.a(this.f12803M, 35, RelatedUsersModel.class);
            return (ImmutableList) this.f12803M;
        }

        @Nullable
        private ReplacementUnitModel m15910R() {
            this.f12804N = (ReplacementUnitModel) super.a(this.f12804N, 36, ReplacementUnitModel.class);
            return this.f12804N;
        }

        @Nullable
        private PageServiceItemModel m15911S() {
            this.f12805O = (PageServiceItemModel) super.a(this.f12805O, 37, PageServiceItemModel.class);
            return this.f12805O;
        }

        @Nullable
        private String m15912T() {
            this.f12806P = super.a(this.f12806P, 38);
            return this.f12806P;
        }

        @Nullable
        private String m15913U() {
            this.f12807Q = super.a(this.f12807Q, 39);
            return this.f12807Q;
        }

        @Nullable
        private String m15914V() {
            this.f12808R = super.a(this.f12808R, 40);
            return this.f12808R;
        }

        @Nullable
        private StoryModel m15915W() {
            this.f12809S = (StoryModel) super.a(this.f12809S, 41, StoryModel.class);
            return this.f12809S;
        }

        @Nullable
        private String m15916X() {
            this.f12811U = super.a(this.f12811U, 43);
            return this.f12811U;
        }

        @Nullable
        private ReactionEventInviteFieldsModel m15917Y() {
            this.f12812V = (ReactionEventInviteFieldsModel) super.a(this.f12812V, 44, ReactionEventInviteFieldsModel.class);
            return this.f12812V;
        }

        @Nullable
        private String m15918Z() {
            this.f12813W = super.a(this.f12813W, 45);
            return this.f12813W;
        }

        @Nullable
        private ThreadKeyModel aa() {
            this.f12814X = (ThreadKeyModel) super.a(this.f12814X, 46, ThreadKeyModel.class);
            return this.f12814X;
        }

        @Nullable
        private String ab() {
            this.f12815Y = super.a(this.f12815Y, 47);
            return this.f12815Y;
        }

        @Nullable
        private String ac() {
            this.f12816Z = super.a(this.f12816Z, 48);
            return this.f12816Z;
        }

        @Nullable
        private VideoChannelModel ad() {
            this.aa = (VideoChannelModel) super.a(this.aa, 49, VideoChannelModel.class);
            return this.aa;
        }

        public final int jK_() {
            return 1194715522;
        }

        public final GraphQLVisitableModel m15938a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15920j() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15920j());
                if (m15920j() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12818e = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15921k() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15921k());
                if (m15921k() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12819f = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15922l() != null) {
                ActionOgObjectModel actionOgObjectModel = (ActionOgObjectModel) graphQLModelMutatingVisitor.b(m15922l());
                if (m15922l() != actionOgObjectModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12820g = actionOgObjectModel;
                }
            }
            if (m15923m() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m15923m());
                if (m15923m() != albumModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12821h = albumModel;
                }
            }
            if (m15924n() != null) {
                CollectionModel collectionModel = (CollectionModel) graphQLModelMutatingVisitor.b(m15924n());
                if (m15924n() != collectionModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12823j = collectionModel;
                }
            }
            if (m15925o() != null) {
                CommentModel commentModel = (CommentModel) graphQLModelMutatingVisitor.b(m15925o());
                if (m15925o() != commentModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12824k = commentModel;
                }
            }
            if (m15927q() != null) {
                ComposerInlineActivityModel composerInlineActivityModel = (ComposerInlineActivityModel) graphQLModelMutatingVisitor.b(m15927q());
                if (m15927q() != composerInlineActivityModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12826m = composerInlineActivityModel;
                }
            }
            if (m15931u() != null) {
                EventModel eventModel = (EventModel) graphQLModelMutatingVisitor.b(m15931u());
                if (m15931u() != eventModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12830q = eventModel;
                }
            }
            if (m15932v() != null) {
                EventSpaceModel eventSpaceModel = (EventSpaceModel) graphQLModelMutatingVisitor.b(m15932v());
                if (m15932v() != eventSpaceModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12831r = eventSpaceModel;
                }
            }
            if (m15933w() != null) {
                a = ModelHelper.a(m15933w(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ReactionActionFatFieldsModel reactionActionFatFieldsModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    reactionActionFatFieldsModel.f12832s = a.b();
                    graphQLVisitableModel = reactionActionFatFieldsModel;
                }
            }
            if (m15934x() != null) {
                FriendModel friendModel = (FriendModel) graphQLModelMutatingVisitor.b(m15934x());
                if (m15934x() != friendModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12833t = friendModel;
                }
            }
            if (m15936z() != null) {
                FundraiserModel fundraiserModel = (FundraiserModel) graphQLModelMutatingVisitor.b(m15936z());
                if (m15936z() != fundraiserModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12835v = fundraiserModel;
                }
            }
            if (m15893A() != null) {
                FundraiserCampaignModel fundraiserCampaignModel = (FundraiserCampaignModel) graphQLModelMutatingVisitor.b(m15893A());
                if (m15893A() != fundraiserCampaignModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12836w = fundraiserCampaignModel;
                }
            }
            if (m15894B() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m15894B());
                if (m15894B() != groupModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12837x = groupModel;
                }
            }
            if (m15896D() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m15896D());
                if (m15896D() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12839z = defaultLocationFieldsModel;
                }
            }
            if (m15897E() != null) {
                MatchPageModel matchPageModel = (MatchPageModel) graphQLModelMutatingVisitor.b(m15897E());
                if (m15897E() != matchPageModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12791A = matchPageModel;
                }
            }
            if (m15899G() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m15899G());
                if (m15899G() != pageModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12793C = pageModel;
                }
            }
            if (m15903K() != null) {
                PlacesQueryLocationPageModel placesQueryLocationPageModel = (PlacesQueryLocationPageModel) graphQLModelMutatingVisitor.b(m15903K());
                if (m15903K() != placesQueryLocationPageModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12797G = placesQueryLocationPageModel;
                }
            }
            if (m15906N() != null) {
                ProfileModel profileModel = (ProfileModel) graphQLModelMutatingVisitor.b(m15906N());
                if (m15906N() != profileModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12800J = profileModel;
                }
            }
            if (m15909Q() != null) {
                a = ModelHelper.a(m15909Q(), graphQLModelMutatingVisitor);
                if (a != null) {
                    reactionActionFatFieldsModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    reactionActionFatFieldsModel.f12803M = a.b();
                    graphQLVisitableModel = reactionActionFatFieldsModel;
                }
            }
            if (m15910R() != null) {
                ReplacementUnitModel replacementUnitModel = (ReplacementUnitModel) graphQLModelMutatingVisitor.b(m15910R());
                if (m15910R() != replacementUnitModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12804N = replacementUnitModel;
                }
            }
            if (m15911S() != null) {
                PageServiceItemModel pageServiceItemModel = (PageServiceItemModel) graphQLModelMutatingVisitor.b(m15911S());
                if (m15911S() != pageServiceItemModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12805O = pageServiceItemModel;
                }
            }
            if (m15915W() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m15915W());
                if (m15915W() != storyModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12809S = storyModel;
                }
            }
            if (m15917Y() != null) {
                ReactionEventInviteFieldsModel reactionEventInviteFieldsModel = (ReactionEventInviteFieldsModel) graphQLModelMutatingVisitor.b(m15917Y());
                if (m15917Y() != reactionEventInviteFieldsModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12812V = reactionEventInviteFieldsModel;
                }
            }
            if (aa() != null) {
                ThreadKeyModel threadKeyModel = (ThreadKeyModel) graphQLModelMutatingVisitor.b(aa());
                if (aa() != threadKeyModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12814X = threadKeyModel;
                }
            }
            if (ad() != null) {
                VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(ad());
                if (ad() != videoChannelModel) {
                    graphQLVisitableModel = (ReactionActionFatFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aa = videoChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15937a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15919a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15920j());
            int a3 = ModelHelper.a(flatBufferBuilder, m15921k());
            int a4 = ModelHelper.a(flatBufferBuilder, m15922l());
            int a5 = ModelHelper.a(flatBufferBuilder, m15923m());
            int a6 = ModelHelper.a(flatBufferBuilder, m15924n());
            int a7 = ModelHelper.a(flatBufferBuilder, m15925o());
            int b = flatBufferBuilder.b(m15926p());
            int a8 = ModelHelper.a(flatBufferBuilder, m15927q());
            int a9 = flatBufferBuilder.a(m15928r());
            int b2 = flatBufferBuilder.b(m15929s());
            int a10 = flatBufferBuilder.a(m15930t());
            int a11 = ModelHelper.a(flatBufferBuilder, m15931u());
            int a12 = ModelHelper.a(flatBufferBuilder, m15932v());
            int a13 = ModelHelper.a(flatBufferBuilder, m15933w());
            int a14 = ModelHelper.a(flatBufferBuilder, m15934x());
            int b3 = flatBufferBuilder.b(m15935y());
            int a15 = ModelHelper.a(flatBufferBuilder, m15936z());
            int a16 = ModelHelper.a(flatBufferBuilder, m15893A());
            int a17 = ModelHelper.a(flatBufferBuilder, m15894B());
            int a18 = flatBufferBuilder.a(m15895C());
            int a19 = ModelHelper.a(flatBufferBuilder, m15896D());
            int a20 = ModelHelper.a(flatBufferBuilder, m15897E());
            int a21 = flatBufferBuilder.a(m15898F());
            int a22 = ModelHelper.a(flatBufferBuilder, m15899G());
            int b4 = flatBufferBuilder.b(m15900H());
            int a23 = flatBufferBuilder.a(m15901I());
            int b5 = flatBufferBuilder.b(m15902J());
            int a24 = ModelHelper.a(flatBufferBuilder, m15903K());
            int b6 = flatBufferBuilder.b(m15904L());
            int b7 = flatBufferBuilder.b(m15905M());
            int a25 = ModelHelper.a(flatBufferBuilder, m15906N());
            int b8 = flatBufferBuilder.b(m15907O());
            int b9 = flatBufferBuilder.b(m15908P());
            int a26 = ModelHelper.a(flatBufferBuilder, m15909Q());
            int a27 = ModelHelper.a(flatBufferBuilder, m15910R());
            int a28 = ModelHelper.a(flatBufferBuilder, m15911S());
            int b10 = flatBufferBuilder.b(m15912T());
            int b11 = flatBufferBuilder.b(m15913U());
            int b12 = flatBufferBuilder.b(m15914V());
            int a29 = ModelHelper.a(flatBufferBuilder, m15915W());
            int b13 = flatBufferBuilder.b(m15916X());
            int a30 = ModelHelper.a(flatBufferBuilder, m15917Y());
            int b14 = flatBufferBuilder.b(m15918Z());
            int a31 = ModelHelper.a(flatBufferBuilder, aa());
            int b15 = flatBufferBuilder.b(ab());
            int b16 = flatBufferBuilder.b(ac());
            int a32 = ModelHelper.a(flatBufferBuilder, ad());
            flatBufferBuilder.c(50);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.a(5, this.f12822i);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, b);
            flatBufferBuilder.b(9, a8);
            flatBufferBuilder.b(10, a9);
            flatBufferBuilder.b(11, b2);
            flatBufferBuilder.b(12, a10);
            flatBufferBuilder.b(13, a11);
            flatBufferBuilder.b(14, a12);
            flatBufferBuilder.b(15, a13);
            flatBufferBuilder.b(16, a14);
            flatBufferBuilder.b(17, b3);
            flatBufferBuilder.b(18, a15);
            flatBufferBuilder.b(19, a16);
            flatBufferBuilder.b(20, a17);
            flatBufferBuilder.b(21, a18);
            flatBufferBuilder.b(22, a19);
            flatBufferBuilder.b(23, a20);
            flatBufferBuilder.b(24, a21);
            flatBufferBuilder.b(25, a22);
            flatBufferBuilder.b(26, b4);
            flatBufferBuilder.b(27, a23);
            flatBufferBuilder.b(28, b5);
            flatBufferBuilder.b(29, a24);
            flatBufferBuilder.b(30, b6);
            flatBufferBuilder.b(31, b7);
            flatBufferBuilder.b(32, a25);
            flatBufferBuilder.b(33, b8);
            flatBufferBuilder.b(34, b9);
            flatBufferBuilder.b(35, a26);
            flatBufferBuilder.b(36, a27);
            flatBufferBuilder.b(37, a28);
            flatBufferBuilder.b(38, b10);
            flatBufferBuilder.b(39, b11);
            flatBufferBuilder.b(40, b12);
            flatBufferBuilder.b(41, a29);
            flatBufferBuilder.a(42, this.f12810T);
            flatBufferBuilder.b(43, b13);
            flatBufferBuilder.b(44, a30);
            flatBufferBuilder.b(45, b14);
            flatBufferBuilder.b(46, a31);
            flatBufferBuilder.b(47, b15);
            flatBufferBuilder.b(48, b16);
            flatBufferBuilder.b(49, a32);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15939a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12822i = mutableFlatBuffer.a(i, 5);
            this.f12810T = mutableFlatBuffer.a(i, 42);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -929894406)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionAttachmentActionFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionCommerceActionFields, ReactionStoriesActionFields {
        @Nullable
        private GraphQLObjectType f12846d;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12847e;
        @Nullable
        private PageModel f12848f;
        @Nullable
        private List<StoriesModel> f12849g;
        @Nullable
        private List<GraphQLReactionStoryAttachmentActionStyle> f12850h;
        @Nullable
        private String f12851i;

        /* compiled from: field_icon */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f12840a;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12841b;
            @Nullable
            public PageModel f12842c;
            @Nullable
            public ImmutableList<StoriesModel> f12843d;
            @Nullable
            public ImmutableList<GraphQLReactionStoryAttachmentActionStyle> f12844e;
            @Nullable
            public String f12845f;

            public final ReactionAttachmentActionFragmentModel m15940a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f12840a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f12841b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f12842c);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f12843d);
                int d = flatBufferBuilder.d(this.f12844e);
                int b = flatBufferBuilder.b(this.f12845f);
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, d);
                flatBufferBuilder.b(5, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReactionAttachmentActionFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionAttachmentActionFragmentModel.class, new Deserializer());
            }

            public Object m15941a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionAttachmentActionFragmentParser.m16524b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionAttachmentActionFragmentModel = new ReactionAttachmentActionFragmentModel();
                ((BaseModel) reactionAttachmentActionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionAttachmentActionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionAttachmentActionFragmentModel).a();
                }
                return reactionAttachmentActionFragmentModel;
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionAttachmentActionFragmentModel> {
            public final void m15942a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionAttachmentActionFragmentModel reactionAttachmentActionFragmentModel = (ReactionAttachmentActionFragmentModel) obj;
                if (reactionAttachmentActionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionAttachmentActionFragmentModel.m15946a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionAttachmentActionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionAttachmentActionFragmentParser.m16525b(reactionAttachmentActionFragmentModel.w_(), reactionAttachmentActionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionAttachmentActionFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m15949b() {
            return m15944j();
        }

        @Nullable
        public final /* synthetic */ PageModel m15950c() {
            return m15945k();
        }

        public ReactionAttachmentActionFragmentModel() {
            super(6);
        }

        public ReactionAttachmentActionFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(6);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType m15947a() {
            if (this.b != null && this.f12846d == null) {
                this.f12846d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12846d;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15944j() {
            this.f12847e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12847e, 1, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12847e;
        }

        @Nullable
        private PageModel m15945k() {
            this.f12848f = (PageModel) super.a(this.f12848f, 2, PageModel.class);
            return this.f12848f;
        }

        @Nonnull
        public final ImmutableList<StoriesModel> m15951d() {
            this.f12849g = super.a(this.f12849g, 3, StoriesModel.class);
            return (ImmutableList) this.f12849g;
        }

        @Nonnull
        public final ImmutableList<GraphQLReactionStoryAttachmentActionStyle> fF_() {
            this.f12850h = super.c(this.f12850h, 4, GraphQLReactionStoryAttachmentActionStyle.class);
            return (ImmutableList) this.f12850h;
        }

        @Nullable
        public final String m15952g() {
            this.f12851i = super.a(this.f12851i, 5);
            return this.f12851i;
        }

        public static ReactionAttachmentActionFragmentModel m15943a(ReactionAttachmentActionFragmentModel reactionAttachmentActionFragmentModel) {
            int i = 0;
            if (reactionAttachmentActionFragmentModel == null) {
                return null;
            }
            if (reactionAttachmentActionFragmentModel instanceof ReactionAttachmentActionFragmentModel) {
                return reactionAttachmentActionFragmentModel;
            }
            Builder builder = new Builder();
            builder.f12840a = reactionAttachmentActionFragmentModel.m15947a();
            builder.f12841b = DefaultTextWithEntitiesFieldsModel.a(reactionAttachmentActionFragmentModel.m15949b());
            builder.f12842c = PageModel.m15956a(reactionAttachmentActionFragmentModel.m15950c());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i2 = 0; i2 < reactionAttachmentActionFragmentModel.m15951d().size(); i2++) {
                builder2.c(StoriesModel.m16289a((StoriesModel) reactionAttachmentActionFragmentModel.m15951d().get(i2)));
            }
            builder.f12843d = builder2.b();
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            while (i < reactionAttachmentActionFragmentModel.fF_().size()) {
                builder3.c(reactionAttachmentActionFragmentModel.fF_().get(i));
                i++;
            }
            builder.f12844e = builder3.b();
            builder.f12845f = reactionAttachmentActionFragmentModel.m15952g();
            return builder.m15940a();
        }

        public final int jK_() {
            return -2021598843;
        }

        public final GraphQLVisitableModel m15948a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15944j() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15944j());
                if (m15944j() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionAttachmentActionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12847e = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15945k() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m15945k());
                if (m15945k() != pageModel) {
                    graphQLVisitableModel = (ReactionAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12848f = pageModel;
                }
            }
            if (m15951d() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m15951d(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ReactionAttachmentActionFragmentModel reactionAttachmentActionFragmentModel = (ReactionAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    reactionAttachmentActionFragmentModel.f12849g = a.b();
                    graphQLVisitableModel = reactionAttachmentActionFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15946a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15947a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15944j());
            int a3 = ModelHelper.a(flatBufferBuilder, m15945k());
            int a4 = ModelHelper.a(flatBufferBuilder, m15951d());
            int d = flatBufferBuilder.d(fF_());
            int b = flatBufferBuilder.b(m15952g());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, d);
            flatBufferBuilder.b(5, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1827745509)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionCommerceActionFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionCommerceActionFields {
        @Nullable
        private PageModel f12854d;

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionCommerceActionFieldsModel.class, new Deserializer());
            }

            public Object m15953a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionCommerceActionFieldsParser.m16528a(jsonParser);
                Object reactionCommerceActionFieldsModel = new ReactionCommerceActionFieldsModel();
                ((BaseModel) reactionCommerceActionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionCommerceActionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionCommerceActionFieldsModel).a();
                }
                return reactionCommerceActionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12853d;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f12852a;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m15954a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionCommerceActionFieldsParser.PageParser.m16526a(jsonParser, flatBufferBuilder));
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

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m15955a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m15957a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionCommerceActionFieldsParser.PageParser.m16527a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(1);
            }

            public PageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m15960a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15961a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m15962b() {
                this.f12853d = super.a(this.f12853d, 0);
                return this.f12853d;
            }

            public static PageModel m15956a(PageModel pageModel) {
                if (pageModel == null) {
                    return null;
                }
                if (pageModel instanceof PageModel) {
                    return pageModel;
                }
                Builder builder = new Builder();
                builder.f12852a = pageModel.m15962b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12852a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m15959a() {
                return m15962b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m15958a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15957a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15962b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionCommerceActionFieldsModel> {
            public final void m15963a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionCommerceActionFieldsModel reactionCommerceActionFieldsModel = (ReactionCommerceActionFieldsModel) obj;
                if (reactionCommerceActionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionCommerceActionFieldsModel.m15965a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionCommerceActionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionCommerceActionFieldsModel.w_();
                int u_ = reactionCommerceActionFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page");
                    ReactionCommerceActionFieldsParser.PageParser.m16527a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionCommerceActionFieldsModel.class, new Serializer());
            }
        }

        public ReactionCommerceActionFieldsModel() {
            super(1);
        }

        @Nullable
        private PageModel m15964a() {
            this.f12854d = (PageModel) super.a(this.f12854d, 0, PageModel.class);
            return this.f12854d;
        }

        public final int jK_() {
            return 265734237;
        }

        public final GraphQLVisitableModel m15966a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15964a() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m15964a());
                if (m15964a() != pageModel) {
                    graphQLVisitableModel = (ReactionCommerceActionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12854d = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15965a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15964a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1016828739)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionComposerActionFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionComposerActionFields {
        @Nullable
        private ComposerInlineActivityModel f12881d;
        @Nullable
        private EventSpaceModel f12882e;
        @Nullable
        private String f12883f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1956556420)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class ComposerInlineActivityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f12871d;
            @Nullable
            private ObjectModel f12872e;
            @Nullable
            private MinutiaeTaggableActivityModel f12873f;
            @Nullable
            private TaggableActivityIconModel f12874g;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f12855a;
                @Nullable
                public ObjectModel f12856b;
                @Nullable
                public MinutiaeTaggableActivityModel f12857c;
                @Nullable
                public TaggableActivityIconModel f12858d;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ComposerInlineActivityModel.class, new Deserializer());
                }

                public Object m15967a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ComposerInlineActivityParser.m16535a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object composerInlineActivityModel = new ComposerInlineActivityModel();
                    ((BaseModel) composerInlineActivityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (composerInlineActivityModel instanceof Postprocessable) {
                        return ((Postprocessable) composerInlineActivityModel).a();
                    }
                    return composerInlineActivityModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1821837936)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: field_icon */
            public final class ObjectModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f12863d;
                @Nullable
                private String f12864e;
                @Nullable
                private String f12865f;
                @Nullable
                private String f12866g;

                /* compiled from: field_icon */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f12859a;
                    @Nullable
                    public String f12860b;
                    @Nullable
                    public String f12861c;
                    @Nullable
                    public String f12862d;
                }

                /* compiled from: field_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ObjectModel.class, new Deserializer());
                    }

                    public Object m15968a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ObjectParser.m16529a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object objectModel = new ObjectModel();
                        ((BaseModel) objectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (objectModel instanceof Postprocessable) {
                            return ((Postprocessable) objectModel).a();
                        }
                        return objectModel;
                    }
                }

                /* compiled from: field_icon */
                public class Serializer extends JsonSerializer<ObjectModel> {
                    public final void m15969a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ObjectModel objectModel = (ObjectModel) obj;
                        if (objectModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(objectModel.m15971a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            objectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ObjectParser.m16530a(objectModel.w_(), objectModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ObjectModel.class, new Serializer());
                    }
                }

                public ObjectModel() {
                    super(4);
                }

                public ObjectModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(4);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m15974a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m15975a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final GraphQLObjectType m15976b() {
                    if (this.b != null && this.f12863d == null) {
                        this.f12863d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f12863d;
                }

                @Nullable
                public final String m15977c() {
                    this.f12864e = super.a(this.f12864e, 1);
                    return this.f12864e;
                }

                @Nullable
                public final String m15978d() {
                    this.f12865f = super.a(this.f12865f, 2);
                    return this.f12865f;
                }

                @Nullable
                public final String fH_() {
                    this.f12866g = super.a(this.f12866g, 3);
                    return this.f12866g;
                }

                public static ObjectModel m15970a(ObjectModel objectModel) {
                    if (objectModel == null) {
                        return null;
                    }
                    if (objectModel instanceof ObjectModel) {
                        return objectModel;
                    }
                    Builder builder = new Builder();
                    builder.f12859a = objectModel.m15976b();
                    builder.f12860b = objectModel.m15977c();
                    builder.f12861c = objectModel.m15978d();
                    builder.f12862d = objectModel.fH_();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f12859a);
                    int b = flatBufferBuilder.b(builder.f12860b);
                    int b2 = flatBufferBuilder.b(builder.f12861c);
                    int b3 = flatBufferBuilder.b(builder.f12862d);
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, b3);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ObjectModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                @Nullable
                public final String m15973a() {
                    return m15977c();
                }

                public final int jK_() {
                    return 2433570;
                }

                public final GraphQLVisitableModel m15972a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15971a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15976b());
                    int b = flatBufferBuilder.b(m15977c());
                    int b2 = flatBufferBuilder.b(m15978d());
                    int b3 = flatBufferBuilder.b(fH_());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<ComposerInlineActivityModel> {
                public final void m15979a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ComposerInlineActivityModel composerInlineActivityModel = (ComposerInlineActivityModel) obj;
                    if (composerInlineActivityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(composerInlineActivityModel.m15997a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        composerInlineActivityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ComposerInlineActivityParser.m16536a(composerInlineActivityModel.w_(), composerInlineActivityModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ComposerInlineActivityModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -531557957)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: field_icon */
            public final class TaggableActivityIconModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ImageModel f12870d;

                /* compiled from: field_icon */
                public final class Builder {
                    @Nullable
                    public ImageModel f12867a;
                }

                /* compiled from: field_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TaggableActivityIconModel.class, new Deserializer());
                    }

                    public Object m15980a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TaggableActivityIconParser.m16533a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object taggableActivityIconModel = new TaggableActivityIconModel();
                        ((BaseModel) taggableActivityIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (taggableActivityIconModel instanceof Postprocessable) {
                            return ((Postprocessable) taggableActivityIconModel).a();
                        }
                        return taggableActivityIconModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: field_icon */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f12869d;

                    /* compiled from: field_icon */
                    public final class Builder {
                        @Nullable
                        public String f12868a;
                    }

                    /* compiled from: field_icon */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m15981a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ImageParser.m16531a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object imageModel = new ImageModel();
                            ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (imageModel instanceof Postprocessable) {
                                return ((Postprocessable) imageModel).a();
                            }
                            return imageModel;
                        }
                    }

                    /* compiled from: field_icon */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m15982a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m15984a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ImageParser.m16532a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(1);
                    }

                    public ImageModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final String m15986a() {
                        this.f12869d = super.a(this.f12869d, 0);
                        return this.f12869d;
                    }

                    public static ImageModel m15983a(ImageModel imageModel) {
                        if (imageModel == null) {
                            return null;
                        }
                        if (imageModel instanceof ImageModel) {
                            return imageModel;
                        }
                        Builder builder = new Builder();
                        builder.f12868a = imageModel.m15986a();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f12868a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new ImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m15985a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m15984a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m15986a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: field_icon */
                public class Serializer extends JsonSerializer<TaggableActivityIconModel> {
                    public final void m15987a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TaggableActivityIconModel taggableActivityIconModel = (TaggableActivityIconModel) obj;
                        if (taggableActivityIconModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(taggableActivityIconModel.m15990a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            taggableActivityIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TaggableActivityIconParser.m16534a(taggableActivityIconModel.w_(), taggableActivityIconModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(TaggableActivityIconModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ImageModel m15992a() {
                    return m15989j();
                }

                public TaggableActivityIconModel() {
                    super(1);
                }

                public TaggableActivityIconModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private ImageModel m15989j() {
                    this.f12870d = (ImageModel) super.a(this.f12870d, 0, ImageModel.class);
                    return this.f12870d;
                }

                public static TaggableActivityIconModel m15988a(TaggableActivityIconModel taggableActivityIconModel) {
                    if (taggableActivityIconModel == null) {
                        return null;
                    }
                    if (taggableActivityIconModel instanceof TaggableActivityIconModel) {
                        return taggableActivityIconModel;
                    }
                    Builder builder = new Builder();
                    builder.f12867a = ImageModel.m15983a(taggableActivityIconModel.m15992a());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f12867a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new TaggableActivityIconModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 638969039;
                }

                public final GraphQLVisitableModel m15991a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15989j() != null) {
                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m15989j());
                        if (m15989j() != imageModel) {
                            graphQLVisitableModel = (TaggableActivityIconModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12870d = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15990a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15989j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ ObjectModel m16001c() {
                return m15994j();
            }

            @Nullable
            public final /* synthetic */ MinutiaeTaggableActivity m16002d() {
                return m15995k();
            }

            @Nullable
            public final /* synthetic */ TaggableActivityIconModel fG_() {
                return m15996l();
            }

            public ComposerInlineActivityModel() {
                super(4);
            }

            public ComposerInlineActivityModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m16000b() {
                this.f12871d = super.a(this.f12871d, 0);
                return this.f12871d;
            }

            @Nullable
            private ObjectModel m15994j() {
                this.f12872e = (ObjectModel) super.a(this.f12872e, 1, ObjectModel.class);
                return this.f12872e;
            }

            @Nullable
            private MinutiaeTaggableActivityModel m15995k() {
                this.f12873f = (MinutiaeTaggableActivityModel) super.a(this.f12873f, 2, MinutiaeTaggableActivityModel.class);
                return this.f12873f;
            }

            @Nullable
            private TaggableActivityIconModel m15996l() {
                this.f12874g = (TaggableActivityIconModel) super.a(this.f12874g, 3, TaggableActivityIconModel.class);
                return this.f12874g;
            }

            public static ComposerInlineActivityModel m15993a(ComposerInlineActivityModel composerInlineActivityModel) {
                if (composerInlineActivityModel == null) {
                    return null;
                }
                if (composerInlineActivityModel instanceof ComposerInlineActivityModel) {
                    return composerInlineActivityModel;
                }
                Builder builder = new Builder();
                builder.f12855a = composerInlineActivityModel.m16000b();
                builder.f12856b = ObjectModel.m15970a(composerInlineActivityModel.m16001c());
                builder.f12857c = MinutiaeTaggableActivityModel.a(composerInlineActivityModel.m16002d());
                builder.f12858d = TaggableActivityIconModel.m15988a(composerInlineActivityModel.fG_());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12855a);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12856b);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f12857c);
                int a3 = ModelHelper.a(flatBufferBuilder, builder.f12858d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ComposerInlineActivityModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m15999a() {
                return m16000b();
            }

            public final int jK_() {
                return 1291787496;
            }

            public final GraphQLVisitableModel m15998a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15994j() != null) {
                    ObjectModel objectModel = (ObjectModel) graphQLModelMutatingVisitor.b(m15994j());
                    if (m15994j() != objectModel) {
                        graphQLVisitableModel = (ComposerInlineActivityModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12872e = objectModel;
                    }
                }
                if (m15995k() != null) {
                    MinutiaeTaggableActivityModel minutiaeTaggableActivityModel = (MinutiaeTaggableActivityModel) graphQLModelMutatingVisitor.b(m15995k());
                    if (m15995k() != minutiaeTaggableActivityModel) {
                        graphQLVisitableModel = (ComposerInlineActivityModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12873f = minutiaeTaggableActivityModel;
                    }
                }
                if (m15996l() != null) {
                    TaggableActivityIconModel taggableActivityIconModel = (TaggableActivityIconModel) graphQLModelMutatingVisitor.b(m15996l());
                    if (m15996l() != taggableActivityIconModel) {
                        graphQLVisitableModel = (ComposerInlineActivityModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12874g = taggableActivityIconModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15997a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16000b());
                int a = ModelHelper.a(flatBufferBuilder, m15994j());
                int a2 = ModelHelper.a(flatBufferBuilder, m15995k());
                int a3 = ModelHelper.a(flatBufferBuilder, m15996l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionComposerActionFieldsModel.class, new Deserializer());
            }

            public Object m16003a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionComposerActionFieldsParser.m16539a(jsonParser);
                Object reactionComposerActionFieldsModel = new ReactionComposerActionFieldsModel();
                ((BaseModel) reactionComposerActionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionComposerActionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionComposerActionFieldsModel).a();
                }
                return reactionComposerActionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1274591050)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class EventSpaceModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12878d;
            @Nullable
            private String f12879e;
            @Nullable
            private ComposerTargetDataPrivacyScopeFieldsModel f12880f;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f12875a;
                @Nullable
                public String f12876b;
                @Nullable
                public ComposerTargetDataPrivacyScopeFieldsModel f12877c;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventSpaceModel.class, new Deserializer());
                }

                public Object m16004a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventSpaceParser.m16537a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventSpaceModel = new EventSpaceModel();
                    ((BaseModel) eventSpaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventSpaceModel instanceof Postprocessable) {
                        return ((Postprocessable) eventSpaceModel).a();
                    }
                    return eventSpaceModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<EventSpaceModel> {
                public final void m16005a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventSpaceModel eventSpaceModel = (EventSpaceModel) obj;
                    if (eventSpaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventSpaceModel.m16009a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventSpaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventSpaceParser.m16538a(eventSpaceModel.w_(), eventSpaceModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EventSpaceModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ComposerTargetDataPrivacyScopeFields m16016d() {
                return m16008j();
            }

            public EventSpaceModel() {
                super(3);
            }

            public EventSpaceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m16012a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = m16015c();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m16013a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m16007a((String) obj);
                }
            }

            @Nullable
            public final String m16014b() {
                this.f12878d = super.a(this.f12878d, 0);
                return this.f12878d;
            }

            @Nullable
            public final String m16015c() {
                this.f12879e = super.a(this.f12879e, 1);
                return this.f12879e;
            }

            private void m16007a(@Nullable String str) {
                this.f12879e = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, str);
                }
            }

            @Nullable
            private ComposerTargetDataPrivacyScopeFieldsModel m16008j() {
                this.f12880f = (ComposerTargetDataPrivacyScopeFieldsModel) super.a(this.f12880f, 2, ComposerTargetDataPrivacyScopeFieldsModel.class);
                return this.f12880f;
            }

            public static EventSpaceModel m16006a(EventSpaceModel eventSpaceModel) {
                if (eventSpaceModel == null) {
                    return null;
                }
                if (eventSpaceModel instanceof EventSpaceModel) {
                    return eventSpaceModel;
                }
                Builder builder = new Builder();
                builder.f12875a = eventSpaceModel.m16014b();
                builder.f12876b = eventSpaceModel.m16015c();
                builder.f12877c = ComposerTargetDataPrivacyScopeFieldsModel.a(eventSpaceModel.m16016d());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12875a);
                int b2 = flatBufferBuilder.b(builder.f12876b);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12877c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new EventSpaceModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16011a() {
                return m16014b();
            }

            public final int jK_() {
                return 67338874;
            }

            public final GraphQLVisitableModel m16010a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16008j() != null) {
                    ComposerTargetDataPrivacyScopeFieldsModel composerTargetDataPrivacyScopeFieldsModel = (ComposerTargetDataPrivacyScopeFieldsModel) graphQLModelMutatingVisitor.b(m16008j());
                    if (m16008j() != composerTargetDataPrivacyScopeFieldsModel) {
                        graphQLVisitableModel = (EventSpaceModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12880f = composerTargetDataPrivacyScopeFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16009a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16014b());
                int b2 = flatBufferBuilder.b(m16015c());
                int a = ModelHelper.a(flatBufferBuilder, m16008j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionComposerActionFieldsModel> {
            public final void m16017a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionComposerActionFieldsModel reactionComposerActionFieldsModel = (ReactionComposerActionFieldsModel) obj;
                if (reactionComposerActionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionComposerActionFieldsModel.m16021a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionComposerActionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionComposerActionFieldsModel.w_();
                int u_ = reactionComposerActionFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("composer_inline_activity");
                    ComposerInlineActivityParser.m16536a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("event_space");
                    EventSpaceParser.m16538a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("source_text");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionComposerActionFieldsModel.class, new Serializer());
            }
        }

        public ReactionComposerActionFieldsModel() {
            super(3);
        }

        @Nullable
        private ComposerInlineActivityModel m16018a() {
            this.f12881d = (ComposerInlineActivityModel) super.a(this.f12881d, 0, ComposerInlineActivityModel.class);
            return this.f12881d;
        }

        @Nullable
        private EventSpaceModel m16019j() {
            this.f12882e = (EventSpaceModel) super.a(this.f12882e, 1, EventSpaceModel.class);
            return this.f12882e;
        }

        @Nullable
        private String m16020k() {
            this.f12883f = super.a(this.f12883f, 2);
            return this.f12883f;
        }

        public final int jK_() {
            return 1724295711;
        }

        public final GraphQLVisitableModel m16022a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16018a() != null) {
                ComposerInlineActivityModel composerInlineActivityModel = (ComposerInlineActivityModel) graphQLModelMutatingVisitor.b(m16018a());
                if (m16018a() != composerInlineActivityModel) {
                    graphQLVisitableModel = (ReactionComposerActionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12881d = composerInlineActivityModel;
                }
            }
            if (m16019j() != null) {
                EventSpaceModel eventSpaceModel = (EventSpaceModel) graphQLModelMutatingVisitor.b(m16019j());
                if (m16019j() != eventSpaceModel) {
                    graphQLVisitableModel = (ReactionComposerActionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12882e = eventSpaceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16021a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16018a());
            int a2 = ModelHelper.a(flatBufferBuilder, m16019j());
            int b = flatBufferBuilder.b(m16020k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1224010789)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionEventInviteFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLEventPrivacyType f12892d;
        @Nullable
        private EventViewerCapabilityModel f12893e;
        @Nullable
        private String f12894f;
        @Nullable
        private ParentGroupModel f12895g;

        /* compiled from: field_icon */
        public final class Builder {
            @Nullable
            public GraphQLEventPrivacyType f12884a;
            @Nullable
            public EventViewerCapabilityModel f12885b;
            @Nullable
            public String f12886c;
            @Nullable
            public ParentGroupModel f12887d;
        }

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionEventInviteFieldsModel.class, new Deserializer());
            }

            public Object m16023a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionEventInviteFieldsParser.m16544a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionEventInviteFieldsModel = new ReactionEventInviteFieldsModel();
                ((BaseModel) reactionEventInviteFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionEventInviteFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionEventInviteFieldsModel).a();
                }
                return reactionEventInviteFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1484883804)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class EventViewerCapabilityModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f12889d;

            /* compiled from: field_icon */
            public final class Builder {
                public boolean f12888a;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventViewerCapabilityModel.class, new Deserializer());
                }

                public Object m16024a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventViewerCapabilityParser.m16540a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventViewerCapabilityModel = new EventViewerCapabilityModel();
                    ((BaseModel) eventViewerCapabilityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventViewerCapabilityModel instanceof Postprocessable) {
                        return ((Postprocessable) eventViewerCapabilityModel).a();
                    }
                    return eventViewerCapabilityModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<EventViewerCapabilityModel> {
                public final void m16025a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventViewerCapabilityModel eventViewerCapabilityModel = (EventViewerCapabilityModel) obj;
                    if (eventViewerCapabilityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventViewerCapabilityModel.m16027a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventViewerCapabilityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventViewerCapabilityParser.m16541a(eventViewerCapabilityModel.w_(), eventViewerCapabilityModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventViewerCapabilityModel.class, new Serializer());
                }
            }

            public EventViewerCapabilityModel() {
                super(1);
            }

            public EventViewerCapabilityModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final boolean m16030a() {
                a(0, 0);
                return this.f12889d;
            }

            public static EventViewerCapabilityModel m16026a(EventViewerCapabilityModel eventViewerCapabilityModel) {
                if (eventViewerCapabilityModel == null) {
                    return null;
                }
                if (eventViewerCapabilityModel instanceof EventViewerCapabilityModel) {
                    return eventViewerCapabilityModel;
                }
                Builder builder = new Builder();
                builder.f12888a = eventViewerCapabilityModel.m16030a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f12888a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new EventViewerCapabilityModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1910188188;
            }

            public final GraphQLVisitableModel m16028a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16027a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f12889d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16029a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12889d = mutableFlatBuffer.a(i, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class ParentGroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12891d;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f12890a;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ParentGroupModel.class, new Deserializer());
                }

                public Object m16031a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ParentGroupParser.m16542a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object parentGroupModel = new ParentGroupModel();
                    ((BaseModel) parentGroupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (parentGroupModel instanceof Postprocessable) {
                        return ((Postprocessable) parentGroupModel).a();
                    }
                    return parentGroupModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<ParentGroupModel> {
                public final void m16032a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ParentGroupModel parentGroupModel = (ParentGroupModel) obj;
                    if (parentGroupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(parentGroupModel.m16034a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        parentGroupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ParentGroupParser.m16543a(parentGroupModel.w_(), parentGroupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ParentGroupModel.class, new Serializer());
                }
            }

            public ParentGroupModel() {
                super(1);
            }

            public ParentGroupModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m16037a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16038a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16039b() {
                this.f12891d = super.a(this.f12891d, 0);
                return this.f12891d;
            }

            public static ParentGroupModel m16033a(ParentGroupModel parentGroupModel) {
                if (parentGroupModel == null) {
                    return null;
                }
                if (parentGroupModel instanceof ParentGroupModel) {
                    return parentGroupModel;
                }
                Builder builder = new Builder();
                builder.f12890a = parentGroupModel.m16039b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12890a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ParentGroupModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16036a() {
                return m16039b();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m16035a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16034a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16039b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionEventInviteFieldsModel> {
            public final void m16040a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionEventInviteFieldsModel reactionEventInviteFieldsModel = (ReactionEventInviteFieldsModel) obj;
                if (reactionEventInviteFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionEventInviteFieldsModel.m16044a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionEventInviteFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionEventInviteFieldsParser.m16545a(reactionEventInviteFieldsModel.w_(), reactionEventInviteFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionEventInviteFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ EventViewerCapabilityModel m16050c() {
            return m16042j();
        }

        @Nullable
        public final /* synthetic */ ParentGroupModel fI_() {
            return m16043k();
        }

        public ReactionEventInviteFieldsModel() {
            super(4);
        }

        public ReactionEventInviteFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m16047a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16048a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLEventPrivacyType m16049b() {
            this.f12892d = (GraphQLEventPrivacyType) super.b(this.f12892d, 0, GraphQLEventPrivacyType.class, GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12892d;
        }

        @Nullable
        private EventViewerCapabilityModel m16042j() {
            this.f12893e = (EventViewerCapabilityModel) super.a(this.f12893e, 1, EventViewerCapabilityModel.class);
            return this.f12893e;
        }

        @Nullable
        public final String m16051d() {
            this.f12894f = super.a(this.f12894f, 2);
            return this.f12894f;
        }

        @Nullable
        private ParentGroupModel m16043k() {
            this.f12895g = (ParentGroupModel) super.a(this.f12895g, 3, ParentGroupModel.class);
            return this.f12895g;
        }

        public static ReactionEventInviteFieldsModel m16041a(ReactionEventInviteFieldsModel reactionEventInviteFieldsModel) {
            if (reactionEventInviteFieldsModel == null) {
                return null;
            }
            if (reactionEventInviteFieldsModel instanceof ReactionEventInviteFieldsModel) {
                return reactionEventInviteFieldsModel;
            }
            Builder builder = new Builder();
            builder.f12884a = reactionEventInviteFieldsModel.m16049b();
            builder.f12885b = EventViewerCapabilityModel.m16026a(reactionEventInviteFieldsModel.m16050c());
            builder.f12886c = reactionEventInviteFieldsModel.m16051d();
            builder.f12887d = ParentGroupModel.m16033a(reactionEventInviteFieldsModel.fI_());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = flatBufferBuilder.a(builder.f12884a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f12885b);
            int b = flatBufferBuilder.b(builder.f12886c);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f12887d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ReactionEventInviteFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m16046a() {
            return m16051d();
        }

        public final int jK_() {
            return 67338874;
        }

        public final GraphQLVisitableModel m16045a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16042j() != null) {
                EventViewerCapabilityModel eventViewerCapabilityModel = (EventViewerCapabilityModel) graphQLModelMutatingVisitor.b(m16042j());
                if (m16042j() != eventViewerCapabilityModel) {
                    graphQLVisitableModel = (ReactionEventInviteFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12893e = eventViewerCapabilityModel;
                }
            }
            if (m16043k() != null) {
                ParentGroupModel parentGroupModel = (ParentGroupModel) graphQLModelMutatingVisitor.b(m16043k());
                if (m16043k() != parentGroupModel) {
                    graphQLVisitableModel = (ReactionEventInviteFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12895g = parentGroupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16044a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m16049b());
            int a2 = ModelHelper.a(flatBufferBuilder, m16042j());
            int b = flatBufferBuilder.b(m16051d());
            int a3 = ModelHelper.a(flatBufferBuilder, m16043k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 573870374)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionEventMessageOnlyFriendActionFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionEventMessageOnlyFriendActionFields {
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12907d;
        @Nullable
        private EventModel f12908e;
        @Nullable
        private FriendModel f12909f;

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionEventMessageOnlyFriendActionFieldsModel.class, new Deserializer());
            }

            public Object m16052a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionEventMessageOnlyFriendActionFieldsParser.m16552a(jsonParser);
                Object reactionEventMessageOnlyFriendActionFieldsModel = new ReactionEventMessageOnlyFriendActionFieldsModel();
                ((BaseModel) reactionEventMessageOnlyFriendActionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionEventMessageOnlyFriendActionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionEventMessageOnlyFriendActionFieldsModel).a();
                }
                return reactionEventMessageOnlyFriendActionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 805360651)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class EventModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, Event {
            @Nullable
            private EventPlaceModel f12900d;
            @Nullable
            private String f12901e;
            @Nullable
            private String f12902f;
            @Nullable
            private String f12903g;
            @Nullable
            private DefaultImageFieldsModel f12904h;

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventModel.class, new Deserializer());
                }

                public Object m16053a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionEventMessageOnlyFriendActionFieldsParser.EventParser.m16548a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -341630258)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: field_icon */
            public final class EventPlaceModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f12898d;
                @Nullable
                private String f12899e;

                /* compiled from: field_icon */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f12896a;
                    @Nullable
                    public String f12897b;
                }

                /* compiled from: field_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EventPlaceModel.class, new Deserializer());
                    }

                    public Object m16054a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EventPlaceParser.m16546a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object eventPlaceModel = new EventPlaceModel();
                        ((BaseModel) eventPlaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (eventPlaceModel instanceof Postprocessable) {
                            return ((Postprocessable) eventPlaceModel).a();
                        }
                        return eventPlaceModel;
                    }
                }

                /* compiled from: field_icon */
                public class Serializer extends JsonSerializer<EventPlaceModel> {
                    public final void m16055a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EventPlaceModel eventPlaceModel = (EventPlaceModel) obj;
                        if (eventPlaceModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(eventPlaceModel.m16058a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            eventPlaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EventPlaceParser.m16547a(eventPlaceModel.w_(), eventPlaceModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(EventPlaceModel.class, new Serializer());
                    }
                }

                public EventPlaceModel() {
                    super(2);
                }

                public EventPlaceModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m16061a(String str, ConsistencyTuple consistencyTuple) {
                    if ("name".equals(str)) {
                        consistencyTuple.a = m16063b();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 1;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m16062a(String str, Object obj, boolean z) {
                    if ("name".equals(str)) {
                        m16057a((String) obj);
                    }
                }

                @Nullable
                public final GraphQLObjectType m16059a() {
                    if (this.b != null && this.f12898d == null) {
                        this.f12898d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f12898d;
                }

                @Nullable
                public final String m16063b() {
                    this.f12899e = super.a(this.f12899e, 1);
                    return this.f12899e;
                }

                private void m16057a(@Nullable String str) {
                    this.f12899e = str;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 1, str);
                    }
                }

                public static EventPlaceModel m16056a(EventPlaceModel eventPlaceModel) {
                    if (eventPlaceModel == null) {
                        return null;
                    }
                    if (eventPlaceModel instanceof EventPlaceModel) {
                        return eventPlaceModel;
                    }
                    Builder builder = new Builder();
                    builder.f12896a = eventPlaceModel.m16059a();
                    builder.f12897b = eventPlaceModel.m16063b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f12896a);
                    int b = flatBufferBuilder.b(builder.f12897b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventPlaceModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 77195495;
                }

                public final GraphQLVisitableModel m16060a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16058a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m16059a());
                    int b = flatBufferBuilder.b(m16063b());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<EventModel> {
                public final void m16064a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventModel eventModel = (EventModel) obj;
                    if (eventModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventModel.m16071a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionEventMessageOnlyFriendActionFieldsParser.EventParser.m16549a(eventModel.w_(), eventModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EventModel.class, new Serializer());
                }
            }

            public EventModel() {
                super(5);
            }

            public final void m16074a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = m16069m();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m16075a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m16065a((String) obj);
                }
            }

            @Nullable
            private EventPlaceModel m16066j() {
                this.f12900d = (EventPlaceModel) super.a(this.f12900d, 0, EventPlaceModel.class);
                return this.f12900d;
            }

            @Nullable
            private String m16067k() {
                this.f12901e = super.a(this.f12901e, 1);
                return this.f12901e;
            }

            @Nullable
            private String m16068l() {
                this.f12902f = super.a(this.f12902f, 2);
                return this.f12902f;
            }

            @Nullable
            private String m16069m() {
                this.f12903g = super.a(this.f12903g, 3);
                return this.f12903g;
            }

            private void m16065a(@Nullable String str) {
                this.f12903g = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, str);
                }
            }

            @Nullable
            private DefaultImageFieldsModel m16070n() {
                this.f12904h = (DefaultImageFieldsModel) super.a(this.f12904h, 4, DefaultImageFieldsModel.class);
                return this.f12904h;
            }

            @Nullable
            public final String m16073a() {
                return m16067k();
            }

            public final int jK_() {
                return 67338874;
            }

            public final GraphQLVisitableModel m16072a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16066j() != null) {
                    EventPlaceModel eventPlaceModel = (EventPlaceModel) graphQLModelMutatingVisitor.b(m16066j());
                    if (m16066j() != eventPlaceModel) {
                        graphQLVisitableModel = (EventModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12900d = eventPlaceModel;
                    }
                }
                if (m16070n() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16070n());
                    if (m16070n() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (EventModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12904h = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16071a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16066j());
                int b = flatBufferBuilder.b(m16067k());
                int b2 = flatBufferBuilder.b(m16068l());
                int b3 = flatBufferBuilder.b(m16069m());
                int a2 = ModelHelper.a(flatBufferBuilder, m16070n());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                flatBufferBuilder.b(4, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class FriendModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12906d;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f12905a;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendModel.class, new Deserializer());
                }

                public Object m16076a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendParser.m16550a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendModel = new FriendModel();
                    ((BaseModel) friendModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendModel instanceof Postprocessable) {
                        return ((Postprocessable) friendModel).a();
                    }
                    return friendModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<FriendModel> {
                public final void m16077a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendModel friendModel = (FriendModel) obj;
                    if (friendModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendModel.m16079a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendParser.m16551a(friendModel.w_(), friendModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FriendModel.class, new Serializer());
                }
            }

            public FriendModel() {
                super(1);
            }

            public FriendModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m16082a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16083a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16084b() {
                this.f12906d = super.a(this.f12906d, 0);
                return this.f12906d;
            }

            public static FriendModel m16078a(FriendModel friendModel) {
                if (friendModel == null) {
                    return null;
                }
                if (friendModel instanceof FriendModel) {
                    return friendModel;
                }
                Builder builder = new Builder();
                builder.f12905a = friendModel.m16084b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12905a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FriendModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16081a() {
                return m16084b();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m16080a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16079a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16084b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionEventMessageOnlyFriendActionFieldsModel> {
            public final void m16085a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionEventMessageOnlyFriendActionFieldsModel reactionEventMessageOnlyFriendActionFieldsModel = (ReactionEventMessageOnlyFriendActionFieldsModel) obj;
                if (reactionEventMessageOnlyFriendActionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionEventMessageOnlyFriendActionFieldsModel.m16089a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionEventMessageOnlyFriendActionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionEventMessageOnlyFriendActionFieldsModel.w_();
                int u_ = reactionEventMessageOnlyFriendActionFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("action_default_message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("event");
                    ReactionEventMessageOnlyFriendActionFieldsParser.EventParser.m16549a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("friend");
                    FriendParser.m16551a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionEventMessageOnlyFriendActionFieldsModel.class, new Serializer());
            }
        }

        public ReactionEventMessageOnlyFriendActionFieldsModel() {
            super(3);
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m16086a() {
            this.f12907d = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12907d, 0, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12907d;
        }

        @Nullable
        private EventModel m16087j() {
            this.f12908e = (EventModel) super.a(this.f12908e, 1, EventModel.class);
            return this.f12908e;
        }

        @Nullable
        private FriendModel m16088k() {
            this.f12909f = (FriendModel) super.a(this.f12909f, 2, FriendModel.class);
            return this.f12909f;
        }

        public final int jK_() {
            return 228770134;
        }

        public final GraphQLVisitableModel m16090a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16086a() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m16086a());
                if (m16086a() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionEventMessageOnlyFriendActionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12907d = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m16087j() != null) {
                EventModel eventModel = (EventModel) graphQLModelMutatingVisitor.b(m16087j());
                if (m16087j() != eventModel) {
                    graphQLVisitableModel = (ReactionEventMessageOnlyFriendActionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12908e = eventModel;
                }
            }
            if (m16088k() != null) {
                FriendModel friendModel = (FriendModel) graphQLModelMutatingVisitor.b(m16088k());
                if (m16088k() != friendModel) {
                    graphQLVisitableModel = (ReactionEventMessageOnlyFriendActionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12909f = friendModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16089a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16086a());
            int a2 = ModelHelper.a(flatBufferBuilder, m16087j());
            int a3 = ModelHelper.a(flatBufferBuilder, m16088k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 640787110)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionFundraiserActionFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionFundraiserActionFields {
        @Nullable
        private FundraiserCampaignModel f12930d;

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionFundraiserActionFieldsModel.class, new Deserializer());
            }

            public Object m16091a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionFundraiserActionFieldsParser.m16561a(jsonParser);
                Object reactionFundraiserActionFieldsModel = new ReactionFundraiserActionFieldsModel();
                ((BaseModel) reactionFundraiserActionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionFundraiserActionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionFundraiserActionFieldsModel).a();
                }
                return reactionFundraiserActionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1391968191)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class FundraiserCampaignModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f12924d;
            @Nullable
            private String f12925e;
            @Nullable
            private FundraiserDetailedProgressTextModel f12926f;
            @Nullable
            private FundraiserForCharityTextModel f12927g;
            @Nullable
            private String f12928h;
            @Nullable
            private OwnerModel f12929i;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f12910a;
                @Nullable
                public String f12911b;
                @Nullable
                public FundraiserDetailedProgressTextModel f12912c;
                @Nullable
                public FundraiserForCharityTextModel f12913d;
                @Nullable
                public String f12914e;
                @Nullable
                public OwnerModel f12915f;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FundraiserCampaignModel.class, new Deserializer());
                }

                public Object m16092a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FundraiserCampaignParser.m16559a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object fundraiserCampaignModel = new FundraiserCampaignModel();
                    ((BaseModel) fundraiserCampaignModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (fundraiserCampaignModel instanceof Postprocessable) {
                        return ((Postprocessable) fundraiserCampaignModel).a();
                    }
                    return fundraiserCampaignModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: field_icon */
            public final class FundraiserDetailedProgressTextModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f12917d;

                /* compiled from: field_icon */
                public final class Builder {
                    @Nullable
                    public String f12916a;
                }

                /* compiled from: field_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FundraiserDetailedProgressTextModel.class, new Deserializer());
                    }

                    public Object m16093a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FundraiserDetailedProgressTextParser.m16553a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object fundraiserDetailedProgressTextModel = new FundraiserDetailedProgressTextModel();
                        ((BaseModel) fundraiserDetailedProgressTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (fundraiserDetailedProgressTextModel instanceof Postprocessable) {
                            return ((Postprocessable) fundraiserDetailedProgressTextModel).a();
                        }
                        return fundraiserDetailedProgressTextModel;
                    }
                }

                /* compiled from: field_icon */
                public class Serializer extends JsonSerializer<FundraiserDetailedProgressTextModel> {
                    public final void m16094a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FundraiserDetailedProgressTextModel fundraiserDetailedProgressTextModel = (FundraiserDetailedProgressTextModel) obj;
                        if (fundraiserDetailedProgressTextModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(fundraiserDetailedProgressTextModel.m16096a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            fundraiserDetailedProgressTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FundraiserDetailedProgressTextParser.m16554a(fundraiserDetailedProgressTextModel.w_(), fundraiserDetailedProgressTextModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FundraiserDetailedProgressTextModel.class, new Serializer());
                    }
                }

                public FundraiserDetailedProgressTextModel() {
                    super(1);
                }

                public FundraiserDetailedProgressTextModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m16098a() {
                    this.f12917d = super.a(this.f12917d, 0);
                    return this.f12917d;
                }

                public static FundraiserDetailedProgressTextModel m16095a(FundraiserDetailedProgressTextModel fundraiserDetailedProgressTextModel) {
                    if (fundraiserDetailedProgressTextModel == null) {
                        return null;
                    }
                    if (fundraiserDetailedProgressTextModel instanceof FundraiserDetailedProgressTextModel) {
                        return fundraiserDetailedProgressTextModel;
                    }
                    Builder builder = new Builder();
                    builder.f12916a = fundraiserDetailedProgressTextModel.m16098a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f12916a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new FundraiserDetailedProgressTextModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m16097a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16096a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16098a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: field_icon */
            public final class FundraiserForCharityTextModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f12919d;

                /* compiled from: field_icon */
                public final class Builder {
                    @Nullable
                    public String f12918a;
                }

                /* compiled from: field_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FundraiserForCharityTextModel.class, new Deserializer());
                    }

                    public Object m16099a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FundraiserForCharityTextParser.m16555a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object fundraiserForCharityTextModel = new FundraiserForCharityTextModel();
                        ((BaseModel) fundraiserForCharityTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (fundraiserForCharityTextModel instanceof Postprocessable) {
                            return ((Postprocessable) fundraiserForCharityTextModel).a();
                        }
                        return fundraiserForCharityTextModel;
                    }
                }

                /* compiled from: field_icon */
                public class Serializer extends JsonSerializer<FundraiserForCharityTextModel> {
                    public final void m16100a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FundraiserForCharityTextModel fundraiserForCharityTextModel = (FundraiserForCharityTextModel) obj;
                        if (fundraiserForCharityTextModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(fundraiserForCharityTextModel.m16102a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            fundraiserForCharityTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FundraiserForCharityTextParser.m16556a(fundraiserForCharityTextModel.w_(), fundraiserForCharityTextModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FundraiserForCharityTextModel.class, new Serializer());
                    }
                }

                public FundraiserForCharityTextModel() {
                    super(1);
                }

                public FundraiserForCharityTextModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m16104a() {
                    this.f12919d = super.a(this.f12919d, 0);
                    return this.f12919d;
                }

                public static FundraiserForCharityTextModel m16101a(FundraiserForCharityTextModel fundraiserForCharityTextModel) {
                    if (fundraiserForCharityTextModel == null) {
                        return null;
                    }
                    if (fundraiserForCharityTextModel instanceof FundraiserForCharityTextModel) {
                        return fundraiserForCharityTextModel;
                    }
                    Builder builder = new Builder();
                    builder.f12918a = fundraiserForCharityTextModel.m16104a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f12918a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new FundraiserForCharityTextModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m16103a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16102a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16104a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1084932536)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: field_icon */
            public final class OwnerModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f12922d;
                @Nullable
                private DefaultImageFieldsModel f12923e;

                /* compiled from: field_icon */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f12920a;
                    @Nullable
                    public DefaultImageFieldsModel f12921b;
                }

                /* compiled from: field_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                    }

                    public Object m16105a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OwnerParser.m16557a(jsonParser, flatBufferBuilder));
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

                /* compiled from: field_icon */
                public class Serializer extends JsonSerializer<OwnerModel> {
                    public final void m16106a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OwnerModel ownerModel = (OwnerModel) obj;
                        if (ownerModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ownerModel.m16109a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OwnerParser.m16558a(ownerModel.w_(), ownerModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(OwnerModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ DefaultImageFields m16114b() {
                    return m16108j();
                }

                public OwnerModel() {
                    super(2);
                }

                public OwnerModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m16112a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m16113a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final GraphQLObjectType m16110a() {
                    if (this.b != null && this.f12922d == null) {
                        this.f12922d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f12922d;
                }

                @Nullable
                private DefaultImageFieldsModel m16108j() {
                    this.f12923e = (DefaultImageFieldsModel) super.a(this.f12923e, 1, DefaultImageFieldsModel.class);
                    return this.f12923e;
                }

                public static OwnerModel m16107a(OwnerModel ownerModel) {
                    if (ownerModel == null) {
                        return null;
                    }
                    if (ownerModel instanceof OwnerModel) {
                        return ownerModel;
                    }
                    Builder builder = new Builder();
                    builder.f12920a = ownerModel.m16110a();
                    builder.f12921b = DefaultImageFieldsModel.a(ownerModel.m16114b());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f12920a);
                    int a2 = ModelHelper.a(flatBufferBuilder, builder.f12921b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new OwnerModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m16111a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m16108j() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16108j());
                        if (m16108j() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (OwnerModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12923e = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m16109a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m16110a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m16108j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<FundraiserCampaignModel> {
                public final void m16115a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FundraiserCampaignModel fundraiserCampaignModel = (FundraiserCampaignModel) obj;
                    if (fundraiserCampaignModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(fundraiserCampaignModel.m16120a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        fundraiserCampaignModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FundraiserCampaignParser.m16560a(fundraiserCampaignModel.w_(), fundraiserCampaignModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FundraiserCampaignModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ FundraiserDetailedProgressTextModel m16125d() {
                return m16117j();
            }

            @Nullable
            public final /* synthetic */ OwnerModel fJ_() {
                return m16119l();
            }

            @Nullable
            public final /* synthetic */ FundraiserForCharityTextModel fK_() {
                return m16118k();
            }

            public FundraiserCampaignModel() {
                super(6);
            }

            public FundraiserCampaignModel(MutableFlatBuffer mutableFlatBuffer) {
                super(6);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final GraphQLObjectType m16123b() {
                if (this.b != null && this.f12924d == null) {
                    this.f12924d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12924d;
            }

            @Nullable
            public final String m16124c() {
                this.f12925e = super.a(this.f12925e, 1);
                return this.f12925e;
            }

            @Nullable
            private FundraiserDetailedProgressTextModel m16117j() {
                this.f12926f = (FundraiserDetailedProgressTextModel) super.a(this.f12926f, 2, FundraiserDetailedProgressTextModel.class);
                return this.f12926f;
            }

            @Nullable
            private FundraiserForCharityTextModel m16118k() {
                this.f12927g = (FundraiserForCharityTextModel) super.a(this.f12927g, 3, FundraiserForCharityTextModel.class);
                return this.f12927g;
            }

            @Nullable
            public final String m16126g() {
                this.f12928h = super.a(this.f12928h, 4);
                return this.f12928h;
            }

            @Nullable
            private OwnerModel m16119l() {
                this.f12929i = (OwnerModel) super.a(this.f12929i, 5, OwnerModel.class);
                return this.f12929i;
            }

            public static FundraiserCampaignModel m16116a(FundraiserCampaignModel fundraiserCampaignModel) {
                if (fundraiserCampaignModel == null) {
                    return null;
                }
                if (fundraiserCampaignModel instanceof FundraiserCampaignModel) {
                    return fundraiserCampaignModel;
                }
                Builder builder = new Builder();
                builder.f12910a = fundraiserCampaignModel.m16123b();
                builder.f12911b = fundraiserCampaignModel.m16124c();
                builder.f12912c = FundraiserDetailedProgressTextModel.m16095a(fundraiserCampaignModel.m16125d());
                builder.f12913d = FundraiserForCharityTextModel.m16101a(fundraiserCampaignModel.fK_());
                builder.f12914e = fundraiserCampaignModel.m16126g();
                builder.f12915f = OwnerModel.m16107a(fundraiserCampaignModel.fJ_());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12910a);
                int b = flatBufferBuilder.b(builder.f12911b);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f12912c);
                int a3 = ModelHelper.a(flatBufferBuilder, builder.f12913d);
                int b2 = flatBufferBuilder.b(builder.f12914e);
                int a4 = ModelHelper.a(flatBufferBuilder, builder.f12915f);
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FundraiserCampaignModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16122a() {
                return m16126g();
            }

            public final int jK_() {
                return -2117047886;
            }

            public final GraphQLVisitableModel m16121a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16117j() != null) {
                    FundraiserDetailedProgressTextModel fundraiserDetailedProgressTextModel = (FundraiserDetailedProgressTextModel) graphQLModelMutatingVisitor.b(m16117j());
                    if (m16117j() != fundraiserDetailedProgressTextModel) {
                        graphQLVisitableModel = (FundraiserCampaignModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12926f = fundraiserDetailedProgressTextModel;
                    }
                }
                if (m16118k() != null) {
                    FundraiserForCharityTextModel fundraiserForCharityTextModel = (FundraiserForCharityTextModel) graphQLModelMutatingVisitor.b(m16118k());
                    if (m16118k() != fundraiserForCharityTextModel) {
                        graphQLVisitableModel = (FundraiserCampaignModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12927g = fundraiserForCharityTextModel;
                    }
                }
                if (m16119l() != null) {
                    OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m16119l());
                    if (m16119l() != ownerModel) {
                        graphQLVisitableModel = (FundraiserCampaignModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12929i = ownerModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16120a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16123b());
                int b = flatBufferBuilder.b(m16124c());
                int a2 = ModelHelper.a(flatBufferBuilder, m16117j());
                int a3 = ModelHelper.a(flatBufferBuilder, m16118k());
                int b2 = flatBufferBuilder.b(m16126g());
                int a4 = ModelHelper.a(flatBufferBuilder, m16119l());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionFundraiserActionFieldsModel> {
            public final void m16127a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionFundraiserActionFieldsModel reactionFundraiserActionFieldsModel = (ReactionFundraiserActionFieldsModel) obj;
                if (reactionFundraiserActionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionFundraiserActionFieldsModel.m16129a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionFundraiserActionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionFundraiserActionFieldsModel.w_();
                int u_ = reactionFundraiserActionFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("fundraiser_campaign");
                    FundraiserCampaignParser.m16560a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionFundraiserActionFieldsModel.class, new Serializer());
            }
        }

        public ReactionFundraiserActionFieldsModel() {
            super(1);
        }

        @Nullable
        private FundraiserCampaignModel m16128a() {
            this.f12930d = (FundraiserCampaignModel) super.a(this.f12930d, 0, FundraiserCampaignModel.class);
            return this.f12930d;
        }

        public final int jK_() {
            return -1517217910;
        }

        public final GraphQLVisitableModel m16130a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16128a() != null) {
                FundraiserCampaignModel fundraiserCampaignModel = (FundraiserCampaignModel) graphQLModelMutatingVisitor.b(m16128a());
                if (m16128a() != fundraiserCampaignModel) {
                    graphQLVisitableModel = (ReactionFundraiserActionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12930d = fundraiserCampaignModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16129a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16128a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1310023322)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionGenericOpenGraphObjectActionFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionGenericOpenGraphObjectActionFields {
        @Nullable
        private ActionOgObjectModel f12939d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1400907669)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class ActionOgObjectModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            private boolean f12935d;
            private boolean f12936e;
            @Nullable
            private String f12937f;
            @Nullable
            private String f12938g;

            /* compiled from: field_icon */
            public final class Builder {
                public boolean f12931a;
                public boolean f12932b;
                @Nullable
                public String f12933c;
                @Nullable
                public String f12934d;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActionOgObjectModel.class, new Deserializer());
                }

                public Object m16131a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActionOgObjectParser.m16562a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actionOgObjectModel = new ActionOgObjectModel();
                    ((BaseModel) actionOgObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actionOgObjectModel instanceof Postprocessable) {
                        return ((Postprocessable) actionOgObjectModel).a();
                    }
                    return actionOgObjectModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<ActionOgObjectModel> {
                public final void m16132a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActionOgObjectModel actionOgObjectModel = (ActionOgObjectModel) obj;
                    if (actionOgObjectModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actionOgObjectModel.m16134a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actionOgObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActionOgObjectParser.m16563a(actionOgObjectModel.w_(), actionOgObjectModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ActionOgObjectModel.class, new Serializer());
                }
            }

            public ActionOgObjectModel() {
                super(4);
            }

            public ActionOgObjectModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final boolean m16138b() {
                a(0, 0);
                return this.f12935d;
            }

            public final boolean m16139c() {
                a(0, 1);
                return this.f12936e;
            }

            @Nullable
            public final String m16140d() {
                this.f12937f = super.a(this.f12937f, 2);
                return this.f12937f;
            }

            @Nullable
            public final String fL_() {
                this.f12938g = super.a(this.f12938g, 3);
                return this.f12938g;
            }

            public static ActionOgObjectModel m16133a(ActionOgObjectModel actionOgObjectModel) {
                if (actionOgObjectModel == null) {
                    return null;
                }
                if (actionOgObjectModel instanceof ActionOgObjectModel) {
                    return actionOgObjectModel;
                }
                Builder builder = new Builder();
                builder.f12931a = actionOgObjectModel.m16138b();
                builder.f12932b = actionOgObjectModel.m16139c();
                builder.f12933c = actionOgObjectModel.m16140d();
                builder.f12934d = actionOgObjectModel.fL_();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12933c);
                int b2 = flatBufferBuilder.b(builder.f12934d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, builder.f12931a);
                flatBufferBuilder.a(1, builder.f12932b);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ActionOgObjectModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16136a() {
                return m16140d();
            }

            public final int jK_() {
                return -1304042141;
            }

            public final GraphQLVisitableModel m16135a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16134a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16140d());
                int b2 = flatBufferBuilder.b(fL_());
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f12935d);
                flatBufferBuilder.a(1, this.f12936e);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16137a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12935d = mutableFlatBuffer.a(i, 0);
                this.f12936e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionGenericOpenGraphObjectActionFieldsModel.class, new Deserializer());
            }

            public Object m16141a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionGenericOpenGraphObjectActionFieldsParser.m16564a(jsonParser);
                Object reactionGenericOpenGraphObjectActionFieldsModel = new ReactionGenericOpenGraphObjectActionFieldsModel();
                ((BaseModel) reactionGenericOpenGraphObjectActionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionGenericOpenGraphObjectActionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionGenericOpenGraphObjectActionFieldsModel).a();
                }
                return reactionGenericOpenGraphObjectActionFieldsModel;
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionGenericOpenGraphObjectActionFieldsModel> {
            public final void m16142a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionGenericOpenGraphObjectActionFieldsModel reactionGenericOpenGraphObjectActionFieldsModel = (ReactionGenericOpenGraphObjectActionFieldsModel) obj;
                if (reactionGenericOpenGraphObjectActionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionGenericOpenGraphObjectActionFieldsModel.m16144a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionGenericOpenGraphObjectActionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionGenericOpenGraphObjectActionFieldsModel.w_();
                int u_ = reactionGenericOpenGraphObjectActionFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("action_og_object");
                    ActionOgObjectParser.m16563a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionGenericOpenGraphObjectActionFieldsModel.class, new Serializer());
            }
        }

        public ReactionGenericOpenGraphObjectActionFieldsModel() {
            super(1);
        }

        @Nullable
        private ActionOgObjectModel m16143a() {
            this.f12939d = (ActionOgObjectModel) super.a(this.f12939d, 0, ActionOgObjectModel.class);
            return this.f12939d;
        }

        public final int jK_() {
            return 84756203;
        }

        public final GraphQLVisitableModel m16145a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16143a() != null) {
                ActionOgObjectModel actionOgObjectModel = (ActionOgObjectModel) graphQLModelMutatingVisitor.b(m16143a());
                if (m16143a() != actionOgObjectModel) {
                    graphQLVisitableModel = (ReactionGenericOpenGraphObjectActionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12939d = actionOgObjectModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16144a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16143a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -368344204)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionOpenNearbyPlacesActionFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionOpenNearbyPlacesActionFields {
        @Nullable
        private PlacesQueryLocationPageModel f12944d;
        @Nullable
        private String f12945e;
        @Nullable
        private String f12946f;

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionOpenNearbyPlacesActionFieldsModel.class, new Deserializer());
            }

            public Object m16146a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionOpenNearbyPlacesActionFieldsParser.m16567a(jsonParser);
                Object reactionOpenNearbyPlacesActionFieldsModel = new ReactionOpenNearbyPlacesActionFieldsModel();
                ((BaseModel) reactionOpenNearbyPlacesActionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionOpenNearbyPlacesActionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionOpenNearbyPlacesActionFieldsModel).a();
                }
                return reactionOpenNearbyPlacesActionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1185712657)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class PlacesQueryLocationPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12942d;
            @Nullable
            private String f12943e;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f12940a;
                @Nullable
                public String f12941b;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlacesQueryLocationPageModel.class, new Deserializer());
                }

                public Object m16147a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlacesQueryLocationPageParser.m16565a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placesQueryLocationPageModel = new PlacesQueryLocationPageModel();
                    ((BaseModel) placesQueryLocationPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placesQueryLocationPageModel instanceof Postprocessable) {
                        return ((Postprocessable) placesQueryLocationPageModel).a();
                    }
                    return placesQueryLocationPageModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<PlacesQueryLocationPageModel> {
                public final void m16148a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlacesQueryLocationPageModel placesQueryLocationPageModel = (PlacesQueryLocationPageModel) obj;
                    if (placesQueryLocationPageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placesQueryLocationPageModel.m16150a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placesQueryLocationPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlacesQueryLocationPageParser.m16566a(placesQueryLocationPageModel.w_(), placesQueryLocationPageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlacesQueryLocationPageModel.class, new Serializer());
                }
            }

            public PlacesQueryLocationPageModel() {
                super(2);
            }

            public PlacesQueryLocationPageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m16153a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16154a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16155b() {
                this.f12942d = super.a(this.f12942d, 0);
                return this.f12942d;
            }

            @Nullable
            public final String m16156c() {
                this.f12943e = super.a(this.f12943e, 1);
                return this.f12943e;
            }

            public static PlacesQueryLocationPageModel m16149a(PlacesQueryLocationPageModel placesQueryLocationPageModel) {
                if (placesQueryLocationPageModel == null) {
                    return null;
                }
                if (placesQueryLocationPageModel instanceof PlacesQueryLocationPageModel) {
                    return placesQueryLocationPageModel;
                }
                Builder builder = new Builder();
                builder.f12940a = placesQueryLocationPageModel.m16155b();
                builder.f12941b = placesQueryLocationPageModel.m16156c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12940a);
                int b2 = flatBufferBuilder.b(builder.f12941b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PlacesQueryLocationPageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16152a() {
                return m16155b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m16151a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16150a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16155b());
                int b2 = flatBufferBuilder.b(m16156c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionOpenNearbyPlacesActionFieldsModel> {
            public final void m16157a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionOpenNearbyPlacesActionFieldsModel reactionOpenNearbyPlacesActionFieldsModel = (ReactionOpenNearbyPlacesActionFieldsModel) obj;
                if (reactionOpenNearbyPlacesActionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionOpenNearbyPlacesActionFieldsModel.m16161a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionOpenNearbyPlacesActionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionOpenNearbyPlacesActionFieldsModel.w_();
                int u_ = reactionOpenNearbyPlacesActionFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("places_query_location_page");
                    PlacesQueryLocationPageParser.m16566a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("places_query_text");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("places_query_topic_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionOpenNearbyPlacesActionFieldsModel.class, new Serializer());
            }
        }

        public ReactionOpenNearbyPlacesActionFieldsModel() {
            super(3);
        }

        @Nullable
        private PlacesQueryLocationPageModel m16158a() {
            this.f12944d = (PlacesQueryLocationPageModel) super.a(this.f12944d, 0, PlacesQueryLocationPageModel.class);
            return this.f12944d;
        }

        @Nullable
        private String m16159j() {
            this.f12945e = super.a(this.f12945e, 1);
            return this.f12945e;
        }

        @Nullable
        private String m16160k() {
            this.f12946f = super.a(this.f12946f, 2);
            return this.f12946f;
        }

        public final int jK_() {
            return -1571830956;
        }

        public final GraphQLVisitableModel m16162a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16158a() != null) {
                PlacesQueryLocationPageModel placesQueryLocationPageModel = (PlacesQueryLocationPageModel) graphQLModelMutatingVisitor.b(m16158a());
                if (m16158a() != placesQueryLocationPageModel) {
                    graphQLVisitableModel = (ReactionOpenNearbyPlacesActionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12944d = placesQueryLocationPageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16161a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16158a());
            int b = flatBufferBuilder.b(m16159j());
            int b2 = flatBufferBuilder.b(m16160k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1256623116)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionOpenPageAlbumActionFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionOpenPageAlbumActionFragment {
        @Nullable
        private AlbumModel f12950d;
        @Nullable
        private PageModel f12951e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class AlbumModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f12948d;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f12947a;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlbumModel.class, new Deserializer());
                }

                public Object m16163a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AlbumParser.m16568a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object albumModel = new AlbumModel();
                    ((BaseModel) albumModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (albumModel instanceof Postprocessable) {
                        return ((Postprocessable) albumModel).a();
                    }
                    return albumModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<AlbumModel> {
                public final void m16164a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlbumModel albumModel = (AlbumModel) obj;
                    if (albumModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(albumModel.m16166a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        albumModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AlbumParser.m16569a(albumModel.w_(), albumModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AlbumModel.class, new Serializer());
                }
            }

            public AlbumModel() {
                super(1);
            }

            public AlbumModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m16169b() {
                this.f12948d = super.a(this.f12948d, 0);
                return this.f12948d;
            }

            public static AlbumModel m16165a(AlbumModel albumModel) {
                if (albumModel == null) {
                    return null;
                }
                if (albumModel instanceof AlbumModel) {
                    return albumModel;
                }
                Builder builder = new Builder();
                builder.f12947a = albumModel.m16169b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12947a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AlbumModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16168a() {
                return m16169b();
            }

            public final int jK_() {
                return 63344207;
            }

            public final GraphQLVisitableModel m16167a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16166a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16169b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionOpenPageAlbumActionFragmentModel.class, new Deserializer());
            }

            public Object m16170a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionOpenPageAlbumActionFragmentParser.m16572a(jsonParser);
                Object reactionOpenPageAlbumActionFragmentModel = new ReactionOpenPageAlbumActionFragmentModel();
                ((BaseModel) reactionOpenPageAlbumActionFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionOpenPageAlbumActionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionOpenPageAlbumActionFragmentModel).a();
                }
                return reactionOpenPageAlbumActionFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12949d;

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m16171a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionOpenPageAlbumActionFragmentParser.PageParser.m16570a(jsonParser, flatBufferBuilder));
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

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m16172a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m16174a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionOpenPageAlbumActionFragmentParser.PageParser.m16571a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(1);
            }

            public final void m16177a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16178a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m16173j() {
                this.f12949d = super.a(this.f12949d, 0);
                return this.f12949d;
            }

            @Nullable
            public final String m16176a() {
                return m16173j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m16175a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16174a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16173j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionOpenPageAlbumActionFragmentModel> {
            public final void m16179a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionOpenPageAlbumActionFragmentModel reactionOpenPageAlbumActionFragmentModel = (ReactionOpenPageAlbumActionFragmentModel) obj;
                if (reactionOpenPageAlbumActionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionOpenPageAlbumActionFragmentModel.m16182a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionOpenPageAlbumActionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionOpenPageAlbumActionFragmentModel.w_();
                int u_ = reactionOpenPageAlbumActionFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("album");
                    AlbumParser.m16569a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("page");
                    ReactionOpenPageAlbumActionFragmentParser.PageParser.m16571a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionOpenPageAlbumActionFragmentModel.class, new Serializer());
            }
        }

        public ReactionOpenPageAlbumActionFragmentModel() {
            super(2);
        }

        @Nullable
        private AlbumModel m16180a() {
            this.f12950d = (AlbumModel) super.a(this.f12950d, 0, AlbumModel.class);
            return this.f12950d;
        }

        @Nullable
        private PageModel m16181j() {
            this.f12951e = (PageModel) super.a(this.f12951e, 1, PageModel.class);
            return this.f12951e;
        }

        public final int jK_() {
            return 1595039427;
        }

        public final GraphQLVisitableModel m16183a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16180a() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m16180a());
                if (m16180a() != albumModel) {
                    graphQLVisitableModel = (ReactionOpenPageAlbumActionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12950d = albumModel;
                }
            }
            if (m16181j() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m16181j());
                if (m16181j() != pageModel) {
                    graphQLVisitableModel = (ReactionOpenPageAlbumActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12951e = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16182a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16180a());
            int a2 = ModelHelper.a(flatBufferBuilder, m16181j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 562466935)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionOpenPlaysActionFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionOpenPlaysActionFields {
        @Nullable
        private MatchPageModel f12954d;

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionOpenPlaysActionFieldsModel.class, new Deserializer());
            }

            public Object m16184a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionOpenPlaysActionFieldsParser.m16575a(jsonParser);
                Object reactionOpenPlaysActionFieldsModel = new ReactionOpenPlaysActionFieldsModel();
                ((BaseModel) reactionOpenPlaysActionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionOpenPlaysActionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionOpenPlaysActionFieldsModel).a();
                }
                return reactionOpenPlaysActionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class MatchPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12953d;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f12952a;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MatchPageModel.class, new Deserializer());
                }

                public Object m16185a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MatchPageParser.m16573a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object matchPageModel = new MatchPageModel();
                    ((BaseModel) matchPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (matchPageModel instanceof Postprocessable) {
                        return ((Postprocessable) matchPageModel).a();
                    }
                    return matchPageModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<MatchPageModel> {
                public final void m16186a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MatchPageModel matchPageModel = (MatchPageModel) obj;
                    if (matchPageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(matchPageModel.m16188a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        matchPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MatchPageParser.m16574a(matchPageModel.w_(), matchPageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MatchPageModel.class, new Serializer());
                }
            }

            public MatchPageModel() {
                super(1);
            }

            public MatchPageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m16191a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16192a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16193b() {
                this.f12953d = super.a(this.f12953d, 0);
                return this.f12953d;
            }

            public static MatchPageModel m16187a(MatchPageModel matchPageModel) {
                if (matchPageModel == null) {
                    return null;
                }
                if (matchPageModel instanceof MatchPageModel) {
                    return matchPageModel;
                }
                Builder builder = new Builder();
                builder.f12952a = matchPageModel.m16193b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12952a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MatchPageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16190a() {
                return m16193b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m16189a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16188a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16193b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionOpenPlaysActionFieldsModel> {
            public final void m16194a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionOpenPlaysActionFieldsModel reactionOpenPlaysActionFieldsModel = (ReactionOpenPlaysActionFieldsModel) obj;
                if (reactionOpenPlaysActionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionOpenPlaysActionFieldsModel.m16196a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionOpenPlaysActionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionOpenPlaysActionFieldsModel.w_();
                int u_ = reactionOpenPlaysActionFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("match_page");
                    MatchPageParser.m16574a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionOpenPlaysActionFieldsModel.class, new Serializer());
            }
        }

        public ReactionOpenPlaysActionFieldsModel() {
            super(1);
        }

        @Nullable
        private MatchPageModel m16195a() {
            this.f12954d = (MatchPageModel) super.a(this.f12954d, 0, MatchPageModel.class);
            return this.f12954d;
        }

        public final int jK_() {
            return -249247582;
        }

        public final GraphQLVisitableModel m16197a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16195a() != null) {
                MatchPageModel matchPageModel = (MatchPageModel) graphQLModelMutatingVisitor.b(m16195a());
                if (m16195a() != matchPageModel) {
                    graphQLVisitableModel = (ReactionOpenPlaysActionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12954d = matchPageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16196a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16195a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1951106261)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionOpenVideoChannelFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionOpenVideoChannelFields {
        @Nullable
        private VideoChannelModel f12973d;

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionOpenVideoChannelFieldsModel.class, new Deserializer());
            }

            public Object m16198a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionOpenVideoChannelFieldsParser.m16578a(jsonParser);
                Object reactionOpenVideoChannelFieldsModel = new ReactionOpenVideoChannelFieldsModel();
                ((BaseModel) reactionOpenVideoChannelFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionOpenVideoChannelFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionOpenVideoChannelFieldsModel).a();
                }
                return reactionOpenVideoChannelFieldsModel;
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionOpenVideoChannelFieldsModel> {
            public final void m16199a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionOpenVideoChannelFieldsModel reactionOpenVideoChannelFieldsModel = (ReactionOpenVideoChannelFieldsModel) obj;
                if (reactionOpenVideoChannelFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionOpenVideoChannelFieldsModel.m16220a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionOpenVideoChannelFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionOpenVideoChannelFieldsModel.w_();
                int u_ = reactionOpenVideoChannelFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("video_channel");
                    VideoChannelParser.m16577a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionOpenVideoChannelFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 62653598)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class VideoChannelModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, VideoTopicFragment {
            @Nullable
            private GraphQLObjectType f12964d;
            @Nullable
            private String f12965e;
            private int f12966f;
            @Nullable
            private SquareHeaderImageModel f12967g;
            private boolean f12968h;
            private boolean f12969i;
            private int f12970j;
            @Nullable
            private VideoChannelSubtitleModel f12971k;
            @Nullable
            private VideoChannelTitleModel f12972l;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f12955a;
                @Nullable
                public String f12956b;
                public int f12957c;
                @Nullable
                public SquareHeaderImageModel f12958d;
                public boolean f12959e;
                public boolean f12960f;
                public int f12961g;
                @Nullable
                public VideoChannelSubtitleModel f12962h;
                @Nullable
                public VideoChannelTitleModel f12963i;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoChannelModel.class, new Deserializer());
                }

                public Object m16200a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoChannelParser.m16576a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoChannelModel = new VideoChannelModel();
                    ((BaseModel) videoChannelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoChannelModel instanceof Postprocessable) {
                        return ((Postprocessable) videoChannelModel).a();
                    }
                    return videoChannelModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<VideoChannelModel> {
                public final void m16201a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoChannelModel videoChannelModel = (VideoChannelModel) obj;
                    if (videoChannelModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoChannelModel.m16207a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoChannelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoChannelParser.m16577a(videoChannelModel.w_(), videoChannelModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VideoChannelModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ SquareHeaderImageModel mo842d() {
                return m16204l();
            }

            @Nullable
            public final /* synthetic */ VideoChannelSubtitleModel fg_() {
                return m16205m();
            }

            @Nullable
            public final /* synthetic */ VideoChannelTitleModel mo847j() {
                return m16206n();
            }

            public VideoChannelModel() {
                super(9);
            }

            public VideoChannelModel(MutableFlatBuffer mutableFlatBuffer) {
                super(9);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m16211a(String str, ConsistencyTuple consistencyTuple) {
                if ("video_channel_is_viewer_pinned".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(mo846g());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 5;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m16212a(String str, Object obj, boolean z) {
                if ("video_channel_is_viewer_pinned".equals(str)) {
                    m16203a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            public final GraphQLObjectType m16218k() {
                if (this.b != null && this.f12964d == null) {
                    this.f12964d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12964d;
            }

            @Nullable
            public final String mo840b() {
                this.f12965e = super.a(this.f12965e, 1);
                return this.f12965e;
            }

            public final int mo841c() {
                a(0, 2);
                return this.f12966f;
            }

            @Nullable
            private SquareHeaderImageModel m16204l() {
                this.f12967g = (SquareHeaderImageModel) super.a(this.f12967g, 3, SquareHeaderImageModel.class);
                return this.f12967g;
            }

            public final boolean fe_() {
                a(0, 4);
                return this.f12968h;
            }

            public final boolean mo846g() {
                a(0, 5);
                return this.f12969i;
            }

            private void m16203a(boolean z) {
                this.f12969i = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 5, z);
                }
            }

            public final int ff_() {
                a(0, 6);
                return this.f12970j;
            }

            @Nullable
            private VideoChannelSubtitleModel m16205m() {
                this.f12971k = (VideoChannelSubtitleModel) super.a(this.f12971k, 7, VideoChannelSubtitleModel.class);
                return this.f12971k;
            }

            @Nullable
            private VideoChannelTitleModel m16206n() {
                this.f12972l = (VideoChannelTitleModel) super.a(this.f12972l, 8, VideoChannelTitleModel.class);
                return this.f12972l;
            }

            public static VideoChannelModel m16202a(VideoChannelModel videoChannelModel) {
                if (videoChannelModel == null) {
                    return null;
                }
                if (videoChannelModel instanceof VideoChannelModel) {
                    return videoChannelModel;
                }
                Builder builder = new Builder();
                builder.f12955a = videoChannelModel.m16218k();
                builder.f12956b = videoChannelModel.mo840b();
                builder.f12957c = videoChannelModel.mo841c();
                builder.f12958d = SquareHeaderImageModel.m18967a(videoChannelModel.mo842d());
                builder.f12959e = videoChannelModel.fe_();
                builder.f12960f = videoChannelModel.mo846g();
                builder.f12961g = videoChannelModel.ff_();
                builder.f12962h = VideoChannelSubtitleModel.m18974a(videoChannelModel.fg_());
                builder.f12963i = VideoChannelTitleModel.m18981a(videoChannelModel.mo847j());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12955a);
                int b = flatBufferBuilder.b(builder.f12956b);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f12958d);
                int a3 = ModelHelper.a(flatBufferBuilder, builder.f12962h);
                int a4 = ModelHelper.a(flatBufferBuilder, builder.f12963i);
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, builder.f12957c, 0);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.a(4, builder.f12959e);
                flatBufferBuilder.a(5, builder.f12960f);
                flatBufferBuilder.a(6, builder.f12961g, 0);
                flatBufferBuilder.b(7, a3);
                flatBufferBuilder.b(8, a4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new VideoChannelModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16209a() {
                return mo840b();
            }

            public final int jK_() {
                return 756114472;
            }

            public final GraphQLVisitableModel m16208a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16204l() != null) {
                    SquareHeaderImageModel squareHeaderImageModel = (SquareHeaderImageModel) graphQLModelMutatingVisitor.b(m16204l());
                    if (m16204l() != squareHeaderImageModel) {
                        graphQLVisitableModel = (VideoChannelModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12967g = squareHeaderImageModel;
                    }
                }
                if (m16205m() != null) {
                    VideoChannelSubtitleModel videoChannelSubtitleModel = (VideoChannelSubtitleModel) graphQLModelMutatingVisitor.b(m16205m());
                    if (m16205m() != videoChannelSubtitleModel) {
                        graphQLVisitableModel = (VideoChannelModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12971k = videoChannelSubtitleModel;
                    }
                }
                if (m16206n() != null) {
                    VideoChannelTitleModel videoChannelTitleModel = (VideoChannelTitleModel) graphQLModelMutatingVisitor.b(m16206n());
                    if (m16206n() != videoChannelTitleModel) {
                        graphQLVisitableModel = (VideoChannelModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12972l = videoChannelTitleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16207a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16218k());
                int b = flatBufferBuilder.b(mo840b());
                int a2 = ModelHelper.a(flatBufferBuilder, m16204l());
                int a3 = ModelHelper.a(flatBufferBuilder, m16205m());
                int a4 = ModelHelper.a(flatBufferBuilder, m16206n());
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f12966f, 0);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.a(4, this.f12968h);
                flatBufferBuilder.a(5, this.f12969i);
                flatBufferBuilder.a(6, this.f12970j, 0);
                flatBufferBuilder.b(7, a3);
                flatBufferBuilder.b(8, a4);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16210a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12966f = mutableFlatBuffer.a(i, 2, 0);
                this.f12968h = mutableFlatBuffer.a(i, 4);
                this.f12969i = mutableFlatBuffer.a(i, 5);
                this.f12970j = mutableFlatBuffer.a(i, 6, 0);
            }
        }

        public ReactionOpenVideoChannelFieldsModel() {
            super(1);
        }

        @Nullable
        private VideoChannelModel m16219a() {
            this.f12973d = (VideoChannelModel) super.a(this.f12973d, 0, VideoChannelModel.class);
            return this.f12973d;
        }

        public final int jK_() {
            return -303360527;
        }

        public final GraphQLVisitableModel m16221a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16219a() != null) {
                VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(m16219a());
                if (m16219a() != videoChannelModel) {
                    graphQLVisitableModel = (ReactionOpenVideoChannelFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12973d = videoChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16220a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16219a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 799302315)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionReplacementUnitFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionReplacementUnitFields {
        @Nullable
        private ReplacementUnitModel f13010d;
        @Nullable
        private String f13011e;

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionReplacementUnitFieldsModel.class, new Deserializer());
            }

            public Object m16222a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionReplacementUnitFieldsParser.m16586a(jsonParser);
                Object reactionReplacementUnitFieldsModel = new ReactionReplacementUnitFieldsModel();
                ((BaseModel) reactionReplacementUnitFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionReplacementUnitFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionReplacementUnitFieldsModel).a();
                }
                return reactionReplacementUnitFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1638188733)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class ReplacementUnitModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f13003d;
            @Nullable
            private String f13004e;
            @Nullable
            private List<ReactionUnitComponentsModel> f13005f;
            @Nullable
            private String f13006g;
            private int f13007h;
            @Nullable
            private GraphQLReactionUnitStyle f13008i;
            @Nullable
            private String f13009j;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f12974a;
                @Nullable
                public String f12975b;
                @Nullable
                public ImmutableList<ReactionUnitComponentsModel> f12976c;
                @Nullable
                public String f12977d;
                public int f12978e;
                @Nullable
                public GraphQLReactionUnitStyle f12979f;
                @Nullable
                public String f12980g;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReplacementUnitModel.class, new Deserializer());
                }

                public Object m16223a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReplacementUnitParser.m16584a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object replacementUnitModel = new ReplacementUnitModel();
                    ((BaseModel) replacementUnitModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (replacementUnitModel instanceof Postprocessable) {
                        return ((Postprocessable) replacementUnitModel).a();
                    }
                    return replacementUnitModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 75937543)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: field_icon */
            public final class ReactionUnitComponentsModel extends BaseModel implements GraphQLVisitableModel, ReactionUnitComponentBaseFields {
                @Nullable
                private GraphQLObjectType f12994d;
                @Nullable
                private ActionModel f12995e;
                private int f12996f;
                @Nullable
                private String f12997g;
                @Nullable
                private GraphQLReactionUnitComponentStyle f12998h;
                @Nullable
                private String f12999i;
                @Nullable
                private ReactionImageFieldsModel f13000j;
                @Nullable
                private DefaultTextWithEntitiesFieldsModel f13001k;
                @Nullable
                private DefaultTextWithEntitiesFieldsModel f13002l;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1414454120)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: field_icon */
                public final class ActionModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GraphQLObjectType f12983d;
                    @Nullable
                    private GraphQLReactionStoryActionStyle f12984e;

                    /* compiled from: field_icon */
                    public final class Builder {
                        @Nullable
                        public GraphQLObjectType f12981a;
                        @Nullable
                        public GraphQLReactionStoryActionStyle f12982b;
                    }

                    /* compiled from: field_icon */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ActionModel.class, new Deserializer());
                        }

                        public Object m16224a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ActionParser.m16579a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object actionModel = new ActionModel();
                            ((BaseModel) actionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (actionModel instanceof Postprocessable) {
                                return ((Postprocessable) actionModel).a();
                            }
                            return actionModel;
                        }
                    }

                    /* compiled from: field_icon */
                    public class Serializer extends JsonSerializer<ActionModel> {
                        public final void m16225a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ActionModel actionModel = (ActionModel) obj;
                            if (actionModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(actionModel.m16227a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                actionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ActionParser.m16580a(actionModel.w_(), actionModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ActionModel.class, new Serializer());
                        }
                    }

                    public ActionModel() {
                        super(2);
                    }

                    public ActionModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(2);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final GraphQLObjectType m16228a() {
                        if (this.b != null && this.f12983d == null) {
                            this.f12983d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f12983d;
                    }

                    @Nullable
                    public final GraphQLReactionStoryActionStyle m16230b() {
                        this.f12984e = (GraphQLReactionStoryActionStyle) super.b(this.f12984e, 1, GraphQLReactionStoryActionStyle.class, GraphQLReactionStoryActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f12984e;
                    }

                    public static ActionModel m16226a(ActionModel actionModel) {
                        if (actionModel == null) {
                            return null;
                        }
                        if (actionModel instanceof ActionModel) {
                            return actionModel;
                        }
                        Builder builder = new Builder();
                        builder.f12981a = actionModel.m16228a();
                        builder.f12982b = actionModel.m16230b();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, builder.f12981a);
                        int a2 = flatBufferBuilder.a(builder.f12982b);
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new ActionModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 1194715522;
                    }

                    public final GraphQLVisitableModel m16229a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m16227a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m16228a());
                        int a2 = flatBufferBuilder.a(m16230b());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: field_icon */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f12985a;
                    @Nullable
                    public ActionModel f12986b;
                    public int f12987c;
                    @Nullable
                    public String f12988d;
                    @Nullable
                    public GraphQLReactionUnitComponentStyle f12989e;
                    @Nullable
                    public String f12990f;
                    @Nullable
                    public ReactionImageFieldsModel f12991g;
                    @Nullable
                    public DefaultTextWithEntitiesFieldsModel f12992h;
                    @Nullable
                    public DefaultTextWithEntitiesFieldsModel f12993i;
                }

                /* compiled from: field_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ReactionUnitComponentsModel.class, new Deserializer());
                    }

                    public Object m16231a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ReactionUnitComponentsParser.m16582b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object reactionUnitComponentsModel = new ReactionUnitComponentsModel();
                        ((BaseModel) reactionUnitComponentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (reactionUnitComponentsModel instanceof Postprocessable) {
                            return ((Postprocessable) reactionUnitComponentsModel).a();
                        }
                        return reactionUnitComponentsModel;
                    }
                }

                /* compiled from: field_icon */
                public class Serializer extends JsonSerializer<ReactionUnitComponentsModel> {
                    public final void m16232a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ReactionUnitComponentsModel reactionUnitComponentsModel = (ReactionUnitComponentsModel) obj;
                        if (reactionUnitComponentsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(reactionUnitComponentsModel.m16238a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            reactionUnitComponentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ReactionUnitComponentsParser.m16583b(reactionUnitComponentsModel.w_(), reactionUnitComponentsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ReactionUnitComponentsModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ActionModel m16243c() {
                    return m16234k();
                }

                @Nullable
                public final /* synthetic */ DefaultTextWithEntitiesFields fQ_() {
                    return m16236m();
                }

                @Nullable
                public final /* synthetic */ ReactionImageFields fR_() {
                    return m16235l();
                }

                @Nullable
                public final /* synthetic */ DefaultTextWithEntitiesFields m16246j() {
                    return m16237n();
                }

                public ReactionUnitComponentsModel() {
                    super(9);
                }

                public ReactionUnitComponentsModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(9);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final GraphQLObjectType m16242b() {
                    if (this.b != null && this.f12994d == null) {
                        this.f12994d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f12994d;
                }

                @Nullable
                private ActionModel m16234k() {
                    this.f12995e = (ActionModel) super.a(this.f12995e, 1, ActionModel.class);
                    return this.f12995e;
                }

                public final int m16244d() {
                    a(0, 2);
                    return this.f12996f;
                }

                @Nullable
                public final String fP_() {
                    this.f12997g = super.a(this.f12997g, 3);
                    return this.f12997g;
                }

                @Nullable
                public final GraphQLReactionUnitComponentStyle mo848a() {
                    this.f12998h = (GraphQLReactionUnitComponentStyle) super.b(this.f12998h, 4, GraphQLReactionUnitComponentStyle.class, GraphQLReactionUnitComponentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f12998h;
                }

                @Nullable
                public final String m16245g() {
                    this.f12999i = super.a(this.f12999i, 5);
                    return this.f12999i;
                }

                @Nullable
                private ReactionImageFieldsModel m16235l() {
                    this.f13000j = (ReactionImageFieldsModel) super.a(this.f13000j, 6, ReactionImageFieldsModel.class);
                    return this.f13000j;
                }

                @Nullable
                private DefaultTextWithEntitiesFieldsModel m16236m() {
                    this.f13001k = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13001k, 7, DefaultTextWithEntitiesFieldsModel.class);
                    return this.f13001k;
                }

                @Nullable
                private DefaultTextWithEntitiesFieldsModel m16237n() {
                    this.f13002l = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13002l, 8, DefaultTextWithEntitiesFieldsModel.class);
                    return this.f13002l;
                }

                public static ReactionUnitComponentsModel m16233a(ReactionUnitComponentsModel reactionUnitComponentsModel) {
                    if (reactionUnitComponentsModel == null) {
                        return null;
                    }
                    if (reactionUnitComponentsModel instanceof ReactionUnitComponentsModel) {
                        return reactionUnitComponentsModel;
                    }
                    Builder builder = new Builder();
                    builder.f12985a = reactionUnitComponentsModel.m16242b();
                    builder.f12986b = ActionModel.m16226a(reactionUnitComponentsModel.m16243c());
                    builder.f12987c = reactionUnitComponentsModel.m16244d();
                    builder.f12988d = reactionUnitComponentsModel.fP_();
                    builder.f12989e = reactionUnitComponentsModel.mo848a();
                    builder.f12990f = reactionUnitComponentsModel.m16245g();
                    builder.f12991g = ReactionImageFieldsModel.m14497a(reactionUnitComponentsModel.fR_());
                    builder.f12992h = DefaultTextWithEntitiesFieldsModel.a(reactionUnitComponentsModel.fQ_());
                    builder.f12993i = DefaultTextWithEntitiesFieldsModel.a(reactionUnitComponentsModel.m16246j());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f12985a);
                    int a2 = ModelHelper.a(flatBufferBuilder, builder.f12986b);
                    int b = flatBufferBuilder.b(builder.f12988d);
                    int a3 = flatBufferBuilder.a(builder.f12989e);
                    int b2 = flatBufferBuilder.b(builder.f12990f);
                    int a4 = ModelHelper.a(flatBufferBuilder, builder.f12991g);
                    int a5 = ModelHelper.a(flatBufferBuilder, builder.f12992h);
                    int a6 = ModelHelper.a(flatBufferBuilder, builder.f12993i);
                    flatBufferBuilder.c(9);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.a(2, builder.f12987c, 0);
                    flatBufferBuilder.b(3, b);
                    flatBufferBuilder.b(4, a3);
                    flatBufferBuilder.b(5, b2);
                    flatBufferBuilder.b(6, a4);
                    flatBufferBuilder.b(7, a5);
                    flatBufferBuilder.b(8, a6);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ReactionUnitComponentsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -637925360;
                }

                public final GraphQLVisitableModel m16240a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m16234k() != null) {
                        ActionModel actionModel = (ActionModel) graphQLModelMutatingVisitor.b(m16234k());
                        if (m16234k() != actionModel) {
                            graphQLVisitableModel = (ReactionUnitComponentsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12995e = actionModel;
                        }
                    }
                    if (m16235l() != null) {
                        ReactionImageFieldsModel reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(m16235l());
                        if (m16235l() != reactionImageFieldsModel) {
                            graphQLVisitableModel = (ReactionUnitComponentsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13000j = reactionImageFieldsModel;
                        }
                    }
                    if (m16236m() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m16236m());
                        if (m16236m() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionUnitComponentsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13001k = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (m16237n() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m16237n());
                        if (m16237n() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (ReactionUnitComponentsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13002l = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m16238a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m16242b());
                    int a2 = ModelHelper.a(flatBufferBuilder, m16234k());
                    int b = flatBufferBuilder.b(fP_());
                    int a3 = flatBufferBuilder.a(mo848a());
                    int b2 = flatBufferBuilder.b(m16245g());
                    int a4 = ModelHelper.a(flatBufferBuilder, m16235l());
                    int a5 = ModelHelper.a(flatBufferBuilder, m16236m());
                    int a6 = ModelHelper.a(flatBufferBuilder, m16237n());
                    flatBufferBuilder.c(9);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.a(2, this.f12996f, 0);
                    flatBufferBuilder.b(3, b);
                    flatBufferBuilder.b(4, a3);
                    flatBufferBuilder.b(5, b2);
                    flatBufferBuilder.b(6, a4);
                    flatBufferBuilder.b(7, a5);
                    flatBufferBuilder.b(8, a6);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16241a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f12996f = mutableFlatBuffer.a(i, 2, 0);
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<ReplacementUnitModel> {
                public final void m16247a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReplacementUnitModel replacementUnitModel = (ReplacementUnitModel) obj;
                    if (replacementUnitModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(replacementUnitModel.m16249a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        replacementUnitModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReplacementUnitParser.m16585a(replacementUnitModel.w_(), replacementUnitModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReplacementUnitModel.class, new Serializer());
                }
            }

            public ReplacementUnitModel() {
                super(7);
            }

            public ReplacementUnitModel(MutableFlatBuffer mutableFlatBuffer) {
                super(7);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final GraphQLObjectType m16253b() {
                if (this.b != null && this.f13003d == null) {
                    this.f13003d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f13003d;
            }

            @Nullable
            public final String m16254c() {
                this.f13004e = super.a(this.f13004e, 1);
                return this.f13004e;
            }

            @Nonnull
            public final ImmutableList<ReactionUnitComponentsModel> m16255d() {
                this.f13005f = super.a(this.f13005f, 2, ReactionUnitComponentsModel.class);
                return (ImmutableList) this.f13005f;
            }

            @Nullable
            public final String fM_() {
                this.f13006g = super.a(this.f13006g, 3);
                return this.f13006g;
            }

            public final int m16256g() {
                a(0, 4);
                return this.f13007h;
            }

            @Nullable
            public final GraphQLReactionUnitStyle fN_() {
                this.f13008i = (GraphQLReactionUnitStyle) super.b(this.f13008i, 5, GraphQLReactionUnitStyle.class, GraphQLReactionUnitStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f13008i;
            }

            @Nullable
            public final String fO_() {
                this.f13009j = super.a(this.f13009j, 6);
                return this.f13009j;
            }

            public static ReplacementUnitModel m16248a(ReplacementUnitModel replacementUnitModel) {
                if (replacementUnitModel == null) {
                    return null;
                }
                if (replacementUnitModel instanceof ReplacementUnitModel) {
                    return replacementUnitModel;
                }
                Builder builder = new Builder();
                builder.f12974a = replacementUnitModel.m16253b();
                builder.f12975b = replacementUnitModel.m16254c();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < replacementUnitModel.m16255d().size(); i++) {
                    builder2.c(ReactionUnitComponentsModel.m16233a((ReactionUnitComponentsModel) replacementUnitModel.m16255d().get(i)));
                }
                builder.f12976c = builder2.b();
                builder.f12977d = replacementUnitModel.fM_();
                builder.f12978e = replacementUnitModel.m16256g();
                builder.f12979f = replacementUnitModel.fN_();
                builder.f12980g = replacementUnitModel.fO_();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12974a);
                int b = flatBufferBuilder.b(builder.f12975b);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f12976c);
                int b2 = flatBufferBuilder.b(builder.f12977d);
                int a3 = flatBufferBuilder.a(builder.f12979f);
                int b3 = flatBufferBuilder.b(builder.f12980g);
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.a(4, builder.f12978e, 0);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, b3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReplacementUnitModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16251a() {
                return m16254c();
            }

            public final int jK_() {
                return -1551679635;
            }

            public final GraphQLVisitableModel m16250a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16255d() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m16255d(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ReplacementUnitModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13005f = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16249a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16253b());
                int b = flatBufferBuilder.b(m16254c());
                int a2 = ModelHelper.a(flatBufferBuilder, m16255d());
                int b2 = flatBufferBuilder.b(fM_());
                int a3 = flatBufferBuilder.a(fN_());
                int b3 = flatBufferBuilder.b(fO_());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.a(4, this.f13007h, 0);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, b3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16252a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f13007h = mutableFlatBuffer.a(i, 4, 0);
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionReplacementUnitFieldsModel> {
            public final void m16257a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionReplacementUnitFieldsModel reactionReplacementUnitFieldsModel = (ReactionReplacementUnitFieldsModel) obj;
                if (reactionReplacementUnitFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionReplacementUnitFieldsModel.m16260a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionReplacementUnitFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionReplacementUnitFieldsModel.w_();
                int u_ = reactionReplacementUnitFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("replacement_unit");
                    ReplacementUnitParser.m16585a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("settings_token_for_reload");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionReplacementUnitFieldsModel.class, new Serializer());
            }
        }

        public ReactionReplacementUnitFieldsModel() {
            super(2);
        }

        @Nullable
        private ReplacementUnitModel m16258a() {
            this.f13010d = (ReplacementUnitModel) super.a(this.f13010d, 0, ReplacementUnitModel.class);
            return this.f13010d;
        }

        @Nullable
        private String m16259j() {
            this.f13011e = super.a(this.f13011e, 1);
            return this.f13011e;
        }

        public final int jK_() {
            return -1032414238;
        }

        public final GraphQLVisitableModel m16261a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16258a() != null) {
                ReplacementUnitModel replacementUnitModel = (ReplacementUnitModel) graphQLModelMutatingVisitor.b(m16258a());
                if (m16258a() != replacementUnitModel) {
                    graphQLVisitableModel = (ReactionReplacementUnitFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13010d = replacementUnitModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16260a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16258a());
            int b = flatBufferBuilder.b(m16259j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 684601280)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionSeePageCommerceProductsFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionSeePageCommerceProductsFields {
        @Nullable
        private CollectionModel f13014d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class CollectionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f13013d;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f13012a;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CollectionModel.class, new Deserializer());
                }

                public Object m16262a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CollectionParser.m16587a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object collectionModel = new CollectionModel();
                    ((BaseModel) collectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (collectionModel instanceof Postprocessable) {
                        return ((Postprocessable) collectionModel).a();
                    }
                    return collectionModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<CollectionModel> {
                public final void m16263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CollectionModel collectionModel = (CollectionModel) obj;
                    if (collectionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(collectionModel.m16265a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        collectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CollectionParser.m16588a(collectionModel.w_(), collectionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CollectionModel.class, new Serializer());
                }
            }

            public CollectionModel() {
                super(1);
            }

            public CollectionModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m16268b() {
                this.f13013d = super.a(this.f13013d, 0);
                return this.f13013d;
            }

            public static CollectionModel m16264a(CollectionModel collectionModel) {
                if (collectionModel == null) {
                    return null;
                }
                if (collectionModel instanceof CollectionModel) {
                    return collectionModel;
                }
                Builder builder = new Builder();
                builder.f13012a = collectionModel.m16268b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f13012a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CollectionModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16267a() {
                return m16268b();
            }

            public final int jK_() {
                return -1187196444;
            }

            public final GraphQLVisitableModel m16266a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16265a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16268b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionSeePageCommerceProductsFieldsModel.class, new Deserializer());
            }

            public Object m16269a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionSeePageCommerceProductsFieldsParser.m16589a(jsonParser);
                Object reactionSeePageCommerceProductsFieldsModel = new ReactionSeePageCommerceProductsFieldsModel();
                ((BaseModel) reactionSeePageCommerceProductsFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionSeePageCommerceProductsFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionSeePageCommerceProductsFieldsModel).a();
                }
                return reactionSeePageCommerceProductsFieldsModel;
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionSeePageCommerceProductsFieldsModel> {
            public final void m16270a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionSeePageCommerceProductsFieldsModel reactionSeePageCommerceProductsFieldsModel = (ReactionSeePageCommerceProductsFieldsModel) obj;
                if (reactionSeePageCommerceProductsFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionSeePageCommerceProductsFieldsModel.m16272a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionSeePageCommerceProductsFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionSeePageCommerceProductsFieldsModel.w_();
                int u_ = reactionSeePageCommerceProductsFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("collection");
                    CollectionParser.m16588a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionSeePageCommerceProductsFieldsModel.class, new Serializer());
            }
        }

        public ReactionSeePageCommerceProductsFieldsModel() {
            super(1);
        }

        @Nullable
        private CollectionModel m16271a() {
            this.f13014d = (CollectionModel) super.a(this.f13014d, 0, CollectionModel.class);
            return this.f13014d;
        }

        public final int jK_() {
            return -275476786;
        }

        public final GraphQLVisitableModel m16273a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16271a() != null) {
                CollectionModel collectionModel = (CollectionModel) graphQLModelMutatingVisitor.b(m16271a());
                if (m16271a() != collectionModel) {
                    graphQLVisitableModel = (ReactionSeePageCommerceProductsFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13014d = collectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16272a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16271a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 901912178)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionSendMessageAsPageFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionSendMessageAsPageFields {
        @Nullable
        private ThreadKeyModel f13017d;

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionSendMessageAsPageFieldsModel.class, new Deserializer());
            }

            public Object m16274a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionSendMessageAsPageFieldsParser.m16592a(jsonParser);
                Object reactionSendMessageAsPageFieldsModel = new ReactionSendMessageAsPageFieldsModel();
                ((BaseModel) reactionSendMessageAsPageFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionSendMessageAsPageFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionSendMessageAsPageFieldsModel).a();
                }
                return reactionSendMessageAsPageFieldsModel;
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionSendMessageAsPageFieldsModel> {
            public final void m16275a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionSendMessageAsPageFieldsModel reactionSendMessageAsPageFieldsModel = (ReactionSendMessageAsPageFieldsModel) obj;
                if (reactionSendMessageAsPageFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionSendMessageAsPageFieldsModel.m16283a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionSendMessageAsPageFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionSendMessageAsPageFieldsModel.w_();
                int u_ = reactionSendMessageAsPageFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("thread_key");
                    ThreadKeyParser.m16591a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionSendMessageAsPageFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -428743621)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class ThreadKeyModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13016d;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f13015a;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ThreadKeyModel.class, new Deserializer());
                }

                public Object m16276a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThreadKeyParser.m16590a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object threadKeyModel = new ThreadKeyModel();
                    ((BaseModel) threadKeyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (threadKeyModel instanceof Postprocessable) {
                        return ((Postprocessable) threadKeyModel).a();
                    }
                    return threadKeyModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<ThreadKeyModel> {
                public final void m16277a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ThreadKeyModel threadKeyModel = (ThreadKeyModel) obj;
                    if (threadKeyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(threadKeyModel.m16279a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        threadKeyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThreadKeyParser.m16591a(threadKeyModel.w_(), threadKeyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ThreadKeyModel.class, new Serializer());
                }
            }

            public ThreadKeyModel() {
                super(1);
            }

            public ThreadKeyModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m16281a() {
                this.f13016d = super.a(this.f13016d, 0);
                return this.f13016d;
            }

            public static ThreadKeyModel m16278a(ThreadKeyModel threadKeyModel) {
                if (threadKeyModel == null) {
                    return null;
                }
                if (threadKeyModel instanceof ThreadKeyModel) {
                    return threadKeyModel;
                }
                Builder builder = new Builder();
                builder.f13015a = threadKeyModel.m16281a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f13015a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ThreadKeyModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 898588622;
            }

            public final GraphQLVisitableModel m16280a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16279a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16281a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ReactionSendMessageAsPageFieldsModel() {
            super(1);
        }

        @Nullable
        private ThreadKeyModel m16282a() {
            this.f13017d = (ThreadKeyModel) super.a(this.f13017d, 0, ThreadKeyModel.class);
            return this.f13017d;
        }

        public final int jK_() {
            return -1803629587;
        }

        public final GraphQLVisitableModel m16284a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16282a() != null) {
                ThreadKeyModel threadKeyModel = (ThreadKeyModel) graphQLModelMutatingVisitor.b(m16282a());
                if (m16282a() != threadKeyModel) {
                    graphQLVisitableModel = (ReactionSendMessageAsPageFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13017d = threadKeyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16283a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16282a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1484116857)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionStoriesActionFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionStoriesActionFields {
        @Nullable
        private List<StoriesModel> f13020d;

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionStoriesActionFieldsModel.class, new Deserializer());
            }

            public Object m16285a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionStoriesActionFieldsParser.m16597a(jsonParser);
                Object reactionStoriesActionFieldsModel = new ReactionStoriesActionFieldsModel();
                ((BaseModel) reactionStoriesActionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionStoriesActionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionStoriesActionFieldsModel).a();
                }
                return reactionStoriesActionFieldsModel;
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionStoriesActionFieldsModel> {
            public final void m16286a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionStoriesActionFieldsModel reactionStoriesActionFieldsModel = (ReactionStoriesActionFieldsModel) obj;
                if (reactionStoriesActionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionStoriesActionFieldsModel.m16297a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionStoriesActionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionStoriesActionFieldsModel.w_();
                int u_ = reactionStoriesActionFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("stories");
                    StoriesParser.m16594a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionStoriesActionFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1782327613)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class StoriesModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private ReactionFeedbackFieldsModel f13019d;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public ReactionFeedbackFieldsModel f13018a;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StoriesModel.class, new Deserializer());
                }

                public Object m16287a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StoriesParser.m16595b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object storiesModel = new StoriesModel();
                    ((BaseModel) storiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (storiesModel instanceof Postprocessable) {
                        return ((Postprocessable) storiesModel).a();
                    }
                    return storiesModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<StoriesModel> {
                public final void m16288a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StoriesModel storiesModel = (StoriesModel) obj;
                    if (storiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(storiesModel.m16291a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        storiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StoriesParser.m16596b(storiesModel.w_(), storiesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StoriesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ReactionFeedbackFieldsModel m16293a() {
                return m16290j();
            }

            public StoriesModel() {
                super(1);
            }

            public StoriesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m16294a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16295a(String str, Object obj, boolean z) {
            }

            @Nullable
            private ReactionFeedbackFieldsModel m16290j() {
                this.f13019d = (ReactionFeedbackFieldsModel) super.a(this.f13019d, 0, ReactionFeedbackFieldsModel.class);
                return this.f13019d;
            }

            public static StoriesModel m16289a(StoriesModel storiesModel) {
                if (storiesModel == null) {
                    return null;
                }
                if (storiesModel instanceof StoriesModel) {
                    return storiesModel;
                }
                Builder builder = new Builder();
                builder.f13018a = ReactionFeedbackFieldsModel.m14471a(storiesModel.m16293a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f13018a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new StoriesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m16292a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16290j() != null) {
                    ReactionFeedbackFieldsModel reactionFeedbackFieldsModel = (ReactionFeedbackFieldsModel) graphQLModelMutatingVisitor.b(m16290j());
                    if (m16290j() != reactionFeedbackFieldsModel) {
                        graphQLVisitableModel = (StoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13019d = reactionFeedbackFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16291a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16290j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ReactionStoriesActionFieldsModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<StoriesModel> m16296a() {
            this.f13020d = super.a(this.f13020d, 0, StoriesModel.class);
            return (ImmutableList) this.f13020d;
        }

        public final int jK_() {
            return -1820691044;
        }

        public final GraphQLVisitableModel m16298a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16296a() != null) {
                Builder a = ModelHelper.a(m16296a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ReactionStoriesActionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13020d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16297a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16296a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1289265965)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionStoryAttachmentActionCommonFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionStoryAttachmentActionCommonFragment {
        @Nullable
        private FundraiserModel f13073A;
        @Nullable
        private FundraiserCampaignModel f13074B;
        @Nullable
        private GroupModel f13075C;
        @Nullable
        private GraphQLEventWatchStatus f13076D;
        @Nullable
        private DefaultLocationFieldsModel f13077E;
        @Nullable
        private MatchPageModel f13078F;
        @Nullable
        private GraphQLNearbyFriendsNuxType f13079G;
        @Nullable
        private PageModel f13080H;
        @Nullable
        private String f13081I;
        @Nullable
        private GraphQLPagePhotoSourceType f13082J;
        @Nullable
        private String f13083K;
        @Nullable
        private PlacesQueryLocationPageModel f13084L;
        @Nullable
        private String f13085M;
        @Nullable
        private String f13086N;
        @Nullable
        private ProfileModel f13087O;
        @Nullable
        private String f13088P;
        @Nullable
        private String f13089Q;
        @Nullable
        private List<RelatedUsersModel> f13090R;
        @Nullable
        private ReplacementUnitModel f13091S;
        @Nullable
        private PageServiceItemModel f13092T;
        @Nullable
        private String f13093U;
        @Nullable
        private String f13094V;
        @Nullable
        private String f13095W;
        @Nullable
        private StoryModel f13096X;
        private boolean f13097Y;
        @Nullable
        private String f13098Z;
        @Nullable
        private ReactionEventInviteFieldsModel aa;
        @Nullable
        private String ab;
        @Nullable
        private ThreadKeyModel ac;
        @Nullable
        private String ad;
        @Nullable
        private String ae;
        @Nullable
        private VideoChannelModel af;
        @Nullable
        private GraphQLObjectType f13099d;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f13100e;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f13101f;
        @Nullable
        private ReactionImageFieldsModel f13102g;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f13103h;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f13104i;
        private boolean f13105j;
        @Nullable
        private ActionOgObjectModel f13106k;
        @Nullable
        private GraphQLReactionStoryActionStyle f13107l;
        @Nullable
        private AlbumModel f13108m;
        private boolean f13109n;
        @Nullable
        private CollectionModel f13110o;
        @Nullable
        private CommentModel f13111p;
        @Nullable
        private String f13112q;
        @Nullable
        private ComposerInlineActivityModel f13113r;
        @Nullable
        private GraphQLFundraiserSupportersConnectionType f13114s;
        @Nullable
        private String f13115t;
        @Nullable
        private GraphQLPhotosByCategoryEntryPoint f13116u;
        @Nullable
        private EventModel f13117v;
        @Nullable
        private EventSpaceModel f13118w;
        @Nullable
        private List<ReactionWeatherSettingsPlaceItemFragmentModel> f13119x;
        @Nullable
        private FriendModel f13120y;
        @Nullable
        private String f13121z;

        /* compiled from: field_icon */
        public final class Builder {
            @Nullable
            public GraphQLEventWatchStatus f13021A;
            @Nullable
            public DefaultLocationFieldsModel f13022B;
            @Nullable
            public MatchPageModel f13023C;
            @Nullable
            public GraphQLNearbyFriendsNuxType f13024D;
            @Nullable
            public PageModel f13025E;
            @Nullable
            public String f13026F;
            @Nullable
            public GraphQLPagePhotoSourceType f13027G;
            @Nullable
            public String f13028H;
            @Nullable
            public PlacesQueryLocationPageModel f13029I;
            @Nullable
            public String f13030J;
            @Nullable
            public String f13031K;
            @Nullable
            public ProfileModel f13032L;
            @Nullable
            public String f13033M;
            @Nullable
            public String f13034N;
            @Nullable
            public ImmutableList<RelatedUsersModel> f13035O;
            @Nullable
            public ReplacementUnitModel f13036P;
            @Nullable
            public PageServiceItemModel f13037Q;
            @Nullable
            public String f13038R;
            @Nullable
            public String f13039S;
            @Nullable
            public String f13040T;
            @Nullable
            public StoryModel f13041U;
            public boolean f13042V;
            @Nullable
            public String f13043W;
            @Nullable
            public ReactionEventInviteFieldsModel f13044X;
            @Nullable
            public String f13045Y;
            @Nullable
            public ThreadKeyModel f13046Z;
            @Nullable
            public GraphQLObjectType f13047a;
            @Nullable
            public String aa;
            @Nullable
            public String ab;
            @Nullable
            public VideoChannelModel ac;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f13048b;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f13049c;
            @Nullable
            public ReactionImageFieldsModel f13050d;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f13051e;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f13052f;
            public boolean f13053g;
            @Nullable
            public ActionOgObjectModel f13054h;
            @Nullable
            public GraphQLReactionStoryActionStyle f13055i;
            @Nullable
            public AlbumModel f13056j;
            public boolean f13057k;
            @Nullable
            public CollectionModel f13058l;
            @Nullable
            public CommentModel f13059m;
            @Nullable
            public String f13060n;
            @Nullable
            public ComposerInlineActivityModel f13061o;
            @Nullable
            public GraphQLFundraiserSupportersConnectionType f13062p;
            @Nullable
            public String f13063q;
            @Nullable
            public GraphQLPhotosByCategoryEntryPoint f13064r;
            @Nullable
            public EventModel f13065s;
            @Nullable
            public EventSpaceModel f13066t;
            @Nullable
            public ImmutableList<ReactionWeatherSettingsPlaceItemFragmentModel> f13067u;
            @Nullable
            public FriendModel f13068v;
            @Nullable
            public String f13069w;
            @Nullable
            public FundraiserModel f13070x;
            @Nullable
            public FundraiserCampaignModel f13071y;
            @Nullable
            public GroupModel f13072z;

            public final ReactionStoryAttachmentActionCommonFragmentModel m16299a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f13047a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f13048b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f13049c);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f13050d);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f13051e);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f13052f);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f13054h);
                int a8 = flatBufferBuilder.a(this.f13055i);
                int a9 = ModelHelper.a(flatBufferBuilder, this.f13056j);
                int a10 = ModelHelper.a(flatBufferBuilder, this.f13058l);
                int a11 = ModelHelper.a(flatBufferBuilder, this.f13059m);
                int b = flatBufferBuilder.b(this.f13060n);
                int a12 = ModelHelper.a(flatBufferBuilder, this.f13061o);
                int a13 = flatBufferBuilder.a(this.f13062p);
                int b2 = flatBufferBuilder.b(this.f13063q);
                int a14 = flatBufferBuilder.a(this.f13064r);
                int a15 = ModelHelper.a(flatBufferBuilder, this.f13065s);
                int a16 = ModelHelper.a(flatBufferBuilder, this.f13066t);
                int a17 = ModelHelper.a(flatBufferBuilder, this.f13067u);
                int a18 = ModelHelper.a(flatBufferBuilder, this.f13068v);
                int b3 = flatBufferBuilder.b(this.f13069w);
                int a19 = ModelHelper.a(flatBufferBuilder, this.f13070x);
                int a20 = ModelHelper.a(flatBufferBuilder, this.f13071y);
                int a21 = ModelHelper.a(flatBufferBuilder, this.f13072z);
                int a22 = flatBufferBuilder.a(this.f13021A);
                int a23 = ModelHelper.a(flatBufferBuilder, this.f13022B);
                int a24 = ModelHelper.a(flatBufferBuilder, this.f13023C);
                int a25 = flatBufferBuilder.a(this.f13024D);
                int a26 = ModelHelper.a(flatBufferBuilder, this.f13025E);
                int b4 = flatBufferBuilder.b(this.f13026F);
                int a27 = flatBufferBuilder.a(this.f13027G);
                int b5 = flatBufferBuilder.b(this.f13028H);
                int a28 = ModelHelper.a(flatBufferBuilder, this.f13029I);
                int b6 = flatBufferBuilder.b(this.f13030J);
                int b7 = flatBufferBuilder.b(this.f13031K);
                int a29 = ModelHelper.a(flatBufferBuilder, this.f13032L);
                int b8 = flatBufferBuilder.b(this.f13033M);
                int b9 = flatBufferBuilder.b(this.f13034N);
                int a30 = ModelHelper.a(flatBufferBuilder, this.f13035O);
                int a31 = ModelHelper.a(flatBufferBuilder, this.f13036P);
                int a32 = ModelHelper.a(flatBufferBuilder, this.f13037Q);
                int b10 = flatBufferBuilder.b(this.f13038R);
                int b11 = flatBufferBuilder.b(this.f13039S);
                int b12 = flatBufferBuilder.b(this.f13040T);
                int a33 = ModelHelper.a(flatBufferBuilder, this.f13041U);
                int b13 = flatBufferBuilder.b(this.f13043W);
                int a34 = ModelHelper.a(flatBufferBuilder, this.f13044X);
                int b14 = flatBufferBuilder.b(this.f13045Y);
                int a35 = ModelHelper.a(flatBufferBuilder, this.f13046Z);
                int b15 = flatBufferBuilder.b(this.aa);
                int b16 = flatBufferBuilder.b(this.ab);
                int a36 = ModelHelper.a(flatBufferBuilder, this.ac);
                flatBufferBuilder.c(55);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, a5);
                flatBufferBuilder.b(5, a6);
                flatBufferBuilder.a(6, this.f13053g);
                flatBufferBuilder.b(7, a7);
                flatBufferBuilder.b(8, a8);
                flatBufferBuilder.b(9, a9);
                flatBufferBuilder.a(10, this.f13057k);
                flatBufferBuilder.b(11, a10);
                flatBufferBuilder.b(12, a11);
                flatBufferBuilder.b(13, b);
                flatBufferBuilder.b(14, a12);
                flatBufferBuilder.b(15, a13);
                flatBufferBuilder.b(16, b2);
                flatBufferBuilder.b(17, a14);
                flatBufferBuilder.b(18, a15);
                flatBufferBuilder.b(19, a16);
                flatBufferBuilder.b(20, a17);
                flatBufferBuilder.b(21, a18);
                flatBufferBuilder.b(22, b3);
                flatBufferBuilder.b(23, a19);
                flatBufferBuilder.b(24, a20);
                flatBufferBuilder.b(25, a21);
                flatBufferBuilder.b(26, a22);
                flatBufferBuilder.b(27, a23);
                flatBufferBuilder.b(28, a24);
                flatBufferBuilder.b(29, a25);
                flatBufferBuilder.b(30, a26);
                flatBufferBuilder.b(31, b4);
                flatBufferBuilder.b(32, a27);
                flatBufferBuilder.b(33, b5);
                flatBufferBuilder.b(34, a28);
                flatBufferBuilder.b(35, b6);
                flatBufferBuilder.b(36, b7);
                flatBufferBuilder.b(37, a29);
                flatBufferBuilder.b(38, b8);
                flatBufferBuilder.b(39, b9);
                flatBufferBuilder.b(40, a30);
                flatBufferBuilder.b(41, a31);
                flatBufferBuilder.b(42, a32);
                flatBufferBuilder.b(43, b10);
                flatBufferBuilder.b(44, b11);
                flatBufferBuilder.b(45, b12);
                flatBufferBuilder.b(46, a33);
                flatBufferBuilder.a(47, this.f13042V);
                flatBufferBuilder.b(48, b13);
                flatBufferBuilder.b(49, a34);
                flatBufferBuilder.b(50, b14);
                flatBufferBuilder.b(51, a35);
                flatBufferBuilder.b(52, b15);
                flatBufferBuilder.b(53, b16);
                flatBufferBuilder.b(54, a36);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReactionStoryAttachmentActionCommonFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionStoryAttachmentActionCommonFragmentModel.class, new Deserializer());
            }

            public Object m16300a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionStoryAttachmentActionCommonFragmentParser.m16599b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionStoryAttachmentActionCommonFragmentModel = new ReactionStoryAttachmentActionCommonFragmentModel();
                ((BaseModel) reactionStoryAttachmentActionCommonFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionStoryAttachmentActionCommonFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionStoryAttachmentActionCommonFragmentModel).a();
                }
                return reactionStoryAttachmentActionCommonFragmentModel;
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionStoryAttachmentActionCommonFragmentModel> {
            public final void m16301a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionStoryAttachmentActionCommonFragmentModel reactionStoryAttachmentActionCommonFragmentModel = (ReactionStoryAttachmentActionCommonFragmentModel) obj;
                if (reactionStoryAttachmentActionCommonFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionStoryAttachmentActionCommonFragmentModel.m16329a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionStoryAttachmentActionCommonFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionStoryAttachmentActionCommonFragmentParser.m16600b(reactionStoryAttachmentActionCommonFragmentModel.w_(), reactionStoryAttachmentActionCommonFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionStoryAttachmentActionCommonFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ GroupModel mo849A() {
            return at();
        }

        @Nullable
        public final /* synthetic */ DefaultLocationFields mo851C() {
            return au();
        }

        @Nullable
        public final /* synthetic */ MatchPageModel mo852D() {
            return av();
        }

        @Nullable
        public final /* synthetic */ PageModel mo854F() {
            return aw();
        }

        @Nullable
        public final /* synthetic */ PlacesQueryLocationPageModel mo858J() {
            return ax();
        }

        @Nullable
        public final /* synthetic */ ProfileModel mo861M() {
            return ay();
        }

        @Nullable
        public final /* synthetic */ ReplacementUnitModel mo865Q() {
            return az();
        }

        @Nullable
        public final /* synthetic */ PageServiceItemModel mo866R() {
            return aA();
        }

        @Nullable
        public final /* synthetic */ StoryModel mo870V() {
            return aB();
        }

        @Nullable
        public final /* synthetic */ ReactionEventInviteFieldsModel mo873Y() {
            return aC();
        }

        @Nullable
        public final /* synthetic */ ThreadKeyModel aa() {
            return aD();
        }

        @Nullable
        public final /* synthetic */ VideoChannelModel ad() {
            return aE();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields mo880b() {
            return ae();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields mo881c() {
            return af();
        }

        @Nullable
        public final /* synthetic */ ReactionImageFields mo882d() {
            return ag();
        }

        @Nullable
        public final /* synthetic */ ActionOgObjectModel fT_() {
            return aj();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields fU_() {
            return ah();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields mo886g() {
            return ai();
        }

        @Nullable
        public final /* synthetic */ AlbumModel mo888k() {
            return ak();
        }

        @Nullable
        public final /* synthetic */ CollectionModel mo890m() {
            return al();
        }

        @Nullable
        public final /* synthetic */ CommentModel mo891n() {
            return am();
        }

        @Nullable
        public final /* synthetic */ ComposerInlineActivityModel mo893p() {
            return an();
        }

        @Nullable
        public final /* synthetic */ EventModel mo897t() {
            return ao();
        }

        @Nullable
        public final /* synthetic */ EventSpaceModel mo898u() {
            return ap();
        }

        @Nullable
        public final /* synthetic */ FriendModel mo900w() {
            return aq();
        }

        @Nullable
        public final /* synthetic */ FundraiserModel mo902y() {
            return ar();
        }

        @Nullable
        public final /* synthetic */ FundraiserCampaignModel mo903z() {
            return as();
        }

        public ReactionStoryAttachmentActionCommonFragmentModel() {
            super(55);
        }

        public ReactionStoryAttachmentActionCommonFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(55);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType mo875a() {
            if (this.b != null && this.f13099d == null) {
                this.f13099d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13099d;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel ae() {
            this.f13100e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13100e, 1, DefaultTextWithEntitiesFieldsModel.class);
            return this.f13100e;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel af() {
            this.f13101f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13101f, 2, DefaultTextWithEntitiesFieldsModel.class);
            return this.f13101f;
        }

        @Nullable
        private ReactionImageFieldsModel ag() {
            this.f13102g = (ReactionImageFieldsModel) super.a(this.f13102g, 3, ReactionImageFieldsModel.class);
            return this.f13102g;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel ah() {
            this.f13103h = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13103h, 4, DefaultTextWithEntitiesFieldsModel.class);
            return this.f13103h;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel ai() {
            this.f13104i = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13104i, 5, DefaultTextWithEntitiesFieldsModel.class);
            return this.f13104i;
        }

        public final boolean fS_() {
            a(0, 6);
            return this.f13105j;
        }

        @Nullable
        private ActionOgObjectModel aj() {
            this.f13106k = (ActionOgObjectModel) super.a(this.f13106k, 7, ActionOgObjectModel.class);
            return this.f13106k;
        }

        @Nullable
        public final GraphQLReactionStoryActionStyle mo887j() {
            this.f13107l = (GraphQLReactionStoryActionStyle) super.b(this.f13107l, 8, GraphQLReactionStoryActionStyle.class, GraphQLReactionStoryActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13107l;
        }

        @Nullable
        private AlbumModel ak() {
            this.f13108m = (AlbumModel) super.a(this.f13108m, 9, AlbumModel.class);
            return this.f13108m;
        }

        public final boolean mo889l() {
            a(1, 2);
            return this.f13109n;
        }

        @Nullable
        private CollectionModel al() {
            this.f13110o = (CollectionModel) super.a(this.f13110o, 11, CollectionModel.class);
            return this.f13110o;
        }

        @Nullable
        private CommentModel am() {
            this.f13111p = (CommentModel) super.a(this.f13111p, 12, CommentModel.class);
            return this.f13111p;
        }

        @Nullable
        public final String mo892o() {
            this.f13112q = super.a(this.f13112q, 13);
            return this.f13112q;
        }

        @Nullable
        private ComposerInlineActivityModel an() {
            this.f13113r = (ComposerInlineActivityModel) super.a(this.f13113r, 14, ComposerInlineActivityModel.class);
            return this.f13113r;
        }

        @Nullable
        public final GraphQLFundraiserSupportersConnectionType mo894q() {
            this.f13114s = (GraphQLFundraiserSupportersConnectionType) super.b(this.f13114s, 15, GraphQLFundraiserSupportersConnectionType.class, GraphQLFundraiserSupportersConnectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13114s;
        }

        @Nullable
        public final String mo895r() {
            this.f13115t = super.a(this.f13115t, 16);
            return this.f13115t;
        }

        @Nullable
        public final GraphQLPhotosByCategoryEntryPoint mo896s() {
            this.f13116u = (GraphQLPhotosByCategoryEntryPoint) super.b(this.f13116u, 17, GraphQLPhotosByCategoryEntryPoint.class, GraphQLPhotosByCategoryEntryPoint.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13116u;
        }

        @Nullable
        private EventModel ao() {
            this.f13117v = (EventModel) super.a(this.f13117v, 18, EventModel.class);
            return this.f13117v;
        }

        @Nullable
        private EventSpaceModel ap() {
            this.f13118w = (EventSpaceModel) super.a(this.f13118w, 19, EventSpaceModel.class);
            return this.f13118w;
        }

        @Nonnull
        public final ImmutableList<ReactionWeatherSettingsPlaceItemFragmentModel> mo899v() {
            this.f13119x = super.a(this.f13119x, 20, ReactionWeatherSettingsPlaceItemFragmentModel.class);
            return (ImmutableList) this.f13119x;
        }

        @Nullable
        private FriendModel aq() {
            this.f13120y = (FriendModel) super.a(this.f13120y, 21, FriendModel.class);
            return this.f13120y;
        }

        @Nullable
        public final String mo901x() {
            this.f13121z = super.a(this.f13121z, 22);
            return this.f13121z;
        }

        @Nullable
        private FundraiserModel ar() {
            this.f13073A = (FundraiserModel) super.a(this.f13073A, 23, FundraiserModel.class);
            return this.f13073A;
        }

        @Nullable
        private FundraiserCampaignModel as() {
            this.f13074B = (FundraiserCampaignModel) super.a(this.f13074B, 24, FundraiserCampaignModel.class);
            return this.f13074B;
        }

        @Nullable
        private GroupModel at() {
            this.f13075C = (GroupModel) super.a(this.f13075C, 25, GroupModel.class);
            return this.f13075C;
        }

        @Nullable
        public final GraphQLEventWatchStatus mo850B() {
            this.f13076D = (GraphQLEventWatchStatus) super.b(this.f13076D, 26, GraphQLEventWatchStatus.class, GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13076D;
        }

        @Nullable
        private DefaultLocationFieldsModel au() {
            this.f13077E = (DefaultLocationFieldsModel) super.a(this.f13077E, 27, DefaultLocationFieldsModel.class);
            return this.f13077E;
        }

        @Nullable
        private MatchPageModel av() {
            this.f13078F = (MatchPageModel) super.a(this.f13078F, 28, MatchPageModel.class);
            return this.f13078F;
        }

        @Nullable
        public final GraphQLNearbyFriendsNuxType mo853E() {
            this.f13079G = (GraphQLNearbyFriendsNuxType) super.b(this.f13079G, 29, GraphQLNearbyFriendsNuxType.class, GraphQLNearbyFriendsNuxType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13079G;
        }

        @Nullable
        private PageModel aw() {
            this.f13080H = (PageModel) super.a(this.f13080H, 30, PageModel.class);
            return this.f13080H;
        }

        @Nullable
        public final String mo855G() {
            this.f13081I = super.a(this.f13081I, 31);
            return this.f13081I;
        }

        @Nullable
        public final GraphQLPagePhotoSourceType mo856H() {
            this.f13082J = (GraphQLPagePhotoSourceType) super.b(this.f13082J, 32, GraphQLPagePhotoSourceType.class, GraphQLPagePhotoSourceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13082J;
        }

        @Nullable
        public final String mo857I() {
            this.f13083K = super.a(this.f13083K, 33);
            return this.f13083K;
        }

        @Nullable
        private PlacesQueryLocationPageModel ax() {
            this.f13084L = (PlacesQueryLocationPageModel) super.a(this.f13084L, 34, PlacesQueryLocationPageModel.class);
            return this.f13084L;
        }

        @Nullable
        public final String mo859K() {
            this.f13085M = super.a(this.f13085M, 35);
            return this.f13085M;
        }

        @Nullable
        public final String mo860L() {
            this.f13086N = super.a(this.f13086N, 36);
            return this.f13086N;
        }

        @Nullable
        private ProfileModel ay() {
            this.f13087O = (ProfileModel) super.a(this.f13087O, 37, ProfileModel.class);
            return this.f13087O;
        }

        @Nullable
        public final String mo862N() {
            this.f13088P = super.a(this.f13088P, 38);
            return this.f13088P;
        }

        @Nullable
        public final String mo863O() {
            this.f13089Q = super.a(this.f13089Q, 39);
            return this.f13089Q;
        }

        @Nonnull
        public final ImmutableList<RelatedUsersModel> mo864P() {
            this.f13090R = super.a(this.f13090R, 40, RelatedUsersModel.class);
            return (ImmutableList) this.f13090R;
        }

        @Nullable
        private ReplacementUnitModel az() {
            this.f13091S = (ReplacementUnitModel) super.a(this.f13091S, 41, ReplacementUnitModel.class);
            return this.f13091S;
        }

        @Nullable
        private PageServiceItemModel aA() {
            this.f13092T = (PageServiceItemModel) super.a(this.f13092T, 42, PageServiceItemModel.class);
            return this.f13092T;
        }

        @Nullable
        public final String mo867S() {
            this.f13093U = super.a(this.f13093U, 43);
            return this.f13093U;
        }

        @Nullable
        public final String mo868T() {
            this.f13094V = super.a(this.f13094V, 44);
            return this.f13094V;
        }

        @Nullable
        public final String mo869U() {
            this.f13095W = super.a(this.f13095W, 45);
            return this.f13095W;
        }

        @Nullable
        private StoryModel aB() {
            this.f13096X = (StoryModel) super.a(this.f13096X, 46, StoryModel.class);
            return this.f13096X;
        }

        public final boolean mo871W() {
            a(5, 7);
            return this.f13097Y;
        }

        @Nullable
        public final String mo872X() {
            this.f13098Z = super.a(this.f13098Z, 48);
            return this.f13098Z;
        }

        @Nullable
        private ReactionEventInviteFieldsModel aC() {
            this.aa = (ReactionEventInviteFieldsModel) super.a(this.aa, 49, ReactionEventInviteFieldsModel.class);
            return this.aa;
        }

        @Nullable
        public final String mo874Z() {
            this.ab = super.a(this.ab, 50);
            return this.ab;
        }

        @Nullable
        private ThreadKeyModel aD() {
            this.ac = (ThreadKeyModel) super.a(this.ac, 51, ThreadKeyModel.class);
            return this.ac;
        }

        @Nullable
        public final String ab() {
            this.ad = super.a(this.ad, 52);
            return this.ad;
        }

        @Nullable
        public final String ac() {
            this.ae = super.a(this.ae, 53);
            return this.ae;
        }

        @Nullable
        private VideoChannelModel aE() {
            this.af = (VideoChannelModel) super.a(this.af, 54, VideoChannelModel.class);
            return this.af;
        }

        public static ReactionStoryAttachmentActionCommonFragmentModel m16302a(ReactionStoryAttachmentActionCommonFragment reactionStoryAttachmentActionCommonFragment) {
            int i = 0;
            if (reactionStoryAttachmentActionCommonFragment == null) {
                return null;
            }
            if (reactionStoryAttachmentActionCommonFragment instanceof ReactionStoryAttachmentActionCommonFragmentModel) {
                return (ReactionStoryAttachmentActionCommonFragmentModel) reactionStoryAttachmentActionCommonFragment;
            }
            Builder builder = new Builder();
            builder.f13047a = reactionStoryAttachmentActionCommonFragment.mo875a();
            builder.f13048b = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentActionCommonFragment.mo880b());
            builder.f13049c = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentActionCommonFragment.mo881c());
            builder.f13050d = ReactionImageFieldsModel.m14497a(reactionStoryAttachmentActionCommonFragment.mo882d());
            builder.f13051e = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentActionCommonFragment.fU_());
            builder.f13052f = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentActionCommonFragment.mo886g());
            builder.f13053g = reactionStoryAttachmentActionCommonFragment.fS_();
            builder.f13054h = ActionOgObjectModel.m16133a(reactionStoryAttachmentActionCommonFragment.fT_());
            builder.f13055i = reactionStoryAttachmentActionCommonFragment.mo887j();
            builder.f13056j = AlbumModel.m16165a(reactionStoryAttachmentActionCommonFragment.mo888k());
            builder.f13057k = reactionStoryAttachmentActionCommonFragment.mo889l();
            builder.f13058l = CollectionModel.m16264a(reactionStoryAttachmentActionCommonFragment.mo890m());
            builder.f13059m = CommentModel.m16418a(reactionStoryAttachmentActionCommonFragment.mo891n());
            builder.f13060n = reactionStoryAttachmentActionCommonFragment.mo892o();
            builder.f13061o = ComposerInlineActivityModel.m15993a(reactionStoryAttachmentActionCommonFragment.mo893p());
            builder.f13062p = reactionStoryAttachmentActionCommonFragment.mo894q();
            builder.f13063q = reactionStoryAttachmentActionCommonFragment.mo895r();
            builder.f13064r = reactionStoryAttachmentActionCommonFragment.mo896s();
            builder.f13065s = EventModel.m15792a(reactionStoryAttachmentActionCommonFragment.mo897t());
            builder.f13066t = EventSpaceModel.m16006a(reactionStoryAttachmentActionCommonFragment.mo898u());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i2 = 0; i2 < reactionStoryAttachmentActionCommonFragment.mo899v().size(); i2++) {
                builder2.c(ReactionWeatherSettingsPlaceItemFragmentModel.m16500a((ReactionWeatherSettingsPlaceItemFragmentModel) reactionStoryAttachmentActionCommonFragment.mo899v().get(i2)));
            }
            builder.f13067u = builder2.b();
            builder.f13068v = FriendModel.m16078a(reactionStoryAttachmentActionCommonFragment.mo900w());
            builder.f13069w = reactionStoryAttachmentActionCommonFragment.mo901x();
            builder.f13070x = FundraiserModel.m16470a(reactionStoryAttachmentActionCommonFragment.mo902y());
            builder.f13071y = FundraiserCampaignModel.m16116a(reactionStoryAttachmentActionCommonFragment.mo903z());
            builder.f13072z = GroupModel.m15811a(reactionStoryAttachmentActionCommonFragment.mo849A());
            builder.f13021A = reactionStoryAttachmentActionCommonFragment.mo850B();
            builder.f13022B = DefaultLocationFieldsModel.a(reactionStoryAttachmentActionCommonFragment.mo851C());
            builder.f13023C = MatchPageModel.m16187a(reactionStoryAttachmentActionCommonFragment.mo852D());
            builder.f13024D = reactionStoryAttachmentActionCommonFragment.mo853E();
            builder.f13025E = PageModel.m15820a(reactionStoryAttachmentActionCommonFragment.mo854F());
            builder.f13026F = reactionStoryAttachmentActionCommonFragment.mo855G();
            builder.f13027G = reactionStoryAttachmentActionCommonFragment.mo856H();
            builder.f13028H = reactionStoryAttachmentActionCommonFragment.mo857I();
            builder.f13029I = PlacesQueryLocationPageModel.m16149a(reactionStoryAttachmentActionCommonFragment.mo858J());
            builder.f13030J = reactionStoryAttachmentActionCommonFragment.mo859K();
            builder.f13031K = reactionStoryAttachmentActionCommonFragment.mo860L();
            builder.f13032L = ProfileModel.m15833a(reactionStoryAttachmentActionCommonFragment.mo861M());
            builder.f13033M = reactionStoryAttachmentActionCommonFragment.mo862N();
            builder.f13034N = reactionStoryAttachmentActionCommonFragment.mo863O();
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            while (i < reactionStoryAttachmentActionCommonFragment.mo864P().size()) {
                builder3.c(RelatedUsersModel.m15864a((RelatedUsersModel) reactionStoryAttachmentActionCommonFragment.mo864P().get(i)));
                i++;
            }
            builder.f13035O = builder3.b();
            builder.f13036P = ReplacementUnitModel.m16248a(reactionStoryAttachmentActionCommonFragment.mo865Q());
            builder.f13037Q = PageServiceItemModel.m11119a(reactionStoryAttachmentActionCommonFragment.mo866R());
            builder.f13038R = reactionStoryAttachmentActionCommonFragment.mo867S();
            builder.f13039S = reactionStoryAttachmentActionCommonFragment.mo868T();
            builder.f13040T = reactionStoryAttachmentActionCommonFragment.mo869U();
            builder.f13041U = StoryModel.m15883a(reactionStoryAttachmentActionCommonFragment.mo870V());
            builder.f13042V = reactionStoryAttachmentActionCommonFragment.mo871W();
            builder.f13043W = reactionStoryAttachmentActionCommonFragment.mo872X();
            builder.f13044X = ReactionEventInviteFieldsModel.m16041a(reactionStoryAttachmentActionCommonFragment.mo873Y());
            builder.f13045Y = reactionStoryAttachmentActionCommonFragment.mo874Z();
            builder.f13046Z = ThreadKeyModel.m16278a(reactionStoryAttachmentActionCommonFragment.aa());
            builder.aa = reactionStoryAttachmentActionCommonFragment.ab();
            builder.ab = reactionStoryAttachmentActionCommonFragment.ac();
            builder.ac = VideoChannelModel.m16202a(reactionStoryAttachmentActionCommonFragment.ad());
            return builder.m16299a();
        }

        public final int jK_() {
            return 1194715522;
        }

        public final GraphQLVisitableModel m16331a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            com.google.common.collect.ImmutableList.Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (ae() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ae());
                if (ae() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13100e = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (af() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(af());
                if (af() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13101f = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (ag() != null) {
                ReactionImageFieldsModel reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(ag());
                if (ag() != reactionImageFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13102g = reactionImageFieldsModel;
                }
            }
            if (ah() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ah());
                if (ah() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13103h = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (ai() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ai());
                if (ai() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13104i = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aj() != null) {
                ActionOgObjectModel actionOgObjectModel = (ActionOgObjectModel) graphQLModelMutatingVisitor.b(aj());
                if (aj() != actionOgObjectModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13106k = actionOgObjectModel;
                }
            }
            if (ak() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(ak());
                if (ak() != albumModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13108m = albumModel;
                }
            }
            if (al() != null) {
                CollectionModel collectionModel = (CollectionModel) graphQLModelMutatingVisitor.b(al());
                if (al() != collectionModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13110o = collectionModel;
                }
            }
            if (am() != null) {
                CommentModel commentModel = (CommentModel) graphQLModelMutatingVisitor.b(am());
                if (am() != commentModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13111p = commentModel;
                }
            }
            if (an() != null) {
                ComposerInlineActivityModel composerInlineActivityModel = (ComposerInlineActivityModel) graphQLModelMutatingVisitor.b(an());
                if (an() != composerInlineActivityModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13113r = composerInlineActivityModel;
                }
            }
            if (ao() != null) {
                EventModel eventModel = (EventModel) graphQLModelMutatingVisitor.b(ao());
                if (ao() != eventModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13117v = eventModel;
                }
            }
            if (ap() != null) {
                EventSpaceModel eventSpaceModel = (EventSpaceModel) graphQLModelMutatingVisitor.b(ap());
                if (ap() != eventSpaceModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13118w = eventSpaceModel;
                }
            }
            if (mo899v() != null) {
                a = ModelHelper.a(mo899v(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ReactionStoryAttachmentActionCommonFragmentModel reactionStoryAttachmentActionCommonFragmentModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    reactionStoryAttachmentActionCommonFragmentModel.f13119x = a.b();
                    graphQLVisitableModel = reactionStoryAttachmentActionCommonFragmentModel;
                }
            }
            if (aq() != null) {
                FriendModel friendModel = (FriendModel) graphQLModelMutatingVisitor.b(aq());
                if (aq() != friendModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13120y = friendModel;
                }
            }
            if (ar() != null) {
                FundraiserModel fundraiserModel = (FundraiserModel) graphQLModelMutatingVisitor.b(ar());
                if (ar() != fundraiserModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13073A = fundraiserModel;
                }
            }
            if (as() != null) {
                FundraiserCampaignModel fundraiserCampaignModel = (FundraiserCampaignModel) graphQLModelMutatingVisitor.b(as());
                if (as() != fundraiserCampaignModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13074B = fundraiserCampaignModel;
                }
            }
            if (at() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(at());
                if (at() != groupModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13075C = groupModel;
                }
            }
            if (au() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(au());
                if (au() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13077E = defaultLocationFieldsModel;
                }
            }
            if (av() != null) {
                MatchPageModel matchPageModel = (MatchPageModel) graphQLModelMutatingVisitor.b(av());
                if (av() != matchPageModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13078F = matchPageModel;
                }
            }
            if (aw() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(aw());
                if (aw() != pageModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13080H = pageModel;
                }
            }
            if (ax() != null) {
                PlacesQueryLocationPageModel placesQueryLocationPageModel = (PlacesQueryLocationPageModel) graphQLModelMutatingVisitor.b(ax());
                if (ax() != placesQueryLocationPageModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13084L = placesQueryLocationPageModel;
                }
            }
            if (ay() != null) {
                ProfileModel profileModel = (ProfileModel) graphQLModelMutatingVisitor.b(ay());
                if (ay() != profileModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13087O = profileModel;
                }
            }
            if (mo864P() != null) {
                a = ModelHelper.a(mo864P(), graphQLModelMutatingVisitor);
                if (a != null) {
                    reactionStoryAttachmentActionCommonFragmentModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    reactionStoryAttachmentActionCommonFragmentModel.f13090R = a.b();
                    graphQLVisitableModel = reactionStoryAttachmentActionCommonFragmentModel;
                }
            }
            if (az() != null) {
                ReplacementUnitModel replacementUnitModel = (ReplacementUnitModel) graphQLModelMutatingVisitor.b(az());
                if (az() != replacementUnitModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13091S = replacementUnitModel;
                }
            }
            if (aA() != null) {
                PageServiceItemModel pageServiceItemModel = (PageServiceItemModel) graphQLModelMutatingVisitor.b(aA());
                if (aA() != pageServiceItemModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13092T = pageServiceItemModel;
                }
            }
            if (aB() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(aB());
                if (aB() != storyModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13096X = storyModel;
                }
            }
            if (aC() != null) {
                ReactionEventInviteFieldsModel reactionEventInviteFieldsModel = (ReactionEventInviteFieldsModel) graphQLModelMutatingVisitor.b(aC());
                if (aC() != reactionEventInviteFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aa = reactionEventInviteFieldsModel;
                }
            }
            if (aD() != null) {
                ThreadKeyModel threadKeyModel = (ThreadKeyModel) graphQLModelMutatingVisitor.b(aD());
                if (aD() != threadKeyModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ac = threadKeyModel;
                }
            }
            if (aE() != null) {
                VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(aE());
                if (aE() != videoChannelModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionCommonFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.af = videoChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16329a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo875a());
            int a2 = ModelHelper.a(flatBufferBuilder, ae());
            int a3 = ModelHelper.a(flatBufferBuilder, af());
            int a4 = ModelHelper.a(flatBufferBuilder, ag());
            int a5 = ModelHelper.a(flatBufferBuilder, ah());
            int a6 = ModelHelper.a(flatBufferBuilder, ai());
            int a7 = ModelHelper.a(flatBufferBuilder, aj());
            int a8 = flatBufferBuilder.a(mo887j());
            int a9 = ModelHelper.a(flatBufferBuilder, ak());
            int a10 = ModelHelper.a(flatBufferBuilder, al());
            int a11 = ModelHelper.a(flatBufferBuilder, am());
            int b = flatBufferBuilder.b(mo892o());
            int a12 = ModelHelper.a(flatBufferBuilder, an());
            int a13 = flatBufferBuilder.a(mo894q());
            int b2 = flatBufferBuilder.b(mo895r());
            int a14 = flatBufferBuilder.a(mo896s());
            int a15 = ModelHelper.a(flatBufferBuilder, ao());
            int a16 = ModelHelper.a(flatBufferBuilder, ap());
            int a17 = ModelHelper.a(flatBufferBuilder, mo899v());
            int a18 = ModelHelper.a(flatBufferBuilder, aq());
            int b3 = flatBufferBuilder.b(mo901x());
            int a19 = ModelHelper.a(flatBufferBuilder, ar());
            int a20 = ModelHelper.a(flatBufferBuilder, as());
            int a21 = ModelHelper.a(flatBufferBuilder, at());
            int a22 = flatBufferBuilder.a(mo850B());
            int a23 = ModelHelper.a(flatBufferBuilder, au());
            int a24 = ModelHelper.a(flatBufferBuilder, av());
            int a25 = flatBufferBuilder.a(mo853E());
            int a26 = ModelHelper.a(flatBufferBuilder, aw());
            int b4 = flatBufferBuilder.b(mo855G());
            int a27 = flatBufferBuilder.a(mo856H());
            int b5 = flatBufferBuilder.b(mo857I());
            int a28 = ModelHelper.a(flatBufferBuilder, ax());
            int b6 = flatBufferBuilder.b(mo859K());
            int b7 = flatBufferBuilder.b(mo860L());
            int a29 = ModelHelper.a(flatBufferBuilder, ay());
            int b8 = flatBufferBuilder.b(mo862N());
            int b9 = flatBufferBuilder.b(mo863O());
            int a30 = ModelHelper.a(flatBufferBuilder, mo864P());
            int a31 = ModelHelper.a(flatBufferBuilder, az());
            int a32 = ModelHelper.a(flatBufferBuilder, aA());
            int b10 = flatBufferBuilder.b(mo867S());
            int b11 = flatBufferBuilder.b(mo868T());
            int b12 = flatBufferBuilder.b(mo869U());
            int a33 = ModelHelper.a(flatBufferBuilder, aB());
            int b13 = flatBufferBuilder.b(mo872X());
            int a34 = ModelHelper.a(flatBufferBuilder, aC());
            int b14 = flatBufferBuilder.b(mo874Z());
            int a35 = ModelHelper.a(flatBufferBuilder, aD());
            int b15 = flatBufferBuilder.b(ab());
            int b16 = flatBufferBuilder.b(ac());
            int a36 = ModelHelper.a(flatBufferBuilder, aE());
            flatBufferBuilder.c(55);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.a(6, this.f13105j);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, a8);
            flatBufferBuilder.b(9, a9);
            flatBufferBuilder.a(10, this.f13109n);
            flatBufferBuilder.b(11, a10);
            flatBufferBuilder.b(12, a11);
            flatBufferBuilder.b(13, b);
            flatBufferBuilder.b(14, a12);
            flatBufferBuilder.b(15, a13);
            flatBufferBuilder.b(16, b2);
            flatBufferBuilder.b(17, a14);
            flatBufferBuilder.b(18, a15);
            flatBufferBuilder.b(19, a16);
            flatBufferBuilder.b(20, a17);
            flatBufferBuilder.b(21, a18);
            flatBufferBuilder.b(22, b3);
            flatBufferBuilder.b(23, a19);
            flatBufferBuilder.b(24, a20);
            flatBufferBuilder.b(25, a21);
            flatBufferBuilder.b(26, a22);
            flatBufferBuilder.b(27, a23);
            flatBufferBuilder.b(28, a24);
            flatBufferBuilder.b(29, a25);
            flatBufferBuilder.b(30, a26);
            flatBufferBuilder.b(31, b4);
            flatBufferBuilder.b(32, a27);
            flatBufferBuilder.b(33, b5);
            flatBufferBuilder.b(34, a28);
            flatBufferBuilder.b(35, b6);
            flatBufferBuilder.b(36, b7);
            flatBufferBuilder.b(37, a29);
            flatBufferBuilder.b(38, b8);
            flatBufferBuilder.b(39, b9);
            flatBufferBuilder.b(40, a30);
            flatBufferBuilder.b(41, a31);
            flatBufferBuilder.b(42, a32);
            flatBufferBuilder.b(43, b10);
            flatBufferBuilder.b(44, b11);
            flatBufferBuilder.b(45, b12);
            flatBufferBuilder.b(46, a33);
            flatBufferBuilder.a(47, this.f13097Y);
            flatBufferBuilder.b(48, b13);
            flatBufferBuilder.b(49, a34);
            flatBufferBuilder.b(50, b14);
            flatBufferBuilder.b(51, a35);
            flatBufferBuilder.b(52, b15);
            flatBufferBuilder.b(53, b16);
            flatBufferBuilder.b(54, a36);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16332a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13105j = mutableFlatBuffer.a(i, 6);
            this.f13109n = mutableFlatBuffer.a(i, 10);
            this.f13097Y = mutableFlatBuffer.a(i, 47);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1910659538)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionStoryAttachmentActionFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionStoryAttachmentActionCommonFragment {
        @Nullable
        private FundraiserModel f13174A;
        @Nullable
        private FundraiserCampaignModel f13175B;
        @Nullable
        private GroupModel f13176C;
        @Nullable
        private GraphQLEventWatchStatus f13177D;
        @Nullable
        private List<ReactionStoryAttachmentActionCommonFragmentModel> f13178E;
        @Nullable
        private DefaultLocationFieldsModel f13179F;
        @Nullable
        private MatchPageModel f13180G;
        @Nullable
        private GraphQLNearbyFriendsNuxType f13181H;
        @Nullable
        private PageModel f13182I;
        @Nullable
        private String f13183J;
        @Nullable
        private GraphQLPagePhotoSourceType f13184K;
        @Nullable
        private String f13185L;
        @Nullable
        private PlacesQueryLocationPageModel f13186M;
        @Nullable
        private String f13187N;
        @Nullable
        private String f13188O;
        @Nullable
        private ProfileModel f13189P;
        @Nullable
        private String f13190Q;
        @Nullable
        private String f13191R;
        @Nullable
        private List<RelatedUsersModel> f13192S;
        @Nullable
        private ReplacementUnitModel f13193T;
        @Nullable
        private PageServiceItemModel f13194U;
        @Nullable
        private String f13195V;
        @Nullable
        private String f13196W;
        @Nullable
        private String f13197X;
        @Nullable
        private StoryModel f13198Y;
        private boolean f13199Z;
        @Nullable
        private String aa;
        @Nullable
        private ReactionEventInviteFieldsModel ab;
        @Nullable
        private String ac;
        @Nullable
        private ThreadKeyModel ad;
        @Nullable
        private String ae;
        @Nullable
        private String af;
        @Nullable
        private VideoChannelModel ag;
        @Nullable
        private GraphQLObjectType f13200d;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f13201e;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f13202f;
        @Nullable
        private ReactionImageFieldsModel f13203g;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f13204h;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f13205i;
        private boolean f13206j;
        @Nullable
        private ActionOgObjectModel f13207k;
        @Nullable
        private GraphQLReactionStoryActionStyle f13208l;
        @Nullable
        private AlbumModel f13209m;
        private boolean f13210n;
        @Nullable
        private CollectionModel f13211o;
        @Nullable
        private CommentModel f13212p;
        @Nullable
        private String f13213q;
        @Nullable
        private ComposerInlineActivityModel f13214r;
        @Nullable
        private GraphQLFundraiserSupportersConnectionType f13215s;
        @Nullable
        private String f13216t;
        @Nullable
        private GraphQLPhotosByCategoryEntryPoint f13217u;
        @Nullable
        private EventModel f13218v;
        @Nullable
        private EventSpaceModel f13219w;
        @Nullable
        private List<ReactionWeatherSettingsPlaceItemFragmentModel> f13220x;
        @Nullable
        private FriendModel f13221y;
        @Nullable
        private String f13222z;

        /* compiled from: field_icon */
        public final class Builder {
            @Nullable
            public GraphQLEventWatchStatus f13122A;
            @Nullable
            public ImmutableList<ReactionStoryAttachmentActionCommonFragmentModel> f13123B;
            @Nullable
            public DefaultLocationFieldsModel f13124C;
            @Nullable
            public MatchPageModel f13125D;
            @Nullable
            public GraphQLNearbyFriendsNuxType f13126E;
            @Nullable
            public PageModel f13127F;
            @Nullable
            public String f13128G;
            @Nullable
            public GraphQLPagePhotoSourceType f13129H;
            @Nullable
            public String f13130I;
            @Nullable
            public PlacesQueryLocationPageModel f13131J;
            @Nullable
            public String f13132K;
            @Nullable
            public String f13133L;
            @Nullable
            public ProfileModel f13134M;
            @Nullable
            public String f13135N;
            @Nullable
            public String f13136O;
            @Nullable
            public ImmutableList<RelatedUsersModel> f13137P;
            @Nullable
            public ReplacementUnitModel f13138Q;
            @Nullable
            public PageServiceItemModel f13139R;
            @Nullable
            public String f13140S;
            @Nullable
            public String f13141T;
            @Nullable
            public String f13142U;
            @Nullable
            public StoryModel f13143V;
            public boolean f13144W;
            @Nullable
            public String f13145X;
            @Nullable
            public ReactionEventInviteFieldsModel f13146Y;
            @Nullable
            public String f13147Z;
            @Nullable
            public GraphQLObjectType f13148a;
            @Nullable
            public ThreadKeyModel aa;
            @Nullable
            public String ab;
            @Nullable
            public String ac;
            @Nullable
            public VideoChannelModel ad;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f13149b;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f13150c;
            @Nullable
            public ReactionImageFieldsModel f13151d;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f13152e;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f13153f;
            public boolean f13154g;
            @Nullable
            public ActionOgObjectModel f13155h;
            @Nullable
            public GraphQLReactionStoryActionStyle f13156i;
            @Nullable
            public AlbumModel f13157j;
            public boolean f13158k;
            @Nullable
            public CollectionModel f13159l;
            @Nullable
            public CommentModel f13160m;
            @Nullable
            public String f13161n;
            @Nullable
            public ComposerInlineActivityModel f13162o;
            @Nullable
            public GraphQLFundraiserSupportersConnectionType f13163p;
            @Nullable
            public String f13164q;
            @Nullable
            public GraphQLPhotosByCategoryEntryPoint f13165r;
            @Nullable
            public EventModel f13166s;
            @Nullable
            public EventSpaceModel f13167t;
            @Nullable
            public ImmutableList<ReactionWeatherSettingsPlaceItemFragmentModel> f13168u;
            @Nullable
            public FriendModel f13169v;
            @Nullable
            public String f13170w;
            @Nullable
            public FundraiserModel f13171x;
            @Nullable
            public FundraiserCampaignModel f13172y;
            @Nullable
            public GroupModel f13173z;

            public final ReactionStoryAttachmentActionFragmentModel m16354a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f13148a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f13149b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f13150c);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f13151d);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f13152e);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f13153f);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f13155h);
                int a8 = flatBufferBuilder.a(this.f13156i);
                int a9 = ModelHelper.a(flatBufferBuilder, this.f13157j);
                int a10 = ModelHelper.a(flatBufferBuilder, this.f13159l);
                int a11 = ModelHelper.a(flatBufferBuilder, this.f13160m);
                int b = flatBufferBuilder.b(this.f13161n);
                int a12 = ModelHelper.a(flatBufferBuilder, this.f13162o);
                int a13 = flatBufferBuilder.a(this.f13163p);
                int b2 = flatBufferBuilder.b(this.f13164q);
                int a14 = flatBufferBuilder.a(this.f13165r);
                int a15 = ModelHelper.a(flatBufferBuilder, this.f13166s);
                int a16 = ModelHelper.a(flatBufferBuilder, this.f13167t);
                int a17 = ModelHelper.a(flatBufferBuilder, this.f13168u);
                int a18 = ModelHelper.a(flatBufferBuilder, this.f13169v);
                int b3 = flatBufferBuilder.b(this.f13170w);
                int a19 = ModelHelper.a(flatBufferBuilder, this.f13171x);
                int a20 = ModelHelper.a(flatBufferBuilder, this.f13172y);
                int a21 = ModelHelper.a(flatBufferBuilder, this.f13173z);
                int a22 = flatBufferBuilder.a(this.f13122A);
                int a23 = ModelHelper.a(flatBufferBuilder, this.f13123B);
                int a24 = ModelHelper.a(flatBufferBuilder, this.f13124C);
                int a25 = ModelHelper.a(flatBufferBuilder, this.f13125D);
                int a26 = flatBufferBuilder.a(this.f13126E);
                int a27 = ModelHelper.a(flatBufferBuilder, this.f13127F);
                int b4 = flatBufferBuilder.b(this.f13128G);
                int a28 = flatBufferBuilder.a(this.f13129H);
                int b5 = flatBufferBuilder.b(this.f13130I);
                int a29 = ModelHelper.a(flatBufferBuilder, this.f13131J);
                int b6 = flatBufferBuilder.b(this.f13132K);
                int b7 = flatBufferBuilder.b(this.f13133L);
                int a30 = ModelHelper.a(flatBufferBuilder, this.f13134M);
                int b8 = flatBufferBuilder.b(this.f13135N);
                int b9 = flatBufferBuilder.b(this.f13136O);
                int a31 = ModelHelper.a(flatBufferBuilder, this.f13137P);
                int a32 = ModelHelper.a(flatBufferBuilder, this.f13138Q);
                int a33 = ModelHelper.a(flatBufferBuilder, this.f13139R);
                int b10 = flatBufferBuilder.b(this.f13140S);
                int b11 = flatBufferBuilder.b(this.f13141T);
                int b12 = flatBufferBuilder.b(this.f13142U);
                int a34 = ModelHelper.a(flatBufferBuilder, this.f13143V);
                int b13 = flatBufferBuilder.b(this.f13145X);
                int a35 = ModelHelper.a(flatBufferBuilder, this.f13146Y);
                int b14 = flatBufferBuilder.b(this.f13147Z);
                int a36 = ModelHelper.a(flatBufferBuilder, this.aa);
                int b15 = flatBufferBuilder.b(this.ab);
                int b16 = flatBufferBuilder.b(this.ac);
                int a37 = ModelHelper.a(flatBufferBuilder, this.ad);
                flatBufferBuilder.c(56);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, a5);
                flatBufferBuilder.b(5, a6);
                flatBufferBuilder.a(6, this.f13154g);
                flatBufferBuilder.b(7, a7);
                flatBufferBuilder.b(8, a8);
                flatBufferBuilder.b(9, a9);
                flatBufferBuilder.a(10, this.f13158k);
                flatBufferBuilder.b(11, a10);
                flatBufferBuilder.b(12, a11);
                flatBufferBuilder.b(13, b);
                flatBufferBuilder.b(14, a12);
                flatBufferBuilder.b(15, a13);
                flatBufferBuilder.b(16, b2);
                flatBufferBuilder.b(17, a14);
                flatBufferBuilder.b(18, a15);
                flatBufferBuilder.b(19, a16);
                flatBufferBuilder.b(20, a17);
                flatBufferBuilder.b(21, a18);
                flatBufferBuilder.b(22, b3);
                flatBufferBuilder.b(23, a19);
                flatBufferBuilder.b(24, a20);
                flatBufferBuilder.b(25, a21);
                flatBufferBuilder.b(26, a22);
                flatBufferBuilder.b(27, a23);
                flatBufferBuilder.b(28, a24);
                flatBufferBuilder.b(29, a25);
                flatBufferBuilder.b(30, a26);
                flatBufferBuilder.b(31, a27);
                flatBufferBuilder.b(32, b4);
                flatBufferBuilder.b(33, a28);
                flatBufferBuilder.b(34, b5);
                flatBufferBuilder.b(35, a29);
                flatBufferBuilder.b(36, b6);
                flatBufferBuilder.b(37, b7);
                flatBufferBuilder.b(38, a30);
                flatBufferBuilder.b(39, b8);
                flatBufferBuilder.b(40, b9);
                flatBufferBuilder.b(41, a31);
                flatBufferBuilder.b(42, a32);
                flatBufferBuilder.b(43, a33);
                flatBufferBuilder.b(44, b10);
                flatBufferBuilder.b(45, b11);
                flatBufferBuilder.b(46, b12);
                flatBufferBuilder.b(47, a34);
                flatBufferBuilder.a(48, this.f13144W);
                flatBufferBuilder.b(49, b13);
                flatBufferBuilder.b(50, a35);
                flatBufferBuilder.b(51, b14);
                flatBufferBuilder.b(52, a36);
                flatBufferBuilder.b(53, b15);
                flatBufferBuilder.b(54, b16);
                flatBufferBuilder.b(55, a37);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReactionStoryAttachmentActionFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionStoryAttachmentActionFragmentModel.class, new Deserializer());
            }

            public Object m16355a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionStoryAttachmentActionFragmentParser.m16601a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionStoryAttachmentActionFragmentModel = new ReactionStoryAttachmentActionFragmentModel();
                ((BaseModel) reactionStoryAttachmentActionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionStoryAttachmentActionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionStoryAttachmentActionFragmentModel).a();
                }
                return reactionStoryAttachmentActionFragmentModel;
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionStoryAttachmentActionFragmentModel> {
            public final void m16356a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) obj;
                if (reactionStoryAttachmentActionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionStoryAttachmentActionFragmentModel.m16384a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionStoryAttachmentActionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionStoryAttachmentActionFragmentParser.m16604b(reactionStoryAttachmentActionFragmentModel.w_(), reactionStoryAttachmentActionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionStoryAttachmentActionFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ GroupModel mo849A() {
            return au();
        }

        @Nullable
        public final /* synthetic */ DefaultLocationFields mo851C() {
            return av();
        }

        @Nullable
        public final /* synthetic */ MatchPageModel mo852D() {
            return aw();
        }

        @Nullable
        public final /* synthetic */ PageModel mo854F() {
            return ax();
        }

        @Nullable
        public final /* synthetic */ PlacesQueryLocationPageModel mo858J() {
            return ay();
        }

        @Nullable
        public final /* synthetic */ ProfileModel mo861M() {
            return az();
        }

        @Nullable
        public final /* synthetic */ ReplacementUnitModel mo865Q() {
            return aA();
        }

        @Nullable
        public final /* synthetic */ PageServiceItemModel mo866R() {
            return aB();
        }

        @Nullable
        public final /* synthetic */ StoryModel mo870V() {
            return aC();
        }

        @Nullable
        public final /* synthetic */ ReactionEventInviteFieldsModel mo873Y() {
            return aD();
        }

        @Nullable
        public final /* synthetic */ ThreadKeyModel aa() {
            return aE();
        }

        @Nullable
        public final /* synthetic */ VideoChannelModel ad() {
            return aF();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields mo880b() {
            return af();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields mo881c() {
            return ag();
        }

        @Nullable
        public final /* synthetic */ ReactionImageFields mo882d() {
            return ah();
        }

        @Nullable
        public final /* synthetic */ ActionOgObjectModel fT_() {
            return ak();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields fU_() {
            return ai();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields mo886g() {
            return aj();
        }

        @Nullable
        public final /* synthetic */ AlbumModel mo888k() {
            return al();
        }

        @Nullable
        public final /* synthetic */ CollectionModel mo890m() {
            return am();
        }

        @Nullable
        public final /* synthetic */ CommentModel mo891n() {
            return an();
        }

        @Nullable
        public final /* synthetic */ ComposerInlineActivityModel mo893p() {
            return ao();
        }

        @Nullable
        public final /* synthetic */ EventModel mo897t() {
            return ap();
        }

        @Nullable
        public final /* synthetic */ EventSpaceModel mo898u() {
            return aq();
        }

        @Nullable
        public final /* synthetic */ FriendModel mo900w() {
            return ar();
        }

        @Nullable
        public final /* synthetic */ FundraiserModel mo902y() {
            return as();
        }

        @Nullable
        public final /* synthetic */ FundraiserCampaignModel mo903z() {
            return at();
        }

        public ReactionStoryAttachmentActionFragmentModel() {
            super(56);
        }

        public ReactionStoryAttachmentActionFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(56);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType mo875a() {
            if (this.b != null && this.f13200d == null) {
                this.f13200d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13200d;
        }

        @Nullable
        public final DefaultTextWithEntitiesFieldsModel af() {
            this.f13201e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13201e, 1, DefaultTextWithEntitiesFieldsModel.class);
            return this.f13201e;
        }

        @Nullable
        public final DefaultTextWithEntitiesFieldsModel ag() {
            this.f13202f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13202f, 2, DefaultTextWithEntitiesFieldsModel.class);
            return this.f13202f;
        }

        @Nullable
        public final ReactionImageFieldsModel ah() {
            this.f13203g = (ReactionImageFieldsModel) super.a(this.f13203g, 3, ReactionImageFieldsModel.class);
            return this.f13203g;
        }

        @Nullable
        public final DefaultTextWithEntitiesFieldsModel ai() {
            this.f13204h = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13204h, 4, DefaultTextWithEntitiesFieldsModel.class);
            return this.f13204h;
        }

        @Nullable
        public final DefaultTextWithEntitiesFieldsModel aj() {
            this.f13205i = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13205i, 5, DefaultTextWithEntitiesFieldsModel.class);
            return this.f13205i;
        }

        public final boolean fS_() {
            a(0, 6);
            return this.f13206j;
        }

        @Nullable
        public final ActionOgObjectModel ak() {
            this.f13207k = (ActionOgObjectModel) super.a(this.f13207k, 7, ActionOgObjectModel.class);
            return this.f13207k;
        }

        @Nullable
        public final GraphQLReactionStoryActionStyle mo887j() {
            this.f13208l = (GraphQLReactionStoryActionStyle) super.b(this.f13208l, 8, GraphQLReactionStoryActionStyle.class, GraphQLReactionStoryActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13208l;
        }

        @Nullable
        public final AlbumModel al() {
            this.f13209m = (AlbumModel) super.a(this.f13209m, 9, AlbumModel.class);
            return this.f13209m;
        }

        public final boolean mo889l() {
            a(1, 2);
            return this.f13210n;
        }

        @Nullable
        public final CollectionModel am() {
            this.f13211o = (CollectionModel) super.a(this.f13211o, 11, CollectionModel.class);
            return this.f13211o;
        }

        @Nullable
        public final CommentModel an() {
            this.f13212p = (CommentModel) super.a(this.f13212p, 12, CommentModel.class);
            return this.f13212p;
        }

        @Nullable
        public final String mo892o() {
            this.f13213q = super.a(this.f13213q, 13);
            return this.f13213q;
        }

        @Nullable
        public final ComposerInlineActivityModel ao() {
            this.f13214r = (ComposerInlineActivityModel) super.a(this.f13214r, 14, ComposerInlineActivityModel.class);
            return this.f13214r;
        }

        @Nullable
        public final GraphQLFundraiserSupportersConnectionType mo894q() {
            this.f13215s = (GraphQLFundraiserSupportersConnectionType) super.b(this.f13215s, 15, GraphQLFundraiserSupportersConnectionType.class, GraphQLFundraiserSupportersConnectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13215s;
        }

        @Nullable
        public final String mo895r() {
            this.f13216t = super.a(this.f13216t, 16);
            return this.f13216t;
        }

        @Nullable
        public final GraphQLPhotosByCategoryEntryPoint mo896s() {
            this.f13217u = (GraphQLPhotosByCategoryEntryPoint) super.b(this.f13217u, 17, GraphQLPhotosByCategoryEntryPoint.class, GraphQLPhotosByCategoryEntryPoint.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13217u;
        }

        @Nullable
        public final EventModel ap() {
            this.f13218v = (EventModel) super.a(this.f13218v, 18, EventModel.class);
            return this.f13218v;
        }

        @Nullable
        public final EventSpaceModel aq() {
            this.f13219w = (EventSpaceModel) super.a(this.f13219w, 19, EventSpaceModel.class);
            return this.f13219w;
        }

        @Nonnull
        public final ImmutableList<ReactionWeatherSettingsPlaceItemFragmentModel> mo899v() {
            this.f13220x = super.a(this.f13220x, 20, ReactionWeatherSettingsPlaceItemFragmentModel.class);
            return (ImmutableList) this.f13220x;
        }

        @Nullable
        public final FriendModel ar() {
            this.f13221y = (FriendModel) super.a(this.f13221y, 21, FriendModel.class);
            return this.f13221y;
        }

        @Nullable
        public final String mo901x() {
            this.f13222z = super.a(this.f13222z, 22);
            return this.f13222z;
        }

        @Nullable
        public final FundraiserModel as() {
            this.f13174A = (FundraiserModel) super.a(this.f13174A, 23, FundraiserModel.class);
            return this.f13174A;
        }

        @Nullable
        public final FundraiserCampaignModel at() {
            this.f13175B = (FundraiserCampaignModel) super.a(this.f13175B, 24, FundraiserCampaignModel.class);
            return this.f13175B;
        }

        @Nullable
        public final GroupModel au() {
            this.f13176C = (GroupModel) super.a(this.f13176C, 25, GroupModel.class);
            return this.f13176C;
        }

        @Nullable
        public final GraphQLEventWatchStatus mo850B() {
            this.f13177D = (GraphQLEventWatchStatus) super.b(this.f13177D, 26, GraphQLEventWatchStatus.class, GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13177D;
        }

        @Nonnull
        public final ImmutableList<ReactionStoryAttachmentActionCommonFragmentModel> ae() {
            this.f13178E = super.a(this.f13178E, 27, ReactionStoryAttachmentActionCommonFragmentModel.class);
            return (ImmutableList) this.f13178E;
        }

        @Nullable
        public final DefaultLocationFieldsModel av() {
            this.f13179F = (DefaultLocationFieldsModel) super.a(this.f13179F, 28, DefaultLocationFieldsModel.class);
            return this.f13179F;
        }

        @Nullable
        public final MatchPageModel aw() {
            this.f13180G = (MatchPageModel) super.a(this.f13180G, 29, MatchPageModel.class);
            return this.f13180G;
        }

        @Nullable
        public final GraphQLNearbyFriendsNuxType mo853E() {
            this.f13181H = (GraphQLNearbyFriendsNuxType) super.b(this.f13181H, 30, GraphQLNearbyFriendsNuxType.class, GraphQLNearbyFriendsNuxType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13181H;
        }

        @Nullable
        public final PageModel ax() {
            this.f13182I = (PageModel) super.a(this.f13182I, 31, PageModel.class);
            return this.f13182I;
        }

        @Nullable
        public final String mo855G() {
            this.f13183J = super.a(this.f13183J, 32);
            return this.f13183J;
        }

        @Nullable
        public final GraphQLPagePhotoSourceType mo856H() {
            this.f13184K = (GraphQLPagePhotoSourceType) super.b(this.f13184K, 33, GraphQLPagePhotoSourceType.class, GraphQLPagePhotoSourceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13184K;
        }

        @Nullable
        public final String mo857I() {
            this.f13185L = super.a(this.f13185L, 34);
            return this.f13185L;
        }

        @Nullable
        public final PlacesQueryLocationPageModel ay() {
            this.f13186M = (PlacesQueryLocationPageModel) super.a(this.f13186M, 35, PlacesQueryLocationPageModel.class);
            return this.f13186M;
        }

        @Nullable
        public final String mo859K() {
            this.f13187N = super.a(this.f13187N, 36);
            return this.f13187N;
        }

        @Nullable
        public final String mo860L() {
            this.f13188O = super.a(this.f13188O, 37);
            return this.f13188O;
        }

        @Nullable
        public final ProfileModel az() {
            this.f13189P = (ProfileModel) super.a(this.f13189P, 38, ProfileModel.class);
            return this.f13189P;
        }

        @Nullable
        public final String mo862N() {
            this.f13190Q = super.a(this.f13190Q, 39);
            return this.f13190Q;
        }

        @Nullable
        public final String mo863O() {
            this.f13191R = super.a(this.f13191R, 40);
            return this.f13191R;
        }

        @Nonnull
        public final ImmutableList<RelatedUsersModel> mo864P() {
            this.f13192S = super.a(this.f13192S, 41, RelatedUsersModel.class);
            return (ImmutableList) this.f13192S;
        }

        @Nullable
        public final ReplacementUnitModel aA() {
            this.f13193T = (ReplacementUnitModel) super.a(this.f13193T, 42, ReplacementUnitModel.class);
            return this.f13193T;
        }

        @Nullable
        public final PageServiceItemModel aB() {
            this.f13194U = (PageServiceItemModel) super.a(this.f13194U, 43, PageServiceItemModel.class);
            return this.f13194U;
        }

        @Nullable
        public final String mo867S() {
            this.f13195V = super.a(this.f13195V, 44);
            return this.f13195V;
        }

        @Nullable
        public final String mo868T() {
            this.f13196W = super.a(this.f13196W, 45);
            return this.f13196W;
        }

        @Nullable
        public final String mo869U() {
            this.f13197X = super.a(this.f13197X, 46);
            return this.f13197X;
        }

        @Nullable
        public final StoryModel aC() {
            this.f13198Y = (StoryModel) super.a(this.f13198Y, 47, StoryModel.class);
            return this.f13198Y;
        }

        public final boolean mo871W() {
            a(6, 0);
            return this.f13199Z;
        }

        @Nullable
        public final String mo872X() {
            this.aa = super.a(this.aa, 49);
            return this.aa;
        }

        @Nullable
        public final ReactionEventInviteFieldsModel aD() {
            this.ab = (ReactionEventInviteFieldsModel) super.a(this.ab, 50, ReactionEventInviteFieldsModel.class);
            return this.ab;
        }

        @Nullable
        public final String mo874Z() {
            this.ac = super.a(this.ac, 51);
            return this.ac;
        }

        @Nullable
        public final ThreadKeyModel aE() {
            this.ad = (ThreadKeyModel) super.a(this.ad, 52, ThreadKeyModel.class);
            return this.ad;
        }

        @Nullable
        public final String ab() {
            this.ae = super.a(this.ae, 53);
            return this.ae;
        }

        @Nullable
        public final String ac() {
            this.af = super.a(this.af, 54);
            return this.af;
        }

        @Nullable
        public final VideoChannelModel aF() {
            this.ag = (VideoChannelModel) super.a(this.ag, 55, VideoChannelModel.class);
            return this.ag;
        }

        public static ReactionStoryAttachmentActionFragmentModel m16357a(ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel) {
            int i = 0;
            if (reactionStoryAttachmentActionFragmentModel == null) {
                return null;
            }
            if (reactionStoryAttachmentActionFragmentModel instanceof ReactionStoryAttachmentActionFragmentModel) {
                return reactionStoryAttachmentActionFragmentModel;
            }
            int i2;
            Builder builder = new Builder();
            builder.f13148a = reactionStoryAttachmentActionFragmentModel.mo875a();
            builder.f13149b = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentActionFragmentModel.mo880b());
            builder.f13150c = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentActionFragmentModel.mo881c());
            builder.f13151d = ReactionImageFieldsModel.m14497a(reactionStoryAttachmentActionFragmentModel.mo882d());
            builder.f13152e = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentActionFragmentModel.fU_());
            builder.f13153f = DefaultTextWithEntitiesFieldsModel.a(reactionStoryAttachmentActionFragmentModel.mo886g());
            builder.f13154g = reactionStoryAttachmentActionFragmentModel.fS_();
            builder.f13155h = ActionOgObjectModel.m16133a(reactionStoryAttachmentActionFragmentModel.fT_());
            builder.f13156i = reactionStoryAttachmentActionFragmentModel.mo887j();
            builder.f13157j = AlbumModel.m16165a(reactionStoryAttachmentActionFragmentModel.mo888k());
            builder.f13158k = reactionStoryAttachmentActionFragmentModel.mo889l();
            builder.f13159l = CollectionModel.m16264a(reactionStoryAttachmentActionFragmentModel.mo890m());
            builder.f13160m = CommentModel.m16418a(reactionStoryAttachmentActionFragmentModel.mo891n());
            builder.f13161n = reactionStoryAttachmentActionFragmentModel.mo892o();
            builder.f13162o = ComposerInlineActivityModel.m15993a(reactionStoryAttachmentActionFragmentModel.mo893p());
            builder.f13163p = reactionStoryAttachmentActionFragmentModel.mo894q();
            builder.f13164q = reactionStoryAttachmentActionFragmentModel.mo895r();
            builder.f13165r = reactionStoryAttachmentActionFragmentModel.mo896s();
            builder.f13166s = EventModel.m15792a(reactionStoryAttachmentActionFragmentModel.mo897t());
            builder.f13167t = EventSpaceModel.m16006a(reactionStoryAttachmentActionFragmentModel.mo898u());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < reactionStoryAttachmentActionFragmentModel.mo899v().size(); i2++) {
                builder2.c(ReactionWeatherSettingsPlaceItemFragmentModel.m16500a((ReactionWeatherSettingsPlaceItemFragmentModel) reactionStoryAttachmentActionFragmentModel.mo899v().get(i2)));
            }
            builder.f13168u = builder2.b();
            builder.f13169v = FriendModel.m16078a(reactionStoryAttachmentActionFragmentModel.mo900w());
            builder.f13170w = reactionStoryAttachmentActionFragmentModel.mo901x();
            builder.f13171x = FundraiserModel.m16470a(reactionStoryAttachmentActionFragmentModel.mo902y());
            builder.f13172y = FundraiserCampaignModel.m16116a(reactionStoryAttachmentActionFragmentModel.mo903z());
            builder.f13173z = GroupModel.m15811a(reactionStoryAttachmentActionFragmentModel.mo849A());
            builder.f13122A = reactionStoryAttachmentActionFragmentModel.mo850B();
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < reactionStoryAttachmentActionFragmentModel.ae().size(); i2++) {
                builder2.c(ReactionStoryAttachmentActionCommonFragmentModel.m16302a((ReactionStoryAttachmentActionCommonFragment) reactionStoryAttachmentActionFragmentModel.ae().get(i2)));
            }
            builder.f13123B = builder2.b();
            builder.f13124C = DefaultLocationFieldsModel.a(reactionStoryAttachmentActionFragmentModel.mo851C());
            builder.f13125D = MatchPageModel.m16187a(reactionStoryAttachmentActionFragmentModel.mo852D());
            builder.f13126E = reactionStoryAttachmentActionFragmentModel.mo853E();
            builder.f13127F = PageModel.m15820a(reactionStoryAttachmentActionFragmentModel.mo854F());
            builder.f13128G = reactionStoryAttachmentActionFragmentModel.mo855G();
            builder.f13129H = reactionStoryAttachmentActionFragmentModel.mo856H();
            builder.f13130I = reactionStoryAttachmentActionFragmentModel.mo857I();
            builder.f13131J = PlacesQueryLocationPageModel.m16149a(reactionStoryAttachmentActionFragmentModel.mo858J());
            builder.f13132K = reactionStoryAttachmentActionFragmentModel.mo859K();
            builder.f13133L = reactionStoryAttachmentActionFragmentModel.mo860L();
            builder.f13134M = ProfileModel.m15833a(reactionStoryAttachmentActionFragmentModel.mo861M());
            builder.f13135N = reactionStoryAttachmentActionFragmentModel.mo862N();
            builder.f13136O = reactionStoryAttachmentActionFragmentModel.mo863O();
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            while (i < reactionStoryAttachmentActionFragmentModel.mo864P().size()) {
                builder3.c(RelatedUsersModel.m15864a((RelatedUsersModel) reactionStoryAttachmentActionFragmentModel.mo864P().get(i)));
                i++;
            }
            builder.f13137P = builder3.b();
            builder.f13138Q = ReplacementUnitModel.m16248a(reactionStoryAttachmentActionFragmentModel.mo865Q());
            builder.f13139R = PageServiceItemModel.m11119a(reactionStoryAttachmentActionFragmentModel.mo866R());
            builder.f13140S = reactionStoryAttachmentActionFragmentModel.mo867S();
            builder.f13141T = reactionStoryAttachmentActionFragmentModel.mo868T();
            builder.f13142U = reactionStoryAttachmentActionFragmentModel.mo869U();
            builder.f13143V = StoryModel.m15883a(reactionStoryAttachmentActionFragmentModel.mo870V());
            builder.f13144W = reactionStoryAttachmentActionFragmentModel.mo871W();
            builder.f13145X = reactionStoryAttachmentActionFragmentModel.mo872X();
            builder.f13146Y = ReactionEventInviteFieldsModel.m16041a(reactionStoryAttachmentActionFragmentModel.mo873Y());
            builder.f13147Z = reactionStoryAttachmentActionFragmentModel.mo874Z();
            builder.aa = ThreadKeyModel.m16278a(reactionStoryAttachmentActionFragmentModel.aa());
            builder.ab = reactionStoryAttachmentActionFragmentModel.ab();
            builder.ac = reactionStoryAttachmentActionFragmentModel.ac();
            builder.ad = VideoChannelModel.m16202a(reactionStoryAttachmentActionFragmentModel.ad());
            return builder.m16354a();
        }

        public final int jK_() {
            return 1194715522;
        }

        public final GraphQLVisitableModel m16386a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            com.google.common.collect.ImmutableList.Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (af() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(af());
                if (af() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13201e = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (ag() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ag());
                if (ag() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13202f = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (ah() != null) {
                ReactionImageFieldsModel reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(ah());
                if (ah() != reactionImageFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13203g = reactionImageFieldsModel;
                }
            }
            if (ai() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(ai());
                if (ai() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13204h = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (aj() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(aj());
                if (aj() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13205i = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (ak() != null) {
                ActionOgObjectModel actionOgObjectModel = (ActionOgObjectModel) graphQLModelMutatingVisitor.b(ak());
                if (ak() != actionOgObjectModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13207k = actionOgObjectModel;
                }
            }
            if (al() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(al());
                if (al() != albumModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13209m = albumModel;
                }
            }
            if (am() != null) {
                CollectionModel collectionModel = (CollectionModel) graphQLModelMutatingVisitor.b(am());
                if (am() != collectionModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13211o = collectionModel;
                }
            }
            if (an() != null) {
                CommentModel commentModel = (CommentModel) graphQLModelMutatingVisitor.b(an());
                if (an() != commentModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13212p = commentModel;
                }
            }
            if (ao() != null) {
                ComposerInlineActivityModel composerInlineActivityModel = (ComposerInlineActivityModel) graphQLModelMutatingVisitor.b(ao());
                if (ao() != composerInlineActivityModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13214r = composerInlineActivityModel;
                }
            }
            if (ap() != null) {
                EventModel eventModel = (EventModel) graphQLModelMutatingVisitor.b(ap());
                if (ap() != eventModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13218v = eventModel;
                }
            }
            if (aq() != null) {
                EventSpaceModel eventSpaceModel = (EventSpaceModel) graphQLModelMutatingVisitor.b(aq());
                if (aq() != eventSpaceModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13219w = eventSpaceModel;
                }
            }
            if (mo899v() != null) {
                a = ModelHelper.a(mo899v(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    reactionStoryAttachmentActionFragmentModel.f13220x = a.b();
                    graphQLVisitableModel = reactionStoryAttachmentActionFragmentModel;
                }
            }
            if (ar() != null) {
                FriendModel friendModel = (FriendModel) graphQLModelMutatingVisitor.b(ar());
                if (ar() != friendModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13221y = friendModel;
                }
            }
            if (as() != null) {
                FundraiserModel fundraiserModel = (FundraiserModel) graphQLModelMutatingVisitor.b(as());
                if (as() != fundraiserModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13174A = fundraiserModel;
                }
            }
            if (at() != null) {
                FundraiserCampaignModel fundraiserCampaignModel = (FundraiserCampaignModel) graphQLModelMutatingVisitor.b(at());
                if (at() != fundraiserCampaignModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13175B = fundraiserCampaignModel;
                }
            }
            if (au() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(au());
                if (au() != groupModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13176C = groupModel;
                }
            }
            if (ae() != null) {
                a = ModelHelper.a(ae(), graphQLModelMutatingVisitor);
                if (a != null) {
                    reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    reactionStoryAttachmentActionFragmentModel.f13178E = a.b();
                    graphQLVisitableModel = reactionStoryAttachmentActionFragmentModel;
                }
            }
            if (av() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(av());
                if (av() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13179F = defaultLocationFieldsModel;
                }
            }
            if (aw() != null) {
                MatchPageModel matchPageModel = (MatchPageModel) graphQLModelMutatingVisitor.b(aw());
                if (aw() != matchPageModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13180G = matchPageModel;
                }
            }
            if (ax() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(ax());
                if (ax() != pageModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13182I = pageModel;
                }
            }
            if (ay() != null) {
                PlacesQueryLocationPageModel placesQueryLocationPageModel = (PlacesQueryLocationPageModel) graphQLModelMutatingVisitor.b(ay());
                if (ay() != placesQueryLocationPageModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13186M = placesQueryLocationPageModel;
                }
            }
            if (az() != null) {
                ProfileModel profileModel = (ProfileModel) graphQLModelMutatingVisitor.b(az());
                if (az() != profileModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13189P = profileModel;
                }
            }
            if (mo864P() != null) {
                a = ModelHelper.a(mo864P(), graphQLModelMutatingVisitor);
                if (a != null) {
                    reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    reactionStoryAttachmentActionFragmentModel.f13192S = a.b();
                    graphQLVisitableModel = reactionStoryAttachmentActionFragmentModel;
                }
            }
            if (aA() != null) {
                ReplacementUnitModel replacementUnitModel = (ReplacementUnitModel) graphQLModelMutatingVisitor.b(aA());
                if (aA() != replacementUnitModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13193T = replacementUnitModel;
                }
            }
            if (aB() != null) {
                PageServiceItemModel pageServiceItemModel = (PageServiceItemModel) graphQLModelMutatingVisitor.b(aB());
                if (aB() != pageServiceItemModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13194U = pageServiceItemModel;
                }
            }
            if (aC() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(aC());
                if (aC() != storyModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13198Y = storyModel;
                }
            }
            if (aD() != null) {
                ReactionEventInviteFieldsModel reactionEventInviteFieldsModel = (ReactionEventInviteFieldsModel) graphQLModelMutatingVisitor.b(aD());
                if (aD() != reactionEventInviteFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ab = reactionEventInviteFieldsModel;
                }
            }
            if (aE() != null) {
                ThreadKeyModel threadKeyModel = (ThreadKeyModel) graphQLModelMutatingVisitor.b(aE());
                if (aE() != threadKeyModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ad = threadKeyModel;
                }
            }
            if (aF() != null) {
                VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(aF());
                if (aF() != videoChannelModel) {
                    graphQLVisitableModel = (ReactionStoryAttachmentActionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ag = videoChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16384a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo875a());
            int a2 = ModelHelper.a(flatBufferBuilder, af());
            int a3 = ModelHelper.a(flatBufferBuilder, ag());
            int a4 = ModelHelper.a(flatBufferBuilder, ah());
            int a5 = ModelHelper.a(flatBufferBuilder, ai());
            int a6 = ModelHelper.a(flatBufferBuilder, aj());
            int a7 = ModelHelper.a(flatBufferBuilder, ak());
            int a8 = flatBufferBuilder.a(mo887j());
            int a9 = ModelHelper.a(flatBufferBuilder, al());
            int a10 = ModelHelper.a(flatBufferBuilder, am());
            int a11 = ModelHelper.a(flatBufferBuilder, an());
            int b = flatBufferBuilder.b(mo892o());
            int a12 = ModelHelper.a(flatBufferBuilder, ao());
            int a13 = flatBufferBuilder.a(mo894q());
            int b2 = flatBufferBuilder.b(mo895r());
            int a14 = flatBufferBuilder.a(mo896s());
            int a15 = ModelHelper.a(flatBufferBuilder, ap());
            int a16 = ModelHelper.a(flatBufferBuilder, aq());
            int a17 = ModelHelper.a(flatBufferBuilder, mo899v());
            int a18 = ModelHelper.a(flatBufferBuilder, ar());
            int b3 = flatBufferBuilder.b(mo901x());
            int a19 = ModelHelper.a(flatBufferBuilder, as());
            int a20 = ModelHelper.a(flatBufferBuilder, at());
            int a21 = ModelHelper.a(flatBufferBuilder, au());
            int a22 = flatBufferBuilder.a(mo850B());
            int a23 = ModelHelper.a(flatBufferBuilder, ae());
            int a24 = ModelHelper.a(flatBufferBuilder, av());
            int a25 = ModelHelper.a(flatBufferBuilder, aw());
            int a26 = flatBufferBuilder.a(mo853E());
            int a27 = ModelHelper.a(flatBufferBuilder, ax());
            int b4 = flatBufferBuilder.b(mo855G());
            int a28 = flatBufferBuilder.a(mo856H());
            int b5 = flatBufferBuilder.b(mo857I());
            int a29 = ModelHelper.a(flatBufferBuilder, ay());
            int b6 = flatBufferBuilder.b(mo859K());
            int b7 = flatBufferBuilder.b(mo860L());
            int a30 = ModelHelper.a(flatBufferBuilder, az());
            int b8 = flatBufferBuilder.b(mo862N());
            int b9 = flatBufferBuilder.b(mo863O());
            int a31 = ModelHelper.a(flatBufferBuilder, mo864P());
            int a32 = ModelHelper.a(flatBufferBuilder, aA());
            int a33 = ModelHelper.a(flatBufferBuilder, aB());
            int b10 = flatBufferBuilder.b(mo867S());
            int b11 = flatBufferBuilder.b(mo868T());
            int b12 = flatBufferBuilder.b(mo869U());
            int a34 = ModelHelper.a(flatBufferBuilder, aC());
            int b13 = flatBufferBuilder.b(mo872X());
            int a35 = ModelHelper.a(flatBufferBuilder, aD());
            int b14 = flatBufferBuilder.b(mo874Z());
            int a36 = ModelHelper.a(flatBufferBuilder, aE());
            int b15 = flatBufferBuilder.b(ab());
            int b16 = flatBufferBuilder.b(ac());
            int a37 = ModelHelper.a(flatBufferBuilder, aF());
            flatBufferBuilder.c(56);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.a(6, this.f13206j);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, a8);
            flatBufferBuilder.b(9, a9);
            flatBufferBuilder.a(10, this.f13210n);
            flatBufferBuilder.b(11, a10);
            flatBufferBuilder.b(12, a11);
            flatBufferBuilder.b(13, b);
            flatBufferBuilder.b(14, a12);
            flatBufferBuilder.b(15, a13);
            flatBufferBuilder.b(16, b2);
            flatBufferBuilder.b(17, a14);
            flatBufferBuilder.b(18, a15);
            flatBufferBuilder.b(19, a16);
            flatBufferBuilder.b(20, a17);
            flatBufferBuilder.b(21, a18);
            flatBufferBuilder.b(22, b3);
            flatBufferBuilder.b(23, a19);
            flatBufferBuilder.b(24, a20);
            flatBufferBuilder.b(25, a21);
            flatBufferBuilder.b(26, a22);
            flatBufferBuilder.b(27, a23);
            flatBufferBuilder.b(28, a24);
            flatBufferBuilder.b(29, a25);
            flatBufferBuilder.b(30, a26);
            flatBufferBuilder.b(31, a27);
            flatBufferBuilder.b(32, b4);
            flatBufferBuilder.b(33, a28);
            flatBufferBuilder.b(34, b5);
            flatBufferBuilder.b(35, a29);
            flatBufferBuilder.b(36, b6);
            flatBufferBuilder.b(37, b7);
            flatBufferBuilder.b(38, a30);
            flatBufferBuilder.b(39, b8);
            flatBufferBuilder.b(40, b9);
            flatBufferBuilder.b(41, a31);
            flatBufferBuilder.b(42, a32);
            flatBufferBuilder.b(43, a33);
            flatBufferBuilder.b(44, b10);
            flatBufferBuilder.b(45, b11);
            flatBufferBuilder.b(46, b12);
            flatBufferBuilder.b(47, a34);
            flatBufferBuilder.a(48, this.f13199Z);
            flatBufferBuilder.b(49, b13);
            flatBufferBuilder.b(50, a35);
            flatBufferBuilder.b(51, b14);
            flatBufferBuilder.b(52, a36);
            flatBufferBuilder.b(53, b15);
            flatBufferBuilder.b(54, b16);
            flatBufferBuilder.b(55, a37);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16387a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13206j = mutableFlatBuffer.a(i, 6);
            this.f13210n = mutableFlatBuffer.a(i, 10);
            this.f13199Z = mutableFlatBuffer.a(i, 48);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -765884702)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionViewCommentActionFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionViewCommentActionFields {
        @Nullable
        private CommentModel f13231d;
        @Nullable
        private StoryModel f13232e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1327317554)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class CommentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private CommentParentModel f13227d;
            @Nullable
            private String f13228e;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public CommentParentModel f13223a;
                @Nullable
                public String f13224b;
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: field_icon */
            public final class CommentParentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f13226d;

                /* compiled from: field_icon */
                public final class Builder {
                    @Nullable
                    public String f13225a;
                }

                /* compiled from: field_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CommentParentModel.class, new Deserializer());
                    }

                    public Object m16409a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CommentParentParser.m16605a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object commentParentModel = new CommentParentModel();
                        ((BaseModel) commentParentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (commentParentModel instanceof Postprocessable) {
                            return ((Postprocessable) commentParentModel).a();
                        }
                        return commentParentModel;
                    }
                }

                /* compiled from: field_icon */
                public class Serializer extends JsonSerializer<CommentParentModel> {
                    public final void m16410a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CommentParentModel commentParentModel = (CommentParentModel) obj;
                        if (commentParentModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(commentParentModel.m16412a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            commentParentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CommentParentParser.m16606a(commentParentModel.w_(), commentParentModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CommentParentModel.class, new Serializer());
                    }
                }

                public CommentParentModel() {
                    super(1);
                }

                public CommentParentModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m16415b() {
                    this.f13226d = super.a(this.f13226d, 0);
                    return this.f13226d;
                }

                public static CommentParentModel m16411a(CommentParentModel commentParentModel) {
                    if (commentParentModel == null) {
                        return null;
                    }
                    if (commentParentModel instanceof CommentParentModel) {
                        return commentParentModel;
                    }
                    Builder builder = new Builder();
                    builder.f13225a = commentParentModel.m16415b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f13225a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new CommentParentModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                @Nullable
                public final String m16414a() {
                    return m16415b();
                }

                public final int jK_() {
                    return -1679915457;
                }

                public final GraphQLVisitableModel m16413a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16412a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16415b());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommentModel.class, new Deserializer());
                }

                public Object m16416a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommentParser.m16607a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object commentModel = new CommentModel();
                    ((BaseModel) commentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (commentModel instanceof Postprocessable) {
                        return ((Postprocessable) commentModel).a();
                    }
                    return commentModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<CommentModel> {
                public final void m16417a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommentModel commentModel = (CommentModel) obj;
                    if (commentModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commentModel.m16420a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommentParser.m16608a(commentModel.w_(), commentModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CommentModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ CommentParentModel m16423b() {
                return m16419j();
            }

            public CommentModel() {
                super(2);
            }

            public CommentModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private CommentParentModel m16419j() {
                this.f13227d = (CommentParentModel) super.a(this.f13227d, 0, CommentParentModel.class);
                return this.f13227d;
            }

            @Nullable
            public final String m16424c() {
                this.f13228e = super.a(this.f13228e, 1);
                return this.f13228e;
            }

            public static CommentModel m16418a(CommentModel commentModel) {
                if (commentModel == null) {
                    return null;
                }
                if (commentModel instanceof CommentModel) {
                    return commentModel;
                }
                Builder builder = new Builder();
                builder.f13223a = CommentParentModel.m16411a(commentModel.m16423b());
                builder.f13224b = commentModel.m16424c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f13223a);
                int b = flatBufferBuilder.b(builder.f13224b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CommentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16422a() {
                return m16424c();
            }

            public final int jK_() {
                return -1679915457;
            }

            public final GraphQLVisitableModel m16421a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16419j() != null) {
                    CommentParentModel commentParentModel = (CommentParentModel) graphQLModelMutatingVisitor.b(m16419j());
                    if (m16419j() != commentParentModel) {
                        graphQLVisitableModel = (CommentModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13227d = commentParentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16420a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16419j());
                int b = flatBufferBuilder.b(m16424c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionViewCommentActionFieldsModel.class, new Deserializer());
            }

            public Object m16425a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionViewCommentActionFieldsParser.m16611a(jsonParser);
                Object reactionViewCommentActionFieldsModel = new ReactionViewCommentActionFieldsModel();
                ((BaseModel) reactionViewCommentActionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionViewCommentActionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionViewCommentActionFieldsModel).a();
                }
                return reactionViewCommentActionFieldsModel;
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionViewCommentActionFieldsModel> {
            public final void m16426a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionViewCommentActionFieldsModel reactionViewCommentActionFieldsModel = (ReactionViewCommentActionFieldsModel) obj;
                if (reactionViewCommentActionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionViewCommentActionFieldsModel.m16438a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionViewCommentActionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionViewCommentActionFieldsModel.w_();
                int u_ = reactionViewCommentActionFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("comment");
                    CommentParser.m16608a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("story");
                    ReactionViewCommentActionFieldsParser.StoryParser.m16610a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionViewCommentActionFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1739105429)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class StoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f13229d;
            @Nullable
            private String f13230e;

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StoryModel.class, new Deserializer());
                }

                public Object m16427a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionViewCommentActionFieldsParser.StoryParser.m16609a(jsonParser, flatBufferBuilder));
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

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<StoryModel> {
                public final void m16428a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StoryModel storyModel = (StoryModel) obj;
                    if (storyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(storyModel.m16431a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        storyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionViewCommentActionFieldsParser.StoryParser.m16610a(storyModel.w_(), storyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(StoryModel.class, new Serializer());
                }
            }

            public StoryModel() {
                super(2);
            }

            public final void m16434a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16435a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m16429j() {
                this.f13229d = super.a(this.f13229d, 0);
                return this.f13229d;
            }

            @Nullable
            private String m16430k() {
                this.f13230e = super.a(this.f13230e, 1);
                return this.f13230e;
            }

            @Nullable
            public final String m16433a() {
                return m16430k();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m16432a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16431a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16429j());
                int b2 = flatBufferBuilder.b(m16430k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ReactionViewCommentActionFieldsModel() {
            super(2);
        }

        @Nullable
        private CommentModel m16436a() {
            this.f13231d = (CommentModel) super.a(this.f13231d, 0, CommentModel.class);
            return this.f13231d;
        }

        @Nullable
        private StoryModel m16437j() {
            this.f13232e = (StoryModel) super.a(this.f13232e, 1, StoryModel.class);
            return this.f13232e;
        }

        public final int jK_() {
            return 168115079;
        }

        public final GraphQLVisitableModel m16439a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16436a() != null) {
                CommentModel commentModel = (CommentModel) graphQLModelMutatingVisitor.b(m16436a());
                if (m16436a() != commentModel) {
                    graphQLVisitableModel = (ReactionViewCommentActionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13231d = commentModel;
                }
            }
            if (m16437j() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m16437j());
                if (m16437j() != storyModel) {
                    graphQLVisitableModel = (ReactionViewCommentActionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13232e = storyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16438a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16436a());
            int a2 = ModelHelper.a(flatBufferBuilder, m16437j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1608960257)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionViewEventGuestListActionFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionViewEventGuestListActionFields {
        @Nullable
        private EventModel f13241d;
        @Nullable
        private GraphQLEventWatchStatus f13242e;

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionViewEventGuestListActionFieldsModel.class, new Deserializer());
            }

            public Object m16440a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionViewEventGuestListActionFieldsParser.m16616a(jsonParser);
                Object reactionViewEventGuestListActionFieldsModel = new ReactionViewEventGuestListActionFieldsModel();
                ((BaseModel) reactionViewEventGuestListActionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionViewEventGuestListActionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionViewEventGuestListActionFieldsModel).a();
                }
                return reactionViewEventGuestListActionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -46951257)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class EventModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ReactionViewEventGuestListActionFields.Event {
            @Nullable
            private GraphQLConnectionStyle f13235d;
            @Nullable
            private GraphQLEventPrivacyType f13236e;
            @Nullable
            private EventViewerCapabilityModel f13237f;
            @Nullable
            private String f13238g;
            @Nullable
            private String f13239h;
            @Nullable
            private GraphQLEventGuestStatus f13240i;

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventModel.class, new Deserializer());
                }

                public Object m16441a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionViewEventGuestListActionFieldsParser.EventParser.m16614a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1484883804)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: field_icon */
            public final class EventViewerCapabilityModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f13234d;

                /* compiled from: field_icon */
                public final class Builder {
                    public boolean f13233a;
                }

                /* compiled from: field_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EventViewerCapabilityModel.class, new Deserializer());
                    }

                    public Object m16442a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ReactionViewEventGuestListActionFieldsParser.EventParser.EventViewerCapabilityParser.m16612a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object eventViewerCapabilityModel = new EventViewerCapabilityModel();
                        ((BaseModel) eventViewerCapabilityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (eventViewerCapabilityModel instanceof Postprocessable) {
                            return ((Postprocessable) eventViewerCapabilityModel).a();
                        }
                        return eventViewerCapabilityModel;
                    }
                }

                /* compiled from: field_icon */
                public class Serializer extends JsonSerializer<EventViewerCapabilityModel> {
                    public final void m16443a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EventViewerCapabilityModel eventViewerCapabilityModel = (EventViewerCapabilityModel) obj;
                        if (eventViewerCapabilityModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(eventViewerCapabilityModel.m16445a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            eventViewerCapabilityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ReactionViewEventGuestListActionFieldsParser.EventParser.EventViewerCapabilityParser.m16613a(eventViewerCapabilityModel.w_(), eventViewerCapabilityModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(EventViewerCapabilityModel.class, new Serializer());
                    }
                }

                public EventViewerCapabilityModel() {
                    super(1);
                }

                public EventViewerCapabilityModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final boolean m16448a() {
                    a(0, 0);
                    return this.f13234d;
                }

                public static EventViewerCapabilityModel m16444a(EventViewerCapabilityModel eventViewerCapabilityModel) {
                    if (eventViewerCapabilityModel == null) {
                        return null;
                    }
                    if (eventViewerCapabilityModel instanceof EventViewerCapabilityModel) {
                        return eventViewerCapabilityModel;
                    }
                    Builder builder = new Builder();
                    builder.f13233a = eventViewerCapabilityModel.m16448a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, builder.f13233a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventViewerCapabilityModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1910188188;
                }

                public final GraphQLVisitableModel m16446a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16445a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f13234d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16447a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f13234d = mutableFlatBuffer.a(i, 0);
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<EventModel> {
                public final void m16449a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventModel eventModel = (EventModel) obj;
                    if (eventModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventModel.m16453a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionViewEventGuestListActionFieldsParser.EventParser.m16615a(eventModel.w_(), eventModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EventModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ EventViewerCapabilityModel fD_() {
                return m16452j();
            }

            public EventModel() {
                super(6);
            }

            public final void m16456a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = fC_();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 4;
                } else if ("viewer_guest_status".equals(str)) {
                    consistencyTuple.a = mo839k();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 5;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m16457a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m16451a((String) obj);
                } else if ("viewer_guest_status".equals(str)) {
                    m16450a((GraphQLEventGuestStatus) obj);
                }
            }

            @Nullable
            public final GraphQLConnectionStyle mo834b() {
                this.f13235d = (GraphQLConnectionStyle) super.b(this.f13235d, 0, GraphQLConnectionStyle.class, GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f13235d;
            }

            @Nullable
            public final GraphQLEventPrivacyType mo835c() {
                this.f13236e = (GraphQLEventPrivacyType) super.b(this.f13236e, 1, GraphQLEventPrivacyType.class, GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f13236e;
            }

            @Nullable
            private EventViewerCapabilityModel m16452j() {
                this.f13237f = (EventViewerCapabilityModel) super.a(this.f13237f, 2, EventViewerCapabilityModel.class);
                return this.f13237f;
            }

            @Nullable
            public final String mo838g() {
                this.f13238g = super.a(this.f13238g, 3);
                return this.f13238g;
            }

            @Nullable
            public final String fC_() {
                this.f13239h = super.a(this.f13239h, 4);
                return this.f13239h;
            }

            private void m16451a(@Nullable String str) {
                this.f13239h = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 4, str);
                }
            }

            @Nullable
            public final GraphQLEventGuestStatus mo839k() {
                this.f13240i = (GraphQLEventGuestStatus) super.b(this.f13240i, 5, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f13240i;
            }

            private void m16450a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
                this.f13240i = graphQLEventGuestStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 5, graphQLEventGuestStatus != null ? graphQLEventGuestStatus.name() : null);
                }
            }

            @Nullable
            public final String m16455a() {
                return mo838g();
            }

            public final int jK_() {
                return 67338874;
            }

            public final GraphQLVisitableModel m16454a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16452j() != null) {
                    EventViewerCapabilityModel eventViewerCapabilityModel = (EventViewerCapabilityModel) graphQLModelMutatingVisitor.b(m16452j());
                    if (m16452j() != eventViewerCapabilityModel) {
                        graphQLVisitableModel = (EventModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13237f = eventViewerCapabilityModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16453a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(mo834b());
                int a2 = flatBufferBuilder.a(mo835c());
                int a3 = ModelHelper.a(flatBufferBuilder, m16452j());
                int b = flatBufferBuilder.b(mo838g());
                int b2 = flatBufferBuilder.b(fC_());
                int a4 = flatBufferBuilder.a(mo839k());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionViewEventGuestListActionFieldsModel> {
            public final void m16462a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionViewEventGuestListActionFieldsModel reactionViewEventGuestListActionFieldsModel = (ReactionViewEventGuestListActionFieldsModel) obj;
                if (reactionViewEventGuestListActionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionViewEventGuestListActionFieldsModel.m16465a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionViewEventGuestListActionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionViewEventGuestListActionFieldsModel.w_();
                int u_ = reactionViewEventGuestListActionFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("event");
                    ReactionViewEventGuestListActionFieldsParser.EventParser.m16615a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("guest_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionViewEventGuestListActionFieldsModel.class, new Serializer());
            }
        }

        public ReactionViewEventGuestListActionFieldsModel() {
            super(2);
        }

        @Nullable
        private EventModel m16463a() {
            this.f13241d = (EventModel) super.a(this.f13241d, 0, EventModel.class);
            return this.f13241d;
        }

        @Nullable
        private GraphQLEventWatchStatus m16464j() {
            this.f13242e = (GraphQLEventWatchStatus) super.b(this.f13242e, 1, GraphQLEventWatchStatus.class, GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13242e;
        }

        public final int jK_() {
            return -1688418272;
        }

        public final GraphQLVisitableModel m16466a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16463a() != null) {
                EventModel eventModel = (EventModel) graphQLModelMutatingVisitor.b(m16463a());
                if (m16463a() != eventModel) {
                    graphQLVisitableModel = (ReactionViewEventGuestListActionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13241d = eventModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16465a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16463a());
            int a2 = flatBufferBuilder.a(m16464j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 683995881)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionViewFundraiserSupportersActionFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionViewFundraiserSupportersActionFields {
        @Nullable
        private GraphQLFundraiserSupportersConnectionType f13245d;
        @Nullable
        private FundraiserModel f13246e;

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionViewFundraiserSupportersActionFieldsModel.class, new Deserializer());
            }

            public Object m16467a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionViewFundraiserSupportersActionFieldsParser.m16619a(jsonParser);
                Object reactionViewFundraiserSupportersActionFieldsModel = new ReactionViewFundraiserSupportersActionFieldsModel();
                ((BaseModel) reactionViewFundraiserSupportersActionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionViewFundraiserSupportersActionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionViewFundraiserSupportersActionFieldsModel).a();
                }
                return reactionViewFundraiserSupportersActionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class FundraiserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f13244d;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public String f13243a;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FundraiserModel.class, new Deserializer());
                }

                public Object m16468a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FundraiserParser.m16617a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object fundraiserModel = new FundraiserModel();
                    ((BaseModel) fundraiserModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (fundraiserModel instanceof Postprocessable) {
                        return ((Postprocessable) fundraiserModel).a();
                    }
                    return fundraiserModel;
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<FundraiserModel> {
                public final void m16469a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FundraiserModel fundraiserModel = (FundraiserModel) obj;
                    if (fundraiserModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(fundraiserModel.m16471a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        fundraiserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FundraiserParser.m16618a(fundraiserModel.w_(), fundraiserModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FundraiserModel.class, new Serializer());
                }
            }

            public FundraiserModel() {
                super(1);
            }

            public FundraiserModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m16474b() {
                this.f13244d = super.a(this.f13244d, 0);
                return this.f13244d;
            }

            public static FundraiserModel m16470a(FundraiserModel fundraiserModel) {
                if (fundraiserModel == null) {
                    return null;
                }
                if (fundraiserModel instanceof FundraiserModel) {
                    return fundraiserModel;
                }
                Builder builder = new Builder();
                builder.f13243a = fundraiserModel.m16474b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f13243a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FundraiserModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16473a() {
                return m16474b();
            }

            public final int jK_() {
                return -1315407331;
            }

            public final GraphQLVisitableModel m16472a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16471a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16474b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionViewFundraiserSupportersActionFieldsModel> {
            public final void m16475a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionViewFundraiserSupportersActionFieldsModel reactionViewFundraiserSupportersActionFieldsModel = (ReactionViewFundraiserSupportersActionFieldsModel) obj;
                if (reactionViewFundraiserSupportersActionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionViewFundraiserSupportersActionFieldsModel.m16478a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionViewFundraiserSupportersActionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionViewFundraiserSupportersActionFieldsModel.w_();
                int u_ = reactionViewFundraiserSupportersActionFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("connection_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("fundraiser");
                    FundraiserParser.m16618a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionViewFundraiserSupportersActionFieldsModel.class, new Serializer());
            }
        }

        public ReactionViewFundraiserSupportersActionFieldsModel() {
            super(2);
        }

        @Nullable
        private GraphQLFundraiserSupportersConnectionType m16476a() {
            this.f13245d = (GraphQLFundraiserSupportersConnectionType) super.b(this.f13245d, 0, GraphQLFundraiserSupportersConnectionType.class, GraphQLFundraiserSupportersConnectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13245d;
        }

        @Nullable
        private FundraiserModel m16477j() {
            this.f13246e = (FundraiserModel) super.a(this.f13246e, 1, FundraiserModel.class);
            return this.f13246e;
        }

        public final int jK_() {
            return 1387794086;
        }

        public final GraphQLVisitableModel m16479a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16477j() != null) {
                FundraiserModel fundraiserModel = (FundraiserModel) graphQLModelMutatingVisitor.b(m16477j());
                if (m16477j() != fundraiserModel) {
                    graphQLVisitableModel = (ReactionViewFundraiserSupportersActionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13246e = fundraiserModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16478a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m16476a());
            int a2 = ModelHelper.a(flatBufferBuilder, m16477j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1740651241)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: field_icon */
    public final class ReactionWeatherSettingsPlaceItemFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProfileModel f13258d;

        /* compiled from: field_icon */
        public final class Builder {
            @Nullable
            public ProfileModel f13247a;
        }

        /* compiled from: field_icon */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionWeatherSettingsPlaceItemFragmentModel.class, new Deserializer());
            }

            public Object m16480a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionWeatherSettingsPlaceItemFragmentParser.m16624a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionWeatherSettingsPlaceItemFragmentModel = new ReactionWeatherSettingsPlaceItemFragmentModel();
                ((BaseModel) reactionWeatherSettingsPlaceItemFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionWeatherSettingsPlaceItemFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionWeatherSettingsPlaceItemFragmentModel).a();
                }
                return reactionWeatherSettingsPlaceItemFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2086748564)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: field_icon */
        public final class ProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f13254d;
            @Nullable
            private String f13255e;
            @Nullable
            private String f13256f;
            @Nullable
            private ProfilePictureModel f13257g;

            /* compiled from: field_icon */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f13248a;
                @Nullable
                public String f13249b;
                @Nullable
                public String f13250c;
                @Nullable
                public ProfilePictureModel f13251d;
            }

            /* compiled from: field_icon */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileModel.class, new Deserializer());
                }

                public Object m16481a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionWeatherSettingsPlaceItemFragmentParser.ProfileParser.m16622a(jsonParser, flatBufferBuilder));
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
            /* compiled from: field_icon */
            public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f13253d;

                /* compiled from: field_icon */
                public final class Builder {
                    @Nullable
                    public String f13252a;
                }

                /* compiled from: field_icon */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                    }

                    public Object m16482a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfilePictureParser.m16620a(jsonParser, flatBufferBuilder));
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

                /* compiled from: field_icon */
                public class Serializer extends JsonSerializer<ProfilePictureModel> {
                    public final void m16483a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                        if (profilePictureModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(profilePictureModel.m16485a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfilePictureParser.m16621a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                    }
                }

                public ProfilePictureModel() {
                    super(1);
                }

                public ProfilePictureModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m16487a() {
                    this.f13253d = super.a(this.f13253d, 0);
                    return this.f13253d;
                }

                public static ProfilePictureModel m16484a(ProfilePictureModel profilePictureModel) {
                    if (profilePictureModel == null) {
                        return null;
                    }
                    if (profilePictureModel instanceof ProfilePictureModel) {
                        return profilePictureModel;
                    }
                    Builder builder = new Builder();
                    builder.f13252a = profilePictureModel.m16487a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f13252a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ProfilePictureModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m16486a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16485a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16487a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: field_icon */
            public class Serializer extends JsonSerializer<ProfileModel> {
                public final void m16488a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileModel profileModel = (ProfileModel) obj;
                    if (profileModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileModel.m16491a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionWeatherSettingsPlaceItemFragmentParser.ProfileParser.m16623a(profileModel.w_(), profileModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ProfilePictureModel fV_() {
                return m16490j();
            }

            public ProfileModel() {
                super(4);
            }

            public ProfileModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m16494a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16495a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m16496b() {
                if (this.b != null && this.f13254d == null) {
                    this.f13254d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f13254d;
            }

            @Nullable
            public final String m16497c() {
                this.f13255e = super.a(this.f13255e, 1);
                return this.f13255e;
            }

            @Nullable
            public final String m16498d() {
                this.f13256f = super.a(this.f13256f, 2);
                return this.f13256f;
            }

            @Nullable
            private ProfilePictureModel m16490j() {
                this.f13257g = (ProfilePictureModel) super.a(this.f13257g, 3, ProfilePictureModel.class);
                return this.f13257g;
            }

            public static ProfileModel m16489a(ProfileModel profileModel) {
                if (profileModel == null) {
                    return null;
                }
                if (profileModel instanceof ProfileModel) {
                    return profileModel;
                }
                Builder builder = new Builder();
                builder.f13248a = profileModel.m16496b();
                builder.f13249b = profileModel.m16497c();
                builder.f13250c = profileModel.m16498d();
                builder.f13251d = ProfilePictureModel.m16484a(profileModel.fV_());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f13248a);
                int b = flatBufferBuilder.b(builder.f13249b);
                int b2 = flatBufferBuilder.b(builder.f13250c);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f13251d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ProfileModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16493a() {
                return m16497c();
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m16492a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16490j() != null) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m16490j());
                    if (m16490j() != profilePictureModel) {
                        graphQLVisitableModel = (ProfileModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13257g = profilePictureModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16491a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16496b());
                int b = flatBufferBuilder.b(m16497c());
                int b2 = flatBufferBuilder.b(m16498d());
                int a2 = ModelHelper.a(flatBufferBuilder, m16490j());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: field_icon */
        public class Serializer extends JsonSerializer<ReactionWeatherSettingsPlaceItemFragmentModel> {
            public final void m16499a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionWeatherSettingsPlaceItemFragmentModel reactionWeatherSettingsPlaceItemFragmentModel = (ReactionWeatherSettingsPlaceItemFragmentModel) obj;
                if (reactionWeatherSettingsPlaceItemFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionWeatherSettingsPlaceItemFragmentModel.m16502a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionWeatherSettingsPlaceItemFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionWeatherSettingsPlaceItemFragmentParser.m16627b(reactionWeatherSettingsPlaceItemFragmentModel.w_(), reactionWeatherSettingsPlaceItemFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReactionWeatherSettingsPlaceItemFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ProfileModel m16504a() {
            return m16501j();
        }

        public ReactionWeatherSettingsPlaceItemFragmentModel() {
            super(1);
        }

        public ReactionWeatherSettingsPlaceItemFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private ProfileModel m16501j() {
            this.f13258d = (ProfileModel) super.a(this.f13258d, 0, ProfileModel.class);
            return this.f13258d;
        }

        public static ReactionWeatherSettingsPlaceItemFragmentModel m16500a(ReactionWeatherSettingsPlaceItemFragmentModel reactionWeatherSettingsPlaceItemFragmentModel) {
            if (reactionWeatherSettingsPlaceItemFragmentModel == null) {
                return null;
            }
            if (reactionWeatherSettingsPlaceItemFragmentModel instanceof ReactionWeatherSettingsPlaceItemFragmentModel) {
                return reactionWeatherSettingsPlaceItemFragmentModel;
            }
            Builder builder = new Builder();
            builder.f13247a = ProfileModel.m16489a(reactionWeatherSettingsPlaceItemFragmentModel.m16504a());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f13247a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ReactionWeatherSettingsPlaceItemFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -504719321;
        }

        public final GraphQLVisitableModel m16503a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16501j() != null) {
                ProfileModel profileModel = (ProfileModel) graphQLModelMutatingVisitor.b(m16501j());
                if (m16501j() != profileModel) {
                    graphQLVisitableModel = (ReactionWeatherSettingsPlaceItemFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13258d = profileModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16502a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16501j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
