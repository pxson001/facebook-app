package com.facebook.registration.protocol;

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
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.registration.protocol.UserInfoMutationsParsers.UserUpdateGenderCoreMutationFieldsParser;
import com.facebook.registration.protocol.UserInfoMutationsParsers.UserUpdateGenderCoreMutationFieldsParser.UserParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: joinable_exposure */
public class UserInfoMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1343474220)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: joinable_exposure */
    public final class UserUpdateGenderCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UserModel f8926d;

        /* compiled from: joinable_exposure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UserUpdateGenderCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m8910a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UserUpdateGenderCoreMutationFieldsParser.m8925a(jsonParser);
                Object userUpdateGenderCoreMutationFieldsModel = new UserUpdateGenderCoreMutationFieldsModel();
                ((BaseModel) userUpdateGenderCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (userUpdateGenderCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) userUpdateGenderCoreMutationFieldsModel).a();
                }
                return userUpdateGenderCoreMutationFieldsModel;
            }
        }

        /* compiled from: joinable_exposure */
        public class Serializer extends JsonSerializer<UserUpdateGenderCoreMutationFieldsModel> {
            public final void m8911a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UserUpdateGenderCoreMutationFieldsModel userUpdateGenderCoreMutationFieldsModel = (UserUpdateGenderCoreMutationFieldsModel) obj;
                if (userUpdateGenderCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(userUpdateGenderCoreMutationFieldsModel.m8921a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    userUpdateGenderCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = userUpdateGenderCoreMutationFieldsModel.w_();
                int u_ = userUpdateGenderCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("user");
                    UserParser.m8924a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UserUpdateGenderCoreMutationFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: joinable_exposure */
        public final class UserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f8925d;

            /* compiled from: joinable_exposure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UserModel.class, new Deserializer());
                }

                public Object m8912a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UserParser.m8923a(jsonParser, flatBufferBuilder));
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

            /* compiled from: joinable_exposure */
            public class Serializer extends JsonSerializer<UserModel> {
                public final void m8913a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UserModel userModel = (UserModel) obj;
                    if (userModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(userModel.m8915a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        userModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserParser.m8924a(userModel.w_(), userModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UserModel.class, new Serializer());
                }
            }

            public UserModel() {
                super(1);
            }

            public final void m8918a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m8919a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m8914j() {
                this.f8925d = super.a(this.f8925d, 0);
                return this.f8925d;
            }

            @Nullable
            public final String m8917a() {
                return m8914j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m8916a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m8915a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8914j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public UserUpdateGenderCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private UserModel m8920a() {
            this.f8926d = (UserModel) super.a(this.f8926d, 0, UserModel.class);
            return this.f8926d;
        }

        public final int jK_() {
            return 2023071960;
        }

        public final GraphQLVisitableModel m8922a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8920a() != null) {
                UserModel userModel = (UserModel) graphQLModelMutatingVisitor.b(m8920a());
                if (m8920a() != userModel) {
                    graphQLVisitableModel = (UserUpdateGenderCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8926d = userModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8921a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8920a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
