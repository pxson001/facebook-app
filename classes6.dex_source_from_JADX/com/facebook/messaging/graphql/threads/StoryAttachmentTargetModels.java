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
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType;
import com.facebook.graphql.enums.GraphQLMessengerRetailItemStatus;
import com.facebook.graphql.enums.GraphQLMomentsAppMessengerInviteActionType;
import com.facebook.graphql.enums.GraphQLMovieBotMovieListStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageProductTransactionOrderStatusEnum;
import com.facebook.graphql.enums.GraphQLPeerToPeerTransferStatus;
import com.facebook.graphql.enums.GraphQLShipmentTrackingEventType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsModels.PlatformCallToActionModel;
import com.facebook.messaging.graphql.threads.BotMessageQueriesModels.MovieButtonFragmentModel;
import com.facebook.messaging.graphql.threads.BotMessageQueriesModels.MovieDetailsFragmentModel;
import com.facebook.messaging.graphql.threads.BotMessageQueriesModels.MovieImageFragmentModel;
import com.facebook.messaging.graphql.threads.BotMessageQueriesModels.MovieTheaterFragmentModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.BusinessMessage;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceBaseOrderReceipt;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceOrderCancellationBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceOrderReceiptBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceProductSubscriptionBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceProductSubscriptionBubble.PartnerLogo;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommercePromotions;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceRetailItem;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceShipmentBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceShipmentTrackingBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.LogoImage;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.BusinessMessageModel.BusinessItemsModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceBaseOrderReceiptModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceOrderCancellationBubbleModel.CancelledItemsModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceOrderReceiptBubbleModel.RetailItemsModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommercePromotionsModel.PromotionItemsModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.LogoImageModel;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsInterfaces.InvoicesFragment;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsModels.InvoicesFragmentModel.PlatformContextModel;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsModels.InvoicesFragmentModel.TransactionPaymentModel;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsModels.InvoicesFragmentModel.TransactionProductsModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetInterfaces.FundraiserToCharityFragment;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetInterfaces.GroupFragment;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetInterfaces.MessageEventFragment;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetInterfaces.MessageLocationFragment;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetInterfaces.PeerToPeerPaymentRequestFragment;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetInterfaces.PeerToPeerPaymentRequestFragment.Amount;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetInterfaces.PeerToPeerTransferFragment;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.FundraiserToCharityFragmentParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.FundraiserToCharityFragmentParser.FundraiserDetailedProgressTextParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.FundraiserToCharityFragmentParser.FundraiserForCharityTextParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.GroupFragmentParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.GroupFragmentParser.CoverPhotoParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.GroupFragmentParser.CoverPhotoParser.PhotoParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.GroupFragmentParser.CoverPhotoParser.PhotoParser.ImageParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.GroupFragmentParser.GroupFriendMembersParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.GroupFragmentParser.GroupMembersParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.GroupFragmentParser.ViewerInviteToGroupParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.GroupFragmentParser.ViewerInviteToGroupParser.InviterParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.MessageEventFragmentParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.MessageEventFragmentParser.EventCoordinatesParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.MessageEventFragmentParser.EventPlaceParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.MessageLocationFragmentParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.MessageLocationFragmentParser.CoordinatesParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.MessageLocationFragmentParser.PlaceParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.MomentsAppInvitationActionLinkFragmentParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.PeerToPeerPaymentRequestFragmentParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.PeerToPeerPaymentRequestFragmentParser.AmountParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.PeerToPeerPaymentRequestFragmentParser.RequesteeParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.PeerToPeerPaymentRequestFragmentParser.RequesterParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.PeerToPeerTransferFragmentParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.PeerToPeerTransferFragmentParser.ReceiverParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.PeerToPeerTransferFragmentParser.SenderParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.StoryAttachmentTargetFragmentParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.StoryAttachmentTargetFragmentParser.PageParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.StoryAttachmentTargetFragmentParser.PartnerLogoParser;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetParsers.StoryAttachmentTargetFragmentParser.PaymentParser;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsInterfaces.AgentItemReceiptBubble;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsInterfaces.AgentItemReceiptBubble.Payment;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsModels.AgentItemReceiptBubbleModel.ItemModel;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsInterfaces.AirlineBoardingPassBubble;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsInterfaces.AirlineBoardingPassBubble.Page;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsInterfaces.AirlineConfirmationBubble;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlineBoardingPassBubbleModel.BoardingPassesModel;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlineConfirmationBubbleModel.ItineraryLegsModel;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlineFlightInfoModel;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlinePassengerModel;
import com.facebook.messaging.graphql.threads.business.RideThreadFragmentsInterfaces.BusinessRideReceiptFragment;
import com.facebook.messaging.graphql.threads.business.RideThreadFragmentsModels.BusinessRideLocationModel;
import com.facebook.messaging.graphql.threads.business.RideThreadFragmentsModels.BusinessRideReceiptFragmentModel.RideProviderModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: videoTirmStartTimeMs */
public class StoryAttachmentTargetModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 356921820)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoTirmStartTimeMs */
    public final class FundraiserToCharityFragmentModel extends BaseModel implements GraphQLVisitableModel, FundraiserToCharityFragment {
        @Nullable
        private GraphQLObjectType f1068d;
        @Nullable
        private FundraiserDetailedProgressTextModel f1069e;
        @Nullable
        private FundraiserForCharityTextModel f1070f;

        /* compiled from: videoTirmStartTimeMs */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f1061a;
            @Nullable
            public FundraiserDetailedProgressTextModel f1062b;
            @Nullable
            public FundraiserForCharityTextModel f1063c;
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserToCharityFragmentModel.class, new Deserializer());
            }

            public Object m1459a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FundraiserToCharityFragmentParser.m1782a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fundraiserToCharityFragmentModel = new FundraiserToCharityFragmentModel();
                ((BaseModel) fundraiserToCharityFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fundraiserToCharityFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserToCharityFragmentModel).a();
                }
                return fundraiserToCharityFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class FundraiserDetailedProgressTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1065d;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public String f1064a;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FundraiserDetailedProgressTextModel.class, new Deserializer());
                }

                public Object m1460a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FundraiserDetailedProgressTextParser.m1778a(jsonParser, flatBufferBuilder));
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

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<FundraiserDetailedProgressTextModel> {
                public final void m1461a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FundraiserDetailedProgressTextModel fundraiserDetailedProgressTextModel = (FundraiserDetailedProgressTextModel) obj;
                    if (fundraiserDetailedProgressTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(fundraiserDetailedProgressTextModel.m1463a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        fundraiserDetailedProgressTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FundraiserDetailedProgressTextParser.m1779a(fundraiserDetailedProgressTextModel.w_(), fundraiserDetailedProgressTextModel.u_(), jsonGenerator);
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
            public final String m1465a() {
                this.f1065d = super.a(this.f1065d, 0);
                return this.f1065d;
            }

            public static FundraiserDetailedProgressTextModel m1462a(FundraiserDetailedProgressTextModel fundraiserDetailedProgressTextModel) {
                if (fundraiserDetailedProgressTextModel == null) {
                    return null;
                }
                if (fundraiserDetailedProgressTextModel instanceof FundraiserDetailedProgressTextModel) {
                    return fundraiserDetailedProgressTextModel;
                }
                Builder builder = new Builder();
                builder.f1064a = fundraiserDetailedProgressTextModel.m1465a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f1064a);
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

            public final GraphQLVisitableModel m1464a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1463a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1465a());
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
        /* compiled from: videoTirmStartTimeMs */
        public final class FundraiserForCharityTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1067d;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public String f1066a;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FundraiserForCharityTextModel.class, new Deserializer());
                }

                public Object m1466a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FundraiserForCharityTextParser.m1780a(jsonParser, flatBufferBuilder));
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

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<FundraiserForCharityTextModel> {
                public final void m1467a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FundraiserForCharityTextModel fundraiserForCharityTextModel = (FundraiserForCharityTextModel) obj;
                    if (fundraiserForCharityTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(fundraiserForCharityTextModel.m1469a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        fundraiserForCharityTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FundraiserForCharityTextParser.m1781a(fundraiserForCharityTextModel.w_(), fundraiserForCharityTextModel.u_(), jsonGenerator);
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
            public final String m1471a() {
                this.f1067d = super.a(this.f1067d, 0);
                return this.f1067d;
            }

            public static FundraiserForCharityTextModel m1468a(FundraiserForCharityTextModel fundraiserForCharityTextModel) {
                if (fundraiserForCharityTextModel == null) {
                    return null;
                }
                if (fundraiserForCharityTextModel instanceof FundraiserForCharityTextModel) {
                    return fundraiserForCharityTextModel;
                }
                Builder builder = new Builder();
                builder.f1066a = fundraiserForCharityTextModel.m1471a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f1066a);
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

            public final GraphQLVisitableModel m1470a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1469a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1471a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Serializer extends JsonSerializer<FundraiserToCharityFragmentModel> {
            public final void m1472a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FundraiserToCharityFragmentModel fundraiserToCharityFragmentModel = (FundraiserToCharityFragmentModel) obj;
                if (fundraiserToCharityFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserToCharityFragmentModel.m1479a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserToCharityFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FundraiserToCharityFragmentParser.m1783a(fundraiserToCharityFragmentModel.w_(), fundraiserToCharityFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FundraiserToCharityFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FundraiserDetailedProgressTextModel mo114J() {
            return m1473a();
        }

        @Nullable
        public final /* synthetic */ FundraiserForCharityTextModel mo115K() {
            return m1475j();
        }

        public FundraiserToCharityFragmentModel() {
            super(3);
        }

        public FundraiserToCharityFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType mo113I() {
            if (this.b != null && this.f1068d == null) {
                this.f1068d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1068d;
        }

        @Nullable
        private FundraiserDetailedProgressTextModel m1473a() {
            this.f1069e = (FundraiserDetailedProgressTextModel) super.a(this.f1069e, 1, FundraiserDetailedProgressTextModel.class);
            return this.f1069e;
        }

        @Nullable
        private FundraiserForCharityTextModel m1475j() {
            this.f1070f = (FundraiserForCharityTextModel) super.a(this.f1070f, 2, FundraiserForCharityTextModel.class);
            return this.f1070f;
        }

        public static FundraiserToCharityFragmentModel m1474a(FundraiserToCharityFragment fundraiserToCharityFragment) {
            if (fundraiserToCharityFragment == null) {
                return null;
            }
            if (fundraiserToCharityFragment instanceof FundraiserToCharityFragmentModel) {
                return (FundraiserToCharityFragmentModel) fundraiserToCharityFragment;
            }
            Builder builder = new Builder();
            builder.f1061a = fundraiserToCharityFragment.mo113I();
            builder.f1062b = FundraiserDetailedProgressTextModel.m1462a(fundraiserToCharityFragment.mo114J());
            builder.f1063c = FundraiserForCharityTextModel.m1468a(fundraiserToCharityFragment.mo115K());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f1061a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f1062b);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f1063c);
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new FundraiserToCharityFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -2117047886;
        }

        public final GraphQLVisitableModel m1480a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1473a() != null) {
                FundraiserDetailedProgressTextModel fundraiserDetailedProgressTextModel = (FundraiserDetailedProgressTextModel) graphQLModelMutatingVisitor.b(m1473a());
                if (m1473a() != fundraiserDetailedProgressTextModel) {
                    graphQLVisitableModel = (FundraiserToCharityFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1069e = fundraiserDetailedProgressTextModel;
                }
            }
            if (m1475j() != null) {
                FundraiserForCharityTextModel fundraiserForCharityTextModel = (FundraiserForCharityTextModel) graphQLModelMutatingVisitor.b(m1475j());
                if (m1475j() != fundraiserForCharityTextModel) {
                    graphQLVisitableModel = (FundraiserToCharityFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1070f = fundraiserForCharityTextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1479a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo113I());
            int a2 = ModelHelper.a(flatBufferBuilder, m1473a());
            int a3 = ModelHelper.a(flatBufferBuilder, m1475j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1249081290)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoTirmStartTimeMs */
    public final class GroupFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, GroupFragment {
        @Nullable
        private CoverPhotoModel f1087d;
        @Nullable
        private GroupFriendMembersModel f1088e;
        @Nullable
        private GroupMembersModel f1089f;
        @Nullable
        private String f1090g;
        @Nullable
        private ViewerInviteToGroupModel f1091h;
        @Nullable
        private GraphQLGroupJoinState f1092i;
        @Nullable
        private GraphQLGroupVisibility f1093j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1374223681)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhotoModel f1076d;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public PhotoModel f1071a;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m1481a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoverPhotoParser.m1788a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -1328517035)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoTirmStartTimeMs */
            public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ImageModel f1075d;

                /* compiled from: videoTirmStartTimeMs */
                public final class Builder {
                    @Nullable
                    public ImageModel f1072a;
                }

                /* compiled from: videoTirmStartTimeMs */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m1482a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoParser.m1786a(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: videoTirmStartTimeMs */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f1074d;

                    /* compiled from: videoTirmStartTimeMs */
                    public final class Builder {
                        @Nullable
                        public String f1073a;
                    }

                    /* compiled from: videoTirmStartTimeMs */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m1483a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ImageParser.m1784a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: videoTirmStartTimeMs */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m1484a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m1486a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ImageParser.m1785a(imageModel.w_(), imageModel.u_(), jsonGenerator);
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
                    public final String m1488a() {
                        this.f1074d = super.a(this.f1074d, 0);
                        return this.f1074d;
                    }

                    public static ImageModel m1485a(ImageModel imageModel) {
                        if (imageModel == null) {
                            return null;
                        }
                        if (imageModel instanceof ImageModel) {
                            return imageModel;
                        }
                        Builder builder = new Builder();
                        builder.f1073a = imageModel.m1488a();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f1073a);
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

                    public final GraphQLVisitableModel m1487a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m1486a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m1488a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: videoTirmStartTimeMs */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m1489a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) obj;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m1492a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoParser.m1787a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ImageModel m1494a() {
                    return m1491j();
                }

                public PhotoModel() {
                    super(1);
                }

                public PhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private ImageModel m1491j() {
                    this.f1075d = (ImageModel) super.a(this.f1075d, 0, ImageModel.class);
                    return this.f1075d;
                }

                public static PhotoModel m1490a(PhotoModel photoModel) {
                    if (photoModel == null) {
                        return null;
                    }
                    if (photoModel instanceof PhotoModel) {
                        return photoModel;
                    }
                    Builder builder = new Builder();
                    builder.f1072a = ImageModel.m1485a(photoModel.m1494a());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f1072a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m1493a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m1491j() != null) {
                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m1491j());
                        if (m1491j() != imageModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1075d = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m1492a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m1491j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m1495a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m1498a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoverPhotoParser.m1789a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PhotoModel m1500a() {
                return m1497j();
            }

            public CoverPhotoModel() {
                super(1);
            }

            public CoverPhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private PhotoModel m1497j() {
                this.f1076d = (PhotoModel) super.a(this.f1076d, 0, PhotoModel.class);
                return this.f1076d;
            }

            public static CoverPhotoModel m1496a(CoverPhotoModel coverPhotoModel) {
                if (coverPhotoModel == null) {
                    return null;
                }
                if (coverPhotoModel instanceof CoverPhotoModel) {
                    return coverPhotoModel;
                }
                Builder builder = new Builder();
                builder.f1071a = PhotoModel.m1490a(coverPhotoModel.m1500a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f1071a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CoverPhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m1499a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1497j() != null) {
                    PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m1497j());
                    if (m1497j() != photoModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1076d = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1498a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1497j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupFragmentModel.class, new Deserializer());
            }

            public Object m1501a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupFragmentParser.m1798a(jsonParser);
                Object groupFragmentModel = new GroupFragmentModel();
                ((BaseModel) groupFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) groupFragmentModel).a();
                }
                return groupFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class GroupFriendMembersModel extends BaseModel implements GraphQLVisitableModel {
            private int f1078d;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                public int f1077a;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupFriendMembersModel.class, new Deserializer());
                }

                public Object m1502a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupFriendMembersParser.m1790a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupFriendMembersModel = new GroupFriendMembersModel();
                    ((BaseModel) groupFriendMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupFriendMembersModel instanceof Postprocessable) {
                        return ((Postprocessable) groupFriendMembersModel).a();
                    }
                    return groupFriendMembersModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<GroupFriendMembersModel> {
                public final void m1503a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupFriendMembersModel groupFriendMembersModel = (GroupFriendMembersModel) obj;
                    if (groupFriendMembersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupFriendMembersModel.m1506a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupFriendMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupFriendMembersParser.m1791a(groupFriendMembersModel.w_(), groupFriendMembersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupFriendMembersModel.class, new Serializer());
                }
            }

            public GroupFriendMembersModel() {
                super(1);
            }

            public GroupFriendMembersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m1505a() {
                a(0, 0);
                return this.f1078d;
            }

            public static GroupFriendMembersModel m1504a(GroupFriendMembersModel groupFriendMembersModel) {
                if (groupFriendMembersModel == null) {
                    return null;
                }
                if (groupFriendMembersModel instanceof GroupFriendMembersModel) {
                    return groupFriendMembersModel;
                }
                Builder builder = new Builder();
                builder.f1077a = groupFriendMembersModel.m1505a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f1077a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GroupFriendMembersModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 1544320122;
            }

            public final GraphQLVisitableModel m1507a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1506a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f1078d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1508a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1078d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class GroupMembersModel extends BaseModel implements GraphQLVisitableModel {
            private int f1080d;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                public int f1079a;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupMembersModel.class, new Deserializer());
                }

                public Object m1509a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupMembersParser.m1792a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupMembersModel = new GroupMembersModel();
                    ((BaseModel) groupMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupMembersModel instanceof Postprocessable) {
                        return ((Postprocessable) groupMembersModel).a();
                    }
                    return groupMembersModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<GroupMembersModel> {
                public final void m1510a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupMembersModel groupMembersModel = (GroupMembersModel) obj;
                    if (groupMembersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupMembersModel.m1513a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupMembersParser.m1793a(groupMembersModel.w_(), groupMembersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupMembersModel.class, new Serializer());
                }
            }

            public GroupMembersModel() {
                super(1);
            }

            public GroupMembersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m1512a() {
                a(0, 0);
                return this.f1080d;
            }

            public static GroupMembersModel m1511a(GroupMembersModel groupMembersModel) {
                if (groupMembersModel == null) {
                    return null;
                }
                if (groupMembersModel instanceof GroupMembersModel) {
                    return groupMembersModel;
                }
                Builder builder = new Builder();
                builder.f1079a = groupMembersModel.m1512a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f1079a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GroupMembersModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 103365688;
            }

            public final GraphQLVisitableModel m1514a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1513a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f1080d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1515a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1080d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Serializer extends JsonSerializer<GroupFragmentModel> {
            public final void m1516a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupFragmentModel groupFragmentModel = (GroupFragmentModel) obj;
                if (groupFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupFragmentModel.m1543a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupFragmentModel.w_();
                int u_ = groupFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m1789a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("group_friend_members");
                    GroupFriendMembersParser.m1791a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("group_members");
                    GroupMembersParser.m1793a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("viewer_invite_to_group");
                    ViewerInviteToGroupParser.m1797a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 5) != 0) {
                    jsonGenerator.a("viewer_join_state");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 5));
                }
                if (mutableFlatBuffer.g(u_, 6) != 0) {
                    jsonGenerator.a("visibility");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 6));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1900787273)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class ViewerInviteToGroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f1085d;
            @Nullable
            private InviterModel f1086e;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public String f1081a;
                @Nullable
                public InviterModel f1082b;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerInviteToGroupModel.class, new Deserializer());
                }

                public Object m1517a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerInviteToGroupParser.m1796a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerInviteToGroupModel = new ViewerInviteToGroupModel();
                    ((BaseModel) viewerInviteToGroupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerInviteToGroupModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerInviteToGroupModel).a();
                    }
                    return viewerInviteToGroupModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 273304230)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: videoTirmStartTimeMs */
            public final class InviterModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private String f1084d;

                /* compiled from: videoTirmStartTimeMs */
                public final class Builder {
                    @Nullable
                    public String f1083a;
                }

                /* compiled from: videoTirmStartTimeMs */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(InviterModel.class, new Deserializer());
                    }

                    public Object m1518a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(InviterParser.m1794a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object inviterModel = new InviterModel();
                        ((BaseModel) inviterModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (inviterModel instanceof Postprocessable) {
                            return ((Postprocessable) inviterModel).a();
                        }
                        return inviterModel;
                    }
                }

                /* compiled from: videoTirmStartTimeMs */
                public class Serializer extends JsonSerializer<InviterModel> {
                    public final void m1519a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        InviterModel inviterModel = (InviterModel) obj;
                        if (inviterModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(inviterModel.m1521a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            inviterModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        InviterParser.m1795a(inviterModel.w_(), inviterModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(InviterModel.class, new Serializer());
                    }
                }

                public InviterModel() {
                    super(1);
                }

                public InviterModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m1524a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m1525a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m1523a() {
                    this.f1084d = super.a(this.f1084d, 0);
                    return this.f1084d;
                }

                public static InviterModel m1520a(InviterModel inviterModel) {
                    if (inviterModel == null) {
                        return null;
                    }
                    if (inviterModel instanceof InviterModel) {
                        return inviterModel;
                    }
                    Builder builder = new Builder();
                    builder.f1083a = inviterModel.m1523a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f1083a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new InviterModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m1522a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m1521a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m1523a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<ViewerInviteToGroupModel> {
                public final void m1526a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerInviteToGroupModel viewerInviteToGroupModel = (ViewerInviteToGroupModel) obj;
                    if (viewerInviteToGroupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerInviteToGroupModel.m1529a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerInviteToGroupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerInviteToGroupParser.m1797a(viewerInviteToGroupModel.w_(), viewerInviteToGroupModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerInviteToGroupModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ InviterModel m1533c() {
                return m1528j();
            }

            public ViewerInviteToGroupModel() {
                super(2);
            }

            public ViewerInviteToGroupModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m1532b() {
                this.f1085d = super.a(this.f1085d, 0);
                return this.f1085d;
            }

            @Nullable
            private InviterModel m1528j() {
                this.f1086e = (InviterModel) super.a(this.f1086e, 1, InviterModel.class);
                return this.f1086e;
            }

            public static ViewerInviteToGroupModel m1527a(ViewerInviteToGroupModel viewerInviteToGroupModel) {
                if (viewerInviteToGroupModel == null) {
                    return null;
                }
                if (viewerInviteToGroupModel instanceof ViewerInviteToGroupModel) {
                    return viewerInviteToGroupModel;
                }
                Builder builder = new Builder();
                builder.f1081a = viewerInviteToGroupModel.m1532b();
                builder.f1082b = InviterModel.m1520a(viewerInviteToGroupModel.m1533c());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f1081a);
                int a = ModelHelper.a(flatBufferBuilder, builder.f1082b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ViewerInviteToGroupModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m1531a() {
                return m1532b();
            }

            public final int jK_() {
                return 1476491891;
            }

            public final GraphQLVisitableModel m1530a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1528j() != null) {
                    InviterModel inviterModel = (InviterModel) graphQLModelMutatingVisitor.b(m1528j());
                    if (m1528j() != inviterModel) {
                        graphQLVisitableModel = (ViewerInviteToGroupModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1086e = inviterModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1529a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1532b());
                int a = ModelHelper.a(flatBufferBuilder, m1528j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public GroupFragmentModel() {
            super(7);
        }

        public final void m1546a(String str, ConsistencyTuple consistencyTuple) {
            if ("viewer_join_state".equals(str)) {
                consistencyTuple.a = m1541o();
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("visibility".equals(str)) {
                consistencyTuple.a = m1542p();
                consistencyTuple.b = u_();
                consistencyTuple.c = 6;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m1547a(String str, Object obj, boolean z) {
            if ("viewer_join_state".equals(str)) {
                m1534a((GraphQLGroupJoinState) obj);
            } else if ("visibility".equals(str)) {
                m1535a((GraphQLGroupVisibility) obj);
            }
        }

        @Nullable
        private CoverPhotoModel m1536j() {
            this.f1087d = (CoverPhotoModel) super.a(this.f1087d, 0, CoverPhotoModel.class);
            return this.f1087d;
        }

        @Nullable
        private GroupFriendMembersModel m1537k() {
            this.f1088e = (GroupFriendMembersModel) super.a(this.f1088e, 1, GroupFriendMembersModel.class);
            return this.f1088e;
        }

        @Nullable
        private GroupMembersModel m1538l() {
            this.f1089f = (GroupMembersModel) super.a(this.f1089f, 2, GroupMembersModel.class);
            return this.f1089f;
        }

        @Nullable
        private String m1539m() {
            this.f1090g = super.a(this.f1090g, 3);
            return this.f1090g;
        }

        @Nullable
        private ViewerInviteToGroupModel m1540n() {
            this.f1091h = (ViewerInviteToGroupModel) super.a(this.f1091h, 4, ViewerInviteToGroupModel.class);
            return this.f1091h;
        }

        @Nullable
        private GraphQLGroupJoinState m1541o() {
            this.f1092i = (GraphQLGroupJoinState) super.b(this.f1092i, 5, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1092i;
        }

        private void m1534a(GraphQLGroupJoinState graphQLGroupJoinState) {
            this.f1092i = graphQLGroupJoinState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
            }
        }

        @Nullable
        private GraphQLGroupVisibility m1542p() {
            this.f1093j = (GraphQLGroupVisibility) super.b(this.f1093j, 6, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1093j;
        }

        private void m1535a(GraphQLGroupVisibility graphQLGroupVisibility) {
            this.f1093j = graphQLGroupVisibility;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 6, graphQLGroupVisibility != null ? graphQLGroupVisibility.name() : null);
            }
        }

        @Nullable
        public final String m1545a() {
            return m1539m();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m1544a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1536j() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m1536j());
                if (m1536j() != coverPhotoModel) {
                    graphQLVisitableModel = (GroupFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1087d = coverPhotoModel;
                }
            }
            if (m1537k() != null) {
                GroupFriendMembersModel groupFriendMembersModel = (GroupFriendMembersModel) graphQLModelMutatingVisitor.b(m1537k());
                if (m1537k() != groupFriendMembersModel) {
                    graphQLVisitableModel = (GroupFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1088e = groupFriendMembersModel;
                }
            }
            if (m1538l() != null) {
                GroupMembersModel groupMembersModel = (GroupMembersModel) graphQLModelMutatingVisitor.b(m1538l());
                if (m1538l() != groupMembersModel) {
                    graphQLVisitableModel = (GroupFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1089f = groupMembersModel;
                }
            }
            if (m1540n() != null) {
                ViewerInviteToGroupModel viewerInviteToGroupModel = (ViewerInviteToGroupModel) graphQLModelMutatingVisitor.b(m1540n());
                if (m1540n() != viewerInviteToGroupModel) {
                    graphQLVisitableModel = (GroupFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1091h = viewerInviteToGroupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1543a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1536j());
            int a2 = ModelHelper.a(flatBufferBuilder, m1537k());
            int a3 = ModelHelper.a(flatBufferBuilder, m1538l());
            int b = flatBufferBuilder.b(m1539m());
            int a4 = ModelHelper.a(flatBufferBuilder, m1540n());
            int a5 = flatBufferBuilder.a(m1541o());
            int a6 = flatBufferBuilder.a(m1542p());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 321755292)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoTirmStartTimeMs */
    public final class MessageEventFragmentModel extends BaseModel implements GraphQLVisitableModel, MessageEventFragment {
        private long f1104d;
        @Nullable
        private EventCoordinatesModel f1105e;
        @Nullable
        private EventPlaceModel f1106f;
        @Nullable
        private String f1107g;
        private boolean f1108h;
        private long f1109i;

        /* compiled from: videoTirmStartTimeMs */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessageEventFragmentModel.class, new Deserializer());
            }

            public Object m1548a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MessageEventFragmentParser.m1803a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object messageEventFragmentModel = new MessageEventFragmentModel();
                ((BaseModel) messageEventFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (messageEventFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) messageEventFragmentModel).a();
                }
                return messageEventFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 918622653)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class EventCoordinatesModel extends BaseModel implements GraphQLVisitableModel {
            private double f1096d;
            private double f1097e;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                public double f1094a;
                public double f1095b;

                public final EventCoordinatesModel m1549a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f1094a, 0.0d);
                    flatBufferBuilder.a(1, this.f1095b, 0.0d);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventCoordinatesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventCoordinatesModel.class, new Deserializer());
                }

                public Object m1550a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventCoordinatesParser.m1799a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventCoordinatesModel = new EventCoordinatesModel();
                    ((BaseModel) eventCoordinatesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventCoordinatesModel instanceof Postprocessable) {
                        return ((Postprocessable) eventCoordinatesModel).a();
                    }
                    return eventCoordinatesModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<EventCoordinatesModel> {
                public final void m1551a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventCoordinatesModel eventCoordinatesModel = (EventCoordinatesModel) obj;
                    if (eventCoordinatesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventCoordinatesModel.m1554a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventCoordinatesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventCoordinatesParser.m1800a(eventCoordinatesModel.w_(), eventCoordinatesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventCoordinatesModel.class, new Serializer());
                }
            }

            public EventCoordinatesModel() {
                super(2);
            }

            public EventCoordinatesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final double m1553a() {
                a(0, 0);
                return this.f1096d;
            }

            public final double m1557b() {
                a(0, 1);
                return this.f1097e;
            }

            public static EventCoordinatesModel m1552a(EventCoordinatesModel eventCoordinatesModel) {
                if (eventCoordinatesModel == null) {
                    return null;
                }
                if (eventCoordinatesModel instanceof EventCoordinatesModel) {
                    return eventCoordinatesModel;
                }
                Builder builder = new Builder();
                builder.f1094a = eventCoordinatesModel.m1553a();
                builder.f1095b = eventCoordinatesModel.m1557b();
                return builder.m1549a();
            }

            public final int jK_() {
                return 1965687765;
            }

            public final GraphQLVisitableModel m1555a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1554a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f1096d, 0.0d);
                flatBufferBuilder.a(1, this.f1097e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1556a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1096d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f1097e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class EventPlaceModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f1101d;
            @Nullable
            private String f1102e;
            @Nullable
            private String f1103f;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f1098a;
                @Nullable
                public String f1099b;
                @Nullable
                public String f1100c;

                public final EventPlaceModel m1558a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f1098a);
                    int b = flatBufferBuilder.b(this.f1099b);
                    int b2 = flatBufferBuilder.b(this.f1100c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventPlaceModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventPlaceModel.class, new Deserializer());
                }

                public Object m1559a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventPlaceParser.m1801a(jsonParser, flatBufferBuilder));
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

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<EventPlaceModel> {
                public final void m1560a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventPlaceModel eventPlaceModel = (EventPlaceModel) obj;
                    if (eventPlaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventPlaceModel.m1563a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventPlaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventPlaceParser.m1802a(eventPlaceModel.w_(), eventPlaceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventPlaceModel.class, new Serializer());
                }
            }

            public EventPlaceModel() {
                super(3);
            }

            public EventPlaceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m1566a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = m1570d();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m1567a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m1562a((String) obj);
                }
            }

            @Nullable
            public final GraphQLObjectType m1568b() {
                if (this.b != null && this.f1101d == null) {
                    this.f1101d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1101d;
            }

            @Nullable
            public final String m1569c() {
                this.f1102e = super.a(this.f1102e, 1);
                return this.f1102e;
            }

            @Nullable
            public final String m1570d() {
                this.f1103f = super.a(this.f1103f, 2);
                return this.f1103f;
            }

            private void m1562a(@Nullable String str) {
                this.f1103f = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, str);
                }
            }

            public static EventPlaceModel m1561a(EventPlaceModel eventPlaceModel) {
                if (eventPlaceModel == null) {
                    return null;
                }
                if (eventPlaceModel instanceof EventPlaceModel) {
                    return eventPlaceModel;
                }
                Builder builder = new Builder();
                builder.f1098a = eventPlaceModel.m1568b();
                builder.f1099b = eventPlaceModel.m1569c();
                builder.f1100c = eventPlaceModel.m1570d();
                return builder.m1558a();
            }

            @Nullable
            public final String m1565a() {
                return m1569c();
            }

            public final int jK_() {
                return 77195495;
            }

            public final GraphQLVisitableModel m1564a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1563a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1568b());
                int b = flatBufferBuilder.b(m1569c());
                int b2 = flatBufferBuilder.b(m1570d());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Serializer extends JsonSerializer<MessageEventFragmentModel> {
            public final void m1571a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MessageEventFragmentModel messageEventFragmentModel = (MessageEventFragmentModel) obj;
                if (messageEventFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messageEventFragmentModel.m1575a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messageEventFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MessageEventFragmentParser.m1804a(messageEventFragmentModel.w_(), messageEventFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MessageEventFragmentModel.class, new Serializer());
            }
        }

        public MessageEventFragmentModel() {
            super(6);
        }

        @Nullable
        private EventCoordinatesModel m1572a() {
            this.f1105e = (EventCoordinatesModel) super.a(this.f1105e, 1, EventCoordinatesModel.class);
            return this.f1105e;
        }

        @Nullable
        private EventPlaceModel m1573j() {
            this.f1106f = (EventPlaceModel) super.a(this.f1106f, 2, EventPlaceModel.class);
            return this.f1106f;
        }

        @Nullable
        private String m1574k() {
            this.f1107g = super.a(this.f1107g, 3);
            return this.f1107g;
        }

        public final int jK_() {
            return -1145715981;
        }

        public final GraphQLVisitableModel m1576a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1572a() != null) {
                EventCoordinatesModel eventCoordinatesModel = (EventCoordinatesModel) graphQLModelMutatingVisitor.b(m1572a());
                if (m1572a() != eventCoordinatesModel) {
                    graphQLVisitableModel = (MessageEventFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1105e = eventCoordinatesModel;
                }
            }
            if (m1573j() != null) {
                EventPlaceModel eventPlaceModel = (EventPlaceModel) graphQLModelMutatingVisitor.b(m1573j());
                if (m1573j() != eventPlaceModel) {
                    graphQLVisitableModel = (MessageEventFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1106f = eventPlaceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1575a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1572a());
            int a2 = ModelHelper.a(flatBufferBuilder, m1573j());
            int b = flatBufferBuilder.b(m1574k());
            flatBufferBuilder.c(6);
            flatBufferBuilder.a(0, this.f1104d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.a(4, this.f1108h);
            flatBufferBuilder.a(5, this.f1109i, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1577a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1104d = mutableFlatBuffer.a(i, 0, 0);
            this.f1108h = mutableFlatBuffer.a(i, 4);
            this.f1109i = mutableFlatBuffer.a(i, 5, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2073064542)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoTirmStartTimeMs */
    public final class MessageLocationFragmentModel extends BaseModel implements GraphQLVisitableModel, MessageLocationFragment {
        @Nullable
        private CoordinatesModel f1118d;
        private boolean f1119e;
        @Nullable
        private PlaceModel f1120f;
        @Nullable
        private String f1121g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 918622653)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class CoordinatesModel extends BaseModel implements GraphQLVisitableModel {
            private double f1112d;
            private double f1113e;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                public double f1110a;
                public double f1111b;

                public final CoordinatesModel m1578a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f1110a, 0.0d);
                    flatBufferBuilder.a(1, this.f1111b, 0.0d);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new CoordinatesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoordinatesModel.class, new Deserializer());
                }

                public Object m1579a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoordinatesParser.m1805a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object coordinatesModel = new CoordinatesModel();
                    ((BaseModel) coordinatesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (coordinatesModel instanceof Postprocessable) {
                        return ((Postprocessable) coordinatesModel).a();
                    }
                    return coordinatesModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<CoordinatesModel> {
                public final void m1580a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoordinatesModel coordinatesModel = (CoordinatesModel) obj;
                    if (coordinatesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coordinatesModel.m1583a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coordinatesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoordinatesParser.m1806a(coordinatesModel.w_(), coordinatesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CoordinatesModel.class, new Serializer());
                }
            }

            public CoordinatesModel() {
                super(2);
            }

            public CoordinatesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final double m1582a() {
                a(0, 0);
                return this.f1112d;
            }

            public final double m1586b() {
                a(0, 1);
                return this.f1113e;
            }

            public static CoordinatesModel m1581a(CoordinatesModel coordinatesModel) {
                if (coordinatesModel == null) {
                    return null;
                }
                if (coordinatesModel instanceof CoordinatesModel) {
                    return coordinatesModel;
                }
                Builder builder = new Builder();
                builder.f1110a = coordinatesModel.m1582a();
                builder.f1111b = coordinatesModel.m1586b();
                return builder.m1578a();
            }

            public final int jK_() {
                return 1965687765;
            }

            public final GraphQLVisitableModel m1584a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1583a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f1112d, 0.0d);
                flatBufferBuilder.a(1, this.f1113e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1585a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1112d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f1113e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessageLocationFragmentModel.class, new Deserializer());
            }

            public Object m1587a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MessageLocationFragmentParser.m1809a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object messageLocationFragmentModel = new MessageLocationFragmentModel();
                ((BaseModel) messageLocationFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (messageLocationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) messageLocationFragmentModel).a();
                }
                return messageLocationFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class PlaceModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f1116d;
            @Nullable
            private String f1117e;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f1114a;
                @Nullable
                public String f1115b;

                public final PlaceModel m1588a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f1114a);
                    int b = flatBufferBuilder.b(this.f1115b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PlaceModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceModel.class, new Deserializer());
                }

                public Object m1589a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceParser.m1807a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeModel = new PlaceModel();
                    ((BaseModel) placeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeModel instanceof Postprocessable) {
                        return ((Postprocessable) placeModel).a();
                    }
                    return placeModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<PlaceModel> {
                public final void m1590a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceModel placeModel = (PlaceModel) obj;
                    if (placeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeModel.m1592a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceParser.m1808a(placeModel.w_(), placeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlaceModel.class, new Serializer());
                }
            }

            public PlaceModel() {
                super(2);
            }

            public PlaceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m1595a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1596a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m1597b() {
                if (this.b != null && this.f1116d == null) {
                    this.f1116d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1116d;
            }

            @Nullable
            public final String m1598c() {
                this.f1117e = super.a(this.f1117e, 1);
                return this.f1117e;
            }

            public static PlaceModel m1591a(PlaceModel placeModel) {
                if (placeModel == null) {
                    return null;
                }
                if (placeModel instanceof PlaceModel) {
                    return placeModel;
                }
                Builder builder = new Builder();
                builder.f1114a = placeModel.m1597b();
                builder.f1115b = placeModel.m1598c();
                return builder.m1588a();
            }

            @Nullable
            public final String m1594a() {
                return m1598c();
            }

            public final int jK_() {
                return 77195495;
            }

            public final GraphQLVisitableModel m1593a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1592a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1597b());
                int b = flatBufferBuilder.b(m1598c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Serializer extends JsonSerializer<MessageLocationFragmentModel> {
            public final void m1599a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessageLocationFragmentModel messageLocationFragmentModel = (MessageLocationFragmentModel) obj;
                if (messageLocationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messageLocationFragmentModel.m1603a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messageLocationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messageLocationFragmentModel.w_();
                int u_ = messageLocationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("coordinates");
                    CoordinatesParser.m1806a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("is_current_location");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("place");
                    PlaceParser.m1808a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessageLocationFragmentModel.class, new Serializer());
            }
        }

        public MessageLocationFragmentModel() {
            super(4);
        }

        @Nullable
        private CoordinatesModel m1600a() {
            this.f1118d = (CoordinatesModel) super.a(this.f1118d, 0, CoordinatesModel.class);
            return this.f1118d;
        }

        @Nullable
        private PlaceModel m1601j() {
            this.f1120f = (PlaceModel) super.a(this.f1120f, 2, PlaceModel.class);
            return this.f1120f;
        }

        @Nullable
        private String m1602k() {
            this.f1121g = super.a(this.f1121g, 3);
            return this.f1121g;
        }

        public final int jK_() {
            return 1703331004;
        }

        public final GraphQLVisitableModel m1604a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1600a() != null) {
                CoordinatesModel coordinatesModel = (CoordinatesModel) graphQLModelMutatingVisitor.b(m1600a());
                if (m1600a() != coordinatesModel) {
                    graphQLVisitableModel = (MessageLocationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1118d = coordinatesModel;
                }
            }
            if (m1601j() != null) {
                PlaceModel placeModel = (PlaceModel) graphQLModelMutatingVisitor.b(m1601j());
                if (m1601j() != placeModel) {
                    graphQLVisitableModel = (MessageLocationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1120f = placeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1603a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1600a());
            int a2 = ModelHelper.a(flatBufferBuilder, m1601j());
            int b = flatBufferBuilder.b(m1602k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f1119e);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1605a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1119e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1070384690)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoTirmStartTimeMs */
    public final class MomentsAppInvitationActionLinkFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLMomentsAppMessengerInviteActionType f1129d;
        @Nullable
        private String f1130e;
        @Nullable
        private String f1131f;
        @Nullable
        private String f1132g;
        @Nullable
        private String f1133h;
        @Nullable
        private String f1134i;
        @Nullable
        private String f1135j;

        /* compiled from: videoTirmStartTimeMs */
        public final class Builder {
            @Nullable
            public GraphQLMomentsAppMessengerInviteActionType f1122a;
            @Nullable
            public String f1123b;
            @Nullable
            public String f1124c;
            @Nullable
            public String f1125d;
            @Nullable
            public String f1126e;
            @Nullable
            public String f1127f;
            @Nullable
            public String f1128g;

            public final MomentsAppInvitationActionLinkFragmentModel m1606a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = flatBufferBuilder.a(this.f1122a);
                int b = flatBufferBuilder.b(this.f1123b);
                int b2 = flatBufferBuilder.b(this.f1124c);
                int b3 = flatBufferBuilder.b(this.f1125d);
                int b4 = flatBufferBuilder.b(this.f1126e);
                int b5 = flatBufferBuilder.b(this.f1127f);
                int b6 = flatBufferBuilder.b(this.f1128g);
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                flatBufferBuilder.b(4, b4);
                flatBufferBuilder.b(5, b5);
                flatBufferBuilder.b(6, b6);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MomentsAppInvitationActionLinkFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MomentsAppInvitationActionLinkFragmentModel.class, new Deserializer());
            }

            public Object m1607a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MomentsAppInvitationActionLinkFragmentParser.m1813b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object momentsAppInvitationActionLinkFragmentModel = new MomentsAppInvitationActionLinkFragmentModel();
                ((BaseModel) momentsAppInvitationActionLinkFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (momentsAppInvitationActionLinkFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) momentsAppInvitationActionLinkFragmentModel).a();
                }
                return momentsAppInvitationActionLinkFragmentModel;
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Serializer extends JsonSerializer<MomentsAppInvitationActionLinkFragmentModel> {
            public final void m1608a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MomentsAppInvitationActionLinkFragmentModel momentsAppInvitationActionLinkFragmentModel = (MomentsAppInvitationActionLinkFragmentModel) obj;
                if (momentsAppInvitationActionLinkFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(momentsAppInvitationActionLinkFragmentModel.m1610a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    momentsAppInvitationActionLinkFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MomentsAppInvitationActionLinkFragmentParser.m1811a(momentsAppInvitationActionLinkFragmentModel.w_(), momentsAppInvitationActionLinkFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(MomentsAppInvitationActionLinkFragmentModel.class, new Serializer());
            }
        }

        public MomentsAppInvitationActionLinkFragmentModel() {
            super(7);
        }

        public MomentsAppInvitationActionLinkFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(7);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLMomentsAppMessengerInviteActionType m1611a() {
            this.f1129d = (GraphQLMomentsAppMessengerInviteActionType) super.b(this.f1129d, 0, GraphQLMomentsAppMessengerInviteActionType.class, GraphQLMomentsAppMessengerInviteActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1129d;
        }

        @Nullable
        public final String m1613b() {
            this.f1130e = super.a(this.f1130e, 1);
            return this.f1130e;
        }

        @Nullable
        public final String m1614c() {
            this.f1131f = super.a(this.f1131f, 2);
            return this.f1131f;
        }

        @Nullable
        public final String m1615d() {
            this.f1132g = super.a(this.f1132g, 3);
            return this.f1132g;
        }

        @Nullable
        public final String aI_() {
            this.f1133h = super.a(this.f1133h, 4);
            return this.f1133h;
        }

        @Nullable
        public final String m1616g() {
            this.f1134i = super.a(this.f1134i, 5);
            return this.f1134i;
        }

        @Nullable
        public final String aJ_() {
            this.f1135j = super.a(this.f1135j, 6);
            return this.f1135j;
        }

        public static MomentsAppInvitationActionLinkFragmentModel m1609a(MomentsAppInvitationActionLinkFragmentModel momentsAppInvitationActionLinkFragmentModel) {
            if (momentsAppInvitationActionLinkFragmentModel == null) {
                return null;
            }
            if (momentsAppInvitationActionLinkFragmentModel instanceof MomentsAppInvitationActionLinkFragmentModel) {
                return momentsAppInvitationActionLinkFragmentModel;
            }
            Builder builder = new Builder();
            builder.f1122a = momentsAppInvitationActionLinkFragmentModel.m1611a();
            builder.f1123b = momentsAppInvitationActionLinkFragmentModel.m1613b();
            builder.f1124c = momentsAppInvitationActionLinkFragmentModel.m1614c();
            builder.f1125d = momentsAppInvitationActionLinkFragmentModel.m1615d();
            builder.f1126e = momentsAppInvitationActionLinkFragmentModel.aI_();
            builder.f1127f = momentsAppInvitationActionLinkFragmentModel.m1616g();
            builder.f1128g = momentsAppInvitationActionLinkFragmentModel.aJ_();
            return builder.m1606a();
        }

        public final int jK_() {
            return 1233518910;
        }

        public final GraphQLVisitableModel m1612a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m1610a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m1611a());
            int b = flatBufferBuilder.b(m1613b());
            int b2 = flatBufferBuilder.b(m1614c());
            int b3 = flatBufferBuilder.b(m1615d());
            int b4 = flatBufferBuilder.b(aI_());
            int b5 = flatBufferBuilder.b(m1616g());
            int b6 = flatBufferBuilder.b(aJ_());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, b4);
            flatBufferBuilder.b(5, b5);
            flatBufferBuilder.b(6, b6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1670321109)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoTirmStartTimeMs */
    public final class PeerToPeerPaymentRequestFragmentModel extends BaseModel implements GraphQLVisitableModel, PeerToPeerPaymentRequestFragment {
        @Nullable
        private AmountModel f1146d;
        @Nullable
        private String f1147e;
        @Nullable
        private RequesteeModel f1148f;
        @Nullable
        private RequesterModel f1149g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -931469746)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class AmountModel extends BaseModel implements GraphQLVisitableModel, Amount {
            @Nullable
            private String f1136d;
            @Nullable
            private String f1137e;

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AmountModel.class, new Deserializer());
                }

                public Object m1617a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AmountParser.m1814a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object amountModel = new AmountModel();
                    ((BaseModel) amountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (amountModel instanceof Postprocessable) {
                        return ((Postprocessable) amountModel).a();
                    }
                    return amountModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<AmountModel> {
                public final void m1618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AmountModel amountModel = (AmountModel) obj;
                    if (amountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(amountModel.m1619a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        amountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AmountParser.m1815a(amountModel.w_(), amountModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AmountModel.class, new Serializer());
                }
            }

            public AmountModel() {
                super(2);
            }

            @Nullable
            public final String mo116a() {
                this.f1136d = super.a(this.f1136d, 0);
                return this.f1136d;
            }

            @Nullable
            public final String mo117b() {
                this.f1137e = super.a(this.f1137e, 1);
                return this.f1137e;
            }

            public final int jK_() {
                return 753818588;
            }

            public final GraphQLVisitableModel m1620a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1619a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo116a());
                int b2 = flatBufferBuilder.b(mo117b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PeerToPeerPaymentRequestFragmentModel.class, new Deserializer());
            }

            public Object m1623a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PeerToPeerPaymentRequestFragmentParser.m1820a(jsonParser);
                Object peerToPeerPaymentRequestFragmentModel = new PeerToPeerPaymentRequestFragmentModel();
                ((BaseModel) peerToPeerPaymentRequestFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (peerToPeerPaymentRequestFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) peerToPeerPaymentRequestFragmentModel).a();
                }
                return peerToPeerPaymentRequestFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1247803938)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class RequesteeModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f1140d;
            @Nullable
            private String f1141e;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f1138a;
                @Nullable
                public String f1139b;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RequesteeModel.class, new Deserializer());
                }

                public Object m1624a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RequesteeParser.m1816a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object requesteeModel = new RequesteeModel();
                    ((BaseModel) requesteeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (requesteeModel instanceof Postprocessable) {
                        return ((Postprocessable) requesteeModel).a();
                    }
                    return requesteeModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<RequesteeModel> {
                public final void m1625a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RequesteeModel requesteeModel = (RequesteeModel) obj;
                    if (requesteeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(requesteeModel.m1627a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        requesteeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RequesteeParser.m1817a(requesteeModel.w_(), requesteeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RequesteeModel.class, new Serializer());
                }
            }

            public RequesteeModel() {
                super(2);
            }

            public RequesteeModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m1630a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1631a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m1628a() {
                if (this.b != null && this.f1140d == null) {
                    this.f1140d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1140d;
            }

            @Nullable
            public final String m1632b() {
                this.f1141e = super.a(this.f1141e, 1);
                return this.f1141e;
            }

            public static RequesteeModel m1626a(RequesteeModel requesteeModel) {
                if (requesteeModel == null) {
                    return null;
                }
                if (requesteeModel instanceof RequesteeModel) {
                    return requesteeModel;
                }
                Builder builder = new Builder();
                builder.f1138a = requesteeModel.m1628a();
                builder.f1139b = requesteeModel.m1632b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f1138a);
                int b = flatBufferBuilder.b(builder.f1139b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new RequesteeModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m1629a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1627a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1628a());
                int b = flatBufferBuilder.b(m1632b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -74048401)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class RequesterModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f1144d;
            @Nullable
            private String f1145e;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f1142a;
                @Nullable
                public String f1143b;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RequesterModel.class, new Deserializer());
                }

                public Object m1633a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RequesterParser.m1818a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object requesterModel = new RequesterModel();
                    ((BaseModel) requesterModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (requesterModel instanceof Postprocessable) {
                        return ((Postprocessable) requesterModel).a();
                    }
                    return requesterModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<RequesterModel> {
                public final void m1634a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RequesterModel requesterModel = (RequesterModel) obj;
                    if (requesterModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(requesterModel.m1636a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        requesterModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RequesterParser.m1819a(requesterModel.w_(), requesterModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RequesterModel.class, new Serializer());
                }
            }

            public RequesterModel() {
                super(2);
            }

            public RequesterModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m1639a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1640a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m1637a() {
                if (this.b != null && this.f1144d == null) {
                    this.f1144d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1144d;
            }

            @Nullable
            public final String m1641b() {
                this.f1145e = super.a(this.f1145e, 1);
                return this.f1145e;
            }

            public static RequesterModel m1635a(RequesterModel requesterModel) {
                if (requesterModel == null) {
                    return null;
                }
                if (requesterModel instanceof RequesterModel) {
                    return requesterModel;
                }
                Builder builder = new Builder();
                builder.f1142a = requesterModel.m1637a();
                builder.f1143b = requesterModel.m1641b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f1142a);
                int b = flatBufferBuilder.b(builder.f1143b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new RequesterModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m1638a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1636a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1637a());
                int b = flatBufferBuilder.b(m1641b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Serializer extends JsonSerializer<PeerToPeerPaymentRequestFragmentModel> {
            public final void m1642a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PeerToPeerPaymentRequestFragmentModel peerToPeerPaymentRequestFragmentModel = (PeerToPeerPaymentRequestFragmentModel) obj;
                if (peerToPeerPaymentRequestFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(peerToPeerPaymentRequestFragmentModel.m1650a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    peerToPeerPaymentRequestFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = peerToPeerPaymentRequestFragmentModel.w_();
                int u_ = peerToPeerPaymentRequestFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("amount");
                    AmountParser.m1815a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("payment_request_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("requestee");
                    RequesteeParser.m1817a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("requester");
                    RequesterParser.m1819a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PeerToPeerPaymentRequestFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ Amount mo118L() {
            return m1643a();
        }

        @Nullable
        public final /* synthetic */ RequesteeModel mo120N() {
            return m1644j();
        }

        @Nullable
        public final /* synthetic */ RequesterModel mo121O() {
            return m1645k();
        }

        public PeerToPeerPaymentRequestFragmentModel() {
            super(4);
        }

        @Nullable
        private AmountModel m1643a() {
            this.f1146d = (AmountModel) super.a(this.f1146d, 0, AmountModel.class);
            return this.f1146d;
        }

        @Nullable
        public final String mo119M() {
            this.f1147e = super.a(this.f1147e, 1);
            return this.f1147e;
        }

        @Nullable
        private RequesteeModel m1644j() {
            this.f1148f = (RequesteeModel) super.a(this.f1148f, 2, RequesteeModel.class);
            return this.f1148f;
        }

        @Nullable
        private RequesterModel m1645k() {
            this.f1149g = (RequesterModel) super.a(this.f1149g, 3, RequesterModel.class);
            return this.f1149g;
        }

        public final int jK_() {
            return -268249560;
        }

        public final GraphQLVisitableModel m1651a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1643a() != null) {
                AmountModel amountModel = (AmountModel) graphQLModelMutatingVisitor.b(m1643a());
                if (m1643a() != amountModel) {
                    graphQLVisitableModel = (PeerToPeerPaymentRequestFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1146d = amountModel;
                }
            }
            if (m1644j() != null) {
                RequesteeModel requesteeModel = (RequesteeModel) graphQLModelMutatingVisitor.b(m1644j());
                if (m1644j() != requesteeModel) {
                    graphQLVisitableModel = (PeerToPeerPaymentRequestFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1148f = requesteeModel;
                }
            }
            if (m1645k() != null) {
                RequesterModel requesterModel = (RequesterModel) graphQLModelMutatingVisitor.b(m1645k());
                if (m1645k() != requesterModel) {
                    graphQLVisitableModel = (PeerToPeerPaymentRequestFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1149g = requesterModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1650a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1643a());
            int b = flatBufferBuilder.b(mo119M());
            int a2 = ModelHelper.a(flatBufferBuilder, m1644j());
            int a3 = ModelHelper.a(flatBufferBuilder, m1645k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -731378713)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoTirmStartTimeMs */
    public final class PeerToPeerTransferFragmentModel extends BaseModel implements GraphQLVisitableModel, PeerToPeerTransferFragment {
        @Nullable
        private AmountModel f1156d;
        @Nullable
        private String f1157e;
        @Nullable
        private ReceiverModel f1158f;
        @Nullable
        private SenderModel f1159g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -931469746)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class AmountModel extends BaseModel implements GraphQLVisitableModel, PeerToPeerTransferFragment.Amount {
            @Nullable
            private String f1150d;
            @Nullable
            private String f1151e;

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AmountModel.class, new Deserializer());
                }

                public Object m1652a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PeerToPeerTransferFragmentParser.AmountParser.m1821a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object amountModel = new AmountModel();
                    ((BaseModel) amountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (amountModel instanceof Postprocessable) {
                        return ((Postprocessable) amountModel).a();
                    }
                    return amountModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<AmountModel> {
                public final void m1653a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AmountModel amountModel = (AmountModel) obj;
                    if (amountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(amountModel.m1654a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        amountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PeerToPeerTransferFragmentParser.AmountParser.m1822a(amountModel.w_(), amountModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AmountModel.class, new Serializer());
                }
            }

            public AmountModel() {
                super(2);
            }

            @Nullable
            public final String mo122a() {
                this.f1150d = super.a(this.f1150d, 0);
                return this.f1150d;
            }

            @Nullable
            public final String mo123b() {
                this.f1151e = super.a(this.f1151e, 1);
                return this.f1151e;
            }

            public final int jK_() {
                return 753818588;
            }

            public final GraphQLVisitableModel m1655a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1654a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo122a());
                int b2 = flatBufferBuilder.b(mo123b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PeerToPeerTransferFragmentModel.class, new Deserializer());
            }

            public Object m1658a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PeerToPeerTransferFragmentParser.m1827a(jsonParser);
                Object peerToPeerTransferFragmentModel = new PeerToPeerTransferFragmentModel();
                ((BaseModel) peerToPeerTransferFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (peerToPeerTransferFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) peerToPeerTransferFragmentModel).a();
                }
                return peerToPeerTransferFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1099415909)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class ReceiverModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f1153d;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public String f1152a;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReceiverModel.class, new Deserializer());
                }

                public Object m1659a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReceiverParser.m1823a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object receiverModel = new ReceiverModel();
                    ((BaseModel) receiverModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (receiverModel instanceof Postprocessable) {
                        return ((Postprocessable) receiverModel).a();
                    }
                    return receiverModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<ReceiverModel> {
                public final void m1660a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReceiverModel receiverModel = (ReceiverModel) obj;
                    if (receiverModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(receiverModel.m1662a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        receiverModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReceiverParser.m1824a(receiverModel.w_(), receiverModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ReceiverModel.class, new Serializer());
                }
            }

            public ReceiverModel() {
                super(1);
            }

            public ReceiverModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m1665a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1666a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m1664a() {
                this.f1153d = super.a(this.f1153d, 0);
                return this.f1153d;
            }

            public static ReceiverModel m1661a(ReceiverModel receiverModel) {
                if (receiverModel == null) {
                    return null;
                }
                if (receiverModel instanceof ReceiverModel) {
                    return receiverModel;
                }
                Builder builder = new Builder();
                builder.f1152a = receiverModel.m1664a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f1152a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReceiverModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m1663a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1662a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1664a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1954027784)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class SenderModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f1155d;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public String f1154a;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SenderModel.class, new Deserializer());
                }

                public Object m1667a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SenderParser.m1825a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object senderModel = new SenderModel();
                    ((BaseModel) senderModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (senderModel instanceof Postprocessable) {
                        return ((Postprocessable) senderModel).a();
                    }
                    return senderModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<SenderModel> {
                public final void m1668a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SenderModel senderModel = (SenderModel) obj;
                    if (senderModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(senderModel.m1670a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        senderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SenderParser.m1826a(senderModel.w_(), senderModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SenderModel.class, new Serializer());
                }
            }

            public SenderModel() {
                super(1);
            }

            public SenderModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m1673a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1674a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m1672a() {
                this.f1155d = super.a(this.f1155d, 0);
                return this.f1155d;
            }

            public static SenderModel m1669a(SenderModel senderModel) {
                if (senderModel == null) {
                    return null;
                }
                if (senderModel instanceof SenderModel) {
                    return senderModel;
                }
                Builder builder = new Builder();
                builder.f1154a = senderModel.m1672a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f1154a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SenderModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m1671a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1670a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1672a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Serializer extends JsonSerializer<PeerToPeerTransferFragmentModel> {
            public final void m1675a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PeerToPeerTransferFragmentModel peerToPeerTransferFragmentModel = (PeerToPeerTransferFragmentModel) obj;
                if (peerToPeerTransferFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(peerToPeerTransferFragmentModel.m1683a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    peerToPeerTransferFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = peerToPeerTransferFragmentModel.w_();
                int u_ = peerToPeerTransferFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("amount");
                    PeerToPeerTransferFragmentParser.AmountParser.m1822a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("payment_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("receiver");
                    ReceiverParser.m1824a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("sender");
                    SenderParser.m1826a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PeerToPeerTransferFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PeerToPeerTransferFragment.Amount mo124P() {
            return m1676a();
        }

        @Nullable
        public final /* synthetic */ ReceiverModel mo126R() {
            return m1677j();
        }

        @Nullable
        public final /* synthetic */ SenderModel mo127S() {
            return m1678k();
        }

        public PeerToPeerTransferFragmentModel() {
            super(4);
        }

        @Nullable
        private AmountModel m1676a() {
            this.f1156d = (AmountModel) super.a(this.f1156d, 0, AmountModel.class);
            return this.f1156d;
        }

        @Nullable
        public final String mo125Q() {
            this.f1157e = super.a(this.f1157e, 1);
            return this.f1157e;
        }

        @Nullable
        private ReceiverModel m1677j() {
            this.f1158f = (ReceiverModel) super.a(this.f1158f, 2, ReceiverModel.class);
            return this.f1158f;
        }

        @Nullable
        private SenderModel m1678k() {
            this.f1159g = (SenderModel) super.a(this.f1159g, 3, SenderModel.class);
            return this.f1159g;
        }

        public final int jK_() {
            return -1479052374;
        }

        public final GraphQLVisitableModel m1684a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1676a() != null) {
                AmountModel amountModel = (AmountModel) graphQLModelMutatingVisitor.b(m1676a());
                if (m1676a() != amountModel) {
                    graphQLVisitableModel = (PeerToPeerTransferFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1156d = amountModel;
                }
            }
            if (m1677j() != null) {
                ReceiverModel receiverModel = (ReceiverModel) graphQLModelMutatingVisitor.b(m1677j());
                if (m1677j() != receiverModel) {
                    graphQLVisitableModel = (PeerToPeerTransferFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1158f = receiverModel;
                }
            }
            if (m1678k() != null) {
                SenderModel senderModel = (SenderModel) graphQLModelMutatingVisitor.b(m1678k());
                if (m1678k() != senderModel) {
                    graphQLVisitableModel = (PeerToPeerTransferFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1159g = senderModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1683a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1676a());
            int b = flatBufferBuilder.b(mo125Q());
            int a2 = ModelHelper.a(flatBufferBuilder, m1677j());
            int a3 = ModelHelper.a(flatBufferBuilder, m1678k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1971371424)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: videoTirmStartTimeMs */
    public final class StoryAttachmentTargetFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, BusinessMessage, CommerceOrderCancellationBubble, CommerceOrderReceiptBubble, CommerceProductSubscriptionBubble, CommercePromotions, CommerceRetailItem, CommerceShipmentBubble, CommerceShipmentTrackingBubble, InvoicesFragment, FundraiserToCharityFragment, GroupFragment, MessageEventFragment, MessageLocationFragment, PeerToPeerPaymentRequestFragment, PeerToPeerTransferFragment, AgentItemReceiptBubble, AirlineBoardingPassBubble, AirlineConfirmationBubble, BusinessRideReceiptFragment {
        @Nullable
        private String f1230A;
        @Nullable
        private String f1231B;
        @Nullable
        private String f1232C;
        @Nullable
        private String f1233D;
        @Nullable
        private String f1234E;
        @Nullable
        private BusinessRideLocationModel f1235F;
        @Nullable
        private List<MovieButtonFragmentModel> f1236G;
        @Nullable
        private String f1237H;
        @Nullable
        private String f1238I;
        private double f1239J;
        @Nullable
        private String f1240K;
        private long f1241L;
        @Nullable
        private String f1242M;
        @Nullable
        private EventCoordinatesModel f1243N;
        @Nullable
        private GraphQLEventPrivacyType f1244O;
        @Nullable
        private EventPlaceModel f1245P;
        @Nullable
        private String f1246Q;
        @Nullable
        private String f1247R;
        @Nullable
        private String f1248S;
        @Nullable
        private AirlineFlightInfoModel f1249T;
        @Nullable
        private List<AirlineFlightInfoModel> f1250U;
        @Nullable
        private String f1251V;
        @Nullable
        private String f1252W;
        @Nullable
        private String f1253X;
        @Nullable
        private String f1254Y;
        @Nullable
        private FundraiserDetailedProgressTextModel f1255Z;
        @Nullable
        private PaymentModel aA;
        @Nullable
        private String aB;
        @Nullable
        private String aC;
        @Nullable
        private List<MomentsAppInvitationActionLinkFragmentModel> aD;
        @Nullable
        private PlaceModel aE;
        @Nullable
        private PlatformContextModel aF;
        @Nullable
        private MovieDetailsFragmentModel aG;
        @Nullable
        private String aH;
        @Nullable
        private String aI;
        @Nullable
        private String aJ;
        @Nullable
        private PromotionItemsModel aK;
        @Nullable
        private CommerceBaseOrderReceiptModel aL;
        @Nullable
        private String aM;
        @Nullable
        private String aN;
        @Nullable
        private ReceiverModel aO;
        @Nullable
        private RequesteeModel aP;
        @Nullable
        private RequesterModel aQ;
        @Nullable
        private RetailCarrierModel aR;
        @Nullable
        private RetailItemsModel aS;
        @Nullable
        private RetailShipmentItemsModel aT;
        @Nullable
        private String aU;
        @Nullable
        private RideProviderModel aV;
        @Nullable
        private List<MovieButtonFragmentModel> aW;
        @Nullable
        private String aX;
        @Nullable
        private String aY;
        @Nullable
        private SenderModel aZ;
        @Nullable
        private FundraiserForCharityTextModel aa;
        @Nullable
        private GroupFriendMembersModel ab;
        @Nullable
        private GroupMembersModel ac;
        @Nullable
        private String ad;
        @Nullable
        private String ae;
        private boolean af;
        private boolean ag;
        @Nullable
        private ItemModel ah;
        @Nullable
        private ItineraryLegsModel ai;
        @Nullable
        private String aj;
        @Nullable
        private LogoImageModel ak;
        @Nullable
        private MovieImageFragmentModel al;
        @Nullable
        private String am;
        @Nullable
        private CommerceLocationModel an;
        @Nullable
        private List<MovieDetailsFragmentModel> ao;
        @Nullable
        private GraphQLMovieBotMovieListStyle ap;
        @Nullable
        private String aq;
        @Nullable
        private String ar;
        @Nullable
        private String as;
        @Nullable
        private String at;
        @Nullable
        private PageModel au;
        @Nullable
        private PartnerLogoModel av;
        @Nullable
        private List<AirlinePassengerModel> aw;
        @Nullable
        private String ax;
        @Nullable
        private String ay;
        @Nullable
        private String az;
        @Nullable
        private TransactionPaymentModel bA;
        @Nullable
        private TransactionProductsModel bB;
        @Nullable
        private GraphQLPageProductTransactionOrderStatusEnum bC;
        @Nullable
        private String bD;
        private int bE;
        private int bF;
        @Nullable
        private String bG;
        @Nullable
        private String bH;
        @Nullable
        private String bI;
        @Nullable
        private String bJ;
        @Nullable
        private GraphQLEventGuestStatus bK;
        @Nullable
        private ViewerInviteToGroupModel bL;
        @Nullable
        private GraphQLGroupJoinState bM;
        @Nullable
        private GraphQLGroupVisibility bN;
        @Nullable
        private String ba;
        @Nullable
        private String bb;
        @Nullable
        private String bc;
        @Nullable
        private CommerceShipmentBubbleModel bd;
        @Nullable
        private GraphQLShipmentTrackingEventType be;
        @Nullable
        private ShipmentTrackingEventsModel bf;
        @Nullable
        private String bg;
        @Nullable
        private String bh;
        @Nullable
        private BusinessRideLocationModel bi;
        @Nullable
        private String bj;
        private long bk;
        @Nullable
        private String bl;
        @Nullable
        private GraphQLMessengerRetailItemStatus bm;
        @Nullable
        private CommerceLocationModel bn;
        @Nullable
        private SubscribedItemModel bo;
        @Nullable
        private String bp;
        @Nullable
        private List<MovieTheaterFragmentModel> bq;
        @Nullable
        private String br;
        @Nullable
        private String bs;
        @Nullable
        private String bt;
        @Nullable
        private String bu;
        @Nullable
        private String bv;
        @Nullable
        private String bw;
        @Nullable
        private String bx;
        @Nullable
        private String by;
        private int bz;
        @Nullable
        private GraphQLObjectType f1256d;
        @Nullable
        private AmountModel f1257e;
        @Nullable
        private String f1258f;
        @Nullable
        private BoardingPassesModel f1259g;
        @Nullable
        private String f1260h;
        @Nullable
        private String f1261i;
        @Nullable
        private String f1262j;
        @Nullable
        private GraphQLMessengerCommerceBubbleType f1263k;
        @Nullable
        private BusinessItemsModel f1264l;
        @Nullable
        private List<MomentsAppInvitationActionLinkFragmentModel> f1265m;
        @Nullable
        private List<PlatformCallToActionModel> f1266n;
        @Nullable
        private FundraiserToCharityFragmentModel f1267o;
        private boolean f1268p;
        @Nullable
        private CancelledItemsModel f1269q;
        @Nullable
        private String f1270r;
        @Nullable
        private String f1271s;
        @Nullable
        private String f1272t;
        @Nullable
        private CommerceLocationModel f1273u;
        @Nullable
        private CommerceLocationModel f1274v;
        @Nullable
        private GraphQLConnectionStyle f1275w;
        @Nullable
        private CoordinatesModel f1276x;
        @Nullable
        private CoverPhotoModel f1277y;
        @Nullable
        private String f1278z;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -931469746)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class AmountModel extends BaseModel implements GraphQLVisitableModel, Amount, PeerToPeerTransferFragment.Amount {
            @Nullable
            private String f1162d;
            @Nullable
            private String f1163e;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public String f1160a;
                @Nullable
                public String f1161b;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AmountModel.class, new Deserializer());
                }

                public Object m1685a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StoryAttachmentTargetFragmentParser.AmountParser.m1828a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object amountModel = new AmountModel();
                    ((BaseModel) amountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (amountModel instanceof Postprocessable) {
                        return ((Postprocessable) amountModel).a();
                    }
                    return amountModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<AmountModel> {
                public final void m1686a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AmountModel amountModel = (AmountModel) obj;
                    if (amountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(amountModel.m1688a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        amountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StoryAttachmentTargetFragmentParser.AmountParser.m1829a(amountModel.w_(), amountModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AmountModel.class, new Serializer());
                }
            }

            public AmountModel() {
                super(2);
            }

            public AmountModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String mo116a() {
                this.f1162d = super.a(this.f1162d, 0);
                return this.f1162d;
            }

            @Nullable
            public final String mo123b() {
                this.f1163e = super.a(this.f1163e, 1);
                return this.f1163e;
            }

            public static AmountModel m1687a(AmountModel amountModel) {
                if (amountModel == null) {
                    return null;
                }
                if (amountModel instanceof AmountModel) {
                    return amountModel;
                }
                Builder builder = new Builder();
                builder.f1160a = amountModel.mo116a();
                builder.f1161b = amountModel.mo123b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f1160a);
                int b2 = flatBufferBuilder.b(builder.f1161b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AmountModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 753818588;
            }

            public final GraphQLVisitableModel m1689a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1688a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo116a());
                int b2 = flatBufferBuilder.b(mo123b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public final class Builder {
            @Nullable
            public String f1164A;
            @Nullable
            public String f1165B;
            @Nullable
            public BusinessRideLocationModel f1166C;
            @Nullable
            public ImmutableList<MovieButtonFragmentModel> f1167D;
            @Nullable
            public String f1168E;
            @Nullable
            public String f1169F;
            public double f1170G;
            @Nullable
            public String f1171H;
            public long f1172I;
            @Nullable
            public String f1173J;
            @Nullable
            public EventCoordinatesModel f1174K;
            @Nullable
            public GraphQLEventPrivacyType f1175L;
            @Nullable
            public EventPlaceModel f1176M;
            @Nullable
            public String f1177N;
            @Nullable
            public String f1178O;
            @Nullable
            public String f1179P;
            @Nullable
            public AirlineFlightInfoModel f1180Q;
            @Nullable
            public ImmutableList<AirlineFlightInfoModel> f1181R;
            @Nullable
            public String f1182S;
            @Nullable
            public String f1183T;
            @Nullable
            public String f1184U;
            @Nullable
            public String f1185V;
            @Nullable
            public FundraiserDetailedProgressTextModel f1186W;
            @Nullable
            public FundraiserForCharityTextModel f1187X;
            @Nullable
            public GroupFriendMembersModel f1188Y;
            @Nullable
            public GroupMembersModel f1189Z;
            @Nullable
            public GraphQLObjectType f1190a;
            @Nullable
            public ImmutableList<MomentsAppInvitationActionLinkFragmentModel> aA;
            @Nullable
            public PlaceModel aB;
            @Nullable
            public PlatformContextModel aC;
            @Nullable
            public MovieDetailsFragmentModel aD;
            @Nullable
            public String aE;
            @Nullable
            public String aF;
            @Nullable
            public String aG;
            @Nullable
            public PromotionItemsModel aH;
            @Nullable
            public CommerceBaseOrderReceiptModel aI;
            @Nullable
            public String aJ;
            @Nullable
            public String aK;
            @Nullable
            public ReceiverModel aL;
            @Nullable
            public RequesteeModel aM;
            @Nullable
            public RequesterModel aN;
            @Nullable
            public RetailCarrierModel aO;
            @Nullable
            public RetailItemsModel aP;
            @Nullable
            public RetailShipmentItemsModel aQ;
            @Nullable
            public String aR;
            @Nullable
            public RideProviderModel aS;
            @Nullable
            public ImmutableList<MovieButtonFragmentModel> aT;
            @Nullable
            public String aU;
            @Nullable
            public String aV;
            @Nullable
            public SenderModel aW;
            @Nullable
            public String aX;
            @Nullable
            public String aY;
            @Nullable
            public String aZ;
            @Nullable
            public String aa;
            @Nullable
            public String ab;
            public boolean ac;
            public boolean ad;
            @Nullable
            public ItemModel ae;
            @Nullable
            public ItineraryLegsModel af;
            @Nullable
            public String ag;
            @Nullable
            public LogoImageModel ah;
            @Nullable
            public MovieImageFragmentModel ai;
            @Nullable
            public String aj;
            @Nullable
            public CommerceLocationModel ak;
            @Nullable
            public ImmutableList<MovieDetailsFragmentModel> al;
            @Nullable
            public GraphQLMovieBotMovieListStyle am;
            @Nullable
            public String an;
            @Nullable
            public String ao;
            @Nullable
            public String ap;
            @Nullable
            public String aq;
            @Nullable
            public PageModel ar;
            @Nullable
            public PartnerLogoModel as;
            @Nullable
            public ImmutableList<AirlinePassengerModel> at;
            @Nullable
            public String au;
            @Nullable
            public String av;
            @Nullable
            public String aw;
            @Nullable
            public PaymentModel ax;
            @Nullable
            public String ay;
            @Nullable
            public String az;
            @Nullable
            public AmountModel f1191b;
            @Nullable
            public String bA;
            public int bB;
            public int bC;
            @Nullable
            public String bD;
            @Nullable
            public String bE;
            @Nullable
            public String bF;
            @Nullable
            public String bG;
            @Nullable
            public GraphQLEventGuestStatus bH;
            @Nullable
            public ViewerInviteToGroupModel bI;
            @Nullable
            public GraphQLGroupJoinState bJ;
            @Nullable
            public GraphQLGroupVisibility bK;
            @Nullable
            public CommerceShipmentBubbleModel ba;
            @Nullable
            public GraphQLShipmentTrackingEventType bb;
            @Nullable
            public ShipmentTrackingEventsModel bc;
            @Nullable
            public String bd;
            @Nullable
            public String be;
            @Nullable
            public BusinessRideLocationModel bf;
            @Nullable
            public String bg;
            public long bh;
            @Nullable
            public String bi;
            @Nullable
            public GraphQLMessengerRetailItemStatus bj;
            @Nullable
            public CommerceLocationModel bk;
            @Nullable
            public SubscribedItemModel bl;
            @Nullable
            public String bm;
            @Nullable
            public ImmutableList<MovieTheaterFragmentModel> bn;
            @Nullable
            public String bo;
            @Nullable
            public String bp;
            @Nullable
            public String bq;
            @Nullable
            public String br;
            @Nullable
            public String bs;
            @Nullable
            public String bt;
            @Nullable
            public String bu;
            @Nullable
            public String bv;
            public int bw;
            @Nullable
            public TransactionPaymentModel bx;
            @Nullable
            public TransactionProductsModel by;
            @Nullable
            public GraphQLPageProductTransactionOrderStatusEnum bz;
            @Nullable
            public String f1192c;
            @Nullable
            public BoardingPassesModel f1193d;
            @Nullable
            public String f1194e;
            @Nullable
            public String f1195f;
            @Nullable
            public String f1196g;
            @Nullable
            public GraphQLMessengerCommerceBubbleType f1197h;
            @Nullable
            public BusinessItemsModel f1198i;
            @Nullable
            public ImmutableList<MomentsAppInvitationActionLinkFragmentModel> f1199j;
            @Nullable
            public ImmutableList<PlatformCallToActionModel> f1200k;
            @Nullable
            public FundraiserToCharityFragmentModel f1201l;
            public boolean f1202m;
            @Nullable
            public CancelledItemsModel f1203n;
            @Nullable
            public String f1204o;
            @Nullable
            public String f1205p;
            @Nullable
            public String f1206q;
            @Nullable
            public CommerceLocationModel f1207r;
            @Nullable
            public CommerceLocationModel f1208s;
            @Nullable
            public GraphQLConnectionStyle f1209t;
            @Nullable
            public CoordinatesModel f1210u;
            @Nullable
            public CoverPhotoModel f1211v;
            @Nullable
            public String f1212w;
            @Nullable
            public String f1213x;
            @Nullable
            public String f1214y;
            @Nullable
            public String f1215z;

            public final StoryAttachmentTargetFragmentModel m1692a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f1190a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f1191b);
                int b = flatBufferBuilder.b(this.f1192c);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f1193d);
                int b2 = flatBufferBuilder.b(this.f1194e);
                int b3 = flatBufferBuilder.b(this.f1195f);
                int b4 = flatBufferBuilder.b(this.f1196g);
                int a4 = flatBufferBuilder.a(this.f1197h);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f1198i);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f1199j);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f1200k);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f1201l);
                int a9 = ModelHelper.a(flatBufferBuilder, this.f1203n);
                int b5 = flatBufferBuilder.b(this.f1204o);
                int b6 = flatBufferBuilder.b(this.f1205p);
                int b7 = flatBufferBuilder.b(this.f1206q);
                int a10 = ModelHelper.a(flatBufferBuilder, this.f1207r);
                int a11 = ModelHelper.a(flatBufferBuilder, this.f1208s);
                int a12 = flatBufferBuilder.a(this.f1209t);
                int a13 = ModelHelper.a(flatBufferBuilder, this.f1210u);
                int a14 = ModelHelper.a(flatBufferBuilder, this.f1211v);
                int b8 = flatBufferBuilder.b(this.f1212w);
                int b9 = flatBufferBuilder.b(this.f1213x);
                int b10 = flatBufferBuilder.b(this.f1214y);
                int b11 = flatBufferBuilder.b(this.f1215z);
                int b12 = flatBufferBuilder.b(this.f1164A);
                int b13 = flatBufferBuilder.b(this.f1165B);
                int a15 = ModelHelper.a(flatBufferBuilder, this.f1166C);
                int a16 = ModelHelper.a(flatBufferBuilder, this.f1167D);
                int b14 = flatBufferBuilder.b(this.f1168E);
                int b15 = flatBufferBuilder.b(this.f1169F);
                int b16 = flatBufferBuilder.b(this.f1171H);
                int b17 = flatBufferBuilder.b(this.f1173J);
                int a17 = ModelHelper.a(flatBufferBuilder, this.f1174K);
                int a18 = flatBufferBuilder.a(this.f1175L);
                int a19 = ModelHelper.a(flatBufferBuilder, this.f1176M);
                int b18 = flatBufferBuilder.b(this.f1177N);
                int b19 = flatBufferBuilder.b(this.f1178O);
                int b20 = flatBufferBuilder.b(this.f1179P);
                int a20 = ModelHelper.a(flatBufferBuilder, this.f1180Q);
                int a21 = ModelHelper.a(flatBufferBuilder, this.f1181R);
                int b21 = flatBufferBuilder.b(this.f1182S);
                int b22 = flatBufferBuilder.b(this.f1183T);
                int b23 = flatBufferBuilder.b(this.f1184U);
                int b24 = flatBufferBuilder.b(this.f1185V);
                int a22 = ModelHelper.a(flatBufferBuilder, this.f1186W);
                int a23 = ModelHelper.a(flatBufferBuilder, this.f1187X);
                int a24 = ModelHelper.a(flatBufferBuilder, this.f1188Y);
                int a25 = ModelHelper.a(flatBufferBuilder, this.f1189Z);
                int b25 = flatBufferBuilder.b(this.aa);
                int b26 = flatBufferBuilder.b(this.ab);
                int a26 = ModelHelper.a(flatBufferBuilder, this.ae);
                int a27 = ModelHelper.a(flatBufferBuilder, this.af);
                int b27 = flatBufferBuilder.b(this.ag);
                int a28 = ModelHelper.a(flatBufferBuilder, this.ah);
                int a29 = ModelHelper.a(flatBufferBuilder, this.ai);
                int b28 = flatBufferBuilder.b(this.aj);
                int a30 = ModelHelper.a(flatBufferBuilder, this.ak);
                int a31 = ModelHelper.a(flatBufferBuilder, this.al);
                int a32 = flatBufferBuilder.a(this.am);
                int b29 = flatBufferBuilder.b(this.an);
                int b30 = flatBufferBuilder.b(this.ao);
                int b31 = flatBufferBuilder.b(this.ap);
                int b32 = flatBufferBuilder.b(this.aq);
                int a33 = ModelHelper.a(flatBufferBuilder, this.ar);
                int a34 = ModelHelper.a(flatBufferBuilder, this.as);
                int a35 = ModelHelper.a(flatBufferBuilder, this.at);
                int b33 = flatBufferBuilder.b(this.au);
                int b34 = flatBufferBuilder.b(this.av);
                int b35 = flatBufferBuilder.b(this.aw);
                int a36 = ModelHelper.a(flatBufferBuilder, this.ax);
                int b36 = flatBufferBuilder.b(this.ay);
                int b37 = flatBufferBuilder.b(this.az);
                int a37 = ModelHelper.a(flatBufferBuilder, this.aA);
                int a38 = ModelHelper.a(flatBufferBuilder, this.aB);
                int a39 = ModelHelper.a(flatBufferBuilder, this.aC);
                int a40 = ModelHelper.a(flatBufferBuilder, this.aD);
                int b38 = flatBufferBuilder.b(this.aE);
                int b39 = flatBufferBuilder.b(this.aF);
                int b40 = flatBufferBuilder.b(this.aG);
                int a41 = ModelHelper.a(flatBufferBuilder, this.aH);
                int a42 = ModelHelper.a(flatBufferBuilder, this.aI);
                int b41 = flatBufferBuilder.b(this.aJ);
                int b42 = flatBufferBuilder.b(this.aK);
                int a43 = ModelHelper.a(flatBufferBuilder, this.aL);
                int a44 = ModelHelper.a(flatBufferBuilder, this.aM);
                int a45 = ModelHelper.a(flatBufferBuilder, this.aN);
                int a46 = ModelHelper.a(flatBufferBuilder, this.aO);
                int a47 = ModelHelper.a(flatBufferBuilder, this.aP);
                int a48 = ModelHelper.a(flatBufferBuilder, this.aQ);
                int b43 = flatBufferBuilder.b(this.aR);
                int a49 = ModelHelper.a(flatBufferBuilder, this.aS);
                int a50 = ModelHelper.a(flatBufferBuilder, this.aT);
                int b44 = flatBufferBuilder.b(this.aU);
                int b45 = flatBufferBuilder.b(this.aV);
                int a51 = ModelHelper.a(flatBufferBuilder, this.aW);
                int b46 = flatBufferBuilder.b(this.aX);
                int b47 = flatBufferBuilder.b(this.aY);
                int b48 = flatBufferBuilder.b(this.aZ);
                int a52 = ModelHelper.a(flatBufferBuilder, this.ba);
                int a53 = flatBufferBuilder.a(this.bb);
                int a54 = ModelHelper.a(flatBufferBuilder, this.bc);
                int b49 = flatBufferBuilder.b(this.bd);
                int b50 = flatBufferBuilder.b(this.be);
                int a55 = ModelHelper.a(flatBufferBuilder, this.bf);
                int b51 = flatBufferBuilder.b(this.bg);
                int b52 = flatBufferBuilder.b(this.bi);
                int a56 = flatBufferBuilder.a(this.bj);
                int a57 = ModelHelper.a(flatBufferBuilder, this.bk);
                int a58 = ModelHelper.a(flatBufferBuilder, this.bl);
                int b53 = flatBufferBuilder.b(this.bm);
                int a59 = ModelHelper.a(flatBufferBuilder, this.bn);
                int b54 = flatBufferBuilder.b(this.bo);
                int b55 = flatBufferBuilder.b(this.bp);
                int b56 = flatBufferBuilder.b(this.bq);
                int b57 = flatBufferBuilder.b(this.br);
                int b58 = flatBufferBuilder.b(this.bs);
                int b59 = flatBufferBuilder.b(this.bt);
                int b60 = flatBufferBuilder.b(this.bu);
                int b61 = flatBufferBuilder.b(this.bv);
                int a60 = ModelHelper.a(flatBufferBuilder, this.bx);
                int a61 = ModelHelper.a(flatBufferBuilder, this.by);
                int a62 = flatBufferBuilder.a(this.bz);
                int b62 = flatBufferBuilder.b(this.bA);
                int b63 = flatBufferBuilder.b(this.bD);
                int b64 = flatBufferBuilder.b(this.bE);
                int b65 = flatBufferBuilder.b(this.bF);
                int b66 = flatBufferBuilder.b(this.bG);
                int a63 = flatBufferBuilder.a(this.bH);
                int a64 = ModelHelper.a(flatBufferBuilder, this.bI);
                int a65 = flatBufferBuilder.a(this.bJ);
                int a66 = flatBufferBuilder.a(this.bK);
                flatBufferBuilder.c(141);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, b3);
                flatBufferBuilder.b(6, b4);
                flatBufferBuilder.b(7, a4);
                flatBufferBuilder.b(8, a5);
                flatBufferBuilder.b(9, a6);
                flatBufferBuilder.b(10, a7);
                flatBufferBuilder.b(11, a8);
                flatBufferBuilder.a(12, this.f1202m);
                flatBufferBuilder.b(13, a9);
                flatBufferBuilder.b(14, b5);
                flatBufferBuilder.b(15, b6);
                flatBufferBuilder.b(16, b7);
                flatBufferBuilder.b(17, a10);
                flatBufferBuilder.b(18, a11);
                flatBufferBuilder.b(19, a12);
                flatBufferBuilder.b(20, a13);
                flatBufferBuilder.b(21, a14);
                flatBufferBuilder.b(22, b8);
                flatBufferBuilder.b(23, b9);
                flatBufferBuilder.b(24, b10);
                flatBufferBuilder.b(25, b11);
                flatBufferBuilder.b(26, b12);
                flatBufferBuilder.b(27, b13);
                flatBufferBuilder.b(28, a15);
                flatBufferBuilder.b(29, a16);
                flatBufferBuilder.b(30, b14);
                flatBufferBuilder.b(31, b15);
                flatBufferBuilder.a(32, this.f1170G, 0.0d);
                flatBufferBuilder.b(33, b16);
                flatBufferBuilder.a(34, this.f1172I, 0);
                flatBufferBuilder.b(35, b17);
                flatBufferBuilder.b(36, a17);
                flatBufferBuilder.b(37, a18);
                flatBufferBuilder.b(38, a19);
                flatBufferBuilder.b(39, b18);
                flatBufferBuilder.b(40, b19);
                flatBufferBuilder.b(41, b20);
                flatBufferBuilder.b(42, a20);
                flatBufferBuilder.b(43, a21);
                flatBufferBuilder.b(44, b21);
                flatBufferBuilder.b(45, b22);
                flatBufferBuilder.b(46, b23);
                flatBufferBuilder.b(47, b24);
                flatBufferBuilder.b(48, a22);
                flatBufferBuilder.b(49, a23);
                flatBufferBuilder.b(50, a24);
                flatBufferBuilder.b(51, a25);
                flatBufferBuilder.b(52, b25);
                flatBufferBuilder.b(53, b26);
                flatBufferBuilder.a(54, this.ac);
                flatBufferBuilder.a(55, this.ad);
                flatBufferBuilder.b(56, a26);
                flatBufferBuilder.b(57, a27);
                flatBufferBuilder.b(58, b27);
                flatBufferBuilder.b(59, a28);
                flatBufferBuilder.b(60, a29);
                flatBufferBuilder.b(61, b28);
                flatBufferBuilder.b(62, a30);
                flatBufferBuilder.b(63, a31);
                flatBufferBuilder.b(64, a32);
                flatBufferBuilder.b(65, b29);
                flatBufferBuilder.b(66, b30);
                flatBufferBuilder.b(67, b31);
                flatBufferBuilder.b(68, b32);
                flatBufferBuilder.b(69, a33);
                flatBufferBuilder.b(70, a34);
                flatBufferBuilder.b(71, a35);
                flatBufferBuilder.b(72, b33);
                flatBufferBuilder.b(73, b34);
                flatBufferBuilder.b(74, b35);
                flatBufferBuilder.b(75, a36);
                flatBufferBuilder.b(76, b36);
                flatBufferBuilder.b(77, b37);
                flatBufferBuilder.b(78, a37);
                flatBufferBuilder.b(79, a38);
                flatBufferBuilder.b(80, a39);
                flatBufferBuilder.b(81, a40);
                flatBufferBuilder.b(82, b38);
                flatBufferBuilder.b(83, b39);
                flatBufferBuilder.b(84, b40);
                flatBufferBuilder.b(85, a41);
                flatBufferBuilder.b(86, a42);
                flatBufferBuilder.b(87, b41);
                flatBufferBuilder.b(88, b42);
                flatBufferBuilder.b(89, a43);
                flatBufferBuilder.b(90, a44);
                flatBufferBuilder.b(91, a45);
                flatBufferBuilder.b(92, a46);
                flatBufferBuilder.b(93, a47);
                flatBufferBuilder.b(94, a48);
                flatBufferBuilder.b(95, b43);
                flatBufferBuilder.b(96, a49);
                flatBufferBuilder.b(97, a50);
                flatBufferBuilder.b(98, b44);
                flatBufferBuilder.b(99, b45);
                flatBufferBuilder.b(100, a51);
                flatBufferBuilder.b(101, b46);
                flatBufferBuilder.b(102, b47);
                flatBufferBuilder.b(103, b48);
                flatBufferBuilder.b(104, a52);
                flatBufferBuilder.b(105, a53);
                flatBufferBuilder.b(106, a54);
                flatBufferBuilder.b(107, b49);
                flatBufferBuilder.b(108, b50);
                flatBufferBuilder.b(109, a55);
                flatBufferBuilder.b(110, b51);
                flatBufferBuilder.a(111, this.bh, 0);
                flatBufferBuilder.b(112, b52);
                flatBufferBuilder.b(113, a56);
                flatBufferBuilder.b(114, a57);
                flatBufferBuilder.b(115, a58);
                flatBufferBuilder.b(116, b53);
                flatBufferBuilder.b(117, a59);
                flatBufferBuilder.b(118, b54);
                flatBufferBuilder.b(119, b55);
                flatBufferBuilder.b(120, b56);
                flatBufferBuilder.b(121, b57);
                flatBufferBuilder.b(122, b58);
                flatBufferBuilder.b(123, b59);
                flatBufferBuilder.b(124, b60);
                flatBufferBuilder.b(125, b61);
                flatBufferBuilder.a(126, this.bw, 0);
                flatBufferBuilder.b(127, a60);
                flatBufferBuilder.b(128, a61);
                flatBufferBuilder.b(129, a62);
                flatBufferBuilder.b(130, b62);
                flatBufferBuilder.a(131, this.bB, 0);
                flatBufferBuilder.a(132, this.bC, 0);
                flatBufferBuilder.b(133, b63);
                flatBufferBuilder.b(134, b64);
                flatBufferBuilder.b(135, b65);
                flatBufferBuilder.b(136, b66);
                flatBufferBuilder.b(137, a63);
                flatBufferBuilder.b(138, a64);
                flatBufferBuilder.b(139, a65);
                flatBufferBuilder.b(140, a66);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new StoryAttachmentTargetFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StoryAttachmentTargetFragmentModel.class, new Deserializer());
            }

            public Object m1693a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StoryAttachmentTargetFragmentParser.m1836a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object storyAttachmentTargetFragmentModel = new StoryAttachmentTargetFragmentModel();
                ((BaseModel) storyAttachmentTargetFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (storyAttachmentTargetFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) storyAttachmentTargetFragmentModel).a();
                }
                return storyAttachmentTargetFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1185712657)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, Page {
            @Nullable
            private String f1218d;
            @Nullable
            private String f1219e;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public String f1216a;
                @Nullable
                public String f1217b;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m1694a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m1830a(jsonParser, flatBufferBuilder));
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

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m1695a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m1697a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m1831a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(2);
            }

            public PageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m1700a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1701a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String mo128b() {
                this.f1218d = super.a(this.f1218d, 0);
                return this.f1218d;
            }

            @Nullable
            public final String m1703c() {
                this.f1219e = super.a(this.f1219e, 1);
                return this.f1219e;
            }

            public static PageModel m1696a(PageModel pageModel) {
                if (pageModel == null) {
                    return null;
                }
                if (pageModel instanceof PageModel) {
                    return pageModel;
                }
                Builder builder = new Builder();
                builder.f1216a = pageModel.mo128b();
                builder.f1217b = pageModel.m1703c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f1216a);
                int b2 = flatBufferBuilder.b(builder.f1217b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m1699a() {
                return mo128b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m1698a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1697a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo128b());
                int b2 = flatBufferBuilder.b(m1703c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 729935302)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class PartnerLogoModel extends BaseModel implements GraphQLVisitableModel, PartnerLogo, LogoImage {
            private int f1223d;
            @Nullable
            private String f1224e;
            private int f1225f;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                public int f1220a;
                @Nullable
                public String f1221b;
                public int f1222c;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PartnerLogoModel.class, new Deserializer());
                }

                public Object m1704a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PartnerLogoParser.m1832a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object partnerLogoModel = new PartnerLogoModel();
                    ((BaseModel) partnerLogoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (partnerLogoModel instanceof Postprocessable) {
                        return ((Postprocessable) partnerLogoModel).a();
                    }
                    return partnerLogoModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<PartnerLogoModel> {
                public final void m1705a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PartnerLogoModel partnerLogoModel = (PartnerLogoModel) obj;
                    if (partnerLogoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(partnerLogoModel.m1708a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        partnerLogoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PartnerLogoParser.m1833a(partnerLogoModel.w_(), partnerLogoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PartnerLogoModel.class, new Serializer());
                }
            }

            public PartnerLogoModel() {
                super(3);
            }

            public PartnerLogoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int mo87a() {
                a(0, 0);
                return this.f1223d;
            }

            @Nullable
            public final String mo111b() {
                this.f1224e = super.a(this.f1224e, 1);
                return this.f1224e;
            }

            public final int mo89c() {
                a(0, 2);
                return this.f1225f;
            }

            public static PartnerLogoModel m1706a(PartnerLogoModel partnerLogoModel) {
                if (partnerLogoModel == null) {
                    return null;
                }
                if (partnerLogoModel instanceof PartnerLogoModel) {
                    return partnerLogoModel;
                }
                Builder builder = new Builder();
                builder.f1220a = partnerLogoModel.mo87a();
                builder.f1221b = partnerLogoModel.mo111b();
                builder.f1222c = partnerLogoModel.mo89c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f1221b);
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, builder.f1220a, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, builder.f1222c, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PartnerLogoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m1709a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1708a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo111b());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f1223d, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f1225f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1710a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1223d = mutableFlatBuffer.a(i, 0, 0);
                this.f1225f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1171769835)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: videoTirmStartTimeMs */
        public final class PaymentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, Payment {
            @Nullable
            private String f1228d;
            @Nullable
            private GraphQLPeerToPeerTransferStatus f1229e;

            /* compiled from: videoTirmStartTimeMs */
            public final class Builder {
                @Nullable
                public String f1226a;
                @Nullable
                public GraphQLPeerToPeerTransferStatus f1227b;
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PaymentModel.class, new Deserializer());
                }

                public Object m1713a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PaymentParser.m1834a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object paymentModel = new PaymentModel();
                    ((BaseModel) paymentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (paymentModel instanceof Postprocessable) {
                        return ((Postprocessable) paymentModel).a();
                    }
                    return paymentModel;
                }
            }

            /* compiled from: videoTirmStartTimeMs */
            public class Serializer extends JsonSerializer<PaymentModel> {
                public final void m1714a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PaymentModel paymentModel = (PaymentModel) obj;
                    if (paymentModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(paymentModel.m1716a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        paymentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PaymentParser.m1835a(paymentModel.w_(), paymentModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PaymentModel.class, new Serializer());
                }
            }

            public PaymentModel() {
                super(2);
            }

            public PaymentModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String mo129b() {
                this.f1228d = super.a(this.f1228d, 0);
                return this.f1228d;
            }

            @Nullable
            public final GraphQLPeerToPeerTransferStatus m1720c() {
                this.f1229e = (GraphQLPeerToPeerTransferStatus) super.b(this.f1229e, 1, GraphQLPeerToPeerTransferStatus.class, GraphQLPeerToPeerTransferStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1229e;
            }

            public static PaymentModel m1715a(PaymentModel paymentModel) {
                if (paymentModel == null) {
                    return null;
                }
                if (paymentModel instanceof PaymentModel) {
                    return paymentModel;
                }
                Builder builder = new Builder();
                builder.f1226a = paymentModel.mo129b();
                builder.f1227b = paymentModel.m1720c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f1226a);
                int a = flatBufferBuilder.a(builder.f1227b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PaymentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m1718a() {
                return mo129b();
            }

            public final int jK_() {
                return -1658635464;
            }

            public final GraphQLVisitableModel m1717a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1716a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo129b());
                int a = flatBufferBuilder.a(m1720c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: videoTirmStartTimeMs */
        public class Serializer extends JsonSerializer<StoryAttachmentTargetFragmentModel> {
            public final void m1721a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StoryAttachmentTargetFragmentModel storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) obj;
                if (storyAttachmentTargetFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(storyAttachmentTargetFragmentModel.m1751a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    storyAttachmentTargetFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StoryAttachmentTargetFragmentParser.m1837a(storyAttachmentTargetFragmentModel.w_(), storyAttachmentTargetFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StoryAttachmentTargetFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RetailCarrierModel mo61B() {
            return cr();
        }

        @Nullable
        public final /* synthetic */ RetailShipmentItemsModel mo62C() {
            return ct();
        }

        @Nullable
        public final /* synthetic */ ShipmentTrackingEventsModel mo65F() {
            return cx();
        }

        @Nullable
        public final /* synthetic */ CommerceShipmentBubble mo109H() {
            return cw();
        }

        @Nullable
        public final /* synthetic */ FundraiserDetailedProgressTextModel mo114J() {
            return bY();
        }

        @Nullable
        public final /* synthetic */ FundraiserForCharityTextModel mo115K() {
            return bZ();
        }

        @Nullable
        public final /* synthetic */ Amount mo118L() {
            return bO();
        }

        @Nullable
        public final /* synthetic */ RequesteeModel mo120N() {
            return cp();
        }

        @Nullable
        public final /* synthetic */ RequesterModel mo121O() {
            return cq();
        }

        @Nullable
        public final /* synthetic */ PeerToPeerTransferFragment.Amount mo124P() {
            return bO();
        }

        @Nullable
        public final /* synthetic */ ReceiverModel mo126R() {
            return co();
        }

        @Nullable
        public final /* synthetic */ SenderModel mo127S() {
            return cv();
        }

        @Nullable
        public final /* synthetic */ AmountModel m1744T() {
            return bO();
        }

        @Nullable
        public final /* synthetic */ BoardingPassesModel mo130V() {
            return bP();
        }

        @Nullable
        public final /* synthetic */ BusinessItemsModel m1750Z() {
            return bQ();
        }

        @Nullable
        public final /* synthetic */ CommerceLocationModel aE_() {
            return cz();
        }

        @Nullable
        public final /* synthetic */ GroupFriendMembersModel aF() {
            return ca();
        }

        @Nullable
        public final /* synthetic */ GroupMembersModel aG() {
            return cb();
        }

        @Nullable
        public final /* synthetic */ ItemModel aJ() {
            return cc();
        }

        @Nullable
        public final /* synthetic */ ItineraryLegsModel aK() {
            return cd();
        }

        @Nullable
        public final /* synthetic */ LogoImage aM() {
            return ce();
        }

        @Nullable
        public final /* synthetic */ MovieImageFragmentModel aN() {
            return cf();
        }

        @Nullable
        public final /* synthetic */ PageModel aR() {
            return ch();
        }

        @Nullable
        public final /* synthetic */ PartnerLogoModel aS() {
            return ci();
        }

        @Nullable
        public final /* synthetic */ PaymentModel aX() {
            return cj();
        }

        @Nullable
        public final /* synthetic */ PlaceModel aZ() {
            return bK();
        }

        @Nullable
        public final /* synthetic */ FundraiserToCharityFragment ab() {
            return bR();
        }

        @Nullable
        public final /* synthetic */ CoordinatesModel ag() {
            return bH();
        }

        @Nullable
        public final /* synthetic */ CoverPhotoModel ah() {
            return bV();
        }

        @Nullable
        public final /* synthetic */ BusinessRideLocationModel an() {
            return bW();
        }

        @Nullable
        public final /* synthetic */ LogoImage at_() {
            return ci();
        }

        @Nullable
        public final /* synthetic */ EventCoordinatesModel au() {
            return bI();
        }

        @Nullable
        public final /* synthetic */ EventPlaceModel aw() {
            return bJ();
        }

        @Nullable
        public final /* synthetic */ AirlineFlightInfoModel az() {
            return bX();
        }

        @Nullable
        public final /* synthetic */ ViewerInviteToGroupModel bE() {
            return cD();
        }

        @Nullable
        public final /* synthetic */ Payment bL() {
            return cj();
        }

        @Nullable
        public final /* synthetic */ PaymentModel bM() {
            return cj();
        }

        @Nullable
        public final /* synthetic */ Page bN() {
            return ch();
        }

        @Nullable
        public final /* synthetic */ PlatformContextModel ba() {
            return ck();
        }

        @Nullable
        public final /* synthetic */ MovieDetailsFragmentModel bb() {
            return cl();
        }

        @Nullable
        public final /* synthetic */ RideProviderModel bg() {
            return cu();
        }

        @Nullable
        public final /* synthetic */ BusinessRideLocationModel bm() {
            return cy();
        }

        @Nullable
        public final /* synthetic */ TransactionPaymentModel bt() {
            return cB();
        }

        @Nullable
        public final /* synthetic */ TransactionProductsModel bu() {
            return cC();
        }

        @Nullable
        public final /* synthetic */ CommerceLocationModel mo79l() {
            return cg();
        }

        @Nullable
        public final /* synthetic */ CancelledItemsModel mo84p() {
            return bS();
        }

        @Nullable
        public final /* synthetic */ CommerceBaseOrderReceipt mo85q() {
            return cn();
        }

        @Nullable
        public final /* synthetic */ RetailItemsModel mo86r() {
            return cs();
        }

        @Nullable
        public final /* synthetic */ PartnerLogo mo102s() {
            return ci();
        }

        @Nullable
        public final /* synthetic */ SubscribedItemModel mo103t() {
            return cA();
        }

        @Nullable
        public final /* synthetic */ PromotionItemsModel mo108u() {
            return cm();
        }

        @Nullable
        public final /* synthetic */ CommerceLocationModel mo70w() {
            return bT();
        }

        @Nullable
        public final /* synthetic */ CommerceLocationModel mo71x() {
            return bU();
        }

        public StoryAttachmentTargetFragmentModel() {
            super(141);
        }

        public StoryAttachmentTargetFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(141);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m1755a(String str, ConsistencyTuple consistencyTuple) {
            if ("viewer_guest_status".equals(str)) {
                consistencyTuple.a = bD();
                consistencyTuple.b = u_();
                consistencyTuple.c = 137;
            } else if ("viewer_join_state".equals(str)) {
                consistencyTuple.a = bF();
                consistencyTuple.b = u_();
                consistencyTuple.c = 139;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m1756a(String str, Object obj, boolean z) {
            if ("viewer_guest_status".equals(str)) {
                m1723a((GraphQLEventGuestStatus) obj);
            } else if ("viewer_join_state".equals(str)) {
                m1724a((GraphQLGroupJoinState) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType mo113I() {
            if (this.b != null && this.f1256d == null) {
                this.f1256d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1256d;
        }

        @Nullable
        private AmountModel bO() {
            this.f1257e = (AmountModel) super.a(this.f1257e, 1, AmountModel.class);
            return this.f1257e;
        }

        @Nullable
        public final String m1745U() {
            this.f1258f = super.a(this.f1258f, 2);
            return this.f1258f;
        }

        @Nullable
        private BoardingPassesModel bP() {
            this.f1259g = (BoardingPassesModel) super.a(this.f1259g, 3, BoardingPassesModel.class);
            return this.f1259g;
        }

        @Nullable
        public final String m1747W() {
            this.f1260h = super.a(this.f1260h, 4);
            return this.f1260h;
        }

        @Nullable
        public final String m1748X() {
            this.f1261i = super.a(this.f1261i, 5);
            return this.f1261i;
        }

        @Nullable
        public final String m1749Y() {
            this.f1262j = super.a(this.f1262j, 6);
            return this.f1262j;
        }

        @Nullable
        public final GraphQLMessengerCommerceBubbleType mo67b() {
            this.f1263k = (GraphQLMessengerCommerceBubbleType) super.b(this.f1263k, 7, GraphQLMessengerCommerceBubbleType.class, GraphQLMessengerCommerceBubbleType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1263k;
        }

        @Nullable
        private BusinessItemsModel bQ() {
            this.f1264l = (BusinessItemsModel) super.a(this.f1264l, 8, BusinessItemsModel.class);
            return this.f1264l;
        }

        @Nonnull
        public final ImmutableList<MomentsAppInvitationActionLinkFragmentModel> aa() {
            this.f1265m = super.a(this.f1265m, 9, MomentsAppInvitationActionLinkFragmentModel.class);
            return (ImmutableList) this.f1265m;
        }

        @Nonnull
        public final ImmutableList<PlatformCallToActionModel> aB_() {
            this.f1266n = super.a(this.f1266n, 10, PlatformCallToActionModel.class);
            return (ImmutableList) this.f1266n;
        }

        @Nullable
        private FundraiserToCharityFragmentModel bR() {
            this.f1267o = (FundraiserToCharityFragmentModel) super.a(this.f1267o, 11, FundraiserToCharityFragmentModel.class);
            return this.f1267o;
        }

        public final boolean ac() {
            a(1, 4);
            return this.f1268p;
        }

        @Nullable
        private CancelledItemsModel bS() {
            this.f1269q = (CancelledItemsModel) super.a(this.f1269q, 13, CancelledItemsModel.class);
            return this.f1269q;
        }

        @Nullable
        public final String mo69v() {
            this.f1270r = super.a(this.f1270r, 14);
            return this.f1270r;
        }

        @Nullable
        public final String ad() {
            this.f1271s = super.a(this.f1271s, 15);
            return this.f1271s;
        }

        @Nullable
        public final String ae() {
            this.f1272t = super.a(this.f1272t, 16);
            return this.f1272t;
        }

        @Nullable
        private CommerceLocationModel bT() {
            this.f1273u = (CommerceLocationModel) super.a(this.f1273u, 17, CommerceLocationModel.class);
            return this.f1273u;
        }

        @Nullable
        private CommerceLocationModel bU() {
            this.f1274v = (CommerceLocationModel) super.a(this.f1274v, 18, CommerceLocationModel.class);
            return this.f1274v;
        }

        @Nullable
        public final GraphQLConnectionStyle af() {
            this.f1275w = (GraphQLConnectionStyle) super.b(this.f1275w, 19, GraphQLConnectionStyle.class, GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1275w;
        }

        @Nullable
        public final CoordinatesModel bH() {
            this.f1276x = (CoordinatesModel) super.a(this.f1276x, 20, CoordinatesModel.class);
            return this.f1276x;
        }

        @Nullable
        private CoverPhotoModel bV() {
            this.f1277y = (CoverPhotoModel) super.a(this.f1277y, 21, CoverPhotoModel.class);
            return this.f1277y;
        }

        @Nullable
        public final String ai() {
            this.f1278z = super.a(this.f1278z, 22);
            return this.f1278z;
        }

        @Nullable
        public final String mo72y() {
            this.f1230A = super.a(this.f1230A, 23);
            return this.f1230A;
        }

        @Nullable
        public final String aj() {
            this.f1231B = super.a(this.f1231B, 24);
            return this.f1231B;
        }

        @Nullable
        public final String ak() {
            this.f1232C = super.a(this.f1232C, 25);
            return this.f1232C;
        }

        @Nullable
        public final String al() {
            this.f1233D = super.a(this.f1233D, 26);
            return this.f1233D;
        }

        @Nullable
        public final String am() {
            this.f1234E = super.a(this.f1234E, 27);
            return this.f1234E;
        }

        @Nullable
        private BusinessRideLocationModel bW() {
            this.f1235F = (BusinessRideLocationModel) super.a(this.f1235F, 28, BusinessRideLocationModel.class);
            return this.f1235F;
        }

        @Nonnull
        public final ImmutableList<MovieButtonFragmentModel> ao() {
            this.f1236G = super.a(this.f1236G, 29, MovieButtonFragmentModel.class);
            return (ImmutableList) this.f1236G;
        }

        @Nullable
        public final String ap() {
            this.f1237H = super.a(this.f1237H, 30);
            return this.f1237H;
        }

        @Nullable
        public final String aq() {
            this.f1238I = super.a(this.f1238I, 31);
            return this.f1238I;
        }

        public final double ar() {
            a(4, 0);
            return this.f1239J;
        }

        @Nullable
        public final String as() {
            this.f1240K = super.a(this.f1240K, 33);
            return this.f1240K;
        }

        public final long at() {
            a(4, 2);
            return this.f1241L;
        }

        @Nullable
        public final String mo73z() {
            this.f1242M = super.a(this.f1242M, 35);
            return this.f1242M;
        }

        @Nullable
        public final EventCoordinatesModel bI() {
            this.f1243N = (EventCoordinatesModel) super.a(this.f1243N, 36, EventCoordinatesModel.class);
            return this.f1243N;
        }

        @Nullable
        public final GraphQLEventPrivacyType av() {
            this.f1244O = (GraphQLEventPrivacyType) super.b(this.f1244O, 37, GraphQLEventPrivacyType.class, GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1244O;
        }

        @Nullable
        public final EventPlaceModel bJ() {
            this.f1245P = (EventPlaceModel) super.a(this.f1245P, 38, EventPlaceModel.class);
            return this.f1245P;
        }

        @Nullable
        public final String ax() {
            this.f1246Q = super.a(this.f1246Q, 39);
            return this.f1246Q;
        }

        @Nullable
        public final String mo97d() {
            this.f1247R = super.a(this.f1247R, 40);
            return this.f1247R;
        }

        @Nullable
        public final String ay() {
            this.f1248S = super.a(this.f1248S, 41);
            return this.f1248S;
        }

        @Nullable
        private AirlineFlightInfoModel bX() {
            this.f1249T = (AirlineFlightInfoModel) super.a(this.f1249T, 42, AirlineFlightInfoModel.class);
            return this.f1249T;
        }

        @Nonnull
        public final ImmutableList<AirlineFlightInfoModel> aA() {
            this.f1250U = super.a(this.f1250U, 43, AirlineFlightInfoModel.class);
            return (ImmutableList) this.f1250U;
        }

        @Nullable
        public final String aB() {
            this.f1251V = super.a(this.f1251V, 44);
            return this.f1251V;
        }

        @Nullable
        public final String aC() {
            this.f1252W = super.a(this.f1252W, 45);
            return this.f1252W;
        }

        @Nullable
        public final String aD() {
            this.f1253X = super.a(this.f1253X, 46);
            return this.f1253X;
        }

        @Nullable
        public final String aE() {
            this.f1254Y = super.a(this.f1254Y, 47);
            return this.f1254Y;
        }

        @Nullable
        private FundraiserDetailedProgressTextModel bY() {
            this.f1255Z = (FundraiserDetailedProgressTextModel) super.a(this.f1255Z, 48, FundraiserDetailedProgressTextModel.class);
            return this.f1255Z;
        }

        @Nullable
        private FundraiserForCharityTextModel bZ() {
            this.aa = (FundraiserForCharityTextModel) super.a(this.aa, 49, FundraiserForCharityTextModel.class);
            return this.aa;
        }

        @Nullable
        private GroupFriendMembersModel ca() {
            this.ab = (GroupFriendMembersModel) super.a(this.ab, 50, GroupFriendMembersModel.class);
            return this.ab;
        }

        @Nullable
        private GroupMembersModel cb() {
            this.ac = (GroupMembersModel) super.a(this.ac, 51, GroupMembersModel.class);
            return this.ac;
        }

        @Nullable
        public final String mo68c() {
            this.ad = super.a(this.ad, 52);
            return this.ad;
        }

        @Nullable
        public final String ax_() {
            this.ae = super.a(this.ae, 53);
            return this.ae;
        }

        public final boolean aH() {
            a(6, 6);
            return this.af;
        }

        public final boolean aI() {
            a(6, 7);
            return this.ag;
        }

        @Nullable
        private ItemModel cc() {
            this.ah = (ItemModel) super.a(this.ah, 56, ItemModel.class);
            return this.ah;
        }

        @Nullable
        private ItineraryLegsModel cd() {
            this.ai = (ItineraryLegsModel) super.a(this.ai, 57, ItineraryLegsModel.class);
            return this.ai;
        }

        @Nullable
        public final String aL() {
            this.aj = super.a(this.aj, 58);
            return this.aj;
        }

        @Nullable
        private LogoImageModel ce() {
            this.ak = (LogoImageModel) super.a(this.ak, 59, LogoImageModel.class);
            return this.ak;
        }

        @Nullable
        private MovieImageFragmentModel cf() {
            this.al = (MovieImageFragmentModel) super.a(this.al, 60, MovieImageFragmentModel.class);
            return this.al;
        }

        @Nullable
        public final String aO() {
            this.am = super.a(this.am, 61);
            return this.am;
        }

        @Nullable
        private CommerceLocationModel cg() {
            this.an = (CommerceLocationModel) super.a(this.an, 62, CommerceLocationModel.class);
            return this.an;
        }

        @Nonnull
        public final ImmutableList<MovieDetailsFragmentModel> aP() {
            this.ao = super.a(this.ao, 63, MovieDetailsFragmentModel.class);
            return (ImmutableList) this.ao;
        }

        @Nullable
        public final GraphQLMovieBotMovieListStyle aQ() {
            this.ap = (GraphQLMovieBotMovieListStyle) super.b(this.ap, 64, GraphQLMovieBotMovieListStyle.class, GraphQLMovieBotMovieListStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.ap;
        }

        @Nullable
        public final String mo107g() {
            this.aq = super.a(this.aq, 65);
            return this.aq;
        }

        @Nullable
        public final String ay_() {
            this.ar = super.a(this.ar, 66);
            return this.ar;
        }

        @Nullable
        public final String mo60A() {
            this.as = super.a(this.as, 67);
            return this.as;
        }

        @Nullable
        public final String aC_() {
            this.at = super.a(this.at, 68);
            return this.at;
        }

        @Nullable
        private PageModel ch() {
            this.au = (PageModel) super.a(this.au, 69, PageModel.class);
            return this.au;
        }

        @Nullable
        private PartnerLogoModel ci() {
            this.av = (PartnerLogoModel) super.a(this.av, 70, PartnerLogoModel.class);
            return this.av;
        }

        @Nonnull
        public final ImmutableList<AirlinePassengerModel> aT() {
            this.aw = super.a(this.aw, 71, AirlinePassengerModel.class);
            return (ImmutableList) this.aw;
        }

        @Nullable
        public final String aU() {
            this.ax = super.a(this.ax, 72);
            return this.ax;
        }

        @Nullable
        public final String aV() {
            this.ay = super.a(this.ay, 73);
            return this.ay;
        }

        @Nullable
        public final String aW() {
            this.az = super.a(this.az, 74);
            return this.az;
        }

        @Nullable
        private PaymentModel cj() {
            this.aA = (PaymentModel) super.a(this.aA, 75, PaymentModel.class);
            return this.aA;
        }

        @Nullable
        public final String mo125Q() {
            this.aB = super.a(this.aB, 76);
            return this.aB;
        }

        @Nullable
        public final String mo119M() {
            this.aC = super.a(this.aC, 77);
            return this.aC;
        }

        @Nonnull
        public final ImmutableList<MomentsAppInvitationActionLinkFragmentModel> aY() {
            this.aD = super.a(this.aD, 78, MomentsAppInvitationActionLinkFragmentModel.class);
            return (ImmutableList) this.aD;
        }

        @Nullable
        public final PlaceModel bK() {
            this.aE = (PlaceModel) super.a(this.aE, 79, PlaceModel.class);
            return this.aE;
        }

        @Nullable
        private PlatformContextModel ck() {
            this.aF = (PlatformContextModel) super.a(this.aF, 80, PlatformContextModel.class);
            return this.aF;
        }

        @Nullable
        private MovieDetailsFragmentModel cl() {
            this.aG = (MovieDetailsFragmentModel) super.a(this.aG, 81, MovieDetailsFragmentModel.class);
            return this.aG;
        }

        @Nullable
        public final String bc() {
            this.aH = super.a(this.aH, 82);
            return this.aH;
        }

        @Nullable
        public final String bd() {
            this.aI = super.a(this.aI, 83);
            return this.aI;
        }

        @Nullable
        public final String be() {
            this.aJ = super.a(this.aJ, 84);
            return this.aJ;
        }

        @Nullable
        private PromotionItemsModel cm() {
            this.aK = (PromotionItemsModel) super.a(this.aK, 85, PromotionItemsModel.class);
            return this.aK;
        }

        @Nullable
        private CommerceBaseOrderReceiptModel cn() {
            this.aL = (CommerceBaseOrderReceiptModel) super.a(this.aL, 86, CommerceBaseOrderReceiptModel.class);
            return this.aL;
        }

        @Nullable
        public final String aD_() {
            this.aM = super.a(this.aM, 87);
            return this.aM;
        }

        @Nullable
        public final String ar_() {
            this.aN = super.a(this.aN, 88);
            return this.aN;
        }

        @Nullable
        private ReceiverModel co() {
            this.aO = (ReceiverModel) super.a(this.aO, 89, ReceiverModel.class);
            return this.aO;
        }

        @Nullable
        private RequesteeModel cp() {
            this.aP = (RequesteeModel) super.a(this.aP, 90, RequesteeModel.class);
            return this.aP;
        }

        @Nullable
        private RequesterModel cq() {
            this.aQ = (RequesterModel) super.a(this.aQ, 91, RequesterModel.class);
            return this.aQ;
        }

        @Nullable
        private RetailCarrierModel cr() {
            this.aR = (RetailCarrierModel) super.a(this.aR, 92, RetailCarrierModel.class);
            return this.aR;
        }

        @Nullable
        private RetailItemsModel cs() {
            this.aS = (RetailItemsModel) super.a(this.aS, 93, RetailItemsModel.class);
            return this.aS;
        }

        @Nullable
        private RetailShipmentItemsModel ct() {
            this.aT = (RetailShipmentItemsModel) super.a(this.aT, 94, RetailShipmentItemsModel.class);
            return this.aT;
        }

        @Nullable
        public final String bf() {
            this.aU = super.a(this.aU, 95);
            return this.aU;
        }

        @Nullable
        private RideProviderModel cu() {
            this.aV = (RideProviderModel) super.a(this.aV, 96, RideProviderModel.class);
            return this.aV;
        }

        @Nonnull
        public final ImmutableList<MovieButtonFragmentModel> bh() {
            this.aW = super.a(this.aW, 97, MovieButtonFragmentModel.class);
            return (ImmutableList) this.aW;
        }

        @Nullable
        public final String az_() {
            this.aX = super.a(this.aX, 98);
            return this.aX;
        }

        @Nullable
        public final String bi() {
            this.aY = super.a(this.aY, 99);
            return this.aY;
        }

        @Nullable
        private SenderModel cv() {
            this.aZ = (SenderModel) super.a(this.aZ, 100, SenderModel.class);
            return this.aZ;
        }

        @Nullable
        public final String mo63D() {
            this.ba = super.a(this.ba, 101);
            return this.ba;
        }

        @Nullable
        public final String bj() {
            this.bb = super.a(this.bb, 102);
            return this.bb;
        }

        @Nullable
        public final String mo64E() {
            this.bc = super.a(this.bc, 103);
            return this.bc;
        }

        @Nullable
        private CommerceShipmentBubbleModel cw() {
            this.bd = (CommerceShipmentBubbleModel) super.a(this.bd, 104, CommerceShipmentBubbleModel.class);
            return this.bd;
        }

        @Nullable
        public final GraphQLShipmentTrackingEventType mo80m() {
            this.be = (GraphQLShipmentTrackingEventType) super.b(this.be, 105, GraphQLShipmentTrackingEventType.class, GraphQLShipmentTrackingEventType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.be;
        }

        @Nullable
        private ShipmentTrackingEventsModel cx() {
            this.bf = (ShipmentTrackingEventsModel) super.a(this.bf, 106, ShipmentTrackingEventsModel.class);
            return this.bf;
        }

        @Nullable
        public final String bk() {
            this.bg = super.a(this.bg, 107);
            return this.bg;
        }

        @Nullable
        public final String bl() {
            this.bh = super.a(this.bh, 108);
            return this.bh;
        }

        @Nullable
        private BusinessRideLocationModel cy() {
            this.bi = (BusinessRideLocationModel) super.a(this.bi, 109, BusinessRideLocationModel.class);
            return this.bi;
        }

        @Nullable
        public final String mo99j() {
            this.bj = super.a(this.bj, 110);
            return this.bj;
        }

        public final long bn() {
            a(13, 7);
            return this.bk;
        }

        @Nullable
        public final String as_() {
            this.bl = super.a(this.bl, 112);
            return this.bl;
        }

        @Nullable
        public final GraphQLMessengerRetailItemStatus mo100k() {
            this.bm = (GraphQLMessengerRetailItemStatus) super.b(this.bm, 113, GraphQLMessengerRetailItemStatus.class, GraphQLMessengerRetailItemStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.bm;
        }

        @Nullable
        private CommerceLocationModel cz() {
            this.bn = (CommerceLocationModel) super.a(this.bn, 114, CommerceLocationModel.class);
            return this.bn;
        }

        @Nullable
        private SubscribedItemModel cA() {
            this.bo = (SubscribedItemModel) super.a(this.bo, 115, SubscribedItemModel.class);
            return this.bo;
        }

        @Nullable
        public final String aF_() {
            this.bp = super.a(this.bp, 116);
            return this.bp;
        }

        @Nonnull
        public final ImmutableList<MovieTheaterFragmentModel> bo() {
            this.bq = super.a(this.bq, 117, MovieTheaterFragmentModel.class);
            return (ImmutableList) this.bq;
        }

        @Nullable
        public final String aG_() {
            this.br = super.a(this.br, 118);
            return this.br;
        }

        @Nullable
        public final String bp() {
            this.bs = super.a(this.bs, 119);
            return this.bs;
        }

        @Nullable
        public final String bq() {
            this.bt = super.a(this.bt, 120);
            return this.bt;
        }

        @Nullable
        public final String aH_() {
            this.bu = super.a(this.bu, 121);
            return this.bu;
        }

        @Nullable
        public final String br() {
            this.bv = super.a(this.bv, 122);
            return this.bv;
        }

        @Nullable
        public final String mo81n() {
            this.bw = super.a(this.bw, 123);
            return this.bw;
        }

        @Nullable
        public final String mo82o() {
            this.bx = super.a(this.bx, 124);
            return this.bx;
        }

        @Nullable
        public final String mo66G() {
            this.by = super.a(this.by, 125);
            return this.by;
        }

        public final int bs() {
            a(15, 6);
            return this.bz;
        }

        @Nullable
        private TransactionPaymentModel cB() {
            this.bA = (TransactionPaymentModel) super.a(this.bA, 127, TransactionPaymentModel.class);
            return this.bA;
        }

        @Nullable
        private TransactionProductsModel cC() {
            this.bB = (TransactionProductsModel) super.a(this.bB, 128, TransactionProductsModel.class);
            return this.bB;
        }

        @Nullable
        public final GraphQLPageProductTransactionOrderStatusEnum bv() {
            this.bC = (GraphQLPageProductTransactionOrderStatusEnum) super.b(this.bC, 129, GraphQLPageProductTransactionOrderStatusEnum.class, GraphQLPageProductTransactionOrderStatusEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.bC;
        }

        @Nullable
        public final String bw() {
            this.bD = super.a(this.bD, 130);
            return this.bD;
        }

        public final int bx() {
            a(16, 3);
            return this.bE;
        }

        public final int by() {
            a(16, 4);
            return this.bF;
        }

        @Nullable
        public final String bz() {
            this.bG = super.a(this.bG, 133);
            return this.bG;
        }

        @Nullable
        public final String bA() {
            this.bH = super.a(this.bH, 134);
            return this.bH;
        }

        @Nullable
        public final String bB() {
            this.bI = super.a(this.bI, 135);
            return this.bI;
        }

        @Nullable
        public final String bC() {
            this.bJ = super.a(this.bJ, 136);
            return this.bJ;
        }

        @Nullable
        public final GraphQLEventGuestStatus bD() {
            this.bK = (GraphQLEventGuestStatus) super.b(this.bK, 137, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.bK;
        }

        private void m1723a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
            this.bK = graphQLEventGuestStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 137, graphQLEventGuestStatus != null ? graphQLEventGuestStatus.name() : null);
            }
        }

        @Nullable
        private ViewerInviteToGroupModel cD() {
            this.bL = (ViewerInviteToGroupModel) super.a(this.bL, 138, ViewerInviteToGroupModel.class);
            return this.bL;
        }

        @Nullable
        public final GraphQLGroupJoinState bF() {
            this.bM = (GraphQLGroupJoinState) super.b(this.bM, 139, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.bM;
        }

        private void m1724a(GraphQLGroupJoinState graphQLGroupJoinState) {
            this.bM = graphQLGroupJoinState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 139, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
            }
        }

        @Nullable
        public final GraphQLGroupVisibility bG() {
            this.bN = (GraphQLGroupVisibility) super.b(this.bN, 140, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.bN;
        }

        public static StoryAttachmentTargetFragmentModel m1722a(StoryAttachmentTargetFragmentModel storyAttachmentTargetFragmentModel) {
            int i = 0;
            if (storyAttachmentTargetFragmentModel == null) {
                return null;
            }
            if (storyAttachmentTargetFragmentModel instanceof StoryAttachmentTargetFragmentModel) {
                return storyAttachmentTargetFragmentModel;
            }
            int i2;
            Builder builder = new Builder();
            builder.f1190a = storyAttachmentTargetFragmentModel.mo113I();
            builder.f1191b = AmountModel.m1687a(storyAttachmentTargetFragmentModel.m1744T());
            builder.f1192c = storyAttachmentTargetFragmentModel.m1745U();
            builder.f1193d = BoardingPassesModel.m3023a(storyAttachmentTargetFragmentModel.mo130V());
            builder.f1194e = storyAttachmentTargetFragmentModel.m1747W();
            builder.f1195f = storyAttachmentTargetFragmentModel.m1748X();
            builder.f1196g = storyAttachmentTargetFragmentModel.m1749Y();
            builder.f1197h = storyAttachmentTargetFragmentModel.mo67b();
            builder.f1198i = BusinessItemsModel.m994a(storyAttachmentTargetFragmentModel.m1750Z());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < storyAttachmentTargetFragmentModel.aa().size(); i2++) {
                builder2.c(MomentsAppInvitationActionLinkFragmentModel.m1609a((MomentsAppInvitationActionLinkFragmentModel) storyAttachmentTargetFragmentModel.aa().get(i2)));
            }
            builder.f1199j = builder2.b();
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < storyAttachmentTargetFragmentModel.aB_().size(); i2++) {
                builder2.c(PlatformCallToActionModel.m732a((PlatformCallToActionModel) storyAttachmentTargetFragmentModel.aB_().get(i2)));
            }
            builder.f1200k = builder2.b();
            builder.f1201l = FundraiserToCharityFragmentModel.m1474a(storyAttachmentTargetFragmentModel.ab());
            builder.f1202m = storyAttachmentTargetFragmentModel.ac();
            builder.f1203n = CancelledItemsModel.m1045a(storyAttachmentTargetFragmentModel.mo84p());
            builder.f1204o = storyAttachmentTargetFragmentModel.mo69v();
            builder.f1205p = storyAttachmentTargetFragmentModel.ad();
            builder.f1206q = storyAttachmentTargetFragmentModel.ae();
            builder.f1207r = CommerceLocationModel.m1034a(storyAttachmentTargetFragmentModel.mo70w());
            builder.f1208s = CommerceLocationModel.m1034a(storyAttachmentTargetFragmentModel.mo71x());
            builder.f1209t = storyAttachmentTargetFragmentModel.af();
            builder.f1210u = CoordinatesModel.m1581a(storyAttachmentTargetFragmentModel.ag());
            builder.f1211v = CoverPhotoModel.m1496a(storyAttachmentTargetFragmentModel.ah());
            builder.f1212w = storyAttachmentTargetFragmentModel.ai();
            builder.f1213x = storyAttachmentTargetFragmentModel.mo72y();
            builder.f1214y = storyAttachmentTargetFragmentModel.aj();
            builder.f1215z = storyAttachmentTargetFragmentModel.ak();
            builder.f1164A = storyAttachmentTargetFragmentModel.al();
            builder.f1165B = storyAttachmentTargetFragmentModel.am();
            builder.f1166C = BusinessRideLocationModel.m3219a(storyAttachmentTargetFragmentModel.an());
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < storyAttachmentTargetFragmentModel.ao().size(); i2++) {
                builder2.c(MovieButtonFragmentModel.m884a((MovieButtonFragmentModel) storyAttachmentTargetFragmentModel.ao().get(i2)));
            }
            builder.f1167D = builder2.b();
            builder.f1168E = storyAttachmentTargetFragmentModel.ap();
            builder.f1169F = storyAttachmentTargetFragmentModel.aq();
            builder.f1170G = storyAttachmentTargetFragmentModel.ar();
            builder.f1171H = storyAttachmentTargetFragmentModel.as();
            builder.f1172I = storyAttachmentTargetFragmentModel.at();
            builder.f1173J = storyAttachmentTargetFragmentModel.mo73z();
            builder.f1174K = EventCoordinatesModel.m1552a(storyAttachmentTargetFragmentModel.au());
            builder.f1175L = storyAttachmentTargetFragmentModel.av();
            builder.f1176M = EventPlaceModel.m1561a(storyAttachmentTargetFragmentModel.aw());
            builder.f1177N = storyAttachmentTargetFragmentModel.ax();
            builder.f1178O = storyAttachmentTargetFragmentModel.mo97d();
            builder.f1179P = storyAttachmentTargetFragmentModel.ay();
            builder.f1180Q = AirlineFlightInfoModel.m3126a(storyAttachmentTargetFragmentModel.az());
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < storyAttachmentTargetFragmentModel.aA().size(); i2++) {
                builder2.c(AirlineFlightInfoModel.m3126a((AirlineFlightInfoModel) storyAttachmentTargetFragmentModel.aA().get(i2)));
            }
            builder.f1181R = builder2.b();
            builder.f1182S = storyAttachmentTargetFragmentModel.aB();
            builder.f1183T = storyAttachmentTargetFragmentModel.aC();
            builder.f1184U = storyAttachmentTargetFragmentModel.aD();
            builder.f1185V = storyAttachmentTargetFragmentModel.aE();
            builder.f1186W = FundraiserDetailedProgressTextModel.m1462a(storyAttachmentTargetFragmentModel.mo114J());
            builder.f1187X = FundraiserForCharityTextModel.m1468a(storyAttachmentTargetFragmentModel.mo115K());
            builder.f1188Y = GroupFriendMembersModel.m1504a(storyAttachmentTargetFragmentModel.aF());
            builder.f1189Z = GroupMembersModel.m1511a(storyAttachmentTargetFragmentModel.aG());
            builder.aa = storyAttachmentTargetFragmentModel.mo68c();
            builder.ab = storyAttachmentTargetFragmentModel.ax_();
            builder.ac = storyAttachmentTargetFragmentModel.aH();
            builder.ad = storyAttachmentTargetFragmentModel.aI();
            builder.ae = ItemModel.m2980a(storyAttachmentTargetFragmentModel.aJ());
            builder.af = ItineraryLegsModel.m3105a(storyAttachmentTargetFragmentModel.aK());
            builder.ag = storyAttachmentTargetFragmentModel.aL();
            builder.ah = LogoImageModel.m1220a(storyAttachmentTargetFragmentModel.aM());
            builder.ai = MovieImageFragmentModel.m910a(storyAttachmentTargetFragmentModel.aN());
            builder.aj = storyAttachmentTargetFragmentModel.aO();
            builder.ak = CommerceLocationModel.m1034a(storyAttachmentTargetFragmentModel.mo79l());
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < storyAttachmentTargetFragmentModel.aP().size(); i2++) {
                builder2.c(MovieDetailsFragmentModel.m898a((MovieDetailsFragmentModel) storyAttachmentTargetFragmentModel.aP().get(i2)));
            }
            builder.al = builder2.b();
            builder.am = storyAttachmentTargetFragmentModel.aQ();
            builder.an = storyAttachmentTargetFragmentModel.mo107g();
            builder.ao = storyAttachmentTargetFragmentModel.ay_();
            builder.ap = storyAttachmentTargetFragmentModel.mo60A();
            builder.aq = storyAttachmentTargetFragmentModel.aC_();
            builder.ar = PageModel.m1696a(storyAttachmentTargetFragmentModel.aR());
            builder.as = PartnerLogoModel.m1706a(storyAttachmentTargetFragmentModel.aS());
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < storyAttachmentTargetFragmentModel.aT().size(); i2++) {
                builder2.c(AirlinePassengerModel.m3149a((AirlinePassengerModel) storyAttachmentTargetFragmentModel.aT().get(i2)));
            }
            builder.at = builder2.b();
            builder.au = storyAttachmentTargetFragmentModel.aU();
            builder.av = storyAttachmentTargetFragmentModel.aV();
            builder.aw = storyAttachmentTargetFragmentModel.aW();
            builder.ax = PaymentModel.m1715a(storyAttachmentTargetFragmentModel.aX());
            builder.ay = storyAttachmentTargetFragmentModel.mo125Q();
            builder.az = storyAttachmentTargetFragmentModel.mo119M();
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < storyAttachmentTargetFragmentModel.aY().size(); i2++) {
                builder2.c(MomentsAppInvitationActionLinkFragmentModel.m1609a((MomentsAppInvitationActionLinkFragmentModel) storyAttachmentTargetFragmentModel.aY().get(i2)));
            }
            builder.aA = builder2.b();
            builder.aB = PlaceModel.m1591a(storyAttachmentTargetFragmentModel.aZ());
            builder.aC = PlatformContextModel.m1330a(storyAttachmentTargetFragmentModel.ba());
            builder.aD = MovieDetailsFragmentModel.m898a(storyAttachmentTargetFragmentModel.bb());
            builder.aE = storyAttachmentTargetFragmentModel.bc();
            builder.aF = storyAttachmentTargetFragmentModel.bd();
            builder.aG = storyAttachmentTargetFragmentModel.be();
            builder.aH = PromotionItemsModel.m1120a(storyAttachmentTargetFragmentModel.mo108u());
            builder.aI = CommerceBaseOrderReceiptModel.m1010a(storyAttachmentTargetFragmentModel.mo85q());
            builder.aJ = storyAttachmentTargetFragmentModel.aD_();
            builder.aK = storyAttachmentTargetFragmentModel.ar_();
            builder.aL = ReceiverModel.m1661a(storyAttachmentTargetFragmentModel.mo126R());
            builder.aM = RequesteeModel.m1626a(storyAttachmentTargetFragmentModel.mo120N());
            builder.aN = RequesterModel.m1635a(storyAttachmentTargetFragmentModel.mo121O());
            builder.aO = RetailCarrierModel.m1156a(storyAttachmentTargetFragmentModel.mo61B());
            builder.aP = RetailItemsModel.m1065a(storyAttachmentTargetFragmentModel.mo86r());
            builder.aQ = RetailShipmentItemsModel.m1168a(storyAttachmentTargetFragmentModel.mo62C());
            builder.aR = storyAttachmentTargetFragmentModel.bf();
            builder.aS = RideProviderModel.m3228a(storyAttachmentTargetFragmentModel.bg());
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < storyAttachmentTargetFragmentModel.bh().size(); i2++) {
                builder2.c(MovieButtonFragmentModel.m884a((MovieButtonFragmentModel) storyAttachmentTargetFragmentModel.bh().get(i2)));
            }
            builder.aT = builder2.b();
            builder.aU = storyAttachmentTargetFragmentModel.az_();
            builder.aV = storyAttachmentTargetFragmentModel.bi();
            builder.aW = SenderModel.m1669a(storyAttachmentTargetFragmentModel.mo127S());
            builder.aX = storyAttachmentTargetFragmentModel.mo63D();
            builder.aY = storyAttachmentTargetFragmentModel.bj();
            builder.aZ = storyAttachmentTargetFragmentModel.mo64E();
            builder.ba = CommerceShipmentBubbleModel.m1181a(storyAttachmentTargetFragmentModel.mo109H());
            builder.bb = storyAttachmentTargetFragmentModel.mo80m();
            builder.bc = ShipmentTrackingEventsModel.m1177a(storyAttachmentTargetFragmentModel.mo65F());
            builder.bd = storyAttachmentTargetFragmentModel.bk();
            builder.be = storyAttachmentTargetFragmentModel.bl();
            builder.bf = BusinessRideLocationModel.m3219a(storyAttachmentTargetFragmentModel.bm());
            builder.bg = storyAttachmentTargetFragmentModel.mo99j();
            builder.bh = storyAttachmentTargetFragmentModel.bn();
            builder.bi = storyAttachmentTargetFragmentModel.as_();
            builder.bj = storyAttachmentTargetFragmentModel.mo100k();
            builder.bk = CommerceLocationModel.m1034a(storyAttachmentTargetFragmentModel.aE_());
            builder.bl = SubscribedItemModel.m1105a(storyAttachmentTargetFragmentModel.mo103t());
            builder.bm = storyAttachmentTargetFragmentModel.aF_();
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            while (i < storyAttachmentTargetFragmentModel.bo().size()) {
                builder3.c(MovieTheaterFragmentModel.m924a((MovieTheaterFragmentModel) storyAttachmentTargetFragmentModel.bo().get(i)));
                i++;
            }
            builder.bn = builder3.b();
            builder.bo = storyAttachmentTargetFragmentModel.aG_();
            builder.bp = storyAttachmentTargetFragmentModel.bp();
            builder.bq = storyAttachmentTargetFragmentModel.bq();
            builder.br = storyAttachmentTargetFragmentModel.aH_();
            builder.bs = storyAttachmentTargetFragmentModel.br();
            builder.bt = storyAttachmentTargetFragmentModel.mo81n();
            builder.bu = storyAttachmentTargetFragmentModel.mo82o();
            builder.bv = storyAttachmentTargetFragmentModel.mo66G();
            builder.bw = storyAttachmentTargetFragmentModel.bs();
            builder.bx = TransactionPaymentModel.m1345a(storyAttachmentTargetFragmentModel.bt());
            builder.by = TransactionProductsModel.m1384a(storyAttachmentTargetFragmentModel.bu());
            builder.bz = storyAttachmentTargetFragmentModel.bv();
            builder.bA = storyAttachmentTargetFragmentModel.bw();
            builder.bB = storyAttachmentTargetFragmentModel.bx();
            builder.bC = storyAttachmentTargetFragmentModel.by();
            builder.bD = storyAttachmentTargetFragmentModel.bz();
            builder.bE = storyAttachmentTargetFragmentModel.bA();
            builder.bF = storyAttachmentTargetFragmentModel.bB();
            builder.bG = storyAttachmentTargetFragmentModel.bC();
            builder.bH = storyAttachmentTargetFragmentModel.bD();
            builder.bI = ViewerInviteToGroupModel.m1527a(storyAttachmentTargetFragmentModel.bE());
            builder.bJ = storyAttachmentTargetFragmentModel.bF();
            builder.bK = storyAttachmentTargetFragmentModel.bG();
            return builder.m1692a();
        }

        @Nullable
        public final String m1753a() {
            return mo68c();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m1752a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            com.google.common.collect.ImmutableList.Builder a;
            CommerceLocationModel commerceLocationModel;
            BusinessRideLocationModel businessRideLocationModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (bO() != null) {
                AmountModel amountModel = (AmountModel) graphQLModelMutatingVisitor.b(bO());
                if (bO() != amountModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1257e = amountModel;
                }
            }
            if (bP() != null) {
                BoardingPassesModel boardingPassesModel = (BoardingPassesModel) graphQLModelMutatingVisitor.b(bP());
                if (bP() != boardingPassesModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1259g = boardingPassesModel;
                }
            }
            if (bQ() != null) {
                BusinessItemsModel businessItemsModel = (BusinessItemsModel) graphQLModelMutatingVisitor.b(bQ());
                if (bQ() != businessItemsModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1264l = businessItemsModel;
                }
            }
            if (aa() != null) {
                a = ModelHelper.a(aa(), graphQLModelMutatingVisitor);
                if (a != null) {
                    StoryAttachmentTargetFragmentModel storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentTargetFragmentModel.f1265m = a.b();
                    graphQLVisitableModel = storyAttachmentTargetFragmentModel;
                }
            }
            if (aB_() != null) {
                a = ModelHelper.a(aB_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentTargetFragmentModel.f1266n = a.b();
                    graphQLVisitableModel = storyAttachmentTargetFragmentModel;
                }
            }
            if (bR() != null) {
                FundraiserToCharityFragmentModel fundraiserToCharityFragmentModel = (FundraiserToCharityFragmentModel) graphQLModelMutatingVisitor.b(bR());
                if (bR() != fundraiserToCharityFragmentModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1267o = fundraiserToCharityFragmentModel;
                }
            }
            if (bS() != null) {
                CancelledItemsModel cancelledItemsModel = (CancelledItemsModel) graphQLModelMutatingVisitor.b(bS());
                if (bS() != cancelledItemsModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1269q = cancelledItemsModel;
                }
            }
            if (bT() != null) {
                commerceLocationModel = (CommerceLocationModel) graphQLModelMutatingVisitor.b(bT());
                if (bT() != commerceLocationModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1273u = commerceLocationModel;
                }
            }
            if (bU() != null) {
                commerceLocationModel = (CommerceLocationModel) graphQLModelMutatingVisitor.b(bU());
                if (bU() != commerceLocationModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1274v = commerceLocationModel;
                }
            }
            if (bH() != null) {
                CoordinatesModel coordinatesModel = (CoordinatesModel) graphQLModelMutatingVisitor.b(bH());
                if (bH() != coordinatesModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1276x = coordinatesModel;
                }
            }
            if (bV() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(bV());
                if (bV() != coverPhotoModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1277y = coverPhotoModel;
                }
            }
            if (bW() != null) {
                businessRideLocationModel = (BusinessRideLocationModel) graphQLModelMutatingVisitor.b(bW());
                if (bW() != businessRideLocationModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1235F = businessRideLocationModel;
                }
            }
            if (ao() != null) {
                a = ModelHelper.a(ao(), graphQLModelMutatingVisitor);
                if (a != null) {
                    storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentTargetFragmentModel.f1236G = a.b();
                    graphQLVisitableModel = storyAttachmentTargetFragmentModel;
                }
            }
            if (bI() != null) {
                EventCoordinatesModel eventCoordinatesModel = (EventCoordinatesModel) graphQLModelMutatingVisitor.b(bI());
                if (bI() != eventCoordinatesModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1243N = eventCoordinatesModel;
                }
            }
            if (bJ() != null) {
                EventPlaceModel eventPlaceModel = (EventPlaceModel) graphQLModelMutatingVisitor.b(bJ());
                if (bJ() != eventPlaceModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1245P = eventPlaceModel;
                }
            }
            if (bX() != null) {
                AirlineFlightInfoModel airlineFlightInfoModel = (AirlineFlightInfoModel) graphQLModelMutatingVisitor.b(bX());
                if (bX() != airlineFlightInfoModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1249T = airlineFlightInfoModel;
                }
            }
            if (aA() != null) {
                a = ModelHelper.a(aA(), graphQLModelMutatingVisitor);
                if (a != null) {
                    storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentTargetFragmentModel.f1250U = a.b();
                    graphQLVisitableModel = storyAttachmentTargetFragmentModel;
                }
            }
            if (bY() != null) {
                FundraiserDetailedProgressTextModel fundraiserDetailedProgressTextModel = (FundraiserDetailedProgressTextModel) graphQLModelMutatingVisitor.b(bY());
                if (bY() != fundraiserDetailedProgressTextModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1255Z = fundraiserDetailedProgressTextModel;
                }
            }
            if (bZ() != null) {
                FundraiserForCharityTextModel fundraiserForCharityTextModel = (FundraiserForCharityTextModel) graphQLModelMutatingVisitor.b(bZ());
                if (bZ() != fundraiserForCharityTextModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aa = fundraiserForCharityTextModel;
                }
            }
            if (ca() != null) {
                GroupFriendMembersModel groupFriendMembersModel = (GroupFriendMembersModel) graphQLModelMutatingVisitor.b(ca());
                if (ca() != groupFriendMembersModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ab = groupFriendMembersModel;
                }
            }
            if (cb() != null) {
                GroupMembersModel groupMembersModel = (GroupMembersModel) graphQLModelMutatingVisitor.b(cb());
                if (cb() != groupMembersModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ac = groupMembersModel;
                }
            }
            if (cc() != null) {
                ItemModel itemModel = (ItemModel) graphQLModelMutatingVisitor.b(cc());
                if (cc() != itemModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ah = itemModel;
                }
            }
            if (cd() != null) {
                ItineraryLegsModel itineraryLegsModel = (ItineraryLegsModel) graphQLModelMutatingVisitor.b(cd());
                if (cd() != itineraryLegsModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ai = itineraryLegsModel;
                }
            }
            if (ce() != null) {
                LogoImageModel logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(ce());
                if (ce() != logoImageModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.ak = logoImageModel;
                }
            }
            if (cf() != null) {
                MovieImageFragmentModel movieImageFragmentModel = (MovieImageFragmentModel) graphQLModelMutatingVisitor.b(cf());
                if (cf() != movieImageFragmentModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.al = movieImageFragmentModel;
                }
            }
            if (cg() != null) {
                commerceLocationModel = (CommerceLocationModel) graphQLModelMutatingVisitor.b(cg());
                if (cg() != commerceLocationModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.an = commerceLocationModel;
                }
            }
            if (aP() != null) {
                a = ModelHelper.a(aP(), graphQLModelMutatingVisitor);
                if (a != null) {
                    storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentTargetFragmentModel.ao = a.b();
                    graphQLVisitableModel = storyAttachmentTargetFragmentModel;
                }
            }
            if (ch() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(ch());
                if (ch() != pageModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.au = pageModel;
                }
            }
            if (ci() != null) {
                PartnerLogoModel partnerLogoModel = (PartnerLogoModel) graphQLModelMutatingVisitor.b(ci());
                if (ci() != partnerLogoModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.av = partnerLogoModel;
                }
            }
            if (aT() != null) {
                a = ModelHelper.a(aT(), graphQLModelMutatingVisitor);
                if (a != null) {
                    storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentTargetFragmentModel.aw = a.b();
                    graphQLVisitableModel = storyAttachmentTargetFragmentModel;
                }
            }
            if (cj() != null) {
                PaymentModel paymentModel = (PaymentModel) graphQLModelMutatingVisitor.b(cj());
                if (cj() != paymentModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aA = paymentModel;
                }
            }
            if (aY() != null) {
                a = ModelHelper.a(aY(), graphQLModelMutatingVisitor);
                if (a != null) {
                    storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentTargetFragmentModel.aD = a.b();
                    graphQLVisitableModel = storyAttachmentTargetFragmentModel;
                }
            }
            if (bK() != null) {
                PlaceModel placeModel = (PlaceModel) graphQLModelMutatingVisitor.b(bK());
                if (bK() != placeModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aE = placeModel;
                }
            }
            if (ck() != null) {
                PlatformContextModel platformContextModel = (PlatformContextModel) graphQLModelMutatingVisitor.b(ck());
                if (ck() != platformContextModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aF = platformContextModel;
                }
            }
            if (cl() != null) {
                MovieDetailsFragmentModel movieDetailsFragmentModel = (MovieDetailsFragmentModel) graphQLModelMutatingVisitor.b(cl());
                if (cl() != movieDetailsFragmentModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aG = movieDetailsFragmentModel;
                }
            }
            if (cm() != null) {
                PromotionItemsModel promotionItemsModel = (PromotionItemsModel) graphQLModelMutatingVisitor.b(cm());
                if (cm() != promotionItemsModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aK = promotionItemsModel;
                }
            }
            if (cn() != null) {
                CommerceBaseOrderReceiptModel commerceBaseOrderReceiptModel = (CommerceBaseOrderReceiptModel) graphQLModelMutatingVisitor.b(cn());
                if (cn() != commerceBaseOrderReceiptModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aL = commerceBaseOrderReceiptModel;
                }
            }
            if (co() != null) {
                ReceiverModel receiverModel = (ReceiverModel) graphQLModelMutatingVisitor.b(co());
                if (co() != receiverModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aO = receiverModel;
                }
            }
            if (cp() != null) {
                RequesteeModel requesteeModel = (RequesteeModel) graphQLModelMutatingVisitor.b(cp());
                if (cp() != requesteeModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aP = requesteeModel;
                }
            }
            if (cq() != null) {
                RequesterModel requesterModel = (RequesterModel) graphQLModelMutatingVisitor.b(cq());
                if (cq() != requesterModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aQ = requesterModel;
                }
            }
            if (cr() != null) {
                RetailCarrierModel retailCarrierModel = (RetailCarrierModel) graphQLModelMutatingVisitor.b(cr());
                if (cr() != retailCarrierModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aR = retailCarrierModel;
                }
            }
            if (cs() != null) {
                RetailItemsModel retailItemsModel = (RetailItemsModel) graphQLModelMutatingVisitor.b(cs());
                if (cs() != retailItemsModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aS = retailItemsModel;
                }
            }
            if (ct() != null) {
                RetailShipmentItemsModel retailShipmentItemsModel = (RetailShipmentItemsModel) graphQLModelMutatingVisitor.b(ct());
                if (ct() != retailShipmentItemsModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aT = retailShipmentItemsModel;
                }
            }
            if (cu() != null) {
                RideProviderModel rideProviderModel = (RideProviderModel) graphQLModelMutatingVisitor.b(cu());
                if (cu() != rideProviderModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aV = rideProviderModel;
                }
            }
            if (bh() != null) {
                a = ModelHelper.a(bh(), graphQLModelMutatingVisitor);
                if (a != null) {
                    storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentTargetFragmentModel.aW = a.b();
                    graphQLVisitableModel = storyAttachmentTargetFragmentModel;
                }
            }
            if (cv() != null) {
                SenderModel senderModel = (SenderModel) graphQLModelMutatingVisitor.b(cv());
                if (cv() != senderModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.aZ = senderModel;
                }
            }
            if (cw() != null) {
                CommerceShipmentBubbleModel commerceShipmentBubbleModel = (CommerceShipmentBubbleModel) graphQLModelMutatingVisitor.b(cw());
                if (cw() != commerceShipmentBubbleModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.bd = commerceShipmentBubbleModel;
                }
            }
            if (cx() != null) {
                ShipmentTrackingEventsModel shipmentTrackingEventsModel = (ShipmentTrackingEventsModel) graphQLModelMutatingVisitor.b(cx());
                if (cx() != shipmentTrackingEventsModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.bf = shipmentTrackingEventsModel;
                }
            }
            if (cy() != null) {
                businessRideLocationModel = (BusinessRideLocationModel) graphQLModelMutatingVisitor.b(cy());
                if (cy() != businessRideLocationModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.bi = businessRideLocationModel;
                }
            }
            if (cz() != null) {
                commerceLocationModel = (CommerceLocationModel) graphQLModelMutatingVisitor.b(cz());
                if (cz() != commerceLocationModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.bn = commerceLocationModel;
                }
            }
            if (cA() != null) {
                SubscribedItemModel subscribedItemModel = (SubscribedItemModel) graphQLModelMutatingVisitor.b(cA());
                if (cA() != subscribedItemModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.bo = subscribedItemModel;
                }
            }
            if (bo() != null) {
                a = ModelHelper.a(bo(), graphQLModelMutatingVisitor);
                if (a != null) {
                    storyAttachmentTargetFragmentModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    storyAttachmentTargetFragmentModel.bq = a.b();
                    graphQLVisitableModel = storyAttachmentTargetFragmentModel;
                }
            }
            if (cB() != null) {
                TransactionPaymentModel transactionPaymentModel = (TransactionPaymentModel) graphQLModelMutatingVisitor.b(cB());
                if (cB() != transactionPaymentModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.bA = transactionPaymentModel;
                }
            }
            if (cC() != null) {
                TransactionProductsModel transactionProductsModel = (TransactionProductsModel) graphQLModelMutatingVisitor.b(cC());
                if (cC() != transactionProductsModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.bB = transactionProductsModel;
                }
            }
            if (cD() != null) {
                ViewerInviteToGroupModel viewerInviteToGroupModel = (ViewerInviteToGroupModel) graphQLModelMutatingVisitor.b(cD());
                if (cD() != viewerInviteToGroupModel) {
                    graphQLVisitableModel = (StoryAttachmentTargetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.bL = viewerInviteToGroupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1751a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo113I());
            int a2 = ModelHelper.a(flatBufferBuilder, bO());
            int b = flatBufferBuilder.b(m1745U());
            int a3 = ModelHelper.a(flatBufferBuilder, bP());
            int b2 = flatBufferBuilder.b(m1747W());
            int b3 = flatBufferBuilder.b(m1748X());
            int b4 = flatBufferBuilder.b(m1749Y());
            int a4 = flatBufferBuilder.a(mo67b());
            int a5 = ModelHelper.a(flatBufferBuilder, bQ());
            int a6 = ModelHelper.a(flatBufferBuilder, aa());
            int a7 = ModelHelper.a(flatBufferBuilder, aB_());
            int a8 = ModelHelper.a(flatBufferBuilder, bR());
            int a9 = ModelHelper.a(flatBufferBuilder, bS());
            int b5 = flatBufferBuilder.b(mo69v());
            int b6 = flatBufferBuilder.b(ad());
            int b7 = flatBufferBuilder.b(ae());
            int a10 = ModelHelper.a(flatBufferBuilder, bT());
            int a11 = ModelHelper.a(flatBufferBuilder, bU());
            int a12 = flatBufferBuilder.a(af());
            int a13 = ModelHelper.a(flatBufferBuilder, bH());
            int a14 = ModelHelper.a(flatBufferBuilder, bV());
            int b8 = flatBufferBuilder.b(ai());
            int b9 = flatBufferBuilder.b(mo72y());
            int b10 = flatBufferBuilder.b(aj());
            int b11 = flatBufferBuilder.b(ak());
            int b12 = flatBufferBuilder.b(al());
            int b13 = flatBufferBuilder.b(am());
            int a15 = ModelHelper.a(flatBufferBuilder, bW());
            int a16 = ModelHelper.a(flatBufferBuilder, ao());
            int b14 = flatBufferBuilder.b(ap());
            int b15 = flatBufferBuilder.b(aq());
            int b16 = flatBufferBuilder.b(as());
            int b17 = flatBufferBuilder.b(mo73z());
            int a17 = ModelHelper.a(flatBufferBuilder, bI());
            int a18 = flatBufferBuilder.a(av());
            int a19 = ModelHelper.a(flatBufferBuilder, bJ());
            int b18 = flatBufferBuilder.b(ax());
            int b19 = flatBufferBuilder.b(mo97d());
            int b20 = flatBufferBuilder.b(ay());
            int a20 = ModelHelper.a(flatBufferBuilder, bX());
            int a21 = ModelHelper.a(flatBufferBuilder, aA());
            int b21 = flatBufferBuilder.b(aB());
            int b22 = flatBufferBuilder.b(aC());
            int b23 = flatBufferBuilder.b(aD());
            int b24 = flatBufferBuilder.b(aE());
            int a22 = ModelHelper.a(flatBufferBuilder, bY());
            int a23 = ModelHelper.a(flatBufferBuilder, bZ());
            int a24 = ModelHelper.a(flatBufferBuilder, ca());
            int a25 = ModelHelper.a(flatBufferBuilder, cb());
            int b25 = flatBufferBuilder.b(mo68c());
            int b26 = flatBufferBuilder.b(ax_());
            int a26 = ModelHelper.a(flatBufferBuilder, cc());
            int a27 = ModelHelper.a(flatBufferBuilder, cd());
            int b27 = flatBufferBuilder.b(aL());
            int a28 = ModelHelper.a(flatBufferBuilder, ce());
            int a29 = ModelHelper.a(flatBufferBuilder, cf());
            int b28 = flatBufferBuilder.b(aO());
            int a30 = ModelHelper.a(flatBufferBuilder, cg());
            int a31 = ModelHelper.a(flatBufferBuilder, aP());
            int a32 = flatBufferBuilder.a(aQ());
            int b29 = flatBufferBuilder.b(mo107g());
            int b30 = flatBufferBuilder.b(ay_());
            int b31 = flatBufferBuilder.b(mo60A());
            int b32 = flatBufferBuilder.b(aC_());
            int a33 = ModelHelper.a(flatBufferBuilder, ch());
            int a34 = ModelHelper.a(flatBufferBuilder, ci());
            int a35 = ModelHelper.a(flatBufferBuilder, aT());
            int b33 = flatBufferBuilder.b(aU());
            int b34 = flatBufferBuilder.b(aV());
            int b35 = flatBufferBuilder.b(aW());
            int a36 = ModelHelper.a(flatBufferBuilder, cj());
            int b36 = flatBufferBuilder.b(mo125Q());
            int b37 = flatBufferBuilder.b(mo119M());
            int a37 = ModelHelper.a(flatBufferBuilder, aY());
            int a38 = ModelHelper.a(flatBufferBuilder, bK());
            int a39 = ModelHelper.a(flatBufferBuilder, ck());
            int a40 = ModelHelper.a(flatBufferBuilder, cl());
            int b38 = flatBufferBuilder.b(bc());
            int b39 = flatBufferBuilder.b(bd());
            int b40 = flatBufferBuilder.b(be());
            int a41 = ModelHelper.a(flatBufferBuilder, cm());
            int a42 = ModelHelper.a(flatBufferBuilder, cn());
            int b41 = flatBufferBuilder.b(aD_());
            int b42 = flatBufferBuilder.b(ar_());
            int a43 = ModelHelper.a(flatBufferBuilder, co());
            int a44 = ModelHelper.a(flatBufferBuilder, cp());
            int a45 = ModelHelper.a(flatBufferBuilder, cq());
            int a46 = ModelHelper.a(flatBufferBuilder, cr());
            int a47 = ModelHelper.a(flatBufferBuilder, cs());
            int a48 = ModelHelper.a(flatBufferBuilder, ct());
            int b43 = flatBufferBuilder.b(bf());
            int a49 = ModelHelper.a(flatBufferBuilder, cu());
            int a50 = ModelHelper.a(flatBufferBuilder, bh());
            int b44 = flatBufferBuilder.b(az_());
            int b45 = flatBufferBuilder.b(bi());
            int a51 = ModelHelper.a(flatBufferBuilder, cv());
            int b46 = flatBufferBuilder.b(mo63D());
            int b47 = flatBufferBuilder.b(bj());
            int b48 = flatBufferBuilder.b(mo64E());
            int a52 = ModelHelper.a(flatBufferBuilder, cw());
            int a53 = flatBufferBuilder.a(mo80m());
            int a54 = ModelHelper.a(flatBufferBuilder, cx());
            int b49 = flatBufferBuilder.b(bk());
            int b50 = flatBufferBuilder.b(bl());
            int a55 = ModelHelper.a(flatBufferBuilder, cy());
            int b51 = flatBufferBuilder.b(mo99j());
            int b52 = flatBufferBuilder.b(as_());
            int a56 = flatBufferBuilder.a(mo100k());
            int a57 = ModelHelper.a(flatBufferBuilder, cz());
            int a58 = ModelHelper.a(flatBufferBuilder, cA());
            int b53 = flatBufferBuilder.b(aF_());
            int a59 = ModelHelper.a(flatBufferBuilder, bo());
            int b54 = flatBufferBuilder.b(aG_());
            int b55 = flatBufferBuilder.b(bp());
            int b56 = flatBufferBuilder.b(bq());
            int b57 = flatBufferBuilder.b(aH_());
            int b58 = flatBufferBuilder.b(br());
            int b59 = flatBufferBuilder.b(mo81n());
            int b60 = flatBufferBuilder.b(mo82o());
            int b61 = flatBufferBuilder.b(mo66G());
            int a60 = ModelHelper.a(flatBufferBuilder, cB());
            int a61 = ModelHelper.a(flatBufferBuilder, cC());
            int a62 = flatBufferBuilder.a(bv());
            int b62 = flatBufferBuilder.b(bw());
            int b63 = flatBufferBuilder.b(bz());
            int b64 = flatBufferBuilder.b(bA());
            int b65 = flatBufferBuilder.b(bB());
            int b66 = flatBufferBuilder.b(bC());
            int a63 = flatBufferBuilder.a(bD());
            int a64 = ModelHelper.a(flatBufferBuilder, cD());
            int a65 = flatBufferBuilder.a(bF());
            int a66 = flatBufferBuilder.a(bG());
            flatBufferBuilder.c(141);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, b4);
            flatBufferBuilder.b(7, a4);
            flatBufferBuilder.b(8, a5);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.b(10, a7);
            flatBufferBuilder.b(11, a8);
            flatBufferBuilder.a(12, this.f1268p);
            flatBufferBuilder.b(13, a9);
            flatBufferBuilder.b(14, b5);
            flatBufferBuilder.b(15, b6);
            flatBufferBuilder.b(16, b7);
            flatBufferBuilder.b(17, a10);
            flatBufferBuilder.b(18, a11);
            flatBufferBuilder.b(19, a12);
            flatBufferBuilder.b(20, a13);
            flatBufferBuilder.b(21, a14);
            flatBufferBuilder.b(22, b8);
            flatBufferBuilder.b(23, b9);
            flatBufferBuilder.b(24, b10);
            flatBufferBuilder.b(25, b11);
            flatBufferBuilder.b(26, b12);
            flatBufferBuilder.b(27, b13);
            flatBufferBuilder.b(28, a15);
            flatBufferBuilder.b(29, a16);
            flatBufferBuilder.b(30, b14);
            flatBufferBuilder.b(31, b15);
            flatBufferBuilder.a(32, this.f1239J, 0.0d);
            flatBufferBuilder.b(33, b16);
            flatBufferBuilder.a(34, this.f1241L, 0);
            flatBufferBuilder.b(35, b17);
            flatBufferBuilder.b(36, a17);
            flatBufferBuilder.b(37, a18);
            flatBufferBuilder.b(38, a19);
            flatBufferBuilder.b(39, b18);
            flatBufferBuilder.b(40, b19);
            flatBufferBuilder.b(41, b20);
            flatBufferBuilder.b(42, a20);
            flatBufferBuilder.b(43, a21);
            flatBufferBuilder.b(44, b21);
            flatBufferBuilder.b(45, b22);
            flatBufferBuilder.b(46, b23);
            flatBufferBuilder.b(47, b24);
            flatBufferBuilder.b(48, a22);
            flatBufferBuilder.b(49, a23);
            flatBufferBuilder.b(50, a24);
            flatBufferBuilder.b(51, a25);
            flatBufferBuilder.b(52, b25);
            flatBufferBuilder.b(53, b26);
            flatBufferBuilder.a(54, this.af);
            flatBufferBuilder.a(55, this.ag);
            flatBufferBuilder.b(56, a26);
            flatBufferBuilder.b(57, a27);
            flatBufferBuilder.b(58, b27);
            flatBufferBuilder.b(59, a28);
            flatBufferBuilder.b(60, a29);
            flatBufferBuilder.b(61, b28);
            flatBufferBuilder.b(62, a30);
            flatBufferBuilder.b(63, a31);
            flatBufferBuilder.b(64, a32);
            flatBufferBuilder.b(65, b29);
            flatBufferBuilder.b(66, b30);
            flatBufferBuilder.b(67, b31);
            flatBufferBuilder.b(68, b32);
            flatBufferBuilder.b(69, a33);
            flatBufferBuilder.b(70, a34);
            flatBufferBuilder.b(71, a35);
            flatBufferBuilder.b(72, b33);
            flatBufferBuilder.b(73, b34);
            flatBufferBuilder.b(74, b35);
            flatBufferBuilder.b(75, a36);
            flatBufferBuilder.b(76, b36);
            flatBufferBuilder.b(77, b37);
            flatBufferBuilder.b(78, a37);
            flatBufferBuilder.b(79, a38);
            flatBufferBuilder.b(80, a39);
            flatBufferBuilder.b(81, a40);
            flatBufferBuilder.b(82, b38);
            flatBufferBuilder.b(83, b39);
            flatBufferBuilder.b(84, b40);
            flatBufferBuilder.b(85, a41);
            flatBufferBuilder.b(86, a42);
            flatBufferBuilder.b(87, b41);
            flatBufferBuilder.b(88, b42);
            flatBufferBuilder.b(89, a43);
            flatBufferBuilder.b(90, a44);
            flatBufferBuilder.b(91, a45);
            flatBufferBuilder.b(92, a46);
            flatBufferBuilder.b(93, a47);
            flatBufferBuilder.b(94, a48);
            flatBufferBuilder.b(95, b43);
            flatBufferBuilder.b(96, a49);
            flatBufferBuilder.b(97, a50);
            flatBufferBuilder.b(98, b44);
            flatBufferBuilder.b(99, b45);
            flatBufferBuilder.b(100, a51);
            flatBufferBuilder.b(101, b46);
            flatBufferBuilder.b(102, b47);
            flatBufferBuilder.b(103, b48);
            flatBufferBuilder.b(104, a52);
            flatBufferBuilder.b(105, a53);
            flatBufferBuilder.b(106, a54);
            flatBufferBuilder.b(107, b49);
            flatBufferBuilder.b(108, b50);
            flatBufferBuilder.b(109, a55);
            flatBufferBuilder.b(110, b51);
            flatBufferBuilder.a(111, this.bk, 0);
            flatBufferBuilder.b(112, b52);
            flatBufferBuilder.b(113, a56);
            flatBufferBuilder.b(114, a57);
            flatBufferBuilder.b(115, a58);
            flatBufferBuilder.b(116, b53);
            flatBufferBuilder.b(117, a59);
            flatBufferBuilder.b(118, b54);
            flatBufferBuilder.b(119, b55);
            flatBufferBuilder.b(120, b56);
            flatBufferBuilder.b(121, b57);
            flatBufferBuilder.b(122, b58);
            flatBufferBuilder.b(123, b59);
            flatBufferBuilder.b(124, b60);
            flatBufferBuilder.b(125, b61);
            flatBufferBuilder.a(126, this.bz, 0);
            flatBufferBuilder.b(127, a60);
            flatBufferBuilder.b(128, a61);
            flatBufferBuilder.b(129, a62);
            flatBufferBuilder.b(130, b62);
            flatBufferBuilder.a(131, this.bE, 0);
            flatBufferBuilder.a(132, this.bF, 0);
            flatBufferBuilder.b(133, b63);
            flatBufferBuilder.b(134, b64);
            flatBufferBuilder.b(135, b65);
            flatBufferBuilder.b(136, b66);
            flatBufferBuilder.b(137, a63);
            flatBufferBuilder.b(138, a64);
            flatBufferBuilder.b(139, a65);
            flatBufferBuilder.b(140, a66);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1754a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1268p = mutableFlatBuffer.a(i, 12);
            this.f1239J = mutableFlatBuffer.a(i, 32, 0.0d);
            this.f1241L = mutableFlatBuffer.a(i, 34, 0);
            this.af = mutableFlatBuffer.a(i, 54);
            this.ag = mutableFlatBuffer.a(i, 55);
            this.bk = mutableFlatBuffer.a(i, 111, 0);
            this.bz = mutableFlatBuffer.a(i, 126, 0);
            this.bE = mutableFlatBuffer.a(i, 131, 0);
            this.bF = mutableFlatBuffer.a(i, 132, 0);
        }
    }
}
