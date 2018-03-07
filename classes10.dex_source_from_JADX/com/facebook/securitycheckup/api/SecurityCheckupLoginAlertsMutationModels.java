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
import com.facebook.securitycheckup.api.SecurityCheckupLoginAlertsMutationParsers.SecurityCheckupLoginAlertsMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: inbox2 changed */
public class SecurityCheckupLoginAlertsMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: inbox2 changed */
    public final class SecurityCheckupLoginAlertsMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9726d;

        /* compiled from: inbox2 changed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SecurityCheckupLoginAlertsMutationModel.class, new Deserializer());
            }

            public Object m9957a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SecurityCheckupLoginAlertsMutationParser.m9962a(jsonParser);
                Object securityCheckupLoginAlertsMutationModel = new SecurityCheckupLoginAlertsMutationModel();
                ((BaseModel) securityCheckupLoginAlertsMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (securityCheckupLoginAlertsMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) securityCheckupLoginAlertsMutationModel).a();
                }
                return securityCheckupLoginAlertsMutationModel;
            }
        }

        /* compiled from: inbox2 changed */
        public class Serializer extends JsonSerializer<SecurityCheckupLoginAlertsMutationModel> {
            public final void m9958a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SecurityCheckupLoginAlertsMutationModel securityCheckupLoginAlertsMutationModel = (SecurityCheckupLoginAlertsMutationModel) obj;
                if (securityCheckupLoginAlertsMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(securityCheckupLoginAlertsMutationModel.m9960a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    securityCheckupLoginAlertsMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = securityCheckupLoginAlertsMutationModel.w_();
                int u_ = securityCheckupLoginAlertsMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SecurityCheckupLoginAlertsMutationModel.class, new Serializer());
            }
        }

        public SecurityCheckupLoginAlertsMutationModel() {
            super(1);
        }

        @Nullable
        private String m9959a() {
            this.f9726d = super.a(this.f9726d, 0);
            return this.f9726d;
        }

        public final int jK_() {
            return -142363888;
        }

        public final GraphQLVisitableModel m9961a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9960a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9959a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
