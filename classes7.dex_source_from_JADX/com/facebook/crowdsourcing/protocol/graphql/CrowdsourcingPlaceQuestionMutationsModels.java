package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionMutationsParsers.CrowdsourcingPlaceQuestionAnswerSubmitParser;
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

/* compiled from: tap_feed_inline_comment */
public class CrowdsourcingPlaceQuestionMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tap_feed_inline_comment */
    public final class CrowdsourcingPlaceQuestionAnswerSubmitModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2311d;

        /* compiled from: tap_feed_inline_comment */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcingPlaceQuestionAnswerSubmitModel.class, new Deserializer());
            }

            public Object m2259a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrowdsourcingPlaceQuestionAnswerSubmitParser.m2264a(jsonParser);
                Object crowdsourcingPlaceQuestionAnswerSubmitModel = new CrowdsourcingPlaceQuestionAnswerSubmitModel();
                ((BaseModel) crowdsourcingPlaceQuestionAnswerSubmitModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crowdsourcingPlaceQuestionAnswerSubmitModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcingPlaceQuestionAnswerSubmitModel).a();
                }
                return crowdsourcingPlaceQuestionAnswerSubmitModel;
            }
        }

        /* compiled from: tap_feed_inline_comment */
        public class Serializer extends JsonSerializer<CrowdsourcingPlaceQuestionAnswerSubmitModel> {
            public final void m2260a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrowdsourcingPlaceQuestionAnswerSubmitModel crowdsourcingPlaceQuestionAnswerSubmitModel = (CrowdsourcingPlaceQuestionAnswerSubmitModel) obj;
                if (crowdsourcingPlaceQuestionAnswerSubmitModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcingPlaceQuestionAnswerSubmitModel.m2262a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcingPlaceQuestionAnswerSubmitModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crowdsourcingPlaceQuestionAnswerSubmitModel.w_();
                int u_ = crowdsourcingPlaceQuestionAnswerSubmitModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrowdsourcingPlaceQuestionAnswerSubmitModel.class, new Serializer());
            }
        }

        public CrowdsourcingPlaceQuestionAnswerSubmitModel() {
            super(1);
        }

        @Nullable
        private String m2261a() {
            this.f2311d = super.a(this.f2311d, 0);
            return this.f2311d;
        }

        public final int jK_() {
            return -2061765713;
        }

        public final GraphQLVisitableModel m2263a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2262a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2261a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
