package com.facebook.messaging.users.username.graphql;

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
import com.facebook.messaging.users.username.graphql.EditUsernameMutationParsers.EditUsernameMutationFieldsParser;
import com.facebook.messaging.users.username.graphql.EditUsernameMutationParsers.EditUsernameMutationFieldsParser.UserParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: pickup */
public class EditUsernameMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2021359183)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: pickup */
    public final class EditUsernameMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UserModel f4919d;

        /* compiled from: pickup */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EditUsernameMutationFieldsModel.class, new Deserializer());
            }

            public Object m4457a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EditUsernameMutationFieldsParser.m4474a(jsonParser);
                Object editUsernameMutationFieldsModel = new EditUsernameMutationFieldsModel();
                ((BaseModel) editUsernameMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (editUsernameMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) editUsernameMutationFieldsModel).a();
                }
                return editUsernameMutationFieldsModel;
            }
        }

        /* compiled from: pickup */
        public class Serializer extends JsonSerializer<EditUsernameMutationFieldsModel> {
            public final void m4458a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EditUsernameMutationFieldsModel editUsernameMutationFieldsModel = (EditUsernameMutationFieldsModel) obj;
                if (editUsernameMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(editUsernameMutationFieldsModel.m4470a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    editUsernameMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = editUsernameMutationFieldsModel.w_();
                int u_ = editUsernameMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("user");
                    UserParser.m4473a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EditUsernameMutationFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2473142)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: pickup */
        public final class UserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f4917d;
            @Nullable
            private String f4918e;

            /* compiled from: pickup */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UserModel.class, new Deserializer());
                }

                public Object m4459a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UserParser.m4472a(jsonParser, flatBufferBuilder));
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

            /* compiled from: pickup */
            public class Serializer extends JsonSerializer<UserModel> {
                public final void m4460a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UserModel userModel = (UserModel) obj;
                    if (userModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(userModel.m4464a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        userModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserParser.m4473a(userModel.w_(), userModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UserModel.class, new Serializer());
                }
            }

            public UserModel() {
                super(2);
            }

            public final void m4467a(String str, ConsistencyTuple consistencyTuple) {
                if ("username".equals(str)) {
                    consistencyTuple.a = m4463k();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m4468a(String str, Object obj, boolean z) {
                if ("username".equals(str)) {
                    m4461a((String) obj);
                }
            }

            @Nullable
            private String m4462j() {
                this.f4917d = super.a(this.f4917d, 0);
                return this.f4917d;
            }

            @Nullable
            private String m4463k() {
                this.f4918e = super.a(this.f4918e, 1);
                return this.f4918e;
            }

            private void m4461a(@Nullable String str) {
                this.f4918e = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, str);
                }
            }

            @Nullable
            public final String m4466a() {
                return m4462j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m4465a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m4464a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m4462j());
                int b2 = flatBufferBuilder.b(m4463k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public EditUsernameMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private UserModel m4469a() {
            this.f4919d = (UserModel) super.a(this.f4919d, 0, UserModel.class);
            return this.f4919d;
        }

        public final int jK_() {
            return 1616022620;
        }

        public final GraphQLVisitableModel m4471a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4469a() != null) {
                UserModel userModel = (UserModel) graphQLModelMutatingVisitor.b(m4469a());
                if (m4469a() != userModel) {
                    graphQLVisitableModel = (EditUsernameMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4919d = userModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4470a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4469a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
