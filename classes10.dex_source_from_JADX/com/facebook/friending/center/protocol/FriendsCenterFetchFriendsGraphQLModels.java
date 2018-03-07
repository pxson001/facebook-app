package com.facebook.friending.center.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterFetchFriendsGraphQLParsers.FriendsCenterFetchFriendsQueryParser;
import com.facebook.friending.center.protocol.FriendsCenterFetchFriendsGraphQLParsers.FriendsCenterFetchFriendsQueryParser.FriendsParser;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: advertisingId */
public class FriendsCenterFetchFriendsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -373266073)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: advertisingId */
    public final class FriendsCenterFetchFriendsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f20021d;
        @Nullable
        private FriendsModel f20022e;

        /* compiled from: advertisingId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendsCenterFetchFriendsQueryModel.class, new Deserializer());
            }

            public Object m20214a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendsCenterFetchFriendsQueryParser.m20230a(jsonParser);
                Object friendsCenterFetchFriendsQueryModel = new FriendsCenterFetchFriendsQueryModel();
                ((BaseModel) friendsCenterFetchFriendsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendsCenterFetchFriendsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) friendsCenterFetchFriendsQueryModel).a();
                }
                return friendsCenterFetchFriendsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1065753298)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: advertisingId */
        public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FriendsCenterDefaultNodeModel> f20019d;
            @Nullable
            private DefaultPageInfoFieldsModel f20020e;

            /* compiled from: advertisingId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                }

                public Object m20215a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsParser.m20228a(jsonParser, flatBufferBuilder));
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

            /* compiled from: advertisingId */
            public class Serializer extends JsonSerializer<FriendsModel> {
                public final void m20216a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsModel friendsModel = (FriendsModel) obj;
                    if (friendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsModel.m20217a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsParser.m20229a(friendsModel.w_(), friendsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsModel.class, new Serializer());
                }
            }

            public FriendsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<FriendsCenterDefaultNodeModel> m20219a() {
                this.f20019d = super.a(this.f20019d, 0, FriendsCenterDefaultNodeModel.class);
                return (ImmutableList) this.f20019d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m20220j() {
                this.f20020e = (DefaultPageInfoFieldsModel) super.a(this.f20020e, 1, DefaultPageInfoFieldsModel.class);
                return this.f20020e;
            }

            public final int jK_() {
                return 569028147;
            }

            public final GraphQLVisitableModel m20218a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m20219a() != null) {
                    Builder a = ModelHelper.a(m20219a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FriendsModel friendsModel = (FriendsModel) ModelHelper.a(null, this);
                        friendsModel.f20019d = a.b();
                        graphQLVisitableModel = friendsModel;
                        if (m20220j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20220j());
                            if (m20220j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f20020e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m20220j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20220j());
                    if (m20220j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (FriendsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f20020e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m20217a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20219a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20220j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: advertisingId */
        public class Serializer extends JsonSerializer<FriendsCenterFetchFriendsQueryModel> {
            public final void m20221a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendsCenterFetchFriendsQueryModel friendsCenterFetchFriendsQueryModel = (FriendsCenterFetchFriendsQueryModel) obj;
                if (friendsCenterFetchFriendsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendsCenterFetchFriendsQueryModel.m20223a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendsCenterFetchFriendsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendsCenterFetchFriendsQueryModel.w_();
                int u_ = friendsCenterFetchFriendsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("friends");
                    FriendsParser.m20229a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendsCenterFetchFriendsQueryModel.class, new Serializer());
            }
        }

        public FriendsCenterFetchFriendsQueryModel() {
            super(2);
        }

        public final void m20226a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20227a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m20222j() {
            if (this.b != null && this.f20021d == null) {
                this.f20021d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f20021d;
        }

        @Nullable
        public final FriendsModel m20224a() {
            this.f20022e = (FriendsModel) super.a(this.f20022e, 1, FriendsModel.class);
            return this.f20022e;
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m20225a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20224a() != null) {
                FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m20224a());
                if (m20224a() != friendsModel) {
                    graphQLVisitableModel = (FriendsCenterFetchFriendsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20022e = friendsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20223a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20222j());
            int a2 = ModelHelper.a(flatBufferBuilder, m20224a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
