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
import com.facebook.securitycheckup.api.SecurityCheckupLoggingMutationParsers.SecurityCheckupLoggingMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: inbox2_huc_dialog */
public class SecurityCheckupLoggingMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: inbox2_huc_dialog */
    public final class SecurityCheckupLoggingMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9725d;

        /* compiled from: inbox2_huc_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SecurityCheckupLoggingMutationModel.class, new Deserializer());
            }

            public Object m9950a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SecurityCheckupLoggingMutationParser.m9955a(jsonParser);
                Object securityCheckupLoggingMutationModel = new SecurityCheckupLoggingMutationModel();
                ((BaseModel) securityCheckupLoggingMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (securityCheckupLoggingMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) securityCheckupLoggingMutationModel).a();
                }
                return securityCheckupLoggingMutationModel;
            }
        }

        /* compiled from: inbox2_huc_dialog */
        public class Serializer extends JsonSerializer<SecurityCheckupLoggingMutationModel> {
            public final void m9951a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SecurityCheckupLoggingMutationModel securityCheckupLoggingMutationModel = (SecurityCheckupLoggingMutationModel) obj;
                if (securityCheckupLoggingMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(securityCheckupLoggingMutationModel.m9953a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    securityCheckupLoggingMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = securityCheckupLoggingMutationModel.w_();
                int u_ = securityCheckupLoggingMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SecurityCheckupLoggingMutationModel.class, new Serializer());
            }
        }

        public SecurityCheckupLoggingMutationModel() {
            super(1);
        }

        @Nullable
        private String m9952a() {
            this.f9725d = super.a(this.f9725d, 0);
            return this.f9725d;
        }

        public final int jK_() {
            return -1723117903;
        }

        public final GraphQLVisitableModel m9954a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9953a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9952a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
