package com.facebook.messaging.business.nativesignup.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSendConfirmationCodeOutcome;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpPhoneVerificationMutationsParsers.NativeSignUpConfirmPhoneCodeMutationParser;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpPhoneVerificationMutationsParsers.NativeSignUpSendConfirmationMutationParser;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryModels.PhoneNumberInfoModel;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryParsers.PhoneNumberInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: nativeSignUpCreateAccount */
public class NativeSignUpPhoneVerificationMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1713555362)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nativeSignUpCreateAccount */
    public final class NativeSignUpConfirmPhoneCodeMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PhoneNumberInfoModel f8819d;

        /* compiled from: nativeSignUpCreateAccount */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NativeSignUpConfirmPhoneCodeMutationModel.class, new Deserializer());
            }

            public Object m9042a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NativeSignUpConfirmPhoneCodeMutationParser.m9053a(jsonParser);
                Object nativeSignUpConfirmPhoneCodeMutationModel = new NativeSignUpConfirmPhoneCodeMutationModel();
                ((BaseModel) nativeSignUpConfirmPhoneCodeMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (nativeSignUpConfirmPhoneCodeMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) nativeSignUpConfirmPhoneCodeMutationModel).a();
                }
                return nativeSignUpConfirmPhoneCodeMutationModel;
            }
        }

        /* compiled from: nativeSignUpCreateAccount */
        public class Serializer extends JsonSerializer<NativeSignUpConfirmPhoneCodeMutationModel> {
            public final void m9043a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NativeSignUpConfirmPhoneCodeMutationModel nativeSignUpConfirmPhoneCodeMutationModel = (NativeSignUpConfirmPhoneCodeMutationModel) obj;
                if (nativeSignUpConfirmPhoneCodeMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nativeSignUpConfirmPhoneCodeMutationModel.m9044a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nativeSignUpConfirmPhoneCodeMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = nativeSignUpConfirmPhoneCodeMutationModel.w_();
                int u_ = nativeSignUpConfirmPhoneCodeMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("confirmed_phone_number");
                    PhoneNumberInfoParser.m9142a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NativeSignUpConfirmPhoneCodeMutationModel.class, new Serializer());
            }
        }

        public NativeSignUpConfirmPhoneCodeMutationModel() {
            super(1);
        }

        @Nullable
        public final PhoneNumberInfoModel m9046a() {
            this.f8819d = (PhoneNumberInfoModel) super.a(this.f8819d, 0, PhoneNumberInfoModel.class);
            return this.f8819d;
        }

        public final int jK_() {
            return 1659856594;
        }

        public final GraphQLVisitableModel m9045a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9046a() != null) {
                PhoneNumberInfoModel phoneNumberInfoModel = (PhoneNumberInfoModel) graphQLModelMutatingVisitor.b(m9046a());
                if (m9046a() != phoneNumberInfoModel) {
                    graphQLVisitableModel = (NativeSignUpConfirmPhoneCodeMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8819d = phoneNumberInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9044a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9046a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2101643368)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nativeSignUpCreateAccount */
    public final class NativeSignUpSendConfirmationMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8820d;
        @Nullable
        private GraphQLSendConfirmationCodeOutcome f8821e;

        /* compiled from: nativeSignUpCreateAccount */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NativeSignUpSendConfirmationMutationModel.class, new Deserializer());
            }

            public Object m9047a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NativeSignUpSendConfirmationMutationParser.m9054a(jsonParser);
                Object nativeSignUpSendConfirmationMutationModel = new NativeSignUpSendConfirmationMutationModel();
                ((BaseModel) nativeSignUpSendConfirmationMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (nativeSignUpSendConfirmationMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) nativeSignUpSendConfirmationMutationModel).a();
                }
                return nativeSignUpSendConfirmationMutationModel;
            }
        }

        /* compiled from: nativeSignUpCreateAccount */
        public class Serializer extends JsonSerializer<NativeSignUpSendConfirmationMutationModel> {
            public final void m9048a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NativeSignUpSendConfirmationMutationModel nativeSignUpSendConfirmationMutationModel = (NativeSignUpSendConfirmationMutationModel) obj;
                if (nativeSignUpSendConfirmationMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nativeSignUpSendConfirmationMutationModel.m9049a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nativeSignUpSendConfirmationMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = nativeSignUpSendConfirmationMutationModel.w_();
                int u_ = nativeSignUpSendConfirmationMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("send_confirmation_code_error_message");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("send_confirmation_code_result");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NativeSignUpSendConfirmationMutationModel.class, new Serializer());
            }
        }

        public NativeSignUpSendConfirmationMutationModel() {
            super(2);
        }

        @Nullable
        public final String m9051a() {
            this.f8820d = super.a(this.f8820d, 0);
            return this.f8820d;
        }

        @Nullable
        public final GraphQLSendConfirmationCodeOutcome m9052j() {
            this.f8821e = (GraphQLSendConfirmationCodeOutcome) super.b(this.f8821e, 1, GraphQLSendConfirmationCodeOutcome.class, GraphQLSendConfirmationCodeOutcome.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8821e;
        }

        public final int jK_() {
            return 1591638307;
        }

        public final GraphQLVisitableModel m9050a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9049a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9051a());
            int a = flatBufferBuilder.a(m9052j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
