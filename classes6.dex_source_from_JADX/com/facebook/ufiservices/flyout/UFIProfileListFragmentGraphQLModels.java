package com.facebook.ufiservices.flyout;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ufiservices.flyout.UFIProfileListFragmentGraphQLInterfaces.UFIProfileListFragmentGraphQL;
import com.facebook.ufiservices.flyout.UFIProfileListFragmentGraphQLParsers.UFIProfileListFragmentGraphQLParser;
import com.facebook.ufiservices.flyout.UFIProfileListFragmentGraphQLParsers.UFIProfileListFragmentGraphQLParser.ProfilePictureParser;
import com.facebook.ufiservices.flyout.views.C1320xc048192f;
import com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLModels.ProfileListFriendingControllerGraphQLModel.MutualFriendsModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: custom_type */
public class UFIProfileListFragmentGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1869043182)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: custom_type */
    public final class UFIProfileListFragmentGraphQLModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, UFIProfileListFragmentGraphQL {
        @Nullable
        private GraphQLObjectType f18129d;
        @Nullable
        private GraphQLFriendshipStatus f18130e;
        @Nullable
        private String f18131f;
        @Nullable
        private MutualFriendsModel f18132g;
        @Nullable
        private String f18133h;
        @Nullable
        private ProfilePictureModel f18134i;
        @Nullable
        private String f18135j;

        /* compiled from: custom_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UFIProfileListFragmentGraphQLModel.class, new Deserializer());
            }

            public Object m26657a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UFIProfileListFragmentGraphQLParser.m26683a(jsonParser);
                Object uFIProfileListFragmentGraphQLModel = new UFIProfileListFragmentGraphQLModel();
                ((BaseModel) uFIProfileListFragmentGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (uFIProfileListFragmentGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) uFIProfileListFragmentGraphQLModel).a();
                }
                return uFIProfileListFragmentGraphQLModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 729935302)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: custom_type */
        public final class ProfilePictureModel extends BaseModel implements DefaultImageFields, GraphQLVisitableModel, C1320xc048192f {
            private int f18126d;
            @Nullable
            private String f18127e;
            private int f18128f;

            /* compiled from: custom_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m26658a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m26681a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilePictureModel = new ProfilePictureModel();
                    ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilePictureModel instanceof Postprocessable) {
                        return ((Postprocessable) profilePictureModel).a();
                    }
                    return profilePictureModel;
                }
            }

            /* compiled from: custom_type */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m26659a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m26661a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m26682a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(3);
            }

            public final int m26660a() {
                a(0, 0);
                return this.f18126d;
            }

            @Nullable
            public final String mo1385b() {
                this.f18127e = super.a(this.f18127e, 1);
                return this.f18127e;
            }

            public final int m26665c() {
                a(0, 2);
                return this.f18128f;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m26662a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m26661a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo1385b());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f18126d, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f18128f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m26663a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f18126d = mutableFlatBuffer.a(i, 0, 0);
                this.f18128f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: custom_type */
        public class Serializer extends JsonSerializer<UFIProfileListFragmentGraphQLModel> {
            public final void m26666a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                UFIProfileListFragmentGraphQLModel uFIProfileListFragmentGraphQLModel = (UFIProfileListFragmentGraphQLModel) obj;
                if (uFIProfileListFragmentGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(uFIProfileListFragmentGraphQLModel.m26670a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    uFIProfileListFragmentGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                UFIProfileListFragmentGraphQLParser.m26684a(uFIProfileListFragmentGraphQLModel.w_(), uFIProfileListFragmentGraphQLModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(UFIProfileListFragmentGraphQLModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MutualFriendsModel m26675b() {
            return m26668l();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields dB_() {
            return m26669m();
        }

        @Nullable
        public final /* synthetic */ ProfilePictureModel dF_() {
            return m26669m();
        }

        @Nullable
        public final /* synthetic */ C1320xc048192f m26680k() {
            return m26669m();
        }

        public UFIProfileListFragmentGraphQLModel() {
            super(7);
        }

        public UFIProfileListFragmentGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(7);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m26673a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m26677d();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
                return;
            }
            consistencyTuple.a();
        }

        public final void m26674a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m26667a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m26676c() {
            if (this.b != null && this.f18129d == null) {
                this.f18129d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f18129d;
        }

        @Nullable
        public final GraphQLFriendshipStatus m26677d() {
            this.f18130e = (GraphQLFriendshipStatus) super.b(this.f18130e, 1, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f18130e;
        }

        private void m26667a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f18130e = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m26678g() {
            this.f18131f = super.a(this.f18131f, 2);
            return this.f18131f;
        }

        @Nullable
        private MutualFriendsModel m26668l() {
            this.f18132g = (MutualFriendsModel) super.a(this.f18132g, 3, MutualFriendsModel.class);
            return this.f18132g;
        }

        @Nullable
        public final String C_() {
            this.f18133h = super.a(this.f18133h, 4);
            return this.f18133h;
        }

        @Nullable
        private ProfilePictureModel m26669m() {
            this.f18134i = (ProfilePictureModel) super.a(this.f18134i, 5, ProfilePictureModel.class);
            return this.f18134i;
        }

        @Nullable
        public final String m26679j() {
            this.f18135j = super.a(this.f18135j, 6);
            return this.f18135j;
        }

        @Nullable
        public final String m26672a() {
            return m26678g();
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m26671a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26668l() != null) {
                MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m26668l());
                if (m26668l() != mutualFriendsModel) {
                    graphQLVisitableModel = (UFIProfileListFragmentGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18132g = mutualFriendsModel;
                }
            }
            if (m26669m() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m26669m());
                if (m26669m() != profilePictureModel) {
                    graphQLVisitableModel = (UFIProfileListFragmentGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f18134i = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26670a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26676c());
            int a2 = flatBufferBuilder.a(m26677d());
            int b = flatBufferBuilder.b(m26678g());
            int a3 = ModelHelper.a(flatBufferBuilder, m26668l());
            int b2 = flatBufferBuilder.b(C_());
            int a4 = ModelHelper.a(flatBufferBuilder, m26669m());
            int b3 = flatBufferBuilder.b(m26679j());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, b3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
