package com.facebook.backstage.graphql;

import com.facebook.backstage.graphql.FBBackstageMutationFragmentsParsers.FBBackstageClearBadgeMutationParser;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsParsers.FBBackstagePostsDeleteMutationFragmentParser;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsParsers.FBBackstageSeenStateMutationFragmentParser;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsParsers.FBBackstageUpdateAudienceModeMutationParser;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsParsers.FBBackstageUpdateAudienceModeMutationParser.UserParser;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsParsers.UpdateWhiteListMutationParser;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsParsers.UpdateWhiteListMutationParser.UserParser.BackstageWhitelistedFriendsParser;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsParsers.UpdateWhiteListMutationParser.UserParser.BackstageWhitelistedFriendsParser.NodesParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: requesteeFbId */
public class FBBackstageMutationFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -183407208)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: requesteeFbId */
    public final class FBBackstageClearBadgeMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f5243d;
        @Nullable
        private String f5244e;

        /* compiled from: requesteeFbId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBBackstageClearBadgeMutationModel.class, new Deserializer());
            }

            public Object m4994a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBBackstageClearBadgeMutationParser.m5051a(jsonParser);
                Object fBBackstageClearBadgeMutationModel = new FBBackstageClearBadgeMutationModel();
                ((BaseModel) fBBackstageClearBadgeMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBBackstageClearBadgeMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) fBBackstageClearBadgeMutationModel).a();
                }
                return fBBackstageClearBadgeMutationModel;
            }
        }

        /* compiled from: requesteeFbId */
        public class Serializer extends JsonSerializer<FBBackstageClearBadgeMutationModel> {
            public final void m4995a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBBackstageClearBadgeMutationModel fBBackstageClearBadgeMutationModel = (FBBackstageClearBadgeMutationModel) obj;
                if (fBBackstageClearBadgeMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBBackstageClearBadgeMutationModel.m4998a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBBackstageClearBadgeMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBBackstageClearBadgeMutationModel.w_();
                int u_ = fBBackstageClearBadgeMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("client_subscription_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBBackstageClearBadgeMutationModel.class, new Serializer());
            }
        }

        public FBBackstageClearBadgeMutationModel() {
            super(2);
        }

        @Nullable
        private String m4996a() {
            this.f5243d = super.a(this.f5243d, 0);
            return this.f5243d;
        }

        @Nullable
        private String m4997j() {
            this.f5244e = super.a(this.f5244e, 1);
            return this.f5244e;
        }

        public final int jK_() {
            return 17056589;
        }

        public final GraphQLVisitableModel m4999a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m4998a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m4996a());
            int b2 = flatBufferBuilder.b(m4997j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1017655868)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: requesteeFbId */
    public final class FBBackstagePostsDeleteMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<String> f5245d;

        /* compiled from: requesteeFbId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBBackstagePostsDeleteMutationFragmentModel.class, new Deserializer());
            }

            public Object m5000a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBBackstagePostsDeleteMutationFragmentParser.m5052a(jsonParser);
                Object fBBackstagePostsDeleteMutationFragmentModel = new FBBackstagePostsDeleteMutationFragmentModel();
                ((BaseModel) fBBackstagePostsDeleteMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBBackstagePostsDeleteMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBBackstagePostsDeleteMutationFragmentModel).a();
                }
                return fBBackstagePostsDeleteMutationFragmentModel;
            }
        }

        /* compiled from: requesteeFbId */
        public class Serializer extends JsonSerializer<FBBackstagePostsDeleteMutationFragmentModel> {
            public final void m5001a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBBackstagePostsDeleteMutationFragmentModel fBBackstagePostsDeleteMutationFragmentModel = (FBBackstagePostsDeleteMutationFragmentModel) obj;
                if (fBBackstagePostsDeleteMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBBackstagePostsDeleteMutationFragmentModel.m5002a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBBackstagePostsDeleteMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBBackstagePostsDeleteMutationFragmentModel.w_();
                int u_ = fBBackstagePostsDeleteMutationFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("deleted_post_ids");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 0), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBBackstagePostsDeleteMutationFragmentModel.class, new Serializer());
            }
        }

        public FBBackstagePostsDeleteMutationFragmentModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<String> m5004a() {
            this.f5245d = super.a(this.f5245d, 0);
            return (ImmutableList) this.f5245d;
        }

        public final int jK_() {
            return -1774830970;
        }

        public final GraphQLVisitableModel m5003a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m5002a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m5004a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, c);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -183407208)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: requesteeFbId */
    public final class FBBackstageSeenStateMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f5246d;
        @Nullable
        private String f5247e;

        /* compiled from: requesteeFbId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBBackstageSeenStateMutationFragmentModel.class, new Deserializer());
            }

            public Object m5005a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBBackstageSeenStateMutationFragmentParser.m5053a(jsonParser);
                Object fBBackstageSeenStateMutationFragmentModel = new FBBackstageSeenStateMutationFragmentModel();
                ((BaseModel) fBBackstageSeenStateMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBBackstageSeenStateMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBBackstageSeenStateMutationFragmentModel).a();
                }
                return fBBackstageSeenStateMutationFragmentModel;
            }
        }

        /* compiled from: requesteeFbId */
        public class Serializer extends JsonSerializer<FBBackstageSeenStateMutationFragmentModel> {
            public final void m5006a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBBackstageSeenStateMutationFragmentModel fBBackstageSeenStateMutationFragmentModel = (FBBackstageSeenStateMutationFragmentModel) obj;
                if (fBBackstageSeenStateMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBBackstageSeenStateMutationFragmentModel.m5009a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBBackstageSeenStateMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBBackstageSeenStateMutationFragmentModel.w_();
                int u_ = fBBackstageSeenStateMutationFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("client_subscription_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBBackstageSeenStateMutationFragmentModel.class, new Serializer());
            }
        }

        public FBBackstageSeenStateMutationFragmentModel() {
            super(2);
        }

        @Nullable
        private String m5007a() {
            this.f5246d = super.a(this.f5246d, 0);
            return this.f5246d;
        }

        @Nullable
        private String m5008j() {
            this.f5247e = super.a(this.f5247e, 1);
            return this.f5247e;
        }

        public final int jK_() {
            return -907510857;
        }

        public final GraphQLVisitableModel m5010a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m5009a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5007a());
            int b2 = flatBufferBuilder.b(m5008j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1808652079)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: requesteeFbId */
    public final class FBBackstageUpdateAudienceModeMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UserModel f5250d;

        /* compiled from: requesteeFbId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBBackstageUpdateAudienceModeMutationModel.class, new Deserializer());
            }

            public Object m5011a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBBackstageUpdateAudienceModeMutationParser.m5056a(jsonParser);
                Object fBBackstageUpdateAudienceModeMutationModel = new FBBackstageUpdateAudienceModeMutationModel();
                ((BaseModel) fBBackstageUpdateAudienceModeMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBBackstageUpdateAudienceModeMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) fBBackstageUpdateAudienceModeMutationModel).a();
                }
                return fBBackstageUpdateAudienceModeMutationModel;
            }
        }

        /* compiled from: requesteeFbId */
        public class Serializer extends JsonSerializer<FBBackstageUpdateAudienceModeMutationModel> {
            public final void m5012a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBBackstageUpdateAudienceModeMutationModel fBBackstageUpdateAudienceModeMutationModel = (FBBackstageUpdateAudienceModeMutationModel) obj;
                if (fBBackstageUpdateAudienceModeMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBBackstageUpdateAudienceModeMutationModel.m5023a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBBackstageUpdateAudienceModeMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBBackstageUpdateAudienceModeMutationModel.w_();
                int u_ = fBBackstageUpdateAudienceModeMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("user");
                    UserParser.m5055a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBBackstageUpdateAudienceModeMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1409708854)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: requesteeFbId */
        public final class UserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f5248d;
            @Nullable
            private String f5249e;

            /* compiled from: requesteeFbId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UserModel.class, new Deserializer());
                }

                public Object m5013a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UserParser.m5054a(jsonParser, flatBufferBuilder));
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

            /* compiled from: requesteeFbId */
            public class Serializer extends JsonSerializer<UserModel> {
                public final void m5014a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UserModel userModel = (UserModel) obj;
                    if (userModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(userModel.m5017a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        userModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserParser.m5055a(userModel.w_(), userModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UserModel.class, new Serializer());
                }
            }

            public UserModel() {
                super(2);
            }

            public final void m5020a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m5021a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m5015j() {
                this.f5248d = super.a(this.f5248d, 0);
                return this.f5248d;
            }

            @Nullable
            private String m5016k() {
                this.f5249e = super.a(this.f5249e, 1);
                return this.f5249e;
            }

            @Nullable
            public final String m5019a() {
                return m5016k();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m5018a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5017a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5015j());
                int b2 = flatBufferBuilder.b(m5016k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FBBackstageUpdateAudienceModeMutationModel() {
            super(1);
        }

        @Nullable
        private UserModel m5022a() {
            this.f5250d = (UserModel) super.a(this.f5250d, 0, UserModel.class);
            return this.f5250d;
        }

        public final int jK_() {
            return 155487259;
        }

        public final GraphQLVisitableModel m5024a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5022a() != null) {
                UserModel userModel = (UserModel) graphQLModelMutatingVisitor.b(m5022a());
                if (m5022a() != userModel) {
                    graphQLVisitableModel = (FBBackstageUpdateAudienceModeMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5250d = userModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5023a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5022a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1023906357)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: requesteeFbId */
    public final class UpdateWhiteListMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UserModel f5256d;

        /* compiled from: requesteeFbId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UpdateWhiteListMutationModel.class, new Deserializer());
            }

            public Object m5025a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UpdateWhiteListMutationParser.m5063a(jsonParser);
                Object updateWhiteListMutationModel = new UpdateWhiteListMutationModel();
                ((BaseModel) updateWhiteListMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (updateWhiteListMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) updateWhiteListMutationModel).a();
                }
                return updateWhiteListMutationModel;
            }
        }

        /* compiled from: requesteeFbId */
        public class Serializer extends JsonSerializer<UpdateWhiteListMutationModel> {
            public final void m5026a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UpdateWhiteListMutationModel updateWhiteListMutationModel = (UpdateWhiteListMutationModel) obj;
                if (updateWhiteListMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(updateWhiteListMutationModel.m5048a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    updateWhiteListMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = updateWhiteListMutationModel.w_();
                int u_ = updateWhiteListMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("user");
                    UpdateWhiteListMutationParser.UserParser.m5062a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UpdateWhiteListMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2023794522)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: requesteeFbId */
        public final class UserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private BackstageWhitelistedFriendsModel f5254d;
            @Nullable
            private String f5255e;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1270632185)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: requesteeFbId */
            public final class BackstageWhitelistedFriendsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f5253d;

                /* compiled from: requesteeFbId */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(BackstageWhitelistedFriendsModel.class, new Deserializer());
                    }

                    public Object m5027a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(BackstageWhitelistedFriendsParser.m5059a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object backstageWhitelistedFriendsModel = new BackstageWhitelistedFriendsModel();
                        ((BaseModel) backstageWhitelistedFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (backstageWhitelistedFriendsModel instanceof Postprocessable) {
                            return ((Postprocessable) backstageWhitelistedFriendsModel).a();
                        }
                        return backstageWhitelistedFriendsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1787905591)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: requesteeFbId */
                public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private GraphQLObjectType f5251d;
                    @Nullable
                    private String f5252e;

                    /* compiled from: requesteeFbId */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m5028a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodesParser.m5058b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodesModel = new NodesModel();
                            ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodesModel instanceof Postprocessable) {
                                return ((Postprocessable) nodesModel).a();
                            }
                            return nodesModel;
                        }
                    }

                    /* compiled from: requesteeFbId */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m5029a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m5032a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodesParser.m5057a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    public NodesModel() {
                        super(2);
                    }

                    @Nullable
                    private GraphQLObjectType m5030j() {
                        if (this.b != null && this.f5251d == null) {
                            this.f5251d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f5251d;
                    }

                    @Nullable
                    private String m5031k() {
                        this.f5252e = super.a(this.f5252e, 1);
                        return this.f5252e;
                    }

                    @Nullable
                    public final String m5034a() {
                        return m5031k();
                    }

                    public final int jK_() {
                        return -1301901016;
                    }

                    public final GraphQLVisitableModel m5033a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m5032a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m5030j());
                        int b = flatBufferBuilder.b(m5031k());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: requesteeFbId */
                public class Serializer extends JsonSerializer<BackstageWhitelistedFriendsModel> {
                    public final void m5035a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        BackstageWhitelistedFriendsModel backstageWhitelistedFriendsModel = (BackstageWhitelistedFriendsModel) obj;
                        if (backstageWhitelistedFriendsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(backstageWhitelistedFriendsModel.m5037a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            backstageWhitelistedFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        BackstageWhitelistedFriendsParser.m5060a(backstageWhitelistedFriendsModel.w_(), backstageWhitelistedFriendsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(BackstageWhitelistedFriendsModel.class, new Serializer());
                    }
                }

                public BackstageWhitelistedFriendsModel() {
                    super(1);
                }

                @Nonnull
                private ImmutableList<NodesModel> m5036a() {
                    this.f5253d = super.a(this.f5253d, 0, NodesModel.class);
                    return (ImmutableList) this.f5253d;
                }

                public final int jK_() {
                    return 1706115518;
                }

                public final GraphQLVisitableModel m5038a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5036a() != null) {
                        Builder a = ModelHelper.a(m5036a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (BackstageWhitelistedFriendsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5253d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5037a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5036a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: requesteeFbId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UserModel.class, new Deserializer());
                }

                public Object m5039a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UpdateWhiteListMutationParser.UserParser.m5061a(jsonParser, flatBufferBuilder));
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

            /* compiled from: requesteeFbId */
            public class Serializer extends JsonSerializer<UserModel> {
                public final void m5040a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UserModel userModel = (UserModel) obj;
                    if (userModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(userModel.m5042a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        userModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UpdateWhiteListMutationParser.UserParser.m5062a(userModel.w_(), userModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(UserModel.class, new Serializer());
                }
            }

            public UserModel() {
                super(2);
            }

            public final void m5045a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m5046a(String str, Object obj, boolean z) {
            }

            @Nullable
            private BackstageWhitelistedFriendsModel m5041k() {
                this.f5254d = (BackstageWhitelistedFriendsModel) super.a(this.f5254d, 0, BackstageWhitelistedFriendsModel.class);
                return this.f5254d;
            }

            @Nullable
            public final String m5047j() {
                this.f5255e = super.a(this.f5255e, 1);
                return this.f5255e;
            }

            @Nullable
            public final String m5044a() {
                return m5047j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m5043a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5041k() != null) {
                    BackstageWhitelistedFriendsModel backstageWhitelistedFriendsModel = (BackstageWhitelistedFriendsModel) graphQLModelMutatingVisitor.b(m5041k());
                    if (m5041k() != backstageWhitelistedFriendsModel) {
                        graphQLVisitableModel = (UserModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5254d = backstageWhitelistedFriendsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5042a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5041k());
                int b = flatBufferBuilder.b(m5047j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public UpdateWhiteListMutationModel() {
            super(1);
        }

        @Nullable
        public final UserModel m5049a() {
            this.f5256d = (UserModel) super.a(this.f5256d, 0, UserModel.class);
            return this.f5256d;
        }

        public final int jK_() {
            return -794119789;
        }

        public final GraphQLVisitableModel m5050a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5049a() != null) {
                UserModel userModel = (UserModel) graphQLModelMutatingVisitor.b(m5049a());
                if (m5049a() != userModel) {
                    graphQLVisitableModel = (UpdateWhiteListMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5256d = userModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5048a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5049a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
