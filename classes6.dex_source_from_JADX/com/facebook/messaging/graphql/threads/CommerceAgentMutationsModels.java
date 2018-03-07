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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.graphql.threads.CommerceAgentMutationsParsers.AgentThreadStartMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: video_download_aborted */
public class CommerceAgentMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -183407208)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_download_aborted */
    public final class AgentThreadStartMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f813d;
        @Nullable
        private String f814e;

        /* compiled from: video_download_aborted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AgentThreadStartMutationModel.class, new Deserializer());
            }

            public Object m956a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AgentThreadStartMutationParser.m962a(jsonParser);
                Object agentThreadStartMutationModel = new AgentThreadStartMutationModel();
                ((BaseModel) agentThreadStartMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (agentThreadStartMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) agentThreadStartMutationModel).a();
                }
                return agentThreadStartMutationModel;
            }
        }

        /* compiled from: video_download_aborted */
        public class Serializer extends JsonSerializer<AgentThreadStartMutationModel> {
            public final void m957a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AgentThreadStartMutationModel agentThreadStartMutationModel = (AgentThreadStartMutationModel) obj;
                if (agentThreadStartMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(agentThreadStartMutationModel.m960a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    agentThreadStartMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = agentThreadStartMutationModel.w_();
                int u_ = agentThreadStartMutationModel.u_();
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
                FbSerializerProvider.a(AgentThreadStartMutationModel.class, new Serializer());
            }
        }

        public AgentThreadStartMutationModel() {
            super(2);
        }

        @Nullable
        private String m958a() {
            this.f813d = super.a(this.f813d, 0);
            return this.f813d;
        }

        @Nullable
        private String m959j() {
            this.f814e = super.a(this.f814e, 1);
            return this.f814e;
        }

        public final int jK_() {
            return -1510870726;
        }

        public final GraphQLVisitableModel m961a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m960a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m958a());
            int b2 = flatBufferBuilder.b(m959j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
