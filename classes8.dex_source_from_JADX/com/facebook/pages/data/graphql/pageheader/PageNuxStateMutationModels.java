package com.facebook.pages.data.graphql.pageheader;

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
import com.facebook.pages.data.graphql.pageheader.PageNuxStateMutationParsers.NotifyPageNuxShownMutationParser;
import com.facebook.pages.data.graphql.pageheader.PageNuxStateMutationParsers.NotifyPageNuxShownMutationParser.UserParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: confirmation_change_contactpoint_attempt */
public class PageNuxStateMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1255398909)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_attempt */
    public final class NotifyPageNuxShownMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UserModel f17303d;

        /* compiled from: confirmation_change_contactpoint_attempt */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NotifyPageNuxShownMutationModel.class, new Deserializer());
            }

            public Object m21308a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NotifyPageNuxShownMutationParser.m21323a(jsonParser);
                Object notifyPageNuxShownMutationModel = new NotifyPageNuxShownMutationModel();
                ((BaseModel) notifyPageNuxShownMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (notifyPageNuxShownMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) notifyPageNuxShownMutationModel).a();
                }
                return notifyPageNuxShownMutationModel;
            }
        }

        /* compiled from: confirmation_change_contactpoint_attempt */
        public class Serializer extends JsonSerializer<NotifyPageNuxShownMutationModel> {
            public final void m21309a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NotifyPageNuxShownMutationModel notifyPageNuxShownMutationModel = (NotifyPageNuxShownMutationModel) obj;
                if (notifyPageNuxShownMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(notifyPageNuxShownMutationModel.m21319a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    notifyPageNuxShownMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = notifyPageNuxShownMutationModel.w_();
                int u_ = notifyPageNuxShownMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("user");
                    UserParser.m21322a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NotifyPageNuxShownMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_attempt */
        public final class UserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f17302d;

            /* compiled from: confirmation_change_contactpoint_attempt */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UserModel.class, new Deserializer());
                }

                public Object m21310a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UserParser.m21321a(jsonParser, flatBufferBuilder));
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

            /* compiled from: confirmation_change_contactpoint_attempt */
            public class Serializer extends JsonSerializer<UserModel> {
                public final void m21311a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UserModel userModel = (UserModel) obj;
                    if (userModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(userModel.m21313a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        userModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserParser.m21322a(userModel.w_(), userModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UserModel.class, new Serializer());
                }
            }

            public UserModel() {
                super(1);
            }

            public final void m21316a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m21317a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m21312j() {
                this.f17302d = super.a(this.f17302d, 0);
                return this.f17302d;
            }

            @Nullable
            public final String m21315a() {
                return m21312j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m21314a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m21313a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m21312j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public NotifyPageNuxShownMutationModel() {
            super(1);
        }

        @Nullable
        private UserModel m21318a() {
            this.f17303d = (UserModel) super.a(this.f17303d, 0, UserModel.class);
            return this.f17303d;
        }

        public final int jK_() {
            return -1429170891;
        }

        public final GraphQLVisitableModel m21320a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m21318a() != null) {
                UserModel userModel = (UserModel) graphQLModelMutatingVisitor.b(m21318a());
                if (m21318a() != userModel) {
                    graphQLVisitableModel = (NotifyPageNuxShownMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17303d = userModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m21319a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m21318a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
