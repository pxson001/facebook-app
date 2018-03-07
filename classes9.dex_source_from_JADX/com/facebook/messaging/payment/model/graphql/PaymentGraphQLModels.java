package com.facebook.messaging.payment.model.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMessengerPayThemeAssetCompatibilityEnum;
import com.facebook.graphql.enums.GraphQLMessengerPayThemeAssetTypeEnum;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;
import com.facebook.graphql.enums.GraphQLPeerToPeerTransferReceiverStatus;
import com.facebook.graphql.enums.GraphQLPeerToPeerTransferSenderStatus;
import com.facebook.graphql.enums.GraphQLProductAvailability;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.CommerceOrderParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchAllMoreTransactionsQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchAllThemesQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchAllTransactionListQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchIncomingMoreTransactionsQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchIncomingPaymentRequestsQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchIncomingPaymentRequestsQueryParser.IncomingPeerToPeerPaymentRequestsParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchIncomingTransactionListQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchOutgoingMoreTransactionsQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchOutgoingPaymentRequestsQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchOutgoingPaymentRequestsQueryParser.OutgoingPeerToPeerPaymentRequestsParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchOutgoingTransactionListQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchPaymentAccountEnabledStatusQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchPaymentPinStatusQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchPaymentPinStatusQueryParser.PeerToPeerPaymentsParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchPaymentPlatformContextsQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchShippingAddressQueryParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.FetchShippingAddressQueryParser.MailingAddressesParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.MailingAddressInfoParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PageInfoParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentAccountEnabledStatusParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentCurrencyAmountParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentCurrencyQuantityParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentPinStatusParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentPinStatusParser.ProtectedThreadProfilesParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentPinStatusParser.UnprotectedThreadProfilesParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentPlatformContextParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentPlatformContextParser.PeerToPeerPlatformProductItemParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentPlatformItemParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentPlatformItemParser.MerchantLogoParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentPlatformItemParser.PlatformImagesParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentRequestParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentShippingOptionParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentTransactionParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentTransactionsParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentUserParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PlatformItemParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PlatformItemParser.PhotosParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PlatformItemParser.PhotosParser.ImageParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.StreetAddressInfoParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.ThemeAssetParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.ThemeParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.ThemeParser.AssetsParser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.TransferContextParser;
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

