package com.facebook.auth.protocol;

import com.facebook.auth.protocol.LoginApprovalMutationParsers.LoginApprovalMutationParser;
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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;

/* compiled from: suggestion_mechanisms */
public class LoginApprovalMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -834406470)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggestion_mechanisms */
    public final class LoginApprovalMutationModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f2360d;

        /* compiled from: suggestion_mechanisms */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LoginApprovalMutationModel.class, new Deserializer());
            }

            public Object m3238a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LoginApprovalMutationParser.m3243a(jsonParser);
                Object loginApprovalMutationModel = new LoginApprovalMutationModel();
                ((BaseModel) loginApprovalMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (loginApprovalMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) loginApprovalMutationModel).a();
                }
                return loginApprovalMutationModel;
            }
        }

        /* compiled from: suggestion_mechanisms */
        public class Serializer extends JsonSerializer<LoginApprovalMutationModel> {
            public final void m3239a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LoginApprovalMutationModel loginApprovalMutationModel = (LoginApprovalMutationModel) obj;
                if (loginApprovalMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(loginApprovalMutationModel.m3240a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    loginApprovalMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = loginApprovalMutationModel.w_();
                int u_ = loginApprovalMutationModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("is_approved");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LoginApprovalMutationModel.class, new Serializer());
            }
        }

        public LoginApprovalMutationModel() {
            super(1);
        }

        public final int jK_() {
            return 1921271084;
        }

        public final GraphQLVisitableModel m3241a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3240a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f2360d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3242a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2360d = mutableFlatBuffer.a(i, 0);
        }
    }
}
