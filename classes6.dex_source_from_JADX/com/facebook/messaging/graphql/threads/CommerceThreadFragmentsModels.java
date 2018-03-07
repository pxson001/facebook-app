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
import com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType;
import com.facebook.graphql.enums.GraphQLMessengerRetailItemStatus;
import com.facebook.graphql.enums.GraphQLShipmentTrackingEventType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsModels.PlatformCallToActionModel;
import com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsParsers.PlatformCallToActionParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.BusinessMessage;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceBaseOrderReceipt;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceBaseShipmentTracking;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceOrderCancellationBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceOrderReceiptBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceProductSubscriptionBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceProductSubscriptionBubble.PartnerLogo;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommercePromotions;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceRetailItem;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceShipmentBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceShipmentTrackingBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.LogoImage;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.BusinessMessageParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.BusinessMessageParser.BusinessItemsParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceBaseOrderReceiptParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceBaseShipmentTrackingParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceLocationParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceOrderCancellationBubbleParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceOrderCancellationBubbleParser.CancelledItemsParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceOrderReceiptBubbleParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceOrderReceiptBubbleParser.RetailItemsParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommercePromotionsParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommercePromotionsParser.PromotionItemsParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceRetailItemParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentTrackingBubbleParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.LogoImageParser;
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

