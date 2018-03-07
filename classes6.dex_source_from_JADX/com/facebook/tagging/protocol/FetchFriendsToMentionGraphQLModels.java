package com.facebook.tagging.protocol;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.tagging.protocol.FetchFriendsToMentionGraphQLParsers.FetchFriendsToMentionQueryParser;
import com.facebook.tagging.protocol.FetchFriendsToMentionGraphQLParsers.FetchFriendsToMentionQueryParser.FriendsParser;
import com.facebook.tagging.protocol.FetchFriendsToMentionGraphQLParsers.FriendToMentionParser;
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

/* compiled from: deltaParticipantsAddedToGroupThread */
public class FetchFriendsToMentionGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 965056366)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deltaParticipantsAddedToGroupThread */
    public final class FetchFriendsToMentionQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f17550d;
        @Nullable
        private FriendsModel f17551e;

        /* compiled from: deltaParticipantsAddedToGroupThread */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchFriendsToMentionQueryModel.class, new Deserializer());
            }

            public Object m25533a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchFriendsToMentionQueryParser.m25558a(jsonParser);
                Object fetchFriendsToMentionQueryModel = new FetchFriendsToMentionQueryModel();
                ((BaseModel) fetchFriendsToMentionQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchFriendsToMentionQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchFriendsToMentionQueryModel).a();
                }
                return fetchFriendsToMentionQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -104183794)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: deltaParticipantsAddedToGroupThread */
        public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FriendToMentionModel> f17549d;

            /* compiled from: deltaParticipantsAddedToGroupThread */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                }

                public Object m25534a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsParser.m25556a(jsonParser, flatBufferBuilder));
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

            /* compiled from: deltaParticipantsAddedToGroupThread */
            public class Serializer extends JsonSerializer<FriendsModel> {
                public final void m25535a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsModel friendsModel = (FriendsModel) obj;
                    if (friendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsModel.m25537a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsParser.m25557a(friendsModel.w_(), friendsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsModel.class, new Serializer());
                }
            }

            public FriendsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<FriendToMentionModel> m25536a() {
                this.f17549d = super.a(this.f17549d, 0, FriendToMentionModel.class);
                return (ImmutableList) this.f17549d;
            }

            public final int jK_() {
                return 569028147;
            }

            public final GraphQLVisitableModel m25538a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m25536a() != null) {
                    Builder a = ModelHelper.a(m25536a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FriendsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17549d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m25537a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m25536a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: deltaParticipantsAddedToGroupThread */
        public class Serializer extends JsonSerializer<FetchFriendsToMentionQueryModel> {
            public final void m25539a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchFriendsToMentionQueryModel fetchFriendsToMentionQueryModel = (FetchFriendsToMentionQueryModel) obj;
                if (fetchFriendsToMentionQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchFriendsToMentionQueryModel.m25542a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchFriendsToMentionQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchFriendsToMentionQueryModel.w_();
                int u_ = fetchFriendsToMentionQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("friends");
                    FriendsParser.m25557a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchFriendsToMentionQueryModel.class, new Serializer());
            }
        }

        public FetchFriendsToMentionQueryModel() {
            super(2);
        }

        public final void m25544a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m25545a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m25540a() {
            if (this.b != null && this.f17550d == null) {
                this.f17550d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17550d;
        }

        @Nullable
        private FriendsModel m25541j() {
            this.f17551e = (FriendsModel) super.a(this.f17551e, 1, FriendsModel.class);
            return this.f17551e;
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m25543a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25541j() != null) {
                FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m25541j());
                if (m25541j() != friendsModel) {
                    graphQLVisitableModel = (FetchFriendsToMentionQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17551e = friendsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25542a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25540a());
            int a2 = ModelHelper.a(flatBufferBuilder, m25541j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2106355611)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deltaParticipantsAddedToGroupThread */
    public final class FriendToMentionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f17552d;
        @Nullable
        private String f17553e;
        @Nullable
        private DefaultImageFieldsModel f17554f;

        /* compiled from: deltaParticipantsAddedToGroupThread */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendToMentionModel.class, new Deserializer());
            }

            public Object m25546a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FriendToMentionParser.m25559b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object friendToMentionModel = new FriendToMentionModel();
                ((BaseModel) friendToMentionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (friendToMentionModel instanceof Postprocessable) {
                    return ((Postprocessable) friendToMentionModel).a();
                }
                return friendToMentionModel;
            }
        }

        /* compiled from: deltaParticipantsAddedToGroupThread */
        public class Serializer extends JsonSerializer<FriendToMentionModel> {
            public final void m25547a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FriendToMentionModel friendToMentionModel = (FriendToMentionModel) obj;
                if (friendToMentionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendToMentionModel.m25551a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendToMentionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FriendToMentionParser.m25560b(friendToMentionModel.w_(), friendToMentionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FriendToMentionModel.class, new Serializer());
            }
        }

        public FriendToMentionModel() {
            super(3);
        }

        public final void m25554a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m25555a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m25548j() {
            this.f17552d = super.a(this.f17552d, 0);
            return this.f17552d;
        }

        @Nullable
        private String m25549k() {
            this.f17553e = super.a(this.f17553e, 1);
            return this.f17553e;
        }

        @Nullable
        private DefaultImageFieldsModel m25550l() {
            this.f17554f = (DefaultImageFieldsModel) super.a(this.f17554f, 2, DefaultImageFieldsModel.class);
            return this.f17554f;
        }

        @Nullable
        public final String m25553a() {
            return m25548j();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m25552a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25550l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25550l());
                if (m25550l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FriendToMentionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17554f = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25551a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m25548j());
            int b2 = flatBufferBuilder.b(m25549k());
            int a = ModelHelper.a(flatBufferBuilder, m25550l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
