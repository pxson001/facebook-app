package com.facebook.feed.ui;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.ui.PermalinkProfileListFragmentGraphQLParsers.PermalinkProfileListFragmentGraphQLParser;
import com.facebook.feed.ui.PermalinkProfileListFragmentGraphQLParsers.PermalinkProfileListFragmentGraphQLParser.ProfilePictureParser;
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
import com.facebook.ufiservices.flyout.views.FlyoutLikerViewGraphQLInterfaces.FlyoutLikerViewGraphQL;
import com.facebook.ufiservices.flyout.views.FlyoutLikerViewGraphQLInterfaces.FlyoutLikerViewGraphQL.ProfilePicture;
import com.facebook.ufiservices.ui.ProfileListFragmentGraphQLInterfaces.ProfileListFragmentGraphQL;
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

/* compiled from: Trying to access db on ui thread */
public class PermalinkProfileListFragmentGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1079586611)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Trying to access db on ui thread */
    public final class PermalinkProfileListFragmentGraphQLModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, FlyoutLikerViewGraphQL, ProfileListFragmentGraphQL {
        @Nullable
        private GraphQLObjectType f21776d;
        @Nullable
        private GraphQLFriendshipStatus f21777e;
        @Nullable
        private String f21778f;
        @Nullable
        private MutualFriendsModel f21779g;
        @Nullable
        private String f21780h;
        @Nullable
        private ProfilePictureModel f21781i;
        @Nullable
        private String f21782j;

        /* compiled from: Trying to access db on ui thread */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PermalinkProfileListFragmentGraphQLModel.class, new Deserializer());
            }

            public Object m24353a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PermalinkProfileListFragmentGraphQLParser.m24379a(jsonParser);
                Object permalinkProfileListFragmentGraphQLModel = new PermalinkProfileListFragmentGraphQLModel();
                ((BaseModel) permalinkProfileListFragmentGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (permalinkProfileListFragmentGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) permalinkProfileListFragmentGraphQLModel).a();
                }
                return permalinkProfileListFragmentGraphQLModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 729935302)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Trying to access db on ui thread */
        public final class ProfilePictureModel extends BaseModel implements DefaultImageFields, GraphQLVisitableModel, ProfilePicture {
            private int f21773d;
            @Nullable
            private String f21774e;
            private int f21775f;

            /* compiled from: Trying to access db on ui thread */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m24354a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m24377a(jsonParser, flatBufferBuilder));
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

            /* compiled from: Trying to access db on ui thread */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m24355a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m24357a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m24378a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(3);
            }

            public final int m24356a() {
                a(0, 0);
                return this.f21773d;
            }

            @Nullable
            public final String m24360b() {
                this.f21774e = super.a(this.f21774e, 1);
                return this.f21774e;
            }

            public final int m24361c() {
                a(0, 2);
                return this.f21775f;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m24358a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24357a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24360b());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f21773d, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f21775f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m24359a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f21773d = mutableFlatBuffer.a(i, 0, 0);
                this.f21775f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: Trying to access db on ui thread */
        public class Serializer extends JsonSerializer<PermalinkProfileListFragmentGraphQLModel> {
            public final void m24362a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PermalinkProfileListFragmentGraphQLModel permalinkProfileListFragmentGraphQLModel = (PermalinkProfileListFragmentGraphQLModel) obj;
                if (permalinkProfileListFragmentGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(permalinkProfileListFragmentGraphQLModel.m24366a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    permalinkProfileListFragmentGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PermalinkProfileListFragmentGraphQLParser.m24380a(permalinkProfileListFragmentGraphQLModel.w_(), permalinkProfileListFragmentGraphQLModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PermalinkProfileListFragmentGraphQLModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MutualFriendsModel m24371b() {
            return m24364l();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields dB_() {
            return m24365m();
        }

        @Nullable
        public final /* synthetic */ ProfilePicture m24376k() {
            return m24365m();
        }

        public PermalinkProfileListFragmentGraphQLModel() {
            super(7);
        }

        public PermalinkProfileListFragmentGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(7);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m24369a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m24373d();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
                return;
            }
            consistencyTuple.a();
        }

        public final void m24370a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m24363a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m24372c() {
            if (this.b != null && this.f21776d == null) {
                this.f21776d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f21776d;
        }

        @Nullable
        public final GraphQLFriendshipStatus m24373d() {
            this.f21777e = (GraphQLFriendshipStatus) super.b(this.f21777e, 1, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f21777e;
        }

        private void m24363a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f21777e = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m24374g() {
            this.f21778f = super.a(this.f21778f, 2);
            return this.f21778f;
        }

        @Nullable
        private MutualFriendsModel m24364l() {
            this.f21779g = (MutualFriendsModel) super.a(this.f21779g, 3, MutualFriendsModel.class);
            return this.f21779g;
        }

        @Nullable
        public final String C_() {
            this.f21780h = super.a(this.f21780h, 4);
            return this.f21780h;
        }

        @Nullable
        private ProfilePictureModel m24365m() {
            this.f21781i = (ProfilePictureModel) super.a(this.f21781i, 5, ProfilePictureModel.class);
            return this.f21781i;
        }

        @Nullable
        public final String m24375j() {
            this.f21782j = super.a(this.f21782j, 6);
            return this.f21782j;
        }

        @Nullable
        public final String m24368a() {
            return m24374g();
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m24367a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24364l() != null) {
                MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m24364l());
                if (m24364l() != mutualFriendsModel) {
                    graphQLVisitableModel = (PermalinkProfileListFragmentGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21779g = mutualFriendsModel;
                }
            }
            if (m24365m() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m24365m());
                if (m24365m() != profilePictureModel) {
                    graphQLVisitableModel = (PermalinkProfileListFragmentGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21781i = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24366a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24372c());
            int a2 = flatBufferBuilder.a(m24373d());
            int b = flatBufferBuilder.b(m24374g());
            int a3 = ModelHelper.a(flatBufferBuilder, m24364l());
            int b2 = flatBufferBuilder.b(C_());
            int a4 = ModelHelper.a(flatBufferBuilder, m24365m());
            int b3 = flatBufferBuilder.b(m24375j());
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
