package com.facebook.securitycheckup.api;

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
import com.facebook.securitycheckup.api.EndSessionsMutationParsers.EndSessionsMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: inbox_filter_change */
public class EndSessionsMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: inbox_filter_change */
    public final class EndSessionsMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9723d;

        /* compiled from: inbox_filter_change */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EndSessionsMutationModel.class, new Deserializer());
            }

            public Object m9936a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EndSessionsMutationParser.m9941a(jsonParser);
                Object endSessionsMutationModel = new EndSessionsMutationModel();
                ((BaseModel) endSessionsMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (endSessionsMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) endSessionsMutationModel).a();
                }
                return endSessionsMutationModel;
            }
        }

        /* compiled from: inbox_filter_change */
        public class Serializer extends JsonSerializer<EndSessionsMutationModel> {
            public final void m9937a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EndSessionsMutationModel endSessionsMutationModel = (EndSessionsMutationModel) obj;
                if (endSessionsMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(endSessionsMutationModel.m9939a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    endSessionsMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = endSessionsMutationModel.w_();
                int u_ = endSessionsMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EndSessionsMutationModel.class, new Serializer());
            }
        }

        public EndSessionsMutationModel() {
            super(1);
        }

        @Nullable
        private String m9938a() {
            this.f9723d = super.a(this.f9723d, 0);
            return this.f9723d;
        }

        public final int jK_() {
            return -522819467;
        }

        public final GraphQLVisitableModel m9940a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9939a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9938a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
