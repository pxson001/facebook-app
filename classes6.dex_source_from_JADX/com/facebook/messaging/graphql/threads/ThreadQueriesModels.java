package com.facebook.messaging.graphql.threads;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCommercePageType;
import com.facebook.graphql.enums.GraphQLExtensibleMessageAdminTextType;
import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.graphql.enums.GraphQLMNCommerceMessageType;
import com.facebook.graphql.enums.GraphQLMailboxFolder;
import com.facebook.graphql.enums.GraphQLMessageImageType;
import com.facebook.graphql.enums.GraphQLMessageThreadCannotReplyReason;
import com.facebook.graphql.enums.GraphQLMessageVideoType;
import com.facebook.graphql.enums.GraphQLMessengerAdPropertyType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageAdminReplyType;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentMessageType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesInterfaces.AttachmentAttribution;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesModels.AppAttributionInfoModel;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesModels.AttachmentAttributionModel.AttributionAppScopedIdsModel;
import com.facebook.messaging.graphql.threads.BotInfoModels.BotMessagingActorInfoModel;
import com.facebook.messaging.graphql.threads.GenieMessageQueriesModels.GenieMessageFragmentModel;
import com.facebook.messaging.graphql.threads.RtcCallModels.RtcCallDataInfoModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.StoryAttachmentTargetFragmentParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesInterfaces.CommonStoryAttachmentFields;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.BusinessNameSearchQueryParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.BusinessNameSearchQueryParser.SearchResultsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.BusinessPageQueryFragmentParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.BusinessThreadQueryParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.BusinessThreadQueryParser.MessageThreadsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.BusinessThreadQueryParser.MessageThreadsParser.NodesParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.BusinessThreadQueryParser.MessageThreadsParser.NodesParser.OtherParticipantsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.BusinessThreadQueryParser.MessageThreadsParser.NodesParser.OtherParticipantsParser.OtherParticipantsNodesParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.BusinessThreadQueryParser.MessageThreadsParser.NodesParser.OtherParticipantsParser.OtherParticipantsNodesParser.MessagingActorParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.CommonStoryAttachmentFieldsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.CommonStoryAttachmentFieldsParser.DescriptionParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.CommonStoryAttachmentFieldsParser.SourceParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.EventRemindersParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.EventRemindersParser.NodesParser.EventReminderMembersParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.EventRemindersParser.NodesParser.EventReminderMembersParser.EdgesParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.EventRemindersParser.NodesParser.EventReminderMembersParser.EdgesParser.NodeParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.GenericAdminMessageFieldsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.GenericAdminMessageFieldsParser.ExtensibleMessageAdminTextParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.GenericAdminMessageFieldsParser.ExtensibleMessageAdminTextParser.BotItemsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.GenericAdminMessageFieldsParser.ExtensibleMessageAdminTextParser.BotItemsParser.IconParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.GenericAdminMessageFieldsParser.ExtensibleMessageAdminTextParser.BotItemsParser.IconParser.ImageParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.GenericAdminMessageFieldsParser.ExtensibleMessageAdminTextParser.NicknameChoicesParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.GenericAdminMessageFieldsParser.ExtensibleMessageAdminTextParser.RideProviderParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.GenieStoryAttachmentFieldsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ImageInfoParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.JoinableModeInfoParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MessageAnimatedImageAttachmentParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MessageAnimatedImageAttachmentParser.AnimatedImageOriginalDimensionsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MessageInfoParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MessageInfoParser.BlobAttachmentsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MessageInfoParser.BlobAttachmentsParser.OriginalDimensionsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MessageInfoParser.CustomizationsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MessageInfoParser.MessageParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MessageInfoParser.StickerParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MessageVideoAttachmentParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MessageVideoAttachmentParser.StreamingImageThumbnailParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MessagesParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MessagesParser.PageInfoParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MontageThreadListQueryParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MoreMessagesQueryParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.MoreThreadsQueryParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.PinnedThreadsQueryParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.PinnedThreadsQueryParser.PinnedMessageThreadsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ReceiptInfoParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ReceiptInfoParser.ActorParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.SearchParticipantTagsQueryParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.SearchThreadNameAndParticipantsQueryParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.SearchThreadNameAndParticipantsQueryParser.SearchResultsParticipantsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.SearchThreadNameAndParticipantsQueryParser.SearchResultsThreadNameParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.ActiveBotsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.AllParticipantIdsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.AllParticipantsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.CustomizationInfoParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.CustomizationInfoParser.ParticipantCustomizationsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.DeliveryReceiptsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.FormerParticipantIdsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.FormerParticipantsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.LastMessageParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.ReadReceiptsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.ThreadGamesParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.ThreadGamesParser.HighScoreParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadInfoParser.ThreadKeyParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadListQueryParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadQueueInfoParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadQueueInfoParser.ApprovalRequestsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.ThreadQueueInfoParser.ThreadAdminsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.XMAAttachmentMediaParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.XMAAttachmentStoryFieldsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.XMAAttachmentStoryFieldsParser.ActionLinksParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.XMAAttachmentStoryFieldsParser.AttachmentPropertiesParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.XMAAttachmentStoryFieldsParser.AttachmentPropertiesParser.ValueParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.XMAAttachmentStoryFieldsParser.SubattachmentsParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.XMAAttachmentStoryFieldsParser.SubattachmentsParser.MediaParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesParsers.XMAParser;
import com.facebook.messaging.graphql.threads.UserInfoModels.MessagingActorIdModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.MessagingActorInfoModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.ParticipantInfoModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.ProfilePhotoInfoModel;
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

