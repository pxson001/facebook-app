package com.facebook.ufiservices.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ufiservices.graphql.FetchProfilesGraphQLParsers.FetchProfilesQueryParser;
import com.facebook.ufiservices.graphql.FetchProfilesGraphQLParsers.FetchProfilesQueryParser.MutualFriendsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: current_auto_retry_count */
public class FetchProfilesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1074385280)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_auto_retry_count */
    public final class FetchProfilesQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f18240d;
        @Nullable
        private GraphQLFriendshipStatus f18241e;
        @Nullable
        private String f18242f;
        @Nullable
        private MutualFriendsModel f18243g;
        @Nullable
        private String f18244h;
        @Nullable
        private DefaultImageFieldsModel f18245i;

        /* compiled from: current_auto_retry_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchProfilesQueryModel.class, new Deserializer());
            }

            public Object m26756a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchProfilesQueryParser.m26777a(jsonParser);
                Object fetchProfilesQueryModel = new FetchProfilesQueryModel();
                ((BaseModel) fetchProfilesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchProfilesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchProfilesQueryModel).a();
                }
                return fetchProfilesQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: current_auto_retry_count */
        public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
            private int f18239d;

            /* compiled from: current_auto_retry_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                }

                public Object m26757a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MutualFriendsParser.m26775a(jsonParser, flatBufferBuilder));
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

            /* compiled from: current_auto_retry_count */
            public class Serializer extends JsonSerializer<MutualFriendsModel> {
                public final void m26758a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                    if (mutualFriendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mutualFriendsModel.m26759a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MutualFriendsParser.m26776a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                }
            }

            public MutualFriendsModel() {
                super(1);
            }

            public final int jK_() {
                return 1532278911;
            }

            public final GraphQLVisitableModel m26760a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m26759a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f18239d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m26761a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f18239d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: current_auto_retry_count */
        public class Serializer extends JsonSerializer<FetchProfilesQueryModel> {
            public final void m26762a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchProfilesQueryModel fetchProfilesQueryModel = (FetchProfilesQueryModel) obj;
                if (fetchProfilesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchProfilesQueryModel.m26765a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchProfilesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchProfilesQueryModel.w_();
                int u_ = fetchProfilesQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("friendship_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                int g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("mutual_friends");
                    MutualFriendsParser.m26776a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchProfilesQueryModel.class, new Serializer());
            }
        }

        public FetchProfilesQueryModel() {
            super(6);
        }

        public final void m26768a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m26771k();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
                return;
            }
            consistencyTuple.a();
        }

        public final void m26769a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m26763a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m26770j() {
            if (this.b != null && this.f18240d == null) {
                this.f18240d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f18240d;
        }

        @Nullable
        public final GraphQLFriendshipStatus m26771k() {
            this.f18241e = (GraphQLFriendshipStatus) super.b(this.f18241e, 1, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f18241e;
        }

        private void m26763a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f18241e = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m26772l() {
            this.f18242f = super.a(this.f18242f, 2);
            return this.f18242f;
        }

        @Nullable
        private MutualFriendsModel m26764o() {
            this.f18243g = (MutualFriendsModel) super.a(this.f18243g, 3, MutualFriendsModel.class);
            return this.f18243g;
        }

        @Nullable
        public final String m26773m() {
            this.f18244h = super.a(this.f18244h, 4);
            return this.f18244h;
        }

        @Nullable
        public final DefaultImageFieldsModel m26774n() {
            this.f18245i = (DefaultImageFieldsModel) super.a(this.f18245i, 5, DefaultImageFieldsModel.class);
            return this.f18245i;
        }

        @Nullable
        public final String m26767a() {
            return m26772l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m26766a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26764o() != null) {
                MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m26764o());
                if (m26764o() != mutualFriendsModel) {
                    graphQLVisitableModel = (FetchProfilesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18243g = mutualFriendsModel;
                }
            }
            if (m26774n() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m26774n());
                if (m26774n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FetchProfilesQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f18245i = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26765a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26770j());
            int a2 = flatBufferBuilder.a(m26771k());
            int b = flatBufferBuilder.b(m26772l());
            int a3 = ModelHelper.a(flatBufferBuilder, m26764o());
            int b2 = flatBufferBuilder.b(m26773m());
            int a4 = ModelHelper.a(flatBufferBuilder, m26774n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            i();
            return flatBufferBuilder.d();
        }
    }
}
