package com.facebook.zero.onboarding.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.zero.onboarding.graphql.AssistedOnboardingParsers.AssistedRegSendInviteWithSourceParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: minutiae_preview_removed */
public class AssistedOnboardingModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -183407208)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: minutiae_preview_removed */
    public final class AssistedRegSendInviteWithSourceModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f5387d;
        @Nullable
        private String f5388e;

        /* compiled from: minutiae_preview_removed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AssistedRegSendInviteWithSourceModel.class, new Deserializer());
            }

            public Object m6617a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AssistedRegSendInviteWithSourceParser.m6623a(jsonParser);
                Object assistedRegSendInviteWithSourceModel = new AssistedRegSendInviteWithSourceModel();
                ((BaseModel) assistedRegSendInviteWithSourceModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (assistedRegSendInviteWithSourceModel instanceof Postprocessable) {
                    return ((Postprocessable) assistedRegSendInviteWithSourceModel).a();
                }
                return assistedRegSendInviteWithSourceModel;
            }
        }

        /* compiled from: minutiae_preview_removed */
        public class Serializer extends JsonSerializer<AssistedRegSendInviteWithSourceModel> {
            public final void m6618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AssistedRegSendInviteWithSourceModel assistedRegSendInviteWithSourceModel = (AssistedRegSendInviteWithSourceModel) obj;
                if (assistedRegSendInviteWithSourceModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(assistedRegSendInviteWithSourceModel.m6621a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    assistedRegSendInviteWithSourceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = assistedRegSendInviteWithSourceModel.w_();
                int u_ = assistedRegSendInviteWithSourceModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("client_subscription_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AssistedRegSendInviteWithSourceModel.class, new Serializer());
            }
        }

        public AssistedRegSendInviteWithSourceModel() {
            super(2);
        }

        @Nullable
        private String m6619a() {
            this.f5387d = super.a(this.f5387d, 0);
            return this.f5387d;
        }

        @Nullable
        private String m6620j() {
            this.f5388e = super.a(this.f5388e, 1);
            return this.f5388e;
        }

        public final int jK_() {
            return -895971985;
        }

        public final GraphQLVisitableModel m6622a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6621a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6619a());
            int b2 = flatBufferBuilder.b(m6620j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