/* compiled from: videoPathToWaterfallId */
public class ThreadQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 481483740)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class BusinessNameSearchQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SearchResultsModel f1280d;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessNameSearchQueryModel.class, new Deserializer());
            }

            public Object m1861a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BusinessNameSearchQueryParser.m2606a(jsonParser);
                Object businessNameSearchQueryModel = new BusinessNameSearchQueryModel();
                ((BaseModel) businessNameSearchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (businessNameSearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) businessNameSearchQueryModel).a();
                }
                return businessNameSearchQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -338504733)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class SearchResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BusinessPageQueryFragmentModel> f1279d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SearchResultsModel.class, new Deserializer());
                }

                public Object m1862a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SearchResultsParser.m2604a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object searchResultsModel = new SearchResultsModel();
                    ((BaseModel) searchResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (searchResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) searchResultsModel).a();
                    }
                    return searchResultsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<SearchResultsModel> {
                public final void m1863a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SearchResultsModel searchResultsModel = (SearchResultsModel) obj;
                    if (searchResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(searchResultsModel.m1864a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        searchResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SearchResultsParser.m2605a(searchResultsModel.w_(), searchResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SearchResultsModel.class, new Serializer());
                }
            }

            public SearchResultsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BusinessPageQueryFragmentModel> m1866a() {
                this.f1279d = super.a(this.f1279d, 0, BusinessPageQueryFragmentModel.class);
                return (ImmutableList) this.f1279d;
            }

            public final int jK_() {
                return 1843101810;
            }

            public final GraphQLVisitableModel m1865a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1866a() != null) {
                    Builder a = ModelHelper.a(m1866a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SearchResultsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1279d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1864a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1866a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<BusinessNameSearchQueryModel> {
            public final void m1867a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BusinessNameSearchQueryModel businessNameSearchQueryModel = (BusinessNameSearchQueryModel) obj;
                if (businessNameSearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessNameSearchQueryModel.m1868a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessNameSearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = businessNameSearchQueryModel.w_();
                int u_ = businessNameSearchQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("search_results");
                    SearchResultsParser.m2605a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BusinessNameSearchQueryModel.class, new Serializer());
            }
        }

        public BusinessNameSearchQueryModel() {
            super(1);
        }

        @Nullable
        public final SearchResultsModel m1870a() {
            this.f1280d = (SearchResultsModel) super.a(this.f1280d, 0, SearchResultsModel.class);
            return this.f1280d;
        }

        public final int jK_() {
            return 332244357;
        }

        public final GraphQLVisitableModel m1869a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1870a() != null) {
                SearchResultsModel searchResultsModel = (SearchResultsModel) graphQLModelMutatingVisitor.b(m1870a());
                if (m1870a() != searchResultsModel) {
                    graphQLVisitableModel = (BusinessNameSearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1280d = searchResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1868a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1870a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 386695124)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class BusinessPageQueryFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f1281d;
        @Nullable
        private GraphQLCommercePageType f1282e;
        @Nullable
        private String f1283f;
        @Nullable
        private String f1284g;
        @Nullable
        private ProfilePhotoInfoModel f1285h;
        @Nullable
        private ProfilePhotoInfoModel f1286i;
        @Nullable
        private ProfilePhotoInfoModel f1287j;
        @Nullable
        private String f1288k;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessPageQueryFragmentModel.class, new Deserializer());
            }

            public Object m1871a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BusinessPageQueryFragmentParser.m2607b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object businessPageQueryFragmentModel = new BusinessPageQueryFragmentModel();
                ((BaseModel) businessPageQueryFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (businessPageQueryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) businessPageQueryFragmentModel).a();
                }
                return businessPageQueryFragmentModel;
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<BusinessPageQueryFragmentModel> {
            public final void m1872a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BusinessPageQueryFragmentModel businessPageQueryFragmentModel = (BusinessPageQueryFragmentModel) obj;
                if (businessPageQueryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessPageQueryFragmentModel.m1874a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessPageQueryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BusinessPageQueryFragmentParser.m2608b(businessPageQueryFragmentModel.w_(), businessPageQueryFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BusinessPageQueryFragmentModel.class, new Serializer());
            }
        }

        public BusinessPageQueryFragmentModel() {
            super(8);
        }

        public final void m1877a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m1878a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m1873q() {
            if (this.b != null && this.f1281d == null) {
                this.f1281d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1281d;
        }

        @Nullable
        public final GraphQLCommercePageType m1879j() {
            this.f1282e = (GraphQLCommercePageType) super.b(this.f1282e, 1, GraphQLCommercePageType.class, GraphQLCommercePageType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1282e;
        }

        @Nullable
        public final String m1880k() {
            this.f1283f = super.a(this.f1283f, 2);
            return this.f1283f;
        }

        @Nullable
        public final String m1881l() {
            this.f1284g = super.a(this.f1284g, 3);
            return this.f1284g;
        }

        @Nullable
        public final ProfilePhotoInfoModel m1882m() {
            this.f1285h = (ProfilePhotoInfoModel) super.a(this.f1285h, 4, ProfilePhotoInfoModel.class);
            return this.f1285h;
        }

        @Nullable
        public final ProfilePhotoInfoModel m1883n() {
            this.f1286i = (ProfilePhotoInfoModel) super.a(this.f1286i, 5, ProfilePhotoInfoModel.class);
            return this.f1286i;
        }

        @Nullable
        public final ProfilePhotoInfoModel m1884o() {
            this.f1287j = (ProfilePhotoInfoModel) super.a(this.f1287j, 6, ProfilePhotoInfoModel.class);
            return this.f1287j;
        }

        @Nullable
        public final String m1885p() {
            this.f1288k = super.a(this.f1288k, 7);
            return this.f1288k;
        }

        @Nullable
        public final String m1876a() {
            return m1880k();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m1875a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            ProfilePhotoInfoModel profilePhotoInfoModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1882m() != null) {
                profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m1882m());
                if (m1882m() != profilePhotoInfoModel) {
                    graphQLVisitableModel = (BusinessPageQueryFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1285h = profilePhotoInfoModel;
                }
            }
            if (m1883n() != null) {
                profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m1883n());
                if (m1883n() != profilePhotoInfoModel) {
                    graphQLVisitableModel = (BusinessPageQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1286i = profilePhotoInfoModel;
                }
            }
            if (m1884o() != null) {
                profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m1884o());
                if (m1884o() != profilePhotoInfoModel) {
                    graphQLVisitableModel = (BusinessPageQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1287j = profilePhotoInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1874a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1873q());
            int a2 = flatBufferBuilder.a(m1879j());
            int b = flatBufferBuilder.b(m1880k());
            int b2 = flatBufferBuilder.b(m1881l());
            int a3 = ModelHelper.a(flatBufferBuilder, m1882m());
            int a4 = ModelHelper.a(flatBufferBuilder, m1883n());
            int a5 = ModelHelper.a(flatBufferBuilder, m1884o());
            int b3 = flatBufferBuilder.b(m1885p());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -72992919)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class BusinessThreadQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessageThreadsModel f1299d;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessThreadQueryModel.class, new Deserializer());
            }

            public Object m1886a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BusinessThreadQueryParser.m2619a(jsonParser);
                Object businessThreadQueryModel = new BusinessThreadQueryModel();
                ((BaseModel) businessThreadQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (businessThreadQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) businessThreadQueryModel).a();
                }
                return businessThreadQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2052890058)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class MessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f1298d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageThreadsModel.class, new Deserializer());
                }

                public Object m1887a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageThreadsParser.m2617a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messageThreadsModel = new MessageThreadsModel();
                    ((BaseModel) messageThreadsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messageThreadsModel instanceof Postprocessable) {
                        return ((Postprocessable) messageThreadsModel).a();
                    }
                    return messageThreadsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1119964681)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private OtherParticipantsModel f1297d;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m1888a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m2615b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1918533315)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: videoPathToWaterfallId */
                public final class OtherParticipantsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<OtherParticipantsNodesModel> f1296d;

                    /* compiled from: videoPathToWaterfallId */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(OtherParticipantsModel.class, new Deserializer());
                        }

                        public Object m1889a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(OtherParticipantsParser.m2613a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object otherParticipantsModel = new OtherParticipantsModel();
                            ((BaseModel) otherParticipantsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (otherParticipantsModel instanceof Postprocessable) {
                                return ((Postprocessable) otherParticipantsModel).a();
                            }
                            return otherParticipantsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1782310346)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: videoPathToWaterfallId */
                    public final class OtherParticipantsNodesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private MessagingActorModel f1295d;

                        /* compiled from: videoPathToWaterfallId */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(OtherParticipantsNodesModel.class, new Deserializer());
                            }

                            public Object m1890a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(OtherParticipantsNodesParser.m2611b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object otherParticipantsNodesModel = new OtherParticipantsNodesModel();
                                ((BaseModel) otherParticipantsNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (otherParticipantsNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) otherParticipantsNodesModel).a();
                                }
                                return otherParticipantsNodesModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 275182867)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: videoPathToWaterfallId */
                        public final class MessagingActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                            @Nullable
                            private GraphQLObjectType f1289d;
                            @Nullable
                            private String f1290e;
                            @Nullable
                            private String f1291f;
                            @Nullable
                            private ProfilePhotoInfoModel f1292g;
                            @Nullable
                            private ProfilePhotoInfoModel f1293h;
                            @Nullable
                            private ProfilePhotoInfoModel f1294i;

                            /* compiled from: videoPathToWaterfallId */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(MessagingActorModel.class, new Deserializer());
                                }

                                public Object m1891a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(MessagingActorParser.m2609a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object messagingActorModel = new MessagingActorModel();
                                    ((BaseModel) messagingActorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (messagingActorModel instanceof Postprocessable) {
                                        return ((Postprocessable) messagingActorModel).a();
                                    }
                                    return messagingActorModel;
                                }
                            }

                            /* compiled from: videoPathToWaterfallId */
                            public class Serializer extends JsonSerializer<MessagingActorModel> {
                                public final void m1892a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    MessagingActorModel messagingActorModel = (MessagingActorModel) obj;
                                    if (messagingActorModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(messagingActorModel.m1899a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        messagingActorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    MessagingActorParser.m2610a(messagingActorModel.w_(), messagingActorModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(MessagingActorModel.class, new Serializer());
                                }
                            }

                            public MessagingActorModel() {
                                super(6);
                            }

                            @Nullable
                            private GraphQLObjectType m1893j() {
                                if (this.b != null && this.f1289d == null) {
                                    this.f1289d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                }
                                return this.f1289d;
                            }

                            @Nullable
                            private String m1894k() {
                                this.f1290e = super.a(this.f1290e, 1);
                                return this.f1290e;
                            }

                            @Nullable
                            private String m1895l() {
                                this.f1291f = super.a(this.f1291f, 2);
                                return this.f1291f;
                            }

                            @Nullable
                            private ProfilePhotoInfoModel m1896m() {
                                this.f1292g = (ProfilePhotoInfoModel) super.a(this.f1292g, 3, ProfilePhotoInfoModel.class);
                                return this.f1292g;
                            }

                            @Nullable
                            private ProfilePhotoInfoModel m1897n() {
                                this.f1293h = (ProfilePhotoInfoModel) super.a(this.f1293h, 4, ProfilePhotoInfoModel.class);
                                return this.f1293h;
                            }

                            @Nullable
                            private ProfilePhotoInfoModel m1898o() {
                                this.f1294i = (ProfilePhotoInfoModel) super.a(this.f1294i, 5, ProfilePhotoInfoModel.class);
                                return this.f1294i;
                            }

                            @Nullable
                            public final String m1901a() {
                                return m1894k();
                            }

                            public final int jK_() {
                                return -1575218831;
                            }

                            public final GraphQLVisitableModel m1900a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                ProfilePhotoInfoModel profilePhotoInfoModel;
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m1896m() != null) {
                                    profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m1896m());
                                    if (m1896m() != profilePhotoInfoModel) {
                                        graphQLVisitableModel = (MessagingActorModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f1292g = profilePhotoInfoModel;
                                    }
                                }
                                if (m1897n() != null) {
                                    profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m1897n());
                                    if (m1897n() != profilePhotoInfoModel) {
                                        graphQLVisitableModel = (MessagingActorModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f1293h = profilePhotoInfoModel;
                                    }
                                }
                                if (m1898o() != null) {
                                    profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m1898o());
                                    if (m1898o() != profilePhotoInfoModel) {
                                        graphQLVisitableModel = (MessagingActorModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f1294i = profilePhotoInfoModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m1899a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m1893j());
                                int b = flatBufferBuilder.b(m1894k());
                                int b2 = flatBufferBuilder.b(m1895l());
                                int a2 = ModelHelper.a(flatBufferBuilder, m1896m());
                                int a3 = ModelHelper.a(flatBufferBuilder, m1897n());
                                int a4 = ModelHelper.a(flatBufferBuilder, m1898o());
                                flatBufferBuilder.c(6);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, b);
                                flatBufferBuilder.b(2, b2);
                                flatBufferBuilder.b(3, a2);
                                flatBufferBuilder.b(4, a3);
                                flatBufferBuilder.b(5, a4);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: videoPathToWaterfallId */
                        public class Serializer extends JsonSerializer<OtherParticipantsNodesModel> {
                            public final void m1902a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                OtherParticipantsNodesModel otherParticipantsNodesModel = (OtherParticipantsNodesModel) obj;
                                if (otherParticipantsNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(otherParticipantsNodesModel.m1904a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    otherParticipantsNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                OtherParticipantsNodesParser.m2612b(otherParticipantsNodesModel.w_(), otherParticipantsNodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(OtherParticipantsNodesModel.class, new Serializer());
                            }
                        }

                        public OtherParticipantsNodesModel() {
                            super(1);
                        }

                        @Nullable
                        private MessagingActorModel m1903a() {
                            this.f1295d = (MessagingActorModel) super.a(this.f1295d, 0, MessagingActorModel.class);
                            return this.f1295d;
                        }

                        public final int jK_() {
                            return -1020278353;
                        }

                        public final GraphQLVisitableModel m1905a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m1903a() != null) {
                                MessagingActorModel messagingActorModel = (MessagingActorModel) graphQLModelMutatingVisitor.b(m1903a());
                                if (m1903a() != messagingActorModel) {
                                    graphQLVisitableModel = (OtherParticipantsNodesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f1295d = messagingActorModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m1904a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m1903a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: videoPathToWaterfallId */
                    public class Serializer extends JsonSerializer<OtherParticipantsModel> {
                        public final void m1906a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            OtherParticipantsModel otherParticipantsModel = (OtherParticipantsModel) obj;
                            if (otherParticipantsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(otherParticipantsModel.m1908a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                otherParticipantsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            OtherParticipantsParser.m2614a(otherParticipantsModel.w_(), otherParticipantsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(OtherParticipantsModel.class, new Serializer());
                        }
                    }

                    public OtherParticipantsModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<OtherParticipantsNodesModel> m1907a() {
                        this.f1296d = super.a(this.f1296d, 0, OtherParticipantsNodesModel.class);
                        return (ImmutableList) this.f1296d;
                    }

                    public final int jK_() {
                        return -514756541;
                    }

                    public final GraphQLVisitableModel m1909a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m1907a() != null) {
                            Builder a = ModelHelper.a(m1907a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (OtherParticipantsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1296d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m1908a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m1907a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m1910a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m1912a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m2616b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                @Nullable
                private OtherParticipantsModel m1911a() {
                    this.f1297d = (OtherParticipantsModel) super.a(this.f1297d, 0, OtherParticipantsModel.class);
                    return this.f1297d;
                }

                public final int jK_() {
                    return -740570927;
                }

                public final GraphQLVisitableModel m1913a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m1911a() != null) {
                        OtherParticipantsModel otherParticipantsModel = (OtherParticipantsModel) graphQLModelMutatingVisitor.b(m1911a());
                        if (m1911a() != otherParticipantsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1297d = otherParticipantsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m1912a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m1911a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<MessageThreadsModel> {
                public final void m1914a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageThreadsModel messageThreadsModel = (MessageThreadsModel) obj;
                    if (messageThreadsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageThreadsModel.m1916a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageThreadsParser.m2618a(messageThreadsModel.w_(), messageThreadsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessageThreadsModel.class, new Serializer());
                }
            }

            public MessageThreadsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m1915a() {
                this.f1298d = super.a(this.f1298d, 0, NodesModel.class);
                return (ImmutableList) this.f1298d;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m1917a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1915a() != null) {
                    Builder a = ModelHelper.a(m1915a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessageThreadsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1298d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1916a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1915a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<BusinessThreadQueryModel> {
            public final void m1918a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BusinessThreadQueryModel businessThreadQueryModel = (BusinessThreadQueryModel) obj;
                if (businessThreadQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessThreadQueryModel.m1920a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessThreadQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = businessThreadQueryModel.w_();
                int u_ = businessThreadQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("message_threads");
                    MessageThreadsParser.m2618a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BusinessThreadQueryModel.class, new Serializer());
            }
        }

        public BusinessThreadQueryModel() {
            super(1);
        }

        @Nullable
        private MessageThreadsModel m1919a() {
            this.f1299d = (MessageThreadsModel) super.a(this.f1299d, 0, MessageThreadsModel.class);
            return this.f1299d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m1921a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1919a() != null) {
                MessageThreadsModel messageThreadsModel = (MessageThreadsModel) graphQLModelMutatingVisitor.b(m1919a());
                if (m1919a() != messageThreadsModel) {
                    graphQLVisitableModel = (BusinessThreadQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1299d = messageThreadsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1920a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1919a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1311465263)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class CommonStoryAttachmentFieldsModel extends BaseModel implements GraphQLVisitableModel, CommonStoryAttachmentFields {
        @Nullable
        private DescriptionModel f1304d;
        @Nullable
        private SourceModel f1305e;
        @Nullable
        private List<GraphQLStoryAttachmentStyle> f1306f;
        @Nullable
        private String f1307g;
        @Nullable
        private StoryAttachmentTargetFragmentModel f1308h;
        @Nullable
        private String f1309i;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class DescriptionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1301d;

            /* compiled from: videoPathToWaterfallId */
            public final class Builder {
                @Nullable
                public String f1300a;

                public final DescriptionModel m1922a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f1300a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new DescriptionModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DescriptionModel.class, new Deserializer());
                }

                public Object m1923a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DescriptionParser.m2620a(jsonParser, flatBufferBuilder));
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

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<DescriptionModel> {
                public final void m1924a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DescriptionModel descriptionModel = (DescriptionModel) obj;
                    if (descriptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(descriptionModel.m1926a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        descriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DescriptionParser.m2621a(descriptionModel.w_(), descriptionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(DescriptionModel.class, new Serializer());
                }
            }

            public DescriptionModel() {
                super(1);
            }

            public DescriptionModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m1928a() {
                this.f1301d = super.a(this.f1301d, 0);
                return this.f1301d;
            }

            public static DescriptionModel m1925a(DescriptionModel descriptionModel) {
                if (descriptionModel == null) {
                    return null;
                }
                if (descriptionModel instanceof DescriptionModel) {
                    return descriptionModel;
                }
                Builder builder = new Builder();
                builder.f1300a = descriptionModel.m1928a();
                return builder.m1922a();
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m1927a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1926a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1928a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommonStoryAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m1929a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommonStoryAttachmentFieldsParser.m2624a(jsonParser);
                Object commonStoryAttachmentFieldsModel = new CommonStoryAttachmentFieldsModel();
                ((BaseModel) commonStoryAttachmentFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commonStoryAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) commonStoryAttachmentFieldsModel).a();
                }
                return commonStoryAttachmentFieldsModel;
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<CommonStoryAttachmentFieldsModel> {
            public final void m1930a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommonStoryAttachmentFieldsModel commonStoryAttachmentFieldsModel = (CommonStoryAttachmentFieldsModel) obj;
                if (commonStoryAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commonStoryAttachmentFieldsModel.m1943a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commonStoryAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commonStoryAttachmentFieldsModel.w_();
                int u_ = commonStoryAttachmentFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("description");
                    DescriptionParser.m2621a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("source");
                    SourceParser.m2623a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 2), jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("subtitle");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("target");
                    StoryAttachmentTargetFragmentParser.m1837a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 5) != 0) {
                    jsonGenerator.a("title");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 5));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommonStoryAttachmentFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class SourceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1303d;

            /* compiled from: videoPathToWaterfallId */
            public final class Builder {
                @Nullable
                public String f1302a;
            }

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SourceModel.class, new Deserializer());
                }

                public Object m1931a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SourceParser.m2622a(jsonParser, flatBufferBuilder));
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

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<SourceModel> {
                public final void m1932a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SourceModel sourceModel = (SourceModel) obj;
                    if (sourceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sourceModel.m1934a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sourceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SourceParser.m2623a(sourceModel.w_(), sourceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SourceModel.class, new Serializer());
                }
            }

            public SourceModel() {
                super(1);
            }

            public SourceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m1936a() {
                this.f1303d = super.a(this.f1303d, 0);
                return this.f1303d;
            }

            public static SourceModel m1933a(SourceModel sourceModel) {
                if (sourceModel == null) {
                    return null;
                }
                if (sourceModel instanceof SourceModel) {
                    return sourceModel;
                }
                Builder builder = new Builder();
                builder.f1302a = sourceModel.m1936a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f1302a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SourceModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m1935a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1934a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1936a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public CommonStoryAttachmentFieldsModel() {
            super(6);
        }

        @Nullable
        private DescriptionModel m1937a() {
            this.f1304d = (DescriptionModel) super.a(this.f1304d, 0, DescriptionModel.class);
            return this.f1304d;
        }

        @Nullable
        private SourceModel m1938j() {
            this.f1305e = (SourceModel) super.a(this.f1305e, 1, SourceModel.class);
            return this.f1305e;
        }

        @Nonnull
        private ImmutableList<GraphQLStoryAttachmentStyle> m1939k() {
            this.f1306f = super.c(this.f1306f, 2, GraphQLStoryAttachmentStyle.class);
            return (ImmutableList) this.f1306f;
        }

        @Nullable
        private String m1940l() {
            this.f1307g = super.a(this.f1307g, 3);
            return this.f1307g;
        }

        @Nullable
        private StoryAttachmentTargetFragmentModel m1941m() {
            this.f1308h = (StoryAttachmentTargetFragmentModel) super.a(this.f1308h, 4, StoryAttachmentTargetFragmentModel.class);
            return this.f1308h;
        }

        @Nullable
        private String m1942n() {
            this.f1309i = super.a(this.f1309i, 5);
            return this.f1309i;
        }

        public final int jK_() {
            return -1267730472;
        }

        public final GraphQLVisitableModel m1944a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1937a() != null) {
                DescriptionModel descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m1937a());
                if (m1937a() != descriptionModel) {
                    graphQLVisitableModel = (CommonStoryAttachmentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1304d = descriptionModel;
                }
            }
            if (m1938j() != null) {
                SourceModel sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m1938j());
                if (m1938j() != sourceModel) {
                    graphQLVisitableModel = (CommonStoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1305e = sourceModel;
                }
            }
            if (m1941m() != null) {
                StoryAttachmentTargetFragmentModel storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) graphQLModelMutatingVisitor.b(m1941m());
                if (m1941m() != storyAttachmentTargetFragmentModel) {
                    graphQLVisitableModel = (CommonStoryAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1308h = storyAttachmentTargetFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1943a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1937a());
            int a2 = ModelHelper.a(flatBufferBuilder, m1938j());
            int d = flatBufferBuilder.d(m1939k());
            int b = flatBufferBuilder.b(m1940l());
            int a3 = ModelHelper.a(flatBufferBuilder, m1941m());
            int b2 = flatBufferBuilder.b(m1942n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, d);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2035884284)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class EventRemindersModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<NodesModel> f1319d;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventRemindersModel.class, new Deserializer());
            }

            public Object m1945a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EventRemindersParser.m2633a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object eventRemindersModel = new EventRemindersModel();
                ((BaseModel) eventRemindersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (eventRemindersModel instanceof Postprocessable) {
                    return ((Postprocessable) eventRemindersModel).a();
                }
                return eventRemindersModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1158876137)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            private boolean f1314d;
            @Nullable
            private EventReminderMembersModel f1315e;
            @Nullable
            private String f1316f;
            @Nullable
            private String f1317g;
            private long f1318h;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                }

                public Object m1946a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventRemindersParser.NodesParser.m2631b(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 79457921)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class EventReminderMembersModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f1313d;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EventReminderMembersModel.class, new Deserializer());
                    }

                    public Object m1947a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EventReminderMembersParser.m2629a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object eventReminderMembersModel = new EventReminderMembersModel();
                        ((BaseModel) eventReminderMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (eventReminderMembersModel instanceof Postprocessable) {
                            return ((Postprocessable) eventReminderMembersModel).a();
                        }
                        return eventReminderMembersModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 30626616)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: videoPathToWaterfallId */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GraphQLLightweightEventGuestStatus f1311d;
                    @Nullable
                    private NodeModel f1312e;

                    /* compiled from: videoPathToWaterfallId */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m1948a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m2627b(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 1801334754)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: videoPathToWaterfallId */
                    public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                        @Nullable
                        private String f1310d;

                        /* compiled from: videoPathToWaterfallId */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                            }

                            public Object m1949a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodeParser.m2625a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: videoPathToWaterfallId */
                        public class Serializer extends JsonSerializer<NodeModel> {
                            public final void m1950a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodeModel nodeModel = (NodeModel) obj;
                                if (nodeModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodeModel.m1951a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodeParser.m2626a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(NodeModel.class, new Serializer());
                            }
                        }

                        public NodeModel() {
                            super(1);
                        }

                        public final void m1954a(String str, ConsistencyTuple consistencyTuple) {
                            consistencyTuple.a();
                        }

                        public final void m1955a(String str, Object obj, boolean z) {
                        }

                        @Nullable
                        public final String m1956j() {
                            this.f1310d = super.a(this.f1310d, 0);
                            return this.f1310d;
                        }

                        @Nullable
                        public final String m1953a() {
                            return m1956j();
                        }

                        public final int jK_() {
                            return 2645995;
                        }

                        public final GraphQLVisitableModel m1952a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m1951a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m1956j());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: videoPathToWaterfallId */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m1957a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m1958a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m2628b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(2);
                    }

                    @Nullable
                    public final GraphQLLightweightEventGuestStatus m1959a() {
                        this.f1311d = (GraphQLLightweightEventGuestStatus) super.b(this.f1311d, 0, GraphQLLightweightEventGuestStatus.class, GraphQLLightweightEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f1311d;
                    }

                    @Nullable
                    public final NodeModel m1961j() {
                        this.f1312e = (NodeModel) super.a(this.f1312e, 1, NodeModel.class);
                        return this.f1312e;
                    }

                    public final int jK_() {
                        return -1505025091;
                    }

                    public final GraphQLVisitableModel m1960a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m1961j() != null) {
                            NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m1961j());
                            if (m1961j() != nodeModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1312e = nodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m1958a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = flatBufferBuilder.a(m1959a());
                        int a2 = ModelHelper.a(flatBufferBuilder, m1961j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<EventReminderMembersModel> {
                    public final void m1962a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EventReminderMembersModel eventReminderMembersModel = (EventReminderMembersModel) obj;
                        if (eventReminderMembersModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(eventReminderMembersModel.m1963a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            eventReminderMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EventReminderMembersParser.m2630a(eventReminderMembersModel.w_(), eventReminderMembersModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EventReminderMembersModel.class, new Serializer());
                    }
                }

                public EventReminderMembersModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m1965a() {
                    this.f1313d = super.a(this.f1313d, 0, EdgesModel.class);
                    return (ImmutableList) this.f1313d;
                }

                public final int jK_() {
                    return -440421154;
                }

                public final GraphQLVisitableModel m1964a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m1965a() != null) {
                        Builder a = ModelHelper.a(m1965a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (EventReminderMembersModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1313d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m1963a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m1965a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<NodesModel> {
                public final void m1966a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodesModel nodesModel = (NodesModel) obj;
                    if (nodesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodesModel.m1967a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventRemindersParser.NodesParser.m2632b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodesModel.class, new Serializer());
                }
            }

            public NodesModel() {
                super(5);
            }

            public final boolean m1971j() {
                a(0, 0);
                return this.f1314d;
            }

            @Nullable
            public final EventReminderMembersModel m1972k() {
                this.f1315e = (EventReminderMembersModel) super.a(this.f1315e, 1, EventReminderMembersModel.class);
                return this.f1315e;
            }

            @Nullable
            public final String m1973l() {
                this.f1316f = super.a(this.f1316f, 2);
                return this.f1316f;
            }

            @Nullable
            public final String m1974m() {
                this.f1317g = super.a(this.f1317g, 3);
                return this.f1317g;
            }

            public final long m1975n() {
                a(0, 4);
                return this.f1318h;
            }

            @Nullable
            public final String m1969a() {
                return m1974m();
            }

            public final int jK_() {
                return 2135905529;
            }

            public final GraphQLVisitableModel m1968a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1972k() != null) {
                    EventReminderMembersModel eventReminderMembersModel = (EventReminderMembersModel) graphQLModelMutatingVisitor.b(m1972k());
                    if (m1972k() != eventReminderMembersModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1315e = eventReminderMembersModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1967a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1972k());
                int b = flatBufferBuilder.b(m1973l());
                int b2 = flatBufferBuilder.b(m1974m());
                flatBufferBuilder.c(5);
                flatBufferBuilder.a(0, this.f1314d);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.a(4, this.f1318h, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1970a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1314d = mutableFlatBuffer.a(i, 0);
                this.f1318h = mutableFlatBuffer.a(i, 4, 0);
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<EventRemindersModel> {
            public final void m1976a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                EventRemindersModel eventRemindersModel = (EventRemindersModel) obj;
                if (eventRemindersModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventRemindersModel.m1977a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventRemindersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                EventRemindersParser.m2634a(eventRemindersModel.w_(), eventRemindersModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(EventRemindersModel.class, new Serializer());
            }
        }

        public EventRemindersModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<NodesModel> m1979a() {
            this.f1319d = super.a(this.f1319d, 0, NodesModel.class);
            return (ImmutableList) this.f1319d;
        }

        public final int jK_() {
            return 1862270137;
        }

        public final GraphQLVisitableModel m1978a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1979a() != null) {
                Builder a = ModelHelper.a(m1979a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (EventRemindersModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1319d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1977a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1979a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1715661250)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class GenericAdminMessageFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ExtensibleMessageAdminTextModel f1348d;
        @Nullable
        private GraphQLExtensibleMessageAdminTextType f1349e;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GenericAdminMessageFieldsModel.class, new Deserializer());
            }

            public Object m1980a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GenericAdminMessageFieldsParser.m2649a(jsonParser);
                Object genericAdminMessageFieldsModel = new GenericAdminMessageFieldsModel();
                ((BaseModel) genericAdminMessageFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (genericAdminMessageFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) genericAdminMessageFieldsModel).a();
                }
                return genericAdminMessageFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1181500089)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class ExtensibleMessageAdminTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f1329d;
            @Nullable
            private String f1330e;
            @Nullable
            private List<GraphQLMessengerAdPropertyType> f1331f;
            @Nullable
            private List<BotItemsModel> f1332g;
            @Nullable
            private List<String> f1333h;
            @Nullable
            private List<String> f1334i;
            @Nullable
            private String f1335j;
            @Nullable
            private String f1336k;
            private boolean f1337l;
            private boolean f1338m;
            @Nullable
            private String f1339n;
            @Nullable
            private List<NicknameChoicesModel> f1340o;
            @Nullable
            private RideProviderModel f1341p;
            private int f1342q;
            @Nullable
            private String f1343r;
            @Nullable
            private String f1344s;
            @Nullable
            private String f1345t;
            @Nullable
            private String f1346u;
            private int f1347v;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -64539857)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class BotItemsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1322d;
                @Nullable
                private String f1323e;
                @Nullable
                private IconModel f1324f;
                @Nullable
                private String f1325g;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(BotItemsModel.class, new Deserializer());
                    }

                    public Object m1981a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(BotItemsParser.m2640b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object botItemsModel = new BotItemsModel();
                        ((BaseModel) botItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (botItemsModel instanceof Postprocessable) {
                            return ((Postprocessable) botItemsModel).a();
                        }
                        return botItemsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1958638331)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: videoPathToWaterfallId */
                public final class IconModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private ImageModel f1321d;

                    /* compiled from: videoPathToWaterfallId */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(IconModel.class, new Deserializer());
                        }

                        public Object m1982a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(IconParser.m2637a(jsonParser, flatBufferBuilder));
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

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 842551240)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: videoPathToWaterfallId */
                    public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f1320d;

                        /* compiled from: videoPathToWaterfallId */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                            }

                            public Object m1983a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ImageParser.m2635a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: videoPathToWaterfallId */
                        public class Serializer extends JsonSerializer<ImageModel> {
                            public final void m1984a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ImageModel imageModel = (ImageModel) obj;
                                if (imageModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(imageModel.m1985a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ImageParser.m2636a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ImageModel.class, new Serializer());
                            }
                        }

                        public ImageModel() {
                            super(1);
                        }

                        @Nullable
                        public final String m1987a() {
                            this.f1320d = super.a(this.f1320d, 0);
                            return this.f1320d;
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m1986a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m1985a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m1987a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: videoPathToWaterfallId */
                    public class Serializer extends JsonSerializer<IconModel> {
                        public final void m1988a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            IconModel iconModel = (IconModel) obj;
                            if (iconModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(iconModel.m1989a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                iconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            IconParser.m2638a(iconModel.w_(), iconModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(IconModel.class, new Serializer());
                        }
                    }

                    public IconModel() {
                        super(1);
                    }

                    @Nullable
                    public final ImageModel m1991a() {
                        this.f1321d = (ImageModel) super.a(this.f1321d, 0, ImageModel.class);
                        return this.f1321d;
                    }

                    public final int jK_() {
                        return 1516342256;
                    }

                    public final GraphQLVisitableModel m1990a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m1991a() != null) {
                            ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m1991a());
                            if (m1991a() != imageModel) {
                                graphQLVisitableModel = (IconModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1321d = imageModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m1989a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m1991a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<BotItemsModel> {
                    public final void m1992a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        BotItemsModel botItemsModel = (BotItemsModel) obj;
                        if (botItemsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(botItemsModel.m1993a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            botItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        BotItemsParser.m2641b(botItemsModel.w_(), botItemsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(BotItemsModel.class, new Serializer());
                    }
                }

                public BotItemsModel() {
                    super(4);
                }

                @Nullable
                public final String m1995a() {
                    this.f1322d = super.a(this.f1322d, 0);
                    return this.f1322d;
                }

                @Nullable
                public final String m1996j() {
                    this.f1323e = super.a(this.f1323e, 1);
                    return this.f1323e;
                }

                @Nullable
                public final IconModel m1997k() {
                    this.f1324f = (IconModel) super.a(this.f1324f, 2, IconModel.class);
                    return this.f1324f;
                }

                @Nullable
                public final String m1998l() {
                    this.f1325g = super.a(this.f1325g, 3);
                    return this.f1325g;
                }

                public final int jK_() {
                    return 1566983943;
                }

                public final GraphQLVisitableModel m1994a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m1997k() != null) {
                        IconModel iconModel = (IconModel) graphQLModelMutatingVisitor.b(m1997k());
                        if (m1997k() != iconModel) {
                            graphQLVisitableModel = (BotItemsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1324f = iconModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m1993a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m1995a());
                    int b2 = flatBufferBuilder.b(m1996j());
                    int a = ModelHelper.a(flatBufferBuilder, m1997k());
                    int b3 = flatBufferBuilder.b(m1998l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, a);
                    flatBufferBuilder.b(3, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ExtensibleMessageAdminTextModel.class, new Deserializer());
                }

                public Object m1999a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ExtensibleMessageAdminTextParser.m2647a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object extensibleMessageAdminTextModel = new ExtensibleMessageAdminTextModel();
                    ((BaseModel) extensibleMessageAdminTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (extensibleMessageAdminTextModel instanceof Postprocessable) {
                        return ((Postprocessable) extensibleMessageAdminTextModel).a();
                    }
                    return extensibleMessageAdminTextModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -909971467)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class NicknameChoicesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<String> f1326d;
                @Nullable
                private String f1327e;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NicknameChoicesModel.class, new Deserializer());
                    }

                    public Object m2000a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NicknameChoicesParser.m2644b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nicknameChoicesModel = new NicknameChoicesModel();
                        ((BaseModel) nicknameChoicesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nicknameChoicesModel instanceof Postprocessable) {
                            return ((Postprocessable) nicknameChoicesModel).a();
                        }
                        return nicknameChoicesModel;
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<NicknameChoicesModel> {
                    public final void m2001a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NicknameChoicesModel nicknameChoicesModel = (NicknameChoicesModel) obj;
                        if (nicknameChoicesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nicknameChoicesModel.m2002a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nicknameChoicesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NicknameChoicesParser.m2643a(nicknameChoicesModel.w_(), nicknameChoicesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NicknameChoicesModel.class, new Serializer());
                    }
                }

                public NicknameChoicesModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<String> m2004a() {
                    this.f1326d = super.a(this.f1326d, 0);
                    return (ImmutableList) this.f1326d;
                }

                @Nullable
                public final String m2005j() {
                    this.f1327e = super.a(this.f1327e, 1);
                    return this.f1327e;
                }

                public final int jK_() {
                    return 1125952854;
                }

                public final GraphQLVisitableModel m2003a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2002a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int c = flatBufferBuilder.c(m2004a());
                    int b = flatBufferBuilder.b(m2005j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, c);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 273304230)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class RideProviderModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1328d;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RideProviderModel.class, new Deserializer());
                    }

                    public Object m2006a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RideProviderParser.m2645a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object rideProviderModel = new RideProviderModel();
                        ((BaseModel) rideProviderModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (rideProviderModel instanceof Postprocessable) {
                            return ((Postprocessable) rideProviderModel).a();
                        }
                        return rideProviderModel;
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<RideProviderModel> {
                    public final void m2007a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RideProviderModel rideProviderModel = (RideProviderModel) obj;
                        if (rideProviderModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(rideProviderModel.m2008a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            rideProviderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RideProviderParser.m2646a(rideProviderModel.w_(), rideProviderModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(RideProviderModel.class, new Serializer());
                    }
                }

                public RideProviderModel() {
                    super(1);
                }

                @Nullable
                public final String m2010a() {
                    this.f1328d = super.a(this.f1328d, 0);
                    return this.f1328d;
                }

                public final int jK_() {
                    return 1029877545;
                }

                public final GraphQLVisitableModel m2009a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2008a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2010a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<ExtensibleMessageAdminTextModel> {
                public final void m2011a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ExtensibleMessageAdminTextModel extensibleMessageAdminTextModel = (ExtensibleMessageAdminTextModel) obj;
                    if (extensibleMessageAdminTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(extensibleMessageAdminTextModel.m2013a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        extensibleMessageAdminTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ExtensibleMessageAdminTextParser.m2648a(extensibleMessageAdminTextModel.w_(), extensibleMessageAdminTextModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ExtensibleMessageAdminTextModel.class, new Serializer());
                }
            }

            public ExtensibleMessageAdminTextModel() {
                super(19);
            }

            @Nullable
            private GraphQLObjectType m2012A() {
                if (this.b != null && this.f1329d == null) {
                    this.f1329d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1329d;
            }

            @Nullable
            public final String m2015a() {
                this.f1330e = super.a(this.f1330e, 1);
                return this.f1330e;
            }

            @Nonnull
            public final ImmutableList<GraphQLMessengerAdPropertyType> m2017j() {
                this.f1331f = super.c(this.f1331f, 2, GraphQLMessengerAdPropertyType.class);
                return (ImmutableList) this.f1331f;
            }

            @Nonnull
            public final ImmutableList<BotItemsModel> m2018k() {
                this.f1332g = super.a(this.f1332g, 3, BotItemsModel.class);
                return (ImmutableList) this.f1332g;
            }

            @Nonnull
            public final ImmutableList<String> m2019l() {
                this.f1333h = super.a(this.f1333h, 4);
                return (ImmutableList) this.f1333h;
            }

            @Nonnull
            public final ImmutableList<String> m2020m() {
                this.f1334i = super.a(this.f1334i, 5);
                return (ImmutableList) this.f1334i;
            }

            @Nullable
            public final String m2021n() {
                this.f1335j = super.a(this.f1335j, 6);
                return this.f1335j;
            }

            @Nullable
            public final String m2022o() {
                this.f1336k = super.a(this.f1336k, 7);
                return this.f1336k;
            }

            public final boolean m2023p() {
                a(1, 0);
                return this.f1337l;
            }

            public final boolean m2024q() {
                a(1, 1);
                return this.f1338m;
            }

            @Nullable
            public final String m2025r() {
                this.f1339n = super.a(this.f1339n, 10);
                return this.f1339n;
            }

            @Nonnull
            public final ImmutableList<NicknameChoicesModel> m2026s() {
                this.f1340o = super.a(this.f1340o, 11, NicknameChoicesModel.class);
                return (ImmutableList) this.f1340o;
            }

            @Nullable
            public final RideProviderModel m2027t() {
                this.f1341p = (RideProviderModel) super.a(this.f1341p, 12, RideProviderModel.class);
                return this.f1341p;
            }

            public final int m2028u() {
                a(1, 5);
                return this.f1342q;
            }

            @Nullable
            public final String m2029v() {
                this.f1343r = super.a(this.f1343r, 14);
                return this.f1343r;
            }

            @Nullable
            public final String m2030w() {
                this.f1344s = super.a(this.f1344s, 15);
                return this.f1344s;
            }

            @Nullable
            public final String m2031x() {
                this.f1345t = super.a(this.f1345t, 16);
                return this.f1345t;
            }

            @Nullable
            public final String m2032y() {
                this.f1346u = super.a(this.f1346u, 17);
                return this.f1346u;
            }

            public final int m2033z() {
                a(2, 2);
                return this.f1347v;
            }

            public final int jK_() {
                return 1942977040;
            }

            public final GraphQLVisitableModel m2014a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                Builder a;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2018k() != null) {
                    a = ModelHelper.a(m2018k(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ExtensibleMessageAdminTextModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1332g = a.b();
                    }
                }
                if (m2026s() != null) {
                    a = ModelHelper.a(m2026s(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ExtensibleMessageAdminTextModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1340o = a.b();
                    }
                }
                GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
                if (m2027t() != null) {
                    RideProviderModel rideProviderModel = (RideProviderModel) graphQLModelMutatingVisitor.b(m2027t());
                    if (m2027t() != rideProviderModel) {
                        graphQLVisitableModel2 = (ExtensibleMessageAdminTextModel) ModelHelper.a(graphQLVisitableModel2, this);
                        graphQLVisitableModel2.f1341p = rideProviderModel;
                    }
                }
                i();
                return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
            }

            public final int m2013a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2012A());
                int b = flatBufferBuilder.b(m2015a());
                int d = flatBufferBuilder.d(m2017j());
                int a2 = ModelHelper.a(flatBufferBuilder, m2018k());
                int c = flatBufferBuilder.c(m2019l());
                int c2 = flatBufferBuilder.c(m2020m());
                int b2 = flatBufferBuilder.b(m2021n());
                int b3 = flatBufferBuilder.b(m2022o());
                int b4 = flatBufferBuilder.b(m2025r());
                int a3 = ModelHelper.a(flatBufferBuilder, m2026s());
                int a4 = ModelHelper.a(flatBufferBuilder, m2027t());
                int b5 = flatBufferBuilder.b(m2029v());
                int b6 = flatBufferBuilder.b(m2030w());
                int b7 = flatBufferBuilder.b(m2031x());
                int b8 = flatBufferBuilder.b(m2032y());
                flatBufferBuilder.c(19);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, d);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, c);
                flatBufferBuilder.b(5, c2);
                flatBufferBuilder.b(6, b2);
                flatBufferBuilder.b(7, b3);
                flatBufferBuilder.a(8, this.f1337l);
                flatBufferBuilder.a(9, this.f1338m);
                flatBufferBuilder.b(10, b4);
                flatBufferBuilder.b(11, a3);
                flatBufferBuilder.b(12, a4);
                flatBufferBuilder.a(13, this.f1342q, 0);
                flatBufferBuilder.b(14, b5);
                flatBufferBuilder.b(15, b6);
                flatBufferBuilder.b(16, b7);
                flatBufferBuilder.b(17, b8);
                flatBufferBuilder.a(18, this.f1347v, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2016a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1337l = mutableFlatBuffer.a(i, 8);
                this.f1338m = mutableFlatBuffer.a(i, 9);
                this.f1342q = mutableFlatBuffer.a(i, 13, 0);
                this.f1347v = mutableFlatBuffer.a(i, 18, 0);
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<GenericAdminMessageFieldsModel> {
            public final void m2034a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GenericAdminMessageFieldsModel genericAdminMessageFieldsModel = (GenericAdminMessageFieldsModel) obj;
                if (genericAdminMessageFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(genericAdminMessageFieldsModel.m2037a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    genericAdminMessageFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = genericAdminMessageFieldsModel.w_();
                int u_ = genericAdminMessageFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("extensible_message_admin_text");
                    ExtensibleMessageAdminTextParser.m2648a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("extensible_message_admin_text_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GenericAdminMessageFieldsModel.class, new Serializer());
            }
        }

        public GenericAdminMessageFieldsModel() {
            super(2);
        }

        @Nullable
        private ExtensibleMessageAdminTextModel m2035a() {
            this.f1348d = (ExtensibleMessageAdminTextModel) super.a(this.f1348d, 0, ExtensibleMessageAdminTextModel.class);
            return this.f1348d;
        }

        @Nullable
        private GraphQLExtensibleMessageAdminTextType m2036j() {
            this.f1349e = (GraphQLExtensibleMessageAdminTextType) super.b(this.f1349e, 1, GraphQLExtensibleMessageAdminTextType.class, GraphQLExtensibleMessageAdminTextType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1349e;
        }

        public final int jK_() {
            return -234751198;
        }

        public final GraphQLVisitableModel m2038a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2035a() != null) {
                ExtensibleMessageAdminTextModel extensibleMessageAdminTextModel = (ExtensibleMessageAdminTextModel) graphQLModelMutatingVisitor.b(m2035a());
                if (m2035a() != extensibleMessageAdminTextModel) {
                    graphQLVisitableModel = (GenericAdminMessageFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1348d = extensibleMessageAdminTextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2037a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2035a());
            int a2 = flatBufferBuilder.a(m2036j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2046620890)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class GenieStoryAttachmentFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GenieMessageFragmentModel f1350d;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GenieStoryAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m2039a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GenieStoryAttachmentFieldsParser.m2650a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object genieStoryAttachmentFieldsModel = new GenieStoryAttachmentFieldsModel();
                ((BaseModel) genieStoryAttachmentFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (genieStoryAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) genieStoryAttachmentFieldsModel).a();
                }
                return genieStoryAttachmentFieldsModel;
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<GenieStoryAttachmentFieldsModel> {
            public final void m2040a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GenieStoryAttachmentFieldsModel genieStoryAttachmentFieldsModel = (GenieStoryAttachmentFieldsModel) obj;
                if (genieStoryAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(genieStoryAttachmentFieldsModel.m2041a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    genieStoryAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GenieStoryAttachmentFieldsParser.m2651a(genieStoryAttachmentFieldsModel.w_(), genieStoryAttachmentFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GenieStoryAttachmentFieldsModel.class, new Serializer());
            }
        }

        public GenieStoryAttachmentFieldsModel() {
            super(1);
        }

        @Nullable
        public final GenieMessageFragmentModel m2043a() {
            this.f1350d = (GenieMessageFragmentModel) super.a(this.f1350d, 0, GenieMessageFragmentModel.class);
            return this.f1350d;
        }

        public final int jK_() {
            return -1267730472;
        }

        public final GraphQLVisitableModel m2042a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2043a() != null) {
                GenieMessageFragmentModel genieMessageFragmentModel = (GenieMessageFragmentModel) graphQLModelMutatingVisitor.b(m2043a());
                if (m2043a() != genieMessageFragmentModel) {
                    graphQLVisitableModel = (GenieStoryAttachmentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1350d = genieMessageFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2041a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2043a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 729935302)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class ImageInfoModel extends BaseModel implements GraphQLVisitableModel {
        private int f1351d;
        @Nullable
        private String f1352e;
        private int f1353f;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ImageInfoModel.class, new Deserializer());
            }

            public Object m2044a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ImageInfoParser.m2652a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object imageInfoModel = new ImageInfoModel();
                ((BaseModel) imageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (imageInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) imageInfoModel).a();
                }
                return imageInfoModel;
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<ImageInfoModel> {
            public final void m2045a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ImageInfoModel imageInfoModel = (ImageInfoModel) obj;
                if (imageInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(imageInfoModel.m2047a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    imageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ImageInfoParser.m2653a(imageInfoModel.w_(), imageInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ImageInfoModel.class, new Serializer());
            }
        }

        public ImageInfoModel() {
            super(3);
        }

        public final int m2046a() {
            a(0, 0);
            return this.f1351d;
        }

        @Nullable
        public final String m2050j() {
            this.f1352e = super.a(this.f1352e, 1);
            return this.f1352e;
        }

        public final int m2051k() {
            a(0, 2);
            return this.f1353f;
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m2048a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2047a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2050j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f1351d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f1353f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2049a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1351d = mutableFlatBuffer.a(i, 0, 0);
            this.f1353f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2023271792)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class JoinableModeInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1354d;
        @Nullable
        private String f1355e;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(JoinableModeInfoModel.class, new Deserializer());
            }

            public Object m2052a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(JoinableModeInfoParser.m2654a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object joinableModeInfoModel = new JoinableModeInfoModel();
                ((BaseModel) joinableModeInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (joinableModeInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) joinableModeInfoModel).a();
                }
                return joinableModeInfoModel;
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<JoinableModeInfoModel> {
            public final void m2053a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                JoinableModeInfoModel joinableModeInfoModel = (JoinableModeInfoModel) obj;
                if (joinableModeInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(joinableModeInfoModel.m2054a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    joinableModeInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                JoinableModeInfoParser.m2655a(joinableModeInfoModel.w_(), joinableModeInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(JoinableModeInfoModel.class, new Serializer());
            }
        }

        public JoinableModeInfoModel() {
            super(2);
        }

        @Nullable
        public final String m2056a() {
            this.f1354d = super.a(this.f1354d, 0);
            return this.f1354d;
        }

        @Nullable
        public final String m2057j() {
            this.f1355e = super.a(this.f1355e, 1);
            return this.f1355e;
        }

        public final int jK_() {
            return 65438904;
        }

        public final GraphQLVisitableModel m2055a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2054a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2056a());
            int b2 = flatBufferBuilder.b(m2057j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1112833733)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class MessageAnimatedImageAttachmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ImageInfoModel f1358d;
        @Nullable
        private ImageInfoModel f1359e;
        @Nullable
        private ImageInfoModel f1360f;
        @Nullable
        private AnimatedImageOriginalDimensionsModel f1361g;
        private boolean f1362h;
        @Nullable
        private ImageInfoModel f1363i;
        @Nullable
        private ImageInfoModel f1364j;
        @Nullable
        private ImageInfoModel f1365k;
        @Nullable
        private ImageInfoModel f1366l;
        @Nullable
        private ImageInfoModel f1367m;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -496435496)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class AnimatedImageOriginalDimensionsModel extends BaseModel implements GraphQLVisitableModel {
            private double f1356d;
            private double f1357e;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AnimatedImageOriginalDimensionsModel.class, new Deserializer());
                }

                public Object m2058a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AnimatedImageOriginalDimensionsParser.m2656a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object animatedImageOriginalDimensionsModel = new AnimatedImageOriginalDimensionsModel();
                    ((BaseModel) animatedImageOriginalDimensionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (animatedImageOriginalDimensionsModel instanceof Postprocessable) {
                        return ((Postprocessable) animatedImageOriginalDimensionsModel).a();
                    }
                    return animatedImageOriginalDimensionsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<AnimatedImageOriginalDimensionsModel> {
                public final void m2059a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AnimatedImageOriginalDimensionsModel animatedImageOriginalDimensionsModel = (AnimatedImageOriginalDimensionsModel) obj;
                    if (animatedImageOriginalDimensionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(animatedImageOriginalDimensionsModel.m2061a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        animatedImageOriginalDimensionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AnimatedImageOriginalDimensionsParser.m2657a(animatedImageOriginalDimensionsModel.w_(), animatedImageOriginalDimensionsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AnimatedImageOriginalDimensionsModel.class, new Serializer());
                }
            }

            public AnimatedImageOriginalDimensionsModel() {
                super(2);
            }

            public final double m2060a() {
                a(0, 0);
                return this.f1356d;
            }

            public final double m2064j() {
                a(0, 1);
                return this.f1357e;
            }

            public final int jK_() {
                return 82530482;
            }

            public final GraphQLVisitableModel m2062a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2061a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f1356d, 0.0d);
                flatBufferBuilder.a(1, this.f1357e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2063a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1356d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f1357e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessageAnimatedImageAttachmentModel.class, new Deserializer());
            }

            public Object m2065a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MessageAnimatedImageAttachmentParser.m2658a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object messageAnimatedImageAttachmentModel = new MessageAnimatedImageAttachmentModel();
                ((BaseModel) messageAnimatedImageAttachmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (messageAnimatedImageAttachmentModel instanceof Postprocessable) {
                    return ((Postprocessable) messageAnimatedImageAttachmentModel).a();
                }
                return messageAnimatedImageAttachmentModel;
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<MessageAnimatedImageAttachmentModel> {
            public final void m2066a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessageAnimatedImageAttachmentModel messageAnimatedImageAttachmentModel = (MessageAnimatedImageAttachmentModel) obj;
                if (messageAnimatedImageAttachmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messageAnimatedImageAttachmentModel.m2076a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messageAnimatedImageAttachmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messageAnimatedImageAttachmentModel.w_();
                int u_ = messageAnimatedImageAttachmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("animated_image_full_screen");
                    ImageInfoParser.m2653a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("animated_image_large_preview");
                    ImageInfoParser.m2653a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("animated_image_medium_preview");
                    ImageInfoParser.m2653a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("animated_image_original_dimensions");
                    AnimatedImageOriginalDimensionsParser.m2657a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 4);
                if (a) {
                    jsonGenerator.a("animated_image_render_as_sticker");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("animated_image_small_preview");
                    ImageInfoParser.m2653a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("animated_static_image_full_screen");
                    ImageInfoParser.m2653a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 7);
                if (g != 0) {
                    jsonGenerator.a("animated_static_image_large_preview");
                    ImageInfoParser.m2653a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 8);
                if (g != 0) {
                    jsonGenerator.a("animated_static_image_medium_preview");
                    ImageInfoParser.m2653a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 9);
                if (g != 0) {
                    jsonGenerator.a("animated_static_image_small_preview");
                    ImageInfoParser.m2653a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessageAnimatedImageAttachmentModel.class, new Serializer());
            }
        }

        public MessageAnimatedImageAttachmentModel() {
            super(10);
        }

        @Nullable
        private ImageInfoModel m2067a() {
            this.f1358d = (ImageInfoModel) super.a(this.f1358d, 0, ImageInfoModel.class);
            return this.f1358d;
        }

        @Nullable
        private ImageInfoModel m2068j() {
            this.f1359e = (ImageInfoModel) super.a(this.f1359e, 1, ImageInfoModel.class);
            return this.f1359e;
        }

        @Nullable
        private ImageInfoModel m2069k() {
            this.f1360f = (ImageInfoModel) super.a(this.f1360f, 2, ImageInfoModel.class);
            return this.f1360f;
        }

        @Nullable
        private AnimatedImageOriginalDimensionsModel m2070l() {
            this.f1361g = (AnimatedImageOriginalDimensionsModel) super.a(this.f1361g, 3, AnimatedImageOriginalDimensionsModel.class);
            return this.f1361g;
        }

        @Nullable
        private ImageInfoModel m2071m() {
            this.f1363i = (ImageInfoModel) super.a(this.f1363i, 5, ImageInfoModel.class);
            return this.f1363i;
        }

        @Nullable
        private ImageInfoModel m2072n() {
            this.f1364j = (ImageInfoModel) super.a(this.f1364j, 6, ImageInfoModel.class);
            return this.f1364j;
        }

        @Nullable
        private ImageInfoModel m2073o() {
            this.f1365k = (ImageInfoModel) super.a(this.f1365k, 7, ImageInfoModel.class);
            return this.f1365k;
        }

        @Nullable
        private ImageInfoModel m2074p() {
            this.f1366l = (ImageInfoModel) super.a(this.f1366l, 8, ImageInfoModel.class);
            return this.f1366l;
        }

        @Nullable
        private ImageInfoModel m2075q() {
            this.f1367m = (ImageInfoModel) super.a(this.f1367m, 9, ImageInfoModel.class);
            return this.f1367m;
        }

        public final int jK_() {
            return -702610223;
        }

        public final GraphQLVisitableModel m2077a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            ImageInfoModel imageInfoModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2067a() != null) {
                imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2067a());
                if (m2067a() != imageInfoModel) {
                    graphQLVisitableModel = (MessageAnimatedImageAttachmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1358d = imageInfoModel;
                }
            }
            if (m2068j() != null) {
                imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2068j());
                if (m2068j() != imageInfoModel) {
                    graphQLVisitableModel = (MessageAnimatedImageAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1359e = imageInfoModel;
                }
            }
            if (m2069k() != null) {
                imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2069k());
                if (m2069k() != imageInfoModel) {
                    graphQLVisitableModel = (MessageAnimatedImageAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1360f = imageInfoModel;
                }
            }
            if (m2070l() != null) {
                AnimatedImageOriginalDimensionsModel animatedImageOriginalDimensionsModel = (AnimatedImageOriginalDimensionsModel) graphQLModelMutatingVisitor.b(m2070l());
                if (m2070l() != animatedImageOriginalDimensionsModel) {
                    graphQLVisitableModel = (MessageAnimatedImageAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1361g = animatedImageOriginalDimensionsModel;
                }
            }
            if (m2071m() != null) {
                imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2071m());
                if (m2071m() != imageInfoModel) {
                    graphQLVisitableModel = (MessageAnimatedImageAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1363i = imageInfoModel;
                }
            }
            if (m2072n() != null) {
                imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2072n());
                if (m2072n() != imageInfoModel) {
                    graphQLVisitableModel = (MessageAnimatedImageAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1364j = imageInfoModel;
                }
            }
            if (m2073o() != null) {
                imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2073o());
                if (m2073o() != imageInfoModel) {
                    graphQLVisitableModel = (MessageAnimatedImageAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1365k = imageInfoModel;
                }
            }
            if (m2074p() != null) {
                imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2074p());
                if (m2074p() != imageInfoModel) {
                    graphQLVisitableModel = (MessageAnimatedImageAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1366l = imageInfoModel;
                }
            }
            if (m2075q() != null) {
                imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2075q());
                if (m2075q() != imageInfoModel) {
                    graphQLVisitableModel = (MessageAnimatedImageAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1367m = imageInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2076a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2067a());
            int a2 = ModelHelper.a(flatBufferBuilder, m2068j());
            int a3 = ModelHelper.a(flatBufferBuilder, m2069k());
            int a4 = ModelHelper.a(flatBufferBuilder, m2070l());
            int a5 = ModelHelper.a(flatBufferBuilder, m2071m());
            int a6 = ModelHelper.a(flatBufferBuilder, m2072n());
            int a7 = ModelHelper.a(flatBufferBuilder, m2073o());
            int a8 = ModelHelper.a(flatBufferBuilder, m2074p());
            int a9 = ModelHelper.a(flatBufferBuilder, m2075q());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.a(4, this.f1362h);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, a8);
            flatBufferBuilder.b(9, a9);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2078a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1362h = mutableFlatBuffer.a(i, 4);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1561164865)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class MessageInfoModel extends BaseModel implements GraphQLVisitableModel {
        private long f1407A;
        private long f1408B;
        @Nullable
        private StickerModel f1409C;
        @Nullable
        private List<String> f1410D;
        @Nullable
        private String f1411E;
        @Nullable
        private String f1412F;
        @Nullable
        private String f1413G;
        private int f1414H;
        private boolean f1415I;
        @Nullable
        private GraphQLObjectType f1416d;
        private boolean f1417e;
        private boolean f1418f;
        @Nullable
        private List<BlobAttachmentsModel> f1419g;
        @Nullable
        private GraphQLMNCommerceMessageType f1420h;
        @Nullable
        private List<CustomizationsModel> f1421i;
        private int f1422j;
        private int f1423k;
        @Nullable
        private XMAModel f1424l;
        @Nullable
        private ExtensibleMessageAdminTextModel f1425m;
        @Nullable
        private GraphQLExtensibleMessageAdminTextType f1426n;
        private boolean f1427o;
        private boolean f1428p;
        @Nullable
        private MessageModel f1429q;
        @Nullable
        private String f1430r;
        @Nullable
        private ParticipantInfoModel f1431s;
        @Nullable
        private String f1432t;
        @Nullable
        private GraphQLPeerToPeerPaymentMessageType f1433u;
        @Nullable
        private String f1434v;
        @Nullable
        private List<ParticipantInfoModel> f1435w;
        @Nullable
        private List<ParticipantInfoModel> f1436x;
        @Nullable
        private GraphQLPageAdminReplyType f1437y;
        @Nullable
        private String f1438z;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2138326059)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class BlobAttachmentsModel extends BaseModel implements GraphQLVisitableModel, AttachmentAttribution {
            private boolean f1370A;
            @Nullable
            private String f1371B;
            @Nullable
            private String f1372C;
            @Nullable
            private OriginalDimensionsModel f1373D;
            private int f1374E;
            private boolean f1375F;
            private int f1376G;
            @Nullable
            private StreamingImageThumbnailModel f1377H;
            private int f1378I;
            @Nullable
            private GraphQLMessageVideoType f1379J;
            @Nullable
            private GraphQLObjectType f1380d;
            @Nullable
            private ImageInfoModel f1381e;
            @Nullable
            private ImageInfoModel f1382f;
            @Nullable
            private ImageInfoModel f1383g;
            @Nullable
            private AnimatedImageOriginalDimensionsModel f1384h;
            private boolean f1385i;
            @Nullable
            private ImageInfoModel f1386j;
            @Nullable
            private ImageInfoModel f1387k;
            @Nullable
            private ImageInfoModel f1388l;
            @Nullable
            private ImageInfoModel f1389m;
            @Nullable
            private ImageInfoModel f1390n;
            @Nullable
            private String f1391o;
            @Nullable
            private String f1392p;
            @Nullable
            private AppAttributionInfoModel f1393q;
            @Nullable
            private List<AttributionAppScopedIdsModel> f1394r;
            @Nullable
            private String f1395s;
            @Nullable
            private String f1396t;
            private int f1397u;
            @Nullable
            private ImageInfoModel f1398v;
            @Nullable
            private ImageInfoModel f1399w;
            @Nullable
            private ImageInfoModel f1400x;
            @Nullable
            private ImageInfoModel f1401y;
            @Nullable
            private GraphQLMessageImageType f1402z;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BlobAttachmentsModel.class, new Deserializer());
                }

                public Object m2079a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BlobAttachmentsParser.m2662b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object blobAttachmentsModel = new BlobAttachmentsModel();
                    ((BaseModel) blobAttachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (blobAttachmentsModel instanceof Postprocessable) {
                        return ((Postprocessable) blobAttachmentsModel).a();
                    }
                    return blobAttachmentsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -496435496)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class OriginalDimensionsModel extends BaseModel implements GraphQLVisitableModel {
                private double f1368d;
                private double f1369e;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OriginalDimensionsModel.class, new Deserializer());
                    }

                    public Object m2080a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OriginalDimensionsParser.m2659a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object originalDimensionsModel = new OriginalDimensionsModel();
                        ((BaseModel) originalDimensionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (originalDimensionsModel instanceof Postprocessable) {
                            return ((Postprocessable) originalDimensionsModel).a();
                        }
                        return originalDimensionsModel;
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<OriginalDimensionsModel> {
                    public final void m2081a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OriginalDimensionsModel originalDimensionsModel = (OriginalDimensionsModel) obj;
                        if (originalDimensionsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(originalDimensionsModel.m2083a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            originalDimensionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OriginalDimensionsParser.m2660a(originalDimensionsModel.w_(), originalDimensionsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(OriginalDimensionsModel.class, new Serializer());
                    }
                }

                public OriginalDimensionsModel() {
                    super(2);
                }

                public final double m2082a() {
                    a(0, 0);
                    return this.f1368d;
                }

                public final double m2086j() {
                    a(0, 1);
                    return this.f1369e;
                }

                public final int jK_() {
                    return 82530482;
                }

                public final GraphQLVisitableModel m2084a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2083a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f1368d, 0.0d);
                    flatBufferBuilder.a(1, this.f1369e, 0.0d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2085a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1368d = mutableFlatBuffer.a(i, 0, 0.0d);
                    this.f1369e = mutableFlatBuffer.a(i, 1, 0.0d);
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<BlobAttachmentsModel> {
                public final void m2087a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BlobAttachmentsModel blobAttachmentsModel = (BlobAttachmentsModel) obj;
                    if (blobAttachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(blobAttachmentsModel.m2102a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        blobAttachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BlobAttachmentsParser.m2663b(blobAttachmentsModel.w_(), blobAttachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BlobAttachmentsModel.class, new Serializer());
                }
            }

            public BlobAttachmentsModel() {
                super(33);
            }

            @Nullable
            public final GraphQLObjectType m2103a() {
                if (this.b != null && this.f1380d == null) {
                    this.f1380d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1380d;
            }

            @Nullable
            public final ImageInfoModel m2106j() {
                this.f1381e = (ImageInfoModel) super.a(this.f1381e, 1, ImageInfoModel.class);
                return this.f1381e;
            }

            @Nullable
            public final ImageInfoModel m2107k() {
                this.f1382f = (ImageInfoModel) super.a(this.f1382f, 2, ImageInfoModel.class);
                return this.f1382f;
            }

            @Nullable
            public final ImageInfoModel m2108l() {
                this.f1383g = (ImageInfoModel) super.a(this.f1383g, 3, ImageInfoModel.class);
                return this.f1383g;
            }

            @Nullable
            public final AnimatedImageOriginalDimensionsModel m2109m() {
                this.f1384h = (AnimatedImageOriginalDimensionsModel) super.a(this.f1384h, 4, AnimatedImageOriginalDimensionsModel.class);
                return this.f1384h;
            }

            public final boolean m2110n() {
                a(0, 5);
                return this.f1385i;
            }

            @Nullable
            public final ImageInfoModel m2111o() {
                this.f1386j = (ImageInfoModel) super.a(this.f1386j, 6, ImageInfoModel.class);
                return this.f1386j;
            }

            @Nullable
            public final ImageInfoModel m2112p() {
                this.f1387k = (ImageInfoModel) super.a(this.f1387k, 7, ImageInfoModel.class);
                return this.f1387k;
            }

            @Nullable
            public final ImageInfoModel m2113q() {
                this.f1388l = (ImageInfoModel) super.a(this.f1388l, 8, ImageInfoModel.class);
                return this.f1388l;
            }

            @Nullable
            public final ImageInfoModel m2114r() {
                this.f1389m = (ImageInfoModel) super.a(this.f1389m, 9, ImageInfoModel.class);
                return this.f1389m;
            }

            @Nullable
            public final ImageInfoModel m2115s() {
                this.f1390n = (ImageInfoModel) super.a(this.f1390n, 10, ImageInfoModel.class);
                return this.f1390n;
            }

            @Nullable
            public final String m2116t() {
                this.f1391o = super.a(this.f1391o, 11);
                return this.f1391o;
            }

            @Nullable
            public final String m2117u() {
                this.f1392p = super.a(this.f1392p, 12);
                return this.f1392p;
            }

            @Nullable
            public final AppAttributionInfoModel m2118v() {
                this.f1393q = (AppAttributionInfoModel) super.a(this.f1393q, 13, AppAttributionInfoModel.class);
                return this.f1393q;
            }

            @Nonnull
            public final ImmutableList<AttributionAppScopedIdsModel> m2119w() {
                this.f1394r = super.a(this.f1394r, 14, AttributionAppScopedIdsModel.class);
                return (ImmutableList) this.f1394r;
            }

            @Nullable
            public final String m2120x() {
                this.f1395s = super.a(this.f1395s, 15);
                return this.f1395s;
            }

            @Nullable
            public final String m2121y() {
                this.f1396t = super.a(this.f1396t, 16);
                return this.f1396t;
            }

            public final int m2122z() {
                a(2, 1);
                return this.f1397u;
            }

            @Nullable
            public final ImageInfoModel m2088A() {
                this.f1398v = (ImageInfoModel) super.a(this.f1398v, 18, ImageInfoModel.class);
                return this.f1398v;
            }

            @Nullable
            public final ImageInfoModel m2089B() {
                this.f1399w = (ImageInfoModel) super.a(this.f1399w, 19, ImageInfoModel.class);
                return this.f1399w;
            }

            @Nullable
            public final ImageInfoModel m2090C() {
                this.f1400x = (ImageInfoModel) super.a(this.f1400x, 20, ImageInfoModel.class);
                return this.f1400x;
            }

            @Nullable
            public final ImageInfoModel m2091D() {
                this.f1401y = (ImageInfoModel) super.a(this.f1401y, 21, ImageInfoModel.class);
                return this.f1401y;
            }

            @Nullable
            public final GraphQLMessageImageType m2092E() {
                this.f1402z = (GraphQLMessageImageType) super.b(this.f1402z, 22, GraphQLMessageImageType.class, GraphQLMessageImageType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1402z;
            }

            public final boolean m2093F() {
                a(2, 7);
                return this.f1370A;
            }

            @Nullable
            public final String m2094G() {
                this.f1371B = super.a(this.f1371B, 24);
                return this.f1371B;
            }

            @Nullable
            public final String m2095H() {
                this.f1372C = super.a(this.f1372C, 25);
                return this.f1372C;
            }

            @Nullable
            public final OriginalDimensionsModel m2096I() {
                this.f1373D = (OriginalDimensionsModel) super.a(this.f1373D, 26, OriginalDimensionsModel.class);
                return this.f1373D;
            }

            public final int m2097J() {
                a(3, 3);
                return this.f1374E;
            }

            public final boolean m2098K() {
                a(3, 4);
                return this.f1375F;
            }

            public final int m2099L() {
                a(3, 5);
                return this.f1376G;
            }

            @Nullable
            public final StreamingImageThumbnailModel m2100M() {
                this.f1377H = (StreamingImageThumbnailModel) super.a(this.f1377H, 30, StreamingImageThumbnailModel.class);
                return this.f1377H;
            }

            @Nullable
            public final GraphQLMessageVideoType m2101N() {
                this.f1379J = (GraphQLMessageVideoType) super.b(this.f1379J, 32, GraphQLMessageVideoType.class, GraphQLMessageVideoType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1379J;
            }

            public final int jK_() {
                return -715306905;
            }

            public final GraphQLVisitableModel m2104a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                ImageInfoModel imageInfoModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2106j() != null) {
                    imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2106j());
                    if (m2106j() != imageInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1381e = imageInfoModel;
                    }
                }
                if (m2107k() != null) {
                    imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2107k());
                    if (m2107k() != imageInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1382f = imageInfoModel;
                    }
                }
                if (m2108l() != null) {
                    imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2108l());
                    if (m2108l() != imageInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1383g = imageInfoModel;
                    }
                }
                if (m2109m() != null) {
                    AnimatedImageOriginalDimensionsModel animatedImageOriginalDimensionsModel = (AnimatedImageOriginalDimensionsModel) graphQLModelMutatingVisitor.b(m2109m());
                    if (m2109m() != animatedImageOriginalDimensionsModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1384h = animatedImageOriginalDimensionsModel;
                    }
                }
                if (m2111o() != null) {
                    imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2111o());
                    if (m2111o() != imageInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1386j = imageInfoModel;
                    }
                }
                if (m2112p() != null) {
                    imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2112p());
                    if (m2112p() != imageInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1387k = imageInfoModel;
                    }
                }
                if (m2113q() != null) {
                    imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2113q());
                    if (m2113q() != imageInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1388l = imageInfoModel;
                    }
                }
                if (m2114r() != null) {
                    imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2114r());
                    if (m2114r() != imageInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1389m = imageInfoModel;
                    }
                }
                if (m2115s() != null) {
                    imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2115s());
                    if (m2115s() != imageInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1390n = imageInfoModel;
                    }
                }
                if (m2118v() != null) {
                    AppAttributionInfoModel appAttributionInfoModel = (AppAttributionInfoModel) graphQLModelMutatingVisitor.b(m2118v());
                    if (m2118v() != appAttributionInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1393q = appAttributionInfoModel;
                    }
                }
                if (m2119w() != null) {
                    Builder a = ModelHelper.a(m2119w(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        BlobAttachmentsModel blobAttachmentsModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        blobAttachmentsModel.f1394r = a.b();
                        graphQLVisitableModel = blobAttachmentsModel;
                    }
                }
                if (m2088A() != null) {
                    imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2088A());
                    if (m2088A() != imageInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1398v = imageInfoModel;
                    }
                }
                if (m2089B() != null) {
                    imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2089B());
                    if (m2089B() != imageInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1399w = imageInfoModel;
                    }
                }
                if (m2090C() != null) {
                    imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2090C());
                    if (m2090C() != imageInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1400x = imageInfoModel;
                    }
                }
                if (m2091D() != null) {
                    imageInfoModel = (ImageInfoModel) graphQLModelMutatingVisitor.b(m2091D());
                    if (m2091D() != imageInfoModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1401y = imageInfoModel;
                    }
                }
                if (m2096I() != null) {
                    OriginalDimensionsModel originalDimensionsModel = (OriginalDimensionsModel) graphQLModelMutatingVisitor.b(m2096I());
                    if (m2096I() != originalDimensionsModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1373D = originalDimensionsModel;
                    }
                }
                if (m2100M() != null) {
                    StreamingImageThumbnailModel streamingImageThumbnailModel = (StreamingImageThumbnailModel) graphQLModelMutatingVisitor.b(m2100M());
                    if (m2100M() != streamingImageThumbnailModel) {
                        graphQLVisitableModel = (BlobAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1377H = streamingImageThumbnailModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2102a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2103a());
                int a2 = ModelHelper.a(flatBufferBuilder, m2106j());
                int a3 = ModelHelper.a(flatBufferBuilder, m2107k());
                int a4 = ModelHelper.a(flatBufferBuilder, m2108l());
                int a5 = ModelHelper.a(flatBufferBuilder, m2109m());
                int a6 = ModelHelper.a(flatBufferBuilder, m2111o());
                int a7 = ModelHelper.a(flatBufferBuilder, m2112p());
                int a8 = ModelHelper.a(flatBufferBuilder, m2113q());
                int a9 = ModelHelper.a(flatBufferBuilder, m2114r());
                int a10 = ModelHelper.a(flatBufferBuilder, m2115s());
                int b = flatBufferBuilder.b(m2116t());
                int b2 = flatBufferBuilder.b(m2117u());
                int a11 = ModelHelper.a(flatBufferBuilder, m2118v());
                int a12 = ModelHelper.a(flatBufferBuilder, m2119w());
                int b3 = flatBufferBuilder.b(m2120x());
                int b4 = flatBufferBuilder.b(m2121y());
                int a13 = ModelHelper.a(flatBufferBuilder, m2088A());
                int a14 = ModelHelper.a(flatBufferBuilder, m2089B());
                int a15 = ModelHelper.a(flatBufferBuilder, m2090C());
                int a16 = ModelHelper.a(flatBufferBuilder, m2091D());
                int a17 = flatBufferBuilder.a(m2092E());
                int b5 = flatBufferBuilder.b(m2094G());
                int b6 = flatBufferBuilder.b(m2095H());
                int a18 = ModelHelper.a(flatBufferBuilder, m2096I());
                int a19 = ModelHelper.a(flatBufferBuilder, m2100M());
                int a20 = flatBufferBuilder.a(m2101N());
                flatBufferBuilder.c(33);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, a5);
                flatBufferBuilder.a(5, this.f1385i);
                flatBufferBuilder.b(6, a6);
                flatBufferBuilder.b(7, a7);
                flatBufferBuilder.b(8, a8);
                flatBufferBuilder.b(9, a9);
                flatBufferBuilder.b(10, a10);
                flatBufferBuilder.b(11, b);
                flatBufferBuilder.b(12, b2);
                flatBufferBuilder.b(13, a11);
                flatBufferBuilder.b(14, a12);
                flatBufferBuilder.b(15, b3);
                flatBufferBuilder.b(16, b4);
                flatBufferBuilder.a(17, this.f1397u, 0);
                flatBufferBuilder.b(18, a13);
                flatBufferBuilder.b(19, a14);
                flatBufferBuilder.b(20, a15);
                flatBufferBuilder.b(21, a16);
                flatBufferBuilder.b(22, a17);
                flatBufferBuilder.a(23, this.f1370A);
                flatBufferBuilder.b(24, b5);
                flatBufferBuilder.b(25, b6);
                flatBufferBuilder.b(26, a18);
                flatBufferBuilder.a(27, this.f1374E, 0);
                flatBufferBuilder.a(28, this.f1375F);
                flatBufferBuilder.a(29, this.f1376G, 0);
                flatBufferBuilder.b(30, a19);
                flatBufferBuilder.a(31, this.f1378I, 0);
                flatBufferBuilder.b(32, a20);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2105a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1385i = mutableFlatBuffer.a(i, 5);
                this.f1397u = mutableFlatBuffer.a(i, 17, 0);
                this.f1370A = mutableFlatBuffer.a(i, 23);
                this.f1374E = mutableFlatBuffer.a(i, 27, 0);
                this.f1375F = mutableFlatBuffer.a(i, 28);
                this.f1376G = mutableFlatBuffer.a(i, 29, 0);
                this.f1378I = mutableFlatBuffer.a(i, 31, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -639531001)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class CustomizationsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1403d;
            @Nullable
            private String f1404e;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CustomizationsModel.class, new Deserializer());
                }

                public Object m2123a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CustomizationsParser.m2666b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object customizationsModel = new CustomizationsModel();
                    ((BaseModel) customizationsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (customizationsModel instanceof Postprocessable) {
                        return ((Postprocessable) customizationsModel).a();
                    }
                    return customizationsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<CustomizationsModel> {
                public final void m2124a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CustomizationsModel customizationsModel = (CustomizationsModel) obj;
                    if (customizationsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(customizationsModel.m2125a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        customizationsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CustomizationsParser.m2665a(customizationsModel.w_(), customizationsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CustomizationsModel.class, new Serializer());
                }
            }

            public CustomizationsModel() {
                super(2);
            }

            @Nullable
            public final String m2127a() {
                this.f1403d = super.a(this.f1403d, 0);
                return this.f1403d;
            }

            @Nullable
            public final String m2128j() {
                this.f1404e = super.a(this.f1404e, 1);
                return this.f1404e;
            }

            public final int jK_() {
                return -1493135572;
            }

            public final GraphQLVisitableModel m2126a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2125a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2127a());
                int b2 = flatBufferBuilder.b(m2128j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessageInfoModel.class, new Deserializer());
            }

            public Object m2129a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MessageInfoParser.m2671b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object messageInfoModel = new MessageInfoModel();
                ((BaseModel) messageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (messageInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) messageInfoModel).a();
                }
                return messageInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class MessageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1405d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageModel.class, new Deserializer());
                }

                public Object m2130a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageParser.m2667a(jsonParser, flatBufferBuilder));
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

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<MessageModel> {
                public final void m2131a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageModel messageModel = (MessageModel) obj;
                    if (messageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageModel.m2132a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageParser.m2668a(messageModel.w_(), messageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessageModel.class, new Serializer());
                }
            }

            public MessageModel() {
                super(1);
            }

            @Nullable
            public final String m2134a() {
                this.f1405d = super.a(this.f1405d, 0);
                return this.f1405d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m2133a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2132a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2134a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<MessageInfoModel> {
            public final void m2135a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MessageInfoModel messageInfoModel = (MessageInfoModel) obj;
                if (messageInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messageInfoModel.m2155a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MessageInfoParser.m2672b(messageInfoModel.w_(), messageInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MessageInfoModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class StickerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f1406d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StickerModel.class, new Deserializer());
                }

                public Object m2136a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StickerParser.m2669a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stickerModel = new StickerModel();
                    ((BaseModel) stickerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stickerModel instanceof Postprocessable) {
                        return ((Postprocessable) stickerModel).a();
                    }
                    return stickerModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<StickerModel> {
                public final void m2137a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StickerModel stickerModel = (StickerModel) obj;
                    if (stickerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stickerModel.m2138a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stickerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StickerParser.m2670a(stickerModel.w_(), stickerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(StickerModel.class, new Serializer());
                }
            }

            public StickerModel() {
                super(1);
            }

            @Nullable
            public final String m2141j() {
                this.f1406d = super.a(this.f1406d, 0);
                return this.f1406d;
            }

            @Nullable
            public final String m2140a() {
                return m2141j();
            }

            public final int jK_() {
                return -225599203;
            }

            public final GraphQLVisitableModel m2139a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2138a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2141j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public MessageInfoModel() {
            super(32);
        }

        @Nullable
        public final GraphQLObjectType m2156a() {
            if (this.b != null && this.f1416d == null) {
                this.f1416d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1416d;
        }

        public final boolean m2159j() {
            a(0, 1);
            return this.f1417e;
        }

        public final boolean m2160k() {
            a(0, 2);
            return this.f1418f;
        }

        @Nonnull
        public final ImmutableList<BlobAttachmentsModel> m2161l() {
            this.f1419g = super.a(this.f1419g, 3, BlobAttachmentsModel.class);
            return (ImmutableList) this.f1419g;
        }

        @Nullable
        public final GraphQLMNCommerceMessageType m2162m() {
            this.f1420h = (GraphQLMNCommerceMessageType) super.b(this.f1420h, 4, GraphQLMNCommerceMessageType.class, GraphQLMNCommerceMessageType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1420h;
        }

        @Nonnull
        public final ImmutableList<CustomizationsModel> m2163n() {
            this.f1421i = super.a(this.f1421i, 5, CustomizationsModel.class);
            return (ImmutableList) this.f1421i;
        }

        public final int m2164o() {
            a(0, 6);
            return this.f1422j;
        }

        public final int m2165p() {
            a(0, 7);
            return this.f1423k;
        }

        @Nullable
        public final XMAModel m2166q() {
            this.f1424l = (XMAModel) super.a(this.f1424l, 8, XMAModel.class);
            return this.f1424l;
        }

        @Nullable
        public final ExtensibleMessageAdminTextModel m2167r() {
            this.f1425m = (ExtensibleMessageAdminTextModel) super.a(this.f1425m, 9, ExtensibleMessageAdminTextModel.class);
            return this.f1425m;
        }

        @Nullable
        public final GraphQLExtensibleMessageAdminTextType m2168s() {
            this.f1426n = (GraphQLExtensibleMessageAdminTextType) super.b(this.f1426n, 10, GraphQLExtensibleMessageAdminTextType.class, GraphQLExtensibleMessageAdminTextType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1426n;
        }

        public final boolean m2169t() {
            a(1, 3);
            return this.f1427o;
        }

        public final boolean m2170u() {
            a(1, 4);
            return this.f1428p;
        }

        @Nullable
        public final MessageModel m2171v() {
            this.f1429q = (MessageModel) super.a(this.f1429q, 13, MessageModel.class);
            return this.f1429q;
        }

        @Nullable
        public final String m2172w() {
            this.f1430r = super.a(this.f1430r, 14);
            return this.f1430r;
        }

        @Nullable
        public final ParticipantInfoModel m2173x() {
            this.f1431s = (ParticipantInfoModel) super.a(this.f1431s, 15, ParticipantInfoModel.class);
            return this.f1431s;
        }

        @Nullable
        public final String m2174y() {
            this.f1432t = super.a(this.f1432t, 16);
            return this.f1432t;
        }

        @Nullable
        public final GraphQLPeerToPeerPaymentMessageType m2175z() {
            this.f1433u = (GraphQLPeerToPeerPaymentMessageType) super.b(this.f1433u, 17, GraphQLPeerToPeerPaymentMessageType.class, GraphQLPeerToPeerPaymentMessageType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1433u;
        }

        @Nullable
        public final String m2144A() {
            this.f1434v = super.a(this.f1434v, 18);
            return this.f1434v;
        }

        @Nonnull
        public final ImmutableList<ParticipantInfoModel> m2145B() {
            this.f1435w = super.a(this.f1435w, 19, ParticipantInfoModel.class);
            return (ImmutableList) this.f1435w;
        }

        @Nonnull
        public final ImmutableList<ParticipantInfoModel> m2146C() {
            this.f1436x = super.a(this.f1436x, 20, ParticipantInfoModel.class);
            return (ImmutableList) this.f1436x;
        }

        @Nullable
        public final GraphQLPageAdminReplyType m2147D() {
            this.f1437y = (GraphQLPageAdminReplyType) super.b(this.f1437y, 21, GraphQLPageAdminReplyType.class, GraphQLPageAdminReplyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1437y;
        }

        @Nullable
        public final String m2148E() {
            this.f1438z = super.a(this.f1438z, 22);
            return this.f1438z;
        }

        public final long m2149F() {
            a(2, 7);
            return this.f1407A;
        }

        public final long m2150G() {
            a(3, 0);
            return this.f1408B;
        }

        @Nullable
        public final StickerModel m2151H() {
            this.f1409C = (StickerModel) super.a(this.f1409C, 25, StickerModel.class);
            return this.f1409C;
        }

        @Nonnull
        public final ImmutableList<String> m2152I() {
            this.f1410D = super.a(this.f1410D, 26);
            return (ImmutableList) this.f1410D;
        }

        @Nullable
        private String m2142L() {
            this.f1411E = super.a(this.f1411E, 27);
            return this.f1411E;
        }

        @Nullable
        private String m2143M() {
            this.f1412F = super.a(this.f1412F, 28);
            return this.f1412F;
        }

        @Nullable
        public final String m2153J() {
            this.f1413G = super.a(this.f1413G, 29);
            return this.f1413G;
        }

        public final int m2154K() {
            a(3, 6);
            return this.f1414H;
        }

        public final int jK_() {
            return -1675388953;
        }

        public final GraphQLVisitableModel m2157a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            Builder a2;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2161l() != null) {
                a = ModelHelper.a(m2161l(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (MessageInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1419g = a.b();
                }
            }
            if (m2163n() != null) {
                a = ModelHelper.a(m2163n(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (MessageInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1421i = a.b();
                }
            }
            GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
            if (m2166q() != null) {
                XMAModel xMAModel = (XMAModel) graphQLModelMutatingVisitor.b(m2166q());
                if (m2166q() != xMAModel) {
                    graphQLVisitableModel2 = (MessageInfoModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f1424l = xMAModel;
                }
            }
            if (m2167r() != null) {
                ExtensibleMessageAdminTextModel extensibleMessageAdminTextModel = (ExtensibleMessageAdminTextModel) graphQLModelMutatingVisitor.b(m2167r());
                if (m2167r() != extensibleMessageAdminTextModel) {
                    graphQLVisitableModel2 = (MessageInfoModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f1425m = extensibleMessageAdminTextModel;
                }
            }
            if (m2171v() != null) {
                MessageModel messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m2171v());
                if (m2171v() != messageModel) {
                    graphQLVisitableModel2 = (MessageInfoModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f1429q = messageModel;
                }
            }
            if (m2173x() != null) {
                ParticipantInfoModel participantInfoModel = (ParticipantInfoModel) graphQLModelMutatingVisitor.b(m2173x());
                if (m2173x() != participantInfoModel) {
                    graphQLVisitableModel2 = (MessageInfoModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f1431s = participantInfoModel;
                }
            }
            if (m2145B() != null) {
                a2 = ModelHelper.a(m2145B(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    MessageInfoModel messageInfoModel = (MessageInfoModel) ModelHelper.a(graphQLVisitableModel2, this);
                    messageInfoModel.f1435w = a2.b();
                    graphQLVisitableModel2 = messageInfoModel;
                }
            }
            if (m2146C() != null) {
                a2 = ModelHelper.a(m2146C(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    messageInfoModel = (MessageInfoModel) ModelHelper.a(graphQLVisitableModel2, this);
                    messageInfoModel.f1436x = a2.b();
                    graphQLVisitableModel2 = messageInfoModel;
                }
            }
            if (m2151H() != null) {
                StickerModel stickerModel = (StickerModel) graphQLModelMutatingVisitor.b(m2151H());
                if (m2151H() != stickerModel) {
                    graphQLVisitableModel2 = (MessageInfoModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f1409C = stickerModel;
                }
            }
            i();
            return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
        }

        public final int m2155a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2156a());
            int a2 = ModelHelper.a(flatBufferBuilder, m2161l());
            int a3 = flatBufferBuilder.a(m2162m());
            int a4 = ModelHelper.a(flatBufferBuilder, m2163n());
            int a5 = ModelHelper.a(flatBufferBuilder, m2166q());
            int a6 = ModelHelper.a(flatBufferBuilder, m2167r());
            int a7 = flatBufferBuilder.a(m2168s());
            int a8 = ModelHelper.a(flatBufferBuilder, m2171v());
            int b = flatBufferBuilder.b(m2172w());
            int a9 = ModelHelper.a(flatBufferBuilder, m2173x());
            int b2 = flatBufferBuilder.b(m2174y());
            int a10 = flatBufferBuilder.a(m2175z());
            int b3 = flatBufferBuilder.b(m2144A());
            int a11 = ModelHelper.a(flatBufferBuilder, m2145B());
            int a12 = ModelHelper.a(flatBufferBuilder, m2146C());
            int a13 = flatBufferBuilder.a(m2147D());
            int b4 = flatBufferBuilder.b(m2148E());
            int a14 = ModelHelper.a(flatBufferBuilder, m2151H());
            int c = flatBufferBuilder.c(m2152I());
            int b5 = flatBufferBuilder.b(m2142L());
            int b6 = flatBufferBuilder.b(m2143M());
            int b7 = flatBufferBuilder.b(m2153J());
            flatBufferBuilder.c(32);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f1417e);
            flatBufferBuilder.a(2, this.f1418f);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.a(6, this.f1422j, 0);
            flatBufferBuilder.a(7, this.f1423k, 0);
            flatBufferBuilder.b(8, a5);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.b(10, a7);
            flatBufferBuilder.a(11, this.f1427o);
            flatBufferBuilder.a(12, this.f1428p);
            flatBufferBuilder.b(13, a8);
            flatBufferBuilder.b(14, b);
            flatBufferBuilder.b(15, a9);
            flatBufferBuilder.b(16, b2);
            flatBufferBuilder.b(17, a10);
            flatBufferBuilder.b(18, b3);
            flatBufferBuilder.b(19, a11);
            flatBufferBuilder.b(20, a12);
            flatBufferBuilder.b(21, a13);
            flatBufferBuilder.b(22, b4);
            flatBufferBuilder.a(23, this.f1407A, 0);
            flatBufferBuilder.a(24, this.f1408B, 0);
            flatBufferBuilder.b(25, a14);
            flatBufferBuilder.b(26, c);
            flatBufferBuilder.b(27, b5);
            flatBufferBuilder.b(28, b6);
            flatBufferBuilder.b(29, b7);
            flatBufferBuilder.a(30, this.f1414H, 0);
            flatBufferBuilder.a(31, this.f1415I);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2158a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1417e = mutableFlatBuffer.a(i, 1);
            this.f1418f = mutableFlatBuffer.a(i, 2);
            this.f1422j = mutableFlatBuffer.a(i, 6, 0);
            this.f1423k = mutableFlatBuffer.a(i, 7, 0);
            this.f1427o = mutableFlatBuffer.a(i, 11);
            this.f1428p = mutableFlatBuffer.a(i, 12);
            this.f1407A = mutableFlatBuffer.a(i, 23, 0);
            this.f1408B = mutableFlatBuffer.a(i, 24, 0);
            this.f1414H = mutableFlatBuffer.a(i, 30, 0);
            this.f1415I = mutableFlatBuffer.a(i, 31);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1808005505)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class MessageVideoAttachmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1442d;
        @Nullable
        private String f1443e;
        @Nullable
        private OriginalDimensionsModel f1444f;
        private int f1445g;
        private int f1446h;
        @Nullable
        private StreamingImageThumbnailModel f1447i;
        private int f1448j;
        @Nullable
        private GraphQLMessageVideoType f1449k;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessageVideoAttachmentModel.class, new Deserializer());
            }

            public Object m2176a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MessageVideoAttachmentParser.m2677a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object messageVideoAttachmentModel = new MessageVideoAttachmentModel();
                ((BaseModel) messageVideoAttachmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (messageVideoAttachmentModel instanceof Postprocessable) {
                    return ((Postprocessable) messageVideoAttachmentModel).a();
                }
                return messageVideoAttachmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -496435496)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class OriginalDimensionsModel extends BaseModel implements GraphQLVisitableModel {
            private double f1439d;
            private double f1440e;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OriginalDimensionsModel.class, new Deserializer());
                }

                public Object m2177a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageVideoAttachmentParser.OriginalDimensionsParser.m2673a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object originalDimensionsModel = new OriginalDimensionsModel();
                    ((BaseModel) originalDimensionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (originalDimensionsModel instanceof Postprocessable) {
                        return ((Postprocessable) originalDimensionsModel).a();
                    }
                    return originalDimensionsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<OriginalDimensionsModel> {
                public final void m2178a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OriginalDimensionsModel originalDimensionsModel = (OriginalDimensionsModel) obj;
                    if (originalDimensionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(originalDimensionsModel.m2179a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        originalDimensionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageVideoAttachmentParser.OriginalDimensionsParser.m2674a(originalDimensionsModel.w_(), originalDimensionsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OriginalDimensionsModel.class, new Serializer());
                }
            }

            public OriginalDimensionsModel() {
                super(2);
            }

            public final int jK_() {
                return 82530482;
            }

            public final GraphQLVisitableModel m2180a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2179a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f1439d, 0.0d);
                flatBufferBuilder.a(1, this.f1440e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2181a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1439d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f1440e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<MessageVideoAttachmentModel> {
            public final void m2182a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessageVideoAttachmentModel messageVideoAttachmentModel = (MessageVideoAttachmentModel) obj;
                if (messageVideoAttachmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messageVideoAttachmentModel.m2193a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messageVideoAttachmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messageVideoAttachmentModel.w_();
                int u_ = messageVideoAttachmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("attachment_video_url");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("filename");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("original_dimensions");
                    MessageVideoAttachmentParser.OriginalDimensionsParser.m2674a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(u_, 3, 0);
                if (g != 0) {
                    jsonGenerator.a("playable_duration_in_ms");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(u_, 4, 0);
                if (g != 0) {
                    jsonGenerator.a("rotation");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("streamingImageThumbnail");
                    StreamingImageThumbnailParser.m2676a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(u_, 6, 0);
                if (g != 0) {
                    jsonGenerator.a("video_filesize");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(u_, 7) != 0) {
                    jsonGenerator.a("video_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 7));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessageVideoAttachmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class StreamingImageThumbnailModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1441d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StreamingImageThumbnailModel.class, new Deserializer());
                }

                public Object m2183a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StreamingImageThumbnailParser.m2675a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object streamingImageThumbnailModel = new StreamingImageThumbnailModel();
                    ((BaseModel) streamingImageThumbnailModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (streamingImageThumbnailModel instanceof Postprocessable) {
                        return ((Postprocessable) streamingImageThumbnailModel).a();
                    }
                    return streamingImageThumbnailModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<StreamingImageThumbnailModel> {
                public final void m2184a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StreamingImageThumbnailModel streamingImageThumbnailModel = (StreamingImageThumbnailModel) obj;
                    if (streamingImageThumbnailModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(streamingImageThumbnailModel.m2185a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        streamingImageThumbnailModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StreamingImageThumbnailParser.m2676a(streamingImageThumbnailModel.w_(), streamingImageThumbnailModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(StreamingImageThumbnailModel.class, new Serializer());
                }
            }

            public StreamingImageThumbnailModel() {
                super(1);
            }

            @Nullable
            public final String m2187a() {
                this.f1441d = super.a(this.f1441d, 0);
                return this.f1441d;
            }

            public final int jK_() {
                return 886594105;
            }

            public final GraphQLVisitableModel m2186a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2185a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2187a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public MessageVideoAttachmentModel() {
            super(8);
        }

        @Nullable
        private String m2188a() {
            this.f1442d = super.a(this.f1442d, 0);
            return this.f1442d;
        }

        @Nullable
        private String m2189j() {
            this.f1443e = super.a(this.f1443e, 1);
            return this.f1443e;
        }

        @Nullable
        private OriginalDimensionsModel m2190k() {
            this.f1444f = (OriginalDimensionsModel) super.a(this.f1444f, 2, OriginalDimensionsModel.class);
            return this.f1444f;
        }

        @Nullable
        private StreamingImageThumbnailModel m2191l() {
            this.f1447i = (StreamingImageThumbnailModel) super.a(this.f1447i, 5, StreamingImageThumbnailModel.class);
            return this.f1447i;
        }

        @Nullable
        private GraphQLMessageVideoType m2192m() {
            this.f1449k = (GraphQLMessageVideoType) super.b(this.f1449k, 7, GraphQLMessageVideoType.class, GraphQLMessageVideoType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1449k;
        }

        public final int jK_() {
            return -1130404652;
        }

        public final GraphQLVisitableModel m2194a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2190k() != null) {
                OriginalDimensionsModel originalDimensionsModel = (OriginalDimensionsModel) graphQLModelMutatingVisitor.b(m2190k());
                if (m2190k() != originalDimensionsModel) {
                    graphQLVisitableModel = (MessageVideoAttachmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1444f = originalDimensionsModel;
                }
            }
            if (m2191l() != null) {
                StreamingImageThumbnailModel streamingImageThumbnailModel = (StreamingImageThumbnailModel) graphQLModelMutatingVisitor.b(m2191l());
                if (m2191l() != streamingImageThumbnailModel) {
                    graphQLVisitableModel = (MessageVideoAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1447i = streamingImageThumbnailModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2193a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2188a());
            int b2 = flatBufferBuilder.b(m2189j());
            int a = ModelHelper.a(flatBufferBuilder, m2190k());
            int a2 = ModelHelper.a(flatBufferBuilder, m2191l());
            int a3 = flatBufferBuilder.a(m2192m());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.a(3, this.f1445g, 0);
            flatBufferBuilder.a(4, this.f1446h, 0);
            flatBufferBuilder.b(5, a2);
            flatBufferBuilder.a(6, this.f1448j, 0);
            flatBufferBuilder.b(7, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2195a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1445g = mutableFlatBuffer.a(i, 3, 0);
            this.f1446h = mutableFlatBuffer.a(i, 4, 0);
            this.f1448j = mutableFlatBuffer.a(i, 6, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1555244771)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class MessagesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<MessageInfoModel> f1451d;
        @Nullable
        private PageInfoModel f1452e;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessagesModel.class, new Deserializer());
            }

            public Object m2196a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MessagesParser.m2680a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object messagesModel = new MessagesModel();
                ((BaseModel) messagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (messagesModel instanceof Postprocessable) {
                    return ((Postprocessable) messagesModel).a();
                }
                return messagesModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1558866721)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f1450d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                }

                public Object m2197a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageInfoParser.m2678a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageInfoModel = new PageInfoModel();
                    ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) pageInfoModel).a();
                    }
                    return pageInfoModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<PageInfoModel> {
                public final void m2198a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageInfoModel pageInfoModel = (PageInfoModel) obj;
                    if (pageInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageInfoModel.m2199a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageInfoParser.m2679a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                }
            }

            public PageInfoModel() {
                super(1);
            }

            public final boolean m2202a() {
                a(0, 0);
                return this.f1450d;
            }

            public final int jK_() {
                return 923779069;
            }

            public final GraphQLVisitableModel m2200a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2199a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f1450d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2201a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1450d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<MessagesModel> {
            public final void m2203a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MessagesModel messagesModel = (MessagesModel) obj;
                if (messagesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messagesModel.m2204a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MessagesParser.m2681a(messagesModel.w_(), messagesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MessagesModel.class, new Serializer());
            }
        }

        public MessagesModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<MessageInfoModel> m2206a() {
            this.f1451d = super.a(this.f1451d, 0, MessageInfoModel.class);
            return (ImmutableList) this.f1451d;
        }

        @Nullable
        public final PageInfoModel m2207j() {
            this.f1452e = (PageInfoModel) super.a(this.f1452e, 1, PageInfoModel.class);
            return this.f1452e;
        }

        public final int jK_() {
            return 1801832203;
        }

        public final GraphQLVisitableModel m2205a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            PageInfoModel pageInfoModel;
            h();
            if (m2206a() != null) {
                Builder a = ModelHelper.a(m2206a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    MessagesModel messagesModel = (MessagesModel) ModelHelper.a(null, this);
                    messagesModel.f1451d = a.b();
                    graphQLVisitableModel = messagesModel;
                    if (m2207j() != null) {
                        pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m2207j());
                        if (m2207j() != pageInfoModel) {
                            graphQLVisitableModel = (MessagesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1452e = pageInfoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m2207j() != null) {
                pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m2207j());
                if (m2207j() != pageInfoModel) {
                    graphQLVisitableModel = (MessagesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1452e = pageInfoModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m2204a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2206a());
            int a2 = ModelHelper.a(flatBufferBuilder, m2207j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 648926669)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class MontageThreadListQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessageThreadsModel f1460d;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MontageThreadListQueryModel.class, new Deserializer());
            }

            public Object m2208a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MontageThreadListQueryParser.m2686a(jsonParser);
                Object montageThreadListQueryModel = new MontageThreadListQueryModel();
                ((BaseModel) montageThreadListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (montageThreadListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) montageThreadListQueryModel).a();
                }
                return montageThreadListQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -961507930)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class MessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
            private int f1454d;
            private int f1455e;
            @Nullable
            private List<ThreadInfoModel> f1456f;
            @Nullable
            private PageInfoModel f1457g;
            private int f1458h;
            private int f1459i;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageThreadsModel.class, new Deserializer());
                }

                public Object m2209a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MontageThreadListQueryParser.MessageThreadsParser.m2684a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messageThreadsModel = new MessageThreadsModel();
                    ((BaseModel) messageThreadsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messageThreadsModel instanceof Postprocessable) {
                        return ((Postprocessable) messageThreadsModel).a();
                    }
                    return messageThreadsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1947362733)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f1453d;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m2210a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MontageThreadListQueryParser.MessageThreadsParser.PageInfoParser.m2682a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m2211a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m2212a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MontageThreadListQueryParser.MessageThreadsParser.PageInfoParser.m2683a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(1);
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m2213a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2212a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f1453d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2214a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1453d = mutableFlatBuffer.a(i, 0);
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<MessageThreadsModel> {
                public final void m2215a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageThreadsModel messageThreadsModel = (MessageThreadsModel) obj;
                    if (messageThreadsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageThreadsModel.m2217a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MontageThreadListQueryParser.MessageThreadsParser.m2685a(messageThreadsModel.w_(), messageThreadsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessageThreadsModel.class, new Serializer());
                }
            }

            public MessageThreadsModel() {
                super(6);
            }

            @Nonnull
            public final ImmutableList<ThreadInfoModel> m2219a() {
                this.f1456f = super.a(this.f1456f, 2, ThreadInfoModel.class);
                return (ImmutableList) this.f1456f;
            }

            @Nullable
            private PageInfoModel m2216l() {
                this.f1457g = (PageInfoModel) super.a(this.f1457g, 3, PageInfoModel.class);
                return this.f1457g;
            }

            public final int m2221j() {
                a(0, 4);
                return this.f1458h;
            }

            public final int m2222k() {
                a(0, 5);
                return this.f1459i;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m2218a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m2219a() != null) {
                    Builder a = ModelHelper.a(m2219a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        MessageThreadsModel messageThreadsModel = (MessageThreadsModel) ModelHelper.a(null, this);
                        messageThreadsModel.f1456f = a.b();
                        graphQLVisitableModel = messageThreadsModel;
                        if (m2216l() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m2216l());
                            if (m2216l() != pageInfoModel) {
                                graphQLVisitableModel = (MessageThreadsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f1457g = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m2216l() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m2216l());
                    if (m2216l() != pageInfoModel) {
                        graphQLVisitableModel = (MessageThreadsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1457g = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m2217a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2219a());
                int a2 = ModelHelper.a(flatBufferBuilder, m2216l());
                flatBufferBuilder.c(6);
                flatBufferBuilder.a(0, this.f1454d, 0);
                flatBufferBuilder.a(1, this.f1455e, 0);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.a(4, this.f1458h, 0);
                flatBufferBuilder.a(5, this.f1459i, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2220a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1454d = mutableFlatBuffer.a(i, 0, 0);
                this.f1455e = mutableFlatBuffer.a(i, 1, 0);
                this.f1458h = mutableFlatBuffer.a(i, 4, 0);
                this.f1459i = mutableFlatBuffer.a(i, 5, 0);
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<MontageThreadListQueryModel> {
            public final void m2223a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MontageThreadListQueryModel montageThreadListQueryModel = (MontageThreadListQueryModel) obj;
                if (montageThreadListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(montageThreadListQueryModel.m2224a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    montageThreadListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = montageThreadListQueryModel.w_();
                int u_ = montageThreadListQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("message_threads");
                    MontageThreadListQueryParser.MessageThreadsParser.m2685a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MontageThreadListQueryModel.class, new Serializer());
            }
        }

        public MontageThreadListQueryModel() {
            super(1);
        }

        @Nullable
        public final MessageThreadsModel m2226a() {
            this.f1460d = (MessageThreadsModel) super.a(this.f1460d, 0, MessageThreadsModel.class);
            return this.f1460d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m2225a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2226a() != null) {
                MessageThreadsModel messageThreadsModel = (MessageThreadsModel) graphQLModelMutatingVisitor.b(m2226a());
                if (m2226a() != messageThreadsModel) {
                    graphQLVisitableModel = (MontageThreadListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1460d = messageThreadsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2224a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2226a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2136688925)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class MoreMessagesQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessagesModel f1461d;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MoreMessagesQueryModel.class, new Deserializer());
            }

            public Object m2227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MoreMessagesQueryParser.m2687a(jsonParser);
                Object moreMessagesQueryModel = new MoreMessagesQueryModel();
                ((BaseModel) moreMessagesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (moreMessagesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) moreMessagesQueryModel).a();
                }
                return moreMessagesQueryModel;
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<MoreMessagesQueryModel> {
            public final void m2228a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MoreMessagesQueryModel moreMessagesQueryModel = (MoreMessagesQueryModel) obj;
                if (moreMessagesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(moreMessagesQueryModel.m2229a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    moreMessagesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = moreMessagesQueryModel.w_();
                int u_ = moreMessagesQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messages");
                    MessagesParser.m2681a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MoreMessagesQueryModel.class, new Serializer());
            }
        }

        public MoreMessagesQueryModel() {
            super(1);
        }

        @Nullable
        public final MessagesModel m2231a() {
            this.f1461d = (MessagesModel) super.a(this.f1461d, 0, MessagesModel.class);
            return this.f1461d;
        }

        public final int jK_() {
            return -740570927;
        }

        public final GraphQLVisitableModel m2230a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2231a() != null) {
                MessagesModel messagesModel = (MessagesModel) graphQLModelMutatingVisitor.b(m2231a());
                if (m2231a() != messagesModel) {
                    graphQLVisitableModel = (MoreMessagesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1461d = messagesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2229a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2231a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1051038926)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class MoreThreadsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessageThreadsModel f1465d;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MoreThreadsQueryModel.class, new Deserializer());
            }

            public Object m2232a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MoreThreadsQueryParser.m2692a(jsonParser);
                Object moreThreadsQueryModel = new MoreThreadsQueryModel();
                ((BaseModel) moreThreadsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (moreThreadsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) moreThreadsQueryModel).a();
                }
                return moreThreadsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1183467816)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class MessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ThreadInfoModel> f1463d;
            @Nullable
            private PageInfoModel f1464e;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageThreadsModel.class, new Deserializer());
                }

                public Object m2233a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MoreThreadsQueryParser.MessageThreadsParser.m2690a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messageThreadsModel = new MessageThreadsModel();
                    ((BaseModel) messageThreadsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messageThreadsModel instanceof Postprocessable) {
                        return ((Postprocessable) messageThreadsModel).a();
                    }
                    return messageThreadsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1947362733)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f1462d;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m2234a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MoreThreadsQueryParser.MessageThreadsParser.PageInfoParser.m2688a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m2235a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m2236a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MoreThreadsQueryParser.MessageThreadsParser.PageInfoParser.m2689a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(1);
                }

                public final boolean m2239a() {
                    a(0, 0);
                    return this.f1462d;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m2237a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2236a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f1462d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2238a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1462d = mutableFlatBuffer.a(i, 0);
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<MessageThreadsModel> {
                public final void m2240a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageThreadsModel messageThreadsModel = (MessageThreadsModel) obj;
                    if (messageThreadsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageThreadsModel.m2241a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MoreThreadsQueryParser.MessageThreadsParser.m2691a(messageThreadsModel.w_(), messageThreadsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessageThreadsModel.class, new Serializer());
                }
            }

            public MessageThreadsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<ThreadInfoModel> m2243a() {
                this.f1463d = super.a(this.f1463d, 0, ThreadInfoModel.class);
                return (ImmutableList) this.f1463d;
            }

            @Nullable
            public final PageInfoModel m2244j() {
                this.f1464e = (PageInfoModel) super.a(this.f1464e, 1, PageInfoModel.class);
                return this.f1464e;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m2242a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m2243a() != null) {
                    Builder a = ModelHelper.a(m2243a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        MessageThreadsModel messageThreadsModel = (MessageThreadsModel) ModelHelper.a(null, this);
                        messageThreadsModel.f1463d = a.b();
                        graphQLVisitableModel = messageThreadsModel;
                        if (m2244j() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m2244j());
                            if (m2244j() != pageInfoModel) {
                                graphQLVisitableModel = (MessageThreadsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f1464e = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m2244j() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m2244j());
                    if (m2244j() != pageInfoModel) {
                        graphQLVisitableModel = (MessageThreadsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1464e = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m2241a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2243a());
                int a2 = ModelHelper.a(flatBufferBuilder, m2244j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<MoreThreadsQueryModel> {
            public final void m2245a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MoreThreadsQueryModel moreThreadsQueryModel = (MoreThreadsQueryModel) obj;
                if (moreThreadsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(moreThreadsQueryModel.m2246a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    moreThreadsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = moreThreadsQueryModel.w_();
                int u_ = moreThreadsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("message_threads");
                    MoreThreadsQueryParser.MessageThreadsParser.m2691a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MoreThreadsQueryModel.class, new Serializer());
            }
        }

        public MoreThreadsQueryModel() {
            super(1);
        }

        @Nullable
        public final MessageThreadsModel m2248a() {
            this.f1465d = (MessageThreadsModel) super.a(this.f1465d, 0, MessageThreadsModel.class);
            return this.f1465d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m2247a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2248a() != null) {
                MessageThreadsModel messageThreadsModel = (MessageThreadsModel) graphQLModelMutatingVisitor.b(m2248a());
                if (m2248a() != messageThreadsModel) {
                    graphQLVisitableModel = (MoreThreadsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1465d = messageThreadsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2246a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2248a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1160258916)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class PinnedThreadsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PinnedMessageThreadsModel f1468d;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PinnedThreadsQueryModel.class, new Deserializer());
            }

            public Object m2249a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PinnedThreadsQueryParser.m2695a(jsonParser);
                Object pinnedThreadsQueryModel = new PinnedThreadsQueryModel();
                ((BaseModel) pinnedThreadsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pinnedThreadsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pinnedThreadsQueryModel).a();
                }
                return pinnedThreadsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2073883453)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class PinnedMessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ThreadInfoModel> f1466d;
            private long f1467e;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PinnedMessageThreadsModel.class, new Deserializer());
                }

                public Object m2250a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PinnedMessageThreadsParser.m2693a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pinnedMessageThreadsModel = new PinnedMessageThreadsModel();
                    ((BaseModel) pinnedMessageThreadsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pinnedMessageThreadsModel instanceof Postprocessable) {
                        return ((Postprocessable) pinnedMessageThreadsModel).a();
                    }
                    return pinnedMessageThreadsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<PinnedMessageThreadsModel> {
                public final void m2251a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PinnedMessageThreadsModel pinnedMessageThreadsModel = (PinnedMessageThreadsModel) obj;
                    if (pinnedMessageThreadsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pinnedMessageThreadsModel.m2252a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pinnedMessageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PinnedMessageThreadsParser.m2694a(pinnedMessageThreadsModel.w_(), pinnedMessageThreadsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PinnedMessageThreadsModel.class, new Serializer());
                }
            }

            public PinnedMessageThreadsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<ThreadInfoModel> m2254a() {
                this.f1466d = super.a(this.f1466d, 0, ThreadInfoModel.class);
                return (ImmutableList) this.f1466d;
            }

            public final long m2256j() {
                a(0, 1);
                return this.f1467e;
            }

            public final int jK_() {
                return -1580303816;
            }

            public final GraphQLVisitableModel m2253a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2254a() != null) {
                    Builder a = ModelHelper.a(m2254a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PinnedMessageThreadsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1466d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2252a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2254a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f1467e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2255a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1467e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<PinnedThreadsQueryModel> {
            public final void m2257a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PinnedThreadsQueryModel pinnedThreadsQueryModel = (PinnedThreadsQueryModel) obj;
                if (pinnedThreadsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pinnedThreadsQueryModel.m2258a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pinnedThreadsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pinnedThreadsQueryModel.w_();
                int u_ = pinnedThreadsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("pinned_message_threads");
                    PinnedMessageThreadsParser.m2694a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PinnedThreadsQueryModel.class, new Serializer());
            }
        }

        public PinnedThreadsQueryModel() {
            super(1);
        }

        @Nullable
        public final PinnedMessageThreadsModel m2260a() {
            this.f1468d = (PinnedMessageThreadsModel) super.a(this.f1468d, 0, PinnedMessageThreadsModel.class);
            return this.f1468d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m2259a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2260a() != null) {
                PinnedMessageThreadsModel pinnedMessageThreadsModel = (PinnedMessageThreadsModel) graphQLModelMutatingVisitor.b(m2260a());
                if (m2260a() != pinnedMessageThreadsModel) {
                    graphQLVisitableModel = (PinnedThreadsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1468d = pinnedMessageThreadsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2258a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2260a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -924631078)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class ReceiptInfoModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f1471d;
        @Nullable
        private ActorModel f1472e;
        @Nullable
        private String f1473f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class ActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f1469d;
            @Nullable
            private String f1470e;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                }

                public Object m2261a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActorParser.m2696a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actorModel = new ActorModel();
                    ((BaseModel) actorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actorModel instanceof Postprocessable) {
                        return ((Postprocessable) actorModel).a();
                    }
                    return actorModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<ActorModel> {
                public final void m2262a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActorModel actorModel = (ActorModel) obj;
                    if (actorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actorModel.m2264a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActorParser.m2697a(actorModel.w_(), actorModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ActorModel.class, new Serializer());
                }
            }

            public ActorModel() {
                super(2);
            }

            public final void m2267a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m2268a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m2263k() {
                if (this.b != null && this.f1469d == null) {
                    this.f1469d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1469d;
            }

            @Nullable
            public final String m2269j() {
                this.f1470e = super.a(this.f1470e, 1);
                return this.f1470e;
            }

            @Nullable
            public final String m2266a() {
                return m2269j();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m2265a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2264a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2263k());
                int b = flatBufferBuilder.b(m2269j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReceiptInfoModel.class, new Deserializer());
            }

            public Object m2270a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReceiptInfoParser.m2700b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object receiptInfoModel = new ReceiptInfoModel();
                ((BaseModel) receiptInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (receiptInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) receiptInfoModel).a();
                }
                return receiptInfoModel;
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<ReceiptInfoModel> {
            public final void m2271a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReceiptInfoModel receiptInfoModel = (ReceiptInfoModel) obj;
                if (receiptInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(receiptInfoModel.m2273a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    receiptInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReceiptInfoParser.m2701b(receiptInfoModel.w_(), receiptInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReceiptInfoModel.class, new Serializer());
            }
        }

        public ReceiptInfoModel() {
            super(3);
        }

        public final void m2276a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2277a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m2272k() {
            if (this.b != null && this.f1471d == null) {
                this.f1471d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1471d;
        }

        @Nullable
        public final ActorModel m2275a() {
            this.f1472e = (ActorModel) super.a(this.f1472e, 1, ActorModel.class);
            return this.f1472e;
        }

        @Nullable
        public final String m2278j() {
            this.f1473f = super.a(this.f1473f, 2);
            return this.f1473f;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m2274a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2275a() != null) {
                ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m2275a());
                if (m2275a() != actorModel) {
                    graphQLVisitableModel = (ReceiptInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1472e = actorModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2273a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2272k());
            int a2 = ModelHelper.a(flatBufferBuilder, m2275a());
            int b = flatBufferBuilder.b(m2278j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1835994332)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class SearchParticipantTagsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessageThreadsModel f1475d;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchParticipantTagsQueryModel.class, new Deserializer());
            }

            public Object m2279a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SearchParticipantTagsQueryParser.m2704a(jsonParser);
                Object searchParticipantTagsQueryModel = new SearchParticipantTagsQueryModel();
                ((BaseModel) searchParticipantTagsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (searchParticipantTagsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) searchParticipantTagsQueryModel).a();
                }
                return searchParticipantTagsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -412013063)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class MessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ThreadInfoModel> f1474d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageThreadsModel.class, new Deserializer());
                }

                public Object m2280a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SearchParticipantTagsQueryParser.MessageThreadsParser.m2702a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messageThreadsModel = new MessageThreadsModel();
                    ((BaseModel) messageThreadsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messageThreadsModel instanceof Postprocessable) {
                        return ((Postprocessable) messageThreadsModel).a();
                    }
                    return messageThreadsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<MessageThreadsModel> {
                public final void m2281a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageThreadsModel messageThreadsModel = (MessageThreadsModel) obj;
                    if (messageThreadsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageThreadsModel.m2283a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SearchParticipantTagsQueryParser.MessageThreadsParser.m2703a(messageThreadsModel.w_(), messageThreadsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessageThreadsModel.class, new Serializer());
                }
            }

            public MessageThreadsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<ThreadInfoModel> m2282a() {
                this.f1474d = super.a(this.f1474d, 0, ThreadInfoModel.class);
                return (ImmutableList) this.f1474d;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m2284a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2282a() != null) {
                    Builder a = ModelHelper.a(m2282a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessageThreadsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1474d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2283a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2282a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<SearchParticipantTagsQueryModel> {
            public final void m2285a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SearchParticipantTagsQueryModel searchParticipantTagsQueryModel = (SearchParticipantTagsQueryModel) obj;
                if (searchParticipantTagsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchParticipantTagsQueryModel.m2287a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchParticipantTagsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = searchParticipantTagsQueryModel.w_();
                int u_ = searchParticipantTagsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("message_threads");
                    SearchParticipantTagsQueryParser.MessageThreadsParser.m2703a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SearchParticipantTagsQueryModel.class, new Serializer());
            }
        }

        public SearchParticipantTagsQueryModel() {
            super(1);
        }

        @Nullable
        private MessageThreadsModel m2286a() {
            this.f1475d = (MessageThreadsModel) super.a(this.f1475d, 0, MessageThreadsModel.class);
            return this.f1475d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m2288a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2286a() != null) {
                MessageThreadsModel messageThreadsModel = (MessageThreadsModel) graphQLModelMutatingVisitor.b(m2286a());
                if (m2286a() != messageThreadsModel) {
                    graphQLVisitableModel = (SearchParticipantTagsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1475d = messageThreadsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2287a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2286a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -661216819)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class SearchThreadNameAndParticipantsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SearchResultsParticipantsModel f1478d;
        @Nullable
        private SearchResultsThreadNameModel f1479e;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchThreadNameAndParticipantsQueryModel.class, new Deserializer());
            }

            public Object m2289a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SearchThreadNameAndParticipantsQueryParser.m2709a(jsonParser);
                Object searchThreadNameAndParticipantsQueryModel = new SearchThreadNameAndParticipantsQueryModel();
                ((BaseModel) searchThreadNameAndParticipantsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (searchThreadNameAndParticipantsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) searchThreadNameAndParticipantsQueryModel).a();
                }
                return searchThreadNameAndParticipantsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -412013063)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class SearchResultsParticipantsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ThreadInfoModel> f1476d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SearchResultsParticipantsModel.class, new Deserializer());
                }

                public Object m2290a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SearchResultsParticipantsParser.m2705a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object searchResultsParticipantsModel = new SearchResultsParticipantsModel();
                    ((BaseModel) searchResultsParticipantsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (searchResultsParticipantsModel instanceof Postprocessable) {
                        return ((Postprocessable) searchResultsParticipantsModel).a();
                    }
                    return searchResultsParticipantsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<SearchResultsParticipantsModel> {
                public final void m2291a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SearchResultsParticipantsModel searchResultsParticipantsModel = (SearchResultsParticipantsModel) obj;
                    if (searchResultsParticipantsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(searchResultsParticipantsModel.m2292a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        searchResultsParticipantsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SearchResultsParticipantsParser.m2706a(searchResultsParticipantsModel.w_(), searchResultsParticipantsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SearchResultsParticipantsModel.class, new Serializer());
                }
            }

            public SearchResultsParticipantsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ThreadInfoModel> m2294a() {
                this.f1476d = super.a(this.f1476d, 0, ThreadInfoModel.class);
                return (ImmutableList) this.f1476d;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m2293a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2294a() != null) {
                    Builder a = ModelHelper.a(m2294a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SearchResultsParticipantsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1476d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2292a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2294a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -412013063)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class SearchResultsThreadNameModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ThreadInfoModel> f1477d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SearchResultsThreadNameModel.class, new Deserializer());
                }

                public Object m2295a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SearchResultsThreadNameParser.m2707a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object searchResultsThreadNameModel = new SearchResultsThreadNameModel();
                    ((BaseModel) searchResultsThreadNameModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (searchResultsThreadNameModel instanceof Postprocessable) {
                        return ((Postprocessable) searchResultsThreadNameModel).a();
                    }
                    return searchResultsThreadNameModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<SearchResultsThreadNameModel> {
                public final void m2296a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SearchResultsThreadNameModel searchResultsThreadNameModel = (SearchResultsThreadNameModel) obj;
                    if (searchResultsThreadNameModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(searchResultsThreadNameModel.m2297a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        searchResultsThreadNameModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SearchResultsThreadNameParser.m2708a(searchResultsThreadNameModel.w_(), searchResultsThreadNameModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SearchResultsThreadNameModel.class, new Serializer());
                }
            }

            public SearchResultsThreadNameModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ThreadInfoModel> m2299a() {
                this.f1477d = super.a(this.f1477d, 0, ThreadInfoModel.class);
                return (ImmutableList) this.f1477d;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m2298a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2299a() != null) {
                    Builder a = ModelHelper.a(m2299a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SearchResultsThreadNameModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1477d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2297a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2299a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<SearchThreadNameAndParticipantsQueryModel> {
            public final void m2300a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SearchThreadNameAndParticipantsQueryModel searchThreadNameAndParticipantsQueryModel = (SearchThreadNameAndParticipantsQueryModel) obj;
                if (searchThreadNameAndParticipantsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchThreadNameAndParticipantsQueryModel.m2301a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchThreadNameAndParticipantsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = searchThreadNameAndParticipantsQueryModel.w_();
                int u_ = searchThreadNameAndParticipantsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("search_results_participants");
                    SearchResultsParticipantsParser.m2706a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("search_results_thread_name");
                    SearchResultsThreadNameParser.m2708a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SearchThreadNameAndParticipantsQueryModel.class, new Serializer());
            }
        }

        public SearchThreadNameAndParticipantsQueryModel() {
            super(2);
        }

        @Nullable
        public final SearchResultsParticipantsModel m2303a() {
            this.f1478d = (SearchResultsParticipantsModel) super.a(this.f1478d, 0, SearchResultsParticipantsModel.class);
            return this.f1478d;
        }

        @Nullable
        public final SearchResultsThreadNameModel m2304j() {
            this.f1479e = (SearchResultsThreadNameModel) super.a(this.f1479e, 1, SearchResultsThreadNameModel.class);
            return this.f1479e;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m2302a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2303a() != null) {
                SearchResultsParticipantsModel searchResultsParticipantsModel = (SearchResultsParticipantsModel) graphQLModelMutatingVisitor.b(m2303a());
                if (m2303a() != searchResultsParticipantsModel) {
                    graphQLVisitableModel = (SearchThreadNameAndParticipantsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1478d = searchResultsParticipantsModel;
                }
            }
            if (m2304j() != null) {
                SearchResultsThreadNameModel searchResultsThreadNameModel = (SearchResultsThreadNameModel) graphQLModelMutatingVisitor.b(m2304j());
                if (m2304j() != searchResultsThreadNameModel) {
                    graphQLVisitableModel = (SearchThreadNameAndParticipantsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1479e = searchResultsThreadNameModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2301a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2303a());
            int a2 = ModelHelper.a(flatBufferBuilder, m2304j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1994444987)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class ThreadInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private ReadReceiptsModel f1513A;
        @Nullable
        private RtcCallDataInfoModel f1514B;
        @Nullable
        private List<ThreadGamesModel> f1515C;
        @Nullable
        private ThreadKeyModel f1516D;
        private boolean f1517E;
        @Nullable
        private ThreadQueueInfoModel f1518F;
        private int f1519G;
        @Nullable
        private String f1520H;
        @Nullable
        private ActiveBotsModel f1521d;
        @Nullable
        private AllParticipantIdsModel f1522e;
        @Nullable
        private AllParticipantsModel f1523f;
        private boolean f1524g;
        @Nullable
        private GraphQLMessageThreadCannotReplyReason f1525h;
        @Nullable
        private CustomizationInfoModel f1526i;
        @Nullable
        private DeliveryReceiptsModel f1527j;
        private int f1528k;
        @Nullable
        private EventRemindersModel f1529l;
        @Nullable
        private GraphQLMailboxFolder f1530m;
        @Nullable
        private FormerParticipantIdsModel f1531n;
        @Nullable
        private FormerParticipantsModel f1532o;
        private double f1533p;
        private boolean f1534q;
        @Nullable
        private String f1535r;
        @Nullable
        private ImageModel f1536s;
        private boolean f1537t;
        private boolean f1538u;
        @Nullable
        private LastMessageModel f1539v;
        @Nullable
        private MessagesModel f1540w;
        private int f1541x;
        private int f1542y;
        @Nullable
        private String f1543z;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1364907720)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class ActiveBotsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BotMessagingActorInfoModel> f1480d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActiveBotsModel.class, new Deserializer());
                }

                public Object m2305a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActiveBotsParser.m2710a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object activeBotsModel = new ActiveBotsModel();
                    ((BaseModel) activeBotsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (activeBotsModel instanceof Postprocessable) {
                        return ((Postprocessable) activeBotsModel).a();
                    }
                    return activeBotsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<ActiveBotsModel> {
                public final void m2306a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActiveBotsModel activeBotsModel = (ActiveBotsModel) obj;
                    if (activeBotsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(activeBotsModel.m2307a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        activeBotsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActiveBotsParser.m2711a(activeBotsModel.w_(), activeBotsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActiveBotsModel.class, new Serializer());
                }
            }

            public ActiveBotsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BotMessagingActorInfoModel> m2309a() {
                this.f1480d = super.a(this.f1480d, 0, BotMessagingActorInfoModel.class);
                return (ImmutableList) this.f1480d;
            }

            public final int jK_() {
                return -174762705;
            }

            public final GraphQLVisitableModel m2308a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2309a() != null) {
                    Builder a = ModelHelper.a(m2309a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ActiveBotsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1480d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2307a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2309a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 854471674)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class AllParticipantIdsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MessagingActorIdModel> f1481d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AllParticipantIdsModel.class, new Deserializer());
                }

                public Object m2310a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AllParticipantIdsParser.m2712a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object allParticipantIdsModel = new AllParticipantIdsModel();
                    ((BaseModel) allParticipantIdsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (allParticipantIdsModel instanceof Postprocessable) {
                        return ((Postprocessable) allParticipantIdsModel).a();
                    }
                    return allParticipantIdsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<AllParticipantIdsModel> {
                public final void m2311a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AllParticipantIdsModel allParticipantIdsModel = (AllParticipantIdsModel) obj;
                    if (allParticipantIdsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(allParticipantIdsModel.m2312a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        allParticipantIdsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AllParticipantIdsParser.m2713a(allParticipantIdsModel.w_(), allParticipantIdsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AllParticipantIdsModel.class, new Serializer());
                }
            }

            public AllParticipantIdsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<MessagingActorIdModel> m2314a() {
                this.f1481d = super.a(this.f1481d, 0, MessagingActorIdModel.class);
                return (ImmutableList) this.f1481d;
            }

            public final int jK_() {
                return -700993630;
            }

            public final GraphQLVisitableModel m2313a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2314a() != null) {
                    Builder a = ModelHelper.a(m2314a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AllParticipantIdsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1481d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2312a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2314a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1842602993)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class AllParticipantsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MessagingActorInfoModel> f1482d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AllParticipantsModel.class, new Deserializer());
                }

                public Object m2315a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AllParticipantsParser.m2714a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object allParticipantsModel = new AllParticipantsModel();
                    ((BaseModel) allParticipantsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (allParticipantsModel instanceof Postprocessable) {
                        return ((Postprocessable) allParticipantsModel).a();
                    }
                    return allParticipantsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<AllParticipantsModel> {
                public final void m2316a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AllParticipantsModel allParticipantsModel = (AllParticipantsModel) obj;
                    if (allParticipantsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(allParticipantsModel.m2317a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        allParticipantsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AllParticipantsParser.m2715a(allParticipantsModel.w_(), allParticipantsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AllParticipantsModel.class, new Serializer());
                }
            }

            public AllParticipantsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<MessagingActorInfoModel> m2319a() {
                this.f1482d = super.a(this.f1482d, 0, MessagingActorInfoModel.class);
                return (ImmutableList) this.f1482d;
            }

            public final int jK_() {
                return -700993630;
            }

            public final GraphQLVisitableModel m2318a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2319a() != null) {
                    Builder a = ModelHelper.a(m2319a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AllParticipantsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1482d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2317a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2319a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -451161022)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class CustomizationInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1485d;
            @Nullable
            private String f1486e;
            @Nullable
            private String f1487f;
            @Nullable
            private List<ParticipantCustomizationsModel> f1488g;
            @Nullable
            private String f1489h;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CustomizationInfoModel.class, new Deserializer());
                }

                public Object m2320a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CustomizationInfoParser.m2718a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object customizationInfoModel = new CustomizationInfoModel();
                    ((BaseModel) customizationInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (customizationInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) customizationInfoModel).a();
                    }
                    return customizationInfoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1012388394)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class ParticipantCustomizationsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1483d;
                @Nullable
                private String f1484e;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ParticipantCustomizationsModel.class, new Deserializer());
                    }

                    public Object m2321a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ParticipantCustomizationsParser.m2717b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object participantCustomizationsModel = new ParticipantCustomizationsModel();
                        ((BaseModel) participantCustomizationsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (participantCustomizationsModel instanceof Postprocessable) {
                            return ((Postprocessable) participantCustomizationsModel).a();
                        }
                        return participantCustomizationsModel;
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<ParticipantCustomizationsModel> {
                    public final void m2322a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ParticipantCustomizationsModel participantCustomizationsModel = (ParticipantCustomizationsModel) obj;
                        if (participantCustomizationsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(participantCustomizationsModel.m2323a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            participantCustomizationsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ParticipantCustomizationsParser.m2716a(participantCustomizationsModel.w_(), participantCustomizationsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ParticipantCustomizationsModel.class, new Serializer());
                    }
                }

                public ParticipantCustomizationsModel() {
                    super(2);
                }

                @Nullable
                public final String m2325a() {
                    this.f1483d = super.a(this.f1483d, 0);
                    return this.f1483d;
                }

                @Nullable
                public final String m2326j() {
                    this.f1484e = super.a(this.f1484e, 1);
                    return this.f1484e;
                }

                public final int jK_() {
                    return 1195654481;
                }

                public final GraphQLVisitableModel m2324a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2323a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2325a());
                    int b2 = flatBufferBuilder.b(m2326j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<CustomizationInfoModel> {
                public final void m2327a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CustomizationInfoModel customizationInfoModel = (CustomizationInfoModel) obj;
                    if (customizationInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(customizationInfoModel.m2328a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        customizationInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CustomizationInfoParser.m2719a(customizationInfoModel.w_(), customizationInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CustomizationInfoModel.class, new Serializer());
                }
            }

            public CustomizationInfoModel() {
                super(5);
            }

            @Nullable
            public final String m2330a() {
                this.f1485d = super.a(this.f1485d, 0);
                return this.f1485d;
            }

            @Nullable
            public final String m2331j() {
                this.f1486e = super.a(this.f1486e, 1);
                return this.f1486e;
            }

            @Nullable
            public final String m2332k() {
                this.f1487f = super.a(this.f1487f, 2);
                return this.f1487f;
            }

            @Nonnull
            public final ImmutableList<ParticipantCustomizationsModel> m2333l() {
                this.f1488g = super.a(this.f1488g, 3, ParticipantCustomizationsModel.class);
                return (ImmutableList) this.f1488g;
            }

            @Nullable
            public final String m2334m() {
                this.f1489h = super.a(this.f1489h, 4);
                return this.f1489h;
            }

            public final int jK_() {
                return -992957822;
            }

            public final GraphQLVisitableModel m2329a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2333l() != null) {
                    Builder a = ModelHelper.a(m2333l(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CustomizationInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1488g = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2328a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2330a());
                int b2 = flatBufferBuilder.b(m2331j());
                int b3 = flatBufferBuilder.b(m2332k());
                int a = ModelHelper.a(flatBufferBuilder, m2333l());
                int b4 = flatBufferBuilder.b(m2334m());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, a);
                flatBufferBuilder.b(4, b4);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 387574471)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class DeliveryReceiptsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ReceiptInfoModel> f1490d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DeliveryReceiptsModel.class, new Deserializer());
                }

                public Object m2335a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DeliveryReceiptsParser.m2720a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object deliveryReceiptsModel = new DeliveryReceiptsModel();
                    ((BaseModel) deliveryReceiptsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (deliveryReceiptsModel instanceof Postprocessable) {
                        return ((Postprocessable) deliveryReceiptsModel).a();
                    }
                    return deliveryReceiptsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<DeliveryReceiptsModel> {
                public final void m2336a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DeliveryReceiptsModel deliveryReceiptsModel = (DeliveryReceiptsModel) obj;
                    if (deliveryReceiptsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(deliveryReceiptsModel.m2337a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        deliveryReceiptsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DeliveryReceiptsParser.m2721a(deliveryReceiptsModel.w_(), deliveryReceiptsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DeliveryReceiptsModel.class, new Serializer());
                }
            }

            public DeliveryReceiptsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ReceiptInfoModel> m2339a() {
                this.f1490d = super.a(this.f1490d, 0, ReceiptInfoModel.class);
                return (ImmutableList) this.f1490d;
            }

            public final int jK_() {
                return -1667855822;
            }

            public final GraphQLVisitableModel m2338a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2339a() != null) {
                    Builder a = ModelHelper.a(m2339a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (DeliveryReceiptsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1490d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2337a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2339a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThreadInfoModel.class, new Deserializer());
            }

            public Object m2340a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ThreadInfoParser.m2744b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object threadInfoModel = new ThreadInfoModel();
                ((BaseModel) threadInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (threadInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) threadInfoModel).a();
                }
                return threadInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 854471674)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class FormerParticipantIdsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MessagingActorIdModel> f1491d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FormerParticipantIdsModel.class, new Deserializer());
                }

                public Object m2341a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FormerParticipantIdsParser.m2722a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object formerParticipantIdsModel = new FormerParticipantIdsModel();
                    ((BaseModel) formerParticipantIdsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (formerParticipantIdsModel instanceof Postprocessable) {
                        return ((Postprocessable) formerParticipantIdsModel).a();
                    }
                    return formerParticipantIdsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<FormerParticipantIdsModel> {
                public final void m2342a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FormerParticipantIdsModel formerParticipantIdsModel = (FormerParticipantIdsModel) obj;
                    if (formerParticipantIdsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(formerParticipantIdsModel.m2343a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        formerParticipantIdsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FormerParticipantIdsParser.m2723a(formerParticipantIdsModel.w_(), formerParticipantIdsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FormerParticipantIdsModel.class, new Serializer());
                }
            }

            public FormerParticipantIdsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<MessagingActorIdModel> m2345a() {
                this.f1491d = super.a(this.f1491d, 0, MessagingActorIdModel.class);
                return (ImmutableList) this.f1491d;
            }

            public final int jK_() {
                return 831093394;
            }

            public final GraphQLVisitableModel m2344a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2345a() != null) {
                    Builder a = ModelHelper.a(m2345a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FormerParticipantIdsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1491d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2343a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2345a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1842602993)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class FormerParticipantsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MessagingActorInfoModel> f1492d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FormerParticipantsModel.class, new Deserializer());
                }

                public Object m2346a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FormerParticipantsParser.m2724a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object formerParticipantsModel = new FormerParticipantsModel();
                    ((BaseModel) formerParticipantsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (formerParticipantsModel instanceof Postprocessable) {
                        return ((Postprocessable) formerParticipantsModel).a();
                    }
                    return formerParticipantsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<FormerParticipantsModel> {
                public final void m2347a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FormerParticipantsModel formerParticipantsModel = (FormerParticipantsModel) obj;
                    if (formerParticipantsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(formerParticipantsModel.m2348a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        formerParticipantsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FormerParticipantsParser.m2725a(formerParticipantsModel.w_(), formerParticipantsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FormerParticipantsModel.class, new Serializer());
                }
            }

            public FormerParticipantsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<MessagingActorInfoModel> m2350a() {
                this.f1492d = super.a(this.f1492d, 0, MessagingActorInfoModel.class);
                return (ImmutableList) this.f1492d;
            }

            public final int jK_() {
                return 831093394;
            }

            public final GraphQLVisitableModel m2349a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2350a() != null) {
                    Builder a = ModelHelper.a(m2350a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FormerParticipantsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1492d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2348a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2350a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1493d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                }

                public Object m2351a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThreadInfoParser.ImageParser.m2726a(jsonParser, flatBufferBuilder));
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

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<ImageModel> {
                public final void m2352a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageModel imageModel = (ImageModel) obj;
                    if (imageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageModel.m2353a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThreadInfoParser.ImageParser.m2727a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageModel.class, new Serializer());
                }
            }

            public ImageModel() {
                super(1);
            }

            @Nullable
            public final String m2355a() {
                this.f1493d = super.a(this.f1493d, 0);
                return this.f1493d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m2354a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2353a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2355a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 849826014)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class LastMessageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f1505d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LastMessageModel.class, new Deserializer());
                }

                public Object m2356a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LastMessageParser.m2732a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object lastMessageModel = new LastMessageModel();
                    ((BaseModel) lastMessageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (lastMessageModel instanceof Postprocessable) {
                        return ((Postprocessable) lastMessageModel).a();
                    }
                    return lastMessageModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 209849835)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f1495d;
                private boolean f1496e;
                private boolean f1497f;
                @Nullable
                private GraphQLMNCommerceMessageType f1498g;
                private boolean f1499h;
                @Nullable
                private MessageModel f1500i;
                @Nullable
                private ParticipantInfoModel f1501j;
                @Nullable
                private GraphQLPeerToPeerPaymentMessageType f1502k;
                @Nullable
                private GraphQLPageAdminReplyType f1503l;
                @Nullable
                private String f1504m;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m2357a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LastMessageParser.NodesParser.m2730b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: videoPathToWaterfallId */
                public final class MessageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f1494d;

                    /* compiled from: videoPathToWaterfallId */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(MessageModel.class, new Deserializer());
                        }

                        public Object m2358a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(LastMessageParser.NodesParser.MessageParser.m2728a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: videoPathToWaterfallId */
                    public class Serializer extends JsonSerializer<MessageModel> {
                        public final void m2359a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            MessageModel messageModel = (MessageModel) obj;
                            if (messageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(messageModel.m2360a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                messageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            LastMessageParser.NodesParser.MessageParser.m2729a(messageModel.w_(), messageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(MessageModel.class, new Serializer());
                        }
                    }

                    public MessageModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m2362a() {
                        this.f1494d = super.a(this.f1494d, 0);
                        return this.f1494d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m2361a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m2360a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m2362a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m2363a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m2364a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LastMessageParser.NodesParser.m2731b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(10);
                }

                @Nullable
                public final GraphQLObjectType m2365a() {
                    if (this.b != null && this.f1495d == null) {
                        this.f1495d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f1495d;
                }

                public final boolean m2368j() {
                    a(0, 1);
                    return this.f1496e;
                }

                public final boolean m2369k() {
                    a(0, 2);
                    return this.f1497f;
                }

                @Nullable
                public final GraphQLMNCommerceMessageType m2370l() {
                    this.f1498g = (GraphQLMNCommerceMessageType) super.b(this.f1498g, 3, GraphQLMNCommerceMessageType.class, GraphQLMNCommerceMessageType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f1498g;
                }

                public final boolean m2371m() {
                    a(0, 4);
                    return this.f1499h;
                }

                @Nullable
                public final MessageModel m2372n() {
                    this.f1500i = (MessageModel) super.a(this.f1500i, 5, MessageModel.class);
                    return this.f1500i;
                }

                @Nullable
                public final ParticipantInfoModel m2373o() {
                    this.f1501j = (ParticipantInfoModel) super.a(this.f1501j, 6, ParticipantInfoModel.class);
                    return this.f1501j;
                }

                @Nullable
                public final GraphQLPeerToPeerPaymentMessageType m2374p() {
                    this.f1502k = (GraphQLPeerToPeerPaymentMessageType) super.b(this.f1502k, 7, GraphQLPeerToPeerPaymentMessageType.class, GraphQLPeerToPeerPaymentMessageType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f1502k;
                }

                @Nullable
                public final GraphQLPageAdminReplyType m2375q() {
                    this.f1503l = (GraphQLPageAdminReplyType) super.b(this.f1503l, 8, GraphQLPageAdminReplyType.class, GraphQLPageAdminReplyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f1503l;
                }

                @Nullable
                public final String m2376r() {
                    this.f1504m = super.a(this.f1504m, 9);
                    return this.f1504m;
                }

                public final int jK_() {
                    return -1675388953;
                }

                public final GraphQLVisitableModel m2366a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2372n() != null) {
                        MessageModel messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m2372n());
                        if (m2372n() != messageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1500i = messageModel;
                        }
                    }
                    if (m2373o() != null) {
                        ParticipantInfoModel participantInfoModel = (ParticipantInfoModel) graphQLModelMutatingVisitor.b(m2373o());
                        if (m2373o() != participantInfoModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1501j = participantInfoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2364a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2365a());
                    int a2 = flatBufferBuilder.a(m2370l());
                    int a3 = ModelHelper.a(flatBufferBuilder, m2372n());
                    int a4 = ModelHelper.a(flatBufferBuilder, m2373o());
                    int a5 = flatBufferBuilder.a(m2374p());
                    int a6 = flatBufferBuilder.a(m2375q());
                    int b = flatBufferBuilder.b(m2376r());
                    flatBufferBuilder.c(10);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f1496e);
                    flatBufferBuilder.a(2, this.f1497f);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.a(4, this.f1499h);
                    flatBufferBuilder.b(5, a3);
                    flatBufferBuilder.b(6, a4);
                    flatBufferBuilder.b(7, a5);
                    flatBufferBuilder.b(8, a6);
                    flatBufferBuilder.b(9, b);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2367a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1496e = mutableFlatBuffer.a(i, 1);
                    this.f1497f = mutableFlatBuffer.a(i, 2);
                    this.f1499h = mutableFlatBuffer.a(i, 4);
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<LastMessageModel> {
                public final void m2377a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LastMessageModel lastMessageModel = (LastMessageModel) obj;
                    if (lastMessageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(lastMessageModel.m2378a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        lastMessageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LastMessageParser.m2733a(lastMessageModel.w_(), lastMessageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LastMessageModel.class, new Serializer());
                }
            }

            public LastMessageModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m2380a() {
                this.f1505d = super.a(this.f1505d, 0, NodesModel.class);
                return (ImmutableList) this.f1505d;
            }

            public final int jK_() {
                return 1801832203;
            }

            public final GraphQLVisitableModel m2379a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2380a() != null) {
                    Builder a = ModelHelper.a(m2380a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (LastMessageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1505d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2378a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2380a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 387574471)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class ReadReceiptsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ReceiptInfoModel> f1506d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReadReceiptsModel.class, new Deserializer());
                }

                public Object m2381a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReadReceiptsParser.m2734a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object readReceiptsModel = new ReadReceiptsModel();
                    ((BaseModel) readReceiptsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (readReceiptsModel instanceof Postprocessable) {
                        return ((Postprocessable) readReceiptsModel).a();
                    }
                    return readReceiptsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<ReadReceiptsModel> {
                public final void m2382a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReadReceiptsModel readReceiptsModel = (ReadReceiptsModel) obj;
                    if (readReceiptsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(readReceiptsModel.m2383a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        readReceiptsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReadReceiptsParser.m2735a(readReceiptsModel.w_(), readReceiptsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReadReceiptsModel.class, new Serializer());
                }
            }

            public ReadReceiptsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ReceiptInfoModel> m2385a() {
                this.f1506d = super.a(this.f1506d, 0, ReceiptInfoModel.class);
                return (ImmutableList) this.f1506d;
            }

            public final int jK_() {
                return 134660948;
            }

            public final GraphQLVisitableModel m2384a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2385a() != null) {
                    Builder a = ModelHelper.a(m2385a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ReadReceiptsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1506d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2383a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2385a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<ThreadInfoModel> {
            public final void m2386a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ThreadInfoModel threadInfoModel = (ThreadInfoModel) obj;
                if (threadInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(threadInfoModel.m2420a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    threadInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ThreadInfoParser.m2745b(threadInfoModel.w_(), threadInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ThreadInfoModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -884032628)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class ThreadGamesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1509d;
            @Nullable
            private HighScoreModel f1510e;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ThreadGamesModel.class, new Deserializer());
                }

                public Object m2387a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThreadGamesParser.m2738b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object threadGamesModel = new ThreadGamesModel();
                    ((BaseModel) threadGamesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (threadGamesModel instanceof Postprocessable) {
                        return ((Postprocessable) threadGamesModel).a();
                    }
                    return threadGamesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 927593547)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class HighScoreModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1507d;
                private int f1508e;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(HighScoreModel.class, new Deserializer());
                    }

                    public Object m2388a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(HighScoreParser.m2736a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object highScoreModel = new HighScoreModel();
                        ((BaseModel) highScoreModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (highScoreModel instanceof Postprocessable) {
                            return ((Postprocessable) highScoreModel).a();
                        }
                        return highScoreModel;
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<HighScoreModel> {
                    public final void m2389a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        HighScoreModel highScoreModel = (HighScoreModel) obj;
                        if (highScoreModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(highScoreModel.m2390a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            highScoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        HighScoreParser.m2737a(highScoreModel.w_(), highScoreModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(HighScoreModel.class, new Serializer());
                    }
                }

                public HighScoreModel() {
                    super(2);
                }

                @Nullable
                public final String m2392a() {
                    this.f1507d = super.a(this.f1507d, 0);
                    return this.f1507d;
                }

                public final int m2394j() {
                    a(0, 1);
                    return this.f1508e;
                }

                public final int jK_() {
                    return -1902425026;
                }

                public final GraphQLVisitableModel m2391a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2390a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2392a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f1508e, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2393a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1508e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<ThreadGamesModel> {
                public final void m2395a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ThreadGamesModel threadGamesModel = (ThreadGamesModel) obj;
                    if (threadGamesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(threadGamesModel.m2396a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        threadGamesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThreadGamesParser.m2739b(threadGamesModel.w_(), threadGamesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ThreadGamesModel.class, new Serializer());
                }
            }

            public ThreadGamesModel() {
                super(2);
            }

            @Nullable
            public final String m2398a() {
                this.f1509d = super.a(this.f1509d, 0);
                return this.f1509d;
            }

            @Nullable
            public final HighScoreModel m2399j() {
                this.f1510e = (HighScoreModel) super.a(this.f1510e, 1, HighScoreModel.class);
                return this.f1510e;
            }

            public final int jK_() {
                return -616006530;
            }

            public final GraphQLVisitableModel m2397a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2399j() != null) {
                    HighScoreModel highScoreModel = (HighScoreModel) graphQLModelMutatingVisitor.b(m2399j());
                    if (m2399j() != highScoreModel) {
                        graphQLVisitableModel = (ThreadGamesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1510e = highScoreModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2396a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2398a());
                int a = ModelHelper.a(flatBufferBuilder, m2399j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -955914545)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class ThreadKeyModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1511d;
            @Nullable
            private String f1512e;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ThreadKeyModel.class, new Deserializer());
                }

                public Object m2400a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThreadKeyParser.m2740a(jsonParser, flatBufferBuilder));
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

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<ThreadKeyModel> {
                public final void m2401a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ThreadKeyModel threadKeyModel = (ThreadKeyModel) obj;
                    if (threadKeyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(threadKeyModel.m2402a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        threadKeyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThreadKeyParser.m2741a(threadKeyModel.w_(), threadKeyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ThreadKeyModel.class, new Serializer());
                }
            }

            public ThreadKeyModel() {
                super(2);
            }

            @Nullable
            public final String m2404a() {
                this.f1511d = super.a(this.f1511d, 0);
                return this.f1511d;
            }

            @Nullable
            public final String m2405j() {
                this.f1512e = super.a(this.f1512e, 1);
                return this.f1512e;
            }

            public final int jK_() {
                return 898588622;
            }

            public final GraphQLVisitableModel m2403a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2402a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2404a());
                int b2 = flatBufferBuilder.b(m2405j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ThreadInfoModel() {
            super(31);
        }

        @Nullable
        public final ActiveBotsModel m2424j() {
            this.f1521d = (ActiveBotsModel) super.a(this.f1521d, 0, ActiveBotsModel.class);
            return this.f1521d;
        }

        @Nullable
        public final AllParticipantIdsModel m2425k() {
            this.f1522e = (AllParticipantIdsModel) super.a(this.f1522e, 1, AllParticipantIdsModel.class);
            return this.f1522e;
        }

        @Nullable
        public final AllParticipantsModel m2426l() {
            this.f1523f = (AllParticipantsModel) super.a(this.f1523f, 2, AllParticipantsModel.class);
            return this.f1523f;
        }

        public final boolean m2427m() {
            a(0, 3);
            return this.f1524g;
        }

        @Nullable
        public final GraphQLMessageThreadCannotReplyReason m2428n() {
            this.f1525h = (GraphQLMessageThreadCannotReplyReason) super.b(this.f1525h, 4, GraphQLMessageThreadCannotReplyReason.class, GraphQLMessageThreadCannotReplyReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1525h;
        }

        @Nullable
        public final CustomizationInfoModel m2429o() {
            this.f1526i = (CustomizationInfoModel) super.a(this.f1526i, 5, CustomizationInfoModel.class);
            return this.f1526i;
        }

        @Nullable
        public final DeliveryReceiptsModel m2430p() {
            this.f1527j = (DeliveryReceiptsModel) super.a(this.f1527j, 6, DeliveryReceiptsModel.class);
            return this.f1527j;
        }

        public final int m2431q() {
            a(0, 7);
            return this.f1528k;
        }

        @Nullable
        public final EventRemindersModel m2432r() {
            this.f1529l = (EventRemindersModel) super.a(this.f1529l, 8, EventRemindersModel.class);
            return this.f1529l;
        }

        @Nullable
        public final GraphQLMailboxFolder m2433s() {
            this.f1530m = (GraphQLMailboxFolder) super.b(this.f1530m, 9, GraphQLMailboxFolder.class, GraphQLMailboxFolder.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1530m;
        }

        @Nullable
        public final FormerParticipantIdsModel m2434t() {
            this.f1531n = (FormerParticipantIdsModel) super.a(this.f1531n, 10, FormerParticipantIdsModel.class);
            return this.f1531n;
        }

        @Nullable
        public final FormerParticipantsModel m2435u() {
            this.f1532o = (FormerParticipantsModel) super.a(this.f1532o, 11, FormerParticipantsModel.class);
            return this.f1532o;
        }

        public final double m2436v() {
            a(1, 4);
            return this.f1533p;
        }

        public final boolean m2437w() {
            a(1, 5);
            return this.f1534q;
        }

        @Nullable
        public final String m2438x() {
            this.f1535r = super.a(this.f1535r, 14);
            return this.f1535r;
        }

        @Nullable
        public final ImageModel m2439y() {
            this.f1536s = (ImageModel) super.a(this.f1536s, 15, ImageModel.class);
            return this.f1536s;
        }

        public final boolean m2440z() {
            a(2, 0);
            return this.f1537t;
        }

        public final boolean m2406A() {
            a(2, 1);
            return this.f1538u;
        }

        @Nullable
        public final LastMessageModel m2407B() {
            this.f1539v = (LastMessageModel) super.a(this.f1539v, 18, LastMessageModel.class);
            return this.f1539v;
        }

        @Nullable
        public final MessagesModel m2408C() {
            this.f1540w = (MessagesModel) super.a(this.f1540w, 19, MessagesModel.class);
            return this.f1540w;
        }

        public final int m2409D() {
            a(2, 4);
            return this.f1541x;
        }

        public final int m2410E() {
            a(2, 5);
            return this.f1542y;
        }

        @Nullable
        public final String m2411F() {
            this.f1543z = super.a(this.f1543z, 22);
            return this.f1543z;
        }

        @Nullable
        public final ReadReceiptsModel m2412G() {
            this.f1513A = (ReadReceiptsModel) super.a(this.f1513A, 23, ReadReceiptsModel.class);
            return this.f1513A;
        }

        @Nullable
        public final RtcCallDataInfoModel m2413H() {
            this.f1514B = (RtcCallDataInfoModel) super.a(this.f1514B, 24, RtcCallDataInfoModel.class);
            return this.f1514B;
        }

        @Nonnull
        public final ImmutableList<ThreadGamesModel> m2414I() {
            this.f1515C = super.a(this.f1515C, 25, ThreadGamesModel.class);
            return (ImmutableList) this.f1515C;
        }

        @Nullable
        public final ThreadKeyModel m2415J() {
            this.f1516D = (ThreadKeyModel) super.a(this.f1516D, 26, ThreadKeyModel.class);
            return this.f1516D;
        }

        public final boolean m2416K() {
            a(3, 3);
            return this.f1517E;
        }

        @Nullable
        public final ThreadQueueInfoModel m2417L() {
            this.f1518F = (ThreadQueueInfoModel) super.a(this.f1518F, 28, ThreadQueueInfoModel.class);
            return this.f1518F;
        }

        public final int m2418M() {
            a(3, 5);
            return this.f1519G;
        }

        @Nullable
        public final String m2419N() {
            this.f1520H = super.a(this.f1520H, 30);
            return this.f1520H;
        }

        @Nullable
        public final String m2422a() {
            return m2438x();
        }

        public final int jK_() {
            return -740570927;
        }

        public final GraphQLVisitableModel m2421a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2424j() != null) {
                ActiveBotsModel activeBotsModel = (ActiveBotsModel) graphQLModelMutatingVisitor.b(m2424j());
                if (m2424j() != activeBotsModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1521d = activeBotsModel;
                }
            }
            if (m2425k() != null) {
                AllParticipantIdsModel allParticipantIdsModel = (AllParticipantIdsModel) graphQLModelMutatingVisitor.b(m2425k());
                if (m2425k() != allParticipantIdsModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1522e = allParticipantIdsModel;
                }
            }
            if (m2426l() != null) {
                AllParticipantsModel allParticipantsModel = (AllParticipantsModel) graphQLModelMutatingVisitor.b(m2426l());
                if (m2426l() != allParticipantsModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1523f = allParticipantsModel;
                }
            }
            if (m2429o() != null) {
                CustomizationInfoModel customizationInfoModel = (CustomizationInfoModel) graphQLModelMutatingVisitor.b(m2429o());
                if (m2429o() != customizationInfoModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1526i = customizationInfoModel;
                }
            }
            if (m2430p() != null) {
                DeliveryReceiptsModel deliveryReceiptsModel = (DeliveryReceiptsModel) graphQLModelMutatingVisitor.b(m2430p());
                if (m2430p() != deliveryReceiptsModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1527j = deliveryReceiptsModel;
                }
            }
            if (m2432r() != null) {
                EventRemindersModel eventRemindersModel = (EventRemindersModel) graphQLModelMutatingVisitor.b(m2432r());
                if (m2432r() != eventRemindersModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1529l = eventRemindersModel;
                }
            }
            if (m2434t() != null) {
                FormerParticipantIdsModel formerParticipantIdsModel = (FormerParticipantIdsModel) graphQLModelMutatingVisitor.b(m2434t());
                if (m2434t() != formerParticipantIdsModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1531n = formerParticipantIdsModel;
                }
            }
            if (m2435u() != null) {
                FormerParticipantsModel formerParticipantsModel = (FormerParticipantsModel) graphQLModelMutatingVisitor.b(m2435u());
                if (m2435u() != formerParticipantsModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1532o = formerParticipantsModel;
                }
            }
            if (m2439y() != null) {
                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m2439y());
                if (m2439y() != imageModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1536s = imageModel;
                }
            }
            if (m2407B() != null) {
                LastMessageModel lastMessageModel = (LastMessageModel) graphQLModelMutatingVisitor.b(m2407B());
                if (m2407B() != lastMessageModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1539v = lastMessageModel;
                }
            }
            if (m2408C() != null) {
                MessagesModel messagesModel = (MessagesModel) graphQLModelMutatingVisitor.b(m2408C());
                if (m2408C() != messagesModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1540w = messagesModel;
                }
            }
            if (m2412G() != null) {
                ReadReceiptsModel readReceiptsModel = (ReadReceiptsModel) graphQLModelMutatingVisitor.b(m2412G());
                if (m2412G() != readReceiptsModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1513A = readReceiptsModel;
                }
            }
            if (m2413H() != null) {
                RtcCallDataInfoModel rtcCallDataInfoModel = (RtcCallDataInfoModel) graphQLModelMutatingVisitor.b(m2413H());
                if (m2413H() != rtcCallDataInfoModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1514B = rtcCallDataInfoModel;
                }
            }
            if (m2414I() != null) {
                Builder a = ModelHelper.a(m2414I(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ThreadInfoModel threadInfoModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    threadInfoModel.f1515C = a.b();
                    graphQLVisitableModel = threadInfoModel;
                }
            }
            if (m2415J() != null) {
                ThreadKeyModel threadKeyModel = (ThreadKeyModel) graphQLModelMutatingVisitor.b(m2415J());
                if (m2415J() != threadKeyModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1516D = threadKeyModel;
                }
            }
            if (m2417L() != null) {
                ThreadQueueInfoModel threadQueueInfoModel = (ThreadQueueInfoModel) graphQLModelMutatingVisitor.b(m2417L());
                if (m2417L() != threadQueueInfoModel) {
                    graphQLVisitableModel = (ThreadInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1518F = threadQueueInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2420a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2424j());
            int a2 = ModelHelper.a(flatBufferBuilder, m2425k());
            int a3 = ModelHelper.a(flatBufferBuilder, m2426l());
            int a4 = flatBufferBuilder.a(m2428n());
            int a5 = ModelHelper.a(flatBufferBuilder, m2429o());
            int a6 = ModelHelper.a(flatBufferBuilder, m2430p());
            int a7 = ModelHelper.a(flatBufferBuilder, m2432r());
            int a8 = flatBufferBuilder.a(m2433s());
            int a9 = ModelHelper.a(flatBufferBuilder, m2434t());
            int a10 = ModelHelper.a(flatBufferBuilder, m2435u());
            int b = flatBufferBuilder.b(m2438x());
            int a11 = ModelHelper.a(flatBufferBuilder, m2439y());
            int a12 = ModelHelper.a(flatBufferBuilder, m2407B());
            int a13 = ModelHelper.a(flatBufferBuilder, m2408C());
            int b2 = flatBufferBuilder.b(m2411F());
            int a14 = ModelHelper.a(flatBufferBuilder, m2412G());
            int a15 = ModelHelper.a(flatBufferBuilder, m2413H());
            int a16 = ModelHelper.a(flatBufferBuilder, m2414I());
            int a17 = ModelHelper.a(flatBufferBuilder, m2415J());
            int a18 = ModelHelper.a(flatBufferBuilder, m2417L());
            int b3 = flatBufferBuilder.b(m2419N());
            flatBufferBuilder.c(31);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.a(3, this.f1524g);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.a(7, this.f1528k, 0);
            flatBufferBuilder.b(8, a7);
            flatBufferBuilder.b(9, a8);
            flatBufferBuilder.b(10, a9);
            flatBufferBuilder.b(11, a10);
            flatBufferBuilder.a(12, this.f1533p, 0.0d);
            flatBufferBuilder.a(13, this.f1534q);
            flatBufferBuilder.b(14, b);
            flatBufferBuilder.b(15, a11);
            flatBufferBuilder.a(16, this.f1537t);
            flatBufferBuilder.a(17, this.f1538u);
            flatBufferBuilder.b(18, a12);
            flatBufferBuilder.b(19, a13);
            flatBufferBuilder.a(20, this.f1541x, 0);
            flatBufferBuilder.a(21, this.f1542y, 0);
            flatBufferBuilder.b(22, b2);
            flatBufferBuilder.b(23, a14);
            flatBufferBuilder.b(24, a15);
            flatBufferBuilder.b(25, a16);
            flatBufferBuilder.b(26, a17);
            flatBufferBuilder.a(27, this.f1517E);
            flatBufferBuilder.b(28, a18);
            flatBufferBuilder.a(29, this.f1519G, 0);
            flatBufferBuilder.b(30, b3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2423a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1524g = mutableFlatBuffer.a(i, 3);
            this.f1528k = mutableFlatBuffer.a(i, 7, 0);
            this.f1533p = mutableFlatBuffer.a(i, 12, 0.0d);
            this.f1534q = mutableFlatBuffer.a(i, 13);
            this.f1537t = mutableFlatBuffer.a(i, 16);
            this.f1538u = mutableFlatBuffer.a(i, 17);
            this.f1541x = mutableFlatBuffer.a(i, 20, 0);
            this.f1542y = mutableFlatBuffer.a(i, 21, 0);
            this.f1517E = mutableFlatBuffer.a(i, 27);
            this.f1519G = mutableFlatBuffer.a(i, 29, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2039945660)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class ThreadListQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessageThreadsModel f1552d;

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThreadListQueryModel.class, new Deserializer());
            }

            public Object m2441a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ThreadListQueryParser.m2750a(jsonParser);
                Object threadListQueryModel = new ThreadListQueryModel();
                ((BaseModel) threadListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (threadListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) threadListQueryModel).a();
                }
                return threadListQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1185490882)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class MessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
            private int f1545d;
            private int f1546e;
            @Nullable
            private List<ThreadInfoModel> f1547f;
            @Nullable
            private PageInfoModel f1548g;
            @Nullable
            private String f1549h;
            private int f1550i;
            private int f1551j;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageThreadsModel.class, new Deserializer());
                }

                public Object m2442a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThreadListQueryParser.MessageThreadsParser.m2748a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messageThreadsModel = new MessageThreadsModel();
                    ((BaseModel) messageThreadsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messageThreadsModel instanceof Postprocessable) {
                        return ((Postprocessable) messageThreadsModel).a();
                    }
                    return messageThreadsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1947362733)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f1544d;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m2443a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ThreadListQueryParser.MessageThreadsParser.PageInfoParser.m2746a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m2444a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m2445a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ThreadListQueryParser.MessageThreadsParser.PageInfoParser.m2747a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(1);
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m2446a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2445a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f1544d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2447a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1544d = mutableFlatBuffer.a(i, 0);
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<MessageThreadsModel> {
                public final void m2448a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageThreadsModel messageThreadsModel = (MessageThreadsModel) obj;
                    if (messageThreadsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageThreadsModel.m2450a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThreadListQueryParser.MessageThreadsParser.m2749a(messageThreadsModel.w_(), messageThreadsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessageThreadsModel.class, new Serializer());
                }
            }

            public MessageThreadsModel() {
                super(7);
            }

            public final int m2449a() {
                a(0, 1);
                return this.f1546e;
            }

            @Nonnull
            public final ImmutableList<ThreadInfoModel> m2453j() {
                this.f1547f = super.a(this.f1547f, 2, ThreadInfoModel.class);
                return (ImmutableList) this.f1547f;
            }

            @Nullable
            public final PageInfoModel m2454k() {
                this.f1548g = (PageInfoModel) super.a(this.f1548g, 3, PageInfoModel.class);
                return this.f1548g;
            }

            @Nullable
            public final String m2455l() {
                this.f1549h = super.a(this.f1549h, 4);
                return this.f1549h;
            }

            public final int m2456m() {
                a(0, 5);
                return this.f1550i;
            }

            public final int m2457n() {
                a(0, 6);
                return this.f1551j;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m2451a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m2453j() != null) {
                    Builder a = ModelHelper.a(m2453j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        MessageThreadsModel messageThreadsModel = (MessageThreadsModel) ModelHelper.a(null, this);
                        messageThreadsModel.f1547f = a.b();
                        graphQLVisitableModel = messageThreadsModel;
                        if (m2454k() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m2454k());
                            if (m2454k() != pageInfoModel) {
                                graphQLVisitableModel = (MessageThreadsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f1548g = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m2454k() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m2454k());
                    if (m2454k() != pageInfoModel) {
                        graphQLVisitableModel = (MessageThreadsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1548g = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m2450a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2453j());
                int a2 = ModelHelper.a(flatBufferBuilder, m2454k());
                int b = flatBufferBuilder.b(m2455l());
                flatBufferBuilder.c(7);
                flatBufferBuilder.a(0, this.f1545d, 0);
                flatBufferBuilder.a(1, this.f1546e, 0);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, b);
                flatBufferBuilder.a(5, this.f1550i, 0);
                flatBufferBuilder.a(6, this.f1551j, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2452a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1545d = mutableFlatBuffer.a(i, 0, 0);
                this.f1546e = mutableFlatBuffer.a(i, 1, 0);
                this.f1550i = mutableFlatBuffer.a(i, 5, 0);
                this.f1551j = mutableFlatBuffer.a(i, 6, 0);
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<ThreadListQueryModel> {
            public final void m2458a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ThreadListQueryModel threadListQueryModel = (ThreadListQueryModel) obj;
                if (threadListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(threadListQueryModel.m2459a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    threadListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = threadListQueryModel.w_();
                int u_ = threadListQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("message_threads");
                    ThreadListQueryParser.MessageThreadsParser.m2749a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ThreadListQueryModel.class, new Serializer());
            }
        }

        public ThreadListQueryModel() {
            super(1);
        }

        @Nullable
        public final MessageThreadsModel m2461a() {
            this.f1552d = (MessageThreadsModel) super.a(this.f1552d, 0, MessageThreadsModel.class);
            return this.f1552d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m2460a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2461a() != null) {
                MessageThreadsModel messageThreadsModel = (MessageThreadsModel) graphQLModelMutatingVisitor.b(m2461a());
                if (m2461a() != messageThreadsModel) {
                    graphQLVisitableModel = (ThreadListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1552d = messageThreadsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2459a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2461a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 980302173)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class ThreadQueueInfoModel extends BaseModel implements GraphQLVisitableModel {
        private int f1559d;
        @Nullable
        private ApprovalRequestsModel f1560e;
        @Nullable
        private JoinableModeInfoModel f1561f;
        @Nullable
        private List<ThreadAdminsModel> f1562g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1608316023)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class ApprovalRequestsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f1556d;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ApprovalRequestsModel.class, new Deserializer());
                }

                public Object m2462a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ApprovalRequestsParser.m2755a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object approvalRequestsModel = new ApprovalRequestsModel();
                    ((BaseModel) approvalRequestsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (approvalRequestsModel instanceof Postprocessable) {
                        return ((Postprocessable) approvalRequestsModel).a();
                    }
                    return approvalRequestsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1748417740)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f1554d;
                private long f1555e;

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m2463a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ApprovalRequestsParser.EdgesParser.m2753b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 1801334754)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: videoPathToWaterfallId */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f1553d;

                    /* compiled from: videoPathToWaterfallId */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m2464a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ApprovalRequestsParser.EdgesParser.NodeParser.m2751a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: videoPathToWaterfallId */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m2465a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m2466a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ApprovalRequestsParser.EdgesParser.NodeParser.m2752a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(1);
                    }

                    public final void m2469a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m2470a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final String m2471j() {
                        this.f1553d = super.a(this.f1553d, 0);
                        return this.f1553d;
                    }

                    @Nullable
                    public final String m2468a() {
                        return m2471j();
                    }

                    public final int jK_() {
                        return 2645995;
                    }

                    public final GraphQLVisitableModel m2467a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m2466a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m2471j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m2472a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m2473a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ApprovalRequestsParser.EdgesParser.m2754b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(2);
                }

                @Nullable
                public final NodeModel m2475a() {
                    this.f1554d = (NodeModel) super.a(this.f1554d, 0, NodeModel.class);
                    return this.f1554d;
                }

                public final long m2477j() {
                    a(0, 1);
                    return this.f1555e;
                }

                public final int jK_() {
                    return 1518846213;
                }

                public final GraphQLVisitableModel m2474a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2475a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m2475a());
                        if (m2475a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1554d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2473a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2475a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f1555e, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2476a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1555e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<ApprovalRequestsModel> {
                public final void m2478a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ApprovalRequestsModel approvalRequestsModel = (ApprovalRequestsModel) obj;
                    if (approvalRequestsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(approvalRequestsModel.m2479a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        approvalRequestsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ApprovalRequestsParser.m2756a(approvalRequestsModel.w_(), approvalRequestsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ApprovalRequestsModel.class, new Serializer());
                }
            }

            public ApprovalRequestsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m2481a() {
                this.f1556d = super.a(this.f1556d, 0, EdgesModel.class);
                return (ImmutableList) this.f1556d;
            }

            public final int jK_() {
                return -1877787610;
            }

            public final GraphQLVisitableModel m2480a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2481a() != null) {
                    Builder a = ModelHelper.a(m2481a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ApprovalRequestsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1556d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2479a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2481a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThreadQueueInfoModel.class, new Deserializer());
            }

            public Object m2482a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ThreadQueueInfoParser.m2760a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object threadQueueInfoModel = new ThreadQueueInfoModel();
                ((BaseModel) threadQueueInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (threadQueueInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) threadQueueInfoModel).a();
                }
                return threadQueueInfoModel;
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<ThreadQueueInfoModel> {
            public final void m2483a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ThreadQueueInfoModel threadQueueInfoModel = (ThreadQueueInfoModel) obj;
                if (threadQueueInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(threadQueueInfoModel.m2494a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    threadQueueInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ThreadQueueInfoParser.m2761a(threadQueueInfoModel.w_(), threadQueueInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ThreadQueueInfoModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class ThreadAdminsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f1557d;
            @Nullable
            private String f1558e;

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ThreadAdminsModel.class, new Deserializer());
                }

                public Object m2484a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThreadAdminsParser.m2759b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object threadAdminsModel = new ThreadAdminsModel();
                    ((BaseModel) threadAdminsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (threadAdminsModel instanceof Postprocessable) {
                        return ((Postprocessable) threadAdminsModel).a();
                    }
                    return threadAdminsModel;
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<ThreadAdminsModel> {
                public final void m2485a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ThreadAdminsModel threadAdminsModel = (ThreadAdminsModel) obj;
                    if (threadAdminsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(threadAdminsModel.m2487a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        threadAdminsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThreadAdminsParser.m2758a(threadAdminsModel.w_(), threadAdminsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ThreadAdminsModel.class, new Serializer());
                }
            }

            public ThreadAdminsModel() {
                super(2);
            }

            public final void m2490a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m2491a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m2486k() {
                if (this.b != null && this.f1557d == null) {
                    this.f1557d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1557d;
            }

            @Nullable
            public final String m2492j() {
                this.f1558e = super.a(this.f1558e, 1);
                return this.f1558e;
            }

            @Nullable
            public final String m2489a() {
                return m2492j();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m2488a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2487a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2486k());
                int b = flatBufferBuilder.b(m2492j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ThreadQueueInfoModel() {
            super(4);
        }

        public final int m2493a() {
            a(0, 0);
            return this.f1559d;
        }

        @Nullable
        public final ApprovalRequestsModel m2497j() {
            this.f1560e = (ApprovalRequestsModel) super.a(this.f1560e, 1, ApprovalRequestsModel.class);
            return this.f1560e;
        }

        @Nullable
        public final JoinableModeInfoModel m2498k() {
            this.f1561f = (JoinableModeInfoModel) super.a(this.f1561f, 2, JoinableModeInfoModel.class);
            return this.f1561f;
        }

        @Nonnull
        public final ImmutableList<ThreadAdminsModel> m2499l() {
            this.f1562g = super.a(this.f1562g, 3, ThreadAdminsModel.class);
            return (ImmutableList) this.f1562g;
        }

        public final int jK_() {
            return -546639062;
        }

        public final GraphQLVisitableModel m2495a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2497j() != null) {
                ApprovalRequestsModel approvalRequestsModel = (ApprovalRequestsModel) graphQLModelMutatingVisitor.b(m2497j());
                if (m2497j() != approvalRequestsModel) {
                    graphQLVisitableModel = (ThreadQueueInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1560e = approvalRequestsModel;
                }
            }
            if (m2498k() != null) {
                JoinableModeInfoModel joinableModeInfoModel = (JoinableModeInfoModel) graphQLModelMutatingVisitor.b(m2498k());
                if (m2498k() != joinableModeInfoModel) {
                    graphQLVisitableModel = (ThreadQueueInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1561f = joinableModeInfoModel;
                }
            }
            if (m2499l() != null) {
                Builder a = ModelHelper.a(m2499l(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ThreadQueueInfoModel threadQueueInfoModel = (ThreadQueueInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    threadQueueInfoModel.f1562g = a.b();
                    graphQLVisitableModel = threadQueueInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2494a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2497j());
            int a2 = ModelHelper.a(flatBufferBuilder, m2498k());
            int a3 = ModelHelper.a(flatBufferBuilder, m2499l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f1559d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2496a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1559d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2077473518)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class XMAAttachmentMediaModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f1574d;
        private int f1575e;
        @Nullable
        private DefaultImageFieldsModel f1576f;
        @Nullable
        private DefaultImageFieldsModel f1577g;
        @Nullable
        private DefaultImageFieldsModel f1578h;
        private boolean f1579i;
        private boolean f1580j;
        private int f1581k;
        private int f1582l;
        @Nullable
        private String f1583m;
        private int f1584n;

        /* compiled from: videoPathToWaterfallId */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f1563a;
            public int f1564b;
            @Nullable
            public DefaultImageFieldsModel f1565c;
            @Nullable
            public DefaultImageFieldsModel f1566d;
            @Nullable
            public DefaultImageFieldsModel f1567e;
            public boolean f1568f;
            public boolean f1569g;
            public int f1570h;
            public int f1571i;
            @Nullable
            public String f1572j;
            public int f1573k;
        }

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(XMAAttachmentMediaModel.class, new Deserializer());
            }

            public Object m2500a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(XMAAttachmentMediaParser.m2762a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object xMAAttachmentMediaModel = new XMAAttachmentMediaModel();
                ((BaseModel) xMAAttachmentMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (xMAAttachmentMediaModel instanceof Postprocessable) {
                    return ((Postprocessable) xMAAttachmentMediaModel).a();
                }
                return xMAAttachmentMediaModel;
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<XMAAttachmentMediaModel> {
            public final void m2501a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                XMAAttachmentMediaModel xMAAttachmentMediaModel = (XMAAttachmentMediaModel) obj;
                if (xMAAttachmentMediaModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(xMAAttachmentMediaModel.m2504a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    xMAAttachmentMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                XMAAttachmentMediaParser.m2763a(xMAAttachmentMediaModel.w_(), xMAAttachmentMediaModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(XMAAttachmentMediaModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields aM_() {
            return m2516n();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m2509c() {
            return m2515m();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m2510d() {
            return m2503o();
        }

        public XMAAttachmentMediaModel() {
            super(11);
        }

        public XMAAttachmentMediaModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType m2505a() {
            if (this.b != null && this.f1574d == null) {
                this.f1574d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1574d;
        }

        public final int m2508b() {
            a(0, 1);
            return this.f1575e;
        }

        @Nullable
        public final DefaultImageFieldsModel m2515m() {
            this.f1576f = (DefaultImageFieldsModel) super.a(this.f1576f, 2, DefaultImageFieldsModel.class);
            return this.f1576f;
        }

        @Nullable
        private DefaultImageFieldsModel m2503o() {
            this.f1577g = (DefaultImageFieldsModel) super.a(this.f1577g, 3, DefaultImageFieldsModel.class);
            return this.f1577g;
        }

        @Nullable
        public final DefaultImageFieldsModel m2516n() {
            this.f1578h = (DefaultImageFieldsModel) super.a(this.f1578h, 4, DefaultImageFieldsModel.class);
            return this.f1578h;
        }

        public final boolean m2511g() {
            a(0, 5);
            return this.f1579i;
        }

        public final boolean aK_() {
            a(0, 6);
            return this.f1580j;
        }

        public final int aL_() {
            a(0, 7);
            return this.f1581k;
        }

        public final int m2512j() {
            a(1, 0);
            return this.f1582l;
        }

        @Nullable
        public final String m2513k() {
            this.f1583m = super.a(this.f1583m, 9);
            return this.f1583m;
        }

        public final int m2514l() {
            a(1, 2);
            return this.f1584n;
        }

        public static XMAAttachmentMediaModel m2502a(XMAAttachmentMediaModel xMAAttachmentMediaModel) {
            if (xMAAttachmentMediaModel == null) {
                return null;
            }
            if (xMAAttachmentMediaModel instanceof XMAAttachmentMediaModel) {
                return xMAAttachmentMediaModel;
            }
            Builder builder = new Builder();
            builder.f1563a = xMAAttachmentMediaModel.m2505a();
            builder.f1564b = xMAAttachmentMediaModel.m2508b();
            builder.f1565c = DefaultImageFieldsModel.a(xMAAttachmentMediaModel.m2509c());
            builder.f1566d = DefaultImageFieldsModel.a(xMAAttachmentMediaModel.m2510d());
            builder.f1567e = DefaultImageFieldsModel.a(xMAAttachmentMediaModel.aM_());
            builder.f1568f = xMAAttachmentMediaModel.m2511g();
            builder.f1569g = xMAAttachmentMediaModel.aK_();
            builder.f1570h = xMAAttachmentMediaModel.aL_();
            builder.f1571i = xMAAttachmentMediaModel.m2512j();
            builder.f1572j = xMAAttachmentMediaModel.m2513k();
            builder.f1573k = xMAAttachmentMediaModel.m2514l();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f1563a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f1565c);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f1566d);
            int a4 = ModelHelper.a(flatBufferBuilder, builder.f1567e);
            int b = flatBufferBuilder.b(builder.f1572j);
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, builder.f1564b, 0);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.a(5, builder.f1568f);
            flatBufferBuilder.a(6, builder.f1569g);
            flatBufferBuilder.a(7, builder.f1570h, 0);
            flatBufferBuilder.a(8, builder.f1571i, 0);
            flatBufferBuilder.b(9, b);
            flatBufferBuilder.a(10, builder.f1573k, 0);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new XMAAttachmentMediaModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m2506a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2515m() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m2515m());
                if (m2515m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (XMAAttachmentMediaModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1576f = defaultImageFieldsModel;
                }
            }
            if (m2503o() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m2503o());
                if (m2503o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (XMAAttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1577g = defaultImageFieldsModel;
                }
            }
            if (m2516n() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m2516n());
                if (m2516n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (XMAAttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1578h = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2504a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2505a());
            int a2 = ModelHelper.a(flatBufferBuilder, m2515m());
            int a3 = ModelHelper.a(flatBufferBuilder, m2503o());
            int a4 = ModelHelper.a(flatBufferBuilder, m2516n());
            int b = flatBufferBuilder.b(m2513k());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f1575e, 0);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.a(5, this.f1579i);
            flatBufferBuilder.a(6, this.f1580j);
            flatBufferBuilder.a(7, this.f1581k, 0);
            flatBufferBuilder.a(8, this.f1582l, 0);
            flatBufferBuilder.b(9, b);
            flatBufferBuilder.a(10, this.f1584n, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2507a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1575e = mutableFlatBuffer.a(i, 1, 0);
            this.f1579i = mutableFlatBuffer.a(i, 5);
            this.f1580j = mutableFlatBuffer.a(i, 6);
            this.f1581k = mutableFlatBuffer.a(i, 7, 0);
            this.f1582l = mutableFlatBuffer.a(i, 8, 0);
            this.f1584n = mutableFlatBuffer.a(i, 10, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -136496321)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class XMAAttachmentStoryFieldsModel extends BaseModel implements GraphQLVisitableModel, CommonStoryAttachmentFields {
        @Nullable
        private List<ActionLinksModel> f1634d;
        @Nullable
        private List<AttachmentPropertiesModel> f1635e;
        @Nullable
        private String f1636f;
        @Nullable
        private DescriptionModel f1637g;
        @Nullable
        private XMAAttachmentMediaModel f1638h;
        @Nullable
        private SourceModel f1639i;
        @Nullable
        private List<GraphQLStoryAttachmentStyle> f1640j;
        @Nullable
        private List<SubattachmentsModel> f1641k;
        @Nullable
        private String f1642l;
        @Nullable
        private StoryAttachmentTargetFragmentModel f1643m;
        @Nullable
        private String f1644n;
        @Nullable
        private String f1645o;
        @Nullable
        private String f1646p;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1134676274)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class ActionLinksModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f1588d;
            @Nullable
            private String f1589e;
            @Nullable
            private String f1590f;

            /* compiled from: videoPathToWaterfallId */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f1585a;
                @Nullable
                public String f1586b;
                @Nullable
                public String f1587c;
            }

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActionLinksModel.class, new Deserializer());
                }

                public Object m2517a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActionLinksParser.m2765b(jsonParser, flatBufferBuilder));
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

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<ActionLinksModel> {
                public final void m2518a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActionLinksModel actionLinksModel = (ActionLinksModel) obj;
                    if (actionLinksModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actionLinksModel.m2520a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actionLinksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActionLinksParser.m2764a(actionLinksModel.w_(), actionLinksModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ActionLinksModel.class, new Serializer());
                }
            }

            public ActionLinksModel() {
                super(3);
            }

            public ActionLinksModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final GraphQLObjectType m2521a() {
                if (this.b != null && this.f1588d == null) {
                    this.f1588d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1588d;
            }

            @Nullable
            public final String m2523b() {
                this.f1589e = super.a(this.f1589e, 1);
                return this.f1589e;
            }

            @Nullable
            public final String m2524c() {
                this.f1590f = super.a(this.f1590f, 2);
                return this.f1590f;
            }

            public static ActionLinksModel m2519a(ActionLinksModel actionLinksModel) {
                if (actionLinksModel == null) {
                    return null;
                }
                if (actionLinksModel instanceof ActionLinksModel) {
                    return actionLinksModel;
                }
                Builder builder = new Builder();
                builder.f1585a = actionLinksModel.m2521a();
                builder.f1586b = actionLinksModel.m2523b();
                builder.f1587c = actionLinksModel.m2524c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f1585a);
                int b = flatBufferBuilder.b(builder.f1586b);
                int b2 = flatBufferBuilder.b(builder.f1587c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ActionLinksModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1747569147;
            }

            public final GraphQLVisitableModel m2522a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2520a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2521a());
                int b = flatBufferBuilder.b(m2523b());
                int b2 = flatBufferBuilder.b(m2524c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 924256145)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class AttachmentPropertiesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1597d;
            @Nullable
            private String f1598e;
            @Nullable
            private String f1599f;
            @Nullable
            private ValueModel f1600g;

            /* compiled from: videoPathToWaterfallId */
            public final class Builder {
                @Nullable
                public String f1591a;
                @Nullable
                public String f1592b;
                @Nullable
                public String f1593c;
                @Nullable
                public ValueModel f1594d;

                public final AttachmentPropertiesModel m2525a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f1591a);
                    int b2 = flatBufferBuilder.b(this.f1592b);
                    int b3 = flatBufferBuilder.b(this.f1593c);
                    int a = ModelHelper.a(flatBufferBuilder, this.f1594d);
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, b3);
                    flatBufferBuilder.b(3, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new AttachmentPropertiesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttachmentPropertiesModel.class, new Deserializer());
                }

                public Object m2526a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttachmentPropertiesParser.m2769b(jsonParser, flatBufferBuilder));
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

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<AttachmentPropertiesModel> {
                public final void m2527a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttachmentPropertiesModel attachmentPropertiesModel = (AttachmentPropertiesModel) obj;
                    if (attachmentPropertiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attachmentPropertiesModel.m2537a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attachmentPropertiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttachmentPropertiesParser.m2770b(attachmentPropertiesModel.w_(), attachmentPropertiesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttachmentPropertiesModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class ValueModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1596d;

                /* compiled from: videoPathToWaterfallId */
                public final class Builder {
                    @Nullable
                    public String f1595a;

                    public final ValueModel m2528a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(this.f1595a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new ValueModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ValueModel.class, new Deserializer());
                    }

                    public Object m2529a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ValueParser.m2766a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object valueModel = new ValueModel();
                        ((BaseModel) valueModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (valueModel instanceof Postprocessable) {
                            return ((Postprocessable) valueModel).a();
                        }
                        return valueModel;
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<ValueModel> {
                    public final void m2530a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ValueModel valueModel = (ValueModel) obj;
                        if (valueModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(valueModel.m2532a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            valueModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ValueParser.m2767a(valueModel.w_(), valueModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ValueModel.class, new Serializer());
                    }
                }

                public ValueModel() {
                    super(1);
                }

                public ValueModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m2534a() {
                    this.f1596d = super.a(this.f1596d, 0);
                    return this.f1596d;
                }

                public static ValueModel m2531a(ValueModel valueModel) {
                    if (valueModel == null) {
                        return null;
                    }
                    if (valueModel instanceof ValueModel) {
                        return valueModel;
                    }
                    Builder builder = new Builder();
                    builder.f1595a = valueModel.m2534a();
                    return builder.m2528a();
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m2533a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2532a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2534a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ ValueModel m2542d() {
                return m2536j();
            }

            public AttachmentPropertiesModel() {
                super(4);
            }

            public AttachmentPropertiesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m2539a() {
                this.f1597d = super.a(this.f1597d, 0);
                return this.f1597d;
            }

            @Nullable
            public final String m2540b() {
                this.f1598e = super.a(this.f1598e, 1);
                return this.f1598e;
            }

            @Nullable
            public final String m2541c() {
                this.f1599f = super.a(this.f1599f, 2);
                return this.f1599f;
            }

            @Nullable
            private ValueModel m2536j() {
                this.f1600g = (ValueModel) super.a(this.f1600g, 3, ValueModel.class);
                return this.f1600g;
            }

            public static AttachmentPropertiesModel m2535a(AttachmentPropertiesModel attachmentPropertiesModel) {
                if (attachmentPropertiesModel == null) {
                    return null;
                }
                if (attachmentPropertiesModel instanceof AttachmentPropertiesModel) {
                    return attachmentPropertiesModel;
                }
                Builder builder = new Builder();
                builder.f1591a = attachmentPropertiesModel.m2539a();
                builder.f1592b = attachmentPropertiesModel.m2540b();
                builder.f1593c = attachmentPropertiesModel.m2541c();
                builder.f1594d = ValueModel.m2531a(attachmentPropertiesModel.m2542d());
                return builder.m2525a();
            }

            public final int jK_() {
                return -363494344;
            }

            public final GraphQLVisitableModel m2538a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2536j() != null) {
                    ValueModel valueModel = (ValueModel) graphQLModelMutatingVisitor.b(m2536j());
                    if (m2536j() != valueModel) {
                        graphQLVisitableModel = (AttachmentPropertiesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1600g = valueModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2537a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2539a());
                int b2 = flatBufferBuilder.b(m2540b());
                int b3 = flatBufferBuilder.b(m2541c());
                int a = ModelHelper.a(flatBufferBuilder, m2536j());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public final class Builder {
            @Nullable
            public ImmutableList<ActionLinksModel> f1601a;
            @Nullable
            public ImmutableList<AttachmentPropertiesModel> f1602b;
            @Nullable
            public String f1603c;
            @Nullable
            public DescriptionModel f1604d;
            @Nullable
            public XMAAttachmentMediaModel f1605e;
            @Nullable
            public SourceModel f1606f;
            @Nullable
            public ImmutableList<GraphQLStoryAttachmentStyle> f1607g;
            @Nullable
            public ImmutableList<SubattachmentsModel> f1608h;
            @Nullable
            public String f1609i;
            @Nullable
            public StoryAttachmentTargetFragmentModel f1610j;
            @Nullable
            public String f1611k;
            @Nullable
            public String f1612l;
            @Nullable
            public String f1613m;

            public final XMAAttachmentStoryFieldsModel m2543a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f1601a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f1602b);
                int b = flatBufferBuilder.b(this.f1603c);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f1604d);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f1605e);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f1606f);
                int d = flatBufferBuilder.d(this.f1607g);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f1608h);
                int b2 = flatBufferBuilder.b(this.f1609i);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f1610j);
                int b3 = flatBufferBuilder.b(this.f1611k);
                int b4 = flatBufferBuilder.b(this.f1612l);
                int b5 = flatBufferBuilder.b(this.f1613m);
                flatBufferBuilder.c(13);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.b(6, d);
                flatBufferBuilder.b(7, a6);
                flatBufferBuilder.b(8, b2);
                flatBufferBuilder.b(9, a7);
                flatBufferBuilder.b(10, b3);
                flatBufferBuilder.b(11, b4);
                flatBufferBuilder.b(12, b5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new XMAAttachmentStoryFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(XMAAttachmentStoryFieldsModel.class, new Deserializer());
            }

            public Object m2544a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(XMAAttachmentStoryFieldsParser.m2778a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object xMAAttachmentStoryFieldsModel = new XMAAttachmentStoryFieldsModel();
                ((BaseModel) xMAAttachmentStoryFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (xMAAttachmentStoryFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) xMAAttachmentStoryFieldsModel).a();
                }
                return xMAAttachmentStoryFieldsModel;
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<XMAAttachmentStoryFieldsModel> {
            public final void m2545a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel = (XMAAttachmentStoryFieldsModel) obj;
                if (xMAAttachmentStoryFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(xMAAttachmentStoryFieldsModel.m2578a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    xMAAttachmentStoryFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                XMAAttachmentStoryFieldsParser.m2779a(xMAAttachmentStoryFieldsModel.w_(), xMAAttachmentStoryFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(XMAAttachmentStoryFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -672616944)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoPathToWaterfallId */
        public final class SubattachmentsModel extends BaseModel implements GraphQLVisitableModel, CommonStoryAttachmentFields {
            @Nullable
            private DescriptionModel f1627d;
            @Nullable
            private MediaModel f1628e;
            @Nullable
            private SourceModel f1629f;
            @Nullable
            private List<GraphQLStoryAttachmentStyle> f1630g;
            @Nullable
            private String f1631h;
            @Nullable
            private StoryAttachmentTargetFragmentModel f1632i;
            @Nullable
            private String f1633j;

            /* compiled from: videoPathToWaterfallId */
            public final class Builder {
                @Nullable
                public DescriptionModel f1614a;
                @Nullable
                public MediaModel f1615b;
                @Nullable
                public SourceModel f1616c;
                @Nullable
                public ImmutableList<GraphQLStoryAttachmentStyle> f1617d;
                @Nullable
                public String f1618e;
                @Nullable
                public StoryAttachmentTargetFragmentModel f1619f;
                @Nullable
                public String f1620g;

                public final SubattachmentsModel m2546a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f1614a);
                    int a2 = ModelHelper.a(flatBufferBuilder, this.f1615b);
                    int a3 = ModelHelper.a(flatBufferBuilder, this.f1616c);
                    int d = flatBufferBuilder.d(this.f1617d);
                    int b = flatBufferBuilder.b(this.f1618e);
                    int a4 = ModelHelper.a(flatBufferBuilder, this.f1619f);
                    int b2 = flatBufferBuilder.b(this.f1620g);
                    flatBufferBuilder.c(7);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    flatBufferBuilder.b(3, d);
                    flatBufferBuilder.b(4, b);
                    flatBufferBuilder.b(5, a4);
                    flatBufferBuilder.b(6, b2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new SubattachmentsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SubattachmentsModel.class, new Deserializer());
                }

                public Object m2547a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SubattachmentsParser.m2776b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object subattachmentsModel = new SubattachmentsModel();
                    ((BaseModel) subattachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (subattachmentsModel instanceof Postprocessable) {
                        return ((Postprocessable) subattachmentsModel).a();
                    }
                    return subattachmentsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2120343825)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoPathToWaterfallId */
            public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f1625d;
                @Nullable
                private ImageModel f1626e;

                /* compiled from: videoPathToWaterfallId */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f1621a;
                    @Nullable
                    public ImageModel f1622b;
                }

                /* compiled from: videoPathToWaterfallId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                    }

                    public Object m2548a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MediaParser.m2773a(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: videoPathToWaterfallId */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f1624d;

                    /* compiled from: videoPathToWaterfallId */
                    public final class Builder {
                        @Nullable
                        public String f1623a;
                    }

                    /* compiled from: videoPathToWaterfallId */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m2549a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(MediaParser.ImageParser.m2771a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: videoPathToWaterfallId */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m2550a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m2552a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MediaParser.ImageParser.m2772a(imageModel.w_(), imageModel.u_(), jsonGenerator);
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
                    public final String m2554a() {
                        this.f1624d = super.a(this.f1624d, 0);
                        return this.f1624d;
                    }

                    public static ImageModel m2551a(ImageModel imageModel) {
                        if (imageModel == null) {
                            return null;
                        }
                        if (imageModel instanceof ImageModel) {
                            return imageModel;
                        }
                        Builder builder = new Builder();
                        builder.f1623a = imageModel.m2554a();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f1623a);
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

                    public final GraphQLVisitableModel m2553a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m2552a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m2554a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: videoPathToWaterfallId */
                public class Serializer extends JsonSerializer<MediaModel> {
                    public final void m2555a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MediaModel mediaModel = (MediaModel) obj;
                        if (mediaModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mediaModel.m2558a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MediaParser.m2774a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(MediaModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ImageModel m2561b() {
                    return m2557j();
                }

                public MediaModel() {
                    super(2);
                }

                public MediaModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final GraphQLObjectType m2559a() {
                    if (this.b != null && this.f1625d == null) {
                        this.f1625d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f1625d;
                }

                @Nullable
                private ImageModel m2557j() {
                    this.f1626e = (ImageModel) super.a(this.f1626e, 1, ImageModel.class);
                    return this.f1626e;
                }

                public static MediaModel m2556a(MediaModel mediaModel) {
                    if (mediaModel == null) {
                        return null;
                    }
                    if (mediaModel instanceof MediaModel) {
                        return mediaModel;
                    }
                    Builder builder = new Builder();
                    builder.f1621a = mediaModel.m2559a();
                    builder.f1622b = ImageModel.m2551a(mediaModel.m2561b());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f1621a);
                    int a2 = ModelHelper.a(flatBufferBuilder, builder.f1622b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new MediaModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 74219460;
                }

                public final GraphQLVisitableModel m2560a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2557j() != null) {
                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m2557j());
                        if (m2557j() != imageModel) {
                            graphQLVisitableModel = (MediaModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1626e = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2558a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2559a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m2557j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: videoPathToWaterfallId */
            public class Serializer extends JsonSerializer<SubattachmentsModel> {
                public final void m2562a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SubattachmentsModel subattachmentsModel = (SubattachmentsModel) obj;
                    if (subattachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(subattachmentsModel.m2568a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        subattachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SubattachmentsParser.m2777b(subattachmentsModel.w_(), subattachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SubattachmentsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DescriptionModel m2570a() {
                return m2564j();
            }

            @Nullable
            public final /* synthetic */ MediaModel m2571b() {
                return m2565k();
            }

            @Nullable
            public final /* synthetic */ SourceModel m2572c() {
                return m2566l();
            }

            @Nullable
            public final /* synthetic */ StoryAttachmentTargetFragmentModel m2574g() {
                return m2567m();
            }

            public SubattachmentsModel() {
                super(7);
            }

            public SubattachmentsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(7);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private DescriptionModel m2564j() {
                this.f1627d = (DescriptionModel) super.a(this.f1627d, 0, DescriptionModel.class);
                return this.f1627d;
            }

            @Nullable
            private MediaModel m2565k() {
                this.f1628e = (MediaModel) super.a(this.f1628e, 1, MediaModel.class);
                return this.f1628e;
            }

            @Nullable
            private SourceModel m2566l() {
                this.f1629f = (SourceModel) super.a(this.f1629f, 2, SourceModel.class);
                return this.f1629f;
            }

            @Nonnull
            public final ImmutableList<GraphQLStoryAttachmentStyle> m2573d() {
                this.f1630g = super.c(this.f1630g, 3, GraphQLStoryAttachmentStyle.class);
                return (ImmutableList) this.f1630g;
            }

            @Nullable
            public final String aQ_() {
                this.f1631h = super.a(this.f1631h, 4);
                return this.f1631h;
            }

            @Nullable
            private StoryAttachmentTargetFragmentModel m2567m() {
                this.f1632i = (StoryAttachmentTargetFragmentModel) super.a(this.f1632i, 5, StoryAttachmentTargetFragmentModel.class);
                return this.f1632i;
            }

            @Nullable
            public final String aR_() {
                this.f1633j = super.a(this.f1633j, 6);
                return this.f1633j;
            }

            public static SubattachmentsModel m2563a(SubattachmentsModel subattachmentsModel) {
                if (subattachmentsModel == null) {
                    return null;
                }
                if (subattachmentsModel instanceof SubattachmentsModel) {
                    return subattachmentsModel;
                }
                Builder builder = new Builder();
                builder.f1614a = DescriptionModel.m1925a(subattachmentsModel.m2570a());
                builder.f1615b = MediaModel.m2556a(subattachmentsModel.m2571b());
                builder.f1616c = SourceModel.m1933a(subattachmentsModel.m2572c());
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < subattachmentsModel.m2573d().size(); i++) {
                    builder2.c(subattachmentsModel.m2573d().get(i));
                }
                builder.f1617d = builder2.b();
                builder.f1618e = subattachmentsModel.aQ_();
                builder.f1619f = StoryAttachmentTargetFragmentModel.m1722a(subattachmentsModel.m2574g());
                builder.f1620g = subattachmentsModel.aR_();
                return builder.m2546a();
            }

            public final int jK_() {
                return -1267730472;
            }

            public final GraphQLVisitableModel m2569a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2564j() != null) {
                    DescriptionModel descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m2564j());
                    if (m2564j() != descriptionModel) {
                        graphQLVisitableModel = (SubattachmentsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1627d = descriptionModel;
                    }
                }
                if (m2565k() != null) {
                    MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m2565k());
                    if (m2565k() != mediaModel) {
                        graphQLVisitableModel = (SubattachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1628e = mediaModel;
                    }
                }
                if (m2566l() != null) {
                    SourceModel sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m2566l());
                    if (m2566l() != sourceModel) {
                        graphQLVisitableModel = (SubattachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1629f = sourceModel;
                    }
                }
                if (m2567m() != null) {
                    StoryAttachmentTargetFragmentModel storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) graphQLModelMutatingVisitor.b(m2567m());
                    if (m2567m() != storyAttachmentTargetFragmentModel) {
                        graphQLVisitableModel = (SubattachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1632i = storyAttachmentTargetFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2568a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2564j());
                int a2 = ModelHelper.a(flatBufferBuilder, m2565k());
                int a3 = ModelHelper.a(flatBufferBuilder, m2566l());
                int d = flatBufferBuilder.d(m2573d());
                int b = flatBufferBuilder.b(aQ_());
                int a4 = ModelHelper.a(flatBufferBuilder, m2567m());
                int b2 = flatBufferBuilder.b(aR_());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, d);
                flatBufferBuilder.b(4, b);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ XMAAttachmentMediaModel aP_() {
            return m2590o();
        }

        @Nullable
        public final /* synthetic */ DescriptionModel m2583d() {
            return m2576q();
        }

        @Nullable
        public final /* synthetic */ SourceModel m2584g() {
            return m2577r();
        }

        @Nullable
        public final /* synthetic */ StoryAttachmentTargetFragmentModel m2586k() {
            return m2591p();
        }

        public XMAAttachmentStoryFieldsModel() {
            super(13);
        }

        public XMAAttachmentStoryFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(13);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<ActionLinksModel> m2580a() {
            this.f1634d = super.a(this.f1634d, 0, ActionLinksModel.class);
            return (ImmutableList) this.f1634d;
        }

        @Nonnull
        public final ImmutableList<AttachmentPropertiesModel> m2581b() {
            this.f1635e = super.a(this.f1635e, 1, AttachmentPropertiesModel.class);
            return (ImmutableList) this.f1635e;
        }

        @Nullable
        public final String m2582c() {
            this.f1636f = super.a(this.f1636f, 2);
            return this.f1636f;
        }

        @Nullable
        private DescriptionModel m2576q() {
            this.f1637g = (DescriptionModel) super.a(this.f1637g, 3, DescriptionModel.class);
            return this.f1637g;
        }

        @Nullable
        public final XMAAttachmentMediaModel m2590o() {
            this.f1638h = (XMAAttachmentMediaModel) super.a(this.f1638h, 4, XMAAttachmentMediaModel.class);
            return this.f1638h;
        }

        @Nullable
        private SourceModel m2577r() {
            this.f1639i = (SourceModel) super.a(this.f1639i, 5, SourceModel.class);
            return this.f1639i;
        }

        @Nonnull
        public final ImmutableList<GraphQLStoryAttachmentStyle> aN_() {
            this.f1640j = super.c(this.f1640j, 6, GraphQLStoryAttachmentStyle.class);
            return (ImmutableList) this.f1640j;
        }

        @Nonnull
        public final ImmutableList<SubattachmentsModel> aO_() {
            this.f1641k = super.a(this.f1641k, 7, SubattachmentsModel.class);
            return (ImmutableList) this.f1641k;
        }

        @Nullable
        public final String m2585j() {
            this.f1642l = super.a(this.f1642l, 8);
            return this.f1642l;
        }

        @Nullable
        public final StoryAttachmentTargetFragmentModel m2591p() {
            this.f1643m = (StoryAttachmentTargetFragmentModel) super.a(this.f1643m, 9, StoryAttachmentTargetFragmentModel.class);
            return this.f1643m;
        }

        @Nullable
        public final String m2587l() {
            this.f1644n = super.a(this.f1644n, 10);
            return this.f1644n;
        }

        @Nullable
        public final String m2588m() {
            this.f1645o = super.a(this.f1645o, 11);
            return this.f1645o;
        }

        @Nullable
        public final String m2589n() {
            this.f1646p = super.a(this.f1646p, 12);
            return this.f1646p;
        }

        public static XMAAttachmentStoryFieldsModel m2575a(XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel) {
            int i = 0;
            if (xMAAttachmentStoryFieldsModel == null) {
                return null;
            }
            if (xMAAttachmentStoryFieldsModel instanceof XMAAttachmentStoryFieldsModel) {
                return xMAAttachmentStoryFieldsModel;
            }
            int i2;
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < xMAAttachmentStoryFieldsModel.m2580a().size(); i2++) {
                builder2.c(ActionLinksModel.m2519a((ActionLinksModel) xMAAttachmentStoryFieldsModel.m2580a().get(i2)));
            }
            builder.f1601a = builder2.b();
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < xMAAttachmentStoryFieldsModel.m2581b().size(); i2++) {
                builder2.c(AttachmentPropertiesModel.m2535a((AttachmentPropertiesModel) xMAAttachmentStoryFieldsModel.m2581b().get(i2)));
            }
            builder.f1602b = builder2.b();
            builder.f1603c = xMAAttachmentStoryFieldsModel.m2582c();
            builder.f1604d = DescriptionModel.m1925a(xMAAttachmentStoryFieldsModel.m2583d());
            builder.f1605e = XMAAttachmentMediaModel.m2502a(xMAAttachmentStoryFieldsModel.aP_());
            builder.f1606f = SourceModel.m1933a(xMAAttachmentStoryFieldsModel.m2584g());
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            for (int i3 = 0; i3 < xMAAttachmentStoryFieldsModel.aN_().size(); i3++) {
                builder3.c(xMAAttachmentStoryFieldsModel.aN_().get(i3));
            }
            builder.f1607g = builder3.b();
            builder3 = ImmutableList.builder();
            while (i < xMAAttachmentStoryFieldsModel.aO_().size()) {
                builder3.c(SubattachmentsModel.m2563a((SubattachmentsModel) xMAAttachmentStoryFieldsModel.aO_().get(i)));
                i++;
            }
            builder.f1608h = builder3.b();
            builder.f1609i = xMAAttachmentStoryFieldsModel.m2585j();
            builder.f1610j = StoryAttachmentTargetFragmentModel.m1722a(xMAAttachmentStoryFieldsModel.m2586k());
            builder.f1611k = xMAAttachmentStoryFieldsModel.m2587l();
            builder.f1612l = xMAAttachmentStoryFieldsModel.m2588m();
            builder.f1613m = xMAAttachmentStoryFieldsModel.m2589n();
            return builder.m2543a();
        }

        public final int jK_() {
            return -1267730472;
        }

        public final GraphQLVisitableModel m2579a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            com.google.common.collect.ImmutableList.Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2580a() != null) {
                a = ModelHelper.a(m2580a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (XMAAttachmentStoryFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1634d = a.b();
                }
            }
            if (m2581b() != null) {
                a = ModelHelper.a(m2581b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (XMAAttachmentStoryFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1635e = a.b();
                }
            }
            GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
            if (m2576q() != null) {
                DescriptionModel descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m2576q());
                if (m2576q() != descriptionModel) {
                    graphQLVisitableModel2 = (XMAAttachmentStoryFieldsModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f1637g = descriptionModel;
                }
            }
            if (m2590o() != null) {
                XMAAttachmentMediaModel xMAAttachmentMediaModel = (XMAAttachmentMediaModel) graphQLModelMutatingVisitor.b(m2590o());
                if (m2590o() != xMAAttachmentMediaModel) {
                    graphQLVisitableModel2 = (XMAAttachmentStoryFieldsModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f1638h = xMAAttachmentMediaModel;
                }
            }
            if (m2577r() != null) {
                SourceModel sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m2577r());
                if (m2577r() != sourceModel) {
                    graphQLVisitableModel2 = (XMAAttachmentStoryFieldsModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f1639i = sourceModel;
                }
            }
            if (aO_() != null) {
                com.google.common.collect.ImmutableList.Builder a2 = ModelHelper.a(aO_(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel = (XMAAttachmentStoryFieldsModel) ModelHelper.a(graphQLVisitableModel2, this);
                    xMAAttachmentStoryFieldsModel.f1641k = a2.b();
                    graphQLVisitableModel2 = xMAAttachmentStoryFieldsModel;
                }
            }
            if (m2591p() != null) {
                StoryAttachmentTargetFragmentModel storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) graphQLModelMutatingVisitor.b(m2591p());
                if (m2591p() != storyAttachmentTargetFragmentModel) {
                    graphQLVisitableModel2 = (XMAAttachmentStoryFieldsModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f1643m = storyAttachmentTargetFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
        }

        public final int m2578a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2580a());
            int a2 = ModelHelper.a(flatBufferBuilder, m2581b());
            int b = flatBufferBuilder.b(m2582c());
            int a3 = ModelHelper.a(flatBufferBuilder, m2576q());
            int a4 = ModelHelper.a(flatBufferBuilder, m2590o());
            int a5 = ModelHelper.a(flatBufferBuilder, m2577r());
            int d = flatBufferBuilder.d(aN_());
            int a6 = ModelHelper.a(flatBufferBuilder, aO_());
            int b2 = flatBufferBuilder.b(m2585j());
            int a7 = ModelHelper.a(flatBufferBuilder, m2591p());
            int b3 = flatBufferBuilder.b(m2587l());
            int b4 = flatBufferBuilder.b(m2588m());
            int b5 = flatBufferBuilder.b(m2589n());
            flatBufferBuilder.c(13);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, d);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.b(8, b2);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.b(10, b3);
            flatBufferBuilder.b(11, b4);
            flatBufferBuilder.b(12, b5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2121310465)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoPathToWaterfallId */
    public final class XMAModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GenieStoryAttachmentFieldsModel f1651d;
        @Nullable
        private String f1652e;
        private boolean f1653f;
        @Nullable
        private XMAAttachmentStoryFieldsModel f1654g;

        /* compiled from: videoPathToWaterfallId */
        public final class Builder {
            @Nullable
            public GenieStoryAttachmentFieldsModel f1647a;
            @Nullable
            public String f1648b;
            public boolean f1649c;
            @Nullable
            public XMAAttachmentStoryFieldsModel f1650d;

            public final XMAModel m2592a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f1647a);
                int b = flatBufferBuilder.b(this.f1648b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f1650d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f1649c);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new XMAModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(XMAModel.class, new Deserializer());
            }

            public Object m2593a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(XMAParser.m2780a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object xMAModel = new XMAModel();
                ((BaseModel) xMAModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (xMAModel instanceof Postprocessable) {
                    return ((Postprocessable) xMAModel).a();
                }
                return xMAModel;
            }
        }

        /* compiled from: videoPathToWaterfallId */
        public class Serializer extends JsonSerializer<XMAModel> {
            public final void m2594a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                XMAModel xMAModel = (XMAModel) obj;
                if (xMAModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(xMAModel.m2595a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    xMAModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                XMAParser.m2781a(xMAModel.w_(), xMAModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(XMAModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ XMAAttachmentStoryFieldsModel m2600c() {
            return m2603l();
        }

        public XMAModel() {
            super(4);
        }

        public XMAModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GenieStoryAttachmentFieldsModel m2601j() {
            this.f1651d = (GenieStoryAttachmentFieldsModel) super.a(this.f1651d, 0, GenieStoryAttachmentFieldsModel.class);
            return this.f1651d;
        }

        @Nullable
        public final String m2599b() {
            this.f1652e = super.a(this.f1652e, 1);
            return this.f1652e;
        }

        public final boolean m2602k() {
            a(0, 2);
            return this.f1653f;
        }

        @Nullable
        public final XMAAttachmentStoryFieldsModel m2603l() {
            this.f1654g = (XMAAttachmentStoryFieldsModel) super.a(this.f1654g, 3, XMAAttachmentStoryFieldsModel.class);
            return this.f1654g;
        }

        @Nullable
        public final String m2597a() {
            return m2599b();
        }

        public final int jK_() {
            return 1756691119;
        }

        public final GraphQLVisitableModel m2596a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2601j() != null) {
                GenieStoryAttachmentFieldsModel genieStoryAttachmentFieldsModel = (GenieStoryAttachmentFieldsModel) graphQLModelMutatingVisitor.b(m2601j());
                if (m2601j() != genieStoryAttachmentFieldsModel) {
                    graphQLVisitableModel = (XMAModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1651d = genieStoryAttachmentFieldsModel;
                }
            }
            if (m2603l() != null) {
                XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel = (XMAAttachmentStoryFieldsModel) graphQLModelMutatingVisitor.b(m2603l());
                if (m2603l() != xMAAttachmentStoryFieldsModel) {
                    graphQLVisitableModel = (XMAModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1654g = xMAAttachmentStoryFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2595a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2601j());
            int b = flatBufferBuilder.b(m2599b());
            int a2 = ModelHelper.a(flatBufferBuilder, m2603l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f1653f);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2598a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1653f = mutableFlatBuffer.a(i, 2);
        }
    }
}
