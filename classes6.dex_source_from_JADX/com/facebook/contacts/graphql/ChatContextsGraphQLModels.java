package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.graphql.ChatContextsGraphQLInterfaces.ChatContextForUser;
import com.facebook.contacts.graphql.ChatContextsGraphQLParsers.ChatContextForUserParser;
import com.facebook.contacts.graphql.ChatContextsGraphQLParsers.ChatContextParser;
import com.facebook.contacts.graphql.ChatContextsGraphQLParsers.ChatContextParser.ContextStatusParser;
import com.facebook.contacts.graphql.ChatContextsGraphQLParsers.ChatContextParser.ContextStatusSecondaryParser;
import com.facebook.contacts.graphql.ChatContextsGraphQLParsers.FetchChatContextsQueryParser;
import com.facebook.contacts.graphql.ChatContextsGraphQLParsers.FetchChatContextsQueryParser.FriendsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLUserChatContextType;
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

/* compiled from: photo_comment_batch */
public class ChatContextsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1505315444)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_comment_batch */
    public final class ChatContextForUserModel extends BaseModel implements ChatContextForUser, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private ChatContextModel f8148d;
        @Nullable
        private String f8149e;

        /* compiled from: photo_comment_batch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ChatContextForUserModel.class, new Deserializer());
            }

            public Object m11701a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ChatContextForUserParser.m11743b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object chatContextForUserModel = new ChatContextForUserModel();
                ((BaseModel) chatContextForUserModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (chatContextForUserModel instanceof Postprocessable) {
                    return ((Postprocessable) chatContextForUserModel).a();
                }
                return chatContextForUserModel;
            }
        }

        /* compiled from: photo_comment_batch */
        public class Serializer extends JsonSerializer<ChatContextForUserModel> {
            public final void m11702a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ChatContextForUserModel chatContextForUserModel = (ChatContextForUserModel) obj;
                if (chatContextForUserModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(chatContextForUserModel.m11704a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    chatContextForUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ChatContextForUserParser.m11744b(chatContextForUserModel.w_(), chatContextForUserModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ChatContextForUserModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ChatContextModel mo935b() {
            return m11703j();
        }

        public ChatContextForUserModel() {
            super(2);
        }

        public final void m11707a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11708a(String str, Object obj, boolean z) {
        }

        @Nullable
        private ChatContextModel m11703j() {
            this.f8148d = (ChatContextModel) super.a(this.f8148d, 0, ChatContextModel.class);
            return this.f8148d;
        }

        @Nullable
        public final String mo936c() {
            this.f8149e = super.a(this.f8149e, 1);
            return this.f8149e;
        }

        @Nullable
        public final String m11706a() {
            return mo936c();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m11705a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11703j() != null) {
                ChatContextModel chatContextModel = (ChatContextModel) graphQLModelMutatingVisitor.b(m11703j());
                if (m11703j() != chatContextModel) {
                    graphQLVisitableModel = (ChatContextForUserModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8148d = chatContextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11704a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11703j());
            int b = flatBufferBuilder.b(mo936c());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 747177629)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_comment_batch */
    public final class ChatContextModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ContextStatusModel f8152d;
        @Nullable
        private ContextStatusSecondaryModel f8153e;
        @Nullable
        private GraphQLUserChatContextType f8154f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_comment_batch */
        public final class ContextStatusModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8150d;

            /* compiled from: photo_comment_batch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ContextStatusModel.class, new Deserializer());
                }

                public Object m11711a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ContextStatusParser.m11745a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object contextStatusModel = new ContextStatusModel();
                    ((BaseModel) contextStatusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (contextStatusModel instanceof Postprocessable) {
                        return ((Postprocessable) contextStatusModel).a();
                    }
                    return contextStatusModel;
                }
            }

            /* compiled from: photo_comment_batch */
            public class Serializer extends JsonSerializer<ContextStatusModel> {
                public final void m11712a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ContextStatusModel contextStatusModel = (ContextStatusModel) obj;
                    if (contextStatusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(contextStatusModel.m11713a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        contextStatusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ContextStatusParser.m11746a(contextStatusModel.w_(), contextStatusModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ContextStatusModel.class, new Serializer());
                }
            }

            public ContextStatusModel() {
                super(1);
            }

            @Nullable
            public final String m11715a() {
                this.f8150d = super.a(this.f8150d, 0);
                return this.f8150d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m11714a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m11713a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11715a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_comment_batch */
        public final class ContextStatusSecondaryModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8151d;

            /* compiled from: photo_comment_batch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ContextStatusSecondaryModel.class, new Deserializer());
                }

                public Object m11716a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ContextStatusSecondaryParser.m11747a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object contextStatusSecondaryModel = new ContextStatusSecondaryModel();
                    ((BaseModel) contextStatusSecondaryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (contextStatusSecondaryModel instanceof Postprocessable) {
                        return ((Postprocessable) contextStatusSecondaryModel).a();
                    }
                    return contextStatusSecondaryModel;
                }
            }

            /* compiled from: photo_comment_batch */
            public class Serializer extends JsonSerializer<ContextStatusSecondaryModel> {
                public final void m11717a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ContextStatusSecondaryModel contextStatusSecondaryModel = (ContextStatusSecondaryModel) obj;
                    if (contextStatusSecondaryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(contextStatusSecondaryModel.m11719a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        contextStatusSecondaryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ContextStatusSecondaryParser.m11748a(contextStatusSecondaryModel.w_(), contextStatusSecondaryModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ContextStatusSecondaryModel.class, new Serializer());
                }
            }

            public ContextStatusSecondaryModel() {
                super(1);
            }

            @Nullable
            private String m11718a() {
                this.f8151d = super.a(this.f8151d, 0);
                return this.f8151d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m11720a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m11719a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11718a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_comment_batch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ChatContextModel.class, new Deserializer());
            }

            public Object m11721a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ChatContextParser.m11749a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object chatContextModel = new ChatContextModel();
                ((BaseModel) chatContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (chatContextModel instanceof Postprocessable) {
                    return ((Postprocessable) chatContextModel).a();
                }
                return chatContextModel;
            }
        }

        /* compiled from: photo_comment_batch */
        public class Serializer extends JsonSerializer<ChatContextModel> {
            public final void m11722a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ChatContextModel chatContextModel = (ChatContextModel) obj;
                if (chatContextModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(chatContextModel.m11725a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    chatContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ChatContextParser.m11750a(chatContextModel.w_(), chatContextModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ChatContextModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ContextStatusModel m11726a() {
            return m11723j();
        }

        public ChatContextModel() {
            super(3);
        }

        @Nullable
        private ContextStatusModel m11723j() {
            this.f8152d = (ContextStatusModel) super.a(this.f8152d, 0, ContextStatusModel.class);
            return this.f8152d;
        }

        @Nullable
        private ContextStatusSecondaryModel m11724k() {
            this.f8153e = (ContextStatusSecondaryModel) super.a(this.f8153e, 1, ContextStatusSecondaryModel.class);
            return this.f8153e;
        }

        @Nullable
        public final GraphQLUserChatContextType m11728b() {
            this.f8154f = (GraphQLUserChatContextType) super.b(this.f8154f, 2, GraphQLUserChatContextType.class, GraphQLUserChatContextType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8154f;
        }

        public final int jK_() {
            return -455082420;
        }

        public final GraphQLVisitableModel m11727a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11723j() != null) {
                ContextStatusModel contextStatusModel = (ContextStatusModel) graphQLModelMutatingVisitor.b(m11723j());
                if (m11723j() != contextStatusModel) {
                    graphQLVisitableModel = (ChatContextModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8152d = contextStatusModel;
                }
            }
            if (m11724k() != null) {
                ContextStatusSecondaryModel contextStatusSecondaryModel = (ContextStatusSecondaryModel) graphQLModelMutatingVisitor.b(m11724k());
                if (m11724k() != contextStatusSecondaryModel) {
                    graphQLVisitableModel = (ChatContextModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8153e = contextStatusSecondaryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11725a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11723j());
            int a2 = ModelHelper.a(flatBufferBuilder, m11724k());
            int a3 = flatBufferBuilder.a(m11728b());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -749967367)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_comment_batch */
    public final class FetchChatContextsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f8156d;
        @Nullable
        private FriendsModel f8157e;

        /* compiled from: photo_comment_batch */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchChatContextsQueryModel.class, new Deserializer());
            }

            public Object m11729a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchChatContextsQueryParser.m11753a(jsonParser);
                Object fetchChatContextsQueryModel = new FetchChatContextsQueryModel();
                ((BaseModel) fetchChatContextsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchChatContextsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchChatContextsQueryModel).a();
                }
                return fetchChatContextsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1901978642)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_comment_batch */
        public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ChatContextForUserModel> f8155d;

            /* compiled from: photo_comment_batch */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                }

                public Object m11730a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsParser.m11751a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendsModel = new FriendsModel();
                    ((BaseModel) friendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendsModel instanceof Postprocessable) {
                        return ((Postprocessable) friendsModel).a();
                    }
                    return friendsModel;
                }
            }

            /* compiled from: photo_comment_batch */
            public class Serializer extends JsonSerializer<FriendsModel> {
                public final void m11731a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsModel friendsModel = (FriendsModel) obj;
                    if (friendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsModel.m11732a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsParser.m11752a(friendsModel.w_(), friendsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsModel.class, new Serializer());
                }
            }

            public FriendsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ChatContextForUserModel> m11734a() {
                this.f8155d = super.a(this.f8155d, 0, ChatContextForUserModel.class);
                return (ImmutableList) this.f8155d;
            }

            public final int jK_() {
                return 569028147;
            }

            public final GraphQLVisitableModel m11733a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11734a() != null) {
                    Builder a = ModelHelper.a(m11734a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FriendsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8155d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11732a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11734a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_comment_batch */
        public class Serializer extends JsonSerializer<FetchChatContextsQueryModel> {
            public final void m11735a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchChatContextsQueryModel fetchChatContextsQueryModel = (FetchChatContextsQueryModel) obj;
                if (fetchChatContextsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchChatContextsQueryModel.m11738a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchChatContextsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchChatContextsQueryModel.w_();
                int u_ = fetchChatContextsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("friends");
                    FriendsParser.m11752a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchChatContextsQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FriendsModel m11739a() {
            return m11737k();
        }

        public FetchChatContextsQueryModel() {
            super(2);
        }

        public final void m11741a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11742a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m11736j() {
            if (this.b != null && this.f8156d == null) {
                this.f8156d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8156d;
        }

        @Nullable
        private FriendsModel m11737k() {
            this.f8157e = (FriendsModel) super.a(this.f8157e, 1, FriendsModel.class);
            return this.f8157e;
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m11740a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11737k() != null) {
                FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m11737k());
                if (m11737k() != friendsModel) {
                    graphQLVisitableModel = (FetchChatContextsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8157e = friendsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11738a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11736j());
            int a2 = ModelHelper.a(flatBufferBuilder, m11737k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
