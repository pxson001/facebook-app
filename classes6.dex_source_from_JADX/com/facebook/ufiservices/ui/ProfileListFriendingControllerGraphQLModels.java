package com.facebook.ufiservices.ui;

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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLInterfaces.ProfileListFriendingControllerGraphQL;
import com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLParsers.ProfileListFriendingControllerGraphQLParser;
import com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLParsers.ProfileListFriendingControllerGraphQLParser.MutualFriendsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: ct */
public class ProfileListFriendingControllerGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -55398025)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ct */
    public final class ProfileListFriendingControllerGraphQLModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ProfileListFriendingControllerGraphQL {
        @Nullable
        private GraphQLFriendshipStatus f18278d;
        @Nullable
        private String f18279e;
        @Nullable
        private MutualFriendsModel f18280f;
        @Nullable
        private String f18281g;

        /* compiled from: ct */
        public final class Builder {
            @Nullable
            public GraphQLFriendshipStatus f18272a;
            @Nullable
            public String f18273b;
            @Nullable
            public MutualFriendsModel f18274c;
            @Nullable
            public String f18275d;

            public static Builder m26797a(ProfileListFriendingControllerGraphQLModel profileListFriendingControllerGraphQLModel) {
                Builder builder = new Builder();
                builder.f18272a = profileListFriendingControllerGraphQLModel.m26816d();
                builder.f18273b = profileListFriendingControllerGraphQLModel.m26817g();
                builder.f18274c = profileListFriendingControllerGraphQLModel.m26818j();
                builder.f18275d = profileListFriendingControllerGraphQLModel.C_();
                return builder;
            }

            public final ProfileListFriendingControllerGraphQLModel m26798a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = flatBufferBuilder.a(this.f18272a);
                int b = flatBufferBuilder.b(this.f18273b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f18274c);
                int b2 = flatBufferBuilder.b(this.f18275d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ProfileListFriendingControllerGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: ct */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileListFriendingControllerGraphQLModel.class, new Deserializer());
            }

            public Object m26799a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProfileListFriendingControllerGraphQLParser.m26821a(jsonParser);
                Object profileListFriendingControllerGraphQLModel = new ProfileListFriendingControllerGraphQLModel();
                ((BaseModel) profileListFriendingControllerGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (profileListFriendingControllerGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) profileListFriendingControllerGraphQLModel).a();
                }
                return profileListFriendingControllerGraphQLModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ct */
        public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
            private int f18277d;

            /* compiled from: ct */
            public final class Builder {
                public int f18276a;
            }

            /* compiled from: ct */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                }

                public Object m26800a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MutualFriendsParser.m26819a(jsonParser, flatBufferBuilder));
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

            /* compiled from: ct */
            public class Serializer extends JsonSerializer<MutualFriendsModel> {
                public final void m26801a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                    if (mutualFriendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mutualFriendsModel.m26804a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MutualFriendsParser.m26820a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                }
            }

            public MutualFriendsModel() {
                super(1);
            }

            public MutualFriendsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m26803a() {
                a(0, 0);
                return this.f18277d;
            }

            public static MutualFriendsModel m26802a(MutualFriendsModel mutualFriendsModel) {
                if (mutualFriendsModel == null) {
                    return null;
                }
                if (mutualFriendsModel instanceof MutualFriendsModel) {
                    return mutualFriendsModel;
                }
                Builder builder = new Builder();
                builder.f18276a = mutualFriendsModel.m26803a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f18276a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MutualFriendsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 1532278911;
            }

            public final GraphQLVisitableModel m26805a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m26804a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f18277d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m26806a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f18277d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: ct */
        public class Serializer extends JsonSerializer<ProfileListFriendingControllerGraphQLModel> {
            public final void m26807a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileListFriendingControllerGraphQLModel profileListFriendingControllerGraphQLModel = (ProfileListFriendingControllerGraphQLModel) obj;
                if (profileListFriendingControllerGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileListFriendingControllerGraphQLModel.m26810a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileListFriendingControllerGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileListFriendingControllerGraphQLModel.w_();
                int u_ = profileListFriendingControllerGraphQLModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("friendship_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("mutual_friends");
                    MutualFriendsParser.m26820a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileListFriendingControllerGraphQLModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MutualFriendsModel m26815b() {
            return m26818j();
        }

        public ProfileListFriendingControllerGraphQLModel() {
            super(4);
        }

        public ProfileListFriendingControllerGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m26813a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m26816d();
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
                return;
            }
            consistencyTuple.a();
        }

        public final void m26814a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m26809a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        public final GraphQLFriendshipStatus m26816d() {
            this.f18278d = (GraphQLFriendshipStatus) super.b(this.f18278d, 0, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f18278d;
        }

        private void m26809a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f18278d = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m26817g() {
            this.f18279e = super.a(this.f18279e, 1);
            return this.f18279e;
        }

        @Nullable
        public final MutualFriendsModel m26818j() {
            this.f18280f = (MutualFriendsModel) super.a(this.f18280f, 2, MutualFriendsModel.class);
            return this.f18280f;
        }

        @Nullable
        public final String C_() {
            this.f18281g = super.a(this.f18281g, 3);
            return this.f18281g;
        }

        public static ProfileListFriendingControllerGraphQLModel m26808a(ProfileListFriendingControllerGraphQL profileListFriendingControllerGraphQL) {
            if (profileListFriendingControllerGraphQL == null) {
                return null;
            }
            if (profileListFriendingControllerGraphQL instanceof ProfileListFriendingControllerGraphQLModel) {
                return (ProfileListFriendingControllerGraphQLModel) profileListFriendingControllerGraphQL;
            }
            Builder builder = new Builder();
            builder.f18272a = profileListFriendingControllerGraphQL.d();
            builder.f18273b = profileListFriendingControllerGraphQL.g();
            builder.f18274c = MutualFriendsModel.m26802a(profileListFriendingControllerGraphQL.b());
            builder.f18275d = profileListFriendingControllerGraphQL.C_();
            return builder.m26798a();
        }

        @Nullable
        public final String m26812a() {
            return m26817g();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m26811a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26818j() != null) {
                MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m26818j());
                if (m26818j() != mutualFriendsModel) {
                    graphQLVisitableModel = (ProfileListFriendingControllerGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18280f = mutualFriendsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26810a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m26816d());
            int b = flatBufferBuilder.b(m26817g());
            int a2 = ModelHelper.a(flatBufferBuilder, m26818j());
            int b2 = flatBufferBuilder.b(C_());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
