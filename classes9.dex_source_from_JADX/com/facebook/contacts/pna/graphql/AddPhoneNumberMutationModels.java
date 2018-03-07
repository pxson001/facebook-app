package com.facebook.contacts.pna.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.pna.graphql.AddPhoneNumberMutationParsers.UserPhoneNumberAddCoreMutationFragmentParser;
import com.facebook.contacts.pna.graphql.AddPhoneNumberMutationParsers.UserPhoneNumberAddCoreMutationFragmentParser.UserParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
import javax.annotation.Nullable;

/* compiled from: platform_apps/ */
public class AddPhoneNumberMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1485934967)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: platform_apps/ */
    public final class UserPhoneNumberAddCoreMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UserModel f6508d;

        /* compiled from: platform_apps/ */
        public final class Builder {
            @Nullable
            public UserModel f6506a;
        }

        /* compiled from: platform_apps/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UserPhoneNumberAddCoreMutationFragmentModel.class, new Deserializer());
            }

            public Object m6849a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UserPhoneNumberAddCoreMutationFragmentParser.m6864a(jsonParser);
                Object userPhoneNumberAddCoreMutationFragmentModel = new UserPhoneNumberAddCoreMutationFragmentModel();
                ((BaseModel) userPhoneNumberAddCoreMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (userPhoneNumberAddCoreMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) userPhoneNumberAddCoreMutationFragmentModel).a();
                }
                return userPhoneNumberAddCoreMutationFragmentModel;
            }
        }

        /* compiled from: platform_apps/ */
        public class Serializer extends JsonSerializer<UserPhoneNumberAddCoreMutationFragmentModel> {
            public final void m6850a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UserPhoneNumberAddCoreMutationFragmentModel userPhoneNumberAddCoreMutationFragmentModel = (UserPhoneNumberAddCoreMutationFragmentModel) obj;
                if (userPhoneNumberAddCoreMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(userPhoneNumberAddCoreMutationFragmentModel.m6860a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    userPhoneNumberAddCoreMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = userPhoneNumberAddCoreMutationFragmentModel.w_();
                int u_ = userPhoneNumberAddCoreMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("user");
                    UserParser.m6863a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UserPhoneNumberAddCoreMutationFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: platform_apps/ */
        public final class UserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f6507d;

            /* compiled from: platform_apps/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UserModel.class, new Deserializer());
                }

                public Object m6851a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UserParser.m6862a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object userModel = new UserModel();
                    ((BaseModel) userModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (userModel instanceof Postprocessable) {
                        return ((Postprocessable) userModel).a();
                    }
                    return userModel;
                }
            }

            /* compiled from: platform_apps/ */
            public class Serializer extends JsonSerializer<UserModel> {
                public final void m6852a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UserModel userModel = (UserModel) obj;
                    if (userModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(userModel.m6854a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        userModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserParser.m6863a(userModel.w_(), userModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UserModel.class, new Serializer());
                }
            }

            public UserModel() {
                super(1);
            }

            public final void m6857a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m6858a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m6853j() {
                this.f6507d = super.a(this.f6507d, 0);
                return this.f6507d;
            }

            @Nullable
            public final String m6856a() {
                return m6853j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m6855a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6854a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6853j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public UserPhoneNumberAddCoreMutationFragmentModel() {
            super(1);
        }

        public UserPhoneNumberAddCoreMutationFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private UserModel m6859a() {
            this.f6508d = (UserModel) super.a(this.f6508d, 0, UserModel.class);
            return this.f6508d;
        }

        public final int jK_() {
            return 305937848;
        }

        public final GraphQLVisitableModel m6861a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6859a() != null) {
                UserModel userModel = (UserModel) graphQLModelMutatingVisitor.b(m6859a());
                if (m6859a() != userModel) {
                    graphQLVisitableModel = (UserPhoneNumberAddCoreMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6508d = userModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6860a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6859a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
