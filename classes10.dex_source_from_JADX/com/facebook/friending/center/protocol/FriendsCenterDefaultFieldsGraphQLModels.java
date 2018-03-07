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
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLParsers.FriendsCenterDefaultNodeParser;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLParsers.FriendsCenterDefaultNodeParser.MutualFriendsParser;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
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
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: afb6a54ae46aae2987a2d42a0b3eaef9 */
public class FriendsCenterDefaultFieldsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -353591052)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: afb6a54ae46aae2987a2d42a0b3eaef9 */
    public final class FriendsCenterDefaultNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLFriendshipStatus f20014d;
        @Nullable
        private String f20015e;
        @Nullable
        private MutualFriendsModel f20016f;
        @Nullable
        private String f20017g;
        @Nullable
        private DefaultImageFieldsModel f20018h;

        /* compiled from: afb6a54ae46aae2987a2d42a0b3eaef9 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendsCenterDefaultNodeModel.class, new Deserializer());
            }

            public Object m20185a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FriendsCenterDefaultNodeParser.m20208b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object friendsCenterDefaultNodeModel = new FriendsCenterDefaultNodeModel();
                ((BaseModel) friendsCenterDefaultNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (friendsCenterDefaultNodeModel instanceof Postprocessable) {
                    return ((Postprocessable) friendsCenterDefaultNodeModel).a();
                }
                return friendsCenterDefaultNodeModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: afb6a54ae46aae2987a2d42a0b3eaef9 */
        public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
            private int f20013d;

            /* compiled from: afb6a54ae46aae2987a2d42a0b3eaef9 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                }

                public Object m20186a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MutualFriendsParser.m20204a(jsonParser, flatBufferBuilder));
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

            /* compiled from: afb6a54ae46aae2987a2d42a0b3eaef9 */
            public class Serializer extends JsonSerializer<MutualFriendsModel> {
                public final void m20187a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                    if (mutualFriendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mutualFriendsModel.m20189a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MutualFriendsParser.m20205a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                }
            }

            public MutualFriendsModel() {
                super(1);
            }

            public final int m20188a() {
                a(0, 0);
                return this.f20013d;
            }

            public final int jK_() {
                return 1532278911;
            }

            public final GraphQLVisitableModel m20190a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20189a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f20013d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20191a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f20013d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: afb6a54ae46aae2987a2d42a0b3eaef9 */
        public class Serializer extends JsonSerializer<FriendsCenterDefaultNodeModel> {
            public final void m20192a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FriendsCenterDefaultNodeModel friendsCenterDefaultNodeModel = (FriendsCenterDefaultNodeModel) obj;
                if (friendsCenterDefaultNodeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendsCenterDefaultNodeModel.m20194a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendsCenterDefaultNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FriendsCenterDefaultNodeParser.m20209b(friendsCenterDefaultNodeModel.w_(), friendsCenterDefaultNodeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FriendsCenterDefaultNodeModel.class, new Serializer());
            }
        }

        public FriendsCenterDefaultNodeModel() {
            super(5);
        }

        public final void m20197a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m20199j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
                return;
            }
            consistencyTuple.a();
        }

        public final void m20198a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m20193a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        public final GraphQLFriendshipStatus m20199j() {
            this.f20014d = (GraphQLFriendshipStatus) super.b(this.f20014d, 0, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f20014d;
        }

        private void m20193a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f20014d = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m20200k() {
            this.f20015e = super.a(this.f20015e, 1);
            return this.f20015e;
        }

        @Nullable
        public final MutualFriendsModel m20201l() {
            this.f20016f = (MutualFriendsModel) super.a(this.f20016f, 2, MutualFriendsModel.class);
            return this.f20016f;
        }

        @Nullable
        public final String m20202m() {
            this.f20017g = super.a(this.f20017g, 3);
            return this.f20017g;
        }

        @Nullable
        public final DefaultImageFieldsModel m20203n() {
            this.f20018h = (DefaultImageFieldsModel) super.a(this.f20018h, 4, DefaultImageFieldsModel.class);
            return this.f20018h;
        }

        @Nullable
        public final String m20196a() {
            return m20200k();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m20195a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20201l() != null) {
                MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m20201l());
                if (m20201l() != mutualFriendsModel) {
                    graphQLVisitableModel = (FriendsCenterDefaultNodeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20016f = mutualFriendsModel;
                }
            }
            if (m20203n() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20203n());
                if (m20203n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FriendsCenterDefaultNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f20018h = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20194a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m20199j());
            int b = flatBufferBuilder.b(m20200k());
            int a2 = ModelHelper.a(flatBufferBuilder, m20201l());
            int b2 = flatBufferBuilder.b(m20202m());
            int a3 = ModelHelper.a(flatBufferBuilder, m20203n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
