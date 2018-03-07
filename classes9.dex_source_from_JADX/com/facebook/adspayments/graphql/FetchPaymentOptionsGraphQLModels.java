package com.facebook.adspayments.graphql;

import com.facebook.adspayments.graphql.FetchPaymentOptionsGraphQLParsers.FetchPaymentOptionsQueryParser;
import com.facebook.adspayments.graphql.FetchPaymentOptionsGraphQLParsers.FetchPaymentOptionsQueryParser.SupportedPaymentOptionsParser;
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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: UberbarLocalResultsFetch */
public class FetchPaymentOptionsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 899201471)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: UberbarLocalResultsFetch */
    public final class FetchPaymentOptionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SupportedPaymentOptionsModel f23678d;

        /* compiled from: UberbarLocalResultsFetch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPaymentOptionsQueryModel.class, new Deserializer());
            }

            public Object m25671a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPaymentOptionsQueryParser.m25683a(jsonParser);
                Object fetchPaymentOptionsQueryModel = new FetchPaymentOptionsQueryModel();
                ((BaseModel) fetchPaymentOptionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPaymentOptionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPaymentOptionsQueryModel).a();
                }
                return fetchPaymentOptionsQueryModel;
            }
        }

        /* compiled from: UberbarLocalResultsFetch */
        public class Serializer extends JsonSerializer<FetchPaymentOptionsQueryModel> {
            public final void m25672a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPaymentOptionsQueryModel fetchPaymentOptionsQueryModel = (FetchPaymentOptionsQueryModel) obj;
                if (fetchPaymentOptionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPaymentOptionsQueryModel.m25678a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPaymentOptionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPaymentOptionsQueryModel.w_();
                int u_ = fetchPaymentOptionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("supported_payment_options");
                    SupportedPaymentOptionsParser.m25682a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPaymentOptionsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1950664046)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: UberbarLocalResultsFetch */
        public final class SupportedPaymentOptionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<GraphQLMobilePaymentOption> f23677d;

            /* compiled from: UberbarLocalResultsFetch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SupportedPaymentOptionsModel.class, new Deserializer());
                }

                public Object m25673a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SupportedPaymentOptionsParser.m25681a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object supportedPaymentOptionsModel = new SupportedPaymentOptionsModel();
                    ((BaseModel) supportedPaymentOptionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (supportedPaymentOptionsModel instanceof Postprocessable) {
                        return ((Postprocessable) supportedPaymentOptionsModel).a();
                    }
                    return supportedPaymentOptionsModel;
                }
            }

            /* compiled from: UberbarLocalResultsFetch */
            public class Serializer extends JsonSerializer<SupportedPaymentOptionsModel> {
                public final void m25674a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SupportedPaymentOptionsModel supportedPaymentOptionsModel = (SupportedPaymentOptionsModel) obj;
                    if (supportedPaymentOptionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(supportedPaymentOptionsModel.m25675a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        supportedPaymentOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SupportedPaymentOptionsParser.m25682a(supportedPaymentOptionsModel.w_(), supportedPaymentOptionsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SupportedPaymentOptionsModel.class, new Serializer());
                }
            }

            public SupportedPaymentOptionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<GraphQLMobilePaymentOption> m25677a() {
                this.f23677d = super.c(this.f23677d, 0, GraphQLMobilePaymentOption.class);
                return (ImmutableList) this.f23677d;
            }

            public final int jK_() {
                return 2011132630;
            }

            public final GraphQLVisitableModel m25676a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25675a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int d = flatBufferBuilder.d(m25677a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, d);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchPaymentOptionsQueryModel() {
            super(1);
        }

        @Nullable
        public final SupportedPaymentOptionsModel m25679a() {
            this.f23678d = (SupportedPaymentOptionsModel) super.a(this.f23678d, 0, SupportedPaymentOptionsModel.class);
            return this.f23678d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m25680a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25679a() != null) {
                SupportedPaymentOptionsModel supportedPaymentOptionsModel = (SupportedPaymentOptionsModel) graphQLModelMutatingVisitor.b(m25679a());
                if (m25679a() != supportedPaymentOptionsModel) {
                    graphQLVisitableModel = (FetchPaymentOptionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f23678d = supportedPaymentOptionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25678a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25679a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