/* compiled from: helpText */
public class PaymentGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2033975810)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class CommerceOrderModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f13276d;
        @Nullable
        private String f13277e;
        @Nullable
        private String f13278f;
        @Nullable
        private String f13279g;
        @Nullable
        private String f13280h;

        /* compiled from: helpText */
        public final class Builder {
            @Nullable
            public String f13271a;
            @Nullable
            public String f13272b;
            @Nullable
            public String f13273c;
            @Nullable
            public String f13274d;
            @Nullable
            public String f13275e;

            public final CommerceOrderModel m13567a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f13271a);
                int b2 = flatBufferBuilder.b(this.f13272b);
                int b3 = flatBufferBuilder.b(this.f13273c);
                int b4 = flatBufferBuilder.b(this.f13274d);
                int b5 = flatBufferBuilder.b(this.f13275e);
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, b4);
                flatBufferBuilder.b(4, b5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CommerceOrderModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceOrderModel.class, new Deserializer());
            }

            public Object m13568a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommerceOrderParser.m13952a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commerceOrderModel = new CommerceOrderModel();
                ((BaseModel) commerceOrderModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commerceOrderModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceOrderModel).a();
                }
                return commerceOrderModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<CommerceOrderModel> {
            public final void m13569a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceOrderModel commerceOrderModel = (CommerceOrderModel) obj;
                if (commerceOrderModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceOrderModel.m13571a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceOrderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceOrderParser.m13953a(commerceOrderModel.w_(), commerceOrderModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(CommerceOrderModel.class, new Serializer());
            }
        }

        public CommerceOrderModel() {
            super(5);
        }

        public CommerceOrderModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m13574b() {
            this.f13276d = super.a(this.f13276d, 0);
            return this.f13276d;
        }

        @Nullable
        public final String m13575c() {
            this.f13277e = super.a(this.f13277e, 1);
            return this.f13277e;
        }

        @Nullable
        public final String m13576d() {
            this.f13278f = super.a(this.f13278f, 2);
            return this.f13278f;
        }

        @Nullable
        public final String ln_() {
            this.f13279g = super.a(this.f13279g, 3);
            return this.f13279g;
        }

        @Nullable
        public final String m13577g() {
            this.f13280h = super.a(this.f13280h, 4);
            return this.f13280h;
        }

        public static CommerceOrderModel m13570a(CommerceOrderModel commerceOrderModel) {
            if (commerceOrderModel == null) {
                return null;
            }
            if (commerceOrderModel instanceof CommerceOrderModel) {
                return commerceOrderModel;
            }
            Builder builder = new Builder();
            builder.f13271a = commerceOrderModel.m13574b();
            builder.f13272b = commerceOrderModel.m13575c();
            builder.f13273c = commerceOrderModel.m13576d();
            builder.f13274d = commerceOrderModel.ln_();
            builder.f13275e = commerceOrderModel.m13577g();
            return builder.m13567a();
        }

        @Nullable
        public final String m13573a() {
            return m13575c();
        }

        public final int jK_() {
            return 1851543484;
        }

        public final GraphQLVisitableModel m13572a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m13571a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13574b());
            int b2 = flatBufferBuilder.b(m13575c());
            int b3 = flatBufferBuilder.b(m13576d());
            int b4 = flatBufferBuilder.b(ln_());
            int b5 = flatBufferBuilder.b(m13577g());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.b(4, b5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1043771783)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchAllMoreTransactionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PaymentTransactionsModel f13281d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchAllMoreTransactionsQueryModel.class, new Deserializer());
            }

            public Object m13578a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchAllMoreTransactionsQueryParser.m13954a(jsonParser);
                Object fetchAllMoreTransactionsQueryModel = new FetchAllMoreTransactionsQueryModel();
                ((BaseModel) fetchAllMoreTransactionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchAllMoreTransactionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchAllMoreTransactionsQueryModel).a();
                }
                return fetchAllMoreTransactionsQueryModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchAllMoreTransactionsQueryModel> {
            public final void m13579a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchAllMoreTransactionsQueryModel fetchAllMoreTransactionsQueryModel = (FetchAllMoreTransactionsQueryModel) obj;
                if (fetchAllMoreTransactionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchAllMoreTransactionsQueryModel.m13580a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchAllMoreTransactionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchAllMoreTransactionsQueryModel.w_();
                int u_ = fetchAllMoreTransactionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("all_messenger_payments");
                    PaymentTransactionsParser.m14013a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchAllMoreTransactionsQueryModel.class, new Serializer());
            }
        }

        public FetchAllMoreTransactionsQueryModel() {
            super(1);
        }

        @Nullable
        public final PaymentTransactionsModel m13582a() {
            this.f13281d = (PaymentTransactionsModel) super.a(this.f13281d, 0, PaymentTransactionsModel.class);
            return this.f13281d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13581a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13582a() != null) {
                PaymentTransactionsModel paymentTransactionsModel = (PaymentTransactionsModel) graphQLModelMutatingVisitor.b(m13582a());
                if (m13582a() != paymentTransactionsModel) {
                    graphQLVisitableModel = (FetchAllMoreTransactionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13281d = paymentTransactionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13580a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13582a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1060999785)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchAllThemesQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ThemeModel> f13282d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchAllThemesQueryModel.class, new Deserializer());
            }

            public Object m13583a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchAllThemesQueryParser.m13955a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchAllThemesQueryModel = new FetchAllThemesQueryModel();
                ((BaseModel) fetchAllThemesQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchAllThemesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchAllThemesQueryModel).a();
                }
                return fetchAllThemesQueryModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchAllThemesQueryModel> {
            public final void m13584a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchAllThemesQueryModel fetchAllThemesQueryModel = (FetchAllThemesQueryModel) obj;
                if (fetchAllThemesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchAllThemesQueryModel.m13585a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchAllThemesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchAllThemesQueryModel.w_();
                int u_ = fetchAllThemesQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("all_themes");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        ThemeParser.m14031b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchAllThemesQueryModel.class, new Serializer());
            }
        }

        public FetchAllThemesQueryModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<ThemeModel> m13587a() {
            this.f13282d = super.a(this.f13282d, 0, ThemeModel.class);
            return (ImmutableList) this.f13282d;
        }

        public final int jK_() {
            return -652569390;
        }

        public final GraphQLVisitableModel m13586a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13587a() != null) {
                Builder a = ModelHelper.a(m13587a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FetchAllThemesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13282d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13585a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13587a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1043771783)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchAllTransactionListQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PaymentTransactionsModel f13283d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchAllTransactionListQueryModel.class, new Deserializer());
            }

            public Object m13588a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchAllTransactionListQueryParser.m13956a(jsonParser);
                Object fetchAllTransactionListQueryModel = new FetchAllTransactionListQueryModel();
                ((BaseModel) fetchAllTransactionListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchAllTransactionListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchAllTransactionListQueryModel).a();
                }
                return fetchAllTransactionListQueryModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchAllTransactionListQueryModel> {
            public final void m13589a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchAllTransactionListQueryModel fetchAllTransactionListQueryModel = (FetchAllTransactionListQueryModel) obj;
                if (fetchAllTransactionListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchAllTransactionListQueryModel.m13590a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchAllTransactionListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchAllTransactionListQueryModel.w_();
                int u_ = fetchAllTransactionListQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("all_messenger_payments");
                    PaymentTransactionsParser.m14013a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchAllTransactionListQueryModel.class, new Serializer());
            }
        }

        public FetchAllTransactionListQueryModel() {
            super(1);
        }

        @Nullable
        public final PaymentTransactionsModel m13592a() {
            this.f13283d = (PaymentTransactionsModel) super.a(this.f13283d, 0, PaymentTransactionsModel.class);
            return this.f13283d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13591a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13592a() != null) {
                PaymentTransactionsModel paymentTransactionsModel = (PaymentTransactionsModel) graphQLModelMutatingVisitor.b(m13592a());
                if (m13592a() != paymentTransactionsModel) {
                    graphQLVisitableModel = (FetchAllTransactionListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13283d = paymentTransactionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13590a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13592a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 357893265)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchIncomingMoreTransactionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PaymentTransactionsModel f13284d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchIncomingMoreTransactionsQueryModel.class, new Deserializer());
            }

            public Object m13593a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchIncomingMoreTransactionsQueryParser.m13957a(jsonParser);
                Object fetchIncomingMoreTransactionsQueryModel = new FetchIncomingMoreTransactionsQueryModel();
                ((BaseModel) fetchIncomingMoreTransactionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchIncomingMoreTransactionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchIncomingMoreTransactionsQueryModel).a();
                }
                return fetchIncomingMoreTransactionsQueryModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchIncomingMoreTransactionsQueryModel> {
            public final void m13594a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchIncomingMoreTransactionsQueryModel fetchIncomingMoreTransactionsQueryModel = (FetchIncomingMoreTransactionsQueryModel) obj;
                if (fetchIncomingMoreTransactionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchIncomingMoreTransactionsQueryModel.m13595a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchIncomingMoreTransactionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchIncomingMoreTransactionsQueryModel.w_();
                int u_ = fetchIncomingMoreTransactionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("incoming_messenger_payments");
                    PaymentTransactionsParser.m14013a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchIncomingMoreTransactionsQueryModel.class, new Serializer());
            }
        }

        public FetchIncomingMoreTransactionsQueryModel() {
            super(1);
        }

        @Nullable
        public final PaymentTransactionsModel m13597a() {
            this.f13284d = (PaymentTransactionsModel) super.a(this.f13284d, 0, PaymentTransactionsModel.class);
            return this.f13284d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13596a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13597a() != null) {
                PaymentTransactionsModel paymentTransactionsModel = (PaymentTransactionsModel) graphQLModelMutatingVisitor.b(m13597a());
                if (m13597a() != paymentTransactionsModel) {
                    graphQLVisitableModel = (FetchIncomingMoreTransactionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13284d = paymentTransactionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13595a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13597a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2033459429)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchIncomingPaymentRequestsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private IncomingPeerToPeerPaymentRequestsModel f13286d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchIncomingPaymentRequestsQueryModel.class, new Deserializer());
            }

            public Object m13598a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchIncomingPaymentRequestsQueryParser.m13960a(jsonParser);
                Object fetchIncomingPaymentRequestsQueryModel = new FetchIncomingPaymentRequestsQueryModel();
                ((BaseModel) fetchIncomingPaymentRequestsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchIncomingPaymentRequestsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchIncomingPaymentRequestsQueryModel).a();
                }
                return fetchIncomingPaymentRequestsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1821416147)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: helpText */
        public final class IncomingPeerToPeerPaymentRequestsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PaymentRequestModel> f13285d;

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(IncomingPeerToPeerPaymentRequestsModel.class, new Deserializer());
                }

                public Object m13599a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(IncomingPeerToPeerPaymentRequestsParser.m13958a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object incomingPeerToPeerPaymentRequestsModel = new IncomingPeerToPeerPaymentRequestsModel();
                    ((BaseModel) incomingPeerToPeerPaymentRequestsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (incomingPeerToPeerPaymentRequestsModel instanceof Postprocessable) {
                        return ((Postprocessable) incomingPeerToPeerPaymentRequestsModel).a();
                    }
                    return incomingPeerToPeerPaymentRequestsModel;
                }
            }

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<IncomingPeerToPeerPaymentRequestsModel> {
                public final void m13600a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    IncomingPeerToPeerPaymentRequestsModel incomingPeerToPeerPaymentRequestsModel = (IncomingPeerToPeerPaymentRequestsModel) obj;
                    if (incomingPeerToPeerPaymentRequestsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(incomingPeerToPeerPaymentRequestsModel.m13601a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        incomingPeerToPeerPaymentRequestsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    IncomingPeerToPeerPaymentRequestsParser.m13959a(incomingPeerToPeerPaymentRequestsModel.w_(), incomingPeerToPeerPaymentRequestsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(IncomingPeerToPeerPaymentRequestsModel.class, new Serializer());
                }
            }

            public IncomingPeerToPeerPaymentRequestsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<PaymentRequestModel> m13603a() {
                this.f13285d = super.a(this.f13285d, 0, PaymentRequestModel.class);
                return (ImmutableList) this.f13285d;
            }

            public final int jK_() {
                return -1493600637;
            }

            public final GraphQLVisitableModel m13602a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13603a() != null) {
                    Builder a = ModelHelper.a(m13603a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (IncomingPeerToPeerPaymentRequestsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13285d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13601a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13603a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchIncomingPaymentRequestsQueryModel> {
            public final void m13604a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchIncomingPaymentRequestsQueryModel fetchIncomingPaymentRequestsQueryModel = (FetchIncomingPaymentRequestsQueryModel) obj;
                if (fetchIncomingPaymentRequestsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchIncomingPaymentRequestsQueryModel.m13605a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchIncomingPaymentRequestsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchIncomingPaymentRequestsQueryModel.w_();
                int u_ = fetchIncomingPaymentRequestsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("incoming_peer_to_peer_payment_requests");
                    IncomingPeerToPeerPaymentRequestsParser.m13959a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchIncomingPaymentRequestsQueryModel.class, new Serializer());
            }
        }

        public FetchIncomingPaymentRequestsQueryModel() {
            super(1);
        }

        @Nullable
        public final IncomingPeerToPeerPaymentRequestsModel m13607a() {
            this.f13286d = (IncomingPeerToPeerPaymentRequestsModel) super.a(this.f13286d, 0, IncomingPeerToPeerPaymentRequestsModel.class);
            return this.f13286d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13606a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13607a() != null) {
                IncomingPeerToPeerPaymentRequestsModel incomingPeerToPeerPaymentRequestsModel = (IncomingPeerToPeerPaymentRequestsModel) graphQLModelMutatingVisitor.b(m13607a());
                if (m13607a() != incomingPeerToPeerPaymentRequestsModel) {
                    graphQLVisitableModel = (FetchIncomingPaymentRequestsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13286d = incomingPeerToPeerPaymentRequestsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13605a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13607a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 357893265)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchIncomingTransactionListQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PaymentTransactionsModel f13287d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchIncomingTransactionListQueryModel.class, new Deserializer());
            }

            public Object m13608a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchIncomingTransactionListQueryParser.m13961a(jsonParser);
                Object fetchIncomingTransactionListQueryModel = new FetchIncomingTransactionListQueryModel();
                ((BaseModel) fetchIncomingTransactionListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchIncomingTransactionListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchIncomingTransactionListQueryModel).a();
                }
                return fetchIncomingTransactionListQueryModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchIncomingTransactionListQueryModel> {
            public final void m13609a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchIncomingTransactionListQueryModel fetchIncomingTransactionListQueryModel = (FetchIncomingTransactionListQueryModel) obj;
                if (fetchIncomingTransactionListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchIncomingTransactionListQueryModel.m13610a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchIncomingTransactionListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchIncomingTransactionListQueryModel.w_();
                int u_ = fetchIncomingTransactionListQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("incoming_messenger_payments");
                    PaymentTransactionsParser.m14013a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchIncomingTransactionListQueryModel.class, new Serializer());
            }
        }

        public FetchIncomingTransactionListQueryModel() {
            super(1);
        }

        @Nullable
        public final PaymentTransactionsModel m13612a() {
            this.f13287d = (PaymentTransactionsModel) super.a(this.f13287d, 0, PaymentTransactionsModel.class);
            return this.f13287d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13611a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13612a() != null) {
                PaymentTransactionsModel paymentTransactionsModel = (PaymentTransactionsModel) graphQLModelMutatingVisitor.b(m13612a());
                if (m13612a() != paymentTransactionsModel) {
                    graphQLVisitableModel = (FetchIncomingTransactionListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13287d = paymentTransactionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13610a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13612a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -879452820)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchOutgoingMoreTransactionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PaymentTransactionsModel f13288d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchOutgoingMoreTransactionsQueryModel.class, new Deserializer());
            }

            public Object m13613a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchOutgoingMoreTransactionsQueryParser.m13962a(jsonParser);
                Object fetchOutgoingMoreTransactionsQueryModel = new FetchOutgoingMoreTransactionsQueryModel();
                ((BaseModel) fetchOutgoingMoreTransactionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchOutgoingMoreTransactionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchOutgoingMoreTransactionsQueryModel).a();
                }
                return fetchOutgoingMoreTransactionsQueryModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchOutgoingMoreTransactionsQueryModel> {
            public final void m13614a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchOutgoingMoreTransactionsQueryModel fetchOutgoingMoreTransactionsQueryModel = (FetchOutgoingMoreTransactionsQueryModel) obj;
                if (fetchOutgoingMoreTransactionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchOutgoingMoreTransactionsQueryModel.m13615a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchOutgoingMoreTransactionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchOutgoingMoreTransactionsQueryModel.w_();
                int u_ = fetchOutgoingMoreTransactionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("outgoing_messenger_payments");
                    PaymentTransactionsParser.m14013a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchOutgoingMoreTransactionsQueryModel.class, new Serializer());
            }
        }

        public FetchOutgoingMoreTransactionsQueryModel() {
            super(1);
        }

        @Nullable
        public final PaymentTransactionsModel m13617a() {
            this.f13288d = (PaymentTransactionsModel) super.a(this.f13288d, 0, PaymentTransactionsModel.class);
            return this.f13288d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13616a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13617a() != null) {
                PaymentTransactionsModel paymentTransactionsModel = (PaymentTransactionsModel) graphQLModelMutatingVisitor.b(m13617a());
                if (m13617a() != paymentTransactionsModel) {
                    graphQLVisitableModel = (FetchOutgoingMoreTransactionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13288d = paymentTransactionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13615a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13617a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1007098655)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchOutgoingPaymentRequestsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private OutgoingPeerToPeerPaymentRequestsModel f13290d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchOutgoingPaymentRequestsQueryModel.class, new Deserializer());
            }

            public Object m13618a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchOutgoingPaymentRequestsQueryParser.m13965a(jsonParser);
                Object fetchOutgoingPaymentRequestsQueryModel = new FetchOutgoingPaymentRequestsQueryModel();
                ((BaseModel) fetchOutgoingPaymentRequestsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchOutgoingPaymentRequestsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchOutgoingPaymentRequestsQueryModel).a();
                }
                return fetchOutgoingPaymentRequestsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1821416147)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: helpText */
        public final class OutgoingPeerToPeerPaymentRequestsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PaymentRequestModel> f13289d;

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OutgoingPeerToPeerPaymentRequestsModel.class, new Deserializer());
                }

                public Object m13619a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OutgoingPeerToPeerPaymentRequestsParser.m13963a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object outgoingPeerToPeerPaymentRequestsModel = new OutgoingPeerToPeerPaymentRequestsModel();
                    ((BaseModel) outgoingPeerToPeerPaymentRequestsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (outgoingPeerToPeerPaymentRequestsModel instanceof Postprocessable) {
                        return ((Postprocessable) outgoingPeerToPeerPaymentRequestsModel).a();
                    }
                    return outgoingPeerToPeerPaymentRequestsModel;
                }
            }

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<OutgoingPeerToPeerPaymentRequestsModel> {
                public final void m13620a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OutgoingPeerToPeerPaymentRequestsModel outgoingPeerToPeerPaymentRequestsModel = (OutgoingPeerToPeerPaymentRequestsModel) obj;
                    if (outgoingPeerToPeerPaymentRequestsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(outgoingPeerToPeerPaymentRequestsModel.m13621a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        outgoingPeerToPeerPaymentRequestsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OutgoingPeerToPeerPaymentRequestsParser.m13964a(outgoingPeerToPeerPaymentRequestsModel.w_(), outgoingPeerToPeerPaymentRequestsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(OutgoingPeerToPeerPaymentRequestsModel.class, new Serializer());
                }
            }

            public OutgoingPeerToPeerPaymentRequestsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<PaymentRequestModel> m13623a() {
                this.f13289d = super.a(this.f13289d, 0, PaymentRequestModel.class);
                return (ImmutableList) this.f13289d;
            }

            public final int jK_() {
                return 1778107773;
            }

            public final GraphQLVisitableModel m13622a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13623a() != null) {
                    Builder a = ModelHelper.a(m13623a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (OutgoingPeerToPeerPaymentRequestsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13289d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13621a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13623a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchOutgoingPaymentRequestsQueryModel> {
            public final void m13624a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchOutgoingPaymentRequestsQueryModel fetchOutgoingPaymentRequestsQueryModel = (FetchOutgoingPaymentRequestsQueryModel) obj;
                if (fetchOutgoingPaymentRequestsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchOutgoingPaymentRequestsQueryModel.m13625a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchOutgoingPaymentRequestsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchOutgoingPaymentRequestsQueryModel.w_();
                int u_ = fetchOutgoingPaymentRequestsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("outgoing_peer_to_peer_payment_requests");
                    OutgoingPeerToPeerPaymentRequestsParser.m13964a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchOutgoingPaymentRequestsQueryModel.class, new Serializer());
            }
        }

        public FetchOutgoingPaymentRequestsQueryModel() {
            super(1);
        }

        @Nullable
        public final OutgoingPeerToPeerPaymentRequestsModel m13627a() {
            this.f13290d = (OutgoingPeerToPeerPaymentRequestsModel) super.a(this.f13290d, 0, OutgoingPeerToPeerPaymentRequestsModel.class);
            return this.f13290d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13626a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13627a() != null) {
                OutgoingPeerToPeerPaymentRequestsModel outgoingPeerToPeerPaymentRequestsModel = (OutgoingPeerToPeerPaymentRequestsModel) graphQLModelMutatingVisitor.b(m13627a());
                if (m13627a() != outgoingPeerToPeerPaymentRequestsModel) {
                    graphQLVisitableModel = (FetchOutgoingPaymentRequestsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13290d = outgoingPeerToPeerPaymentRequestsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13625a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13627a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -879452820)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchOutgoingTransactionListQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PaymentTransactionsModel f13291d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchOutgoingTransactionListQueryModel.class, new Deserializer());
            }

            public Object m13628a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchOutgoingTransactionListQueryParser.m13966a(jsonParser);
                Object fetchOutgoingTransactionListQueryModel = new FetchOutgoingTransactionListQueryModel();
                ((BaseModel) fetchOutgoingTransactionListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchOutgoingTransactionListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchOutgoingTransactionListQueryModel).a();
                }
                return fetchOutgoingTransactionListQueryModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchOutgoingTransactionListQueryModel> {
            public final void m13629a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchOutgoingTransactionListQueryModel fetchOutgoingTransactionListQueryModel = (FetchOutgoingTransactionListQueryModel) obj;
                if (fetchOutgoingTransactionListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchOutgoingTransactionListQueryModel.m13630a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchOutgoingTransactionListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchOutgoingTransactionListQueryModel.w_();
                int u_ = fetchOutgoingTransactionListQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("outgoing_messenger_payments");
                    PaymentTransactionsParser.m14013a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchOutgoingTransactionListQueryModel.class, new Serializer());
            }
        }

        public FetchOutgoingTransactionListQueryModel() {
            super(1);
        }

        @Nullable
        public final PaymentTransactionsModel m13632a() {
            this.f13291d = (PaymentTransactionsModel) super.a(this.f13291d, 0, PaymentTransactionsModel.class);
            return this.f13291d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13631a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13632a() != null) {
                PaymentTransactionsModel paymentTransactionsModel = (PaymentTransactionsModel) graphQLModelMutatingVisitor.b(m13632a());
                if (m13632a() != paymentTransactionsModel) {
                    graphQLVisitableModel = (FetchOutgoingTransactionListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13291d = paymentTransactionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13630a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13632a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1352123561)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchPaymentAccountEnabledStatusQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PaymentAccountEnabledStatusModel f13292d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPaymentAccountEnabledStatusQueryModel.class, new Deserializer());
            }

            public Object m13633a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPaymentAccountEnabledStatusQueryParser.m13967a(jsonParser);
                Object fetchPaymentAccountEnabledStatusQueryModel = new FetchPaymentAccountEnabledStatusQueryModel();
                ((BaseModel) fetchPaymentAccountEnabledStatusQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPaymentAccountEnabledStatusQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPaymentAccountEnabledStatusQueryModel).a();
                }
                return fetchPaymentAccountEnabledStatusQueryModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchPaymentAccountEnabledStatusQueryModel> {
            public final void m13634a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPaymentAccountEnabledStatusQueryModel fetchPaymentAccountEnabledStatusQueryModel = (FetchPaymentAccountEnabledStatusQueryModel) obj;
                if (fetchPaymentAccountEnabledStatusQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPaymentAccountEnabledStatusQueryModel.m13635a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPaymentAccountEnabledStatusQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPaymentAccountEnabledStatusQueryModel.w_();
                int u_ = fetchPaymentAccountEnabledStatusQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("peer_to_peer_payments");
                    PaymentAccountEnabledStatusParser.m13979a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPaymentAccountEnabledStatusQueryModel.class, new Serializer());
            }
        }

        public FetchPaymentAccountEnabledStatusQueryModel() {
            super(1);
        }

        @Nullable
        public final PaymentAccountEnabledStatusModel m13637a() {
            this.f13292d = (PaymentAccountEnabledStatusModel) super.a(this.f13292d, 0, PaymentAccountEnabledStatusModel.class);
            return this.f13292d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13636a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13637a() != null) {
                PaymentAccountEnabledStatusModel paymentAccountEnabledStatusModel = (PaymentAccountEnabledStatusModel) graphQLModelMutatingVisitor.b(m13637a());
                if (m13637a() != paymentAccountEnabledStatusModel) {
                    graphQLVisitableModel = (FetchPaymentAccountEnabledStatusQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13292d = paymentAccountEnabledStatusModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13635a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13637a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2008215422)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchPaymentPinStatusQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PeerToPeerPaymentsModel f13294d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPaymentPinStatusQueryModel.class, new Deserializer());
            }

            public Object m13638a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPaymentPinStatusQueryParser.m13970a(jsonParser);
                Object fetchPaymentPinStatusQueryModel = new FetchPaymentPinStatusQueryModel();
                ((BaseModel) fetchPaymentPinStatusQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPaymentPinStatusQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPaymentPinStatusQueryModel).a();
                }
                return fetchPaymentPinStatusQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1441338555)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: helpText */
        public final class PeerToPeerPaymentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PaymentPinStatusModel f13293d;

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PeerToPeerPaymentsModel.class, new Deserializer());
                }

                public Object m13639a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PeerToPeerPaymentsParser.m13968a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object peerToPeerPaymentsModel = new PeerToPeerPaymentsModel();
                    ((BaseModel) peerToPeerPaymentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (peerToPeerPaymentsModel instanceof Postprocessable) {
                        return ((Postprocessable) peerToPeerPaymentsModel).a();
                    }
                    return peerToPeerPaymentsModel;
                }
            }

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<PeerToPeerPaymentsModel> {
                public final void m13640a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PeerToPeerPaymentsModel peerToPeerPaymentsModel = (PeerToPeerPaymentsModel) obj;
                    if (peerToPeerPaymentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(peerToPeerPaymentsModel.m13641a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        peerToPeerPaymentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PeerToPeerPaymentsParser.m13969a(peerToPeerPaymentsModel.w_(), peerToPeerPaymentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PeerToPeerPaymentsModel.class, new Serializer());
                }
            }

            public PeerToPeerPaymentsModel() {
                super(1);
            }

            @Nullable
            public final PaymentPinStatusModel m13643a() {
                this.f13293d = (PaymentPinStatusModel) super.a(this.f13293d, 0, PaymentPinStatusModel.class);
                return this.f13293d;
            }

            public final int jK_() {
                return 1753705926;
            }

            public final GraphQLVisitableModel m13642a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13643a() != null) {
                    PaymentPinStatusModel paymentPinStatusModel = (PaymentPinStatusModel) graphQLModelMutatingVisitor.b(m13643a());
                    if (m13643a() != paymentPinStatusModel) {
                        graphQLVisitableModel = (PeerToPeerPaymentsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13293d = paymentPinStatusModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13641a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13643a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchPaymentPinStatusQueryModel> {
            public final void m13644a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPaymentPinStatusQueryModel fetchPaymentPinStatusQueryModel = (FetchPaymentPinStatusQueryModel) obj;
                if (fetchPaymentPinStatusQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPaymentPinStatusQueryModel.m13645a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPaymentPinStatusQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPaymentPinStatusQueryModel.w_();
                int u_ = fetchPaymentPinStatusQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("peer_to_peer_payments");
                    PeerToPeerPaymentsParser.m13969a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPaymentPinStatusQueryModel.class, new Serializer());
            }
        }

        public FetchPaymentPinStatusQueryModel() {
            super(1);
        }

        @Nullable
        public final PeerToPeerPaymentsModel m13647a() {
            this.f13294d = (PeerToPeerPaymentsModel) super.a(this.f13294d, 0, PeerToPeerPaymentsModel.class);
            return this.f13294d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13646a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13647a() != null) {
                PeerToPeerPaymentsModel peerToPeerPaymentsModel = (PeerToPeerPaymentsModel) graphQLModelMutatingVisitor.b(m13647a());
                if (m13647a() != peerToPeerPaymentsModel) {
                    graphQLVisitableModel = (FetchPaymentPinStatusQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13294d = peerToPeerPaymentsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13645a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13647a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -139751986)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchPaymentPlatformContextsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<PaymentPlatformContextModel> f13295d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPaymentPlatformContextsQueryModel.class, new Deserializer());
            }

            public Object m13648a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchPaymentPlatformContextsQueryParser.m13971a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchPaymentPlatformContextsQueryModel = new FetchPaymentPlatformContextsQueryModel();
                ((BaseModel) fetchPaymentPlatformContextsQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchPaymentPlatformContextsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPaymentPlatformContextsQueryModel).a();
                }
                return fetchPaymentPlatformContextsQueryModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchPaymentPlatformContextsQueryModel> {
            public final void m13649a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPaymentPlatformContextsQueryModel fetchPaymentPlatformContextsQueryModel = (FetchPaymentPlatformContextsQueryModel) obj;
                if (fetchPaymentPlatformContextsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPaymentPlatformContextsQueryModel.m13650a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPaymentPlatformContextsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPaymentPlatformContextsQueryModel.w_();
                int u_ = fetchPaymentPlatformContextsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("peer_to_peer_platform_contexts");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        PaymentPlatformContextParser.m13995b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPaymentPlatformContextsQueryModel.class, new Serializer());
            }
        }

        public FetchPaymentPlatformContextsQueryModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<PaymentPlatformContextModel> m13652a() {
            this.f13295d = super.a(this.f13295d, 0, PaymentPlatformContextModel.class);
            return (ImmutableList) this.f13295d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13651a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13652a() != null) {
                Builder a = ModelHelper.a(m13652a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FetchPaymentPlatformContextsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13295d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13650a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13652a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -350289177)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class FetchShippingAddressQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private MailingAddressesModel f13297d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchShippingAddressQueryModel.class, new Deserializer());
            }

            public Object m13653a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchShippingAddressQueryParser.m13974a(jsonParser);
                Object fetchShippingAddressQueryModel = new FetchShippingAddressQueryModel();
                ((BaseModel) fetchShippingAddressQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchShippingAddressQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchShippingAddressQueryModel).a();
                }
                return fetchShippingAddressQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1758417408)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: helpText */
        public final class MailingAddressesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MailingAddressInfoModel> f13296d;

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MailingAddressesModel.class, new Deserializer());
                }

                public Object m13654a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MailingAddressesParser.m13972a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mailingAddressesModel = new MailingAddressesModel();
                    ((BaseModel) mailingAddressesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mailingAddressesModel instanceof Postprocessable) {
                        return ((Postprocessable) mailingAddressesModel).a();
                    }
                    return mailingAddressesModel;
                }
            }

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<MailingAddressesModel> {
                public final void m13655a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MailingAddressesModel mailingAddressesModel = (MailingAddressesModel) obj;
                    if (mailingAddressesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mailingAddressesModel.m13656a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mailingAddressesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MailingAddressesParser.m13973a(mailingAddressesModel.w_(), mailingAddressesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MailingAddressesModel.class, new Serializer());
                }
            }

            public MailingAddressesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<MailingAddressInfoModel> m13658a() {
                this.f13296d = super.a(this.f13296d, 0, MailingAddressInfoModel.class);
                return (ImmutableList) this.f13296d;
            }

            public final int jK_() {
                return 1358017397;
            }

            public final GraphQLVisitableModel m13657a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13658a() != null) {
                    Builder a = ModelHelper.a(m13658a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MailingAddressesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13296d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13656a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13658a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<FetchShippingAddressQueryModel> {
            public final void m13659a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchShippingAddressQueryModel fetchShippingAddressQueryModel = (FetchShippingAddressQueryModel) obj;
                if (fetchShippingAddressQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchShippingAddressQueryModel.m13660a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchShippingAddressQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchShippingAddressQueryModel.w_();
                int u_ = fetchShippingAddressQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("mailing_addresses");
                    MailingAddressesParser.m13973a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchShippingAddressQueryModel.class, new Serializer());
            }
        }

        public FetchShippingAddressQueryModel() {
            super(1);
        }

        public final void m13663a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13664a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final MailingAddressesModel m13662a() {
            this.f13297d = (MailingAddressesModel) super.a(this.f13297d, 0, MailingAddressesModel.class);
            return this.f13297d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m13661a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13662a() != null) {
                MailingAddressesModel mailingAddressesModel = (MailingAddressesModel) graphQLModelMutatingVisitor.b(m13662a());
                if (m13662a() != mailingAddressesModel) {
                    graphQLVisitableModel = (FetchShippingAddressQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13297d = mailingAddressesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13660a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13662a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1388330641)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class MailingAddressInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private StreetAddressInfoModel f13298d;
        @Nullable
        private String f13299e;
        @Nullable
        private String f13300f;
        private boolean f13301g;
        private boolean f13302h;
        @Nullable
        private String f13303i;
        @Nullable
        private String f13304j;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MailingAddressInfoModel.class, new Deserializer());
            }

            public Object m13665a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MailingAddressInfoParser.m13975a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object mailingAddressInfoModel = new MailingAddressInfoModel();
                ((BaseModel) mailingAddressInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (mailingAddressInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) mailingAddressInfoModel).a();
                }
                return mailingAddressInfoModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<MailingAddressInfoModel> {
            public final void m13666a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MailingAddressInfoModel mailingAddressInfoModel = (MailingAddressInfoModel) obj;
                if (mailingAddressInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mailingAddressInfoModel.m13668a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mailingAddressInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MailingAddressInfoParser.m13976b(mailingAddressInfoModel.w_(), mailingAddressInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MailingAddressInfoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ StreetAddressInfoModel m13672b() {
            return m13667j();
        }

        public MailingAddressInfoModel() {
            super(7);
        }

        @Nullable
        private StreetAddressInfoModel m13667j() {
            this.f13298d = (StreetAddressInfoModel) super.a(this.f13298d, 0, StreetAddressInfoModel.class);
            return this.f13298d;
        }

        @Nullable
        public final String m13673c() {
            this.f13299e = super.a(this.f13299e, 1);
            return this.f13299e;
        }

        @Nullable
        public final String m13674d() {
            this.f13300f = super.a(this.f13300f, 2);
            return this.f13300f;
        }

        public final boolean lo_() {
            a(0, 3);
            return this.f13301g;
        }

        @Nullable
        public final String m13675g() {
            this.f13303i = super.a(this.f13303i, 5);
            return this.f13303i;
        }

        @Nullable
        public final String lp_() {
            this.f13304j = super.a(this.f13304j, 6);
            return this.f13304j;
        }

        @Nullable
        public final String m13670a() {
            return m13674d();
        }

        public final int jK_() {
            return 430158537;
        }

        public final GraphQLVisitableModel m13669a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13667j() != null) {
                StreetAddressInfoModel streetAddressInfoModel = (StreetAddressInfoModel) graphQLModelMutatingVisitor.b(m13667j());
                if (m13667j() != streetAddressInfoModel) {
                    graphQLVisitableModel = (MailingAddressInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13298d = streetAddressInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13668a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13667j());
            int b = flatBufferBuilder.b(m13673c());
            int b2 = flatBufferBuilder.b(m13674d());
            int b3 = flatBufferBuilder.b(m13675g());
            int b4 = flatBufferBuilder.b(lp_());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.a(3, this.f13301g);
            flatBufferBuilder.a(4, this.f13302h);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, b4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13671a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13301g = mutableFlatBuffer.a(i, 3);
            this.f13302h = mutableFlatBuffer.a(i, 4);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 273304230)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PageInfoModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private String f13305d;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
            }

            public Object m13676a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageInfoParser.m13977a(jsonParser);
                Object pageInfoModel = new PageInfoModel();
                ((BaseModel) pageInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) pageInfoModel).a();
                }
                return pageInfoModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PageInfoModel> {
            public final void m13677a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageInfoModel pageInfoModel = (PageInfoModel) obj;
                if (pageInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageInfoModel.m13678a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageInfoModel.w_();
                int u_ = pageInfoModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageInfoModel.class, new Serializer());
            }
        }

        public PageInfoModel() {
            super(1);
        }

        public final void m13681a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13682a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final String m13680a() {
            this.f13305d = super.a(this.f13305d, 0);
            return this.f13305d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m13679a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m13678a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13680a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -56491806)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PaymentAccountEnabledStatusModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f13307d;

        /* compiled from: helpText */
        public final class Builder {
            public boolean f13306a;
        }

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PaymentAccountEnabledStatusModel.class, new Deserializer());
            }

            public Object m13683a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PaymentAccountEnabledStatusParser.m13978a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object paymentAccountEnabledStatusModel = new PaymentAccountEnabledStatusModel();
                ((BaseModel) paymentAccountEnabledStatusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (paymentAccountEnabledStatusModel instanceof Postprocessable) {
                    return ((Postprocessable) paymentAccountEnabledStatusModel).a();
                }
                return paymentAccountEnabledStatusModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PaymentAccountEnabledStatusModel> {
            public final void m13684a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PaymentAccountEnabledStatusModel paymentAccountEnabledStatusModel = (PaymentAccountEnabledStatusModel) obj;
                if (paymentAccountEnabledStatusModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(paymentAccountEnabledStatusModel.m13685a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    paymentAccountEnabledStatusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PaymentAccountEnabledStatusParser.m13979a(paymentAccountEnabledStatusModel.w_(), paymentAccountEnabledStatusModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PaymentAccountEnabledStatusModel.class, new Serializer());
            }
        }

        public PaymentAccountEnabledStatusModel() {
            super(1);
        }

        public PaymentAccountEnabledStatusModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final boolean m13688a() {
            a(0, 0);
            return this.f13307d;
        }

        public final int jK_() {
            return 1753705926;
        }

        public final GraphQLVisitableModel m13686a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m13685a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f13307d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13687a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13307d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1377760999)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PaymentCurrencyAmountModel extends BaseModel implements GraphQLVisitableModel {
        private int f13308d;
        @Nullable
        private String f13309e;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PaymentCurrencyAmountModel.class, new Deserializer());
            }

            public Object m13689a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PaymentCurrencyAmountParser.m13980a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object paymentCurrencyAmountModel = new PaymentCurrencyAmountModel();
                ((BaseModel) paymentCurrencyAmountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (paymentCurrencyAmountModel instanceof Postprocessable) {
                    return ((Postprocessable) paymentCurrencyAmountModel).a();
                }
                return paymentCurrencyAmountModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PaymentCurrencyAmountModel> {
            public final void m13690a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PaymentCurrencyAmountModel paymentCurrencyAmountModel = (PaymentCurrencyAmountModel) obj;
                if (paymentCurrencyAmountModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(paymentCurrencyAmountModel.m13692a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    paymentCurrencyAmountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PaymentCurrencyAmountParser.m13981a(paymentCurrencyAmountModel.w_(), paymentCurrencyAmountModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PaymentCurrencyAmountModel.class, new Serializer());
            }
        }

        public PaymentCurrencyAmountModel() {
            super(2);
        }

        public final int m13691a() {
            a(0, 0);
            return this.f13308d;
        }

        @Nullable
        public final String m13695b() {
            this.f13309e = super.a(this.f13309e, 1);
            return this.f13309e;
        }

        public final int jK_() {
            return -1840781335;
        }

        public final GraphQLVisitableModel m13693a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m13692a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13695b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f13308d, 0);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13694a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13308d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 4676149)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PaymentCurrencyQuantityModel extends BaseModel implements GraphQLVisitableModel {
        private int f13313d;
        @Nullable
        private String f13314e;
        private int f13315f;

        /* compiled from: helpText */
        public final class Builder {
            public int f13310a;
            @Nullable
            public String f13311b;
            public int f13312c;

            public final Builder m13696a(int i) {
                this.f13310a = i;
                return this;
            }

            public final Builder m13697a(@Nullable String str) {
                this.f13311b = str;
                return this;
            }

            public final Builder m13699b(int i) {
                this.f13312c = i;
                return this;
            }

            public final PaymentCurrencyQuantityModel m13698a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f13311b);
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f13310a, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f13312c, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PaymentCurrencyQuantityModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PaymentCurrencyQuantityModel.class, new Deserializer());
            }

            public Object m13700a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PaymentCurrencyQuantityParser.m13982a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object paymentCurrencyQuantityModel = new PaymentCurrencyQuantityModel();
                ((BaseModel) paymentCurrencyQuantityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (paymentCurrencyQuantityModel instanceof Postprocessable) {
                    return ((Postprocessable) paymentCurrencyQuantityModel).a();
                }
                return paymentCurrencyQuantityModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PaymentCurrencyQuantityModel> {
            public final void m13701a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PaymentCurrencyQuantityModel paymentCurrencyQuantityModel = (PaymentCurrencyQuantityModel) obj;
                if (paymentCurrencyQuantityModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(paymentCurrencyQuantityModel.m13704a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    paymentCurrencyQuantityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PaymentCurrencyQuantityParser.m13983a(paymentCurrencyQuantityModel.w_(), paymentCurrencyQuantityModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PaymentCurrencyQuantityModel.class, new Serializer());
            }
        }

        public PaymentCurrencyQuantityModel() {
            super(3);
        }

        public PaymentCurrencyQuantityModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m13703a() {
            a(0, 0);
            return this.f13313d;
        }

        @Nullable
        public final String m13707b() {
            this.f13314e = super.a(this.f13314e, 1);
            return this.f13314e;
        }

        public final int m13708c() {
            a(0, 2);
            return this.f13315f;
        }

        public static PaymentCurrencyQuantityModel m13702a(PaymentCurrencyQuantityModel paymentCurrencyQuantityModel) {
            if (paymentCurrencyQuantityModel == null) {
                return null;
            }
            if (paymentCurrencyQuantityModel instanceof PaymentCurrencyQuantityModel) {
                return paymentCurrencyQuantityModel;
            }
            Builder builder = new Builder();
            builder.f13310a = paymentCurrencyQuantityModel.m13703a();
            builder.f13311b = paymentCurrencyQuantityModel.m13707b();
            builder.f13312c = paymentCurrencyQuantityModel.m13708c();
            return builder.m13698a();
        }

        public final int jK_() {
            return 753818588;
        }

        public final GraphQLVisitableModel m13705a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m13704a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13707b());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f13313d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f13315f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13706a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13313d = mutableFlatBuffer.a(i, 0, 0);
            this.f13315f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -763627979)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PaymentPinStatusModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f13320d;
        private boolean f13321e;
        @Nullable
        private List<ProtectedThreadProfilesModel> f13322f;
        @Nullable
        private List<UnprotectedThreadProfilesModel> f13323g;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PaymentPinStatusModel.class, new Deserializer());
            }

            public Object m13709a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PaymentPinStatusParser.m13990a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object paymentPinStatusModel = new PaymentPinStatusModel();
                ((BaseModel) paymentPinStatusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (paymentPinStatusModel instanceof Postprocessable) {
                    return ((Postprocessable) paymentPinStatusModel).a();
                }
                return paymentPinStatusModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: helpText */
        public final class ProtectedThreadProfilesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f13316d;
            @Nullable
            private String f13317e;

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProtectedThreadProfilesModel.class, new Deserializer());
                }

                public Object m13710a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProtectedThreadProfilesParser.m13986b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object protectedThreadProfilesModel = new ProtectedThreadProfilesModel();
                    ((BaseModel) protectedThreadProfilesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (protectedThreadProfilesModel instanceof Postprocessable) {
                        return ((Postprocessable) protectedThreadProfilesModel).a();
                    }
                    return protectedThreadProfilesModel;
                }
            }

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<ProtectedThreadProfilesModel> {
                public final void m13711a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProtectedThreadProfilesModel protectedThreadProfilesModel = (ProtectedThreadProfilesModel) obj;
                    if (protectedThreadProfilesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(protectedThreadProfilesModel.m13713a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        protectedThreadProfilesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProtectedThreadProfilesParser.m13985a(protectedThreadProfilesModel.w_(), protectedThreadProfilesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProtectedThreadProfilesModel.class, new Serializer());
                }
            }

            public ProtectedThreadProfilesModel() {
                super(2);
            }

            public final void m13716a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m13717a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m13712j() {
                if (this.b != null && this.f13316d == null) {
                    this.f13316d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f13316d;
            }

            @Nullable
            public final String m13718b() {
                this.f13317e = super.a(this.f13317e, 1);
                return this.f13317e;
            }

            @Nullable
            public final String m13715a() {
                return m13718b();
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m13714a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13713a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13712j());
                int b = flatBufferBuilder.b(m13718b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PaymentPinStatusModel> {
            public final void m13719a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PaymentPinStatusModel paymentPinStatusModel = (PaymentPinStatusModel) obj;
                if (paymentPinStatusModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(paymentPinStatusModel.m13730a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    paymentPinStatusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PaymentPinStatusParser.m13991a(paymentPinStatusModel.w_(), paymentPinStatusModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PaymentPinStatusModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: helpText */
        public final class UnprotectedThreadProfilesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f13318d;
            @Nullable
            private String f13319e;

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UnprotectedThreadProfilesModel.class, new Deserializer());
                }

                public Object m13720a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UnprotectedThreadProfilesParser.m13989b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object unprotectedThreadProfilesModel = new UnprotectedThreadProfilesModel();
                    ((BaseModel) unprotectedThreadProfilesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (unprotectedThreadProfilesModel instanceof Postprocessable) {
                        return ((Postprocessable) unprotectedThreadProfilesModel).a();
                    }
                    return unprotectedThreadProfilesModel;
                }
            }

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<UnprotectedThreadProfilesModel> {
                public final void m13721a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UnprotectedThreadProfilesModel unprotectedThreadProfilesModel = (UnprotectedThreadProfilesModel) obj;
                    if (unprotectedThreadProfilesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(unprotectedThreadProfilesModel.m13723a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        unprotectedThreadProfilesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UnprotectedThreadProfilesParser.m13988a(unprotectedThreadProfilesModel.w_(), unprotectedThreadProfilesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UnprotectedThreadProfilesModel.class, new Serializer());
                }
            }

            public UnprotectedThreadProfilesModel() {
                super(2);
            }

            public final void m13726a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m13727a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m13722j() {
                if (this.b != null && this.f13318d == null) {
                    this.f13318d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f13318d;
            }

            @Nullable
            public final String m13728b() {
                this.f13319e = super.a(this.f13319e, 1);
                return this.f13319e;
            }

            @Nullable
            public final String m13725a() {
                return m13728b();
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m13724a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13723a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13722j());
                int b = flatBufferBuilder.b(m13728b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public PaymentPinStatusModel() {
            super(4);
        }

        @Nullable
        private String m13729j() {
            this.f13320d = super.a(this.f13320d, 0);
            return this.f13320d;
        }

        @Nonnull
        public final ImmutableList<ProtectedThreadProfilesModel> m13734b() {
            this.f13322f = super.a(this.f13322f, 2, ProtectedThreadProfilesModel.class);
            return (ImmutableList) this.f13322f;
        }

        @Nonnull
        public final ImmutableList<UnprotectedThreadProfilesModel> m13735c() {
            this.f13323g = super.a(this.f13323g, 3, UnprotectedThreadProfilesModel.class);
            return (ImmutableList) this.f13323g;
        }

        @Nullable
        public final String m13732a() {
            return m13729j();
        }

        public final int jK_() {
            return -689879634;
        }

        public final GraphQLVisitableModel m13731a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13734b() != null) {
                a = ModelHelper.a(m13734b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PaymentPinStatusModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13322f = a.b();
                }
            }
            if (m13735c() != null) {
                a = ModelHelper.a(m13735c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PaymentPinStatusModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13323g = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13730a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13729j());
            int a = ModelHelper.a(flatBufferBuilder, m13734b());
            int a2 = ModelHelper.a(flatBufferBuilder, m13735c());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f13321e);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13733a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13321e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2016794982)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PaymentPlatformContextModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private PaymentUserModel f13325d;
        private long f13326e;
        @Nullable
        private String f13327f;
        private long f13328g;
        @Nullable
        private PaymentPlatformItemModel f13329h;
        @Nullable
        private PeerToPeerPlatformProductItemModel f13330i;
        @Nullable
        private MailingAddressInfoModel f13331j;
        @Nullable
        private PaymentShippingOptionModel f13332k;
        @Nullable
        private PaymentUserModel f13333l;
        @Nullable
        private List<PaymentShippingOptionModel> f13334m;
        private boolean f13335n;
        private boolean f13336o;
        private boolean f13337p;
        private boolean f13338q;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PaymentPlatformContextModel.class, new Deserializer());
            }

            public Object m13736a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PaymentPlatformContextParser.m13994a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object paymentPlatformContextModel = new PaymentPlatformContextModel();
                ((BaseModel) paymentPlatformContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (paymentPlatformContextModel instanceof Postprocessable) {
                    return ((Postprocessable) paymentPlatformContextModel).a();
                }
                return paymentPlatformContextModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2053684759)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: helpText */
        public final class PeerToPeerPlatformProductItemModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PaymentCurrencyAmountModel f13324d;

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PeerToPeerPlatformProductItemModel.class, new Deserializer());
                }

                public Object m13737a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PeerToPeerPlatformProductItemParser.m13992a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object peerToPeerPlatformProductItemModel = new PeerToPeerPlatformProductItemModel();
                    ((BaseModel) peerToPeerPlatformProductItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (peerToPeerPlatformProductItemModel instanceof Postprocessable) {
                        return ((Postprocessable) peerToPeerPlatformProductItemModel).a();
                    }
                    return peerToPeerPlatformProductItemModel;
                }
            }

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<PeerToPeerPlatformProductItemModel> {
                public final void m13738a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PeerToPeerPlatformProductItemModel peerToPeerPlatformProductItemModel = (PeerToPeerPlatformProductItemModel) obj;
                    if (peerToPeerPlatformProductItemModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(peerToPeerPlatformProductItemModel.m13740a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        peerToPeerPlatformProductItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PeerToPeerPlatformProductItemParser.m13993a(peerToPeerPlatformProductItemModel.w_(), peerToPeerPlatformProductItemModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PeerToPeerPlatformProductItemModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PaymentCurrencyAmountModel m13742a() {
                return m13739j();
            }

            public PeerToPeerPlatformProductItemModel() {
                super(1);
            }

            @Nullable
            private PaymentCurrencyAmountModel m13739j() {
                this.f13324d = (PaymentCurrencyAmountModel) super.a(this.f13324d, 0, PaymentCurrencyAmountModel.class);
                return this.f13324d;
            }

            public final int jK_() {
                return -1649148656;
            }

            public final GraphQLVisitableModel m13741a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13739j() != null) {
                    PaymentCurrencyAmountModel paymentCurrencyAmountModel = (PaymentCurrencyAmountModel) graphQLModelMutatingVisitor.b(m13739j());
                    if (m13739j() != paymentCurrencyAmountModel) {
                        graphQLVisitableModel = (PeerToPeerPlatformProductItemModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13324d = paymentCurrencyAmountModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13740a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13739j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PaymentPlatformContextModel> {
            public final void m13743a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) obj;
                if (paymentPlatformContextModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(paymentPlatformContextModel.m13750a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    paymentPlatformContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PaymentPlatformContextParser.m13995b(paymentPlatformContextModel.w_(), paymentPlatformContextModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PaymentPlatformContextModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PaymentUserModel m13754b() {
            return m13744o();
        }

        @Nullable
        public final /* synthetic */ PaymentPlatformItemModel m13757g() {
            return m13745p();
        }

        @Nullable
        public final /* synthetic */ PaymentShippingOptionModel m13758j() {
            return m13748s();
        }

        @Nullable
        public final /* synthetic */ PaymentUserModel m13759k() {
            return m13749t();
        }

        @Nullable
        public final /* synthetic */ MailingAddressInfoModel lr_() {
            return m13747r();
        }

        @Nullable
        public final /* synthetic */ PeerToPeerPlatformProductItemModel ls_() {
            return m13746q();
        }

        public PaymentPlatformContextModel() {
            super(14);
        }

        @Nullable
        private PaymentUserModel m13744o() {
            this.f13325d = (PaymentUserModel) super.a(this.f13325d, 0, PaymentUserModel.class);
            return this.f13325d;
        }

        public final long m13755c() {
            a(0, 1);
            return this.f13326e;
        }

        @Nullable
        public final String m13756d() {
            this.f13327f = super.a(this.f13327f, 2);
            return this.f13327f;
        }

        public final long lq_() {
            a(0, 3);
            return this.f13328g;
        }

        @Nullable
        private PaymentPlatformItemModel m13745p() {
            this.f13329h = (PaymentPlatformItemModel) super.a(this.f13329h, 4, PaymentPlatformItemModel.class);
            return this.f13329h;
        }

        @Nullable
        private PeerToPeerPlatformProductItemModel m13746q() {
            this.f13330i = (PeerToPeerPlatformProductItemModel) super.a(this.f13330i, 5, PeerToPeerPlatformProductItemModel.class);
            return this.f13330i;
        }

        @Nullable
        private MailingAddressInfoModel m13747r() {
            this.f13331j = (MailingAddressInfoModel) super.a(this.f13331j, 6, MailingAddressInfoModel.class);
            return this.f13331j;
        }

        @Nullable
        private PaymentShippingOptionModel m13748s() {
            this.f13332k = (PaymentShippingOptionModel) super.a(this.f13332k, 7, PaymentShippingOptionModel.class);
            return this.f13332k;
        }

        @Nullable
        private PaymentUserModel m13749t() {
            this.f13333l = (PaymentUserModel) super.a(this.f13333l, 8, PaymentUserModel.class);
            return this.f13333l;
        }

        @Nonnull
        public final ImmutableList<PaymentShippingOptionModel> m13760l() {
            this.f13334m = super.a(this.f13334m, 9, PaymentShippingOptionModel.class);
            return (ImmutableList) this.f13334m;
        }

        public final boolean m13761m() {
            a(1, 2);
            return this.f13335n;
        }

        public final boolean m13762n() {
            a(1, 5);
            return this.f13338q;
        }

        @Nullable
        public final String m13752a() {
            return m13756d();
        }

        public final int jK_() {
            return -377623267;
        }

        public final GraphQLVisitableModel m13751a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            PaymentUserModel paymentUserModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13744o() != null) {
                paymentUserModel = (PaymentUserModel) graphQLModelMutatingVisitor.b(m13744o());
                if (m13744o() != paymentUserModel) {
                    graphQLVisitableModel = (PaymentPlatformContextModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13325d = paymentUserModel;
                }
            }
            if (m13745p() != null) {
                PaymentPlatformItemModel paymentPlatformItemModel = (PaymentPlatformItemModel) graphQLModelMutatingVisitor.b(m13745p());
                if (m13745p() != paymentPlatformItemModel) {
                    graphQLVisitableModel = (PaymentPlatformContextModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13329h = paymentPlatformItemModel;
                }
            }
            if (m13746q() != null) {
                PeerToPeerPlatformProductItemModel peerToPeerPlatformProductItemModel = (PeerToPeerPlatformProductItemModel) graphQLModelMutatingVisitor.b(m13746q());
                if (m13746q() != peerToPeerPlatformProductItemModel) {
                    graphQLVisitableModel = (PaymentPlatformContextModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13330i = peerToPeerPlatformProductItemModel;
                }
            }
            if (m13747r() != null) {
                MailingAddressInfoModel mailingAddressInfoModel = (MailingAddressInfoModel) graphQLModelMutatingVisitor.b(m13747r());
                if (m13747r() != mailingAddressInfoModel) {
                    graphQLVisitableModel = (PaymentPlatformContextModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13331j = mailingAddressInfoModel;
                }
            }
            if (m13748s() != null) {
                PaymentShippingOptionModel paymentShippingOptionModel = (PaymentShippingOptionModel) graphQLModelMutatingVisitor.b(m13748s());
                if (m13748s() != paymentShippingOptionModel) {
                    graphQLVisitableModel = (PaymentPlatformContextModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13332k = paymentShippingOptionModel;
                }
            }
            if (m13749t() != null) {
                paymentUserModel = (PaymentUserModel) graphQLModelMutatingVisitor.b(m13749t());
                if (m13749t() != paymentUserModel) {
                    graphQLVisitableModel = (PaymentPlatformContextModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13333l = paymentUserModel;
                }
            }
            if (m13760l() != null) {
                Builder a = ModelHelper.a(m13760l(), graphQLModelMutatingVisitor);
                if (a != null) {
                    PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) ModelHelper.a(graphQLVisitableModel, this);
                    paymentPlatformContextModel.f13334m = a.b();
                    graphQLVisitableModel = paymentPlatformContextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13750a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13744o());
            int b = flatBufferBuilder.b(m13756d());
            int a2 = ModelHelper.a(flatBufferBuilder, m13745p());
            int a3 = ModelHelper.a(flatBufferBuilder, m13746q());
            int a4 = ModelHelper.a(flatBufferBuilder, m13747r());
            int a5 = ModelHelper.a(flatBufferBuilder, m13748s());
            int a6 = ModelHelper.a(flatBufferBuilder, m13749t());
            int a7 = ModelHelper.a(flatBufferBuilder, m13760l());
            flatBufferBuilder.c(14);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f13326e, 0);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.a(3, this.f13328g, 0);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.a(10, this.f13335n);
            flatBufferBuilder.a(11, this.f13336o);
            flatBufferBuilder.a(12, this.f13337p);
            flatBufferBuilder.a(13, this.f13338q);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13753a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13326e = mutableFlatBuffer.a(i, 1, 0);
            this.f13328g = mutableFlatBuffer.a(i, 3, 0);
            this.f13335n = mutableFlatBuffer.a(i, 10);
            this.f13336o = mutableFlatBuffer.a(i, 11);
            this.f13337p = mutableFlatBuffer.a(i, 12);
            this.f13338q = mutableFlatBuffer.a(i, 13);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1708789629)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PaymentPlatformItemModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f13352d;
        @Nullable
        private String f13353e;
        @Nullable
        private String f13354f;
        @Nullable
        private GraphQLProductAvailability f13355g;
        @Nullable
        private List<String> f13356h;
        @Nullable
        private MerchantLogoModel f13357i;
        @Nullable
        private String f13358j;
        @Nullable
        private List<PlatformImagesModel> f13359k;
        @Nullable
        private PaymentCurrencyAmountModel f13360l;
        @Nullable
        private String f13361m;
        @Nullable
        private PaymentUserModel f13362n;

        /* compiled from: helpText */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f13339a;
            @Nullable
            public String f13340b;
            @Nullable
            public String f13341c;
            @Nullable
            public GraphQLProductAvailability f13342d;
            @Nullable
            public ImmutableList<String> f13343e;
            @Nullable
            public MerchantLogoModel f13344f;
            @Nullable
            public String f13345g;
            @Nullable
            public ImmutableList<PlatformImagesModel> f13346h;
            @Nullable
            public PaymentCurrencyAmountModel f13347i;
            @Nullable
            public String f13348j;
            @Nullable
            public PaymentUserModel f13349k;

            public final PaymentPlatformItemModel m13763a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f13339a);
                int b = flatBufferBuilder.b(this.f13340b);
                int b2 = flatBufferBuilder.b(this.f13341c);
                int a2 = flatBufferBuilder.a(this.f13342d);
                int c = flatBufferBuilder.c(this.f13343e);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f13344f);
                int b3 = flatBufferBuilder.b(this.f13345g);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f13346h);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f13347i);
                int b4 = flatBufferBuilder.b(this.f13348j);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f13349k);
                flatBufferBuilder.c(11);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, c);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, b3);
                flatBufferBuilder.b(7, a4);
                flatBufferBuilder.b(8, a5);
                flatBufferBuilder.b(9, b4);
                flatBufferBuilder.b(10, a6);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PaymentPlatformItemModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PaymentPlatformItemModel.class, new Deserializer());
            }

            public Object m13764a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PaymentPlatformItemParser.m14000a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object paymentPlatformItemModel = new PaymentPlatformItemModel();
                ((BaseModel) paymentPlatformItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (paymentPlatformItemModel instanceof Postprocessable) {
                    return ((Postprocessable) paymentPlatformItemModel).a();
                }
                return paymentPlatformItemModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: helpText */
        public final class MerchantLogoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13350d;

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MerchantLogoModel.class, new Deserializer());
                }

                public Object m13765a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MerchantLogoParser.m13996a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object merchantLogoModel = new MerchantLogoModel();
                    ((BaseModel) merchantLogoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (merchantLogoModel instanceof Postprocessable) {
                        return ((Postprocessable) merchantLogoModel).a();
                    }
                    return merchantLogoModel;
                }
            }

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<MerchantLogoModel> {
                public final void m13766a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MerchantLogoModel merchantLogoModel = (MerchantLogoModel) obj;
                    if (merchantLogoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(merchantLogoModel.m13767a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        merchantLogoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MerchantLogoParser.m13997a(merchantLogoModel.w_(), merchantLogoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MerchantLogoModel.class, new Serializer());
                }
            }

            public MerchantLogoModel() {
                super(1);
            }

            @Nullable
            public final String m13769a() {
                this.f13350d = super.a(this.f13350d, 0);
                return this.f13350d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m13768a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13767a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13769a());
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
        /* compiled from: helpText */
        public final class PlatformImagesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13351d;

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlatformImagesModel.class, new Deserializer());
                }

                public Object m13770a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlatformImagesParser.m13999b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object platformImagesModel = new PlatformImagesModel();
                    ((BaseModel) platformImagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (platformImagesModel instanceof Postprocessable) {
                        return ((Postprocessable) platformImagesModel).a();
                    }
                    return platformImagesModel;
                }
            }

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<PlatformImagesModel> {
                public final void m13771a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlatformImagesModel platformImagesModel = (PlatformImagesModel) obj;
                    if (platformImagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(platformImagesModel.m13772a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        platformImagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlatformImagesParser.m13998a(platformImagesModel.w_(), platformImagesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlatformImagesModel.class, new Serializer());
                }
            }

            public PlatformImagesModel() {
                super(1);
            }

            @Nullable
            public final String m13774a() {
                this.f13351d = super.a(this.f13351d, 0);
                return this.f13351d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m13773a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13772a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13774a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PaymentPlatformItemModel> {
            public final void m13775a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PaymentPlatformItemModel paymentPlatformItemModel = (PaymentPlatformItemModel) obj;
                if (paymentPlatformItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(paymentPlatformItemModel.m13776a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    paymentPlatformItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PaymentPlatformItemParser.m14001a(paymentPlatformItemModel.w_(), paymentPlatformItemModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PaymentPlatformItemModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PaymentUserModel m13784k() {
            return m13789p();
        }

        @Nullable
        public final /* synthetic */ PaymentCurrencyAmountModel lu_() {
            return m13788o();
        }

        @Nullable
        public final /* synthetic */ MerchantLogoModel lv_() {
            return m13787n();
        }

        public PaymentPlatformItemModel() {
            super(11);
        }

        public PaymentPlatformItemModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType m13785l() {
            if (this.b != null && this.f13352d == null) {
                this.f13352d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13352d;
        }

        @Nullable
        public final String m13786m() {
            this.f13353e = super.a(this.f13353e, 1);
            return this.f13353e;
        }

        @Nullable
        public final String m13779b() {
            this.f13354f = super.a(this.f13354f, 2);
            return this.f13354f;
        }

        @Nullable
        public final GraphQLProductAvailability m13780c() {
            this.f13355g = (GraphQLProductAvailability) super.b(this.f13355g, 3, GraphQLProductAvailability.class, GraphQLProductAvailability.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13355g;
        }

        @Nonnull
        public final ImmutableList<String> m13781d() {
            this.f13356h = super.a(this.f13356h, 4);
            return (ImmutableList) this.f13356h;
        }

        @Nullable
        public final MerchantLogoModel m13787n() {
            this.f13357i = (MerchantLogoModel) super.a(this.f13357i, 5, MerchantLogoModel.class);
            return this.f13357i;
        }

        @Nullable
        public final String m13782g() {
            this.f13358j = super.a(this.f13358j, 6);
            return this.f13358j;
        }

        @Nonnull
        public final ImmutableList<PlatformImagesModel> lt_() {
            this.f13359k = super.a(this.f13359k, 7, PlatformImagesModel.class);
            return (ImmutableList) this.f13359k;
        }

        @Nullable
        public final PaymentCurrencyAmountModel m13788o() {
            this.f13360l = (PaymentCurrencyAmountModel) super.a(this.f13360l, 8, PaymentCurrencyAmountModel.class);
            return this.f13360l;
        }

        @Nullable
        public final String m13783j() {
            this.f13361m = super.a(this.f13361m, 9);
            return this.f13361m;
        }

        @Nullable
        public final PaymentUserModel m13789p() {
            this.f13362n = (PaymentUserModel) super.a(this.f13362n, 10, PaymentUserModel.class);
            return this.f13362n;
        }

        @Nullable
        public final String m13778a() {
            return m13779b();
        }

        public final int jK_() {
            return 1846636585;
        }

        public final GraphQLVisitableModel m13777a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13787n() != null) {
                MerchantLogoModel merchantLogoModel = (MerchantLogoModel) graphQLModelMutatingVisitor.b(m13787n());
                if (m13787n() != merchantLogoModel) {
                    graphQLVisitableModel = (PaymentPlatformItemModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13357i = merchantLogoModel;
                }
            }
            if (lt_() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(lt_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    PaymentPlatformItemModel paymentPlatformItemModel = (PaymentPlatformItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    paymentPlatformItemModel.f13359k = a.b();
                    graphQLVisitableModel = paymentPlatformItemModel;
                }
            }
            if (m13788o() != null) {
                PaymentCurrencyAmountModel paymentCurrencyAmountModel = (PaymentCurrencyAmountModel) graphQLModelMutatingVisitor.b(m13788o());
                if (m13788o() != paymentCurrencyAmountModel) {
                    graphQLVisitableModel = (PaymentPlatformItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13360l = paymentCurrencyAmountModel;
                }
            }
            if (m13789p() != null) {
                PaymentUserModel paymentUserModel = (PaymentUserModel) graphQLModelMutatingVisitor.b(m13789p());
                if (m13789p() != paymentUserModel) {
                    graphQLVisitableModel = (PaymentPlatformItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13362n = paymentUserModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13776a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13785l());
            int b = flatBufferBuilder.b(m13786m());
            int b2 = flatBufferBuilder.b(m13779b());
            int a2 = flatBufferBuilder.a(m13780c());
            int c = flatBufferBuilder.c(m13781d());
            int a3 = ModelHelper.a(flatBufferBuilder, m13787n());
            int b3 = flatBufferBuilder.b(m13782g());
            int a4 = ModelHelper.a(flatBufferBuilder, lt_());
            int a5 = ModelHelper.a(flatBufferBuilder, m13788o());
            int b4 = flatBufferBuilder.b(m13783j());
            int a6 = ModelHelper.a(flatBufferBuilder, m13789p());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, c);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, b3);
            flatBufferBuilder.b(7, a4);
            flatBufferBuilder.b(8, a5);
            flatBufferBuilder.b(9, b4);
            flatBufferBuilder.b(10, a6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1682904219)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PaymentRequestModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private PaymentCurrencyQuantityModel f13374d;
        private long f13375e;
        @Nullable
        private String f13376f;
        @Nullable
        private String f13377g;
        @Nullable
        private String f13378h;
        @Nullable
        private GraphQLPeerToPeerPaymentRequestStatus f13379i;
        @Nullable
        private ThemeModel f13380j;
        @Nullable
        private PaymentUserModel f13381k;
        @Nullable
        private PaymentUserModel f13382l;
        @Nullable
        private PaymentTransactionModel f13383m;
        private long f13384n;

        /* compiled from: helpText */
        public final class Builder {
            @Nullable
            public PaymentCurrencyQuantityModel f13363a;
            public long f13364b;
            @Nullable
            public String f13365c;
            @Nullable
            public String f13366d;
            @Nullable
            public String f13367e;
            @Nullable
            public GraphQLPeerToPeerPaymentRequestStatus f13368f;
            @Nullable
            public ThemeModel f13369g;
            @Nullable
            public PaymentUserModel f13370h;
            @Nullable
            public PaymentUserModel f13371i;
            @Nullable
            public PaymentTransactionModel f13372j;
            public long f13373k;

            public final Builder m13792a(@Nullable PaymentCurrencyQuantityModel paymentCurrencyQuantityModel) {
                this.f13363a = paymentCurrencyQuantityModel;
                return this;
            }

            public final Builder m13790a(long j) {
                this.f13364b = j;
                return this;
            }

            public final Builder m13794a(@Nullable String str) {
                this.f13365c = str;
                return this;
            }

            public final Builder m13797b(@Nullable String str) {
                this.f13366d = str;
                return this;
            }

            public final Builder m13798c(@Nullable String str) {
                this.f13367e = str;
                return this;
            }

            public final Builder m13791a(@Nullable GraphQLPeerToPeerPaymentRequestStatus graphQLPeerToPeerPaymentRequestStatus) {
                this.f13368f = graphQLPeerToPeerPaymentRequestStatus;
                return this;
            }

            public final Builder m13793a(@Nullable PaymentUserModel paymentUserModel) {
                this.f13370h = paymentUserModel;
                return this;
            }

            public final Builder m13796b(@Nullable PaymentUserModel paymentUserModel) {
                this.f13371i = paymentUserModel;
                return this;
            }

            public final PaymentRequestModel m13795a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f13363a);
                int b = flatBufferBuilder.b(this.f13365c);
                int b2 = flatBufferBuilder.b(this.f13366d);
                int b3 = flatBufferBuilder.b(this.f13367e);
                int a2 = flatBufferBuilder.a(this.f13368f);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f13369g);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f13370h);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f13371i);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f13372j);
                flatBufferBuilder.c(11);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f13364b, 0);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, a2);
                flatBufferBuilder.b(6, a3);
                flatBufferBuilder.b(7, a4);
                flatBufferBuilder.b(8, a5);
                flatBufferBuilder.b(9, a6);
                flatBufferBuilder.a(10, this.f13373k, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PaymentRequestModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PaymentRequestModel.class, new Deserializer());
            }

            public Object m13799a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PaymentRequestParser.m14004b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object paymentRequestModel = new PaymentRequestModel();
                ((BaseModel) paymentRequestModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (paymentRequestModel instanceof Postprocessable) {
                    return ((Postprocessable) paymentRequestModel).a();
                }
                return paymentRequestModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PaymentRequestModel> {
            public final void m13800a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PaymentRequestModel paymentRequestModel = (PaymentRequestModel) obj;
                if (paymentRequestModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(paymentRequestModel.m13807a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    paymentRequestModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PaymentRequestParser.m14005b(paymentRequestModel.w_(), paymentRequestModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PaymentRequestModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PaymentCurrencyQuantityModel m13811b() {
            return m13802n();
        }

        @Nullable
        public final /* synthetic */ PaymentUserModel m13815j() {
            return m13804p();
        }

        @Nullable
        public final /* synthetic */ PaymentUserModel m13816k() {
            return m13805q();
        }

        @Nullable
        public final /* synthetic */ PaymentTransactionModel m13817l() {
            return m13806r();
        }

        @Nullable
        public final /* synthetic */ ThemeModel ly_() {
            return m13803o();
        }

        public PaymentRequestModel() {
            super(11);
        }

        public PaymentRequestModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private PaymentCurrencyQuantityModel m13802n() {
            this.f13374d = (PaymentCurrencyQuantityModel) super.a(this.f13374d, 0, PaymentCurrencyQuantityModel.class);
            return this.f13374d;
        }

        public final long m13812c() {
            a(0, 1);
            return this.f13375e;
        }

        @Nullable
        public final String m13813d() {
            this.f13376f = super.a(this.f13376f, 2);
            return this.f13376f;
        }

        @Nullable
        public final String lw_() {
            this.f13377g = super.a(this.f13377g, 3);
            return this.f13377g;
        }

        @Nullable
        public final String m13814g() {
            this.f13378h = super.a(this.f13378h, 4);
            return this.f13378h;
        }

        @Nullable
        public final GraphQLPeerToPeerPaymentRequestStatus lx_() {
            this.f13379i = (GraphQLPeerToPeerPaymentRequestStatus) super.b(this.f13379i, 5, GraphQLPeerToPeerPaymentRequestStatus.class, GraphQLPeerToPeerPaymentRequestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13379i;
        }

        @Nullable
        private ThemeModel m13803o() {
            this.f13380j = (ThemeModel) super.a(this.f13380j, 6, ThemeModel.class);
            return this.f13380j;
        }

        @Nullable
        private PaymentUserModel m13804p() {
            this.f13381k = (PaymentUserModel) super.a(this.f13381k, 7, PaymentUserModel.class);
            return this.f13381k;
        }

        @Nullable
        private PaymentUserModel m13805q() {
            this.f13382l = (PaymentUserModel) super.a(this.f13382l, 8, PaymentUserModel.class);
            return this.f13382l;
        }

        @Nullable
        private PaymentTransactionModel m13806r() {
            this.f13383m = (PaymentTransactionModel) super.a(this.f13383m, 9, PaymentTransactionModel.class);
            return this.f13383m;
        }

        public final long m13818m() {
            a(1, 2);
            return this.f13384n;
        }

        public static PaymentRequestModel m13801a(PaymentRequestModel paymentRequestModel) {
            if (paymentRequestModel == null) {
                return null;
            }
            if (paymentRequestModel instanceof PaymentRequestModel) {
                return paymentRequestModel;
            }
            Builder builder = new Builder();
            builder.f13363a = PaymentCurrencyQuantityModel.m13702a(paymentRequestModel.m13811b());
            builder.f13364b = paymentRequestModel.m13812c();
            builder.f13365c = paymentRequestModel.m13813d();
            builder.f13366d = paymentRequestModel.lw_();
            builder.f13367e = paymentRequestModel.m13814g();
            builder.f13368f = paymentRequestModel.lx_();
            builder.f13369g = ThemeModel.m13935a(paymentRequestModel.ly_());
            builder.f13370h = PaymentUserModel.m13871a(paymentRequestModel.m13815j());
            builder.f13371i = PaymentUserModel.m13871a(paymentRequestModel.m13816k());
            builder.f13372j = PaymentTransactionModel.m13832a(paymentRequestModel.m13817l());
            builder.f13373k = paymentRequestModel.m13818m();
            return builder.m13795a();
        }

        @Nullable
        public final String m13809a() {
            return lw_();
        }

        public final int jK_() {
            return -268249560;
        }

        public final GraphQLVisitableModel m13808a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            PaymentUserModel paymentUserModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13802n() != null) {
                PaymentCurrencyQuantityModel paymentCurrencyQuantityModel = (PaymentCurrencyQuantityModel) graphQLModelMutatingVisitor.b(m13802n());
                if (m13802n() != paymentCurrencyQuantityModel) {
                    graphQLVisitableModel = (PaymentRequestModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13374d = paymentCurrencyQuantityModel;
                }
            }
            if (m13803o() != null) {
                ThemeModel themeModel = (ThemeModel) graphQLModelMutatingVisitor.b(m13803o());
                if (m13803o() != themeModel) {
                    graphQLVisitableModel = (PaymentRequestModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13380j = themeModel;
                }
            }
            if (m13804p() != null) {
                paymentUserModel = (PaymentUserModel) graphQLModelMutatingVisitor.b(m13804p());
                if (m13804p() != paymentUserModel) {
                    graphQLVisitableModel = (PaymentRequestModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13381k = paymentUserModel;
                }
            }
            if (m13805q() != null) {
                paymentUserModel = (PaymentUserModel) graphQLModelMutatingVisitor.b(m13805q());
                if (m13805q() != paymentUserModel) {
                    graphQLVisitableModel = (PaymentRequestModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13382l = paymentUserModel;
                }
            }
            if (m13806r() != null) {
                PaymentTransactionModel paymentTransactionModel = (PaymentTransactionModel) graphQLModelMutatingVisitor.b(m13806r());
                if (m13806r() != paymentTransactionModel) {
                    graphQLVisitableModel = (PaymentRequestModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13383m = paymentTransactionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13807a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13802n());
            int b = flatBufferBuilder.b(m13813d());
            int b2 = flatBufferBuilder.b(lw_());
            int b3 = flatBufferBuilder.b(m13814g());
            int a2 = flatBufferBuilder.a(lx_());
            int a3 = ModelHelper.a(flatBufferBuilder, m13803o());
            int a4 = ModelHelper.a(flatBufferBuilder, m13804p());
            int a5 = ModelHelper.a(flatBufferBuilder, m13805q());
            int a6 = ModelHelper.a(flatBufferBuilder, m13806r());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f13375e, 0);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, a2);
            flatBufferBuilder.b(6, a3);
            flatBufferBuilder.b(7, a4);
            flatBufferBuilder.b(8, a5);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.a(10, this.f13384n, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13810a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13375e = mutableFlatBuffer.a(i, 1, 0);
            this.f13384n = mutableFlatBuffer.a(i, 10, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 708217725)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PaymentShippingOptionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f13385d;
        @Nullable
        private String f13386e;
        private int f13387f;
        private int f13388g;
        @Nullable
        private String f13389h;
        private int f13390i;
        private int f13391j;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PaymentShippingOptionModel.class, new Deserializer());
            }

            public Object m13819a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PaymentShippingOptionParser.m14006a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object paymentShippingOptionModel = new PaymentShippingOptionModel();
                ((BaseModel) paymentShippingOptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (paymentShippingOptionModel instanceof Postprocessable) {
                    return ((Postprocessable) paymentShippingOptionModel).a();
                }
                return paymentShippingOptionModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PaymentShippingOptionModel> {
            public final void m13820a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PaymentShippingOptionModel paymentShippingOptionModel = (PaymentShippingOptionModel) obj;
                if (paymentShippingOptionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(paymentShippingOptionModel.m13821a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    paymentShippingOptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PaymentShippingOptionParser.m14007a(paymentShippingOptionModel.w_(), paymentShippingOptionModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PaymentShippingOptionModel.class, new Serializer());
            }
        }

        public PaymentShippingOptionModel() {
            super(7);
        }

        @Nullable
        public final String m13823a() {
            this.f13385d = super.a(this.f13385d, 0);
            return this.f13385d;
        }

        @Nullable
        public final String m13825b() {
            this.f13386e = super.a(this.f13386e, 1);
            return this.f13386e;
        }

        public final int m13826c() {
            a(0, 2);
            return this.f13387f;
        }

        public final int m13827d() {
            a(0, 3);
            return this.f13388g;
        }

        @Nullable
        public final String lz_() {
            this.f13389h = super.a(this.f13389h, 4);
            return this.f13389h;
        }

        public final int m13828g() {
            a(0, 5);
            return this.f13390i;
        }

        public final int lA_() {
            a(0, 6);
            return this.f13391j;
        }

        public final int jK_() {
            return -1715036258;
        }

        public final GraphQLVisitableModel m13822a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m13821a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13823a());
            int b2 = flatBufferBuilder.b(m13825b());
            int b3 = flatBufferBuilder.b(lz_());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.a(2, this.f13387f, 0);
            flatBufferBuilder.a(3, this.f13388g, 0);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.a(5, this.f13390i, 0);
            flatBufferBuilder.a(6, this.f13391j, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13824a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13387f = mutableFlatBuffer.a(i, 2, 0);
            this.f13388g = mutableFlatBuffer.a(i, 3, 0);
            this.f13390i = mutableFlatBuffer.a(i, 5, 0);
            this.f13391j = mutableFlatBuffer.a(i, 6, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1996928072)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PaymentTransactionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f13407d;
        @Nullable
        private PaymentCurrencyQuantityModel f13408e;
        @Nullable
        private PaymentCurrencyQuantityModel f13409f;
        @Nullable
        private CommerceOrderModel f13410g;
        private long f13411h;
        private long f13412i;
        @Nullable
        private String f13413j;
        @Nullable
        private String f13414k;
        @Nullable
        private PlatformItemModel f13415l;
        @Nullable
        private PaymentUserModel f13416m;
        @Nullable
        private GraphQLPeerToPeerTransferReceiverStatus f13417n;
        @Nullable
        private PaymentUserModel f13418o;
        @Nullable
        private GraphQLPeerToPeerTransferSenderStatus f13419p;
        @Nullable
        private TransferContextModel f13420q;
        private long f13421r;

        /* compiled from: helpText */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f13392a;
            @Nullable
            public PaymentCurrencyQuantityModel f13393b;
            @Nullable
            public PaymentCurrencyQuantityModel f13394c;
            @Nullable
            public CommerceOrderModel f13395d;
            public long f13396e;
            public long f13397f;
            @Nullable
            public String f13398g;
            @Nullable
            public String f13399h;
            @Nullable
            public PlatformItemModel f13400i;
            @Nullable
            public PaymentUserModel f13401j;
            @Nullable
            public GraphQLPeerToPeerTransferReceiverStatus f13402k;
            @Nullable
            public PaymentUserModel f13403l;
            @Nullable
            public GraphQLPeerToPeerTransferSenderStatus f13404m;
            @Nullable
            public TransferContextModel f13405n;
            public long f13406o;

            public final PaymentTransactionModel m13829a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f13392a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f13393b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f13394c);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f13395d);
                int b = flatBufferBuilder.b(this.f13398g);
                int b2 = flatBufferBuilder.b(this.f13399h);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f13400i);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f13401j);
                int a7 = flatBufferBuilder.a(this.f13402k);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f13403l);
                int a9 = flatBufferBuilder.a(this.f13404m);
                int a10 = ModelHelper.a(flatBufferBuilder, this.f13405n);
                flatBufferBuilder.c(15);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.a(4, this.f13396e, 0);
                flatBufferBuilder.a(5, this.f13397f, 0);
                flatBufferBuilder.b(6, b);
                flatBufferBuilder.b(7, b2);
                flatBufferBuilder.b(8, a5);
                flatBufferBuilder.b(9, a6);
                flatBufferBuilder.b(10, a7);
                flatBufferBuilder.b(11, a8);
                flatBufferBuilder.b(12, a9);
                flatBufferBuilder.b(13, a10);
                flatBufferBuilder.a(14, this.f13406o, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PaymentTransactionModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PaymentTransactionModel.class, new Deserializer());
            }

            public Object m13830a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PaymentTransactionParser.m14008a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object paymentTransactionModel = new PaymentTransactionModel();
                ((BaseModel) paymentTransactionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (paymentTransactionModel instanceof Postprocessable) {
                    return ((Postprocessable) paymentTransactionModel).a();
                }
                return paymentTransactionModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PaymentTransactionModel> {
            public final void m13831a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PaymentTransactionModel paymentTransactionModel = (PaymentTransactionModel) obj;
                if (paymentTransactionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(paymentTransactionModel.m13833a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    paymentTransactionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PaymentTransactionParser.m14009b(paymentTransactionModel.w_(), paymentTransactionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PaymentTransactionModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PaymentCurrencyQuantityModel m13838c() {
            return m13849r();
        }

        @Nullable
        public final /* synthetic */ PaymentCurrencyQuantityModel m13839d() {
            return m13850s();
        }

        @Nullable
        public final /* synthetic */ PlatformItemModel m13842k() {
            return m13852u();
        }

        @Nullable
        public final /* synthetic */ PaymentUserModel m13843l() {
            return m13853v();
        }

        @Nullable
        public final /* synthetic */ CommerceOrderModel lD_() {
            return m13851t();
        }

        @Nullable
        public final /* synthetic */ PaymentUserModel m13845n() {
            return m13854w();
        }

        @Nullable
        public final /* synthetic */ TransferContextModel m13847p() {
            return m13855x();
        }

        public PaymentTransactionModel() {
            super(15);
        }

        public PaymentTransactionModel(MutableFlatBuffer mutableFlatBuffer) {
            super(15);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType m13837b() {
            if (this.b != null && this.f13407d == null) {
                this.f13407d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13407d;
        }

        @Nullable
        public final PaymentCurrencyQuantityModel m13849r() {
            this.f13408e = (PaymentCurrencyQuantityModel) super.a(this.f13408e, 1, PaymentCurrencyQuantityModel.class);
            return this.f13408e;
        }

        @Nullable
        public final PaymentCurrencyQuantityModel m13850s() {
            this.f13409f = (PaymentCurrencyQuantityModel) super.a(this.f13409f, 2, PaymentCurrencyQuantityModel.class);
            return this.f13409f;
        }

        @Nullable
        public final CommerceOrderModel m13851t() {
            this.f13410g = (CommerceOrderModel) super.a(this.f13410g, 3, CommerceOrderModel.class);
            return this.f13410g;
        }

        public final long m13840g() {
            a(0, 4);
            return this.f13411h;
        }

        public final long lB_() {
            a(0, 5);
            return this.f13412i;
        }

        @Nullable
        public final String lC_() {
            this.f13413j = super.a(this.f13413j, 6);
            return this.f13413j;
        }

        @Nullable
        public final String m13841j() {
            this.f13414k = super.a(this.f13414k, 7);
            return this.f13414k;
        }

        @Nullable
        public final PlatformItemModel m13852u() {
            this.f13415l = (PlatformItemModel) super.a(this.f13415l, 8, PlatformItemModel.class);
            return this.f13415l;
        }

        @Nullable
        public final PaymentUserModel m13853v() {
            this.f13416m = (PaymentUserModel) super.a(this.f13416m, 9, PaymentUserModel.class);
            return this.f13416m;
        }

        @Nullable
        public final GraphQLPeerToPeerTransferReceiverStatus m13844m() {
            this.f13417n = (GraphQLPeerToPeerTransferReceiverStatus) super.b(this.f13417n, 10, GraphQLPeerToPeerTransferReceiverStatus.class, GraphQLPeerToPeerTransferReceiverStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13417n;
        }

        @Nullable
        public final PaymentUserModel m13854w() {
            this.f13418o = (PaymentUserModel) super.a(this.f13418o, 11, PaymentUserModel.class);
            return this.f13418o;
        }

        @Nullable
        public final GraphQLPeerToPeerTransferSenderStatus m13846o() {
            this.f13419p = (GraphQLPeerToPeerTransferSenderStatus) super.b(this.f13419p, 12, GraphQLPeerToPeerTransferSenderStatus.class, GraphQLPeerToPeerTransferSenderStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13419p;
        }

        @Nullable
        public final TransferContextModel m13855x() {
            this.f13420q = (TransferContextModel) super.a(this.f13420q, 13, TransferContextModel.class);
            return this.f13420q;
        }

        public final long m13848q() {
            a(1, 6);
            return this.f13421r;
        }

        public static PaymentTransactionModel m13832a(PaymentTransactionModel paymentTransactionModel) {
            if (paymentTransactionModel == null) {
                return null;
            }
            if (paymentTransactionModel instanceof PaymentTransactionModel) {
                return paymentTransactionModel;
            }
            Builder builder = new Builder();
            builder.f13392a = paymentTransactionModel.m13837b();
            builder.f13393b = PaymentCurrencyQuantityModel.m13702a(paymentTransactionModel.m13838c());
            builder.f13394c = PaymentCurrencyQuantityModel.m13702a(paymentTransactionModel.m13839d());
            builder.f13395d = CommerceOrderModel.m13570a(paymentTransactionModel.lD_());
            builder.f13396e = paymentTransactionModel.m13840g();
            builder.f13397f = paymentTransactionModel.lB_();
            builder.f13398g = paymentTransactionModel.lC_();
            builder.f13399h = paymentTransactionModel.m13841j();
            builder.f13400i = PlatformItemModel.m13896a(paymentTransactionModel.m13842k());
            builder.f13401j = PaymentUserModel.m13871a(paymentTransactionModel.m13843l());
            builder.f13402k = paymentTransactionModel.m13844m();
            builder.f13403l = PaymentUserModel.m13871a(paymentTransactionModel.m13845n());
            builder.f13404m = paymentTransactionModel.m13846o();
            builder.f13405n = TransferContextModel.m13946a(paymentTransactionModel.m13847p());
            builder.f13406o = paymentTransactionModel.m13848q();
            return builder.m13829a();
        }

        @Nullable
        public final String m13835a() {
            return lC_();
        }

        public final int jK_() {
            return 712001427;
        }

        public final GraphQLVisitableModel m13834a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            PaymentCurrencyQuantityModel paymentCurrencyQuantityModel;
            PaymentUserModel paymentUserModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13849r() != null) {
                paymentCurrencyQuantityModel = (PaymentCurrencyQuantityModel) graphQLModelMutatingVisitor.b(m13849r());
                if (m13849r() != paymentCurrencyQuantityModel) {
                    graphQLVisitableModel = (PaymentTransactionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13408e = paymentCurrencyQuantityModel;
                }
            }
            if (m13850s() != null) {
                paymentCurrencyQuantityModel = (PaymentCurrencyQuantityModel) graphQLModelMutatingVisitor.b(m13850s());
                if (m13850s() != paymentCurrencyQuantityModel) {
                    graphQLVisitableModel = (PaymentTransactionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13409f = paymentCurrencyQuantityModel;
                }
            }
            if (m13851t() != null) {
                CommerceOrderModel commerceOrderModel = (CommerceOrderModel) graphQLModelMutatingVisitor.b(m13851t());
                if (m13851t() != commerceOrderModel) {
                    graphQLVisitableModel = (PaymentTransactionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13410g = commerceOrderModel;
                }
            }
            if (m13852u() != null) {
                PlatformItemModel platformItemModel = (PlatformItemModel) graphQLModelMutatingVisitor.b(m13852u());
                if (m13852u() != platformItemModel) {
                    graphQLVisitableModel = (PaymentTransactionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13415l = platformItemModel;
                }
            }
            if (m13853v() != null) {
                paymentUserModel = (PaymentUserModel) graphQLModelMutatingVisitor.b(m13853v());
                if (m13853v() != paymentUserModel) {
                    graphQLVisitableModel = (PaymentTransactionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13416m = paymentUserModel;
                }
            }
            if (m13854w() != null) {
                paymentUserModel = (PaymentUserModel) graphQLModelMutatingVisitor.b(m13854w());
                if (m13854w() != paymentUserModel) {
                    graphQLVisitableModel = (PaymentTransactionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13418o = paymentUserModel;
                }
            }
            if (m13855x() != null) {
                TransferContextModel transferContextModel = (TransferContextModel) graphQLModelMutatingVisitor.b(m13855x());
                if (m13855x() != transferContextModel) {
                    graphQLVisitableModel = (PaymentTransactionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13420q = transferContextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13833a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13837b());
            int a2 = ModelHelper.a(flatBufferBuilder, m13849r());
            int a3 = ModelHelper.a(flatBufferBuilder, m13850s());
            int a4 = ModelHelper.a(flatBufferBuilder, m13851t());
            int b = flatBufferBuilder.b(lC_());
            int b2 = flatBufferBuilder.b(m13841j());
            int a5 = ModelHelper.a(flatBufferBuilder, m13852u());
            int a6 = ModelHelper.a(flatBufferBuilder, m13853v());
            int a7 = flatBufferBuilder.a(m13844m());
            int a8 = ModelHelper.a(flatBufferBuilder, m13854w());
            int a9 = flatBufferBuilder.a(m13846o());
            int a10 = ModelHelper.a(flatBufferBuilder, m13855x());
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.a(4, this.f13411h, 0);
            flatBufferBuilder.a(5, this.f13412i, 0);
            flatBufferBuilder.b(6, b);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, a5);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.b(10, a7);
            flatBufferBuilder.b(11, a8);
            flatBufferBuilder.b(12, a9);
            flatBufferBuilder.b(13, a10);
            flatBufferBuilder.a(14, this.f13421r, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13836a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13411h = mutableFlatBuffer.a(i, 4, 0);
            this.f13412i = mutableFlatBuffer.a(i, 5, 0);
            this.f13421r = mutableFlatBuffer.a(i, 14, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1929392830)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PaymentTransactionsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<PaymentTransactionModel> f13423d;
        @Nullable
        private PageInfoModel f13424e;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PaymentTransactionsModel.class, new Deserializer());
            }

            public Object m13856a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PaymentTransactionsParser.m14012a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object paymentTransactionsModel = new PaymentTransactionsModel();
                ((BaseModel) paymentTransactionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (paymentTransactionsModel instanceof Postprocessable) {
                    return ((Postprocessable) paymentTransactionsModel).a();
                }
                return paymentTransactionsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1947362733)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: helpText */
        public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f13422d;

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                }

                public Object m13857a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PaymentTransactionsParser.PageInfoParser.m14010a(jsonParser, flatBufferBuilder));
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

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<PageInfoModel> {
                public final void m13858a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageInfoModel pageInfoModel = (PageInfoModel) obj;
                    if (pageInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageInfoModel.m13859a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PaymentTransactionsParser.PageInfoParser.m14011a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                }
            }

            public PageInfoModel() {
                super(1);
            }

            public final boolean m13862a() {
                a(0, 0);
                return this.f13422d;
            }

            public final int jK_() {
                return 923779069;
            }

            public final GraphQLVisitableModel m13860a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13859a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f13422d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m13861a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f13422d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PaymentTransactionsModel> {
            public final void m13863a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PaymentTransactionsModel paymentTransactionsModel = (PaymentTransactionsModel) obj;
                if (paymentTransactionsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(paymentTransactionsModel.m13864a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    paymentTransactionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PaymentTransactionsParser.m14013a(paymentTransactionsModel.w_(), paymentTransactionsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PaymentTransactionsModel.class, new Serializer());
            }
        }

        public PaymentTransactionsModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<PaymentTransactionModel> m13866a() {
            this.f13423d = super.a(this.f13423d, 0, PaymentTransactionModel.class);
            return (ImmutableList) this.f13423d;
        }

        @Nullable
        public final PageInfoModel m13867j() {
            this.f13424e = (PageInfoModel) super.a(this.f13424e, 1, PageInfoModel.class);
            return this.f13424e;
        }

        public final int jK_() {
            return -58913763;
        }

        public final GraphQLVisitableModel m13865a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            PageInfoModel pageInfoModel;
            h();
            if (m13866a() != null) {
                Builder a = ModelHelper.a(m13866a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    PaymentTransactionsModel paymentTransactionsModel = (PaymentTransactionsModel) ModelHelper.a(null, this);
                    paymentTransactionsModel.f13423d = a.b();
                    graphQLVisitableModel = paymentTransactionsModel;
                    if (m13867j() != null) {
                        pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m13867j());
                        if (m13867j() != pageInfoModel) {
                            graphQLVisitableModel = (PaymentTransactionsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13424e = pageInfoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m13867j() != null) {
                pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m13867j());
                if (m13867j() != pageInfoModel) {
                    graphQLVisitableModel = (PaymentTransactionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13424e = pageInfoModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m13864a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13866a());
            int a2 = ModelHelper.a(flatBufferBuilder, m13867j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -864890516)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PaymentUserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f13429d;
        @Nullable
        private String f13430e;
        private boolean f13431f;
        @Nullable
        private String f13432g;

        /* compiled from: helpText */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f13425a;
            @Nullable
            public String f13426b;
            public boolean f13427c;
            @Nullable
            public String f13428d;

            public final PaymentUserModel m13868a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f13425a);
                int b = flatBufferBuilder.b(this.f13426b);
                int b2 = flatBufferBuilder.b(this.f13428d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f13427c);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PaymentUserModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PaymentUserModel.class, new Deserializer());
            }

            public Object m13869a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PaymentUserParser.m14014a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object paymentUserModel = new PaymentUserModel();
                ((BaseModel) paymentUserModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (paymentUserModel instanceof Postprocessable) {
                    return ((Postprocessable) paymentUserModel).a();
                }
                return paymentUserModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PaymentUserModel> {
            public final void m13870a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PaymentUserModel paymentUserModel = (PaymentUserModel) obj;
                if (paymentUserModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(paymentUserModel.m13872a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    paymentUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PaymentUserParser.m14015a(paymentUserModel.w_(), paymentUserModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PaymentUserModel.class, new Serializer());
            }
        }

        public PaymentUserModel() {
            super(4);
        }

        public PaymentUserModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m13876a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13877a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType m13878b() {
            if (this.b != null && this.f13429d == null) {
                this.f13429d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13429d;
        }

        @Nullable
        public final String m13879c() {
            this.f13430e = super.a(this.f13430e, 1);
            return this.f13430e;
        }

        public final boolean m13880d() {
            a(0, 2);
            return this.f13431f;
        }

        @Nullable
        public final String lE_() {
            this.f13432g = super.a(this.f13432g, 3);
            return this.f13432g;
        }

        public static PaymentUserModel m13871a(PaymentUserModel paymentUserModel) {
            if (paymentUserModel == null) {
                return null;
            }
            if (paymentUserModel instanceof PaymentUserModel) {
                return paymentUserModel;
            }
            Builder builder = new Builder();
            builder.f13425a = paymentUserModel.m13878b();
            builder.f13426b = paymentUserModel.m13879c();
            builder.f13427c = paymentUserModel.m13880d();
            builder.f13428d = paymentUserModel.lE_();
            return builder.m13868a();
        }

        @Nullable
        public final String m13874a() {
            return m13879c();
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m13873a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m13872a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13878b());
            int b = flatBufferBuilder.b(m13879c());
            int b2 = flatBufferBuilder.b(lE_());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f13431f);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13875a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13431f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1539849689)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class PlatformItemModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f13441d;
        @Nullable
        private String f13442e;
        @Nullable
        private String f13443f;
        @Nullable
        private List<PhotosModel> f13444g;

        /* compiled from: helpText */
        public final class Builder {
            @Nullable
            public String f13433a;
            @Nullable
            public String f13434b;
            @Nullable
            public String f13435c;
            @Nullable
            public ImmutableList<PhotosModel> f13436d;
        }

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlatformItemModel.class, new Deserializer());
            }

            public Object m13881a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlatformItemParser.m14020a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object platformItemModel = new PlatformItemModel();
                ((BaseModel) platformItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (platformItemModel instanceof Postprocessable) {
                    return ((Postprocessable) platformItemModel).a();
                }
                return platformItemModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1273040494)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: helpText */
        public final class PhotosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ImageModel f13440d;

            /* compiled from: helpText */
            public final class Builder {
                @Nullable
                public ImageModel f13437a;
            }

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotosModel.class, new Deserializer());
                }

                public Object m13882a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotosParser.m14018b(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: helpText */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f13439d;

                /* compiled from: helpText */
                public final class Builder {
                    @Nullable
                    public String f13438a;
                }

                /* compiled from: helpText */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                    }

                    public Object m13883a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageParser.m14016a(jsonParser, flatBufferBuilder));
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

                /* compiled from: helpText */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m13884a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageModel imageModel = (ImageModel) obj;
                        if (imageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageModel.m13886a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageParser.m14017a(imageModel.w_(), imageModel.u_(), jsonGenerator);
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
                public final String m13888a() {
                    this.f13439d = super.a(this.f13439d, 0);
                    return this.f13439d;
                }

                public static ImageModel m13885a(ImageModel imageModel) {
                    if (imageModel == null) {
                        return null;
                    }
                    if (imageModel instanceof ImageModel) {
                        return imageModel;
                    }
                    Builder builder = new Builder();
                    builder.f13438a = imageModel.m13888a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f13438a);
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

                public final GraphQLVisitableModel m13887a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m13886a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m13888a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<PhotosModel> {
                public final void m13889a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotosModel photosModel = (PhotosModel) obj;
                    if (photosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photosModel.m13892a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotosParser.m14019b(photosModel.w_(), photosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotosModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ImageModel m13894a() {
                return m13891j();
            }

            public PhotosModel() {
                super(1);
            }

            public PhotosModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private ImageModel m13891j() {
                this.f13440d = (ImageModel) super.a(this.f13440d, 0, ImageModel.class);
                return this.f13440d;
            }

            public static PhotosModel m13890a(PhotosModel photosModel) {
                if (photosModel == null) {
                    return null;
                }
                if (photosModel instanceof PhotosModel) {
                    return photosModel;
                }
                Builder builder = new Builder();
                builder.f13437a = ImageModel.m13885a(photosModel.m13894a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f13437a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PhotosModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m13893a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13891j() != null) {
                    ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m13891j());
                    if (m13891j() != imageModel) {
                        graphQLVisitableModel = (PhotosModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13440d = imageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13892a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13891j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<PlatformItemModel> {
            public final void m13895a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlatformItemModel platformItemModel = (PlatformItemModel) obj;
                if (platformItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(platformItemModel.m13897a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    platformItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlatformItemParser.m14021a(platformItemModel.w_(), platformItemModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlatformItemModel.class, new Serializer());
            }
        }

        public PlatformItemModel() {
            super(4);
        }

        public PlatformItemModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m13900b() {
            this.f13441d = super.a(this.f13441d, 0);
            return this.f13441d;
        }

        @Nullable
        public final String m13901c() {
            this.f13442e = super.a(this.f13442e, 1);
            return this.f13442e;
        }

        @Nullable
        public final String m13902d() {
            this.f13443f = super.a(this.f13443f, 2);
            return this.f13443f;
        }

        @Nonnull
        public final ImmutableList<PhotosModel> lF_() {
            this.f13444g = super.a(this.f13444g, 3, PhotosModel.class);
            return (ImmutableList) this.f13444g;
        }

        public static PlatformItemModel m13896a(PlatformItemModel platformItemModel) {
            if (platformItemModel == null) {
                return null;
            }
            if (platformItemModel instanceof PlatformItemModel) {
                return platformItemModel;
            }
            Builder builder = new Builder();
            builder.f13433a = platformItemModel.m13900b();
            builder.f13434b = platformItemModel.m13901c();
            builder.f13435c = platformItemModel.m13902d();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < platformItemModel.lF_().size(); i++) {
                builder2.c(PhotosModel.m13890a((PhotosModel) platformItemModel.lF_().get(i)));
            }
            builder.f13436d = builder2.b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f13433a);
            int b2 = flatBufferBuilder.b(builder.f13434b);
            int b3 = flatBufferBuilder.b(builder.f13435c);
            int a = ModelHelper.a(flatBufferBuilder, builder.f13436d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new PlatformItemModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m13899a() {
            return m13901c();
        }

        public final int jK_() {
            return -1146606070;
        }

        public final GraphQLVisitableModel m13898a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (lF_() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(lF_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PlatformItemModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13444g = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13897a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13900b());
            int b2 = flatBufferBuilder.b(m13901c());
            int b3 = flatBufferBuilder.b(m13902d());
            int a = ModelHelper.a(flatBufferBuilder, lF_());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1024531349)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class StreetAddressInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f13445d;
        @Nullable
        private String f13446e;
        @Nullable
        private String f13447f;
        @Nullable
        private String f13448g;
        @Nullable
        private String f13449h;
        @Nullable
        private String f13450i;

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StreetAddressInfoModel.class, new Deserializer());
            }

            public Object m13903a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StreetAddressInfoParser.m14022a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object streetAddressInfoModel = new StreetAddressInfoModel();
                ((BaseModel) streetAddressInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (streetAddressInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) streetAddressInfoModel).a();
                }
                return streetAddressInfoModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<StreetAddressInfoModel> {
            public final void m13904a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StreetAddressInfoModel streetAddressInfoModel = (StreetAddressInfoModel) obj;
                if (streetAddressInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(streetAddressInfoModel.m13905a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    streetAddressInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StreetAddressInfoParser.m14023a(streetAddressInfoModel.w_(), streetAddressInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(StreetAddressInfoModel.class, new Serializer());
            }
        }

        public StreetAddressInfoModel() {
            super(6);
        }

        @Nullable
        public final String m13907a() {
            this.f13445d = super.a(this.f13445d, 0);
            return this.f13445d;
        }

        @Nullable
        public final String m13908b() {
            this.f13446e = super.a(this.f13446e, 1);
            return this.f13446e;
        }

        @Nullable
        public final String m13909c() {
            this.f13447f = super.a(this.f13447f, 2);
            return this.f13447f;
        }

        @Nullable
        public final String m13910d() {
            this.f13448g = super.a(this.f13448g, 3);
            return this.f13448g;
        }

        @Nullable
        public final String lG_() {
            this.f13449h = super.a(this.f13449h, 4);
            return this.f13449h;
        }

        @Nullable
        public final String m13911g() {
            this.f13450i = super.a(this.f13450i, 5);
            return this.f13450i;
        }

        public final int jK_() {
            return 799251025;
        }

        public final GraphQLVisitableModel m13906a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m13905a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13907a());
            int b2 = flatBufferBuilder.b(m13908b());
            int b3 = flatBufferBuilder.b(m13909c());
            int b4 = flatBufferBuilder.b(m13910d());
            int b5 = flatBufferBuilder.b(lG_());
            int b6 = flatBufferBuilder.b(m13911g());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.b(4, b5);
            flatBufferBuilder.b(5, b6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1300868443)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class ThemeAssetModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLMessengerPayThemeAssetTypeEnum f13456d;
        @Nullable
        private List<GraphQLMessengerPayThemeAssetCompatibilityEnum> f13457e;
        @Nullable
        private ImageModel f13458f;

        /* compiled from: helpText */
        public final class Builder {
            @Nullable
            public GraphQLMessengerPayThemeAssetTypeEnum f13451a;
            @Nullable
            public ImmutableList<GraphQLMessengerPayThemeAssetCompatibilityEnum> f13452b;
            @Nullable
            public ImageModel f13453c;
        }

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThemeAssetModel.class, new Deserializer());
            }

            public Object m13912a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ThemeAssetParser.m14026b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object themeAssetModel = new ThemeAssetModel();
                ((BaseModel) themeAssetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (themeAssetModel instanceof Postprocessable) {
                    return ((Postprocessable) themeAssetModel).a();
                }
                return themeAssetModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: helpText */
        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13455d;

            /* compiled from: helpText */
            public final class Builder {
                @Nullable
                public String f13454a;
            }

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                }

                public Object m13913a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThemeAssetParser.ImageParser.m14024a(jsonParser, flatBufferBuilder));
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

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<ImageModel> {
                public final void m13914a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageModel imageModel = (ImageModel) obj;
                    if (imageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageModel.m13916a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThemeAssetParser.ImageParser.m14025a(imageModel.w_(), imageModel.u_(), jsonGenerator);
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
            public final String m13918a() {
                this.f13455d = super.a(this.f13455d, 0);
                return this.f13455d;
            }

            public static ImageModel m13915a(ImageModel imageModel) {
                if (imageModel == null) {
                    return null;
                }
                if (imageModel instanceof ImageModel) {
                    return imageModel;
                }
                Builder builder = new Builder();
                builder.f13454a = imageModel.m13918a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f13454a);
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

            public final GraphQLVisitableModel m13917a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13916a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13918a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<ThemeAssetModel> {
            public final void m13919a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ThemeAssetModel themeAssetModel = (ThemeAssetModel) obj;
                if (themeAssetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(themeAssetModel.m13922a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    themeAssetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ThemeAssetParser.m14027b(themeAssetModel.w_(), themeAssetModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ThemeAssetModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ImageModel m13926c() {
            return m13921j();
        }

        public ThemeAssetModel() {
            super(3);
        }

        public ThemeAssetModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLMessengerPayThemeAssetTypeEnum m13923a() {
            this.f13456d = (GraphQLMessengerPayThemeAssetTypeEnum) super.b(this.f13456d, 0, GraphQLMessengerPayThemeAssetTypeEnum.class, GraphQLMessengerPayThemeAssetTypeEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13456d;
        }

        @Nonnull
        public final ImmutableList<GraphQLMessengerPayThemeAssetCompatibilityEnum> m13925b() {
            this.f13457e = super.c(this.f13457e, 1, GraphQLMessengerPayThemeAssetCompatibilityEnum.class);
            return (ImmutableList) this.f13457e;
        }

        @Nullable
        private ImageModel m13921j() {
            this.f13458f = (ImageModel) super.a(this.f13458f, 2, ImageModel.class);
            return this.f13458f;
        }

        public static ThemeAssetModel m13920a(ThemeAssetModel themeAssetModel) {
            if (themeAssetModel == null) {
                return null;
            }
            if (themeAssetModel instanceof ThemeAssetModel) {
                return themeAssetModel;
            }
            Builder builder = new Builder();
            builder.f13451a = themeAssetModel.m13923a();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < themeAssetModel.m13925b().size(); i++) {
                builder2.c(themeAssetModel.m13925b().get(i));
            }
            builder.f13452b = builder2.b();
            builder.f13453c = ImageModel.m13915a(themeAssetModel.m13926c());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = flatBufferBuilder.a(builder.f13451a);
            int d = flatBufferBuilder.d(builder.f13452b);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f13453c);
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, d);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ThemeAssetModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 1235324220;
        }

        public final GraphQLVisitableModel m13924a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13921j() != null) {
                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m13921j());
                if (m13921j() != imageModel) {
                    graphQLVisitableModel = (ThemeAssetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13458f = imageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13922a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m13923a());
            int d = flatBufferBuilder.d(m13925b());
            int a2 = ModelHelper.a(flatBufferBuilder, m13921j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, d);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -275659502)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class ThemeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AssetsModel f13465d;
        @Nullable
        private String f13466e;
        @Nullable
        private String f13467f;
        @Nullable
        private String f13468g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -427314515)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: helpText */
        public final class AssetsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ThemeAssetModel> f13460d;

            /* compiled from: helpText */
            public final class Builder {
                @Nullable
                public ImmutableList<ThemeAssetModel> f13459a;
            }

            /* compiled from: helpText */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AssetsModel.class, new Deserializer());
                }

                public Object m13927a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AssetsParser.m14028a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object assetsModel = new AssetsModel();
                    ((BaseModel) assetsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (assetsModel instanceof Postprocessable) {
                        return ((Postprocessable) assetsModel).a();
                    }
                    return assetsModel;
                }
            }

            /* compiled from: helpText */
            public class Serializer extends JsonSerializer<AssetsModel> {
                public final void m13928a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AssetsModel assetsModel = (AssetsModel) obj;
                    if (assetsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(assetsModel.m13930a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        assetsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AssetsParser.m14029a(assetsModel.w_(), assetsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AssetsModel.class, new Serializer());
                }
            }

            public AssetsModel() {
                super(1);
            }

            public AssetsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<ThemeAssetModel> m13932a() {
                this.f13460d = super.a(this.f13460d, 0, ThemeAssetModel.class);
                return (ImmutableList) this.f13460d;
            }

            public static AssetsModel m13929a(AssetsModel assetsModel) {
                if (assetsModel == null) {
                    return null;
                }
                if (assetsModel instanceof AssetsModel) {
                    return assetsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < assetsModel.m13932a().size(); i++) {
                    builder2.c(ThemeAssetModel.m13920a((ThemeAssetModel) assetsModel.m13932a().get(i)));
                }
                builder.f13459a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f13459a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AssetsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 1264254096;
            }

            public final GraphQLVisitableModel m13931a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13932a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m13932a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AssetsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13460d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13930a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13932a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: helpText */
        public final class Builder {
            @Nullable
            public AssetsModel f13461a;
            @Nullable
            public String f13462b;
            @Nullable
            public String f13463c;
            @Nullable
            public String f13464d;
        }

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThemeModel.class, new Deserializer());
            }

            public Object m13933a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ThemeParser.m14030a(jsonParser, flatBufferBuilder));
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

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<ThemeModel> {
            public final void m13934a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ThemeModel themeModel = (ThemeModel) obj;
                if (themeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(themeModel.m13937a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    themeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ThemeParser.m14031b(themeModel.w_(), themeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ThemeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AssetsModel m13940b() {
            return m13936j();
        }

        public ThemeModel() {
            super(4);
        }

        public ThemeModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private AssetsModel m13936j() {
            this.f13465d = (AssetsModel) super.a(this.f13465d, 0, AssetsModel.class);
            return this.f13465d;
        }

        @Nullable
        public final String m13941c() {
            this.f13466e = super.a(this.f13466e, 1);
            return this.f13466e;
        }

        @Nullable
        public final String m13942d() {
            this.f13467f = super.a(this.f13467f, 2);
            return this.f13467f;
        }

        @Nullable
        public final String lH_() {
            this.f13468g = super.a(this.f13468g, 3);
            return this.f13468g;
        }

        public static ThemeModel m13935a(ThemeModel themeModel) {
            if (themeModel == null) {
                return null;
            }
            if (themeModel instanceof ThemeModel) {
                return themeModel;
            }
            Builder builder = new Builder();
            builder.f13461a = AssetsModel.m13929a(themeModel.m13940b());
            builder.f13462b = themeModel.m13941c();
            builder.f13463c = themeModel.m13942d();
            builder.f13464d = themeModel.lH_();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f13461a);
            int b = flatBufferBuilder.b(builder.f13462b);
            int b2 = flatBufferBuilder.b(builder.f13463c);
            int b3 = flatBufferBuilder.b(builder.f13464d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ThemeModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m13939a() {
            return m13942d();
        }

        public final int jK_() {
            return 574200340;
        }

        public final GraphQLVisitableModel m13938a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13936j() != null) {
                AssetsModel assetsModel = (AssetsModel) graphQLModelMutatingVisitor.b(m13936j());
                if (m13936j() != assetsModel) {
                    graphQLVisitableModel = (ThemeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13465d = assetsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13937a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13936j());
            int b = flatBufferBuilder.b(m13941c());
            int b2 = flatBufferBuilder.b(m13942d());
            int b3 = flatBufferBuilder.b(lH_());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 116015763)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: helpText */
    public final class TransferContextModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f13471d;
        @Nullable
        private ThemeModel f13472e;

        /* compiled from: helpText */
        public final class Builder {
            @Nullable
            public String f13469a;
            @Nullable
            public ThemeModel f13470b;

            public final TransferContextModel m13943a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f13469a);
                int a = ModelHelper.a(flatBufferBuilder, this.f13470b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TransferContextModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: helpText */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TransferContextModel.class, new Deserializer());
            }

            public Object m13944a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TransferContextParser.m14032a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object transferContextModel = new TransferContextModel();
                ((BaseModel) transferContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (transferContextModel instanceof Postprocessable) {
                    return ((Postprocessable) transferContextModel).a();
                }
                return transferContextModel;
            }
        }

        /* compiled from: helpText */
        public class Serializer extends JsonSerializer<TransferContextModel> {
            public final void m13945a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TransferContextModel transferContextModel = (TransferContextModel) obj;
                if (transferContextModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(transferContextModel.m13948a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    transferContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TransferContextParser.m14033a(transferContextModel.w_(), transferContextModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TransferContextModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ThemeModel m13951b() {
            return m13947j();
        }

        public TransferContextModel() {
            super(2);
        }

        public TransferContextModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m13950a() {
            this.f13471d = super.a(this.f13471d, 0);
            return this.f13471d;
        }

        @Nullable
        private ThemeModel m13947j() {
            this.f13472e = (ThemeModel) super.a(this.f13472e, 1, ThemeModel.class);
            return this.f13472e;
        }

        public static TransferContextModel m13946a(TransferContextModel transferContextModel) {
            if (transferContextModel == null) {
                return null;
            }
            if (transferContextModel instanceof TransferContextModel) {
                return transferContextModel;
            }
            Builder builder = new Builder();
            builder.f13469a = transferContextModel.m13950a();
            builder.f13470b = ThemeModel.m13935a(transferContextModel.m13951b());
            return builder.m13943a();
        }

        public final int jK_() {
            return -420952411;
        }

        public final GraphQLVisitableModel m13949a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13947j() != null) {
                ThemeModel themeModel = (ThemeModel) graphQLModelMutatingVisitor.b(m13947j());
                if (m13947j() != themeModel) {
                    graphQLVisitableModel = (TransferContextModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13472e = themeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13948a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13950a());
            int a = ModelHelper.a(flatBufferBuilder, m13947j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
