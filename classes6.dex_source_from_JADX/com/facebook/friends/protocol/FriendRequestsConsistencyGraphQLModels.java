package com.facebook.friends.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friends.protocol.FriendRequestsConsistencyGraphQLParsers.FriendRequestsRepresentedProfileFieldsParser;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel;
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

/* compiled from: m_mid */
public class FriendRequestsConsistencyGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1138812123)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: m_mid */
    public final class FriendRequestsRepresentedProfileFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLFriendshipStatus f10813d;
        @Nullable
        private String f10814e;
        @Nullable
        private GraphQLSecondarySubscribeStatus f10815f;
        @Nullable
        private GraphQLSubscribeStatus f10816g;

        /* compiled from: m_mid */
        public final class Builder {
            @Nullable
            public GraphQLFriendshipStatus f10809a;
            @Nullable
            public String f10810b;
            @Nullable
            public GraphQLSecondarySubscribeStatus f10811c;
            @Nullable
            public GraphQLSubscribeStatus f10812d;

            public final FriendRequestsRepresentedProfileFieldsModel m17351a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = flatBufferBuilder.a(this.f10809a);
                int b = flatBufferBuilder.b(this.f10810b);
                int a2 = flatBufferBuilder.a(this.f10811c);
                int a3 = flatBufferBuilder.a(this.f10812d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FriendRequestsRepresentedProfileFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: m_mid */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendRequestsRepresentedProfileFieldsModel.class, new Deserializer());
            }

            public Object m17352a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendRequestsRepresentedProfileFieldsParser.m17366a(jsonParser);
                Object friendRequestsRepresentedProfileFieldsModel = new FriendRequestsRepresentedProfileFieldsModel();
                ((BaseModel) friendRequestsRepresentedProfileFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendRequestsRepresentedProfileFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) friendRequestsRepresentedProfileFieldsModel).a();
                }
                return friendRequestsRepresentedProfileFieldsModel;
            }
        }

        /* compiled from: m_mid */
        public class Serializer extends JsonSerializer<FriendRequestsRepresentedProfileFieldsModel> {
            public final void m17353a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendRequestsRepresentedProfileFieldsModel friendRequestsRepresentedProfileFieldsModel = (FriendRequestsRepresentedProfileFieldsModel) obj;
                if (friendRequestsRepresentedProfileFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendRequestsRepresentedProfileFieldsModel.m17361a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendRequestsRepresentedProfileFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendRequestsRepresentedProfileFieldsModel.w_();
                int u_ = friendRequestsRepresentedProfileFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("friendship_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("secondary_subscribe_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 2));
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("subscribe_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendRequestsRepresentedProfileFieldsModel.class, new Serializer());
            }
        }

        public FriendRequestsRepresentedProfileFieldsModel() {
            super(4);
        }

        public FriendRequestsRepresentedProfileFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m17364a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m17357j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
            } else if ("secondary_subscribe_status".equals(str)) {
                consistencyTuple.a = m17359l();
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
            } else if ("subscribe_status".equals(str)) {
                consistencyTuple.a = m17360m();
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m17365a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m17354a((GraphQLFriendshipStatus) obj);
            } else if ("secondary_subscribe_status".equals(str)) {
                m17355a((GraphQLSecondarySubscribeStatus) obj);
            } else if ("subscribe_status".equals(str)) {
                m17356a((GraphQLSubscribeStatus) obj);
            }
        }

        @Nullable
        private GraphQLFriendshipStatus m17357j() {
            this.f10813d = (GraphQLFriendshipStatus) super.b(this.f10813d, 0, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10813d;
        }

        private void m17354a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f10813d = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        private String m17358k() {
            this.f10814e = super.a(this.f10814e, 1);
            return this.f10814e;
        }

        @Nullable
        private GraphQLSecondarySubscribeStatus m17359l() {
            this.f10815f = (GraphQLSecondarySubscribeStatus) super.b(this.f10815f, 2, GraphQLSecondarySubscribeStatus.class, GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10815f;
        }

        private void m17355a(GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus) {
            this.f10815f = graphQLSecondarySubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, graphQLSecondarySubscribeStatus != null ? graphQLSecondarySubscribeStatus.name() : null);
            }
        }

        @Nullable
        private GraphQLSubscribeStatus m17360m() {
            this.f10816g = (GraphQLSubscribeStatus) super.b(this.f10816g, 3, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10816g;
        }

        private void m17356a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f10816g = graphQLSubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
            }
        }

        @Nullable
        public final String m17363a() {
            return m17358k();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m17362a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m17361a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m17357j());
            int b = flatBufferBuilder.b(m17358k());
            int a2 = flatBufferBuilder.a(m17359l());
            int a3 = flatBufferBuilder.a(m17360m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