/* compiled from: video_creative_editing_metadata */
public class CommerceThreadFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2104334452)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_creative_editing_metadata */
    public final class BusinessMessageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, BusinessMessage {
        @Nullable
        private BusinessItemsModel f817d;
        @Nullable
        private List<PlatformCallToActionModel> f818e;
        @Nullable
        private String f819f;
        @Nullable
        private String f820g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1105566069)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_creative_editing_metadata */
        public final class BusinessItemsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<CommerceRetailItemModel> f816d;

            /* compiled from: video_creative_editing_metadata */
            public final class Builder {
                @Nullable
                public ImmutableList<CommerceRetailItemModel> f815a;
            }

            /* compiled from: video_creative_editing_metadata */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BusinessItemsModel.class, new Deserializer());
                }

                public Object m992a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BusinessItemsParser.m1227a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object businessItemsModel = new BusinessItemsModel();
                    ((BaseModel) businessItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (businessItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) businessItemsModel).a();
                    }
                    return businessItemsModel;
                }
            }

            /* compiled from: video_creative_editing_metadata */
            public class Serializer extends JsonSerializer<BusinessItemsModel> {
                public final void m993a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BusinessItemsModel businessItemsModel = (BusinessItemsModel) obj;
                    if (businessItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(businessItemsModel.m995a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        businessItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BusinessItemsParser.m1228a(businessItemsModel.w_(), businessItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BusinessItemsModel.class, new Serializer());
                }
            }

            public BusinessItemsModel() {
                super(1);
            }

            public BusinessItemsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<CommerceRetailItemModel> m997a() {
                this.f816d = super.a(this.f816d, 0, CommerceRetailItemModel.class);
                return (ImmutableList) this.f816d;
            }

            public static BusinessItemsModel m994a(BusinessItemsModel businessItemsModel) {
                if (businessItemsModel == null) {
                    return null;
                }
                if (businessItemsModel instanceof BusinessItemsModel) {
                    return businessItemsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < businessItemsModel.m997a().size(); i++) {
                    builder2.c(CommerceRetailItemModel.m1137a((CommerceRetailItem) businessItemsModel.m997a().get(i)));
                }
                builder.f815a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f815a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new BusinessItemsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -157191318;
            }

            public final GraphQLVisitableModel m996a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m997a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m997a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (BusinessItemsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f816d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m995a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m997a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessMessageModel.class, new Deserializer());
            }

            public Object m998a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BusinessMessageParser.m1229a(jsonParser);
                Object businessMessageModel = new BusinessMessageModel();
                ((BaseModel) businessMessageModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (businessMessageModel instanceof Postprocessable) {
                    return ((Postprocessable) businessMessageModel).a();
                }
                return businessMessageModel;
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Serializer extends JsonSerializer<BusinessMessageModel> {
            public final void m999a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BusinessMessageModel businessMessageModel = (BusinessMessageModel) obj;
                if (businessMessageModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessMessageModel.m1004a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessMessageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = businessMessageModel.w_();
                int u_ = businessMessageModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("business_items");
                    BusinessItemsParser.m1228a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("call_to_actions");
                    PlatformCallToActionParser.m745a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("snippet");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BusinessMessageModel.class, new Serializer());
            }
        }

        public BusinessMessageModel() {
            super(4);
        }

        @Nullable
        private BusinessItemsModel m1000j() {
            this.f817d = (BusinessItemsModel) super.a(this.f817d, 0, BusinessItemsModel.class);
            return this.f817d;
        }

        @Nonnull
        private ImmutableList<PlatformCallToActionModel> m1001k() {
            this.f818e = super.a(this.f818e, 1, PlatformCallToActionModel.class);
            return (ImmutableList) this.f818e;
        }

        @Nullable
        private String m1002l() {
            this.f819f = super.a(this.f819f, 2);
            return this.f819f;
        }

        @Nullable
        private String m1003m() {
            this.f820g = super.a(this.f820g, 3);
            return this.f820g;
        }

        @Nullable
        public final String m1006a() {
            return m1002l();
        }

        public final int jK_() {
            return 897308852;
        }

        public final GraphQLVisitableModel m1005a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1000j() != null) {
                BusinessItemsModel businessItemsModel = (BusinessItemsModel) graphQLModelMutatingVisitor.b(m1000j());
                if (m1000j() != businessItemsModel) {
                    graphQLVisitableModel = (BusinessMessageModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f817d = businessItemsModel;
                }
            }
            if (m1001k() != null) {
                Builder a = ModelHelper.a(m1001k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    BusinessMessageModel businessMessageModel = (BusinessMessageModel) ModelHelper.a(graphQLVisitableModel, this);
                    businessMessageModel.f818e = a.b();
                    graphQLVisitableModel = businessMessageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1004a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1000j());
            int a2 = ModelHelper.a(flatBufferBuilder, m1001k());
            int b = flatBufferBuilder.b(m1002l());
            int b2 = flatBufferBuilder.b(m1003m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -327467851)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_creative_editing_metadata */
    public final class CommerceBaseOrderReceiptModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CommerceBaseOrderReceipt {
        @Nullable
        private GraphQLMessengerCommerceBubbleType f830d;
        @Nullable
        private String f831e;
        @Nullable
        private String f832f;
        @Nullable
        private LogoImageModel f833g;
        @Nullable
        private String f834h;
        @Nullable
        private String f835i;
        @Nullable
        private String f836j;
        @Nullable
        private CommerceLocationModel f837k;
        @Nullable
        private String f838l;

        /* compiled from: video_creative_editing_metadata */
        public final class Builder {
            @Nullable
            public GraphQLMessengerCommerceBubbleType f821a;
            @Nullable
            public String f822b;
            @Nullable
            public String f823c;
            @Nullable
            public LogoImageModel f824d;
            @Nullable
            public String f825e;
            @Nullable
            public String f826f;
            @Nullable
            public String f827g;
            @Nullable
            public CommerceLocationModel f828h;
            @Nullable
            public String f829i;

            public final CommerceBaseOrderReceiptModel m1007a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = flatBufferBuilder.a(this.f821a);
                int b = flatBufferBuilder.b(this.f822b);
                int b2 = flatBufferBuilder.b(this.f823c);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f824d);
                int b3 = flatBufferBuilder.b(this.f825e);
                int b4 = flatBufferBuilder.b(this.f826f);
                int b5 = flatBufferBuilder.b(this.f827g);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f828h);
                int b6 = flatBufferBuilder.b(this.f829i);
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, b4);
                flatBufferBuilder.b(6, b5);
                flatBufferBuilder.b(7, a3);
                flatBufferBuilder.b(8, b6);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CommerceBaseOrderReceiptModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceBaseOrderReceiptModel.class, new Deserializer());
            }

            public Object m1008a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommerceBaseOrderReceiptParser.m1230a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commerceBaseOrderReceiptModel = new CommerceBaseOrderReceiptModel();
                ((BaseModel) commerceBaseOrderReceiptModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commerceBaseOrderReceiptModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceBaseOrderReceiptModel).a();
                }
                return commerceBaseOrderReceiptModel;
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Serializer extends JsonSerializer<CommerceBaseOrderReceiptModel> {
            public final void m1009a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceBaseOrderReceiptModel commerceBaseOrderReceiptModel = (CommerceBaseOrderReceiptModel) obj;
                if (commerceBaseOrderReceiptModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceBaseOrderReceiptModel.m1013a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceBaseOrderReceiptModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceBaseOrderReceiptParser.m1231a(commerceBaseOrderReceiptModel.w_(), commerceBaseOrderReceiptModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommerceBaseOrderReceiptModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CommerceLocationModel aE_() {
            return m1012m();
        }

        @Nullable
        public final /* synthetic */ LogoImage at_() {
            return m1011l();
        }

        public CommerceBaseOrderReceiptModel() {
            super(9);
        }

        public CommerceBaseOrderReceiptModel(MutableFlatBuffer mutableFlatBuffer) {
            super(9);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLMessengerCommerceBubbleType mo57b() {
            this.f830d = (GraphQLMessengerCommerceBubbleType) super.b(this.f830d, 0, GraphQLMessengerCommerceBubbleType.class, GraphQLMessengerCommerceBubbleType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f830d;
        }

        @Nullable
        public final String mo58c() {
            this.f831e = super.a(this.f831e, 1);
            return this.f831e;
        }

        @Nullable
        public final String aC_() {
            this.f832f = super.a(this.f832f, 2);
            return this.f832f;
        }

        @Nullable
        private LogoImageModel m1011l() {
            this.f833g = (LogoImageModel) super.a(this.f833g, 3, LogoImageModel.class);
            return this.f833g;
        }

        @Nullable
        public final String aD_() {
            this.f834h = super.a(this.f834h, 4);
            return this.f834h;
        }

        @Nullable
        public final String ar_() {
            this.f835i = super.a(this.f835i, 5);
            return this.f835i;
        }

        @Nullable
        public final String as_() {
            this.f836j = super.a(this.f836j, 6);
            return this.f836j;
        }

        @Nullable
        private CommerceLocationModel m1012m() {
            this.f837k = (CommerceLocationModel) super.a(this.f837k, 7, CommerceLocationModel.class);
            return this.f837k;
        }

        @Nullable
        public final String aH_() {
            this.f838l = super.a(this.f838l, 8);
            return this.f838l;
        }

        public static CommerceBaseOrderReceiptModel m1010a(CommerceBaseOrderReceipt commerceBaseOrderReceipt) {
            if (commerceBaseOrderReceipt == null) {
                return null;
            }
            if (commerceBaseOrderReceipt instanceof CommerceBaseOrderReceiptModel) {
                return (CommerceBaseOrderReceiptModel) commerceBaseOrderReceipt;
            }
            Builder builder = new Builder();
            builder.f821a = commerceBaseOrderReceipt.mo57b();
            builder.f822b = commerceBaseOrderReceipt.mo58c();
            builder.f823c = commerceBaseOrderReceipt.aC_();
            builder.f824d = LogoImageModel.m1220a(commerceBaseOrderReceipt.at_());
            builder.f825e = commerceBaseOrderReceipt.aD_();
            builder.f826f = commerceBaseOrderReceipt.ar_();
            builder.f827g = commerceBaseOrderReceipt.as_();
            builder.f828h = CommerceLocationModel.m1034a(commerceBaseOrderReceipt.aE_());
            builder.f829i = commerceBaseOrderReceipt.aH_();
            return builder.m1007a();
        }

        @Nullable
        public final String m1015a() {
            return mo58c();
        }

        public final int jK_() {
            return -1649510526;
        }

        public final GraphQLVisitableModel m1014a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1011l() != null) {
                LogoImageModel logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(m1011l());
                if (m1011l() != logoImageModel) {
                    graphQLVisitableModel = (CommerceBaseOrderReceiptModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f833g = logoImageModel;
                }
            }
            if (m1012m() != null) {
                CommerceLocationModel commerceLocationModel = (CommerceLocationModel) graphQLModelMutatingVisitor.b(m1012m());
                if (m1012m() != commerceLocationModel) {
                    graphQLVisitableModel = (CommerceBaseOrderReceiptModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f837k = commerceLocationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1013a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(mo57b());
            int b = flatBufferBuilder.b(mo58c());
            int b2 = flatBufferBuilder.b(aC_());
            int a2 = ModelHelper.a(flatBufferBuilder, m1011l());
            int b3 = flatBufferBuilder.b(aD_());
            int b4 = flatBufferBuilder.b(ar_());
            int b5 = flatBufferBuilder.b(as_());
            int a3 = ModelHelper.a(flatBufferBuilder, m1012m());
            int b6 = flatBufferBuilder.b(aH_());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.b(6, b5);
            flatBufferBuilder.b(7, a3);
            flatBufferBuilder.b(8, b6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1793804002)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_creative_editing_metadata */
    public final class CommerceBaseShipmentTrackingModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CommerceBaseShipmentTracking {
        @Nullable
        private GraphQLMessengerCommerceBubbleType f845d;
        @Nullable
        private String f846e;
        @Nullable
        private CommerceLocationModel f847f;
        @Nullable
        private GraphQLShipmentTrackingEventType f848g;
        @Nullable
        private String f849h;
        @Nullable
        private String f850i;

        /* compiled from: video_creative_editing_metadata */
        public final class Builder {
            @Nullable
            public GraphQLMessengerCommerceBubbleType f839a;
            @Nullable
            public String f840b;
            @Nullable
            public CommerceLocationModel f841c;
            @Nullable
            public GraphQLShipmentTrackingEventType f842d;
            @Nullable
            public String f843e;
            @Nullable
            public String f844f;
        }

        /* compiled from: video_creative_editing_metadata */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceBaseShipmentTrackingModel.class, new Deserializer());
            }

            public Object m1018a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommerceBaseShipmentTrackingParser.m1232b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commerceBaseShipmentTrackingModel = new CommerceBaseShipmentTrackingModel();
                ((BaseModel) commerceBaseShipmentTrackingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commerceBaseShipmentTrackingModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceBaseShipmentTrackingModel).a();
                }
                return commerceBaseShipmentTrackingModel;
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Serializer extends JsonSerializer<CommerceBaseShipmentTrackingModel> {
            public final void m1019a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceBaseShipmentTrackingModel commerceBaseShipmentTrackingModel = (CommerceBaseShipmentTrackingModel) obj;
                if (commerceBaseShipmentTrackingModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceBaseShipmentTrackingModel.m1022a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceBaseShipmentTrackingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceBaseShipmentTrackingParser.m1233b(commerceBaseShipmentTrackingModel.w_(), commerceBaseShipmentTrackingModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommerceBaseShipmentTrackingModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CommerceLocationModel mo79l() {
            return m1021j();
        }

        public CommerceBaseShipmentTrackingModel() {
            super(6);
        }

        public CommerceBaseShipmentTrackingModel(MutableFlatBuffer mutableFlatBuffer) {
            super(6);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLMessengerCommerceBubbleType mo77b() {
            this.f845d = (GraphQLMessengerCommerceBubbleType) super.b(this.f845d, 0, GraphQLMessengerCommerceBubbleType.class, GraphQLMessengerCommerceBubbleType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f845d;
        }

        @Nullable
        public final String mo78c() {
            this.f846e = super.a(this.f846e, 1);
            return this.f846e;
        }

        @Nullable
        private CommerceLocationModel m1021j() {
            this.f847f = (CommerceLocationModel) super.a(this.f847f, 2, CommerceLocationModel.class);
            return this.f847f;
        }

        @Nullable
        public final GraphQLShipmentTrackingEventType mo80m() {
            this.f848g = (GraphQLShipmentTrackingEventType) super.b(this.f848g, 3, GraphQLShipmentTrackingEventType.class, GraphQLShipmentTrackingEventType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f848g;
        }

        @Nullable
        public final String mo81n() {
            this.f849h = super.a(this.f849h, 4);
            return this.f849h;
        }

        @Nullable
        public final String mo82o() {
            this.f850i = super.a(this.f850i, 5);
            return this.f850i;
        }

        public static CommerceBaseShipmentTrackingModel m1020a(CommerceBaseShipmentTracking commerceBaseShipmentTracking) {
            if (commerceBaseShipmentTracking == null) {
                return null;
            }
            if (commerceBaseShipmentTracking instanceof CommerceBaseShipmentTrackingModel) {
                return (CommerceBaseShipmentTrackingModel) commerceBaseShipmentTracking;
            }
            Builder builder = new Builder();
            builder.f839a = commerceBaseShipmentTracking.mo77b();
            builder.f840b = commerceBaseShipmentTracking.mo78c();
            builder.f841c = CommerceLocationModel.m1034a(commerceBaseShipmentTracking.mo79l());
            builder.f842d = commerceBaseShipmentTracking.mo80m();
            builder.f843e = commerceBaseShipmentTracking.mo81n();
            builder.f844f = commerceBaseShipmentTracking.mo82o();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = flatBufferBuilder.a(builder.f839a);
            int b = flatBufferBuilder.b(builder.f840b);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f841c);
            int a3 = flatBufferBuilder.a(builder.f842d);
            int b2 = flatBufferBuilder.b(builder.f843e);
            int b3 = flatBufferBuilder.b(builder.f844f);
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new CommerceBaseShipmentTrackingModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m1024a() {
            return mo78c();
        }

        public final int jK_() {
            return 558867059;
        }

        public final GraphQLVisitableModel m1023a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1021j() != null) {
                CommerceLocationModel commerceLocationModel = (CommerceLocationModel) graphQLModelMutatingVisitor.b(m1021j());
                if (m1021j() != commerceLocationModel) {
                    graphQLVisitableModel = (CommerceBaseShipmentTrackingModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f847f = commerceLocationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1022a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(mo77b());
            int b = flatBufferBuilder.b(mo78c());
            int a2 = ModelHelper.a(flatBufferBuilder, m1021j());
            int a3 = flatBufferBuilder.a(mo80m());
            int b2 = flatBufferBuilder.b(mo81n());
            int b3 = flatBufferBuilder.b(mo82o());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1369228030)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_creative_editing_metadata */
    public final class CommerceLocationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f859d;
        @Nullable
        private String f860e;
        private double f861f;
        private double f862g;
        @Nullable
        private String f863h;
        @Nullable
        private String f864i;
        @Nullable
        private List<String> f865j;
        @Nullable
        private String f866k;

        /* compiled from: video_creative_editing_metadata */
        public final class Builder {
            @Nullable
            public String f851a;
            @Nullable
            public String f852b;
            public double f853c;
            public double f854d;
            @Nullable
            public String f855e;
            @Nullable
            public String f856f;
            @Nullable
            public ImmutableList<String> f857g;
            @Nullable
            public String f858h;

            public final CommerceLocationModel m1031a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f851a);
                int b2 = flatBufferBuilder.b(this.f852b);
                int b3 = flatBufferBuilder.b(this.f855e);
                int b4 = flatBufferBuilder.b(this.f856f);
                int c = flatBufferBuilder.c(this.f857g);
                int b5 = flatBufferBuilder.b(this.f858h);
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.a(2, this.f853c, 0.0d);
                flatBufferBuilder.a(3, this.f854d, 0.0d);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, b4);
                flatBufferBuilder.b(6, c);
                flatBufferBuilder.b(7, b5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CommerceLocationModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceLocationModel.class, new Deserializer());
            }

            public Object m1032a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommerceLocationParser.m1234a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commerceLocationModel = new CommerceLocationModel();
                ((BaseModel) commerceLocationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commerceLocationModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceLocationModel).a();
                }
                return commerceLocationModel;
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Serializer extends JsonSerializer<CommerceLocationModel> {
            public final void m1033a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceLocationModel commerceLocationModel = (CommerceLocationModel) obj;
                if (commerceLocationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceLocationModel.m1035a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceLocationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceLocationParser.m1235a(commerceLocationModel.w_(), commerceLocationModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(CommerceLocationModel.class, new Serializer());
            }
        }

        public CommerceLocationModel() {
            super(8);
        }

        public CommerceLocationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(8);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m1037a() {
            this.f859d = super.a(this.f859d, 0);
            return this.f859d;
        }

        @Nullable
        public final String m1039b() {
            this.f860e = super.a(this.f860e, 1);
            return this.f860e;
        }

        public final double m1040c() {
            a(0, 2);
            return this.f861f;
        }

        public final double m1041d() {
            a(0, 3);
            return this.f862g;
        }

        @Nullable
        public final String au_() {
            this.f863h = super.a(this.f863h, 4);
            return this.f863h;
        }

        @Nullable
        public final String m1042g() {
            this.f864i = super.a(this.f864i, 5);
            return this.f864i;
        }

        @Nonnull
        public final ImmutableList<String> av_() {
            this.f865j = super.a(this.f865j, 6);
            return (ImmutableList) this.f865j;
        }

        @Nullable
        public final String aw_() {
            this.f866k = super.a(this.f866k, 7);
            return this.f866k;
        }

        public static CommerceLocationModel m1034a(CommerceLocationModel commerceLocationModel) {
            if (commerceLocationModel == null) {
                return null;
            }
            if (commerceLocationModel instanceof CommerceLocationModel) {
                return commerceLocationModel;
            }
            Builder builder = new Builder();
            builder.f851a = commerceLocationModel.m1037a();
            builder.f852b = commerceLocationModel.m1039b();
            builder.f853c = commerceLocationModel.m1040c();
            builder.f854d = commerceLocationModel.m1041d();
            builder.f855e = commerceLocationModel.au_();
            builder.f856f = commerceLocationModel.m1042g();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < commerceLocationModel.av_().size(); i++) {
                builder2.c(commerceLocationModel.av_().get(i));
            }
            builder.f857g = builder2.b();
            builder.f858h = commerceLocationModel.aw_();
            return builder.m1031a();
        }

        public final int jK_() {
            return -1507970397;
        }

        public final GraphQLVisitableModel m1036a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m1035a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1037a());
            int b2 = flatBufferBuilder.b(m1039b());
            int b3 = flatBufferBuilder.b(au_());
            int b4 = flatBufferBuilder.b(m1042g());
            int c = flatBufferBuilder.c(av_());
            int b5 = flatBufferBuilder.b(aw_());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.a(2, this.f861f, 0.0d);
            flatBufferBuilder.a(3, this.f862g, 0.0d);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.b(6, c);
            flatBufferBuilder.b(7, b5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1038a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f861f = mutableFlatBuffer.a(i, 2, 0.0d);
            this.f862g = mutableFlatBuffer.a(i, 3, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 509814896)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_creative_editing_metadata */
    public final class CommerceOrderCancellationBubbleModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CommerceOrderCancellationBubble {
        @Nullable
        private GraphQLMessengerCommerceBubbleType f871d;
        @Nullable
        private CancelledItemsModel f872e;
        @Nullable
        private String f873f;
        @Nullable
        private CommerceBaseOrderReceiptModel f874g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1050581796)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_creative_editing_metadata */
        public final class CancelledItemsModel extends BaseModel implements GraphQLVisitableModel {
            private int f869d;
            @Nullable
            private List<CommerceRetailItemModel> f870e;

            /* compiled from: video_creative_editing_metadata */
            public final class Builder {
                public int f867a;
                @Nullable
                public ImmutableList<CommerceRetailItemModel> f868b;
            }

            /* compiled from: video_creative_editing_metadata */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CancelledItemsModel.class, new Deserializer());
                }

                public Object m1043a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CancelledItemsParser.m1236a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object cancelledItemsModel = new CancelledItemsModel();
                    ((BaseModel) cancelledItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (cancelledItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) cancelledItemsModel).a();
                    }
                    return cancelledItemsModel;
                }
            }

            /* compiled from: video_creative_editing_metadata */
            public class Serializer extends JsonSerializer<CancelledItemsModel> {
                public final void m1044a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CancelledItemsModel cancelledItemsModel = (CancelledItemsModel) obj;
                    if (cancelledItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(cancelledItemsModel.m1047a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        cancelledItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CancelledItemsParser.m1237a(cancelledItemsModel.w_(), cancelledItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CancelledItemsModel.class, new Serializer());
                }
            }

            public CancelledItemsModel() {
                super(2);
            }

            public CancelledItemsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m1046a() {
                a(0, 0);
                return this.f869d;
            }

            @Nonnull
            public final ImmutableList<CommerceRetailItemModel> m1050b() {
                this.f870e = super.a(this.f870e, 1, CommerceRetailItemModel.class);
                return (ImmutableList) this.f870e;
            }

            public static CancelledItemsModel m1045a(CancelledItemsModel cancelledItemsModel) {
                if (cancelledItemsModel == null) {
                    return null;
                }
                if (cancelledItemsModel instanceof CancelledItemsModel) {
                    return cancelledItemsModel;
                }
                Builder builder = new Builder();
                builder.f867a = cancelledItemsModel.m1046a();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < cancelledItemsModel.m1050b().size(); i++) {
                    builder2.c(CommerceRetailItemModel.m1137a((CommerceRetailItem) cancelledItemsModel.m1050b().get(i)));
                }
                builder.f868b = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f868b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, builder.f867a, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CancelledItemsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1713952744;
            }

            public final GraphQLVisitableModel m1048a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1050b() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m1050b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CancelledItemsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f870e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1047a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1050b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f869d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1049a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f869d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceOrderCancellationBubbleModel.class, new Deserializer());
            }

            public Object m1051a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommerceOrderCancellationBubbleParser.m1238a(jsonParser);
                Object commerceOrderCancellationBubbleModel = new CommerceOrderCancellationBubbleModel();
                ((BaseModel) commerceOrderCancellationBubbleModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commerceOrderCancellationBubbleModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceOrderCancellationBubbleModel).a();
                }
                return commerceOrderCancellationBubbleModel;
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Serializer extends JsonSerializer<CommerceOrderCancellationBubbleModel> {
            public final void m1052a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommerceOrderCancellationBubbleModel commerceOrderCancellationBubbleModel = (CommerceOrderCancellationBubbleModel) obj;
                if (commerceOrderCancellationBubbleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceOrderCancellationBubbleModel.m1056a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceOrderCancellationBubbleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commerceOrderCancellationBubbleModel.w_();
                int u_ = commerceOrderCancellationBubbleModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("bubble_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("cancelled_items");
                    CancelledItemsParser.m1237a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("receipt");
                    CommerceBaseOrderReceiptParser.m1231a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommerceOrderCancellationBubbleModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CancelledItemsModel mo84p() {
            return m1054k();
        }

        @Nullable
        public final /* synthetic */ CommerceBaseOrderReceipt mo85q() {
            return m1055l();
        }

        public CommerceOrderCancellationBubbleModel() {
            super(4);
        }

        @Nullable
        private GraphQLMessengerCommerceBubbleType m1053j() {
            this.f871d = (GraphQLMessengerCommerceBubbleType) super.b(this.f871d, 0, GraphQLMessengerCommerceBubbleType.class, GraphQLMessengerCommerceBubbleType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f871d;
        }

        @Nullable
        private CancelledItemsModel m1054k() {
            this.f872e = (CancelledItemsModel) super.a(this.f872e, 1, CancelledItemsModel.class);
            return this.f872e;
        }

        @Nullable
        public final String mo83c() {
            this.f873f = super.a(this.f873f, 2);
            return this.f873f;
        }

        @Nullable
        private CommerceBaseOrderReceiptModel m1055l() {
            this.f874g = (CommerceBaseOrderReceiptModel) super.a(this.f874g, 3, CommerceBaseOrderReceiptModel.class);
            return this.f874g;
        }

        @Nullable
        public final String m1058a() {
            return mo83c();
        }

        public final int jK_() {
            return -1039777287;
        }

        public final GraphQLVisitableModel m1057a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1054k() != null) {
                CancelledItemsModel cancelledItemsModel = (CancelledItemsModel) graphQLModelMutatingVisitor.b(m1054k());
                if (m1054k() != cancelledItemsModel) {
                    graphQLVisitableModel = (CommerceOrderCancellationBubbleModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f872e = cancelledItemsModel;
                }
            }
            if (m1055l() != null) {
                CommerceBaseOrderReceiptModel commerceBaseOrderReceiptModel = (CommerceBaseOrderReceiptModel) graphQLModelMutatingVisitor.b(m1055l());
                if (m1055l() != commerceBaseOrderReceiptModel) {
                    graphQLVisitableModel = (CommerceOrderCancellationBubbleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f874g = commerceBaseOrderReceiptModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1056a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m1053j());
            int a2 = ModelHelper.a(flatBufferBuilder, m1054k());
            int b = flatBufferBuilder.b(mo83c());
            int a3 = ModelHelper.a(flatBufferBuilder, m1055l());
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
    @ModelWithFlatBufferFormatHash(a = 1603910508)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_creative_editing_metadata */
    public final class CommerceOrderReceiptBubbleModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CommerceOrderReceiptBubble {
        @Nullable
        private GraphQLMessengerCommerceBubbleType f879d;
        @Nullable
        private String f880e;
        @Nullable
        private String f881f;
        @Nullable
        private LogoImageModel f882g;
        @Nullable
        private String f883h;
        @Nullable
        private String f884i;
        @Nullable
        private RetailItemsModel f885j;
        @Nullable
        private String f886k;
        @Nullable
        private CommerceLocationModel f887l;
        @Nullable
        private String f888m;

        /* compiled from: video_creative_editing_metadata */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceOrderReceiptBubbleModel.class, new Deserializer());
            }

            public Object m1062a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommerceOrderReceiptBubbleParser.m1241a(jsonParser);
                Object commerceOrderReceiptBubbleModel = new CommerceOrderReceiptBubbleModel();
                ((BaseModel) commerceOrderReceiptBubbleModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commerceOrderReceiptBubbleModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceOrderReceiptBubbleModel).a();
                }
                return commerceOrderReceiptBubbleModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1050581796)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_creative_editing_metadata */
        public final class RetailItemsModel extends BaseModel implements GraphQLVisitableModel {
            private int f877d;
            @Nullable
            private List<CommerceRetailItemModel> f878e;

            /* compiled from: video_creative_editing_metadata */
            public final class Builder {
                public int f875a;
                @Nullable
                public ImmutableList<CommerceRetailItemModel> f876b;
            }

            /* compiled from: video_creative_editing_metadata */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RetailItemsModel.class, new Deserializer());
                }

                public Object m1063a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RetailItemsParser.m1239a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object retailItemsModel = new RetailItemsModel();
                    ((BaseModel) retailItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (retailItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) retailItemsModel).a();
                    }
                    return retailItemsModel;
                }
            }

            /* compiled from: video_creative_editing_metadata */
            public class Serializer extends JsonSerializer<RetailItemsModel> {
                public final void m1064a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RetailItemsModel retailItemsModel = (RetailItemsModel) obj;
                    if (retailItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(retailItemsModel.m1067a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        retailItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RetailItemsParser.m1240a(retailItemsModel.w_(), retailItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RetailItemsModel.class, new Serializer());
                }
            }

            public RetailItemsModel() {
                super(2);
            }

            public RetailItemsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m1066a() {
                a(0, 0);
                return this.f877d;
            }

            @Nonnull
            public final ImmutableList<CommerceRetailItemModel> m1070b() {
                this.f878e = super.a(this.f878e, 1, CommerceRetailItemModel.class);
                return (ImmutableList) this.f878e;
            }

            public static RetailItemsModel m1065a(RetailItemsModel retailItemsModel) {
                if (retailItemsModel == null) {
                    return null;
                }
                if (retailItemsModel instanceof RetailItemsModel) {
                    return retailItemsModel;
                }
                Builder builder = new Builder();
                builder.f875a = retailItemsModel.m1066a();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < retailItemsModel.m1070b().size(); i++) {
                    builder2.c(CommerceRetailItemModel.m1137a((CommerceRetailItem) retailItemsModel.m1070b().get(i)));
                }
                builder.f876b = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f876b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, builder.f875a, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new RetailItemsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1053041047;
            }

            public final GraphQLVisitableModel m1068a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1070b() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m1070b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (RetailItemsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f878e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1067a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1070b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f877d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1069a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f877d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Serializer extends JsonSerializer<CommerceOrderReceiptBubbleModel> {
            public final void m1071a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceOrderReceiptBubbleModel commerceOrderReceiptBubbleModel = (CommerceOrderReceiptBubbleModel) obj;
                if (commerceOrderReceiptBubbleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceOrderReceiptBubbleModel.m1075a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceOrderReceiptBubbleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceOrderReceiptBubbleParser.m1242a(commerceOrderReceiptBubbleModel.w_(), commerceOrderReceiptBubbleModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommerceOrderReceiptBubbleModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CommerceLocationModel aE_() {
            return m1074n();
        }

        @Nullable
        public final /* synthetic */ LogoImage at_() {
            return m1072l();
        }

        @Nullable
        public final /* synthetic */ RetailItemsModel mo86r() {
            return m1073m();
        }

        public CommerceOrderReceiptBubbleModel() {
            super(10);
        }

        @Nullable
        public final GraphQLMessengerCommerceBubbleType mo57b() {
            this.f879d = (GraphQLMessengerCommerceBubbleType) super.b(this.f879d, 0, GraphQLMessengerCommerceBubbleType.class, GraphQLMessengerCommerceBubbleType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f879d;
        }

        @Nullable
        public final String mo58c() {
            this.f880e = super.a(this.f880e, 1);
            return this.f880e;
        }

        @Nullable
        public final String aC_() {
            this.f881f = super.a(this.f881f, 2);
            return this.f881f;
        }

        @Nullable
        private LogoImageModel m1072l() {
            this.f882g = (LogoImageModel) super.a(this.f882g, 3, LogoImageModel.class);
            return this.f882g;
        }

        @Nullable
        public final String aD_() {
            this.f883h = super.a(this.f883h, 4);
            return this.f883h;
        }

        @Nullable
        public final String ar_() {
            this.f884i = super.a(this.f884i, 5);
            return this.f884i;
        }

        @Nullable
        private RetailItemsModel m1073m() {
            this.f885j = (RetailItemsModel) super.a(this.f885j, 6, RetailItemsModel.class);
            return this.f885j;
        }

        @Nullable
        public final String as_() {
            this.f886k = super.a(this.f886k, 7);
            return this.f886k;
        }

        @Nullable
        private CommerceLocationModel m1074n() {
            this.f887l = (CommerceLocationModel) super.a(this.f887l, 8, CommerceLocationModel.class);
            return this.f887l;
        }

        @Nullable
        public final String aH_() {
            this.f888m = super.a(this.f888m, 9);
            return this.f888m;
        }

        @Nullable
        public final String m1077a() {
            return mo58c();
        }

        public final int jK_() {
            return -1649510526;
        }

        public final GraphQLVisitableModel m1076a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1072l() != null) {
                LogoImageModel logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(m1072l());
                if (m1072l() != logoImageModel) {
                    graphQLVisitableModel = (CommerceOrderReceiptBubbleModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f882g = logoImageModel;
                }
            }
            if (m1073m() != null) {
                RetailItemsModel retailItemsModel = (RetailItemsModel) graphQLModelMutatingVisitor.b(m1073m());
                if (m1073m() != retailItemsModel) {
                    graphQLVisitableModel = (CommerceOrderReceiptBubbleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f885j = retailItemsModel;
                }
            }
            if (m1074n() != null) {
                CommerceLocationModel commerceLocationModel = (CommerceLocationModel) graphQLModelMutatingVisitor.b(m1074n());
                if (m1074n() != commerceLocationModel) {
                    graphQLVisitableModel = (CommerceOrderReceiptBubbleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f887l = commerceLocationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1075a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(mo57b());
            int b = flatBufferBuilder.b(mo58c());
            int b2 = flatBufferBuilder.b(aC_());
            int a2 = ModelHelper.a(flatBufferBuilder, m1072l());
            int b3 = flatBufferBuilder.b(aD_());
            int b4 = flatBufferBuilder.b(ar_());
            int a3 = ModelHelper.a(flatBufferBuilder, m1073m());
            int b5 = flatBufferBuilder.b(as_());
            int a4 = ModelHelper.a(flatBufferBuilder, m1074n());
            int b6 = flatBufferBuilder.b(aH_());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.b(6, a3);
            flatBufferBuilder.b(7, b5);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, b6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -25367848)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_creative_editing_metadata */
    public final class CommerceProductSubscriptionBubbleModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CommerceProductSubscriptionBubble {
        @Nullable
        private String f916d;
        @Nullable
        private PartnerLogoModel f917e;
        @Nullable
        private SubscribedItemModel f918f;

        /* compiled from: video_creative_editing_metadata */
        public class Deserializer extends FbJsonDeserializer {
            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.class;
                r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m1081a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceProductSubscriptionBubbleParser.m1249a(r6);
                r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 729935302)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_creative_editing_metadata */
        public final class PartnerLogoModel extends BaseModel implements GraphQLVisitableModel, PartnerLogo {
            private int f889d;
            @Nullable
            private String f890e;
            private int f891f;

            /* compiled from: video_creative_editing_metadata */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.class;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$PartnerLogoModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m1082a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceProductSubscriptionBubbleParser.PartnerLogoParser.m1243a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$PartnerLogoModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: video_creative_editing_metadata */
            public class Serializer extends JsonSerializer<PartnerLogoModel> {
                public final void m1083a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m1085a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceProductSubscriptionBubbleParser.PartnerLogoParser.m1244a(r0, r1, r9);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.class;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$PartnerLogoModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.Serializer.<clinit>():void");
                }
            }

            public PartnerLogoModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 3;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.<init>():void");
            }

            public final int mo87a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 0;
                r1.a(r0, r0);
                r0 = r1.f889d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.a():int");
            }

            @javax.annotation.Nullable
            public final java.lang.String mo88b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.f890e;
                r1 = 1;
                r0 = super.a(r0, r1);
                r2.f890e = r0;
                r0 = r2.f890e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.b():java.lang.String");
            }

            public final int mo89c() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r1 = 2;
                r2.a(r0, r1);
                r0 = r2.f891f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.c():int");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m1086a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.h();
                r0.i();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m1085a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r2 = 0;
                r3.h();
                r0 = r3.mo88b();
                r0 = r4.b(r0);
                r1 = 3;
                r4.c(r1);
                r1 = r3.f889d;
                r4.a(r2, r1, r2);
                r1 = 1;
                r4.b(r1, r0);
                r0 = 2;
                r1 = r3.f891f;
                r4.a(r0, r1, r2);
                r3.i();
                r0 = r4.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m1087a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, java.lang.Object r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r1 = 0;
                super.a(r3, r4, r5);
                r0 = r3.a(r4, r1, r1);
                r2.f889d = r0;
                r0 = 2;
                r0 = r3.a(r4, r0, r1);
                r2.f891f = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Serializer extends JsonSerializer<CommerceProductSubscriptionBubbleModel> {
            public final void m1090a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r8 = this;
                r9 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m1111a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r9.a(r0, r1);
            L_0x0035:
                r0 = r9.w_();
                r1 = r9.u_();
                r7 = 0;
                r10.f();
                r6 = r0.g(r1, r7);
                if (r6 == 0) goto L_0x0053;
            L_0x0047:
                r6 = "id";
                r10.a(r6);
                r6 = r0.c(r1, r7);
                r10.b(r6);
            L_0x0053:
                r6 = 1;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x0062;
            L_0x005a:
                r7 = "partner_logo";
                r10.a(r7);
                com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceProductSubscriptionBubbleParser.PartnerLogoParser.m1244a(r0, r6, r10);
            L_0x0062:
                r6 = 2;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x0071;
            L_0x0069:
                r7 = "subscribed_item";
                r10.a(r7);
                com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceProductSubscriptionBubbleParser.SubscribedItemParser.m1248a(r0, r6, r10, r11);
            L_0x0071:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.class;
                r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 924668578)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_creative_editing_metadata */
        public final class SubscribedItemModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f915d;

            /* compiled from: video_creative_editing_metadata */
            public final class Builder {
                @Nullable
                public ImmutableList<NodesModel> f892a;
            }

            /* compiled from: video_creative_editing_metadata */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.class;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m1091a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceProductSubscriptionBubbleParser.SubscribedItemParser.m1247a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 843775349)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: video_creative_editing_metadata */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CommerceRetailItem {
                @Nullable
                private List<PlatformCallToActionModel> f904d;
                @Nullable
                private String f905e;
                @Nullable
                private String f906f;
                @Nullable
                private String f907g;
                @Nullable
                private String f908h;
                @Nullable
                private String f909i;
                @Nullable
                private String f910j;
                @Nullable
                private String f911k;
                @Nullable
                private GraphQLMessengerRetailItemStatus f912l;
                @Nullable
                private String f913m;
                @Nullable
                private String f914n;

                /* compiled from: video_creative_editing_metadata */
                public final class Builder {
                    @Nullable
                    public ImmutableList<PlatformCallToActionModel> f893a;
                    @Nullable
                    public String f894b;
                    @Nullable
                    public String f895c;
                    @Nullable
                    public String f896d;
                    @Nullable
                    public String f897e;
                    @Nullable
                    public String f898f;
                    @Nullable
                    public String f899g;
                    @Nullable
                    public String f900h;
                    @Nullable
                    public GraphQLMessengerRetailItemStatus f901i;
                    @Nullable
                    public String f902j;
                    @Nullable
                    public String f903k;

                    public final com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel m1092a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r13 = this;
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r13.f893a;
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r1);
                        r2 = r13.f894b;
                        r2 = r0.b(r2);
                        r3 = r13.f895c;
                        r3 = r0.b(r3);
                        r4 = r13.f896d;
                        r4 = r0.b(r4);
                        r5 = r13.f897e;
                        r5 = r0.b(r5);
                        r6 = r13.f898f;
                        r6 = r0.b(r6);
                        r7 = r13.f899g;
                        r7 = r0.b(r7);
                        r8 = r13.f900h;
                        r8 = r0.b(r8);
                        r9 = r13.f901i;
                        r9 = r0.a(r9);
                        r10 = r13.f902j;
                        r10 = r0.b(r10);
                        r11 = r13.f903k;
                        r11 = r0.b(r11);
                        r12 = 11;
                        r0.c(r12);
                        r12 = 0;
                        r0.b(r12, r1);
                        r1 = 1;
                        r0.b(r1, r2);
                        r1 = 2;
                        r0.b(r1, r3);
                        r1 = 3;
                        r0.b(r1, r4);
                        r1 = 4;
                        r0.b(r1, r5);
                        r1 = 5;
                        r0.b(r1, r6);
                        r1 = 6;
                        r0.b(r1, r7);
                        r1 = 7;
                        r0.b(r1, r8);
                        r1 = 8;
                        r0.b(r1, r9);
                        r1 = 9;
                        r0.b(r1, r10);
                        r1 = 10;
                        r0.b(r1, r11);
                        r1 = r0.d();
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r2 = 0;
                        r3 = 0;
                        r4 = 1;
                        r5 = 0;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel$NodesModel;
                        r1.<init>(r0);
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.Builder.a():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel$NodesModel");
                    }
                }

                /* compiled from: video_creative_editing_metadata */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.class;
                        r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel$NodesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m1093a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceProductSubscriptionBubbleParser.SubscribedItemParser.NodesParser.m1245b(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel$NodesModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: video_creative_editing_metadata */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m1094a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m1096a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceProductSubscriptionBubbleParser.SubscribedItemParser.NodesParser.m1246b(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.class;
                        r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel$NodesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.Serializer.<clinit>():void");
                    }
                }

                public NodesModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 11;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.<init>():void");
                }

                public NodesModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 11;
                    r2.<init>(r0);
                    r1 = r3.a;
                    r0 = r1;
                    r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r2.a(r3, r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                }

                @javax.annotation.Nonnull
                public final com.google.common.collect.ImmutableList<com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsModels.PlatformCallToActionModel> aB_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f904d;
                    r1 = 0;
                    r2 = com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsModels.PlatformCallToActionModel.class;
                    r0 = super.a(r0, r1, r2);
                    r3.f904d = r0;
                    r0 = r3.f904d;
                    r0 = (com.google.common.collect.ImmutableList) r0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.aB_():com.google.common.collect.ImmutableList<com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsModels$PlatformCallToActionModel>");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo97d() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f905e;
                    r1 = 1;
                    r0 = super.a(r0, r1);
                    r2.f905e = r0;
                    r0 = r2.f905e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.d():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo96c() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f906f;
                    r1 = 2;
                    r0 = super.a(r0, r1);
                    r2.f906f = r0;
                    r0 = r2.f906f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.c():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String ax_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f907g;
                    r1 = 3;
                    r0 = super.a(r0, r1);
                    r2.f907g = r0;
                    r0 = r2.f907g;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.ax_():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo98g() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f908h;
                    r1 = 4;
                    r0 = super.a(r0, r1);
                    r2.f908h = r0;
                    r0 = r2.f908h;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.g():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String ay_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f909i;
                    r1 = 5;
                    r0 = super.a(r0, r1);
                    r2.f909i = r0;
                    r0 = r2.f909i;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.ay_():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String az_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f910j;
                    r1 = 6;
                    r0 = super.a(r0, r1);
                    r2.f910j = r0;
                    r0 = r2.f910j;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.az_():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo99j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f911k;
                    r1 = 7;
                    r0 = super.a(r0, r1);
                    r2.f911k = r0;
                    r0 = r2.f911k;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.j():java.lang.String");
                }

                @javax.annotation.Nullable
                public final com.facebook.graphql.enums.GraphQLMessengerRetailItemStatus mo100k() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r0 = r4.f912l;
                    r1 = 8;
                    r2 = com.facebook.graphql.enums.GraphQLMessengerRetailItemStatus.class;
                    r3 = com.facebook.graphql.enums.GraphQLMessengerRetailItemStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                    r0 = super.b(r0, r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLMessengerRetailItemStatus) r0;
                    r4.f912l = r0;
                    r0 = r4.f912l;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.k():com.facebook.graphql.enums.GraphQLMessengerRetailItemStatus");
                }

                @javax.annotation.Nullable
                public final java.lang.String aF_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f913m;
                    r1 = 9;
                    r0 = super.a(r0, r1);
                    r2.f913m = r0;
                    r0 = r2.f913m;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.aF_():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String aG_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f914n;
                    r1 = 10;
                    r0 = super.a(r0, r1);
                    r2.f914n = r0;
                    r0 = r2.f914n;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.aG_():java.lang.String");
                }

                public static com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel m1095a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    if (r4 != 0) goto L_0x0004;
                L_0x0002:
                    r4 = 0;
                L_0x0003:
                    return r4;
                L_0x0004:
                    r0 = r4 instanceof com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel;
                    if (r0 == 0) goto L_0x000b;
                L_0x0008:
                    r4 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel) r4;
                    goto L_0x0003;
                L_0x000b:
                    r2 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel$NodesModel$Builder;
                    r2.<init>();
                    r3 = com.google.common.collect.ImmutableList.builder();
                    r0 = 0;
                    r1 = r0;
                L_0x0016:
                    r0 = r4.aB_();
                    r0 = r0.size();
                    if (r1 >= r0) goto L_0x0035;
                L_0x0020:
                    r0 = r4.aB_();
                    r0 = r0.get(r1);
                    r0 = (com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsModels.PlatformCallToActionModel) r0;
                    r0 = com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsModels.PlatformCallToActionModel.m732a(r0);
                    r3.c(r0);
                    r0 = r1 + 1;
                    r1 = r0;
                    goto L_0x0016;
                L_0x0035:
                    r0 = r3.b();
                    r2.f893a = r0;
                    r0 = r4.mo97d();
                    r2.f894b = r0;
                    r0 = r4.mo96c();
                    r2.f895c = r0;
                    r0 = r4.ax_();
                    r2.f896d = r0;
                    r0 = r4.mo98g();
                    r2.f897e = r0;
                    r0 = r4.ay_();
                    r2.f898f = r0;
                    r0 = r4.az_();
                    r2.f899g = r0;
                    r0 = r4.mo99j();
                    r2.f900h = r0;
                    r0 = r4.mo100k();
                    r2.f901i = r0;
                    r0 = r4.aF_();
                    r2.f902j = r0;
                    r0 = r4.aG_();
                    r2.f903k = r0;
                    r4 = r2.m1092a();
                    goto L_0x0003;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel$NodesModel):com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel$NodesModel");
                }

                @javax.annotation.Nullable
                public final java.lang.String m1098a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.mo96c();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.a():java.lang.String");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1580370441; // 0x5e328a09 float:3.2162763E18 double:7.808067426E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m1097a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 0;
                    r2.h();
                    r1 = r2.aB_();
                    if (r1 == 0) goto L_0x0020;
                L_0x000a:
                    r1 = r2.aB_();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    if (r1 == 0) goto L_0x0020;
                L_0x0014:
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                    r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel) r0;
                    r1 = r1.b();
                    r0.f904d = r1;
                L_0x0020:
                    r2.i();
                    if (r0 != 0) goto L_0x0026;
                L_0x0025:
                    return r2;
                L_0x0026:
                    r2 = r0;
                    goto L_0x0025;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m1096a(com.facebook.flatbuffers.FlatBufferBuilder r13) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r12 = this;
                    r12.h();
                    r0 = r12.aB_();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r13, r0);
                    r1 = r12.mo97d();
                    r1 = r13.b(r1);
                    r2 = r12.mo96c();
                    r2 = r13.b(r2);
                    r3 = r12.ax_();
                    r3 = r13.b(r3);
                    r4 = r12.mo98g();
                    r4 = r13.b(r4);
                    r5 = r12.ay_();
                    r5 = r13.b(r5);
                    r6 = r12.az_();
                    r6 = r13.b(r6);
                    r7 = r12.mo99j();
                    r7 = r13.b(r7);
                    r8 = r12.mo100k();
                    r8 = r13.a(r8);
                    r9 = r12.aF_();
                    r9 = r13.b(r9);
                    r10 = r12.aG_();
                    r10 = r13.b(r10);
                    r11 = 11;
                    r13.c(r11);
                    r11 = 0;
                    r13.b(r11, r0);
                    r0 = 1;
                    r13.b(r0, r1);
                    r0 = 2;
                    r13.b(r0, r2);
                    r0 = 3;
                    r13.b(r0, r3);
                    r0 = 4;
                    r13.b(r0, r4);
                    r0 = 5;
                    r13.b(r0, r5);
                    r0 = 6;
                    r13.b(r0, r6);
                    r0 = 7;
                    r13.b(r0, r7);
                    r0 = 8;
                    r13.b(r0, r8);
                    r0 = 9;
                    r13.b(r0, r9);
                    r0 = 10;
                    r13.b(r0, r10);
                    r12.i();
                    r0 = r13.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: video_creative_editing_metadata */
            public class Serializer extends JsonSerializer<SubscribedItemModel> {
                public final void m1104a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m1106a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceProductSubscriptionBubbleParser.SubscribedItemParser.m1248a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.class;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.Serializer.<clinit>():void");
                }
            }

            public SubscribedItemModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 1;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.<init>():void");
            }

            public SubscribedItemModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 1;
                r2.<init>(r0);
                r1 = r3.a;
                r0 = r1;
                r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r2.a(r3, r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel> m1108a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f915d;
                r1 = 0;
                r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f915d = r0;
                r0 = r3.f915d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.a():com.google.common.collect.ImmutableList<com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel$NodesModel>");
            }

            public static com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel m1105a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel r10) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                if (r10 != 0) goto L_0x0004;
            L_0x0002:
                r10 = 0;
            L_0x0003:
                return r10;
            L_0x0004:
                r0 = r10 instanceof com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel;
                if (r0 == 0) goto L_0x000b;
            L_0x0008:
                r10 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel) r10;
                goto L_0x0003;
            L_0x000b:
                r2 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel$Builder;
                r2.<init>();
                r3 = com.google.common.collect.ImmutableList.builder();
                r0 = 0;
                r1 = r0;
            L_0x0016:
                r0 = r10.m1108a();
                r0 = r0.size();
                if (r1 >= r0) goto L_0x0035;
            L_0x0020:
                r0 = r10.m1108a();
                r0 = r0.get(r1);
                r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel) r0;
                r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel.m1095a(r0);
                r3.c(r0);
                r0 = r1 + 1;
                r1 = r0;
                goto L_0x0016;
            L_0x0035:
                r0 = r3.b();
                r2.f892a = r0;
                r8 = 1;
                r7 = 0;
                r6 = 0;
                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r4.<init>(r5);
                r5 = r2.f892a;
                r5 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r5);
                r4.c(r8);
                r4.b(r7, r5);
                r5 = r4.d();
                r4.d(r5);
                r4 = r4.e();
                r5 = java.nio.ByteBuffer.wrap(r4);
                r5.position(r7);
                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r7 = r6;
                r9 = r6;
                r4.<init>(r5, r6, r7, r8, r9);
                r5 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel;
                r5.<init>(r4);
                r10 = r5;
                goto L_0x0003;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel):com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = -2094406705; // 0xffffffff8329e3cf float:-4.992615E-37 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m1107a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r2.h();
                r1 = r2.m1108a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m1108a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel) r0;
                r1 = r1.b();
                r0.f915d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m1106a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r2.h();
                r0 = r2.m1108a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceProductSubscriptionBubble.PartnerLogo mo102s() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m1109j();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.s():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces$CommerceProductSubscriptionBubble$PartnerLogo");
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel mo103t() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m1110k();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.t():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel");
        }

        public CommerceProductSubscriptionBubbleModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 3;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.<init>():void");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo101c() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f916d;
            r1 = 0;
            r0 = super.a(r0, r1);
            r2.f916d = r0;
            r0 = r2.f916d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.c():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel m1109j() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f917e;
            r1 = 1;
            r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel) r0;
            r3.f917e = r0;
            r0 = r3.f917e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.j():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$PartnerLogoModel");
        }

        @javax.annotation.Nullable
        private com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel m1110k() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f918f;
            r1 = 2;
            r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel) r0;
            r3.f918f = r0;
            r0 = r3.f918f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.k():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceProductSubscriptionBubbleModel$SubscribedItemModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String m1113a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.mo101c();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.a():java.lang.String");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 1611225566; // 0x600959de float:3.9588743E19 double:7.960512E-315;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m1112a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r1 = 0;
            r3.h();
            r0 = r3.m1109j();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m1109j();
            r0 = r4.b(r0);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.PartnerLogoModel) r0;
            r2 = r3.m1109j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel) r1;
            r1.f917e = r0;
        L_0x0022:
            r0 = r3.m1110k();
            if (r0 == 0) goto L_0x0040;
        L_0x0028:
            r0 = r3.m1110k();
            r0 = r4.b(r0);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel) r0;
            r2 = r3.m1110k();
            if (r2 == r0) goto L_0x0040;
        L_0x0038:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel) r1;
            r1.f918f = r0;
        L_0x0040:
            r3.i();
            if (r1 != 0) goto L_0x0046;
        L_0x0045:
            return r3;
        L_0x0046:
            r3 = r1;
            goto L_0x0045;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m1111a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r4.h();
            r0 = r4.mo101c();
            r0 = r5.b(r0);
            r1 = r4.m1109j();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r1);
            r2 = r4.m1110k();
            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r2);
            r3 = 3;
            r5.c(r3);
            r3 = 0;
            r5.b(r3, r0);
            r0 = 1;
            r5.b(r0, r1);
            r0 = 2;
            r5.b(r0, r2);
            r4.i();
            r0 = r5.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -402831950)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_creative_editing_metadata */
    public final class CommercePromotionsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CommercePromotions {
        @Nullable
        private List<PlatformCallToActionModel> f921d;
        @Nullable
        private String f922e;
        @Nullable
        private String f923f;
        @Nullable
        private LogoImageModel f924g;
        @Nullable
        private PromotionItemsModel f925h;
        @Nullable
        private String f926i;

        /* compiled from: video_creative_editing_metadata */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommercePromotionsModel.class, new Deserializer());
            }

            public Object m1117a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommercePromotionsParser.m1252a(jsonParser);
                Object commercePromotionsModel = new CommercePromotionsModel();
                ((BaseModel) commercePromotionsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commercePromotionsModel instanceof Postprocessable) {
                    return ((Postprocessable) commercePromotionsModel).a();
                }
                return commercePromotionsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1105566069)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_creative_editing_metadata */
        public final class PromotionItemsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<CommerceRetailItemModel> f920d;

            /* compiled from: video_creative_editing_metadata */
            public final class Builder {
                @Nullable
                public ImmutableList<CommerceRetailItemModel> f919a;
            }

            /* compiled from: video_creative_editing_metadata */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PromotionItemsModel.class, new Deserializer());
                }

                public Object m1118a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PromotionItemsParser.m1250a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object promotionItemsModel = new PromotionItemsModel();
                    ((BaseModel) promotionItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (promotionItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) promotionItemsModel).a();
                    }
                    return promotionItemsModel;
                }
            }

            /* compiled from: video_creative_editing_metadata */
            public class Serializer extends JsonSerializer<PromotionItemsModel> {
                public final void m1119a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PromotionItemsModel promotionItemsModel = (PromotionItemsModel) obj;
                    if (promotionItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(promotionItemsModel.m1121a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        promotionItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PromotionItemsParser.m1251a(promotionItemsModel.w_(), promotionItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PromotionItemsModel.class, new Serializer());
                }
            }

            public PromotionItemsModel() {
                super(1);
            }

            public PromotionItemsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<CommerceRetailItemModel> m1123a() {
                this.f920d = super.a(this.f920d, 0, CommerceRetailItemModel.class);
                return (ImmutableList) this.f920d;
            }

            public static PromotionItemsModel m1120a(PromotionItemsModel promotionItemsModel) {
                if (promotionItemsModel == null) {
                    return null;
                }
                if (promotionItemsModel instanceof PromotionItemsModel) {
                    return promotionItemsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < promotionItemsModel.m1123a().size(); i++) {
                    builder2.c(CommerceRetailItemModel.m1137a((CommerceRetailItem) promotionItemsModel.m1123a().get(i)));
                }
                builder.f919a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f919a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PromotionItemsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 112761822;
            }

            public final GraphQLVisitableModel m1122a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1123a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m1123a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PromotionItemsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f920d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1121a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1123a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Serializer extends JsonSerializer<CommercePromotionsModel> {
            public final void m1124a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommercePromotionsModel commercePromotionsModel = (CommercePromotionsModel) obj;
                if (commercePromotionsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commercePromotionsModel.m1128a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commercePromotionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commercePromotionsModel.w_();
                int u_ = commercePromotionsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("call_to_actions");
                    PlatformCallToActionParser.m745a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("partner_logo");
                    LogoImageParser.m1270a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("promotion_items");
                    PromotionItemsParser.m1251a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 5) != 0) {
                    jsonGenerator.a("snippet");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 5));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommercePromotionsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ LogoImage at_() {
            return m1125j();
        }

        @Nullable
        public final /* synthetic */ PromotionItemsModel mo108u() {
            return m1126k();
        }

        public CommercePromotionsModel() {
            super(6);
        }

        @Nonnull
        public final ImmutableList<PlatformCallToActionModel> aB_() {
            this.f921d = super.a(this.f921d, 0, PlatformCallToActionModel.class);
            return (ImmutableList) this.f921d;
        }

        @Nullable
        public final String mo106c() {
            this.f922e = super.a(this.f922e, 1);
            return this.f922e;
        }

        @Nullable
        public final String mo107g() {
            this.f923f = super.a(this.f923f, 2);
            return this.f923f;
        }

        @Nullable
        private LogoImageModel m1125j() {
            this.f924g = (LogoImageModel) super.a(this.f924g, 3, LogoImageModel.class);
            return this.f924g;
        }

        @Nullable
        private PromotionItemsModel m1126k() {
            this.f925h = (PromotionItemsModel) super.a(this.f925h, 4, PromotionItemsModel.class);
            return this.f925h;
        }

        @Nullable
        private String m1127l() {
            this.f926i = super.a(this.f926i, 5);
            return this.f926i;
        }

        @Nullable
        public final String m1130a() {
            return mo106c();
        }

        public final int jK_() {
            return -1835214995;
        }

        public final GraphQLVisitableModel m1129a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            LogoImageModel logoImageModel;
            PromotionItemsModel promotionItemsModel;
            h();
            if (aB_() != null) {
                Builder a = ModelHelper.a(aB_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    CommercePromotionsModel commercePromotionsModel = (CommercePromotionsModel) ModelHelper.a(null, this);
                    commercePromotionsModel.f921d = a.b();
                    graphQLVisitableModel = commercePromotionsModel;
                    if (m1125j() != null) {
                        logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(m1125j());
                        if (m1125j() != logoImageModel) {
                            graphQLVisitableModel = (CommercePromotionsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f924g = logoImageModel;
                        }
                    }
                    if (m1126k() != null) {
                        promotionItemsModel = (PromotionItemsModel) graphQLModelMutatingVisitor.b(m1126k());
                        if (m1126k() != promotionItemsModel) {
                            graphQLVisitableModel = (CommercePromotionsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f925h = promotionItemsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m1125j() != null) {
                logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(m1125j());
                if (m1125j() != logoImageModel) {
                    graphQLVisitableModel = (CommercePromotionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f924g = logoImageModel;
                }
            }
            if (m1126k() != null) {
                promotionItemsModel = (PromotionItemsModel) graphQLModelMutatingVisitor.b(m1126k());
                if (m1126k() != promotionItemsModel) {
                    graphQLVisitableModel = (CommercePromotionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f925h = promotionItemsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m1128a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, aB_());
            int b = flatBufferBuilder.b(mo106c());
            int b2 = flatBufferBuilder.b(mo107g());
            int a2 = ModelHelper.a(flatBufferBuilder, m1125j());
            int a3 = ModelHelper.a(flatBufferBuilder, m1126k());
            int b3 = flatBufferBuilder.b(m1127l());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 843775349)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_creative_editing_metadata */
    public final class CommerceRetailItemModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CommerceRetailItem {
        @Nullable
        private List<PlatformCallToActionModel> f938d;
        @Nullable
        private String f939e;
        @Nullable
        private String f940f;
        @Nullable
        private String f941g;
        @Nullable
        private String f942h;
        @Nullable
        private String f943i;
        @Nullable
        private String f944j;
        @Nullable
        private String f945k;
        @Nullable
        private GraphQLMessengerRetailItemStatus f946l;
        @Nullable
        private String f947m;
        @Nullable
        private String f948n;

        /* compiled from: video_creative_editing_metadata */
        public final class Builder {
            @Nullable
            public ImmutableList<PlatformCallToActionModel> f927a;
            @Nullable
            public String f928b;
            @Nullable
            public String f929c;
            @Nullable
            public String f930d;
            @Nullable
            public String f931e;
            @Nullable
            public String f932f;
            @Nullable
            public String f933g;
            @Nullable
            public String f934h;
            @Nullable
            public GraphQLMessengerRetailItemStatus f935i;
            @Nullable
            public String f936j;
            @Nullable
            public String f937k;

            public final CommerceRetailItemModel m1134a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f927a);
                int b = flatBufferBuilder.b(this.f928b);
                int b2 = flatBufferBuilder.b(this.f929c);
                int b3 = flatBufferBuilder.b(this.f930d);
                int b4 = flatBufferBuilder.b(this.f931e);
                int b5 = flatBufferBuilder.b(this.f932f);
                int b6 = flatBufferBuilder.b(this.f933g);
                int b7 = flatBufferBuilder.b(this.f934h);
                int a2 = flatBufferBuilder.a(this.f935i);
                int b8 = flatBufferBuilder.b(this.f936j);
                int b9 = flatBufferBuilder.b(this.f937k);
                flatBufferBuilder.c(11);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                flatBufferBuilder.b(4, b4);
                flatBufferBuilder.b(5, b5);
                flatBufferBuilder.b(6, b6);
                flatBufferBuilder.b(7, b7);
                flatBufferBuilder.b(8, a2);
                flatBufferBuilder.b(9, b8);
                flatBufferBuilder.b(10, b9);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CommerceRetailItemModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceRetailItemModel.class, new Deserializer());
            }

            public Object m1135a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommerceRetailItemParser.m1255b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commerceRetailItemModel = new CommerceRetailItemModel();
                ((BaseModel) commerceRetailItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commerceRetailItemModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceRetailItemModel).a();
                }
                return commerceRetailItemModel;
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Serializer extends JsonSerializer<CommerceRetailItemModel> {
            public final void m1136a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceRetailItemModel commerceRetailItemModel = (CommerceRetailItemModel) obj;
                if (commerceRetailItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceRetailItemModel.m1138a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceRetailItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceRetailItemParser.m1256b(commerceRetailItemModel.w_(), commerceRetailItemModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommerceRetailItemModel.class, new Serializer());
            }
        }

        public CommerceRetailItemModel() {
            super(11);
        }

        public CommerceRetailItemModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<PlatformCallToActionModel> aB_() {
            this.f938d = super.a(this.f938d, 0, PlatformCallToActionModel.class);
            return (ImmutableList) this.f938d;
        }

        @Nullable
        public final String mo97d() {
            this.f939e = super.a(this.f939e, 1);
            return this.f939e;
        }

        @Nullable
        public final String mo96c() {
            this.f940f = super.a(this.f940f, 2);
            return this.f940f;
        }

        @Nullable
        public final String ax_() {
            this.f941g = super.a(this.f941g, 3);
            return this.f941g;
        }

        @Nullable
        public final String mo98g() {
            this.f942h = super.a(this.f942h, 4);
            return this.f942h;
        }

        @Nullable
        public final String ay_() {
            this.f943i = super.a(this.f943i, 5);
            return this.f943i;
        }

        @Nullable
        public final String az_() {
            this.f944j = super.a(this.f944j, 6);
            return this.f944j;
        }

        @Nullable
        public final String mo99j() {
            this.f945k = super.a(this.f945k, 7);
            return this.f945k;
        }

        @Nullable
        public final GraphQLMessengerRetailItemStatus mo100k() {
            this.f946l = (GraphQLMessengerRetailItemStatus) super.b(this.f946l, 8, GraphQLMessengerRetailItemStatus.class, GraphQLMessengerRetailItemStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f946l;
        }

        @Nullable
        public final String aF_() {
            this.f947m = super.a(this.f947m, 9);
            return this.f947m;
        }

        @Nullable
        public final String aG_() {
            this.f948n = super.a(this.f948n, 10);
            return this.f948n;
        }

        public static CommerceRetailItemModel m1137a(CommerceRetailItem commerceRetailItem) {
            if (commerceRetailItem == null) {
                return null;
            }
            if (commerceRetailItem instanceof CommerceRetailItemModel) {
                return (CommerceRetailItemModel) commerceRetailItem;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < commerceRetailItem.aB_().size(); i++) {
                builder2.c(PlatformCallToActionModel.m732a((PlatformCallToActionModel) commerceRetailItem.aB_().get(i)));
            }
            builder.f927a = builder2.b();
            builder.f928b = commerceRetailItem.mo97d();
            builder.f929c = commerceRetailItem.mo96c();
            builder.f930d = commerceRetailItem.ax_();
            builder.f931e = commerceRetailItem.mo98g();
            builder.f932f = commerceRetailItem.ay_();
            builder.f933g = commerceRetailItem.az_();
            builder.f934h = commerceRetailItem.mo99j();
            builder.f935i = commerceRetailItem.mo100k();
            builder.f936j = commerceRetailItem.aF_();
            builder.f937k = commerceRetailItem.aG_();
            return builder.m1134a();
        }

        @Nullable
        public final String m1140a() {
            return mo96c();
        }

        public final int jK_() {
            return 1580370441;
        }

        public final GraphQLVisitableModel m1139a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (aB_() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(aB_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (CommerceRetailItemModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f938d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1138a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, aB_());
            int b = flatBufferBuilder.b(mo97d());
            int b2 = flatBufferBuilder.b(mo96c());
            int b3 = flatBufferBuilder.b(ax_());
            int b4 = flatBufferBuilder.b(mo98g());
            int b5 = flatBufferBuilder.b(ay_());
            int b6 = flatBufferBuilder.b(az_());
            int b7 = flatBufferBuilder.b(mo99j());
            int a2 = flatBufferBuilder.a(mo100k());
            int b8 = flatBufferBuilder.b(aF_());
            int b9 = flatBufferBuilder.b(aG_());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, b4);
            flatBufferBuilder.b(5, b5);
            flatBufferBuilder.b(6, b6);
            flatBufferBuilder.b(7, b7);
            flatBufferBuilder.b(8, a2);
            flatBufferBuilder.b(9, b8);
            flatBufferBuilder.b(10, b9);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 525145075)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_creative_editing_metadata */
    public final class CommerceShipmentBubbleModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CommerceShipmentBubble {
        @Nullable
        private GraphQLMessengerCommerceBubbleType f979d;
        @Nullable
        private String f980e;
        @Nullable
        private CommerceLocationModel f981f;
        @Nullable
        private CommerceLocationModel f982g;
        @Nullable
        private String f983h;
        @Nullable
        private String f984i;
        @Nullable
        private String f985j;
        @Nullable
        private String f986k;
        @Nullable
        private RetailCarrierModel f987l;
        @Nullable
        private RetailShipmentItemsModel f988m;
        @Nullable
        private String f989n;
        @Nullable
        private String f990o;
        @Nullable
        private ShipmentTrackingEventsModel f991p;
        @Nullable
        private String f992q;

        /* compiled from: video_creative_editing_metadata */
        public final class Builder {
            @Nullable
            public GraphQLMessengerCommerceBubbleType f949a;
            @Nullable
            public String f950b;
            @Nullable
            public CommerceLocationModel f951c;
            @Nullable
            public CommerceLocationModel f952d;
            @Nullable
            public String f953e;
            @Nullable
            public String f954f;
            @Nullable
            public String f955g;
            @Nullable
            public String f956h;
            @Nullable
            public RetailCarrierModel f957i;
            @Nullable
            public RetailShipmentItemsModel f958j;
            @Nullable
            public String f959k;
            @Nullable
            public String f960l;
            @Nullable
            public ShipmentTrackingEventsModel f961m;
            @Nullable
            public String f962n;

            public final com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel m1146a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r17 = this;
                r1 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r1.<init>(r2);
                r0 = r17;
                r2 = r0.f949a;
                r2 = r1.a(r2);
                r0 = r17;
                r3 = r0.f950b;
                r3 = r1.b(r3);
                r0 = r17;
                r4 = r0.f951c;
                r4 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
                r0 = r17;
                r5 = r0.f952d;
                r5 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r5);
                r0 = r17;
                r6 = r0.f953e;
                r6 = r1.b(r6);
                r0 = r17;
                r7 = r0.f954f;
                r7 = r1.b(r7);
                r0 = r17;
                r8 = r0.f955g;
                r8 = r1.b(r8);
                r0 = r17;
                r9 = r0.f956h;
                r9 = r1.b(r9);
                r0 = r17;
                r10 = r0.f957i;
                r10 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r10);
                r0 = r17;
                r11 = r0.f958j;
                r11 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r11);
                r0 = r17;
                r12 = r0.f959k;
                r12 = r1.b(r12);
                r0 = r17;
                r13 = r0.f960l;
                r13 = r1.b(r13);
                r0 = r17;
                r14 = r0.f961m;
                r14 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r14);
                r0 = r17;
                r15 = r0.f962n;
                r15 = r1.b(r15);
                r16 = 14;
                r0 = r16;
                r1.c(r0);
                r16 = 0;
                r0 = r16;
                r1.b(r0, r2);
                r2 = 1;
                r1.b(r2, r3);
                r2 = 2;
                r1.b(r2, r4);
                r2 = 3;
                r1.b(r2, r5);
                r2 = 4;
                r1.b(r2, r6);
                r2 = 5;
                r1.b(r2, r7);
                r2 = 6;
                r1.b(r2, r8);
                r2 = 7;
                r1.b(r2, r9);
                r2 = 8;
                r1.b(r2, r10);
                r2 = 9;
                r1.b(r2, r11);
                r2 = 10;
                r1.b(r2, r12);
                r2 = 11;
                r1.b(r2, r13);
                r2 = 12;
                r1.b(r2, r14);
                r2 = 13;
                r1.b(r2, r15);
                r2 = r1.d();
                r1.d(r2);
                r1 = r1.e();
                r2 = java.nio.ByteBuffer.wrap(r1);
                r1 = 0;
                r2.position(r1);
                r1 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r3 = 0;
                r4 = 0;
                r5 = 1;
                r6 = 0;
                r1.<init>(r2, r3, r4, r5, r6);
                r2 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel;
                r2.<init>(r1);
                return r2;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.Builder.a():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel");
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Deserializer extends FbJsonDeserializer {
            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.class;
                r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m1147a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r10 = this;
                r8 = 1;
                r6 = 0;
                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r4.<init>(r5);
                r5 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.m1265a(r11, r4);
                r4.d(r5);
                r4 = r4.e();
                r5 = java.nio.ByteBuffer.wrap(r4);
                r4 = 0;
                r5.position(r4);
                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r7 = r6;
                r9 = r6;
                r4.<init>(r5, r6, r7, r8, r9);
                r5 = 4;
                r6 = java.lang.Boolean.valueOf(r8);
                r4.a(r5, r6);
                r2 = r4;
                r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r11);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0048;
            L_0x0042:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0048:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1805730855)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_creative_editing_metadata */
        public final class RetailCarrierModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f969d;
            @Nullable
            private LegalTermsOfServiceTextModel f970e;
            @Nullable
            private LogoImageModel f971f;
            @Nullable
            private String f972g;

            /* compiled from: video_creative_editing_metadata */
            public final class Builder {
                public boolean f963a;
                @Nullable
                public LegalTermsOfServiceTextModel f964b;
                @Nullable
                public LogoImageModel f965c;
                @Nullable
                public String f966d;
            }

            /* compiled from: video_creative_editing_metadata */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.class;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m1148a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.RetailCarrierParser.m1259a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: video_creative_editing_metadata */
            public final class LegalTermsOfServiceTextModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f968d;

                /* compiled from: video_creative_editing_metadata */
                public final class Builder {
                    @Nullable
                    public String f967a;
                }

                /* compiled from: video_creative_editing_metadata */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.class;
                        r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel$LegalTermsOfServiceTextModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m1149a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.RetailCarrierParser.LegalTermsOfServiceTextParser.m1257a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel$LegalTermsOfServiceTextModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: video_creative_editing_metadata */
                public class Serializer extends JsonSerializer<LegalTermsOfServiceTextModel> {
                    public final void m1150a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m1152a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.RetailCarrierParser.LegalTermsOfServiceTextParser.m1258a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.class;
                        r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel$LegalTermsOfServiceTextModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.Serializer.<clinit>():void");
                    }
                }

                public LegalTermsOfServiceTextModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.<init>():void");
                }

                public LegalTermsOfServiceTextModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 1;
                    r2.<init>(r0);
                    r1 = r3.a;
                    r0 = r1;
                    r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r2.a(r3, r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m1154a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f968d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f968d = r0;
                    r0 = r2.f968d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.a():java.lang.String");
                }

                public static com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel m1151a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel r8) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    if (r8 != 0) goto L_0x0004;
                L_0x0002:
                    r8 = 0;
                L_0x0003:
                    return r8;
                L_0x0004:
                    r0 = r8 instanceof com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel;
                    if (r0 == 0) goto L_0x000b;
                L_0x0008:
                    r8 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel) r8;
                    goto L_0x0003;
                L_0x000b:
                    r0 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel$LegalTermsOfServiceTextModel$Builder;
                    r0.<init>();
                    r1 = r8.m1154a();
                    r0.f967a = r1;
                    r6 = 1;
                    r5 = 0;
                    r4 = 0;
                    r2 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r2.<init>(r3);
                    r3 = r0.f967a;
                    r3 = r2.b(r3);
                    r2.c(r6);
                    r2.b(r5, r3);
                    r3 = r2.d();
                    r2.d(r3);
                    r2 = r2.e();
                    r3 = java.nio.ByteBuffer.wrap(r2);
                    r3.position(r5);
                    r2 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r5 = r4;
                    r7 = r4;
                    r2.<init>(r3, r4, r5, r6, r7);
                    r3 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel$LegalTermsOfServiceTextModel;
                    r3.<init>(r2);
                    r8 = r3;
                    goto L_0x0003;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel$LegalTermsOfServiceTextModel):com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel$LegalTermsOfServiceTextModel");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = -1919764332; // 0xffffffff8d92b894 float:-9.04238E-31 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m1153a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m1152a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.h();
                    r0 = r2.m1154a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: video_creative_editing_metadata */
            public class Serializer extends JsonSerializer<RetailCarrierModel> {
                public final void m1155a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m1159a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.RetailCarrierParser.m1260a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.class;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.Serializer.<clinit>():void");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel m1163b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m1157j();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.b():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel$LegalTermsOfServiceTextModel");
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.LogoImage m1164c() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m1158k();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.c():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces$LogoImage");
            }

            public RetailCarrierModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 4;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.<init>():void");
            }

            public RetailCarrierModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 4;
                r2.<init>(r0);
                r1 = r3.a;
                r0 = r1;
                r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r2.a(r3, r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
            }

            public final boolean m1162a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 0;
                r1.a(r0, r0);
                r0 = r1.f969d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.a():boolean");
            }

            @javax.annotation.Nullable
            private com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel m1157j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f970e;
                r1 = 1;
                r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel) r0;
                r3.f970e = r0;
                r0 = r3.f970e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.j():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel$LegalTermsOfServiceTextModel");
            }

            @javax.annotation.Nullable
            private com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.LogoImageModel m1158k() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f971f;
                r1 = 2;
                r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.LogoImageModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.LogoImageModel) r0;
                r3.f971f = r0;
                r0 = r3.f971f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.k():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$LogoImageModel");
            }

            @javax.annotation.Nullable
            public final java.lang.String m1165d() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.f972g;
                r1 = 3;
                r0 = super.a(r0, r1);
                r2.f972g = r0;
                r0 = r2.f972g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.d():java.lang.String");
            }

            public static com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel m1156a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel r10) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                if (r10 != 0) goto L_0x0004;
            L_0x0002:
                r10 = 0;
            L_0x0003:
                return r10;
            L_0x0004:
                r0 = r10 instanceof com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel;
                if (r0 == 0) goto L_0x000b;
            L_0x0008:
                r10 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel) r10;
                goto L_0x0003;
            L_0x000b:
                r0 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel$Builder;
                r0.<init>();
                r1 = r10.m1162a();
                r0.f963a = r1;
                r1 = r10.m1163b();
                r1 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel.m1151a(r1);
                r0.f964b = r1;
                r1 = r10.m1164c();
                r1 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.LogoImageModel.m1220a(r1);
                r0.f965c = r1;
                r1 = r10.m1165d();
                r0.f966d = r1;
                r6 = 1;
                r9 = 0;
                r4 = 0;
                r2 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r2.<init>(r3);
                r3 = r0.f964b;
                r3 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r3);
                r5 = r0.f965c;
                r5 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r5);
                r7 = r0.f966d;
                r7 = r2.b(r7);
                r8 = 4;
                r2.c(r8);
                r8 = r0.f963a;
                r2.a(r9, r8);
                r2.b(r6, r3);
                r3 = 2;
                r2.b(r3, r5);
                r3 = 3;
                r2.b(r3, r7);
                r3 = r2.d();
                r2.d(r3);
                r2 = r2.e();
                r3 = java.nio.ByteBuffer.wrap(r2);
                r3.position(r9);
                r2 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r5 = r4;
                r7 = r4;
                r2.<init>(r3, r4, r5, r6, r7);
                r3 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel;
                r3.<init>(r2);
                r10 = r3;
                goto L_0x0003;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel):com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 2117526594; // 0x7e36e442 float:6.077617E37 double:1.0461971443E-314;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m1160a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r1 = 0;
                r3.h();
                r0 = r3.m1157j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m1157j();
                r0 = r4.b(r0);
                r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.LegalTermsOfServiceTextModel) r0;
                r2 = r3.m1157j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel) r1;
                r1.f970e = r0;
            L_0x0022:
                r0 = r3.m1158k();
                if (r0 == 0) goto L_0x0040;
            L_0x0028:
                r0 = r3.m1158k();
                r0 = r4.b(r0);
                r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.LogoImageModel) r0;
                r2 = r3.m1158k();
                if (r2 == r0) goto L_0x0040;
            L_0x0038:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel) r1;
                r1.f971f = r0;
            L_0x0040:
                r3.i();
                if (r1 != 0) goto L_0x0046;
            L_0x0045:
                return r3;
            L_0x0046:
                r3 = r1;
                goto L_0x0045;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m1159a(com.facebook.flatbuffers.FlatBufferBuilder r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r5.h();
                r0 = r5.m1157j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r0);
                r1 = r5.m1158k();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r1);
                r2 = r5.m1165d();
                r2 = r6.b(r2);
                r3 = 4;
                r6.c(r3);
                r3 = 0;
                r4 = r5.f969d;
                r6.a(r3, r4);
                r3 = 1;
                r6.b(r3, r0);
                r0 = 2;
                r6.b(r0, r1);
                r0 = 3;
                r6.b(r0, r2);
                r5.i();
                r0 = r6.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m1161a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                super.a(r2, r3, r4);
                r0 = 0;
                r0 = r2.a(r3, r0);
                r1.f969d = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1050581796)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_creative_editing_metadata */
        public final class RetailShipmentItemsModel extends BaseModel implements GraphQLVisitableModel {
            private int f975d;
            @Nullable
            private List<CommerceRetailItemModel> f976e;

            /* compiled from: video_creative_editing_metadata */
            public final class Builder {
                public int f973a;
                @Nullable
                public ImmutableList<CommerceRetailItemModel> f974b;
            }

            /* compiled from: video_creative_editing_metadata */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.class;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailShipmentItemsModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m1166a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.RetailShipmentItemsParser.m1261a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailShipmentItemsModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: video_creative_editing_metadata */
            public class Serializer extends JsonSerializer<RetailShipmentItemsModel> {
                public final void m1167a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m1170a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.RetailShipmentItemsParser.m1262a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.class;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailShipmentItemsModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.Serializer.<clinit>():void");
                }
            }

            public RetailShipmentItemsModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 2;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.<init>():void");
            }

            public RetailShipmentItemsModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 2;
                r2.<init>(r0);
                r1 = r3.a;
                r0 = r1;
                r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r2.a(r3, r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
            }

            public final int m1169a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 0;
                r1.a(r0, r0);
                r0 = r1.f975d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.a():int");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceRetailItemModel> m1173b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f976e;
                r1 = 1;
                r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceRetailItemModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f976e = r0;
                r0 = r3.f976e;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.b():com.google.common.collect.ImmutableList<com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceRetailItemModel>");
            }

            public static com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel m1168a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel r10) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                if (r10 != 0) goto L_0x0004;
            L_0x0002:
                r10 = 0;
            L_0x0003:
                return r10;
            L_0x0004:
                r0 = r10 instanceof com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel;
                if (r0 == 0) goto L_0x000b;
            L_0x0008:
                r10 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel) r10;
                goto L_0x0003;
            L_0x000b:
                r2 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailShipmentItemsModel$Builder;
                r2.<init>();
                r0 = r10.m1169a();
                r2.f973a = r0;
                r3 = com.google.common.collect.ImmutableList.builder();
                r0 = 0;
                r1 = r0;
            L_0x001c:
                r0 = r10.m1173b();
                r0 = r0.size();
                if (r1 >= r0) goto L_0x003b;
            L_0x0026:
                r0 = r10.m1173b();
                r0 = r0.get(r1);
                r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceRetailItem) r0;
                r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceRetailItemModel.m1137a(r0);
                r3.c(r0);
                r0 = r1 + 1;
                r1 = r0;
                goto L_0x001c;
            L_0x003b:
                r0 = r3.b();
                r2.f974b = r0;
                r8 = 1;
                r6 = 0;
                r9 = 0;
                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r4.<init>(r5);
                r5 = r2.f974b;
                r5 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r5);
                r7 = 2;
                r4.c(r7);
                r7 = r2.f973a;
                r4.a(r9, r7, r9);
                r4.b(r8, r5);
                r5 = r4.d();
                r4.d(r5);
                r4 = r4.e();
                r5 = java.nio.ByteBuffer.wrap(r4);
                r5.position(r9);
                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r7 = r6;
                r9 = r6;
                r4.<init>(r5, r6, r7, r8, r9);
                r5 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailShipmentItemsModel;
                r5.<init>(r4);
                r10 = r5;
                goto L_0x0003;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailShipmentItemsModel):com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailShipmentItemsModel");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 712381729; // 0x2a761521 float:2.185652E-13 double:3.51963339E-315;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m1171a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r2.h();
                r1 = r2.m1173b();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m1173b();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel) r0;
                r1 = r1.b();
                r0.f976e = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m1170a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r2 = 0;
                r3.h();
                r0 = r3.m1173b();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                r1 = 2;
                r4.c(r1);
                r1 = r3.f975d;
                r4.a(r2, r1, r2);
                r1 = 1;
                r4.b(r1, r0);
                r3.i();
                r0 = r4.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m1172a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 0;
                super.a(r2, r3, r4);
                r0 = r2.a(r3, r0, r0);
                r1.f975d = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Serializer extends JsonSerializer<CommerceShipmentBubbleModel> {
            public final void m1174a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r7 = this;
                r8 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel) r8;
                r2 = 0;
                r0 = r8.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r8.m1194a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r8.a(r0, r1);
            L_0x0035:
                r0 = r8.w_();
                r1 = r8.u_();
                com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.m1266a(r0, r1, r9, r10);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.class;
                r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1240033404)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_creative_editing_metadata */
        public final class ShipmentTrackingEventsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<CommerceBaseShipmentTrackingModel> f978d;

            /* compiled from: video_creative_editing_metadata */
            public final class Builder {
                @Nullable
                public ImmutableList<CommerceBaseShipmentTrackingModel> f977a;
            }

            /* compiled from: video_creative_editing_metadata */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.class;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$ShipmentTrackingEventsModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m1175a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.ShipmentTrackingEventsParser.m1263a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$ShipmentTrackingEventsModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: video_creative_editing_metadata */
            public class Serializer extends JsonSerializer<ShipmentTrackingEventsModel> {
                public final void m1176a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m1178a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.messaging.graphql.threads.CommerceThreadFragmentsParsers.CommerceShipmentBubbleParser.ShipmentTrackingEventsParser.m1264a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.class;
                    r1 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$ShipmentTrackingEventsModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.Serializer.<clinit>():void");
                }
            }

            public ShipmentTrackingEventsModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 1;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.<init>():void");
            }

            public ShipmentTrackingEventsModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 1;
                r2.<init>(r0);
                r1 = r3.a;
                r0 = r1;
                r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r2.a(r3, r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceBaseShipmentTrackingModel> m1180a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f978d;
                r1 = 0;
                r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceBaseShipmentTrackingModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f978d = r0;
                r0 = r3.f978d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.a():com.google.common.collect.ImmutableList<com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceBaseShipmentTrackingModel>");
            }

            public static com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel m1177a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel r10) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                if (r10 != 0) goto L_0x0004;
            L_0x0002:
                r10 = 0;
            L_0x0003:
                return r10;
            L_0x0004:
                r0 = r10 instanceof com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel;
                if (r0 == 0) goto L_0x000b;
            L_0x0008:
                r10 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel) r10;
                goto L_0x0003;
            L_0x000b:
                r2 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$ShipmentTrackingEventsModel$Builder;
                r2.<init>();
                r3 = com.google.common.collect.ImmutableList.builder();
                r0 = 0;
                r1 = r0;
            L_0x0016:
                r0 = r10.m1180a();
                r0 = r0.size();
                if (r1 >= r0) goto L_0x0035;
            L_0x0020:
                r0 = r10.m1180a();
                r0 = r0.get(r1);
                r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceBaseShipmentTracking) r0;
                r0 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceBaseShipmentTrackingModel.m1020a(r0);
                r3.c(r0);
                r0 = r1 + 1;
                r1 = r0;
                goto L_0x0016;
            L_0x0035:
                r0 = r3.b();
                r2.f977a = r0;
                r8 = 1;
                r7 = 0;
                r6 = 0;
                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r4.<init>(r5);
                r5 = r2.f977a;
                r5 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r5);
                r4.c(r8);
                r4.b(r7, r5);
                r5 = r4.d();
                r4.d(r5);
                r4 = r4.e();
                r5 = java.nio.ByteBuffer.wrap(r4);
                r5.position(r7);
                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r7 = r6;
                r9 = r6;
                r4.<init>(r5, r6, r7, r8, r9);
                r5 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$ShipmentTrackingEventsModel;
                r5.<init>(r4);
                r10 = r5;
                goto L_0x0003;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$ShipmentTrackingEventsModel):com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$ShipmentTrackingEventsModel");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = -1278803285; // 0xffffffffb3c702ab float:-9.267145E-8 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m1179a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r2.h();
                r1 = r2.m1180a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m1180a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel) r0;
                r1 = r1.b();
                r0.f978d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m1178a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r2.h();
                r0 = r2.m1180a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel mo61B() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m1184l();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.B():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel");
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel mo62C() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m1185m();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.C():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailShipmentItemsModel");
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel mo65F() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m1186n();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.F():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$ShipmentTrackingEventsModel");
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel mo70w() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m1182j();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.w():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceLocationModel");
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel mo71x() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m1183k();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.x():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceLocationModel");
        }

        public CommerceShipmentBubbleModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 14;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.<init>():void");
        }

        public CommerceShipmentBubbleModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = 14;
            r2.<init>(r0);
            r1 = r3.a;
            r0 = r1;
            r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
            r2.a(r3, r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
        }

        @javax.annotation.Nullable
        public final com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType mo67b() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.f979d;
            r1 = 0;
            r2 = com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType.class;
            r3 = com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            r0 = super.b(r0, r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType) r0;
            r4.f979d = r0;
            r0 = r4.f979d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.b():com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo69v() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f980e;
            r1 = 1;
            r0 = super.a(r0, r1);
            r2.f980e = r0;
            r0 = r2.f980e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.v():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel m1182j() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f981f;
            r1 = 2;
            r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel) r0;
            r3.f981f = r0;
            r0 = r3.f981f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.j():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceLocationModel");
        }

        @javax.annotation.Nullable
        private com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel m1183k() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f982g;
            r1 = 3;
            r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel) r0;
            r3.f982g = r0;
            r0 = r3.f982g;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.k():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceLocationModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo72y() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f983h;
            r1 = 4;
            r0 = super.a(r0, r1);
            r2.f983h = r0;
            r0 = r2.f983h;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.y():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo73z() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f984i;
            r1 = 5;
            r0 = super.a(r0, r1);
            r2.f984i = r0;
            r0 = r2.f984i;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.z():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo68c() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f985j;
            r1 = 6;
            r0 = super.a(r0, r1);
            r2.f985j = r0;
            r0 = r2.f985j;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.c():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo60A() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f986k;
            r1 = 7;
            r0 = super.a(r0, r1);
            r2.f986k = r0;
            r0 = r2.f986k;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.A():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel m1184l() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f987l;
            r1 = 8;
            r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel) r0;
            r3.f987l = r0;
            r0 = r3.f987l;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.l():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailCarrierModel");
        }

        @javax.annotation.Nullable
        private com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel m1185m() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f988m;
            r1 = 9;
            r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel) r0;
            r3.f988m = r0;
            r0 = r3.f988m;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.m():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$RetailShipmentItemsModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo63D() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f989n;
            r1 = 10;
            r0 = super.a(r0, r1);
            r2.f989n = r0;
            r0 = r2.f989n;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.D():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo64E() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f990o;
            r1 = 11;
            r0 = super.a(r0, r1);
            r2.f990o = r0;
            r0 = r2.f990o;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.E():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel m1186n() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f991p;
            r1 = 12;
            r2 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel) r0;
            r3.f991p = r0;
            r0 = r3.f991p;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.n():com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$ShipmentTrackingEventsModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo66G() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f992q;
            r1 = 13;
            r0 = super.a(r0, r1);
            r2.f992q = r0;
            r0 = r2.f992q;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.G():java.lang.String");
        }

        public static com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel m1181a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceShipmentBubble r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            if (r2 != 0) goto L_0x0004;
        L_0x0002:
            r2 = 0;
        L_0x0003:
            return r2;
        L_0x0004:
            r0 = r2 instanceof com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel;
            if (r0 == 0) goto L_0x000b;
        L_0x0008:
            r2 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel) r2;
            goto L_0x0003;
        L_0x000b:
            r0 = new com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel$Builder;
            r0.<init>();
            r1 = r2.mo67b();
            r0.f949a = r1;
            r1 = r2.mo69v();
            r0.f950b = r1;
            r1 = r2.mo70w();
            r1 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel.m1034a(r1);
            r0.f951c = r1;
            r1 = r2.mo71x();
            r1 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel.m1034a(r1);
            r0.f952d = r1;
            r1 = r2.mo72y();
            r0.f953e = r1;
            r1 = r2.mo73z();
            r0.f954f = r1;
            r1 = r2.mo68c();
            r0.f955g = r1;
            r1 = r2.mo60A();
            r0.f956h = r1;
            r1 = r2.mo61B();
            r1 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel.m1156a(r1);
            r0.f957i = r1;
            r1 = r2.mo62C();
            r1 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel.m1168a(r1);
            r0.f958j = r1;
            r1 = r2.mo63D();
            r0.f959k = r1;
            r1 = r2.mo64E();
            r0.f960l = r1;
            r1 = r2.mo65F();
            r1 = com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel.m1177a(r1);
            r0.f961m = r1;
            r1 = r2.mo66G();
            r0.f962n = r1;
            r2 = r0.m1146a();
            goto L_0x0003;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.a(com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces$CommerceShipmentBubble):com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels$CommerceShipmentBubbleModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String m1196a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.mo68c();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.a():java.lang.String");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 697177488; // 0x298e1590 float:6.309807E-14 double:3.44451446E-315;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m1195a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r1 = 0;
            r3.h();
            r0 = r3.m1182j();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m1182j();
            r0 = r4.b(r0);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel) r0;
            r2 = r3.m1182j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel) r1;
            r1.f981f = r0;
        L_0x0022:
            r0 = r3.m1183k();
            if (r0 == 0) goto L_0x0040;
        L_0x0028:
            r0 = r3.m1183k();
            r0 = r4.b(r0);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel) r0;
            r2 = r3.m1183k();
            if (r2 == r0) goto L_0x0040;
        L_0x0038:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel) r1;
            r1.f982g = r0;
        L_0x0040:
            r0 = r3.m1184l();
            if (r0 == 0) goto L_0x005e;
        L_0x0046:
            r0 = r3.m1184l();
            r0 = r4.b(r0);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel) r0;
            r2 = r3.m1184l();
            if (r2 == r0) goto L_0x005e;
        L_0x0056:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel) r1;
            r1.f987l = r0;
        L_0x005e:
            r0 = r3.m1185m();
            if (r0 == 0) goto L_0x007c;
        L_0x0064:
            r0 = r3.m1185m();
            r0 = r4.b(r0);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel) r0;
            r2 = r3.m1185m();
            if (r2 == r0) goto L_0x007c;
        L_0x0074:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel) r1;
            r1.f988m = r0;
        L_0x007c:
            r0 = r3.m1186n();
            if (r0 == 0) goto L_0x009a;
        L_0x0082:
            r0 = r3.m1186n();
            r0 = r4.b(r0);
            r0 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel) r0;
            r2 = r3.m1186n();
            if (r2 == r0) goto L_0x009a;
        L_0x0092:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel) r1;
            r1.f991p = r0;
        L_0x009a:
            r3.i();
            if (r1 != 0) goto L_0x00a0;
        L_0x009f:
            return r3;
        L_0x00a0:
            r3 = r1;
            goto L_0x009f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m1194a(com.facebook.flatbuffers.FlatBufferBuilder r17) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r16 = this;
            r16.h();
            r1 = r16.mo67b();
            r0 = r17;
            r1 = r0.a(r1);
            r2 = r16.mo69v();
            r0 = r17;
            r2 = r0.b(r2);
            r3 = r16.m1182j();
            r0 = r17;
            r3 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
            r4 = r16.m1183k();
            r0 = r17;
            r4 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r4);
            r5 = r16.mo72y();
            r0 = r17;
            r5 = r0.b(r5);
            r6 = r16.mo73z();
            r0 = r17;
            r6 = r0.b(r6);
            r7 = r16.mo68c();
            r0 = r17;
            r7 = r0.b(r7);
            r8 = r16.mo60A();
            r0 = r17;
            r8 = r0.b(r8);
            r9 = r16.m1184l();
            r0 = r17;
            r9 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r9);
            r10 = r16.m1185m();
            r0 = r17;
            r10 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r10);
            r11 = r16.mo63D();
            r0 = r17;
            r11 = r0.b(r11);
            r12 = r16.mo64E();
            r0 = r17;
            r12 = r0.b(r12);
            r13 = r16.m1186n();
            r0 = r17;
            r13 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r13);
            r14 = r16.mo66G();
            r0 = r17;
            r14 = r0.b(r14);
            r15 = 14;
            r0 = r17;
            r0.c(r15);
            r15 = 0;
            r0 = r17;
            r0.b(r15, r1);
            r1 = 1;
            r0 = r17;
            r0.b(r1, r2);
            r1 = 2;
            r0 = r17;
            r0.b(r1, r3);
            r1 = 3;
            r0 = r17;
            r0.b(r1, r4);
            r1 = 4;
            r0 = r17;
            r0.b(r1, r5);
            r1 = 5;
            r0 = r17;
            r0.b(r1, r6);
            r1 = 6;
            r0 = r17;
            r0.b(r1, r7);
            r1 = 7;
            r0 = r17;
            r0.b(r1, r8);
            r1 = 8;
            r0 = r17;
            r0.b(r1, r9);
            r1 = 9;
            r0 = r17;
            r0.b(r1, r10);
            r1 = 10;
            r0 = r17;
            r0.b(r1, r11);
            r1 = 11;
            r0 = r17;
            r0.b(r1, r12);
            r1 = 12;
            r0 = r17;
            r0.b(r1, r13);
            r1 = 13;
            r0 = r17;
            r0.b(r1, r14);
            r16.i();
            r1 = r17.d();
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 154367135)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_creative_editing_metadata */
    public final class CommerceShipmentTrackingBubbleModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CommerceShipmentTrackingBubble {
        @Nullable
        private GraphQLMessengerCommerceBubbleType f993d;
        @Nullable
        private String f994e;
        @Nullable
        private CommerceLocationModel f995f;
        @Nullable
        private CommerceShipmentBubbleModel f996g;
        @Nullable
        private GraphQLShipmentTrackingEventType f997h;
        @Nullable
        private String f998i;
        @Nullable
        private String f999j;

        /* compiled from: video_creative_editing_metadata */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceShipmentTrackingBubbleModel.class, new Deserializer());
            }

            public Object m1204a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommerceShipmentTrackingBubbleParser.m1267a(jsonParser);
                Object commerceShipmentTrackingBubbleModel = new CommerceShipmentTrackingBubbleModel();
                ((BaseModel) commerceShipmentTrackingBubbleModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commerceShipmentTrackingBubbleModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceShipmentTrackingBubbleModel).a();
                }
                return commerceShipmentTrackingBubbleModel;
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Serializer extends JsonSerializer<CommerceShipmentTrackingBubbleModel> {
            public final void m1205a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceShipmentTrackingBubbleModel commerceShipmentTrackingBubbleModel = (CommerceShipmentTrackingBubbleModel) obj;
                if (commerceShipmentTrackingBubbleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceShipmentTrackingBubbleModel.m1209a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceShipmentTrackingBubbleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceShipmentTrackingBubbleParser.m1268a(commerceShipmentTrackingBubbleModel.w_(), commerceShipmentTrackingBubbleModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommerceShipmentTrackingBubbleModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CommerceShipmentBubble mo109H() {
            return m1207k();
        }

        @Nullable
        public final /* synthetic */ CommerceLocationModel mo79l() {
            return m1206j();
        }

        public CommerceShipmentTrackingBubbleModel() {
            super(7);
        }

        @Nullable
        public final GraphQLMessengerCommerceBubbleType mo77b() {
            this.f993d = (GraphQLMessengerCommerceBubbleType) super.b(this.f993d, 0, GraphQLMessengerCommerceBubbleType.class, GraphQLMessengerCommerceBubbleType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f993d;
        }

        @Nullable
        public final String mo78c() {
            this.f994e = super.a(this.f994e, 1);
            return this.f994e;
        }

        @Nullable
        private CommerceLocationModel m1206j() {
            this.f995f = (CommerceLocationModel) super.a(this.f995f, 2, CommerceLocationModel.class);
            return this.f995f;
        }

        @Nullable
        private CommerceShipmentBubbleModel m1207k() {
            this.f996g = (CommerceShipmentBubbleModel) super.a(this.f996g, 3, CommerceShipmentBubbleModel.class);
            return this.f996g;
        }

        @Nullable
        public final GraphQLShipmentTrackingEventType mo80m() {
            this.f997h = (GraphQLShipmentTrackingEventType) super.b(this.f997h, 4, GraphQLShipmentTrackingEventType.class, GraphQLShipmentTrackingEventType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f997h;
        }

        @Nullable
        public final String mo81n() {
            this.f998i = super.a(this.f998i, 5);
            return this.f998i;
        }

        @Nullable
        public final String mo82o() {
            this.f999j = super.a(this.f999j, 6);
            return this.f999j;
        }

        @Nullable
        public final String m1211a() {
            return mo78c();
        }

        public final int jK_() {
            return 558867059;
        }

        public final GraphQLVisitableModel m1210a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1206j() != null) {
                CommerceLocationModel commerceLocationModel = (CommerceLocationModel) graphQLModelMutatingVisitor.b(m1206j());
                if (m1206j() != commerceLocationModel) {
                    graphQLVisitableModel = (CommerceShipmentTrackingBubbleModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f995f = commerceLocationModel;
                }
            }
            if (m1207k() != null) {
                CommerceShipmentBubbleModel commerceShipmentBubbleModel = (CommerceShipmentBubbleModel) graphQLModelMutatingVisitor.b(m1207k());
                if (m1207k() != commerceShipmentBubbleModel) {
                    graphQLVisitableModel = (CommerceShipmentTrackingBubbleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f996g = commerceShipmentBubbleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1209a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(mo77b());
            int b = flatBufferBuilder.b(mo78c());
            int a2 = ModelHelper.a(flatBufferBuilder, m1206j());
            int a3 = ModelHelper.a(flatBufferBuilder, m1207k());
            int a4 = flatBufferBuilder.a(mo80m());
            int b2 = flatBufferBuilder.b(mo81n());
            int b3 = flatBufferBuilder.b(mo82o());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.b(6, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 729935302)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_creative_editing_metadata */
    public final class LogoImageModel extends BaseModel implements GraphQLVisitableModel, LogoImage {
        private int f1003d;
        @Nullable
        private String f1004e;
        private int f1005f;

        /* compiled from: video_creative_editing_metadata */
        public final class Builder {
            public int f1000a;
            @Nullable
            public String f1001b;
            public int f1002c;
        }

        /* compiled from: video_creative_editing_metadata */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LogoImageModel.class, new Deserializer());
            }

            public Object m1218a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LogoImageParser.m1269a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object logoImageModel = new LogoImageModel();
                ((BaseModel) logoImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (logoImageModel instanceof Postprocessable) {
                    return ((Postprocessable) logoImageModel).a();
                }
                return logoImageModel;
            }
        }

        /* compiled from: video_creative_editing_metadata */
        public class Serializer extends JsonSerializer<LogoImageModel> {
            public final void m1219a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LogoImageModel logoImageModel = (LogoImageModel) obj;
                if (logoImageModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(logoImageModel.m1222a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    logoImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LogoImageParser.m1270a(logoImageModel.w_(), logoImageModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(LogoImageModel.class, new Serializer());
            }
        }

        public LogoImageModel() {
            super(3);
        }

        public LogoImageModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int mo110a() {
            a(0, 0);
            return this.f1003d;
        }

        @Nullable
        public final String mo111b() {
            this.f1004e = super.a(this.f1004e, 1);
            return this.f1004e;
        }

        public final int mo112c() {
            a(0, 2);
            return this.f1005f;
        }

        public static LogoImageModel m1220a(LogoImage logoImage) {
            if (logoImage == null) {
                return null;
            }
            if (logoImage instanceof LogoImageModel) {
                return (LogoImageModel) logoImage;
            }
            Builder builder = new Builder();
            builder.f1000a = logoImage.mo110a();
            builder.f1001b = logoImage.mo111b();
            builder.f1002c = logoImage.mo112c();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f1001b);
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, builder.f1000a, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, builder.f1002c, 0);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new LogoImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m1223a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m1222a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo111b());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f1003d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f1005f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1224a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1003d = mutableFlatBuffer.a(i, 0, 0);
            this.f1005f = mutableFlatBuffer.a(i, 2, 0);
        }
    }
}
