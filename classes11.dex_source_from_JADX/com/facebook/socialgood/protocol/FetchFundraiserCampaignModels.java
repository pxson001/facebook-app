package com.facebook.socialgood.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMobilePaymentOption;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.socialgood.protocol.FetchFundraiserCampaignParsers.CurrencyAmountFieldsParser;
import com.facebook.socialgood.protocol.FetchFundraiserCampaignParsers.FetchDonationPaymentMethodsQueryParser;
import com.facebook.socialgood.protocol.FetchFundraiserCampaignParsers.FetchDonationPaymentMethodsQueryParser.FundraiserPaymentInfoParser;
import com.facebook.socialgood.protocol.FetchFundraiserCampaignParsers.FetchDonationPaymentMethodsQueryParser.FundraiserPaymentInfoParser.MethodsParser;
import com.facebook.socialgood.protocol.FetchFundraiserCampaignParsers.FundraiserCampaignFragmentParser;
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

/* compiled from: Operation canceled */
public class FetchFundraiserCampaignModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1377760999)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Operation canceled */
    public final class CurrencyAmountFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f12714d;
        @Nullable
        private String f12715e;

        /* compiled from: Operation canceled */
        public final class Builder {
            public int f12712a;
            @Nullable
            public String f12713b;

            public final Builder m13218a(int i) {
                this.f12712a = i;
                return this;
            }

            public final Builder m13219a(@Nullable String str) {
                this.f12713b = str;
                return this;
            }

            public final CurrencyAmountFieldsModel m13220a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f12713b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f12712a, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CurrencyAmountFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: Operation canceled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CurrencyAmountFieldsModel.class, new Deserializer());
            }

            public Object m13221a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CurrencyAmountFieldsParser.m13263a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object currencyAmountFieldsModel = new CurrencyAmountFieldsModel();
                ((BaseModel) currencyAmountFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (currencyAmountFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) currencyAmountFieldsModel).a();
                }
                return currencyAmountFieldsModel;
            }
        }

        /* compiled from: Operation canceled */
        public class Serializer extends JsonSerializer<CurrencyAmountFieldsModel> {
            public final void m13222a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CurrencyAmountFieldsModel currencyAmountFieldsModel = (CurrencyAmountFieldsModel) obj;
                if (currencyAmountFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(currencyAmountFieldsModel.m13224a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    currencyAmountFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CurrencyAmountFieldsParser.m13264a(currencyAmountFieldsModel.w_(), currencyAmountFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(CurrencyAmountFieldsModel.class, new Serializer());
            }
        }

        public CurrencyAmountFieldsModel() {
            super(2);
        }

        public CurrencyAmountFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m13223a() {
            a(0, 0);
            return this.f12714d;
        }

        @Nullable
        public final String m13227j() {
            this.f12715e = super.a(this.f12715e, 1);
            return this.f12715e;
        }

        public final int jK_() {
            return -1840781335;
        }

        public final GraphQLVisitableModel m13225a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m13224a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13227j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f12714d, 0);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13226a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12714d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -603567670)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Operation canceled */
    public final class FetchDonationPaymentMethodsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FundraiserPaymentInfoModel f12724d;

        /* compiled from: Operation canceled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchDonationPaymentMethodsQueryModel.class, new Deserializer());
            }

            public Object m13228a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchDonationPaymentMethodsQueryParser.m13270a(jsonParser);
                Object fetchDonationPaymentMethodsQueryModel = new FetchDonationPaymentMethodsQueryModel();
                ((BaseModel) fetchDonationPaymentMethodsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchDonationPaymentMethodsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchDonationPaymentMethodsQueryModel).a();
                }
                return fetchDonationPaymentMethodsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 461909575)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Operation canceled */
        public final class FundraiserPaymentInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12720d;
            private boolean f12721e;
            private boolean f12722f;
            @Nullable
            private List<MethodsModel> f12723g;

            /* compiled from: Operation canceled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FundraiserPaymentInfoModel.class, new Deserializer());
                }

                public Object m13229a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FundraiserPaymentInfoParser.m13268a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object fundraiserPaymentInfoModel = new FundraiserPaymentInfoModel();
                    ((BaseModel) fundraiserPaymentInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (fundraiserPaymentInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) fundraiserPaymentInfoModel).a();
                    }
                    return fundraiserPaymentInfoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1049957574)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: Operation canceled */
            public final class MethodsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f12716d;
                @Nullable
                private String f12717e;
                @Nullable
                private String f12718f;
                @Nullable
                private GraphQLMobilePaymentOption f12719g;

                /* compiled from: Operation canceled */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MethodsModel.class, new Deserializer());
                    }

                    public Object m13230a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MethodsParser.m13267b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object methodsModel = new MethodsModel();
                        ((BaseModel) methodsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (methodsModel instanceof Postprocessable) {
                            return ((Postprocessable) methodsModel).a();
                        }
                        return methodsModel;
                    }
                }

                /* compiled from: Operation canceled */
                public class Serializer extends JsonSerializer<MethodsModel> {
                    public final void m13231a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MethodsModel methodsModel = (MethodsModel) obj;
                        if (methodsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(methodsModel.m13232a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            methodsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MethodsParser.m13266a(methodsModel.w_(), methodsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MethodsModel.class, new Serializer());
                    }
                }

                public MethodsModel() {
                    super(4);
                }

                @Nullable
                public final String m13234a() {
                    this.f12716d = super.a(this.f12716d, 0);
                    return this.f12716d;
                }

                @Nullable
                public final String m13235j() {
                    this.f12717e = super.a(this.f12717e, 1);
                    return this.f12717e;
                }

                @Nullable
                public final String m13236k() {
                    this.f12718f = super.a(this.f12718f, 2);
                    return this.f12718f;
                }

                @Nullable
                public final GraphQLMobilePaymentOption m13237l() {
                    this.f12719g = (GraphQLMobilePaymentOption) super.b(this.f12719g, 3, GraphQLMobilePaymentOption.class, GraphQLMobilePaymentOption.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f12719g;
                }

                public final int jK_() {
                    return -1490349284;
                }

                public final GraphQLVisitableModel m13233a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m13232a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m13234a());
                    int b2 = flatBufferBuilder.b(m13235j());
                    int b3 = flatBufferBuilder.b(m13236k());
                    int a = flatBufferBuilder.a(m13237l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, b3);
                    flatBufferBuilder.b(3, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: Operation canceled */
            public class Serializer extends JsonSerializer<FundraiserPaymentInfoModel> {
                public final void m13238a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FundraiserPaymentInfoModel fundraiserPaymentInfoModel = (FundraiserPaymentInfoModel) obj;
                    if (fundraiserPaymentInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(fundraiserPaymentInfoModel.m13240a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        fundraiserPaymentInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FundraiserPaymentInfoParser.m13269a(fundraiserPaymentInfoModel.w_(), fundraiserPaymentInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FundraiserPaymentInfoModel.class, new Serializer());
                }
            }

            public FundraiserPaymentInfoModel() {
                super(4);
            }

            @Nullable
            private String m13239j() {
                this.f12720d = super.a(this.f12720d, 0);
                return this.f12720d;
            }

            @Nonnull
            public final ImmutableList<MethodsModel> m13242a() {
                this.f12723g = super.a(this.f12723g, 3, MethodsModel.class);
                return (ImmutableList) this.f12723g;
            }

            public final int jK_() {
                return -1159202391;
            }

            public final GraphQLVisitableModel m13241a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13242a() != null) {
                    Builder a = ModelHelper.a(m13242a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FundraiserPaymentInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12723g = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13240a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13239j());
                int a = ModelHelper.a(flatBufferBuilder, m13242a());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f12721e);
                flatBufferBuilder.a(2, this.f12722f);
                flatBufferBuilder.b(3, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m13243a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12721e = mutableFlatBuffer.a(i, 1);
                this.f12722f = mutableFlatBuffer.a(i, 2);
            }
        }

        /* compiled from: Operation canceled */
        public class Serializer extends JsonSerializer<FetchDonationPaymentMethodsQueryModel> {
            public final void m13244a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchDonationPaymentMethodsQueryModel fetchDonationPaymentMethodsQueryModel = (FetchDonationPaymentMethodsQueryModel) obj;
                if (fetchDonationPaymentMethodsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchDonationPaymentMethodsQueryModel.m13245a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchDonationPaymentMethodsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchDonationPaymentMethodsQueryModel.w_();
                int u_ = fetchDonationPaymentMethodsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("fundraiser_payment_info");
                    FundraiserPaymentInfoParser.m13269a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchDonationPaymentMethodsQueryModel.class, new Serializer());
            }
        }

        public FetchDonationPaymentMethodsQueryModel() {
            super(1);
        }

        @Nullable
        public final FundraiserPaymentInfoModel m13247a() {
            this.f12724d = (FundraiserPaymentInfoModel) super.a(this.f12724d, 0, FundraiserPaymentInfoModel.class);
            return this.f12724d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13246a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13247a() != null) {
                FundraiserPaymentInfoModel fundraiserPaymentInfoModel = (FundraiserPaymentInfoModel) graphQLModelMutatingVisitor.b(m13247a());
                if (m13247a() != fundraiserPaymentInfoModel) {
                    graphQLVisitableModel = (FetchDonationPaymentMethodsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12724d = fundraiserPaymentInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13245a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13247a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 277616884)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Operation canceled */
    public final class FundraiserCampaignFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f12725d;
        @Nullable
        private String f12726e;
        @Nullable
        private CurrencyAmountFieldsModel f12727f;
        @Nullable
        private String f12728g;
        @Nullable
        private String f12729h;
        @Nullable
        private String f12730i;
        @Nullable
        private DefaultImageFieldsModel f12731j;
        @Nullable
        private String f12732k;
        @Nullable
        private CurrencyAmountFieldsModel f12733l;
        @Nullable
        private CurrencyAmountFieldsModel f12734m;
        @Nullable
        private List<CurrencyAmountFieldsModel> f12735n;

        /* compiled from: Operation canceled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserCampaignFragmentModel.class, new Deserializer());
            }

            public Object m13248a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FundraiserCampaignFragmentParser.m13271a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fundraiserCampaignFragmentModel = new FundraiserCampaignFragmentModel();
                ((BaseModel) fundraiserCampaignFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fundraiserCampaignFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserCampaignFragmentModel).a();
                }
                return fundraiserCampaignFragmentModel;
            }
        }

        /* compiled from: Operation canceled */
        public class Serializer extends JsonSerializer<FundraiserCampaignFragmentModel> {
            public final void m13249a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FundraiserCampaignFragmentModel fundraiserCampaignFragmentModel = (FundraiserCampaignFragmentModel) obj;
                if (fundraiserCampaignFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserCampaignFragmentModel.m13254a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserCampaignFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FundraiserCampaignFragmentParser.m13272a(fundraiserCampaignFragmentModel.w_(), fundraiserCampaignFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FundraiserCampaignFragmentModel.class, new Serializer());
            }
        }

        public FundraiserCampaignFragmentModel() {
            super(11);
        }

        @Nullable
        public final String m13256a() {
            this.f12725d = super.a(this.f12725d, 0);
            return this.f12725d;
        }

        @Nullable
        private String m13250p() {
            this.f12726e = super.a(this.f12726e, 1);
            return this.f12726e;
        }

        @Nullable
        public final CurrencyAmountFieldsModel m13257j() {
            this.f12727f = (CurrencyAmountFieldsModel) super.a(this.f12727f, 2, CurrencyAmountFieldsModel.class);
            return this.f12727f;
        }

        @Nullable
        private String m13251q() {
            this.f12728g = super.a(this.f12728g, 3);
            return this.f12728g;
        }

        @Nullable
        public final String m13258k() {
            this.f12729h = super.a(this.f12729h, 4);
            return this.f12729h;
        }

        @Nullable
        private String m13252r() {
            this.f12730i = super.a(this.f12730i, 5);
            return this.f12730i;
        }

        @Nullable
        public final DefaultImageFieldsModel m13259l() {
            this.f12731j = (DefaultImageFieldsModel) super.a(this.f12731j, 6, DefaultImageFieldsModel.class);
            return this.f12731j;
        }

        @Nullable
        private String m13253s() {
            this.f12732k = super.a(this.f12732k, 7);
            return this.f12732k;
        }

        @Nullable
        public final CurrencyAmountFieldsModel m13260m() {
            this.f12733l = (CurrencyAmountFieldsModel) super.a(this.f12733l, 8, CurrencyAmountFieldsModel.class);
            return this.f12733l;
        }

        @Nullable
        public final CurrencyAmountFieldsModel m13261n() {
            this.f12734m = (CurrencyAmountFieldsModel) super.a(this.f12734m, 9, CurrencyAmountFieldsModel.class);
            return this.f12734m;
        }

        @Nonnull
        public final ImmutableList<CurrencyAmountFieldsModel> m13262o() {
            this.f12735n = super.a(this.f12735n, 10, CurrencyAmountFieldsModel.class);
            return (ImmutableList) this.f12735n;
        }

        public final int jK_() {
            return 98695003;
        }

        public final GraphQLVisitableModel m13255a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            CurrencyAmountFieldsModel currencyAmountFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13257j() != null) {
                currencyAmountFieldsModel = (CurrencyAmountFieldsModel) graphQLModelMutatingVisitor.b(m13257j());
                if (m13257j() != currencyAmountFieldsModel) {
                    graphQLVisitableModel = (FundraiserCampaignFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12727f = currencyAmountFieldsModel;
                }
            }
            if (m13259l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m13259l());
                if (m13259l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FundraiserCampaignFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12731j = defaultImageFieldsModel;
                }
            }
            if (m13260m() != null) {
                currencyAmountFieldsModel = (CurrencyAmountFieldsModel) graphQLModelMutatingVisitor.b(m13260m());
                if (m13260m() != currencyAmountFieldsModel) {
                    graphQLVisitableModel = (FundraiserCampaignFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12733l = currencyAmountFieldsModel;
                }
            }
            if (m13261n() != null) {
                currencyAmountFieldsModel = (CurrencyAmountFieldsModel) graphQLModelMutatingVisitor.b(m13261n());
                if (m13261n() != currencyAmountFieldsModel) {
                    graphQLVisitableModel = (FundraiserCampaignFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12734m = currencyAmountFieldsModel;
                }
            }
            if (m13262o() != null) {
                Builder a = ModelHelper.a(m13262o(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FundraiserCampaignFragmentModel fundraiserCampaignFragmentModel = (FundraiserCampaignFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    fundraiserCampaignFragmentModel.f12735n = a.b();
                    graphQLVisitableModel = fundraiserCampaignFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13254a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13256a());
            int b2 = flatBufferBuilder.b(m13250p());
            int a = ModelHelper.a(flatBufferBuilder, m13257j());
            int b3 = flatBufferBuilder.b(m13251q());
            int b4 = flatBufferBuilder.b(m13258k());
            int b5 = flatBufferBuilder.b(m13252r());
            int a2 = ModelHelper.a(flatBufferBuilder, m13259l());
            int b6 = flatBufferBuilder.b(m13253s());
            int a3 = ModelHelper.a(flatBufferBuilder, m13260m());
            int a4 = ModelHelper.a(flatBufferBuilder, m13261n());
            int a5 = ModelHelper.a(flatBufferBuilder, m13262o());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, b4);
            flatBufferBuilder.b(5, b5);
            flatBufferBuilder.b(6, a2);
            flatBufferBuilder.b(7, b6);
            flatBufferBuilder.b(8, a3);
            flatBufferBuilder.b(9, a4);
            flatBufferBuilder.b(10, a5);
            i();
            return flatBufferBuilder.d();
        }
    }
}
