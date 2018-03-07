package com.facebook.facecast.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.facecast.protocol.FetchPageCommercialBreakEligibilityQueryParsers.FetchPageCommercialBreakEligibilityQueryParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;

/* compiled from: backCamera */
public class FetchPageCommercialBreakEligibilityQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 256987437)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: backCamera */
    public final class FetchPageCommercialBreakEligibilityQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        private boolean f18798d;

        /* compiled from: backCamera */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPageCommercialBreakEligibilityQueryModel.class, new Deserializer());
            }

            public Object m22392a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPageCommercialBreakEligibilityQueryParser.m22400a(jsonParser);
                Object fetchPageCommercialBreakEligibilityQueryModel = new FetchPageCommercialBreakEligibilityQueryModel();
                ((BaseModel) fetchPageCommercialBreakEligibilityQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPageCommercialBreakEligibilityQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPageCommercialBreakEligibilityQueryModel).a();
                }
                return fetchPageCommercialBreakEligibilityQueryModel;
            }
        }

        /* compiled from: backCamera */
        public class Serializer extends JsonSerializer<FetchPageCommercialBreakEligibilityQueryModel> {
            public final void m22393a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPageCommercialBreakEligibilityQueryModel fetchPageCommercialBreakEligibilityQueryModel = (FetchPageCommercialBreakEligibilityQueryModel) obj;
                if (fetchPageCommercialBreakEligibilityQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPageCommercialBreakEligibilityQueryModel.m22394a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPageCommercialBreakEligibilityQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPageCommercialBreakEligibilityQueryModel.w_();
                int u_ = fetchPageCommercialBreakEligibilityQueryModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("is_eligible_for_commercial_break");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPageCommercialBreakEligibilityQueryModel.class, new Serializer());
            }
        }

        public FetchPageCommercialBreakEligibilityQueryModel() {
            super(1);
        }

        public final void m22397a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m22398a(String str, Object obj, boolean z) {
        }

        public final boolean m22399a() {
            a(0, 0);
            return this.f18798d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m22395a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m22394a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f18798d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m22396a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f18798d = mutableFlatBuffer.a(i, 0);
        }
    }
}
