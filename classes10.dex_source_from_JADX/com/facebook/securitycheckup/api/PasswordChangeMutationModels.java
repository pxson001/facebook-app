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
import com.facebook.securitycheckup.api.PasswordChangeMutationParsers.PasswordChangeMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: inbox_banner_clicked */
public class PasswordChangeMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: inbox_banner_clicked */
    public final class PasswordChangeMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9724d;

        /* compiled from: inbox_banner_clicked */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PasswordChangeMutationModel.class, new Deserializer());
            }

            public Object m9943a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PasswordChangeMutationParser.m9948a(jsonParser);
                Object passwordChangeMutationModel = new PasswordChangeMutationModel();
                ((BaseModel) passwordChangeMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (passwordChangeMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) passwordChangeMutationModel).a();
                }
                return passwordChangeMutationModel;
            }
        }

        /* compiled from: inbox_banner_clicked */
        public class Serializer extends JsonSerializer<PasswordChangeMutationModel> {
            public final void m9944a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PasswordChangeMutationModel passwordChangeMutationModel = (PasswordChangeMutationModel) obj;
                if (passwordChangeMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(passwordChangeMutationModel.m9946a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    passwordChangeMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = passwordChangeMutationModel.w_();
                int u_ = passwordChangeMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PasswordChangeMutationModel.class, new Serializer());
            }
        }

        public PasswordChangeMutationModel() {
            super(1);
        }

        @Nullable
        private String m9945a() {
            this.f9724d = super.a(this.f9724d, 0);
            return this.f9724d;
        }

        public final int jK_() {
            return -7185342;
        }

        public final GraphQLVisitableModel m9947a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9946a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9945a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
