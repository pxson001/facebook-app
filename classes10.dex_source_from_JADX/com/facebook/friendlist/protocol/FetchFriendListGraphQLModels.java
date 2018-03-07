package com.facebook.friendlist.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLParsers.FetchFriendListQueryParser;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLParsers.FetchFriendListQueryParser.FriendsParser;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLParsers.FetchMutualFriendListQueryParser;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLParsers.FetchMutualFriendListQueryParser.MutualFriendsParser;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLParsers.FetchRecentlyAddedFriendListQueryParser;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLParsers.FetchSuggestionsFriendListQueryParser;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLParsers.FetchWithNewPostsFriendListQueryParser;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLParsers.UserFieldsParser;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLParsers.UserFieldsParser.StructuredNameParser;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNamePartFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
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

/* compiled from: access_denied */
public class FetchFriendListGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 813866108)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: access_denied */
    public final class FetchFriendListQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private FriendsModel f20423d;

        /* compiled from: access_denied */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchFriendListQueryModel.class, new Deserializer());
            }

            public Object m20693a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchFriendListQueryParser.m20790a(jsonParser);
                Object fetchFriendListQueryModel = new FetchFriendListQueryModel();
                ((BaseModel) fetchFriendListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchFriendListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchFriendListQueryModel).a();
                }
                return fetchFriendListQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1270791826)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: access_denied */
        public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<UserFieldsModel> f20421d;
            @Nullable
            private DefaultPageInfoFieldsModel f20422e;

            /* compiled from: access_denied */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                }

                public Object m20694a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsParser.m20788a(jsonParser, flatBufferBuilder));
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

            /* compiled from: access_denied */
            public class Serializer extends JsonSerializer<FriendsModel> {
                public final void m20695a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsModel friendsModel = (FriendsModel) obj;
                    if (friendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsModel.m20696a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsParser.m20789a(friendsModel.w_(), friendsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsModel.class, new Serializer());
                }
            }

            public FriendsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<UserFieldsModel> m20698a() {
                this.f20421d = super.a(this.f20421d, 0, UserFieldsModel.class);
                return (ImmutableList) this.f20421d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m20699j() {
                this.f20422e = (DefaultPageInfoFieldsModel) super.a(this.f20422e, 1, DefaultPageInfoFieldsModel.class);
                return this.f20422e;
            }

            public final int jK_() {
                return 569028147;
            }

            public final GraphQLVisitableModel m20697a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m20698a() != null) {
                    Builder a = ModelHelper.a(m20698a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FriendsModel friendsModel = (FriendsModel) ModelHelper.a(null, this);
                        friendsModel.f20421d = a.b();
                        graphQLVisitableModel = friendsModel;
                        if (m20699j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20699j());
                            if (m20699j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f20422e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m20699j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20699j());
                    if (m20699j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f20422e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m20696a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20698a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20699j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: access_denied */
        public class Serializer extends JsonSerializer<FetchFriendListQueryModel> {
            public final void m20700a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchFriendListQueryModel fetchFriendListQueryModel = (FetchFriendListQueryModel) obj;
                if (fetchFriendListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchFriendListQueryModel.m20701a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchFriendListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchFriendListQueryModel.w_();
                int u_ = fetchFriendListQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friends");
                    FriendsParser.m20789a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchFriendListQueryModel.class, new Serializer());
            }
        }

        public FetchFriendListQueryModel() {
            super(1);
        }

        public final void m20704a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20705a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final FriendsModel m20702a() {
            this.f20423d = (FriendsModel) super.a(this.f20423d, 0, FriendsModel.class);
            return this.f20423d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m20703a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20702a() != null) {
                FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m20702a());
                if (m20702a() != friendsModel) {
                    graphQLVisitableModel = (FetchFriendListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20423d = friendsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20701a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20702a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1905600858)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: access_denied */
    public final class FetchMutualFriendListQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private MutualFriendsModel f20426d;

        /* compiled from: access_denied */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchMutualFriendListQueryModel.class, new Deserializer());
            }

            public Object m20706a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchMutualFriendListQueryParser.m20793a(jsonParser);
                Object fetchMutualFriendListQueryModel = new FetchMutualFriendListQueryModel();
                ((BaseModel) fetchMutualFriendListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchMutualFriendListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchMutualFriendListQueryModel).a();
                }
                return fetchMutualFriendListQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1270791826)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: access_denied */
        public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<UserFieldsModel> f20424d;
            @Nullable
            private DefaultPageInfoFieldsModel f20425e;

            /* compiled from: access_denied */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                }

                public Object m20707a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MutualFriendsParser.m20791a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mutualFriendsModel = new MutualFriendsModel();
                    ((BaseModel) mutualFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mutualFriendsModel instanceof Postprocessable) {
                        return ((Postprocessable) mutualFriendsModel).a();
                    }
                    return mutualFriendsModel;
                }
            }

            /* compiled from: access_denied */
            public class Serializer extends JsonSerializer<MutualFriendsModel> {
                public final void m20708a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                    if (mutualFriendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mutualFriendsModel.m20709a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MutualFriendsParser.m20792a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                }
            }

            public MutualFriendsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<UserFieldsModel> m20711a() {
                this.f20424d = super.a(this.f20424d, 0, UserFieldsModel.class);
                return (ImmutableList) this.f20424d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m20712j() {
                this.f20425e = (DefaultPageInfoFieldsModel) super.a(this.f20425e, 1, DefaultPageInfoFieldsModel.class);
                return this.f20425e;
            }

            public final int jK_() {
                return 1532278911;
            }

            public final GraphQLVisitableModel m20710a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m20711a() != null) {
                    Builder a = ModelHelper.a(m20711a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) ModelHelper.a(null, this);
                        mutualFriendsModel.f20424d = a.b();
                        graphQLVisitableModel = mutualFriendsModel;
                        if (m20712j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20712j());
                            if (m20712j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (MutualFriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f20425e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m20712j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20712j());
                    if (m20712j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (MutualFriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f20425e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m20709a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20711a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20712j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: access_denied */
        public class Serializer extends JsonSerializer<FetchMutualFriendListQueryModel> {
            public final void m20713a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchMutualFriendListQueryModel fetchMutualFriendListQueryModel = (FetchMutualFriendListQueryModel) obj;
                if (fetchMutualFriendListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchMutualFriendListQueryModel.m20714a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchMutualFriendListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchMutualFriendListQueryModel.w_();
                int u_ = fetchMutualFriendListQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("mutual_friends");
                    MutualFriendsParser.m20792a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchMutualFriendListQueryModel.class, new Serializer());
            }
        }

        public FetchMutualFriendListQueryModel() {
            super(1);
        }

        public final void m20717a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20718a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final MutualFriendsModel m20715a() {
            this.f20426d = (MutualFriendsModel) super.a(this.f20426d, 0, MutualFriendsModel.class);
            return this.f20426d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m20716a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20715a() != null) {
                MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m20715a());
                if (m20715a() != mutualFriendsModel) {
                    graphQLVisitableModel = (FetchMutualFriendListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20426d = mutualFriendsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20714a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20715a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1364640660)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: access_denied */
    public final class FetchRecentlyAddedFriendListQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private FriendsModel f20429d;

        /* compiled from: access_denied */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchRecentlyAddedFriendListQueryModel.class, new Deserializer());
            }

            public Object m20719a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchRecentlyAddedFriendListQueryParser.m20796a(jsonParser);
                Object fetchRecentlyAddedFriendListQueryModel = new FetchRecentlyAddedFriendListQueryModel();
                ((BaseModel) fetchRecentlyAddedFriendListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchRecentlyAddedFriendListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchRecentlyAddedFriendListQueryModel).a();
                }
                return fetchRecentlyAddedFriendListQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1270791826)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: access_denied */
        public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<UserFieldsModel> f20427d;
            @Nullable
            private DefaultPageInfoFieldsModel f20428e;

            /* compiled from: access_denied */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                }

                public Object m20720a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchRecentlyAddedFriendListQueryParser.FriendsParser.m20794a(jsonParser, flatBufferBuilder));
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

            /* compiled from: access_denied */
            public class Serializer extends JsonSerializer<FriendsModel> {
                public final void m20721a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsModel friendsModel = (FriendsModel) obj;
                    if (friendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsModel.m20722a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchRecentlyAddedFriendListQueryParser.FriendsParser.m20795a(friendsModel.w_(), friendsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsModel.class, new Serializer());
                }
            }

            public FriendsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<UserFieldsModel> m20724a() {
                this.f20427d = super.a(this.f20427d, 0, UserFieldsModel.class);
                return (ImmutableList) this.f20427d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m20725j() {
                this.f20428e = (DefaultPageInfoFieldsModel) super.a(this.f20428e, 1, DefaultPageInfoFieldsModel.class);
                return this.f20428e;
            }

            public final int jK_() {
                return 569028147;
            }

            public final GraphQLVisitableModel m20723a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m20724a() != null) {
                    Builder a = ModelHelper.a(m20724a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FriendsModel friendsModel = (FriendsModel) ModelHelper.a(null, this);
                        friendsModel.f20427d = a.b();
                        graphQLVisitableModel = friendsModel;
                        if (m20725j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20725j());
                            if (m20725j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f20428e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m20725j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20725j());
                    if (m20725j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f20428e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m20722a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20724a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20725j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: access_denied */
        public class Serializer extends JsonSerializer<FetchRecentlyAddedFriendListQueryModel> {
            public final void m20726a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchRecentlyAddedFriendListQueryModel fetchRecentlyAddedFriendListQueryModel = (FetchRecentlyAddedFriendListQueryModel) obj;
                if (fetchRecentlyAddedFriendListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchRecentlyAddedFriendListQueryModel.m20727a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchRecentlyAddedFriendListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchRecentlyAddedFriendListQueryModel.w_();
                int u_ = fetchRecentlyAddedFriendListQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friends");
                    FetchRecentlyAddedFriendListQueryParser.FriendsParser.m20795a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchRecentlyAddedFriendListQueryModel.class, new Serializer());
            }
        }

        public FetchRecentlyAddedFriendListQueryModel() {
            super(1);
        }

        public final void m20730a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20731a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final FriendsModel m20728a() {
            this.f20429d = (FriendsModel) super.a(this.f20429d, 0, FriendsModel.class);
            return this.f20429d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m20729a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20728a() != null) {
                FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m20728a());
                if (m20728a() != friendsModel) {
                    graphQLVisitableModel = (FetchRecentlyAddedFriendListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20429d = friendsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20727a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20728a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2099279798)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: access_denied */
    public final class FetchSuggestionsFriendListQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private FriendsModel f20432d;

        /* compiled from: access_denied */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchSuggestionsFriendListQueryModel.class, new Deserializer());
            }

            public Object m20732a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchSuggestionsFriendListQueryParser.m20799a(jsonParser);
                Object fetchSuggestionsFriendListQueryModel = new FetchSuggestionsFriendListQueryModel();
                ((BaseModel) fetchSuggestionsFriendListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchSuggestionsFriendListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchSuggestionsFriendListQueryModel).a();
                }
                return fetchSuggestionsFriendListQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1270791826)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: access_denied */
        public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<UserFieldsModel> f20430d;
            @Nullable
            private DefaultPageInfoFieldsModel f20431e;

            /* compiled from: access_denied */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                }

                public Object m20733a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchSuggestionsFriendListQueryParser.FriendsParser.m20797a(jsonParser, flatBufferBuilder));
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

            /* compiled from: access_denied */
            public class Serializer extends JsonSerializer<FriendsModel> {
                public final void m20734a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsModel friendsModel = (FriendsModel) obj;
                    if (friendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsModel.m20735a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchSuggestionsFriendListQueryParser.FriendsParser.m20798a(friendsModel.w_(), friendsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsModel.class, new Serializer());
                }
            }

            public FriendsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<UserFieldsModel> m20737a() {
                this.f20430d = super.a(this.f20430d, 0, UserFieldsModel.class);
                return (ImmutableList) this.f20430d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m20738j() {
                this.f20431e = (DefaultPageInfoFieldsModel) super.a(this.f20431e, 1, DefaultPageInfoFieldsModel.class);
                return this.f20431e;
            }

            public final int jK_() {
                return 569028147;
            }

            public final GraphQLVisitableModel m20736a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m20737a() != null) {
                    Builder a = ModelHelper.a(m20737a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FriendsModel friendsModel = (FriendsModel) ModelHelper.a(null, this);
                        friendsModel.f20430d = a.b();
                        graphQLVisitableModel = friendsModel;
                        if (m20738j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20738j());
                            if (m20738j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f20431e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m20738j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20738j());
                    if (m20738j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f20431e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m20735a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20737a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20738j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: access_denied */
        public class Serializer extends JsonSerializer<FetchSuggestionsFriendListQueryModel> {
            public final void m20739a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchSuggestionsFriendListQueryModel fetchSuggestionsFriendListQueryModel = (FetchSuggestionsFriendListQueryModel) obj;
                if (fetchSuggestionsFriendListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchSuggestionsFriendListQueryModel.m20740a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchSuggestionsFriendListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchSuggestionsFriendListQueryModel.w_();
                int u_ = fetchSuggestionsFriendListQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friends");
                    FetchSuggestionsFriendListQueryParser.FriendsParser.m20798a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchSuggestionsFriendListQueryModel.class, new Serializer());
            }
        }

        public FetchSuggestionsFriendListQueryModel() {
            super(1);
        }

        public final void m20743a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20744a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final FriendsModel m20741a() {
            this.f20432d = (FriendsModel) super.a(this.f20432d, 0, FriendsModel.class);
            return this.f20432d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m20742a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20741a() != null) {
                FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m20741a());
                if (m20741a() != friendsModel) {
                    graphQLVisitableModel = (FetchSuggestionsFriendListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20432d = friendsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20740a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20741a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -657528779)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: access_denied */
    public final class FetchWithNewPostsFriendListQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private FriendsModel f20435d;

        /* compiled from: access_denied */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchWithNewPostsFriendListQueryModel.class, new Deserializer());
            }

            public Object m20745a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchWithNewPostsFriendListQueryParser.m20802a(jsonParser);
                Object fetchWithNewPostsFriendListQueryModel = new FetchWithNewPostsFriendListQueryModel();
                ((BaseModel) fetchWithNewPostsFriendListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchWithNewPostsFriendListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchWithNewPostsFriendListQueryModel).a();
                }
                return fetchWithNewPostsFriendListQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1270791826)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: access_denied */
        public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<UserFieldsModel> f20433d;
            @Nullable
            private DefaultPageInfoFieldsModel f20434e;

            /* compiled from: access_denied */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                }

                public Object m20746a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchWithNewPostsFriendListQueryParser.FriendsParser.m20800a(jsonParser, flatBufferBuilder));
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

            /* compiled from: access_denied */
            public class Serializer extends JsonSerializer<FriendsModel> {
                public final void m20747a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsModel friendsModel = (FriendsModel) obj;
                    if (friendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsModel.m20748a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchWithNewPostsFriendListQueryParser.FriendsParser.m20801a(friendsModel.w_(), friendsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsModel.class, new Serializer());
                }
            }

            public FriendsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<UserFieldsModel> m20750a() {
                this.f20433d = super.a(this.f20433d, 0, UserFieldsModel.class);
                return (ImmutableList) this.f20433d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m20751j() {
                this.f20434e = (DefaultPageInfoFieldsModel) super.a(this.f20434e, 1, DefaultPageInfoFieldsModel.class);
                return this.f20434e;
            }

            public final int jK_() {
                return 569028147;
            }

            public final GraphQLVisitableModel m20749a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m20750a() != null) {
                    Builder a = ModelHelper.a(m20750a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FriendsModel friendsModel = (FriendsModel) ModelHelper.a(null, this);
                        friendsModel.f20433d = a.b();
                        graphQLVisitableModel = friendsModel;
                        if (m20751j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20751j());
                            if (m20751j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f20434e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m20751j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20751j());
                    if (m20751j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f20434e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m20748a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20750a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20751j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: access_denied */
        public class Serializer extends JsonSerializer<FetchWithNewPostsFriendListQueryModel> {
            public final void m20752a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchWithNewPostsFriendListQueryModel fetchWithNewPostsFriendListQueryModel = (FetchWithNewPostsFriendListQueryModel) obj;
                if (fetchWithNewPostsFriendListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchWithNewPostsFriendListQueryModel.m20753a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchWithNewPostsFriendListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchWithNewPostsFriendListQueryModel.w_();
                int u_ = fetchWithNewPostsFriendListQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friends");
                    FetchWithNewPostsFriendListQueryParser.FriendsParser.m20801a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchWithNewPostsFriendListQueryModel.class, new Serializer());
            }
        }

        public FetchWithNewPostsFriendListQueryModel() {
            super(1);
        }

        public final void m20756a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20757a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final FriendsModel m20754a() {
            this.f20435d = (FriendsModel) super.a(this.f20435d, 0, FriendsModel.class);
            return this.f20435d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m20755a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20754a() != null) {
                FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m20754a());
                if (m20754a() != friendsModel) {
                    graphQLVisitableModel = (FetchWithNewPostsFriendListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20435d = friendsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20753a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20754a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -799887593)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: access_denied */
    public final class UserFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLFriendshipStatus f20439d;
        @Nullable
        private String f20440e;
        @Nullable
        private MutualFriendsModel f20441f;
        @Nullable
        private String f20442g;
        @Nullable
        private DefaultImageFieldsModel f20443h;
        @Nullable
        private StructuredNameModel f20444i;
        @Nullable
        private GraphQLSubscribeStatus f20445j;
        private int f20446k;

        /* compiled from: access_denied */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UserFieldsModel.class, new Deserializer());
            }

            public Object m20758a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(UserFieldsParser.m20809b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object userFieldsModel = new UserFieldsModel();
                ((BaseModel) userFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (userFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) userFieldsModel).a();
                }
                return userFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: access_denied */
        public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
            private int f20436d;

            /* compiled from: access_denied */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                }

                public Object m20759a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UserFieldsParser.MutualFriendsParser.m20803a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mutualFriendsModel = new MutualFriendsModel();
                    ((BaseModel) mutualFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mutualFriendsModel instanceof Postprocessable) {
                        return ((Postprocessable) mutualFriendsModel).a();
                    }
                    return mutualFriendsModel;
                }
            }

            /* compiled from: access_denied */
            public class Serializer extends JsonSerializer<MutualFriendsModel> {
                public final void m20760a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                    if (mutualFriendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mutualFriendsModel.m20762a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserFieldsParser.MutualFriendsParser.m20804a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                }
            }

            public MutualFriendsModel() {
                super(1);
            }

            public final int m20761a() {
                a(0, 0);
                return this.f20436d;
            }

            public final int jK_() {
                return 1532278911;
            }

            public final GraphQLVisitableModel m20763a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20762a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f20436d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20764a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f20436d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: access_denied */
        public class Serializer extends JsonSerializer<UserFieldsModel> {
            public final void m20765a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                UserFieldsModel userFieldsModel = (UserFieldsModel) obj;
                if (userFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(userFieldsModel.m20774a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    userFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                UserFieldsParser.m20810b(userFieldsModel.w_(), userFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(UserFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -541630613)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: access_denied */
        public final class StructuredNameModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<DefaultNamePartFieldsModel> f20437d;
            @Nullable
            private String f20438e;

            /* compiled from: access_denied */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StructuredNameModel.class, new Deserializer());
                }

                public Object m20766a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StructuredNameParser.m20805a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object structuredNameModel = new StructuredNameModel();
                    ((BaseModel) structuredNameModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (structuredNameModel instanceof Postprocessable) {
                        return ((Postprocessable) structuredNameModel).a();
                    }
                    return structuredNameModel;
                }
            }

            /* compiled from: access_denied */
            public class Serializer extends JsonSerializer<StructuredNameModel> {
                public final void m20767a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StructuredNameModel structuredNameModel = (StructuredNameModel) obj;
                    if (structuredNameModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(structuredNameModel.m20768a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        structuredNameModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StructuredNameParser.m20806a(structuredNameModel.w_(), structuredNameModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StructuredNameModel.class, new Serializer());
                }
            }

            public StructuredNameModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<DefaultNamePartFieldsModel> m20770a() {
                this.f20437d = super.a(this.f20437d, 0, DefaultNamePartFieldsModel.class);
                return (ImmutableList) this.f20437d;
            }

            @Nullable
            public final String m20771j() {
                this.f20438e = super.a(this.f20438e, 1);
                return this.f20438e;
            }

            public final int jK_() {
                return 2420395;
            }

            public final GraphQLVisitableModel m20769a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20770a() != null) {
                    Builder a = ModelHelper.a(m20770a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (StructuredNameModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f20437d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20768a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20770a());
                int b = flatBufferBuilder.b(m20771j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public UserFieldsModel() {
            super(8);
        }

        public final void m20778a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m20780j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
            } else if ("subscribe_status".equals(str)) {
                consistencyTuple.a = m20786p();
                consistencyTuple.b = u_();
                consistencyTuple.c = 6;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m20779a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m20772a((GraphQLFriendshipStatus) obj);
            } else if ("subscribe_status".equals(str)) {
                m20773a((GraphQLSubscribeStatus) obj);
            }
        }

        @Nullable
        public final GraphQLFriendshipStatus m20780j() {
            this.f20439d = (GraphQLFriendshipStatus) super.b(this.f20439d, 0, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f20439d;
        }

        private void m20772a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f20439d = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m20781k() {
            this.f20440e = super.a(this.f20440e, 1);
            return this.f20440e;
        }

        @Nullable
        public final MutualFriendsModel m20782l() {
            this.f20441f = (MutualFriendsModel) super.a(this.f20441f, 2, MutualFriendsModel.class);
            return this.f20441f;
        }

        @Nullable
        public final String m20783m() {
            this.f20442g = super.a(this.f20442g, 3);
            return this.f20442g;
        }

        @Nullable
        public final DefaultImageFieldsModel m20784n() {
            this.f20443h = (DefaultImageFieldsModel) super.a(this.f20443h, 4, DefaultImageFieldsModel.class);
            return this.f20443h;
        }

        @Nullable
        public final StructuredNameModel m20785o() {
            this.f20444i = (StructuredNameModel) super.a(this.f20444i, 5, StructuredNameModel.class);
            return this.f20444i;
        }

        @Nullable
        public final GraphQLSubscribeStatus m20786p() {
            this.f20445j = (GraphQLSubscribeStatus) super.b(this.f20445j, 6, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f20445j;
        }

        private void m20773a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f20445j = graphQLSubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 6, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
            }
        }

        public final int m20787q() {
            a(0, 7);
            return this.f20446k;
        }

        @Nullable
        public final String m20776a() {
            return m20781k();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m20775a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20782l() != null) {
                MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m20782l());
                if (m20782l() != mutualFriendsModel) {
                    graphQLVisitableModel = (UserFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20441f = mutualFriendsModel;
                }
            }
            if (m20784n() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20784n());
                if (m20784n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (UserFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f20443h = defaultImageFieldsModel;
                }
            }
            if (m20785o() != null) {
                StructuredNameModel structuredNameModel = (StructuredNameModel) graphQLModelMutatingVisitor.b(m20785o());
                if (m20785o() != structuredNameModel) {
                    graphQLVisitableModel = (UserFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f20444i = structuredNameModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20774a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m20780j());
            int b = flatBufferBuilder.b(m20781k());
            int a2 = ModelHelper.a(flatBufferBuilder, m20782l());
            int b2 = flatBufferBuilder.b(m20783m());
            int a3 = ModelHelper.a(flatBufferBuilder, m20784n());
            int a4 = ModelHelper.a(flatBufferBuilder, m20785o());
            int a5 = flatBufferBuilder.a(m20786p());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.a(7, this.f20446k, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m20777a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f20446k = mutableFlatBuffer.a(i, 7, 0);
        }
    }
}
