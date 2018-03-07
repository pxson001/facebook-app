package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingLocationFeedbackMutationsParsers.CrowdsourcingUnknownRegionClaimParser;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingLocationFeedbackMutationsParsers.CrowdsourcingWrongRegionReportParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: tap_header */
public class CrowdsourcingLocationFeedbackMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tap_header */
    public final class CrowdsourcingUnknownRegionClaimModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2309d;

        /* compiled from: tap_header */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcingUnknownRegionClaimModel.class, new Deserializer());
            }

            public Object m2246a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrowdsourcingUnknownRegionClaimParser.m2256a(jsonParser);
                Object crowdsourcingUnknownRegionClaimModel = new CrowdsourcingUnknownRegionClaimModel();
                ((BaseModel) crowdsourcingUnknownRegionClaimModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crowdsourcingUnknownRegionClaimModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcingUnknownRegionClaimModel).a();
                }
                return crowdsourcingUnknownRegionClaimModel;
            }
        }

        /* compiled from: tap_header */
        public class Serializer extends JsonSerializer<CrowdsourcingUnknownRegionClaimModel> {
            public final void m2247a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrowdsourcingUnknownRegionClaimModel crowdsourcingUnknownRegionClaimModel = (CrowdsourcingUnknownRegionClaimModel) obj;
                if (crowdsourcingUnknownRegionClaimModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcingUnknownRegionClaimModel.m2249a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcingUnknownRegionClaimModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crowdsourcingUnknownRegionClaimModel.w_();
                int u_ = crowdsourcingUnknownRegionClaimModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrowdsourcingUnknownRegionClaimModel.class, new Serializer());
            }
        }

        public CrowdsourcingUnknownRegionClaimModel() {
            super(1);
        }

        @Nullable
        private String m2248a() {
            this.f2309d = super.a(this.f2309d, 0);
            return this.f2309d;
        }

        public final int jK_() {
            return -2023573806;
        }

        public final GraphQLVisitableModel m2250a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2249a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2248a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tap_header */
    public final class CrowdsourcingWrongRegionReportModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2310d;

        /* compiled from: tap_header */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcingWrongRegionReportModel.class, new Deserializer());
            }

            public Object m2251a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrowdsourcingWrongRegionReportParser.m2257a(jsonParser);
                Object crowdsourcingWrongRegionReportModel = new CrowdsourcingWrongRegionReportModel();
                ((BaseModel) crowdsourcingWrongRegionReportModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crowdsourcingWrongRegionReportModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcingWrongRegionReportModel).a();
                }
                return crowdsourcingWrongRegionReportModel;
            }
        }

        /* compiled from: tap_header */
        public class Serializer extends JsonSerializer<CrowdsourcingWrongRegionReportModel> {
            public final void m2252a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrowdsourcingWrongRegionReportModel crowdsourcingWrongRegionReportModel = (CrowdsourcingWrongRegionReportModel) obj;
                if (crowdsourcingWrongRegionReportModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcingWrongRegionReportModel.m2254a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcingWrongRegionReportModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crowdsourcingWrongRegionReportModel.w_();
                int u_ = crowdsourcingWrongRegionReportModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrowdsourcingWrongRegionReportModel.class, new Serializer());
            }
        }

        public CrowdsourcingWrongRegionReportModel() {
            super(1);
        }

        @Nullable
        private String m2253a() {
            this.f2310d = super.a(this.f2310d, 0);
            return this.f2310d;
        }

        public final int jK_() {
            return 584930389;
        }

        public final GraphQLVisitableModel m2255a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2254a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2253a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
